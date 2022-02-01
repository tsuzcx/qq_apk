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
import android.view.ViewGroup.MarginLayoutParams;
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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ar.b;
import com.tencent.mm.g.a.yg;
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
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class t
{
  public static long OGB;
  private static byte[] OGD = { 0 };
  private static boolean OGi = false;
  private static final int OGz = 2131492949;
  private static PowerManager.WakeLock wakeLock = null;
  private final long EKO = 300L;
  private long EKP = SystemClock.elapsedRealtime();
  public View GDE;
  private int IUs = 0;
  private View OFP;
  private View OFQ;
  private TextView OFR;
  private FrameLayout OFS;
  public boolean OFT = true;
  private String OFU = " ";
  private int OFV = 0;
  private int OFW = 0;
  private com.tencent.mm.ui.widget.a OFX = null;
  private com.tencent.mm.ui.widget.a OFY = null;
  private com.tencent.mm.ui.widget.a OFZ = null;
  private int OGA = -1;
  int OGC = 0;
  private a OGE;
  private MenuItem OGF;
  private Runnable OGH = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(205112);
      t.m(t.this).getWindow().setFlags(1024, 1024);
      if (t.j(t.this) != null) {
        t.j(t.this).hide();
      }
      AppMethodBeat.o(205112);
    }
  };
  private Runnable OGI = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(205113);
      if (t.j(t.this) != null) {
        t.j(t.this).show();
      }
      AppMethodBeat.o(205113);
    }
  };
  private com.tencent.mm.ui.widget.a OGa = null;
  private com.tencent.mm.ui.widget.a OGb = null;
  boolean OGc = false;
  private boolean OGd = false;
  public AppCompatActivity OGe;
  boolean OGf = false;
  private boolean OGg;
  private a OGh = new a();
  public TextView OGj;
  View OGk;
  WeImageView OGl;
  ProgressBar OGm;
  int OGn = 0;
  private ImageView OGo;
  private ViewGroup.LayoutParams OGp;
  View OGq;
  AlbumChooserView OGr;
  private View OGs;
  public boolean OGt = true;
  private int OGu = 0;
  private boolean OGv = false;
  private boolean OGw = true;
  private IListener OGx = new IListener() {};
  public int OGy = 2131492946;
  View OxH;
  WeImageView OxJ;
  TextView OxL;
  private boolean OxS = false;
  int OxT;
  private int OxU;
  LinkedList<a> OxV = new LinkedList();
  private View actionbarView;
  int bIs = this.OxT;
  String className;
  View contentView;
  private boolean crv = false;
  private s gzP;
  private AudioManager jus;
  private LayoutInflater kgB;
  protected boolean landscapeMode = false;
  public ActionBar mActionBar;
  Context mContext;
  ArrayList<Dialog> ogl;
  TextView orb;
  private Button sUc;
  public int statusBarColor = -1;
  protected MMHandler wMu = new MMHandler(Looper.getMainLooper());
  private boolean zSX = false;
  
  private com.tencent.mm.ui.widget.a a(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (this.OxS) {
      localDrawable = ar.e(paramDrawable, -1);
    }
    localDrawable.setBounds(0, 0, at.aH(this.OGe, 2131165296), at.aH(this.OGe, 2131165296));
    paramDrawable = new com.tencent.mm.ui.widget.a(localDrawable);
    paramDrawable.QBM = ((localDrawable.getIntrinsicHeight() - paramInt) / 2);
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a locala = new a();
    locala.Oye = paramInt1;
    locala.Oyf = paramInt2;
    locala.text = paramString;
    locala.kjh = paramOnMenuItemClickListener;
    locala.tib = paramOnLongClickListener;
    locala.OGS = paramb;
    locala.eho = paramBoolean;
    if ((locala.Oyf == 2131233966) && (Util.isNullOrNil(paramString))) {
      locala.text = this.mContext.getString(2131755899);
    }
    akW(locala.Oye);
    this.OxV.add(locala);
    supportInvalidateOptionsMenu();
  }
  
  private void a(int paramInt, Drawable paramDrawable, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, b paramb)
  {
    a locala = new a();
    locala.Oye = paramInt;
    locala.OGR = paramDrawable;
    locala.text = paramString;
    locala.kjh = paramOnMenuItemClickListener;
    locala.tib = null;
    locala.OGS = paramb;
    akW(locala.Oye);
    this.OxV.add(locala);
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205117);
        t.this.supportInvalidateOptionsMenu();
        AppMethodBeat.o(205117);
      }
    }, 200L);
  }
  
  private void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, boolean paramBoolean2)
  {
    Log.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.OFQ });
    if (!needShowIdcError()) {
      break label63;
    }
    label63:
    while ((!paramBoolean1) && (this.OFQ == null)) {
      return;
    }
    if ((this.mActionBar != null) && (!this.mActionBar.isShowing()))
    {
      Log.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      return;
    }
    if (this.OFS == null) {
      this.OFS = ((FrameLayout)this.contentView.findViewById(2131304715));
    }
    if (this.OFQ != null) {
      this.OFS.removeView(this.OFQ);
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.OFQ = this.kgB.inflate(paramInt1, null);
      this.OFR = ((TextView)this.OFQ.findViewById(2131305558));
      this.OFQ.findViewById(2131305551).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new com.tencent.mm.g.a.ar();
          paramAnonymousView.dDD.type = 1;
          paramAnonymousView.dDD.event = paramString3;
          paramAnonymousView.dDD.position = paramInt2;
          EventCenter.instance.publish(paramAnonymousView);
          t.b(t.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141341);
        }
      });
      this.OFQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141343);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (paramString1 != null)
          {
            localObject = new Intent("android.intent.action.VIEW");
            ((Intent)localObject).setData(Uri.parse(paramString1));
            paramAnonymousView = t.c(t.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141343);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.OGv) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.OGe, 48.0F), 0, 0);
        Log.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.OFS.addView(this.OFQ, this.OFS.getChildCount(), paramString3);
      if (this.OFQ == null) {
        break;
      }
      if (paramBoolean2)
      {
        paramString3 = this.OFQ;
        if (paramBoolean1)
        {
          paramInt1 = 0;
          paramString3.setVisibility(paramInt1);
          String str = this.mContext.getString(2131761760);
          paramString3 = paramString2;
          if (Util.isNullOrNil(paramString2)) {
            paramString3 = this.mContext.getString(2131758343);
          }
          if (paramString1 == null) {
            break label488;
          }
          paramString1 = new SpannableString(paramString3 + str);
          paramString2 = new ForegroundColorSpan(-10119449);
          paramInt1 = paramString3.length();
          paramInt2 = paramString3.length();
          paramString1.setSpan(paramString2, paramInt1, str.length() + paramInt2, 33);
          this.OFR.setText(paramString1);
        }
        for (;;)
        {
          this.OFQ.invalidate();
          this.OFS.invalidate();
          return;
          paramInt1 = 8;
          break;
          label488:
          Log.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
          this.OFR.setText(paramString3);
        }
      }
      this.OFQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141344);
          Object localObject = t.b(t.this);
          int i;
          if (paramBoolean1)
          {
            i = 0;
            ((View)localObject).setVisibility(i);
            String str = t.c(t.this).getString(2131761760);
            if (!Util.isNullOrNil(paramString2)) {
              break label170;
            }
            localObject = t.c(t.this).getString(2131758343);
            label63:
            if (paramString1 == null) {
              break label178;
            }
            SpannableString localSpannableString = new SpannableString((String)localObject + str);
            localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
            t.d(t.this).setText(localSpannableString);
          }
          for (;;)
          {
            t.b(t.this).invalidate();
            t.e(t.this).invalidate();
            AppMethodBeat.o(141344);
            return;
            i = 8;
            break;
            label170:
            localObject = paramString2;
            break label63;
            label178:
            Log.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
            t.d(t.this).setText((CharSequence)localObject);
          }
        }
      });
      return;
      paramInt1 = 2131495655;
    }
  }
  
  private void a(MenuItem paramMenuItem, a parama)
  {
    if (!this.OFT) {
      Log.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
    }
    while (parama.kjh == null) {
      return;
    }
    parama.kjh.onMenuItemClick(paramMenuItem);
  }
  
  private void a(WeImageView paramWeImageView, int paramInt)
  {
    if (this.OGt)
    {
      paramWeImageView.setIconColor(paramInt);
      return;
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.clearColorFilter();
  }
  
  private void b(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.OGt)
    {
      paramDrawable.setColorFilter(paramInt, paramMode);
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  private static boolean bd(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(2130969656, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131766883))));
    return true;
  }
  
  private static boolean be(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(2130969656, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131761068))));
    return true;
  }
  
  private static boolean bf(Activity paramActivity)
  {
    if (paramActivity == null) {}
    TypedValue localTypedValue;
    do
    {
      return false;
      localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(2130969656, localTypedValue, true);
    } while ((localTypedValue.string == null) || (!localTypedValue.string.equals(paramActivity.getString(2131763746))));
    return true;
  }
  
  private void bg(Activity paramActivity)
  {
    View localView;
    if ((this.mActionBar != null) && (!noActionBar()))
    {
      Log.d("MicroMsg.MMActivityController", "onCreate, after");
      if (this.IUs == 0) {
        this.IUs = gIN();
      }
      this.OxS = ar.aln(this.IUs);
      setActionbarColor(this.IUs);
      this.mActionBar.setLogo(new ColorDrawable(this.OGe.getResources().getColor(17170445)));
      this.mActionBar.gt();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.gs();
      this.mActionBar.gu();
      this.mActionBar.gr();
      if (this.OGA != -1) {
        break label383;
      }
      localView = aa.jQ(this.OGe).inflate(this.OGy, new LinearLayout(this.OGe), false);
      this.mActionBar.setCustomView(localView);
      this.OGj = ((TextView)findViewById(16908308));
      this.orb = ((TextView)findViewById(16908309));
      this.OxH = findViewById(2131309235);
      this.OGm = ((ProgressBar)findViewById(2131306284));
      this.OGk = findViewById(2131296448);
      this.OGl = ((WeImageView)findViewById(2131296449));
      this.OGk.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(141348);
          if ((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) {
            t.OGB = System.currentTimeMillis();
          }
          AppMethodBeat.o(141348);
          return false;
        }
      });
      if (this.OGl != null) {
        this.OGl.setContentDescription(this.OGe.getString(2131755316));
      }
      if (this.OGj != null) {
        this.OGj.setText(2131755908);
      }
      this.OGq = findViewById(2131296438);
      this.OGr = ((AlbumChooserView)findViewById(2131296419));
      if (paramActivity.getClass().getName() != "WebViewUI") {
        break label421;
      }
      if (this.OGl != null) {
        this.OGl.setVisibility(0);
      }
      if (this.OGk != null) {
        this.OGk.setVisibility(0);
      }
    }
    for (;;)
    {
      gIR();
      if (this.OGy == 2131492946) {
        gIP();
      }
      return;
      label383:
      localView = aa.jQ(this.OGe).inflate(this.OGA, new LinearLayout(this.OGe), false);
      this.mActionBar.setCustomView(localView);
      break;
      label421:
      if ((paramActivity instanceof MMActivity))
      {
        if (this.OGl != null) {
          this.OGl.setVisibility(0);
        }
        if (this.OGk != null) {
          this.OGk.setVisibility(0);
        }
        if (this.OGj != null)
        {
          this.OGj.setVisibility(0);
          ao.a(this.OGj.getPaint(), 0.8F);
        }
      }
      else
      {
        if (this.OGl != null) {
          this.OGl.setVisibility(8);
        }
        if (this.OGk != null) {
          this.OGk.setVisibility(8);
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
    return this.OGe.findViewById(paramInt);
  }
  
  public static boolean gIO()
  {
    for (;;)
    {
      synchronized (OGD)
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
  
  private void gIP()
  {
    if (!this.OGw) {
      return;
    }
    this.mActionBar.getCustomView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141334);
        View localView = t.j(t.this).getCustomView();
        int i;
        int j;
        if ((localView != null) && (localView.getMeasuredWidth() != 0))
        {
          i = com.tencent.mm.cb.a.jn(localView.getContext());
          j = localView.getMeasuredWidth();
          if ((!ao.gJK()) || (t.k(t.this) == null)) {
            break label178;
          }
          i = t.k(t.this).getMeasuredWidth() - localView.getMeasuredWidth();
        }
        for (;;)
        {
          localView = localView.findViewById(2131296429);
          ViewGroup.MarginLayoutParams localMarginLayoutParams;
          if (localView != null)
          {
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
            localMarginLayoutParams.leftMargin = i;
            if ((i != 0) || (t.l(t.this) == null)) {
              break label173;
            }
          }
          label173:
          for (i = t.l(t.this).getMeasuredWidth();; i = 0)
          {
            localView.setPadding(i, 0, i, 0);
            localView.setLayoutParams(localMarginLayoutParams);
            Log.i("MicroMsg.MMActivityController", "mActionBar center mode width:%s", new Object[] { Integer.valueOf(t.j(t.this).getCustomView().getMeasuredWidth()) });
            AppMethodBeat.o(141334);
            return;
          }
          label178:
          i -= j;
        }
      }
    });
  }
  
  private void gIR()
  {
    WeImageView localWeImageView;
    PorterDuff.Mode localMode;
    if (this.OxS)
    {
      if (this.OGl != null)
      {
        localWeImageView = this.OGl;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
      }
      if ((this.OGj != null) && (this.OGj.getVisibility() == 0)) {
        this.OGj.setTextColor(this.mContext.getResources().getColor(2131099904));
      }
      if ((this.orb != null) && (this.orb.getVisibility() == 0)) {
        this.orb.setTextColor(this.mContext.getResources().getColor(2131099904));
      }
      if ((this.OxJ != null) && (this.OxJ.getVisibility() == 0)) {
        if (this.OxJ.getDrawable() != null) {
          b(this.OxJ.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    do
    {
      do
      {
        return;
        localWeImageView = this.OxJ;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -1);
        return;
      } while ((this.OxL == null) || (this.OxL.getVisibility() != 0));
      this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131101430));
      return;
      if (this.OGl != null)
      {
        localWeImageView = this.OGl;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
      }
      if ((this.OGj != null) && (this.OGj.getVisibility() == 0)) {
        this.OGj.setTextColor(this.mContext.getResources().getColor(2131099836));
      }
      if ((this.orb != null) && (this.orb.getVisibility() == 0)) {
        this.orb.setTextColor(this.mContext.getResources().getColor(2131099836));
      }
      if ((this.OxJ != null) && (this.OxJ.getVisibility() == 0))
      {
        if (this.OxJ.getDrawable() != null)
        {
          b(this.OxJ.getDrawable(), -16777216, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        localWeImageView = this.OxJ;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a(localWeImageView, -16777216);
        return;
      }
    } while ((this.OxL == null) || (this.OxL.getVisibility() != 0));
    this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131100050));
  }
  
  private void gIS()
  {
    updataStatusBarIcon(this.OxS);
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
  
  private void jL(Context paramContext)
  {
    synchronized (OGD)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(32, "screen Lock");
      }
      if (!wakeLock.isHeld())
      {
        wakeLock.acquire();
        Log.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        return;
      }
      Log.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  private com.tencent.mm.ui.widget.a kO(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    if (this.OxS) {
      localDrawable = ar.m(this.OGe, paramInt2, -1);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a(localDrawable);
    locala.QBM = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    return locala;
  }
  
  private void releaseWakeLock()
  {
    synchronized (OGD)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        wakeLock.release();
        Log.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(wakeLock.isHeld()) });
        wakeLock = null;
        return;
      }
      Log.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
    }
  }
  
  public static void setMainProcess()
  {
    OGi = true;
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
  
  public final void Bi(boolean paramBoolean)
  {
    this.OxS = paramBoolean;
    gIS();
    gIR();
  }
  
  public final void a(Context paramContext, AppCompatActivity paramAppCompatActivity)
  {
    this.mContext = paramAppCompatActivity;
    this.OGe = paramAppCompatActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = this.OGe.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      this.OGe.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    if (!noActionBar())
    {
      boolean bool = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
      MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (!bool)
      {
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
      }
    }
    this.crv = ao.f(paramAppCompatActivity.getResources());
    int i;
    label448:
    label582:
    label736:
    long l;
    if (paramAppCompatActivity != null)
    {
      if (!this.crv) {
        break label1026;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && ((bd(paramAppCompatActivity)) || (((MMActivity)paramAppCompatActivity).transparentTheme))) {
        paramAppCompatActivity.setTheme(2131820573);
      }
    }
    else
    {
      onCreateBeforeSetContentView();
      this.className = getClass().getName();
      am.dl(3, this.className);
      initLanguage(paramContext);
      this.jus = ((AudioManager)this.mContext.getSystemService("audio"));
      i = getLayoutId();
      this.kgB = LayoutInflater.from(this.mContext);
      this.contentView = provideCustomActivityContentView();
      if (this.contentView == null)
      {
        com.tencent.mm.kiss.a.b.aBh();
        this.contentView = com.tencent.mm.kiss.a.b.c(paramAppCompatActivity, 2131495494);
      }
      this.OFP = this.contentView.findViewById(2131304737);
      this.OFS = ((FrameLayout)this.contentView.findViewById(2131304715));
      if (i != -1)
      {
        this.GDE = getLayoutView();
        if (this.GDE != null) {
          break label1118;
        }
        this.GDE = this.kgB.inflate(getLayoutId(), null);
        this.OFS.addView(this.GDE, 0);
      }
      dealContentView(this.contentView);
      if (fromFullScreenActivity())
      {
        ao.p(ao.a(this.OGe.getWindow(), this.GDE), this.GDE);
        ((ViewGroup)this.GDE.getParent()).removeView(this.GDE);
        ((ViewGroup)this.OGe.getWindow().getDecorView()).addView(this.GDE, 0);
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label1148;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165255);
        this.GDE.setPadding(this.GDE.getPaddingLeft(), i + (j + this.GDE.getPaddingTop()), this.GDE.getPaddingRight(), this.GDE.getPaddingBottom());
      }
      this.mActionBar = getSupportActionBar();
      Log.d("MicroMsg.MMActivityController", "onCreate, before.");
      bg(paramAppCompatActivity);
      if (!noActionBar())
      {
        this.OxT = at.aH(this.mContext, 2131165256);
        this.OxU = at.aH(this.mContext, 2131165577);
      }
      if (this.OFS != null) {
        this.OFS.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(141345);
            t.e(t.this).removeOnAttachStateChangeListener(this);
            com.tencent.mm.kiss.a.b.aBi();
            AppMethodBeat.o(141345);
          }
        });
      }
      if ((this.OFS == null) || (!(this.OFS instanceof LayoutListenerView))) {
        break label1165;
      }
      ((LayoutListenerView)this.OFS).setOnResizedListener(new LayoutListenerView.c()
      {
        private final int OGP;
        
        public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(141347);
          if (t.f(t.this))
          {
            AppMethodBeat.o(141347);
            return;
          }
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
          {
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.OGP))
            {
              t.g(t.this);
              AppMethodBeat.o(141347);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.OGP)) {
              t.h(t.this);
            }
          }
          AppMethodBeat.o(141347);
        }
      });
      paramContext = new com.tencent.mm.g.a.ar();
      paramContext.dDD.type = 2;
      paramContext.dDD.position = this.OGu;
      EventCenter.instance.publish(paramContext);
      if (paramContext.dDE.dDH == 2)
      {
        l = System.currentTimeMillis();
        localObject = paramContext.dDE.dDJ;
        i = paramContext.dDE.position;
        Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), localObject, Util.getStack() });
        if ((i <= 0) || (i == this.OGu)) {
          break label1177;
        }
        Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.OGu) });
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if ((needResetStatusBarColorOnActivityCreate()) && (Build.VERSION.SDK_INT >= 21))
      {
        if (this.IUs == 0) {
          this.IUs = gIN();
        }
        paramContext = paramAppCompatActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(-2147483648);
        p(paramAppCompatActivity, this.IUs);
        gIS();
      }
      return;
      if (((paramAppCompatActivity instanceof MMActivity)) && (bf(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820572);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (be(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820571);
        break;
      }
      paramAppCompatActivity.setTheme(2131820570);
      break;
      label1026:
      if (((paramAppCompatActivity instanceof MMActivity)) && ((((MMActivity)paramAppCompatActivity).transparentTheme) || (bd(paramAppCompatActivity))))
      {
        paramAppCompatActivity.setTheme(2131820578);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (bf(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820577);
        break;
      }
      if (((paramAppCompatActivity instanceof MMActivity)) && (be(paramAppCompatActivity)))
      {
        paramAppCompatActivity.setTheme(2131820576);
        break;
      }
      paramAppCompatActivity.setTheme(2131820575);
      break;
      label1118:
      if (this.GDE.getParent() == null) {
        break label448;
      }
      ((ViewGroup)this.GDE.getParent()).removeView(this.GDE);
      break label448;
      label1148:
      i = this.mContext.getResources().getDimensionPixelSize(2131165256);
      break label582;
      label1165:
      Log.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label736;
      label1177:
      a(paramContext.dDE.dDI, paramContext.dDE.visible, paramContext.dDE.url, paramContext.dDE.desc, (String)localObject, i, true);
    }
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity)
  {
    this.OGA = 2131492945;
    bg(paramAppCompatActivity);
  }
  
  public final void a(a parama)
  {
    akW(parama.Oye);
    this.OxV.add(parama);
    supportInvalidateOptionsMenu();
  }
  
  public final void activateBroadcast(final boolean paramBoolean)
  {
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205120);
        if ((!t.bTg()) && (paramBoolean))
        {
          com.tencent.mm.ui.base.aa.d(paramBoolean, new Intent().putExtra("classname", t.this.getClassName()).putExtra("main_process", false));
          AppMethodBeat.o(205120);
          return;
        }
        com.tencent.mm.ui.base.aa.d(paramBoolean, new Intent().putExtra("classname", t.this.getClassName() + t.this.getIdentString()));
        AppMethodBeat.o(205120);
      }
    }, "ActivateBroadcast-Thread");
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.ogl == null) {
      this.ogl = new ArrayList();
    }
    this.ogl.add(paramDialog);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, null, b.OGT);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), false, paramOnMenuItemClickListener, paramOnLongClickListener, b.OGT);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramBoolean, paramOnMenuItemClickListener, null, b.OGT);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, null, b.OGT);
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt1, paramInt2, "", false, paramOnMenuItemClickListener, paramOnLongClickListener, b.OGT);
  }
  
  public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt1, paramInt2, paramString, false, paramOnMenuItemClickListener, null, b.OGT);
  }
  
  public final void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, paramDrawable, paramString, paramOnMenuItemClickListener, b.OGT);
  }
  
  public final void addSearchMenu(boolean paramBoolean, s params)
  {
    Log.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.Oye = 2131304628;
    locala.text = this.mContext.getString(2131755972);
    locala.Oyf = 2131689496;
    locala.kjh = null;
    locala.tib = null;
    removeOptionMenu(locala.Oye);
    this.OxV.add(0, locala);
    this.OGg = paramBoolean;
    this.gzP = params;
    supportInvalidateOptionsMenu();
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, null, b.OGT);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, b.OGT);
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, b paramb)
  {
    a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  final boolean akW(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.OxV.size())
      {
        if (((a)this.OxV.get(i)).Oye == paramInt)
        {
          Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.OxV.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final a akX(int paramInt)
  {
    Iterator localIterator = this.OxV.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.Oye == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public final void akY(int paramInt)
  {
    if (noActionBar()) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > this.OxT) {
        i = this.OxT;
      }
      paramInt = i;
      if (i < this.OxU) {
        paramInt = this.OxU;
      }
      this.bIs = paramInt;
      this.actionbarView = this.OGe.getWindow().getDecorView().findViewById(2131296366);
      if (this.actionbarView != null) {
        this.OGp = this.actionbarView.getLayoutParams();
      }
      if ((this.actionbarView != null) && (this.OGp != null))
      {
        this.OGp.height = (this.actionbarView.getPaddingTop() + paramInt + this.actionbarView.getPaddingBottom());
        this.actionbarView.setLayoutParams(this.OGp);
      }
      float f1 = Math.min(com.tencent.mm.cb.a.ez(this.OGe), com.tencent.mm.cb.a.ji(this.OGe));
      i = (int)(at.aH(this.mContext, 2131165588) * f1);
      int j = (int)(f1 * at.aH(this.mContext, 2131165536));
      int k = at.fromDPToPix(this.mContext, 14);
      f1 = (paramInt - this.OxU) / (this.OxT - this.OxU);
      float f2 = i;
      float f3 = j - i;
      setIconAlpha(f1);
      paramInt = (int)((k - at.fromDPToPix(this.mContext, 40)) * (1.0F - f1));
      i = (int)((this.OxU - this.OxT) / 2.0F * (1.0F - f1));
      if (this.OGj != null)
      {
        this.OGj.setTextSize(0, f3 * f1 + f2);
        if (this.OxH != null)
        {
          this.OxH.setTranslationX(paramInt);
          this.OxH.setTranslationY(i);
        }
      }
      if (this.OGl != null) {
        this.OGl.setTranslationY(i);
      }
    } while (this.OxJ == null);
    this.OxJ.setTranslationY(i);
  }
  
  public final void bF(int paramInt, boolean paramBoolean)
  {
    this.OGu = paramInt;
    this.OGv = paramBoolean;
  }
  
  final void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.OxV.iterator();
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
      localIterator = this.OxV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.Oye != paramInt) || (locala.enable == paramBoolean2)) {
          break label189;
        }
        locala.enable = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.gzP == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.gzP.Qwd)
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
    if ((this.OGh != null) && (this.OGh.enable))
    {
      a(null, this.OGh);
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
      localIterator = this.OxV.iterator();
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
      localIterator = this.OxV.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.Oye != paramInt) || (locala.visible == paramBoolean2)) {
          break label194;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        label125:
        if (this.gzP == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.gzP.Qwd)
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
    if (this.OGh == null) {}
    while (this.OGh.enable == paramBoolean) {
      return;
    }
    this.OGh.enable = paramBoolean;
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
      this.wMu.removeCallbacks(this.OGI);
      this.wMu.removeCallbacks(this.OGH);
      this.wMu.postDelayed(this.OGH, 256L);
      return;
    }
    this.OGe.getWindow().clearFlags(1024);
    this.wMu.removeCallbacks(this.OGH);
    this.wMu.removeCallbacks(this.OGI);
    this.wMu.postDelayed(this.OGI, 256L);
  }
  
  public final void fullScreenNoTitleBar(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      this.wMu.removeCallbacks(this.OGI);
      this.wMu.removeCallbacks(this.OGH);
      this.wMu.postDelayed(this.OGH, paramLong);
      return;
    }
    this.OGe.getWindow().clearFlags(1024);
    this.wMu.removeCallbacks(this.OGH);
    this.wMu.removeCallbacks(this.OGI);
    this.wMu.postDelayed(this.OGI, paramLong);
  }
  
  public final void fullScreenWithTitleBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.OGe.getWindow().setFlags(1024, 1024);
      return;
    }
    this.OGe.getWindow().clearFlags(1024);
  }
  
  public final void gIL()
  {
    this.OGy = 2131492945;
  }
  
  public final ActionBar gIM()
  {
    return this.mActionBar;
  }
  
  public final int gIN()
  {
    this.OxS = false;
    if (this.IUs == 0) {
      this.IUs = this.mContext.getResources().getColor(2131100898);
    }
    return this.IUs;
  }
  
  final void gIQ()
  {
    Object localObject1 = "%s";
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131165186);
    if (this.OFV != 0) {
      localObject1 = "# ".concat(String.valueOf("%s"));
    }
    if (this.OFW != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int j = 1;; j = 0)
    {
      if ((!this.OGc) && (this.zSX))
      {
        localObject1 = (String)localObject1 + " #";
        j += 2;
      }
      for (int i = 1;; i = 0)
      {
        if (this.OGc)
        {
          localObject1 = (String)localObject1 + " #";
          j += 2;
        }
        for (int k = 1;; k = 0)
        {
          int n;
          int m;
          if (this.OGd)
          {
            localObject1 = (String)localObject1 + " #";
            n = i + 2;
            i = 1;
            m = j + 2;
            j = n;
          }
          for (;;)
          {
            Object localObject2 = String.format((String)localObject1, new Object[] { this.OFU });
            Log.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
            localObject1 = com.tencent.mm.ui.g.c.b.a(this.mContext, (CharSequence)localObject2, i1);
            if ((localObject1 instanceof SpannableString))
            {
              localObject2 = (SpannableString)localObject1;
              if (this.OFV != 0) {
                ((SpannableString)localObject2).setSpan(this.OFX, 0, 1, 33);
              }
              if (this.OFW != 0)
              {
                m = ((SpannableString)localObject2).length() - m;
                ((SpannableString)localObject2).setSpan(this.OFY, m, m + 1, 33);
              }
              if (this.OGc)
              {
                if (this.OGa == null) {
                  this.OGa = kO(i1, 2131689892);
                }
                k = ((SpannableString)localObject2).length() - k;
                ((SpannableString)localObject2).setSpan(this.OGa, k, k + 1, 33);
              }
              if ((!this.OGc) && (this.zSX))
              {
                if (this.OFZ == null) {
                  this.OFZ = a(i1, ar.m(this.OGe, 2131690747, this.OGe.getResources().getColor(2131100006)));
                }
                j = ((SpannableString)localObject2).length() - j;
                ((SpannableString)localObject2).setSpan(this.OFZ, j, j + 1, 33);
              }
              if (this.OGd)
              {
                if (this.OGb == null) {
                  this.OGb = kO(i1, 2131689895);
                }
                i = ((SpannableString)localObject2).length() - i;
                ((SpannableString)localObject2).setSpan(this.OGb, i, i + 1, 33);
              }
            }
            this.OGj.setText((CharSequence)localObject1);
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
    if (this.OFU != null) {
      return this.OFU;
    }
    return this.mActionBar.getTitle();
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.jus.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.jus.getStreamVolume(paramInt);
  }
  
  public ActionBar getSupportActionBar()
  {
    return this.OGe.getSupportActionBar();
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
    if (this.ogl != null)
    {
      int j = this.ogl.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.ogl.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.ogl.clear();
      this.ogl = null;
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
    View localView = this.OGe.getCurrentFocus();
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
  
  public final void jM(Context paramContext)
  {
    EventCenter.instance.removeListener(this.OGx);
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
    Log.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.OxV.size()) });
    if ((this.mActionBar == null) || (this.OxV.size() == 0))
    {
      Log.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.OxV.size()) });
      return false;
    }
    this.OGE = null;
    this.OGF = null;
    Object localObject1;
    if (this.mActionBar.getHeight() == 0)
    {
      localObject1 = this.mContext.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label184;
      }
      this.mContext.getResources().getDimensionPixelSize(2131165255);
    }
    final a locala;
    for (;;)
    {
      localObject1 = this.OxV.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1817;
        }
        locala = (a)((Iterator)localObject1).next();
        if (locala.Oye != 16908332) {
          break;
        }
        Log.v("MicroMsg.MMActivityController", "match back option menu, continue");
      }
      label184:
      this.mContext.getResources().getDimensionPixelSize(2131165256);
    }
    if (locala.Oye == 2131304628)
    {
      boolean bool2 = this.OGg;
      if (this.gzP == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!this.OGg) || (this.gzP == null)) {
          break;
        }
        this.gzP.a(this.OGe, paramMenu);
        break;
      }
    }
    final MenuItem localMenuItem = paramMenu.add(0, locala.Oye, 0, locala.text);
    com.tencent.mm.compatible.h.a.a(localMenuItem, getClass().getName());
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205109);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        t.a(t.this, localMenuItem, locala);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205109);
      }
    };
    View.OnLongClickListener local3 = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205110);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        boolean bool = t.a(t.this, paramAnonymousView, locala);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(205110);
        return bool;
      }
    };
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205111);
        boolean bool = t.a(t.this, paramAnonymousView, paramAnonymousMotionEvent, locala);
        AppMethodBeat.o(205111);
        return bool;
      }
    };
    if ((locala.Oyf != 0) || (locala.OGR != null))
    {
      if (locala.Oyh == null) {
        locala.Oyh = View.inflate(this.mContext, 2131492938, null);
      }
      localObject2 = (ImageView)locala.Oyh.findViewById(2131299682);
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      this.OxJ = ((WeImageView)locala.Oyh.findViewById(2131296401));
      this.OxJ.setVisibility(0);
      label473:
      PorterDuff.Mode localMode;
      if (locala.OGR != null)
      {
        this.OxJ.setImageDrawable(locala.OGR);
        if (this.OGn == 0) {
          break label736;
        }
        localObject2 = this.OxJ;
        int i = this.OGn;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, i);
        label503:
        this.OxJ.setOnClickListener(local2);
        this.OxJ.setEnabled(locala.enable);
        this.OxJ.setContentDescription(locala.text);
        if (locala.tib != null) {
          this.OxJ.setOnLongClickListener(local3);
        }
        this.OGo = ((ImageView)locala.Oyh.findViewById(2131299734));
        if (this.OGo != null)
        {
          if (!locala.eho) {
            break label795;
          }
          this.OGo.setVisibility(0);
        }
      }
      for (;;)
      {
        localMenuItem.setActionView(locala.Oyh);
        localMenuItem.setEnabled(locala.enable);
        localMenuItem.setVisible(locala.visible);
        localMenuItem.setShowAsAction(2);
        if (locala.Oyf == 2131233966)
        {
          this.OGE = locala;
          this.OGF = localMenuItem;
        }
        Log.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.Oye), locala.text, Boolean.valueOf(locala.enable), Boolean.valueOf(locala.visible) });
        break;
        this.OxJ.setImageResource(locala.Oyf);
        break label473;
        label736:
        if (locala.OGQ != 0) {
          break label503;
        }
        if (this.OxS)
        {
          localObject2 = this.OxJ;
          localMode = PorterDuff.Mode.SRC_ATOP;
          a((WeImageView)localObject2, -1);
          break label503;
        }
        localObject2 = this.OxJ;
        localMode = PorterDuff.Mode.SRC_ATOP;
        a((WeImageView)localObject2, -16777216);
        break label503;
        label795:
        this.OGo.setVisibility(8);
      }
    }
    if (locala.Oyg == null) {
      locala.Oyg = View.inflate(this.mContext, 2131492938, null);
    }
    this.OxL = ((TextView)locala.Oyg.findViewById(2131296402));
    this.OxL.setVisibility(0);
    this.sUc = ((Button)locala.Oyg.findViewById(2131296399));
    this.sUc.setVisibility(8);
    this.OGs = locala.Oyg.findViewById(2131296677);
    this.OGs.setVisibility(8);
    if ((locala.OGS == b.OGV) || (locala.OGS == b.OGY))
    {
      this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131100997));
      this.sUc.setVisibility(0);
      this.sUc.setBackgroundResource(2131231435);
      this.OxL.setVisibility(8);
    }
    for (;;)
    {
      this.OxL.setText(locala.text);
      if (locala.textColor != 0) {
        this.OxL.setTextColor(locala.textColor);
      }
      this.OxL.setOnClickListener(local2);
      this.OxL.setOnLongClickListener(local3);
      this.OxL.setEnabled(locala.enable);
      this.OxL.setOnTouchListener((View.OnTouchListener)localObject2);
      this.sUc.setText(locala.text);
      this.sUc.setOnClickListener(local2);
      this.sUc.setOnLongClickListener(local3);
      this.sUc.setOnTouchListener((View.OnTouchListener)localObject2);
      this.sUc.setEnabled(locala.enable);
      localMenuItem.setActionView(locala.Oyg);
      break;
      if (locala.OGS == b.OGZ)
      {
        this.sUc.setVisibility(0);
        this.sUc.setBackgroundResource(2131231436);
        this.sUc.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131101425));
        this.OxL.setVisibility(8);
      }
      else if (locala.OGS == b.OGU)
      {
        this.sUc.setVisibility(0);
        this.sUc.setBackgroundResource(2131231430);
        this.sUc.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131100194));
        this.OxL.setVisibility(8);
      }
      else
      {
        if (locala.OGS != b.OGW)
        {
          if (locala.OGS == b.OHb)
          {
            this.OxL.setTextColor(this.OGe.getResources().getColor(2131100753));
            continue;
          }
          if (locala.OGS == b.OHa)
          {
            this.OxL.setTextColor(this.OGe.getResources().getColor(2131100996));
            continue;
          }
          if (locala.OGS == b.OHe)
          {
            this.sUc.setVisibility(0);
            this.sUc.setBackgroundResource(2131231440);
            this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131100194));
            this.OxL.setVisibility(8);
            continue;
          }
          if (b.OHg == locala.OGS)
          {
            Log.i("MicroMsg.MMActivityController", "dark green mode.");
            this.sUc.setVisibility(0);
            this.sUc.setBackgroundResource(2131231426);
            this.sUc.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131100498));
            this.OxL.setVisibility(8);
            continue;
          }
          if (locala.OGS == b.OHf)
          {
            this.sUc.setVisibility(0);
            this.sUc.setBackgroundResource(2131231433);
            this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131100194));
            this.OxL.setVisibility(8);
            continue;
          }
          if (b.OHh == locala.OGS)
          {
            Log.i("MicroMsg.MMActivityController", "smart gallery entry %s.", new Object[] { Boolean.valueOf(this.OGf) });
            this.OxL.setVisibility(8);
            if (this.OGf)
            {
              this.OGs.setVisibility(0);
              this.OGs.setOnClickListener(local2);
              continue;
            }
            if (8 == this.OGs.getVisibility()) {
              this.OGs.setVisibility(4);
            }
            for (;;)
            {
              this.OGs.setOnClickListener(null);
              break;
              if (this.OGs.getVisibility() == 0) {
                this.OGs.animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(141333);
                    t.i(t.this).setVisibility(4);
                    AppMethodBeat.o(141333);
                  }
                });
              }
            }
          }
          if (b.OHi == locala.OGS)
          {
            this.sUc.setVisibility(0);
            this.sUc.setBackgroundResource(2131231433);
            this.sUc.setTextColor(com.tencent.mm.cb.a.n(this.OGe, 2131100100));
            this.OxL.setVisibility(8);
            continue;
          }
          if (b.OHj == locala.OGS)
          {
            this.sUc.setVisibility(0);
            this.sUc.setBackgroundResource(2131231428);
            this.sUc.setTextColor(com.tencent.mm.cb.a.n(this.OGe, 2131099669));
            this.OxL.setVisibility(8);
            continue;
          }
          if (this.OGn != 0)
          {
            this.OxL.setTextColor(this.OGn);
            continue;
          }
          if (this.OxS)
          {
            this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131101430));
            continue;
          }
        }
        this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, 2131100050));
      }
    }
    label1817:
    if (this.OGy == 2131492946) {
      gIP();
    }
    return true;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.compatible.b.g.anG();
    com.tencent.mm.compatible.b.g.anG();
    if ((this.OGg) && (this.gzP != null) && (this.gzP.onKeyDown(paramInt, paramKeyEvent)))
    {
      Log.d("MicroMsg.MMActivityController", "match search view on key down");
      if (this.OxS) {
        setActionbarColor(this.OGe.getResources().getColor(2131100229));
      }
      for (;;)
      {
        return true;
        setActionbarColor(this.OGe.getResources().getColor(2131100898));
      }
    }
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.OGE != null) && (this.OGE.enable)) {
        a(this.OGF, this.OGE);
      }
      return true;
    }
    return false;
  }
  
  public abstract void onKeyboardStateChanged();
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Log.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.OFT)
    {
      Log.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      return true;
    }
    if ((paramMenuItem.getItemId() == this.OGh.Oye) && (this.OGh.enable))
    {
      a(paramMenuItem, this.OGh);
      return true;
    }
    Iterator localIterator = this.OxV.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.Oye)
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
    EventCenter.instance.removeListener(this.OGx);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Log.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.OGg) && (this.gzP != null)) {
      this.gzP.a(this.OGe, paramMenu);
    }
    return true;
  }
  
  public final void onResume()
  {
    activateBroadcast(true);
    EventCenter.instance.addListener(this.OGx);
    Object localObject = new com.tencent.mm.g.a.ar();
    ((com.tencent.mm.g.a.ar)localObject).dDD.type = 2;
    ((com.tencent.mm.g.a.ar)localObject).dDD.position = this.OGu;
    EventCenter.instance.publish((IEvent)localObject);
    long l;
    String str;
    int i;
    if (((com.tencent.mm.g.a.ar)localObject).dDE.dDH == 2)
    {
      l = System.currentTimeMillis();
      str = ((com.tencent.mm.g.a.ar)localObject).dDE.dDJ;
      i = ((com.tencent.mm.g.a.ar)localObject).dDE.position;
      Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.OGu)) {
        break label432;
      }
      Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.OGu) });
    }
    for (;;)
    {
      Log.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY) && (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)))
      {
        if (1.0F != com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())) {
          break;
        }
        if (1.0F != MMApplicationContext.getContext().getResources().getConfiguration().fontScale)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(15181, new Object[] { Integer.valueOf(1) });
          localObject = new f.a(MMApplicationContext.getContext());
          ((f.a)localObject).aC(this.OGe.getResources().getString(2131760902)).bow(this.OGe.getResources().getString(2131760899)).boA(this.OGe.getResources().getString(2131760901)).boB(this.OGe.getResources().getString(2131760900));
          ((f.a)localObject).c(new f.c()
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(141349);
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(15181, new Object[] { Integer.valueOf(3) });
                Object localObject = new Intent();
                ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                ((Intent)localObject).addFlags(268435456);
                paramAnonymousString = MMApplicationContext.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(141349);
                return;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(15181, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(141349);
            }
          }).show();
          MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
      }
      return;
      label432:
      a(((com.tencent.mm.g.a.ar)localObject).dDE.dDI, ((com.tencent.mm.g.a.ar)localObject).dDE.visible, ((com.tencent.mm.g.a.ar)localObject).dDE.url, ((com.tencent.mm.g.a.ar)localObject).dDE.desc, str, i, true);
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
        this.OGe.setRequestedOrientation(-1);
        return;
      }
      this.OGe.setRequestedOrientation(1);
      return;
    }
    this.OGe.setRequestedOrientation(getForceOrientation());
  }
  
  @TargetApi(21)
  public final void p(Activity paramActivity, int paramInt)
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
        com.tencent.mm.ui.statusbar.a.e(this.contentView, i, d.f(paramActivity.getWindow()));
      }
      for (;;)
      {
        setNavigationbarColor(paramActivity.getResources().getColor(2131099648));
        this.statusBarColor = paramInt;
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label124;
        }
        i = ar.v(paramActivity.getResources().getColor(2131101173), paramInt);
        break;
        paramActivity.getWindow().setStatusBarColor(i);
      }
      label124:
      i = 0;
    }
  }
  
  protected View provideCustomActivityContentView()
  {
    return null;
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.OxV.isEmpty()) {
      return;
    }
    this.OxV.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final boolean removeOptionMenu(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.OxV.size())
      {
        if (((a)this.OxV.get(i)).Oye == paramInt)
        {
          Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
          this.OxV.remove(i);
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
    this.IUs = paramInt;
    this.OxS = ar.aln(this.IUs);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IUs));
    p(this.OGe, this.IUs);
    gIS();
    gIR();
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
        if (this.OGl.getDrawable() == null) {
          i = 2131689492;
        }
      }
      if ((this.OGl != null) && (i != 0)) {
        this.OGl.setImageResource(i);
      }
      this.OGh.Oye = 16908332;
      this.OGh.kjh = paramOnMenuItemClickListener;
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.OGk != null) {
        this.OGk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(205116);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView.setSelected(false);
            paramAnonymousView.setPressed(false);
            paramAnonymousView.clearFocus();
            paramAnonymousView.invalidate();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(205115);
                t.11.this.OxX.onMenuItemClick(null);
                AppMethodBeat.o(205115);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(205116);
          }
        });
      }
    }
  }
  
  public final void setBackBtnColorFilter(int paramInt)
  {
    if (this.OGl != null) {
      this.OGl.getDrawable().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void setBackBtnVisible(boolean paramBoolean)
  {
    if (this.OGl == null) {
      return;
    }
    if (paramBoolean)
    {
      this.OGl.setVisibility(0);
      return;
    }
    this.OGl.setVisibility(8);
  }
  
  public final void setBackGroundColorResource(int paramInt)
  {
    if (this.contentView == null) {
      return;
    }
    if (this.OFS == null) {
      this.OFS = ((FrameLayout)this.contentView.findViewById(2131304715));
    }
    this.OFS.setBackgroundResource(paramInt);
    this.GDE.setBackgroundResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    if (this.OFS == null) {
      this.OFS = ((FrameLayout)this.contentView.findViewById(2131304715));
    }
    if (this.OFQ != null) {
      this.OFS.removeView(this.OFQ);
    }
    this.OFS.removeView(this.GDE);
    this.GDE = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.OFS.addView(this.GDE, 0, new FrameLayout.LayoutParams(-1, -1));
    if (this.OFQ != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 47.0F));
      this.OFS.addView(this.OFQ, this.OFS.getChildCount(), localLayoutParams);
    }
    this.OFS.invalidate();
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    if (this.OGk != null)
    {
      this.OGk.setAlpha(paramFloat);
      if (paramFloat != 0.0F) {
        break label59;
      }
      this.OGk.setEnabled(false);
    }
    for (;;)
    {
      if (this.OxJ != null)
      {
        this.OxJ.setAlpha(paramFloat);
        if (paramFloat != 0.0F) {
          break;
        }
        this.OxJ.setEnabled(false);
      }
      return;
      label59:
      this.OGk.setEnabled(true);
    }
    this.OxJ.setEnabled(true);
  }
  
  public final void setMMNormalView()
  {
    if (this.mContext != null) {
      bg(this.OGe);
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
        this.mActionBar.setCustomView(OGz);
        localTextView = (TextView)this.mActionBar.getCustomView().findViewById(2131296370);
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
    this.orb.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.cb.a.jk(this.OGe))
    {
      this.orb.setTextSize(1, 14.0F);
      this.OGj.setTextSize(1, 18.0F);
    }
    this.orb.setVisibility(0);
    updateDescription(this.mContext.getString(paramInt));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramString == null)
    {
      this.orb.setVisibility(8);
      return;
    }
    this.orb.setText(paramString);
    if (com.tencent.mm.cb.a.jk(this.OGe))
    {
      this.orb.setTextSize(1, 14.0F);
      this.OGj.setTextSize(1, 18.0F);
    }
    this.orb.setVisibility(0);
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
    this.OFU = paramCharSequence.toString();
    this.OGj.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.jk(this.OGe)) {
      this.OGj.setTextSize(0, com.tencent.mm.cb.a.aH(this.OGe, 2131165186) * com.tencent.mm.cb.a.ji(this.OGe));
    }
    updateDescription(paramCharSequence.toString());
  }
  
  public final void setMMTitle(String paramString)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.OFU = paramString;
    if (com.tencent.mm.cb.a.jk(this.OGe)) {
      this.OGj.setTextSize(0, com.tencent.mm.cb.a.aH(this.OGe, 2131165186) * com.tencent.mm.cb.a.ji(this.OGe));
    }
    gIQ();
    updateDescription(paramString);
  }
  
  public final void setMMTitleVisibility(int paramInt)
  {
    this.OGj.setVisibility(paramInt);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 26) && (!r.gII()))
    {
      this.OGe.getWindow().setNavigationBarColor(paramInt);
      boolean bool = ar.aln(paramInt);
      localView = this.OGe.getWindow().getDecorView();
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
    this.OFT = paramBoolean;
    if ((this.OFP == null) && (this.contentView != null)) {
      this.OFP = this.contentView.findViewById(2131304737);
    }
    if (this.OFP == null)
    {
      Log.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      return;
    }
    View localView = this.OFP;
    if (!paramBoolean)
    {
      bool1 = true;
      localView.setFocusable(bool1);
      localView = this.OFP;
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
      jL(this.OGe);
      return;
      bool1 = false;
      break;
    }
    label111:
    releaseWakeLock();
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    p(this.OGe, paramInt);
    updataStatusBarIcon(ar.aln(paramInt));
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
        AppMethodBeat.i(141338);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SystemClock.elapsedRealtime() - t.n(t.this) < 300L) {
          paramRunnable.run();
        }
        t.a(t.this, SystemClock.elapsedRealtime());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(141338);
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
      this.OFV = 0;
      this.OFX = null;
      if (paramInt2 != 0) {
        break label82;
      }
      this.OFW = 0;
      this.OFY = null;
    }
    for (;;)
    {
      gIQ();
      return;
      if (this.OFV == paramInt1) {
        break;
      }
      this.OFV = paramInt1;
      this.OFX = kO(this.mContext.getResources().getDimensionPixelSize(2131165195), this.OFV);
      break;
      label82:
      if (this.OFW != paramInt2)
      {
        this.OFW = paramInt2;
        this.OFY = kO(this.mContext.getResources().getDimensionPixelSize(2131165195), this.OFW);
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zSX = bool;
      gIQ();
      return;
    }
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.OGd = bool;
      gIQ();
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
      p(this.OGe, this.IUs);
      return;
    }
    this.mActionBar.hide();
    p(this.OGe, this.OGe.getResources().getColor(2131100042));
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
    } while (this.OGk == null);
    View localView = this.OGk;
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
    this.OGe.supportInvalidateOptionsMenu();
  }
  
  public final void updataStatusBarIcon(boolean paramBoolean)
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.OGe.getWindow().getDecorView();
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
    while ((this.OGl == null) || (paramDrawable == null)) {
      return;
    }
    this.OGl.setImageDrawable(paramDrawable);
    paramDrawable.invalidateSelf();
  }
  
  protected final void updateDescription(String paramString)
  {
    a.a.gKe().p(this.OGe, paramString);
  }
  
  public final void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    a locala = akX(paramInt1);
    if ((locala != null) && (locala.Oyf != paramInt2))
    {
      locala.Oyf = paramInt2;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    a locala = akX(paramInt);
    if (locala != null)
    {
      locala.kjh = paramOnMenuItemClickListener;
      locala.tib = paramOnLongClickListener;
    }
  }
  
  public final void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    a locala = akX(paramInt);
    if ((locala != null) && (locala.eho != paramBoolean))
    {
      locala.eho = paramBoolean;
      supportInvalidateOptionsMenu();
    }
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    a locala = akX(paramInt);
    if ((locala != null) && (!Util.nullAs(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      supportInvalidateOptionsMenu();
    }
  }
  
  public static final class a
  {
    public int OGQ = 0;
    public Drawable OGR;
    public t.b OGS = t.b.OGT;
    public int Oye = -1;
    public int Oyf;
    public View Oyg;
    public View Oyh;
    public boolean eho = false;
    public boolean enable = true;
    public MenuItem.OnMenuItemClickListener kjh;
    public String text;
    public int textColor;
    public View.OnLongClickListener tib;
    public View.OnTouchListener uwC;
    public boolean visible = true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(141353);
      OGT = new b("NORMAL", 0);
      OGU = new b("GREEN", 1);
      OGV = new b("RED", 2);
      OGW = new b("BLACK", 3);
      OGX = new b("TRANSPARENT", 4);
      OGY = new b("TRANSPARENT_RED_TEXT", 5);
      OGZ = new b("TRANSPARENT_GREEN_TEXT", 6);
      OHa = new b("GOLDEN", 7);
      OHb = new b("TRANSPARENT_GOLD_TEXT", 8);
      OHc = new b("TRANSPARENT_GB_GREEN_TEXT", 9);
      OHd = new b("TRANSPARENT_BG_BLACK_TEXT", 10);
      OHe = new b("YELLOW", 11);
      OHf = new b("ORANGE", 12);
      OHg = new b("DARK_GREEN_MODE", 13);
      OHh = new b("SMART_GALLERY_SEARCH_ENTRY", 14);
      OHi = new b("FEED_FOLLOW", 15);
      OHj = new b("FEED_UNFOLLOW", 16);
      OHk = new b[] { OGT, OGU, OGV, OGW, OGX, OGY, OGZ, OHa, OHb, OHc, OHd, OHe, OHf, OHg, OHh, OHi, OHj };
      AppMethodBeat.o(141353);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */