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
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.b;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static boolean HnA = false;
  private static final int HnR = 2131492928;
  public static long HnT;
  private static byte[] HnV = { 0 };
  private static PowerManager.WakeLock wakeLock = null;
  View HfO;
  private int HfQ = 0;
  WeImageView HfR;
  TextView HfT;
  private boolean Hga = false;
  int Hgb;
  private int Hgc;
  LinkedList<a> Hgd = new LinkedList();
  ArrayList<Dialog> HnB;
  TextView HnC;
  View HnD;
  WeImageView HnE;
  ProgressBar HnF;
  int HnG = 0;
  private ImageView HnH;
  private ViewGroup.LayoutParams HnI;
  View HnJ;
  AlbumChooserView HnK;
  private View HnL;
  public boolean HnM = true;
  private int HnN = 0;
  private boolean HnO = false;
  private c HnP = new c() {};
  private int HnQ = 2131492926;
  private int HnS = -1;
  int HnU = 0;
  private a HnW;
  private MenuItem HnX;
  private Runnable HnY = new Runnable()
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
  private Runnable HnZ = new Runnable()
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
  private View Hnf;
  public View Hng;
  private View Hnh;
  private TextView Hni;
  private FrameLayout Hnj;
  public boolean Hnk = true;
  private String Hnl = " ";
  private int Hnm = 0;
  private int Hnn = 0;
  private com.tencent.mm.ui.widget.a Hno = null;
  private com.tencent.mm.ui.widget.a Hnp = null;
  private com.tencent.mm.ui.widget.a Hnq = null;
  private com.tencent.mm.ui.widget.a Hnr = null;
  private com.tencent.mm.ui.widget.a Hns = null;
  private boolean Hnt = false;
  boolean Hnu = false;
  private boolean Hnv = false;
  public AppCompatActivity Hnw;
  boolean Hnx = false;
  private boolean Hny;
  private a Hnz = new a();
  private View actionbarView;
  int bxO = this.Hgb;
  String className;
  View contentView;
  private boolean fXS = false;
  private r fzp;
  private LayoutInflater iMw;
  private AudioManager icP;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  TextView mBI;
  Context mContext;
  private Button qBE;
  protected com.tencent.mm.sdk.platformtools.ao snT = new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper());
  private final long ySC = 300L;
  private long ySD = SystemClock.elapsedRealtime();
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.Hga) {
      localDrawable = am.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, ao.av(this.Hnw, 2131165289), ao.av(this.Hnw, 2131165289));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable);
    paramDrawable.IZa = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.Hgm = paramInt1;
    locala.Hgn = paramInt2;
    locala.text = paramString;
    locala.iPc = paramOnMenuItemClickListener;
    locala.qQj = paramOnLongClickListener;
    locala.Hoj = paramb;
    locala.Hok = paramBoolean;
    if ((locala.Hgn == 2131233291) && (bs.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(2131755815);
    }
    Zw(locala.Hgm);
    this.Hgd.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.Hgm = paramInt;
    locala.Hoi = paramDrawable;
    locala.text = paramString;
    locala.iPc = paramOnMenuItemClickListener;
    locala.qQj = null;
    locala.Hoj = paramb;
    Zw(locala.Hgm);
    this.Hgd.add(locala);
    new com.tencent.mm.sdk.platformtools.ao().postDelayed(new Runnable()
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
    ac.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.Hnh });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.Hnh == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      ac.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.Hnj == null) {
      this.Hnj = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.Hnh != null) {
      this.Hnj.removeView(this.Hnh);
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.Hnh = this.iMw.inflate(paramInt1, null);
      this.Hni = ((TextView)this.Hnh.findViewById(2131302969));
      this.Hnh.findViewById(2131302964).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141341);
          paramAnonymousView = new ap();
          paramAnonymousView.cZT.type = 1;
          paramAnonymousView.cZT.cZV = paramString3;
          paramAnonymousView.cZT.position = paramInt2;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          s.b(s.this).setVisibility(8);
          AppMethodBeat.o(141341);
        }
      });
      this.Hnh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141343);
          if (paramString1 != null)
          {
            Object localObject = new Intent("android.intent.action.VIEW");
            ((Intent)localObject).setData(Uri.parse(paramString1));
            paramAnonymousView = s.c(s.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(141343);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.HnO) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.g(this.Hnw, 48.0F), 0, 0);
        ac.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.Hnj.addView(this.Hnh, this.Hnj.getChildCount(), paramString3);
      if (this.Hnh == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.Hnh;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(2131760318);
          paramString3 = paramString2;
          if (bs.isNullOrNil(paramString2)) {
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
          this.Hni.setText(paramString1);
        }
        for (;;)
        {
          this.Hnh.invalidate();
          this.Hnj.invalidate();
          return;
          paramInt1 = 8;
          break;
          label488:
          ac.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.Hni.setText(paramString3);
        }
      }
      this.Hnh.post(new Runnable()
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
            if (!bs.isNullOrNil(paramString2)) {
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
            ac.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
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
    if (!this.Hnk) {
      ac.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.iPc == null) {
      return;
    }
    parama.iPc.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.HnM)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.clearColorFilter();
  }
  
  private static boolean aPB(String paramString)
  {
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {}
    while ((!lL(str1, paramString)) && (!lL(str2, paramString))) {
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
    if (this.HnM)
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
      ac.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.HfQ == 0) {
        this.HfQ = fgE();
      }
      this.Hga = am.ZN(this.HfQ);
      setActionbarColor(this.HfQ);
      this.mActionBar.setLogo(new ColorDrawable(this.Hnw.getResources().getColor(17170445)));
      this.mActionBar.fU();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.fT();
      this.mActionBar.fV();
      this.mActionBar.fS();
      if (this.HnS != -1) {
        break label370;
      }
      localView = z.jD(this.Hnw).inflate(this.HnQ, new LinearLayout(this.Hnw), false);
      this.mActionBar.setCustomView(localView);
      this.HnC = ((TextView)findViewById(16908308));
      this.mBI = ((TextView)findViewById(16908309));
      this.HfO = findViewById(2131305937);
      this.HnF = ((ProgressBar)findViewById(2131303518));
      this.HnD = findViewById(2131296416);
      this.HnE = ((WeImageView)findViewById(2131296417));
      this.HnD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(141348);
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            s.HnT = System.currentTimeMillis();
          }
          AppMethodBeat.o(141348);
          return false;
        }
      });
      if (this.HnE != null) {
        this.HnE.setContentDescription(this.Hnw.getString(2131755281));
      }
      if (this.HnC != null) {
        this.HnC.setText(2131755822);
      }
      this.HnJ = findViewById(2131296408);
      this.HnK = ((AlbumChooserView)findViewById(2131296394));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label408;
      }
      if (this.HnE != null) {
        this.HnE.setVisibility(0);
      }
      if (this.HnD != null) {
        this.HnD.setVisibility(0);
      }
    }
    for (;;)
    {
      fgH();
      return;
      label370:
      localView = z.jD(this.Hnw).inflate(this.HnS, new LinearLayout(this.Hnw), false);
      this.mActionBar.setCustomView(localView);
      break;
      label408:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.HnE != null) {
          this.HnE.setVisibility(0);
        }
        if (this.HnD != null) {
          this.HnD.setVisibility(0);
        }
        if (this.HnC != null)
        {
          this.HnC.setVisibility(0);
          aj.a(this.HnC.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.HnE != null) {
          this.HnE.setVisibility(8);
        }
        if (this.HnD != null) {
          this.HnD.setVisibility(8);
        }
      }
    }
  }
  
  public static boolean fgF()
  {
    for (;;)
    {
      synchronized (HnV)
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
  
  private void fgH()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.Hga)
    {
      if (this.HnE != null)
      {
        localWeImageView = this.HnE;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.HnC != null) && (this.HnC.getVisibility() == 0)) {
        this.HnC.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.mBI != null) && (this.mBI.getVisibility() == 0)) {
        this.mBI.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.HfR != null) && (this.HfR.getVisibility() == 0)) {
        if (this.HfR.getDrawable() != null) {
          b(this.HfR.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.HfR;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.HfT == null) || (this.HfT.getVisibility() != 0));
      this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131101185));
      return;
      if (this.HnE != null)
      {
        localWeImageView = this.HnE;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
      }
      if ((this.HnC != null) && (this.HnC.getVisibility() == 0)) {
        this.HnC.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.mBI != null) && (this.mBI.getVisibility() == 0)) {
        this.mBI.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.HfR != null) && (this.HfR.getVisibility() == 0))
      {
        if (this.HfR.getDrawable() != null)
        {
          b(this.HfR.getDrawable(), -16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        localWeImageView = this.HfR;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
        return;
      }
    } while ((this.HfT == null) || (this.HfT.getVisibility() != 0));
    this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131100024));
  }
  
  private void fgI()
  {
    updataStatusBarIcon(this.Hga);
  }
  
  private static boolean fgJ()
  {
    return (aPB("y83a")) || (aPB("y83")) || (aPB("v1732a")) || (aPB("v1732t"));
  }
  
  public static boolean fgK()
  {
    return fgJ();
  }
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.Hnw.findViewById(paramInt);
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return initLanguage(paramContext, ab.f(paramContext.getSharedPreferences(ai.eUX(), 0)));
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      ab.a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = ab.aKK(paramString);
    ab.a(paramContext, paramString);
    return paramString;
  }
  
  private com.tencent.mm.ui.widget.a jp(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.Hga) {
      localDrawable = am.k(this.Hnw, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.IZa = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private void jy(Context paramContext)
  {
    synchronized (HnV)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(32, "screen Lock");
      }
      if (!wakeLock.isHeld())
      {
        wakeLock.acquire();
        ac.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      ac.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  private static boolean lL(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return bs.lr(paramString1.toLowerCase(), paramString2.toLowerCase());
  }
  
  private void releaseWakeLock()
  {
    synchronized (HnV)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        wakeLock.release();
        ac.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        wakeLock = null;
        return;
      }
      ac.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  public static void setMainProcess()
  {
    HnA = true;
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
  
  final boolean Zw(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.Hgd.size())
      {
        if (((a)this.Hgd.get(i)).Hgm == paramInt)
        {
          ac.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.Hgd.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a Zx(int paramInt)
  {
    Iterator localIterator = this.Hgd.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.Hgm == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void Zy(int paramInt)
  {
    if (noActionBar()) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > this.Hgb) {
        i = this.Hgb;
      }
      paramInt = i;
      if (i < this.Hgc) {
        paramInt = this.Hgc;
      }
      this.bxO = paramInt;
      this.actionbarView = this.Hnw.getWindow().getDecorView().findViewById(2131296345);
      if (this.actionbarView != null) {
        this.HnI = this.actionbarView.getLayoutParams();
      }
      if ((this.actionbarView != null) && (this.HnI != null))
      {
        this.HnI.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
        this.actionbarView.setLayoutParams(this.HnI);
      }
      float f1 = Math.min(com.tencent.mm.cc.a.eb(this.Hnw), com.tencent.mm.cc.a.ib(this.Hnw));
      i = (int)(ao.av(this.mContext, 2131165570) * f1);
      int j = (int)(f1 * ao.av(this.mContext, 2131165518));
      int k = ao.fromDPToPix(this.mContext, 14);
      f1 = (paramInt - this.Hgc) / (this.Hgb - this.Hgc);
      float f2 = i;
      float f3 = j - i;
      setIconAlpha(f1);
      paramInt = (int)((k - ao.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
      i = (int)((this.Hgc - this.Hgb) / 2.0F * (1.0F - f1));
      if (this.HnC != null)
      {
        this.HnC.setTextSize(0, f3 * f1 + f2);
        if (this.HfO != null)
        {
          this.HfO.setTranslationX(paramInt);
          this.HfO.setTranslationY(i);
        }
      }
      if (this.HnE != null) {
        this.HnE.setTranslationY(i);
      }
    } while (this.HfR == null);
    this.HfR.setTranslationY(i);
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.Hnw = paramAppCompatActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = this.Hnw.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      this.Hnw.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    if (!noActionBar())
    {
      boolean bool = ai.getContext().getSharedPreferences(ai.eUX() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
      ai.getContext().getSharedPreferences(ai.eUX() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (!bool)
      {
        ai.getContext().getSharedPreferences(ai.eUX() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
        ai.getContext().getSharedPreferences(ai.eUX() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
      }
    }
    this.fXS = aj.j(paramAppCompatActivity.getResources());
    int i;
    label448:
    label582:
    label736:
    long l;
    if (paramAppCompatActivity != null)
    {
      if (!this.fXS) {
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
      ah.cJ(3, this.className);
      initLanguage(paramContext);
      this.icP = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.iMw = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.a.b.ahR();
        this.contentView = com.tencent.mm.kiss.a.b.c(paramAppCompatActivity, 2131494760);
      }
      this.Hnf = this.contentView.findViewById(2131302342);
      this.Hnj = ((FrameLayout)this.contentView.findViewById(2131302320));
      if (i != -1)
      {
        this.Hng = getLayoutView();
        if (this.Hng != null) {
          break label1118;
        }
        this.Hng = this.iMw.inflate(getLayoutId(), null);
        this.Hnj.addView(this.Hng, 0);
      }
      dealContentView(this.contentView);
      if (fromFullScreenActivity())
      {
        aj.m(aj.a(this.Hnw.getWindow(), this.Hng), this.Hng);
        ((ViewGroup)this.Hng.getParent()).removeView(this.Hng);
        ((ViewGroup)this.Hnw.getWindow().getDecorView()).addView(this.Hng, 0);
        int j = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label1148;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165251);
        this.Hng.setPadding(this.Hng.getPaddingLeft(), i + (j + this.Hng.getPaddingTop()), this.Hng.getPaddingRight(), this.Hng.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      ac.d("MicroMsg.MMActivityController", "onCreate, before.");
      bb(paramAppCompatActivity);
      if (!noActionBar())
      {
        this.Hgb = ao.av(this.mContext, 2131165252);
        this.Hgc = ao.av(this.mContext, 2131165559);
      }
      if (this.Hnj != null) {
        this.Hnj.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(141345);
            s.e(s.this).removeOnAttachStateChangeListener(this);
            com.tencent.mm.kiss.a.b.ahS();
            AppMethodBeat.o(141345);
          }
        });
      }
      if ((this.Hnj == null) || (!(this.Hnj instanceof LayoutListenerView))) {
        break label1165;
      }
      ((LayoutListenerView)this.Hnj).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int Hog;
        
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
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.Hog))
            {
              s.g(s.this);
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.Hog)) {
              s.h(s.this);
            }
          }
          AppMethodBeat.o(141347);
        }
      });
      paramContext = new ap();
      paramContext.cZT.type = 2;
      paramContext.cZT.position = this.HnN;
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      if (paramContext.cZU.cZY == 2)
      {
        l = System.currentTimeMillis();
        localObject = paramContext.cZU.daa;
        i = paramContext.cZU.position;
        ac.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject, bs.eWi() });
        if ((i <= 0) || (i == this.HnN)) {
          break label1177;
        }
        ac.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.HnN) });
      }
    }
    for (;;)
    {
      ac.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
      {
        if (this.HfQ == 0) {
          this.HfQ = fgE();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        q(paramAppCompatActivity, this.HfQ);
        fgI();
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
      if (this.Hng.getParent() == null) {
        break label448;
      }
      ((ViewGroup)this.Hng.getParent()).removeView(this.Hng);
      break label448;
      label1148:
      i = this.mContext.getResources().getDimensionPixelSize(2131165252);
      break label582;
      label1165:
      ac.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label736;
      label1177:
      a(paramContext.cZU.cZZ, paramContext.cZU.visible, paramContext.cZU.url, paramContext.cZU.desc, (String)localObject, i, true);
    }
  }
  
  public final void a(a parama)
  {
    Zw(parama.Hgm);
    this.Hgd.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  public final void aX(int paramInt, boolean paramBoolean)
  {
    this.HnN = paramInt;
    this.HnO = paramBoolean;
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    if ((!HnA) && (paramBoolean))
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
    if (this.HnB == null) {
      this.HnB = new ArrayList();
    }
    this.HnB.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.Hol);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Hol);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.Hol);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.Hol);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Hol);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.Hol);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.Hol);
  }
  
  public final void addSearchMenu(boolean paramBoolean, r paramr)
  {
    ac.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.Hgm = 2131302248;
    locala.text = this.mContext.getString(2131755882);
    locala.Hgn = 2131689494;
    locala.iPc = null;
    locala.qQj = null;
    removeOptionMenu(locala.Hgm);
    this.Hgd.add(0, locala);
    this.Hny = paramBoolean;
    this.fzp = paramr;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.Hol);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Hol);
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
      localIterator = this.Hgd.iterator();
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
      localIterator = this.Hgd.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.Hgm != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fzp == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fzp.ITH)
        {
          if (!paramBoolean1) {
            supportInvalidateOptionsMenu();
          }
          ac.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
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
      localIterator = this.Hgd.iterator();
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
      localIterator = this.Hgd.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.Hgm != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fzp == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fzp.ITH)
        {
          if ((bool) && (!paramBoolean1)) {
            supportInvalidateOptionsMenu();
          }
          ac.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final boolean callBackMenu()
  {
    if ((this.Hnz != null) && (this.Hnz.enable))
    {
      a(null, this.Hnz);
      return true;
    }
    return false;
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.Hnz == null) {}
    while (this.Hnz.enable == paramBoolean) {
      return;
    }
    this.Hnz.enable = paramBoolean;
    supportInvalidateOptionsMenu();
  }
  
  public final int fgE()
  {
    this.Hga = false;
    if (this.HfQ == 0) {
      this.HfQ = this.mContext.getResources().getColor(2131100705);
    }
    return this.HfQ;
  }
  
  final void fgG()
  {
    Object localObject1 = "%s";
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131165184);
    if (this.Hnm != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.Hnn != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int j = 1;; j = 0)
    {
      if ((!this.Hnu) && (this.Hnt))
      {
        localObject1 = (String)localObject1 + " #";
        j += 2;
      }
      for (int i = 1;; i = 0)
      {
        if (this.Hnu)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
        }
        for (int k = 1;; k = 0)
        {
          int n;
          int m;
          if (this.Hnv)
          {
            localObject1 = (String)localObject1 + " #";
            n = i + 2;
            i = 1;
            m = j + 2;
            j = n;
          }
          for (;;)
          {
            Object localObject2 = String.format((String)localObject1, new Object[] { this.Hnl });
            ac.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
            localObject1 = com.tencent.mm.ui.f.c.b.h(this.mContext, (CharSequence)localObject2, i1);
            if ((localObject1 instanceof SpannableString))
            {
              localObject2 = (SpannableString)localObject1;
              if (this.Hnm != 0) {
                ((SpannableString)localObject2).setSpan(this.Hno, 0, 1, 33);
              }
              if (this.Hnn != 0)
              {
                m = ((SpannableString)localObject2).length() - m;
                ((SpannableString)localObject2).setSpan(this.Hnp, m, m + 1, 33);
              }
              if (this.Hnu)
              {
                if (this.Hnr == null) {
                  this.Hnr = jp(i1, 2131689877);
                }
                k = ((SpannableString)localObject2).length() - k;
                ((SpannableString)localObject2).setSpan(this.Hnr, k, k + 1, 33);
              }
              if ((!this.Hnu) && (this.Hnt))
              {
                if (this.Hnq == null) {
                  this.Hnq = a(i1, am.k(this.Hnw, 2131690523, this.Hnw.getResources().getColor(2131099982)));
                }
                j = ((SpannableString)localObject2).length() - j;
                ((SpannableString)localObject2).setSpan(this.Hnq, j, j + 1, 33);
              }
              if (this.Hnv)
              {
                if (this.Hns == null) {
                  this.Hns = jp(i1, 2131689880);
                }
                i = ((SpannableString)localObject2).length() - i;
                ((SpannableString)localObject2).setSpan(this.Hns, i, i + 1, 33);
              }
            }
            this.HnC.setText((CharSequence)localObject1);
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
  
  protected abstract boolean fromFullScreenActivity();
  
  public final void fullScreenNoTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.snT.removeCallbacks(this.HnZ);
      this.snT.removeCallbacks(this.HnY);
      this.snT.postDelayed(this.HnY, 256L);
      return;
    }
    this.Hnw.getWindow().clearFlags(1024);
    this.snT.removeCallbacks(this.HnY);
    this.snT.removeCallbacks(this.HnZ);
    this.snT.postDelayed(this.HnZ, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.snT.removeCallbacks(this.HnZ);
      this.snT.removeCallbacks(this.HnY);
      this.snT.postDelayed(this.HnY, paramLong);
      return;
    }
    this.Hnw.getWindow().clearFlags(1024);
    this.snT.removeCallbacks(this.HnY);
    this.snT.removeCallbacks(this.HnZ);
    this.snT.postDelayed(this.HnZ, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Hnw.getWindow().setFlags(1024, 1024);
      return;
    }
    this.Hnw.getWindow().clearFlags(1024);
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
    if (this.Hnl != null) {
      return this.Hnl;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.icP.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.icP.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.Hnw.getSupportActionBar();
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
    if (this.HnB != null)
    {
      int j = this.HnB.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.HnB.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.HnB.clear();
      this.HnB = null;
    }
  }
  
  public final void hideTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      ac.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    View localView = this.Hnw.getCurrentFocus();
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
        ac.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
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
      ac.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return false;
      bool = false;
    }
    return this.mActionBar.isShowing();
  }
  
  public final void jz(Context paramContext)
  {
    com.tencent.mm.sdk.b.a.GpY.d(this.HnP);
    hideAllManagedDialogs();
    com.tencent.mm.sdk.f.a.gu(paramContext);
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
    ac.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.Hgd.size()) });
    if ((this.mActionBar == null) || (this.Hgd.size() == 0))
    {
      ac.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.Hgd.size()) });
      return false;
    }
    this.HnW = null;
    this.HnX = null;
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
      localObject1 = this.Hgd.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1701;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.Hgm != 16908332) {
          break;
        }
        ac.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label184:
      this.mContext.getResources().getDimensionPixelSize(2131165252);
    }
    if (locala.Hgm == 2131302248)
    {
      boolean bool2 = this.Hny;
      if (this.fzp == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ac.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!this.Hny) || (this.fzp == null)) {
          break;
        }
        this.fzp.a(this.Hnw, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.Hgm, 0, locala.text);
    com.tencent.mm.compatible.g.a.a(localMenuItem, getClass().getName());
    View.OnClickListener local20 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141350);
        s.a(s.this, localMenuItem, locala);
        AppMethodBeat.o(141350);
      }
    };
    View.OnLongClickListener local2 = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141330);
        boolean bool = s.a(s.this, paramAnonymousView, locala);
        AppMethodBeat.o(141330);
        return bool;
      }
    };
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141331);
        boolean bool = s.a(s.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
        AppMethodBeat.o(141331);
        return bool;
      }
    };
    if ((locala.Hgn != 0) || (locala.Hoi != null))
    {
      if (locala.Hgp == null) {
        locala.Hgp = View.inflate(this.mContext, 2131492920, null);
      }
      localObject2 = (ImageView)locala.Hgp.findViewById(2131299154);
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      this.HfR = ((WeImageView)locala.Hgp.findViewById(2131296376));
      this.HfR.setVisibility(0);
      label473:
      PorterDuff.Mode localMode;
      if (locala.Hoi != null)
      {
        this.HfR.setImageDrawable(locala.Hoi);
        if (this.HnG == 0) {
          break label736;
        }
        localObject2 = this.HfR;
        int i = this.HnG;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, i);
        label503:
        this.HfR.setOnClickListener(local20);
        this.HfR.setEnabled(locala.enable);
        this.HfR.setContentDescription(locala.text);
        if (locala.qQj != null) {
          this.HfR.setOnLongClickListener(local2);
        }
        this.HnH = ((ImageView)locala.Hgp.findViewById(2131299183));
        if (this.HnH != null)
        {
          if (!locala.Hok) {
            break label795;
          }
          this.HnH.setVisibility(0);
        }
      }
      for (;;)
      {
        localMenuItem.setActionView(locala.Hgp);
        localMenuItem.setEnabled(locala.enable);
        localMenuItem.setVisible(locala.visible);
        localMenuItem.setShowAsAction(2);
        if (locala.Hgn == 2131233291)
        {
          this.HnW = locala;
          this.HnX = localMenuItem;
        }
        ac.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.Hgm), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
        break;
        this.HfR.setImageResource(locala.Hgn);
        break label473;
        label736:
        if (locala.Hoh != 0) {
          break label503;
        }
        if (this.Hga)
        {
          localObject2 = this.HfR;
          localMode = PorterDuff.Mode.SRC_ATOP;
          a((WeImageView)localObject2, -1);
          break label503;
        }
        localObject2 = this.HfR;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, -16777216);
        break label503;
        label795:
        this.HnH.setVisibility(8);
      }
    }
    if (locala.Hgo == null) {
      locala.Hgo = View.inflate(this.mContext, 2131492920, null);
    }
    this.HfT = ((TextView)locala.Hgo.findViewById(2131296377));
    this.HfT.setVisibility(0);
    this.qBE = ((Button)locala.Hgo.findViewById(2131296374));
    this.qBE.setVisibility(8);
    this.HnL = locala.Hgo.findViewById(2131296600);
    this.HnL.setVisibility(8);
    if ((locala.Hoj == b.Hon) || (locala.Hoj == b.Hoq))
    {
      this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131100801));
      this.qBE.setVisibility(0);
      this.qBE.setBackgroundResource(2131231371);
      this.HfT.setVisibility(8);
    }
    for (;;)
    {
      this.HfT.setText(locala.text);
      if (locala.textColor != 0) {
        this.HfT.setTextColor(locala.textColor);
      }
      this.HfT.setOnClickListener(local20);
      this.HfT.setOnLongClickListener(local2);
      this.HfT.setEnabled(locala.enable);
      this.HfT.setOnTouchListener((View.OnTouchListener)localObject2);
      this.qBE.setText(locala.text);
      this.qBE.setOnClickListener(local20);
      this.qBE.setOnLongClickListener(local2);
      this.qBE.setOnTouchListener((View.OnTouchListener)localObject2);
      this.qBE.setEnabled(locala.enable);
      localMenuItem.setActionView(locala.Hgo);
      break;
      if (locala.Hoj == b.Hor)
      {
        this.qBE.setVisibility(0);
        this.qBE.setBackgroundResource(2131231372);
        this.qBE.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131101180));
        this.HfT.setVisibility(8);
      }
      else if (locala.Hoj == b.Hom)
      {
        this.qBE.setVisibility(0);
        this.qBE.setBackgroundResource(2131231366);
        this.qBE.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131100161));
        this.HfT.setVisibility(8);
      }
      else
      {
        if (locala.Hoj != b.Hoo)
        {
          if (locala.Hoj == b.Hot)
          {
            this.HfT.setTextColor(this.Hnw.getResources().getColor(2131100585));
            continue;
          }
          if (locala.Hoj == b.Hos)
          {
            this.HfT.setTextColor(this.Hnw.getResources().getColor(2131100800));
            continue;
          }
          if (locala.Hoj == b.How)
          {
            this.qBE.setVisibility(0);
            this.qBE.setBackgroundResource(2131231376);
            this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131100161));
            this.HfT.setVisibility(8);
            continue;
          }
          if (b.Hoy == locala.Hoj)
          {
            ac.i("MicroMsg.MMActivityController", "dark green mode.");
            this.qBE.setVisibility(0);
            this.qBE.setBackgroundResource(2131231363);
            this.qBE.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131100397));
            this.HfT.setVisibility(8);
            continue;
          }
          if (locala.Hoj == b.Hox)
          {
            this.qBE.setVisibility(0);
            this.qBE.setBackgroundResource(2131231369);
            this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131100161));
            this.HfT.setVisibility(8);
            continue;
          }
          if (b.Hoz == locala.Hoj)
          {
            ac.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.Hnx) });
            this.HfT.setVisibility(8);
            if (this.Hnx)
            {
              this.HnL.setVisibility(0);
              this.HnL.setOnClickListener(local20);
              continue;
            }
            if (8 == this.HnL.getVisibility()) {
              this.HnL.setVisibility(4);
            }
            for (;;)
            {
              this.HnL.setOnClickListener(null);
              break;
              if (this.HnL.getVisibility() == 0) {
                this.HnL.animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
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
          if (this.HnG != 0)
          {
            this.HfT.setTextColor(this.HnG);
            continue;
          }
          if (this.Hga)
          {
            this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131101185));
            continue;
          }
        }
        this.HfT.setTextColor(com.tencent.mm.cc.a.m(this.Hnw, 2131100024));
      }
    }
    label1701:
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.Xj();
    com.tencent.mm.compatible.b.g.Xj();
    if ((this.Hny) && (this.fzp != null) && (this.fzp.onKeyDown(paramInt, paramKeyEvent)))
    {
      ac.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.Hga) {
        setActionbarColor(this.Hnw.getResources().getColor(2131100196));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.Hnw.getResources().getColor(2131100705));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.HnW != null) && (this.HnW.enable)) {
        a(this.HnX, this.HnW);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ac.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.Hnk)
    {
      ac.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.Hnz.Hgm) && (this.Hnz.enable))
    {
      a(paramMenuItem, this.Hnz);
      return true;
    }
    Iterator localIterator = this.Hgd.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.Hgm)
      {
        ac.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        return true;
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    activateBroadcast(false);
    com.tencent.mm.sdk.b.a.GpY.d(this.HnP);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ac.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.Hny) && (this.fzp != null)) {
      this.fzp.a(this.Hnw, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    com.tencent.mm.sdk.b.a.GpY.c(this.HnP);
    Object localObject = new ap();
    ((ap)localObject).cZT.type = 2;
    ((ap)localObject).cZT.position = this.HnN;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    String str;
    int i;
    if (((ap)localObject).cZU.cZY == 2)
    {
      l = System.currentTimeMillis();
      str = ((ap)localObject).cZU.daa;
      i = ((ap)localObject).cZU.position;
      ac.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.HnN)) {
        break label432;
      }
      ac.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.HnN) });
    }
    for (;;)
    {
      ac.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT) && (!ai.getContext().getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cc.a.eb(ai.getContext())) {
          break;
        }
        if (1.0F != ai.getContext().getResources().getConfiguration().fontScale)
        {
          h.wUl.f(15181, new Object[] { Integer.valueOf(1) });
          localObject = new f.a(ai.getContext());
          ((f.a)localObject).av(this.Hnw.getResources().getString(2131759585)).aRQ(this.Hnw.getResources().getString(2131759582)).aRU(this.Hnw.getResources().getString(2131759584)).aRV(this.Hnw.getResources().getString(2131759583));
          ((f.a)localObject).c(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(141349);
              if (paramAnonymousBoolean)
              {
                h.wUl.f(15181, new Object[] { Integer.valueOf(3) });
                Object localObject = new Intent();
                ((Intent)localObject).setClassName(ai.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                ((Intent)localObject).addFlags(268435456);
                paramAnonymousString = ai.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(141349);
                return;
              }
              h.wUl.f(15181, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(141349);
            }
          }).show();
          ai.getContext().getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label432:
      a(((ap)localObject).cZU.cZZ, ((ap)localObject).cZU.visible, ((ap)localObject).cZU.url, ((ap)localObject).cZU.desc, str, i, true);
    }
    ai.getContext().getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
  }
  
  public final void onStart()
  {
    this.landscapeMode = this.mContext.getSharedPreferences(ai.eUX(), 0).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      this.Hnw.setRequestedOrientation(-1);
      return;
    }
    this.Hnw.setRequestedOrientation(1);
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
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.YJ())) {}
    for (;;)
    {
      if (((paramActivity instanceof MMActivity)) && (((MMActivity)paramActivity).fixStatusbar) && (((MMActivity)paramActivity).isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.statusbar.a.e(this.contentView, paramInt, d.e(paramActivity.getWindow()));
      }
      for (;;)
      {
        setNavigationbarColor(ao.aJ(this.Hnw, 2130968578));
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
    if (this.Hgd.isEmpty()) {
      return;
    }
    this.Hgd.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.Hgd.size())
      {
        if (((a)this.Hgd.get(i)).Hgm == paramInt)
        {
          ac.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.Hgd.remove(i);
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
    this.HfQ = paramInt;
    this.Hga = am.ZN(this.HfQ);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.HfQ));
    q(this.Hnw, this.HfQ);
    fgI();
    fgH();
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
        if (this.HnE.getDrawable() == null) {
          i = 2131689490;
        }
      }
      if ((this.HnE != null) && (i != 0)) {
        this.HnE.setImageResource(i);
      }
      this.Hnz.Hgm = 16908332;
      this.Hnz.iPc = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.HnD != null) {
        this.HnD.setOnClickListener(new View.OnClickListener()
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
                s.9.this.Hgf.onMenuItemClick(null);
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
    if (this.HnE != null) {
      this.HnE.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.HnE == null) {
      return;
    }
    if (paramBoolean)
    {
      this.HnE.setVisibility(0);
      return;
    }
    this.HnE.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.Hnj == null) {
      this.Hnj = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    this.Hnj.setBackgroundResource(paramInt);
    this.Hng.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.Hnj == null) {
      this.Hnj = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.Hnh != null) {
      this.Hnj.removeView(this.Hnh);
    }
    this.Hnj.removeView(this.Hng);
    this.Hng = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.Hnj.addView(this.Hng, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.Hnh != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.b.g(this.mContext, 47.0F));
      this.Hnj.addView(this.Hnh, this.Hnj.getChildCount(), localLayoutParams);
    }
    this.Hnj.invalidate();
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.HnD != null)
    {
      this.HnD.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.HnD.setEnabled(false);
    }
    for (;;)
    {
      if (this.HfR != null)
      {
        this.HfR.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.HfR.setEnabled(false);
      }
      return;
      label59:
      this.HnD.setEnabled(true);
    }
    this.HfR.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      bb(this.Hnw);
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
        this.mActionBar.setCustomView(HnR);
        localTextView = (TextView)this.mActionBar.getCustomView().findViewById(2131296348);
      } while (localTextView == null);
      localTextView.clearAnimation();
      if (paramAnimation != null) {
        localTextView.startAnimation(paramAnimation);
      }
    } while (bs.isNullOrNil(paramString));
    localTextView.setText(paramString);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.mBI.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cc.a.id(this.Hnw))
    {
      this.mBI.setTextSize(1, 14.0F);
      this.HnC.setTextSize(1, 18.0F);
    }
    this.mBI.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.mBI.setVisibility(8);
      return;
    }
    this.mBI.setText(paramString);
    if (com.tencent.mm.cc.a.id(this.Hnw))
    {
      this.mBI.setTextSize(1, 14.0F);
      this.HnC.setTextSize(1, 18.0F);
    }
    this.mBI.setVisibility(0);
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
    this.Hnl = paramCharSequence.toString();
    this.HnC.setText(paramCharSequence);
    if (com.tencent.mm.cc.a.id(this.Hnw)) {
      this.HnC.setTextSize(0, com.tencent.mm.cc.a.av(this.Hnw, 2131165184) * com.tencent.mm.cc.a.ib(this.Hnw));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.Hnl = paramString;
    if (com.tencent.mm.cc.a.id(this.Hnw)) {
      this.HnC.setTextSize(0, com.tencent.mm.cc.a.av(this.Hnw, 2131165184) * com.tencent.mm.cc.a.ib(this.Hnw));
    }
    fgG();
    updateDescription(paramString);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.HnC.setVisibility(paramInt);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!fgJ()))
    {
      this.Hnw.getWindow().setNavigationBarColor(paramInt);
      boolean bool = am.ZN(paramInt);
      localView = this.Hnw.getWindow().getDecorView();
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
    this.Hnk = paramBoolean;
    if ((this.Hnf == null) && (this.contentView != null)) {
      this.Hnf = this.contentView.findViewById(2131302342);
    }
    if (this.Hnf == null)
    {
      ac.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.Hnf;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.Hnf;
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
      jy(this.Hnw);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    q(this.Hnw, paramInt);
    updataStatusBarIcon(am.ZN(paramInt));
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
        if (SystemClock.elapsedRealtime() - s.l(s.this) < 300L) {
          paramRunnable.run();
        }
        s.a(s.this, SystemClock.elapsedRealtime());
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
      this.Hnm = 0;
      this.Hno = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.Hnn = 0;
      this.Hnp = null;
    }
    for (;;)
    {
      fgG();
      return;
      if (this.Hnm == paramInt1) {
        break;
      }
      this.Hnm = paramInt1;
      this.Hno = jp(this.mContext.getResources().getDimensionPixelSize(2131165192), this.Hnm);
      break;
      label82:
      if (this.Hnn != paramInt2)
      {
        this.Hnn = paramInt2;
        this.Hnp = jp(this.mContext.getResources().getDimensionPixelSize(2131165192), this.Hnn);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Hnt = bool;
      fgG();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Hnv = bool;
      fgG();
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
      q(this.Hnw, this.HfQ);
      return;
    }
    this.mActionBar.hide();
    q(this.Hnw, this.Hnw.getResources().getColor(2131100017));
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
    } while (this.HnD == null);
    View localView = this.HnD;
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
      ac.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    this.Hnw.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.Hnw.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      ac.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", new Object[] { Boolean.valueOf(paramBoolean) });
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
    while ((this.HnE == null) || (paramDrawable == null)) {
      return;
    }
    this.HnE.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.fhP().l(this.Hnw, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = Zx(paramInt1);
    if ((locala != null) && (locala.Hgn != paramInt2))
    {
      locala.Hgn = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = Zx(paramInt);
    if (locala != null)
    {
      locala.iPc = paramOnMenuItemClickListener;
      locala.qQj = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = Zx(paramInt);
    if ((locala != null) && (locala.Hok != paramBoolean))
    {
      locala.Hok = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = Zx(paramInt);
    if ((locala != null) && (!bs.bG(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void wz(boolean paramBoolean)
  {
    this.Hga = paramBoolean;
    fgI();
    fgH();
  }
  
  public static final class a
  {
    public int Hgm = -1;
    public int Hgn;
    public View Hgo;
    public View Hgp;
    public int Hoh = 0;
    public Drawable Hoi;
    public s.b Hoj = s.b.Hol;
    public boolean Hok = false;
    public boolean enable = true;
    public MenuItem.OnMenuItemClickListener iPc;
    public View.OnLongClickListener qQj;
    public View.OnTouchListener sOi;
    public String text;
    public int textColor;
    public boolean visible = true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      Hol = new b("NORMAL", 0);
      Hom = new b("GREEN", 1);
      Hon = new b("RED", 2);
      Hoo = new b("BLACK", 3);
      Hop = new b("TRANSPARENT", 4);
      Hoq = new b("TRANSPARENT_RED_TEXT", 5);
      Hor = new b("TRANSPARENT_GREEN_TEXT", 6);
      Hos = new b("GOLDEN", 7);
      Hot = new b("TRANSPARENT_GOLD_TEXT", 8);
      Hou = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      Hov = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      How = new b("YELLOW", 11);
      Hox = new b("ORANGE", 12);
      Hoy = new b("DARK_GREEN_MODE", 13);
      Hoz = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      HoA = new b[] { Hol, Hom, Hon, Hoo, Hop, Hoq, Hor, Hos, Hot, Hou, Hov, How, Hox, Hoy, Hoz };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */