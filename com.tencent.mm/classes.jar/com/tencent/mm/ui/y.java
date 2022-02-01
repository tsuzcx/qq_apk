package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.autogen.a.ay.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.WXActionMenuView.a;
import com.tencent.mm.ui.widget.WXActionMenuView.a.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.MMWeUIBounceView;
import com.tencent.mm.util.b.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.n.n;

public abstract class y
{
  private static boolean adDY = false;
  private static final int adEo = a.h.actionbar_title_single_text;
  public static long adEq;
  private static byte[] adEs = { 0 };
  private static PowerManager.WakeLock wakeLock = null;
  View DOL;
  private String JAf = " ";
  private AudioManager Jey;
  private boolean LuL = false;
  protected MMHandler NBu = new MMHandler(Looper.getMainLooper());
  private int WHg = 0;
  private final long WZx = 300L;
  public int WoL = -1;
  private View actionbarView;
  private long adBa = SystemClock.elapsedRealtime();
  private View adDE;
  private View adDF;
  private TextView adDG;
  public FrameLayout adDH;
  public boolean adDI = true;
  private int adDJ = 0;
  private int adDK = 0;
  private com.tencent.mm.ui.widget.a adDL = null;
  private com.tencent.mm.ui.widget.a adDM = null;
  private com.tencent.mm.ui.widget.a adDN = null;
  private com.tencent.mm.ui.widget.a adDO = null;
  private com.tencent.mm.ui.widget.a adDP = null;
  boolean adDQ = false;
  private boolean adDR = false;
  public AppCompatActivity adDS;
  protected com.tencent.mm.ui.widget.pulldown.f adDT;
  boolean adDU = false;
  public boolean adDV;
  private a adDW = new a();
  private com.tencent.mm.ui.tools.a adDX;
  public TextView adDZ;
  View adEa;
  public WeImageView adEb;
  ProgressBar adEc;
  int adEd = 0;
  private ImageView adEe;
  private ViewGroup.LayoutParams adEf;
  View adEg;
  AlbumChooserView adEh;
  private View adEi;
  public boolean adEj = true;
  private int adEk = 0;
  private boolean adEl = false;
  private IListener adEm = new MMActivityController.1(this, com.tencent.mm.app.f.hfK);
  int adEn = a.h.actionbar_title_center;
  public int adEp = -1;
  int adEr = 0;
  private a adEt;
  private MenuItem adEu;
  private Runnable adEv = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141334);
      y.j(y.this).getWindow().setFlags(1024, 1024);
      if (y.k(y.this) != null) {
        y.k(y.this).hide();
      }
      AppMethodBeat.o(141334);
    }
  };
  private Runnable adEw = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(249484);
      if (y.k(y.this) != null) {
        y.k(y.this).show();
      }
      AppMethodBeat.o(249484);
    }
  };
  boolean adEx = false;
  View aduT;
  WeImageView aduV;
  TextView aduW;
  private boolean advd = false;
  int adve;
  private int advf;
  LinkedList<a> advg = new LinkedList();
  private boolean bounceEnable = true;
  String className;
  private View contentView;
  int dlE = this.adve;
  private boolean ehd = false;
  public com.tencent.mm.ui.tools.s lMw;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  private LayoutInflater pUI;
  TextView uCY;
  ArrayList<Dialog> upT;
  int uxT = 0;
  private Button zWj;
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.advd) {
      localDrawable = bb.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, bd.bs(getContext(), a.e.Edge_2A), bd.bs(getContext(), a.e.Edge_2A));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable, 1);
    paramDrawable.afSg = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.advp = paramInt;
    locala.adEG = paramDrawable;
    locala.text = paramString;
    locala.pYf = paramOnMenuItemClickListener;
    locala.AkV = null;
    locala.adEH = paramb;
    aAl(locala.advp);
    this.advg.add(locala);
    new MMHandler().postDelayed(new y.10(this), 200L);
  }
  
  private void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, String paramString3, int paramInt2, boolean paramBoolean2)
  {
    Log.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.adDF });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.adDF == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      Log.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.adDH == null) {
      this.adDH = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    if (this.adDF != null) {
      this.adDH.removeView(this.adDF);
    }
    int i = a.h.mmnotify_view;
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.adDF = this.pUI.inflate(paramInt1, null);
      this.adDG = ((TextView)this.adDF.findViewById(a.g.notify_text));
      this.adDF.findViewById(a.g.notify_btn).setOnClickListener(new y.11(this, paramString3, paramInt2));
      this.adDF.setOnClickListener(new y.14(this, paramString1));
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.adEl) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.adDS, 48.0F), 0, 0);
        Log.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.adDH.addView(this.adDF, this.adDH.getChildCount(), paramString3);
      if (this.adDF == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.adDF;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(a.k.idc_url);
          paramString3 = paramString2;
          if (Util.isNullOrNil(paramString2)) {
            paramString3 = this.mContext.getString(a.k.disaster_default_tips_default);
          }
          if (paramString1 == null) {
            break label493;
          }
          paramString1 = new SpannableString(paramString3 + str);
          paramString2 = new ForegroundColorSpan(-10119449);
          paramInt1 = paramString3.length();
          paramInt2 = paramString3.length();
          paramString1.setSpan(paramString2, paramInt1, str.length() + paramInt2, 33);
          this.adDG.setText(paramString1);
        }
        for (;;)
        {
          this.adDF.invalidate();
          this.adDH.invalidate();
          return;
          paramInt1 = 8;
          break;
          label493:
          Log.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.adDG.setText(paramString3);
        }
      }
      this.adDF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141344);
          Object localObject = y.b(y.this);
          int i;
          if (paramBoolean1)
          {
            i = 0;
            ((View)localObject).setVisibility(i);
            String str = y.c(y.this).getString(a.k.idc_url);
            if (!Util.isNullOrNil(paramString2)) {
              break label172;
            }
            localObject = y.c(y.this).getString(a.k.disaster_default_tips_default);
            label65:
            if (paramString1 == null) {
              break label180;
            }
            SpannableString localSpannableString = new SpannableString((String)localObject + str);
            localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
            y.d(y.this).setText(localSpannableString);
          }
          for (;;)
          {
            y.b(y.this).invalidate();
            y.e(y.this).invalidate();
            AppMethodBeat.o(141344);
            return;
            i = 8;
            break;
            label172:
            localObject = paramString2;
            break label65;
            label180:
            Log.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
            y.d(y.this).setText((CharSequence)localObject);
          }
        }
      });
      return;
      paramInt1 = i;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.adDI) {
      Log.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.pYf == null) {
      return;
    }
    parama.pYf.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.adEj)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.clearColorFilter();
  }
  
  private void b(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if (this.adEj)
    {
      paramDrawable.setColorFilter(-1, paramMode);
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  private static boolean bO(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(a.c.themeName, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(a.k.transluent_theme))));
    return true;
  }
  
  private static boolean bP(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(a.c.themeName, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(a.k.full_transluent_theme))));
    return true;
  }
  
  private static boolean bQ(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(a.c.themeName, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(a.k.notitle_transluent_theme))));
    return true;
  }
  
  private static boolean bzM(String paramString)
  {
    String str1 = q.aPo();
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {}
    while ((!pV(str1, paramString)) && (!pV(str2, paramString))) {
      return false;
    }
    return true;
  }
  
  private void d(Menu paramMenu)
  {
    Log.i("MicroMsg.MMActivityController", "actionBarTitleCenter isActionbarMenuUseOriginalSys: %s.", new Object[] { Boolean.valueOf(isActionbarMenuUseOriginalSys()) });
    if (isActionbarMenuUseOriginalSys())
    {
      if (this.adDX != null) {
        this.adDX.b(getSupportActionBar());
      }
      a.a(getSupportActionBar(), isActionbarCenterLayoutMode(), this, paramMenu);
      return;
    }
    jjP();
    this.adDX.a(this.adDS, paramMenu, this);
  }
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.adDS.findViewById(paramInt);
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return initLanguage(paramContext, LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext));
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      LocaleUtil.updateApplicationResourceLocale(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = LocaleUtil.transLanguageToLocale(paramString);
    LocaleUtil.updateApplicationResourceLocale(paramContext, paramString);
    return paramString;
  }
  
  private void jjP()
  {
    if (this.adDX == null)
    {
      Log.i("MicroMsg.MMActivityController", "initCustomMenuHelper, init, mAppCompatActivity:%s", new Object[] { this.adDS });
      new WXActionMenuView.a.a();
      new WXActionMenuView.a.a().Nm(isActionbarCenterLayoutMode()).Nn(isActionbarMenuUseOriginalSys()).aEo(Math.max(this.adve, bd.bs(this.mContext, a.e.DefaultActionbarHeightPort)));
      WXActionMenuView.a locala = WXActionMenuView.a.a.afWq;
      this.adDX = new com.tencent.mm.ui.tools.a(this.adDS, locala);
    }
    if (this.adDX != null) {
      Log.i("MicroMsg.MMActivityController", "initCustomMenuHelper has init.");
    }
  }
  
  public static boolean jjS()
  {
    synchronized (adEs)
    {
      if (wakeLock != null)
      {
        bool = wakeLock.isHeld();
        return bool;
      }
      boolean bool = false;
    }
  }
  
  private void jjU()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.advd)
    {
      if (this.adEb != null)
      {
        localWeImageView = this.adEb;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.adDZ != null) && (this.adDZ.getVisibility() == 0)) {
        this.adDZ.setTextColor(this.mContext.getResources().getColor(a.d.actionbar_title_light_color));
      }
      if ((this.uCY != null) && (this.uCY.getVisibility() == 0)) {
        this.uCY.setTextColor(this.mContext.getResources().getColor(a.d.actionbar_title_light_color));
      }
      if ((this.aduV != null) && (this.aduV.getVisibility() == 0)) {
        if (this.aduV.getDrawable() != null) {
          b(this.aduV.getDrawable(), PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.aduV;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.aduW == null) || (this.aduW.getVisibility() != 0));
      this.aduW.setTextColor(com.tencent.mm.cd.a.l(this.mContext, a.d.actionbar_title_light_color_selector));
      return;
      if (this.adEb != null) {
        this.adEb.setIconColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
      }
      if ((this.adDZ != null) && (this.adDZ.getVisibility() == 0)) {
        this.adDZ.setTextColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
      }
      if ((this.uCY != null) && (this.uCY.getVisibility() == 0)) {
        this.uCY.setTextColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
      }
      if ((this.aduV != null) && (this.aduV.getVisibility() == 0))
      {
        this.aduV.setIconColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
        return;
      }
    } while ((this.aduW == null) || (this.aduW.getVisibility() != 0));
    this.aduW.setTextColor(com.tencent.mm.cd.a.l(this.mContext, a.d.black_text_color_selector));
  }
  
  private void jjV()
  {
    updataStatusBarIcon(this.advd);
  }
  
  public static boolean jjW()
  {
    return (bzM("y83a")) || (bzM("y83")) || (bzM("v1732a")) || (bzM("v1732t"));
  }
  
  private void mP(Context paramContext)
  {
    synchronized (adEs)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(32, "screen Lock");
      }
      if (!wakeLock.isHeld())
      {
        paramContext = wakeLock;
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, "com/tencent/mm/ui/MMActivityController", "acquireWakeLock", "(Landroid/content/Context;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
        paramContext.acquire();
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/MMActivityController", "acquireWakeLock", "(Landroid/content/Context;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
        Log.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      Log.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  private com.tencent.mm.ui.widget.a nW(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.advd) {
      localDrawable = bb.m(getContext(), paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable, 1);
    locala.afSg = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private static boolean pV(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return Util.isEqual(paramString1.toLowerCase(), paramString2.toLowerCase());
  }
  
  private void releaseWakeLock()
  {
    synchronized (adEs)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        PowerManager.WakeLock localWakeLock = wakeLock;
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/ui/MMActivityController", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/ui/MMActivityController", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        Log.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        wakeLock = null;
        return;
      }
      Log.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  public static void setMainProcess()
  {
    adDY = true;
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
  
  protected abstract String Dy();
  
  public final void Li(boolean paramBoolean)
  {
    this.advd = paramBoolean;
    jjV();
    jjU();
  }
  
  final void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.advp = paramInt1;
    locala.advq = paramInt2;
    locala.text = paramString;
    locala.pYf = paramOnMenuItemClickListener;
    locala.AkV = paramOnLongClickListener;
    locala.adEH = paramb;
    locala.ihQ = paramBoolean;
    if ((locala.advq == a.f.mm_title_btn_menu) || (locala.advq == a.j.icons_outlined_more) || (locala.advq == a.j.actionbar_icon_dark_more) || ((locala.advq == a.j.icons_outlined_help) && (Util.isNullOrNil(paramString)))) {
      locala.text = this.mContext.getString(a.k.app_more);
    }
    aAl(locala.advp);
    this.advg.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.adDS = paramAppCompatActivity;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject1 = this.adDS.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).layoutInDisplayCutoutMode = 1;
      this.adDS.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    boolean bool1;
    if (!noActionBar())
    {
      bool1 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
      MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (!bool1)
      {
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
      }
    }
    this.ehd = aw.f(paramAppCompatActivity.getResources());
    int i;
    label448:
    Object localObject2;
    label486:
    boolean bool2;
    if (paramAppCompatActivity != null)
    {
      if (!this.ehd) {
        break label1321;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && ((bO(paramAppCompatActivity)) || (((MMActivity)paramAppCompatActivity).transparentTheme))) {
        paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode_Transparent);
      }
    }
    else
    {
      onCreateBeforeSetContentView();
      this.className = getClass().getName();
      au.eb(3, this.className);
      initLanguage(paramContext);
      this.Jey = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.pUI = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.layout.b.bbG();
        this.contentView = com.tencent.mm.kiss.layout.b.d(paramAppCompatActivity, a.h.mm_activity);
      }
      this.adDE = this.contentView.findViewById(a.g.mm_trans_layer);
      this.adDH = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
      if (i != -1)
      {
        this.DOL = getLayoutView();
        if (this.DOL != null) {
          break label1413;
        }
        this.DOL = this.pUI.inflate(getLayoutId(), null);
        paramContext = this.DOL;
        localObject1 = com.tencent.mm.ui.widget.pulldown.d.aglB;
        localObject2 = Dy();
        CharSequence localCharSequence = (CharSequence)localObject2;
        if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
          break label1443;
        }
        i = 1;
        if (i != 0) {
          break label1448;
        }
        kotlin.g.b.s.u(localObject2, "name");
        localObject2 = com.tencent.mm.ui.widget.pulldown.d.bzX((String)localObject2);
        if (localObject2 == null) {
          break label1448;
        }
        i = ((com.tencent.mm.ui.widget.pulldown.d)localObject1).ci((Class)localObject2);
        label518:
        if ((i & 0x1) == 0) {
          break label1453;
        }
        bool1 = true;
        label527:
        if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zum, b.a.agqw, 1) != 1) {
          break label1459;
        }
        bool2 = true;
        label555:
        Log.i("MicroMsg.MMActivityController", "bounceCreate: %s %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.bounceEnable) });
        this.bounceEnable = (bool1 & this.bounceEnable);
        this.bounceEnable = (bool2 & this.bounceEnable);
        if (!this.bounceEnable) {
          break label1613;
        }
        this.adDT = new MMWeUIBounceView(getContext());
        i = getCustomBounceId();
        if (i == -1) {
          break label1608;
        }
        paramContext = this.DOL.findViewById(i);
        label657:
        if ((paramContext != null) && (paramContext != this.DOL)) {
          break label1465;
        }
        this.adDT.setView(this.DOL);
        i = jjR();
        this.adDT.setStart2EndBgColorByActionBar(i);
        this.adDT.setEnd2StartBgColorByNavigationBar(i);
        paramContext = this.adDT.getView();
        label717:
        this.adDT.jIK();
      }
    }
    label1034:
    label1321:
    label1453:
    label1459:
    label1465:
    label1608:
    label1613:
    for (;;)
    {
      this.adDH.addView(paramContext, 0);
      this.DOL = paramContext;
      if (jjO()) {
        com.tencent.mm.pluginsdk.h.bE(paramAppCompatActivity);
      }
      dealContentView(this.contentView);
      label873:
      long l;
      if (fromFullScreenActivity())
      {
        aw.y(aw.a(this.adDS.getWindow(), this.DOL), this.DOL);
        ((ViewGroup)this.DOL.getParent()).removeView(this.DOL);
        ((ViewGroup)this.adDS.getWindow().getDecorView()).addView(this.DOL, 0);
        int j = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels > paramContext.heightPixels)
        {
          i = this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
          this.DOL.setPadding(this.DOL.getPaddingLeft(), i + (j + this.DOL.getPaddingTop()), this.DOL.getPaddingRight(), this.DOL.getPaddingBottom());
        }
      }
      else
      {
        this.mActionBar = com.tencent.mm.ui.widget.d.c(getSupportActionBar());
        Log.d("MicroMsg.MMActivityController", "onCreate, before.");
        bR(paramAppCompatActivity);
        if (!noActionBar())
        {
          this.adve = bd.bs(this.mContext, a.e.DefaultActionbarHeightPort);
          this.advf = bd.bs(this.mContext, a.e.SmallActionbarHeight);
        }
        jjP();
        if (this.adDH != null) {
          this.adDH.addOnAttachStateChangeListener(new y.16(this));
        }
        if ((this.adDH == null) || (!(this.adDH instanceof LayoutListenerView))) {
          break label1557;
        }
        ((LayoutListenerView)this.adDH).setOnResizedListener(new LayoutListenerView.c()
        {
          private final int adEE;
          
          public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            AppMethodBeat.i(141347);
            if (y.f(y.this))
            {
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
            {
              if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.adEE))
              {
                y.g(y.this);
                AppMethodBeat.o(141347);
                return;
              }
              if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.adEE)) {
                y.h(y.this);
              }
            }
            AppMethodBeat.o(141347);
          }
        });
        paramContext = new ay();
        paramContext.hAK.type = 2;
        paramContext.hAK.position = this.adEk;
        paramContext.publish();
        if (paramContext.hAL.hAO == 2)
        {
          l = System.currentTimeMillis();
          localObject1 = paramContext.hAL.hAR;
          i = paramContext.hAL.position;
          Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject1, Util.getStack() });
          if ((i <= 0) || (i == this.adEk)) {
            break label1569;
          }
          Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.adEk) });
        }
      }
      for (;;)
      {
        Log.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
        if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
        {
          if (this.WHg == 0) {
            this.WHg = jjR();
          }
          paramContext = paramAppCompatActivity.getWindow();
          paramContext.clearFlags(201326592);
          paramContext.addFlags(-2147483648);
          s(paramAppCompatActivity, this.WHg);
          jjV();
        }
        return;
        if (((paramAppCompatActivity instanceof MMActivity)) && (bQ(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode_NoTitleTransparent);
          break;
        }
        if (((paramAppCompatActivity instanceof MMActivity)) && (bP(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode_FullTransparent);
          break;
        }
        paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode);
        break;
        if (((paramAppCompatActivity instanceof MMActivity)) && ((((MMActivity)paramAppCompatActivity).transparentTheme) || (bO(paramAppCompatActivity))))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode_Transparent);
          break;
        }
        if (((paramAppCompatActivity instanceof MMActivity)) && (bQ(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode_NoTitleTransparent);
          break;
        }
        if (((paramAppCompatActivity instanceof MMActivity)) && (bP(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode_FullTransparent);
          break;
        }
        paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode);
        break;
        if (this.DOL.getParent() == null) {
          break label448;
        }
        ((ViewGroup)this.DOL.getParent()).removeView(this.DOL);
        break label448;
        i = 0;
        break label486;
        i = 1;
        break label518;
        bool1 = false;
        break label527;
        bool2 = false;
        break label555;
        localObject1 = paramContext.getParent();
        if ((localObject1 instanceof ViewGroup))
        {
          localObject1 = (ViewGroup)localObject1;
          i = ((ViewGroup)localObject1).indexOfChild(paramContext);
          localObject2 = paramContext.getLayoutParams();
          ((ViewGroup)localObject1).removeViewAt(i);
          this.adDT.setView(paramContext);
          ((ViewGroup)localObject1).addView(this.adDT.getView(), i, (ViewGroup.LayoutParams)localObject2);
        }
        paramContext = this.DOL;
        break label717;
        i = this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
        break label873;
        Log.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        break label1034;
        a(paramContext.hAL.hAQ, paramContext.hAL.visible, paramContext.hAL.url, paramContext.hAL.desc, (String)localObject1, i, true);
      }
      paramContext = null;
      break label657;
    }
  }
  
  public final void a(a parama)
  {
    aAl(parama.advp);
    this.advg.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  final boolean aAl(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.advg.size())
      {
        if (((a)this.advg.get(i)).advp == paramInt)
        {
          Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.advg.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a aAm(int paramInt)
  {
    Iterator localIterator = this.advg.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.advp == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void aAn(int paramInt)
  {
    if (noActionBar()) {}
    View localView;
    do
    {
      do
      {
        return;
        int i = paramInt;
        if (paramInt > this.adve) {
          i = this.adve;
        }
        paramInt = i;
        if (i < this.advf) {
          paramInt = this.advf;
        }
        this.dlE = paramInt;
        this.actionbarView = this.adDS.getWindow().getDecorView().findViewById(a.g.action_bar_container);
        if (this.actionbarView != null) {
          this.adEf = this.actionbarView.getLayoutParams();
        }
      } while ((this.actionbarView == null) || (this.adEf == null));
      this.adEf.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
      this.actionbarView.setLayoutParams(this.adEf);
      localView = this.actionbarView.findViewById(a.g.action_bar);
    } while ((localView == null) || (!(localView instanceof Toolbar)));
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = paramInt;
    }
    localView.setLayoutParams(localLayoutParams);
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    com.tencent.threadpool.h.ahAA.g(new y.20(this, paramBoolean), "ActivateBroadcast-Thread");
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.upT == null) {
      this.upT = new ArrayList();
    }
    this.upT.add(paramDialog);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.adEI);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.adEI);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.adEI);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.adEI);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.adEI);
  }
  
  public void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.adEI);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.adEI);
  }
  
  public final void addSearchMenu(boolean paramBoolean, com.tencent.mm.ui.tools.s params)
  {
    Log.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.advp = a.g.menu_search;
    locala.text = this.mContext.getString(a.k.app_search);
    locala.advq = a.j.actionbar_icon_dark_search;
    locala.pYf = null;
    locala.AkV = null;
    removeOptionMenu(locala.advp);
    this.advg.add(0, locala);
    this.adDV = paramBoolean;
    this.lMw = params;
    this.lMw.afKJ = this;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.adEI);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.adEI);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public final void bR(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      Log.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.WHg == 0) {
        this.WHg = jjR();
      }
      this.advd = bb.aAF(this.WHg);
      setActionbarColor(this.WHg);
      this.mActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      this.mActionBar.x(false);
      this.mActionBar.w(false);
      this.mActionBar.v(false);
      this.mActionBar.y(true);
      this.mActionBar.setIcon(a.f.transparent_background);
      if (this.adEp != -1) {
        break label386;
      }
      localView = af.mU(getContext()).inflate(this.adEn, new LinearLayout(getContext()), false);
      this.mActionBar.setCustomView(localView);
      this.adDZ = ((TextView)findViewById(16908308));
      this.uCY = ((TextView)findViewById(16908309));
      a.v(this.adDZ, a.e.ActionBarTextSize);
      this.aduT = findViewById(a.g.title_ll);
      this.adEc = ((ProgressBar)findViewById(a.g.progress_bar));
      this.adEa = findViewById(a.g.actionbar_up_indicator);
      this.adEb = ((WeImageView)findViewById(a.g.actionbar_up_indicator_btn));
      this.adEa.setOnTouchListener(new y.18(this));
      if (this.adEb != null) {
        this.adEb.setContentDescription(getContext().getString(a.k.app_back));
      }
      if (this.adDZ != null) {
        this.adDZ.setText(a.k.app_name);
      }
      this.adEg = findViewById(a.g.actionbar_operate_area);
      this.adEh = ((AlbumChooserView)findViewById(a.g.actionbar_album_chooser));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label424;
      }
      if (this.adEb != null) {
        this.adEb.setVisibility(0);
      }
      if (this.adEa != null) {
        this.adEa.setVisibility(0);
      }
    }
    for (;;)
    {
      jjU();
      return;
      label386:
      localView = af.mU(getContext()).inflate(this.adEp, new LinearLayout(getContext()), false);
      this.mActionBar.setCustomView(localView);
      break;
      label424:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.adEb != null) {
          this.adEb.setVisibility(0);
        }
        if (this.adEa != null) {
          this.adEa.setVisibility(0);
        }
        if (this.adDZ != null)
        {
          this.adDZ.setVisibility(0);
          aw.a(this.adDZ.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.adEb != null) {
          this.adEb.setVisibility(8);
        }
        if (this.adEa != null) {
          this.adEa.setVisibility(8);
        }
      }
    }
  }
  
  final void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.advg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label125;
      }
      locala = (a)localIterator.next();
      if (locala.enable == paramBoolean2) {
        break label192;
      }
      locala.enable = paramBoolean2;
      paramBoolean1 = true;
    }
    label189:
    label192:
    for (;;)
    {
      break;
      localIterator = this.advg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.advp != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.lMw == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.lMw.afKu)
        {
          if (!paramBoolean1) {
            supportInvalidateOptionsMenu();
          }
          Log.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final void cD(int paramInt, boolean paramBoolean)
  {
    this.adEk = paramInt;
    this.adEl = paramBoolean;
  }
  
  public final boolean callBackMenu()
  {
    if ((this.adDW != null) && (this.adDW.enable))
    {
      a(null, this.adDW);
      return true;
    }
    return false;
  }
  
  final void d(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.advg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label125;
      }
      locala = (a)localIterator.next();
      if (locala.visible == paramBoolean2) {
        break label197;
      }
      locala.visible = paramBoolean2;
      paramBoolean1 = true;
    }
    label194:
    label197:
    for (;;)
    {
      break;
      localIterator = this.advg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.advp != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.lMw == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.lMw.afKu)
        {
          if ((bool) && (!paramBoolean1)) {
            supportInvalidateOptionsMenu();
          }
          Log.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.adDW == null) {}
    while (this.adDW.enable == paramBoolean) {
      return;
    }
    this.adDW.enable = paramBoolean;
    supportInvalidateOptionsMenu();
  }
  
  protected abstract boolean fromFullScreenActivity();
  
  public final void fullScreenNoTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.NBu.removeCallbacks(this.adEw);
      this.NBu.removeCallbacks(this.adEv);
      this.NBu.postDelayed(this.adEv, 256L);
      return;
    }
    this.adDS.getWindow().clearFlags(1024);
    this.NBu.removeCallbacks(this.adEv);
    this.NBu.removeCallbacks(this.adEw);
    this.NBu.postDelayed(this.adEw, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.NBu.removeCallbacks(this.adEw);
      this.NBu.removeCallbacks(this.adEv);
      this.NBu.postDelayed(this.adEv, paramLong);
      return;
    }
    this.adDS.getWindow().clearFlags(1024);
    this.NBu.removeCallbacks(this.adEv);
    this.NBu.removeCallbacks(this.adEw);
    this.NBu.postDelayed(this.adEw, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.adDS.getWindow().setFlags(1024, 1024);
      return;
    }
    this.adDS.getWindow().clearFlags(1024);
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public AppCompatActivity getContext()
  {
    return this.adDS;
  }
  
  protected abstract int getCustomBounceId();
  
  protected int getForceOrientation()
  {
    return -1;
  }
  
  protected abstract String getIdentString();
  
  public final boolean getLandscapeMode()
  {
    return this.landscapeMode;
  }
  
  protected abstract int getLayoutId();
  
  protected abstract View getLayoutView();
  
  public final CharSequence getMMTitle()
  {
    if (this.mActionBar == null) {
      return null;
    }
    if (this.JAf != null) {
      return this.JAf;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.Jey.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.Jey.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.adDS.getSupportActionBar();
  }
  
  public final int getTitleLocation()
  {
    if (this.mActionBar == null) {
      return 0;
    }
    return this.mActionBar.getHeight();
  }
  
  public final void hideActionBarOperationArea()
  {
    if (this.adEg != null) {
      this.adEg.setVisibility(8);
    }
    if (this.aduT != null) {
      this.aduT.setVisibility(0);
    }
  }
  
  public final void hideActionbarLine()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().g(0.0F);
    }
    this.adEx = true;
  }
  
  public final void hideAllManagedDialogs()
  {
    if (this.upT != null)
    {
      int j = this.upT.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.upT.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.upT.clear();
      this.upT = null;
    }
  }
  
  public final void hideTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      Log.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return;
      bool = false;
    }
    this.mActionBar.hide();
  }
  
  public final boolean hideVKB()
  {
    View localView = this.adDS.getCurrentFocus();
    if (localView == null) {
      return hideVKB(this.contentView);
    }
    return hideVKB(localView);
  }
  
  public final boolean hideVKB(View paramView)
  {
    if (paramView == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      do
      {
        return false;
        localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
      } while (localInputMethodManager == null);
      paramView = paramView.getWindowToken();
    } while (paramView == null);
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      Log.i("MicroMsg.MMActivityController", "hideVKB status:%s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (IllegalArgumentException paramView)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
  
  public boolean interceptSupportInvalidateOptionsMenu()
  {
    return false;
  }
  
  protected boolean isActionbarCenterLayoutMode()
  {
    return true;
  }
  
  protected boolean isActionbarMenuUseOriginalSys()
  {
    return false;
  }
  
  public final boolean isTitleShowing()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      Log.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return false;
      bool = false;
    }
    return this.mActionBar.isShowing();
  }
  
  public abstract boolean jjN();
  
  public boolean jjO()
  {
    return false;
  }
  
  public final com.tencent.mm.ui.base.s jjQ()
  {
    if ((this.adDX != null) && (this.adDX.afDb)) {
      return this.adDX.Vtk;
    }
    return null;
  }
  
  public final int jjR()
  {
    this.advd = false;
    if (this.WHg == 0) {
      this.WHg = this.mContext.getResources().getColor(a.d.normal_actionbar_color);
    }
    return this.WHg;
  }
  
  final void jjT()
  {
    Object localObject1 = "%s";
    int n = this.mContext.getResources().getDimensionPixelSize(a.e.ActionBarTextSize);
    if (this.adDJ != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.adDK != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int i = 1;; i = 0)
    {
      if (this.LuL)
      {
        localObject1 = (String)localObject1 + " #";
        i += 2;
      }
      for (int j = 1;; j = 0)
      {
        int m;
        int k;
        if (this.adDR)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
          m = 1;
          k = i + 2;
        }
        for (i = m;; i = m)
        {
          Object localObject2 = String.format((String)localObject1, new Object[] { this.JAf });
          Log.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
          localObject1 = com.tencent.mm.ui.i.c.b.a(this.mContext, (CharSequence)localObject2, n);
          if ((localObject1 instanceof SpannableString))
          {
            localObject2 = (SpannableString)localObject1;
            if (this.adDJ != 0) {
              ((SpannableString)localObject2).setSpan(this.adDL, 0, 1, 33);
            }
            if (this.adDK != 0)
            {
              k = ((SpannableString)localObject2).length() - k;
              ((SpannableString)localObject2).setSpan(this.adDM, k, k + 1, 33);
            }
            if (this.LuL)
            {
              if (this.adDN == null) {
                this.adDN = a(n, bb.m(getContext(), a.j.icons_outlined_bellring_off, getContext().getResources().getColor(a.d.arrow_color)));
              }
              j = ((SpannableString)localObject2).length() - j;
              ((SpannableString)localObject2).setSpan(this.adDN, j, j + 1, 33);
            }
            if (this.adDR)
            {
              if (this.adDP == null) {
                this.adDP = nW(n, a.j.chat_phone_notify_title_icon);
              }
              i = ((SpannableString)localObject2).length() - i;
              ((SpannableString)localObject2).setSpan(this.adDP, i, i + 1, 33);
            }
          }
          this.adDZ.setText((CharSequence)localObject1);
          return;
          m = 0;
          k = i;
        }
      }
    }
  }
  
  public final void mQ(Context paramContext)
  {
    this.adEm.dead();
    hideAllManagedDialogs();
    AndroidContextUtil.fixInputMethodManagerLeak(paramContext);
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
  
  protected abstract void onCreateBeforeSetContentView();
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Log.i("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.advg.size()) });
    if ((this.mActionBar == null) || (this.advg.size() == 0))
    {
      Log.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.advg.size()) });
      d(paramMenu);
      return false;
    }
    this.adEt = null;
    this.adEu = null;
    Iterator localIterator = this.advg.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.advp == 16908332)
      {
        Log.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      else
      {
        if (locala.advp == a.g.menu_search)
        {
          boolean bool2 = this.adDV;
          if (this.lMw == null) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            if ((!this.adDV) || (this.lMw == null)) {
              break;
            }
            this.lMw.a(this.adDS, paramMenu);
            break;
          }
        }
        MenuItem localMenuItem = paramMenu.add(0, locala.advp, 0, locala.text);
        Object localObject1 = getClass().getName();
        label271:
        y.2 local2;
        Object localObject2;
        int i;
        label467:
        Object localObject3;
        if (localMenuItem == null)
        {
          Log.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
          localObject1 = new y.1(this, localMenuItem, locala);
          local2 = new y.2(this, locala);
          localObject2 = new y.3(this, locala);
          if ((locala.advq == 0) && (locala.adEG == null)) {
            break label1254;
          }
          if (locala.advs == null) {
            locala.advs = View.inflate(this.mContext, a.h.action_option_view, null);
          }
          localObject2 = (ImageView)locala.advs.findViewById(a.g.divider);
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          if (this.advg.size() <= 1) {
            break label1049;
          }
          if (!((a)this.advg.get(this.advg.size() - 1)).equals(locala)) {
            break label918;
          }
          this.aduV = ((WeImageView)locala.advs.findViewById(a.g.action_option_icon_right));
          this.adEe = ((ImageView)locala.advs.findViewById(a.g.dot_iv_right));
          localObject2 = this.adEe;
          if (!locala.ihQ) {
            break label912;
          }
          i = 0;
          ((ImageView)localObject2).setVisibility(i);
          locala.advs.findViewById(a.g.action_option_icon_left).setVisibility(8);
          locala.advs.findViewById(a.g.action_option_icon).setVisibility(8);
          locala.advs.findViewById(a.g.dot_iv_left).setVisibility(8);
          locala.advs.findViewById(a.g.dot_iv).setVisibility(8);
          this.aduV.setVisibility(0);
          if (locala.adEG == null) {
            break label1180;
          }
          this.aduV.setImageDrawable(locala.adEG);
          label565:
          if (this.adEd == 0) {
            break label1195;
          }
          localObject2 = this.aduV;
          i = this.adEd;
          localObject3 = PorterDuff.Mode.SRC_ATOP;
          a((WeImageView)localObject2, i);
        }
        for (;;)
        {
          this.aduV.setOnClickListener((View.OnClickListener)localObject1);
          this.aduV.setEnabled(locala.enable);
          this.aduV.setContentDescription(locala.text);
          this.aduV.setTag(a.g.tag_key_weimg_res, Integer.valueOf(locala.advq));
          if (locala.AkV != null) {
            this.aduV.setOnLongClickListener(local2);
          }
          localMenuItem.setActionView(locala.advs);
          localMenuItem.setEnabled(locala.enable);
          localMenuItem.setVisible(locala.visible);
          localMenuItem.setShowAsAction(2);
          if (locala.advq == a.f.mm_title_btn_menu)
          {
            this.adEt = locala;
            this.adEu = localMenuItem;
          }
          Log.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.advp), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
          break;
          if (localMenuItem.getTitleCondensed() == null)
          {
            Log.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", new Object[] { localObject1 });
            localMenuItem.setTitleCondensed("");
            break label271;
          }
          if ((localMenuItem.getTitleCondensed() instanceof String)) {
            break label271;
          }
          Log.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", new Object[] { localObject1, localMenuItem.getTitleCondensed().getClass().getName(), localMenuItem.getTitleCondensed() });
          localMenuItem.setTitleCondensed(localMenuItem.getTitleCondensed().toString());
          break label271;
          label912:
          i = 8;
          break label467;
          label918:
          this.aduV = ((WeImageView)locala.advs.findViewById(a.g.action_option_icon_left));
          this.adEe = ((ImageView)locala.advs.findViewById(a.g.dot_iv_left));
          localObject2 = this.adEe;
          if (locala.ihQ) {}
          for (i = 0;; i = 8)
          {
            ((ImageView)localObject2).setVisibility(i);
            locala.advs.findViewById(a.g.action_option_icon_right).setVisibility(8);
            locala.advs.findViewById(a.g.action_option_icon).setVisibility(8);
            locala.advs.findViewById(a.g.dot_iv_right).setVisibility(8);
            locala.advs.findViewById(a.g.dot_iv).setVisibility(8);
            break;
          }
          label1049:
          this.aduV = ((WeImageView)locala.advs.findViewById(a.g.action_option_icon));
          this.adEe = ((ImageView)locala.advs.findViewById(a.g.dot_iv));
          localObject2 = this.adEe;
          if (locala.ihQ) {}
          for (i = 0;; i = 8)
          {
            ((ImageView)localObject2).setVisibility(i);
            locala.advs.findViewById(a.g.action_option_icon_left).setVisibility(8);
            locala.advs.findViewById(a.g.action_option_icon_right).setVisibility(8);
            locala.advs.findViewById(a.g.dot_iv_left).setVisibility(8);
            locala.advs.findViewById(a.g.dot_iv_right).setVisibility(8);
            break;
          }
          label1180:
          this.aduV.setImageResource(locala.advq);
          break label565;
          label1195:
          if (locala.adEF == 0) {
            if (this.advd)
            {
              localObject2 = this.aduV;
              localObject3 = PorterDuff.Mode.SRC_ATOP;
              a((WeImageView)localObject2, -1);
            }
            else
            {
              this.aduV.setIconColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
            }
          }
        }
        label1254:
        if (locala.advr == null) {
          locala.advr = View.inflate(this.mContext, a.h.action_option_view, null);
        }
        this.aduW = ((TextView)locala.advr.findViewById(a.g.action_option_text));
        this.aduW.setVisibility(0);
        this.zWj = ((Button)locala.advr.findViewById(a.g.action_option_btn));
        this.zWj.setVisibility(8);
        a.v(this.zWj, a.e.SmallBtnTextSize);
        a.v(this.aduW, a.e.ActionBarTextSize);
        this.adEi = locala.advr.findViewById(a.g.album_smart_gallery_entry);
        this.adEi.setVisibility(8);
        if ((locala.adEH == b.adEK) || (locala.adEH == b.adEN))
        {
          this.aduW.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.red_text_color_selector));
          this.zWj.setVisibility(0);
          this.zWj.setBackgroundResource(a.f.btn_solid_live_small);
          this.aduW.setVisibility(8);
        }
        for (;;)
        {
          this.aduW.setText(locala.text);
          if (locala.textColor != 0) {
            this.aduW.setTextColor(locala.textColor);
          }
          this.aduW.setOnClickListener((View.OnClickListener)localObject1);
          this.aduW.setOnLongClickListener(local2);
          this.aduW.setEnabled(locala.enable);
          this.aduW.setOnTouchListener((View.OnTouchListener)localObject2);
          this.zWj.setText(locala.text);
          this.zWj.setOnClickListener((View.OnClickListener)localObject1);
          this.zWj.setOnLongClickListener(local2);
          this.zWj.setOnTouchListener((View.OnTouchListener)localObject2);
          this.zWj.setEnabled(locala.enable);
          localMenuItem.setActionView(locala.advr);
          break;
          if (locala.adEH == b.adEO)
          {
            this.zWj.setVisibility(0);
            this.zWj.setBackgroundResource(a.f.btn_solid_white);
            this.zWj.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.white_btn_text_selector));
            this.aduW.setVisibility(8);
          }
          else
          {
            if (locala.adEH == b.adEJ)
            {
              this.zWj.setVisibility(0);
              localObject3 = this.zWj;
              if (com.tencent.mm.ce.b.iRp()) {}
              for (i = a.f.btn_solid_green_small_care;; i = a.f.btn_solid_green_small)
              {
                ((Button)localObject3).setBackgroundResource(i);
                this.zWj.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.color_btn_text_selector));
                this.aduW.setVisibility(8);
                break;
              }
            }
            if (locala.adEH != b.adEL)
            {
              if (locala.adEH == b.adEQ)
              {
                this.aduW.setTextColor(getContext().getResources().getColor(a.d.lucky_money_goldstyle_text_color));
                continue;
              }
              if (locala.adEH == b.adEP)
              {
                this.aduW.setTextColor(getContext().getResources().getColor(a.d.red_text_color));
                continue;
              }
              if (locala.adEH == b.adET)
              {
                this.zWj.setVisibility(0);
                this.zWj.setBackgroundResource(a.f.btn_solid_yellow_small);
                this.aduW.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.color_btn_text_selector));
                this.aduW.setVisibility(8);
                continue;
              }
              if (b.adEV == locala.adEH)
              {
                Log.i("MicroMsg.MMActivityController", "dark green mode.");
                this.zWj.setVisibility(0);
                localObject3 = this.zWj;
                if (com.tencent.mm.ce.b.iRp()) {}
                for (i = a.f.btn_solid_green_small_care;; i = a.f.btn_solid_dark_green_small)
                {
                  ((Button)localObject3).setBackgroundResource(i);
                  this.zWj.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.gallery_btn_text_selector));
                  this.aduW.setVisibility(8);
                  break;
                }
              }
              if (locala.adEH == b.adEU)
              {
                this.zWj.setVisibility(0);
                this.zWj.setBackgroundResource(a.f.btn_solid_orange_small);
                this.aduW.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.color_btn_text_selector));
                this.aduW.setVisibility(8);
                continue;
              }
              if (b.adEW == locala.adEH)
              {
                Log.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.adDU) });
                this.aduW.setVisibility(8);
                if (this.adDU)
                {
                  this.adEi.setVisibility(0);
                  this.adEi.setOnClickListener((View.OnClickListener)localObject1);
                  continue;
                }
                if (8 == this.adEi.getVisibility()) {
                  this.adEi.setVisibility(4);
                }
                for (;;)
                {
                  this.adEi.setOnClickListener(null);
                  break;
                  if (this.adEi.getVisibility() == 0) {
                    this.adEi.animate().alpha(0.0F).setDuration(200L).withEndAction(new y.4(this));
                  }
                }
              }
              if (b.adEX == locala.adEH)
              {
                this.zWj.setVisibility(0);
                this.zWj.setBackgroundResource(a.f.btn_solid_orange_small);
                this.zWj.setTextColor(com.tencent.mm.cd.a.w(getContext(), a.d.btn_white_text_color));
                this.aduW.setVisibility(8);
                continue;
              }
              if (b.adEY == locala.adEH)
              {
                this.zWj.setVisibility(0);
                this.zWj.setBackgroundResource(a.f.btn_solid_gray_small);
                this.zWj.setTextColor(com.tencent.mm.cd.a.w(getContext(), a.d.BW_0_Alpha_0_9));
                this.aduW.setVisibility(8);
                continue;
              }
              if (b.adEZ == locala.adEH)
              {
                this.zWj.setVisibility(0);
                this.zWj.setBackgroundResource(a.f.btn_solid_live_small);
                this.zWj.setTextColor(com.tencent.mm.cd.a.w(getContext(), a.d.BW_100_Alpha_0_8));
                this.aduW.setVisibility(8);
                continue;
              }
              if (b.adFa == locala.adEH)
              {
                this.zWj.setVisibility(0);
                this.zWj.setBackgroundResource(a.f.alert_btn_background);
                this.zWj.setTextColor(com.tencent.mm.cd.a.w(getContext(), a.d.cancel_btn_color));
                this.aduW.setVisibility(8);
                continue;
              }
              if (this.adEd != 0)
              {
                this.aduW.setTextColor(this.adEd);
                continue;
              }
              if (this.advd)
              {
                this.aduW.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.actionbar_title_light_color_selector));
                continue;
              }
            }
            this.aduW.setTextColor(com.tencent.mm.cd.a.l(getContext(), a.d.black_text_color_selector));
          }
        }
      }
    }
    d(paramMenu);
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((com.tencent.mm.compatible.b.g.aOg()) && (paramInt == 25) && (this.Jey != null)) {
      if (paramKeyEvent.getAction() == 0)
      {
        paramInt = this.Jey.getStreamMaxVolume(3);
        j = this.Jey.getStreamVolume(3);
        i = paramInt / 7;
        paramInt = i;
        if (i == 0) {
          paramInt = 1;
        }
        com.tencent.mm.compatible.b.a.a(this.Jey, 3, j - paramInt, 5);
      }
    }
    do
    {
      return true;
      if ((!com.tencent.mm.compatible.b.g.aOg()) || (paramInt != 24) || (this.Jey == null)) {
        break;
      }
    } while (paramKeyEvent.getAction() != 0);
    paramInt = this.Jey.getStreamMaxVolume(3);
    int j = this.Jey.getStreamVolume(3);
    if (j >= paramInt)
    {
      Log.i("MicroMsg.MMActivityController", "has set the max volume");
      return true;
    }
    int i = paramInt / 7;
    paramInt = i;
    if (i == 0) {
      paramInt = 1;
    }
    com.tencent.mm.compatible.b.a.a(this.Jey, 3, paramInt + j, 5);
    return true;
    if ((this.adDV) && (this.lMw != null) && (this.lMw.onKeyDown(paramInt, paramKeyEvent)))
    {
      Log.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.advd)
      {
        setActionbarColor(getContext().getResources().getColor(a.d.dark_actionbar_color));
        return true;
      }
      setActionbarColor(getContext().getResources().getColor(a.d.normal_actionbar_color));
      return true;
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.adEt != null) && (this.adEt.enable)) {
        a(this.adEu, this.adEt);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Log.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.adDI)
    {
      Log.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.adDW.advp) && (this.adDW.enable))
    {
      a(paramMenuItem, this.adDW);
      return true;
    }
    Iterator localIterator = this.advg.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.advp)
      {
        Log.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        return true;
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    activateBroadcast(false);
    this.adEm.dead();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Log.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.adDV) && (this.lMw != null)) {
      this.lMw.a(this.adDS, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    this.adEm.alive();
    Object localObject = new ay();
    ((ay)localObject).hAK.type = 2;
    ((ay)localObject).hAK.position = this.adEk;
    ((ay)localObject).publish();
    long l;
    String str;
    int i;
    if (((ay)localObject).hAL.hAO == 2)
    {
      l = System.currentTimeMillis();
      str = ((ay)localObject).hAL.hAR;
      i = ((ay)localObject).hAL.position;
      Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.adEk)) {
        break label425;
      }
      Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.adEk) });
    }
    for (;;)
    {
      Log.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext())) {
          break;
        }
        if (1.0F != MMApplicationContext.getContext().getResources().getConfiguration().fontScale)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(15181, new Object[] { Integer.valueOf(1) });
          localObject = new g.a(MMApplicationContext.getContext());
          ((g.a)localObject).bf(getContext().getResources().getString(a.k.font_scale_adjust_title)).bDE(getContext().getResources().getString(a.k.font_scale_adjust_content)).bDI(getContext().getResources().getString(a.k.font_scale_adjust_positive_text)).bDJ(getContext().getResources().getString(a.k.font_scale_adjust_negative_text));
          ((g.a)localObject).c(new y.19(this)).show();
          MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label425:
      a(((ay)localObject).hAL.hAQ, ((ay)localObject).hAL.visible, ((ay)localObject).hAL.url, ((ay)localObject).hAL.desc, str, i, true);
    }
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
  }
  
  public final void onStart()
  {
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
      if (this.landscapeMode)
      {
        if (aw.jkT()) {
          bh.aDU(1);
        }
        this.adDS.setRequestedOrientation(-1);
        return;
      }
      if (aw.jkT()) {
        bh.aDU(0);
      }
      this.adDS.setRequestedOrientation(1);
      return;
    }
    this.adDS.setRequestedOrientation(getForceOrientation());
  }
  
  protected View provideCustomActivityContentView()
  {
    return null;
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.advg.isEmpty()) {
      return;
    }
    this.advg.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.advg.size())
      {
        if (((a)this.advg.get(i)).advp == paramInt)
        {
          Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.advg.remove(i);
          supportInvalidateOptionsMenu();
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void s(Activity paramActivity, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8())) {
      i = paramInt;
    }
    for (;;)
    {
      if (((paramActivity instanceof MMActivity)) && (((MMActivity)paramActivity).fixStatusbar) && (((MMActivity)paramActivity).isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.statusbar.a.h(getContentView(), i, com.tencent.mm.ui.statusbar.d.h(paramActivity.getWindow()));
      }
      for (;;)
      {
        this.WoL = paramInt;
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label110;
        }
        i = bb.av(paramActivity.getResources().getColor(a.d.statusbar_fg_drak_color), paramInt);
        break;
        paramActivity.getWindow().setStatusBarColor(i);
      }
      label110:
      i = 0;
    }
  }
  
  public void setActionbarColor(int paramInt)
  {
    if (this.mActionBar == null) {}
    do
    {
      return;
      this.WHg = paramInt;
      this.advd = bb.aAF(this.WHg);
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.WHg));
      s(this.adDS, this.WHg);
      jjV();
      jjU();
      if (this.WHg == this.mContext.getResources().getColor(a.d.white))
      {
        this.uxT = this.WHg;
        setNavigationbarColor(this.uxT);
        return;
      }
    } while (this.uxT != 0);
    setNavigationbarColor(this.mContext.getResources().getColor(a.d.BG_0));
  }
  
  public final void setBackBtn(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null) {
      this.mActionBar.w(false);
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (this.adEb.getDrawable() == null) {
          i = a.j.actionbar_icon_dark_back;
        }
      }
      if ((this.adEb != null) && (i != 0))
      {
        this.adEa.setTag(a.g.tag_key_weimg_res, Integer.valueOf(i));
        this.adEb.setImageResource(i);
      }
      this.adDW.advp = 16908332;
      this.adDW.pYf = paramOnMenuItemClickListener;
      return;
      this.mActionBar.w(false);
      if (this.adEa != null) {
        this.adEa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249482);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MMActivityController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249216);
                y.9.this.advi.onMenuItemClick(null);
                AppMethodBeat.o(249216);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249482);
          }
        });
      }
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.adEb == null) {
      return;
    }
    if (paramBoolean)
    {
      this.adEb.setVisibility(0);
      return;
    }
    this.adEb.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.adDH == null) {
      this.adDH = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    this.adDH.setBackgroundResource(paramInt);
    this.DOL.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.adDH == null) {
      this.adDH = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    if (this.adDF != null) {
      this.adDH.removeView(this.adDF);
    }
    this.adDH.removeView(this.DOL);
    this.DOL = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.adDH.addView(this.DOL, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.adDF != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 47.0F));
      this.adDH.addView(this.adDF, this.adDH.getChildCount(), localLayoutParams);
    }
    this.adDH.invalidate();
  }
  
  public final void setBounceEnabled(boolean paramBoolean)
  {
    this.bounceEnable = paramBoolean;
    if (this.adDT != null) {
      this.adDT.setBounceEnabled(paramBoolean);
    }
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      bR(this.adDS);
    }
  }
  
  public final void setMMSingleTitle(String paramString, Animation paramAnimation)
  {
    if (this.mActionBar == null) {}
    TextView localTextView;
    do
    {
      do
      {
        return;
        this.mActionBar.L(adEo);
        localTextView = (TextView)this.mActionBar.getCustomView().findViewById(a.g.action_bar_single_title);
      } while (localTextView == null);
      localTextView.clearAnimation();
      if (paramAnimation != null) {
        localTextView.startAnimation(paramAnimation);
      }
    } while (Util.isNullOrNil(paramString));
    localTextView.setText(paramString);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.uCY.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cd.a.mp(getContext()))
    {
      this.uCY.setTextSize(1, 14.0F);
      this.adDZ.setTextSize(1, 18.0F);
    }
    this.uCY.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.uCY.setVisibility(8);
      return;
    }
    this.uCY.setText(paramString);
    if (com.tencent.mm.cd.a.mp(getContext()))
    {
      this.uCY.setTextSize(1, 14.0F);
      this.adDZ.setTextSize(1, 18.0F);
    }
    this.uCY.setVisibility(0);
    updateDescription(paramString);
  }
  
  public final void setMMTitle(int paramInt)
  {
    setMMTitle(this.mContext.getString(paramInt));
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.JAf = paramCharSequence.toString();
    this.adDZ.setText(paramCharSequence);
    if (!a.jhB()) {
      if (com.tencent.mm.cd.a.mp(getContext())) {
        this.adDZ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.e.ActionBarTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      }
    }
    for (;;)
    {
      updateDescription(paramCharSequence.toString());
      return;
      a.v(this.adDZ, a.e.ActionBarTextSize);
    }
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.JAf = paramString;
    if (!a.jhB()) {
      if (com.tencent.mm.cd.a.mp(getContext())) {
        this.adDZ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.e.ActionBarTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      }
    }
    for (;;)
    {
      jjT();
      updateDescription(paramString);
      return;
      a.v(this.adDZ, a.e.ActionBarTextSize);
    }
  }
  
  public final void setMMTitleColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    Log.d("MicroMsg.MMActivityController", "setMMTitleColor color: %s.", new Object[] { Integer.valueOf(paramInt) });
    this.adDZ.setTextColor(paramInt);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.adDZ.setVisibility(paramInt);
  }
  
  public void setNavigationbarColor(int paramInt)
  {
    View localView;
    int i;
    if ((Build.VERSION.SDK_INT >= 26) && (!jjW()))
    {
      this.adDS.getWindow().setNavigationBarColor(paramInt);
      boolean bool = bb.aAF(paramInt);
      localView = this.adDS.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!bool) {
        break label101;
      }
      i &= 0xFFFFFFEF;
    }
    for (;;)
    {
      localView.setSystemUiVisibility(i);
      this.uxT = paramInt;
      if ((getCustomBounceId() == -1) && (this.adDT != null) && (!jjN())) {
        this.adDT.setEnd2StartBgColorByNavigationBar(paramInt);
      }
      return;
      label101:
      i |= 0x10;
    }
  }
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.adDI = paramBoolean;
    if ((this.adDE == null) && (this.contentView != null)) {
      this.adDE = this.contentView.findViewById(a.g.mm_trans_layer);
    }
    if (this.adDE == null)
    {
      Log.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.adDE;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.adDE;
      if (paramBoolean) {
        break label106;
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localView.setFocusableInTouchMode(bool1);
      if (paramBoolean) {
        break label111;
      }
      mP(getContext());
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    s(this.adDS, paramInt);
    updataStatusBarIcon(bb.aAF(paramInt));
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    if ((this.mActionBar == null) || (paramRunnable == null)) {
      return;
    }
    this.mActionBar.getCustomView().setOnClickListener(new y.7(this, paramRunnable));
  }
  
  public final void setTitleLogo(int paramInt1, int paramInt2)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.adDJ = 0;
      this.adDL = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.adDK = 0;
      this.adDM = null;
    }
    for (;;)
    {
      jjT();
      return;
      if (this.adDJ == paramInt1) {
        break;
      }
      this.adDJ = paramInt1;
      this.adDL = nW(this.mContext.getResources().getDimensionPixelSize(a.e.BigTextSize), this.adDJ);
      break;
      label82:
      if (this.adDK != paramInt2)
      {
        this.adDK = paramInt2;
        this.adDM = nW(this.mContext.getResources().getDimensionPixelSize(a.e.BigTextSize), this.adDK);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.LuL = bool;
      jjT();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.adDR = bool;
      jjT();
      return;
    }
  }
  
  public final void setTitleVisibility(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.mActionBar.show();
      s(this.adDS, this.WHg);
    }
    for (;;)
    {
      Log.d("MicroMsg.MMActivityController", "setTitleVisibility visible: %s.", new Object[] { Integer.valueOf(paramInt) });
      return;
      this.mActionBar.hide();
      s(this.adDS, getContext().getResources().getColor(a.d.black));
    }
  }
  
  public final void showActionbarLine()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().g(1.0F);
    }
    this.adEx = false;
  }
  
  public final void showHomeBtn(boolean paramBoolean)
  {
    if (this.mActionBar == null) {}
    do
    {
      return;
      this.mActionBar.w(paramBoolean);
    } while (this.adEa == null);
    View localView = this.adEa;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public final void showTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      Log.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return;
      bool = false;
    }
    this.mActionBar.show();
  }
  
  public void supportInvalidateOptionsMenu()
  {
    this.adDS.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.adDS.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      Log.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label60;
      }
      i &= 0xFFFFDFFF;
    }
    for (;;)
    {
      localView.setSystemUiVisibility(i);
      return;
      label60:
      i |= 0x2000;
    }
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.jlv().r(this.adDS, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = aAm(paramInt1);
    if ((locala != null) && (locala.advq != paramInt2))
    {
      locala.advq = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = aAm(paramInt);
    if (locala != null)
    {
      locala.pYf = paramOnMenuItemClickListener;
      locala.AkV = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = aAm(paramInt);
    if ((locala != null) && (locala.ihQ != paramBoolean))
    {
      locala.ihQ = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = aAm(paramInt);
    if ((locala != null) && (!Util.nullAs(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public static final class a
  {
    public View.OnLongClickListener AkV;
    public View.OnTouchListener DIP;
    public int adEF = 0;
    public Drawable adEG;
    public y.b adEH = y.b.adEI;
    public int advp = -1;
    public int advq;
    public View advr;
    public View advs;
    public boolean enable = true;
    public boolean ihQ = false;
    public MenuItem.OnMenuItemClickListener pYf;
    public String text;
    public int textColor;
    public boolean visible = true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      adEI = new b("NORMAL", 0);
      adEJ = new b("GREEN", 1);
      adEK = new b("RED", 2);
      adEL = new b("BLACK", 3);
      adEM = new b("TRANSPARENT", 4);
      adEN = new b("TRANSPARENT_RED_TEXT", 5);
      adEO = new b("TRANSPARENT_GREEN_TEXT", 6);
      adEP = new b("GOLDEN", 7);
      adEQ = new b("TRANSPARENT_GOLD_TEXT", 8);
      adER = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      adES = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      adET = new b("YELLOW", 11);
      adEU = new b("ORANGE", 12);
      adEV = new b("DARK_GREEN_MODE", 13);
      adEW = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      adEX = new b("FEED_FOLLOW", 15);
      adEY = new b("FEED_UNFOLLOW", 16);
      adEZ = new b("FINDER_LIVE", 17);
      adFa = new b("ALTER_BTN_BACKGROUND", 18);
      adFb = new b[] { adEI, adEJ, adEK, adEL, adEM, adEN, adEO, adEP, adEQ, adER, adES, adET, adEU, adEV, adEW, adEX, adEY, adEZ, adFa };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.y
 * JD-Core Version:    0.7.0.1
 */