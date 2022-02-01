package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Constructor;

public class FlutterFragment
  extends Fragment
  implements FlutterActivityAndFragmentDelegate.Host
{
  protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
  protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
  protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
  protected static final String ARG_ENABLE_STATE_RESTORATION = "enable_state_restoration";
  protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
  protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
  protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
  protected static final String ARG_HANDLE_DEEPLINKING = "handle_deeplinking";
  protected static final String ARG_INITIAL_ROUTE = "initial_route";
  protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
  private static final String TAG = "FlutterFragment";
  FlutterActivityAndFragmentDelegate delegate;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public static FlutterFragment createDefault()
  {
    AppMethodBeat.i(190424);
    FlutterFragment localFlutterFragment = new NewEngineFragmentBuilder().build();
    AppMethodBeat.o(190424);
    return localFlutterFragment;
  }
  
  private boolean stillAttachedForEvent(String paramString)
  {
    AppMethodBeat.i(190454);
    if (this.delegate == null)
    {
      Log.v("FlutterFragment", "FlutterFragment " + hashCode() + " " + paramString + " called after release.");
      AppMethodBeat.o(190454);
      return false;
    }
    AppMethodBeat.o(190454);
    return true;
  }
  
  public static CachedEngineFragmentBuilder withCachedEngine(String paramString)
  {
    AppMethodBeat.i(190439);
    paramString = new CachedEngineFragmentBuilder(paramString, null);
    AppMethodBeat.o(190439);
    return paramString;
  }
  
  public static NewEngineFragmentBuilder withNewEngine()
  {
    AppMethodBeat.i(190430);
    NewEngineFragmentBuilder localNewEngineFragmentBuilder = new NewEngineFragmentBuilder();
    AppMethodBeat.o(190430);
    return localNewEngineFragmentBuilder;
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190676);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).cleanUpFlutterEngine(paramFlutterEngine);
    }
    AppMethodBeat.o(190676);
  }
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(10108);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).configureFlutterEngine(paramFlutterEngine);
    }
    AppMethodBeat.o(10108);
  }
  
  public void detachFromFlutterEngine()
  {
    AppMethodBeat.i(190540);
    Log.v("FlutterFragment", "FlutterFragment " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    this.delegate.onDestroyView();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
    AppMethodBeat.o(190540);
  }
  
  public String getAppBundlePath()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path");
    AppMethodBeat.o(10101);
    return str;
  }
  
  public String getCachedEngineId()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public FlutterEngine getFlutterEngine()
  {
    AppMethodBeat.i(190660);
    FlutterEngine localFlutterEngine = this.delegate.getFlutterEngine();
    AppMethodBeat.o(190660);
    return localFlutterEngine;
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    AppMethodBeat.i(10097);
    Object localObject = getArguments().getStringArray("initialization_args");
    if (localObject != null) {}
    for (;;)
    {
      localObject = new FlutterShellArgs((String[])localObject);
      AppMethodBeat.o(10097);
      return localObject;
      localObject = new String[0];
    }
  }
  
  public String getInitialRoute()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public RenderMode getRenderMode()
  {
    AppMethodBeat.i(190638);
    RenderMode localRenderMode = RenderMode.valueOf(getArguments().getString("flutterview_render_mode", RenderMode.surface.name()));
    AppMethodBeat.o(190638);
    return localRenderMode;
  }
  
  public TransparencyMode getTransparencyMode()
  {
    AppMethodBeat.i(190643);
    TransparencyMode localTransparencyMode = TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.transparent.name()));
    AppMethodBeat.o(190643);
    return localTransparencyMode;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    if (stillAttachedForEvent("onActivityResult")) {
      this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(paramContext);
    AppMethodBeat.o(10086);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190566);
    if (stillAttachedForEvent("onBackPressed")) {
      this.delegate.onBackPressed();
    }
    AppMethodBeat.o(190566);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190477);
    super.onCreate(paramBundle);
    this.delegate.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(190477);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.delegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    if (stillAttachedForEvent("onDestroyView")) {
      this.delegate.onDestroyView();
    }
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    if (this.delegate != null)
    {
      this.delegate.onDetach();
      this.delegate.release();
      this.delegate = null;
      AppMethodBeat.o(10093);
      return;
    }
    Log.v("FlutterFragment", "FlutterFragment " + this + " onDetach called after release.");
    AppMethodBeat.o(10093);
  }
  
  public void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    AppMethodBeat.i(190700);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterUiDisplayListener)) {
      ((FlutterUiDisplayListener)localFragmentActivity).onFlutterUiDisplayed();
    }
    AppMethodBeat.o(190700);
  }
  
  public void onFlutterUiNoLongerDisplayed()
  {
    AppMethodBeat.i(190705);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterUiDisplayListener)) {
      ((FlutterUiDisplayListener)localFragmentActivity).onFlutterUiNoLongerDisplayed();
    }
    AppMethodBeat.o(190705);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    if (stillAttachedForEvent("onLowMemory")) {
      this.delegate.onLowMemory();
    }
    AppMethodBeat.o(10096);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190556);
    if (stillAttachedForEvent("onNewIntent")) {
      this.delegate.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(190556);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.delegate.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(190503);
    this.delegate.onPostResume();
    AppMethodBeat.o(190503);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    if (stillAttachedForEvent("onRequestPermissionsResult")) {
      this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.delegate.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190532);
    super.onSaveInstanceState(paramBundle);
    if (stillAttachedForEvent("onSaveInstanceState")) {
      this.delegate.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(190532);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.delegate.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    if (stillAttachedForEvent("onStop")) {
      this.delegate.onStop();
    }
    AppMethodBeat.o(10091);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(190592);
    if (stillAttachedForEvent("onTrimMemory")) {
      this.delegate.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(190592);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(190583);
    if (stillAttachedForEvent("onUserLeaveHint")) {
      this.delegate.onUserLeaveHint();
    }
    AppMethodBeat.o(190583);
  }
  
  public boolean popSystemNavigator()
  {
    return false;
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    AppMethodBeat.i(190653);
    paramContext = getActivity();
    if ((paramContext instanceof FlutterEngineProvider)) {
      Log.v("FlutterFragment", "Deferring to attached Activity to provide a FlutterEngine.");
    }
    for (paramContext = ((FlutterEngineProvider)paramContext).provideFlutterEngine(getContext());; paramContext = null)
    {
      AppMethodBeat.o(190653);
      return paramContext;
    }
  }
  
  public PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel(), this);
      AppMethodBeat.o(10107);
      return paramActivity;
    }
    AppMethodBeat.o(10107);
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof SplashScreenProvider))
    {
      localObject = ((SplashScreenProvider)localObject).provideSplashScreen();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  void setDelegate(FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate)
  {
    this.delegate = paramFlutterActivityAndFragmentDelegate;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost()))
    {
      AppMethodBeat.o(10099);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public boolean shouldHandleDeeplinking()
  {
    AppMethodBeat.i(190686);
    boolean bool = getArguments().getBoolean("handle_deeplinking");
    AppMethodBeat.o(190686);
    return bool;
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    AppMethodBeat.i(190709);
    if (getArguments().containsKey("enable_state_restoration"))
    {
      boolean bool = getArguments().getBoolean("enable_state_restoration");
      AppMethodBeat.o(190709);
      return bool;
    }
    if (getCachedEngineId() != null)
    {
      AppMethodBeat.o(190709);
      return false;
    }
    AppMethodBeat.o(190709);
    return true;
  }
  
  public static class CachedEngineFragmentBuilder
  {
    private boolean destroyEngineWithFragment = false;
    private final String engineId;
    private final Class<? extends FlutterFragment> fragmentClass;
    private boolean handleDeeplinking = false;
    private RenderMode renderMode = RenderMode.surface;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    public CachedEngineFragmentBuilder(Class<? extends FlutterFragment> paramClass, String paramString)
    {
      this.fragmentClass = paramClass;
      this.engineId = paramString;
    }
    
    private CachedEngineFragmentBuilder(String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    public <T extends FlutterFragment> T build()
    {
      AppMethodBeat.i(190442);
      RuntimeException localRuntimeException;
      try
      {
        Object localObject = (FlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localObject == null)
        {
          localObject = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(190442);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        localRuntimeException = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", localException);
        AppMethodBeat.o(190442);
        throw localRuntimeException;
      }
      localRuntimeException.setArguments(createArgs());
      AppMethodBeat.o(190442);
      return localRuntimeException;
    }
    
    protected Bundle createArgs()
    {
      AppMethodBeat.i(190431);
      Bundle localBundle = new Bundle();
      localBundle.putString("cached_engine_id", this.engineId);
      localBundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
      localBundle.putBoolean("handle_deeplinking", this.handleDeeplinking);
      if (this.renderMode != null)
      {
        str = this.renderMode.name();
        localBundle.putString("flutterview_render_mode", str);
        if (this.transparencyMode == null) {
          break label114;
        }
      }
      label114:
      for (String str = this.transparencyMode.name();; str = TransparencyMode.transparent.name())
      {
        localBundle.putString("flutterview_transparency_mode", str);
        localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
        AppMethodBeat.o(190431);
        return localBundle;
        str = RenderMode.surface.name();
        break;
      }
    }
    
    public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean paramBoolean)
    {
      this.destroyEngineWithFragment = paramBoolean;
      return this;
    }
    
    public CachedEngineFragmentBuilder handleDeeplinking(Boolean paramBoolean)
    {
      AppMethodBeat.i(190411);
      this.handleDeeplinking = paramBoolean.booleanValue();
      AppMethodBeat.o(190411);
      return this;
    }
    
    public CachedEngineFragmentBuilder renderMode(RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
    {
      this.shouldAttachEngineToActivity = paramBoolean;
      return this;
    }
    
    public CachedEngineFragmentBuilder transparencyMode(TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
  }
  
  public static class NewEngineFragmentBuilder
  {
    private String appBundlePath = null;
    private String dartEntrypoint = "main";
    private final Class<? extends FlutterFragment> fragmentClass;
    private boolean handleDeeplinking = false;
    private String initialRoute = "/";
    private RenderMode renderMode = RenderMode.surface;
    private FlutterShellArgs shellArgs = null;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    public NewEngineFragmentBuilder()
    {
      this.fragmentClass = FlutterFragment.class;
    }
    
    public NewEngineFragmentBuilder(Class<? extends FlutterFragment> paramClass)
    {
      this.fragmentClass = paramClass;
    }
    
    public NewEngineFragmentBuilder appBundlePath(String paramString)
    {
      this.appBundlePath = paramString;
      return this;
    }
    
    public <T extends FlutterFragment> T build()
    {
      AppMethodBeat.i(190402);
      RuntimeException localRuntimeException;
      try
      {
        Object localObject = (FlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localObject == null)
        {
          localObject = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(190402);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        localRuntimeException = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", localException);
        AppMethodBeat.o(190402);
        throw localRuntimeException;
      }
      localRuntimeException.setArguments(createArgs());
      AppMethodBeat.o(190402);
      return localRuntimeException;
    }
    
    protected Bundle createArgs()
    {
      AppMethodBeat.i(190394);
      Bundle localBundle = new Bundle();
      localBundle.putString("initial_route", this.initialRoute);
      localBundle.putBoolean("handle_deeplinking", this.handleDeeplinking);
      localBundle.putString("app_bundle_path", this.appBundlePath);
      localBundle.putString("dart_entrypoint", this.dartEntrypoint);
      if (this.shellArgs != null) {
        localBundle.putStringArray("initialization_args", this.shellArgs.toArray());
      }
      if (this.renderMode != null)
      {
        str = this.renderMode.name();
        localBundle.putString("flutterview_render_mode", str);
        if (this.transparencyMode == null) {
          break label151;
        }
      }
      label151:
      for (String str = this.transparencyMode.name();; str = TransparencyMode.transparent.name())
      {
        localBundle.putString("flutterview_transparency_mode", str);
        localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        AppMethodBeat.o(190394);
        return localBundle;
        str = RenderMode.surface.name();
        break;
      }
    }
    
    public NewEngineFragmentBuilder dartEntrypoint(String paramString)
    {
      this.dartEntrypoint = paramString;
      return this;
    }
    
    public NewEngineFragmentBuilder flutterShellArgs(FlutterShellArgs paramFlutterShellArgs)
    {
      this.shellArgs = paramFlutterShellArgs;
      return this;
    }
    
    public NewEngineFragmentBuilder handleDeeplinking(Boolean paramBoolean)
    {
      AppMethodBeat.i(190367);
      this.handleDeeplinking = paramBoolean.booleanValue();
      AppMethodBeat.o(190367);
      return this;
    }
    
    public NewEngineFragmentBuilder initialRoute(String paramString)
    {
      this.initialRoute = paramString;
      return this;
    }
    
    public NewEngineFragmentBuilder renderMode(RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
    {
      this.shouldAttachEngineToActivity = paramBoolean;
      return this;
    }
    
    public NewEngineFragmentBuilder transparencyMode(TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */