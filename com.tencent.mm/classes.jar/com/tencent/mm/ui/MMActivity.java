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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.s;
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
  implements ad, h.c, com.tencent.mm.ui.widget.a.c
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
  public t mController = new t()
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
      int j = MMActivity.this.getLayoutId();
      int i = j;
      if (j == 0) {
        i = MMActivity.this.getLayoutUIC().getLayoutId();
      }
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
  private boolean mIsPaused = false;
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
    return t.initLanguage(paramContext);
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    return t.initLanguage(paramContext, paramString);
  }
  
  private void noteOnPauseTicks()
  {
    this.lastOnPauseTicks = Util.currentTicks();
  }
  
  private void noteOnResumeTicks()
  {
    if (this.lastOnPauseTicks > this.lastOnResumeTicks) {
      this.lastBrowseTime += this.lastOnPauseTicks - this.lastOnResumeTicks;
    }
    this.lastOnResumeTicks = Util.currentTicks();
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
  
  public void addSearchMenu(boolean paramBoolean, s params)
  {
    this.mController.addSearchMenu(paramBoolean, params);
  }
  
  public void addTextOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    t localt = this.mController;
    t.b localb = t.b.OGT;
    t.a locala = new t.a();
    locala.Oye = paramInt1;
    locala.text = paramString;
    locala.textColor = paramInt2;
    locala.kjh = paramOnMenuItemClickListener;
    locala.tib = null;
    locala.OGS = localb;
    localt.akW(locala.Oye);
    localt.OxV.add(locala);
    new MMHandler().postDelayed(new t.14(localt), 200L);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, View.OnTouchListener paramOnTouchListener, t.b paramb)
  {
    t localt = this.mController;
    t.a locala = new t.a();
    locala.Oye = paramInt;
    locala.Oyf = 0;
    locala.text = paramString;
    locala.kjh = paramOnMenuItemClickListener;
    locala.tib = paramOnLongClickListener;
    locala.uwC = paramOnTouchListener;
    locala.OGS = paramb;
    locala.eho = false;
    if ((locala.Oyf == 2131233966) && (Util.isNullOrNil(paramString))) {
      locala.text = localt.mContext.getString(2131755899);
    }
    localt.akW(locala.Oye);
    localt.OxV.add(locala);
    localt.supportInvalidateOptionsMenu();
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, t.b paramb)
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
    this.mController.c(false, paramInt, paramBoolean);
  }
  
  public void enableOptionMenu(boolean paramBoolean)
  {
    this.mController.c(true, -1, paramBoolean);
  }
  
  public void expendActionbar()
  {
    t localt = this.mController;
    if ((!localt.noActionBar()) && (localt.bIs < localt.OxT))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localt.bIs, localt.OxT }).setDuration(200L);
      localValueAnimator.addUpdateListener(new t.15(localt));
      localValueAnimator.start();
    }
  }
  
  public void finish()
  {
    super.finish();
    int i = IntentUtil.getIntExtra(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
    int j = IntentUtil.getIntExtra(getIntent(), "MMActivity.OverrideExitAnimation", -1);
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
    return this.mController.gIN();
  }
  
  public long getActivityBrowseTimeMs()
  {
    if (this.lastOnPauseTicks != 0L) {}
    for (long l = this.lastOnPauseTicks - this.lastOnResumeTicks + this.lastBrowseTime;; l = Util.currentTicks() - this.lastOnResumeTicks + this.lastBrowseTime)
    {
      if (l < 0L) {
        Log.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l), Long.valueOf(this.lastOnResumeTicks), Long.valueOf(this.lastOnPauseTicks), Long.valueOf(this.lastBrowseTime) });
      }
      Log.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
      return l;
    }
  }
  
  public View getBodyView()
  {
    return this.mController.GDE;
  }
  
  public String getCallerPackage()
  {
    Object localObject1 = "";
    localObject2 = getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      Log.i("MicroMsg.MMActivity", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
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
      Log.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject2 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMActivity", localException, "get mReferrer error", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        localObject3 = getReferrer();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = ((Uri)localObject3).getAuthority();
          Log.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject1 });
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
    return this.mController.OGe;
  }
  
  public t getController()
  {
    return this.mController;
  }
  
  public int getCurrentActionbarHeight()
  {
    return this.mController.bIs;
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
      if ((localResources instanceof com.tencent.mm.cc.b))
      {
        localObject1 = localResources;
        if (localObject2 != null)
        {
          localObject1 = (com.tencent.mm.cc.b)localResources;
          localObject2 = ((com.tencent.mm.cc.b)localObject1).NDo.g(((Resources)localObject2).getConfiguration());
          com.tencent.mm.cc.c.a((Configuration)localObject2, ao.f(localResources));
          ((com.tencent.mm.cc.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
        }
      }
      return localObject1;
    }
    Log.printInfoStack("MicroMsg.MMActivity", "no base context!!", new Object[0]);
    return super.getResources();
  }
  
  public int getStatusBarHeight(int paramInt)
  {
    if ((this.mWrappingFrame instanceof com.tencent.mm.ui.statusbar.b)) {
      return ((com.tencent.mm.ui.statusbar.b)this.mWrappingFrame).getDrawnStatusBarHeight();
    }
    return au.D(this, paramInt);
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
  
  public void hideActionBarOperationArea()
  {
    if (this.mController != null)
    {
      t localt = this.mController;
      if (localt.OGq != null) {
        localt.OGq.setVisibility(8);
      }
      if (localt.OxH != null) {
        localt.OxH.setVisibility(0);
      }
    }
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
      t localt = this.mController;
      if (localt.OGq != null) {
        localt.OGq.setVisibility(0);
      }
      if (localt.OxH != null) {
        localt.OxH.setVisibility(8);
      }
    }
  }
  
  public void initActionBarOperationAreaTxt(String paramString)
  {
    if (this.mController != null)
    {
      t localt = this.mController;
      if (localt.OGr != null) {
        localt.OGr.QBA.setText(paramString);
      }
    }
  }
  
  public void initActionBarOperationAreaTxt(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mController != null)
    {
      Object localObject = this.mController;
      if (((t)localObject).OGr != null)
      {
        localObject = ((t)localObject).OGr;
        ((AlbumChooserView)localObject).QBA.setText(paramString);
        ((AlbumChooserView)localObject).QBA.setTextColor(((AlbumChooserView)localObject).getContext().getResources().getColor(paramInt1));
        ((LinearLayout)((AlbumChooserView)localObject).QBA.getParent()).setBackground(((AlbumChooserView)localObject).getContext().getResources().getDrawable(paramInt4));
        ((AlbumChooserView)localObject).QBB.setIconColor(((AlbumChooserView)localObject).getContext().getResources().getColor(paramInt2));
        ((FrameLayout)((AlbumChooserView)localObject).QBB.getParent()).setBackground(((AlbumChooserView)localObject).getContext().getResources().getDrawable(paramInt3));
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
    Iterator localIterator = this.mController.OxV.iterator();
    while (localIterator.hasNext())
    {
      t.a locala = (t.a)localIterator.next();
      if (locala.Oye == paramInt) {
        return locala.enable;
      }
    }
    return false;
  }
  
  public boolean isOptionMenuShow(int paramInt)
  {
    Iterator localIterator = this.mController.OxV.iterator();
    while (localIterator.hasNext())
    {
      t.a locala = (t.a)localIterator.next();
      if (locala.Oye == paramInt) {
        return locala.visible;
      }
    }
    return false;
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isScreenEnable()
  {
    return this.mController.OFT;
  }
  
  public boolean isShowDialog()
  {
    Object localObject = this.mController;
    if (((t)localObject).ogl == null) {
      return false;
    }
    localObject = ((t)localObject).ogl.iterator();
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
    t localt = this.mController;
    return (localt.mActionBar != null) && (localt.mActionBar.getCustomView() != null) && (localt.mActionBar.getCustomView().findViewById(2131296370) != null);
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
    return this.mController.OGC;
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
      this.onActResult.d(paramInt1, paramInt2, paramIntent);
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
    getController().OGy = 2131492946;
    super.onCreate(paramBundle);
    if (isHideStatusBar()) {
      this.fixStatusbar = false;
    }
    this.mController.a(getApplicationContext(), this);
    initNavigationSwipeBack();
    if (!noActionBar())
    {
      setActionbarColor(getResources().getColor(2131100898));
      setMMTitleSize(com.tencent.mm.cb.a.aH(this, 2131165186) * com.tencent.mm.cb.a.ji(this));
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
    this.mController.jM(this);
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
      Log.printErrStackTrace("MicroMsg.MMActivity", paramKeyEvent, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
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
    am.dl(2, this.className);
    this.mIsPaused = true;
    super.onPause();
    this.mController.onPause();
    boolean bool = isFinishing();
    Log.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
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
    am.dl(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    Log.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    Log.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(hashCode()) });
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
      if (((t)localObject).OGr != null)
      {
        localObject = ((t)localObject).OGr;
        if (!((AlbumChooserView)localObject).QBC)
        {
          ((AlbumChooserView)localObject).QBC = true;
          ((AlbumChooserView)localObject).QBB.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.2((AlbumChooserView)localObject)).start();
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
  
  public void removeSearchMenu()
  {
    t localt = this.mController;
    t.a locala = new t.a();
    locala.Oye = 2131304628;
    locala.text = localt.mContext.getString(2131755972);
    locala.Oyf = 2131689496;
    locala.kjh = null;
    locala.tib = null;
    localt.removeOptionMenu(locala.Oye);
    localt.supportInvalidateOptionsMenu();
  }
  
  public void setActionBarOperationAreaClickListener(AlbumChooserView.a parama)
  {
    if (this.mController != null)
    {
      t localt = this.mController;
      if (localt.OGr != null) {
        localt.OGr.setOnAlbumChooserViewClick(parama);
      }
    }
  }
  
  public void setActionbarColor(int paramInt)
  {
    this.mController.setActionbarColor(paramInt);
  }
  
  public void setActionbarElementColor(int paramInt)
  {
    t localt = this.mController;
    localt.OGn = paramInt;
    localt.OGt = true;
    if (localt.OGl != null) {
      localt.OGl.setIconColor(paramInt);
    }
    if ((localt.OGj != null) && (localt.OGj.getVisibility() == 0)) {
      localt.OGj.setTextColor(paramInt);
    }
    if ((localt.orb != null) && (localt.orb.getVisibility() == 0)) {
      localt.orb.setTextColor(paramInt);
    }
    if ((localt.OxJ != null) && (localt.OxJ.getVisibility() == 0)) {
      localt.OxJ.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    while ((localt.OxL == null) || (localt.OxL.getVisibility() != 0)) {
      return;
    }
    localt.OxL.setTextColor(paramInt);
  }
  
  public void setActionbarHeight(int paramInt)
  {
    this.mController.akY(paramInt);
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
    this.mController.Bi(paramBoolean);
  }
  
  public void setLightNavigationbarIcon()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((t)localObject).OGe.getWindow().getDecorView();
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
      this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
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
    t localt = this.mController;
    if (localt.mActionBar != null) {
      localt.OGj.setTextColor(paramInt);
    }
  }
  
  public void setMMTitleSize(float paramFloat)
  {
    t localt = this.mController;
    if ((localt.mActionBar != null) && (localt.OGj != null)) {
      localt.OGj.setTextSize(0, paramFloat);
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
    t localt = this.mController;
    if (localt.mActionBar != null) {
      localt.OGm.setIndeterminateDrawable(localt.OGe.getDrawable(paramInt));
    }
  }
  
  public void setProgressVisibility(int paramInt)
  {
    t localt = this.mController;
    if (localt.mActionBar != null) {
      localt.OGm.setVisibility(paramInt);
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
    if (!au.aA(getContext()))
    {
      Log.w("MicroMsg.MMActivity", "has not NavigationBar!");
      return;
    }
    if (this.mSelfNavigationBar == null)
    {
      this.mSelfNavigationBar = new View(getContext());
      ((ViewGroup)getWindow().getDecorView()).addView(this.mSelfNavigationBar);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, au.aD(getContext()));
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
      t localt = this.mController;
      Log.d("MicroMsg.MMActivityController", "set smart gallery entry valid.");
      localt.OGf = paramBoolean;
      localt.supportInvalidateOptionsMenu();
    }
  }
  
  public void setTitleAlpha(float paramFloat)
  {
    t localt = this.mController;
    if (localt.OGj != null) {
      localt.OGj.setAlpha(paramFloat);
    }
  }
  
  public void setTitleBarClickListener(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    t localt = this.mController;
    if (localt.mActionBar == null) {
      return;
    }
    localt.mActionBar.getCustomView().setOnClickListener(new t.10(localt, paramRunnable1, paramRunnable2));
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
    t localt = this.mController;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localt.OGc = bool;
      localt.gIQ();
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
    t localt = this.mController;
    localt.OGl.setVisibility(8);
    localt.OGk.setVisibility(8);
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.d(false, paramInt, paramBoolean);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    this.mController.d(true, -1, paramBoolean);
  }
  
  public void showTitleView()
  {
    this.mController.showTitleView();
  }
  
  public void showVKB()
  {
    t.showVKB(this.mController.OGe);
  }
  
  public void startActivity(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.axQ(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramClass.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void startActivity(Class<?> paramClass, Intent paramIntent)
  {
    paramIntent.setClass(this, paramClass);
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.axQ(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramClass.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void supportLightStatusBar()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((t)localObject).OGe.getWindow().getDecorView();
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
      if (((t)localObject).OGr != null)
      {
        localObject = ((t)localObject).OGr;
        if (!((AlbumChooserView)localObject).QBC)
        {
          ((AlbumChooserView)localObject).QBC = true;
          ((AlbumChooserView)localObject).QBB.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.3((AlbumChooserView)localObject, paramString)).start();
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
  
  public void updateOptionMenuStyle(int paramInt, t.b paramb)
  {
    t localt = this.mController;
    t.a locala = localt.akX(paramInt);
    if (locala != null)
    {
      locala.OGS = paramb;
      localt.supportInvalidateOptionsMenu();
    }
  }
  
  public void updateOptionMenuText(int paramInt, String paramString)
  {
    this.mController.updateOptionMenuText(paramInt, paramString);
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt1, int paramInt2, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMActivity
 * JD-Core Version:    0.7.0.1
 */