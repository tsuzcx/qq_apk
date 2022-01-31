package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.h.a.aj;
import com.tencent.mm.h.a.aj.b;
import com.tencent.mm.h.a.sh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class s
{
  private static boolean uMQ = false;
  public static final int uNf = a.h.actionbar_title_single_text;
  private static byte[] uNi = { 0 };
  private static PowerManager.WakeLock wakeLock = null;
  public int aTI = this.uMZ;
  String className;
  public View contentView;
  private n drn;
  AudioManager eJZ;
  private LayoutInflater fhz;
  private int kIR = 0;
  public ActionBar mActionBar;
  public Context mContext;
  boolean nST = false;
  protected ah ntK = new ah(Looper.getMainLooper());
  private final long peu = 300L;
  private long pev = SystemClock.elapsedRealtime();
  private int uGL = 0;
  public ImageButton uGM;
  TextView uGO;
  LinkedList<a> uGV = new LinkedList();
  View uMA;
  private TextView uMB;
  FrameLayout uMC;
  public boolean uMD = true;
  private String uME = " ";
  private int uMF = 0;
  private int uMG = 0;
  private com.tencent.mm.ui.widget.a uMH = null;
  private com.tencent.mm.ui.widget.a uMI = null;
  private com.tencent.mm.ui.widget.a uMJ = null;
  private com.tencent.mm.ui.widget.a uMK = null;
  private boolean uML = false;
  boolean uMM = false;
  public AppCompatActivity uMN;
  private boolean uMO;
  private a uMP = new a();
  private ArrayList<Dialog> uMR;
  public TextView uMS;
  private View uMT;
  public View uMU;
  public ImageView uMV;
  TextView uMW;
  int uMX = 0;
  private ImageView uMY;
  private int uMZ;
  protected boolean uMo = false;
  private View uMy;
  public View uMz;
  private int uNa;
  private int uNb = 0;
  private boolean uNc = false;
  private c uNd = new c() {};
  private int uNe = a.h.actionbar_title;
  private int uNg = -1;
  public int uNh = 0;
  private a uNj;
  private MenuItem uNk;
  private Runnable uNl = new Runnable()
  {
    public final void run()
    {
      s.i(s.this).getWindow().setFlags(1024, 1024);
      if (s.j(s.this) != null) {
        s.j(s.this).hide();
      }
    }
  };
  private Runnable uNm = new Runnable()
  {
    public final void run()
    {
      if (s.j(s.this) != null) {
        s.j(s.this).show();
      }
    }
  };
  
  private void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, boolean paramBoolean2)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.uMA });
    if (!needShowIdcError()) {
      break label61;
    }
    label61:
    while ((!paramBoolean1) && (this.uMA == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.uMC == null) {
      this.uMC = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    if (this.uMA != null) {
      this.uMC.removeView(this.uMA);
    }
    int i = a.h.mmnotify_view;
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.uMA = this.fhz.inflate(paramInt1, null);
      this.uMB = ((TextView)this.uMA.findViewById(a.g.notify_text));
      this.uMA.findViewById(a.g.notify_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new aj();
          paramAnonymousView.bGr.type = 1;
          paramAnonymousView.bGr.bGt = paramString3;
          paramAnonymousView.bGr.position = paramInt2;
          com.tencent.mm.sdk.b.a.udP.m(paramAnonymousView);
          s.b(s.this).setVisibility(8);
        }
      });
      this.uMA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (paramString1 != null)
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            paramAnonymousView.setData(Uri.parse(paramString1));
            s.c(s.this).startActivity(paramAnonymousView);
          }
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.uNc) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.b(this.uMN, 48.0F), 0, 0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.uMC.addView(this.uMA, this.uMC.getChildCount(), paramString3);
      if (this.uMA == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.uMA;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(a.k.idc_url);
          paramString3 = paramString2;
          if (bk.bl(paramString2)) {
            paramString3 = this.mContext.getString(a.k.disaster_default_tips_default);
          }
          if (paramString1 == null) {
            break label489;
          }
          paramString1 = new SpannableString(paramString3 + str);
          paramString2 = new ForegroundColorSpan(-10119449);
          paramInt1 = paramString3.length();
          paramInt2 = paramString3.length();
          paramString1.setSpan(paramString2, paramInt1, str.length() + paramInt2, 33);
          this.uMB.setText(paramString1);
        }
        for (;;)
        {
          this.uMA.invalidate();
          this.uMC.invalidate();
          return;
          paramInt1 = 8;
          break;
          label489:
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.uMB.setText(paramString3);
        }
      }
      this.uMA.post(new Runnable()
      {
        public final void run()
        {
          Object localObject = s.b(s.this);
          int i;
          if (paramBoolean1)
          {
            i = 0;
            ((View)localObject).setVisibility(i);
            String str = s.c(s.this).getString(a.k.idc_url);
            if (!bk.bl(paramString2)) {
              break label162;
            }
            localObject = s.c(s.this).getString(a.k.disaster_default_tips_default);
            label60:
            if (paramString1 == null) {
              break label170;
            }
            SpannableString localSpannableString = new SpannableString((String)localObject + str);
            localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
            s.d(s.this).setText(localSpannableString);
          }
          for (;;)
          {
            s.b(s.this).invalidate();
            s.e(s.this).invalidate();
            return;
            i = 8;
            break;
            label162:
            localObject = paramString2;
            break label60;
            label170:
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
            s.d(s.this).setText((CharSequence)localObject);
          }
        }
      });
      return;
      paramInt1 = i;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.uMD) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.fkl == null) {
      return;
    }
    parama.fkl.onMenuItemClick(paramMenuItem);
  }
  
  public static Locale by(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      com.tencent.mm.sdk.platformtools.x.a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = com.tencent.mm.sdk.platformtools.x.Zi(paramString);
    com.tencent.mm.sdk.platformtools.x.a(paramContext, paramString);
    return paramString;
  }
  
  public static void czj()
  {
    uMQ = true;
  }
  
  public static boolean czw()
  {
    for (;;)
    {
      synchronized (uNi)
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
  
  public static void czy() {}
  
  public static void czz() {}
  
  private View findViewById(int paramInt)
  {
    View localView = this.contentView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.uMN.findViewById(paramInt);
  }
  
  private com.tencent.mm.ui.widget.a fj(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.nST) {
      localDrawable = an.an(this.uMN, paramInt2);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.wjc = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  protected static int getForceOrientation()
  {
    return -1;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return by(paramContext, com.tencent.mm.sdk.platformtools.x.d(paramContext.getSharedPreferences(ae.cqR(), 0)));
  }
  
  @TargetApi(21)
  private static void l(Activity paramActivity, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!h.zL())) {}
    for (;;)
    {
      paramActivity.getWindow().setStatusBarColor(paramInt);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        paramInt = an.n(paramActivity.getResources().getColor(a.d.statusbar_fg_drak_color), paramInt);
      } else {
        paramInt = 0;
      }
    }
  }
  
  final boolean FT(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.uGV.size())
      {
        if (((a)this.uGV.get(i)).uHd == paramInt)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.uGV.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a FU(int paramInt)
  {
    Iterator localIterator = this.uGV.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.uHd == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void N(CharSequence paramCharSequence)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.uME = paramCharSequence.toString();
    this.uMS.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.fh(this.uMN)) {
      this.uMS.setTextSize(0, com.tencent.mm.cb.a.ab(this.uMN, a.e.ActionBarTextSize) * com.tencent.mm.cb.a.ff(this.uMN));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void X(Activity paramActivity)
  {
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.uGL == 0) {
        this.uGL = czv();
      }
      this.nST = an.Gf(this.uGL);
      ta(this.uGL);
      this.mActionBar.setLogo(new ColorDrawable(this.uMN.getResources().getColor(17170445)));
      this.mActionBar.dZ();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.dY();
      this.mActionBar.ea();
      this.mActionBar.setIcon(a.f.transparent_background);
      if (this.uNg != -1) {
        break label316;
      }
      this.mActionBar.setCustomView(y.gt(this.uMN).inflate(this.uNe, new LinearLayout(this.uMN), false));
      this.uMS = ((TextView)findViewById(16908308));
      this.uMW = ((TextView)findViewById(16908309));
      this.uMT = findViewById(a.g.title_ll);
      this.uMU = findViewById(a.g.actionbar_up_indicator);
      this.uMV = ((ImageView)findViewById(a.g.actionbar_up_indicator_btn));
      if (this.uMV != null) {
        this.uMV.setContentDescription(this.uMN.getString(a.k.app_back));
      }
      if (this.uMS != null) {
        this.uMS.setText(a.k.app_name);
      }
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label352;
      }
      if (this.uMV != null) {
        this.uMV.setVisibility(0);
      }
      if (this.uMU != null) {
        this.uMU.setVisibility(0);
      }
    }
    for (;;)
    {
      czB();
      return;
      label316:
      this.mActionBar.setCustomView(y.gt(this.uMN).inflate(this.uNg, new LinearLayout(this.uMN), false));
      break;
      label352:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.uMV != null) {
          this.uMV.setVisibility(0);
        }
        if (this.uMU != null) {
          this.uMU.setVisibility(0);
        }
        if (this.uMS != null) {
          this.uMS.setVisibility(0);
        }
      }
      else
      {
        if (this.uMV != null) {
          this.uMV.setVisibility(8);
        }
        if (this.uMU != null) {
          this.uMU.setVisibility(8);
        }
      }
    }
  }
  
  final void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.uHd = paramInt1;
    locala.uHe = paramInt2;
    locala.text = paramString;
    locala.fkl = paramOnMenuItemClickListener;
    locala.kfL = paramOnLongClickListener;
    locala.uNu = paramb;
    locala.uNv = paramBoolean;
    if ((locala.uHe == a.f.mm_title_btn_menu) && (bk.bl(paramString))) {
      locala.text = this.mContext.getString(a.k.app_more);
    }
    FT(locala.uHd);
    this.uGV.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.uMN = paramAppCompatActivity;
    boolean bool1 = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar_init", false);
    boolean bool2 = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
    if ((!bool1) && (!bool2))
    {
      ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
      ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).edit().putBoolean("dark_actionbar_init", true).commit();
    }
    onCreateBeforeSetContentView();
    this.className = getClass().getName();
    ai.be(3, this.className);
    initLanguage(paramContext);
    this.eJZ = ((AudioManager)this.mContext.getSystemService("audio"));
    int i = getLayoutId();
    this.fhz = LayoutInflater.from(this.mContext);
    this.contentView = com.tencent.mm.kiss.a.b.ED().a(paramAppCompatActivity, "R.layout.mm_activity", a.h.mm_activity);
    this.uMy = this.contentView.findViewById(a.g.mm_trans_layer);
    this.uMC = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    this.kIR = this.mContext.getResources().getDimensionPixelSize(a.e.SmallBtnPadding);
    label494:
    long l;
    label618:
    String str;
    if (i != -1)
    {
      this.uMz = getLayoutView();
      if (this.uMz == null)
      {
        this.uMz = this.fhz.inflate(getLayoutId(), null);
        this.uMC.addView(this.uMz, 0);
      }
    }
    else
    {
      dealContentView(this.contentView);
      if (czg())
      {
        ak.g(ak.a(this.uMN.getWindow(), this.uMz), this.uMz);
        ((ViewGroup)this.uMz.getParent()).removeView(this.uMz);
        ((ViewGroup)this.uMN.getWindow().getDecorView()).addView(this.uMz, 0);
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label870;
        }
        i = this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
        this.uMz.setPadding(this.uMz.getPaddingLeft(), i + (j + this.uMz.getPaddingTop()), this.uMz.getPaddingRight(), this.uMz.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "onCreate, before.");
      X(paramAppCompatActivity);
      this.uMZ = ap.ab(this.mContext, a.e.DefaultActionbarHeightPort);
      this.uNa = ap.ab(this.mContext, a.e.SmallActionbarHeight);
      if ((this.uMC == null) || (!(this.uMC instanceof LayoutListenerView))) {
        break label887;
      }
      ((LayoutListenerView)this.uMC).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int uNr = com.tencent.mm.cb.a.fromDPToPix(s.c(s.this), 100);
        
        public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          if (s.f(s.this)) {}
          do
          {
            do
            {
              return;
            } while ((paramAnonymousInt1 == 0) || (paramAnonymousInt2 == 0) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0) || (paramAnonymousInt1 != paramAnonymousInt3));
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.uNr))
            {
              s.g(s.this);
              return;
            }
          } while ((paramAnonymousInt4 <= paramAnonymousInt2) || (paramAnonymousInt4 - paramAnonymousInt2 <= this.uNr));
          s.h(s.this);
        }
      });
      paramContext = new aj();
      paramContext.bGr.type = 2;
      paramContext.bGr.position = this.uNb;
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
      if (paramContext.bGs.bGv == 2)
      {
        l = System.currentTimeMillis();
        str = paramContext.bGs.bGy;
        i = paramContext.bGs.position;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), str, bk.csb() });
        if ((i <= 0) || (i == this.uNb)) {
          break label898;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.uNb) });
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.uGL == 0) {
          this.uGL = czv();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        l(paramAppCompatActivity, this.uGL);
        czC();
      }
      return;
      if (this.uMz.getParent() == null) {
        break;
      }
      ((ViewGroup)this.uMz.getParent()).removeView(this.uMz);
      break;
      label870:
      i = this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
      break label494;
      label887:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label618;
      label898:
      a(paramContext.bGs.bGx, paramContext.bGs.aoL, paramContext.bGs.url, paramContext.bGs.desc, str, i, true);
    }
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    if ((!uMQ) && (paramBoolean))
    {
      com.tencent.mm.ui.base.x.b(paramBoolean, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
      return;
    }
    com.tencent.mm.ui.base.x.b(paramBoolean, new Intent().putExtra("classname", getClassName() + bdI()));
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.uMR == null) {
      this.uMR = new ArrayList();
    }
    this.uMR.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.uNw);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.uNw);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.uNw);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.uNw);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.uNw);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.uNw);
  }
  
  public final void addSearchMenu(boolean paramBoolean, n paramn)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.uHd = a.g.menu_search;
    locala.text = this.mContext.getString(a.k.app_search);
    locala.uHe = a.j.actionbar_icon_dark_search;
    locala.fkl = null;
    locala.kfL = null;
    removeOptionMenu(locala.uHd);
    this.uGV.add(0, locala);
    this.uMO = paramBoolean;
    this.drn = paramn;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.uNw);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public final void ap(int paramInt, boolean paramBoolean)
  {
    this.uNb = paramInt;
    this.uNc = paramBoolean;
  }
  
  protected abstract String bdI();
  
  final void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.uGV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label125;
      }
      locala = (a)localIterator.next();
      if (locala.bIU == paramBoolean2) {
        break label191;
      }
      locala.bIU = paramBoolean2;
      paramBoolean1 = true;
    }
    label188:
    label191:
    for (;;)
    {
      break;
      localIterator = this.uGV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.uHd != paramInt) || (locala.bIU == paramBoolean2)) {
          break label188;
        }
        locala.bIU = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.drn == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.drn.wel)
        {
          if (!paramBoolean1) {
            supportInvalidateOptionsMenu();
          }
          com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final boolean callBackMenu()
  {
    if ((this.uMP != null) && (this.uMP.bIU))
    {
      a(null, this.uMP);
      return true;
    }
    return false;
  }
  
  final void czA()
  {
    Object localObject1 = "%s";
    int n = this.mContext.getResources().getDimensionPixelSize(a.e.ActionBarTextSize);
    if (this.uMF != 0) {
      localObject1 = "# " + "%s";
    }
    if (this.uMG != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int i = 1;; i = 0)
    {
      if (this.uML)
      {
        localObject1 = (String)localObject1 + " #";
        i += 2;
      }
      for (int j = 1;; j = 0)
      {
        int m;
        int k;
        if (this.uMM)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
          m = 1;
          k = i + 2;
        }
        for (i = m;; i = m)
        {
          Object localObject2 = String.format((String)localObject1, new Object[] { this.uME });
          com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
          localObject1 = com.tencent.mm.ui.e.c.b.c((CharSequence)localObject2, n);
          if ((localObject1 instanceof SpannableString))
          {
            localObject2 = (SpannableString)localObject1;
            if (this.uMF != 0) {
              ((SpannableString)localObject2).setSpan(this.uMH, 0, 1, 33);
            }
            if (this.uMG != 0)
            {
              k = ((SpannableString)localObject2).length() - k;
              ((SpannableString)localObject2).setSpan(this.uMI, k, k + 1, 33);
            }
            if (this.uML)
            {
              if (this.uMJ == null) {
                this.uMJ = fj(n, a.j.chat_mute_notify_title_icon);
              }
              j = ((SpannableString)localObject2).length() - j;
              ((SpannableString)localObject2).setSpan(this.uMJ, j, j + 1, 33);
            }
            if (this.uMM)
            {
              if (this.uMK == null) {
                this.uMK = fj(n, a.j.chat_phone_notify_title_icon);
              }
              i = ((SpannableString)localObject2).length() - i;
              ((SpannableString)localObject2).setSpan(this.uMK, i, i + 1, 33);
            }
          }
          this.uMS.setText((CharSequence)localObject1);
          return;
          m = 0;
          k = i;
        }
      }
    }
  }
  
  final void czB()
  {
    if (this.nST)
    {
      if (this.uMV != null)
      {
        this.uMV.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.uMU.setBackgroundResource(a.f.selected_bg_dark);
      }
      if ((this.uMS != null) && (this.uMS.getVisibility() == 0)) {
        this.uMS.setTextColor(this.mContext.getResources().getColor(a.d.white_text_color));
      }
      if ((this.uMW != null) && (this.uMW.getVisibility() == 0)) {
        this.uMW.setTextColor(this.mContext.getResources().getColor(a.d.white_text_color));
      }
      if ((this.uGM != null) && (this.uGM.getVisibility() == 0)) {
        if (this.uGM.getDrawable() != null) {
          this.uGM.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.uGM.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
      } while ((this.uGO == null) || (this.uGO.getVisibility() != 0));
      this.uGO.setTextColor(com.tencent.mm.cb.a.h(this.mContext, a.d.white_text_color_selector));
      return;
      if (this.uMV != null)
      {
        this.uMV.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.uMU.setBackgroundResource(a.f.actionbar_menu_selector);
      }
      if ((this.uMS != null) && (this.uMS.getVisibility() == 0)) {
        this.uMS.setTextColor(this.mContext.getResources().getColor(a.d.black_text_color));
      }
      if ((this.uMW != null) && (this.uMW.getVisibility() == 0)) {
        this.uMW.setTextColor(this.mContext.getResources().getColor(a.d.black_text_color));
      }
      if ((this.uGM != null) && (this.uGM.getVisibility() == 0))
      {
        if (this.uGM.getDrawable() != null)
        {
          this.uGM.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        this.uGM.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        return;
      }
    } while ((this.uGO == null) || (this.uGO.getVisibility() != 0));
    this.uGO.setTextColor(com.tencent.mm.cb.a.h(this.mContext, a.d.black_text_color_selector));
  }
  
  final void czC()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.uMN.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", new Object[] { Boolean.valueOf(this.nST) });
      if (!this.nST) {
        break label65;
      }
      i &= 0xFFFFDFFF;
    }
    for (;;)
    {
      localView.setSystemUiVisibility(i);
      return;
      label65:
      i |= 0x2000;
    }
  }
  
  protected abstract boolean czg();
  
  public final int czv()
  {
    boolean bool = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
    this.nST = bool;
    if (this.uGL == 0) {
      if (!bool) {
        break label77;
      }
    }
    label77:
    for (this.uGL = this.mContext.getResources().getColor(a.d.dark_actionbar_color);; this.uGL = this.mContext.getResources().getColor(a.d.normal_actionbar_color)) {
      return this.uGL;
    }
  }
  
  public final void czx()
  {
    if (this.mActionBar != null) {
      this.mActionBar.hide();
    }
    this.ntK.removeCallbacks(this.uNm);
    this.ntK.removeCallbacks(this.uNl);
    this.ntK.postDelayed(this.uNl, 0L);
  }
  
  final void d(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.uGV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label125;
      }
      locala = (a)localIterator.next();
      if (locala.aoL == paramBoolean2) {
        break label196;
      }
      locala.aoL = paramBoolean2;
      paramBoolean1 = true;
    }
    label193:
    label196:
    for (;;)
    {
      break;
      localIterator = this.uGV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.uHd != paramInt) || (locala.aoL == paramBoolean2)) {
          break label193;
        }
        locala.aoL = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.drn == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.drn.wel)
        {
          if ((bool) && (!paramBoolean1)) {
            supportInvalidateOptionsMenu();
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.uMP == null) {}
    while (this.uMP.bIU == paramBoolean) {
      return;
    }
    this.uMP.bIU = paramBoolean;
    supportInvalidateOptionsMenu();
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.ntK.removeCallbacks(this.uNm);
      this.ntK.removeCallbacks(this.uNl);
      this.ntK.postDelayed(this.uNl, 256L);
      return;
    }
    this.uMN.getWindow().clearFlags(1024);
    this.ntK.removeCallbacks(this.uNl);
    this.ntK.removeCallbacks(this.uNm);
    this.ntK.postDelayed(this.uNm, 256L);
  }
  
  protected abstract String getClassName();
  
  public final boolean getLandscapeMode()
  {
    return this.uMo;
  }
  
  protected abstract int getLayoutId();
  
  protected abstract View getLayoutView();
  
  public final CharSequence getMMTitle()
  {
    if (this.mActionBar == null) {
      return null;
    }
    if (this.uME != null) {
      return this.uME;
    }
    return this.mActionBar.getTitle();
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.uMN.getSupportActionBar();
  }
  
  public final int getTitleLocation()
  {
    if (this.mActionBar == null) {
      return 0;
    }
    return this.mActionBar.getHeight();
  }
  
  public final void hideTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (localInputMethodManager == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = this.uMN.getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMActivityController", "hide VKB exception %s", new Object[] { localIllegalArgumentException });
        boolean bool = false;
      }
    }
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
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
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
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return false;
      bool = false;
    }
    return this.mActionBar.isShowing();
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
    boolean bool2 = true;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.uGV.size()) });
    boolean bool1;
    if ((this.mActionBar == null) || (this.uGV.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.uGV.size()) });
      bool1 = false;
      return bool1;
    }
    this.uNj = null;
    this.uNk = null;
    Object localObject1;
    if (this.mActionBar.getHeight() == 0)
    {
      localObject1 = this.mContext.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label187;
      }
      this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
    }
    final a locala;
    for (;;)
    {
      localObject1 = this.uGV.iterator();
      for (;;)
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.uHd != 16908332) {
          break label204;
        }
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label187:
      this.mContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
    }
    label204:
    if (locala.uHd == a.g.menu_search)
    {
      boolean bool3 = this.uMO;
      if (this.drn == null) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if ((!this.uMO) || (this.drn == null)) {
          break;
        }
        this.drn.a(this.uMN, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.uHd, 0, locala.text);
    Object localObject2 = getClass().getName();
    label334:
    View.OnLongClickListener local12;
    if (localMenuItem == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          s.a(s.this, localMenuItem, locala);
        }
      };
      local12 = new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          return s.a(s.this, paramAnonymousView, locala);
        }
      };
      if ((locala.uHe == 0) && (locala.uNt == null)) {
        break label930;
      }
      if (locala.uHg == null) {
        locala.uHg = View.inflate(this.mContext, a.h.action_option_view, null);
      }
      ImageView localImageView = (ImageView)locala.uHg.findViewById(a.g.divider);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      this.uGM = ((ImageButton)locala.uHg.findViewById(a.g.action_option_icon));
      this.uGM.setVisibility(0);
      if (locala.uNt == null) {
        break label840;
      }
      this.uGM.setImageDrawable(locala.uNt);
      label474:
      if (!this.nST) {
        break label872;
      }
      if (this.uMX == 0) {
        break label855;
      }
      this.uGM.getDrawable().setColorFilter(this.uMX, PorterDuff.Mode.SRC_ATOP);
      label505:
      this.uGM.setOnClickListener((View.OnClickListener)localObject2);
      this.uGM.setEnabled(locala.bIU);
      this.uGM.setContentDescription(locala.text);
      if (locala.kfL != null) {
        this.uGM.setOnLongClickListener(local12);
      }
      this.uMY = ((ImageView)locala.uHg.findViewById(a.g.dot_iv));
      if (this.uMY != null)
      {
        if (!locala.uNv) {
          break label918;
        }
        this.uMY.setVisibility(0);
      }
    }
    for (;;)
    {
      android.support.v4.view.f.a(localMenuItem, locala.uHg);
      localMenuItem.setEnabled(locala.bIU);
      localMenuItem.setVisible(locala.aoL);
      android.support.v4.view.f.a(localMenuItem, 2);
      if (locala.uHe == a.f.mm_title_btn_menu)
      {
        this.uNj = locala;
        this.uNk = localMenuItem;
      }
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.uHd), locala.text, Boolean.valueOf(locala.bIU), Boolean.valueOf(locala.aoL) });
      break;
      if (localMenuItem.getTitleCondensed() == null)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", new Object[] { localObject2 });
        localMenuItem.setTitleCondensed("");
        break label334;
      }
      if ((localMenuItem.getTitleCondensed() instanceof String)) {
        break label334;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", new Object[] { localObject2, localMenuItem.getTitleCondensed().getClass().getName(), localMenuItem.getTitleCondensed() });
      localMenuItem.setTitleCondensed(localMenuItem.getTitleCondensed().toString());
      break label334;
      label840:
      this.uGM.setImageResource(locala.uHe);
      break label474;
      label855:
      this.uGM.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      break label505;
      label872:
      if (this.uMX != 0)
      {
        this.uGM.getDrawable().setColorFilter(this.uMX, PorterDuff.Mode.SRC_ATOP);
        break label505;
      }
      this.uGM.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      break label505;
      label918:
      this.uMY.setVisibility(8);
    }
    label930:
    if (locala.uHf == null) {
      locala.uHf = View.inflate(this.mContext, a.h.action_option_view, null);
    }
    this.uGO = ((TextView)locala.uHf.findViewById(a.g.action_option_text));
    this.uGO.setVisibility(0);
    if ((locala.uNu == b.uNy) || (locala.uNu == b.uNB)) {
      this.uGO.setTextColor(com.tencent.mm.cb.a.h(this.uMN, a.d.red_text_color_selector));
    }
    for (;;)
    {
      this.uGO.setText(locala.text);
      if (locala.textColor != 0) {
        this.uGO.setTextColor(locala.textColor);
      }
      this.uGO.setOnClickListener((View.OnClickListener)localObject2);
      this.uGO.setOnLongClickListener(local12);
      this.uGO.setEnabled(locala.bIU);
      android.support.v4.view.f.a(localMenuItem, locala.uHf);
      break;
      if ((locala.uNu == b.uNx) || (locala.uNu == b.uNC))
      {
        this.uGO.setTextColor(com.tencent.mm.cb.a.h(this.uMN, a.d.green_text_color_selector));
      }
      else
      {
        if (locala.uNu != b.uNz)
        {
          if (locala.uNu == b.uNE)
          {
            this.uGO.setTextColor(this.uMN.getResources().getColor(a.d.lucky_money_goldstyle_text_color));
            continue;
          }
          if (locala.uNu == b.uND)
          {
            this.uGO.setTextColor(-2601405);
            continue;
          }
          if (this.uMX != 0)
          {
            this.uGO.setTextColor(this.uMX);
            continue;
          }
          if (this.nST)
          {
            this.uGO.setTextColor(com.tencent.mm.cb.a.h(this.uMN, a.d.white_text_color_selector));
            continue;
          }
        }
        this.uGO.setTextColor(com.tencent.mm.cb.a.h(this.uMN, a.d.black_text_color_selector));
      }
    }
  }
  
  public final void onDestroy()
  {
    if (this.uMR != null)
    {
      int j = this.uMR.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.uMR.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.uMR.clear();
      this.uMR = null;
    }
    if ((d.spd) || (com.tencent.mm.sdk.a.b.cqk())) {
      com.tencent.mm.sdk.platformtools.an.fC(this.mContext);
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    com.tencent.mm.compatible.b.f.ym();
    com.tencent.mm.compatible.b.f.ym();
    boolean bool1 = bool2;
    if (this.uMO)
    {
      bool1 = bool2;
      if (this.drn != null)
      {
        bool1 = bool2;
        if (this.drn.onKeyDown(paramInt, paramKeyEvent))
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "match search view on key down");
          if (!ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
            break label116;
          }
          ta(this.uMN.getResources().getColor(a.d.dark_actionbar_color));
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label116:
      ta(this.uMN.getResources().getColor(a.d.normal_actionbar_color));
    }
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.uNj != null) && (this.uNj.bIU)) {
        a(this.uNk, this.uNj);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.uMD)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.uMP.uHd) && (this.uMP.bIU))
    {
      a(paramMenuItem, this.uMP);
      return true;
    }
    Iterator localIterator = this.uGV.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.uHd)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        return true;
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    activateBroadcast(false);
    com.tencent.mm.sdk.b.a.udP.d(this.uNd);
    if ((d.spd) || (com.tencent.mm.sdk.a.b.cqk())) {
      com.tencent.mm.sdk.platformtools.an.fD(this.mContext);
    }
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.uMO) && (this.drn != null)) {
      this.drn.a(this.uMN, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    com.tencent.mm.sdk.b.a.udP.c(this.uNd);
    aj localaj = new aj();
    localaj.bGr.type = 2;
    localaj.bGr.position = this.uNb;
    com.tencent.mm.sdk.b.a.udP.m(localaj);
    long l;
    String str;
    int i;
    if (localaj.bGs.bGv == 2)
    {
      l = System.currentTimeMillis();
      str = localaj.bGs.bGy;
      i = localaj.bGs.position;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.uNb)) {
        break label183;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.uNb) });
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      return;
      label183:
      a(localaj.bGs.bGx, localaj.bGs.aoL, localaj.bGs.url, localaj.bGs.desc, str, i, true);
    }
  }
  
  public final void onStart()
  {
    this.uMo = this.mContext.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_landscape_mode", false);
    if (this.uMo)
    {
      this.uMN.setRequestedOrientation(-1);
      return;
    }
    this.uMN.setRequestedOrientation(1);
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.uGV.isEmpty()) {
      return;
    }
    this.uGV.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.uGV.size())
      {
        if (((a)this.uGV.get(i)).uHd == paramInt)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.uGV.remove(i);
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
      if (paramInt == 0) {
        i = a.j.actionbar_icon_dark_back;
      }
      if ((this.uMV != null) && (i != 0)) {
        this.uMV.setImageResource(i);
      }
      this.uMP.uHd = 16908332;
      this.uMP.fkl = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.uMU != null) {
        this.uMU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramOnMenuItemClickListener.onMenuItemClick(null);
          }
        });
      }
    }
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.uMC == null) {
      this.uMC = ((FrameLayout)this.contentView.findViewById(a.g.mm_content_fl));
    }
    this.uMC.setBackgroundResource(paramInt);
    this.uMz.setBackgroundResource(paramInt);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.uMW.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cb.a.fh(this.uMN))
    {
      this.uMW.setTextSize(1, 14.0F);
      this.uMS.setTextSize(1, 18.0F);
    }
    this.uMW.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.uMW.setVisibility(8);
      return;
    }
    this.uMW.setText(paramString);
    if (com.tencent.mm.cb.a.fh(this.uMN))
    {
      this.uMW.setTextSize(1, 14.0F);
      this.uMS.setTextSize(1, 18.0F);
    }
    this.uMW.setVisibility(0);
    updateDescription(paramString);
  }
  
  public final void setMMTitle(int paramInt)
  {
    setMMTitle(this.mContext.getString(paramInt));
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.uME = paramString;
    if (com.tencent.mm.cb.a.fh(this.uMN)) {
      this.uMS.setTextSize(0, com.tencent.mm.cb.a.ab(this.uMN, a.e.ActionBarTextSize) * com.tencent.mm.cb.a.ff(this.uMN));
    }
    czA();
    updateDescription(paramString);
  }
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.uMD = paramBoolean;
    if ((this.uMy == null) && (this.contentView != null)) {
      this.uMy = this.contentView.findViewById(a.g.mm_trans_layer);
    }
    if (this.uMy == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    ??? = this.uMy;
    boolean bool1;
    label81:
    AppCompatActivity localAppCompatActivity;
    if (!paramBoolean)
    {
      bool1 = true;
      ((View)???).setFocusable(bool1);
      ??? = this.uMy;
      if (paramBoolean) {
        break label199;
      }
      bool1 = bool2;
      ((View)???).setFocusableInTouchMode(bool1);
      if (paramBoolean) {
        break label226;
      }
      localAppCompatActivity = this.uMN;
    }
    for (;;)
    {
      synchronized (uNi)
      {
        if (wakeLock == null) {
          wakeLock = ((PowerManager)localAppCompatActivity.getSystemService("power")).newWakeLock(32, "screen Lock");
        }
        if (wakeLock.isHeld()) {
          break label204;
        }
        wakeLock.acquire();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      bool1 = false;
      break;
      label199:
      bool1 = false;
      break label81;
      label204:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
    for (;;)
    {
      synchronized (uNi)
      {
        label226:
        if ((wakeLock != null) && (wakeLock.isHeld()))
        {
          wakeLock.release();
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
          return;
        }
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
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
        if (SystemClock.elapsedRealtime() - s.k(s.this) < 300L) {
          paramRunnable.run();
        }
        s.a(s.this, SystemClock.elapsedRealtime());
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
      this.uMF = 0;
      this.uMH = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.uMG = 0;
      this.uMI = null;
    }
    for (;;)
    {
      czA();
      return;
      if (this.uMF == paramInt1) {
        break;
      }
      this.uMF = paramInt1;
      this.uMH = fj(this.mContext.getResources().getDimensionPixelSize(a.e.BigTextSize), this.uMF);
      break;
      label82:
      if (this.uMG != paramInt2)
      {
        this.uMG = paramInt2;
        this.uMI = fj(this.mContext.getResources().getDimensionPixelSize(a.e.BigTextSize), this.uMG);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uML = bool;
      czA();
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
      l(this.uMN, this.uGL);
      return;
    }
    this.mActionBar.hide();
    l(this.uMN, this.uMN.getResources().getColor(a.d.black));
  }
  
  public final void showHomeBtn(boolean paramBoolean)
  {
    if (this.mActionBar == null) {}
    do
    {
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
    } while (this.uMU == null);
    View localView = this.uMU;
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
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return;
      bool = false;
    }
    this.mActionBar.show();
  }
  
  public final void showVKB()
  {
    Object localObject = this.uMN;
    InputMethodManager localInputMethodManager = (InputMethodManager)((Activity)localObject).getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      if ((localObject != null) && (((View)localObject).getWindowToken() != null)) {
        localInputMethodManager.toggleSoftInput(0, 2);
      }
    }
  }
  
  public void supportInvalidateOptionsMenu()
  {
    this.uMN.supportInvalidateOptionsMenu();
  }
  
  public final void ta(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.uGL = paramInt;
    this.nST = an.Gf(this.uGL);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.uGL));
    l(this.uMN, this.uGL);
    czC();
    czB();
  }
  
  protected final void updateDescription(String paramString)
  {
    com.tencent.mm.ui.a.a locala = a.a.cAj();
    AppCompatActivity localAppCompatActivity = this.uMN;
    if ((locala.cAi()) || (bk.bl(paramString)) || (localAppCompatActivity == null)) {
      return;
    }
    paramString = localAppCompatActivity.getString(a.k.common_enter_activity) + paramString;
    localAppCompatActivity.getWindow().getDecorView().setContentDescription(paramString);
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = FU(paramInt);
    if (locala != null)
    {
      locala.fkl = paramOnMenuItemClickListener;
      locala.kfL = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = FU(paramInt);
    if ((locala != null) && (!bk.aM(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public static final class a
  {
    boolean aoL = true;
    boolean bIU = true;
    MenuItem.OnMenuItemClickListener fkl;
    View.OnLongClickListener kfL;
    String text;
    int textColor;
    int uHd = -1;
    int uHe;
    View uHf;
    View uHg;
    Drawable uNt;
    s.b uNu = s.b.uNw;
    boolean uNv = false;
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */