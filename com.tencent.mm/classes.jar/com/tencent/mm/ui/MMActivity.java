package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity
  extends MMFragmentActivity
  implements com.tencent.mm.plugin.appbrand.widget.input.ad
{
  private static final int ANDROID_API_LEVEL_11 = 11;
  protected static final int DEFAULT_TOAST_TIME = 3000;
  public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
  public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
  private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
  private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
  private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
  private static final String TAG = "MicroMsg.MMActivity";
  private static final String TAG2 = "MicroMsg.INIT";
  private static String sNavBarOverride;
  String className;
  boolean customfixStatusbar = false;
  boolean fixStatusbar = false;
  protected boolean landscapeMode = false;
  private long lastBrowseTime = 0L;
  private long lastOnPauseTicks = 0L;
  private long lastOnResumeTicks = 0L;
  public q mController = new q()
  {
    protected final void dealContentView(View paramAnonymousView)
    {
      AppMethodBeat.i(105986);
      MMActivity.this.dealContentView(paramAnonymousView);
      AppMethodBeat.o(105986);
    }
    
    protected final boolean fromFullScreenActivity()
    {
      AppMethodBeat.i(105991);
      boolean bool = MMActivity.this.fromFullScreenActivity();
      AppMethodBeat.o(105991);
      return bool;
    }
    
    protected final String getClassName()
    {
      AppMethodBeat.i(105990);
      String str = MMActivity.this.getClass().getName();
      AppMethodBeat.o(105990);
      return str;
    }
    
    protected final String getIdentString()
    {
      AppMethodBeat.i(105987);
      String str = MMActivity.this.getIdentString();
      AppMethodBeat.o(105987);
      return str;
    }
    
    protected final int getLayoutId()
    {
      AppMethodBeat.i(105985);
      int i = MMActivity.this.getLayoutId();
      AppMethodBeat.o(105985);
      return i;
    }
    
    protected final View getLayoutView()
    {
      AppMethodBeat.i(142716);
      View localView = MMActivity.this.getLayoutView();
      AppMethodBeat.o(142716);
      return localView;
    }
    
    public final boolean needShowIdcError()
    {
      AppMethodBeat.i(105993);
      boolean bool = MMActivity.this.needShowIdcError();
      AppMethodBeat.o(105993);
      return bool;
    }
    
    public final boolean noActionBar()
    {
      AppMethodBeat.i(105992);
      boolean bool = MMActivity.this.noActionBar();
      AppMethodBeat.o(105992);
      return bool;
    }
    
    protected final void onCreateBeforeSetContentView()
    {
      AppMethodBeat.i(105989);
      MMActivity.this.onCreateBeforeSetContentView();
      AppMethodBeat.o(105989);
    }
    
    public final void onKeyboardStateChanged()
    {
      AppMethodBeat.i(105988);
      MMActivity.this.onKeyboardStateChanged();
      AppMethodBeat.o(105988);
    }
  };
  private View mSelfNavigationBar;
  private ViewGroup mWrappingFrame = null;
  private a onActResult = null;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      sNavBarOverride = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return;
    }
    catch (Throwable localThrowable)
    {
      sNavBarOverride = null;
    }
  }
  
  private int getInternalDimensionSize(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return q.initLanguage(paramContext);
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    return q.initLanguage(paramContext, paramString);
  }
  
  private void noteOnPauseTicks()
  {
    this.lastOnPauseTicks = bo.yB();
  }
  
  private void noteOnResumeTicks()
  {
    if (this.lastOnPauseTicks > this.lastOnResumeTicks) {
      this.lastBrowseTime += this.lastOnPauseTicks - this.lastOnResumeTicks;
    }
    this.lastOnResumeTicks = bo.yB();
    this.lastOnPauseTicks = 0L;
  }
  
  public static void setMainProcess() {}
  
  public static void showVKB(Activity paramActivity)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (localInputMethodManager == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getCurrentFocus();
    } while ((paramActivity == null) || (paramActivity.getWindowToken() == null));
    localInputMethodManager.toggleSoftInput(0, 2);
  }
  
  protected <T> T $(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public void activateBroadcast(boolean paramBoolean)
  {
    this.mController.activateBroadcast(paramBoolean);
  }
  
  public boolean activityHasDestroyed()
  {
    return isDestroyed();
  }
  
  public void addDialog(Dialog paramDialog)
  {
    this.mController.addDialog(paramDialog);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramBoolean, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, getString(paramInt2), paramDrawable, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramString, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt, paramString, paramDrawable, paramOnMenuItemClickListener);
  }
  
  public void addSearchMenu(boolean paramBoolean, com.tencent.mm.ui.tools.q paramq)
  {
    this.mController.addSearchMenu(paramBoolean, paramq);
  }
  
  public void addTextOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    q localq = this.mController;
    q.b localb = q.b.zbx;
    q.a locala = new q.a();
    locala.yUo = paramInt1;
    locala.text = paramString;
    locala.textColor = paramInt2;
    locala.gBC = paramOnMenuItemClickListener;
    locala.mAd = null;
    locala.zbv = localb;
    localq.Of(locala.yUo);
    localq.yUg.add(locala);
    new ak().postDelayed(new q.10(localq), 200L);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, View.OnTouchListener paramOnTouchListener, q.b paramb)
  {
    q localq = this.mController;
    q.a locala = new q.a();
    locala.yUo = paramInt;
    locala.yUp = 0;
    locala.text = paramString;
    locala.gBC = paramOnMenuItemClickListener;
    locala.mAd = paramOnLongClickListener;
    locala.jVU = paramOnTouchListener;
    locala.zbv = paramb;
    locala.zbw = false;
    if ((locala.yUp == 2130839668) && (bo.isNullOrNil(paramString))) {
      locala.text = localq.mContext.getString(2131296998);
    }
    localq.Of(locala.yUo);
    localq.yUg.add(locala);
    localq.supportInvalidateOptionsMenu();
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, q.b paramb)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public boolean callBackMenu()
  {
    return this.mController.callBackMenu();
  }
  
  @Deprecated
  public void customfixStatusbar(boolean paramBoolean)
  {
    this.customfixStatusbar = paramBoolean;
  }
  
  protected void dealContentView(View paramView)
  {
    setContentView(paramView);
  }
  
  public void disableMultiTouch()
  {
    if (this.mController != null) {
      this.mController.disableMultiTouch();
    }
  }
  
  public void enableBackMenu(boolean paramBoolean)
  {
    this.mController.enableBackMenu(paramBoolean);
  }
  
  public void enableMultiTouch()
  {
    if (this.mController != null) {
      this.mController.enableMultiTouch();
    }
  }
  
  public void enableOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.d(false, paramInt, paramBoolean);
  }
  
  public void enableOptionMenu(boolean paramBoolean)
  {
    this.mController.d(true, -1, paramBoolean);
  }
  
  public void expendActionbar()
  {
    q localq = this.mController;
    if (localq.bcg < localq.yUe)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localq.bcg, localq.yUe }).setDuration(200L);
      localValueAnimator.addUpdateListener(new q.11(localq));
      localValueAnimator.start();
    }
  }
  
  public void finish()
  {
    super.finish();
    int i = w.a(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
    int j = w.a(getIntent(), "MMActivity.OverrideExitAnimation", -1);
    if (i != -1) {
      super.overridePendingTransition(i, j);
    }
  }
  
  @Deprecated
  public void fixStatusbar(boolean paramBoolean)
  {
    this.fixStatusbar = paramBoolean;
  }
  
  protected boolean fromFullScreenActivity()
  {
    return false;
  }
  
  public void fullScreenNoTitleBar(boolean paramBoolean)
  {
    this.mController.fullScreenNoTitleBar(paramBoolean);
  }
  
  public void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    this.mController.fullScreenNoTitleBar(paramBoolean, paramLong);
  }
  
  public void fullScreenWithTitleBar(boolean paramBoolean)
  {
    this.mController.fullScreenWithTitleBar(paramBoolean);
  }
  
  public int getActionbarColor()
  {
    return this.mController.dCs();
  }
  
  public long getActivityBrowseTimeMs()
  {
    if (this.lastOnPauseTicks != 0L) {}
    for (long l = this.lastOnPauseTicks - this.lastOnResumeTicks + this.lastBrowseTime;; l = bo.yB() - this.lastOnResumeTicks + this.lastBrowseTime)
    {
      if (l < 0L) {
        ab.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l), Long.valueOf(this.lastOnResumeTicks), Long.valueOf(this.lastOnPauseTicks), Long.valueOf(this.lastBrowseTime) });
      }
      ab.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
      return l;
    }
  }
  
  public View getBodyView()
  {
    return this.mController.zay;
  }
  
  public String getCallerPackage()
  {
    Object localObject1 = "";
    localObject2 = getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      ab.i("MicroMsg.MMActivity", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (bo.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT >= 22) {
        localObject3 = localObject1;
      }
    }
    try
    {
      Object localObject4 = new c(this, "mReferrer", null).get();
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        localObject3 = localObject1;
        localObject2 = (String)localObject4;
      }
      localObject3 = localObject2;
      ab.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject2 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMActivity", localException, "get mReferrer error", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        localObject3 = getReferrer();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = ((Uri)localObject3).getAuthority();
          ab.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject1 });
        }
      }
    }
    return localObject1;
  }
  
  public final View getContentView()
  {
    return this.mController.contentView;
  }
  
  public AppCompatActivity getContext()
  {
    return this.mController.zaO;
  }
  
  public q getController()
  {
    return this.mController;
  }
  
  public int getCurrentActionbarHeight()
  {
    return this.mController.bcg;
  }
  
  protected int getForceOrientation()
  {
    return -1;
  }
  
  protected String getIdentString()
  {
    return "";
  }
  
  protected abstract int getLayoutId();
  
  protected View getLayoutView()
  {
    return null;
  }
  
  public CharSequence getMMTitle()
  {
    return this.mController.getMMTitle();
  }
  
  public Resources getResources()
  {
    if (getBaseContext() != null)
    {
      Resources localResources = getBaseContext().getResources();
      Object localObject2 = super.getResources();
      Object localObject1 = localObject2;
      if ((localObject2 instanceof com.tencent.mm.cc.b))
      {
        localObject1 = (com.tencent.mm.cc.b)localObject2;
        localObject2 = ((com.tencent.mm.cc.b)localObject1).yjj.c(localResources.getConfiguration());
        ((com.tencent.mm.cc.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
      }
      return localObject1;
    }
    ab.b("MicroMsg.MMActivity", "no base context!!", new Object[0]);
    return super.getResources();
  }
  
  public int getStreamMaxVolume(int paramInt)
  {
    return this.mController.getStreamMaxVolume(paramInt);
  }
  
  public int getStreamVolume(int paramInt)
  {
    return this.mController.getStreamVolume(paramInt);
  }
  
  public int getTitleLocation()
  {
    return this.mController.getTitleLocation();
  }
  
  public void hideActionbarLine()
  {
    q localq = this.mController;
    if ((Build.VERSION.SDK_INT >= 21) && (localq.getSupportActionBar() != null)) {
      localq.getSupportActionBar().setElevation(0.0F);
    }
  }
  
  public void hideTitleView()
  {
    this.mController.hideTitleView();
  }
  
  public void hideVKB()
  {
    this.mController.hideVKB();
  }
  
  public void hideVKB(View paramView)
  {
    this.mController.hideVKB(paramView);
  }
  
  public boolean hideVKBHavingResult()
  {
    return this.mController.hideVKB();
  }
  
  protected void initSwipeBack()
  {
    super.initSwipeBack();
    View localView;
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      if (!this.fixStatusbar) {
        break label97;
      }
    }
    label97:
    for (this.mWrappingFrame = new com.tencent.mm.ui.statusbar.b(this);; this.mWrappingFrame = new FrameLayout(this))
    {
      this.mWrappingFrame.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.mWrappingFrame);
      getSwipeBackLayout().setContentView(this.mWrappingFrame);
      return;
    }
  }
  
  @Deprecated
  protected void initView() {}
  
  public boolean isOptionMenuEnable(int paramInt)
  {
    Iterator localIterator = this.mController.yUg.iterator();
    while (localIterator.hasNext())
    {
      q.a locala = (q.a)localIterator.next();
      if (locala.yUo == paramInt) {
        return locala.enable;
      }
    }
    return false;
  }
  
  public boolean isOptionMenuShow(int paramInt)
  {
    Iterator localIterator = this.mController.yUg.iterator();
    while (localIterator.hasNext())
    {
      q.a locala = (q.a)localIterator.next();
      if (locala.yUo == paramInt) {
        return locala.arf;
      }
    }
    return false;
  }
  
  public boolean isScreenEnable()
  {
    return this.mController.zaC;
  }
  
  public boolean isSingleTitleView()
  {
    q localq = this.mController;
    return (localq.mActionBar != null) && (localq.mActionBar.getCustomView() != null) && (localq.mActionBar.getCustomView().findViewById(2131821000) != null);
  }
  
  public boolean isTitleShowing()
  {
    return this.mController.isTitleShowing();
  }
  
  public int keyboardState()
  {
    return this.mController.zbg;
  }
  
  public void mmSetOnActivityResultCallback(a parama)
  {
    this.onActResult = parama;
  }
  
  public void mmStartActivityForResult(a parama, Intent paramIntent, int paramInt)
  {
    this.onActResult = parama;
    startActivityForResult(paramIntent, paramInt);
  }
  
  public boolean needShowIdcError()
  {
    return true;
  }
  
  public boolean noActionBar()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.c(paramInt1, paramInt2, paramIntent);
    }
    this.onActResult = null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (!this.customfixStatusbar) {
      this.fixStatusbar = true;
    }
    super.onCreate(paramBundle);
    if (isHideStatusBar()) {
      this.fixStatusbar = false;
    }
    this.mController.a(getApplicationContext(), this);
    initNavigationSwipeBack();
    setActionbarColor(getResources().getColor(2131690316));
    setMMTitleSize(com.tencent.mm.cb.a.ap(this, 2131427493) * com.tencent.mm.cb.a.gr(this));
  }
  
  protected void onCreateBeforeSetContentView() {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.mController.onCreateOptionsMenu(paramMenu)) {
      return true;
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mController.hI(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mController.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @TargetApi(17)
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mController.onKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    try
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      ab.printErrStackTrace("MicroMsg.MMActivity", paramKeyEvent, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
    }
    return true;
  }
  
  public void onKeyboardStateChanged() {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.mController.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onPause()
  {
    long l = System.currentTimeMillis();
    ad.bK(2, this.className);
    super.onPause();
    this.mController.onPause();
    boolean bool = isFinishing();
    ab.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
    noteOnPauseTicks();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.mController.onPrepareOptionsMenu(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    long l = System.currentTimeMillis();
    ad.bK(1, this.className);
    super.onResume();
    ab.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    ab.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(hashCode()) });
    noteOnResumeTicks();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    setMMOrientation();
    super.onStart();
  }
  
  public void onSwipeBack()
  {
    if (!onSwipeBackFinish()) {
      this.mController.callBackMenu();
    }
    super.onSwipeBack();
  }
  
  public boolean onSwipeBackFinish()
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void removeAllOptionMenu()
  {
    this.mController.removeAllOptionMenu();
  }
  
  public boolean removeOptionMenu(int paramInt)
  {
    return this.mController.removeOptionMenu(paramInt);
  }
  
  public void setActionbarColor(int paramInt)
  {
    this.mController.setActionbarColor(paramInt);
  }
  
  public void setActionbarElementColor(int paramInt)
  {
    q localq = this.mController;
    localq.zaW = paramInt;
    if (localq.zaV != null) {
      localq.zaV.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    if ((localq.zaT != null) && (localq.zaT.getVisibility() == 0)) {
      localq.zaT.setTextColor(paramInt);
    }
    if ((localq.jjS != null) && (localq.jjS.getVisibility() == 0)) {
      localq.jjS.setTextColor(paramInt);
    }
    if ((localq.yTV != null) && (localq.yTV.getVisibility() == 0)) {
      localq.yTV.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    while ((localq.yTX == null) || (localq.yTX.getVisibility() != 0)) {
      return;
    }
    localq.yTX.setTextColor(paramInt);
  }
  
  public void setActionbarHeight(int paramInt)
  {
    this.mController.setActionbarHeight(paramInt);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.setBackBtn(paramOnMenuItemClickListener, 0);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    this.mController.setBackBtn(paramOnMenuItemClickListener, paramInt);
  }
  
  public void setBackBtnColorFilter(int paramInt)
  {
    this.mController.setBackBtnColorFilter(paramInt);
  }
  
  public void setBackBtnVisible(boolean paramBoolean)
  {
    this.mController.setBackBtnVisible(paramBoolean);
  }
  
  public void setBackGroundColorResource(int paramInt)
  {
    this.mController.setBackGroundColorResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    this.mController.setBodyView(paramInt);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    getContentView().setVisibility(paramInt);
    if (paramInt == 0)
    {
      showTitleView();
      return;
    }
    hideTitleView();
  }
  
  public void setIconAlpha(float paramFloat)
  {
    this.mController.setIconAlpha(paramFloat);
  }
  
  public void setIsDarkActionbarBg(boolean paramBoolean)
  {
    q localq = this.mController;
    localq.qGO = paramBoolean;
    localq.dCv();
    localq.dCu();
  }
  
  public void setLightNavigationbarIcon()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((q)localObject).zaO.getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFEF);
    }
  }
  
  public void setMMNormalView()
  {
    this.mController.setMMNormalView();
  }
  
  protected void setMMOrientation()
  {
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = getSharedPreferences(ah.dsP(), 0).getBoolean("settings_landscape_mode", false);
      if (this.landscapeMode)
      {
        setRequestedOrientation(-1);
        return;
      }
      setRequestedOrientation(1);
      return;
    }
    setRequestedOrientation(getForceOrientation());
  }
  
  public void setMMSingleTitle(String paramString)
  {
    this.mController.setMMSingleTitle(paramString, null);
  }
  
  public void setMMSingleTitle(String paramString, Animation paramAnimation)
  {
    this.mController.setMMSingleTitle(paramString, paramAnimation);
  }
  
  public void setMMSubTitle(int paramInt)
  {
    this.mController.setMMSubTitle(paramInt);
  }
  
  public void setMMSubTitle(String paramString)
  {
    this.mController.setMMSubTitle(paramString);
  }
  
  @Deprecated
  public void setMMSubTitleColor(int paramInt) {}
  
  public void setMMTitle(int paramInt)
  {
    this.mController.setMMTitle(paramInt);
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    this.mController.setMMTitle(paramCharSequence);
  }
  
  public void setMMTitle(String paramString)
  {
    this.mController.setMMTitle(paramString);
  }
  
  public void setMMTitleColor(int paramInt)
  {
    q localq = this.mController;
    if (localq.mActionBar != null) {
      localq.zaT.setTextColor(paramInt);
    }
  }
  
  public void setMMTitleSize(float paramFloat)
  {
    q localq = this.mController;
    if ((localq.mActionBar != null) && (localq.zaT != null)) {
      localq.zaT.setTextSize(0, paramFloat);
    }
  }
  
  public void setMMTitleVisibility(int paramInt)
  {
    this.mController.zaT.setVisibility(paramInt);
  }
  
  public void setNavigationbarColor(int paramInt)
  {
    this.mController.setNavigationbarColor(paramInt);
  }
  
  @Deprecated
  public void setRedDotVisibilty(int paramInt) {}
  
  public void setScreenEnable(boolean paramBoolean)
  {
    this.mController.setScreenEnable(paramBoolean);
  }
  
  public void setSelfNavigationBarColor(int paramInt)
  {
    if (!am.hO(getContext()))
    {
      ab.w("MicroMsg.MMActivity", "has not NavigationBar!");
      return;
    }
    if (this.mSelfNavigationBar == null)
    {
      this.mSelfNavigationBar = new View(getContext());
      ((ViewGroup)getWindow().getDecorView()).addView(this.mSelfNavigationBar);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, am.fx(getContext()));
    localLayoutParams.gravity = 80;
    this.mSelfNavigationBar.setLayoutParams(localLayoutParams);
    this.mSelfNavigationBar.setBackgroundColor(paramInt);
    this.mSelfNavigationBar.setVisibility(8);
  }
  
  public void setSelfNavigationBarVisible(int paramInt)
  {
    if (this.mSelfNavigationBar != null) {
      this.mSelfNavigationBar.setVisibility(paramInt);
    }
  }
  
  public void setTitleAlpha(float paramFloat)
  {
    q localq = this.mController;
    if (localq.zaT != null) {
      localq.zaT.setAlpha(paramFloat);
    }
  }
  
  public void setTitleBarClickListener(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    q localq = this.mController;
    if (localq.mActionBar == null) {
      return;
    }
    localq.mActionBar.getCustomView().setOnClickListener(new q.7(localq, paramRunnable1, paramRunnable2));
  }
  
  public void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    this.mController.setTitleBarDoubleClickListener(paramRunnable);
  }
  
  @Deprecated
  public void setTitleClickAction(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener) {}
  
  public void setTitleDividerColor(int paramInt) {}
  
  public void setTitleDividerVis(boolean paramBoolean) {}
  
  public void setTitleForceNotifyIconVisibility(int paramInt)
  {
    q localq = this.mController;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localq.zaM = bool;
      localq.dCt();
      return;
    }
  }
  
  public void setTitleLogo(int paramInt1, int paramInt2)
  {
    this.mController.setTitleLogo(paramInt1, paramInt2);
  }
  
  public void setTitleMuteIconVisibility(int paramInt)
  {
    this.mController.setTitleMuteIconVisibility(paramInt);
  }
  
  public void setTitlePhoneIconVisibility(int paramInt)
  {
    this.mController.setTitlePhoneIconVisibility(paramInt);
  }
  
  public void setTitleVisibility(int paramInt)
  {
    this.mController.setTitleVisibility(paramInt);
  }
  
  @Deprecated
  public void setToTop(View.OnClickListener paramOnClickListener) {}
  
  public void showActionbarLine()
  {
    q localq = this.mController;
    if ((Build.VERSION.SDK_INT >= 21) && (localq.getSupportActionBar() != null)) {
      localq.getSupportActionBar().setElevation(1.0F);
    }
  }
  
  public void showHomeBtn(boolean paramBoolean)
  {
    this.mController.showHomeBtn(paramBoolean);
  }
  
  public void showMMLogo()
  {
    q localq = this.mController;
    localq.zaV.setVisibility(8);
    localq.zaU.setVisibility(8);
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.e(false, paramInt, paramBoolean);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    this.mController.e(true, -1, paramBoolean);
  }
  
  public void showTitleView()
  {
    this.mController.showTitleView();
  }
  
  public void showVKB()
  {
    q.showVKB(this.mController.zaO);
  }
  
  public void startActivity(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    startActivity(localIntent);
  }
  
  public void startActivity(Class<?> paramClass, Intent paramIntent)
  {
    paramIntent.setClass(this, paramClass);
    startActivity(paramIntent);
  }
  
  public void supportLightStatusBar()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((q)localObject).zaO.getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x2000);
    }
  }
  
  public void updateBackBtn(Drawable paramDrawable)
  {
    this.mController.updateBackBtn(paramDrawable);
  }
  
  protected void updateDescription(String paramString)
  {
    this.mController.updateDescription(paramString);
  }
  
  public void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    this.mController.updateOptionMenuIcon(paramInt1, paramInt2);
  }
  
  public void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.updateOptionMenuListener(paramInt, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void updateOptionMenuText(int paramInt, String paramString)
  {
    this.mController.updateOptionMenuText(paramInt, paramString);
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt1, int paramInt2, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMActivity
 * JD-Core Version:    0.7.0.1
 */