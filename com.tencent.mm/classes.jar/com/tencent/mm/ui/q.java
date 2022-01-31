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
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak.b;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class q
{
  private static PowerManager.WakeLock wakeLock = null;
  private static boolean zaR = false;
  private static final int zbd = 2130968620;
  public static long zbf;
  private static byte[] zbh = { 0 };
  private View actionbarView;
  int bcg = this.yUe;
  String className;
  View contentView;
  private com.tencent.mm.ui.tools.q eiV;
  private LayoutInflater exe;
  private AudioManager fZB;
  TextView jjS;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  protected com.tencent.mm.sdk.platformtools.ak mHV = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
  private Button mmm;
  private int nfo = 0;
  boolean qGO = false;
  private final long rXi = 300L;
  private long rXj = SystemClock.elapsedRealtime();
  private View yTS;
  private int yTU = 0;
  ImageButton yTV;
  TextView yTX;
  int yUe;
  private int yUf;
  LinkedList<a> yUg = new LinkedList();
  private TextView zaA;
  private FrameLayout zaB;
  public boolean zaC = true;
  private String zaD = " ";
  private int zaE = 0;
  private int zaF = 0;
  private com.tencent.mm.ui.widget.a zaG = null;
  private com.tencent.mm.ui.widget.a zaH = null;
  private com.tencent.mm.ui.widget.a zaI = null;
  private com.tencent.mm.ui.widget.a zaJ = null;
  private com.tencent.mm.ui.widget.a zaK = null;
  private boolean zaL = false;
  boolean zaM = false;
  private boolean zaN = false;
  public AppCompatActivity zaO;
  private boolean zaP;
  private a zaQ = new a();
  private ArrayList<Dialog> zaS;
  TextView zaT;
  View zaU;
  ImageView zaV;
  int zaW = 0;
  private ImageView zaX;
  private ViewGroup.LayoutParams zaY;
  private int zaZ = 0;
  private View zax;
  public View zay;
  private View zaz;
  private boolean zba = false;
  private c zbb = new c() {};
  private int zbc = 2130968618;
  private int zbe = -1;
  int zbg = 0;
  private a zbi;
  private MenuItem zbj;
  private Runnable zbk = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(142719);
      q.i(q.this).getWindow().setFlags(1024, 1024);
      if (q.j(q.this) != null) {
        q.j(q.this).hide();
      }
      AppMethodBeat.o(142719);
    }
  };
  private Runnable zbl = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(142720);
      if (q.j(q.this) != null) {
        q.j(q.this).show();
      }
      AppMethodBeat.o(142720);
    }
  };
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.qGO) {
      localDrawable = aj.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, al.ap(this.zaO, 2131427587), al.ap(this.zaO, 2131427587));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable);
    paramDrawable.ACa = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.yUo = paramInt1;
    locala.yUp = paramInt2;
    locala.text = paramString;
    locala.gBC = paramOnMenuItemClickListener;
    locala.mAd = paramOnLongClickListener;
    locala.zbv = paramb;
    locala.zbw = paramBoolean;
    if ((locala.yUp == 2130839668) && (bo.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(2131296998);
    }
    Of(locala.yUo);
    this.yUg.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.yUo = paramInt;
    locala.zbu = paramDrawable;
    locala.text = paramString;
    locala.gBC = paramOnMenuItemClickListener;
    locala.mAd = null;
    locala.zbv = paramb;
    Of(locala.yUo);
    this.yUg.add(locala);
    new com.tencent.mm.sdk.platformtools.ak().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142724);
        q.this.supportInvalidateOptionsMenu();
        AppMethodBeat.o(142724);
      }
    }, 200L);
  }
  
  private void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, boolean paramBoolean2)
  {
    ab.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.zaz });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.zaz == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      ab.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.zaB == null) {
      this.zaB = ((FrameLayout)this.contentView.findViewById(2131826124));
    }
    if (this.zaz != null) {
      this.zaB.removeView(this.zaz);
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.zaz = this.exe.inflate(paramInt1, null);
      this.zaA = ((TextView)this.zaz.findViewById(2131823423));
      this.zaz.findViewById(2131826285).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(106004);
          paramAnonymousView = new com.tencent.mm.g.a.ak();
          paramAnonymousView.cnA.type = 1;
          paramAnonymousView.cnA.cnC = paramString3;
          paramAnonymousView.cnA.position = paramInt2;
          com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousView);
          q.b(q.this).setVisibility(8);
          AppMethodBeat.o(106004);
        }
      });
      this.zaz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(106005);
          if (paramString1 != null)
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            paramAnonymousView.setData(Uri.parse(paramString1));
            q.c(q.this).startActivity(paramAnonymousView);
          }
          AppMethodBeat.o(106005);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.zba) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.b(this.zaO, 48.0F), 0, 0);
        ab.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.zaB.addView(this.zaz, this.zaB.getChildCount(), paramString3);
      if (this.zaz == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.zaz;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(2131300721);
          paramString3 = paramString2;
          if (bo.isNullOrNil(paramString2)) {
            paramString3 = this.mContext.getString(2131298988);
          }
          if (paramString1 == null) {
            break label488;
          }
          paramString1 = new SpannableString(paramString3 + str);
          paramString2 = new ForegroundColorSpan(-10119449);
          paramInt1 = paramString3.length();
          paramInt2 = paramString3.length();
          paramString1.setSpan(paramString2, paramInt1, str.length() + paramInt2, 33);
          this.zaA.setText(paramString1);
        }
        for (;;)
        {
          this.zaz.invalidate();
          this.zaB.invalidate();
          return;
          paramInt1 = 8;
          break;
          label488:
          ab.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.zaA.setText(paramString3);
        }
      }
      this.zaz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106006);
          Object localObject = q.b(q.this);
          int i;
          if (paramBoolean1)
          {
            i = 0;
            ((View)localObject).setVisibility(i);
            String str = q.c(q.this).getString(2131300721);
            if (!bo.isNullOrNil(paramString2)) {
              break label170;
            }
            localObject = q.c(q.this).getString(2131298988);
            label63:
            if (paramString1 == null) {
              break label178;
            }
            SpannableString localSpannableString = new SpannableString((String)localObject + str);
            localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
            q.d(q.this).setText(localSpannableString);
          }
          for (;;)
          {
            q.b(q.this).invalidate();
            q.e(q.this).invalidate();
            AppMethodBeat.o(106006);
            return;
            i = 8;
            break;
            label170:
            localObject = paramString2;
            break label63;
            label178:
            ab.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
            q.d(q.this).setText((CharSequence)localObject);
          }
        }
      });
      return;
      paramInt1 = 2130970283;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.zaC) {
      ab.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.gBC == null) {
      return;
    }
    parama.gBC.onMenuItemClick(paramMenuItem);
  }
  
  private static boolean atn(String paramString)
  {
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null)) {}
    while ((!iy(str1, paramString)) && (!iy(str2, paramString))) {
      return false;
    }
    return true;
  }
  
  private void ax(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      ab.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.yTU == 0) {
        this.yTU = dCs();
      }
      this.qGO = aj.Ow(this.yTU);
      setActionbarColor(this.yTU);
      this.mActionBar.setLogo(new ColorDrawable(this.zaO.getResources().getColor(17170445)));
      this.mActionBar.eu();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.et();
      this.mActionBar.ev();
      this.mActionBar.es();
      if (this.zbe != -1) {
        break label331;
      }
      localView = w.hM(this.zaO).inflate(this.zbc, new LinearLayout(this.zaO), false);
      this.mActionBar.setCustomView(localView);
      this.zaT = ((TextView)findViewById(16908308));
      this.jjS = ((TextView)findViewById(16908309));
      this.yTS = findViewById(2131820997);
      this.zaU = findViewById(2131820988);
      this.zaV = ((ImageView)findViewById(2131820989));
      this.zaU.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(142730);
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            q.zbf = System.currentTimeMillis();
          }
          AppMethodBeat.o(142730);
          return false;
        }
      });
      if (this.zaV != null) {
        this.zaV.setContentDescription(this.zaO.getString(2131296546));
      }
      if (this.zaT != null) {
        this.zaT.setText(2131297005);
      }
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label369;
      }
      if (this.zaV != null) {
        this.zaV.setVisibility(0);
      }
      if (this.zaU != null) {
        this.zaU.setVisibility(0);
      }
    }
    for (;;)
    {
      dCu();
      return;
      label331:
      localView = w.hM(this.zaO).inflate(this.zbe, new LinearLayout(this.zaO), false);
      this.mActionBar.setCustomView(localView);
      break;
      label369:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.zaV != null) {
          this.zaV.setVisibility(0);
        }
        if (this.zaU != null) {
          this.zaU.setVisibility(0);
        }
        if (this.zaT != null)
        {
          this.zaT.setVisibility(0);
          af.a(this.zaT.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.zaV != null) {
          this.zaV.setVisibility(8);
        }
        if (this.zaU != null) {
          this.zaU.setVisibility(8);
        }
      }
    }
  }
  
  private static boolean dCw()
  {
    return (atn("y83a")) || (atn("y83")) || (atn("v1732a")) || (atn("v1732t"));
  }
  
  private static void fe(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        int i = 0;
        while (i < 3)
        {
          Object localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
          try
          {
            localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
            ((Field)localObject1).setAccessible(true);
            Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
            if ((localObject2 != null) && ((localObject2 instanceof View)) && (((View)localObject2).getContext() == paramContext)) {
              ((Field)localObject1).set(localInputMethodManager, null);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.MMActivityController", localThrowable, "", new Object[0]);
            }
          }
          i += 1;
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
    return this.zaO.findViewById(paramInt);
  }
  
  private void hH(Context paramContext)
  {
    synchronized (zbh)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(32, "screen Lock");
      }
      if (!wakeLock.isHeld())
      {
        wakeLock.acquire();
        ab.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      ab.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  private com.tencent.mm.ui.widget.a hq(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.qGO) {
      localDrawable = aj.g(this.zaO, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.ACa = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return initLanguage(paramContext, aa.f(paramContext.getSharedPreferences(ah.dsP(), 0)));
  }
  
  public static Locale initLanguage(Context paramContext, String paramString)
  {
    if (paramString.equals("language_default"))
    {
      aa.a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    paramString = aa.apg(paramString);
    aa.a(paramContext, paramString);
    return paramString;
  }
  
  private static boolean iy(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return bo.isEqual(paramString1.toLowerCase(), paramString2.toLowerCase());
  }
  
  private void releaseWakeLock()
  {
    synchronized (zbh)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        wakeLock.release();
        ab.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        wakeLock = null;
        return;
      }
      ab.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  public static void setMainProcess()
  {
    zaR = true;
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
  
  final boolean Of(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.yUg.size())
      {
        if (((a)this.yUg.get(i)).yUo == paramInt)
        {
          ab.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.yUg.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a Og(int paramInt)
  {
    Iterator localIterator = this.yUg.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.yUo == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.zaO = paramAppCompatActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = this.zaO.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      this.zaO.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    boolean bool = ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
    ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).getBoolean("dark_actionbar", false);
    if (!bool)
    {
      ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
      ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
    }
    onCreateBeforeSetContentView();
    this.className = getClass().getName();
    ad.bK(3, this.className);
    initLanguage(paramContext);
    this.fZB = ((AudioManager)this.mContext.getSystemService("audio"));
    int i = getLayoutId();
    this.exe = LayoutInflater.from(this.mContext);
    com.tencent.mm.kiss.a.b.SH();
    this.contentView = com.tencent.mm.kiss.a.b.b(paramAppCompatActivity, 2130970138);
    this.zax = this.contentView.findViewById(2131826125);
    this.zaB = ((FrameLayout)this.contentView.findViewById(2131826124));
    this.nfo = this.mContext.getResources().getDimensionPixelSize(2131427848);
    label524:
    label671:
    long l;
    if (i != -1)
    {
      this.zay = getLayoutView();
      if (this.zay == null)
      {
        this.zay = this.exe.inflate(getLayoutId(), null);
        this.zaB.addView(this.zay, 0);
      }
    }
    else
    {
      dealContentView(this.contentView);
      if (fromFullScreenActivity())
      {
        af.h(af.a(this.zaO.getWindow(), this.zay), this.zay);
        ((ViewGroup)this.zay.getParent()).removeView(this.zay);
        ((ViewGroup)this.zaO.getWindow().getDecorView()).addView(this.zay, 0);
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label926;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131427558);
        this.zay.setPadding(this.zay.getPaddingLeft(), i + (j + this.zay.getPaddingTop()), this.zay.getPaddingRight(), this.zay.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      ab.d("MicroMsg.MMActivityController", "onCreate, before.");
      ax(paramAppCompatActivity);
      this.yUe = al.ap(this.mContext, 2131427559);
      this.yUf = al.ap(this.mContext, 2131427845);
      if (this.zaB != null) {
        this.zaB.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(142727);
            q.e(q.this).removeOnAttachStateChangeListener(this);
            com.tencent.mm.kiss.a.b.SI();
            AppMethodBeat.o(142727);
          }
        });
      }
      if ((this.zaB == null) || (!(this.zaB instanceof LayoutListenerView))) {
        break label943;
      }
      ((LayoutListenerView)this.zaB).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int zbs;
        
        public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(142729);
          if (q.f(q.this))
          {
            AppMethodBeat.o(142729);
            return;
          }
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
          {
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.zbs))
            {
              q.g(q.this);
              AppMethodBeat.o(142729);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.zbs)) {
              q.h(q.this);
            }
          }
          AppMethodBeat.o(142729);
        }
      });
      paramContext = new com.tencent.mm.g.a.ak();
      paramContext.cnA.type = 2;
      paramContext.cnA.position = this.zaZ;
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      if (paramContext.cnB.cnE == 2)
      {
        l = System.currentTimeMillis();
        localObject = paramContext.cnB.cnG;
        i = paramContext.cnB.position;
        ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject, bo.dtY() });
        if ((i <= 0) || (i == this.zaZ)) {
          break label955;
        }
        ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.zaZ) });
      }
    }
    for (;;)
    {
      ab.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.yTU == 0) {
          this.yTU = dCs();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        n(paramAppCompatActivity, this.yTU);
        dCv();
      }
      return;
      if (this.zay.getParent() == null) {
        break;
      }
      ((ViewGroup)this.zay.getParent()).removeView(this.zay);
      break;
      label926:
      i = this.mContext.getResources().getDimensionPixelSize(2131427559);
      break label524;
      label943:
      ab.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label671;
      label955:
      a(paramContext.cnB.cnF, paramContext.cnB.arf, paramContext.cnB.url, paramContext.cnB.desc, (String)localObject, i, true);
    }
  }
  
  public final void a(a parama)
  {
    Of(parama.yUo);
    this.yUg.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  public final void aF(int paramInt, boolean paramBoolean)
  {
    this.zaZ = paramInt;
    this.zba = paramBoolean;
  }
  
  public final void activateBroadcast(boolean paramBoolean)
  {
    if ((!zaR) && (paramBoolean))
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
    if (this.zaS == null) {
      this.zaS = new ArrayList();
    }
    this.zaS.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.zbx);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.zbx);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.zbx);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.zbx);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.zbx);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.zbx);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.zbx);
  }
  
  public final void addSearchMenu(boolean paramBoolean, com.tencent.mm.ui.tools.q paramq)
  {
    ab.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.yUo = 2131820646;
    locala.text = this.mContext.getString(2131297065);
    locala.yUp = 2131230741;
    locala.gBC = null;
    locala.mAd = null;
    removeOptionMenu(locala.yUo);
    this.yUg.add(0, locala);
    this.zaP = paramBoolean;
    this.eiV = paramq;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.zbx);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.zbx);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public final boolean callBackMenu()
  {
    if ((this.zaQ != null) && (this.zaQ.enable))
    {
      a(null, this.zaQ);
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
      localIterator = this.yUg.iterator();
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
      localIterator = this.yUg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.yUo != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.eiV == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.eiV.Axb)
        {
          if (!paramBoolean1) {
            supportInvalidateOptionsMenu();
          }
          ab.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final ActionBar dCr()
  {
    return this.mActionBar;
  }
  
  public final int dCs()
  {
    this.qGO = false;
    if (this.yTU == 0) {
      this.yTU = this.mContext.getResources().getColor(2131690316);
    }
    return this.yTU;
  }
  
  final void dCt()
  {
    Object localObject1 = "%s";
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131427493);
    if (this.zaE != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.zaF != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int j = 1;; j = 0)
    {
      if ((!this.zaM) && (this.zaL))
      {
        localObject1 = (String)localObject1 + " #";
        j += 2;
      }
      for (int i = 1;; i = 0)
      {
        if (this.zaM)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
        }
        for (int k = 1;; k = 0)
        {
          int n;
          int m;
          if (this.zaN)
          {
            localObject1 = (String)localObject1 + " #";
            n = i + 2;
            i = 1;
            m = j + 2;
            j = n;
          }
          for (;;)
          {
            Object localObject2 = String.format((String)localObject1, new Object[] { this.zaD });
            ab.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
            localObject1 = com.tencent.mm.ui.f.c.b.h(this.mContext, (CharSequence)localObject2, i1);
            if ((localObject1 instanceof SpannableString))
            {
              localObject2 = (SpannableString)localObject1;
              if (this.zaE != 0) {
                ((SpannableString)localObject2).setSpan(this.zaG, 0, 1, 33);
              }
              if (this.zaF != 0)
              {
                m = ((SpannableString)localObject2).length() - m;
                ((SpannableString)localObject2).setSpan(this.zaH, m, m + 1, 33);
              }
              if (this.zaM)
              {
                if (this.zaJ == null) {
                  this.zaJ = hq(i1, 2131231086);
                }
                k = ((SpannableString)localObject2).length() - k;
                ((SpannableString)localObject2).setSpan(this.zaJ, k, k + 1, 33);
              }
              if ((!this.zaM) && (this.zaL))
              {
                if (this.zaI == null) {
                  this.zaI = a(i1, aj.g(this.zaO, 2131231488, this.zaO.getResources().getColor(2131689494)));
                }
                j = ((SpannableString)localObject2).length() - j;
                ((SpannableString)localObject2).setSpan(this.zaI, j, j + 1, 33);
              }
              if (this.zaN)
              {
                if (this.zaK == null) {
                  this.zaK = hq(i1, 2131231089);
                }
                i = ((SpannableString)localObject2).length() - i;
                ((SpannableString)localObject2).setSpan(this.zaK, i, i + 1, 33);
              }
            }
            this.zaT.setText((CharSequence)localObject1);
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
  
  final void dCu()
  {
    if (this.qGO)
    {
      if (this.zaV != null)
      {
        this.zaV.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.zaU.setBackgroundResource(2130840228);
      }
      if ((this.zaT != null) && (this.zaT.getVisibility() == 0)) {
        this.zaT.setTextColor(this.mContext.getResources().getColor(2131690711));
      }
      if ((this.jjS != null) && (this.jjS.getVisibility() == 0)) {
        this.jjS.setTextColor(this.mContext.getResources().getColor(2131690711));
      }
      if ((this.yTV != null) && (this.yTV.getVisibility() == 0)) {
        if (this.yTV.getDrawable() != null) {
          this.yTV.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.yTV.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
      } while ((this.yTX == null) || (this.yTX.getVisibility() != 0));
      this.yTX.setTextColor(com.tencent.mm.cb.a.l(this.mContext, 2131690799));
      return;
      if (this.zaV != null)
      {
        this.zaV.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.zaU.setBackgroundResource(2130837631);
      }
      if ((this.zaT != null) && (this.zaT.getVisibility() == 0)) {
        this.zaT.setTextColor(this.mContext.getResources().getColor(2131689766));
      }
      if ((this.jjS != null) && (this.jjS.getVisibility() == 0)) {
        this.jjS.setTextColor(this.mContext.getResources().getColor(2131689766));
      }
      if ((this.yTV != null) && (this.yTV.getVisibility() == 0))
      {
        if (this.yTV.getDrawable() != null)
        {
          this.yTV.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        this.yTV.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        return;
      }
    } while ((this.yTX == null) || (this.yTX.getVisibility() != 0));
    this.yTX.setTextColor(com.tencent.mm.cb.a.l(this.mContext, 2131690741));
  }
  
  final void dCv()
  {
    qq(this.qGO);
  }
  
  protected abstract void dealContentView(View paramView);
  
  public final void disableMultiTouch()
  {
    if ((this.zaB instanceof LayoutListenerView)) {
      ((LayoutListenerView)this.zaB).zad = true;
    }
  }
  
  final void e(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.yUg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label125;
      }
      locala = (a)localIterator.next();
      if (locala.arf == paramBoolean2) {
        break label197;
      }
      locala.arf = paramBoolean2;
      paramBoolean1 = true;
    }
    label194:
    label197:
    for (;;)
    {
      break;
      localIterator = this.yUg.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.yUo != paramInt) || (locala.arf == paramBoolean2)) {
          break label194;
        }
        locala.arf = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.eiV == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.eiV.Axb)
        {
          if ((bool) && (!paramBoolean1)) {
            supportInvalidateOptionsMenu();
          }
          ab.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          return;
        }
      }
    }
  }
  
  public final void enableBackMenu(boolean paramBoolean)
  {
    if (this.zaQ == null) {}
    while (this.zaQ.enable == paramBoolean) {
      return;
    }
    this.zaQ.enable = paramBoolean;
    supportInvalidateOptionsMenu();
  }
  
  public final void enableMultiTouch()
  {
    if ((this.zaB instanceof LayoutListenerView)) {
      ((LayoutListenerView)this.zaB).zad = false;
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
      this.mHV.removeCallbacks(this.zbl);
      this.mHV.removeCallbacks(this.zbk);
      this.mHV.postDelayed(this.zbk, 256L);
      return;
    }
    this.zaO.getWindow().clearFlags(1024);
    this.mHV.removeCallbacks(this.zbk);
    this.mHV.removeCallbacks(this.zbl);
    this.mHV.postDelayed(this.zbl, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.mHV.removeCallbacks(this.zbl);
      this.mHV.removeCallbacks(this.zbk);
      this.mHV.postDelayed(this.zbk, paramLong);
      return;
    }
    this.zaO.getWindow().clearFlags(1024);
    this.mHV.removeCallbacks(this.zbk);
    this.mHV.removeCallbacks(this.zbl);
    this.mHV.postDelayed(this.zbl, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.zaO.getWindow().setFlags(1024, 1024);
      return;
    }
    this.zaO.getWindow().clearFlags(1024);
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
    if (this.zaD != null) {
      return this.zaD;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.fZB.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.fZB.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.zaO.getSupportActionBar();
  }
  
  public final int getTitleLocation()
  {
    if (this.mActionBar == null) {
      return 0;
    }
    return this.mActionBar.getHeight();
  }
  
  public final void hI(Context paramContext)
  {
    com.tencent.mm.sdk.b.a.ymk.d(this.zbb);
    if (this.zaS != null)
    {
      int j = this.zaS.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.zaS.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.zaS.clear();
      this.zaS = null;
    }
    fe(paramContext);
  }
  
  public final void hideTitleView()
  {
    boolean bool = true;
    if (this.mActionBar != null) {}
    for (;;)
    {
      ab.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
        localObject = this.zaO.getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      ab.v("MicroMsg.MMActivityController", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMActivityController", "hide VKB exception %s", new Object[] { localIllegalArgumentException });
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
        ab.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
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
      ab.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.mActionBar != null) {
        break;
      }
      return false;
      bool = false;
    }
    return this.mActionBar.isShowing();
  }
  
  @TargetApi(21)
  public final void n(Activity paramActivity, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.h.Mo())) {}
    for (;;)
    {
      if (((paramActivity instanceof MMActivity)) && (((MMActivity)paramActivity).fixStatusbar) && (((MMActivity)paramActivity).isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.statusbar.a.d(this.contentView, paramInt, d.b(paramActivity.getWindow()));
      }
      for (;;)
      {
        setNavigationbarColor(this.zaO.getResources().getColor(2131689499));
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label120;
        }
        paramInt = aj.n(paramActivity.getResources().getColor(2131690523), paramInt);
        break;
        paramActivity.getWindow().setStatusBarColor(paramInt);
      }
      label120:
      paramInt = 0;
    }
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
    ab.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.yUg.size()) });
    boolean bool1;
    if ((this.mActionBar == null) || (this.yUg.size() == 0))
    {
      ab.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.yUg.size()) });
      bool1 = false;
      return bool1;
    }
    this.zbi = null;
    this.zbj = null;
    Object localObject1;
    if (this.mActionBar.getHeight() == 0)
    {
      localObject1 = this.mContext.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label190;
      }
      this.mContext.getResources().getDimensionPixelSize(2131427558);
    }
    final a locala;
    for (;;)
    {
      localObject1 = this.yUg.iterator();
      for (;;)
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.yUo != 16908332) {
          break label207;
        }
        ab.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label190:
      this.mContext.getResources().getDimensionPixelSize(2131427559);
    }
    label207:
    if (locala.yUo == 2131820646)
    {
      boolean bool3 = this.zaP;
      if (this.eiV == null) {}
      for (bool1 = true;; bool1 = false)
      {
        ab.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if ((!this.zaP) || (this.eiV == null)) {
          break;
        }
        this.eiV.a(this.zaO, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.yUo, 0, locala.text);
    com.tencent.mm.compatible.i.a.a(localMenuItem, getClass().getName());
    View.OnClickListener local19 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142732);
        q.a(q.this, localMenuItem, locala);
        AppMethodBeat.o(142732);
      }
    };
    View.OnLongClickListener local2 = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142717);
        boolean bool = q.a(q.this, paramAnonymousView, locala);
        AppMethodBeat.o(142717);
        return bool;
      }
    };
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142718);
        boolean bool = q.a(q.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
        AppMethodBeat.o(142718);
        return bool;
      }
    };
    if ((locala.yUp != 0) || (locala.zbu != null))
    {
      if (locala.yUr == null) {
        locala.yUr = View.inflate(this.mContext, 2130968612, null);
      }
      localObject2 = (ImageView)locala.yUr.findViewById(2131821148);
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      this.yTV = ((ImageButton)locala.yUr.findViewById(2131820976));
      this.yTV.setVisibility(0);
      if (locala.zbu != null)
      {
        this.yTV.setImageDrawable(locala.zbu);
        label479:
        if (this.zaW == 0) {
          break label736;
        }
        this.yTV.getDrawable().setColorFilter(this.zaW, PorterDuff.Mode.SRC_ATOP);
        label503:
        this.yTV.setOnClickListener(local19);
        this.yTV.setEnabled(locala.enable);
        this.yTV.setContentDescription(locala.text);
        if (locala.mAd != null) {
          this.yTV.setOnLongClickListener(local2);
        }
        this.zaX = ((ImageView)locala.yUr.findViewById(2131820977));
        if (this.zaX != null)
        {
          if (!locala.zbw) {
            break label787;
          }
          this.zaX.setVisibility(0);
        }
      }
      for (;;)
      {
        localMenuItem.setActionView(locala.yUr);
        localMenuItem.setEnabled(locala.enable);
        localMenuItem.setVisible(locala.arf);
        localMenuItem.setShowAsAction(2);
        if (locala.yUp == 2130839668)
        {
          this.zbi = locala;
          this.zbj = localMenuItem;
        }
        ab.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.yUo), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.arf) });
        break;
        this.yTV.setImageResource(locala.yUp);
        break label479;
        label736:
        if (locala.zbt != 0) {
          break label503;
        }
        if (this.qGO)
        {
          this.yTV.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
          break label503;
        }
        this.yTV.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        break label503;
        label787:
        this.zaX.setVisibility(8);
      }
    }
    if (locala.yUq == null) {
      locala.yUq = View.inflate(this.mContext, 2130968612, null);
    }
    this.yTX = ((TextView)locala.yUq.findViewById(2131820974));
    this.yTX.setVisibility(0);
    this.mmm = ((Button)locala.yUq.findViewById(2131820975));
    this.mmm.setVisibility(8);
    if ((locala.zbv == b.zbz) || (locala.zbv == b.zbC))
    {
      this.yTX.setTextColor(com.tencent.mm.cb.a.l(this.zaO, 2131690784));
      this.mmm.setVisibility(0);
      this.mmm.setBackgroundResource(2130838049);
      this.yTX.setVisibility(8);
    }
    for (;;)
    {
      this.yTX.setText(locala.text);
      if (locala.textColor != 0) {
        this.yTX.setTextColor(locala.textColor);
      }
      this.yTX.setOnClickListener(local19);
      this.yTX.setOnLongClickListener(local2);
      this.yTX.setEnabled(locala.enable);
      this.yTX.setOnTouchListener((View.OnTouchListener)localObject2);
      this.mmm.setText(locala.text);
      this.mmm.setOnClickListener(local19);
      this.mmm.setOnLongClickListener(local2);
      this.mmm.setOnTouchListener((View.OnTouchListener)localObject2);
      this.mmm.setEnabled(locala.enable);
      localMenuItem.setActionView(locala.yUq);
      break;
      if ((locala.zbv == b.zby) || (locala.zbv == b.zbD))
      {
        this.mmm.setVisibility(0);
        this.mmm.setBackgroundResource(2130838046);
        this.yTX.setVisibility(8);
      }
      else
      {
        if (locala.zbv != b.zbA)
        {
          if (locala.zbv == b.zbF)
          {
            this.yTX.setTextColor(this.zaO.getResources().getColor(2131690246));
            continue;
          }
          if (locala.zbv == b.zbE)
          {
            this.yTX.setTextColor(-2601405);
            continue;
          }
          if (locala.zbv == b.zbI)
          {
            this.mmm.setVisibility(0);
            this.mmm.setBackgroundResource(2130838051);
            this.yTX.setVisibility(8);
            continue;
          }
          if (this.zaW != 0)
          {
            this.yTX.setTextColor(this.zaW);
            continue;
          }
          if (this.qGO)
          {
            this.yTX.setTextColor(com.tencent.mm.cb.a.l(this.zaO, 2131690799));
            continue;
          }
        }
        this.yTX.setTextColor(com.tencent.mm.cb.a.l(this.zaO, 2131690741));
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.KG();
    com.tencent.mm.compatible.b.g.KG();
    if ((this.zaP) && (this.eiV != null) && (this.eiV.onKeyDown(paramInt, paramKeyEvent)))
    {
      ab.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.qGO) {
        setActionbarColor(this.zaO.getResources().getColor(2131689915));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.zaO.getResources().getColor(2131690316));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.zbi != null) && (this.zbi.enable)) {
        a(this.zbj, this.zbi);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ab.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.zaC)
    {
      ab.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.zaQ.yUo) && (this.zaQ.enable))
    {
      a(paramMenuItem, this.zaQ);
      return true;
    }
    Iterator localIterator = this.yUg.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.yUo)
      {
        ab.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        return true;
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    activateBroadcast(false);
    com.tencent.mm.sdk.b.a.ymk.d(this.zbb);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ab.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.zaP) && (this.eiV != null)) {
      this.eiV.a(this.zaO, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    com.tencent.mm.sdk.b.a.ymk.c(this.zbb);
    Object localObject1 = new com.tencent.mm.g.a.ak();
    ((com.tencent.mm.g.a.ak)localObject1).cnA.type = 2;
    ((com.tencent.mm.g.a.ak)localObject1).cnA.position = this.zaZ;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    long l;
    Object localObject2;
    int i;
    if (((com.tencent.mm.g.a.ak)localObject1).cnB.cnE == 2)
    {
      l = System.currentTimeMillis();
      localObject2 = ((com.tencent.mm.g.a.ak)localObject1).cnB.cnG;
      i = ((com.tencent.mm.g.a.ak)localObject1).cnB.position;
      ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), localObject2 });
      if ((i <= 0) || (i == this.zaZ)) {
        break label437;
      }
      ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.zaZ) });
    }
    for (;;)
    {
      ab.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.g.RG()) && (com.tencent.mm.kernel.g.RJ().eHg) && (!ah.getContext().getSharedPreferences(ah.dsP() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cb.a.dr(ah.getContext())) {
          break;
        }
        if (1.0F != ah.getContext().getResources().getConfiguration().fontScale)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(15181, new Object[] { Integer.valueOf(1) });
          localObject1 = new e.a(ah.getContext());
          localObject2 = ((e.a)localObject1).aj(this.zaO.getResources().getString(2131300118)).avu(this.zaO.getResources().getString(2131300115));
          ((e.a)localObject2).AHs = this.zaO.getResources().getString(2131300117);
          ((e.a)localObject2).AHt = this.zaO.getResources().getString(2131300116);
          ((e.a)localObject1).c(new e.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(142731);
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.h.qsU.e(15181, new Object[] { Integer.valueOf(3) });
                paramAnonymousString = new Intent();
                paramAnonymousString.setClassName(ah.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                paramAnonymousString.addFlags(268435456);
                ah.getContext().startActivity(paramAnonymousString);
                AppMethodBeat.o(142731);
                return;
              }
              com.tencent.mm.plugin.report.service.h.qsU.e(15181, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(142731);
            }
          }).show();
          ah.getContext().getSharedPreferences(ah.dsP() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label437:
      a(((com.tencent.mm.g.a.ak)localObject1).cnB.cnF, ((com.tencent.mm.g.a.ak)localObject1).cnB.arf, ((com.tencent.mm.g.a.ak)localObject1).cnB.url, ((com.tencent.mm.g.a.ak)localObject1).cnB.desc, (String)localObject2, i, true);
    }
    ah.getContext().getSharedPreferences(ah.dsP() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
  }
  
  public final void onStart()
  {
    this.landscapeMode = this.mContext.getSharedPreferences(ah.dsP(), 0).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      this.zaO.setRequestedOrientation(-1);
      return;
    }
    this.zaO.setRequestedOrientation(1);
  }
  
  public final void qq(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.zaO.getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      ab.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public final void removeAllOptionMenu()
  {
    if (this.yUg.isEmpty()) {
      return;
    }
    this.yUg.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.yUg.size())
      {
        if (((a)this.yUg.get(i)).yUo == paramInt)
        {
          ab.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.yUg.remove(i);
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
    this.yTU = paramInt;
    this.qGO = aj.Ow(this.yTU);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yTU));
    n(this.zaO, this.yTU);
    dCv();
    dCu();
  }
  
  public final void setActionbarHeight(int paramInt)
  {
    int i = paramInt;
    if (paramInt > this.yUe) {
      i = this.yUe;
    }
    paramInt = i;
    if (i < this.yUf) {
      paramInt = this.yUf;
    }
    this.bcg = paramInt;
    this.actionbarView = this.zaO.getWindow().getDecorView().findViewById(2131820956);
    if (this.actionbarView != null) {
      this.zaY = this.actionbarView.getLayoutParams();
    }
    if ((this.actionbarView != null) && (this.zaY != null))
    {
      this.zaY.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
      this.actionbarView.setLayoutParams(this.zaY);
    }
    float f1 = Math.min(com.tencent.mm.cb.a.dr(this.zaO), com.tencent.mm.cb.a.gr(this.zaO));
    i = (int)(al.ap(this.mContext, 2131427856) * f1);
    int j = (int)(f1 * al.ap(this.mContext, 2131427810));
    int k = al.fromDPToPix(this.mContext, 14);
    f1 = (paramInt - this.yUf) / (this.yUe - this.yUf);
    float f2 = i;
    float f3 = j - i;
    setIconAlpha(f1);
    paramInt = (int)((k - al.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
    i = (int)((this.yUf - this.yUe) / 2.0F * (1.0F - f1));
    if (this.zaT != null)
    {
      this.zaT.setTextSize(0, f3 * f1 + f2);
      if (this.yTS != null)
      {
        this.yTS.setTranslationX(paramInt);
        this.yTS.setTranslationY(i);
      }
    }
    if (this.zaV != null) {
      this.zaV.setTranslationY(i);
    }
    if (this.yTV != null) {
      this.yTV.setTranslationY(i);
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
      if (paramInt == 0)
      {
        i = paramInt;
        if (this.zaV.getDrawable() == null) {
          i = 2131230737;
        }
      }
      if ((this.zaV != null) && (i != 0)) {
        this.zaV.setImageResource(i);
      }
      this.zaQ.yUo = 16908332;
      this.zaQ.gBC = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.zaU != null) {
        this.zaU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(142723);
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142722);
                q.8.this.ksX.onMenuItemClick(null);
                AppMethodBeat.o(142722);
              }
            });
            AppMethodBeat.o(142723);
          }
        });
      }
    }
  }
  
  public final void setBackBtnColorFilter(int paramInt)
  {
    if (this.zaV != null) {
      this.zaV.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.zaV == null) {
      return;
    }
    if (paramBoolean)
    {
      this.zaV.setVisibility(0);
      return;
    }
    this.zaV.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.zaB == null) {
      this.zaB = ((FrameLayout)this.contentView.findViewById(2131826124));
    }
    this.zaB.setBackgroundResource(paramInt);
    this.zay.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.zaB == null) {
      this.zaB = ((FrameLayout)this.contentView.findViewById(2131826124));
    }
    if (this.zaz != null) {
      this.zaB.removeView(this.zaz);
    }
    this.zaB.removeView(this.zay);
    this.zay = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.zaB.addView(this.zay, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.zaz != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.b.b(this.mContext, 47.0F));
      this.zaB.addView(this.zaz, this.zaB.getChildCount(), localLayoutParams);
    }
    this.zaB.invalidate();
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.zaU != null)
    {
      this.zaU.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.zaU.setEnabled(false);
    }
    for (;;)
    {
      if (this.yTV != null)
      {
        this.yTV.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.yTV.setEnabled(false);
      }
      return;
      label59:
      this.zaU.setEnabled(true);
    }
    this.yTV.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      ax(this.zaO);
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
        this.mActionBar.setCustomView(zbd);
        localTextView = (TextView)this.mActionBar.getCustomView().findViewById(2131821000);
      } while (localTextView == null);
      localTextView.clearAnimation();
      if (paramAnimation != null) {
        localTextView.startAnimation(paramAnimation);
      }
    } while (bo.isNullOrNil(paramString));
    localTextView.setText(paramString);
  }
  
  public final void setMMSubTitle(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.jjS.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cb.a.gt(this.zaO))
    {
      this.jjS.setTextSize(1, 14.0F);
      this.zaT.setTextSize(1, 18.0F);
    }
    this.jjS.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.jjS.setVisibility(8);
      return;
    }
    this.jjS.setText(paramString);
    if (com.tencent.mm.cb.a.gt(this.zaO))
    {
      this.jjS.setTextSize(1, 14.0F);
      this.zaT.setTextSize(1, 18.0F);
    }
    this.jjS.setVisibility(0);
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
    this.zaD = paramCharSequence.toString();
    this.zaT.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.gt(this.zaO)) {
      this.zaT.setTextSize(0, com.tencent.mm.cb.a.ap(this.zaO, 2131427493) * com.tencent.mm.cb.a.gr(this.zaO));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.zaD = paramString;
    if (com.tencent.mm.cb.a.gt(this.zaO)) {
      this.zaT.setTextSize(0, com.tencent.mm.cb.a.ap(this.zaO, 2131427493) * com.tencent.mm.cb.a.gr(this.zaO));
    }
    dCt();
    updateDescription(paramString);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!dCw()))
    {
      this.zaO.getWindow().setNavigationBarColor(paramInt);
      boolean bool = aj.Ow(paramInt);
      localView = this.zaO.getWindow().getDecorView();
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
    this.zaC = paramBoolean;
    if ((this.zax == null) && (this.contentView != null)) {
      this.zax = this.contentView.findViewById(2131826125);
    }
    if (this.zax == null)
    {
      ab.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.zax;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.zax;
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
      hH(this.zaO);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
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
        AppMethodBeat.i(106001);
        if (SystemClock.elapsedRealtime() - q.k(q.this) < 300L) {
          paramRunnable.run();
        }
        q.a(q.this, SystemClock.elapsedRealtime());
        AppMethodBeat.o(106001);
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
      this.zaE = 0;
      this.zaG = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.zaF = 0;
      this.zaH = null;
    }
    for (;;)
    {
      dCt();
      return;
      if (this.zaE == paramInt1) {
        break;
      }
      this.zaE = paramInt1;
      this.zaG = hq(this.mContext.getResources().getDimensionPixelSize(2131427501), this.zaE);
      break;
      label82:
      if (this.zaF != paramInt2)
      {
        this.zaF = paramInt2;
        this.zaH = hq(this.mContext.getResources().getDimensionPixelSize(2131427501), this.zaF);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zaL = bool;
      dCt();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zaN = bool;
      dCt();
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
      n(this.zaO, this.yTU);
      return;
    }
    this.mActionBar.hide();
    n(this.zaO, this.zaO.getResources().getColor(2131689763));
  }
  
  public final void showHomeBtn(boolean paramBoolean)
  {
    if (this.mActionBar == null) {}
    do
    {
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
    } while (this.zaU == null);
    View localView = this.zaU;
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
      ab.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
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
    this.zaO.supportInvalidateOptionsMenu();
  }
  
  public final void updateBackBtn(Drawable paramDrawable)
  {
    if (this.mActionBar == null) {}
    while ((this.zaV == null) || (paramDrawable == null)) {
      return;
    }
    this.zaV.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.dDt().k(this.zaO, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = Og(paramInt1);
    if ((locala != null) && (locala.yUp != paramInt2))
    {
      locala.yUp = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = Og(paramInt);
    if (locala != null)
    {
      locala.gBC = paramOnMenuItemClickListener;
      locala.mAd = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = Og(paramInt);
    if ((locala != null) && (!bo.bf(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public static final class a
  {
    public boolean arf = true;
    public boolean enable = true;
    public MenuItem.OnMenuItemClickListener gBC;
    public View.OnTouchListener jVU;
    public View.OnLongClickListener mAd;
    public String text;
    public int textColor;
    public int yUo = -1;
    public int yUp;
    public View yUq;
    public View yUr;
    public int zbt = 0;
    public Drawable zbu;
    public q.b zbv = q.b.zbx;
    public boolean zbw = false;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(106015);
      zbx = new b("NORMAL", 0);
      zby = new b("GREEN", 1);
      zbz = new b("RED", 2);
      zbA = new b("BLACK", 3);
      zbB = new b("TRANSPARENT", 4);
      zbC = new b("TRANSPARENT_RED_TEXT", 5);
      zbD = new b("TRANSPARENT_GREEN_TEXT", 6);
      zbE = new b("GOLDEN", 7);
      zbF = new b("TRANSPARENT_GOLD_TEXT", 8);
      zbG = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      zbH = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      zbI = new b("YELLOW", 11);
      zbJ = new b[] { zbx, zby, zbz, zbA, zbB, zbC, zbD, zbE, zbF, zbG, zbH, zbI };
      AppMethodBeat.o(106015);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */