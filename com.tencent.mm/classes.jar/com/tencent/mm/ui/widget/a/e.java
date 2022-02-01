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
  private l Ekt;
  public b JXC;
  private boolean JXD;
  public n.a KJC;
  public n.b KJD;
  public n.d KJy;
  public n.e KJz;
  private l KWA;
  private l KWB;
  private Boolean KWC;
  private LinearLayout KWD;
  private LinearLayout KWE;
  private LinearLayout KWF;
  private CustomScrollView KWG;
  private View KWH;
  private View KWI;
  private TextView KWJ;
  private c KWK;
  private c KWL;
  private boolean KWM;
  private boolean KWN;
  private boolean KWO;
  private boolean KWP;
  private RecyclerView KWQ;
  private ImageView KWR;
  private ImageView KWS;
  private int KWT;
  private int KWU;
  private int KWV;
  private int KWW;
  public boolean KWX;
  public boolean KWY;
  private int KWZ;
  public n.d KWs;
  public n.d KWt;
  private n.e KWu;
  public n.e KWv;
  public n.e KWw;
  public a KWx;
  public n.a KWy;
  private l KWz;
  public boolean KXa;
  private boolean KXb;
  private ViewTreeObserver afv;
  private RecyclerView anl;
  public int iKS;
  private View kBS;
  private Dialog lzA;
  private int lzC;
  private BottomSheetBehavior lzD;
  private boolean lzE;
  private int lzF;
  public boolean lzG;
  public boolean lzH;
  private boolean lzI;
  private int lzJ;
  private Context mContext;
  private View qI;
  private boolean sSh;
  public boolean sSi;
  private boolean wXu;
  public boolean xpt;
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.KWC = Boolean.FALSE;
    this.KWM = false;
    this.KWN = false;
    this.KWO = false;
    this.KWP = false;
    this.lzE = false;
    this.KWT = 4;
    this.KWU = (this.KWT * 3);
    this.KWV = 6;
    this.xpt = false;
    this.sSi = false;
    this.JXD = false;
    this.lzH = false;
    this.KWX = false;
    this.KWY = false;
    this.iKS = 0;
    this.lzI = false;
    this.KWZ = 0;
    this.lzJ = 0;
    this.KXa = false;
    this.KXb = false;
    this.KWW = paramInt;
    this.mContext = paramContext;
    this.wXu = paramBoolean;
    this.KWY = false;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aM(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public e(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(192595);
    this.KWC = Boolean.FALSE;
    this.KWM = false;
    this.KWN = false;
    this.KWO = false;
    this.KWP = false;
    this.lzE = false;
    this.KWT = 4;
    this.KWU = (this.KWT * 3);
    this.KWV = 6;
    this.xpt = false;
    this.sSi = false;
    this.JXD = false;
    this.lzH = false;
    this.KWX = false;
    this.KWY = false;
    this.iKS = 0;
    this.lzI = false;
    this.KWZ = 0;
    this.lzJ = 0;
    this.KXa = false;
    this.KXb = false;
    this.KWW = paramInt;
    this.mContext = paramContext;
    this.lzI = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aM(this.mContext);
    AppMethodBeat.o(192595);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.Ekt = new l(paramContext);
    this.KWz = new l(paramContext);
    this.KWA = new l(paramContext);
    this.KWB = new l(paramContext);
    if (this.lzI)
    {
      this.lzA = new b(paramContext);
      this.kBS = View.inflate(paramContext, 2131494771, null);
      this.KWD = ((LinearLayout)this.kBS.findViewById(2131297466));
      this.KWE = ((LinearLayout)this.kBS.findViewById(2131297462));
      this.KWF = ((LinearLayout)this.kBS.findViewById(2131297459));
      this.KWI = this.kBS.findViewById(2131307286);
      this.KWJ = ((TextView)this.kBS.findViewById(2131307287));
      this.KWG = ((CustomScrollView)this.kBS.findViewById(2131308265));
      this.KWH = this.kBS.findViewById(2131308322);
      this.KWR = ((ImageView)this.kBS.findViewById(2131299071));
      this.KWS = ((ImageView)this.kBS.findViewById(2131302242));
      this.KWF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159340);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          e.this.bpT();
          if (e.b(e.this) != null) {
            e.b(e.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159340);
        }
      });
      this.anl = ((RecyclerView)this.kBS.findViewById(2131297464));
      this.anl.setHasFixedSize(true);
      this.KWQ = ((RecyclerView)this.kBS.findViewById(2131297465));
      this.KWQ.setHasFixedSize(true);
      this.lzE = aol();
      if (this.KWW != 0) {
        break label763;
      }
      this.KWP = true;
      if (!this.lzE) {
        break label722;
      }
      this.KWT = 7;
      this.KWU = (this.KWT * 2);
      this.lzC = (aq.ay(this.mContext, 2131165202) + aq.ay(this.mContext, 2131166412));
      label362:
      if (this.wXu) {
        this.lzC += aq.ay(this.mContext, 2131166412);
      }
      this.KWF.setVisibility(0);
      if (this.kBS != null)
      {
        if ((!this.lzI) || (!aol())) {
          break label750;
        }
        this.kBS.setBackgroundColor(this.mContext.getResources().getColor(2131099649));
      }
      label437:
      this.KWG.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(192591);
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() - (paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY()) < 50)
          {
            e.c(e.this).setVisibility(8);
            AppMethodBeat.o(192591);
            return;
          }
          e.c(e.this).setVisibility(0);
          AppMethodBeat.o(192591);
        }
      });
      label452:
      if ((this.wXu) && (this.KWR != null) && (this.KWY)) {
        this.KWR.setVisibility(0);
      }
      if (this.KWW != 0) {
        break label1004;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.anl.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.KWQ.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.anl.setFocusable(false);
      this.anl.setItemViewCacheSize(20);
      this.KWK = new c();
      this.KWK.KXd = this.Ekt;
      this.KWK.arf = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if (paramAnonymousInt >= e.d(e.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159342);
            return;
          }
          paramAnonymousAdapterView = (m)e.d(e.this).JlY.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.lSG))
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
              e.this.bpT();
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
              e.fMi();
            }
          }
        }
      };
      this.anl.setAdapter(this.KWK);
      this.anl.setOverScrollMode(1);
      this.KWL = new c();
      this.KWL.KXd = this.KWA;
      this.KWL.arf = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(192592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if (paramAnonymousInt > e.k(e.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(192592);
            return;
          }
          paramAnonymousAdapterView = (m)e.k(e.this).JlY.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.lSG))
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(192592);
            return;
          }
          if ((paramAnonymousInt < e.k(e.this).size()) && (e.l(e.this) != null)) {
            e.l(e.this).onMMMenuItemSelected(e.k(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!e.h(e.this)) {
            e.this.bpT();
          }
          e.i(e.this);
          e.m(e.this).asY.notifyChanged();
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(192592);
        }
      };
      this.KWQ.setAdapter(this.KWL);
      this.KWQ.setOverScrollMode(1);
      if (this.lzA != null) {
        this.lzA.setContentView(this.kBS);
      }
      if (this.lzA != null) {
        this.lzA.setOnDismissListener(new DialogInterface.OnDismissListener()
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
      this.lzA = new i(paramContext);
      break;
      label722:
      this.lzC = (aq.ay(this.mContext, 2131165201) + aq.ay(this.mContext, 2131166412));
      break label362;
      label750:
      this.kBS.setBackgroundResource(2131234449);
      break label437;
      label763:
      if (this.KWW == 2)
      {
        this.KWN = true;
        i = aq.ay(this.mContext, 2131165927);
        if (this.lzE) {
          this.KWV = 2;
        }
        for (this.lzC = ((int)(i * 2.5D) + aq.ay(this.mContext, 2131165923));; this.lzC = ((int)(i * 3.5D) + aq.ay(this.mContext, 2131165923)))
        {
          if (!this.wXu) {
            break label877;
          }
          this.lzC += aq.fromDPToPix(this.mContext, 88);
          break;
          this.KWV = 3;
        }
        break label452;
      }
      label877:
      this.KWO = true;
      int i = aq.ay(this.mContext, 2131165930);
      if (this.lzE) {
        this.KWV = 4;
      }
      for (this.lzC = ((int)(i * 4.5D) + aq.ay(this.mContext, 2131165923));; this.lzC = ((int)(i * 6.5D) + aq.ay(this.mContext, 2131165923)))
      {
        if (this.wXu) {
          this.lzC += aq.ay(this.mContext, 2131166412);
        }
        if (this.KWF == null) {
          break;
        }
        this.KWF.setVisibility(0);
        break;
        this.KWV = 6;
      }
      label1004:
      this.anl.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  private boolean aol()
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
  private void eUs()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.lzA != null))
    {
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.lzA.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private void fMh()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
    this.Ekt.size();
    if ((!this.KWM) && (this.KWz.size() > 0)) {
      this.KWz.size();
    }
    Rect localRect;
    if ((this.lzE) && (this.qI != null))
    {
      localRect = new Rect();
      this.qI.getWindowVisibleDisplayFrame(localRect);
      if (!this.lzI) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.lzJ != 0) {
        localLayoutParams.width = this.lzJ;
      }
      if (!ar.jY(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - ar.jW(this.mContext));
    }
    for (;;)
    {
      this.kBS.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(159366);
      return;
      label157:
      localLayoutParams.height = localRect.bottom;
      continue;
      label168:
      localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
      if (this.lzJ != 0) {
        localLayoutParams.width = this.lzJ;
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
  
  public final void K(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159356);
    if (paramView == null)
    {
      AppMethodBeat.o(159356);
      return;
    }
    this.wXu = true;
    ImageView localImageView;
    if (this.KWR != null)
    {
      localImageView = this.KWR;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.KWD != null)
      {
        this.KWD.setVisibility(0);
        this.KWD.removeAllViews();
        this.KWD.setGravity(17);
        this.KWD.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void a(n.d paramd)
  {
    this.KJy = paramd;
  }
  
  public final void a(n.e parame)
  {
    this.KJz = parame;
  }
  
  public final void a(a parama)
  {
    this.KWx = parama;
  }
  
  public final void b(n.d paramd)
  {
    this.KWs = paramd;
  }
  
  public final void b(n.e parame)
  {
    this.KWv = parame;
  }
  
  public final void b(b paramb)
  {
    this.JXC = paramb;
  }
  
  public final void bpT()
  {
    AppMethodBeat.i(159364);
    if (this.lzA != null)
    {
      if (this.lzD != null) {
        this.lzD.nZ = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lzA.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void cMW()
  {
    int j = 0;
    AppMethodBeat.i(159362);
    this.JXD = false;
    this.lzE = aol();
    this.lzF = getRotation();
    if (this.KJy != null) {
      this.KJy.onCreateMMMenu(this.Ekt);
    }
    if (this.KWs != null) {
      this.KWs.onCreateMMMenu(this.KWA);
    }
    if (this.KWt != null) {
      this.KWt.onCreateMMMenu(this.KWB);
    }
    final int i;
    if (this.lzA != null)
    {
      fMh();
      if (!this.KWP) {
        break label928;
      }
      if (this.KWA.size() > 0)
      {
        this.KWS.setVisibility(0);
        this.KWQ.setVisibility(0);
        if (this.KWI != null) {
          this.KWI.setVisibility(8);
        }
      }
      Object localObject;
      if (this.KWB.size() > 0)
      {
        if (this.KWD != null)
        {
          this.KWD.setVisibility(0);
          this.KWD.removeAllViews();
          this.KWD.setGravity(17);
        }
        View localView = View.inflate(this.mContext, 2131496434, null);
        LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131308357);
        i = 0;
        while (i < this.KWB.size())
        {
          m localm = (m)this.KWB.JlY.get(i);
          if (localm.Jma)
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
            if (this.KWy != null) {
              this.KWy.a(localWeImageView, localm);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localm.Jmc);
              localTextView1.setText(localm.getTitle());
              if (localm.tBj != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localm.tBj);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(192593);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  if (e.r(e.this) != null) {
                    e.r(e.this).onMMMenuItemSelected(e.s(e.this).getItem(i), i);
                  }
                  if (!e.h(e.this)) {
                    e.this.bpT();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(192593);
                }
              });
              break;
              localWeImageView.setImageDrawable(localm.getIcon());
            }
          }
        }
        this.KWD.addView(localView);
      }
      int k = aq.ay(this.mContext, 2131166412);
      int m = aq.ay(this.mContext, 2131165289);
      i = k;
      if (this.wXu)
      {
        i = k;
        if (this.KWD.getVisibility() == 0) {
          i = aq.fromDPToPix(this.mContext, 0);
        }
      }
      this.anl.setPadding(0, i, this.anl.getPaddingRight(), this.anl.getPaddingBottom());
      if (!aol()) {
        break label891;
      }
      this.KWQ.setPadding(0, this.KWQ.getPaddingTop(), this.KWQ.getPaddingRight(), m);
      this.KWG.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.KWG.getChildAt(0) != null)
      {
        localObject = new Rect();
        this.qI.getWindowVisibleDisplayFrame((Rect)localObject);
        if (this.KWG.getChildAt(0).getMeasuredHeight() + aq.ay(this.mContext, 2131165299) <= ((Rect)localObject).bottom) {
          break label923;
        }
        i = 1;
        label622:
        if (i != 0) {
          this.KWH.setVisibility(0);
        }
      }
      label634:
      if ((this.KWz != null) && (this.KWK != null)) {
        this.KWK.asY.notifyChanged();
      }
      if (this.KWL != null) {
        this.KWL.asY.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.lzA.getWindow().addFlags(-2147483648);
      }
      if (this.sSh) {
        eUs();
      }
      if (this.lzG) {
        this.lzA.getWindow().addFlags(1024);
      }
      if (!this.lzH) {
        break label942;
      }
      this.lzA.getWindow().setFlags(8, 8);
      this.lzA.getWindow().addFlags(131200);
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.lzD != null) {
        this.lzD.nZ = false;
      }
      if (this.JXC != null) {
        this.lzA.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(192594);
            if (!e.t(e.this)) {
              e.this.JXC.onDismiss();
            }
            AppMethodBeat.o(192594);
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
        this.lzA.show();
      }
      AppMethodBeat.o(159362);
      return;
      label891:
      this.KWQ.setPadding(0, this.KWQ.getPaddingTop(), this.KWQ.getPaddingRight(), this.KWQ.getPaddingBottom());
      break;
      label923:
      i = 0;
      break label622;
      label928:
      this.anl.setPadding(0, 0, 0, 0);
      break label634;
      label942:
      this.lzA.getWindow().clearFlags(8);
      this.lzA.getWindow().clearFlags(131072);
      this.lzA.getWindow().clearFlags(128);
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void fMc()
  {
    AppMethodBeat.i(159359);
    if (this.KWF == null)
    {
      AppMethodBeat.o(159359);
      return;
    }
    this.KWF.setVisibility(8);
    AppMethodBeat.o(159359);
  }
  
  public final e fMd()
  {
    AppMethodBeat.i(192598);
    this.KXb = true;
    if (this.kBS != null)
    {
      if (!this.KXb) {
        break label93;
      }
      this.kBS.setBackgroundResource(2131234972);
      this.KWI.setBackgroundColor(this.mContext.getResources().getColor(2131099727));
      this.KWJ.setTextColor(this.mContext.getResources().getColor(2131099673));
      this.KWJ.setBackgroundResource(2131234852);
    }
    for (;;)
    {
      AppMethodBeat.o(192598);
      return this;
      label93:
      this.kBS.setBackgroundResource(2131234848);
    }
  }
  
  public final void fMe()
  {
    this.xpt = true;
  }
  
  public final void fMf()
  {
    this.lzH = true;
  }
  
  public final void fMg()
  {
    AppMethodBeat.i(159363);
    if (this.lzA != null)
    {
      if ((this.KWz != null) && (this.KWK != null)) {
        this.KWK.asY.notifyChanged();
      }
      if (this.KWL != null) {
        this.KWL.asY.notifyChanged();
      }
      this.lzA.show();
    }
    AppMethodBeat.o(159363);
  }
  
  public final void ha(View paramView)
  {
    AppMethodBeat.i(221678);
    K(paramView, false);
    AppMethodBeat.o(221678);
  }
  
  public final void i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192597);
    if ((this.KWD != null) && (this.wXu))
    {
      this.KWD.setVisibility(0);
      this.KWD.removeAllViews();
      this.KWD.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setTextSize(0, paramInt2);
      localTextView.setGravity(paramInt1 | 0x50);
      this.KWD.addView(localView, -1, -2);
    }
    AppMethodBeat.o(192597);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.lzA != null) && (this.lzA.isShowing()))
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
        bpT();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.lzE != aol()) || (this.lzF != getRotation()))) {
        bpT();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void p(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159357);
    if ((this.KWD != null) && (this.wXu))
    {
      this.KWD.setVisibility(0);
      this.KWD.removeAllViews();
      this.KWD.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      this.KWD.addView(localView, -1, -2);
    }
    AppMethodBeat.o(159357);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.kBS != null) {
      this.kBS.setBackgroundColor(paramInt);
    }
    this.KWC = Boolean.valueOf(ao.abX(paramInt));
    if ((this.KWC.booleanValue()) && (this.KWR != null)) {
      this.KWR.setImageDrawable(this.mContext.getResources().getDrawable(2131100200));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.KWE != null)
    {
      if (paramView == null)
      {
        this.KWE.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.KWE.setVisibility(0);
      this.KWE.removeAllViews();
      this.KWE.setGravity(17);
      this.KWE.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
  }
  
  public final e yT(boolean paramBoolean)
  {
    this.KXa = paramBoolean;
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
    l KXd;
    AdapterView.OnItemClickListener arf;
    
    public c() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      if (e.F(e.this))
      {
        i = this.KXd.size();
        j = e.f(e.this).size();
        AppMethodBeat.o(159348);
        return i + j + 1;
      }
      int i = this.KXd.size();
      int j = e.f(e.this).size();
      AppMethodBeat.o(159348);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.w
      implements View.OnClickListener
    {
      ImageView KXe;
      RadioButton KXf;
      LinearLayout KXg;
      View KXh;
      ImageView KcO;
      TextView gnM;
      View goo;
      TextView iDG;
      WeImageView sQB;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(159346);
        paramView.setOnClickListener(this);
        this.gnM = ((TextView)paramView.findViewById(2131305902));
        this.sQB = ((WeImageView)paramView.findViewById(2131300874));
        this.KXg = ((LinearLayout)paramView.findViewById(2131304239));
        this.KXh = paramView.findViewById(2131302798);
        this.goo = paramView.findViewById(2131303917);
        if (e.D(e.this)) {
          this.KXe = ((ImageView)paramView.findViewById(2131300884));
        }
        if (e.x(e.this)) {
          this.KXf = ((RadioButton)paramView.findViewById(2131303704));
        }
        if ((e.x(e.this)) || (e.E(e.this)))
        {
          this.iDG = ((TextView)paramView.findViewById(2131298996));
          this.KcO = ((ImageView)paramView.findViewById(2131299154));
        }
        AppMethodBeat.o(159346);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(159347);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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