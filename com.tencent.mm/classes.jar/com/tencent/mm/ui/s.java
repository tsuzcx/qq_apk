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
import com.tencent.mm.g.a.xf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static boolean JvO = false;
  private static final int Jwf = 2131492928;
  public static long Jwh;
  private static byte[] Jwj = { 0 };
  private static PowerManager.WakeLock wakeLock = null;
  private final long ABq = 300L;
  private long ABr = SystemClock.elapsedRealtime();
  public View CbM;
  private int EhG = 0;
  View JnN;
  WeImageView JnP;
  TextView JnR;
  private boolean JnY = false;
  int JnZ;
  private int Joa;
  LinkedList<a> Job = new LinkedList();
  private int JvA = 0;
  private int JvB = 0;
  private com.tencent.mm.ui.widget.a JvC = null;
  private com.tencent.mm.ui.widget.a JvD = null;
  private com.tencent.mm.ui.widget.a JvE = null;
  private com.tencent.mm.ui.widget.a JvF = null;
  private com.tencent.mm.ui.widget.a JvG = null;
  private boolean JvH = false;
  boolean JvI = false;
  private boolean JvJ = false;
  public AppCompatActivity JvK;
  boolean JvL = false;
  private boolean JvM;
  private a JvN = new a();
  ArrayList<Dialog> JvP;
  public TextView JvQ;
  View JvR;
  WeImageView JvS;
  ProgressBar JvT;
  int JvU = 0;
  private ImageView JvV;
  private ViewGroup.LayoutParams JvW;
  View JvX;
  AlbumChooserView JvY;
  private View JvZ;
  private View Jvu;
  private View Jvv;
  private TextView Jvw;
  private FrameLayout Jvx;
  public boolean Jvy = true;
  private String Jvz = " ";
  public boolean Jwa = true;
  private int Jwb = 0;
  private boolean Jwc = false;
  private c Jwd = new c() {};
  private int Jwe = 2131492926;
  private int Jwg = -1;
  int Jwi = 0;
  private a Jwk;
  private MenuItem Jwl;
  private Runnable Jwm = new Runnable()
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
  private Runnable Jwn = new Runnable()
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
  private View actionbarView;
  int bIc = this.JnZ;
  String className;
  View contentView;
  private r fUI;
  private boolean gtO = false;
  private AudioManager ize;
  private LayoutInflater jiz;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  TextView nhr;
  private Button rtz;
  public int statusBarColor = -1;
  protected com.tencent.mm.sdk.platformtools.aq tvo = new com.tencent.mm.sdk.platformtools.aq(Looper.getMainLooper());
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.JnY) {
      localDrawable = ao.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, aq.ay(this.JvK, 2131165289), aq.ay(this.JvK, 2131165289));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable);
    paramDrawable.LmE = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.Jok = paramInt1;
    locala.Jol = paramInt2;
    locala.text = paramString;
    locala.jle = paramOnMenuItemClickListener;
    locala.rIu = paramOnLongClickListener;
    locala.Jwx = paramb;
    locala.Jwy = paramBoolean;
    if ((locala.Jol == 2131233291) && (bu.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(2131755815);
    }
    aco(locala.Jok);
    this.Job.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.Jok = paramInt;
    locala.Jww = paramDrawable;
    locala.text = paramString;
    locala.jle = paramOnMenuItemClickListener;
    locala.rIu = null;
    locala.Jwx = paramb;
    aco(locala.Jok);
    this.Job.add(locala);
    new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
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
    ae.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.Jvv });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.Jvv == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      ae.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.Jvx == null) {
      this.Jvx = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.Jvv != null) {
      this.Jvx.removeView(this.Jvv);
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.Jvv = this.jiz.inflate(paramInt1, null);
      this.Jvw = ((TextView)this.Jvv.findViewById(2131302969));
      this.Jvv.findViewById(2131302964).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new ap();
          paramAnonymousView.dmn.type = 1;
          paramAnonymousView.dmn.dmp = paramString3;
          paramAnonymousView.dmn.position = paramInt2;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
          s.b(s.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141341);
        }
      });
      this.Jvv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141343);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (paramString1 != null)
          {
            localObject = new Intent("android.intent.action.VIEW");
            ((Intent)localObject).setData(Uri.parse(paramString1));
            paramAnonymousView = s.c(s.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141343);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.Jwc) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.h(this.JvK, 48.0F), 0, 0);
        ae.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.Jvx.addView(this.Jvv, this.Jvx.getChildCount(), paramString3);
      if (this.Jvv == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.Jvv;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(2131760318);
          paramString3 = paramString2;
          if (bu.isNullOrNil(paramString2)) {
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
          this.Jvw.setText(paramString1);
        }
        for (;;)
        {
          this.Jvv.invalidate();
          this.Jvx.invalidate();
          return;
          paramInt1 = 8;
          break;
          label488:
          ae.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.Jvw.setText(paramString3);
        }
      }
      this.Jvv.post(new Runnable()
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
            if (!bu.isNullOrNil(paramString2)) {
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
            ae.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
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
    if (!this.Jvy) {
      ae.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.jle == null) {
      return;
    }
    parama.jle.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.Jwa)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.clearColorFilter();
  }
  
  private static boolean aWS(String paramString)
  {
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {}
    while ((!mq(str1, paramString)) && (!mq(str2, paramString))) {
      return false;
    }
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
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131764538))));
    return true;
  }
  
  private void b(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.Jwa)
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
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131759747))));
    return true;
  }
  
  private static boolean bb(Activity paramActivity)
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
  
  private void bc(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      ae.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.EhG == 0) {
        this.EhG = fAS();
      }
      this.JnY = ao.acF(this.EhG);
      setActionbarColor(this.EhG);
      this.mActionBar.setLogo(new ColorDrawable(this.JvK.getResources().getColor(17170445)));
      this.mActionBar.gm();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.gl();
      this.mActionBar.gn();
      this.mActionBar.gk();
      if (this.Jwg != -1) {
        break label370;
      }
      localView = z.jV(this.JvK).inflate(this.Jwe, new LinearLayout(this.JvK), false);
      this.mActionBar.setCustomView(localView);
      this.JvQ = ((TextView)findViewById(16908308));
      this.nhr = ((TextView)findViewById(16908309));
      this.JnN = findViewById(2131305937);
      this.JvT = ((ProgressBar)findViewById(2131303518));
      this.JvR = findViewById(2131296416);
      this.JvS = ((WeImageView)findViewById(2131296417));
      this.JvR.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(141348);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            s.Jwh = System.currentTimeMillis();
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/MMActivityController$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(141348);
          return false;
        }
      });
      if (this.JvS != null) {
        this.JvS.setContentDescription(this.JvK.getString(2131755281));
      }
      if (this.JvQ != null) {
        this.JvQ.setText(2131755822);
      }
      this.JvX = findViewById(2131296408);
      this.JvY = ((AlbumChooserView)findViewById(2131296394));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label408;
      }
      if (this.JvS != null) {
        this.JvS.setVisibility(0);
      }
      if (this.JvR != null) {
        this.JvR.setVisibility(0);
      }
    }
    for (;;)
    {
      fAV();
      return;
      label370:
      localView = z.jV(this.JvK).inflate(this.Jwg, new LinearLayout(this.JvK), false);
      this.mActionBar.setCustomView(localView);
      break;
      label408:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.JvS != null) {
          this.JvS.setVisibility(0);
        }
        if (this.JvR != null) {
          this.JvR.setVisibility(0);
        }
        if (this.JvQ != null)
        {
          this.JvQ.setVisibility(0);
          al.a(this.JvQ.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.JvS != null) {
          this.JvS.setVisibility(8);
        }
        if (this.JvR != null) {
          this.JvR.setVisibility(8);
        }
      }
    }
  }
  
  public static boolean fAT()
  {
    for (;;)
    {
      synchronized (Jwj)
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
  
  private void fAV()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.JnY)
    {
      if (this.JvS != null)
      {
        localWeImageView = this.JvS;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.JvQ != null) && (this.JvQ.getVisibility() == 0)) {
        this.JvQ.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.nhr != null) && (this.nhr.getVisibility() == 0)) {
        this.nhr.setTextColor(this.mContext.getResources().getColor(2131099886));
      }
      if ((this.JnP != null) && (this.JnP.getVisibility() == 0)) {
        if (this.JnP.getDrawable() != null) {
          b(this.JnP.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.JnP;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.JnR == null) || (this.JnR.getVisibility() != 0));
      this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131101185));
      return;
      if (this.JvS != null)
      {
        localWeImageView = this.JvS;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
      }
      if ((this.JvQ != null) && (this.JvQ.getVisibility() == 0)) {
        this.JvQ.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.nhr != null) && (this.nhr.getVisibility() == 0)) {
        this.nhr.setTextColor(this.mContext.getResources().getColor(2131099820));
      }
      if ((this.JnP != null) && (this.JnP.getVisibility() == 0))
      {
        if (this.JnP.getDrawable() != null)
        {
          b(this.JnP.getDrawable(), -16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        localWeImageView = this.JnP;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
        return;
      }
    } while ((this.JnR == null) || (this.JnR.getVisibility() != 0));
    this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131100024));
  }
  
  private void fAW()
  {
    updataStatusBarIcon(this.JnY);
  }
  
  private static boolean fAX()
  {
    return (aWS("y83a")) || (aWS("y83")) || (aWS("v1732a")) || (aWS("v1732t"));
  }
  
  public static boolean fAY()
  {
    return fAX();
  }
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.JvK.findViewById(paramInt);
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return initLanguage(paramContext, ad.f(paramContext.getSharedPreferences(ak.fow(), 0)));
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      ad.a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = ad.aRN(paramString);
    ad.a(paramContext, paramString);
    return paramString;
  }
  
  private com.tencent.mm.ui.widget.a jF(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.JnY) {
      localDrawable = ao.k(this.JvK, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.LmE = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private void jQ(Context paramContext)
  {
    synchronized (Jwj)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(32, "screen Lock");
      }
      if (!wakeLock.isHeld())
      {
        wakeLock.acquire();
        ae.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      ae.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  private static boolean mq(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return bu.lX(paramString1.toLowerCase(), paramString2.toLowerCase());
  }
  
  private void releaseWakeLock()
  {
    synchronized (Jwj)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        wakeLock.release();
        ae.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        wakeLock = null;
        return;
      }
      ae.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  public static void setMainProcess()
  {
    JvO = true;
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
    this.JvK = paramAppCompatActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = this.JvK.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      this.JvK.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    if (!noActionBar())
    {
      boolean bool = ak.getContext().getSharedPreferences(ak.fow() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
      ak.getContext().getSharedPreferences(ak.fow() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (!bool)
      {
        ak.getContext().getSharedPreferences(ak.fow() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
        ak.getContext().getSharedPreferences(ak.fow() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
      }
    }
    this.gtO = al.j(paramAppCompatActivity.getResources());
    int i;
    label448:
    label582:
    label736:
    long l;
    if (paramAppCompatActivity != null)
    {
      if (!this.gtO) {
        break label1026;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && ((aZ(paramAppCompatActivity)) || (((MMActivity)paramAppCompatActivity).transparentTheme))) {
        paramAppCompatActivity.setTheme(2131820572);
      }
    }
    else
    {
      onCreateBeforeSetContentView();
      this.className = getClass().getName();
      aj.cQ(3, this.className);
      initLanguage(paramContext);
      this.ize = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.jiz = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.a.b.akR();
        this.contentView = com.tencent.mm.kiss.a.b.c(paramAppCompatActivity, 2131494760);
      }
      this.Jvu = this.contentView.findViewById(2131302342);
      this.Jvx = ((FrameLayout)this.contentView.findViewById(2131302320));
      if (i != -1)
      {
        this.CbM = getLayoutView();
        if (this.CbM != null) {
          break label1118;
        }
        this.CbM = this.jiz.inflate(getLayoutId(), null);
        this.Jvx.addView(this.CbM, 0);
      }
      dealContentView(this.contentView);
      if (fromFullScreenActivity())
      {
        al.n(al.a(this.JvK.getWindow(), this.CbM), this.CbM);
        ((ViewGroup)this.CbM.getParent()).removeView(this.CbM);
        ((ViewGroup)this.JvK.getWindow().getDecorView()).addView(this.CbM, 0);
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label1148;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165251);
        this.CbM.setPadding(this.CbM.getPaddingLeft(), i + (j + this.CbM.getPaddingTop()), this.CbM.getPaddingRight(), this.CbM.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      ae.d("MicroMsg.MMActivityController", "onCreate, before.");
      bc(paramAppCompatActivity);
      if (!noActionBar())
      {
        this.JnZ = aq.ay(this.mContext, 2131165252);
        this.Joa = aq.ay(this.mContext, 2131165559);
      }
      if (this.Jvx != null) {
        this.Jvx.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(141345);
            s.e(s.this).removeOnAttachStateChangeListener(this);
            com.tencent.mm.kiss.a.b.akS();
            AppMethodBeat.o(141345);
          }
        });
      }
      if ((this.Jvx == null) || (!(this.Jvx instanceof LayoutListenerView))) {
        break label1165;
      }
      ((LayoutListenerView)this.Jvx).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int Jwu;
        
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
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.Jwu))
            {
              s.g(s.this);
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.Jwu)) {
              s.h(s.this);
            }
          }
          AppMethodBeat.o(141347);
        }
      });
      paramContext = new ap();
      paramContext.dmn.type = 2;
      paramContext.dmn.position = this.Jwb;
      com.tencent.mm.sdk.b.a.IvT.l(paramContext);
      if (paramContext.dmo.dms == 2)
      {
        l = System.currentTimeMillis();
        localObject = paramContext.dmo.dmu;
        i = paramContext.dmo.position;
        ae.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject, bu.fpN() });
        if ((i <= 0) || (i == this.Jwb)) {
          break label1177;
        }
        ae.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Jwb) });
      }
    }
    for (;;)
    {
      ae.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
      {
        if (this.EhG == 0) {
          this.EhG = fAS();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        q(paramAppCompatActivity, this.EhG);
        fAW();
      }
      return;
      if (((paramAppCompatActivity instanceof MMActivity)) && (bb(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820571);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (ba(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820570);
        break;
      }
      paramAppCompatActivity.setTheme(2131820569);
      break;
      label1026:
      if (((paramAppCompatActivity instanceof MMActivity)) && ((((MMActivity)paramAppCompatActivity).transparentTheme) || (aZ(paramAppCompatActivity))))
      {
        paramAppCompatActivity.setTheme(2131820577);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (bb(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820576);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (ba(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820575);
        break;
      }
      paramAppCompatActivity.setTheme(2131820574);
      break;
      label1118:
      if (this.CbM.getParent() == null) {
        break label448;
      }
      ((ViewGroup)this.CbM.getParent()).removeView(this.CbM);
      break label448;
      label1148:
      i = this.mContext.getResources().getDimensionPixelSize(2131165252);
      break label582;
      label1165:
      ae.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label736;
      label1177:
      a(paramContext.dmo.dmt, paramContext.dmo.visible, paramContext.dmo.url, paramContext.dmo.desc, (String)localObject, i, true);
    }
  }
  
  public final void a(a parama)
  {
    aco(parama.Jok);
    this.Job.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  final boolean aco(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.Job.size())
      {
        if (((a)this.Job.get(i)).Jok == paramInt)
        {
          ae.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.Job.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a acp(int paramInt)
  {
    Iterator localIterator = this.Job.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.Jok == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void acq(int paramInt)
  {
    if (noActionBar()) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > this.JnZ) {
        i = this.JnZ;
      }
      paramInt = i;
      if (i < this.Joa) {
        paramInt = this.Joa;
      }
      this.bIc = paramInt;
      this.actionbarView = this.JvK.getWindow().getDecorView().findViewById(2131296345);
      if (this.actionbarView != null) {
        this.JvW = this.actionbarView.getLayoutParams();
      }
      if ((this.actionbarView != null) && (this.JvW != null))
      {
        this.JvW.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
        this.actionbarView.setLayoutParams(this.JvW);
      }
      float f1 = Math.min(com.tencent.mm.cb.a.ef(this.JvK), com.tencent.mm.cb.a.ip(this.JvK));
      i = (int)(aq.ay(this.mContext, 2131165570) * f1);
      int j = (int)(f1 * aq.ay(this.mContext, 2131165518));
      int k = aq.fromDPToPix(this.mContext, 14);
      f1 = (paramInt - this.Joa) / (this.JnZ - this.Joa);
      float f2 = i;
      float f3 = j - i;
      setIconAlpha(f1);
      paramInt = (int)((k - aq.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
      i = (int)((this.Joa - this.JnZ) / 2.0F * (1.0F - f1));
      if (this.JvQ != null)
      {
        this.JvQ.setTextSize(0, f3 * f1 + f2);
        if (this.JnN != null)
        {
          this.JnN.setTranslationX(paramInt);
          this.JnN.setTranslationY(i);
        }
      }
      if (this.JvS != null) {
        this.JvS.setTranslationY(i);
      }
    } while (this.JnP == null);
    this.JnP.setTranslationY(i);
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    if ((!JvO) && (paramBoolean))
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
    if (this.JvP == null) {
      this.JvP = new ArrayList();
    }
    this.JvP.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.Jwz);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Jwz);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.Jwz);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.Jwz);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Jwz);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.Jwz);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.Jwz);
  }
  
  public final void addSearchMenu(boolean paramBoolean, r paramr)
  {
    ae.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.Jok = 2131302248;
    locala.text = this.mContext.getString(2131755882);
    locala.Jol = 2131689494;
    locala.jle = null;
    locala.rIu = null;
    removeOptionMenu(locala.Jok);
    this.Job.add(0, locala);
    this.JvM = paramBoolean;
    this.fUI = paramr;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.Jwz);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.Jwz);
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
      localIterator = this.Job.iterator();
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
      localIterator = this.Job.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.Jok != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fUI == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fUI.Lhf)
        {
          if (!paramBoolean1) {
            supportInvalidateOptionsMenu();
          }
          ae.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final void bk(int paramInt, boolean paramBoolean)
  {
    this.Jwb = paramInt;
    this.Jwc = paramBoolean;
  }
  
  final void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.Job.iterator();
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
      localIterator = this.Job.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.Jok != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.fUI == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.fUI.Lhf)
        {
          if ((bool) && (!paramBoolean1)) {
            supportInvalidateOptionsMenu();
          }
          ae.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final boolean callBackMenu()
  {
    if ((this.JvN != null) && (this.JvN.enable))
    {
      a(null, this.JvN);
      return true;
    }
    return false;
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.JvN == null) {}
    while (this.JvN.enable == paramBoolean) {
      return;
    }
    this.JvN.enable = paramBoolean;
    supportInvalidateOptionsMenu();
  }
  
  public final int fAS()
  {
    this.JnY = false;
    if (this.EhG == 0) {
      this.EhG = this.mContext.getResources().getColor(2131100705);
    }
    return this.EhG;
  }
  
  final void fAU()
  {
    Object localObject1 = "%s";
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131165184);
    if (this.JvA != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.JvB != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int j = 1;; j = 0)
    {
      if ((!this.JvI) && (this.JvH))
      {
        localObject1 = (String)localObject1 + " #";
        j += 2;
      }
      for (int i = 1;; i = 0)
      {
        if (this.JvI)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
        }
        for (int k = 1;; k = 0)
        {
          int n;
          int m;
          if (this.JvJ)
          {
            localObject1 = (String)localObject1 + " #";
            n = i + 2;
            i = 1;
            m = j + 2;
            j = n;
          }
          for (;;)
          {
            Object localObject2 = String.format((String)localObject1, new Object[] { this.Jvz });
            ae.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
            localObject1 = com.tencent.mm.ui.f.c.b.h(this.mContext, (CharSequence)localObject2, i1);
            if ((localObject1 instanceof SpannableString))
            {
              localObject2 = (SpannableString)localObject1;
              if (this.JvA != 0) {
                ((SpannableString)localObject2).setSpan(this.JvC, 0, 1, 33);
              }
              if (this.JvB != 0)
              {
                m = ((SpannableString)localObject2).length() - m;
                ((SpannableString)localObject2).setSpan(this.JvD, m, m + 1, 33);
              }
              if (this.JvI)
              {
                if (this.JvF == null) {
                  this.JvF = jF(i1, 2131689877);
                }
                k = ((SpannableString)localObject2).length() - k;
                ((SpannableString)localObject2).setSpan(this.JvF, k, k + 1, 33);
              }
              if ((!this.JvI) && (this.JvH))
              {
                if (this.JvE == null) {
                  this.JvE = a(i1, ao.k(this.JvK, 2131690523, this.JvK.getResources().getColor(2131099982)));
                }
                j = ((SpannableString)localObject2).length() - j;
                ((SpannableString)localObject2).setSpan(this.JvE, j, j + 1, 33);
              }
              if (this.JvJ)
              {
                if (this.JvG == null) {
                  this.JvG = jF(i1, 2131689880);
                }
                i = ((SpannableString)localObject2).length() - i;
                ((SpannableString)localObject2).setSpan(this.JvG, i, i + 1, 33);
              }
            }
            this.JvQ.setText((CharSequence)localObject1);
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
      this.tvo.removeCallbacks(this.Jwn);
      this.tvo.removeCallbacks(this.Jwm);
      this.tvo.postDelayed(this.Jwm, 256L);
      return;
    }
    this.JvK.getWindow().clearFlags(1024);
    this.tvo.removeCallbacks(this.Jwm);
    this.tvo.removeCallbacks(this.Jwn);
    this.tvo.postDelayed(this.Jwn, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.tvo.removeCallbacks(this.Jwn);
      this.tvo.removeCallbacks(this.Jwm);
      this.tvo.postDelayed(this.Jwm, paramLong);
      return;
    }
    this.JvK.getWindow().clearFlags(1024);
    this.tvo.removeCallbacks(this.Jwm);
    this.tvo.removeCallbacks(this.Jwn);
    this.tvo.postDelayed(this.Jwn, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.JvK.getWindow().setFlags(1024, 1024);
      return;
    }
    this.JvK.getWindow().clearFlags(1024);
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
    if (this.Jvz != null) {
      return this.Jvz;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.ize.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.ize.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.JvK.getSupportActionBar();
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
    if (this.JvP != null)
    {
      int j = this.JvP.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.JvP.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.JvP.clear();
      this.JvP = null;
    }
  }
  
  public final void hideTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      ae.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    View localView = this.JvK.getCurrentFocus();
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
        ae.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
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
      ae.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return false;
      bool = false;
    }
    return this.mActionBar.isShowing();
  }
  
  public final void jR(Context paramContext)
  {
    com.tencent.mm.sdk.b.a.IvT.d(this.Jwd);
    hideAllManagedDialogs();
    com.tencent.mm.sdk.f.a.gC(paramContext);
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
    ae.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.Job.size()) });
    if ((this.mActionBar == null) || (this.Job.size() == 0))
    {
      ae.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.Job.size()) });
      return false;
    }
    this.Jwk = null;
    this.Jwl = null;
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
      localObject1 = this.Job.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1817;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.Jok != 16908332) {
          break;
        }
        ae.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label184:
      this.mContext.getResources().getDimensionPixelSize(2131165252);
    }
    if (locala.Jok == 2131302248)
    {
      boolean bool2 = this.JvM;
      if (this.fUI == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!this.JvM) || (this.fUI == null)) {
          break;
        }
        this.fUI.a(this.JvK, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.Jok, 0, locala.text);
    com.tencent.mm.compatible.g.a.a(localMenuItem, getClass().getName());
    View.OnClickListener local20 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141350);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = s.a(s.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(141331);
        return bool;
      }
    };
    if ((locala.Jol != 0) || (locala.Jww != null))
    {
      if (locala.Jon == null) {
        locala.Jon = View.inflate(this.mContext, 2131492920, null);
      }
      localObject2 = (ImageView)locala.Jon.findViewById(2131299154);
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      this.JnP = ((WeImageView)locala.Jon.findViewById(2131296376));
      this.JnP.setVisibility(0);
      label473:
      PorterDuff.Mode localMode;
      if (locala.Jww != null)
      {
        this.JnP.setImageDrawable(locala.Jww);
        if (this.JvU == 0) {
          break label736;
        }
        localObject2 = this.JnP;
        int i = this.JvU;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, i);
        label503:
        this.JnP.setOnClickListener(local20);
        this.JnP.setEnabled(locala.enable);
        this.JnP.setContentDescription(locala.text);
        if (locala.rIu != null) {
          this.JnP.setOnLongClickListener(local2);
        }
        this.JvV = ((ImageView)locala.Jon.findViewById(2131299183));
        if (this.JvV != null)
        {
          if (!locala.Jwy) {
            break label795;
          }
          this.JvV.setVisibility(0);
        }
      }
      for (;;)
      {
        localMenuItem.setActionView(locala.Jon);
        localMenuItem.setEnabled(locala.enable);
        localMenuItem.setVisible(locala.visible);
        localMenuItem.setShowAsAction(2);
        if (locala.Jol == 2131233291)
        {
          this.Jwk = locala;
          this.Jwl = localMenuItem;
        }
        ae.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.Jok), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
        break;
        this.JnP.setImageResource(locala.Jol);
        break label473;
        label736:
        if (locala.Jwv != 0) {
          break label503;
        }
        if (this.JnY)
        {
          localObject2 = this.JnP;
          localMode = PorterDuff.Mode.SRC_ATOP;
          a((WeImageView)localObject2, -1);
          break label503;
        }
        localObject2 = this.JnP;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, -16777216);
        break label503;
        label795:
        this.JvV.setVisibility(8);
      }
    }
    if (locala.Jom == null) {
      locala.Jom = View.inflate(this.mContext, 2131492920, null);
    }
    this.JnR = ((TextView)locala.Jom.findViewById(2131296377));
    this.JnR.setVisibility(0);
    this.rtz = ((Button)locala.Jom.findViewById(2131296374));
    this.rtz.setVisibility(8);
    this.JvZ = locala.Jom.findViewById(2131296600);
    this.JvZ.setVisibility(8);
    if ((locala.Jwx == b.JwB) || (locala.Jwx == b.JwE))
    {
      this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131100801));
      this.rtz.setVisibility(0);
      this.rtz.setBackgroundResource(2131231371);
      this.JnR.setVisibility(8);
    }
    for (;;)
    {
      this.JnR.setText(locala.text);
      if (locala.textColor != 0) {
        this.JnR.setTextColor(locala.textColor);
      }
      this.JnR.setOnClickListener(local20);
      this.JnR.setOnLongClickListener(local2);
      this.JnR.setEnabled(locala.enable);
      this.JnR.setOnTouchListener((View.OnTouchListener)localObject2);
      this.rtz.setText(locala.text);
      this.rtz.setOnClickListener(local20);
      this.rtz.setOnLongClickListener(local2);
      this.rtz.setOnTouchListener((View.OnTouchListener)localObject2);
      this.rtz.setEnabled(locala.enable);
      localMenuItem.setActionView(locala.Jom);
      break;
      if (locala.Jwx == b.JwF)
      {
        this.rtz.setVisibility(0);
        this.rtz.setBackgroundResource(2131231372);
        this.rtz.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131101180));
        this.JnR.setVisibility(8);
      }
      else if (locala.Jwx == b.JwA)
      {
        this.rtz.setVisibility(0);
        this.rtz.setBackgroundResource(2131231366);
        this.rtz.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131100161));
        this.JnR.setVisibility(8);
      }
      else
      {
        if (locala.Jwx != b.JwC)
        {
          if (locala.Jwx == b.JwH)
          {
            this.JnR.setTextColor(this.JvK.getResources().getColor(2131100585));
            continue;
          }
          if (locala.Jwx == b.JwG)
          {
            this.JnR.setTextColor(this.JvK.getResources().getColor(2131100800));
            continue;
          }
          if (locala.Jwx == b.JwK)
          {
            this.rtz.setVisibility(0);
            this.rtz.setBackgroundResource(2131231376);
            this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131100161));
            this.JnR.setVisibility(8);
            continue;
          }
          if (b.JwM == locala.Jwx)
          {
            ae.i("MicroMsg.MMActivityController", "dark green mode.");
            this.rtz.setVisibility(0);
            this.rtz.setBackgroundResource(2131231363);
            this.rtz.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131100397));
            this.JnR.setVisibility(8);
            continue;
          }
          if (locala.Jwx == b.JwL)
          {
            this.rtz.setVisibility(0);
            this.rtz.setBackgroundResource(2131231369);
            this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131100161));
            this.JnR.setVisibility(8);
            continue;
          }
          if (b.JwN == locala.Jwx)
          {
            ae.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.JvL) });
            this.JnR.setVisibility(8);
            if (this.JvL)
            {
              this.JvZ.setVisibility(0);
              this.JvZ.setOnClickListener(local20);
              continue;
            }
            if (8 == this.JvZ.getVisibility()) {
              this.JvZ.setVisibility(4);
            }
            for (;;)
            {
              this.JvZ.setOnClickListener(null);
              break;
              if (this.JvZ.getVisibility() == 0) {
                this.JvZ.animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
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
          if (b.JwO == locala.Jwx)
          {
            this.rtz.setVisibility(0);
            this.rtz.setBackgroundResource(2131231369);
            this.rtz.setTextColor(com.tencent.mm.cb.a.n(this.JvK, 2131100072));
            this.JnR.setVisibility(8);
            continue;
          }
          if (b.JwP == locala.Jwx)
          {
            this.rtz.setVisibility(0);
            this.rtz.setBackgroundResource(2131235092);
            this.rtz.setTextColor(com.tencent.mm.cb.a.n(this.JvK, 2131099664));
            this.JnR.setVisibility(8);
            continue;
          }
          if (this.JvU != 0)
          {
            this.JnR.setTextColor(this.JvU);
            continue;
          }
          if (this.JnY)
          {
            this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131101185));
            continue;
          }
        }
        this.JnR.setTextColor(com.tencent.mm.cb.a.m(this.JvK, 2131100024));
      }
    }
    label1817:
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.ZT();
    com.tencent.mm.compatible.b.g.ZT();
    if ((this.JvM) && (this.fUI != null) && (this.fUI.onKeyDown(paramInt, paramKeyEvent)))
    {
      ae.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.JnY) {
        setActionbarColor(this.JvK.getResources().getColor(2131100196));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.JvK.getResources().getColor(2131100705));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.Jwk != null) && (this.Jwk.enable)) {
        a(this.Jwl, this.Jwk);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ae.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.Jvy)
    {
      ae.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.JvN.Jok) && (this.JvN.enable))
    {
      a(paramMenuItem, this.JvN);
      return true;
    }
    Iterator localIterator = this.Job.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.Jok)
      {
        ae.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        return true;
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    activateBroadcast(false);
    com.tencent.mm.sdk.b.a.IvT.d(this.Jwd);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ae.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.JvM) && (this.fUI != null)) {
      this.fUI.a(this.JvK, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    com.tencent.mm.sdk.b.a.IvT.c(this.Jwd);
    Object localObject = new ap();
    ((ap)localObject).dmn.type = 2;
    ((ap)localObject).dmn.position = this.Jwb;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    String str;
    int i;
    if (((ap)localObject).dmo.dms == 2)
    {
      l = System.currentTimeMillis();
      str = ((ap)localObject).dmo.dmu;
      i = ((ap)localObject).dmo.position;
      ae.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.Jwb)) {
        break label432;
      }
      ae.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Jwb) });
    }
    for (;;)
    {
      ae.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk) && (!ak.getContext().getSharedPreferences(ak.fow() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cb.a.ef(ak.getContext())) {
          break;
        }
        if (1.0F != ak.getContext().getResources().getConfiguration().fontScale)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(15181, new Object[] { Integer.valueOf(1) });
          localObject = new f.a(ak.getContext());
          ((f.a)localObject).au(this.JvK.getResources().getString(2131759585)).aZq(this.JvK.getResources().getString(2131759582)).aZu(this.JvK.getResources().getString(2131759584)).aZv(this.JvK.getResources().getString(2131759583));
          ((f.a)localObject).c(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(141349);
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(15181, new Object[] { Integer.valueOf(3) });
                Object localObject = new Intent();
                ((Intent)localObject).setClassName(ak.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                ((Intent)localObject).addFlags(268435456);
                paramAnonymousString = ak.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(141349);
                return;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(15181, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(141349);
            }
          }).show();
          ak.getContext().getSharedPreferences(ak.fow() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label432:
      a(((ap)localObject).dmo.dmt, ((ap)localObject).dmo.visible, ((ap)localObject).dmo.url, ((ap)localObject).dmo.desc, str, i, true);
    }
    ak.getContext().getSharedPreferences(ak.fow() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
  }
  
  public final void onStart()
  {
    this.landscapeMode = this.mContext.getSharedPreferences(ak.fow(), 0).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      this.JvK.setRequestedOrientation(-1);
      return;
    }
    this.JvK.setRequestedOrientation(1);
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
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.abu())) {
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
    if (this.Job.isEmpty()) {
      return;
    }
    this.Job.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.Job.size())
      {
        if (((a)this.Job.get(i)).Jok == paramInt)
        {
          ae.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.Job.remove(i);
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
    this.EhG = paramInt;
    this.JnY = ao.acF(this.EhG);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.EhG));
    q(this.JvK, this.EhG);
    fAW();
    fAV();
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
        if (this.JvS.getDrawable() == null) {
          i = 2131689490;
        }
      }
      if ((this.JvS != null) && (i != 0)) {
        this.JvS.setImageResource(i);
      }
      this.JvN.Jok = 16908332;
      this.JvN.jle = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.JvR != null) {
        this.JvR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(141338);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141337);
                s.9.this.Jod.onMenuItemClick(null);
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
    if (this.JvS != null) {
      this.JvS.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.JvS == null) {
      return;
    }
    if (paramBoolean)
    {
      this.JvS.setVisibility(0);
      return;
    }
    this.JvS.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.Jvx == null) {
      this.Jvx = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    this.Jvx.setBackgroundResource(paramInt);
    this.CbM.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.Jvx == null) {
      this.Jvx = ((FrameLayout)this.contentView.findViewById(2131302320));
    }
    if (this.Jvv != null) {
      this.Jvx.removeView(this.Jvv);
    }
    this.Jvx.removeView(this.CbM);
    this.CbM = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.Jvx.addView(this.CbM, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.Jvv != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.b.h(this.mContext, 47.0F));
      this.Jvx.addView(this.Jvv, this.Jvx.getChildCount(), localLayoutParams);
    }
    this.Jvx.invalidate();
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.JvR != null)
    {
      this.JvR.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.JvR.setEnabled(false);
    }
    for (;;)
    {
      if (this.JnP != null)
      {
        this.JnP.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.JnP.setEnabled(false);
      }
      return;
      label59:
      this.JvR.setEnabled(true);
    }
    this.JnP.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      bc(this.JvK);
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
        this.mActionBar.setCustomView(Jwf);
        localTextView = (TextView)this.mActionBar.getCustomView().findViewById(2131296348);
      } while (localTextView == null);
      localTextView.clearAnimation();
      if (paramAnimation != null) {
        localTextView.startAnimation(paramAnimation);
      }
    } while (bu.isNullOrNil(paramString));
    localTextView.setText(paramString);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.nhr.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cb.a.ir(this.JvK))
    {
      this.nhr.setTextSize(1, 14.0F);
      this.JvQ.setTextSize(1, 18.0F);
    }
    this.nhr.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.nhr.setVisibility(8);
      return;
    }
    this.nhr.setText(paramString);
    if (com.tencent.mm.cb.a.ir(this.JvK))
    {
      this.nhr.setTextSize(1, 14.0F);
      this.JvQ.setTextSize(1, 18.0F);
    }
    this.nhr.setVisibility(0);
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
    this.Jvz = paramCharSequence.toString();
    this.JvQ.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.ir(this.JvK)) {
      this.JvQ.setTextSize(0, com.tencent.mm.cb.a.ay(this.JvK, 2131165184) * com.tencent.mm.cb.a.ip(this.JvK));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.Jvz = paramString;
    if (com.tencent.mm.cb.a.ir(this.JvK)) {
      this.JvQ.setTextSize(0, com.tencent.mm.cb.a.ay(this.JvK, 2131165184) * com.tencent.mm.cb.a.ip(this.JvK));
    }
    fAU();
    updateDescription(paramString);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.JvQ.setVisibility(paramInt);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!fAX()))
    {
      this.JvK.getWindow().setNavigationBarColor(paramInt);
      boolean bool = ao.acF(paramInt);
      localView = this.JvK.getWindow().getDecorView();
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
    this.Jvy = paramBoolean;
    if ((this.Jvu == null) && (this.contentView != null)) {
      this.Jvu = this.contentView.findViewById(2131302342);
    }
    if (this.Jvu == null)
    {
      ae.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.Jvu;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.Jvu;
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
      jQ(this.JvK);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    q(this.JvK, paramInt);
    updataStatusBarIcon(ao.acF(paramInt));
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      this.JvA = 0;
      this.JvC = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.JvB = 0;
      this.JvD = null;
    }
    for (;;)
    {
      fAU();
      return;
      if (this.JvA == paramInt1) {
        break;
      }
      this.JvA = paramInt1;
      this.JvC = jF(this.mContext.getResources().getDimensionPixelSize(2131165192), this.JvA);
      break;
      label82:
      if (this.JvB != paramInt2)
      {
        this.JvB = paramInt2;
        this.JvD = jF(this.mContext.getResources().getDimensionPixelSize(2131165192), this.JvB);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.JvH = bool;
      fAU();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.JvJ = bool;
      fAU();
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
      q(this.JvK, this.EhG);
      return;
    }
    this.mActionBar.hide();
    q(this.JvK, this.JvK.getResources().getColor(2131100017));
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
    } while (this.JvR == null);
    View localView = this.JvR;
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
      ae.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    this.JvK.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.JvK.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      ae.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", new Object[] { Boolean.valueOf(paramBoolean) });
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
    while ((this.JvS == null) || (paramDrawable == null)) {
      return;
    }
    this.JvS.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.fCh().l(this.JvK, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = acp(paramInt1);
    if ((locala != null) && (locala.Jol != paramInt2))
    {
      locala.Jol = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = acp(paramInt);
    if (locala != null)
    {
      locala.jle = paramOnMenuItemClickListener;
      locala.rIu = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = acp(paramInt);
    if ((locala != null) && (locala.Jwy != paramBoolean))
    {
      locala.Jwy = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = acp(paramInt);
    if ((locala != null) && (!bu.bI(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void xt(boolean paramBoolean)
  {
    this.JnY = paramBoolean;
    fAW();
    fAV();
  }
  
  public static final class a
  {
    public int Jok = -1;
    public int Jol;
    public View Jom;
    public View Jon;
    public int Jwv = 0;
    public Drawable Jww;
    public s.b Jwx = s.b.Jwz;
    public boolean Jwy = false;
    public boolean enable = true;
    public MenuItem.OnMenuItemClickListener jle;
    public View.OnLongClickListener rIu;
    public View.OnTouchListener tVH;
    public String text;
    public int textColor;
    public boolean visible = true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      Jwz = new b("NORMAL", 0);
      JwA = new b("GREEN", 1);
      JwB = new b("RED", 2);
      JwC = new b("BLACK", 3);
      JwD = new b("TRANSPARENT", 4);
      JwE = new b("TRANSPARENT_RED_TEXT", 5);
      JwF = new b("TRANSPARENT_GREEN_TEXT", 6);
      JwG = new b("GOLDEN", 7);
      JwH = new b("TRANSPARENT_GOLD_TEXT", 8);
      JwI = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      JwJ = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      JwK = new b("YELLOW", 11);
      JwL = new b("ORANGE", 12);
      JwM = new b("DARK_GREEN_MODE", 13);
      JwN = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      JwO = new b("FEED_FOLLOW", 15);
      JwP = new b("FEED_UNFOLLOW", 16);
      JwQ = new b[] { Jwz, JwA, JwB, JwC, JwD, JwE, JwF, JwG, JwH, JwI, JwJ, JwK, JwL, JwM, JwN, JwO, JwP };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */