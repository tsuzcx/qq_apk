package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
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
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.a;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.d;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.o.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean BFo;
  private boolean Bln;
  public o.f HLX;
  public o.g HLY;
  private o.g HLZ;
  private boolean HMD;
  public o.b HMa;
  public o.c HMb;
  public m HMc;
  private m HMd;
  private boolean HMf;
  public boolean HMg;
  private LinearLayout HMv;
  private LinearLayout HMw;
  public b PGl;
  private boolean PGm;
  public c QNG;
  public o.f QNH;
  private o.f QNI;
  public o.f QNJ;
  public o.g QNK;
  private o.g QNL;
  public o.g QNM;
  private e QNN;
  public a QNO;
  public o.b QNP;
  public o.b QNQ;
  private o.a QNR;
  private o.c QNS;
  private m QNT;
  private m QNU;
  private m QNV;
  private Boolean QNW;
  private LinearLayout QNX;
  private LinearLayout QNY;
  private CustomScrollView QNZ;
  private boolean QOA;
  private View QOa;
  private View QOb;
  private TextView QOc;
  public f QOd;
  private f QOe;
  private boolean QOf;
  private boolean QOg;
  private boolean QOh;
  private RecyclerView QOi;
  private ImageView QOj;
  private ImageView QOk;
  private int QOl;
  private int QOm;
  private int QOn;
  private int QOo;
  public boolean QOp;
  private int QOq;
  public boolean QOr;
  public RecyclerView.r QOs;
  private boolean QOt;
  private boolean QOu;
  private boolean QOv;
  private String QOw;
  private o.b QOx;
  private o.a QOy;
  private o.h QOz;
  private ViewTreeObserver afI;
  public int jKz;
  private View lJI;
  private Context mContext;
  private Dialog mLH;
  private int mLJ;
  private BottomSheetBehavior mLK;
  private boolean mLL;
  private int mLM;
  public boolean mLN;
  public boolean mLO;
  private boolean mLP;
  public int mLQ;
  public RecyclerView mRecyclerView;
  private View qK;
  private boolean wjM;
  public boolean wjN;
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.QNW = Boolean.FALSE;
    this.QOf = false;
    this.HMf = false;
    this.QOg = false;
    this.QOh = false;
    this.mLL = false;
    this.QOl = 4;
    this.QOm = (this.QOl * 3);
    this.QOn = 6;
    this.BFo = false;
    this.wjN = false;
    this.PGm = false;
    this.mLO = false;
    this.HMg = false;
    this.QOp = false;
    this.jKz = 0;
    this.mLP = false;
    this.QOq = 0;
    this.mLQ = 0;
    this.QOr = false;
    this.HMD = false;
    this.QOs = null;
    this.QOt = false;
    this.QOu = false;
    this.QOv = true;
    this.QOw = null;
    this.QOx = null;
    this.QOy = null;
    this.QOz = null;
    this.QOA = false;
    this.QOo = paramInt;
    this.mContext = paramContext;
    this.Bln = paramBoolean;
    this.QOp = false;
    if ((this.mContext instanceof Activity)) {
      this.qK = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    bh(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public e(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(198239);
    this.QNW = Boolean.FALSE;
    this.QOf = false;
    this.HMf = false;
    this.QOg = false;
    this.QOh = false;
    this.mLL = false;
    this.QOl = 4;
    this.QOm = (this.QOl * 3);
    this.QOn = 6;
    this.BFo = false;
    this.wjN = false;
    this.PGm = false;
    this.mLO = false;
    this.HMg = false;
    this.QOp = false;
    this.jKz = 0;
    this.mLP = false;
    this.QOq = 0;
    this.mLQ = 0;
    this.QOr = false;
    this.HMD = false;
    this.QOs = null;
    this.QOt = false;
    this.QOu = false;
    this.QOv = true;
    this.QOw = null;
    this.QOx = null;
    this.QOy = null;
    this.QOz = null;
    this.QOA = false;
    this.QOo = paramInt;
    this.mContext = paramContext;
    this.mLP = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.qK = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    bh(this.mContext);
    AppMethodBeat.o(198239);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.HMc = new m(paramContext);
    this.HMd = new m(paramContext);
    this.QNT = new m(paramContext);
    this.QNU = new m(paramContext);
    this.QNV = new m(paramContext);
    if (this.mLP)
    {
      this.mLH = new b(paramContext);
      this.lJI = View.inflate(paramContext, 2131495505, null);
      this.HMv = ((LinearLayout)this.lJI.findViewById(2131297701));
      this.HMw = ((LinearLayout)this.lJI.findViewById(2131297696));
      this.QNX = ((LinearLayout)this.lJI.findViewById(2131297693));
      this.QOb = this.lJI.findViewById(2131297969);
      this.QNY = ((LinearLayout)this.lJI.findViewById(2131297697));
      this.QOc = ((TextView)this.lJI.findViewById(2131297970));
      this.QNZ = ((CustomScrollView)this.lJI.findViewById(2131299217));
      this.QOa = this.lJI.findViewById(2131302161);
      this.QOj = ((ImageView)this.lJI.findViewById(2131299577));
      this.QOk = ((ImageView)this.lJI.findViewById(2131304620));
      this.QNX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159340);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          e.this.bMo();
          if (e.b(e.this) != null) {
            e.b(e.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159340);
        }
      });
      this.mRecyclerView = ((RecyclerView)this.lJI.findViewById(2131297699));
      this.mRecyclerView.setHasFixedSize(true);
      if (this.mRecyclerView.getItemAnimator() != null) {
        this.mRecyclerView.getItemAnimator().atn = 100L;
      }
      this.QOi = ((RecyclerView)this.lJI.findViewById(2131297700));
      this.QOi.setHasFixedSize(true);
      this.QOs = new ae(this.mRecyclerView.getContext())
      {
        public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
        {
          return 1.0F / paramAnonymousDisplayMetrics.densityDpi;
        }
        
        public final PointF bZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(198226);
          if ((e.c(e.this) != null) && (e.c(e.this).getLayoutManager() != null) && ((e.c(e.this).getLayoutManager() instanceof LinearLayoutManager)))
          {
            localPointF = ((LinearLayoutManager)e.c(e.this).getLayoutManager()).bZ(paramAnonymousInt);
            AppMethodBeat.o(198226);
            return localPointF;
          }
          PointF localPointF = super.bZ(paramAnonymousInt);
          AppMethodBeat.o(198226);
          return localPointF;
        }
        
        public final int kz()
        {
          return -1;
        }
      };
      this.mLL = isLandscape();
      if (this.QOo != 0) {
        break label840;
      }
      this.QOh = true;
      if (!this.mLL) {
        break label799;
      }
      this.QOl = 7;
      this.QOm = (this.QOl * 2);
      this.mLJ = (at.aH(this.mContext, 2131165205) + at.aH(this.mContext, 2131166504));
      label436:
      if (this.Bln) {
        this.mLJ += at.aH(this.mContext, 2131166504);
      }
      this.QNX.setVisibility(0);
      if (this.lJI != null)
      {
        if ((!this.mLP) || (!isLandscape())) {
          break label827;
        }
        this.lJI.setBackgroundColor(this.mContext.getResources().getColor(2131099649));
      }
      label511:
      this.QNZ.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(198227);
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() - (paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY()) < 50)
          {
            e.d(e.this).setVisibility(8);
            AppMethodBeat.o(198227);
            return;
          }
          e.d(e.this).setVisibility(0);
          AppMethodBeat.o(198227);
        }
      });
      label526:
      if ((this.Bln) && (this.QOj != null) && (this.QOp)) {
        this.QOj.setVisibility(0);
      }
      if (this.QOo != 0) {
        break label1081;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.mRecyclerView.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.QOi.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.mRecyclerView.setFocusable(false);
      this.mRecyclerView.setItemViewCacheSize(20);
      this.QOd = new f(false);
      this.QOd.HMj = this.HMc;
      this.QOd.ars = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(198228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (paramAnonymousInt < e.e(e.this).size())
          {
            paramAnonymousAdapterView = (n)e.e(e.this).ORD.get(paramAnonymousInt);
            if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.neT))
            {
              a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198228);
              return;
            }
            if (e.f(e.this) != null) {
              e.f(e.this).onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            }
          }
          for (;;)
          {
            if (!e.k(e.this)) {
              e.this.bMo();
            }
            e.l(e.this);
            e.a(e.this, paramAnonymousInt);
            e.m(e.this).atj.notifyChanged();
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(198228);
            return;
            paramAnonymousAdapterView.performClick();
            continue;
            if ((e.g(e.this).size() > 0) && (paramAnonymousInt < e.e(e.this).size() + e.g(e.this).size()))
            {
              paramAnonymousAdapterView = (n)e.g(e.this).getItem(paramAnonymousInt - e.e(e.this).size());
              if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.neT))
              {
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(198228);
                return;
              }
              if (e.h(e.this) != null) {
                e.h(e.this).onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
              } else {
                paramAnonymousAdapterView.performClick();
              }
            }
            else
            {
              if (!e.i(e.this))
              {
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(198228);
                return;
              }
              e.j(e.this);
            }
          }
        }
      };
      this.mRecyclerView.setAdapter(this.QOd);
      this.mRecyclerView.setOverScrollMode(1);
      this.QOe = new f(true);
      this.QOe.HMj = this.QNT;
      this.QOe.ars = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(198229);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (paramAnonymousInt >= e.n(e.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(198229);
            return;
          }
          paramAnonymousAdapterView = (n)e.n(e.this).ORD.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.neT))
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(198229);
            return;
          }
          if ((paramAnonymousInt < e.n(e.this).size()) && (e.o(e.this) != null)) {
            e.o(e.this).onMMMenuItemSelected(e.n(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!e.k(e.this)) {
            e.this.bMo();
          }
          e.l(e.this);
          e.p(e.this).atj.notifyChanged();
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(198229);
        }
      };
      this.QOi.setAdapter(this.QOe);
      this.QOi.setOverScrollMode(1);
      if (this.mLH != null) {
        this.mLH.setContentView(this.lJI);
      }
      if (this.mLH != null) {
        this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159345);
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
            AppMethodBeat.o(159345);
          }
        });
      }
      AppMethodBeat.o(159355);
      return;
      this.mLH = new i(paramContext);
      break;
      label799:
      this.mLJ = (at.aH(this.mContext, 2131165204) + at.aH(this.mContext, 2131166504));
      break label436;
      label827:
      this.lJI.setBackgroundResource(2131235389);
      break label511;
      label840:
      if (this.QOo == 2)
      {
        this.HMf = true;
        i = at.aH(this.mContext, 2131165954);
        if (this.mLL) {
          this.QOn = 2;
        }
        for (this.mLJ = ((int)(i * 2.5D) + at.aH(this.mContext, 2131165950));; this.mLJ = ((int)(i * 3.5D) + at.aH(this.mContext, 2131165950)))
        {
          if (!this.Bln) {
            break label954;
          }
          this.mLJ += at.fromDPToPix(this.mContext, 88);
          break;
          this.QOn = 3;
        }
        break label526;
      }
      label954:
      this.QOg = true;
      int i = at.aH(this.mContext, 2131165957);
      if (this.mLL) {
        this.QOn = 4;
      }
      for (this.mLJ = ((int)(i * 4.5D) + at.aH(this.mContext, 2131165950));; this.mLJ = ((int)(i * 6.5D) + at.aH(this.mContext, 2131165950)))
      {
        if (this.Bln) {
          this.mLJ += at.aH(this.mContext, 2131166504);
        }
        if (this.QNX == null) {
          break;
        }
        this.QNX.setVisibility(0);
        break;
        this.QOn = 6;
      }
      label1081:
      this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
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
  
  @TargetApi(23)
  private void ghk()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.mLH != null))
    {
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mLH.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private void hbt()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
    this.HMc.size();
    if ((!this.QOf) && (this.HMd.size() > 0)) {
      this.HMd.size();
    }
    Rect localRect;
    if ((this.mLL) && (this.qK != null))
    {
      localRect = new Rect();
      this.qK.getWindowVisibleDisplayFrame(localRect);
      if (!this.mLP) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.mLQ != 0) {
        localLayoutParams.width = this.mLQ;
      }
      if (!au.jX(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - au.ay(this.mContext));
    }
    for (;;)
    {
      this.lJI.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(159366);
      return;
      label157:
      localLayoutParams.height = localRect.bottom;
      continue;
      label168:
      localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
      if (this.mLQ != 0) {
        localLayoutParams.width = this.mLQ;
      }
    }
  }
  
  private boolean isLandscape()
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
  
  public final void Dm(boolean paramBoolean)
  {
    AppMethodBeat.i(198242);
    if (this.QNX == null)
    {
      AppMethodBeat.o(198242);
      return;
    }
    if (paramBoolean)
    {
      this.QNX.setVisibility(8);
      AppMethodBeat.o(198242);
      return;
    }
    this.QNX.setVisibility(0);
    AppMethodBeat.o(198242);
  }
  
  public final void Dn(boolean paramBoolean)
  {
    this.QOv = paramBoolean;
  }
  
  public final void Do(boolean paramBoolean)
  {
    this.mLO = paramBoolean;
  }
  
  public final e Dp(boolean paramBoolean)
  {
    this.QOr = paramBoolean;
    return this;
  }
  
  public final void V(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159356);
    if (paramView == null)
    {
      AppMethodBeat.o(159356);
      return;
    }
    this.Bln = true;
    ImageView localImageView;
    if (this.QOj != null)
    {
      localImageView = this.QOj;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.HMv != null)
      {
        this.HMv.setVisibility(0);
        this.HMv.removeAllViews();
        this.HMv.setGravity(17);
        this.HMv.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void a(m paramm, o.g paramg, o.c paramc)
  {
    AppMethodBeat.i(198245);
    this.QOt = true;
    this.HMd = paramm;
    this.HLZ = paramg;
    this.QNS = paramc;
    if (!this.QOA)
    {
      if (this.mRecyclerView == null)
      {
        AppMethodBeat.o(198245);
        return;
      }
      paramm = paramm.ORD;
      if ((paramm == null) || (paramm.isEmpty()))
      {
        AppMethodBeat.o(198245);
        return;
      }
      paramm = paramm.iterator();
      do
      {
        if (!paramm.hasNext()) {
          break;
        }
        paramg = (MenuItem)paramm.next();
      } while ((!(paramg instanceof n)) || (((n)paramg).ORL == null));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.mRecyclerView.a(new d((byte)0));
        this.QOA = true;
      }
      AppMethodBeat.o(198245);
      return;
    }
  }
  
  public final void a(o.a parama)
  {
    this.QNR = parama;
  }
  
  public final void a(o.f paramf)
  {
    this.HLX = paramf;
  }
  
  public final void a(o.g paramg)
  {
    this.HLY = paramg;
  }
  
  public final void a(a parama)
  {
    this.QNO = parama;
  }
  
  public final void a(e parame, String paramString, o.b paramb, o.a parama, o.h paramh)
  {
    AppMethodBeat.i(198244);
    this.QOf = true;
    this.QNN = parame;
    this.QOu = true;
    this.QOw = paramString;
    this.QOx = paramb;
    this.QOy = parama;
    this.QOz = paramh;
    if (!this.QOA)
    {
      if (this.mRecyclerView == null)
      {
        AppMethodBeat.o(198244);
        return;
      }
      this.mRecyclerView.a(new d((byte)0));
      this.QOA = true;
    }
    AppMethodBeat.o(198244);
  }
  
  public final void b(o.f paramf)
  {
    this.QNH = paramf;
  }
  
  public final void b(o.g paramg)
  {
    this.QNK = paramg;
  }
  
  public final void b(b paramb)
  {
    this.PGl = paramb;
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(159364);
    if (this.mLH != null)
    {
      if (this.mLK != null) {
        this.mLK.ob = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.mLH.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void dGm()
  {
    int j = 0;
    AppMethodBeat.i(159362);
    this.PGm = false;
    this.mLL = isLandscape();
    this.mLM = getRotation();
    if (this.HLX != null) {
      this.HLX.onCreateMMMenu(this.HMc);
    }
    if (this.QNH != null) {
      this.QNH.onCreateMMMenu(this.QNT);
    }
    if (this.QNI != null) {
      this.QNI.onCreateMMMenu(this.QNU);
    }
    if (this.QNJ != null) {
      this.QNJ.onCreateMMMenu(this.QNV);
    }
    final int i;
    int m;
    if (this.mLH != null)
    {
      hbt();
      if (!this.QOh) {
        break label1327;
      }
      if (this.QNT.size() > 0)
      {
        this.QOk.setVisibility(0);
        this.QOi.setVisibility(0);
        if (this.QOb != null) {
          this.QOb.setVisibility(8);
        }
      }
      View localView;
      LinearLayout localLinearLayout;
      n localn;
      Object localObject;
      WeImageView localWeImageView;
      TextView localTextView1;
      TextView localTextView2;
      if (this.QNU.size() > 0)
      {
        if (this.HMv != null)
        {
          this.HMv.setVisibility(0);
          this.HMv.removeAllViews();
          this.HMv.setGravity(17);
        }
        localView = View.inflate(this.mContext, 2131493318, null);
        localLinearLayout = (LinearLayout)localView.findViewById(2131304619);
        i = 0;
        while (i < this.QNU.size())
        {
          localn = (n)this.QNU.ORD.get(i);
          if (localn.Bno)
          {
            localObject = View.inflate(this.mContext, 2131493316, null);
            localLinearLayout.addView((View)localObject);
            i += 1;
          }
          else
          {
            localObject = View.inflate(this.mContext, 2131493317, null);
            localWeImageView = (WeImageView)((View)localObject).findViewById(2131304645);
            localTextView1 = (TextView)((View)localObject).findViewById(2131304636);
            localTextView2 = (TextView)((View)localObject).findViewById(2131304611);
            if (this.QNP != null) {
              this.QNP.a(localWeImageView, localn);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localn.uzt);
              localTextView1.setText(localn.getTitle());
              if (localn.xdb != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localn.xdb);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(198230);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  if ((e.u(e.this) != null) && (i < e.v(e.this).size())) {
                    e.u(e.this).onMMMenuItemSelected(e.v(e.this).getItem(i), i);
                  }
                  if (!e.k(e.this)) {
                    e.this.bMo();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(198230);
                }
              });
              break;
              localWeImageView.setImageDrawable(localn.getIcon());
            }
          }
        }
        this.HMv.addView(localView);
      }
      if (this.QNV.size() > 0)
      {
        if (this.QNY != null)
        {
          this.QNY.setVisibility(0);
          this.QNY.removeAllViews();
          this.QNY.setGravity(17);
        }
        localView = View.inflate(this.mContext, 2131493315, null);
        localLinearLayout = (LinearLayout)localView.findViewById(2131304619);
        i = 0;
        while (i < this.QNV.size())
        {
          localn = (n)this.QNV.ORD.get(i);
          if (localn.Bno)
          {
            localObject = View.inflate(this.mContext, 2131493313, null);
            localLinearLayout.addView((View)localObject);
            i += 1;
          }
          else
          {
            localObject = View.inflate(this.mContext, 2131493314, null);
            localWeImageView = (WeImageView)((View)localObject).findViewById(2131304645);
            localTextView1 = (TextView)((View)localObject).findViewById(2131304636);
            localTextView2 = (TextView)((View)localObject).findViewById(2131304611);
            if (this.QNQ != null) {
              this.QNQ.a(localWeImageView, localn);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localn.uzt);
              localTextView1.setText(localn.getTitle());
              if (localn.xdb != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localn.xdb);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(198231);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  if ((e.w(e.this) != null) && (i < e.x(e.this).size())) {
                    e.w(e.this).onMMMenuItemSelected(e.x(e.this).getItem(i), i);
                  }
                  if (!e.k(e.this)) {
                    e.this.bMo();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(198231);
                }
              });
              break;
              localWeImageView.setImageDrawable(localn.getIcon());
            }
          }
        }
        if (this.QNY != null) {
          this.QNY.addView(localView);
        }
      }
      int k = at.aH(this.mContext, 2131166504);
      m = at.aH(this.mContext, 2131165296);
      i = k;
      if (this.Bln)
      {
        i = k;
        if (this.HMv.getVisibility() == 0) {
          i = at.fromDPToPix(this.mContext, 0);
        }
      }
      this.mRecyclerView.setPadding(0, i, this.mRecyclerView.getPaddingRight(), this.mRecyclerView.getPaddingBottom());
      if ((this.QNY == null) || (this.QNY.getVisibility() != 0)) {
        break label1256;
      }
      this.QNY.setPadding(0, this.QNY.getPaddingTop(), this.QNY.getPaddingRight(), m);
      this.QOi.setPadding(0, this.QOi.getPaddingTop(), this.QOi.getPaddingRight(), m);
      this.QNZ.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.QNZ.getChildAt(0) != null)
      {
        localObject = new Rect();
        this.qK.getWindowVisibleDisplayFrame((Rect)localObject);
        if (this.QNZ.getChildAt(0).getMeasuredHeight() + at.aH(this.mContext, 2131165310) <= ((Rect)localObject).bottom) {
          break label1322;
        }
        i = 1;
        label971:
        if (i != 0) {
          this.QOa.setVisibility(0);
        }
      }
      label983:
      if ((this.HMd != null) && (this.QOd != null)) {
        this.QOd.atj.notifyChanged();
      }
      if (this.QOe != null) {
        this.QOe.atj.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.mLH.getWindow().addFlags(-2147483648);
      }
      if (this.wjM) {
        ghk();
      }
      if (this.mLN) {
        this.mLH.getWindow().addFlags(1024);
      }
      if (!this.mLO) {
        break label1341;
      }
      this.mLH.getWindow().setFlags(8, 8);
      this.mLH.getWindow().addFlags(131200);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    for (;;)
    {
      if (this.mLK != null) {
        this.mLK.ob = false;
      }
      if (this.PGl != null) {
        this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(198232);
            if (!e.y(e.this)) {
              e.this.PGl.onDismiss();
            }
            AppMethodBeat.o(198232);
          }
        });
      }
      this.mLH.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(198224);
          if ((e.this.QNG != null) && (!e.y(e.this))) {
            e.this.QNG.onShow();
          }
          AppMethodBeat.o(198224);
        }
      });
      if (this.qK != null)
      {
        i = j;
        if (this.afI == null) {
          i = 1;
        }
        this.afI = this.qK.getViewTreeObserver();
        if (i != 0) {
          this.afI.addOnGlobalLayoutListener(this);
        }
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.mLH.show();
      }
      AppMethodBeat.o(159362);
      return;
      label1256:
      if (isLandscape())
      {
        this.QOi.setPadding(0, this.QOi.getPaddingTop(), this.QOi.getPaddingRight(), m);
        break;
      }
      this.QOi.setPadding(0, this.QOi.getPaddingTop(), this.QOi.getPaddingRight(), this.QOi.getPaddingBottom());
      break;
      label1322:
      i = 0;
      break label971;
      label1327:
      this.mRecyclerView.setPadding(0, 0, 0, 0);
      break label983;
      label1341:
      this.mLH.getWindow().clearFlags(8);
      this.mLH.getWindow().clearFlags(131072);
      this.mLH.getWindow().clearFlags(128);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void fPw()
  {
    AppMethodBeat.i(159363);
    if (this.mLH != null)
    {
      if ((this.HMd != null) && (this.QOd != null)) {
        this.QOd.atj.notifyChanged();
      }
      if (this.QOe != null) {
        this.QOe.atj.notifyChanged();
      }
      this.mLH.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(198225);
          if ((e.this.QNG != null) && (!e.y(e.this))) {
            e.this.QNG.onShow();
          }
          AppMethodBeat.o(198225);
        }
      });
      this.mLH.show();
    }
    AppMethodBeat.o(159363);
  }
  
  public final int hbo()
  {
    return this.QOo;
  }
  
  public final boolean hbp()
  {
    return this.wjM;
  }
  
  public final boolean hbq()
  {
    return this.mLO;
  }
  
  public final e hbr()
  {
    AppMethodBeat.i(198243);
    this.HMD = true;
    if (this.lJI != null)
    {
      if (!this.HMD) {
        break label113;
      }
      if (this.QOo != 0) {
        break label100;
      }
      this.lJI.setBackgroundResource(2131235390);
      this.QOb.setBackgroundColor(this.mContext.getResources().getColor(2131099741));
      this.QOc.setTextColor(this.mContext.getResources().getColor(2131099679));
      this.QOc.setBackgroundResource(2131231950);
    }
    for (;;)
    {
      AppMethodBeat.o(198243);
      return this;
      label100:
      this.lJI.setBackgroundResource(2131235388);
      break;
      label113:
      this.lJI.setBackgroundResource(2131235391);
    }
  }
  
  public final void hbs()
  {
    this.BFo = true;
  }
  
  public final boolean isHideStatusBar()
  {
    return this.mLN;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.mLH != null) && (this.mLH.isShowing()))
    {
      AppMethodBeat.o(159365);
      return true;
    }
    AppMethodBeat.o(159365);
    return false;
  }
  
  public final void j(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198241);
    if ((this.HMv != null) && (this.Bln))
    {
      this.HMv.setVisibility(0);
      this.HMv.removeAllViews();
      this.HMv.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(2131495509, null);
      TextView localTextView = (TextView)localView.findViewById(2131309245);
      localTextView.setText(paramCharSequence);
      localTextView.setTextSize(0, paramInt2);
      localTextView.setGravity(paramInt1 | 0x50);
      if (this.HMD) {
        localTextView.setTextColor(this.mContext.getResources().getColor(2131099679));
      }
      this.HMv.addView(localView, -1, -2);
    }
    AppMethodBeat.o(198241);
  }
  
  public final void o(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159357);
    if ((this.HMv != null) && (this.Bln))
    {
      this.HMv.setVisibility(0);
      this.HMv.removeAllViews();
      this.HMv.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2131495509, null);
      TextView localTextView = (TextView)localView.findViewById(2131309245);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      if (this.HMD) {
        localTextView.setTextColor(this.mContext.getResources().getColor(2131099679));
      }
      this.HMv.addView(localView, -1, -2);
    }
    AppMethodBeat.o(159357);
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(159353);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.lJI != null) {
      this.lJI.setBackgroundColor(paramInt);
    }
    this.QNW = Boolean.valueOf(ar.aln(paramInt));
    if ((this.QNW.booleanValue()) && (this.QOj != null)) {
      this.QOj.setImageDrawable(this.mContext.getResources().getDrawable(2131100233));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.HMw != null)
    {
      if (paramView == null)
      {
        this.HMw.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.HMw.setVisibility(0);
      this.HMw.removeAllViews();
      this.HMw.setGravity(17);
      this.HMw.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(258311);
    V(paramView, false);
    AppMethodBeat.o(258311);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
  
  public static abstract interface c
  {
    public abstract void onShow();
  }
  
  final class d
    extends RecyclerView.l
  {
    private d() {}
    
    private n aoZ(int paramInt)
    {
      AppMethodBeat.i(198236);
      if (paramInt < 0)
      {
        AppMethodBeat.o(198236);
        return null;
      }
      n localn;
      if (paramInt < e.e(e.this).size())
      {
        localn = (n)e.e(e.this).ORD.get(paramInt);
        AppMethodBeat.o(198236);
        return localn;
      }
      if ((e.g(e.this).size() > 0) && (paramInt < e.e(e.this).size() + e.g(e.this).size()))
      {
        localn = (n)e.g(e.this).getItem(paramInt - e.e(e.this).size());
        AppMethodBeat.o(198236);
        return localn;
      }
      AppMethodBeat.o(198236);
      return null;
    }
    
    private void v(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(198235);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (!(paramRecyclerView instanceof LinearLayoutManager))
      {
        AppMethodBeat.o(198235);
        return;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = paramRecyclerView.ks();
      int j = paramRecyclerView.ku();
      if (i <= j)
      {
        Object localObject = aoZ(i);
        if (localObject == null) {
          if ((i == e.e(e.this).size() + e.g(e.this).size()) && (e.T(e.this) != null)) {
            e.T(e.this).cy(paramRecyclerView.findViewByPosition(i));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = ((n)localObject).ORL;
          if (localObject != null) {
            ((o.h)localObject).cy(paramRecyclerView.findViewByPosition(i));
          }
        }
      }
      AppMethodBeat.o(198235);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(198233);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      v(paramRecyclerView);
      a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(198233);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198234);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      v(paramRecyclerView);
      a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(198234);
    }
  }
  
  public static abstract interface e
  {
    public abstract void onClick();
  }
  
  public final class f
    extends RecyclerView.a<a>
  {
    m HMj;
    private final boolean QOC;
    AdapterView.OnItemClickListener ars;
    
    public f(boolean paramBoolean)
    {
      this.QOC = paramBoolean;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      int j = this.HMj.size();
      int i;
      if (this.QOC)
      {
        i = j;
        if (e.K(e.this)) {}
      }
      else
      {
        i = j + e.g(e.this).size();
      }
      j = i;
      if (e.N(e.this)) {
        if (this.QOC)
        {
          j = i;
          if (e.K(e.this)) {}
        }
        else
        {
          j = i + 1;
        }
      }
      AppMethodBeat.o(159348);
      return j;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(198238);
      if ((paramInt >= 0) && (paramInt < this.HMj.size()))
      {
        MenuItem localMenuItem = this.HMj.getItem(paramInt);
        if (((localMenuItem instanceof n)) && (!((n)localMenuItem).ORG))
        {
          AppMethodBeat.o(198238);
          return 1;
        }
      }
      else
      {
        if ((e.g(e.this).size() > 0) && (paramInt < this.HMj.size() + e.g(e.this).size()))
        {
          AppMethodBeat.o(198238);
          return 2;
        }
        if ((e.N(e.this)) && (paramInt == this.HMj.size() + e.g(e.this).size()))
        {
          AppMethodBeat.o(198238);
          return 3;
        }
      }
      AppMethodBeat.o(198238);
      return 0;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      ImageView HMl;
      LinearLayout HMm;
      ImageView QOF;
      ImageView QOG;
      RadioButton QOH;
      View QOI;
      View hbJ;
      TextView hbb;
      TextView jCB;
      WeImageView uGm;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(159346);
        this.QOF = null;
        paramView.setOnClickListener(this);
        this.hbb = ((TextView)paramView.findViewById(2131309195));
        this.uGm = ((WeImageView)paramView.findViewById(2131302468));
        this.HMm = ((LinearLayout)paramView.findViewById(2131307157));
        this.QOI = paramView.findViewById(2131305368);
        this.hbJ = paramView.findViewById(2131306759);
        if (e.I(e.this))
        {
          this.QOG = ((ImageView)paramView.findViewById(2131302483));
          this.QOF = ((ImageView)paramView.findViewById(2131302482));
        }
        if (e.C(e.this)) {
          this.QOH = ((RadioButton)paramView.findViewById(2131306483));
        }
        if ((e.C(e.this)) || (e.J(e.this)))
        {
          this.jCB = ((TextView)paramView.findViewById(2131299495));
          this.HMl = ((ImageView)paramView.findViewById(2131299682));
        }
        AppMethodBeat.o(159346);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(159347);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (e.f.this.ars != null) {
          e.f.this.ars.onItemClick(null, paramView, getPosition(), getPosition());
        }
        a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159347);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */