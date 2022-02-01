package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.android.ExclusiveAppComponent;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding.OnSaveInstanceStateListener;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceAware.OnModeChangeListener;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FlutterEngineConnectionRegistry
  implements PluginRegistry, ActivityControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface, ServiceControlSurface
{
  private static final String TAG = "FlutterEngineCxnRegstry";
  @Deprecated
  private Activity activity;
  private final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins;
  private FlutterEngineActivityPluginBinding activityPluginBinding;
  private BroadcastReceiver broadcastReceiver;
  private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins;
  private FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
  private ContentProvider contentProvider;
  private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins;
  private FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
  private ExclusiveAppComponent<Activity> exclusiveActivity;
  private final FlutterEngine flutterEngine;
  private boolean isWaitingForActivityReattachment;
  private final FlutterPlugin.FlutterPluginBinding pluginBinding;
  private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins;
  private Service service;
  private final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins;
  private FlutterEngineServicePluginBinding servicePluginBinding;
  
  FlutterEngineConnectionRegistry(Context paramContext, FlutterEngine paramFlutterEngine, FlutterLoader paramFlutterLoader)
  {
    AppMethodBeat.i(190097);
    this.plugins = new HashMap();
    this.activityAwarePlugins = new HashMap();
    this.isWaitingForActivityReattachment = false;
    this.serviceAwarePlugins = new HashMap();
    this.broadcastReceiverAwarePlugins = new HashMap();
    this.contentProviderAwarePlugins = new HashMap();
    this.flutterEngine = paramFlutterEngine;
    this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(paramContext, paramFlutterEngine, paramFlutterEngine.getDartExecutor(), paramFlutterEngine.getRenderer(), paramFlutterEngine.getPlatformViewsController().getRegistry(), new FlutterEngineConnectionRegistry.DefaultFlutterAssets(paramFlutterLoader, null));
    AppMethodBeat.o(190097);
  }
  
  private void attachToActivityInternal(Activity paramActivity, j paramj)
  {
    AppMethodBeat.i(190127);
    this.activityPluginBinding = new FlutterEngineActivityPluginBinding(paramActivity, paramj);
    this.flutterEngine.getPlatformViewsController().attach(paramActivity, this.flutterEngine.getRenderer(), this.flutterEngine.getDartExecutor());
    paramActivity = this.activityAwarePlugins.values().iterator();
    while (paramActivity.hasNext())
    {
      paramj = (ActivityAware)paramActivity.next();
      if (this.isWaitingForActivityReattachment) {
        paramj.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
      } else {
        paramj.onAttachedToActivity(this.activityPluginBinding);
      }
    }
    this.isWaitingForActivityReattachment = false;
    AppMethodBeat.o(190127);
  }
  
  private Activity attachedActivity()
  {
    AppMethodBeat.i(190122);
    if (this.exclusiveActivity != null)
    {
      localActivity = (Activity)this.exclusiveActivity.getAppComponent();
      AppMethodBeat.o(190122);
      return localActivity;
    }
    Activity localActivity = this.activity;
    AppMethodBeat.o(190122);
    return localActivity;
  }
  
  private void detachFromActivityInternal()
  {
    AppMethodBeat.i(190139);
    this.flutterEngine.getPlatformViewsController().detach();
    this.exclusiveActivity = null;
    this.activity = null;
    this.activityPluginBinding = null;
    AppMethodBeat.o(190139);
  }
  
  private void detachFromAppComponent()
  {
    AppMethodBeat.i(190103);
    if (isAttachedToActivity())
    {
      detachFromActivity();
      AppMethodBeat.o(190103);
      return;
    }
    if (isAttachedToService())
    {
      detachFromService();
      AppMethodBeat.o(190103);
      return;
    }
    if (isAttachedToBroadcastReceiver())
    {
      detachFromBroadcastReceiver();
      AppMethodBeat.o(190103);
      return;
    }
    if (isAttachedToContentProvider()) {
      detachFromContentProvider();
    }
    AppMethodBeat.o(190103);
  }
  
  private boolean isAttachedToActivity()
  {
    return (this.activity != null) || (this.exclusiveActivity != null);
  }
  
  private boolean isAttachedToBroadcastReceiver()
  {
    return this.broadcastReceiver != null;
  }
  
  private boolean isAttachedToContentProvider()
  {
    return this.contentProvider != null;
  }
  
  private boolean isAttachedToService()
  {
    return this.service != null;
  }
  
  public void add(FlutterPlugin paramFlutterPlugin)
  {
    AppMethodBeat.i(190179);
    if (has(paramFlutterPlugin.getClass()))
    {
      Log.w("FlutterEngineCxnRegstry", "Attempted to register plugin (" + paramFlutterPlugin + ") but it was already registered with this FlutterEngine (" + this.flutterEngine + ").");
      AppMethodBeat.o(190179);
      return;
    }
    Log.v("FlutterEngineCxnRegstry", "Adding plugin: ".concat(String.valueOf(paramFlutterPlugin)));
    this.plugins.put(paramFlutterPlugin.getClass(), paramFlutterPlugin);
    paramFlutterPlugin.onAttachedToEngine(this.pluginBinding);
    Object localObject;
    if ((paramFlutterPlugin instanceof ActivityAware))
    {
      localObject = (ActivityAware)paramFlutterPlugin;
      this.activityAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToActivity()) {
        ((ActivityAware)localObject).onAttachedToActivity(this.activityPluginBinding);
      }
    }
    if ((paramFlutterPlugin instanceof ServiceAware))
    {
      localObject = (ServiceAware)paramFlutterPlugin;
      this.serviceAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToService()) {
        ((ServiceAware)localObject).onAttachedToService(this.servicePluginBinding);
      }
    }
    if ((paramFlutterPlugin instanceof BroadcastReceiverAware))
    {
      localObject = (BroadcastReceiverAware)paramFlutterPlugin;
      this.broadcastReceiverAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToBroadcastReceiver()) {
        ((BroadcastReceiverAware)localObject).onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
      }
    }
    if ((paramFlutterPlugin instanceof ContentProviderAware))
    {
      localObject = (ContentProviderAware)paramFlutterPlugin;
      this.contentProviderAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToContentProvider()) {
        ((ContentProviderAware)localObject).onAttachedToContentProvider(this.contentProviderPluginBinding);
      }
    }
    AppMethodBeat.o(190179);
  }
  
  public void add(Set<FlutterPlugin> paramSet)
  {
    AppMethodBeat.i(190191);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      add((FlutterPlugin)paramSet.next());
    }
    AppMethodBeat.o(190191);
  }
  
  public void attachToActivity(Activity paramActivity, j paramj)
  {
    AppMethodBeat.i(190238);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    if (this.isWaitingForActivityReattachment) {}
    for (String str = " This is after a config change.";; str = "")
    {
      Log.v("FlutterEngineCxnRegstry", str);
      if (this.exclusiveActivity != null) {
        this.exclusiveActivity.detachFromFlutterEngine();
      }
      detachFromAppComponent();
      if (this.exclusiveActivity == null) {
        break;
      }
      paramActivity = new AssertionError("Only activity or exclusiveActivity should be set");
      AppMethodBeat.o(190238);
      throw paramActivity;
    }
    this.activity = paramActivity;
    attachToActivityInternal(paramActivity, paramj);
    AppMethodBeat.o(190238);
  }
  
  public void attachToActivity(ExclusiveAppComponent<Activity> paramExclusiveAppComponent, j paramj)
  {
    AppMethodBeat.i(190244);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an exclusive Activity: ").append(paramExclusiveAppComponent.getAppComponent());
    if (isAttachedToActivity())
    {
      str = " evicting previous activity " + attachedActivity();
      localStringBuilder = localStringBuilder.append(str).append(".");
      if (!this.isWaitingForActivityReattachment) {
        break label147;
      }
    }
    label147:
    for (String str = " This is after a config change.";; str = "")
    {
      Log.v("FlutterEngineCxnRegstry", str);
      if (this.exclusiveActivity != null) {
        this.exclusiveActivity.detachFromFlutterEngine();
      }
      detachFromAppComponent();
      if (this.activity == null) {
        break label154;
      }
      paramExclusiveAppComponent = new AssertionError("Only activity or exclusiveActivity should be set");
      AppMethodBeat.o(190244);
      throw paramExclusiveAppComponent;
      str = "";
      break;
    }
    label154:
    this.exclusiveActivity = paramExclusiveAppComponent;
    attachToActivityInternal((Activity)paramExclusiveAppComponent.getAppComponent(), paramj);
    AppMethodBeat.o(190244);
  }
  
  public void attachToBroadcastReceiver(BroadcastReceiver paramBroadcastReceiver, j paramj)
  {
    AppMethodBeat.i(190335);
    Log.v("FlutterEngineCxnRegstry", "Attaching to BroadcastReceiver: ".concat(String.valueOf(paramBroadcastReceiver)));
    detachFromAppComponent();
    this.broadcastReceiver = paramBroadcastReceiver;
    this.broadcastReceiverPluginBinding = new FlutterEngineBroadcastReceiverPluginBinding(paramBroadcastReceiver);
    paramBroadcastReceiver = this.broadcastReceiverAwarePlugins.values().iterator();
    while (paramBroadcastReceiver.hasNext()) {
      ((BroadcastReceiverAware)paramBroadcastReceiver.next()).onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
    }
    AppMethodBeat.o(190335);
  }
  
  public void attachToContentProvider(ContentProvider paramContentProvider, j paramj)
  {
    AppMethodBeat.i(190347);
    Log.v("FlutterEngineCxnRegstry", "Attaching to ContentProvider: ".concat(String.valueOf(paramContentProvider)));
    detachFromAppComponent();
    this.contentProvider = paramContentProvider;
    this.contentProviderPluginBinding = new FlutterEngineContentProviderPluginBinding(paramContentProvider);
    paramContentProvider = this.contentProviderAwarePlugins.values().iterator();
    while (paramContentProvider.hasNext()) {
      ((ContentProviderAware)paramContentProvider.next()).onAttachedToContentProvider(this.contentProviderPluginBinding);
    }
    AppMethodBeat.o(190347);
  }
  
  public void attachToService(Service paramService, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(190306);
    Log.v("FlutterEngineCxnRegstry", "Attaching to a Service: ".concat(String.valueOf(paramService)));
    detachFromAppComponent();
    this.service = paramService;
    this.servicePluginBinding = new FlutterEngineServicePluginBinding(paramService, paramj);
    paramService = this.serviceAwarePlugins.values().iterator();
    while (paramService.hasNext()) {
      ((ServiceAware)paramService.next()).onAttachedToService(this.servicePluginBinding);
    }
    AppMethodBeat.o(190306);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(190171);
    Log.v("FlutterEngineCxnRegstry", "Destroying.");
    detachFromAppComponent();
    removeAll();
    AppMethodBeat.o(190171);
  }
  
  public void detachFromActivity()
  {
    AppMethodBeat.i(190256);
    if (isAttachedToActivity())
    {
      Log.v("FlutterEngineCxnRegstry", "Detaching from an Activity: " + attachedActivity());
      Iterator localIterator = this.activityAwarePlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((ActivityAware)localIterator.next()).onDetachedFromActivity();
      }
      detachFromActivityInternal();
      AppMethodBeat.o(190256);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
    AppMethodBeat.o(190256);
  }
  
  public void detachFromActivityForConfigChanges()
  {
    AppMethodBeat.i(190251);
    if (isAttachedToActivity())
    {
      Log.v("FlutterEngineCxnRegstry", "Detaching from an Activity for config changes: " + attachedActivity());
      this.isWaitingForActivityReattachment = true;
      Iterator localIterator = this.activityAwarePlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((ActivityAware)localIterator.next()).onDetachedFromActivityForConfigChanges();
      }
      detachFromActivityInternal();
      AppMethodBeat.o(190251);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
    AppMethodBeat.o(190251);
  }
  
  public void detachFromBroadcastReceiver()
  {
    AppMethodBeat.i(190341);
    if (isAttachedToBroadcastReceiver())
    {
      Log.v("FlutterEngineCxnRegstry", "Detaching from BroadcastReceiver: " + this.broadcastReceiver);
      Iterator localIterator = this.broadcastReceiverAwarePlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((BroadcastReceiverAware)localIterator.next()).onDetachedFromBroadcastReceiver();
      }
      AppMethodBeat.o(190341);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
    AppMethodBeat.o(190341);
  }
  
  public void detachFromContentProvider()
  {
    AppMethodBeat.i(190356);
    if (isAttachedToContentProvider())
    {
      Log.v("FlutterEngineCxnRegstry", "Detaching from ContentProvider: " + this.contentProvider);
      Iterator localIterator = this.contentProviderAwarePlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((ContentProviderAware)localIterator.next()).onDetachedFromContentProvider();
      }
      AppMethodBeat.o(190356);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
    AppMethodBeat.o(190356);
  }
  
  public void detachFromService()
  {
    AppMethodBeat.i(190314);
    if (isAttachedToService())
    {
      Log.v("FlutterEngineCxnRegstry", "Detaching from a Service: " + this.service);
      Iterator localIterator = this.serviceAwarePlugins.values().iterator();
      while (localIterator.hasNext()) {
        ((ServiceAware)localIterator.next()).onDetachedFromService();
      }
      this.service = null;
      this.servicePluginBinding = null;
      AppMethodBeat.o(190314);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
    AppMethodBeat.o(190314);
  }
  
  public FlutterPlugin get(Class<? extends FlutterPlugin> paramClass)
  {
    AppMethodBeat.i(190215);
    paramClass = (FlutterPlugin)this.plugins.get(paramClass);
    AppMethodBeat.o(190215);
    return paramClass;
  }
  
  public boolean has(Class<? extends FlutterPlugin> paramClass)
  {
    AppMethodBeat.i(190200);
    boolean bool = this.plugins.containsKey(paramClass);
    AppMethodBeat.o(190200);
    return bool;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190272);
    Log.v("FlutterEngineCxnRegstry", "Forwarding onActivityResult() to plugins.");
    if (isAttachedToActivity())
    {
      boolean bool = this.activityPluginBinding.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(190272);
      return bool;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
    AppMethodBeat.o(190272);
    return false;
  }
  
  public void onMoveToBackground()
  {
    AppMethodBeat.i(190327);
    if (isAttachedToService())
    {
      Log.v("FlutterEngineCxnRegstry", "Attached Service moved to background.");
      this.servicePluginBinding.onMoveToBackground();
    }
    AppMethodBeat.o(190327);
  }
  
  public void onMoveToForeground()
  {
    AppMethodBeat.i(190321);
    if (isAttachedToService())
    {
      Log.v("FlutterEngineCxnRegstry", "Attached Service moved to foreground.");
      this.servicePluginBinding.onMoveToForeground();
    }
    AppMethodBeat.o(190321);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190280);
    Log.v("FlutterEngineCxnRegstry", "Forwarding onNewIntent() to plugins.");
    if (isAttachedToActivity())
    {
      this.activityPluginBinding.onNewIntent(paramIntent);
      AppMethodBeat.o(190280);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
    AppMethodBeat.o(190280);
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190265);
    Log.v("FlutterEngineCxnRegstry", "Forwarding onRequestPermissionsResult() to plugins.");
    if (isAttachedToActivity())
    {
      boolean bool = this.activityPluginBinding.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(190265);
      return bool;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
    AppMethodBeat.o(190265);
    return false;
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190300);
    Log.v("FlutterEngineCxnRegstry", "Forwarding onRestoreInstanceState() to plugins.");
    if (isAttachedToActivity())
    {
      this.activityPluginBinding.onRestoreInstanceState(paramBundle);
      AppMethodBeat.o(190300);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
    AppMethodBeat.o(190300);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190293);
    Log.v("FlutterEngineCxnRegstry", "Forwarding onSaveInstanceState() to plugins.");
    if (isAttachedToActivity())
    {
      this.activityPluginBinding.onSaveInstanceState(paramBundle);
      AppMethodBeat.o(190293);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
    AppMethodBeat.o(190293);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(190286);
    Log.v("FlutterEngineCxnRegstry", "Forwarding onUserLeaveHint() to plugins.");
    if (isAttachedToActivity())
    {
      this.activityPluginBinding.onUserLeaveHint();
      AppMethodBeat.o(190286);
      return;
    }
    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
    AppMethodBeat.o(190286);
  }
  
  public void remove(Class<? extends FlutterPlugin> paramClass)
  {
    AppMethodBeat.i(190224);
    FlutterPlugin localFlutterPlugin = (FlutterPlugin)this.plugins.get(paramClass);
    if (localFlutterPlugin != null)
    {
      Log.v("FlutterEngineCxnRegstry", "Removing plugin: ".concat(String.valueOf(localFlutterPlugin)));
      if ((localFlutterPlugin instanceof ActivityAware))
      {
        if (isAttachedToActivity()) {
          ((ActivityAware)localFlutterPlugin).onDetachedFromActivity();
        }
        this.activityAwarePlugins.remove(paramClass);
      }
      if ((localFlutterPlugin instanceof ServiceAware))
      {
        if (isAttachedToService()) {
          ((ServiceAware)localFlutterPlugin).onDetachedFromService();
        }
        this.serviceAwarePlugins.remove(paramClass);
      }
      if ((localFlutterPlugin instanceof BroadcastReceiverAware))
      {
        if (isAttachedToBroadcastReceiver()) {
          ((BroadcastReceiverAware)localFlutterPlugin).onDetachedFromBroadcastReceiver();
        }
        this.broadcastReceiverAwarePlugins.remove(paramClass);
      }
      if ((localFlutterPlugin instanceof ContentProviderAware))
      {
        if (isAttachedToContentProvider()) {
          ((ContentProviderAware)localFlutterPlugin).onDetachedFromContentProvider();
        }
        this.contentProviderAwarePlugins.remove(paramClass);
      }
      localFlutterPlugin.onDetachedFromEngine(this.pluginBinding);
      this.plugins.remove(paramClass);
    }
    AppMethodBeat.o(190224);
  }
  
  public void remove(Set<Class<? extends FlutterPlugin>> paramSet)
  {
    AppMethodBeat.i(190230);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      remove((Class)paramSet.next());
    }
    AppMethodBeat.o(190230);
  }
  
  public void removeAll()
  {
    AppMethodBeat.i(190234);
    remove(new HashSet(this.plugins.keySet()));
    this.plugins.clear();
    AppMethodBeat.o(190234);
  }
  
  static class FlutterEngineActivityPluginBinding
    implements ActivityPluginBinding
  {
    private final Activity activity;
    private final HiddenLifecycleReference hiddenLifecycleReference;
    private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners;
    private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners;
    private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners;
    private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners;
    private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners;
    
    public FlutterEngineActivityPluginBinding(Activity paramActivity, j paramj)
    {
      AppMethodBeat.i(190087);
      this.onRequestPermissionsResultListeners = new HashSet();
      this.onActivityResultListeners = new HashSet();
      this.onNewIntentListeners = new HashSet();
      this.onUserLeaveHintListeners = new HashSet();
      this.onSaveInstanceStateListeners = new HashSet();
      this.activity = paramActivity;
      this.hiddenLifecycleReference = new HiddenLifecycleReference(paramj);
      AppMethodBeat.o(190087);
    }
    
    public void addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
    {
      AppMethodBeat.i(190133);
      this.onActivityResultListeners.add(paramActivityResultListener);
      AppMethodBeat.o(190133);
    }
    
    public void addOnNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
    {
      AppMethodBeat.i(190159);
      this.onNewIntentListeners.add(paramNewIntentListener);
      AppMethodBeat.o(190159);
    }
    
    public void addOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener paramOnSaveInstanceStateListener)
    {
      AppMethodBeat.i(190196);
      this.onSaveInstanceStateListeners.add(paramOnSaveInstanceStateListener);
      AppMethodBeat.o(190196);
    }
    
    public void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
    {
      AppMethodBeat.i(190183);
      this.onUserLeaveHintListeners.add(paramUserLeaveHintListener);
      AppMethodBeat.o(190183);
    }
    
    public void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
    {
      AppMethodBeat.i(190107);
      this.onRequestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
      AppMethodBeat.o(190107);
    }
    
    public Activity getActivity()
    {
      return this.activity;
    }
    
    public Object getLifecycle()
    {
      return this.hiddenLifecycleReference;
    }
    
    boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(190152);
      Iterator localIterator = new HashSet(this.onActivityResultListeners).iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        if ((((PluginRegistry.ActivityResultListener)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent)) || (bool)) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      AppMethodBeat.o(190152);
      return bool;
    }
    
    void onNewIntent(Intent paramIntent)
    {
      AppMethodBeat.i(190175);
      Iterator localIterator = this.onNewIntentListeners.iterator();
      while (localIterator.hasNext()) {
        ((PluginRegistry.NewIntentListener)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(190175);
    }
    
    boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(190124);
      Iterator localIterator = this.onRequestPermissionsResultListeners.iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        if ((((PluginRegistry.RequestPermissionsResultListener)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt)) || (bool)) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      AppMethodBeat.o(190124);
      return bool;
    }
    
    void onRestoreInstanceState(Bundle paramBundle)
    {
      AppMethodBeat.i(190228);
      Iterator localIterator = this.onSaveInstanceStateListeners.iterator();
      while (localIterator.hasNext()) {
        ((ActivityPluginBinding.OnSaveInstanceStateListener)localIterator.next()).onRestoreInstanceState(paramBundle);
      }
      AppMethodBeat.o(190228);
    }
    
    void onSaveInstanceState(Bundle paramBundle)
    {
      AppMethodBeat.i(190223);
      Iterator localIterator = this.onSaveInstanceStateListeners.iterator();
      while (localIterator.hasNext()) {
        ((ActivityPluginBinding.OnSaveInstanceStateListener)localIterator.next()).onSaveInstanceState(paramBundle);
      }
      AppMethodBeat.o(190223);
    }
    
    void onUserLeaveHint()
    {
      AppMethodBeat.i(190216);
      Iterator localIterator = this.onUserLeaveHintListeners.iterator();
      while (localIterator.hasNext()) {
        ((PluginRegistry.UserLeaveHintListener)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(190216);
    }
    
    public void removeActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
    {
      AppMethodBeat.i(190144);
      this.onActivityResultListeners.remove(paramActivityResultListener);
      AppMethodBeat.o(190144);
    }
    
    public void removeOnNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
    {
      AppMethodBeat.i(190168);
      this.onNewIntentListeners.remove(paramNewIntentListener);
      AppMethodBeat.o(190168);
    }
    
    public void removeOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener paramOnSaveInstanceStateListener)
    {
      AppMethodBeat.i(190205);
      this.onSaveInstanceStateListeners.remove(paramOnSaveInstanceStateListener);
      AppMethodBeat.o(190205);
    }
    
    public void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
    {
      AppMethodBeat.i(190187);
      this.onUserLeaveHintListeners.remove(paramUserLeaveHintListener);
      AppMethodBeat.o(190187);
    }
    
    public void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
    {
      AppMethodBeat.i(190117);
      this.onRequestPermissionsResultListeners.remove(paramRequestPermissionsResultListener);
      AppMethodBeat.o(190117);
    }
  }
  
  static class FlutterEngineBroadcastReceiverPluginBinding
    implements BroadcastReceiverPluginBinding
  {
    private final BroadcastReceiver broadcastReceiver;
    
    FlutterEngineBroadcastReceiverPluginBinding(BroadcastReceiver paramBroadcastReceiver)
    {
      this.broadcastReceiver = paramBroadcastReceiver;
    }
    
    public BroadcastReceiver getBroadcastReceiver()
    {
      return this.broadcastReceiver;
    }
  }
  
  static class FlutterEngineContentProviderPluginBinding
    implements ContentProviderPluginBinding
  {
    private final ContentProvider contentProvider;
    
    FlutterEngineContentProviderPluginBinding(ContentProvider paramContentProvider)
    {
      this.contentProvider = paramContentProvider;
    }
    
    public ContentProvider getContentProvider()
    {
      return this.contentProvider;
    }
  }
  
  static class FlutterEngineServicePluginBinding
    implements ServicePluginBinding
  {
    private final HiddenLifecycleReference hiddenLifecycleReference;
    private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners;
    private final Service service;
    
    FlutterEngineServicePluginBinding(Service paramService, j paramj)
    {
      AppMethodBeat.i(190014);
      this.onModeChangeListeners = new HashSet();
      this.service = paramService;
      if (paramj != null) {}
      for (paramService = new HiddenLifecycleReference(paramj);; paramService = null)
      {
        this.hiddenLifecycleReference = paramService;
        AppMethodBeat.o(190014);
        return;
      }
    }
    
    public void addOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener)
    {
      AppMethodBeat.i(190034);
      this.onModeChangeListeners.add(paramOnModeChangeListener);
      AppMethodBeat.o(190034);
    }
    
    public Object getLifecycle()
    {
      return this.hiddenLifecycleReference;
    }
    
    public Service getService()
    {
      return this.service;
    }
    
    void onMoveToBackground()
    {
      AppMethodBeat.i(190051);
      Iterator localIterator = this.onModeChangeListeners.iterator();
      while (localIterator.hasNext()) {
        ((ServiceAware.OnModeChangeListener)localIterator.next()).onMoveToBackground();
      }
      AppMethodBeat.o(190051);
    }
    
    void onMoveToForeground()
    {
      AppMethodBeat.i(190045);
      Iterator localIterator = this.onModeChangeListeners.iterator();
      while (localIterator.hasNext()) {
        ((ServiceAware.OnModeChangeListener)localIterator.next()).onMoveToForeground();
      }
      AppMethodBeat.o(190045);
    }
    
    public void removeOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener)
    {
      AppMethodBeat.i(190040);
      this.onModeChangeListeners.remove(paramOnModeChangeListener);
      AppMethodBeat.o(190040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineConnectionRegistry
 * JD-Core Version:    0.7.0.1
 */