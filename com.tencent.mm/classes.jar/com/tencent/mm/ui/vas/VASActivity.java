package com.tencent.mm.ui.vas;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.aj;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.vas.b.a.a;
import com.tencent.mm.ui.vas.fragment.VASBaseFragment;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "_TAG", "", "get_TAG", "()Ljava/lang/String;", "set_TAG", "(Ljava/lang/String;)V", "_activity", "Landroid/app/Activity;", "get_activity", "()Landroid/app/Activity;", "set_activity", "(Landroid/app/Activity;)V", "_isFinishing", "", "get_isFinishing", "()Z", "set_isFinishing", "(Z)V", "backStackCount", "", "getBackStackCount", "()I", "setBackStackCount", "(I)V", "disableCommonAreaControl", "getDisableCommonAreaControl", "setDisableCommonAreaControl", "fragment", "Lcom/tencent/mm/ui/vas/VASCommonFragment;", "getFragment", "()Lcom/tencent/mm/ui/vas/VASCommonFragment;", "setFragment", "(Lcom/tencent/mm/ui/vas/VASCommonFragment;)V", "innerContext", "Landroid/content/Context;", "getInnerContext", "()Landroid/content/Context;", "setInnerContext", "(Landroid/content/Context;)V", "isGetFragment", "isInitFinished", "setInitFinished", "isVASValid", "mActionBar", "Landroidx/appcompat/app/ActionBar;", "getMActionBar", "()Landroidx/appcompat/app/ActionBar;", "mActionBar$delegate", "Lkotlin/Lazy;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getMFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setMFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "tempPageAnim", "Lcom/tencent/mm/ui/vas/VASActivity$TempPageAnim;", "getTempPageAnim", "()Lcom/tencent/mm/ui/vas/VASActivity$TempPageAnim;", "setTempPageAnim", "(Lcom/tencent/mm/ui/vas/VASActivity$TempPageAnim;)V", "uiComponents", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/component/UIComponent;", "getUiComponents", "()Ljava/util/HashSet;", "_getCustomBounceId", "callOnActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "findViewById", "T", "Landroid/view/View;", "id", "(I)Landroid/view/View;", "finish", "finishWithNoAnim", "getActionBarData", "Lcom/tencent/mm/ui/vas/actionbar/VasActionBarData;", "getActionbarColor", "getApplicationInfo", "Landroid/content/pm/ApplicationInfo;", "getBackStackCnt", "getController", "Lcom/tencent/mm/ui/MMActivityController;", "getCurLayoutId", "getCustomBounceId", "getForceOrientation", "getIntent", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getRequestedOrientation", "getResources", "Landroid/content/res/Resources;", "getResultCode", "getResultData", "getSupportActionBar", "getSupportFragmentManager", "getSystemService", "", "name", "getTheme", "Landroid/content/res/Resources$Theme;", "getViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getWindow", "Landroid/view/Window;", "handleRequestPermissions", "permissions", "", "([Ljava/lang/String;I)Z", "hideActionBar", "hideActionBarOperationArea", "hideActionbarLine", "hideVKB", "view", "initVasController", "isFinishing", "isFullScreen", "isTabMode", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnterAnimationComplete", "onInited", "onNewBundle", "argument", "onPageAnimEnd", "onPageAnimStart", "onPause", "onResume", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "overridePendingTransition", "enterAnim", "exitAnim", "registerActivityDetailedLifecycleCallbacks", "setActionbarColor", "color", "setBackBtn", "listener", "Landroid/view/MenuItem$OnMenuItemClickListener;", "setContentView", "setMMTitle", "text", "", "resId", "setNavigationbarColor", "setPageAnim", "Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "popEnterAnim", "popExitAnim", "setRequestedOrientation", "requestedOrientation", "setTheme", "resid", "showActionBar", "showVKB", "startActivityForResult", "intent", "options", "supportInvalidateOptionsMenu", "supportRequestWindowFeature", "featureId", "Companion", "TempPageAnim", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class VASActivity
  extends MMActivity
  implements p
{
  public static final a Companion = new a((byte)0);
  public static final String KEY_CLS = "VAS_CLASS";
  public static final String KEY_DISABLE_COMMON_AREA_CONTROL = "KEY_DISABLE_COMMON_AREA_CONTROL";
  public static final String KEY_GET_FRAGMENT = "KEY_GET_FRAGMENT";
  public static final String KEY_LAUNCH_MODE = "KEY_LAUNCH_MODE";
  public static final int LAUNCH_MODE_SINGLEINSTANCE = 3;
  public static final int LAUNCH_MODE_SINGLETASK = 2;
  public static final int LAUNCH_MODE_SINGLETOP = 1;
  public static final int LAUNCH_MODE_STANDARD = 0;
  private static com.tencent.mm.ui.vas.b.a vasController = a.a.jEr();
  private String _TAG = "MicroMsg.VAS.VASActivity." + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode());
  public Activity _activity;
  private byte _hellAccFlag_;
  private boolean _isFinishing;
  private int backStackCount;
  private boolean disableCommonAreaControl;
  public VASCommonFragment fragment;
  public Context innerContext;
  private boolean isInitFinished;
  private final kotlin.j mActionBar$delegate = k.cm((kotlin.g.a.a)new c(this));
  private FragmentManager mFragmentManager;
  private b tempPageAnim = new b();
  
  static
  {
    a.a locala = com.tencent.mm.ui.vas.b.a.afQX;
  }
  
  @z(Ho=j.a.ON_CREATE)
  private final void onCreate()
  {
    onCreate(null);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final int _getCustomBounceId()
  {
    return getCustomBounceId();
  }
  
  public void callOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    Object localObject;
    if (!isVASValid()) {
      localObject = super.findViewById(paramInt);
    }
    View localView;
    do
    {
      return localObject;
      localView = getController().getContentView().findViewById(paramInt);
      localObject = localView;
    } while (localView != null);
    return get_activity().findViewById(paramInt);
  }
  
  public void finish()
  {
    if (!isVASValid()) {
      super.finish();
    }
    Object localObject;
    do
    {
      return;
      this._isFinishing = true;
      localObject = com.tencent.mm.ui.vas.e.a.afRq;
      com.tencent.mm.ui.vas.e.a.a(getResultCode(), getResultData(), getFragment().getTargetRequestCode());
      int i = getBackStackCnt();
      Log.d(this._TAG, s.X("finish backStackCnt:", Integer.valueOf(i)));
      if (i <= 0) {
        break;
      }
      localObject = this.mFragmentManager;
    } while (localObject == null);
    ((FragmentManager)localObject).popBackStack();
    return;
    get_activity().finish();
  }
  
  public final void finishWithNoAnim()
  {
    if (getBackStackCnt() > 0)
    {
      e locale = e.afQO;
      e.jEp();
      locale = e.afQO;
      e.jEq();
    }
    finish();
  }
  
  public final com.tencent.mm.ui.vas.a.a getActionBarData()
  {
    return new com.tencent.mm.ui.vas.a.a(getMMTitle(), getController().adEb.getIconColor(), getController().jjR(), getController().adDZ.getCurrentTextColor(), getController().adDZ.getTextSize());
  }
  
  public int getActionbarColor()
  {
    if (!isVASValid()) {
      return super.getActionbarColor();
    }
    return getController().jjR();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (!isVASValid())
    {
      localApplicationInfo = super.getApplicationInfo();
      s.s(localApplicationInfo, "super.getApplicationInfo()");
      return localApplicationInfo;
    }
    ApplicationInfo localApplicationInfo = getInnerContext().getApplicationInfo();
    s.s(localApplicationInfo, "innerContext.applicationInfo");
    return localApplicationInfo;
  }
  
  public final int getBackStackCnt()
  {
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (localFragmentManager == null) {
      return 0;
    }
    return localFragmentManager.getBackStackEntryCount();
  }
  
  public final int getBackStackCount()
  {
    return this.backStackCount;
  }
  
  public y getController()
  {
    if (!isVASValid())
    {
      y localy = super.getController();
      s.s(localy, "super.getController()");
      return localy;
    }
    return getFragment().mController;
  }
  
  public final int getCurLayoutId()
  {
    return getLayoutId();
  }
  
  public int getCustomBounceId()
  {
    if (!isVASValid()) {
      return super.getCustomBounceId();
    }
    return -1;
  }
  
  public final boolean getDisableCommonAreaControl()
  {
    return this.disableCommonAreaControl;
  }
  
  public int getForceOrientation()
  {
    if (!isVASValid()) {
      return super.getForceOrientation();
    }
    return -1;
  }
  
  public final VASCommonFragment getFragment()
  {
    VASCommonFragment localVASCommonFragment = this.fragment;
    if (localVASCommonFragment != null) {
      return localVASCommonFragment;
    }
    s.bIx("fragment");
    return null;
  }
  
  public final Context getInnerContext()
  {
    Context localContext = this.innerContext;
    if (localContext != null) {
      return localContext;
    }
    s.bIx("innerContext");
    return null;
  }
  
  public Intent getIntent()
  {
    if (!isVASValid())
    {
      Intent localIntent = super.getIntent();
      s.s(localIntent, "super.getIntent()");
      return localIntent;
    }
    return getFragment().intent;
  }
  
  public androidx.lifecycle.j getLifecycle()
  {
    if (!isVASValid())
    {
      localj = super.getLifecycle();
      s.s(localj, "super.getLifecycle()");
      return localj;
    }
    androidx.lifecycle.j localj = getFragment().getLifecycle();
    s.s(localj, "fragment.lifecycle");
    return localj;
  }
  
  public final ActionBar getMActionBar()
  {
    return (ActionBar)this.mActionBar$delegate.getValue();
  }
  
  public final FragmentManager getMFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public int getRequestedOrientation()
  {
    if (!isVASValid()) {
      return super.getRequestedOrientation();
    }
    return get_activity().getRequestedOrientation();
  }
  
  public Resources getResources()
  {
    if (!isVASValid())
    {
      localResources = super.getResources();
      s.s(localResources, "super.getResources()");
      return localResources;
    }
    Resources localResources = getInnerContext().getResources();
    s.s(localResources, "innerContext.resources");
    return localResources;
  }
  
  public final int getResultCode()
  {
    try
    {
      Object localObject1 = Activity.class.getDeclaredField("mResultCode");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(this);
      if (localObject1 == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      }
      int i = ((Integer)localObject1).intValue();
      return i;
    }
    finally {}
    return 0;
  }
  
  public final Intent getResultData()
  {
    try
    {
      Object localObject1 = Activity.class.getDeclaredField("mResultData");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (Intent)((Field)localObject1).get(this);
      return localObject1;
    }
    finally {}
    return null;
  }
  
  public ActionBar getSupportActionBar()
  {
    if (!isVASValid()) {
      return super.getSupportActionBar();
    }
    return getMActionBar();
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    if (!isVASValid())
    {
      localFragmentManager = super.getSupportFragmentManager();
      s.s(localFragmentManager, "super.getSupportFragmentManager()");
      return localFragmentManager;
    }
    FragmentManager localFragmentManager = this.mFragmentManager;
    s.checkNotNull(localFragmentManager);
    return localFragmentManager;
  }
  
  public Object getSystemService(String paramString)
  {
    s.u(paramString, "name");
    Object localObject1;
    if (!isVASValid()) {
      localObject1 = super.getSystemService(paramString);
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = getInnerContext().getSystemService(paramString);
        localObject1 = localObject2;
      } while (!s.p("layout_inflater", paramString));
      localObject1 = localObject2;
    } while (!(localObject2 instanceof LayoutInflater));
    return af.a((LayoutInflater)localObject2, (Context)this);
  }
  
  public final b getTempPageAnim()
  {
    return this.tempPageAnim;
  }
  
  public Resources.Theme getTheme()
  {
    if (!isVASValid())
    {
      localTheme = super.getTheme();
      s.s(localTheme, "super.getTheme()");
      return localTheme;
    }
    Resources.Theme localTheme = getInnerContext().getTheme();
    s.s(localTheme, "innerContext.theme");
    return localTheme;
  }
  
  public HashSet<UIComponent> getUiComponents()
  {
    if (!isVASValid()) {
      return super.getUiComponents();
    }
    return getFragment().uiComponents;
  }
  
  public aj getViewModelStore()
  {
    if (!isVASValid()) {
      return super.getViewModelStore();
    }
    return getFragment().getViewModelStore();
  }
  
  public Window getWindow()
  {
    if (!isVASValid())
    {
      localWindow = super.getWindow();
      s.s(localWindow, "super.getWindow()");
      return localWindow;
    }
    Window localWindow = get_activity().getWindow();
    s.s(localWindow, "_activity.window");
    return localWindow;
  }
  
  public final String get_TAG()
  {
    return this._TAG;
  }
  
  public final Activity get_activity()
  {
    Activity localActivity = this._activity;
    if (localActivity != null) {
      return localActivity;
    }
    s.bIx("_activity");
    return null;
  }
  
  public final boolean get_isFinishing()
  {
    return this._isFinishing;
  }
  
  public final boolean handleRequestPermissions(String[] paramArrayOfString, int paramInt)
  {
    s.u(paramArrayOfString, "permissions");
    if (!isVASValid()) {
      return false;
    }
    VASCommonFragment localVASCommonFragment = getFragment();
    paramArrayOfString = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(localVASCommonFragment, paramArrayOfString.aYi(), "com/tencent/mm/ui/vas/VASActivity", "handleRequestPermissions", "([Ljava/lang/String;I)Z", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    localVASCommonFragment.requestPermissions((String[])paramArrayOfString.sb(0), ((Integer)paramArrayOfString.sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localVASCommonFragment, "com/tencent/mm/ui/vas/VASActivity", "handleRequestPermissions", "([Ljava/lang/String;I)Z", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    return true;
  }
  
  public final void hideActionBar()
  {
    ActionBar localActionBar = getController().getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.hide();
    }
  }
  
  public void hideActionBarOperationArea()
  {
    if (!isVASValid()) {
      super.hideActionBarOperationArea();
    }
    y localy;
    do
    {
      return;
      localy = getController();
    } while (localy == null);
    localy.hideActionBarOperationArea();
  }
  
  public void hideActionbarLine()
  {
    if (!isVASValid()) {
      super.hideActionbarLine();
    }
    while (this.disableCommonAreaControl) {
      return;
    }
    getController().hideActionbarLine();
  }
  
  public void hideVKB()
  {
    if (!isVASValid())
    {
      super.hideVKB();
      return;
    }
    getFragment().mController.hideVKB();
  }
  
  public void hideVKB(View paramView)
  {
    if (!isVASValid())
    {
      super.hideVKB(paramView);
      return;
    }
    getController().hideVKB(paramView);
  }
  
  public final void initVasController()
  {
    setCurController(getController());
  }
  
  public boolean isFinishing()
  {
    if (!isVASValid()) {
      return super.isFinishing();
    }
    return getFragment().isRemoving();
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isGetFragment()
  {
    return getIntent().getBooleanExtra("KEY_GET_FRAGMENT", false);
  }
  
  public final boolean isInitFinished()
  {
    return this.isInitFinished;
  }
  
  public final boolean isTabMode()
  {
    return get_activity() instanceof VASCommonForPadActivity;
  }
  
  public final boolean isVASValid()
  {
    return this.isInitFinished;
  }
  
  public void onBackPressed()
  {
    if (!isVASValid())
    {
      super.onBackPressed();
      return;
    }
    if (isTabMode())
    {
      localObject = d.afQM;
      localObject = getClass().getName();
      s.s(localObject, "this::class.java.name");
      if (d.bDo((String)localObject))
      {
        get_activity().finish();
        return;
      }
    }
    Object localObject = ((Iterable)UIComponentActivity.activeUIComponents$default((UIComponentActivity)this, false, 1, null)).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((UIComponent)((Iterator)localObject).next()).onBackPressed()) {
        return;
      }
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (!isVASValid())
    {
      MMActivity.aReporter.bs(getIntent());
      super.onCreate(paramBundle);
    }
    do
    {
      return;
      Log.i(this._TAG, "onCreate " + getClass().getName() + ' ' + hashCode());
      this.disableCommonAreaControl = getIntent().getBooleanExtra("KEY_DISABLE_COMMON_AREA_CONTROL", false);
      paramBundle = i.agtt;
    } while (i.a(b.a.agqu, 0) != 1);
    aa.makeText((Context)this, (CharSequence)s.X("VAS-", getClass().getSimpleName()), 0).show();
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public void onDestroy()
  {
    if (!isVASValid())
    {
      super.onDestroy();
      return;
    }
    Log.d(this._TAG, "onDestroy " + getClass().getName() + ' ' + hashCode());
  }
  
  public void onEnterAnimationComplete()
  {
    super.onEnterAnimationComplete();
    MMActivity.aReporter.a(getIntent(), System.currentTimeMillis() - 300L);
    MMActivity.aReporter.bt(getIntent());
  }
  
  public final void onInited()
  {
    this.isInitFinished = true;
    attachBaseContext((Context)get_activity());
  }
  
  public void onNewBundle(Bundle paramBundle)
  {
    s.u(paramBundle, "argument");
    Log.d(this._TAG, s.X("onNewBundle() called with: argument = ", paramBundle));
  }
  
  public void onPageAnimEnd()
  {
    Log.d("MicroMsg.VAS.VasNavigator", "onPageAnimEnd() called");
  }
  
  public void onPageAnimStart()
  {
    Log.d("MicroMsg.VAS.VasNavigator", "onPageAnimStart() called");
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onPause()
  {
    if (!isVASValid())
    {
      super.onPause();
      return;
    }
    Log.d(this._TAG, "onPause " + getClass().getName() + ' ' + hashCode());
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onResume()
  {
    if (!isVASValid())
    {
      super.onResume();
      return;
    }
    Log.d(this._TAG, "onResume " + getClass().getName() + ' ' + hashCode());
  }
  
  @z(Ho=j.a.ON_START)
  public void onStart()
  {
    if (!isVASValid())
    {
      super.onStart();
      return;
    }
    Log.d(this._TAG, "onStart " + getClass().getName() + ' ' + hashCode());
  }
  
  @z(Ho=j.a.ON_STOP)
  public void onStop()
  {
    if (!isVASValid())
    {
      super.onStop();
      return;
    }
    Log.d(this._TAG, "onStop " + getClass().getName() + ' ' + hashCode());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!isVASValid()) {
      super.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    if (!isVASValid())
    {
      super.overridePendingTransition(paramInt1, paramInt2);
      return;
    }
    get_activity().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void registerActivityDetailedLifecycleCallbacks()
  {
    if ((!a.jEi()) || (!isVASValid())) {
      super.registerActivityDetailedLifecycleCallbacks();
    }
  }
  
  public void setActionbarColor(int paramInt)
  {
    if (!isVASValid()) {
      super.setActionbarColor(paramInt);
    }
    while (this.disableCommonAreaControl) {
      return;
    }
    getController().setActionbarColor(paramInt);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    if (!isVASValid())
    {
      super.setBackBtn(paramOnMenuItemClickListener);
      return;
    }
    getController().setBackBtn(paramOnMenuItemClickListener, 0);
  }
  
  public final void setBackStackCount(int paramInt)
  {
    this.backStackCount = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    if (!isVASValid()) {
      super.setContentView(paramView);
    }
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (paramView == null);
      localFrameLayout = getFragment().afQH;
      if (localFrameLayout != null) {
        localFrameLayout.removeAllViews();
      }
      localFrameLayout = getFragment().afQH;
    } while (localFrameLayout == null);
    localFrameLayout.addView(paramView);
  }
  
  public final void setDisableCommonAreaControl(boolean paramBoolean)
  {
    this.disableCommonAreaControl = paramBoolean;
  }
  
  public final void setFragment(VASCommonFragment paramVASCommonFragment)
  {
    s.u(paramVASCommonFragment, "<set-?>");
    this.fragment = paramVASCommonFragment;
  }
  
  public final void setInitFinished(boolean paramBoolean)
  {
    this.isInitFinished = paramBoolean;
  }
  
  public final void setInnerContext(Context paramContext)
  {
    s.u(paramContext, "<set-?>");
    this.innerContext = paramContext;
  }
  
  public final void setMFragmentManager(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void setMMTitle(int paramInt)
  {
    if (!isVASValid()) {
      super.setMMTitle(paramInt);
    }
    while (this.disableCommonAreaControl) {
      return;
    }
    getFragment().mController.setMMTitle(paramInt);
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    if (!isVASValid()) {
      super.setMMTitle(paramCharSequence);
    }
    while (this.disableCommonAreaControl) {
      return;
    }
    getFragment().mController.setMMTitle(paramCharSequence);
  }
  
  public void setMMTitle(String paramString)
  {
    if (!isVASValid()) {
      super.setMMTitle(paramString);
    }
    while (this.disableCommonAreaControl) {
      return;
    }
    getFragment().mController.setMMTitle((CharSequence)paramString);
  }
  
  public void setNavigationbarColor(int paramInt)
  {
    if (!isVASValid()) {
      super.setNavigationbarColor(paramInt);
    }
    while (this.disableCommonAreaControl) {
      return;
    }
    getController().setNavigationbarColor(paramInt);
  }
  
  public final void setPageAnim(com.tencent.mm.ui.vas.c.f paramf1, com.tencent.mm.ui.vas.c.f paramf2, com.tencent.mm.ui.vas.c.f paramf3, com.tencent.mm.ui.vas.c.f paramf4)
  {
    s.u(paramf1, "enterAnim");
    s.u(paramf2, "exitAnim");
    s.u(paramf3, "popEnterAnim");
    s.u(paramf4, "popExitAnim");
    this.tempPageAnim.afQp = paramf1;
    this.tempPageAnim.afQq = paramf2;
    this.tempPageAnim.afQr = paramf3;
    this.tempPageAnim.afQs = paramf4;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (!isVASValid())
    {
      super.setRequestedOrientation(paramInt);
      return;
    }
    get_activity().setRequestedOrientation(paramInt);
  }
  
  public final void setTempPageAnim(b paramb)
  {
    s.u(paramb, "<set-?>");
    this.tempPageAnim = paramb;
  }
  
  public void setTheme(int paramInt)
  {
    if (!isVASValid())
    {
      super.setTheme(paramInt);
      return;
    }
    get_activity().setTheme(paramInt);
  }
  
  public final void set_TAG(String paramString)
  {
    s.u(paramString, "<set-?>");
    this._TAG = paramString;
  }
  
  public final void set_activity(Activity paramActivity)
  {
    s.u(paramActivity, "<set-?>");
    this._activity = paramActivity;
  }
  
  public final void set_isFinishing(boolean paramBoolean)
  {
    this._isFinishing = paramBoolean;
  }
  
  public final void showActionBar()
  {
    ActionBar localActionBar = getController().getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.show();
    }
  }
  
  public void showVKB()
  {
    if (!isVASValid()) {
      super.showVKB();
    }
    y localy;
    do
    {
      return;
      localy = getController();
    } while (localy == null);
    y.showVKB(localy.adDS);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    if (!isVASValid())
    {
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    Object localObject;
    if ((paramIntent != null) && (c.isVASActivity(paramIntent) == true))
    {
      if (i == 0) {
        break label118;
      }
      if (paramIntent != null) {
        break label75;
      }
      localObject = "";
    }
    for (;;)
    {
      localObject = Class.forName((String)localObject);
      s.s(localObject, "curClass");
      f.a(this, (Class)localObject, paramIntent, paramBundle, paramInt);
      return;
      i = 0;
      break;
      label75:
      localObject = paramIntent.getComponent();
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        String str = ((ComponentName)localObject).getClassName();
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    label118:
    get_activity().startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (!isVASValid())
    {
      super.supportInvalidateOptionsMenu();
      return;
    }
    getController().supportInvalidateOptionsMenu();
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    if (!isVASValid()) {
      return super.supportRequestWindowFeature(paramInt);
    }
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASActivity$Companion;", "", "()V", "KEY_CLS", "", "KEY_DISABLE_COMMON_AREA_CONTROL", "KEY_GET_FRAGMENT", "KEY_LAUNCH_MODE", "LAUNCH_MODE_SINGLEINSTANCE", "", "LAUNCH_MODE_SINGLETASK", "LAUNCH_MODE_SINGLETOP", "LAUNCH_MODE_STANDARD", "vasController", "Lcom/tencent/mm/ui/vas/api/IVASController;", "getVasController", "()Lcom/tencent/mm/ui/vas/api/IVASController;", "setVasController", "(Lcom/tencent/mm/ui/vas/api/IVASController;)V", "isRemoveContainerMargin", "", "className", "isSupport", "isVASSwitchOpen", "setVASSwitch", "", "open", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(com.tencent.mm.ui.vas.b.a parama)
    {
      AppMethodBeat.i(249932);
      s.u(parama, "<set-?>");
      VASActivity.access$setVasController$cp(parama);
      AppMethodBeat.o(249932);
    }
    
    public static com.tencent.mm.ui.vas.b.a jEh()
    {
      AppMethodBeat.i(249927);
      com.tencent.mm.ui.vas.b.a locala = VASActivity.access$getVasController$cp();
      AppMethodBeat.o(249927);
      return locala;
    }
    
    public static boolean jEi()
    {
      AppMethodBeat.i(249939);
      boolean bool = VASActivity.access$getVasController$cp().gUR();
      AppMethodBeat.o(249939);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASActivity$TempPageAnim;", "", "()V", "enterAnim", "Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "getEnterAnim", "()Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "setEnterAnim", "(Lcom/tencent/mm/ui/vas/page/VASPageAnim;)V", "exitAnim", "getExitAnim", "setExitAnim", "popEnterAnim", "getPopEnterAnim", "setPopEnterAnim", "popExitAnim", "getPopExitAnim", "setPopExitAnim", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    com.tencent.mm.ui.vas.c.f afQp;
    com.tencent.mm.ui.vas.c.f afQq;
    com.tencent.mm.ui.vas.c.f afQr;
    com.tencent.mm.ui.vas.c.f afQs;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/vas/VASActionBar;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<b>
  {
    c(VASActivity paramVASActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.VASActivity
 * JD-Core Version:    0.7.0.1
 */