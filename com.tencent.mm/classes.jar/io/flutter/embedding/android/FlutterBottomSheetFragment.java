package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Constructor;

public class FlutterBottomSheetFragment
  extends BottomSheetDialogFragment
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
  private static final String TAG = "FlutterBottomSheetFragment";
  FlutterActivityAndFragmentDelegate delegate;
  
  public FlutterBottomSheetFragment()
  {
    AppMethodBeat.i(190487);
    setArguments(new Bundle());
    AppMethodBeat.o(190487);
  }
  
  public static FlutterBottomSheetFragment createDefault()
  {
    AppMethodBeat.i(190467);
    FlutterBottomSheetFragment localFlutterBottomSheetFragment = new NewEngineFragmentBuilder().build();
    AppMethodBeat.o(190467);
    return localFlutterBottomSheetFragment;
  }
  
  private boolean stillAttachedForEvent(String paramString)
  {
    AppMethodBeat.i(190490);
    if (this.delegate == null)
    {
      Log.v("FlutterBottomSheetFragment", "FlutterBottomSheetFragment " + hashCode() + " " + paramString + " called after release.");
      AppMethodBeat.o(190490);
      return false;
    }
    AppMethodBeat.o(190490);
    return true;
  }
  
  public static CachedEngineFragmentBuilder withCachedEngine(String paramString)
  {
    AppMethodBeat.i(190483);
    paramString = new CachedEngineFragmentBuilder(paramString, null);
    AppMethodBeat.o(190483);
    return paramString;
  }
  
  public static NewEngineFragmentBuilder withNewEngine()
  {
    AppMethodBeat.i(190475);
    NewEngineFragmentBuilder localNewEngineFragmentBuilder = new NewEngineFragmentBuilder();
    AppMethodBeat.o(190475);
    return localNewEngineFragmentBuilder;
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190698);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).cleanUpFlutterEngine(paramFlutterEngine);
    }
    AppMethodBeat.o(190698);
  }
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190693);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).configureFlutterEngine(paramFlutterEngine);
    }
    AppMethodBeat.o(190693);
  }
  
  public void detachFromFlutterEngine()
  {
    AppMethodBeat.i(190573);
    Log.v("FlutterBottomSheetFragment", "FlutterBottomSheetFragment " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    this.delegate.onDestroyView();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
    AppMethodBeat.o(190573);
  }
  
  public String getAppBundlePath()
  {
    AppMethodBeat.i(190652);
    String str = getArguments().getString("app_bundle_path");
    AppMethodBeat.o(190652);
    return str;
  }
  
  public String getCachedEngineId()
  {
    AppMethodBeat.i(190635);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(190635);
    return str;
  }
  
  public String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(190645);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(190645);
    return str;
  }
  
  public FlutterEngine getFlutterEngine()
  {
    AppMethodBeat.i(190685);
    FlutterEngine localFlutterEngine = this.delegate.getFlutterEngine();
    AppMethodBeat.o(190685);
    return localFlutterEngine;
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    AppMethodBeat.i(190631);
    Object localObject = getArguments().getStringArray("initialization_args");
    if (localObject != null) {}
    for (;;)
    {
      localObject = new FlutterShellArgs((String[])localObject);
      AppMethodBeat.o(190631);
      return localObject;
      localObject = new String[0];
    }
  }
  
  public String getInitialRoute()
  {
    AppMethodBeat.i(190658);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(190658);
    return str;
  }
  
  public RenderMode getRenderMode()
  {
    AppMethodBeat.i(190664);
    RenderMode localRenderMode = RenderMode.valueOf(getArguments().getString("flutterview_render_mode", RenderMode.surface.name()));
    AppMethodBeat.o(190664);
    return localRenderMode;
  }
  
  public TransparencyMode getTransparencyMode()
  {
    AppMethodBeat.i(190669);
    TransparencyMode localTransparencyMode = TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.transparent.name()));
    AppMethodBeat.o(190669);
    return localTransparencyMode;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190610);
    if (stillAttachedForEvent("onActivityResult")) {
      this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(190610);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(190509);
    super.onAttach(paramContext);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(paramContext);
    AppMethodBeat.o(190509);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190605);
    if (stillAttachedForEvent("onBackPressed")) {
      this.delegate.onBackPressed();
    }
    AppMethodBeat.o(190605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190513);
    super.onCreate(paramBundle);
    this.delegate.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(190513);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(190520);
    paramLayoutInflater = this.delegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(190520);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(190554);
    super.onDestroyView();
    if (stillAttachedForEvent("onDestroyView")) {
      this.delegate.onDestroyView();
    }
    AppMethodBeat.o(190554);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(190581);
    super.onDetach();
    if (this.delegate != null)
    {
      this.delegate.onDetach();
      this.delegate.release();
      this.delegate = null;
      AppMethodBeat.o(190581);
      return;
    }
    Log.v("FlutterBottomSheetFragment", "FlutterBottomSheetFragment " + this + " onDetach called after release.");
    AppMethodBeat.o(190581);
  }
  
  public void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    AppMethodBeat.i(190719);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterUiDisplayListener)) {
      ((FlutterUiDisplayListener)localFragmentActivity).onFlutterUiDisplayed();
    }
    AppMethodBeat.o(190719);
  }
  
  public void onFlutterUiNoLongerDisplayed()
  {
    AppMethodBeat.i(190722);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterUiDisplayListener)) {
      ((FlutterUiDisplayListener)localFragmentActivity).onFlutterUiNoLongerDisplayed();
    }
    AppMethodBeat.o(190722);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(190627);
    super.onLowMemory();
    if (stillAttachedForEvent("onLowMemory")) {
      this.delegate.onLowMemory();
    }
    AppMethodBeat.o(190627);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190599);
    if (stillAttachedForEvent("onNewIntent")) {
      this.delegate.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(190599);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190546);
    super.onPause();
    this.delegate.onPause();
    AppMethodBeat.o(190546);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(190541);
    this.delegate.onPostResume();
    AppMethodBeat.o(190541);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190591);
    if (stillAttachedForEvent("onRequestPermissionsResult")) {
      this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(190591);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190534);
    super.onResume();
    this.delegate.onResume();
    AppMethodBeat.o(190534);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190564);
    super.onSaveInstanceState(paramBundle);
    if (stillAttachedForEvent("onSaveInstanceState")) {
      this.delegate.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(190564);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(190526);
    super.onStart();
    this.delegate.onStart();
    AppMethodBeat.o(190526);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(190550);
    super.onStop();
    if (stillAttachedForEvent("onStop")) {
      this.delegate.onStop();
    }
    AppMethodBeat.o(190550);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(190620);
    if (stillAttachedForEvent("onTrimMemory")) {
      this.delegate.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(190620);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(190617);
    if (stillAttachedForEvent("onUserLeaveHint")) {
      this.delegate.onUserLeaveHint();
    }
    AppMethodBeat.o(190617);
  }
  
  public boolean popSystemNavigator()
  {
    return false;
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    AppMethodBeat.i(190681);
    paramContext = getActivity();
    if ((paramContext instanceof FlutterEngineProvider)) {
      Log.v("FlutterBottomSheetFragment", "Deferring to attached Activity to provide a FlutterEngine.");
    }
    for (paramContext = ((FlutterEngineProvider)paramContext).provideFlutterEngine(getContext());; paramContext = null)
    {
      AppMethodBeat.o(190681);
      return paramContext;
    }
  }
  
  public PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190690);
    if (paramActivity != null)
    {
      paramActivity = new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel(), this);
      AppMethodBeat.o(190690);
      return paramActivity;
    }
    AppMethodBeat.o(190690);
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(190673);
    Object localObject = getActivity();
    if ((localObject instanceof SplashScreenProvider))
    {
      localObject = ((SplashScreenProvider)localObject).provideSplashScreen();
      AppMethodBeat.o(190673);
      return localObject;
    }
    AppMethodBeat.o(190673);
    return null;
  }
  
  void setDelegate(FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate)
  {
    this.delegate = paramFlutterActivityAndFragmentDelegate;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    AppMethodBeat.i(190704);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(190704);
    return bool;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    AppMethodBeat.i(190641);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost()))
    {
      AppMethodBeat.o(190641);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(190641);
    return bool;
  }
  
  public boolean shouldHandleDeeplinking()
  {
    AppMethodBeat.i(190708);
    boolean bool = getArguments().getBoolean("handle_deeplinking");
    AppMethodBeat.o(190708);
    return bool;
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    AppMethodBeat.i(190724);
    if (getArguments().containsKey("enable_state_restoration"))
    {
      boolean bool = getArguments().getBoolean("enable_state_restoration");
      AppMethodBeat.o(190724);
      return bool;
    }
    if (getCachedEngineId() != null)
    {
      AppMethodBeat.o(190724);
      return false;
    }
    AppMethodBeat.o(190724);
    return true;
  }
  
  public static class CachedEngineFragmentBuilder
  {
    private boolean destroyEngineWithFragment = false;
    private final String engineId;
    private final Class<? extends FlutterBottomSheetFragment> fragmentClass;
    private boolean handleDeeplinking = false;
    private RenderMode renderMode = RenderMode.surface;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    public CachedEngineFragmentBuilder(Class<? extends FlutterBottomSheetFragment> paramClass, String paramString)
    {
      this.fragmentClass = paramClass;
      this.engineId = paramString;
    }
    
    private CachedEngineFragmentBuilder(String paramString)
    {
      this(FlutterBottomSheetFragment.class, paramString);
    }
    
    public <T extends FlutterBottomSheetFragment> T build()
    {
      AppMethodBeat.i(190530);
      RuntimeException localRuntimeException;
      try
      {
        Object localObject = (FlutterBottomSheetFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localObject == null)
        {
          localObject = new RuntimeException("The FlutterBottomSheetFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(190530);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        localRuntimeException = new RuntimeException("Could not instantiate FlutterBottomSheetFragment subclass (" + this.fragmentClass.getName() + ")", localException);
        AppMethodBeat.o(190530);
        throw localRuntimeException;
      }
      localRuntimeException.setArguments(createArgs());
      AppMethodBeat.o(190530);
      return localRuntimeException;
    }
    
    protected Bundle createArgs()
    {
      AppMethodBeat.i(190523);
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
        AppMethodBeat.o(190523);
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
      AppMethodBeat.i(190508);
      this.handleDeeplinking = paramBoolean.booleanValue();
      AppMethodBeat.o(190508);
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
    private final Class<? extends FlutterBottomSheetFragment> fragmentClass;
    private boolean handleDeeplinking = false;
    private String initialRoute = "/";
    private RenderMode renderMode = RenderMode.surface;
    private FlutterShellArgs shellArgs = null;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    public NewEngineFragmentBuilder()
    {
      this.fragmentClass = FlutterBottomSheetFragment.class;
    }
    
    public NewEngineFragmentBuilder(Class<? extends FlutterBottomSheetFragment> paramClass)
    {
      this.fragmentClass = paramClass;
    }
    
    public NewEngineFragmentBuilder appBundlePath(String paramString)
    {
      this.appBundlePath = paramString;
      return this;
    }
    
    public <T extends FlutterBottomSheetFragment> T build()
    {
      AppMethodBeat.i(190444);
      RuntimeException localRuntimeException;
      try
      {
        Object localObject = (FlutterBottomSheetFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localObject == null)
        {
          localObject = new RuntimeException("The FlutterBottomSheetFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(190444);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        localRuntimeException = new RuntimeException("Could not instantiate FlutterBottomSheetFragment subclass (" + this.fragmentClass.getName() + ")", localException);
        AppMethodBeat.o(190444);
        throw localRuntimeException;
      }
      localRuntimeException.setArguments(createArgs());
      AppMethodBeat.o(190444);
      return localRuntimeException;
    }
    
    protected Bundle createArgs()
    {
      AppMethodBeat.i(190436);
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
        AppMethodBeat.o(190436);
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
      AppMethodBeat.i(190404);
      this.handleDeeplinking = paramBoolean.booleanValue();
      AppMethodBeat.o(190404);
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
 * Qualified Name:     io.flutter.embedding.android.FlutterBottomSheetFragment
 * JD-Core Version:    0.7.0.1
 */