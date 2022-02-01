package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class FlutterPluginRegistry
  implements PluginRegistry, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener
{
  private static final String TAG = "FlutterPluginRegistry";
  private Activity mActivity;
  private final List<PluginRegistry.ActivityResultListener> mActivityResultListeners;
  private Context mAppContext;
  private FlutterView mFlutterView;
  private FlutterNativeView mNativeView;
  private final List<PluginRegistry.NewIntentListener> mNewIntentListeners;
  private final PlatformViewsController mPlatformViewsController;
  private final Map<String, Object> mPluginMap;
  private final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners;
  private final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners;
  private final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners;
  
  public FlutterPluginRegistry(FlutterEngine paramFlutterEngine, Context paramContext)
  {
    AppMethodBeat.i(189570);
    this.mPluginMap = new LinkedHashMap(0);
    this.mRequestPermissionsResultListeners = new ArrayList(0);
    this.mActivityResultListeners = new ArrayList(0);
    this.mNewIntentListeners = new ArrayList(0);
    this.mUserLeaveHintListeners = new ArrayList(0);
    this.mViewDestroyListeners = new ArrayList(0);
    this.mAppContext = paramContext;
    this.mPlatformViewsController = new PlatformViewsController();
    AppMethodBeat.o(189570);
  }
  
  public FlutterPluginRegistry(FlutterNativeView paramFlutterNativeView, Context paramContext)
  {
    AppMethodBeat.i(9595);
    this.mPluginMap = new LinkedHashMap(0);
    this.mRequestPermissionsResultListeners = new ArrayList(0);
    this.mActivityResultListeners = new ArrayList(0);
    this.mNewIntentListeners = new ArrayList(0);
    this.mUserLeaveHintListeners = new ArrayList(0);
    this.mViewDestroyListeners = new ArrayList(0);
    this.mNativeView = paramFlutterNativeView;
    this.mAppContext = paramContext;
    this.mPlatformViewsController = new PlatformViewsController();
    AppMethodBeat.o(9595);
  }
  
  public void attach(FlutterView paramFlutterView, Activity paramActivity)
  {
    AppMethodBeat.i(189665);
    this.mFlutterView = paramFlutterView;
    this.mActivity = paramActivity;
    this.mPlatformViewsController.attach(paramActivity, paramFlutterView, paramFlutterView.getDartExecutor());
    AppMethodBeat.o(189665);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(189737);
    this.mPlatformViewsController.onDetachedFromJNI();
    AppMethodBeat.o(189737);
  }
  
  public void detach()
  {
    AppMethodBeat.i(189675);
    this.mPlatformViewsController.detach();
    this.mPlatformViewsController.onDetachedFromJNI();
    this.mFlutterView = null;
    this.mActivity = null;
    AppMethodBeat.o(189675);
  }
  
  public PlatformViewsController getPlatformViewsController()
  {
    return this.mPlatformViewsController;
  }
  
  public boolean hasPlugin(String paramString)
  {
    AppMethodBeat.i(9597);
    boolean bool = this.mPluginMap.containsKey(paramString);
    AppMethodBeat.o(9597);
    return bool;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9600);
    Iterator localIterator = this.mActivityResultListeners.iterator();
    while (localIterator.hasNext()) {
      if (((PluginRegistry.ActivityResultListener)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(9600);
        return true;
      }
    }
    AppMethodBeat.o(9600);
    return false;
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9601);
    Iterator localIterator = this.mNewIntentListeners.iterator();
    while (localIterator.hasNext()) {
      if (((PluginRegistry.NewIntentListener)localIterator.next()).onNewIntent(paramIntent))
      {
        AppMethodBeat.o(9601);
        return true;
      }
    }
    AppMethodBeat.o(9601);
    return false;
  }
  
  public void onPreEngineRestart()
  {
    AppMethodBeat.i(189686);
    this.mPlatformViewsController.onPreEngineRestart();
    AppMethodBeat.o(189686);
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9599);
    Iterator localIterator = this.mRequestPermissionsResultListeners.iterator();
    while (localIterator.hasNext()) {
      if (((PluginRegistry.RequestPermissionsResultListener)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
      {
        AppMethodBeat.o(9599);
        return true;
      }
    }
    AppMethodBeat.o(9599);
    return false;
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9602);
    Iterator localIterator = this.mUserLeaveHintListeners.iterator();
    while (localIterator.hasNext()) {
      ((PluginRegistry.UserLeaveHintListener)localIterator.next()).onUserLeaveHint();
    }
    AppMethodBeat.o(9602);
  }
  
  public boolean onViewDestroy(FlutterNativeView paramFlutterNativeView)
  {
    AppMethodBeat.i(9603);
    Iterator localIterator = this.mViewDestroyListeners.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((PluginRegistry.ViewDestroyListener)localIterator.next()).onViewDestroy(paramFlutterNativeView)) {
        break label58;
      }
      bool = true;
    }
    label58:
    for (;;)
    {
      break;
      AppMethodBeat.o(9603);
      return bool;
    }
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    AppMethodBeat.i(9598);
    if (this.mPluginMap.containsKey(paramString))
    {
      paramString = new IllegalStateException("Plugin key " + paramString + " is already in use");
      AppMethodBeat.o(9598);
      throw paramString;
    }
    this.mPluginMap.put(paramString, null);
    paramString = new FlutterRegistrar(paramString);
    AppMethodBeat.o(9598);
    return paramString;
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    AppMethodBeat.i(189649);
    paramString = this.mPluginMap.get(paramString);
    AppMethodBeat.o(189649);
    return paramString;
  }
  
  class FlutterRegistrar
    implements PluginRegistry.Registrar
  {
    private final String pluginKey;
    
    FlutterRegistrar(String paramString)
    {
      this.pluginKey = paramString;
    }
    
    public Context activeContext()
    {
      AppMethodBeat.i(189585);
      if (FlutterPluginRegistry.this.mActivity != null)
      {
        localObject = FlutterPluginRegistry.this.mActivity;
        AppMethodBeat.o(189585);
        return localObject;
      }
      Object localObject = FlutterPluginRegistry.this.mAppContext;
      AppMethodBeat.o(189585);
      return localObject;
    }
    
    public Activity activity()
    {
      AppMethodBeat.i(9624);
      Activity localActivity = FlutterPluginRegistry.this.mActivity;
      AppMethodBeat.o(9624);
      return localActivity;
    }
    
    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
    {
      AppMethodBeat.i(189652);
      FlutterPluginRegistry.this.mActivityResultListeners.add(paramActivityResultListener);
      AppMethodBeat.o(189652);
      return this;
    }
    
    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
    {
      AppMethodBeat.i(189662);
      FlutterPluginRegistry.this.mNewIntentListeners.add(paramNewIntentListener);
      AppMethodBeat.o(189662);
      return this;
    }
    
    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
    {
      AppMethodBeat.i(189642);
      FlutterPluginRegistry.this.mRequestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
      AppMethodBeat.o(189642);
      return this;
    }
    
    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
    {
      AppMethodBeat.i(189673);
      FlutterPluginRegistry.this.mUserLeaveHintListeners.add(paramUserLeaveHintListener);
      AppMethodBeat.o(189673);
      return this;
    }
    
    public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener)
    {
      AppMethodBeat.i(9630);
      FlutterPluginRegistry.this.mViewDestroyListeners.add(paramViewDestroyListener);
      AppMethodBeat.o(9630);
      return this;
    }
    
    public Context context()
    {
      AppMethodBeat.i(9625);
      Context localContext = FlutterPluginRegistry.this.mAppContext;
      AppMethodBeat.o(9625);
      return localContext;
    }
    
    public String lookupKeyForAsset(String paramString)
    {
      AppMethodBeat.i(9628);
      paramString = FlutterMain.getLookupKeyForAsset(paramString);
      AppMethodBeat.o(9628);
      return paramString;
    }
    
    public String lookupKeyForAsset(String paramString1, String paramString2)
    {
      AppMethodBeat.i(9629);
      paramString1 = FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
      AppMethodBeat.o(9629);
      return paramString1;
    }
    
    public BinaryMessenger messenger()
    {
      AppMethodBeat.i(9626);
      FlutterNativeView localFlutterNativeView = FlutterPluginRegistry.this.mNativeView;
      AppMethodBeat.o(9626);
      return localFlutterNativeView;
    }
    
    public PlatformViewRegistry platformViewRegistry()
    {
      AppMethodBeat.i(189606);
      PlatformViewRegistry localPlatformViewRegistry = FlutterPluginRegistry.this.mPlatformViewsController.getRegistry();
      AppMethodBeat.o(189606);
      return localPlatformViewRegistry;
    }
    
    public PluginRegistry.Registrar publish(Object paramObject)
    {
      AppMethodBeat.i(189635);
      FlutterPluginRegistry.this.mPluginMap.put(this.pluginKey, paramObject);
      AppMethodBeat.o(189635);
      return this;
    }
    
    public TextureRegistry textures()
    {
      AppMethodBeat.i(9627);
      FlutterView localFlutterView = FlutterPluginRegistry.this.mFlutterView;
      AppMethodBeat.o(9627);
      return localFlutterView;
    }
    
    public FlutterView view()
    {
      AppMethodBeat.i(189615);
      FlutterView localFlutterView = FlutterPluginRegistry.this.mFlutterView;
      AppMethodBeat.o(189615);
      return localFlutterView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.app.FlutterPluginRegistry
 * JD-Core Version:    0.7.0.1
 */