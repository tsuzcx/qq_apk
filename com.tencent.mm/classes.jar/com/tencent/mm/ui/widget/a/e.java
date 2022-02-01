package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.design.widget.a;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private l CGH;
  public n.c ISu;
  public n.d ISv;
  public n.a ISy;
  public n.b ISz;
  public b Ihj;
  private boolean Ihk;
  private boolean JfA;
  private boolean JfB;
  private RecyclerView JfC;
  private ImageView JfD;
  private ImageView JfE;
  private int JfF;
  private int JfG;
  private int JfH;
  private int JfI;
  public boolean JfJ;
  public boolean JfK;
  private int JfL;
  public boolean JfM;
  private boolean JfN;
  public n.c Jfj;
  private n.d Jfk;
  public n.d Jfl;
  public a Jfm;
  private l Jfn;
  private l Jfo;
  private Boolean Jfp;
  private LinearLayout Jfq;
  private LinearLayout Jfr;
  private LinearLayout Jfs;
  private View Jft;
  private View Jfu;
  private TextView Jfv;
  private c Jfw;
  private c Jfx;
  private boolean Jfy;
  private boolean Jfz;
  private ViewTreeObserver adE;
  private RecyclerView alu;
  public int irP;
  private View khe;
  private Dialog lcA;
  private int lcC;
  private BottomSheetBehavior lcD;
  private boolean lcE;
  private int lcF;
  public boolean lcG;
  public boolean lcH;
  private boolean lcI;
  private int lcJ;
  private Context mContext;
  private View oP;
  private boolean rVy;
  public boolean rVz;
  private boolean vQk;
  public boolean whK;
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.Jfp = Boolean.FALSE;
    this.Jfy = false;
    this.Jfz = false;
    this.JfA = false;
    this.JfB = false;
    this.lcE = false;
    this.JfF = 4;
    this.JfG = (this.JfF * 3);
    this.JfH = 6;
    this.whK = false;
    this.rVz = false;
    this.Ihk = false;
    this.lcH = false;
    this.JfJ = false;
    this.JfK = false;
    this.irP = 0;
    this.lcI = false;
    this.JfL = 0;
    this.lcJ = 0;
    this.JfM = false;
    this.JfN = false;
    this.JfI = paramInt;
    this.mContext = paramContext;
    this.vQk = paramBoolean;
    this.JfK = false;
    if ((this.mContext instanceof Activity)) {
      this.oP = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aM(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public e(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(199678);
    this.Jfp = Boolean.FALSE;
    this.Jfy = false;
    this.Jfz = false;
    this.JfA = false;
    this.JfB = false;
    this.lcE = false;
    this.JfF = 4;
    this.JfG = (this.JfF * 3);
    this.JfH = 6;
    this.whK = false;
    this.rVz = false;
    this.Ihk = false;
    this.lcH = false;
    this.JfJ = false;
    this.JfK = false;
    this.irP = 0;
    this.lcI = false;
    this.JfL = 0;
    this.lcJ = 0;
    this.JfM = false;
    this.JfN = false;
    this.JfI = paramInt;
    this.mContext = paramContext;
    this.lcI = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.oP = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aM(this.mContext);
    AppMethodBeat.o(199678);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.CGH = new l(paramContext);
    this.Jfn = new l(paramContext);
    this.Jfo = new l(paramContext);
    if (this.lcI)
    {
      this.lcA = new b(paramContext);
      this.khe = View.inflate(paramContext, 2131494771, null);
      this.Jfq = ((LinearLayout)this.khe.findViewById(2131297466));
      this.Jfr = ((LinearLayout)this.khe.findViewById(2131297462));
      this.Jfs = ((LinearLayout)this.khe.findViewById(2131297459));
      this.Jft = this.khe.findViewById(2131307286);
      this.Jfu = this.khe.findViewById(2131307284);
      this.Jfv = ((TextView)this.khe.findViewById(2131307287));
      this.JfD = ((ImageView)this.khe.findViewById(2131299071));
      this.JfE = ((ImageView)this.khe.findViewById(2131302242));
      this.Jfs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159340);
          e.this.bmi();
          if (e.b(e.this) != null) {
            e.b(e.this).onClick();
          }
          AppMethodBeat.o(159340);
        }
      });
      this.alu = ((RecyclerView)this.khe.findViewById(2131297464));
      this.alu.setHasFixedSize(true);
      this.JfC = ((RecyclerView)this.khe.findViewById(2131297465));
      this.JfC.setHasFixedSize(true);
      this.lcE = aly();
      if (this.JfI != 0) {
        break label767;
      }
      this.JfB = true;
      if (!this.lcE) {
        break label726;
      }
      this.JfF = 7;
      this.JfG = (this.JfF * 2);
      this.lcC = (ao.av(this.mContext, 2131165202) + ao.av(this.mContext, 2131166412));
      label331:
      if (this.vQk) {
        this.lcC += ao.av(this.mContext, 2131166412);
      }
      this.Jfs.setVisibility(0);
      if (this.khe != null)
      {
        if ((!this.lcI) || (!aly())) {
          break label754;
        }
        this.khe.setBackgroundColor(this.mContext.getResources().getColor(2131099649));
      }
      label406:
      if ((this.vQk) && (this.JfD != null) && (this.JfK)) {
        this.JfD.setVisibility(0);
      }
      if (this.JfI != 0) {
        break label1008;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.alu.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.JfC.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.alu.setFocusable(false);
      this.alu.setItemViewCacheSize(20);
      this.Jfw = new c();
      this.Jfw.JfP = this.CGH;
      this.Jfw.apn = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159341);
          if (paramAnonymousInt >= e.c(e.this).size())
          {
            AppMethodBeat.o(159341);
            return;
          }
          paramAnonymousAdapterView = (m)e.c(e.this).Hyi.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.ltx))
          {
            AppMethodBeat.o(159341);
            return;
          }
          if (paramAnonymousInt < e.c(e.this).size()) {
            if (e.d(e.this) != null) {
              e.d(e.this).onMMMenuItemSelected(e.c(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
            }
          }
          for (;;)
          {
            if (!e.g(e.this)) {
              e.this.bmi();
            }
            e.h(e.this);
            e.a(e.this, paramAnonymousInt);
            e.i(e.this).arg.notifyChanged();
            AppMethodBeat.o(159341);
            return;
            paramAnonymousAdapterView.performClick();
            continue;
            if ((e.e(e.this).size() > 0) && (paramAnonymousInt < e.c(e.this).size() + e.e(e.this).size()))
            {
              if (e.f(e.this) != null) {
                e.f(e.this).onMMMenuItemSelected(e.e(e.this).getItem(paramAnonymousInt - e.c(e.this).size()), paramAnonymousInt);
              }
            }
            else {
              e.fvw();
            }
          }
        }
      };
      this.alu.setAdapter(this.Jfw);
      this.alu.setOverScrollMode(1);
      this.Jfx = new c();
      this.Jfx.JfP = this.Jfo;
      this.Jfx.apn = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159342);
          if (paramAnonymousInt > e.j(e.this).size())
          {
            AppMethodBeat.o(159342);
            return;
          }
          paramAnonymousAdapterView = (m)e.j(e.this).Hyi.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.ltx))
          {
            AppMethodBeat.o(159342);
            return;
          }
          if ((paramAnonymousInt < e.j(e.this).size()) && (e.k(e.this) != null)) {
            e.k(e.this).onMMMenuItemSelected(e.j(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!e.g(e.this)) {
            e.this.bmi();
          }
          e.h(e.this);
          e.l(e.this).arg.notifyChanged();
          AppMethodBeat.o(159342);
        }
      };
      this.JfC.setAdapter(this.Jfx);
      this.JfC.setOverScrollMode(1);
      if (this.lcA != null) {
        this.lcA.setContentView(this.khe);
      }
      if (!this.lcI)
      {
        this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
        this.lcD.setState(3);
        this.lcD.mp = new BottomSheetBehavior.a()
        {
          public final void N(int paramAnonymousInt) {}
          
          public final void l(float paramAnonymousFloat)
          {
            AppMethodBeat.i(159343);
            if ((e.m(e.this) != null) && (!e.n(e.this)))
            {
              if ((e.o(e.this).canScrollVertically(-1)) && (e.p(e.this)) && (paramAnonymousFloat != 0.0F))
              {
                e.m(e.this).setVisibility(0);
                AppMethodBeat.o(159343);
                return;
              }
              e.m(e.this).setVisibility(4);
            }
            AppMethodBeat.o(159343);
          }
        };
      }
      if (this.lcA != null) {
        this.lcA.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159344);
            if (e.q(e.this) != null)
            {
              if (!e.q(e.this).isAlive()) {
                e.a(e.this, e.r(e.this).getViewTreeObserver());
              }
              e.q(e.this).removeGlobalOnLayoutListener(e.this);
              e.a(e.this, null);
            }
            if (!e.s(e.this)) {
              e.t(e.this);
            }
            AppMethodBeat.o(159344);
          }
        });
      }
      AppMethodBeat.o(159355);
      return;
      this.lcA = new a(paramContext, 2131820788);
      break;
      label726:
      this.lcC = (ao.av(this.mContext, 2131165201) + ao.av(this.mContext, 2131166412));
      break label331;
      label754:
      this.khe.setBackgroundResource(2131234449);
      break label406;
      label767:
      if (this.JfI == 2)
      {
        this.Jfz = true;
        i = ao.av(this.mContext, 2131165927);
        if (this.lcE) {
          this.JfH = 2;
        }
        for (this.lcC = ((int)(i * 2.5D) + ao.av(this.mContext, 2131165923));; this.lcC = ((int)(i * 3.5D) + ao.av(this.mContext, 2131165923)))
        {
          if (!this.vQk) {
            break label881;
          }
          this.lcC += ao.fromDPToPix(this.mContext, 88);
          break;
          this.JfH = 3;
        }
        break label406;
      }
      label881:
      this.JfA = true;
      int i = ao.av(this.mContext, 2131165930);
      if (this.lcE) {
        this.JfH = 4;
      }
      for (this.lcC = ((int)(i * 4.5D) + ao.av(this.mContext, 2131165923));; this.lcC = ((int)(i * 6.5D) + ao.av(this.mContext, 2131165923)))
      {
        if (this.vQk) {
          this.lcC += ao.av(this.mContext, 2131166412);
        }
        if (this.Jfs == null) {
          break;
        }
        this.Jfs.setVisibility(0);
        break;
        this.JfH = 6;
      }
      label1008:
      this.alu.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  private boolean aly()
  {
    AppMethodBeat.i(159367);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(159367);
      return true;
    }
    AppMethodBeat.o(159367);
    return false;
  }
  
  @TargetApi(23)
  private void eFw()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.lcA != null))
    {
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.lcA.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private void fvv()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
    this.CGH.size();
    if ((!this.Jfy) && (this.Jfn.size() > 0)) {
      this.Jfn.size();
    }
    Rect localRect;
    if ((this.lcE) && (this.oP != null))
    {
      localRect = new Rect();
      this.oP.getWindowVisibleDisplayFrame(localRect);
      if (!this.lcI) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.lcJ != 0) {
        localLayoutParams.width = this.lcJ;
      }
      if (!ap.jN(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - ap.jL(this.mContext));
    }
    for (;;)
    {
      this.khe.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(159366);
      return;
      label157:
      localLayoutParams.height = localRect.bottom;
      continue;
      label168:
      localLayoutParams.width = localRect.right;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    AppMethodBeat.i(159354);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(159354);
    return i;
  }
  
  public final void J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159356);
    if (paramView == null)
    {
      AppMethodBeat.o(159356);
      return;
    }
    this.vQk = true;
    ImageView localImageView;
    if (this.JfD != null)
    {
      localImageView = this.JfD;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.Jfq != null)
      {
        this.Jfq.setVisibility(0);
        this.Jfq.removeAllViews();
        this.Jfq.setGravity(17);
        this.Jfq.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void a(n.c paramc)
  {
    this.ISu = paramc;
  }
  
  public final void a(n.d paramd)
  {
    this.ISv = paramd;
  }
  
  public final void a(a parama)
  {
    this.Jfm = parama;
  }
  
  public final void b(n.c paramc)
  {
    this.Jfj = paramc;
  }
  
  public final void b(n.d paramd)
  {
    this.Jfl = paramd;
  }
  
  public final void b(b paramb)
  {
    this.Ihj = paramb;
  }
  
  public final void bmi()
  {
    AppMethodBeat.i(159364);
    if (this.lcA != null)
    {
      if (this.lcD != null) {
        this.lcD.mg = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lcA.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void cED()
  {
    AppMethodBeat.i(159362);
    this.Ihk = false;
    this.lcE = aly();
    this.lcF = getRotation();
    if (this.ISu != null) {
      this.ISu.onCreateMMMenu(this.CGH);
    }
    if (this.Jfj != null) {
      this.Jfj.onCreateMMMenu(this.Jfo);
    }
    if (this.lcA != null)
    {
      fvv();
      if (!this.JfB) {
        break label503;
      }
      if (this.Jfo.size() > 0)
      {
        this.JfE.setVisibility(0);
        this.JfC.setVisibility(0);
      }
      int j = ao.av(this.mContext, 2131166412);
      int k = ao.av(this.mContext, 2131165289);
      i = j;
      if (this.vQk)
      {
        i = j;
        if (this.Jfq.getVisibility() == 0) {
          i = ao.fromDPToPix(this.mContext, 0);
        }
      }
      this.alu.setPadding(0, i, this.alu.getPaddingRight(), this.alu.getPaddingBottom());
      if (!aly()) {
        break label471;
      }
      this.JfC.setPadding(0, this.JfC.getPaddingTop(), this.JfC.getPaddingRight(), k);
      if ((this.Jfn != null) && (this.Jfw != null)) {
        this.Jfw.arg.notifyChanged();
      }
      if (this.Jfx != null) {
        this.Jfx.arg.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.lcA.getWindow().addFlags(-2147483648);
      }
      if (this.rVy) {
        eFw();
      }
      if (this.lcG) {
        this.lcA.getWindow().addFlags(1024);
      }
      if (!this.lcH) {
        break label517;
      }
      this.lcA.getWindow().setFlags(8, 8);
      this.lcA.getWindow().addFlags(131200);
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(6);
      label358:
      if (this.lcD != null) {
        this.lcD.mg = false;
      }
      if (this.Ihj != null) {
        this.lcA.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159345);
            if (!e.u(e.this)) {
              e.this.Ihj.onDismiss();
            }
            AppMethodBeat.o(159345);
          }
        });
      }
      if (this.oP != null) {
        if (this.adE != null) {
          break label572;
        }
      }
    }
    label517:
    label572:
    for (int i = 1;; i = 0)
    {
      this.adE = this.oP.getViewTreeObserver();
      if (i != 0) {
        this.adE.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lcA.show();
      }
      AppMethodBeat.o(159362);
      return;
      label471:
      this.JfC.setPadding(0, this.JfC.getPaddingTop(), this.JfC.getPaddingRight(), this.JfC.getPaddingBottom());
      break;
      label503:
      this.alu.setPadding(0, 0, 0, 0);
      break;
      this.lcA.getWindow().clearFlags(8);
      this.lcA.getWindow().clearFlags(131072);
      this.lcA.getWindow().clearFlags(128);
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(0);
      break label358;
    }
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(159359);
    if (this.Jfs == null)
    {
      AppMethodBeat.o(159359);
      return;
    }
    this.Jfs.setVisibility(8);
    AppMethodBeat.o(159359);
  }
  
  public final e fvr()
  {
    AppMethodBeat.i(199681);
    this.JfN = true;
    if (this.khe != null)
    {
      if (!this.JfN) {
        break label113;
      }
      this.khe.setBackgroundResource(2131234972);
      this.Jft.setBackgroundColor(this.mContext.getResources().getColor(2131099727));
      this.Jfu.setBackgroundColor(this.mContext.getResources().getColor(2131099667));
      this.Jfv.setTextColor(this.mContext.getResources().getColor(2131099673));
      this.Jfv.setBackgroundResource(2131234852);
    }
    for (;;)
    {
      AppMethodBeat.o(199681);
      return this;
      label113:
      this.khe.setBackgroundResource(2131234848);
    }
  }
  
  public final void fvs()
  {
    this.whK = true;
  }
  
  public final void fvt()
  {
    this.lcH = true;
  }
  
  public final void fvu()
  {
    AppMethodBeat.i(159363);
    if (this.lcA != null)
    {
      if ((this.Jfn != null) && (this.Jfw != null)) {
        this.Jfw.arg.notifyChanged();
      }
      if (this.Jfx != null) {
        this.Jfx.arg.notifyChanged();
      }
      this.lcA.show();
    }
    AppMethodBeat.o(159363);
  }
  
  public final void gJ(View paramView)
  {
    AppMethodBeat.i(210315);
    J(paramView, false);
    AppMethodBeat.o(210315);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.lcA != null) && (this.lcA.isShowing()))
    {
      AppMethodBeat.o(159365);
      return true;
    }
    AppMethodBeat.o(159365);
    return false;
  }
  
  public final void m(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199680);
    if ((this.Jfq != null) && (this.vQk))
    {
      this.Jfq.setVisibility(0);
      this.Jfq.removeAllViews();
      this.Jfq.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setTextSize(0, paramInt2);
      localTextView.setGravity(paramInt1 | 0x50);
      this.Jfq.addView(localView, -1, -2);
    }
    AppMethodBeat.o(199680);
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(159353);
    if (isShowing())
    {
      View localView = this.oP;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bmi();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.lcE != aly()) || (this.lcF != getRotation()))) {
        bmi();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void p(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159357);
    if ((this.Jfq != null) && (this.vQk))
    {
      this.Jfq.setVisibility(0);
      this.Jfq.removeAllViews();
      this.Jfq.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      this.Jfq.addView(localView, -1, -2);
    }
    AppMethodBeat.o(159357);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.khe != null) {
      this.khe.setBackgroundColor(paramInt);
    }
    this.Jfp = Boolean.valueOf(am.ZN(paramInt));
    if ((this.Jfp.booleanValue()) && (this.JfD != null)) {
      this.JfD.setImageDrawable(this.mContext.getResources().getDrawable(2131100200));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.Jfr != null)
    {
      if (paramView == null)
      {
        this.Jfr.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.Jfr.setVisibility(0);
      this.Jfr.removeAllViews();
      this.Jfr.setGravity(17);
      this.Jfr.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
  }
  
  public final e yh(boolean paramBoolean)
  {
    this.JfM = paramBoolean;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
  
  public final class c
    extends RecyclerView.a<a>
  {
    l JfP;
    AdapterView.OnItemClickListener apn;
    
    public c() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      if (e.G(e.this))
      {
        i = this.JfP.size();
        j = e.e(e.this).size();
        AppMethodBeat.o(159348);
        return i + j + 1;
      }
      int i = this.JfP.size();
      int j = e.e(e.this).size();
      AppMethodBeat.o(159348);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.w
      implements View.OnClickListener
    {
      ImageView Imq;
      ImageView JfQ;
      RadioButton JfR;
      LinearLayout JfS;
      View JfT;
      View fUM;
      TextView fUk;
      TextView ikp;
      WeImageView rTQ;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(159346);
        paramView.setOnClickListener(this);
        this.fUk = ((TextView)paramView.findViewById(2131305902));
        this.rTQ = ((WeImageView)paramView.findViewById(2131300874));
        this.JfS = ((LinearLayout)paramView.findViewById(2131304239));
        this.JfT = paramView.findViewById(2131302798);
        this.fUM = paramView.findViewById(2131303917);
        if (e.E(e.this)) {
          this.JfQ = ((ImageView)paramView.findViewById(2131300884));
        }
        if (e.y(e.this)) {
          this.JfR = ((RadioButton)paramView.findViewById(2131303704));
        }
        if ((e.y(e.this)) || (e.F(e.this)))
        {
          this.ikp = ((TextView)paramView.findViewById(2131298996));
          this.Imq = ((ImageView)paramView.findViewById(2131299154));
        }
        AppMethodBeat.o(159346);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(159347);
        if (e.c.this.apn != null) {
          e.c.this.apn.onItemClick(null, paramView, getPosition(), getPosition());
        }
        AppMethodBeat.o(159347);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */