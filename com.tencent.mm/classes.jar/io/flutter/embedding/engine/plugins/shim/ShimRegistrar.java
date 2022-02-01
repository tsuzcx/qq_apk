package io.flutter.embedding.engine.plugins.shim;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ShimRegistrar
  implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar
{
  private static final String TAG = "ShimRegistrar";
  private ActivityPluginBinding activityPluginBinding;
  private final Set<PluginRegistry.ActivityResultListener> activityResultListeners;
  private final Map<String, Object> globalRegistrarMap;
  private final Set<PluginRegistry.NewIntentListener> newIntentListeners;
  private FlutterPlugin.FlutterPluginBinding pluginBinding;
  private final String pluginId;
  private final Set<PluginRegistry.RequestPermissionsResultListener> requestPermissionsResultListeners;
  private final Set<PluginRegistry.UserLeaveHintListener> userLeaveHintListeners;
  private final Set<PluginRegistry.ViewDestroyListener> viewDestroyListeners;
  
  public ShimRegistrar(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(190318);
    this.viewDestroyListeners = new HashSet();
    this.requestPermissionsResultListeners = new HashSet();
    this.activityResultListeners = new HashSet();
    this.newIntentListeners = new HashSet();
    this.userLeaveHintListeners = new HashSet();
    this.pluginId = paramString;
    this.globalRegistrarMap = paramMap;
    AppMethodBeat.o(190318);
  }
  
  private void addExistingListenersToActivityPluginBinding()
  {
    AppMethodBeat.i(190324);
    Iterator localIterator = this.requestPermissionsResultListeners.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.RequestPermissionsResultListener)localIterator.next();
      this.activityPluginBinding.addRequestPermissionsResultListener((PluginRegistry.RequestPermissionsResultListener)localObject);
    }
    localIterator = this.activityResultListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.ActivityResultListener)localIterator.next();
      this.activityPluginBinding.addActivityResultListener((PluginRegistry.ActivityResultListener)localObject);
    }
    localIterator = this.newIntentListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.NewIntentListener)localIterator.next();
      this.activityPluginBinding.addOnNewIntentListener((PluginRegistry.NewIntentListener)localObject);
    }
    localIterator = this.userLeaveHintListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.UserLeaveHintListener)localIterator.next();
      this.activityPluginBinding.addOnUserLeaveHintListener((PluginRegistry.UserLeaveHintListener)localObject);
    }
    AppMethodBeat.o(190324);
  }
  
  public Context activeContext()
  {
    AppMethodBeat.i(190345);
    if (this.activityPluginBinding == null)
    {
      localObject = context();
      AppMethodBeat.o(190345);
      return localObject;
    }
    Object localObject = activity();
    AppMethodBeat.o(190345);
    return localObject;
  }
  
  public Activity activity()
  {
    AppMethodBeat.i(190332);
    if (this.activityPluginBinding != null)
    {
      Activity localActivity = this.activityPluginBinding.getActivity();
      AppMethodBeat.o(190332);
      return localActivity;
    }
    AppMethodBeat.o(190332);
    return null;
  }
  
  public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
  {
    AppMethodBeat.i(190401);
    this.activityResultListeners.add(paramActivityResultListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addActivityResultListener(paramActivityResultListener);
    }
    AppMethodBeat.o(190401);
    return this;
  }
  
  public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
  {
    AppMethodBeat.i(190406);
    this.newIntentListeners.add(paramNewIntentListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addOnNewIntentListener(paramNewIntentListener);
    }
    AppMethodBeat.o(190406);
    return this;
  }
  
  public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
  {
    AppMethodBeat.i(190392);
    this.requestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addRequestPermissionsResultListener(paramRequestPermissionsResultListener);
    }
    AppMethodBeat.o(190392);
    return this;
  }
  
  public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
  {
    AppMethodBeat.i(190413);
    this.userLeaveHintListeners.add(paramUserLeaveHintListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addOnUserLeaveHintListener(paramUserLeaveHintListener);
    }
    AppMethodBeat.o(190413);
    return this;
  }
  
  public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener)
  {
    AppMethodBeat.i(190419);
    this.viewDestroyListeners.add(paramViewDestroyListener);
    AppMethodBeat.o(190419);
    return this;
  }
  
  public Context context()
  {
    AppMethodBeat.i(190340);
    if (this.pluginBinding != null)
    {
      Context localContext = this.pluginBinding.getApplicationContext();
      AppMethodBeat.o(190340);
      return localContext;
    }
    AppMethodBeat.o(190340);
    return null;
  }
  
  public String lookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(190376);
    paramString = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(paramString);
    AppMethodBeat.o(190376);
    return paramString;
  }
  
  public String lookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190381);
    paramString1 = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(190381);
    return paramString1;
  }
  
  public BinaryMessenger messenger()
  {
    AppMethodBeat.i(190352);
    if (this.pluginBinding != null)
    {
      BinaryMessenger localBinaryMessenger = this.pluginBinding.getBinaryMessenger();
      AppMethodBeat.o(190352);
      return localBinaryMessenger;
    }
    AppMethodBeat.o(190352);
    return null;
  }
  
  public void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(190446);
    Log.v("ShimRegistrar", "Attached to an Activity.");
    this.activityPluginBinding = paramActivityPluginBinding;
    addExistingListenersToActivityPluginBinding();
    AppMethodBeat.o(190446);
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(190428);
    Log.v("ShimRegistrar", "Attached to FlutterEngine.");
    this.pluginBinding = paramFlutterPluginBinding;
    AppMethodBeat.o(190428);
  }
  
  public void onDetachedFromActivity()
  {
    AppMethodBeat.i(190471);
    Log.v("ShimRegistrar", "Detached from an Activity.");
    this.activityPluginBinding = null;
    AppMethodBeat.o(190471);
  }
  
  public void onDetachedFromActivityForConfigChanges()
  {
    AppMethodBeat.i(190455);
    Log.v("ShimRegistrar", "Detached from an Activity for config changes.");
    this.activityPluginBinding = null;
    AppMethodBeat.o(190455);
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(190437);
    Log.v("ShimRegistrar", "Detached from FlutterEngine.");
    paramFlutterPluginBinding = this.viewDestroyListeners.iterator();
    while (paramFlutterPluginBinding.hasNext()) {
      ((PluginRegistry.ViewDestroyListener)paramFlutterPluginBinding.next()).onViewDestroy(null);
    }
    this.pluginBinding = null;
    this.activityPluginBinding = null;
    AppMethodBeat.o(190437);
  }
  
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(190464);
    Log.v("ShimRegistrar", "Reconnected to an Activity after config changes.");
    this.activityPluginBinding = paramActivityPluginBinding;
    addExistingListenersToActivityPluginBinding();
    AppMethodBeat.o(190464);
  }
  
  public PlatformViewRegistry platformViewRegistry()
  {
    AppMethodBeat.i(190366);
    if (this.pluginBinding != null)
    {
      PlatformViewRegistry localPlatformViewRegistry = this.pluginBinding.getPlatformViewRegistry();
      AppMethodBeat.o(190366);
      return localPlatformViewRegistry;
    }
    AppMethodBeat.o(190366);
    return null;
  }
  
  public PluginRegistry.Registrar publish(Object paramObject)
  {
    AppMethodBeat.i(190388);
    this.globalRegistrarMap.put(this.pluginId, paramObject);
    AppMethodBeat.o(190388);
    return this;
  }
  
  public TextureRegistry textures()
  {
    AppMethodBeat.i(190361);
    if (this.pluginBinding != null)
    {
      TextureRegistry localTextureRegistry = this.pluginBinding.getTextureRegistry();
      AppMethodBeat.o(190361);
      return localTextureRegistry;
    }
    AppMethodBeat.o(190361);
    return null;
  }
  
  public FlutterView view()
  {
    AppMethodBeat.i(190371);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
    AppMethodBeat.o(190371);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.shim.ShimRegistrar
 * JD-Core Version:    0.7.0.1
 */