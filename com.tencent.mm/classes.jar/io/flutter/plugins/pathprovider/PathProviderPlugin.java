package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.b.a.b;
import com.google.b.b.a.c;
import com.google.b.b.a.d.a;
import com.google.b.b.a.f;
import com.google.b.b.a.g;
import com.google.b.b.a.h;
import com.google.b.b.a.h.1;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class PathProviderPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel channel;
  private Context context;
  private final Executor executor;
  private final Executor uiThreadExecutor;
  
  public PathProviderPlugin()
  {
    AppMethodBeat.i(189720);
    this.uiThreadExecutor = new PathProviderPlugin.UiThreadExecutor(null);
    Object localObject = new h();
    h.format("path-provider-background-%d", new Object[] { Integer.valueOf(0) });
    ((h)localObject).dBl = "path-provider-background-%d";
    ((h)localObject).dBn = Integer.valueOf(5);
    String str = ((h)localObject).dBl;
    Boolean localBoolean = ((h)localObject).dBm;
    Integer localInteger = ((h)localObject).dBn;
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = ((h)localObject).dBo;
    if (((h)localObject).dBp != null) {}
    for (localObject = ((h)localObject).dBp;; localObject = Executors.defaultThreadFactory())
    {
      if (str != null) {
        localAtomicLong = new AtomicLong(0L);
      }
      this.executor = Executors.newSingleThreadExecutor(new h.1((ThreadFactory)localObject, str, localAtomicLong, localBoolean, localInteger, localUncaughtExceptionHandler));
      AppMethodBeat.o(189720);
      return;
    }
  }
  
  private <T> void executeInBackground(Callable<T> paramCallable, final MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(189739);
    g localg = g.XV();
    paramResult = new c()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(189741);
        paramResult.error(paramAnonymousThrowable.getClass().getName(), paramAnonymousThrowable.getMessage(), null);
        AppMethodBeat.o(189741);
      }
      
      public void onSuccess(T paramAnonymousT)
      {
        AppMethodBeat.i(189731);
        paramResult.success(paramAnonymousT);
        AppMethodBeat.o(189731);
      }
    };
    Executor localExecutor = this.uiThreadExecutor;
    b.checkNotNull(paramResult);
    localg.a(new d.a(localg, paramResult), localExecutor);
    this.executor.execute(new PathProviderPlugin..ExternalSyntheticLambda0(localg, paramCallable));
    AppMethodBeat.o(189739);
  }
  
  private String getApplicationSupportDirectory()
  {
    AppMethodBeat.i(189756);
    String str = PathUtils.getFilesDir(this.context);
    AppMethodBeat.o(189756);
    return str;
  }
  
  private String getPathProviderApplicationDocumentsDirectory()
  {
    AppMethodBeat.i(189764);
    String str = PathUtils.getDataDirectory(this.context);
    AppMethodBeat.o(189764);
    return str;
  }
  
  private List<String> getPathProviderExternalCacheDirectories()
  {
    AppMethodBeat.i(189785);
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject1 = this.context.getExternalCacheDirs();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localArrayList.add(localObject2.getAbsolutePath());
        }
        i += 1;
      }
    }
    Object localObject1 = this.context.getExternalCacheDir();
    if (localObject1 != null) {
      localArrayList.add(((File)localObject1).getAbsolutePath());
    }
    AppMethodBeat.o(189785);
    return localArrayList;
  }
  
  private List<String> getPathProviderExternalStorageDirectories(String paramString)
  {
    AppMethodBeat.i(189791);
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramString = this.context.getExternalFilesDirs(paramString);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject != null) {
          localArrayList.add(localObject.getAbsolutePath());
        }
        i += 1;
      }
    }
    paramString = this.context.getExternalFilesDir(paramString);
    if (paramString != null) {
      localArrayList.add(paramString.getAbsolutePath());
    }
    AppMethodBeat.o(189791);
    return localArrayList;
  }
  
  private String getPathProviderStorageDirectory()
  {
    AppMethodBeat.i(189774);
    Object localObject = this.context.getExternalFilesDir(null);
    if (localObject == null)
    {
      AppMethodBeat.o(189774);
      return null;
    }
    localObject = ((File)localObject).getAbsolutePath();
    AppMethodBeat.o(189774);
    return localObject;
  }
  
  private String getPathProviderTemporaryDirectory()
  {
    AppMethodBeat.i(189749);
    String str = this.context.getCacheDir().getPath();
    AppMethodBeat.o(189749);
    return str;
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    AppMethodBeat.i(189728);
    PathProviderPlugin localPathProviderPlugin = new PathProviderPlugin();
    localPathProviderPlugin.channel = new MethodChannel(paramRegistrar.messenger(), "plugins.flutter.io/path_provider");
    localPathProviderPlugin.context = paramRegistrar.context();
    localPathProviderPlugin.channel.setMethodCallHandler(localPathProviderPlugin);
    AppMethodBeat.o(189728);
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189807);
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/path_provider");
    this.context = paramFlutterPluginBinding.getApplicationContext();
    this.channel.setMethodCallHandler(this);
    AppMethodBeat.o(189807);
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189814);
    this.channel.setMethodCallHandler(null);
    this.channel = null;
    AppMethodBeat.o(189814);
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(153351);
    String str = paramMethodCall.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        AppMethodBeat.o(153351);
        return;
        if (str.equals("getTemporaryDirectory"))
        {
          i = 0;
          continue;
          if (str.equals("getApplicationDocumentsDirectory"))
          {
            i = 1;
            continue;
            if (str.equals("getStorageDirectory"))
            {
              i = 2;
              continue;
              if (str.equals("getExternalCacheDirectories"))
              {
                i = 3;
                continue;
                if (str.equals("getExternalStorageDirectories"))
                {
                  i = 4;
                  continue;
                  if (str.equals("getApplicationSupportDirectory")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    executeInBackground(new PathProviderPlugin..ExternalSyntheticLambda1(this), paramResult);
    AppMethodBeat.o(153351);
    return;
    executeInBackground(new PathProviderPlugin..ExternalSyntheticLambda2(this), paramResult);
    AppMethodBeat.o(153351);
    return;
    executeInBackground(new PathProviderPlugin..ExternalSyntheticLambda3(this), paramResult);
    AppMethodBeat.o(153351);
    return;
    executeInBackground(new PathProviderPlugin..ExternalSyntheticLambda4(this), paramResult);
    AppMethodBeat.o(153351);
    return;
    executeInBackground(new PathProviderPlugin..ExternalSyntheticLambda6(this, StorageDirectoryMapper.androidType((Integer)paramMethodCall.argument("type"))), paramResult);
    AppMethodBeat.o(153351);
    return;
    executeInBackground(new PathProviderPlugin..ExternalSyntheticLambda5(this), paramResult);
    AppMethodBeat.o(153351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugins.pathprovider.PathProviderPlugin
 * JD-Core Version:    0.7.0.1
 */