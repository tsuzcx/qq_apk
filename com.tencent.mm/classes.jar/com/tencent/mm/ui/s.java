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
import com.tencent.mm.g.a.ap.b;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class s
{
  private static byte[] JbB = { 0 };
  private static boolean Jbg = false;
  private static final int Jbx = 2131492928;
  public static long Jbz;
  private static PowerManager.WakeLock wakeLock = null;
  private final long Ake = 300L;
  private long Akf = SystemClock.elapsedRealtime();
  public View BKn;
  private int DPG = 0;
  View ITf;
  WeImageView ITh;
  TextView ITj;
  private boolean ITq = false;
  int ITr;
  private int ITs;
  LinkedList<a> ITt = new LinkedList();
  private View JaM;
  private View JaN;
  private TextView JaO;
  private FrameLayout JaP;
  public boolean JaQ = true;
  private String JaR = " ";
  private int JaS = 0;
  private int JaT = 0;
  private com.tencent.mm.ui.widget.a JaU = null;
  private com.tencent.mm.ui.widget.a JaV = null;
  private com.tencent.mm.ui.widget.a JaW = null;
  private com.tencent.mm.ui.widget.a JaX = null;
  private com.tencent.mm.ui.widget.a JaY = null;
  private boolean JaZ = false;
  int JbA = 0;
  private a JbC;
  private MenuItem JbD;
  private Runnable JbE = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141333);
      s.j(s.this).getWindow().setFlags(1024, 1024);
      if (s.k(s.this) != null) {
        s.k(s.this).hide();
      }
      AppMethodBeat.o(141333);
    }
  };
  private Runnable JbF = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141334);
      if (s.k(s.this) != null) {
        s.k(s.this).show();
      }
      AppMethodBeat.o(141334);
    }
  };
  boolean Jba = false;
  private boolean Jbb = false;
  public AppCompatActivity Jbc;
  boolean Jbd = false;
  private boolean Jbe;
  private a Jbf = new a();
  ArrayList<Dialog> Jbh;
  public TextView Jbi;
  View Jbj;
  WeImageView Jbk;
  ProgressBar Jbl;
  int Jbm = 0;
  private ImageView Jbn;
  private ViewGroup.LayoutParams Jbo;
  View Jbp;
  AlbumChooserView Jbq;
  private View Jbr;
  public boolean Jbs = true;
  private int Jbt = 0;
  private boolean Jbu = false;
  private c Jbv = new c() {};
  private int Jbw = 2131492926;
  private int Jby = -1;
  private View actionbarView;
  int bIc = this.ITr;
  String className;
  View contentView;
  private r fSC;
  private boolean isDarkMode = false;
  private AudioManager iwl;
  private LayoutInflater jfG;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  TextView nci;
  private Button rlu;
  public int statusBarColor = -1;
  protected com.tencent.mm.sdk.platformtools.ap tkw = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper());
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.ITq) {
      localDrawable = ao.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, aq.ay(this.Jbc, 2131165289), aq.ay(this.Jbc, 2131165289));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable);
    paramDrawable.KQg = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.ITC = paramInt1;
    locala.ITD = paramInt2;
    locala.text = paramString;
    locala.jil = paramOnMenuItemClickListener;
    locala.rAj = paramOnLongClickListener;
    locala.JbP = paramb;
    locala.JbQ = paramBoolean;
    if ((locala.ITD == 2131233291) && (bt.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(2131755815);
    }
    abG(locala.ITC);
    this.ITt.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.ITC = paramInt;
    locala.JbO = paramDrawable;
    locala.text = paramString;
    locala.jil = paramOnMenuItemClickListener;
    locala.rAj = null;
    locala.JbP = paramb;
    abG(locala.ITC);
    this.ITt.add(locala);
    new com.tencent.mm.sdk.platformtools.ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141339);
        s.this.supportInvalidateOptionsMenu();
        AppMethodBeat.o(141339);
      }
    }, 200L);
  }
  
  private void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, boolean paramBoolean2)
  {
    ad.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.JaN });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.JaN == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      ad.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.JaP == null) {
      this.JaP = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.JaN != null) {
      this.JaP.removeView(this.JaN);
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.JaN = this.jfG.inflate(paramInt1, null);
      this.JaO = ((TextView)this.JaN.findViewById(2131302969));
      this.JaN.findViewById(2131302964).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new com.tencent.mm.g.a.ap();
          paramAnonymousView.dll.type = 1;
          paramAnonymousView.dll.dln = paramString3;
          paramAnonymousView.dll.position = paramInt2;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
          s.b(s.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141341);
        }
      });
      this.JaN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141343);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (paramString1 != null)
          {
            localObject = new Intent("android.intent.action.VIEW");
            ((Intent)localObject).setData(Uri.parse(paramString1));
            paramAnonymousView = s.c(s.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141343);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.Jbu) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.g(this.Jbc, 48.0F), 0, 0);
        ad.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.JaP.addView(this.JaN, this.JaP.getChildCount(), paramString3);
      if (this.JaN == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.JaN;
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
          this.JaO.setText(paramString1);
        }
        for (;;)
        {
          this.JaN.invalidate();
          this.JaP.invalidate();
          return;
          paramInt1 = 8;
          break;
          label488:
          ad.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.JaO.setText(paramString3);
        }
      }
      this.JaN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141344);
          Object localObject = s.b(s.this);
          int i;
          if (paramBoolean1)
          {
            i = 0;
            ((View)localObject).setVisibility(i);
            String str = s.c(s.this).getString(2131760318);
            if (!bt.isNullOrNil(paramString2)) {
              break label170;
            }
            localObject = s.c(s.this).getString(2131758083);
            label63:
            if (paramString1 == null) {
              break label178;
            }
            SpannableString localSpannableString = new SpannableString((String)localObject + str);
            localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
            s.d(s.this).setText(localSpannableString);
          }
          for (;;)
          {
            s.b(s.this).invalidate();
            s.e(s.this).invalidate();
            AppMethodBeat.o(141344);
            return;
            i = 8;
            break;
            label170:
            localObject = paramString2;
            break label63;
            label178:
            ad.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
            s.d(s.this).setText((CharSequence)localObject);
          }
        }
      });
      return;
      paramInt1 = 2131494915;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.JaQ) {
      ad.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.jil == null) {
      return;
    }
    parama.jil.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.Jbs)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.clearColorFilter();
  }
  
  private static boolean aVr(String paramString)
  {
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {}
    while ((!mj(str1, paramString)) && (!mj(str2, paramString))) {
      return false;
    }
    return true;
  }
  
  private static boolean aY(Activity paramActivity)
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
  
  private static boolean aZ(Activity paramActivity)
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
  
  private void b(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.Jbs)
    {
      paramDrawable.setColorFilter(paramInt, paramMode);
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  private static boolean ba(Activity paramActivity)
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
  
  private void bb(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      ad.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.DPG == 0) {
        this.DPG = fwQ();
      }
      this.ITq = ao.abX(this.DPG);
      setActionbarColor(this.DPG);
      this.mActionBar.setLogo(new ColorDrawable(this.Jbc.getResources().getColor(17170445)));
      this.mActionBar.gm();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.gl();
      this.mActionBar.gn();
      this.mActionBar.gk();
      if (this.Jby != -1) {
        break label370;
      }
      localView = z.jO(this.Jbc).inflate(this.Jbw, new LinearLayout(this.Jbc), false);
      this.mActionBar.setCustomView(localView);
      this.Jbi = ((TextView)findViewById(16908308));
      this.nci = ((TextView)findViewById(16908309));
      this.ITf = findViewById(2131305937);
      this.Jbl = ((ProgressBar)findViewById(2131303518));
      this.Jbj = findViewById(2131296416);
      this.Jbk = ((WeImageView)findViewById(2131296417));
      this.Jbj.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(141348);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            s.Jbz = System.currentTimeMillis();
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/MMActivityController$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(141348);
          return false;
        }
      });
      if (this.Jbk != null) {
        this.Jbk.setContentDescription(this.Jbc.getString(2131755281));
      }
      if (this.Jbi != null) {
        this.Jbi.setText(2131755822);
      }
      this.Jbp = findViewById(2131296408);
      this.Jbq = ((AlbumChooserView)findViewById(2131296394));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label408;
      }
      if (this.Jbk != null) {
        this.Jbk.setVisibility(0);
      }
      if (this.Jbj != null) {
        this.Jbj.setVisibility(0);
      }
    }
    for (;;)
    {
      fwT();
      return;
      label370:
      localView = z.jO(this.Jbc).inflate(this.Jby, new LinearLayout(this.Jbc), false);
      this.mActionBar.setCustomView(localView);
      break;
      label408:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.Jbk != null) {
          this.Jbk.setVisibility(0);
        }
        if (this.Jbj != null) {
          this.Jbj.setVisibility(0);
        }
        if (this.Jbi != null)
        {
          this.Jbi.setVisibility(0);
          al.a(this.Jbi.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.Jbk != null) {
          this.Jbk.setVisibility(8);
        }
        if (this.Jbj != null) {
          this.Jbj.setVisibility(8);
        }
      }
    }
  }
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.Jbc.findViewById(paramInt);
  }
  
  public static boolean fwR()
  {
    for (;;)
    {
      synchronized (JbB)
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
  
  private void fwT()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.ITq)
    {
      if (this.Jbk != null)
      {
        localWeImageView = this.Jbk;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.Jbi != null) && (this.Jbi.getVisibility() == 0)) {
        this.Jbi.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.nci != null) && (this.nci.getVisibility() == 0)) {
        this.nci.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.ITh != null) && (this.ITh.getVisibility() == 0)) {
        if (this.ITh.getDrawable() != null) {
          b(this.ITh.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.ITh;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.ITj == null) || (this.ITj.getVisibility() != 0));
      this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131101185));
      return;
      if (this.Jbk != null)
      {
        localWeImageView = this.Jbk;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
      }
      if ((this.Jbi != null) && (this.Jbi.getVisibility() == 0)) {
        this.Jbi.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.nci != null) && (this.nci.getVisibility() == 0)) {
        this.nci.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.ITh != null) && (this.ITh.getVisibility() == 0))
      {
        if (this.ITh.getDrawable() != null)
        {
          b(this.ITh.getDrawable(), -16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        localWeImageView = this.ITh;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
        return;
      }
    } while ((this.ITj == null) || (this.ITj.getVisibility() != 0));
    this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131100024));
  }
  
  private void fwU()
  {
    updataStatusBarIcon(this.ITq);
  }
  
  private static boolean fwV()
  {
    return (aVr("y83a")) || (aVr("y83")) || (aVr("v1732a")) || (aVr("v1732t"));
  }
  
  public static boolean fwW()
  {
    return fwV();
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return initLanguage(paramContext, ac.f(paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC(), 0)));
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      ac.a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = ac.aQq(paramString);
    ac.a(paramContext, paramString);
    return paramString;
  }
  
  private com.tencent.mm.ui.widget.a jB(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.ITq) {
      localDrawable = ao.k(this.Jbc, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.KQg = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private void jJ(Context paramContext)
  {
    synchronized (JbB)
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
  
  private static boolean mj(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return bt.lQ(paramString1.toLowerCase(), paramString2.toLowerCase());
  }
  
  private void releaseWakeLock()
  {
    synchronized (JbB)
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
    Jbg = true;
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
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.Jbc = paramAppCompatActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = this.Jbc.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      this.Jbc.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    if (!noActionBar())
    {
      boolean bool = com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
      com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (!bool)
      {
        com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
        com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
      }
    }
    this.isDarkMode = al.j(paramAppCompatActivity.getResources());
    int i;
    label448:
    label582:
    label736:
    long l;
    if (paramAppCompatActivity != null)
    {
      if (!this.isDarkMode) {
        break label1026;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && ((aY(paramAppCompatActivity)) || (((MMActivity)paramAppCompatActivity).transparentTheme))) {
        paramAppCompatActivity.setTheme(2131820572);
      }
    }
    else
    {
      onCreateBeforeSetContentView();
      this.className = getClass().getName();
      aj.cQ(3, this.className);
      initLanguage(paramContext);
      this.iwl = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.jfG = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.a.b.akC();
        this.contentView = com.tencent.mm.kiss.a.b.c(paramAppCompatActivity, 2131494760);
      }
      this.JaM = this.contentView.findViewById(2131302342);
      this.JaP = ((FrameLayout)this.contentView.findViewById(2131302320));
      if (i != -1)
      {
        this.BKn = getLayoutView();
        if (this.BKn != null) {
          break label1118;
        }
        this.BKn = this.jfG.inflate(getLayoutId(), null);
        this.JaP.addView(this.BKn, 0);
      }
      dealContentView(this.contentView);
      if (fromFullScreenActivity())
      {
        al.n(al.a(this.Jbc.getWindow(), this.BKn), this.BKn);
        ((ViewGroup)this.BKn.getParent()).removeView(this.BKn);
        ((ViewGroup)this.Jbc.getWindow().getDecorView()).addView(this.BKn, 0);
        int j = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label1148;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165251);
        this.BKn.setPadding(this.BKn.getPaddingLeft(), i + (j + this.BKn.getPaddingTop()), this.BKn.getPaddingRight(), this.BKn.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      ad.d("MicroMsg.MMActivityController", "onCreate, before.");
      bb(paramAppCompatActivity);
      if (!noActionBar())
      {
        this.ITr = aq.ay(this.mContext, 2131165252);
        this.ITs = aq.ay(this.mContext, 2131165559);
      }
      if (this.JaP != null) {
        this.JaP.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(141345);
            s.e(s.this).removeOnAttachStateChangeListener(this);
            com.tencent.mm.kiss.a.b.akD();
            AppMethodBeat.o(141345);
          }
        });
      }
      if ((this.JaP == null) || (!(this.JaP instanceof LayoutListenerView))) {
        break label1165;
      }
      ((LayoutListenerView)this.JaP).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int JbM;
        
        public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(141347);
          if (s.f(s.this))
          {
            AppMethodBeat.o(141347);
            return;
          }
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
          {
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.JbM))
            {
              s.g(s.this);
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.JbM)) {
              s.h(s.this);
            }
          }
          AppMethodBeat.o(141347);
        }
      });
      paramContext = new com.tencent.mm.g.a.ap();
      paramContext.dll.type = 2;
      paramContext.dll.position = this.Jbt;
      com.tencent.mm.sdk.b.a.IbL.l(paramContext);
      if (paramContext.dlm.dlq == 2)
      {
        l = System.currentTimeMillis();
        localObject = paramContext.dlm.dls;
        i = paramContext.dlm.position;
        ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject, bt.flS() });
        if ((i <= 0) || (i == this.Jbt)) {
          break label1177;
        }
        ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Jbt) });
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
      {
        if (this.DPG == 0) {
          this.DPG = fwQ();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        q(paramAppCompatActivity, this.DPG);
        fwU();
      }
      return;
      if (((paramAppCompatActivity instanceof MMActivity)) && (ba(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820571);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (aZ(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820570);
        break;
      }
      paramAppCompatActivity.setTheme(2131820569);
      break;
      label1026:
      if (((paramAppCompatActivity instanceof MMActivity)) && ((((MMActivity)paramAppCompatActivity).transparentTheme) || (aY(paramAppCompatActivity))))
      {
        paramAppCompatActivity.setTheme(2131820577);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (ba(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820576);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (aZ(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820575);
        break;
      }
      paramAppCompatActivity.setTheme(2131820574);
      break;
      label1118:
      if (this.BKn.getParent() == null) {
        break label448;
      }
      ((ViewGroup)this.BKn.getParent()).removeView(this.BKn);
      break label448;
      label1148:
      i = this.mContext.getResources().getDimensionPixelSize(2131165252);
      break label582;
      label1165:
      ad.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label736;
      label1177:
      a(paramContext.dlm.dlr, paramContext.dlm.visible, paramContext.dlm.url, paramContext.dlm.desc, (String)localObject, i, true);
    }
  }
  
  public final void a(a parama)
  {
    abG(parama.ITC);
    this.ITt.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  final boolean abG(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.ITt.size())
      {
        if (((a)this.ITt.get(i)).ITC == paramInt)
        {
          ad.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.ITt.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a abH(int paramInt)
  {
    Iterator localIterator = this.ITt.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.ITC == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void abI(int paramInt)
  {
    if (noActionBar()) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > this.ITr) {
        i = this.ITr;
      }
      paramInt = i;
      if (i < this.ITs) {
        paramInt = this.ITs;
      }
      this.bIc = paramInt;
      this.actionbarView = this.Jbc.getWindow().getDecorView().findViewById(2131296345);
      if (this.actionbarView != null) {
        this.Jbo = this.actionbarView.getLayoutParams();
      }
      if ((this.actionbarView != null) && (this.Jbo != null))
      {
        this.Jbo.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
        this.actionbarView.setLayoutParams(this.Jbo);
      }
      float f1 = Math.min(com.tencent.mm.cc.a.eb(this.Jbc), com.tencent.mm.cc.a.ik(this.Jbc));
      i = (int)(aq.ay(this.mContext, 2131165570) * f1);
      int j = (int)(f1 * aq.ay(this.mContext, 2131165518));
      int k = aq.fromDPToPix(this.mContext, 14);
      f1 = (paramInt - this.ITs) / (this.ITr - this.ITs);
      float f2 = i;
      float f3 = j - i;
      setIconAlpha(f1);
      paramInt = (int)((k - aq.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
      i = (int)((this.ITs - this.ITr) / 2.0F * (1.0F - f1));
      if (this.Jbi != null)
      {
        this.Jbi.setTextSize(0, f3 * f1 + f2);
        if (this.ITf != null)
        {
          this.ITf.setTranslationX(paramInt);
          this.ITf.setTranslationY(i);
        }
      }
      if (this.Jbk != null) {
        this.Jbk.setTranslationY(i);
      }
    } while (this.ITh == null);
    this.ITh.setTranslationY(i);
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    if ((!Jbg) && (paramBoolean))
    {
      y.d(paramBoolean, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
      return;
    }
    y.d(paramBoolean, new Intent().putExtra("classname", getClassName() + getIdentString()));
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.Jbh == null) {
      this.Jbh = new ArrayList();
    }
    this.Jbh.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.JbR);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.JbR);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.JbR);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.JbR);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.JbR);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.JbR);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.JbR);
  }
  
  public final void addSearchMenu(boolean paramBoolean, r paramr)
  {
    ad.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.ITC = 2131302248;
    locala.text = this.mContext.getString(2131755882);
    locala.ITD = 2131689494;
    locala.jil = null;
    locala.rAj = null;
    removeOptionMenu(locala.ITC);
    this.ITt.add(0, locala);
    this.Jbe = paramBoolean;
    this.fSC = paramr;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.JbR);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.JbR);
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
      localIterator = this.ITt.iterator();
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
      localIterator = this.ITt.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.ITC != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fSC == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fSC.KKL)
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
  
  public final void be(int paramInt, boolean paramBoolean)
  {
    this.Jbt = paramInt;
    this.Jbu = paramBoolean;
  }
  
  final void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.ITt.iterator();
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
      localIterator = this.ITt.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.ITC != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fSC == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fSC.KKL)
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
    if ((this.Jbf != null) && (this.Jbf.enable))
    {
      a(null, this.Jbf);
      return true;
    }
    return false;
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.Jbf == null) {}
    while (this.Jbf.enable == paramBoolean) {
      return;
    }
    this.Jbf.enable = paramBoolean;
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
      this.tkw.removeCallbacks(this.JbF);
      this.tkw.removeCallbacks(this.JbE);
      this.tkw.postDelayed(this.JbE, 256L);
      return;
    }
    this.Jbc.getWindow().clearFlags(1024);
    this.tkw.removeCallbacks(this.JbE);
    this.tkw.removeCallbacks(this.JbF);
    this.tkw.postDelayed(this.JbF, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.tkw.removeCallbacks(this.JbF);
      this.tkw.removeCallbacks(this.JbE);
      this.tkw.postDelayed(this.JbE, paramLong);
      return;
    }
    this.Jbc.getWindow().clearFlags(1024);
    this.tkw.removeCallbacks(this.JbE);
    this.tkw.removeCallbacks(this.JbF);
    this.tkw.postDelayed(this.JbF, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Jbc.getWindow().setFlags(1024, 1024);
      return;
    }
    this.Jbc.getWindow().clearFlags(1024);
  }
  
  public final int fwQ()
  {
    this.ITq = false;
    if (this.DPG == 0) {
      this.DPG = this.mContext.getResources().getColor(2131100705);
    }
    return this.DPG;
  }
  
  final void fwS()
  {
    Object localObject1 = "%s";
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131165184);
    if (this.JaS != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.JaT != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int j = 1;; j = 0)
    {
      if ((!this.Jba) && (this.JaZ))
      {
        localObject1 = (String)localObject1 + " #";
        j += 2;
      }
      for (int i = 1;; i = 0)
      {
        if (this.Jba)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
        }
        for (int k = 1;; k = 0)
        {
          int n;
          int m;
          if (this.Jbb)
          {
            localObject1 = (String)localObject1 + " #";
            n = i + 2;
            i = 1;
            m = j + 2;
            j = n;
          }
          for (;;)
          {
            Object localObject2 = String.format((String)localObject1, new Object[] { this.JaR });
            ad.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
            localObject1 = com.tencent.mm.ui.f.c.b.h(this.mContext, (CharSequence)localObject2, i1);
            if ((localObject1 instanceof SpannableString))
            {
              localObject2 = (SpannableString)localObject1;
              if (this.JaS != 0) {
                ((SpannableString)localObject2).setSpan(this.JaU, 0, 1, 33);
              }
              if (this.JaT != 0)
              {
                m = ((SpannableString)localObject2).length() - m;
                ((SpannableString)localObject2).setSpan(this.JaV, m, m + 1, 33);
              }
              if (this.Jba)
              {
                if (this.JaX == null) {
                  this.JaX = jB(i1, 2131689877);
                }
                k = ((SpannableString)localObject2).length() - k;
                ((SpannableString)localObject2).setSpan(this.JaX, k, k + 1, 33);
              }
              if ((!this.Jba) && (this.JaZ))
              {
                if (this.JaW == null) {
                  this.JaW = a(i1, ao.k(this.Jbc, 2131690523, this.Jbc.getResources().getColor(2131099982)));
                }
                j = ((SpannableString)localObject2).length() - j;
                ((SpannableString)localObject2).setSpan(this.JaW, j, j + 1, 33);
              }
              if (this.Jbb)
              {
                if (this.JaY == null) {
                  this.JaY = jB(i1, 2131689880);
                }
                i = ((SpannableString)localObject2).length() - i;
                ((SpannableString)localObject2).setSpan(this.JaY, i, i + 1, 33);
              }
            }
            this.Jbi.setText((CharSequence)localObject1);
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
    if (this.JaR != null) {
      return this.JaR;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.iwl.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.iwl.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.Jbc.getSupportActionBar();
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
    if (this.Jbh != null)
    {
      int j = this.Jbh.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.Jbh.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.Jbh.clear();
      this.Jbh = null;
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
    View localView = this.Jbc.getCurrentFocus();
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
  
  public final void jK(Context paramContext)
  {
    com.tencent.mm.sdk.b.a.IbL.d(this.Jbv);
    hideAllManagedDialogs();
    com.tencent.mm.sdk.f.a.gx(paramContext);
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
    ad.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.ITt.size()) });
    if ((this.mActionBar == null) || (this.ITt.size() == 0))
    {
      ad.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.ITt.size()) });
      return false;
    }
    this.JbC = null;
    this.JbD = null;
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
      localObject1 = this.ITt.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1701;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.ITC != 16908332) {
          break;
        }
        ad.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label184:
      this.mContext.getResources().getDimensionPixelSize(2131165252);
    }
    if (locala.ITC == 2131302248)
    {
      boolean bool2 = this.Jbe;
      if (this.fSC == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!this.Jbe) || (this.fSC == null)) {
          break;
        }
        this.fSC.a(this.Jbc, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.ITC, 0, locala.text);
    com.tencent.mm.compatible.g.a.a(localMenuItem, getClass().getName());
    View.OnClickListener local20 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141350);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        s.a(s.this, localMenuItem, locala);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(141350);
      }
    };
    View.OnLongClickListener local2 = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141330);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        boolean bool = s.a(s.this, paramAnonymousView, locala);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(141330);
        return bool;
      }
    };
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = s.a(s.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(141331);
        return bool;
      }
    };
    if ((locala.ITD != 0) || (locala.JbO != null))
    {
      if (locala.ITF == null) {
        locala.ITF = View.inflate(this.mContext, 2131492920, null);
      }
      localObject2 = (ImageView)locala.ITF.findViewById(2131299154);
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      this.ITh = ((WeImageView)locala.ITF.findViewById(2131296376));
      this.ITh.setVisibility(0);
      label473:
      PorterDuff.Mode localMode;
      if (locala.JbO != null)
      {
        this.ITh.setImageDrawable(locala.JbO);
        if (this.Jbm == 0) {
          break label736;
        }
        localObject2 = this.ITh;
        int i = this.Jbm;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, i);
        label503:
        this.ITh.setOnClickListener(local20);
        this.ITh.setEnabled(locala.enable);
        this.ITh.setContentDescription(locala.text);
        if (locala.rAj != null) {
          this.ITh.setOnLongClickListener(local2);
        }
        this.Jbn = ((ImageView)locala.ITF.findViewById(2131299183));
        if (this.Jbn != null)
        {
          if (!locala.JbQ) {
            break label795;
          }
          this.Jbn.setVisibility(0);
        }
      }
      for (;;)
      {
        localMenuItem.setActionView(locala.ITF);
        localMenuItem.setEnabled(locala.enable);
        localMenuItem.setVisible(locala.visible);
        localMenuItem.setShowAsAction(2);
        if (locala.ITD == 2131233291)
        {
          this.JbC = locala;
          this.JbD = localMenuItem;
        }
        ad.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.ITC), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
        break;
        this.ITh.setImageResource(locala.ITD);
        break label473;
        label736:
        if (locala.JbN != 0) {
          break label503;
        }
        if (this.ITq)
        {
          localObject2 = this.ITh;
          localMode = PorterDuff.Mode.SRC_ATOP;
          a((WeImageView)localObject2, -1);
          break label503;
        }
        localObject2 = this.ITh;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, -16777216);
        break label503;
        label795:
        this.Jbn.setVisibility(8);
      }
    }
    if (locala.ITE == null) {
      locala.ITE = View.inflate(this.mContext, 2131492920, null);
    }
    this.ITj = ((TextView)locala.ITE.findViewById(2131296377));
    this.ITj.setVisibility(0);
    this.rlu = ((Button)locala.ITE.findViewById(2131296374));
    this.rlu.setVisibility(8);
    this.Jbr = locala.ITE.findViewById(2131296600);
    this.Jbr.setVisibility(8);
    if ((locala.JbP == b.JbT) || (locala.JbP == b.JbW))
    {
      this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131100801));
      this.rlu.setVisibility(0);
      this.rlu.setBackgroundResource(2131231371);
      this.ITj.setVisibility(8);
    }
    for (;;)
    {
      this.ITj.setText(locala.text);
      if (locala.textColor != 0) {
        this.ITj.setTextColor(locala.textColor);
      }
      this.ITj.setOnClickListener(local20);
      this.ITj.setOnLongClickListener(local2);
      this.ITj.setEnabled(locala.enable);
      this.ITj.setOnTouchListener((View.OnTouchListener)localObject2);
      this.rlu.setText(locala.text);
      this.rlu.setOnClickListener(local20);
      this.rlu.setOnLongClickListener(local2);
      this.rlu.setOnTouchListener((View.OnTouchListener)localObject2);
      this.rlu.setEnabled(locala.enable);
      localMenuItem.setActionView(locala.ITE);
      break;
      if (locala.JbP == b.JbX)
      {
        this.rlu.setVisibility(0);
        this.rlu.setBackgroundResource(2131231372);
        this.rlu.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131101180));
        this.ITj.setVisibility(8);
      }
      else if (locala.JbP == b.JbS)
      {
        this.rlu.setVisibility(0);
        this.rlu.setBackgroundResource(2131231366);
        this.rlu.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131100161));
        this.ITj.setVisibility(8);
      }
      else
      {
        if (locala.JbP != b.JbU)
        {
          if (locala.JbP == b.JbZ)
          {
            this.ITj.setTextColor(this.Jbc.getResources().getColor(2131100585));
            continue;
          }
          if (locala.JbP == b.JbY)
          {
            this.ITj.setTextColor(this.Jbc.getResources().getColor(2131100800));
            continue;
          }
          if (locala.JbP == b.Jcc)
          {
            this.rlu.setVisibility(0);
            this.rlu.setBackgroundResource(2131231376);
            this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131100161));
            this.ITj.setVisibility(8);
            continue;
          }
          if (b.Jce == locala.JbP)
          {
            ad.i("MicroMsg.MMActivityController", "dark green mode.");
            this.rlu.setVisibility(0);
            this.rlu.setBackgroundResource(2131231363);
            this.rlu.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131100397));
            this.ITj.setVisibility(8);
            continue;
          }
          if (locala.JbP == b.Jcd)
          {
            this.rlu.setVisibility(0);
            this.rlu.setBackgroundResource(2131231369);
            this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131100161));
            this.ITj.setVisibility(8);
            continue;
          }
          if (b.Jcf == locala.JbP)
          {
            ad.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.Jbd) });
            this.ITj.setVisibility(8);
            if (this.Jbd)
            {
              this.Jbr.setVisibility(0);
              this.Jbr.setOnClickListener(local20);
              continue;
            }
            if (8 == this.Jbr.getVisibility()) {
              this.Jbr.setVisibility(4);
            }
            for (;;)
            {
              this.Jbr.setOnClickListener(null);
              break;
              if (this.Jbr.getVisibility() == 0) {
                this.Jbr.animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(141332);
                    s.i(s.this).setVisibility(4);
                    AppMethodBeat.o(141332);
                  }
                });
              }
            }
          }
          if (this.Jbm != 0)
          {
            this.ITj.setTextColor(this.Jbm);
            continue;
          }
          if (this.ITq)
          {
            this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131101185));
            continue;
          }
        }
        this.ITj.setTextColor(com.tencent.mm.cc.a.m(this.Jbc, 2131100024));
      }
    }
    label1701:
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.ZK();
    com.tencent.mm.compatible.b.g.ZK();
    if ((this.Jbe) && (this.fSC != null) && (this.fSC.onKeyDown(paramInt, paramKeyEvent)))
    {
      ad.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.ITq) {
        setActionbarColor(this.Jbc.getResources().getColor(2131100196));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.Jbc.getResources().getColor(2131100705));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.JbC != null) && (this.JbC.enable)) {
        a(this.JbD, this.JbC);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ad.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.JaQ)
    {
      ad.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.Jbf.ITC) && (this.Jbf.enable))
    {
      a(paramMenuItem, this.Jbf);
      return true;
    }
    Iterator localIterator = this.ITt.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.ITC)
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
    com.tencent.mm.sdk.b.a.IbL.d(this.Jbv);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ad.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.Jbe) && (this.fSC != null)) {
      this.fSC.a(this.Jbc, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    com.tencent.mm.sdk.b.a.IbL.c(this.Jbv);
    Object localObject = new com.tencent.mm.g.a.ap();
    ((com.tencent.mm.g.a.ap)localObject).dll.type = 2;
    ((com.tencent.mm.g.a.ap)localObject).dll.position = this.Jbt;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    String str;
    int i;
    if (((com.tencent.mm.g.a.ap)localObject).dlm.dlq == 2)
    {
      l = System.currentTimeMillis();
      str = ((com.tencent.mm.g.a.ap)localObject).dlm.dls;
      i = ((com.tencent.mm.g.a.ap)localObject).dlm.position;
      ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.Jbt)) {
        break label432;
      }
      ad.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Jbt) });
    }
    for (;;)
    {
      ad.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD) && (!com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cc.a.eb(com.tencent.mm.sdk.platformtools.aj.getContext())) {
          break;
        }
        if (1.0F != com.tencent.mm.sdk.platformtools.aj.getContext().getResources().getConfiguration().fontScale)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(15181, new Object[] { Integer.valueOf(1) });
          localObject = new f.a(com.tencent.mm.sdk.platformtools.aj.getContext());
          ((f.a)localObject).av(this.Jbc.getResources().getString(2131759585)).aXO(this.Jbc.getResources().getString(2131759582)).aXS(this.Jbc.getResources().getString(2131759584)).aXT(this.Jbc.getResources().getString(2131759583));
          ((f.a)localObject).c(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(141349);
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(15181, new Object[] { Integer.valueOf(3) });
                Object localObject = new Intent();
                ((Intent)localObject).setClassName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                ((Intent)localObject).addFlags(268435456);
                paramAnonymousString = com.tencent.mm.sdk.platformtools.aj.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(141349);
                return;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(15181, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(141349);
            }
          }).show();
          com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label432:
      a(((com.tencent.mm.g.a.ap)localObject).dlm.dlr, ((com.tencent.mm.g.a.ap)localObject).dlm.visible, ((com.tencent.mm.g.a.ap)localObject).dlm.url, ((com.tencent.mm.g.a.ap)localObject).dlm.desc, str, i, true);
    }
    com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
  }
  
  public final void onStart()
  {
    this.landscapeMode = this.mContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC(), 0).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      this.Jbc.setRequestedOrientation(-1);
      return;
    }
    this.Jbc.setRequestedOrientation(1);
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
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.abl())) {
      i = paramInt;
    }
    for (;;)
    {
      if (((paramActivity instanceof MMActivity)) && (((MMActivity)paramActivity).fixStatusbar) && (((MMActivity)paramActivity).isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.statusbar.a.e(this.contentView, i, d.e(paramActivity.getWindow()));
      }
      for (;;)
      {
        setNavigationbarColor(paramActivity.getResources().getColor(2131099648));
        this.statusBarColor = paramInt;
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label124;
        }
        i = ao.v(paramActivity.getResources().getColor(2131100954), paramInt);
        break;
        paramActivity.getWindow().setStatusBarColor(i);
      }
      label124:
      i = 0;
    }
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.ITt.isEmpty()) {
      return;
    }
    this.ITt.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.ITt.size())
      {
        if (((a)this.ITt.get(i)).ITC == paramInt)
        {
          ad.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.ITt.remove(i);
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
    this.DPG = paramInt;
    this.ITq = ao.abX(this.DPG);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.DPG));
    q(this.Jbc, this.DPG);
    fwU();
    fwT();
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
        if (this.Jbk.getDrawable() == null) {
          i = 2131689490;
        }
      }
      if ((this.Jbk != null) && (i != 0)) {
        this.Jbk.setImageResource(i);
      }
      this.Jbf.ITC = 16908332;
      this.Jbf.jil = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.Jbj != null) {
        this.Jbj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(141338);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141337);
                s.9.this.ITv.onMenuItemClick(null);
                AppMethodBeat.o(141337);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(141338);
          }
        });
      }
    }
  }
  
  public final void setBackBtnColorFilter(int paramInt)
  {
    if (this.Jbk != null) {
      this.Jbk.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.Jbk == null) {
      return;
    }
    if (paramBoolean)
    {
      this.Jbk.setVisibility(0);
      return;
    }
    this.Jbk.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.JaP == null) {
      this.JaP = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    this.JaP.setBackgroundResource(paramInt);
    this.BKn.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.JaP == null) {
      this.JaP = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.JaN != null) {
      this.JaP.removeView(this.JaN);
    }
    this.JaP.removeView(this.BKn);
    this.BKn = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.JaP.addView(this.BKn, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.JaN != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.b.g(this.mContext, 47.0F));
      this.JaP.addView(this.JaN, this.JaP.getChildCount(), localLayoutParams);
    }
    this.JaP.invalidate();
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.Jbj != null)
    {
      this.Jbj.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.Jbj.setEnabled(false);
    }
    for (;;)
    {
      if (this.ITh != null)
      {
        this.ITh.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.ITh.setEnabled(false);
      }
      return;
      label59:
      this.Jbj.setEnabled(true);
    }
    this.ITh.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      bb(this.Jbc);
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
        this.mActionBar.setCustomView(Jbx);
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
    this.nci.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cc.a.im(this.Jbc))
    {
      this.nci.setTextSize(1, 14.0F);
      this.Jbi.setTextSize(1, 18.0F);
    }
    this.nci.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.nci.setVisibility(8);
      return;
    }
    this.nci.setText(paramString);
    if (com.tencent.mm.cc.a.im(this.Jbc))
    {
      this.nci.setTextSize(1, 14.0F);
      this.Jbi.setTextSize(1, 18.0F);
    }
    this.nci.setVisibility(0);
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
    this.JaR = paramCharSequence.toString();
    this.Jbi.setText(paramCharSequence);
    if (com.tencent.mm.cc.a.im(this.Jbc)) {
      this.Jbi.setTextSize(0, com.tencent.mm.cc.a.ay(this.Jbc, 2131165184) * com.tencent.mm.cc.a.ik(this.Jbc));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.JaR = paramString;
    if (com.tencent.mm.cc.a.im(this.Jbc)) {
      this.Jbi.setTextSize(0, com.tencent.mm.cc.a.ay(this.Jbc, 2131165184) * com.tencent.mm.cc.a.ik(this.Jbc));
    }
    fwS();
    updateDescription(paramString);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.Jbi.setVisibility(paramInt);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!fwV()))
    {
      this.Jbc.getWindow().setNavigationBarColor(paramInt);
      boolean bool = ao.abX(paramInt);
      localView = this.Jbc.getWindow().getDecorView();
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
    this.JaQ = paramBoolean;
    if ((this.JaM == null) && (this.contentView != null)) {
      this.JaM = this.contentView.findViewById(2131302342);
    }
    if (this.JaM == null)
    {
      ad.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.JaM;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.JaM;
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
      jJ(this.Jbc);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    q(this.Jbc, paramInt);
    updataStatusBarIcon(ao.abX(paramInt));
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SystemClock.elapsedRealtime() - s.l(s.this) < 300L) {
          paramRunnable.run();
        }
        s.a(s.this, SystemClock.elapsedRealtime());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      this.JaS = 0;
      this.JaU = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.JaT = 0;
      this.JaV = null;
    }
    for (;;)
    {
      fwS();
      return;
      if (this.JaS == paramInt1) {
        break;
      }
      this.JaS = paramInt1;
      this.JaU = jB(this.mContext.getResources().getDimensionPixelSize(2131165192), this.JaS);
      break;
      label82:
      if (this.JaT != paramInt2)
      {
        this.JaT = paramInt2;
        this.JaV = jB(this.mContext.getResources().getDimensionPixelSize(2131165192), this.JaT);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.JaZ = bool;
      fwS();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jbb = bool;
      fwS();
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
      q(this.Jbc, this.DPG);
      return;
    }
    this.mActionBar.hide();
    q(this.Jbc, this.Jbc.getResources().getColor(2131100017));
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
    } while (this.Jbj == null);
    View localView = this.Jbj;
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
    this.Jbc.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.Jbc.getWindow().getDecorView();
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
    while ((this.Jbk == null) || (paramDrawable == null)) {
      return;
    }
    this.Jbk.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.fyf().l(this.Jbc, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = abH(paramInt1);
    if ((locala != null) && (locala.ITD != paramInt2))
    {
      locala.ITD = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = abH(paramInt);
    if (locala != null)
    {
      locala.jil = paramOnMenuItemClickListener;
      locala.rAj = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = abH(paramInt);
    if ((locala != null) && (locala.JbQ != paramBoolean))
    {
      locala.JbQ = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = abH(paramInt);
    if ((locala != null) && (!bt.bI(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void xl(boolean paramBoolean)
  {
    this.ITq = paramBoolean;
    fwU();
    fwT();
  }
  
  public static final class a
  {
    public int ITC = -1;
    public int ITD;
    public View ITE;
    public View ITF;
    public int JbN = 0;
    public Drawable JbO;
    public s.b JbP = s.b.JbR;
    public boolean JbQ = false;
    public boolean enable = true;
    public MenuItem.OnMenuItemClickListener jil;
    public View.OnLongClickListener rAj;
    public View.OnTouchListener tKQ;
    public String text;
    public int textColor;
    public boolean visible = true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      JbR = new b("NORMAL", 0);
      JbS = new b("GREEN", 1);
      JbT = new b("RED", 2);
      JbU = new b("BLACK", 3);
      JbV = new b("TRANSPARENT", 4);
      JbW = new b("TRANSPARENT_RED_TEXT", 5);
      JbX = new b("TRANSPARENT_GREEN_TEXT", 6);
      JbY = new b("GOLDEN", 7);
      JbZ = new b("TRANSPARENT_GOLD_TEXT", 8);
      Jca = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      Jcb = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      Jcc = new b("YELLOW", 11);
      Jcd = new b("ORANGE", 12);
      Jce = new b("DARK_GREEN_MODE", 13);
      Jcf = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      Jcg = new b[] { JbR, JbS, JbT, JbU, JbV, JbW, JbX, JbY, JbZ, Jca, Jcb, Jcc, Jcd, Jce, Jcf };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */