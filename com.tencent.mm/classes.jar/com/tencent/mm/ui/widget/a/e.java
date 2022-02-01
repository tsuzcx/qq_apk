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
import android.support.v7.widget.RecyclerView.v;
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
  private l BoA;
  public b GHn;
  private boolean GHo;
  public n.c HEP;
  private n.d HEQ;
  public n.d HER;
  public a HES;
  private l HET;
  private l HEU;
  private Boolean HEV;
  private LinearLayout HEW;
  private LinearLayout HEX;
  private LinearLayout HEY;
  private c HEZ;
  private c HFa;
  private boolean HFb;
  private boolean HFc;
  private boolean HFd;
  private boolean HFe;
  private RecyclerView HFf;
  private ImageView HFg;
  private ImageView HFh;
  private int HFi;
  private int HFj;
  private int HFk;
  private int HFl;
  public boolean HFm;
  public boolean HFn;
  private int HFo;
  public boolean HFp;
  public n.c HrX;
  public n.d HrY;
  public n.a Hsb;
  public n.b Hsc;
  private ViewTreeObserver acK;
  private RecyclerView akA;
  public int hRK;
  private View jGG;
  private Dialog kBi;
  private int kBk;
  private BottomSheetBehavior kBl;
  private boolean kBm;
  private int kBn;
  public boolean kBo;
  public boolean kBp;
  private boolean kBq;
  private int kBr;
  private Context mContext;
  private View nO;
  private boolean qVs;
  public boolean qVt;
  private boolean uHt;
  public boolean uYV;
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.HEV = Boolean.FALSE;
    this.HFb = false;
    this.HFc = false;
    this.HFd = false;
    this.HFe = false;
    this.kBm = false;
    this.HFi = 4;
    this.HFj = (this.HFi * 3);
    this.HFk = 6;
    this.uYV = false;
    this.qVt = false;
    this.GHo = false;
    this.kBp = false;
    this.HFm = false;
    this.HFn = false;
    this.hRK = 0;
    this.kBq = false;
    this.HFo = 0;
    this.kBr = 0;
    this.HFp = false;
    this.HFl = paramInt;
    this.mContext = paramContext;
    this.uHt = paramBoolean;
    this.HFn = false;
    if ((this.mContext instanceof Activity)) {
      this.nO = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aL(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public e(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(195209);
    this.HEV = Boolean.FALSE;
    this.HFb = false;
    this.HFc = false;
    this.HFd = false;
    this.HFe = false;
    this.kBm = false;
    this.HFi = 4;
    this.HFj = (this.HFi * 3);
    this.HFk = 6;
    this.uYV = false;
    this.qVt = false;
    this.GHo = false;
    this.kBp = false;
    this.HFm = false;
    this.HFn = false;
    this.hRK = 0;
    this.kBq = false;
    this.HFo = 0;
    this.kBr = 0;
    this.HFp = false;
    this.HFl = paramInt;
    this.mContext = paramContext;
    this.kBq = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.nO = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aL(this.mContext);
    AppMethodBeat.o(195209);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.BoA = new l(paramContext);
    this.HET = new l(paramContext);
    this.HEU = new l(paramContext);
    if (this.kBq)
    {
      this.kBi = new b(paramContext);
      this.jGG = View.inflate(paramContext, 2131494771, null);
      this.HEW = ((LinearLayout)this.jGG.findViewById(2131297466));
      this.HEX = ((LinearLayout)this.jGG.findViewById(2131297462));
      this.HEY = ((LinearLayout)this.jGG.findViewById(2131297459));
      this.HFg = ((ImageView)this.jGG.findViewById(2131299071));
      this.HFh = ((ImageView)this.jGG.findViewById(2131302242));
      this.HEY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159340);
          e.this.bfo();
          if (e.b(e.this) != null) {
            e.b(e.this).onClick();
          }
          AppMethodBeat.o(159340);
        }
      });
      this.akA = ((RecyclerView)this.jGG.findViewById(2131297464));
      this.akA.setHasFixedSize(true);
      this.HFf = ((RecyclerView)this.jGG.findViewById(2131297465));
      this.HFf.setHasFixedSize(true);
      this.kBm = aov();
      if (this.HFl != 0) {
        break label720;
      }
      this.HFe = true;
      if (!this.kBm) {
        break label679;
      }
      this.HFi = 7;
      this.HFj = (this.HFi * 2);
      this.kBk = (ao.ap(this.mContext, 2131165202) + ao.ap(this.mContext, 2131166412));
      label284:
      if (this.uHt) {
        this.kBk += ao.ap(this.mContext, 2131166412);
      }
      this.HEY.setVisibility(0);
      if (this.jGG != null)
      {
        if ((!this.kBq) || (!aov())) {
          break label707;
        }
        this.jGG.setBackgroundColor(this.mContext.getResources().getColor(2131099649));
      }
      label359:
      if ((this.uHt) && (this.HFg != null) && (this.HFn)) {
        this.HFg.setVisibility(0);
      }
      if (this.HFl != 0) {
        break label961;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.akA.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.HFf.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.akA.setFocusable(false);
      this.akA.setItemViewCacheSize(20);
      this.HEZ = new c();
      this.HEZ.HFr = this.BoA;
      this.HEZ.aos = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159341);
          if (paramAnonymousInt >= e.c(e.this).size())
          {
            AppMethodBeat.o(159341);
            return;
          }
          paramAnonymousAdapterView = (m)e.c(e.this).FYt.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.kRX))
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
              e.this.bfo();
            }
            e.h(e.this);
            e.a(e.this, paramAnonymousInt);
            e.i(e.this).aql.notifyChanged();
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
              e.ffy();
            }
          }
        }
      };
      this.akA.setAdapter(this.HEZ);
      this.akA.setOverScrollMode(1);
      this.HFa = new c();
      this.HFa.HFr = this.HEU;
      this.HFa.aos = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159342);
          if (paramAnonymousInt > e.j(e.this).size())
          {
            AppMethodBeat.o(159342);
            return;
          }
          paramAnonymousAdapterView = (m)e.j(e.this).FYt.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.kRX))
          {
            AppMethodBeat.o(159342);
            return;
          }
          if ((paramAnonymousInt < e.j(e.this).size()) && (e.k(e.this) != null)) {
            e.k(e.this).onMMMenuItemSelected(e.j(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!e.g(e.this)) {
            e.this.bfo();
          }
          e.h(e.this);
          e.l(e.this).aql.notifyChanged();
          AppMethodBeat.o(159342);
        }
      };
      this.HFf.setAdapter(this.HFa);
      this.HFf.setOverScrollMode(1);
      if (this.kBi != null) {
        this.kBi.setContentView(this.jGG);
      }
      if (!this.kBq)
      {
        this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
        this.kBl.setState(3);
        this.kBl.lq = new BottomSheetBehavior.a()
        {
          public final void N(int paramAnonymousInt) {}
          
          public final void h(float paramAnonymousFloat)
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
      if (this.kBi != null) {
        this.kBi.setOnDismissListener(new DialogInterface.OnDismissListener()
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
      this.kBi = new a(paramContext, 2131820788);
      break;
      label679:
      this.kBk = (ao.ap(this.mContext, 2131165201) + ao.ap(this.mContext, 2131166412));
      break label284;
      label707:
      this.jGG.setBackgroundResource(2131234449);
      break label359;
      label720:
      if (this.HFl == 2)
      {
        this.HFc = true;
        i = ao.ap(this.mContext, 2131165927);
        if (this.kBm) {
          this.HFk = 2;
        }
        for (this.kBk = ((int)(i * 2.5D) + ao.ap(this.mContext, 2131165923));; this.kBk = ((int)(i * 3.5D) + ao.ap(this.mContext, 2131165923)))
        {
          if (!this.uHt) {
            break label834;
          }
          this.kBk += ao.fromDPToPix(this.mContext, 88);
          break;
          this.HFk = 3;
        }
        break label359;
      }
      label834:
      this.HFd = true;
      int i = ao.ap(this.mContext, 2131165930);
      if (this.kBm) {
        this.HFk = 4;
      }
      for (this.kBk = ((int)(i * 4.5D) + ao.ap(this.mContext, 2131165923));; this.kBk = ((int)(i * 6.5D) + ao.ap(this.mContext, 2131165923)))
      {
        if (this.uHt) {
          this.kBk += ao.ap(this.mContext, 2131166412);
        }
        if (this.HEY == null) {
          break;
        }
        this.HEY.setVisibility(0);
        break;
        this.HFk = 6;
      }
      label961:
      this.akA.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  private boolean aov()
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
  private void eqc()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.kBi != null))
    {
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.kBi.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private void ffx()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jGG.getLayoutParams();
    this.BoA.size();
    if ((!this.HFb) && (this.HET.size() > 0)) {
      this.HET.size();
    }
    Rect localRect;
    if ((this.kBm) && (this.nO != null))
    {
      localRect = new Rect();
      this.nO.getWindowVisibleDisplayFrame(localRect);
      if (!this.kBq) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.kBr != 0) {
        localLayoutParams.width = this.kBr;
      }
      if (!ap.jC(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - ap.jA(this.mContext));
    }
    for (;;)
    {
      this.jGG.setLayoutParams(localLayoutParams);
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
    this.uHt = true;
    ImageView localImageView;
    if (this.HFg != null)
    {
      localImageView = this.HFg;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.HEW != null)
      {
        this.HEW.setVisibility(0);
        this.HEW.removeAllViews();
        this.HEW.setGravity(17);
        this.HEW.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void a(n.c paramc)
  {
    this.HrX = paramc;
  }
  
  public final void a(n.d paramd)
  {
    this.HrY = paramd;
  }
  
  public final void a(a parama)
  {
    this.HES = parama;
  }
  
  public final void b(n.c paramc)
  {
    this.HEP = paramc;
  }
  
  public final void b(n.d paramd)
  {
    this.HER = paramd;
  }
  
  public final void b(b paramb)
  {
    this.GHn = paramb;
  }
  
  public final void bfo()
  {
    AppMethodBeat.i(159364);
    if (this.kBi != null)
    {
      if (this.kBl != null) {
        this.kBl.lh = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.kBi.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void csG()
  {
    AppMethodBeat.i(159362);
    this.GHo = false;
    this.kBm = aov();
    this.kBn = getRotation();
    if (this.HrX != null) {
      this.HrX.onCreateMMMenu(this.BoA);
    }
    if (this.HEP != null) {
      this.HEP.onCreateMMMenu(this.HEU);
    }
    if (this.kBi != null)
    {
      ffx();
      if (!this.HFe) {
        break label503;
      }
      if (this.HEU.size() > 0)
      {
        this.HFh.setVisibility(0);
        this.HFf.setVisibility(0);
      }
      int j = ao.ap(this.mContext, 2131166412);
      int k = ao.ap(this.mContext, 2131165289);
      i = j;
      if (this.uHt)
      {
        i = j;
        if (this.HEW.getVisibility() == 0) {
          i = ao.fromDPToPix(this.mContext, 0);
        }
      }
      this.akA.setPadding(0, i, this.akA.getPaddingRight(), this.akA.getPaddingBottom());
      if (!aov()) {
        break label471;
      }
      this.HFf.setPadding(0, this.HFf.getPaddingTop(), this.HFf.getPaddingRight(), k);
      if ((this.HET != null) && (this.HEZ != null)) {
        this.HEZ.aql.notifyChanged();
      }
      if (this.HFa != null) {
        this.HFa.aql.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.kBi.getWindow().addFlags(-2147483648);
      }
      if (this.qVs) {
        eqc();
      }
      if (this.kBo) {
        this.kBi.getWindow().addFlags(1024);
      }
      if (!this.kBp) {
        break label517;
      }
      this.kBi.getWindow().setFlags(8, 8);
      this.kBi.getWindow().addFlags(131200);
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(6);
      label358:
      if (this.kBl != null) {
        this.kBl.lh = false;
      }
      if (this.GHn != null) {
        this.kBi.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159345);
            if (!e.u(e.this)) {
              e.this.GHn.onDismiss();
            }
            AppMethodBeat.o(159345);
          }
        });
      }
      if (this.nO != null) {
        if (this.acK != null) {
          break label572;
        }
      }
    }
    label517:
    label572:
    for (int i = 1;; i = 0)
    {
      this.acK = this.nO.getViewTreeObserver();
      if (i != 0) {
        this.acK.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.kBi.show();
      }
      AppMethodBeat.o(159362);
      return;
      label471:
      this.HFf.setPadding(0, this.HFf.getPaddingTop(), this.HFf.getPaddingRight(), this.HFf.getPaddingBottom());
      break;
      label503:
      this.akA.setPadding(0, 0, 0, 0);
      break;
      this.kBi.getWindow().clearFlags(8);
      this.kBi.getWindow().clearFlags(131072);
      this.kBi.getWindow().clearFlags(128);
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(0);
      break label358;
    }
  }
  
  public final void ffu()
  {
    AppMethodBeat.i(159359);
    if (this.HEY == null)
    {
      AppMethodBeat.o(159359);
      return;
    }
    this.HEY.setVisibility(8);
    AppMethodBeat.o(159359);
  }
  
  public final void ffv()
  {
    this.kBp = true;
  }
  
  public final void ffw()
  {
    AppMethodBeat.i(159363);
    if (this.kBi != null)
    {
      if ((this.HET != null) && (this.HEZ != null)) {
        this.HEZ.aql.notifyChanged();
      }
      if (this.HFa != null) {
        this.HFa.aql.notifyChanged();
      }
      this.kBi.show();
    }
    AppMethodBeat.o(159363);
  }
  
  public final void gU(View paramView)
  {
    AppMethodBeat.i(202395);
    J(paramView, false);
    AppMethodBeat.o(202395);
  }
  
  public final void gam()
  {
    this.uYV = true;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.kBi != null) && (this.kBi.isShowing()))
    {
      AppMethodBeat.o(159365);
      return true;
    }
    AppMethodBeat.o(159365);
    return false;
  }
  
  public final void l(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195210);
    if ((this.HEW != null) && (this.uHt))
    {
      this.HEW.setVisibility(0);
      this.HEW.removeAllViews();
      this.HEW.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setTextSize(0, paramInt2);
      localTextView.setGravity(paramInt1 | 0x50);
      this.HEW.addView(localView, -1, -2);
    }
    AppMethodBeat.o(195210);
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(159353);
    if (isShowing())
    {
      View localView = this.nO;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bfo();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.kBm != aov()) || (this.kBn != getRotation()))) {
        bfo();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void q(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159357);
    if ((this.HEW != null) && (this.uHt))
    {
      this.HEW.setVisibility(0);
      this.HEW.removeAllViews();
      this.HEW.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2131494775, null);
      TextView localTextView = (TextView)localView.findViewById(2131305945);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      this.HEW.addView(localView, -1, -2);
    }
    AppMethodBeat.o(159357);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.jGG != null) {
      this.jGG.setBackgroundColor(paramInt);
    }
    this.HEV = Boolean.valueOf(am.XC(paramInt));
    if ((this.HEV.booleanValue()) && (this.HFg != null)) {
      this.HFg.setImageDrawable(this.mContext.getResources().getDrawable(2131100200));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.HEX != null)
    {
      if (paramView == null)
      {
        this.HEX.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.HEX.setVisibility(0);
      this.HEX.removeAllViews();
      this.HEX.setGravity(17);
      this.HEX.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
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
    l HFr;
    AdapterView.OnItemClickListener aos;
    
    public c() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      if (e.E(e.this))
      {
        i = this.HFr.size();
        j = e.e(e.this).size();
        AppMethodBeat.o(159348);
        return i + j + 1;
      }
      int i = this.HFr.size();
      int j = e.e(e.this).size();
      AppMethodBeat.o(159348);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      ImageView GMt;
      WeImageView HFs;
      ImageView HFt;
      RadioButton HFu;
      LinearLayout HFv;
      View HFw;
      View fQR;
      TextView fQp;
      TextView hJR;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(159346);
        paramView.setOnClickListener(this);
        this.fQp = ((TextView)paramView.findViewById(2131305902));
        this.HFs = ((WeImageView)paramView.findViewById(2131300874));
        this.HFv = ((LinearLayout)paramView.findViewById(2131304239));
        this.HFw = paramView.findViewById(2131302798);
        this.fQR = paramView.findViewById(2131303917);
        if (e.D(e.this)) {
          this.HFt = ((ImageView)paramView.findViewById(2131300884));
        }
        if (e.y(e.this)) {
          this.HFu = ((RadioButton)paramView.findViewById(2131303704));
        }
        if ((e.y(e.this)) || (e.F(e.this)))
        {
          this.hJR = ((TextView)paramView.findViewById(2131298996));
          this.GMt = ((ImageView)paramView.findViewById(2131299154));
        }
        AppMethodBeat.o(159346);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(159347);
        if (e.c.this.aos != null) {
          e.c.this.aos.onItemClick(null, paramView, getPosition(), getPosition());
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