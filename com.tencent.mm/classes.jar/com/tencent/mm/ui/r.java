package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ao.b;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class r
{
  private static boolean FNP = false;
  private static final int FOg = 2131492928;
  public static long FOi;
  private static byte[] FOk = { 0 };
  private static PowerManager.WakeLock wakeLock = null;
  View FGG;
  private int FGI = 0;
  WeImageView FGJ;
  TextView FGL;
  private boolean FGS = false;
  int FGT;
  private int FGU;
  LinkedList<a> FGV = new LinkedList();
  private String FNA = " ";
  private int FNB = 0;
  private int FNC = 0;
  private com.tencent.mm.ui.widget.a FND = null;
  private com.tencent.mm.ui.widget.a FNE = null;
  private com.tencent.mm.ui.widget.a FNF = null;
  private com.tencent.mm.ui.widget.a FNG = null;
  private com.tencent.mm.ui.widget.a FNH = null;
  private boolean FNI = false;
  boolean FNJ = false;
  private boolean FNK = false;
  public AppCompatActivity FNL;
  boolean FNM = false;
  private boolean FNN;
  private a FNO = new a();
  ArrayList<Dialog> FNQ;
  TextView FNR;
  View FNS;
  WeImageView FNT;
  ProgressBar FNU;
  int FNV = 0;
  private ImageView FNW;
  private ViewGroup.LayoutParams FNX;
  View FNY;
  AlbumChooserView FNZ;
  private View FNu;
  public View FNv;
  private View FNw;
  private TextView FNx;
  private FrameLayout FNy;
  public boolean FNz = true;
  private View FOa;
  public boolean FOb = true;
  private int FOc = 0;
  private boolean FOd = false;
  private c FOe = new c() {};
  private int FOf = 2131492926;
  private int FOh = -1;
  int FOj = 0;
  private a FOl;
  private MenuItem FOm;
  private Runnable FOn = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141333);
      r.j(r.this).getWindow().setFlags(1024, 1024);
      if (r.k(r.this) != null) {
        r.k(r.this).hide();
      }
      AppMethodBeat.o(141333);
    }
  };
  private Runnable FOo = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141334);
      if (r.k(r.this) != null) {
        r.k(r.this).show();
      }
      AppMethodBeat.o(141334);
    }
  };
  private View actionbarView;
  int bAg = this.FGT;
  String className;
  View contentView;
  private boolean fTY = false;
  private com.tencent.mm.ui.tools.r fvI;
  private AudioManager hCo;
  private LayoutInflater imq;
  TextView lZH;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  private Button pSX;
  protected ap rfb = new ap(Looper.getMainLooper());
  private final long xFP = 300L;
  private long xFQ = SystemClock.elapsedRealtime();
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.FGS) {
      localDrawable = am.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, ao.ap(this.FNL, 2131165289), ao.ap(this.FNL, 2131165289));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable);
    paramDrawable.HyD = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.FHe = paramInt1;
    locala.FHf = paramInt2;
    locala.text = paramString;
    locala.ioW = paramOnMenuItemClickListener;
    locala.qhH = paramOnLongClickListener;
    locala.FOy = paramb;
    locala.FOz = paramBoolean;
    if ((locala.FHf == 2131233291) && (bt.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(2131755815);
    }
    Xk(locala.FHe);
    this.FGV.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.FHe = paramInt;
    locala.FOx = paramDrawable;
    locala.text = paramString;
    locala.ioW = paramOnMenuItemClickListener;
    locala.qhH = null;
    locala.FOy = paramb;
    Xk(locala.FHe);
    this.FGV.add(locala);
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141339);
        r.this.supportInvalidateOptionsMenu();
        AppMethodBeat.o(141339);
      }
    }, 200L);
  }
  
  private void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, boolean paramBoolean2)
  {
    ad.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.FNw });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.FNw == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      ad.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.FNy == null) {
      this.FNy = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.FNw != null) {
      this.FNy.removeView(this.FNw);
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.FNw = this.imq.inflate(paramInt1, null);
      this.FNx = ((TextView)this.FNw.findViewById(2131302969));
      this.FNw.findViewById(2131302964).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141341);
          paramAnonymousView = new com.tencent.mm.g.a.ao();
          paramAnonymousView.dcv.type = 1;
          paramAnonymousView.dcv.dcx = paramString3;
          paramAnonymousView.dcv.position = paramInt2;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
          r.b(r.this).setVisibility(8);
          AppMethodBeat.o(141341);
        }
      });
      this.FNw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141343);
          if (paramString1 != null)
          {
            Object localObject = new Intent("android.intent.action.VIEW");
            ((Intent)localObject).setData(Uri.parse(paramString1));
            paramAnonymousView = r.c(r.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(141343);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.FOd) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.g(this.FNL, 48.0F), 0, 0);
        ad.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.FNy.addView(this.FNw, this.FNy.getChildCount(), paramString3);
      if (this.FNw == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.FNw;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(2131760318);
          paramString3 = paramString2;
          if (bt.isNullOrNil(paramString2)) {
            paramString3 = this.mContext.getString(2131758083);
          }
          if (paramString1 == null) {
            break label488;
          }
          paramString1 = new SpannableString(paramString3 + str);
          paramString2 = new ForegroundColorSpan(-10119449);
          paramInt1 = paramString3.length();
          paramInt2 = paramString3.length();
          paramString1.setSpan(paramString2, paramInt1, str.length() + paramInt2, 33);
          this.FNx.setText(paramString1);
        }
        for (;;)
        {
          this.FNw.invalidate();
          this.FNy.invalidate();
          return;
          paramInt1 = 8;
          break;
          label488:
          ad.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.FNx.setText(paramString3);
        }
      }
      this.FNw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141344);
          Object localObject = r.b(r.this);
          int i;
          if (paramBoolean1)
          {
            i = 0;
            ((View)localObject).setVisibility(i);
            String str = r.c(r.this).getString(2131760318);
            if (!bt.isNullOrNil(paramString2)) {
              break label170;
            }
            localObject = r.c(r.this).getString(2131758083);
            label63:
            if (paramString1 == null) {
              break label178;
            }
            SpannableString localSpannableString = new SpannableString((String)localObject + str);
            localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
            r.d(r.this).setText(localSpannableString);
          }
          for (;;)
          {
            r.b(r.this).invalidate();
            r.e(r.this).invalidate();
            AppMethodBeat.o(141344);
            return;
            i = 8;
            break;
            label170:
            localObject = paramString2;
            break label63;
            label178:
            ad.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
            r.d(r.this).setText((CharSequence)localObject);
          }
        }
      });
      return;
      paramInt1 = 2131494915;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.FNz) {
      ad.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.ioW == null) {
      return;
    }
    parama.ioW.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.FOb)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.clearColorFilter();
  }
  
  private static boolean aJZ(String paramString)
  {
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {}
    while ((!lo(str1, paramString)) && (!lo(str2, paramString))) {
      return false;
    }
    return true;
  }
  
  private static boolean aU(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(2130969570, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131764538))));
    return true;
  }
  
  private static boolean aV(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(2130969570, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131759747))));
    return true;
  }
  
  private static boolean aW(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(2130969570, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131761775))));
    return true;
  }
  
  private void aX(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      ad.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.FGI == 0) {
        this.FGI = eQV();
      }
      this.FGS = am.XC(this.FGI);
      setActionbarColor(this.FGI);
      this.mActionBar.setLogo(new ColorDrawable(this.FNL.getResources().getColor(17170445)));
      this.mActionBar.fM();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.fL();
      this.mActionBar.fN();
      this.mActionBar.fK();
      if (this.FOh != -1) {
        break label370;
      }
      localView = y.js(this.FNL).inflate(this.FOf, new LinearLayout(this.FNL), false);
      this.mActionBar.setCustomView(localView);
      this.FNR = ((TextView)findViewById(16908308));
      this.lZH = ((TextView)findViewById(16908309));
      this.FGG = findViewById(2131305937);
      this.FNU = ((ProgressBar)findViewById(2131303518));
      this.FNS = findViewById(2131296416);
      this.FNT = ((WeImageView)findViewById(2131296417));
      this.FNS.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(141348);
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            r.FOi = System.currentTimeMillis();
          }
          AppMethodBeat.o(141348);
          return false;
        }
      });
      if (this.FNT != null) {
        this.FNT.setContentDescription(this.FNL.getString(2131755281));
      }
      if (this.FNR != null) {
        this.FNR.setText(2131755822);
      }
      this.FNY = findViewById(2131296408);
      this.FNZ = ((AlbumChooserView)findViewById(2131296394));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label408;
      }
      if (this.FNT != null) {
        this.FNT.setVisibility(0);
      }
      if (this.FNS != null) {
        this.FNS.setVisibility(0);
      }
    }
    for (;;)
    {
      eQY();
      return;
      label370:
      localView = y.js(this.FNL).inflate(this.FOh, new LinearLayout(this.FNL), false);
      this.mActionBar.setCustomView(localView);
      break;
      label408:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.FNT != null) {
          this.FNT.setVisibility(0);
        }
        if (this.FNS != null) {
          this.FNS.setVisibility(0);
        }
        if (this.FNR != null)
        {
          this.FNR.setVisibility(0);
          ai.a(this.FNR.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.FNT != null) {
          this.FNT.setVisibility(8);
        }
        if (this.FNS != null) {
          this.FNS.setVisibility(8);
        }
      }
    }
  }
  
  private void b(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.FOb)
    {
      paramDrawable.setColorFilter(paramInt, paramMode);
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  public static boolean eQW()
  {
    for (;;)
    {
      synchronized (FOk)
      {
        if (wakeLock != null)
        {
          bool = wakeLock.isHeld();
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void eQY()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.FGS)
    {
      if (this.FNT != null)
      {
        localWeImageView = this.FNT;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.FNR != null) && (this.FNR.getVisibility() == 0)) {
        this.FNR.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.lZH != null) && (this.lZH.getVisibility() == 0)) {
        this.lZH.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.FGJ != null) && (this.FGJ.getVisibility() == 0)) {
        if (this.FGJ.getDrawable() != null) {
          b(this.FGJ.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.FGJ;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.FGL == null) || (this.FGL.getVisibility() != 0));
      this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.mContext, 2131101185));
      return;
      if (this.FNT != null)
      {
        localWeImageView = this.FNT;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
      }
      if ((this.FNR != null) && (this.FNR.getVisibility() == 0)) {
        this.FNR.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.lZH != null) && (this.lZH.getVisibility() == 0)) {
        this.lZH.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.FGJ != null) && (this.FGJ.getVisibility() == 0))
      {
        if (this.FGJ.getDrawable() != null)
        {
          b(this.FGJ.getDrawable(), -16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        localWeImageView = this.FGJ;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
        return;
      }
    } while ((this.FGL == null) || (this.FGL.getVisibility() != 0));
    this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.mContext, 2131100024));
  }
  
  private void eQZ()
  {
    updataStatusBarIcon(this.FGS);
  }
  
  private static boolean eRa()
  {
    return (aJZ("y83a")) || (aJZ("y83")) || (aJZ("v1732a")) || (aJZ("v1732t"));
  }
  
  public static boolean eRb()
  {
    return eRa();
  }
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.FNL.findViewById(paramInt);
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return initLanguage(paramContext, ac.f(paramContext.getSharedPreferences(aj.eFD(), 0)));
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      ac.a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = ac.aFt(paramString);
    ac.a(paramContext, paramString);
    return paramString;
  }
  
  private com.tencent.mm.ui.widget.a jc(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.FGS) {
      localDrawable = am.i(this.FNL, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.HyD = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private void jn(Context paramContext)
  {
    synchronized (FOk)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(32, "screen Lock");
      }
      if (!wakeLock.isHeld())
      {
        wakeLock.acquire();
        ad.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      ad.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  private static boolean lo(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return bt.kU(paramString1.toLowerCase(), paramString2.toLowerCase());
  }
  
  private void releaseWakeLock()
  {
    synchronized (FOk)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        wakeLock.release();
        ad.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        wakeLock = null;
        return;
      }
      ad.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  public static void setMainProcess()
  {
    FNP = true;
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
  
  final boolean Xk(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.FGV.size())
      {
        if (((a)this.FGV.get(i)).FHe == paramInt)
        {
          ad.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.FGV.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a Xl(int paramInt)
  {
    Iterator localIterator = this.FGV.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.FHe == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void Xm(int paramInt)
  {
    if (noActionBar()) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > this.FGT) {
        i = this.FGT;
      }
      paramInt = i;
      if (i < this.FGU) {
        paramInt = this.FGU;
      }
      this.bAg = paramInt;
      this.actionbarView = this.FNL.getWindow().getDecorView().findViewById(2131296345);
      if (this.actionbarView != null) {
        this.FNX = this.actionbarView.getLayoutParams();
      }
      if ((this.actionbarView != null) && (this.FNX != null))
      {
        this.FNX.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
        this.actionbarView.setLayoutParams(this.FNX);
      }
      float f1 = Math.min(com.tencent.mm.cd.a.dT(this.FNL), com.tencent.mm.cd.a.hQ(this.FNL));
      i = (int)(ao.ap(this.mContext, 2131165570) * f1);
      int j = (int)(f1 * ao.ap(this.mContext, 2131165518));
      int k = ao.fromDPToPix(this.mContext, 14);
      f1 = (paramInt - this.FGU) / (this.FGT - this.FGU);
      float f2 = i;
      float f3 = j - i;
      setIconAlpha(f1);
      paramInt = (int)((k - ao.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
      i = (int)((this.FGU - this.FGT) / 2.0F * (1.0F - f1));
      if (this.FNR != null)
      {
        this.FNR.setTextSize(0, f3 * f1 + f2);
        if (this.FGG != null)
        {
          this.FGG.setTranslationX(paramInt);
          this.FGG.setTranslationY(i);
        }
      }
      if (this.FNT != null) {
        this.FNT.setTranslationY(i);
      }
    } while (this.FGJ == null);
    this.FGJ.setTranslationY(i);
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.FNL = paramAppCompatActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = this.FNL.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      this.FNL.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    if (!noActionBar())
    {
      boolean bool = aj.getContext().getSharedPreferences(aj.eFD() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
      aj.getContext().getSharedPreferences(aj.eFD() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (!bool)
      {
        aj.getContext().getSharedPreferences(aj.eFD() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
        aj.getContext().getSharedPreferences(aj.eFD() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
      }
    }
    this.fTY = ai.j(paramAppCompatActivity.getResources());
    int i;
    label448:
    label582:
    label736:
    long l;
    if (paramAppCompatActivity != null)
    {
      if (!this.fTY) {
        break label1026;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && ((aU(paramAppCompatActivity)) || (((MMActivity)paramAppCompatActivity).transparentTheme))) {
        paramAppCompatActivity.setTheme(2131820572);
      }
    }
    else
    {
      onCreateBeforeSetContentView();
      this.className = getClass().getName();
      ag.cG(3, this.className);
      initLanguage(paramContext);
      this.hCo = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.imq = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.a.b.agA();
        this.contentView = com.tencent.mm.kiss.a.b.c(paramAppCompatActivity, 2131494760);
      }
      this.FNu = this.contentView.findViewById(2131302342);
      this.FNy = ((FrameLayout)this.contentView.findViewById(2131302320));
      if (i != -1)
      {
        this.FNv = getLayoutView();
        if (this.FNv != null) {
          break label1118;
        }
        this.FNv = this.imq.inflate(getLayoutId(), null);
        this.FNy.addView(this.FNv, 0);
      }
      dealContentView(this.contentView);
      if (fromFullScreenActivity())
      {
        ai.l(ai.a(this.FNL.getWindow(), this.FNv), this.FNv);
        ((ViewGroup)this.FNv.getParent()).removeView(this.FNv);
        ((ViewGroup)this.FNL.getWindow().getDecorView()).addView(this.FNv, 0);
        int j = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label1148;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165251);
        this.FNv.setPadding(this.FNv.getPaddingLeft(), i + (j + this.FNv.getPaddingTop()), this.FNv.getPaddingRight(), this.FNv.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      ad.d("MicroMsg.MMActivityController", "onCreate, before.");
      aX(paramAppCompatActivity);
      if (!noActionBar())
      {
        this.FGT = ao.ap(this.mContext, 2131165252);
        this.FGU = ao.ap(this.mContext, 2131165559);
      }
      if (this.FNy != null) {
        this.FNy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(141345);
            r.e(r.this).removeOnAttachStateChangeListener(this);
            com.tencent.mm.kiss.a.b.agB();
            AppMethodBeat.o(141345);
          }
        });
      }
      if ((this.FNy == null) || (!(this.FNy instanceof LayoutListenerView))) {
        break label1165;
      }
      ((LayoutListenerView)this.FNy).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int FOv;
        
        public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(141347);
          if (r.f(r.this))
          {
            AppMethodBeat.o(141347);
            return;
          }
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
          {
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.FOv))
            {
              r.g(r.this);
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.FOv)) {
              r.h(r.this);
            }
          }
          AppMethodBeat.o(141347);
        }
      });
      paramContext = new com.tencent.mm.g.a.ao();
      paramContext.dcv.type = 2;
      paramContext.dcv.position = this.FOc;
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      if (paramContext.dcw.dcA == 2)
      {
        l = System.currentTimeMillis();
        localObject = paramContext.dcw.dcC;
        i = paramContext.dcw.position;
        ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject, bt.eGN() });
        if ((i <= 0) || (i == this.FOc)) {
          break label1177;
        }
        ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.FOc) });
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
      {
        if (this.FGI == 0) {
          this.FGI = eQV();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        q(paramAppCompatActivity, this.FGI);
        eQZ();
      }
      return;
      if (((paramAppCompatActivity instanceof MMActivity)) && (aW(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820571);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (aV(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820570);
        break;
      }
      paramAppCompatActivity.setTheme(2131820569);
      break;
      label1026:
      if (((paramAppCompatActivity instanceof MMActivity)) && ((((MMActivity)paramAppCompatActivity).transparentTheme) || (aU(paramAppCompatActivity))))
      {
        paramAppCompatActivity.setTheme(2131820577);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (aW(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820576);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (aV(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820575);
        break;
      }
      paramAppCompatActivity.setTheme(2131820574);
      break;
      label1118:
      if (this.FNv.getParent() == null) {
        break label448;
      }
      ((ViewGroup)this.FNv.getParent()).removeView(this.FNv);
      break label448;
      label1148:
      i = this.mContext.getResources().getDimensionPixelSize(2131165252);
      break label582;
      label1165:
      ad.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label736;
      label1177:
      a(paramContext.dcw.dcB, paramContext.dcw.visible, paramContext.dcw.url, paramContext.dcw.desc, (String)localObject, i, true);
    }
  }
  
  public final void a(a parama)
  {
    Xk(parama.FHe);
    this.FGV.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  public final void aT(int paramInt, boolean paramBoolean)
  {
    this.FOc = paramInt;
    this.FOd = paramBoolean;
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    if ((!FNP) && (paramBoolean))
    {
      com.tencent.mm.ui.base.y.d(paramBoolean, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
      return;
    }
    com.tencent.mm.ui.base.y.d(paramBoolean, new Intent().putExtra("classname", getClassName() + getIdentString()));
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.FNQ == null) {
      this.FNQ = new ArrayList();
    }
    this.FNQ.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.FOA);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.FOA);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.FOA);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.FOA);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.FOA);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.FOA);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.FOA);
  }
  
  public final void addSearchMenu(boolean paramBoolean, com.tencent.mm.ui.tools.r paramr)
  {
    ad.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.FHe = 2131302248;
    locala.text = this.mContext.getString(2131755882);
    locala.FHf = 2131689494;
    locala.ioW = null;
    locala.qhH = null;
    removeOptionMenu(locala.FHe);
    this.FGV.add(0, locala);
    this.FNN = paramBoolean;
    this.fvI = paramr;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.FOA);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.FOA);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  final void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.FGV.iterator();
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
      localIterator = this.FGV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.FHe != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fvI == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fvI.Htk)
        {
          if (!paramBoolean1) {
            supportInvalidateOptionsMenu();
          }
          ad.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
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
      localIterator = this.FGV.iterator();
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
      localIterator = this.FGV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.FHe != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fvI == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fvI.Htk)
        {
          if ((bool) && (!paramBoolean1)) {
            supportInvalidateOptionsMenu();
          }
          ad.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final boolean callBackMenu()
  {
    if ((this.FNO != null) && (this.FNO.enable))
    {
      a(null, this.FNO);
      return true;
    }
    return false;
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final int eQV()
  {
    this.FGS = false;
    if (this.FGI == 0) {
      this.FGI = this.mContext.getResources().getColor(2131100705);
    }
    return this.FGI;
  }
  
  final void eQX()
  {
    Object localObject1 = "%s";
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131165184);
    if (this.FNB != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.FNC != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int j = 1;; j = 0)
    {
      if ((!this.FNJ) && (this.FNI))
      {
        localObject1 = (String)localObject1 + " #";
        j += 2;
      }
      for (int i = 1;; i = 0)
      {
        if (this.FNJ)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
        }
        for (int k = 1;; k = 0)
        {
          int n;
          int m;
          if (this.FNK)
          {
            localObject1 = (String)localObject1 + " #";
            n = i + 2;
            i = 1;
            m = j + 2;
            j = n;
          }
          for (;;)
          {
            Object localObject2 = String.format((String)localObject1, new Object[] { this.FNA });
            ad.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
            localObject1 = com.tencent.mm.ui.f.c.b.g(this.mContext, (CharSequence)localObject2, i1);
            if ((localObject1 instanceof SpannableString))
            {
              localObject2 = (SpannableString)localObject1;
              if (this.FNB != 0) {
                ((SpannableString)localObject2).setSpan(this.FND, 0, 1, 33);
              }
              if (this.FNC != 0)
              {
                m = ((SpannableString)localObject2).length() - m;
                ((SpannableString)localObject2).setSpan(this.FNE, m, m + 1, 33);
              }
              if (this.FNJ)
              {
                if (this.FNG == null) {
                  this.FNG = jc(i1, 2131689877);
                }
                k = ((SpannableString)localObject2).length() - k;
                ((SpannableString)localObject2).setSpan(this.FNG, k, k + 1, 33);
              }
              if ((!this.FNJ) && (this.FNI))
              {
                if (this.FNF == null) {
                  this.FNF = a(i1, am.i(this.FNL, 2131690523, this.FNL.getResources().getColor(2131099982)));
                }
                j = ((SpannableString)localObject2).length() - j;
                ((SpannableString)localObject2).setSpan(this.FNF, j, j + 1, 33);
              }
              if (this.FNK)
              {
                if (this.FNH == null) {
                  this.FNH = jc(i1, 2131689880);
                }
                i = ((SpannableString)localObject2).length() - i;
                ((SpannableString)localObject2).setSpan(this.FNH, i, i + 1, 33);
              }
            }
            this.FNR.setText((CharSequence)localObject1);
            return;
            n = 0;
            m = j;
            j = i;
            i = n;
          }
        }
      }
    }
  }
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.FNO == null) {}
    while (this.FNO.enable == paramBoolean) {
      return;
    }
    this.FNO.enable = paramBoolean;
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
      this.rfb.removeCallbacks(this.FOo);
      this.rfb.removeCallbacks(this.FOn);
      this.rfb.postDelayed(this.FOn, 256L);
      return;
    }
    this.FNL.getWindow().clearFlags(1024);
    this.rfb.removeCallbacks(this.FOn);
    this.rfb.removeCallbacks(this.FOo);
    this.rfb.postDelayed(this.FOo, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.rfb.removeCallbacks(this.FOo);
      this.rfb.removeCallbacks(this.FOn);
      this.rfb.postDelayed(this.FOn, paramLong);
      return;
    }
    this.FNL.getWindow().clearFlags(1024);
    this.rfb.removeCallbacks(this.FOn);
    this.rfb.removeCallbacks(this.FOo);
    this.rfb.postDelayed(this.FOo, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.FNL.getWindow().setFlags(1024, 1024);
      return;
    }
    this.FNL.getWindow().clearFlags(1024);
  }
  
  protected abstract String getClassName();
  
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
    if (this.FNA != null) {
      return this.FNA;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.hCo.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.hCo.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.FNL.getSupportActionBar();
  }
  
  public final int getTitleLocation()
  {
    if (this.mActionBar == null) {
      return 0;
    }
    return this.mActionBar.getHeight();
  }
  
  public final void hideActionbarLine()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().setElevation(0.0F);
    }
  }
  
  public final void hideAllManagedDialogs()
  {
    if (this.FNQ != null)
    {
      int j = this.FNQ.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.FNQ.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.FNQ.clear();
      this.FNQ = null;
    }
  }
  
  public final void hideTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      ad.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    View localView = this.FNL.getCurrentFocus();
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
        ad.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
  
  public boolean interceptSupportInvalidateOptionsMenu()
  {
    return false;
  }
  
  public final boolean isTitleShowing()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      ad.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return false;
      bool = false;
    }
    return this.mActionBar.isShowing();
  }
  
  public final void jo(Context paramContext)
  {
    com.tencent.mm.sdk.b.a.ESL.d(this.FOe);
    hideAllManagedDialogs();
    com.tencent.mm.sdk.f.a.gi(paramContext);
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
    ad.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.FGV.size()) });
    if ((this.mActionBar == null) || (this.FGV.size() == 0))
    {
      ad.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.FGV.size()) });
      return false;
    }
    this.FOl = null;
    this.FOm = null;
    Object localObject1;
    if (this.mActionBar.getHeight() == 0)
    {
      localObject1 = this.mContext.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label184;
      }
      this.mContext.getResources().getDimensionPixelSize(2131165251);
    }
    final a locala;
    for (;;)
    {
      localObject1 = this.FGV.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1701;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.FHe != 16908332) {
          break;
        }
        ad.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label184:
      this.mContext.getResources().getDimensionPixelSize(2131165252);
    }
    if (locala.FHe == 2131302248)
    {
      boolean bool2 = this.FNN;
      if (this.fvI == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!this.FNN) || (this.fvI == null)) {
          break;
        }
        this.fvI.a(this.FNL, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.FHe, 0, locala.text);
    com.tencent.mm.compatible.g.a.a(localMenuItem, getClass().getName());
    View.OnClickListener local20 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141350);
        r.a(r.this, localMenuItem, locala);
        AppMethodBeat.o(141350);
      }
    };
    View.OnLongClickListener local2 = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141330);
        boolean bool = r.a(r.this, paramAnonymousView, locala);
        AppMethodBeat.o(141330);
        return bool;
      }
    };
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141331);
        boolean bool = r.a(r.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
        AppMethodBeat.o(141331);
        return bool;
      }
    };
    if ((locala.FHf != 0) || (locala.FOx != null))
    {
      if (locala.FHh == null) {
        locala.FHh = View.inflate(this.mContext, 2131492920, null);
      }
      localObject2 = (ImageView)locala.FHh.findViewById(2131299154);
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      this.FGJ = ((WeImageView)locala.FHh.findViewById(2131296376));
      this.FGJ.setVisibility(0);
      label473:
      PorterDuff.Mode localMode;
      if (locala.FOx != null)
      {
        this.FGJ.setImageDrawable(locala.FOx);
        if (this.FNV == 0) {
          break label736;
        }
        localObject2 = this.FGJ;
        int i = this.FNV;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, i);
        label503:
        this.FGJ.setOnClickListener(local20);
        this.FGJ.setEnabled(locala.enable);
        this.FGJ.setContentDescription(locala.text);
        if (locala.qhH != null) {
          this.FGJ.setOnLongClickListener(local2);
        }
        this.FNW = ((ImageView)locala.FHh.findViewById(2131299183));
        if (this.FNW != null)
        {
          if (!locala.FOz) {
            break label795;
          }
          this.FNW.setVisibility(0);
        }
      }
      for (;;)
      {
        localMenuItem.setActionView(locala.FHh);
        localMenuItem.setEnabled(locala.enable);
        localMenuItem.setVisible(locala.visible);
        localMenuItem.setShowAsAction(2);
        if (locala.FHf == 2131233291)
        {
          this.FOl = locala;
          this.FOm = localMenuItem;
        }
        ad.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.FHe), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
        break;
        this.FGJ.setImageResource(locala.FHf);
        break label473;
        label736:
        if (locala.FOw != 0) {
          break label503;
        }
        if (this.FGS)
        {
          localObject2 = this.FGJ;
          localMode = PorterDuff.Mode.SRC_ATOP;
          a((WeImageView)localObject2, -1);
          break label503;
        }
        localObject2 = this.FGJ;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, -16777216);
        break label503;
        label795:
        this.FNW.setVisibility(8);
      }
    }
    if (locala.FHg == null) {
      locala.FHg = View.inflate(this.mContext, 2131492920, null);
    }
    this.FGL = ((TextView)locala.FHg.findViewById(2131296377));
    this.FGL.setVisibility(0);
    this.pSX = ((Button)locala.FHg.findViewById(2131296374));
    this.pSX.setVisibility(8);
    this.FOa = locala.FHg.findViewById(2131296600);
    this.FOa.setVisibility(8);
    if ((locala.FOy == b.FOC) || (locala.FOy == b.FOF))
    {
      this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131100801));
      this.pSX.setVisibility(0);
      this.pSX.setBackgroundResource(2131231371);
      this.FGL.setVisibility(8);
    }
    for (;;)
    {
      this.FGL.setText(locala.text);
      if (locala.textColor != 0) {
        this.FGL.setTextColor(locala.textColor);
      }
      this.FGL.setOnClickListener(local20);
      this.FGL.setOnLongClickListener(local2);
      this.FGL.setEnabled(locala.enable);
      this.FGL.setOnTouchListener((View.OnTouchListener)localObject2);
      this.pSX.setText(locala.text);
      this.pSX.setOnClickListener(local20);
      this.pSX.setOnLongClickListener(local2);
      this.pSX.setOnTouchListener((View.OnTouchListener)localObject2);
      this.pSX.setEnabled(locala.enable);
      localMenuItem.setActionView(locala.FHg);
      break;
      if (locala.FOy == b.FOG)
      {
        this.pSX.setVisibility(0);
        this.pSX.setBackgroundResource(2131231372);
        this.pSX.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131101180));
        this.FGL.setVisibility(8);
      }
      else if (locala.FOy == b.FOB)
      {
        this.pSX.setVisibility(0);
        this.pSX.setBackgroundResource(2131231366);
        this.pSX.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131100161));
        this.FGL.setVisibility(8);
      }
      else
      {
        if (locala.FOy != b.FOD)
        {
          if (locala.FOy == b.FOI)
          {
            this.FGL.setTextColor(this.FNL.getResources().getColor(2131100585));
            continue;
          }
          if (locala.FOy == b.FOH)
          {
            this.FGL.setTextColor(this.FNL.getResources().getColor(2131100800));
            continue;
          }
          if (locala.FOy == b.FOL)
          {
            this.pSX.setVisibility(0);
            this.pSX.setBackgroundResource(2131231376);
            this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131100161));
            this.FGL.setVisibility(8);
            continue;
          }
          if (b.FON == locala.FOy)
          {
            ad.i("MicroMsg.MMActivityController", "dark green mode.");
            this.pSX.setVisibility(0);
            this.pSX.setBackgroundResource(2131231363);
            this.pSX.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131100397));
            this.FGL.setVisibility(8);
            continue;
          }
          if (locala.FOy == b.FOM)
          {
            this.pSX.setVisibility(0);
            this.pSX.setBackgroundResource(2131231369);
            this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131100161));
            this.FGL.setVisibility(8);
            continue;
          }
          if (b.FOO == locala.FOy)
          {
            ad.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.FNM) });
            this.FGL.setVisibility(8);
            if (this.FNM)
            {
              this.FOa.setVisibility(0);
              this.FOa.setOnClickListener(local20);
              continue;
            }
            if (8 == this.FOa.getVisibility()) {
              this.FOa.setVisibility(4);
            }
            for (;;)
            {
              this.FOa.setOnClickListener(null);
              break;
              if (this.FOa.getVisibility() == 0) {
                this.FOa.animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(141332);
                    r.i(r.this).setVisibility(4);
                    AppMethodBeat.o(141332);
                  }
                });
              }
            }
          }
          if (this.FNV != 0)
          {
            this.FGL.setTextColor(this.FNV);
            continue;
          }
          if (this.FGS)
          {
            this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131101185));
            continue;
          }
        }
        this.FGL.setTextColor(com.tencent.mm.cd.a.m(this.FNL, 2131100024));
      }
    }
    label1701:
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.Wl();
    com.tencent.mm.compatible.b.g.Wl();
    if ((this.FNN) && (this.fvI != null) && (this.fvI.onKeyDown(paramInt, paramKeyEvent)))
    {
      ad.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.FGS) {
        setActionbarColor(this.FNL.getResources().getColor(2131100196));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.FNL.getResources().getColor(2131100705));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.FOl != null) && (this.FOl.enable)) {
        a(this.FOm, this.FOl);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ad.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.FNz)
    {
      ad.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.FNO.FHe) && (this.FNO.enable))
    {
      a(paramMenuItem, this.FNO);
      return true;
    }
    Iterator localIterator = this.FGV.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.FHe)
      {
        ad.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        return true;
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    activateBroadcast(false);
    com.tencent.mm.sdk.b.a.ESL.d(this.FOe);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ad.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.FNN) && (this.fvI != null)) {
      this.fvI.a(this.FNL, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    com.tencent.mm.sdk.b.a.ESL.c(this.FOe);
    Object localObject = new com.tencent.mm.g.a.ao();
    ((com.tencent.mm.g.a.ao)localObject).dcv.type = 2;
    ((com.tencent.mm.g.a.ao)localObject).dcv.position = this.FOc;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    String str;
    int i;
    if (((com.tencent.mm.g.a.ao)localObject).dcw.dcA == 2)
    {
      l = System.currentTimeMillis();
      str = ((com.tencent.mm.g.a.ao)localObject).dcw.dcC;
      i = ((com.tencent.mm.g.a.ao)localObject).dcw.position;
      ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.FOc)) {
        break label432;
      }
      ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.FOc) });
    }
    for (;;)
    {
      ad.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn) && (!aj.getContext().getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cd.a.dT(aj.getContext())) {
          break;
        }
        if (1.0F != aj.getContext().getResources().getConfiguration().fontScale)
        {
          h.vKh.f(15181, new Object[] { Integer.valueOf(1) });
          localObject = new f.a(aj.getContext());
          ((f.a)localObject).au(this.FNL.getResources().getString(2131759585)).aMo(this.FNL.getResources().getString(2131759582)).aMs(this.FNL.getResources().getString(2131759584)).aMt(this.FNL.getResources().getString(2131759583));
          ((f.a)localObject).c(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(141349);
              if (paramAnonymousBoolean)
              {
                h.vKh.f(15181, new Object[] { Integer.valueOf(3) });
                Object localObject = new Intent();
                ((Intent)localObject).setClassName(aj.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                ((Intent)localObject).addFlags(268435456);
                paramAnonymousString = aj.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(141349);
                return;
              }
              h.vKh.f(15181, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(141349);
            }
          }).show();
          aj.getContext().getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label432:
      a(((com.tencent.mm.g.a.ao)localObject).dcw.dcB, ((com.tencent.mm.g.a.ao)localObject).dcw.visible, ((com.tencent.mm.g.a.ao)localObject).dcw.url, ((com.tencent.mm.g.a.ao)localObject).dcw.desc, str, i, true);
    }
    aj.getContext().getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
  }
  
  public final void onStart()
  {
    this.landscapeMode = this.mContext.getSharedPreferences(aj.eFD(), 0).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      this.FNL.setRequestedOrientation(-1);
      return;
    }
    this.FNL.setRequestedOrientation(1);
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
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.XM())) {}
    for (;;)
    {
      if (((paramActivity instanceof MMActivity)) && (((MMActivity)paramActivity).fixStatusbar) && (((MMActivity)paramActivity).isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.statusbar.a.e(this.contentView, paramInt, d.e(paramActivity.getWindow()));
      }
      for (;;)
      {
        setNavigationbarColor(ao.aD(this.FNL, 2130968578));
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label117;
        }
        paramInt = am.o(paramActivity.getResources().getColor(2131100954), paramInt);
        break;
        paramActivity.getWindow().setStatusBarColor(paramInt);
      }
      label117:
      paramInt = 0;
    }
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.FGV.isEmpty()) {
      return;
    }
    this.FGV.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.FGV.size())
      {
        if (((a)this.FGV.get(i)).FHe == paramInt)
        {
          ad.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.FGV.remove(i);
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
    this.FGI = paramInt;
    this.FGS = am.XC(this.FGI);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.FGI));
    q(this.FNL, this.FGI);
    eQZ();
    eQY();
  }
  
  public final void setBackBtn(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null) {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (this.FNT.getDrawable() == null) {
          i = 2131689490;
        }
      }
      if ((this.FNT != null) && (i != 0)) {
        this.FNT.setImageResource(i);
      }
      this.FNO.FHe = 16908332;
      this.FNO.ioW = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.FNS != null) {
        this.FNS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(141338);
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141337);
                r.9.this.FGX.onMenuItemClick(null);
                AppMethodBeat.o(141337);
              }
            });
            AppMethodBeat.o(141338);
          }
        });
      }
    }
  }
  
  public final void setBackBtnColorFilter(int paramInt)
  {
    if (this.FNT != null) {
      this.FNT.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.FNT == null) {
      return;
    }
    if (paramBoolean)
    {
      this.FNT.setVisibility(0);
      return;
    }
    this.FNT.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.FNy == null) {
      this.FNy = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    this.FNy.setBackgroundResource(paramInt);
    this.FNv.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.FNy == null) {
      this.FNy = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.FNw != null) {
      this.FNy.removeView(this.FNw);
    }
    this.FNy.removeView(this.FNv);
    this.FNv = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.FNy.addView(this.FNv, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.FNw != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.b.g(this.mContext, 47.0F));
      this.FNy.addView(this.FNw, this.FNy.getChildCount(), localLayoutParams);
    }
    this.FNy.invalidate();
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.FNS != null)
    {
      this.FNS.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.FNS.setEnabled(false);
    }
    for (;;)
    {
      if (this.FGJ != null)
      {
        this.FGJ.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.FGJ.setEnabled(false);
      }
      return;
      label59:
      this.FNS.setEnabled(true);
    }
    this.FGJ.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      aX(this.FNL);
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
        this.mActionBar.setCustomView(FOg);
        localTextView = (TextView)this.mActionBar.getCustomView().findViewById(2131296348);
      } while (localTextView == null);
      localTextView.clearAnimation();
      if (paramAnimation != null) {
        localTextView.startAnimation(paramAnimation);
      }
    } while (bt.isNullOrNil(paramString));
    localTextView.setText(paramString);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.lZH.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cd.a.hS(this.FNL))
    {
      this.lZH.setTextSize(1, 14.0F);
      this.FNR.setTextSize(1, 18.0F);
    }
    this.lZH.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.lZH.setVisibility(8);
      return;
    }
    this.lZH.setText(paramString);
    if (com.tencent.mm.cd.a.hS(this.FNL))
    {
      this.lZH.setTextSize(1, 14.0F);
      this.FNR.setTextSize(1, 18.0F);
    }
    this.lZH.setVisibility(0);
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
    this.FNA = paramCharSequence.toString();
    this.FNR.setText(paramCharSequence);
    if (com.tencent.mm.cd.a.hS(this.FNL)) {
      this.FNR.setTextSize(0, com.tencent.mm.cd.a.ap(this.FNL, 2131165184) * com.tencent.mm.cd.a.hQ(this.FNL));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.FNA = paramString;
    if (com.tencent.mm.cd.a.hS(this.FNL)) {
      this.FNR.setTextSize(0, com.tencent.mm.cd.a.ap(this.FNL, 2131165184) * com.tencent.mm.cd.a.hQ(this.FNL));
    }
    eQX();
    updateDescription(paramString);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.FNR.setVisibility(paramInt);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!eRa()))
    {
      this.FNL.getWindow().setNavigationBarColor(paramInt);
      boolean bool = am.XC(paramInt);
      localView = this.FNL.getWindow().getDecorView();
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
    this.FNz = paramBoolean;
    if ((this.FNu == null) && (this.contentView != null)) {
      this.FNu = this.contentView.findViewById(2131302342);
    }
    if (this.FNu == null)
    {
      ad.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.FNu;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.FNu;
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
      jn(this.FNL);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    q(this.FNL, paramInt);
    updataStatusBarIcon(am.XC(paramInt));
  }
  
  public final void setTitleBarDoubleClickListener(final Runnable paramRunnable)
  {
    if ((this.mActionBar == null) || (paramRunnable == null)) {
      return;
    }
    this.mActionBar.getCustomView().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141335);
        if (SystemClock.elapsedRealtime() - r.l(r.this) < 300L) {
          paramRunnable.run();
        }
        r.a(r.this, SystemClock.elapsedRealtime());
        AppMethodBeat.o(141335);
      }
    });
  }
  
  public final void setTitleLogo(int paramInt1, int paramInt2)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.FNB = 0;
      this.FND = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.FNC = 0;
      this.FNE = null;
    }
    for (;;)
    {
      eQX();
      return;
      if (this.FNB == paramInt1) {
        break;
      }
      this.FNB = paramInt1;
      this.FND = jc(this.mContext.getResources().getDimensionPixelSize(2131165192), this.FNB);
      break;
      label82:
      if (this.FNC != paramInt2)
      {
        this.FNC = paramInt2;
        this.FNE = jc(this.mContext.getResources().getDimensionPixelSize(2131165192), this.FNC);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.FNI = bool;
      eQX();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.FNK = bool;
      eQX();
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
      q(this.FNL, this.FGI);
      return;
    }
    this.mActionBar.hide();
    q(this.FNL, this.FNL.getResources().getColor(2131100017));
  }
  
  public final void showActionbarLine()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().setElevation(1.0F);
    }
  }
  
  public final void showHomeBtn(boolean paramBoolean)
  {
    if (this.mActionBar == null) {}
    do
    {
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
    } while (this.FNS == null);
    View localView = this.FNS;
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
      ad.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    this.FNL.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.FNL.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      ad.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", new Object[] { Boolean.valueOf(paramBoolean) });
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
    while ((this.FNT == null) || (paramDrawable == null)) {
      return;
    }
    this.FNT.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.eSf().l(this.FNL, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = Xl(paramInt1);
    if ((locala != null) && (locala.FHf != paramInt2))
    {
      locala.FHf = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = Xl(paramInt);
    if (locala != null)
    {
      locala.ioW = paramOnMenuItemClickListener;
      locala.qhH = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = Xl(paramInt);
    if ((locala != null) && (locala.FOz != paramBoolean))
    {
      locala.FOz = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = Xl(paramInt);
    if ((locala != null) && (!bt.by(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void vx(boolean paramBoolean)
  {
    this.FGS = paramBoolean;
    eQZ();
    eQY();
  }
  
  public static final class a
  {
    public int FHe = -1;
    public int FHf;
    public View FHg;
    public View FHh;
    public int FOw = 0;
    public Drawable FOx;
    public r.b FOy = r.b.FOA;
    public boolean FOz = false;
    public boolean enable = true;
    public MenuItem.OnMenuItemClickListener ioW;
    public View.OnLongClickListener qhH;
    public View.OnTouchListener rFq;
    public String text;
    public int textColor;
    public boolean visible = true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      FOA = new b("NORMAL", 0);
      FOB = new b("GREEN", 1);
      FOC = new b("RED", 2);
      FOD = new b("BLACK", 3);
      FOE = new b("TRANSPARENT", 4);
      FOF = new b("TRANSPARENT_RED_TEXT", 5);
      FOG = new b("TRANSPARENT_GREEN_TEXT", 6);
      FOH = new b("GOLDEN", 7);
      FOI = new b("TRANSPARENT_GOLD_TEXT", 8);
      FOJ = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      FOK = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      FOL = new b("YELLOW", 11);
      FOM = new b("ORANGE", 12);
      FON = new b("DARK_GREEN_MODE", 13);
      FOO = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      FOP = new b[] { FOA, FOB, FOC, FOD, FOE, FOF, FOG, FOH, FOI, FOJ, FOK, FOL, FOM, FON, FOO };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */