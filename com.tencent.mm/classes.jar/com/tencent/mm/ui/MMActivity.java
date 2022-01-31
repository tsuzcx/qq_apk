package com.tencent.mm.ui;

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
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.widget.input.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity
  extends MMFragmentActivity
  implements ac
{
  private static String uMt;
  String className;
  public a gJb = null;
  public s mController = new s()
  {
    protected final String bdI()
    {
      return MMActivity.this.bdI();
    }
    
    protected final boolean czg()
    {
      return MMActivity.this.czg();
    }
    
    protected final void dealContentView(View paramAnonymousView)
    {
      MMActivity.this.dealContentView(paramAnonymousView);
    }
    
    protected final String getClassName()
    {
      return MMActivity.this.getClass().getName();
    }
    
    protected final int getLayoutId()
    {
      return MMActivity.this.getLayoutId();
    }
    
    protected final View getLayoutView()
    {
      return MMActivity.getLayoutView();
    }
    
    public final boolean needShowIdcError()
    {
      return MMActivity.this.needShowIdcError();
    }
    
    public final boolean noActionBar()
    {
      return MMActivity.this.noActionBar();
    }
    
    protected final void onCreateBeforeSetContentView()
    {
      MMActivity.this.onCreateBeforeSetContentView();
    }
    
    public final void onKeyboardStateChanged()
    {
      MMActivity.this.onKeyboardStateChanged();
    }
  };
  public boolean uMo = false;
  public boolean uMp = false;
  private ViewGroup uMq = null;
  public boolean uMr = false;
  private View uMs;
  private long uMu = 0L;
  private long uMv = 0L;
  private long uMw = 0L;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      uMt = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return;
    }
    catch (Throwable localThrowable)
    {
      uMt = null;
    }
  }
  
  public static Locale by(Context paramContext, String paramString)
  {
    return s.by(paramContext, paramString);
  }
  
  private static String czh()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    return String.format("Runtime: [%s:%s:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2) });
  }
  
  public static void czj() {}
  
  protected static View getLayoutView()
  {
    return null;
  }
  
  public static boolean gq(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      bool1 = localResources.getBoolean(i);
      if ("1".equals(uMt))
      {
        bool1 = false;
        if ((!bool1) || (bool2) || (ViewConfiguration.get(paramContext).hasPermanentMenuKey())) {
          break label83;
        }
      }
    }
    label83:
    while ((!ViewConfiguration.get(paramContext).hasPermanentMenuKey()) && (!bool2))
    {
      for (;;)
      {
        boolean bool1;
        return true;
        if ("0".equals(uMt)) {
          bool1 = true;
        }
      }
      return false;
    }
    return false;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return s.initLanguage(paramContext);
  }
  
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
  
  public final void FP(int paramInt)
  {
    this.mController.uMS.setVisibility(paramInt);
  }
  
  public final void FQ(int paramInt)
  {
    this.mController.setTitleLogo(0, paramInt);
  }
  
  public final void FR(int paramInt)
  {
    s locals = this.mController;
    locals.uMX = paramInt;
    if (locals.uMV != null) {
      locals.uMV.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    if ((locals.uMS != null) && (locals.uMS.getVisibility() == 0)) {
      locals.uMS.setTextColor(paramInt);
    }
    if ((locals.uMW != null) && (locals.uMW.getVisibility() == 0)) {
      locals.uMW.setTextColor(paramInt);
    }
    if ((locals.uGM != null) && (locals.uGM.getVisibility() == 0)) {
      locals.uGM.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    while ((locals.uGO == null) || (locals.uGO.getVisibility() != 0)) {
      return;
    }
    locals.uGO.setTextColor(paramInt);
  }
  
  public final void FS(int paramInt)
  {
    if (this.uMs != null) {
      this.uMs.setVisibility(paramInt);
    }
  }
  
  public final void N(CharSequence paramCharSequence)
  {
    this.mController.N(paramCharSequence);
  }
  
  public boolean Wt()
  {
    return false;
  }
  
  public void XM()
  {
    this.mController.hideVKB();
  }
  
  public final void Y(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    startActivity(localIntent);
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    s locals = this.mController;
    s.b localb = s.b.uNw;
    s.a locala = new s.a();
    locala.uHd = paramInt1;
    locala.text = paramString;
    locala.textColor = paramInt2;
    locala.fkl = paramOnMenuItemClickListener;
    locala.kfL = null;
    locala.uNu = localb;
    locals.FT(locala.uHd);
    locals.uGV.add(locala);
    new ah().postDelayed(new s.6(locals), 200L);
  }
  
  public final void a(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    s locals = this.mController;
    s.b localb = s.b.uNw;
    s.a locala = new s.a();
    locala.uHd = paramInt;
    locala.uNt = paramDrawable;
    locala.text = paramString;
    locala.fkl = paramOnMenuItemClickListener;
    locala.kfL = null;
    locala.uNu = localb;
    locals.FT(locala.uHd);
    locals.uGV.add(locala);
    new ah().postDelayed(new s.5(locals), 200L);
  }
  
  public final void a(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, s.b paramb)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, null, paramb);
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.updateOptionMenuListener(1, paramOnMenuItemClickListener, null);
  }
  
  public final void a(n paramn)
  {
    this.mController.addSearchMenu(true, paramn);
  }
  
  public final void a(Class<?> paramClass, Intent paramIntent)
  {
    paramIntent.setClass(this, paramClass);
    startActivity(paramIntent);
  }
  
  public final void a(String paramString, int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(0, paramString, paramInt, paramOnMenuItemClickListener);
  }
  
  public void addDialog(Dialog paramDialog)
  {
    this.mController.addDialog(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void ahA()
  {
    if (getForceOrientation() == -1)
    {
      this.uMo = getSharedPreferences(ae.cqR(), 0).getBoolean("settings_landscape_mode", false);
      if (this.uMo)
      {
        setRequestedOrientation(-1);
        return;
      }
      setRequestedOrientation(1);
      return;
    }
    setRequestedOrientation(getForceOrientation());
  }
  
  public final boolean ass()
  {
    return this.mController.hideVKB();
  }
  
  public final void b(a parama, Intent paramIntent, int paramInt)
  {
    this.gJb = parama;
    startActivityForResult(paramIntent, paramInt);
  }
  
  public final void b(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    s locals = this.mController;
    if (locals.mActionBar == null) {
      return;
    }
    locals.mActionBar.getCustomView().setOnClickListener(new s.3(locals, paramRunnable1, paramRunnable2));
  }
  
  public String bdI()
  {
    return "";
  }
  
  public boolean czg()
  {
    return false;
  }
  
  public final AppCompatActivity czi()
  {
    return this.mController.uMN;
  }
  
  public final void czk()
  {
    Object localObject = this.mController;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = ((s)localObject).uMN.getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x2000);
    }
  }
  
  public final boolean czl()
  {
    Iterator localIterator = this.mController.uGV.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
      if (locala.uHd == 0) {
        return locala.bIU;
      }
    }
    return false;
  }
  
  public final boolean czm()
  {
    Iterator localIterator = this.mController.uGV.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
      if (locala.uHd == 0) {
        return locala.aoL;
      }
    }
    return false;
  }
  
  public final void czn()
  {
    s locals = this.mController;
    if (locals.uMV != null) {
      locals.uMV.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void czo()
  {
    s locals = this.mController;
    if (Build.VERSION.SDK_INT >= 21) {
      locals.getSupportActionBar().setElevation(0.0F);
    }
  }
  
  public final void czp()
  {
    s locals = this.mController;
    if (Build.VERSION.SDK_INT >= 21) {
      locals.getSupportActionBar().setElevation(1.0F);
    }
  }
  
  public final int czq()
  {
    return this.mController.czv();
  }
  
  public final void czr()
  {
    s locals = this.mController;
    locals.uMV.setVisibility(8);
    locals.uMU.setVisibility(8);
  }
  
  public final void czs()
  {
    int k = 0;
    if (!gq(this.mController.uMN))
    {
      y.w("MicroMsg.MMActivity", "has not NavigationBar!");
      return;
    }
    if (this.uMs == null)
    {
      this.uMs = new View(this.mController.uMN);
      ((ViewGroup)getWindow().getDecorView()).addView(this.uMs);
    }
    Object localObject = this.mController.uMN;
    Resources localResources = ((Context)localObject).getResources();
    int j;
    int i;
    if (localResources.getConfiguration().orientation == 1)
    {
      j = 1;
      i = k;
      if (Build.VERSION.SDK_INT >= 14)
      {
        i = k;
        if (gq((Context)localObject)) {
          if (j == 0) {
            break label204;
          }
        }
      }
    }
    label204:
    for (localObject = "navigation_bar_height";; localObject = "navigation_bar_height_landscape")
    {
      j = localResources.getIdentifier((String)localObject, "dimen", "android");
      i = k;
      if (j > 0) {
        i = localResources.getDimensionPixelSize(j);
      }
      localObject = new FrameLayout.LayoutParams(-1, i);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      this.uMs.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.uMs.setBackgroundColor(-637534208);
      this.uMs.setVisibility(8);
      return;
      j = 0;
      break;
    }
  }
  
  public final String czt()
  {
    localObject1 = "";
    Object localObject2 = getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      y.i("MicroMsg.MMActivity", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (bk.bl((String)localObject1))
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT < 22) {}
    }
    try
    {
      localObject2 = new c(this, "mReferrer", null).get();
      if (localObject2 == null) {
        break label157;
      }
      localObject2 = (String)localObject2;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Uri localUri;
        y.printErrStackTrace("MicroMsg.MMActivity", localException, "get mReferrer error", new Object[0]);
        Object localObject3 = localObject1;
      }
    }
    localObject2 = localObject1;
    localObject1 = localObject2;
    if (bk.bl((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        localUri = getReferrer();
        localObject1 = localObject2;
        if (localUri != null)
        {
          localObject1 = localUri.getAuthority();
          y.i("MicroMsg.MMActivity", "get referrer, %s", new Object[] { localObject1 });
        }
      }
    }
    return localObject1;
  }
  
  public final long czu()
  {
    if (this.uMv != 0L) {}
    for (long l = this.uMv - this.uMu + this.uMw;; l = bk.UZ() - this.uMu + this.uMw)
    {
      if (l < 0L) {
        y.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l), Long.valueOf(this.uMu), Long.valueOf(this.uMv), Long.valueOf(this.uMw) });
      }
      y.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
      return l;
    }
  }
  
  public void dealContentView(View paramView)
  {
    setContentView(paramView);
  }
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    this.mController.enableBackMenu(paramBoolean);
  }
  
  public final void enableOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.c(false, paramInt, paramBoolean);
  }
  
  public final void enableOptionMenu(boolean paramBoolean)
  {
    this.mController.c(true, -1, paramBoolean);
  }
  
  public void finish()
  {
    super.finish();
    int i = t.a(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
    int j = t.a(getIntent(), "MMActivity.OverrideExitAnimation", -1);
    if (i != -1) {
      super.overridePendingTransition(i, j);
    }
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean)
  {
    this.mController.fullScreenNoTitleBar(paramBoolean);
  }
  
  public final View getContentView()
  {
    return this.mController.contentView;
  }
  
  public int getForceOrientation()
  {
    return -1;
  }
  
  public abstract int getLayoutId();
  
  public void hideVKB(View paramView)
  {
    this.mController.hideVKB(paramView);
  }
  
  public void initSwipeBack()
  {
    super.initSwipeBack();
    View localView;
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      if (!this.uMp) {
        break label97;
      }
    }
    label97:
    for (this.uMq = new b(this);; this.uMq = new FrameLayout(this))
    {
      this.uMq.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.uMq);
      getSwipeBackLayout().setContentView(this.uMq);
      return;
    }
  }
  
  @Deprecated
  public void initView() {}
  
  public final void mS(boolean paramBoolean)
  {
    s locals = this.mController;
    locals.nST = paramBoolean;
    locals.czC();
    locals.czB();
  }
  
  public final void mT(boolean paramBoolean)
  {
    s locals = this.mController;
    if (locals.uMV != null)
    {
      if (paramBoolean) {
        locals.uMV.setVisibility(0);
      }
    }
    else {
      return;
    }
    locals.uMV.setVisibility(8);
  }
  
  public boolean needShowIdcError()
  {
    return true;
  }
  
  public boolean noActionBar()
  {
    return false;
  }
  
  public void oX(int paramInt)
  {
    s locals = this.mController;
    if (locals.mActionBar != null) {
      locals.uMS.setTextColor(paramInt);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.gJb != null) {
      this.gJb.c(paramInt1, paramInt2, paramIntent);
    }
    this.gJb = null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.a(getApplicationContext(), this);
    y.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bk.fW(this), czh() });
    initNavigationSwipeBack();
  }
  
  public void onCreateBeforeSetContentView() {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.mController.onCreateOptionsMenu(paramMenu)) {
      return true;
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bk.fW(this), czh() });
    super.onDestroy();
    this.mController.onDestroy();
    this.uMr = true;
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
      y.printErrStackTrace("MicroMsg.MMActivity", paramKeyEvent, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
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
    ai.be(2, this.className);
    super.onPause();
    this.mController.onPause();
    boolean bool = isFinishing();
    y.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
    this.uMv = bk.UZ();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.mController.onPrepareOptionsMenu(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    long l = System.currentTimeMillis();
    ai.be(1, this.className);
    super.onResume();
    y.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    y.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(hashCode()) });
    if (this.uMv > this.uMu) {
      this.uMw += this.uMv - this.uMu;
    }
    this.uMu = bk.UZ();
    this.uMv = 0L;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    ahA();
    super.onStart();
  }
  
  public void onSwipeBack()
  {
    if (!Wt()) {
      this.mController.callBackMenu();
    }
    super.onSwipeBack();
  }
  
  public final void removeAllOptionMenu()
  {
    this.mController.removeAllOptionMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    return this.mController.removeOptionMenu(paramInt);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.setBackBtn(paramOnMenuItemClickListener, 0);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    this.mController.setBackBtn(paramOnMenuItemClickListener, paramInt);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    this.mController.setBackGroundColorResource(paramInt);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    this.mController.setMMSubTitle(paramInt);
  }
  
  public void setMMSubTitle(String paramString)
  {
    this.mController.setMMSubTitle(paramString);
  }
  
  public void setMMTitle(int paramInt)
  {
    this.mController.setMMTitle(paramInt);
  }
  
  public void setMMTitle(String paramString)
  {
    this.mController.setMMTitle(paramString);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    this.mController.setScreenEnable(paramBoolean);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    this.mController.setTitleBarDoubleClickListener(paramRunnable);
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    this.mController.setTitleMuteIconVisibility(paramInt);
  }
  
  public final void setTitleVisibility(int paramInt)
  {
    this.mController.setTitleVisibility(paramInt);
  }
  
  public final void showHomeBtn(boolean paramBoolean)
  {
    this.mController.showHomeBtn(paramBoolean);
  }
  
  public final void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.d(false, paramInt, paramBoolean);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    this.mController.d(true, -1, paramBoolean);
  }
  
  public void showVKB()
  {
    this.mController.showVKB();
  }
  
  public void ta(int paramInt)
  {
    this.mController.ta(paramInt);
    if ((this.uMp) && (Build.VERSION.SDK_INT >= 21) && (getWindow() != null)) {
      com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getWindow().getStatusBarColor(), d.c(getWindow()));
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    this.mController.updateOptionMenuText(paramInt, paramString);
  }
  
  public void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.mController.showTitleView();
      return;
    }
    this.mController.hideTitleView();
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