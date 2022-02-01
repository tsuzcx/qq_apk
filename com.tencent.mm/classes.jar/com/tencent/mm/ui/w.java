package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
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
import com.tencent.e.i;
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
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.at.b;
import com.tencent.mm.f.a.zn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.WXActionMenuView.a;
import com.tencent.mm.ui.widget.WXActionMenuView.a.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.MMWeUIBounceView;
import com.tencent.mm.ui.widget.pulldown.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.n.n;

public abstract class w
{
  private static boolean VZE = false;
  private static final int VZU = a.h.actionbar_title_single_text;
  public static long VZW;
  private static byte[] VZY = { 0 };
  private static PowerManager.WakeLock wakeLock = null;
  private String DJc = " ";
  private AudioManager Dlo;
  private boolean Fyz = false;
  protected MMHandler HDS = new MMHandler(Looper.getMainLooper());
  View Nrv;
  private int PQJ = 0;
  public int PyE = -1;
  private final long Qhx = 300L;
  View VQL;
  WeImageView VQN;
  TextView VQO;
  private boolean VQV = false;
  int VQW;
  private int VQX;
  LinkedList<a> VQY = new LinkedList();
  private long VWE = SystemClock.elapsedRealtime();
  boolean VZA = false;
  public boolean VZB;
  private a VZC = new a();
  private com.tencent.mm.ui.tools.a VZD;
  public TextView VZF;
  View VZG;
  WeImageView VZH;
  ProgressBar VZI;
  int VZJ = 0;
  private ImageView VZK;
  private ViewGroup.LayoutParams VZL;
  View VZM;
  AlbumChooserView VZN;
  private View VZO;
  public boolean VZP = true;
  private int VZQ = 0;
  private boolean VZR = false;
  private IListener VZS = new IListener() {};
  int VZT = a.h.actionbar_title_center;
  private int VZV = -1;
  int VZX = 0;
  private a VZZ;
  private View VZj;
  private View VZk;
  private TextView VZl;
  public FrameLayout VZm;
  public boolean VZn = true;
  private int VZo = 0;
  private int VZp = 0;
  private com.tencent.mm.ui.widget.a VZq = null;
  private com.tencent.mm.ui.widget.a VZr = null;
  private com.tencent.mm.ui.widget.a VZs = null;
  private com.tencent.mm.ui.widget.a VZt = null;
  private com.tencent.mm.ui.widget.a VZu = null;
  boolean VZv = false;
  private boolean VZw = false;
  public AppCompatActivity VZx;
  e VZy;
  private LinearLayout VZz;
  private MenuItem Waa;
  private Runnable Wab = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141334);
      w.j(w.this).getWindow().setFlags(1024, 1024);
      if (w.k(w.this) != null) {
        w.k(w.this).hide();
      }
      AppMethodBeat.o(141334);
    }
  };
  private Runnable Wac = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(207333);
      if (w.k(w.this) != null) {
        w.k(w.this).show();
      }
      AppMethodBeat.o(207333);
    }
  };
  private View actionbarView;
  private boolean bounceEnable = true;
  int bsc = this.VQW;
  String className;
  View contentView;
  private boolean cpt = false;
  public com.tencent.mm.ui.tools.t jjS;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  private LayoutInflater mYa;
  ArrayList<Dialog> rhX;
  TextView rsy;
  private Button wzY;
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.VQV) {
      localDrawable = au.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, aw.aZ(this.VZx, a.e.Edge_2A), aw.aZ(this.VZx, a.e.Edge_2A));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable, 1);
    paramDrawable.Yal = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.VRh = paramInt1;
    locala.VRi = paramInt2;
    locala.text = paramString;
    locala.naX = paramOnMenuItemClickListener;
    locala.wOt = paramOnLongClickListener;
    locala.Wam = paramb;
    locala.gbE = paramBoolean;
    if ((locala.VRi == a.f.mm_title_btn_menu) && (Util.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(a.k.app_more);
    }
    atS(locala.VRh);
    this.VQY.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.VRh = paramInt;
    locala.Wal = paramDrawable;
    locala.text = paramString;
    locala.naX = paramOnMenuItemClickListener;
    locala.wOt = null;
    locala.Wam = paramb;
    atS(locala.VRh);
    this.VQY.add(locala);
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141340);
        w.this.supportInvalidateOptionsMenu();
        AppMethodBeat.o(141340);
      }
    }, 200L);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean2)
  {
    Log.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.VZk });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.VZk == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      Log.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.VZm == null) {
      this.VZm = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    if (this.VZk != null) {
      this.VZm.removeView(this.VZk);
    }
    int i = a.h.mmnotify_view;
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.VZk = this.mYa.inflate(paramInt1, null);
      this.VZl = ((TextView)this.VZk.findViewById(a.g.notify_text));
      this.VZk.findViewById(a.g.notify_btn).setOnClickListener(new w.12(this, paramString3, paramInt2));
      this.VZk.setOnClickListener(new w.15(this, paramString1));
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.VZR) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.VZx, 48.0F), 0, 0);
        Log.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.VZm.addView(this.VZk, this.VZm.getChildCount(), paramString3);
      if (this.VZk == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.VZk;
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
          this.VZl.setText(paramString1);
        }
        for (;;)
        {
          this.VZk.invalidate();
          this.VZm.invalidate();
          return;
          paramInt1 = 8;
          break;
          label493:
          Log.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.VZl.setText(paramString3);
        }
      }
      this.VZk.post(new w.16(this, paramBoolean1, paramString2, paramString1));
      return;
      paramInt1 = i;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.VZn) {
      Log.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.naX == null) {
      return;
    }
    parama.naX.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.VZP)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.clearColorFilter();
  }
  
  private void b(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.VZP)
    {
      paramDrawable.setColorFilter(paramInt, paramMode);
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  private static boolean bj(Activity paramActivity)
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
  
  private static boolean bk(Activity paramActivity)
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
  
  private static boolean bl(Activity paramActivity)
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
  
  private void bm(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      Log.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.PQJ == 0) {
        this.PQJ = hHI();
      }
      this.VQV = au.auk(this.PQJ);
      setActionbarColor(this.PQJ);
      this.mActionBar.setLogo(new ColorDrawable(this.VZx.getResources().getColor(17170445)));
      this.mActionBar.t(false);
      this.mActionBar.s(false);
      this.mActionBar.r(false);
      this.mActionBar.u(true);
      this.mActionBar.setIcon(a.f.transparent_background);
      if (this.VZV != -1) {
        break label376;
      }
      localView = ad.kS(this.VZx).inflate(this.VZT, new LinearLayout(this.VZx), false);
      this.mActionBar.setCustomView(localView);
      this.VZF = ((TextView)findViewById(16908308));
      this.rsy = ((TextView)findViewById(16908309));
      this.VQL = findViewById(a.g.title_ll);
      this.VZI = ((ProgressBar)findViewById(a.g.progress_bar));
      this.VZG = findViewById(a.g.actionbar_up_indicator);
      this.VZH = ((WeImageView)findViewById(a.g.actionbar_up_indicator_btn));
      this.VZG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(141348);
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            w.VZW = System.currentTimeMillis();
          }
          AppMethodBeat.o(141348);
          return false;
        }
      });
      if (this.VZH != null) {
        this.VZH.setContentDescription(this.VZx.getString(a.k.app_back));
      }
      if (this.VZF != null) {
        this.VZF.setText(a.k.app_name);
      }
      this.VZM = findViewById(a.g.actionbar_operate_area);
      this.VZN = ((AlbumChooserView)findViewById(a.g.actionbar_album_chooser));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label414;
      }
      if (this.VZH != null) {
        this.VZH.setVisibility(0);
      }
      if (this.VZG != null) {
        this.VZG.setVisibility(0);
      }
    }
    for (;;)
    {
      hHL();
      return;
      label376:
      localView = ad.kS(this.VZx).inflate(this.VZV, new LinearLayout(this.VZx), false);
      this.mActionBar.setCustomView(localView);
      break;
      label414:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.VZH != null) {
          this.VZH.setVisibility(0);
        }
        if (this.VZG != null) {
          this.VZG.setVisibility(0);
        }
        if (this.VZF != null)
        {
          this.VZF.setVisibility(0);
          ar.a(this.VZF.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.VZH != null) {
          this.VZH.setVisibility(8);
        }
        if (this.VZG != null) {
          this.VZG.setVisibility(8);
        }
      }
    }
  }
  
  private void d(Menu paramMenu)
  {
    Log.i("MicroMsg.MMActivityController", "actionBarTitleCenter isActionbarMenuUseOriginalSys: %s.", new Object[] { Boolean.valueOf(isActionbarMenuUseOriginalSys()) });
    if (isActionbarMenuUseOriginalSys())
    {
      if (this.VZD != null) {
        this.VZD.b(getSupportActionBar());
      }
      a.a(getSupportActionBar(), isActionbarCenterLayoutMode(), this, paramMenu);
      return;
    }
    hHF();
    this.VZD.a(this.VZx, paramMenu, this);
  }
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.VZx.findViewById(paramInt);
  }
  
  private void hHF()
  {
    if (this.VZD == null)
    {
      Log.i("MicroMsg.MMActivityController", "initCustomMenuHelper, init, mAppCompatActivity:%s", new Object[] { this.VZx });
      new WXActionMenuView.a.a();
      new WXActionMenuView.a.a().Hq(isActionbarCenterLayoutMode()).Hr(isActionbarMenuUseOriginalSys()).axF(Math.max(this.VQW, aw.aZ(this.mContext, a.e.DefaultActionbarHeightPort)));
      WXActionMenuView.a locala = WXActionMenuView.a.a.Yex;
      this.VZD = new com.tencent.mm.ui.tools.a(this.VZx, locala);
    }
    if (this.VZD != null) {
      Log.i("MicroMsg.MMActivityController", "initCustomMenuHelper has init.");
    }
  }
  
  public static boolean hHJ()
  {
    synchronized (VZY)
    {
      if (wakeLock != null)
      {
        bool = wakeLock.isHeld();
        return bool;
      }
      boolean bool = false;
    }
  }
  
  private void hHL()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.VQV)
    {
      if (this.VZH != null)
      {
        localWeImageView = this.VZH;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.VZF != null) && (this.VZF.getVisibility() == 0)) {
        this.VZF.setTextColor(this.mContext.getResources().getColor(a.d.actionbar_title_light_color));
      }
      if ((this.rsy != null) && (this.rsy.getVisibility() == 0)) {
        this.rsy.setTextColor(this.mContext.getResources().getColor(a.d.actionbar_title_light_color));
      }
      if ((this.VQN != null) && (this.VQN.getVisibility() == 0)) {
        if (this.VQN.getDrawable() != null) {
          b(this.VQN.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.VQN;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.VQO == null) || (this.VQO.getVisibility() != 0));
      this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.mContext, a.d.white_text_color_selector));
      return;
      if (this.VZH != null)
      {
        localWeImageView = this.VZH;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
      }
      if ((this.VZF != null) && (this.VZF.getVisibility() == 0)) {
        this.VZF.setTextColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
      }
      if ((this.rsy != null) && (this.rsy.getVisibility() == 0)) {
        this.rsy.setTextColor(this.mContext.getResources().getColor(a.d.UN_BW_0_Alpha_0_9));
      }
      if ((this.VQN != null) && (this.VQN.getVisibility() == 0))
      {
        if (this.VQN.getDrawable() != null)
        {
          b(this.VQN.getDrawable(), -16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        localWeImageView = this.VQN;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
        return;
      }
    } while ((this.VQO == null) || (this.VQO.getVisibility() != 0));
    this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.mContext, a.d.black_text_color_selector));
  }
  
  private void hHM()
  {
    updataStatusBarIcon(this.VQV);
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
  
  private void kM(Context paramContext)
  {
    synchronized (VZY)
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
  
  private com.tencent.mm.ui.widget.a mg(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.VQV) {
      localDrawable = au.o(this.VZx, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable, 1);
    locala.Yal = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private void releaseWakeLock()
  {
    synchronized (VZY)
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
    VZE = true;
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
  
  public final void Fy(boolean paramBoolean)
  {
    this.VQV = paramBoolean;
    hHM();
    hHL();
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.VZx = paramAppCompatActivity;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject1 = this.VZx.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).layoutInDisplayCutoutMode = 1;
      this.VZx.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
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
    this.cpt = ar.f(paramAppCompatActivity.getResources());
    int i;
    label448:
    Object localObject2;
    label486:
    boolean bool2;
    if (paramAppCompatActivity != null)
    {
      if (!this.cpt) {
        break label1360;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && ((bj(paramAppCompatActivity)) || (((MMActivity)paramAppCompatActivity).transparentTheme))) {
        paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode_Transparent);
      }
    }
    else
    {
      onCreateBeforeSetContentView();
      this.className = getClass().getName();
      ap.dk(3, this.className);
      initLanguage(paramContext);
      this.Dlo = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.mYa = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.a.b.aIK();
        this.contentView = com.tencent.mm.kiss.a.b.d(paramAppCompatActivity, a.h.mm_activity);
      }
      this.VZj = this.contentView.findViewById(a.g.mm_trans_layer);
      this.VZm = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
      if (i != -1)
      {
        this.Nrv = getLayoutView();
        if (this.Nrv != null) {
          break label1452;
        }
        this.Nrv = this.mYa.inflate(getLayoutId(), null);
        paramContext = this.Nrv;
        localObject1 = com.tencent.mm.ui.widget.pulldown.d.Ytn;
        localObject2 = bpE();
        CharSequence localCharSequence = (CharSequence)localObject2;
        if ((localCharSequence != null) && (!n.ba(localCharSequence))) {
          break label1482;
        }
        i = 1;
        if (i != 0) {
          break label1487;
        }
        p.k(localObject2, "name");
        localObject2 = com.tencent.mm.ui.widget.pulldown.d.byz((String)localObject2);
        if (localObject2 == null) {
          break label1487;
        }
        i = ((com.tencent.mm.ui.widget.pulldown.d)localObject1).by((Class)localObject2);
        label518:
        if ((i & 0x1) == 0) {
          break label1492;
        }
        bool1 = true;
        label527:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waL, com.tencent.mm.util.b.a.YxN, 1) != 1) {
          break label1498;
        }
        bool2 = true;
        label555:
        Log.i("MicroMsg.MMActivityController", "bounceCreate: %s %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.bounceEnable) });
        this.bounceEnable = (bool1 & this.bounceEnable);
        this.bounceEnable = (bool2 & this.bounceEnable);
        if (!this.bounceEnable) {
          break label1668;
        }
        this.VZz = ((LinearLayout)LayoutInflater.from(this.VZx).inflate(a.h.mm_activity_bg, null, false));
        this.VZy = new MMWeUIBounceView(this.VZx);
        i = getCustomBounceId();
        if (i == -1) {
          break label1663;
        }
        paramContext = this.Nrv.findViewById(i);
        label679:
        if ((paramContext != null) && (paramContext != this.Nrv)) {
          break label1504;
        }
        this.VZy.h(this.VZz, this.Nrv);
        i = hHI();
        this.VZy.setStart2EndBgColorByActionBar(i);
        this.VZy.setEnd2StartBgColorByNavigationBar(i);
        paramContext = this.VZy.getView();
        label743:
        this.VZy.idC();
      }
    }
    label1668:
    for (;;)
    {
      label782:
      label1070:
      long l;
      if (hHE())
      {
        localObject1 = (ViewGroup)paramAppCompatActivity.getWindow().getDecorView();
        ((ViewGroup)localObject1).addView(paramContext, ((ViewGroup)localObject1).getChildCount());
        this.Nrv = paramContext;
        dealContentView(this.contentView);
        if (fromFullScreenActivity())
        {
          ar.p(ar.a(this.VZx.getWindow(), this.Nrv), this.Nrv);
          ((ViewGroup)this.Nrv.getParent()).removeView(this.Nrv);
          ((ViewGroup)this.VZx.getWindow().getDecorView()).addView(this.Nrv, 0);
          int j = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 25);
          paramContext = this.mContext.getResources().getDisplayMetrics();
          if (paramContext.widthPixels <= paramContext.heightPixels) {
            break label1595;
          }
          i = this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
          label909:
          this.Nrv.setPadding(this.Nrv.getPaddingLeft(), i + (j + this.Nrv.getPaddingTop()), this.Nrv.getPaddingRight(), this.Nrv.getPaddingBottom());
        }
        this.mActionBar = com.tencent.mm.ui.widget.d.c(getSupportActionBar());
        Log.d("MicroMsg.MMActivityController", "onCreate, before.");
        bm(paramAppCompatActivity);
        if (!noActionBar())
        {
          this.VQW = aw.aZ(this.mContext, a.e.DefaultActionbarHeightPort);
          this.VQX = aw.aZ(this.mContext, a.e.SmallActionbarHeight);
        }
        hHF();
        if (this.VZm != null) {
          this.VZm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            public final void onViewAttachedToWindow(View paramAnonymousView) {}
            
            public final void onViewDetachedFromWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(141345);
              w.e(w.this).removeOnAttachStateChangeListener(this);
              com.tencent.mm.kiss.a.b.aIL();
              AppMethodBeat.o(141345);
            }
          });
        }
        if ((this.VZm == null) || (!(this.VZm instanceof LayoutListenerView))) {
          break label1612;
        }
        ((LayoutListenerView)this.VZm).setOnResizedListener(new LayoutListenerView.c()
        {
          private final int Waj;
          
          public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            AppMethodBeat.i(141347);
            if (w.f(w.this))
            {
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
            {
              if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.Waj))
              {
                w.g(w.this);
                AppMethodBeat.o(141347);
                return;
              }
              if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.Waj)) {
                w.h(w.this);
              }
            }
            AppMethodBeat.o(141347);
          }
        });
        paramContext = new at();
        paramContext.fwm.type = 2;
        paramContext.fwm.position = this.VZQ;
        EventCenter.instance.publish(paramContext);
        if (paramContext.fwn.fwq == 2)
        {
          l = System.currentTimeMillis();
          localObject1 = paramContext.fwn.fwt;
          i = paramContext.fwn.position;
          Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject1, Util.getStack() });
          if ((i <= 0) || (i == this.VZQ)) {
            break label1624;
          }
          Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.VZQ) });
        }
      }
      for (;;)
      {
        Log.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
        if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
        {
          if (this.PQJ == 0) {
            this.PQJ = hHI();
          }
          paramContext = paramAppCompatActivity.getWindow();
          paramContext.clearFlags(201326592);
          paramContext.addFlags(-2147483648);
          q(paramAppCompatActivity, this.PQJ);
          hHM();
        }
        return;
        if (((paramAppCompatActivity instanceof MMActivity)) && (bl(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode_NoTitleTransparent);
          break;
        }
        if (((paramAppCompatActivity instanceof MMActivity)) && (bk(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode_FullTransparent);
          break;
        }
        paramAppCompatActivity.setTheme(a.l.AppTheme_DarkMode);
        break;
        label1360:
        if (((paramAppCompatActivity instanceof MMActivity)) && ((((MMActivity)paramAppCompatActivity).transparentTheme) || (bj(paramAppCompatActivity))))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode_Transparent);
          break;
        }
        if (((paramAppCompatActivity instanceof MMActivity)) && (bl(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode_NoTitleTransparent);
          break;
        }
        if (((paramAppCompatActivity instanceof MMActivity)) && (bk(paramAppCompatActivity)))
        {
          paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode_FullTransparent);
          break;
        }
        paramAppCompatActivity.setTheme(a.l.AppTheme_LightMode);
        break;
        label1452:
        if (this.Nrv.getParent() == null) {
          break label448;
        }
        ((ViewGroup)this.Nrv.getParent()).removeView(this.Nrv);
        break label448;
        label1482:
        i = 0;
        break label486;
        label1487:
        i = 1;
        break label518;
        label1492:
        bool1 = false;
        break label527;
        label1498:
        bool2 = false;
        break label555;
        label1504:
        localObject1 = paramContext.getParent();
        if ((localObject1 instanceof ViewGroup))
        {
          localObject1 = (ViewGroup)localObject1;
          i = ((ViewGroup)localObject1).indexOfChild(paramContext);
          localObject2 = paramContext.getLayoutParams();
          ((ViewGroup)localObject1).removeViewAt(i);
          this.VZy.h(this.VZz, paramContext);
          ((ViewGroup)localObject1).addView(this.VZy.getView(), i, (ViewGroup.LayoutParams)localObject2);
        }
        paramContext = this.Nrv;
        break label743;
        this.VZm.addView(paramContext, 0);
        break label782;
        label1595:
        i = this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
        break label909;
        label1612:
        Log.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        break label1070;
        label1624:
        a(paramContext.fwn.fws, paramContext.fwn.visible, paramContext.fwn.url, paramContext.fwn.desc, (String)localObject1, i, true);
      }
      label1663:
      paramContext = null;
      break label679;
    }
  }
  
  public final void a(a parama)
  {
    atS(parama.VRh);
    this.VQY.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    com.tencent.e.h.ZvG.d(new w.21(this, paramBoolean), "ActivateBroadcast-Thread");
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.rhX == null) {
      this.rhX = new ArrayList();
    }
    this.rhX.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.Wan);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Wan);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.Wan);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.Wan);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Wan);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.Wan);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.Wan);
  }
  
  public final void addSearchMenu(boolean paramBoolean, com.tencent.mm.ui.tools.t paramt)
  {
    Log.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.VRh = a.g.menu_search;
    locala.text = this.mContext.getString(a.k.app_search);
    locala.VRi = a.j.actionbar_icon_dark_search;
    locala.naX = null;
    locala.wOt = null;
    removeOptionMenu(locala.VRh);
    this.VQY.add(0, locala);
    this.VZB = paramBoolean;
    this.jjS = paramt;
    this.jjS.XUu = this;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.Wan);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Wan);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  final boolean atS(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.VQY.size())
      {
        if (((a)this.VQY.get(i)).VRh == paramInt)
        {
          Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.VQY.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a atT(int paramInt)
  {
    Iterator localIterator = this.VQY.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.VRh == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void atU(int paramInt)
  {
    if (noActionBar()) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > this.VQW) {
        i = this.VQW;
      }
      paramInt = i;
      if (i < this.VQX) {
        paramInt = this.VQX;
      }
      this.bsc = paramInt;
      this.actionbarView = this.VZx.getWindow().getDecorView().findViewById(a.g.action_bar_container);
      if (this.actionbarView != null) {
        this.VZL = this.actionbarView.getLayoutParams();
      }
      if ((this.actionbarView != null) && (this.VZL != null))
      {
        this.VZL.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
        this.actionbarView.setLayoutParams(this.VZL);
      }
      float f1 = Math.min(com.tencent.mm.ci.a.ez(this.VZx), com.tencent.mm.ci.a.km(this.VZx));
      i = (int)(aw.aZ(this.mContext, a.e.SmallTiteSzie) * f1);
      int j = (int)(f1 * aw.aZ(this.mContext, a.e.NormalTiteSzie));
      int k = aw.fromDPToPix(this.mContext, 14);
      f1 = (paramInt - this.VQX) / (this.VQW - this.VQX);
      float f2 = i;
      float f3 = j - i;
      setIconAlpha(f1);
      paramInt = (int)((k - aw.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
      i = (int)((this.VQX - this.VQW) / 2.0F * (1.0F - f1));
      if (this.VZF != null)
      {
        this.VZF.setTextSize(0, f3 * f1 + f2);
        if (this.VQL != null)
        {
          this.VQL.setTranslationX(paramInt);
          this.VQL.setTranslationY(i);
        }
      }
      if (this.VZH != null) {
        this.VZH.setTranslationY(i);
      }
    } while (this.VQN == null);
    this.VQN.setTranslationY(i);
  }
  
  public final void bS(int paramInt, boolean paramBoolean)
  {
    this.VZQ = paramInt;
    this.VZR = paramBoolean;
  }
  
  protected abstract String bpE();
  
  final void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.VQY.iterator();
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
      localIterator = this.VQY.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.VRh != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.jjS == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.jjS.XUg)
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
  
  public final boolean callBackMenu()
  {
    if ((this.VZC != null) && (this.VZC.enable))
    {
      a(null, this.VZC);
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
      localIterator = this.VQY.iterator();
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
      localIterator = this.VQY.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.VRh != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.jjS == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.jjS.XUg)
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
    if (this.VZC == null) {}
    while (this.VZC.enable == paramBoolean) {
      return;
    }
    this.VZC.enable = paramBoolean;
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
      this.HDS.removeCallbacks(this.Wac);
      this.HDS.removeCallbacks(this.Wab);
      this.HDS.postDelayed(this.Wab, 256L);
      return;
    }
    this.VZx.getWindow().clearFlags(1024);
    this.HDS.removeCallbacks(this.Wab);
    this.HDS.removeCallbacks(this.Wac);
    this.HDS.postDelayed(this.Wac, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.HDS.removeCallbacks(this.Wac);
      this.HDS.removeCallbacks(this.Wab);
      this.HDS.postDelayed(this.Wab, paramLong);
      return;
    }
    this.VZx.getWindow().clearFlags(1024);
    this.HDS.removeCallbacks(this.Wab);
    this.HDS.removeCallbacks(this.Wac);
    this.HDS.postDelayed(this.Wac, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.VZx.getWindow().setFlags(1024, 1024);
      return;
    }
    this.VZx.getWindow().clearFlags(1024);
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
    if (this.DJc != null) {
      return this.DJc;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.Dlo.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.Dlo.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.VZx.getSupportActionBar();
  }
  
  public final int getTitleLocation()
  {
    if (this.mActionBar == null) {
      return 0;
    }
    return this.mActionBar.getHeight();
  }
  
  public abstract boolean hHD();
  
  public boolean hHE()
  {
    return false;
  }
  
  public final o hHG()
  {
    if ((this.VZD != null) && (this.VZD.XMO)) {
      return this.VZD.ODY;
    }
    return null;
  }
  
  public final ActionBar hHH()
  {
    return this.mActionBar;
  }
  
  public final int hHI()
  {
    this.VQV = false;
    if (this.PQJ == 0) {
      this.PQJ = this.mContext.getResources().getColor(a.d.normal_actionbar_color);
    }
    return this.PQJ;
  }
  
  final void hHK()
  {
    Object localObject1 = "%s";
    int n = this.mContext.getResources().getDimensionPixelSize(a.e.ActionBarTextSize);
    if (this.VZo != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.VZp != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int i = 1;; i = 0)
    {
      if (this.Fyz)
      {
        localObject1 = (String)localObject1 + " #";
        i += 2;
      }
      for (int j = 1;; j = 0)
      {
        int m;
        int k;
        if (this.VZw)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
          m = 1;
          k = i + 2;
        }
        for (i = m;; i = m)
        {
          Object localObject2 = String.format((String)localObject1, new Object[] { this.DJc });
          Log.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
          localObject1 = com.tencent.mm.ui.h.c.b.a(this.mContext, (CharSequence)localObject2, n);
          if ((localObject1 instanceof SpannableString))
          {
            localObject2 = (SpannableString)localObject1;
            if (this.VZo != 0) {
              ((SpannableString)localObject2).setSpan(this.VZq, 0, 1, 33);
            }
            if (this.VZp != 0)
            {
              k = ((SpannableString)localObject2).length() - k;
              ((SpannableString)localObject2).setSpan(this.VZr, k, k + 1, 33);
            }
            if (this.Fyz)
            {
              if (this.VZs == null) {
                this.VZs = a(n, au.o(this.VZx, a.j.icons_outlined_bellring_off, this.VZx.getResources().getColor(a.d.arrow_color)));
              }
              j = ((SpannableString)localObject2).length() - j;
              ((SpannableString)localObject2).setSpan(this.VZs, j, j + 1, 33);
            }
            if (this.VZw)
            {
              if (this.VZu == null) {
                this.VZu = mg(n, a.j.chat_phone_notify_title_icon);
              }
              i = ((SpannableString)localObject2).length() - i;
              ((SpannableString)localObject2).setSpan(this.VZu, i, i + 1, 33);
            }
          }
          this.VZF.setText((CharSequence)localObject1);
          return;
          m = 0;
          k = i;
        }
      }
    }
  }
  
  public final void hideActionbarLine()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().e(0.0F);
    }
  }
  
  public final void hideAllManagedDialogs()
  {
    if (this.rhX != null)
    {
      int j = this.rhX.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.rhX.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.rhX.clear();
      this.rhX = null;
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
    View localView = this.VZx.getCurrentFocus();
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
  
  public final void kN(Context paramContext)
  {
    EventCenter.instance.removeListener(this.VZS);
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
  
  public final boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Log.i("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.VQY.size()) });
    if ((this.mActionBar == null) || (this.VQY.size() == 0))
    {
      Log.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.VQY.size()) });
      d(paramMenu);
      return false;
    }
    this.VZZ = null;
    this.Waa = null;
    Iterator localIterator = this.VQY.iterator();
    while (localIterator.hasNext())
    {
      final a locala = (a)localIterator.next();
      if (locala.VRh == 16908332)
      {
        Log.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      else
      {
        if (locala.VRh == a.g.menu_search)
        {
          boolean bool2 = this.VZB;
          if (this.jjS == null) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            if ((!this.VZB) || (this.jjS == null)) {
              break;
            }
            this.jjS.a(this.VZx, paramMenu);
            break;
          }
        }
        final MenuItem localMenuItem = paramMenu.add(0, locala.VRh, 0, locala.text);
        com.tencent.mm.compatible.h.a.a(localMenuItem, getClass().getName());
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(203536);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            w.a(w.this, localMenuItem, locala);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203536);
          }
        };
        View.OnLongClickListener local3 = new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(190344);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            boolean bool = w.a(w.this, paramAnonymousView, locala);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(190344);
            return bool;
          }
        };
        Object localObject = new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(219294);
            boolean bool = w.a(w.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
            AppMethodBeat.o(219294);
            return bool;
          }
        };
        if ((locala.VRi != 0) || (locala.Wal != null))
        {
          if (locala.VRk == null) {
            locala.VRk = View.inflate(this.mContext, a.h.action_option_view, null);
          }
          localObject = (ImageView)locala.VRk.findViewById(a.g.divider);
          if (localObject != null) {
            ((ImageView)localObject).setVisibility(8);
          }
          this.VQN = ((WeImageView)locala.VRk.findViewById(a.g.action_option_icon));
          this.VQN.setVisibility(0);
          label412:
          PorterDuff.Mode localMode;
          if (locala.Wal != null)
          {
            this.VQN.setImageDrawable(locala.Wal);
            if (this.VZJ == 0) {
              break label675;
            }
            localObject = this.VQN;
            int i = this.VZJ;
            localMode = PorterDuff.Mode.SRC_ATOP;
            a((WeImageView)localObject, i);
            label442:
            this.VQN.setOnClickListener(local2);
            this.VQN.setEnabled(locala.enable);
            this.VQN.setContentDescription(locala.text);
            if (locala.wOt != null) {
              this.VQN.setOnLongClickListener(local3);
            }
            this.VZK = ((ImageView)locala.VRk.findViewById(a.g.dot_iv));
            if (this.VZK != null)
            {
              if (!locala.gbE) {
                break label734;
              }
              this.VZK.setVisibility(0);
            }
          }
          for (;;)
          {
            localMenuItem.setActionView(locala.VRk);
            localMenuItem.setEnabled(locala.enable);
            localMenuItem.setVisible(locala.visible);
            localMenuItem.setShowAsAction(2);
            if (locala.VRi == a.f.mm_title_btn_menu)
            {
              this.VZZ = locala;
              this.Waa = localMenuItem;
            }
            Log.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.VRh), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
            break;
            this.VQN.setImageResource(locala.VRi);
            break label412;
            label675:
            if (locala.Wak != 0) {
              break label442;
            }
            if (this.VQV)
            {
              localObject = this.VQN;
              localMode = PorterDuff.Mode.SRC_ATOP;
              a((WeImageView)localObject, -1);
              break label442;
            }
            localObject = this.VQN;
            localMode = PorterDuff.Mode.SRC_ATOP;
            a((WeImageView)localObject, -16777216);
            break label442;
            label734:
            this.VZK.setVisibility(8);
          }
        }
        if (locala.VRj == null) {
          locala.VRj = View.inflate(this.mContext, a.h.action_option_view, null);
        }
        this.VQO = ((TextView)locala.VRj.findViewById(a.g.action_option_text));
        this.VQO.setVisibility(0);
        this.wzY = ((Button)locala.VRj.findViewById(a.g.action_option_btn));
        this.wzY.setVisibility(8);
        this.VZO = locala.VRj.findViewById(a.g.album_smart_gallery_entry);
        this.VZO.setVisibility(8);
        if ((locala.Wam == b.Wap) || (locala.Wam == b.Was))
        {
          this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.red_text_color_selector));
          this.wzY.setVisibility(0);
          this.wzY.setBackgroundResource(a.f.btn_solid_live_small);
          this.VQO.setVisibility(8);
        }
        for (;;)
        {
          this.VQO.setText(locala.text);
          if (locala.textColor != 0) {
            this.VQO.setTextColor(locala.textColor);
          }
          this.VQO.setOnClickListener(local2);
          this.VQO.setOnLongClickListener(local3);
          this.VQO.setEnabled(locala.enable);
          this.VQO.setOnTouchListener((View.OnTouchListener)localObject);
          this.wzY.setText(locala.text);
          this.wzY.setOnClickListener(local2);
          this.wzY.setOnLongClickListener(local3);
          this.wzY.setOnTouchListener((View.OnTouchListener)localObject);
          this.wzY.setEnabled(locala.enable);
          localMenuItem.setActionView(locala.VRj);
          break;
          if (locala.Wam == b.Wat)
          {
            this.wzY.setVisibility(0);
            this.wzY.setBackgroundResource(a.f.btn_solid_white);
            this.wzY.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.white_btn_text_selector));
            this.VQO.setVisibility(8);
          }
          else if (locala.Wam == b.Wao)
          {
            this.wzY.setVisibility(0);
            this.wzY.setBackgroundResource(a.f.btn_solid_green_small);
            this.wzY.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.color_btn_text_selector));
            this.VQO.setVisibility(8);
          }
          else
          {
            if (locala.Wam != b.Waq)
            {
              if (locala.Wam == b.Wav)
              {
                this.VQO.setTextColor(this.VZx.getResources().getColor(a.d.lucky_money_goldstyle_text_color));
                continue;
              }
              if (locala.Wam == b.Wau)
              {
                this.VQO.setTextColor(this.VZx.getResources().getColor(a.d.red_text_color));
                continue;
              }
              if (locala.Wam == b.Way)
              {
                this.wzY.setVisibility(0);
                this.wzY.setBackgroundResource(a.f.btn_solid_yellow_small);
                this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.color_btn_text_selector));
                this.VQO.setVisibility(8);
                continue;
              }
              if (b.WaA == locala.Wam)
              {
                Log.i("MicroMsg.MMActivityController", "dark green mode.");
                this.wzY.setVisibility(0);
                this.wzY.setBackgroundResource(a.f.btn_solid_dark_green_small);
                this.wzY.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.gallery_btn_text_selector));
                this.VQO.setVisibility(8);
                continue;
              }
              if (locala.Wam == b.Waz)
              {
                this.wzY.setVisibility(0);
                this.wzY.setBackgroundResource(a.f.btn_solid_orange_small);
                this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.color_btn_text_selector));
                this.VQO.setVisibility(8);
                continue;
              }
              if (b.WaB == locala.Wam)
              {
                Log.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.VZA) });
                this.VQO.setVisibility(8);
                if (this.VZA)
                {
                  this.VZO.setVisibility(0);
                  this.VZO.setOnClickListener(local2);
                  continue;
                }
                if (8 == this.VZO.getVisibility()) {
                  this.VZO.setVisibility(4);
                }
                for (;;)
                {
                  this.VZO.setOnClickListener(null);
                  break;
                  if (this.VZO.getVisibility() == 0) {
                    this.VZO.animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(141333);
                        w.i(w.this).setVisibility(4);
                        AppMethodBeat.o(141333);
                      }
                    });
                  }
                }
              }
              if (b.WaC == locala.Wam)
              {
                this.wzY.setVisibility(0);
                this.wzY.setBackgroundResource(a.f.btn_solid_orange_small);
                this.wzY.setTextColor(com.tencent.mm.ci.a.w(this.VZx, a.d.btn_white_text_color));
                this.VQO.setVisibility(8);
                continue;
              }
              if (b.WaD == locala.Wam)
              {
                this.wzY.setVisibility(0);
                this.wzY.setBackgroundResource(a.f.btn_solid_gray_small);
                this.wzY.setTextColor(com.tencent.mm.ci.a.w(this.VZx, a.d.BW_0_Alpha_0_9));
                this.VQO.setVisibility(8);
                continue;
              }
              if (b.WaE == locala.Wam)
              {
                this.wzY.setVisibility(0);
                this.wzY.setBackgroundResource(a.f.btn_solid_live_small);
                this.wzY.setTextColor(com.tencent.mm.ci.a.w(this.VZx, a.d.BW_100_Alpha_0_8));
                this.VQO.setVisibility(8);
                continue;
              }
              if (this.VZJ != 0)
              {
                this.VQO.setTextColor(this.VZJ);
                continue;
              }
              if (this.VQV)
              {
                this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.white_text_color_selector));
                continue;
              }
            }
            this.VQO.setTextColor(com.tencent.mm.ci.a.l(this.VZx, a.d.black_text_color_selector));
          }
        }
      }
    }
    d(paramMenu);
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.atI();
    com.tencent.mm.compatible.b.g.atI();
    if ((this.VZB) && (this.jjS != null) && (this.jjS.onKeyDown(paramInt, paramKeyEvent)))
    {
      Log.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.VQV) {
        setActionbarColor(this.VZx.getResources().getColor(a.d.dark_actionbar_color));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.VZx.getResources().getColor(a.d.normal_actionbar_color));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.VZZ != null) && (this.VZZ.enable)) {
        a(this.Waa, this.VZZ);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Log.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.VZn)
    {
      Log.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.VZC.VRh) && (this.VZC.enable))
    {
      a(paramMenuItem, this.VZC);
      return true;
    }
    Iterator localIterator = this.VQY.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.VRh)
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
    EventCenter.instance.removeListener(this.VZS);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Log.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.VZB) && (this.jjS != null)) {
      this.jjS.a(this.VZx, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    EventCenter.instance.addListener(this.VZS);
    Object localObject = new at();
    ((at)localObject).fwm.type = 2;
    ((at)localObject).fwm.position = this.VZQ;
    EventCenter.instance.publish((IEvent)localObject);
    long l;
    String str;
    int i;
    if (((at)localObject).fwn.fwq == 2)
    {
      l = System.currentTimeMillis();
      str = ((at)localObject).fwn.fwt;
      i = ((at)localObject).fwn.position;
      Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.VZQ)) {
        break label432;
      }
      Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.VZQ) });
    }
    for (;;)
    {
      Log.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT) && (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.ci.a.ez(MMApplicationContext.getContext())) {
          break;
        }
        if (1.0F != MMApplicationContext.getContext().getResources().getConfiguration().fontScale)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(15181, new Object[] { Integer.valueOf(1) });
          localObject = new f.a(MMApplicationContext.getContext());
          ((f.a)localObject).aR(this.VZx.getResources().getString(a.k.font_scale_adjust_title)).bBl(this.VZx.getResources().getString(a.k.font_scale_adjust_content)).bBp(this.VZx.getResources().getString(a.k.font_scale_adjust_positive_text)).bBq(this.VZx.getResources().getString(a.k.font_scale_adjust_negative_text));
          ((f.a)localObject).c(new w.20(this)).show();
          MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label432:
      a(((at)localObject).fwn.fws, ((at)localObject).fwn.visible, ((at)localObject).fwn.url, ((at)localObject).fwn.desc, str, i, true);
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
        this.VZx.setRequestedOrientation(-1);
        return;
      }
      this.VZx.setRequestedOrientation(1);
      return;
    }
    this.VZx.setRequestedOrientation(getForceOrientation());
  }
  
  protected View provideCustomActivityContentView()
  {
    return null;
  }
  
  @TargetApi(21)
  public final void q(Activity paramActivity, int paramInt)
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
        com.tencent.mm.ui.statusbar.a.f(this.contentView, i, com.tencent.mm.ui.statusbar.d.f(paramActivity.getWindow()));
      }
      for (;;)
      {
        setNavigationbarColor(paramActivity.getResources().getColor(a.d.BG_0));
        this.PyE = paramInt;
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label124;
        }
        i = au.A(paramActivity.getResources().getColor(a.d.statusbar_fg_drak_color), paramInt);
        break;
        paramActivity.getWindow().setStatusBarColor(i);
      }
      label124:
      i = 0;
    }
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.VQY.isEmpty()) {
      return;
    }
    this.VQY.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.VQY.size())
      {
        if (((a)this.VQY.get(i)).VRh == paramInt)
        {
          Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.VQY.remove(i);
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
  
  public final void setActionbarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.PQJ = paramInt;
    this.VQV = au.auk(this.PQJ);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.PQJ));
    q(this.VZx, this.PQJ);
    hHM();
    hHL();
  }
  
  public final void setBackBtn(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null) {
      this.mActionBar.s(false);
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (this.VZH.getDrawable() == null) {
          i = a.j.actionbar_icon_dark_back;
        }
      }
      if ((this.VZH != null) && (i != 0)) {
        this.VZH.setImageResource(i);
      }
      this.VZC.VRh = 16908332;
      this.VZC.naX = paramOnMenuItemClickListener;
      return;
      this.mActionBar.s(false);
      if (this.VZG != null) {
        this.VZG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(219775);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MMActivityController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219616);
                w.10.this.VRa.onMenuItemClick(null);
                AppMethodBeat.o(219616);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219775);
          }
        });
      }
    }
  }
  
  public final void setBackBtnColorFilter(int paramInt)
  {
    if (this.VZH != null) {
      this.VZH.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.VZH == null) {
      return;
    }
    if (paramBoolean)
    {
      this.VZH.setVisibility(0);
      return;
    }
    this.VZH.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.VZm == null) {
      this.VZm = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    this.VZm.setBackgroundResource(paramInt);
    this.Nrv.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.VZm == null) {
      this.VZm = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    if (this.VZk != null) {
      this.VZm.removeView(this.VZk);
    }
    this.VZm.removeView(this.Nrv);
    this.Nrv = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.VZm.addView(this.Nrv, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.VZk != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 47.0F));
      this.VZm.addView(this.VZk, this.VZm.getChildCount(), localLayoutParams);
    }
    this.VZm.invalidate();
  }
  
  public final void setBounceEnabled(boolean paramBoolean)
  {
    this.bounceEnable = paramBoolean;
    if (this.VZy != null) {
      this.VZy.setBounceEnabled(paramBoolean);
    }
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.VZG != null)
    {
      this.VZG.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.VZG.setEnabled(false);
    }
    for (;;)
    {
      if (this.VQN != null)
      {
        this.VQN.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.VQN.setEnabled(false);
      }
      return;
      label59:
      this.VZG.setEnabled(true);
    }
    this.VQN.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      bm(this.VZx);
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
        this.mActionBar.N(VZU);
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
    this.rsy.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.ci.a.ko(this.VZx))
    {
      this.rsy.setTextSize(1, 14.0F);
      this.VZF.setTextSize(1, 18.0F);
    }
    this.rsy.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.rsy.setVisibility(8);
      return;
    }
    this.rsy.setText(paramString);
    if (com.tencent.mm.ci.a.ko(this.VZx))
    {
      this.rsy.setTextSize(1, 14.0F);
      this.VZF.setTextSize(1, 18.0F);
    }
    this.rsy.setVisibility(0);
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
    this.DJc = paramCharSequence.toString();
    this.VZF.setText(paramCharSequence);
    if (com.tencent.mm.ci.a.ko(this.VZx)) {
      this.VZF.setTextSize(0, com.tencent.mm.ci.a.aZ(this.VZx, a.e.ActionBarTextSize) * com.tencent.mm.ci.a.km(this.VZx));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.DJc = paramString;
    if (com.tencent.mm.ci.a.ko(this.VZx)) {
      this.VZF.setTextSize(0, com.tencent.mm.ci.a.aZ(this.VZx, a.e.ActionBarTextSize) * com.tencent.mm.ci.a.km(this.VZx));
    }
    hHK();
    updateDescription(paramString);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.VZF.setVisibility(paramInt);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!t.hHy()))
    {
      this.VZx.getWindow().setNavigationBarColor(paramInt);
      boolean bool = au.auk(paramInt);
      localView = this.VZx.getWindow().getDecorView();
      paramInt = localView.getSystemUiVisibility();
      if (!bool) {
        break label61;
      }
      paramInt &= 0xFFFFFFEF;
    }
    for (;;)
    {
      localView.setSystemUiVisibility(paramInt);
      return;
      label61:
      paramInt |= 0x10;
    }
  }
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.VZn = paramBoolean;
    if ((this.VZj == null) && (this.contentView != null)) {
      this.VZj = this.contentView.findViewById(a.g.mm_trans_layer);
    }
    if (this.VZj == null)
    {
      Log.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.VZj;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.VZj;
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
      kM(this.VZx);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    q(this.VZx, paramInt);
    updataStatusBarIcon(au.auk(paramInt));
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    if ((this.mActionBar == null) || (paramRunnable == null)) {
      return;
    }
    this.mActionBar.getCustomView().setOnClickListener(new w.8(this, paramRunnable));
  }
  
  public final void setTitleLogo(int paramInt1, int paramInt2)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.VZo = 0;
      this.VZq = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.VZp = 0;
      this.VZr = null;
    }
    for (;;)
    {
      hHK();
      return;
      if (this.VZo == paramInt1) {
        break;
      }
      this.VZo = paramInt1;
      this.VZq = mg(this.mContext.getResources().getDimensionPixelSize(a.e.BigTextSize), this.VZo);
      break;
      label82:
      if (this.VZp != paramInt2)
      {
        this.VZp = paramInt2;
        this.VZr = mg(this.mContext.getResources().getDimensionPixelSize(a.e.BigTextSize), this.VZp);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fyz = bool;
      hHK();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.VZw = bool;
      hHK();
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
      q(this.VZx, this.PQJ);
    }
    for (;;)
    {
      Log.d("MicroMsg.MMActivityController", "setTitleVisibility visible: %s.", new Object[] { Integer.valueOf(paramInt) });
      return;
      this.mActionBar.hide();
      q(this.VZx, this.VZx.getResources().getColor(a.d.black));
    }
  }
  
  public final void showActionbarLine()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().e(1.0F);
    }
  }
  
  public final void showHomeBtn(boolean paramBoolean)
  {
    if (this.mActionBar == null) {}
    do
    {
      return;
      this.mActionBar.s(paramBoolean);
    } while (this.VZG == null);
    View localView = this.VZG;
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
    this.VZx.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.VZx.getWindow().getDecorView();
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
  
  public final void updateBackBtn(Drawable paramDrawable)
  {
    if (this.mActionBar == null) {}
    while ((this.VZH == null) || (paramDrawable == null)) {
      return;
    }
    this.VZH.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.hJg().p(this.VZx, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = atT(paramInt1);
    if ((locala != null) && (locala.VRi != paramInt2))
    {
      locala.VRi = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = atT(paramInt);
    if (locala != null)
    {
      locala.naX = paramOnMenuItemClickListener;
      locala.wOt = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = atT(paramInt);
    if ((locala != null) && (locala.gbE != paramBoolean))
    {
      locala.gbE = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = atT(paramInt);
    if ((locala != null) && (!Util.nullAs(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public static final class a
  {
    public int VRh = -1;
    public int VRi;
    public View VRj;
    public View VRk;
    public int Wak = 0;
    public Drawable Wal;
    public w.b Wam = w.b.Wan;
    public boolean enable = true;
    public boolean gbE = false;
    public MenuItem.OnMenuItemClickListener naX;
    public String text;
    public int textColor;
    public boolean visible = true;
    public View.OnLongClickListener wOt;
    public View.OnTouchListener yQj;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      Wan = new b("NORMAL", 0);
      Wao = new b("GREEN", 1);
      Wap = new b("RED", 2);
      Waq = new b("BLACK", 3);
      War = new b("TRANSPARENT", 4);
      Was = new b("TRANSPARENT_RED_TEXT", 5);
      Wat = new b("TRANSPARENT_GREEN_TEXT", 6);
      Wau = new b("GOLDEN", 7);
      Wav = new b("TRANSPARENT_GOLD_TEXT", 8);
      Waw = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      Wax = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      Way = new b("YELLOW", 11);
      Waz = new b("ORANGE", 12);
      WaA = new b("DARK_GREEN_MODE", 13);
      WaB = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      WaC = new b("FEED_FOLLOW", 15);
      WaD = new b("FEED_UNFOLLOW", 16);
      WaE = new b("FINDER_LIVE", 17);
      WaF = new b[] { Wan, Wao, Wap, Waq, War, Was, Wat, Wau, Wav, Waw, Wax, Way, Waz, WaA, WaB, WaC, WaD, WaE };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */