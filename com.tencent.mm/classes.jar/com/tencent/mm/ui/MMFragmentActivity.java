package com.tencent.mm.ui;

import android.content.ComponentName;
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
import android.view.MotionEvent;
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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b.a;
import com.tencent.mm.ag.b.b;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
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
import com.tencent.mm.ui.vas.f;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import com.tencent.mm.ui.widget.l;
import com.tencent.mm.ui.widget.l.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MMFragmentActivity
  extends GloUIComponentActivity
  implements SwipeBackLayout.b, l.a, com.tencent.mm.vending.e.b
{
  public static final long ANIMATION_DURATION = 260L;
  public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
  private static final String TAG = "MicroMsg.MMFragmentActivity";
  public static final float WIDTH_SETTLE_FACT = 3.5F;
  public static com.tencent.mm.ui.vas.d.a aReporter;
  private static List<MMFragmentActivity.d> interceptors;
  String className;
  private Resources customResources;
  private a mActivityAnimStyle;
  private View mContentViewForSwipeBack;
  private List<b> mDispatchedTouchListeners;
  private boolean mIsPaused;
  private com.tencent.mm.vending.a.a mLifeCycleKeeper;
  private MMFragmentActivity.e mNfcFilterHelper;
  private SwipeBackLayout mSwipeBackLayout;
  private boolean mSwiping;
  private MMFragmentActivity.c onActResult;
  ArrayList<WeakReference<MMFragment>> record;
  private boolean updateResource;
  
  static
  {
    AppMethodBeat.i(249094);
    interceptors = new CopyOnWriteArrayList();
    com.tencent.mm.ui.vas.d.a.a locala = com.tencent.mm.ui.vas.d.a.afRn;
    aReporter = com.tencent.mm.ui.vas.d.a.a.jEu();
    AppMethodBeat.o(249094);
  }
  
  public MMFragmentActivity()
  {
    AppMethodBeat.i(141406);
    this.record = new ArrayList();
    this.mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    this.onActResult = null;
    this.mActivityAnimStyle = new a();
    this.updateResource = false;
    this.mContentViewForSwipeBack = null;
    this.mDispatchedTouchListeners = new ArrayList();
    AppMethodBeat.o(141406);
  }
  
  public static void addInterceptor(MMFragmentActivity.d paramd)
  {
    AppMethodBeat.i(249068);
    interceptors.add(paramd);
    AppMethodBeat.o(249068);
  }
  
  private static int getSlideLeftInAnim()
  {
    return com.tencent.mm.ah.a.a.slide_left_in_ease;
  }
  
  private static int getSlideLeftOutAnim()
  {
    return com.tencent.mm.ah.a.a.slide_left_out_ease;
  }
  
  private static int getSlideRightInAnim()
  {
    return com.tencent.mm.ah.a.a.slide_right_in_ease;
  }
  
  private static int getSlideRightOutAnim()
  {
    return com.tencent.mm.ah.a.a.slide_right_out_ease;
  }
  
  public static boolean isVASActivity(Intent paramIntent)
  {
    AppMethodBeat.i(249071);
    if ((paramIntent != null) && (com.tencent.mm.ui.vas.c.isVASActivity(paramIntent)))
    {
      AppMethodBeat.o(249071);
      return true;
    }
    AppMethodBeat.o(249071);
    return false;
  }
  
  public void addDispatchedTouchListener(b paramb)
  {
    AppMethodBeat.i(249277);
    Iterator localIterator = this.mDispatchedTouchListeners.iterator();
    b localb;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (b)localIterator.next();
    } while ((localb != paramb) && (!localb.key().equals(paramb.key())));
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mDispatchedTouchListeners.add(paramb);
      }
      AppMethodBeat.o(249277);
      return;
    }
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
      if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null) && (localSwipeBackLayout.iMy()))
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(249284);
    Iterator localIterator = this.mDispatchedTouchListeners.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).n(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(249284);
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
  
  public int getActionBarHeightFromTheme()
  {
    AppMethodBeat.i(249248);
    int i = com.tencent.mm.compatible.util.a.di(this);
    AppMethodBeat.o(249248);
    return i;
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
        if (((this.customResources instanceof com.tencent.mm.ce.d)) && (localObject2 != null))
        {
          localObject1 = (com.tencent.mm.ce.d)this.customResources;
          localObject2 = ((com.tencent.mm.ce.d)localObject1).acma.h(((Resources)localObject2).getConfiguration());
          com.tencent.mm.ce.e.a((Configuration)localObject2, aw.f(this.customResources));
          ((com.tencent.mm.ce.d)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
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
    AppMethodBeat.i(249274);
    ActionBar localActionBar = com.tencent.mm.ui.widget.d.c(super.getSupportActionBar());
    AppMethodBeat.o(249274);
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
      paramString = af.b((LayoutInflater)localObject);
      AppMethodBeat.o(141447);
      return paramString;
    }
    AppMethodBeat.o(141447);
    return localObject;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(141457);
    Object localObject1;
    if (!isDestroyed())
    {
      localObject1 = super.getWindowManager();
      AppMethodBeat.o(141457);
      return localObject1;
    }
    try
    {
      localObject1 = new Throwable().getStackTrace();
      if ((localObject1 != null) && (localObject1.length >= 2) && (localObject1[1].getMethodName().equals("handleDestroyActivity")))
      {
        localObject1 = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
        AppMethodBeat.o(141457);
        return localObject1;
      }
    }
    finally
    {
      Log.e("MicroMsg.MMFragmentActivity", localObject2.getMessage());
      WindowManager localWindowManager = super.getWindowManager();
      AppMethodBeat.o(141457);
      return localWindowManager;
    }
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(249262);
    View localView = getCurrentFocus();
    if (localView == null)
    {
      hideVKB(getWindow().getDecorView());
      AppMethodBeat.o(249262);
      return;
    }
    hideVKB(localView);
    AppMethodBeat.o(249262);
  }
  
  public void hideVKB(View paramView)
  {
    AppMethodBeat.i(249267);
    if (paramView == null)
    {
      AppMethodBeat.o(249267);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(249267);
      return;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null)
    {
      AppMethodBeat.o(249267);
      return;
    }
    try
    {
      localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      AppMethodBeat.o(249267);
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      Log.e("MicroMsg.MMFragmentActivity", "hide VKB(View) exception %s", new Object[] { paramView });
      AppMethodBeat.o(249267);
    }
  }
  
  protected void initActivityCloseAnimation()
  {
    int i = 0;
    AppMethodBeat.i(141433);
    if (enableActivityAnimation())
    {
      if (com.tencent.mm.ui.base.b.cl(getClass()))
      {
        if (aw.jkS())
        {
          super.overridePendingTransition(0, 0);
          AppMethodBeat.o(141433);
          return;
        }
        super.overridePendingTransition(a.adFt, a.adFu);
        AppMethodBeat.o(141433);
        return;
      }
      if ((com.tencent.mm.ui.base.b.ci(getClass()) & 0x4) != 0) {
        i = 1;
      }
      if (i == 0)
      {
        com.tencent.mm.ui.base.b.nf(this);
        AppMethodBeat.o(141433);
        return;
      }
      com.tencent.mm.ui.base.b.ng(this);
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
        if ((com.tencent.mm.ui.base.b.bzW(paramIntent) & 0x2) != 0) {
          break label70;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (aw.jkS())
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
          super.overridePendingTransition(a.adFr, a.adFs);
          AppMethodBeat.o(141432);
          return;
        }
      }
      if (!com.tencent.mm.ui.base.b.bzY(paramIntent))
      {
        com.tencent.mm.ui.base.b.nd(this);
        AppMethodBeat.o(141432);
        return;
      }
      com.tencent.mm.ui.base.b.ng(this);
    }
    label114:
    AppMethodBeat.o(141432);
  }
  
  public boolean initNavigationSwipeBack()
  {
    AppMethodBeat.i(141445);
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      if ((!com.tencent.mm.ui.base.b.ck(getClass())) || (!convertActivityFromTranslucent())) {
        break label60;
      }
      if (MMHandlerThread.isMainThread()) {
        com.tencent.mm.ui.base.b.bZ(this);
      }
    }
    label60:
    label95:
    while (isSupportNavigationSwipeBack())
    {
      initSwipeBack();
      AppMethodBeat.o(141445);
      return true;
      if ((com.tencent.mm.ui.base.b.ci(getClass()) & 0x10) != 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!MMHandlerThread.isMainThread())) {
          break label95;
        }
        com.tencent.mm.ui.base.b.bZ(this);
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
  
  protected boolean isCallSuperOnSaveInstanceState()
  {
    return false;
  }
  
  public boolean isHideStatusBar()
  {
    AppMethodBeat.i(141444);
    if ((com.tencent.mm.ui.base.b.ci(getClass()) & 0x20) != 0)
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
    if ((com.tencent.mm.compatible.util.d.rb(19)) && (com.tencent.mm.compatible.h.a.aPR()))
    {
      if ((supportNavigationSwipeBack()) && (com.tencent.mm.ui.base.b.ck(getClass())))
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
    this.mLifeCycleKeeper.agtx.keep(parama);
    AppMethodBeat.o(141407);
  }
  
  public void mmStartActivityForResult(MMFragmentActivity.c paramc, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141458);
    this.onActResult = paramc;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(141458);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(141459);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.mmOnActivityResult(paramInt1, paramInt2, paramIntent);
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
            localLayoutParams.height = getActionBarHeightFromTheme();
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
    au.eb(3, this.className);
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
    this.mLifeCycleKeeper.agtx.dead();
    this.mDispatchedTouchListeners.clear();
    super.onDestroy();
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    try
    {
      if (b.a.mHW == null)
      {
        localObject1 = Class.forName("android.rms.iaware.FastgrabConfigReader");
        b.a.mHW = (Class)localObject1;
        localObject1 = ((Class)localObject1).getDeclaredField("mFastgrabConfigReader");
        b.a.field_mFastgrabConfigReader = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
        localObject1 = b.a.mHW.getDeclaredField("mContext");
        b.a.field_mContext = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = b.a.field_mFastgrabConfigReader.get(b.a.mHW);
      if (b.a.field_mContext.get(localObject1) == this) {
        b.a.field_mContext.set(localObject1, null);
      }
    }
    finally
    {
      Object localObject1;
      label177:
      break label177;
    }
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    for (;;)
    {
      try
      {
        if (b.b.clazz == null)
        {
          localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
          b.b.clazz = (Class)localObject1;
          localObject1 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
          b.b.mHX = (Field)localObject1;
          ((Field)localObject1).setAccessible(true);
          localObject1 = b.b.clazz.getDeclaredField("mContext");
          b.b.mHY = (Field)localObject1;
          ((Field)localObject1).setAccessible(true);
        }
        localObject1 = b.b.mHX.get(null);
        if (localObject1 != null) {
          b.b.mHY.set(localObject1, null);
        }
      }
      finally
      {
        continue;
      }
      try
      {
        if ((Build.VERSION.SDK_INT >= 23) && (Build.MANUFACTURER.equalsIgnoreCase("samsung")))
        {
          localObject1 = MMApplicationContext.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
          Field localField = localObject1.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localObject1, MMApplicationContext.getContext());
        }
        Log.i("MicroMsg.MMFragmentActivity", "Activity dump [%s]", new Object[] { com.tencent.mm.ag.a.bbZ() });
        AppMethodBeat.o(141410);
        return;
      }
      finally {}
    }
  }
  
  public void onDrag()
  {
    this.mSwiping = true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(141413);
    au.eb(2, this.className);
    this.mIsPaused = true;
    super.onPause();
    if (isSupportNavigationSwipeBack())
    {
      if (getSwipeBackLayout() != null) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      if (!isFinishing()) {
        l.a(this);
      }
    }
    MMFragmentActivity.e locale;
    if (this.mNfcFilterHelper != null)
    {
      locale = this.mNfcFilterHelper;
      if (locale.adFv == null) {}
    }
    try
    {
      Log.i("MicroMsg.MMFragmentActivity", "[NFC] disableForegroundDispatch");
      locale.adFv.disableForegroundDispatch(locale.adFp);
      this.mLifeCycleKeeper.agty.dead();
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
    au.eb(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      l.b(this);
      onSwipe(1.0F);
      if (getSwipeBackLayout() != null)
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().mqz = false;
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
    if ((Build.VERSION.SDK_INT < 11) || (isCallSuperOnSaveInstanceState())) {
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
      this.mContentViewForSwipeBack = aw.a(getWindow(), getSupportActionBar().getCustomView());
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
    this.mLifeCycleKeeper.agtz.dead();
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
        break label96;
      }
    }
    label96:
    for (View localView = getSupportActionBar().getCustomView();; localView = null)
    {
      this.mContentViewForSwipeBack = aw.a(localWindow, localView);
      localView = this.mContentViewForSwipeBack;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      k.r(localView, 0.0F);
      AppMethodBeat.o(141451);
      return;
    }
    k.r(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
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
      a.adFt = paramInt1;
      a.adFu = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(141430);
  }
  
  public void putActivityOpenAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141429);
    if (enableActivityAnimation())
    {
      a.adFr = paramInt1;
      a.adFs = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(141429);
  }
  
  public void removeDispatchedTouchListener(b paramb)
  {
    AppMethodBeat.i(249280);
    this.mDispatchedTouchListeners.remove(paramb);
    AppMethodBeat.o(249280);
  }
  
  public void setMMOnFragmentActivityResult(MMFragmentActivity.c paramc)
  {
    this.onActResult = paramc;
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
      AppMethodBeat.o(141450);
    }
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(249271);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(249271);
      return;
    }
    View localView = getCurrentFocus();
    if (localView == null)
    {
      AppMethodBeat.o(249271);
      return;
    }
    if (localView.getWindowToken() == null)
    {
      AppMethodBeat.o(249271);
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
    AppMethodBeat.o(249271);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(141436);
    super.startActivities(paramArrayOfIntent);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(141436);
  }
  
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
    Iterator localIterator = interceptors.iterator();
    while (localIterator.hasNext())
    {
      MMFragmentActivity.d locald = (MMFragmentActivity.d)localIterator.next();
      if (paramIntent.getComponent() != null) {}
      for (String str = paramIntent.getComponent().getClassName(); locald.e(this, Util.nullAsNil(str), paramIntent); str = "")
      {
        AppMethodBeat.o(141437);
        return;
      }
    }
    super.startActivity(paramIntent);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141437);
  }
  
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
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141440);
    Iterator localIterator = interceptors.iterator();
    while (localIterator.hasNext())
    {
      MMFragmentActivity.d locald = (MMFragmentActivity.d)localIterator.next();
      if (paramIntent.getComponent() != null) {}
      for (String str = paramIntent.getComponent().getClassName(); locald.e(this, Util.nullAsNil(str), paramIntent); str = "")
      {
        AppMethodBeat.o(141440);
        return;
      }
    }
    if (e.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle }))
    {
      AppMethodBeat.o(141440);
      return;
    }
    boolean bool = isVASActivity(paramIntent);
    aReporter.a(paramIntent, this, bool);
    if (bool) {
      startVASActivityForResult(paramIntent, paramInt, paramBundle);
    }
    for (;;)
    {
      initActivityOpenAnimation(paramIntent);
      AppMethodBeat.o(141440);
      return;
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
    }
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(249208);
    Iterator localIterator = interceptors.iterator();
    while (localIterator.hasNext())
    {
      MMFragmentActivity.d locald = (MMFragmentActivity.d)localIterator.next();
      if (paramIntent.getComponent() != null) {}
      for (String str = paramIntent.getComponent().getClassName(); locald.e(this, Util.nullAsNil(str), paramIntent); str = "")
      {
        AppMethodBeat.o(249208);
        return;
      }
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(249208);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(249213);
    Iterator localIterator = interceptors.iterator();
    while (localIterator.hasNext())
    {
      MMFragmentActivity.d locald = (MMFragmentActivity.d)localIterator.next();
      if (paramIntent.getComponent() != null) {}
      for (String str = paramIntent.getComponent().getClassName(); locald.e(this, Util.nullAsNil(str), paramIntent); str = "")
      {
        AppMethodBeat.o(249213);
        return;
      }
    }
    if (e.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { paramFragment, Integer.valueOf(paramInt) }))
    {
      AppMethodBeat.o(249213);
      return;
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(249213);
  }
  
  protected void startVASActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(249186);
    try
    {
      f.a(this, Class.forName(paramIntent.getComponent().getClassName()), paramIntent, paramBundle);
      return;
    }
    finally
    {
      AppMethodBeat.o(249186);
    }
  }
  
  protected void startVASActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(249193);
    try
    {
      f.a(this, Class.forName(paramIntent.getComponent().getClassName()), paramIntent, paramBundle, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(249193);
    }
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
    AppMethodBeat.i(249154);
    if ((paramFragment == null) || (paramInt1 == 0))
    {
      AppMethodBeat.o(249154);
      return;
    }
    FragmentManager localFragmentManager = getSupportFragmentManager();
    r localr = localFragmentManager.beginTransaction();
    if (paramBoolean2) {
      localr.aJ(paramInt2, paramInt3);
    }
    if (localFragmentManager.findFragmentById(paramInt1) != null) {
      if (paramFragment.isHidden()) {
        localr.c(paramFragment);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        localr.aI(null);
      }
      localr.FW();
      localFragmentManager.executePendingTransactions();
      AppMethodBeat.o(249154);
      return;
      localr.a(paramInt1, paramFragment, paramFragment.getTag());
    }
  }
  
  public void switchFragmentActivity(Fragment paramFragment)
  {
    AppMethodBeat.i(249147);
    if (paramFragment == null)
    {
      AppMethodBeat.o(249147);
      return;
    }
    switchFragmentActivity(paramFragment, paramFragment.getId());
    AppMethodBeat.o(249147);
  }
  
  public void switchFragmentActivity(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(249148);
    switchFragment(paramFragment, paramInt, true, true, com.tencent.mm.ah.a.a.pop_in, com.tencent.mm.ah.a.a.pop_out);
    this.record.add(new WeakReference((MMFragment)paramFragment));
    AppMethodBeat.o(249148);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(249137);
    switchFragmentInternalBackwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(249137);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(249139);
    switchFragment(paramFragment, paramInt, false, true, com.tencent.mm.ah.a.a.slide_left_in, com.tencent.mm.ah.a.a.slide_right_out);
    AppMethodBeat.o(249139);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, int paramInt, View paramView)
  {
    AppMethodBeat.i(249146);
    switchFragment(paramFragment, paramInt, false, true, 0, com.tencent.mm.ah.a.a.slide_right_out);
    if (paramView == null)
    {
      AppMethodBeat.o(249146);
      return;
    }
    paramFragment = AnimationUtils.loadAnimation(this, com.tencent.mm.ah.a.a.slide_left_in);
    if (paramFragment != null) {
      paramView.startAnimation(paramFragment);
    }
    paramView.setVisibility(0);
    AppMethodBeat.o(249146);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, View paramView)
  {
    AppMethodBeat.i(249143);
    if (paramFragment == null)
    {
      AppMethodBeat.o(249143);
      return;
    }
    switchFragmentInternalBackwardWithAnimLeftSelfView(paramFragment, paramFragment.getId(), paramView);
    AppMethodBeat.o(249143);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(249132);
    if (paramFragment == null)
    {
      AppMethodBeat.o(249132);
      return;
    }
    switchFragmentInternalFarwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(249132);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(249135);
    switchFragment(paramFragment, paramInt, false, true, com.tencent.mm.ah.a.a.slide_right_in, com.tencent.mm.ah.a.a.slide_left_out);
    AppMethodBeat.o(249135);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(249126);
    if (paramFragment == null)
    {
      AppMethodBeat.o(249126);
      return;
    }
    switchFragmentInternalWithoutAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(249126);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(249129);
    switchFragment(paramFragment, paramInt, false, false, 0, 0);
    AppMethodBeat.o(249129);
  }
  
  protected com.tencent.mm.vending.e.b theCreate()
  {
    return this.mLifeCycleKeeper.agtx;
  }
  
  protected com.tencent.mm.vending.e.b theResume()
  {
    return this.mLifeCycleKeeper.agty;
  }
  
  protected com.tencent.mm.vending.e.b theStart()
  {
    return this.mLifeCycleKeeper.agty;
  }
  
  public static class a
  {
    public static int adFr;
    public static int adFs;
    public static int adFt;
    public static int adFu;
    public static int upU;
    public static int upV;
    public static int upW;
    public static int upX;
    
    static
    {
      AppMethodBeat.i(141404);
      boolean bool2 = com.tencent.mm.compatible.util.d.rb(19);
      boolean bool1 = com.tencent.mm.compatible.h.a.aPR() & bool2;
      if (bool1)
      {
        i = com.tencent.mm.ah.a.a.slide_right_in;
        upU = i;
        if (!bool1) {
          break label102;
        }
        i = com.tencent.mm.ah.a.a.slide_left_out;
        label37:
        upV = i;
        if (!bool1) {
          break label109;
        }
        i = com.tencent.mm.ah.a.a.slide_left_in;
        label49:
        upW = i;
        if (!bool1) {
          break label116;
        }
      }
      label102:
      label109:
      label116:
      for (int i = com.tencent.mm.ah.a.a.slide_right_out;; i = com.tencent.mm.ah.a.a.pop_out)
      {
        upX = i;
        adFr = upU;
        adFs = upV;
        adFt = upW;
        adFu = upX;
        AppMethodBeat.o(141404);
        return;
        i = com.tencent.mm.ah.a.a.pop_in;
        break;
        i = com.tencent.mm.ah.a.a.anim_not_change;
        break label37;
        i = com.tencent.mm.ah.a.a.anim_not_change;
        break label49;
      }
    }
    
    public static void jka()
    {
      AppMethodBeat.i(141403);
      z localz = com.tencent.mm.compatible.deviceinfo.af.lYd;
      boolean bool = z.aPB();
      Log.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(bool)));
      if (bool)
      {
        bool = com.tencent.mm.compatible.util.d.rb(19);
        bool = com.tencent.mm.compatible.h.a.aPR() & bool;
        Log.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(bool)));
        if (!bool) {
          break label135;
        }
        i = MMFragmentActivity.access$200();
        upU = i;
        if (!bool) {
          break label142;
        }
        i = MMFragmentActivity.access$300();
        label77:
        upV = i;
        if (!bool) {
          break label149;
        }
        i = MMFragmentActivity.access$400();
        label89:
        upW = i;
        if (!bool) {
          break label156;
        }
      }
      label135:
      label142:
      label149:
      label156:
      for (int i = MMFragmentActivity.access$500();; i = com.tencent.mm.ah.a.a.pop_out)
      {
        upX = i;
        adFr = upU;
        adFs = upV;
        adFt = upW;
        adFu = upX;
        AppMethodBeat.o(141403);
        return;
        i = com.tencent.mm.ah.a.a.pop_in;
        break;
        i = com.tencent.mm.ah.a.a.anim_not_change;
        break label77;
        i = com.tencent.mm.ah.a.a.anim_not_change;
        break label89;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract String key();
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity
 * JD-Core Version:    0.7.0.1
 */