package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ce.c;
import com.tencent.mm.ce.e;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.AlbumChooserView.2;
import com.tencent.mm.ui.widget.AlbumChooserView.3;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.f;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity
  extends MMFragmentActivity
  implements ah, k.c, com.tencent.mm.ui.widget.a.d
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
  private final Map<MMActivity.b, Object> mConfigChangedListeners = new androidx.b.a();
  public y mController = new y()
  {
    protected final String Dy()
    {
      AppMethodBeat.i(141323);
      String str = MMActivity.this.getClass().getName();
      AppMethodBeat.o(141323);
      return str;
    }
    
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
    
    protected final int getCustomBounceId()
    {
      AppMethodBeat.i(250959);
      int i = MMActivity.this.getCustomBounceId();
      AppMethodBeat.o(250959);
      return i;
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
    
    protected final boolean isActionbarCenterLayoutMode()
    {
      AppMethodBeat.i(250955);
      boolean bool = MMActivity.this.isActionbarCenterLayoutMode();
      AppMethodBeat.o(250955);
      return bool;
    }
    
    protected final boolean isActionbarMenuUseOriginalSys()
    {
      AppMethodBeat.i(250957);
      boolean bool = MMActivity.this.isActionbarMenuUseOriginalSys();
      AppMethodBeat.o(250957);
      return bool;
    }
    
    public final boolean jjN()
    {
      return false;
    }
    
    public final boolean jjO()
    {
      AppMethodBeat.i(250945);
      boolean bool = MMActivity.this.isLayoutInDecorView();
      AppMethodBeat.o(250945);
      return bool;
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
  protected ViewGroup mWrappingFrame = null;
  private MMActivity.a onActResult = null;
  boolean transparentTheme = false;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      return;
    }
    finally
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
    return y.initLanguage(paramContext);
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    return y.initLanguage(paramContext, paramString);
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
  
  private void recreateSelf()
  {
    finish();
    overridePendingTransition(0, 0);
    MMHandlerThread.postToMainThreadDelayed(new MMActivity.2(this), 50L);
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
    getController().addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
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
    getController().addIconOptionMenu(paramInt1, paramString, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.a(paramInt1, paramInt2, paramString, paramBoolean, paramOnMenuItemClickListener, null, y.b.adEI);
  }
  
  public void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt, paramString, paramDrawable, paramOnMenuItemClickListener);
  }
  
  public void addOnConfigurationChangedListener(MMActivity.b paramb)
  {
    if (paramb != null) {
      this.mConfigChangedListeners.put(paramb, this);
    }
  }
  
  public void addSearchMenu(boolean paramBoolean, com.tencent.mm.ui.tools.s params)
  {
    this.mController.addSearchMenu(paramBoolean, params);
  }
  
  public void addTextOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    y localy = this.mController;
    y.b localb = y.b.adEI;
    y.a locala = new y.a();
    locala.advp = paramInt1;
    locala.text = paramString;
    locala.textColor = paramInt2;
    locala.pYf = paramOnMenuItemClickListener;
    locala.AkV = null;
    locala.adEH = localb;
    localy.aAl(locala.advp);
    localy.advg.add(locala);
    new MMHandler().postDelayed(new y.12(localy), 200L);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, View.OnTouchListener paramOnTouchListener, y.b paramb)
  {
    y localy = this.mController;
    y.a locala = new y.a();
    locala.advp = paramInt;
    locala.advq = 0;
    locala.text = paramString;
    locala.pYf = paramOnMenuItemClickListener;
    locala.AkV = paramOnLongClickListener;
    locala.DIP = paramOnTouchListener;
    locala.adEH = paramb;
    locala.ihQ = false;
    if (((locala.advq == a.f.mm_title_btn_menu) || (locala.advq == a.j.icons_outlined_more) || (locala.advq == a.j.actionbar_icon_dark_more)) && (Util.isNullOrNil(paramString))) {
      locala.text = localy.mContext.getString(a.k.app_more);
    }
    localy.aAl(locala.advp);
    localy.advg.add(locala);
    localy.supportInvalidateOptionsMenu();
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, y.b paramb)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    com.tencent.mm.compatible.util.h.aQi();
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
    y localy = this.mController;
    if ((!localy.noActionBar()) && (localy.dlE < localy.adve))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localy.dlE, localy.adve }).setDuration(200L);
      localValueAnimator.addUpdateListener(new y.13(localy));
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
    return this.mController.jjR();
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
    return this.mController.DOL;
  }
  
  public f getBounceView()
  {
    return this.mController.adDT;
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
      Object localObject4 = new com.tencent.mm.compatible.loader.b(this, "mReferrer", null).get();
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
    return this.mController.getContentView();
  }
  
  public AppCompatActivity getContext()
  {
    return this.mController.getContext();
  }
  
  public y getController()
  {
    return this.mController;
  }
  
  public int getCurrentActionbarHeight()
  {
    return this.mController.dlE;
  }
  
  protected int getCustomBounceId()
  {
    return -1;
  }
  
  protected int getForceOrientation()
  {
    return -1;
  }
  
  public Activity getHostActivity()
  {
    return this;
  }
  
  protected String getIdentString()
  {
    return "";
  }
  
  public abstract int getLayoutId();
  
  protected View getLayoutView()
  {
    return null;
  }
  
  public TextView getMMSubTitle()
  {
    return this.mController.uCY;
  }
  
  public CharSequence getMMTitle()
  {
    return this.mController.getMMTitle();
  }
  
  public TextView getMMTitleView()
  {
    return this.mController.adDZ;
  }
  
  public com.tencent.mm.ui.base.s getMenu()
  {
    return this.mController.jjQ();
  }
  
  public Resources getResources()
  {
    if (getBaseContext() != null)
    {
      Object localObject2 = getBaseContext().getResources();
      Resources localResources = super.getResources();
      Object localObject1 = localResources;
      if ((localResources instanceof com.tencent.mm.ce.d))
      {
        localObject1 = localResources;
        if (localObject2 != null)
        {
          localObject1 = (com.tencent.mm.ce.d)localResources;
          localObject2 = ((com.tencent.mm.ce.d)localObject1).acma.h(((Resources)localObject2).getConfiguration());
          e.a((Configuration)localObject2, aw.f(localResources));
          ((com.tencent.mm.ce.d)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
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
    return bf.I(this, paramInt);
  }
  
  public int getStreamMaxVolume(int paramInt)
  {
    return this.mController.getStreamMaxVolume(paramInt);
  }
  
  public int getStreamVolume(int paramInt)
  {
    return this.mController.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return com.tencent.mm.ui.widget.d.c(super.getSupportActionBar());
  }
  
  public int getTitleLocation()
  {
    return this.mController.getTitleLocation();
  }
  
  public void hideActionBarOperationArea()
  {
    if (this.mController != null) {
      this.mController.hideActionBarOperationArea();
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
      y localy = this.mController;
      if (localy.adEg != null) {
        localy.adEg.setVisibility(0);
      }
      if (localy.aduT != null) {
        localy.aduT.setVisibility(8);
      }
    }
  }
  
  public void initActionBarOperationAreaTxt(String paramString)
  {
    if (this.mController != null)
    {
      y localy = this.mController;
      if (localy.adEh != null) {
        localy.adEh.afRU.setText(paramString);
      }
    }
  }
  
  public void initActionBarOperationAreaTxt(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mController != null)
    {
      Object localObject = this.mController;
      if (((y)localObject).adEh != null)
      {
        localObject = ((y)localObject).adEh;
        ((AlbumChooserView)localObject).afRU.setText(paramString);
        ((AlbumChooserView)localObject).afRU.setTextColor(((AlbumChooserView)localObject).getContext().getResources().getColor(paramInt1));
        ((LinearLayout)((AlbumChooserView)localObject).afRU.getParent()).setBackground(((AlbumChooserView)localObject).getContext().getResources().getDrawable(paramInt4));
        ((AlbumChooserView)localObject).afRV.setIconColor(((AlbumChooserView)localObject).getContext().getResources().getColor(paramInt2));
        ((FrameLayout)((AlbumChooserView)localObject).afRV.getParent()).setBackground(((AlbumChooserView)localObject).getContext().getResources().getDrawable(paramInt3));
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
  
  public boolean isActionbarCenterLayoutMode()
  {
    return true;
  }
  
  public boolean isActionbarMenuUseOriginalSys()
  {
    return false;
  }
  
  protected boolean isForceFixStatusBar()
  {
    return false;
  }
  
  public boolean isLayoutInDecorView()
  {
    return false;
  }
  
  public boolean isOptionMenuEnable(int paramInt)
  {
    Iterator localIterator = this.mController.advg.iterator();
    while (localIterator.hasNext())
    {
      y.a locala = (y.a)localIterator.next();
      if (locala.advp == paramInt) {
        return locala.enable;
      }
    }
    return false;
  }
  
  public boolean isOptionMenuShow(int paramInt)
  {
    Iterator localIterator = this.mController.advg.iterator();
    while (localIterator.hasNext())
    {
      y.a locala = (y.a)localIterator.next();
      if (locala.advp == paramInt) {
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
    return this.mController.adDI;
  }
  
  public boolean isShowDialog()
  {
    Object localObject = this.mController;
    if (((y)localObject).upT == null) {
      return false;
    }
    localObject = ((y)localObject).upT.iterator();
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
    y localy = this.mController;
    return (localy.mActionBar != null) && (localy.mActionBar.getCustomView() != null) && (localy.mActionBar.getCustomView().findViewById(a.g.action_bar_single_title) != null);
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
    return this.mController.adEr;
  }
  
  public void mmSetOnActivityResultCallback(MMActivity.a parama)
  {
    this.onActResult = parama;
  }
  
  public void mmStartActivityForResult(MMActivity.a parama, Intent paramIntent, int paramInt)
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
      this.onActResult.mmOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    this.onActResult = null;
  }
  
  public void onBusinessPermissionDenied(String paramString)
  {
    finish();
  }
  
  public void onBusinessPermissionGranted(String paramString)
  {
    if (getCallingActivity() == null)
    {
      recreateSelf();
      return;
    }
    recreate();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.mConfigChangedListeners.isEmpty())
    {
      paramConfiguration = (MMActivity.b[])this.mConfigChangedListeners.keySet().toArray(new MMActivity.b[this.mConfigChangedListeners.size()]);
      int j = paramConfiguration.length;
      int i = 0;
      while (i < j)
      {
        paramConfiguration[i].dG();
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (!this.customfixStatusbar) {
      this.fixStatusbar = true;
    }
    getController().adEn = a.h.actionbar_title_center;
    super.onCreate(paramBundle);
    if ((isHideStatusBar()) && (!isForceFixStatusBar())) {
      this.fixStatusbar = false;
    }
    this.mController.a(getApplicationContext(), this);
    initNavigationSwipeBack();
    if (!noActionBar())
    {
      setActionbarColor(getResources().getColor(a.d.normal_actionbar_color));
      setMMTitleSize(com.tencent.mm.cd.a.bs(this, a.e.ActionBarTextSize) * com.tencent.mm.cd.a.jO(this));
    }
    paramBundle = i.agtt;
    if (i.a(b.a.agqu, 0) == 1) {
      aa.makeText(this, getClass().getSimpleName(), 0).show();
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
    this.mController.mQ(this);
    this.mConfigChangedListeners.clear();
  }
  
  public void onDialogDismiss(Dialog paramDialog) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mController.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
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
    au.eb(2, this.className);
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
    au.eb(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    Log.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    Log.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(hashCode()) });
    noteOnResumeTicks();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT < 11) || (isCallSuperOnSaveInstanceState())) {
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
      if (((y)localObject).adEh != null)
      {
        localObject = ((y)localObject).adEh;
        if (!((AlbumChooserView)localObject).afRW)
        {
          ((AlbumChooserView)localObject).afRW = true;
          ((AlbumChooserView)localObject).afRV.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.2((AlbumChooserView)localObject)).start();
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
  
  public void removeOnConfigurationChangedListener(MMActivity.b paramb)
  {
    if (paramb != null) {
      this.mConfigChangedListeners.remove(paramb);
    }
  }
  
  public boolean removeOptionMenu(int paramInt)
  {
    return this.mController.removeOptionMenu(paramInt);
  }
  
  public void removeSearchMenu()
  {
    y localy = this.mController;
    y.a locala = new y.a();
    locala.advp = a.g.menu_search;
    locala.text = localy.mContext.getString(a.k.app_search);
    locala.advq = a.j.actionbar_icon_dark_search;
    locala.pYf = null;
    locala.AkV = null;
    localy.removeOptionMenu(locala.advp);
    localy.supportInvalidateOptionsMenu();
  }
  
  public void setActionBarOperationAreaClickListener(AlbumChooserView.a parama)
  {
    if (this.mController != null)
    {
      y localy = this.mController;
      if (localy.adEh != null) {
        localy.adEh.setOnAlbumChooserViewClick(parama);
      }
    }
  }
  
  public void setActionbarColor(int paramInt)
  {
    this.mController.setActionbarColor(paramInt);
    if ((getCustomBounceId() == -1) && (getBounceView() != null)) {
      getBounceView().setStart2EndBgColorByActionBar(paramInt);
    }
  }
  
  public void setActionbarElementColor(int paramInt)
  {
    y localy = this.mController;
    localy.adEd = paramInt;
    localy.adEj = true;
    if (localy.adEb != null) {
      localy.adEb.setIconColor(paramInt);
    }
    if ((localy.adDZ != null) && (localy.adDZ.getVisibility() == 0)) {
      localy.adDZ.setTextColor(paramInt);
    }
    if ((localy.uCY != null) && (localy.uCY.getVisibility() == 0)) {
      localy.uCY.setTextColor(paramInt);
    }
    if ((localy.aduV != null) && (localy.aduV.getVisibility() == 0)) {
      localy.aduV.setIconColor(paramInt);
    }
    while ((localy.aduW == null) || (localy.aduW.getVisibility() != 0)) {
      return;
    }
    localy.aduW.setTextColor(paramInt);
  }
  
  public void setActionbarHeight(int paramInt)
  {
    this.mController.aAn(paramInt);
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
    y localy = this.mController;
    if (localy.adEb != null) {
      localy.adEb.setIconColor(localy.mContext.getResources().getColor(paramInt));
    }
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
  
  public void setBounceEnabled(boolean paramBoolean)
  {
    this.mController.setBounceEnabled(paramBoolean);
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
  
  protected void setCurController(y paramy)
  {
    this.mController = paramy;
  }
  
  public void setIconAlpha(float paramFloat)
  {
    y localy = this.mController;
    if (localy.adEa != null)
    {
      localy.adEa.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label64;
      }
      localy.adEa.setEnabled(false);
    }
    for (;;)
    {
      if (localy.aduV != null)
      {
        localy.aduV.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        localy.aduV.setEnabled(false);
      }
      return;
      label64:
      localy.adEa.setEnabled(true);
    }
    localy.aduV.setEnabled(true);
  }
  
  public void setIsDarkActionbarBg(boolean paramBoolean)
  {
    this.mController.Li(paramBoolean);
  }
  
  public void setLightNavigationbarIcon()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((y)localObject).adDS.getWindow().getDecorView();
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
        if (aw.jkT()) {
          bh.aDU(1);
        }
        setRequestedOrientation(-1);
        return;
      }
      if (aw.jkT()) {
        bh.aDU(0);
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
    super.setTitle(paramInt);
    this.mController.setMMTitle(paramInt);
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.mController.setMMTitle(paramCharSequence);
  }
  
  public void setMMTitle(String paramString)
  {
    super.setTitle(paramString);
    this.mController.setMMTitle(paramString);
  }
  
  public void setMMTitleColor(int paramInt)
  {
    this.mController.setMMTitleColor(paramInt);
  }
  
  public void setMMTitleSize(float paramFloat)
  {
    y localy = this.mController;
    if ((localy.mActionBar != null) && (localy.adDZ != null)) {
      localy.adDZ.setTextSize(0, paramFloat);
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
    y localy = this.mController;
    if (localy.mActionBar != null) {
      localy.adEc.setIndeterminateDrawable(localy.getContext().getDrawable(paramInt));
    }
  }
  
  public void setProgressVisibility(int paramInt)
  {
    y localy = this.mController;
    if (localy.mActionBar != null) {
      localy.adEc.setVisibility(paramInt);
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
    if (!bf.bg(getContext()))
    {
      Log.w("MicroMsg.MMActivity", "has not NavigationBar!");
      return;
    }
    if (this.mSelfNavigationBar == null)
    {
      this.mSelfNavigationBar = new View(getContext());
      ((ViewGroup)getWindow().getDecorView()).addView(this.mSelfNavigationBar);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, bf.bk(getContext()));
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
      y localy = this.mController;
      Log.d("MicroMsg.MMActivityController", "set smart gallery entry valid.");
      localy.adDU = paramBoolean;
      localy.supportInvalidateOptionsMenu();
    }
  }
  
  public void setTitleAlpha(float paramFloat)
  {
    y localy = this.mController;
    if (localy.adDZ != null) {
      localy.adDZ.setAlpha(paramFloat);
    }
  }
  
  public void setTitleBarClickListener(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    y localy = this.mController;
    if (localy.mActionBar == null) {
      return;
    }
    localy.mActionBar.getCustomView().setOnClickListener(new y.8(localy, paramRunnable1, paramRunnable2));
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
    y localy = this.mController;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localy.adDQ = bool;
      localy.jjT();
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
    y localy = this.mController;
    localy.adEb.setVisibility(8);
    localy.adEa.setVisibility(8);
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
    y.showVKB(this.mController.adDS);
  }
  
  public void startActivity(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramClass.aYi(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramClass.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void startActivity(Class<?> paramClass, Intent paramIntent)
  {
    paramIntent.setClass(this, paramClass);
    paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramClass.aYi(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramClass.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.ui.a.h.class);
  }
  
  public void supportLightStatusBar()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((y)localObject).adDS.getWindow().getDecorView();
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
      if (((y)localObject).adEh != null)
      {
        localObject = ((y)localObject).adEh;
        if (!((AlbumChooserView)localObject).afRW)
        {
          ((AlbumChooserView)localObject).afRW = true;
          ((AlbumChooserView)localObject).afRV.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.3((AlbumChooserView)localObject, paramString)).start();
        }
      }
    }
  }
  
  public void updateBackBtn(Drawable paramDrawable)
  {
    y localy = this.mController;
    if ((localy.mActionBar != null) && (localy.adEb != null) && (paramDrawable != null))
    {
      localy.adEb.setImageDrawable(paramDrawable);
      paramDrawable.invalidateSelf();
    }
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
  
  public void updateOptionMenuStyle(int paramInt, y.b paramb)
  {
    y localy = this.mController;
    y.a locala = localy.aAm(paramInt);
    if (locala != null)
    {
      locala.adEH = paramb;
      localy.supportInvalidateOptionsMenu();
    }
  }
  
  public void updateOptionMenuText(int paramInt, String paramString)
  {
    this.mController.updateOptionMenuText(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.MMActivity
 * JD-Core Version:    0.7.0.1
 */