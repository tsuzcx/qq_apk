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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.view.Display;
import android.view.LayoutInflater;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private l ECx;
  public b KtV;
  private boolean KtW;
  public n.d LfS;
  public n.e LfT;
  public n.a LfW;
  public n.b LfX;
  public n.d LsQ;
  public n.d LsR;
  private n.e LsS;
  public n.e LsT;
  public n.e LsU;
  public a LsV;
  public n.a LsW;
  private l LsX;
  private l LsY;
  private l LsZ;
  private Boolean Lta;
  private LinearLayout Ltb;
  private LinearLayout Ltc;
  private LinearLayout Ltd;
  private CustomScrollView Lte;
  private View Ltf;
  private View Ltg;
  private TextView Lth;
  private c Lti;
  private c Ltj;
  private boolean Ltk;
  private boolean Ltl;
  private boolean Ltm;
  private boolean Ltn;
  private RecyclerView Lto;
  private ImageView Ltp;
  private ImageView Ltq;
  private int Ltr;
  private int Lts;
  private int Ltt;
  private int Ltu;
  public boolean Ltv;
  public boolean Ltw;
  private int Ltx;
  public boolean Lty;
  private boolean Ltz;
  private ViewTreeObserver afv;
  private RecyclerView anl;
  public int iNL;
  private View kFh;
  private Dialog lDY;
  private int lEa;
  private BottomSheetBehavior lEb;
  private boolean lEc;
  private int lEd;
  public boolean lEe;
  public boolean lEf;
  private boolean lEg;
  public int lEh;
  private Context mContext;
  private View qI;
  private boolean tds;
  public boolean tdt;
  public boolean xFq;
  private boolean xnl;
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.Lta = Boolean.FALSE;
    this.Ltk = false;
    this.Ltl = false;
    this.Ltm = false;
    this.Ltn = false;
    this.lEc = false;
    this.Ltr = 4;
    this.Lts = (this.Ltr * 3);
    this.Ltt = 6;
    this.xFq = false;
    this.tdt = false;
    this.KtW = false;
    this.lEf = false;
    this.Ltv = false;
    this.Ltw = false;
    this.iNL = 0;
    this.lEg = false;
    this.Ltx = 0;
    this.lEh = 0;
    this.Lty = false;
    this.Ltz = false;
    this.Ltu = paramInt;
    this.mContext = paramContext;
    this.xnl = paramBoolean;
    this.Ltw = false;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aN(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public e(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(200360);
    this.Lta = Boolean.FALSE;
    this.Ltk = false;
    this.Ltl = false;
    this.Ltm = false;
    this.Ltn = false;
    this.lEc = false;
    this.Ltr = 4;
    this.Lts = (this.Ltr * 3);
    this.Ltt = 6;
    this.xFq = false;
    this.tdt = false;
    this.KtW = false;
    this.lEf = false;
    this.Ltv = false;
    this.Ltw = false;
    this.iNL = 0;
    this.lEg = false;
    this.Ltx = 0;
    this.lEh = 0;
    this.Lty = false;
    this.Ltz = false;
    this.Ltu = paramInt;
    this.mContext = paramContext;
    this.lEg = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aN(this.mContext);
    AppMethodBeat.o(200360);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.ECx = new l(paramContext);
    this.LsX = new l(paramContext);
    this.LsY = new l(paramContext);
    this.LsZ = new l(paramContext);
    if (this.lEg)
    {
      this.lDY = new b(paramContext);
      this.kFh = View.inflate(paramContext, 2131494771, null);
      this.Ltb = ((LinearLayout)this.kFh.findViewById(2131297466));
      this.Ltc = ((LinearLayout)this.kFh.findViewById(2131297462));
      this.Ltd = ((LinearLayout)this.kFh.findViewById(2131297459));
      this.Ltg = this.kFh.findViewById(2131307286);
      this.Lth = ((TextView)this.kFh.findViewById(2131307287));
      this.Lte = ((CustomScrollView)this.kFh.findViewById(2131308265));
      this.Ltf = this.kFh.findViewById(2131308322);
      this.Ltp = ((ImageView)this.kFh.findViewById(2131299071));
      this.Ltq = ((ImageView)this.kFh.findViewById(2131302242));
      this.Ltd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159340);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          e.this.bqD();
          if (e.b(e.this) != null) {
            e.b(e.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159340);
        }
      });
      this.anl = ((RecyclerView)this.kFh.findViewById(2131297464));
      this.anl.setHasFixedSize(true);
      this.Lto = ((RecyclerView)this.kFh.findViewById(2131297465));
      this.Lto.setHasFixedSize(true);
      this.lEc = aoA();
      if (this.Ltu != 0) {
        break label763;
      }
      this.Ltn = true;
      if (!this.lEc) {
        break label722;
      }
      this.Ltr = 7;
      this.Lts = (this.Ltr * 2);
      this.lEa = (aq.ay(this.mContext, 2131165202) + aq.ay(this.mContext, 2131166412));
      label362:
      if (this.xnl) {
        this.lEa += aq.ay(this.mContext, 2131166412);
      }
      this.Ltd.setVisibility(0);
      if (this.kFh != null)
      {
        if ((!this.lEg) || (!aoA())) {
          break label750;
        }
        this.kFh.setBackgroundColor(this.mContext.getResources().getColor(2131099649));
      }
      label437:
      this.Lte.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(200356);
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() - (paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY()) < 50)
          {
            e.c(e.this).setVisibility(8);
            AppMethodBeat.o(200356);
            return;
          }
          e.c(e.this).setVisibility(0);
          AppMethodBeat.o(200356);
        }
      });
      label452:
      if ((this.xnl) && (this.Ltp != null) && (this.Ltw)) {
        this.Ltp.setVisibility(0);
      }
      if (this.Ltu != 0) {
        break label1004;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.anl.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.Lto.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.anl.setFocusable(false);
      this.anl.setItemViewCacheSize(20);
      this.Lti = new c();
      this.Lti.LtB = this.ECx;
      this.Lti.arf = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (paramAnonymousInt >= e.d(e.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159342);
            return;
          }
          paramAnonymousAdapterView = (m)e.d(e.this).JGM.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.lXh))
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159342);
            return;
          }
          if (paramAnonymousInt < e.d(e.this).size()) {
            if (e.e(e.this) != null) {
              e.e(e.this).onMMMenuItemSelected(e.d(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
            }
          }
          for (;;)
          {
            if (!e.h(e.this)) {
              e.this.bqD();
            }
            e.i(e.this);
            e.a(e.this, paramAnonymousInt);
            e.j(e.this).asY.notifyChanged();
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159342);
            return;
            paramAnonymousAdapterView.performClick();
            continue;
            if ((e.f(e.this).size() > 0) && (paramAnonymousInt < e.d(e.this).size() + e.f(e.this).size()))
            {
              if (e.g(e.this) != null) {
                e.g(e.this).onMMMenuItemSelected(e.f(e.this).getItem(paramAnonymousInt - e.d(e.this).size()), paramAnonymousInt);
              }
            }
            else {
              e.fQC();
            }
          }
        }
      };
      this.anl.setAdapter(this.Lti);
      this.anl.setOverScrollMode(1);
      this.Ltj = new c();
      this.Ltj.LtB = this.LsY;
      this.Ltj.arf = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(200357);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (paramAnonymousInt > e.k(e.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(200357);
            return;
          }
          paramAnonymousAdapterView = (m)e.k(e.this).JGM.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.lXh))
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(200357);
            return;
          }
          if ((paramAnonymousInt < e.k(e.this).size()) && (e.l(e.this) != null)) {
            e.l(e.this).onMMMenuItemSelected(e.k(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!e.h(e.this)) {
            e.this.bqD();
          }
          e.i(e.this);
          e.m(e.this).asY.notifyChanged();
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(200357);
        }
      };
      this.Lto.setAdapter(this.Ltj);
      this.Lto.setOverScrollMode(1);
      if (this.lDY != null) {
        this.lDY.setContentView(this.kFh);
      }
      if (this.lDY != null) {
        this.lDY.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159344);
            if (e.n(e.this) != null)
            {
              if (!e.n(e.this).isAlive()) {
                e.a(e.this, e.o(e.this).getViewTreeObserver());
              }
              e.n(e.this).removeGlobalOnLayoutListener(e.this);
              e.a(e.this, null);
            }
            if (!e.p(e.this)) {
              e.q(e.this);
            }
            AppMethodBeat.o(159344);
          }
        });
      }
      AppMethodBeat.o(159355);
      return;
      this.lDY = new i(paramContext);
      break;
      label722:
      this.lEa = (aq.ay(this.mContext, 2131165201) + aq.ay(this.mContext, 2131166412));
      break label362;
      label750:
      this.kFh.setBackgroundResource(2131234449);
      break label437;
      label763:
      if (this.Ltu == 2)
      {
        this.Ltl = true;
        i = aq.ay(this.mContext, 2131165927);
        if (this.lEc) {
          this.Ltt = 2;
        }
        for (this.lEa = ((int)(i * 2.5D) + aq.ay(this.mContext, 2131165923));; this.lEa = ((int)(i * 3.5D) + aq.ay(this.mContext, 2131165923)))
        {
          if (!this.xnl) {
            break label877;
          }
          this.lEa += aq.fromDPToPix(this.mContext, 88);
          break;
          this.Ltt = 3;
        }
        break label452;
      }
      label877:
      this.Ltm = true;
      int i = aq.ay(this.mContext, 2131165930);
      if (this.lEc) {
        this.Ltt = 4;
      }
      for (this.lEa = ((int)(i * 4.5D) + aq.ay(this.mContext, 2131165923));; this.lEa = ((int)(i * 6.5D) + aq.ay(this.mContext, 2131165923)))
      {
        if (this.xnl) {
          this.lEa += aq.ay(this.mContext, 2131166412);
        }
        if (this.Ltd == null) {
          break;
        }
        this.Ltd.setVisibility(0);
        break;
        this.Ltt = 6;
      }
      label1004:
      this.anl.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  private boolean aoA()
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
  private void eYf()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.lDY != null))
    {
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.lDY.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private void fQB()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kFh.getLayoutParams();
    this.ECx.size();
    if ((!this.Ltk) && (this.LsX.size() > 0)) {
      this.LsX.size();
    }
    Rect localRect;
    if ((this.lEc) && (this.qI != null))
    {
      localRect = new Rect();
      this.qI.getWindowVisibleDisplayFrame(localRect);
      if (!this.lEg) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.lEh != 0) {
        localLayoutParams.width = this.lEh;
      }
      if (!ar.kf(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - ar.kd(this.mContext));
    }
    for (;;)
    {
      this.kFh.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(159366);
      return;
      label157:
      localLayoutParams.height = localRect.bottom;
      continue;
      label168:
      localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
      if (this.lEh != 0) {
        localLayoutParams.width = this.lEh;
      }
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
  
  public final void P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159356);
    if (paramView == null)
    {
      AppMethodBeat.o(159356);
      return;
    }
    this.xnl = true;
    ImageView localImageView;
    if (this.Ltp != null)
    {
      localImageView = this.Ltp;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.Ltb != null)
      {
        this.Ltb.setVisibility(0);
        this.Ltb.removeAllViews();
        this.Ltb.setGravity(17);
        this.Ltb.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void a(n.d paramd)
  {
    this.LfS = paramd;
  }
  
  public final void a(n.e parame)
  {
    this.LfT = parame;
  }
  
  public final void a(a parama)
  {
    this.LsV = parama;
  }
  
  public final void b(n.d paramd)
  {
    this.LsQ = paramd;
  }
  
  public final void b(n.e parame)
  {
    this.LsT = parame;
  }
  
  public final void b(b paramb)
  {
    this.KtV = paramb;
  }
  
  public final void bqD()
  {
    AppMethodBeat.i(159364);
    if (this.lDY != null)
    {
      if (this.lEb != null) {
        this.lEb.nZ = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lDY.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void cPF()
  {
    int j = 0;
    AppMethodBeat.i(159362);
    this.KtW = false;
    this.lEc = aoA();
    this.lEd = getRotation();
    if (this.LfS != null) {
      this.LfS.onCreateMMMenu(this.ECx);
    }
    if (this.LsQ != null) {
      this.LsQ.onCreateMMMenu(this.LsY);
    }
    if (this.LsR != null) {
      this.LsR.onCreateMMMenu(this.LsZ);
    }
    final int i;
    if (this.lDY != null)
    {
      fQB();
      if (!this.Ltn) {
        break label929;
      }
      if (this.LsY.size() > 0)
      {
        this.Ltq.setVisibility(0);
        this.Lto.setVisibility(0);
        if (this.Ltg != null) {
          this.Ltg.setVisibility(8);
        }
      }
      Object localObject;
      if (this.LsZ.size() > 0)
      {
        if (this.Ltb != null)
        {
          this.Ltb.setVisibility(0);
          this.Ltb.removeAllViews();
          this.Ltb.setGravity(17);
        }
        View localView = View.inflate(this.mContext, 2131496434, null);
        LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131308357);
        i = 0;
        while (i < this.LsZ.size())
        {
          m localm = (m)this.LsZ.JGM.get(i);
          if (localm.JGO)
          {
            localObject = View.inflate(this.mContext, 2131496432, null);
            localLinearLayout.addView((View)localObject);
            i += 1;
          }
          else
          {
            localObject = View.inflate(this.mContext, 2131496433, null);
            WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(2131308362);
            TextView localTextView1 = (TextView)((View)localObject).findViewById(2131308361);
            TextView localTextView2 = (TextView)((View)localObject).findViewById(2131308355);
            if (this.LsW != null) {
              this.LsW.a(localWeImageView, localm);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localm.JGQ);
              localTextView1.setText(localm.getTitle());
              if (localm.tMa != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localm.tMa);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(200358);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  if ((e.r(e.this) != null) && (i < e.s(e.this).size())) {
                    e.r(e.this).onMMMenuItemSelected(e.s(e.this).getItem(i), i);
                  }
                  if (!e.h(e.this)) {
                    e.this.bqD();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(200358);
                }
              });
              break;
              localWeImageView.setImageDrawable(localm.getIcon());
            }
          }
        }
        this.Ltb.addView(localView);
      }
      int k = aq.ay(this.mContext, 2131166412);
      int m = aq.ay(this.mContext, 2131165289);
      i = k;
      if (this.xnl)
      {
        i = k;
        if (this.Ltb.getVisibility() == 0) {
          i = aq.fromDPToPix(this.mContext, 0);
        }
      }
      this.anl.setPadding(0, i, this.anl.getPaddingRight(), this.anl.getPaddingBottom());
      if (!aoA()) {
        break label892;
      }
      this.Lto.setPadding(0, this.Lto.getPaddingTop(), this.Lto.getPaddingRight(), m);
      this.Lte.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.Lte.getChildAt(0) != null)
      {
        localObject = new Rect();
        this.qI.getWindowVisibleDisplayFrame((Rect)localObject);
        if (this.Lte.getChildAt(0).getMeasuredHeight() + aq.ay(this.mContext, 2131165299) <= ((Rect)localObject).bottom) {
          break label924;
        }
        i = 1;
        label622:
        if (i != 0) {
          this.Ltf.setVisibility(0);
        }
      }
      label634:
      if ((this.LsX != null) && (this.Lti != null)) {
        this.Lti.asY.notifyChanged();
      }
      if (this.Ltj != null) {
        this.Ltj.asY.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.lDY.getWindow().addFlags(-2147483648);
      }
      if (this.tds) {
        eYf();
      }
      if (this.lEe) {
        this.lDY.getWindow().addFlags(1024);
      }
      if (!this.lEf) {
        break label943;
      }
      this.lDY.getWindow().setFlags(8, 8);
      this.lDY.getWindow().addFlags(131200);
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    for (;;)
    {
      if (this.lEb != null) {
        this.lEb.nZ = false;
      }
      if (this.KtV != null) {
        this.lDY.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(200359);
            if (!e.t(e.this)) {
              e.this.KtV.onDismiss();
            }
            AppMethodBeat.o(200359);
          }
        });
      }
      if (this.qI != null)
      {
        i = j;
        if (this.afv == null) {
          i = 1;
        }
        this.afv = this.qI.getViewTreeObserver();
        if (i != 0) {
          this.afv.addOnGlobalLayoutListener(this);
        }
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lDY.show();
      }
      AppMethodBeat.o(159362);
      return;
      label892:
      this.Lto.setPadding(0, this.Lto.getPaddingTop(), this.Lto.getPaddingRight(), this.Lto.getPaddingBottom());
      break;
      label924:
      i = 0;
      break label622;
      label929:
      this.anl.setPadding(0, 0, 0, 0);
      break label634;
      label943:
      this.lDY.getWindow().clearFlags(8);
      this.lDY.getWindow().clearFlags(131072);
      this.lDY.getWindow().clearFlags(128);
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void fQA()
  {
    AppMethodBeat.i(159363);
    if (this.lDY != null)
    {
      if ((this.LsX != null) && (this.Lti != null)) {
        this.Lti.asY.notifyChanged();
      }
      if (this.Ltj != null) {
        this.Ltj.asY.notifyChanged();
      }
      this.lDY.show();
    }
    AppMethodBeat.o(159363);
  }
  
  public final void fQw()
  {
    AppMethodBeat.i(159359);
    if (this.Ltd == null)
    {
      AppMethodBeat.o(159359);
      return;
    }
    this.Ltd.setVisibility(8);
    AppMethodBeat.o(159359);
  }
  
  public final e fQx()
  {
    AppMethodBeat.i(200363);
    this.Ltz = true;
    if (this.kFh != null)
    {
      if (!this.Ltz) {
        break label113;
      }
      if (this.Ltu != 0) {
        break label100;
      }
      this.kFh.setBackgroundResource(2131235103);
      this.Ltg.setBackgroundColor(this.mContext.getResources().getColor(2131099727));
      this.Lth.setTextColor(this.mContext.getResources().getColor(2131099673));
      this.Lth.setBackgroundResource(2131234852);
    }
    for (;;)
    {
      AppMethodBeat.o(200363);
      return this;
      label100:
      this.kFh.setBackgroundResource(2131234972);
      break;
      label113:
      this.kFh.setBackgroundResource(2131234848);
    }
  }
  
  public final void fQy()
  {
    this.xFq = true;
  }
  
  public final void fQz()
  {
    this.lEf = true;
  }
  
  public final void hf(View paramView)
  {
    AppMethodBeat.i(224516);
    P(paramView, false);
    AppMethodBeat.o(224516);
  }
  
  public final void i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200362);
    if ((this.Ltb != null) && (this.xnl))
    {
      this.Ltb.setVisibility(0);
      this.Ltb.removeAllViews();
      this.Ltb.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setTextSize(0, paramInt2);
      localTextView.setGravity(paramInt1 | 0x50);
      if (this.Ltz) {
        localTextView.setTextColor(this.mContext.getResources().getColor(2131099671));
      }
      this.Ltb.addView(localView, -1, -2);
    }
    AppMethodBeat.o(200362);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.lDY != null) && (this.lDY.isShowing()))
    {
      AppMethodBeat.o(159365);
      return true;
    }
    AppMethodBeat.o(159365);
    return false;
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(159353);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bqD();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.lEc != aoA()) || (this.lEd != getRotation()))) {
        bqD();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void p(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159357);
    if ((this.Ltb != null) && (this.xnl))
    {
      this.Ltb.setVisibility(0);
      this.Ltb.removeAllViews();
      this.Ltb.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      if (this.Ltz) {
        localTextView.setTextColor(this.mContext.getResources().getColor(2131099671));
      }
      this.Ltb.addView(localView, -1, -2);
    }
    AppMethodBeat.o(159357);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.kFh != null) {
      this.kFh.setBackgroundColor(paramInt);
    }
    this.Lta = Boolean.valueOf(ao.acF(paramInt));
    if ((this.Lta.booleanValue()) && (this.Ltp != null)) {
      this.Ltp.setImageDrawable(this.mContext.getResources().getDrawable(2131100200));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.Ltc != null)
    {
      if (paramView == null)
      {
        this.Ltc.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.Ltc.setVisibility(0);
      this.Ltc.removeAllViews();
      this.Ltc.setGravity(17);
      this.Ltc.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
  }
  
  public final e zh(boolean paramBoolean)
  {
    this.Lty = paramBoolean;
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
    l LtB;
    AdapterView.OnItemClickListener arf;
    
    public c() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      if (e.F(e.this))
      {
        i = this.LtB.size();
        j = e.f(e.this).size();
        AppMethodBeat.o(159348);
        return i + j + 1;
      }
      int i = this.LtB.size();
      int j = e.f(e.this).size();
      AppMethodBeat.o(159348);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.w
      implements View.OnClickListener
    {
      ImageView Kzg;
      ImageView LtC;
      RadioButton LtD;
      LinearLayout LtE;
      View LtF;
      View gqK;
      TextView gqi;
      TextView iGz;
      WeImageView tbM;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(159346);
        paramView.setOnClickListener(this);
        this.gqi = ((TextView)paramView.findViewById(2131305902));
        this.tbM = ((WeImageView)paramView.findViewById(2131300874));
        this.LtE = ((LinearLayout)paramView.findViewById(2131304239));
        this.LtF = paramView.findViewById(2131302798);
        this.gqK = paramView.findViewById(2131303917);
        if (e.D(e.this)) {
          this.LtC = ((ImageView)paramView.findViewById(2131300884));
        }
        if (e.x(e.this)) {
          this.LtD = ((RadioButton)paramView.findViewById(2131303704));
        }
        if ((e.x(e.this)) || (e.E(e.this)))
        {
          this.iGz = ((TextView)paramView.findViewById(2131298996));
          this.Kzg = ((ImageView)paramView.findViewById(2131299154));
        }
        AppMethodBeat.o(159346);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(159347);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (e.c.this.arf != null) {
          e.c.this.arf.onItemClick(null, paramView, getPosition(), getPosition());
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