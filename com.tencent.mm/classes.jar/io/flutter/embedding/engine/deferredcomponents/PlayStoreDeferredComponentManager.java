package io.flutter.embedding.engine.deferredcomponents;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.a.a.a.c;
import com.google.android.a.a.a.d;
import com.google.android.a.a.a.d.a;
import com.google.android.a.a.a.e;
import com.google.android.a.a.a.f;
import com.google.android.a.a.b.a;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PlayStoreDeferredComponentManager
  implements DeferredComponentManager
{
  public static final String MAPPING_KEY;
  private static final String TAG = "PlayStoreDeferredComponentManager";
  private DeferredComponentChannel channel;
  private Context context;
  private FlutterApplicationInfo flutterApplicationInfo;
  private FlutterJNI flutterJNI;
  private FeatureInstallStateUpdatedListener listener;
  protected SparseArray<String> loadingUnitIdToModuleNames;
  protected SparseArray<String> loadingUnitIdToSharedLibraryNames;
  private Map<String, Integer> nameToSessionId;
  private SparseIntArray sessionIdToLoadingUnitId;
  private SparseArray<String> sessionIdToName;
  private SparseArray<String> sessionIdToState;
  private com.google.android.a.a.a.b splitInstallManager;
  
  static
  {
    AppMethodBeat.i(190067);
    MAPPING_KEY = DeferredComponentManager.class.getName() + ".loadingUnitMapping";
    AppMethodBeat.o(190067);
  }
  
  public PlayStoreDeferredComponentManager(Context paramContext, FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(190004);
    this.context = paramContext;
    this.flutterJNI = paramFlutterJNI;
    this.flutterApplicationInfo = ApplicationInfoLoader.load(paramContext);
    this.splitInstallManager = c.XH();
    this.listener = new FeatureInstallStateUpdatedListener(null);
    this.sessionIdToName = new SparseArray();
    this.sessionIdToLoadingUnitId = new SparseIntArray();
    this.sessionIdToState = new SparseArray();
    this.nameToSessionId = new HashMap();
    this.loadingUnitIdToModuleNames = new SparseArray();
    this.loadingUnitIdToSharedLibraryNames = new SparseArray();
    initLoadingUnitMappingToModuleNames();
    AppMethodBeat.o(190004);
  }
  
  private ApplicationInfo getApplicationInfo()
  {
    AppMethodBeat.i(190022);
    try
    {
      ApplicationInfo localApplicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
      AppMethodBeat.o(190022);
      return localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localNameNotFoundException);
      AppMethodBeat.o(190022);
      throw localRuntimeException;
    }
  }
  
  private void initLoadingUnitMappingToModuleNames()
  {
    AppMethodBeat.i(190029);
    new StringBuilder().append(DeferredComponentManager.class.getName()).append(".loadingUnitMapping");
    Object localObject = getApplicationInfo();
    if (localObject != null)
    {
      localObject = ((ApplicationInfo)localObject).metaData;
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString(MAPPING_KEY, null);
        if (localObject == null)
        {
          Log.e("PlayStoreDeferredComponentManager", "No loading unit to dynamic feature module name found. Ensure '" + MAPPING_KEY + "' is defined in the base module's AndroidManifest.");
          AppMethodBeat.o(190029);
          return;
        }
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString = localObject[i].split(":");
          int k = Integer.parseInt(arrayOfString[0]);
          this.loadingUnitIdToModuleNames.put(k, arrayOfString[1]);
          if (arrayOfString.length > 2) {
            this.loadingUnitIdToSharedLibraryNames.put(k, arrayOfString[2]);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(190029);
  }
  
  private boolean verifyJNI()
  {
    AppMethodBeat.i(190015);
    if (this.flutterJNI == null)
    {
      Log.e("PlayStoreDeferredComponentManager", "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
      AppMethodBeat.o(190015);
      return false;
    }
    AppMethodBeat.o(190015);
    return true;
  }
  
  public void destroy()
  {
    this.channel = null;
    this.flutterJNI = null;
  }
  
  public String getDeferredComponentInstallState(int paramInt, String paramString)
  {
    AppMethodBeat.i(190095);
    if (paramString != null) {}
    while (paramString == null)
    {
      Log.e("PlayStoreDeferredComponentManager", "Deferred component module name was null and could not be resolved from loading unit id.");
      AppMethodBeat.o(190095);
      return "unknown";
      paramString = (String)this.loadingUnitIdToModuleNames.get(paramInt);
    }
    if (!this.nameToSessionId.containsKey(paramString))
    {
      if (this.splitInstallManager.getInstalledModules().contains(paramString))
      {
        AppMethodBeat.o(190095);
        return "installedPendingLoad";
      }
      AppMethodBeat.o(190095);
      return "unknown";
    }
    paramInt = ((Integer)this.nameToSessionId.get(paramString)).intValue();
    paramString = (String)this.sessionIdToState.get(paramInt);
    AppMethodBeat.o(190095);
    return paramString;
  }
  
  public void installDeferredComponent(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(190086);
    if (paramString != null) {}
    for (final String str = paramString; str == null; str = (String)this.loadingUnitIdToModuleNames.get(paramInt))
    {
      Log.e("PlayStoreDeferredComponentManager", "Deferred component module name was null and could not be resolved from loading unit id.");
      AppMethodBeat.o(190086);
      return;
    }
    d.XI();
    d.a.XJ();
    d locald = d.a.XK();
    this.splitInstallManager.startInstall(locald).addOnSuccessListener(new a()
    {
      public void onSuccess(Integer paramAnonymousInteger)
      {
        AppMethodBeat.i(189993);
        PlayStoreDeferredComponentManager.this.sessionIdToName.put(paramAnonymousInteger.intValue(), str);
        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.put(paramAnonymousInteger.intValue(), paramInt);
        if (PlayStoreDeferredComponentManager.this.nameToSessionId.containsKey(str)) {
          PlayStoreDeferredComponentManager.this.sessionIdToState.remove(((Integer)PlayStoreDeferredComponentManager.this.nameToSessionId.get(str)).intValue());
        }
        PlayStoreDeferredComponentManager.this.nameToSessionId.put(str, paramAnonymousInteger);
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(paramAnonymousInteger.intValue(), "Requested");
        AppMethodBeat.o(189993);
      }
    }).addOnFailureListener(new Object()
    {
      public void onFailure(Exception paramAnonymousException)
      {
        AppMethodBeat.i(190010);
        switch (((SplitInstallException)paramAnonymousException).getErrorCode())
        {
        default: 
          PlayStoreDeferredComponentManager.this.flutterJNI.deferredComponentInstallFailure(paramInt, String.format("Install of deferred component module \"%s\" failed with error %d: %s", new Object[] { paramString, Integer.valueOf(((SplitInstallException)paramAnonymousException).getErrorCode()), ((SplitInstallException)paramAnonymousException).getMessage() }), false);
          AppMethodBeat.o(190010);
          return;
        case -6: 
          PlayStoreDeferredComponentManager.this.flutterJNI.deferredComponentInstallFailure(paramInt, String.format("Install of deferred component module \"%s\" failed with a network error", new Object[] { paramString }), true);
          AppMethodBeat.o(190010);
          return;
        }
        PlayStoreDeferredComponentManager.this.flutterJNI.deferredComponentInstallFailure(paramInt, String.format("Install of deferred component module \"%s\" failed as it is unavailable", new Object[] { paramString }), false);
        AppMethodBeat.o(190010);
      }
    });
    AppMethodBeat.o(190086);
  }
  
  public void loadAssets(int paramInt, String paramString)
  {
    AppMethodBeat.i(190102);
    if (!verifyJNI())
    {
      AppMethodBeat.o(190102);
      return;
    }
    try
    {
      this.context = this.context.createPackageContext(this.context.getPackageName(), 0);
      paramString = this.context.getAssets();
      this.flutterJNI.updateJavaAssetManager(paramString, this.flutterApplicationInfo.flutterAssetsDir);
      AppMethodBeat.o(190102);
      return;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(190102);
      throw paramString;
    }
  }
  
  public void loadDartLibrary(int paramInt, String paramString)
  {
    AppMethodBeat.i(190110);
    if (!verifyJNI())
    {
      AppMethodBeat.o(190110);
      return;
    }
    if (paramInt < 0)
    {
      AppMethodBeat.o(190110);
      return;
    }
    Object localObject1 = (String)this.loadingUnitIdToSharedLibraryNames.get(paramInt);
    if (localObject1 == null) {
      localObject1 = this.flutterApplicationInfo.aotSharedLibraryName + "-" + paramInt + ".part.so";
    }
    for (;;)
    {
      String str1;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      Object localObject3;
      if (Build.VERSION.SDK_INT >= 21)
      {
        str1 = Build.SUPPORTED_ABIS[0];
        localObject2 = str1.replace("-", "_");
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject3 = new LinkedList();
        ((Queue)localObject3).add(this.context.getFilesDir());
      }
      for (;;)
      {
        if (((Queue)localObject3).isEmpty()) {
          break label318;
        }
        Object localObject4 = (File)((Queue)localObject3).remove();
        if ((localObject4 != null) && (((File)localObject4).isDirectory()))
        {
          localObject4 = ((File)localObject4).listFiles();
          int j = localObject4.length;
          int i = 0;
          while (i < j)
          {
            ((Queue)localObject3).add(localObject4[i]);
            i += 1;
          }
          continue;
          str1 = Build.CPU_ABI;
          break;
        }
        String str2 = ((File)localObject4).getName();
        if ((str2.endsWith(".apk")) && (str2.startsWith(paramString)) && (str2.contains((CharSequence)localObject2))) {
          localArrayList1.add(((File)localObject4).getAbsolutePath());
        } else if (str2.equals(localObject1)) {
          localArrayList2.add(((File)localObject4).getAbsolutePath());
        }
      }
      label318:
      paramString = new ArrayList();
      paramString.add(localObject1);
      Object localObject2 = localArrayList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramString.add((String)localObject3 + "!lib/" + str1 + "/" + (String)localObject1);
      }
      localObject1 = localArrayList2.iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramString.add((String)((Iterator)localObject1).next());
      }
      this.flutterJNI.loadDartDeferredLibrary(paramInt, (String[])paramString.toArray(new String[localArrayList1.size()]));
      AppMethodBeat.o(190110);
      return;
    }
  }
  
  public void setDeferredComponentChannel(DeferredComponentChannel paramDeferredComponentChannel)
  {
    this.channel = paramDeferredComponentChannel;
  }
  
  public void setJNI(FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
  }
  
  public boolean uninstallDeferredComponent(int paramInt, String paramString)
  {
    AppMethodBeat.i(190120);
    if (paramString != null) {}
    while (paramString == null)
    {
      Log.e("PlayStoreDeferredComponentManager", "Deferred component module name was null and could not be resolved from loading unit id.");
      AppMethodBeat.o(190120);
      return false;
      paramString = (String)this.loadingUnitIdToModuleNames.get(paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    this.splitInstallManager.deferredUninstall(localArrayList);
    if (this.nameToSessionId.get(paramString) != null) {
      this.sessionIdToState.delete(((Integer)this.nameToSessionId.get(paramString)).intValue());
    }
    AppMethodBeat.o(190120);
    return true;
  }
  
  class FeatureInstallStateUpdatedListener
    implements f
  {
    private FeatureInstallStateUpdatedListener() {}
    
    public void onStateUpdate(e parame)
    {
      AppMethodBeat.i(190019);
      int i = e.XL();
      if (PlayStoreDeferredComponentManager.this.sessionIdToName.get(i) != null) {}
      switch (e.XM())
      {
      default: 
        Log.d("PlayStoreDeferredComponentManager", "Unknown status: " + e.XM());
        AppMethodBeat.o(190019);
        return;
      case 6: 
        Log.e("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) install failed with: %s", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i), Integer.valueOf(e.XN()) }));
        PlayStoreDeferredComponentManager.this.flutterJNI.deferredComponentInstallFailure(PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(i), "Module install failed with " + e.XN(), true);
        if (PlayStoreDeferredComponentManager.this.channel != null) {
          PlayStoreDeferredComponentManager.this.channel.completeInstallError((String)PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), "Android Deferred Component failed to install.");
        }
        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(i);
        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(i);
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "failed");
        AppMethodBeat.o(190019);
        return;
      case 5: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) install successfully.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        PlayStoreDeferredComponentManager.this.loadAssets(PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(i), (String)PlayStoreDeferredComponentManager.this.sessionIdToName.get(i));
        if (PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(i) > 0) {
          PlayStoreDeferredComponentManager.this.loadDartLibrary(PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(i), (String)PlayStoreDeferredComponentManager.this.sessionIdToName.get(i));
        }
        if (PlayStoreDeferredComponentManager.this.channel != null) {
          PlayStoreDeferredComponentManager.this.channel.completeInstallSuccess((String)PlayStoreDeferredComponentManager.this.sessionIdToName.get(i));
        }
        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(i);
        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(i);
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "installed");
        AppMethodBeat.o(190019);
        return;
      case 7: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) install canceled.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        if (PlayStoreDeferredComponentManager.this.channel != null) {
          PlayStoreDeferredComponentManager.this.channel.completeInstallError((String)PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), "Android Deferred Component installation canceled.");
        }
        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(i);
        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(i);
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "cancelled");
        AppMethodBeat.o(190019);
        return;
      case 9: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) install canceling.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "canceling");
        AppMethodBeat.o(190019);
        return;
      case 1: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) install pending.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "pending");
        AppMethodBeat.o(190019);
        return;
      case 8: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) install requires user confirmation.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "requiresUserConfirmation");
        AppMethodBeat.o(190019);
        return;
      case 2: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) downloading.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "downloading");
        AppMethodBeat.o(190019);
        return;
      case 3: 
        Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) downloaded.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
        PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "downloaded");
        AppMethodBeat.o(190019);
        return;
      }
      Log.d("PlayStoreDeferredComponentManager", String.format("Module \"%s\" (sessionId %d) installing.", new Object[] { PlayStoreDeferredComponentManager.this.sessionIdToName.get(i), Integer.valueOf(i) }));
      PlayStoreDeferredComponentManager.this.sessionIdToState.put(i, "installing");
      AppMethodBeat.o(190019);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager
 * JD-Core Version:    0.7.0.1
 */