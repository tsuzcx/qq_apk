package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b.a;
import com.tencent.mm.ag.b.b;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.glocom.GloUIComponentActivity;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.j;
import com.tencent.mm.ui.widget.j.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MMFragmentActivity
  extends GloUIComponentActivity
  implements SwipeBackLayout.a, j.a, com.tencent.mm.vending.e.b
{
  public static final long ANIMATION_DURATION = 260L;
  public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
  private static final String TAG = "MicroMsg.MMFragmentActivity";
  public static final float WIDTH_SETTLE_FACT = 3.5F;
  String className;
  private Resources customResources;
  private a mActivityAnimStyle;
  private View mContentViewForSwipeBack;
  private boolean mIsPaused;
  private com.tencent.mm.vending.a.a mLifeCycleKeeper;
  private MMFragmentActivity.c mNfcFilterHelper;
  private SwipeBackLayout mSwipeBackLayout;
  private boolean mSwiping;
  private MMFragmentActivity.b onActResult;
  ArrayList<WeakReference<MMFragment>> record;
  private boolean updateResource;
  
  public MMFragmentActivity()
  {
    AppMethodBeat.i(141406);
    this.record = new ArrayList();
    this.mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    this.onActResult = null;
    this.mActivityAnimStyle = new a();
    this.updateResource = false;
    this.mContentViewForSwipeBack = null;
    AppMethodBeat.o(141406);
  }
  
  public String appendMemLog()
  {
    AppMethodBeat.i(141409);
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    String str = String.format("Runtime: [%s:%s:%s] Native: [%s:%s:%s] ", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize()) });
    AppMethodBeat.o(141409);
    return str;
  }
  
  protected boolean convertActivityFromTranslucent()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141454);
    if (isSupportNavigationSwipeBack())
    {
      SwipeBackLayout localSwipeBackLayout = getSwipeBackLayout();
      if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null) && (localSwipeBackLayout.hlH()))
      {
        Log.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        AppMethodBeat.o(141454);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(141454);
    return bool;
  }
  
  public boolean enableActivityAnimation()
  {
    AppMethodBeat.i(141431);
    Intent localIntent = getIntent();
    if (localIntent != null) {}
    for (boolean bool = IntentUtil.getBooleanExtra(localIntent, "extra_use_system_default_enter_exit_anim", false);; bool = false)
    {
      if (bool)
      {
        AppMethodBeat.o(141431);
        return false;
      }
      AppMethodBeat.o(141431);
      return true;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(141434);
    super.finish();
    initActivityCloseAnimation();
    AppMethodBeat.o(141434);
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public MMFragment getCurrentFragmet()
  {
    AppMethodBeat.i(141427);
    int i = this.record.size();
    if (i == 0)
    {
      AppMethodBeat.o(141427);
      return null;
    }
    MMFragment localMMFragment = (MMFragment)((WeakReference)this.record.get(i - 1)).get();
    if ((localMMFragment != null) && (localMMFragment.isShowing()))
    {
      AppMethodBeat.o(141427);
      return localMMFragment;
    }
    AppMethodBeat.o(141427);
    return null;
  }
  
  public final Resources getOriginalResources()
  {
    AppMethodBeat.i(141449);
    Resources localResources = super.getResources();
    AppMethodBeat.o(141449);
    return localResources;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(141448);
    if ((getAssets() != null) && (MMApplicationContext.getResources() != null))
    {
      if ((!this.updateResource) || (this.customResources == null))
      {
        Object localObject2 = getBaseContext().getResources();
        this.customResources = MMApplicationContext.getResources();
        if (((this.customResources instanceof com.tencent.mm.cj.b)) && (localObject2 != null))
        {
          localObject1 = (com.tencent.mm.cj.b)this.customResources;
          localObject2 = ((com.tencent.mm.cj.b)localObject1).UQL.f(((Resources)localObject2).getConfiguration());
          com.tencent.mm.cj.c.a((Configuration)localObject2, ar.f(this.customResources));
          ((com.tencent.mm.cj.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
          this.customResources = ((Resources)localObject1);
          this.updateResource = true;
        }
      }
      localObject1 = this.customResources;
      AppMethodBeat.o(141448);
      return localObject1;
    }
    Object localObject1 = super.getResources();
    AppMethodBeat.o(141448);
    return localObject1;
  }
  
  public ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(187847);
    ActionBar localActionBar = com.tencent.mm.ui.widget.d.c(super.getSupportActionBar());
    AppMethodBeat.o(187847);
    return localActionBar;
  }
  
  public SwipeBackLayout getSwipeBackLayout()
  {
    return this.mSwipeBackLayout;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(141447);
    if ((("clipboard".equals(paramString)) || ("power".equals(paramString))) && (getApplicationContext() != null))
    {
      paramString = getApplicationContext().getSystemService(paramString);
      AppMethodBeat.o(141447);
      return paramString;
    }
    Object localObject = super.getSystemService(paramString);
    if ("layout_inflater".equals(paramString))
    {
      paramString = ad.b((LayoutInflater)localObject);
      AppMethodBeat.o(141447);
      return paramString;
    }
    AppMethodBeat.o(141447);
    return localObject;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(141457);
    Object localObject;
    if (!isDestroyed())
    {
      localObject = super.getWindowManager();
      AppMethodBeat.o(141457);
      return localObject;
    }
    try
    {
      localObject = new Throwable().getStackTrace();
      if ((localObject != null) && (localObject.length >= 2) && (localObject[1].getMethodName().equals("handleDestroyActivity")))
      {
        localObject = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
        AppMethodBeat.o(141457);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MMFragmentActivity", localThrowable.getMessage());
      WindowManager localWindowManager = super.getWindowManager();
      AppMethodBeat.o(141457);
      return localWindowManager;
    }
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(187841);
    View localView = getCurrentFocus();
    if (localView == null)
    {
      hideVKB(getWindow().getDecorView());
      AppMethodBeat.o(187841);
      return;
    }
    hideVKB(localView);
    AppMethodBeat.o(187841);
  }
  
  public void hideVKB(View paramView)
  {
    AppMethodBeat.i(187843);
    if (paramView == null)
    {
      AppMethodBeat.o(187843);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(187843);
      return;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null)
    {
      AppMethodBeat.o(187843);
      return;
    }
    try
    {
      localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      AppMethodBeat.o(187843);
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      Log.e("MicroMsg.MMFragmentActivity", "hide VKB(View) exception %s", new Object[] { paramView });
      AppMethodBeat.o(187843);
    }
  }
  
  protected void initActivityCloseAnimation()
  {
    int i = 0;
    AppMethodBeat.i(141433);
    if (enableActivityAnimation())
    {
      if (com.tencent.mm.ui.base.b.bB(getClass()))
      {
        if (ar.hIH())
        {
          super.overridePendingTransition(0, 0);
          AppMethodBeat.o(141433);
          return;
        }
        super.overridePendingTransition(a.WaY, a.WaZ);
        AppMethodBeat.o(141433);
        return;
      }
      if ((com.tencent.mm.ui.base.b.by(getClass()) & 0x4) != 0) {
        i = 1;
      }
      if (i == 0)
      {
        com.tencent.mm.ui.base.b.lb(this);
        AppMethodBeat.o(141433);
        return;
      }
      com.tencent.mm.ui.base.b.lc(this);
    }
    AppMethodBeat.o(141433);
  }
  
  protected void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(141432);
    if (enableActivityAnimation())
    {
      int i;
      if (paramIntent == null)
      {
        paramIntent = null;
        if (paramIntent == null) {
          break label114;
        }
        paramIntent = com.tencent.mm.ui.base.b.f(paramIntent);
        if ((com.tencent.mm.ui.base.b.byy(paramIntent) & 0x2) != 0) {
          break label70;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (ar.hIH())
          {
            super.overridePendingTransition(0, 0);
            AppMethodBeat.o(141432);
            return;
            paramIntent = paramIntent.getComponent();
            break;
            label70:
            i = 0;
            continue;
          }
          super.overridePendingTransition(a.WaW, a.WaX);
          AppMethodBeat.o(141432);
          return;
        }
      }
      if (!com.tencent.mm.ui.base.b.byA(paramIntent))
      {
        com.tencent.mm.ui.base.b.kZ(this);
        AppMethodBeat.o(141432);
        return;
      }
      com.tencent.mm.ui.base.b.lc(this);
    }
    label114:
    AppMethodBeat.o(141432);
  }
  
  public boolean initNavigationSwipeBack()
  {
    AppMethodBeat.i(141445);
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      if ((!com.tencent.mm.ui.base.b.bA(getClass())) || (!convertActivityFromTranslucent())) {
        break label60;
      }
      if (MMHandlerThread.isMainThread()) {
        com.tencent.mm.ui.base.b.bv(this);
      }
    }
    label60:
    label95:
    while (isSupportNavigationSwipeBack())
    {
      initSwipeBack();
      AppMethodBeat.o(141445);
      return true;
      if ((com.tencent.mm.ui.base.b.by(getClass()) & 0x10) != 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!MMHandlerThread.isMainThread())) {
          break label95;
        }
        com.tencent.mm.ui.base.b.bv(this);
        break;
      }
    }
    AppMethodBeat.o(141445);
    return false;
  }
  
  protected void initSwipeBack()
  {
    AppMethodBeat.i(141446);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(this).inflate(a.h.swipeback_layout, localViewGroup, false));
    this.mSwipeBackLayout.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    View localView = localViewGroup.getChildAt(0);
    localView.setBackgroundResource(a.d.transparent);
    localViewGroup.removeView(localView);
    this.mSwipeBackLayout.addView(localView);
    this.mSwipeBackLayout.setContentView(localView);
    localViewGroup.addView(this.mSwipeBackLayout);
    this.mSwipeBackLayout.setSwipeGestureDelegate(this);
    AppMethodBeat.o(141446);
  }
  
  public boolean isHideStatusBar()
  {
    AppMethodBeat.i(141444);
    if ((com.tencent.mm.ui.base.b.by(getClass()) & 0x20) != 0)
    {
      AppMethodBeat.o(141444);
      return true;
    }
    AppMethodBeat.o(141444);
    return false;
  }
  
  public boolean isNfcFilterEnabled()
  {
    return true;
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(141443);
    if ((com.tencent.mm.compatible.util.d.qV(19)) && (com.tencent.mm.compatible.h.b.avx()))
    {
      if ((supportNavigationSwipeBack()) && (com.tencent.mm.ui.base.b.bA(getClass())))
      {
        AppMethodBeat.o(141443);
        return true;
      }
      AppMethodBeat.o(141443);
      return false;
    }
    AppMethodBeat.o(141443);
    return false;
  }
  
  public boolean isSwiping()
  {
    return this.mSwiping;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(141407);
    this.mLifeCycleKeeper.YyZ.keep(parama);
    AppMethodBeat.o(141407);
  }
  
  public void mmStartActivityForResult(MMFragmentActivity.b paramb, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141458);
    this.onActResult = paramb;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(141458);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(141459);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.d(paramInt1, paramInt2, paramIntent);
    }
    this.onActResult = null;
    AppMethodBeat.o(141459);
  }
  
  public void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141455);
    super.onConfigurationChanged(paramConfiguration);
    if (getSupportActionBar() != null)
    {
      paramConfiguration = (ViewGroup)findViewById(a.g.decor_content_parent);
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.findViewById(a.g.action_bar);
        if ((paramConfiguration != null) && ((paramConfiguration instanceof Toolbar)))
        {
          paramConfiguration = (Toolbar)paramConfiguration;
          ViewGroup.LayoutParams localLayoutParams = paramConfiguration.getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.height = com.tencent.mm.compatible.util.a.cu(this);
          }
          paramConfiguration.setLayoutParams(localLayoutParams);
        }
      }
    }
    AppMethodBeat.o(141455);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(141408);
    this.className = getClass().getName();
    ap.dk(3, this.className);
    super.onCreate(paramBundle);
    if (isNfcFilterEnabled())
    {
      paramBundle = new MMFragmentActivity.1(this);
      if ((ChannelUtil.shouldShowGprsAlert) && (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true))) {
        break label143;
      }
      paramBundle.run();
    }
    for (;;)
    {
      Log.i("MicroMsg.MMFragmentActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this), appendMemLog() });
      AppMethodBeat.o(141408);
      return;
      label143:
      keep(new MMFragmentActivity.2(this, paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(141410);
    Log.i("MicroMsg.MMFragmentActivity", "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this), appendMemLog() });
    this.mLifeCycleKeeper.YyZ.dead();
    super.onDestroy();
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    try
    {
      if (b.a.khy == null)
      {
        localObject = Class.forName("android.rms.iaware.FastgrabConfigReader");
        b.a.khy = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("mFastgrabConfigReader");
        b.a.field_mFastgrabConfigReader = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = b.a.khy.getDeclaredField("mContext");
        b.a.field_mContext = (Field)localObject;
        ((Field)localObject).setAccessible(true);
      }
      localObject = b.a.field_mFastgrabConfigReader.get(b.a.khy);
      if (b.a.field_mContext.get(localObject) == this) {
        b.a.field_mContext.set(localObject, null);
      }
    }
    catch (Throwable localThrowable3)
    {
      Object localObject;
      label168:
      break label168;
    }
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    for (;;)
    {
      try
      {
        if (b.b.aFS == null)
        {
          localObject = Class.forName("android.gestureboost.GestureBoostManager");
          b.b.aFS = (Class)localObject;
          localObject = ((Class)localObject).getDeclaredField("sGestureBoostManager");
          b.b.khz = (Field)localObject;
          ((Field)localObject).setAccessible(true);
          localObject = b.b.aFS.getDeclaredField("mContext");
          b.b.khA = (Field)localObject;
          ((Field)localObject).setAccessible(true);
        }
        localObject = b.b.khz.get(null);
        if (localObject != null) {
          b.b.khA.set(localObject, null);
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      try
      {
        if ((Build.VERSION.SDK_INT >= 23) && (Build.MANUFACTURER.equalsIgnoreCase("samsung")))
        {
          localObject = MMApplicationContext.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
          Field localField = localObject.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localObject, MMApplicationContext.getContext());
        }
        Log.i("MicroMsg.MMFragmentActivity", "Activity dump [%s]", new Object[] { com.tencent.mm.ag.a.aJc() });
        AppMethodBeat.o(141410);
        return;
      }
      catch (Throwable localThrowable1) {}
    }
  }
  
  public void onDrag()
  {
    this.mSwiping = true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(141413);
    ap.dk(2, this.className);
    this.mIsPaused = true;
    super.onPause();
    if (isSupportNavigationSwipeBack())
    {
      if (getSwipeBackLayout() != null) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      if (!isFinishing()) {
        j.a(this);
      }
    }
    MMFragmentActivity.c localc;
    if (this.mNfcFilterHelper != null)
    {
      localc = this.mNfcFilterHelper;
      if (localc.Wba == null) {}
    }
    try
    {
      Log.i("MicroMsg.MMFragmentActivity", "[NFC] disableForegroundDispatch");
      localc.Wba.disableForegroundDispatch(localc.WaU);
      this.mLifeCycleKeeper.Yza.dead();
      AppMethodBeat.o(141413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + localException.getLocalizedMessage());
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(141414);
    ap.dk(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      j.b(this);
      onSwipe(1.0F);
      if (getSwipeBackLayout() != null)
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().jRp = false;
      }
    }
    if (this.mNfcFilterHelper != null) {
      this.mNfcFilterHelper.onResume();
    }
    AppMethodBeat.o(141414);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(141428);
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(141428);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(141452);
    Log.v("ashutest", "ashutest:: on settle %B, speed %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.mContentViewForSwipeBack == null) {
      this.mContentViewForSwipeBack = ar.a(getWindow(), getSupportActionBar().getCustomView());
    }
    View localView = this.mContentViewForSwipeBack;
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        k.a(localView, l, 0.0F, null);
        AppMethodBeat.o(141452);
        return;
        l = 260L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      k.a(localView, l, localView.getWidth() * -1 / 3.5F, null);
      AppMethodBeat.o(141452);
      return;
      l = 260L;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(141412);
    super.onStart();
    AppMethodBeat.o(141412);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(141411);
    this.mLifeCycleKeeper.Yzb.dead();
    super.onStop();
    AppMethodBeat.o(141411);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(141451);
    Log.v("ashutest", "ashutest::on swipe %f, duration %d", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L) });
    Window localWindow;
    if (this.mContentViewForSwipeBack == null)
    {
      localWindow = getWindow();
      if (getSupportActionBar() == null) {
        break label95;
      }
    }
    label95:
    for (View localView = getSupportActionBar().getCustomView();; localView = null)
    {
      this.mContentViewForSwipeBack = ar.a(localWindow, localView);
      localView = this.mContentViewForSwipeBack;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      k.q(localView, 0.0F);
      AppMethodBeat.o(141451);
      return;
    }
    k.q(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(141451);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(141453);
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
    AppMethodBeat.o(141453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean popBackStackImmediate()
  {
    AppMethodBeat.i(141425);
    if (this.record.size() == 0)
    {
      AppMethodBeat.o(141425);
      return false;
    }
    this.record.remove(this.record.size() - 1);
    boolean bool = getSupportFragmentManager().popBackStackImmediate();
    AppMethodBeat.o(141425);
    return bool;
  }
  
  public void putActivityCloseAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141430);
    if (enableActivityAnimation())
    {
      a.WaY = paramInt1;
      a.WaZ = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(141430);
  }
  
  public void putActivityOpenAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141429);
    if (enableActivityAnimation())
    {
      a.WaW = paramInt1;
      a.WaX = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(141429);
  }
  
  public void setMMOnFragmentActivityResult(MMFragmentActivity.b paramb)
  {
    this.onActResult = paramb;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(141450);
    if (!AndroidOSafety.safety(this, paramInt))
    {
      Log.e("MicroMsg.MMFragmentActivity", "AndroidOSafety.safety false ignore setRequestedOrientation %s for activity %s", new Object[] { Integer.valueOf(paramInt), this });
      AppMethodBeat.o(141450);
      return;
    }
    try
    {
      super.setRequestedOrientation(paramInt);
      AppMethodBeat.o(141450);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
      AppMethodBeat.o(141450);
    }
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(187844);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(187844);
      return;
    }
    View localView = getCurrentFocus();
    if (localView == null)
    {
      AppMethodBeat.o(187844);
      return;
    }
    if (localView.getWindowToken() == null)
    {
      AppMethodBeat.o(187844);
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
    AppMethodBeat.o(187844);
  }
  
  @TargetApi(11)
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(141436);
    super.startActivities(paramArrayOfIntent);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(141436);
  }
  
  @TargetApi(16)
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(141435);
    if (e.a(this, this.mIsPaused, paramArrayOfIntent, new Object[] { paramBundle }))
    {
      AppMethodBeat.o(141435);
      return;
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(141435);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(141437);
    super.startActivity(paramIntent);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141437);
  }
  
  @TargetApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(141438);
    super.startActivity(paramIntent, paramBundle);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141438);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141439);
    super.startActivityForResult(paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141439);
  }
  
  @TargetApi(16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141440);
    if (e.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle }))
    {
      AppMethodBeat.o(141440);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141440);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(187829);
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(187829);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(187830);
    if (e.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { paramFragment, Integer.valueOf(paramInt) }))
    {
      AppMethodBeat.o(187830);
      return;
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(187830);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141456);
    if ((getCurrentFragmet() != null) && (getCurrentFragmet().interceptSupportInvalidateOptionsMenu()))
    {
      AppMethodBeat.o(141456);
      return;
    }
    super.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141456);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return true;
  }
  
  public void switchFragment(Fragment paramFragment, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187821);
    if ((paramFragment == null) || (paramInt1 == 0))
    {
      AppMethodBeat.o(187821);
      return;
    }
    androidx.fragment.app.e locale = getSupportFragmentManager();
    i locali = locale.beginTransaction();
    if (paramBoolean2) {
      locali.O(paramInt2, paramInt3);
    }
    if (locale.findFragmentById(paramInt1) != null) {
      if (paramFragment.isHidden()) {
        locali.c(paramFragment);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        locali.ik();
      }
      locali.in();
      locale.executePendingTransactions();
      AppMethodBeat.o(187821);
      return;
      locali.a(paramInt1, paramFragment, paramFragment.getTag());
    }
  }
  
  public void switchFragmentActivity(Fragment paramFragment)
  {
    AppMethodBeat.i(187817);
    if (paramFragment == null)
    {
      AppMethodBeat.o(187817);
      return;
    }
    switchFragmentActivity(paramFragment, paramFragment.getId());
    AppMethodBeat.o(187817);
  }
  
  public void switchFragmentActivity(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(187819);
    switchFragment(paramFragment, paramInt, true, true, a.a.pop_in, a.a.pop_out);
    this.record.add(new WeakReference((MMFragment)paramFragment));
    AppMethodBeat.o(187819);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(187812);
    switchFragmentInternalBackwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(187812);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(187813);
    switchFragment(paramFragment, paramInt, false, true, a.a.slide_left_in, a.a.slide_right_out);
    AppMethodBeat.o(187813);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, int paramInt, View paramView)
  {
    AppMethodBeat.i(187816);
    switchFragment(paramFragment, paramInt, false, true, 0, a.a.slide_right_out);
    if (paramView == null)
    {
      AppMethodBeat.o(187816);
      return;
    }
    paramFragment = AnimationUtils.loadAnimation(this, a.a.slide_left_in);
    if (paramFragment != null) {
      paramView.startAnimation(paramFragment);
    }
    paramView.setVisibility(0);
    AppMethodBeat.o(187816);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, View paramView)
  {
    AppMethodBeat.i(187815);
    if (paramFragment == null)
    {
      AppMethodBeat.o(187815);
      return;
    }
    switchFragmentInternalBackwardWithAnimLeftSelfView(paramFragment, paramFragment.getId(), paramView);
    AppMethodBeat.o(187815);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(187810);
    if (paramFragment == null)
    {
      AppMethodBeat.o(187810);
      return;
    }
    switchFragmentInternalFarwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(187810);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(187811);
    switchFragment(paramFragment, paramInt, false, true, a.a.slide_right_in, a.a.slide_left_out);
    AppMethodBeat.o(187811);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(187807);
    if (paramFragment == null)
    {
      AppMethodBeat.o(187807);
      return;
    }
    switchFragmentInternalWithoutAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(187807);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(187809);
    switchFragment(paramFragment, paramInt, false, false, 0, 0);
    AppMethodBeat.o(187809);
  }
  
  protected com.tencent.mm.vending.e.b theCreate()
  {
    return this.mLifeCycleKeeper.YyZ;
  }
  
  protected com.tencent.mm.vending.e.b theResume()
  {
    return this.mLifeCycleKeeper.Yza;
  }
  
  protected com.tencent.mm.vending.e.b theStart()
  {
    return this.mLifeCycleKeeper.Yza;
  }
  
  public static class a
  {
    public static int WaW;
    public static int WaX;
    public static int WaY;
    public static int WaZ;
    public static int rhY;
    public static int rhZ;
    public static int ria;
    public static int rib;
    
    static
    {
      AppMethodBeat.i(141404);
      boolean bool2 = com.tencent.mm.compatible.util.d.qV(19);
      boolean bool1 = com.tencent.mm.compatible.h.b.avx() & bool2;
      if (bool1)
      {
        i = a.a.slide_right_in;
        rhY = i;
        if (!bool1) {
          break label102;
        }
        i = a.a.slide_left_out;
        label37:
        rhZ = i;
        if (!bool1) {
          break label109;
        }
        i = a.a.slide_left_in;
        label49:
        ria = i;
        if (!bool1) {
          break label116;
        }
      }
      label102:
      label109:
      label116:
      for (int i = a.a.slide_right_out;; i = a.a.pop_out)
      {
        rib = i;
        WaW = rhY;
        WaX = rhZ;
        WaY = ria;
        WaZ = rib;
        AppMethodBeat.o(141404);
        return;
        i = a.a.pop_in;
        break;
        i = a.a.anim_not_change;
        break label37;
        i = a.a.anim_not_change;
        break label49;
      }
    }
    
    public static void hHS()
    {
      AppMethodBeat.i(141403);
      z localz = af.juM;
      boolean bool = z.avg();
      Log.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(bool)));
      if (!bool)
      {
        AppMethodBeat.o(141403);
        return;
      }
      bool = com.tencent.mm.compatible.util.d.qV(19);
      bool = com.tencent.mm.compatible.h.b.avx() & bool;
      Log.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(bool)));
      if (bool)
      {
        i = a.a.slide_right_in;
        rhY = i;
        if (!bool) {
          break label148;
        }
        i = a.a.slide_left_out;
        label83:
        rhZ = i;
        if (!bool) {
          break label155;
        }
        i = a.a.slide_left_in;
        label95:
        ria = i;
        if (!bool) {
          break label162;
        }
      }
      label148:
      label155:
      label162:
      for (int i = a.a.slide_right_out;; i = a.a.pop_out)
      {
        rib = i;
        WaW = rhY;
        WaX = rhZ;
        WaY = ria;
        WaZ = rib;
        AppMethodBeat.o(141403);
        return;
        i = a.a.pop_in;
        break;
        i = a.a.anim_not_change;
        break label83;
        i = a.a.anim_not_change;
        break label95;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity
 * JD-Core Version:    0.7.0.1
 */