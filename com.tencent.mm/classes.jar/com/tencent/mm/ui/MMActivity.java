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
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.AlbumChooserView.2;
import com.tencent.mm.ui.widget.AlbumChooserView.3;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity
  extends MMFragmentActivity
  implements com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.widget.a.c
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
  private byte _hellAccFlag_;
  String className;
  boolean customfixStatusbar = false;
  boolean fixStatusbar = false;
  protected boolean landscapeMode = false;
  private long lastBrowseTime = 0L;
  private long lastOnPauseTicks = 0L;
  private long lastOnResumeTicks = 0L;
  public s mController = new s()
  {
    protected final void dealContentView(View paramAnonymousView)
    {
      AppMethodBeat.i(141318);
      MMActivity.this.dealContentView(paramAnonymousView);
      AppMethodBeat.o(141318);
    }
    
    protected final boolean fromFullScreenActivity()
    {
      AppMethodBeat.i(141324);
      boolean bool = MMActivity.this.fromFullScreenActivity();
      AppMethodBeat.o(141324);
      return bool;
    }
    
    protected final String getClassName()
    {
      AppMethodBeat.i(141323);
      String str = MMActivity.this.getClass().getName();
      AppMethodBeat.o(141323);
      return str;
    }
    
    protected final String getIdentString()
    {
      AppMethodBeat.i(141319);
      String str = MMActivity.this.getIdentString();
      AppMethodBeat.o(141319);
      return str;
    }
    
    protected final int getLayoutId()
    {
      AppMethodBeat.i(141317);
      int i = MMActivity.this.getLayoutId();
      AppMethodBeat.o(141317);
      return i;
    }
    
    protected final View getLayoutView()
    {
      AppMethodBeat.i(141320);
      View localView = MMActivity.this.getLayoutView();
      AppMethodBeat.o(141320);
      return localView;
    }
    
    protected final boolean needResetStatusBarColorOnActivityCreate()
    {
      AppMethodBeat.i(141326);
      boolean bool = MMActivity.this.needResetStatusBarColorOnActivityCreate();
      AppMethodBeat.o(141326);
      return bool;
    }
    
    public final boolean needShowIdcError()
    {
      AppMethodBeat.i(141327);
      boolean bool = MMActivity.this.needShowIdcError();
      AppMethodBeat.o(141327);
      return bool;
    }
    
    public final boolean noActionBar()
    {
      AppMethodBeat.i(141325);
      boolean bool = MMActivity.this.noActionBar();
      AppMethodBeat.o(141325);
      return bool;
    }
    
    protected final void onCreateBeforeSetContentView()
    {
      AppMethodBeat.i(141322);
      MMActivity.this.onCreateBeforeSetContentView();
      AppMethodBeat.o(141322);
    }
    
    public final void onKeyboardStateChanged()
    {
      AppMethodBeat.i(141321);
      MMActivity.this.onKeyboardStateChanged();
      AppMethodBeat.o(141321);
    }
    
    protected final View provideCustomActivityContentView()
    {
      AppMethodBeat.i(141328);
      View localView = MMActivity.this.provideCustomActivityContentView();
      AppMethodBeat.o(141328);
      return localView;
    }
  };
  private boolean mIsStopped = false;
  private View mSelfNavigationBar;
  private ViewGroup mWrappingFrame = null;
  private a onActResult = null;
  boolean transparentTheme = false;
  
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
    return s.initLanguage(paramContext);
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    return s.initLanguage(paramContext, paramString);
  }
  
  private void noteOnPauseTicks()
  {
    this.lastOnPauseTicks = bt.HI();
  }
  
  private void noteOnResumeTicks()
  {
    if (this.lastOnPauseTicks > this.lastOnResumeTicks) {
      this.lastBrowseTime += this.lastOnPauseTicks - this.lastOnResumeTicks;
    }
    this.lastOnResumeTicks = bt.HI();
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
  
  @Deprecated
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
  
  public void addSearchMenu(boolean paramBoolean, r paramr)
  {
    this.mController.addSearchMenu(paramBoolean, paramr);
  }
  
  public void addTextOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    s locals = this.mController;
    s.b localb = s.b.JbR;
    s.a locala = new s.a();
    locala.ITC = paramInt1;
    locala.text = paramString;
    locala.textColor = paramInt2;
    locala.jil = paramOnMenuItemClickListener;
    locala.rAj = null;
    locala.JbP = localb;
    locals.abG(locala.ITC);
    locals.ITt.add(locala);
    new ap().postDelayed(new s.11(locals), 200L);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, View.OnTouchListener paramOnTouchListener, s.b paramb)
  {
    s locals = this.mController;
    s.a locala = new s.a();
    locala.ITC = paramInt;
    locala.ITD = 0;
    locala.text = paramString;
    locala.jil = paramOnMenuItemClickListener;
    locala.rAj = paramOnLongClickListener;
    locala.tKQ = paramOnTouchListener;
    locala.JbP = paramb;
    locala.JbQ = false;
    if ((locala.ITD == 2131233291) && (bt.isNullOrNil(paramString))) {
      locala.text = locals.mContext.getString(2131755815);
    }
    locals.abG(locala.ITC);
    locals.ITt.add(locala);
    locals.supportInvalidateOptionsMenu();
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, s.b paramb)
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
  
  public void enableBackMenu(boolean paramBoolean)
  {
    this.mController.enableBackMenu(paramBoolean);
  }
  
  public void enableOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.b(false, paramInt, paramBoolean);
  }
  
  public void enableOptionMenu(boolean paramBoolean)
  {
    this.mController.b(true, -1, paramBoolean);
  }
  
  public void expendActionbar()
  {
    s locals = this.mController;
    if ((!locals.noActionBar()) && (locals.bIc < locals.ITr))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { locals.bIc, locals.ITr }).setDuration(200L);
      localValueAnimator.addUpdateListener(new s.13(locals));
      localValueAnimator.start();
    }
  }
  
  public void finish()
  {
    super.finish();
    int i = y.getIntExtra(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
    int j = y.getIntExtra(getIntent(), "MMActivity.OverrideExitAnimation", -1);
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
    return this.mController.fwQ();
  }
  
  public long getActivityBrowseTimeMs()
  {
    if (this.lastOnPauseTicks != 0L) {}
    for (long l = this.lastOnPauseTicks - this.lastOnResumeTicks + this.lastBrowseTime;; l = bt.HI() - this.lastOnResumeTicks + this.lastBrowseTime)
    {
      if (l < 0L) {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l), Long.valueOf(this.lastOnResumeTicks), Long.valueOf(this.lastOnPauseTicks), Long.valueOf(this.lastBrowseTime) });
      }
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
      return l;
    }
  }
  
  public View getBodyView()
  {
    return this.mController.BKn;
  }
  
  public String getCallerPackage()
  {
    Object localObject1 = "";
    localObject2 = getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMActivity", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT >= 22) {
        localObject3 = localObject1;
      }
    }
    try
    {
      Object localObject4 = new com.tencent.mm.compatible.loader.c(this, "mReferrer", null).get();
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        localObject3 = localObject1;
        localObject2 = (String)localObject4;
      }
      localObject3 = localObject2;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject2 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.MMActivity", localException, "get mReferrer error", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        localObject3 = getReferrer();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = ((Uri)localObject3).getAuthority();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject1 });
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
    return this.mController.Jbc;
  }
  
  public s getController()
  {
    return this.mController;
  }
  
  public int getCurrentActionbarHeight()
  {
    return this.mController.bIc;
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
      Object localObject2 = getBaseContext().getResources();
      Resources localResources = super.getResources();
      Object localObject1 = localResources;
      if ((localResources instanceof com.tencent.mm.cd.b))
      {
        localObject1 = localResources;
        if (localObject2 != null)
        {
          localObject1 = (com.tencent.mm.cd.b)localResources;
          localObject2 = ((com.tencent.mm.cd.b)localObject1).HVJ.g(((Resources)localObject2).getConfiguration());
          com.tencent.mm.cd.c.a((Configuration)localObject2, al.j(localResources));
          ((com.tencent.mm.cd.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
        }
      }
      return localObject1;
    }
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.MMActivity", "no base context!!", new Object[0]);
    return super.getResources();
  }
  
  public int getStatusBarHeight(int paramInt)
  {
    if ((this.mWrappingFrame instanceof com.tencent.mm.ui.statusbar.b)) {
      return ((com.tencent.mm.ui.statusbar.b)this.mWrappingFrame).getDrawnStatusBarHeight();
    }
    return ar.B(this, paramInt);
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
    this.mController.hideActionbarLine();
  }
  
  public void hideAllManagedDialogs()
  {
    this.mController.hideAllManagedDialogs();
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
  
  public void initActionBarOperationArea()
  {
    if (this.mController != null)
    {
      s locals = this.mController;
      if (locals.Jbp != null) {
        locals.Jbp.setVisibility(0);
      }
      if (locals.ITf != null) {
        locals.ITf.setVisibility(8);
      }
    }
  }
  
  public void initActionBarOperationAreaTxt(String paramString)
  {
    if (this.mController != null)
    {
      s locals = this.mController;
      if (locals.Jbq != null) {
        locals.Jbq.KPU.setText(paramString);
      }
    }
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
    Iterator localIterator = this.mController.ITt.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
      if (locala.ITC == paramInt) {
        return locala.enable;
      }
    }
    return false;
  }
  
  public boolean isOptionMenuShow(int paramInt)
  {
    Iterator localIterator = this.mController.ITt.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
      if (locala.ITC == paramInt) {
        return locala.visible;
      }
    }
    return false;
  }
  
  public boolean isScreenEnable()
  {
    return this.mController.JaQ;
  }
  
  public boolean isShowDialog()
  {
    Object localObject = this.mController;
    if (((s)localObject).Jbh == null) {
      return false;
    }
    localObject = ((s)localObject).Jbh.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!((Dialog)((Iterator)localObject).next()).isShowing());
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isSingleTitleView()
  {
    s locals = this.mController;
    return (locals.mActionBar != null) && (locals.mActionBar.getCustomView() != null) && (locals.mActionBar.getCustomView().findViewById(2131296348) != null);
  }
  
  public boolean isStopped()
  {
    return this.mIsStopped;
  }
  
  public boolean isTitleShowing()
  {
    return this.mController.isTitleShowing();
  }
  
  public int keyboardState()
  {
    return this.mController.JbA;
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
  
  protected boolean needResetStatusBarColorOnActivityCreate()
  {
    return true;
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
    if (!noActionBar())
    {
      setActionbarColor(getResources().getColor(2131100705));
      setMMTitleSize(com.tencent.mm.cc.a.ay(this, 2131165184) * com.tencent.mm.cc.a.ik(this));
    }
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
    this.mController.jK(this);
  }
  
  public void onDialogDismiss(Dialog paramDialog) {}
  
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
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.MMActivity", paramKeyEvent, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
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
    aj.cQ(2, this.className);
    super.onPause();
    this.mController.onPause();
    boolean bool = isFinishing();
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
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
    aj.cQ(1, this.className);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(hashCode()) });
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
    this.mIsStopped = false;
    super.onStart();
  }
  
  public void onStop()
  {
    this.mIsStopped = true;
    super.onStop();
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
  
  public void playActionBarOperationAreaAnim()
  {
    if (this.mController != null)
    {
      Object localObject = this.mController;
      if (((s)localObject).Jbq != null)
      {
        localObject = ((s)localObject).Jbq;
        if (!((AlbumChooserView)localObject).KPW)
        {
          ((AlbumChooserView)localObject).KPW = true;
          ((AlbumChooserView)localObject).KPV.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.2((AlbumChooserView)localObject)).start();
        }
      }
    }
  }
  
  protected View provideCustomActivityContentView()
  {
    return null;
  }
  
  public void removeAllOptionMenu()
  {
    this.mController.removeAllOptionMenu();
  }
  
  public boolean removeOptionMenu(int paramInt)
  {
    return this.mController.removeOptionMenu(paramInt);
  }
  
  public void setActionBarOperationAreaClickListener(AlbumChooserView.a parama)
  {
    if (this.mController != null)
    {
      s locals = this.mController;
      if (locals.Jbq != null) {
        locals.Jbq.setOnAlbumChooserViewClick(parama);
      }
    }
  }
  
  public void setActionbarColor(int paramInt)
  {
    this.mController.setActionbarColor(paramInt);
  }
  
  public void setActionbarElementColor(int paramInt)
  {
    s locals = this.mController;
    locals.Jbm = paramInt;
    locals.Jbs = true;
    if (locals.Jbk != null) {
      locals.Jbk.setIconColor(paramInt);
    }
    if ((locals.Jbi != null) && (locals.Jbi.getVisibility() == 0)) {
      locals.Jbi.setTextColor(paramInt);
    }
    if ((locals.nci != null) && (locals.nci.getVisibility() == 0)) {
      locals.nci.setTextColor(paramInt);
    }
    if ((locals.ITh != null) && (locals.ITh.getVisibility() == 0)) {
      locals.ITh.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    while ((locals.ITj == null) || (locals.ITj.getVisibility() != 0)) {
      return;
    }
    locals.ITj.setTextColor(paramInt);
  }
  
  public void setActionbarHeight(int paramInt)
  {
    this.mController.abI(paramInt);
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
    this.mController.xl(paramBoolean);
  }
  
  public void setLightNavigationbarIcon()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((s)localObject).Jbc.getWindow().getDecorView();
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
      this.landscapeMode = getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC(), 0).getBoolean("settings_landscape_mode", false);
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
    s locals = this.mController;
    if (locals.mActionBar != null) {
      locals.Jbi.setTextColor(paramInt);
    }
  }
  
  public void setMMTitleSize(float paramFloat)
  {
    s locals = this.mController;
    if ((locals.mActionBar != null) && (locals.Jbi != null)) {
      locals.Jbi.setTextSize(0, paramFloat);
    }
  }
  
  public void setMMTitleVisibility(int paramInt)
  {
    this.mController.setMMTitleVisibility(paramInt);
  }
  
  public void setNavigationbarColor(int paramInt)
  {
    this.mController.setNavigationbarColor(paramInt);
  }
  
  public void setProgressIcon(int paramInt)
  {
    s locals = this.mController;
    if (locals.mActionBar != null) {
      locals.Jbl.setIndeterminateDrawable(locals.Jbc.getDrawable(paramInt));
    }
  }
  
  public void setProgressVisibility(int paramInt)
  {
    s locals = this.mController;
    if (locals.mActionBar != null) {
      locals.Jbl.setVisibility(paramInt);
    }
  }
  
  @Deprecated
  public void setRedDotVisibilty(int paramInt) {}
  
  public void setScreenEnable(boolean paramBoolean)
  {
    this.mController.setScreenEnable(paramBoolean);
  }
  
  public void setSelfNavigationBarColor(int paramInt)
  {
    if (!ar.jR(getContext()))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMActivity", "has not NavigationBar!");
      return;
    }
    if (this.mSelfNavigationBar == null)
    {
      this.mSelfNavigationBar = new View(getContext());
      ((ViewGroup)getWindow().getDecorView()).addView(this.mSelfNavigationBar);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, ar.ej(getContext()));
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
  
  public void setSmartGalleryEntryVisibility(boolean paramBoolean)
  {
    if (this.mController != null)
    {
      s locals = this.mController;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MMActivityController", "set smart gallery entry valid.");
      locals.Jbd = paramBoolean;
      locals.supportInvalidateOptionsMenu();
    }
  }
  
  public void setTitleAlpha(float paramFloat)
  {
    s locals = this.mController;
    if (locals.Jbi != null) {
      locals.Jbi.setAlpha(paramFloat);
    }
  }
  
  public void setTitleBarClickListener(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    s locals = this.mController;
    if (locals.mActionBar == null) {
      return;
    }
    locals.mActionBar.getCustomView().setOnClickListener(new s.8(locals, paramRunnable1, paramRunnable2));
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
    s locals = this.mController;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      locals.Jba = bool;
      locals.fwS();
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
  
  public void setTransparentTheme(boolean paramBoolean)
  {
    this.transparentTheme = paramBoolean;
  }
  
  public void showActionbarLine()
  {
    this.mController.showActionbarLine();
  }
  
  public void showHomeBtn(boolean paramBoolean)
  {
    this.mController.showHomeBtn(paramBoolean);
  }
  
  public void showMMLogo()
  {
    s locals = this.mController;
    locals.Jbk.setVisibility(8);
    locals.Jbj.setVisibility(8);
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.c(false, paramInt, paramBoolean);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    this.mController.c(true, -1, paramBoolean);
  }
  
  public void showTitleView()
  {
    this.mController.showTitleView();
  }
  
  public void showVKB()
  {
    s.showVKB(this.mController.Jbc);
  }
  
  public void startActivity(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.ahp(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramClass.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void startActivity(Class<?> paramClass, Intent paramIntent)
  {
    paramIntent.setClass(this, paramClass);
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.ahp(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramClass.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void supportLightStatusBar()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((s)localObject).Jbc.getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x2000);
    }
  }
  
  public void updataStatusBarIcon(boolean paramBoolean)
  {
    this.mController.updataStatusBarIcon(paramBoolean);
  }
  
  public void updateActionBarOperationAreaTxt(String paramString)
  {
    if (this.mController != null)
    {
      Object localObject = this.mController;
      if (((s)localObject).Jbq != null)
      {
        localObject = ((s)localObject).Jbq;
        if (!((AlbumChooserView)localObject).KPW)
        {
          ((AlbumChooserView)localObject).KPW = true;
          ((AlbumChooserView)localObject).KPV.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.3((AlbumChooserView)localObject, paramString)).start();
        }
      }
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
  
  public void updateOptionMenuStyle(int paramInt, s.b paramb)
  {
    s locals = this.mController;
    s.a locala = locals.abH(paramInt);
    if (locala != null)
    {
      locala.JbP = paramb;
      locals.supportInvalidateOptionsMenu();
    }
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