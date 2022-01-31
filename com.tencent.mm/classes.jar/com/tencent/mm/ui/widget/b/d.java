package com.tencent.mm.ui.widget.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.support.v7.widget.GridLayoutManager;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public d.a AGQ;
  private Dialog AGR;
  private n.d AGS;
  private l AGT;
  public Boolean AGU;
  private LinearLayout AGV;
  private LinearLayout AGW;
  private b AGX;
  private boolean AGY;
  private boolean AGZ;
  private boolean AHa;
  private int AHb;
  public ImageView AHc;
  private int AHd;
  private int AHe;
  private int AHf;
  private int AHg;
  private boolean AHh;
  public boolean AHi;
  private boolean AHj;
  private boolean AHk;
  private int AHl;
  private int AHm;
  public n.a AvY;
  public n.b AvZ;
  private ViewTreeObserver VF;
  private RecyclerView adt;
  private BottomSheetBehavior gE;
  public View iDS;
  private View iU;
  public Context mContext;
  private boolean pFk;
  public boolean pXc;
  public n.c sao;
  public n.d sap;
  private l saq;
  public int udx;
  private boolean vnS;
  private boolean vnT;
  public boolean vnU;
  public boolean vnV;
  private int zRb;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(112657);
    this.AGU = Boolean.FALSE;
    this.AGY = false;
    this.AGZ = false;
    this.AHa = false;
    this.vnS = false;
    this.AHd = 4;
    this.AHe = (this.AHd * 3);
    this.AHf = 6;
    this.pXc = false;
    this.AHh = false;
    this.vnV = false;
    this.AHi = false;
    this.AHj = false;
    this.udx = 0;
    this.AHk = false;
    this.AHl = 0;
    this.AHm = 0;
    this.AHg = 1;
    this.mContext = paramContext;
    this.AHk = true;
    if ((this.mContext instanceof Activity)) {
      this.iU = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aA(this.mContext);
    AppMethodBeat.o(112657);
  }
  
  public d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112656);
    this.AGU = Boolean.FALSE;
    this.AGY = false;
    this.AGZ = false;
    this.AHa = false;
    this.vnS = false;
    this.AHd = 4;
    this.AHe = (this.AHd * 3);
    this.AHf = 6;
    this.pXc = false;
    this.AHh = false;
    this.vnV = false;
    this.AHi = false;
    this.AHj = false;
    this.udx = 0;
    this.AHk = false;
    this.AHl = 0;
    this.AHm = 0;
    this.AHg = paramInt;
    this.mContext = paramContext;
    this.pFk = paramBoolean;
    this.AHj = false;
    if ((this.mContext instanceof Activity)) {
      this.iU = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    aA(this.mContext);
    AppMethodBeat.o(112656);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(112660);
    this.saq = new l(paramContext);
    this.AGT = new l(paramContext);
    label192:
    label217:
    int i;
    if (this.AHk)
    {
      this.AGR = new b(paramContext);
      this.iDS = View.inflate(paramContext, 2130970148, null);
      this.AGV = ((LinearLayout)this.iDS.findViewById(2131826158));
      this.AGW = ((LinearLayout)this.iDS.findViewById(2131826161));
      this.AHc = ((ImageView)this.iDS.findViewById(2131826159));
      this.adt = ((RecyclerView)this.iDS.findViewById(2131826160));
      this.adt.setHasFixedSize(true);
      this.vnS = isLandscape();
      if (this.AHg != 0) {
        break label488;
      }
      if (!this.vnS) {
        break label461;
      }
      this.AHd = 7;
      this.AHe = (this.AHd * 2);
      this.zRb = (al.ap(this.mContext, 2131427509) + al.ap(this.mContext, 2131428450));
      if (this.pFk) {
        this.zRb += al.ap(this.mContext, 2131428450);
      }
      if ((this.pFk) && (this.AHc != null) && (this.AHj)) {
        this.AHc.setVisibility(0);
      }
      if (this.AHg != 0) {
        break label741;
      }
      this.adt.setLayoutManager(new GridLayoutManager(this.AHd));
      int j = al.ap(this.mContext, 2131428449);
      i = al.ap(this.mContext, 2131428450);
      if (this.pFk) {
        i = al.fromDPToPix(this.mContext, 0);
      }
      this.adt.setPadding(j, i, j, 0);
    }
    for (;;)
    {
      this.AGX = new b();
      this.AGX.ahl = new d.1(this);
      this.adt.setAdapter(this.AGX);
      this.adt.setOverScrollMode(1);
      this.AGR.setContentView(this.iDS);
      if (!this.AHk)
      {
        this.gE = BottomSheetBehavior.i((View)this.iDS.getParent());
        this.gE.t(this.zRb);
        this.gE.gw = new d.2(this);
      }
      this.AGR.setOnDismissListener(new d.3(this));
      AppMethodBeat.o(112660);
      return;
      this.AGR = new c(paramContext);
      break;
      label461:
      this.zRb = (al.ap(this.mContext, 2131427508) + al.ap(this.mContext, 2131428450));
      break label192;
      label488:
      if (this.AHg == 2)
      {
        this.AGZ = true;
        i = al.ap(this.mContext, 2131428137);
        if (this.vnS) {
          this.AHf = 2;
        }
        for (this.zRb = ((int)(i * 2.5D) + al.ap(this.mContext, 2131428133));; this.zRb = ((int)(i * 3.5D) + al.ap(this.mContext, 2131428133)))
        {
          if (!this.pFk) {
            break label602;
          }
          this.zRb += al.fromDPToPix(this.mContext, 88);
          break;
          this.AHf = 3;
        }
        break label217;
      }
      label602:
      this.AHa = true;
      i = al.ap(this.mContext, 2131428140);
      if (this.vnS) {
        this.AHf = 4;
      }
      for (this.zRb = ((int)(i * 4.5D) + al.ap(this.mContext, 2131428133));; this.zRb = ((int)(i * 6.5D) + al.ap(this.mContext, 2131428133)))
      {
        if (this.pFk) {
          this.zRb += al.ap(this.mContext, 2131428450);
        }
        if (!this.AHk) {
          break;
        }
        i = al.fromDPToPix(this.mContext, 24);
        this.AHc.setPadding(i, 0, i, 0);
        break;
        this.AHf = 6;
      }
      label741:
      this.adt.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  private void dPb()
  {
    AppMethodBeat.i(112668);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.iDS.getLayoutParams();
    int j = this.saq.size();
    int i;
    int k;
    label109:
    Rect localRect;
    if (this.AGY)
    {
      i = j + 1;
      if (this.AHk)
      {
        k = al.ap(this.mContext, 2131428140);
        if (!this.pFk) {
          break label330;
        }
        j = al.ap(this.mContext, 2131428143);
        if (this.AHl != 0) {
          j = this.AHl;
        }
        this.zRb = (j + (int)(k * 4.5D) + al.ap(this.mContext, 2131428133));
      }
      if (this.AHg != 0) {
        break label427;
      }
      if (this.AGX.getItemCount() <= this.AHe) {
        break label344;
      }
      localLayoutParams.height = this.zRb;
      label139:
      label274:
      if ((this.vnS) && (this.iU != null))
      {
        localRect = new Rect();
        this.iU.getWindowVisibleDisplayFrame(localRect);
        if (!this.AHk) {
          break label504;
        }
        localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
        if (this.AHm != 0) {
          localLayoutParams.width = this.AHm;
        }
        if (!am.ia(this.mContext)) {
          break label447;
        }
        localLayoutParams.height = (localRect.bottom - am.hY(this.mContext));
        label238:
        if (this.pFk)
        {
          k = al.ap(this.mContext, 2131428140);
          if (i > this.AHf) {
            break label460;
          }
          i = localLayoutParams.height - i * k;
          if (this.AGV != null) {
            this.AGV.setMinimumHeight(i);
          }
        }
      }
    }
    for (;;)
    {
      this.iDS.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(112668);
      return;
      i = j;
      if (this.AGT.size() <= 0) {
        break;
      }
      i = j + this.AGT.size();
      break;
      label330:
      this.zRb = ((int)(k * 6.5D));
      break label109;
      label344:
      localLayoutParams.height = ((al.ap(this.mContext, 2131428135) + al.ap(this.mContext, 2131428450)) * (int)Math.ceil(this.AGX.getItemCount() / this.AHd) + am.fx(this.mContext));
      if (!this.pFk) {
        break label139;
      }
      localLayoutParams.height += al.ap(this.mContext, 2131428450);
      break label139;
      label427:
      if (i <= this.AHf) {
        break label139;
      }
      localLayoutParams.height = this.zRb;
      break label139;
      label447:
      localLayoutParams.height = localRect.bottom;
      break label238;
      label460:
      j = localLayoutParams.height - (int)(k * (this.AHf + 0.5D));
      i = j;
      if (j <= al.fromDPToPix(this.mContext, 150)) {
        break label274;
      }
      i = j - k;
      break label274;
      label504:
      localLayoutParams.width = localRect.right;
    }
  }
  
  @TargetApi(23)
  private void dgf()
  {
    AppMethodBeat.i(112663);
    if ((Build.VERSION.SDK_INT >= 23) && (this.AGR != null))
    {
      this.AGR.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.AGR.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(112663);
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    AppMethodBeat.i(112659);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(112659);
    return i;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(112669);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(112669);
      return true;
    }
    AppMethodBeat.o(112669);
    return false;
  }
  
  public final void G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112661);
    if (paramView == null)
    {
      AppMethodBeat.o(112661);
      return;
    }
    this.pFk = true;
    ImageView localImageView;
    if (this.AHc != null)
    {
      localImageView = this.AHc;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.AGV != null)
      {
        this.AGV.setVisibility(0);
        this.AGV.removeAllViews();
        this.AGV.setGravity(17);
        this.AGV.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(112661);
      return;
    }
  }
  
  public final void a(n.c paramc)
  {
    this.sao = paramc;
  }
  
  public final void a(n.d paramd)
  {
    this.sap = paramd;
  }
  
  public final void a(d.a parama)
  {
    this.AGQ = parama;
  }
  
  public final void crd()
  {
    int i = 0;
    AppMethodBeat.i(112664);
    this.vnS = isLandscape();
    this.AHb = getRotation();
    if (this.sao != null) {
      this.sao.onCreateMMMenu(this.saq);
    }
    if (this.AGR != null)
    {
      dPb();
      if ((this.AGT != null) && (this.AGX != null)) {
        this.AGX.ajb.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.AGR.getWindow().addFlags(-2147483648);
      }
      if (this.vnT) {
        dgf();
      }
      if (this.vnU) {
        this.AGR.getWindow().addFlags(1024);
      }
      if (!this.vnV) {
        break label293;
      }
      this.AGR.getWindow().setFlags(8, 8);
      this.AGR.getWindow().addFlags(131200);
      this.AGR.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.gE != null) {
        this.gE.go = false;
      }
      if (this.AGQ != null) {
        this.AGR.setOnDismissListener(new d.4(this));
      }
      if (this.iU != null)
      {
        if (this.VF == null) {
          i = 1;
        }
        this.VF = this.iU.getViewTreeObserver();
        if (i != 0) {
          this.VF.addOnGlobalLayoutListener(this);
        }
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.AGR.show();
      }
      AppMethodBeat.o(112664);
      return;
      label293:
      this.AGR.getWindow().clearFlags(8);
      this.AGR.getWindow().clearFlags(131072);
      this.AGR.getWindow().clearFlags(128);
      this.AGR.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void cre()
  {
    AppMethodBeat.i(112666);
    if (this.AGR != null)
    {
      if (this.gE != null) {
        this.gE.go = true;
      }
      if ((this.mContext != null) && (!((Activity)this.mContext).isFinishing())) {
        this.AGR.dismiss();
      }
    }
    AppMethodBeat.o(112666);
  }
  
  public final void dPa()
  {
    AppMethodBeat.i(112665);
    if (this.AGR != null)
    {
      if ((this.AGT != null) && (this.AGX != null)) {
        this.AGX.ajb.notifyChanged();
      }
      this.AGR.show();
    }
    AppMethodBeat.o(112665);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(112667);
    if ((this.AGR != null) && (this.AGR.isShowing()))
    {
      AppMethodBeat.o(112667);
      return true;
    }
    AppMethodBeat.o(112667);
    return false;
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(112658);
    if (isShowing())
    {
      View localView = this.iU;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cre();
        AppMethodBeat.o(112658);
        return;
      }
      if ((isShowing()) && ((this.vnS != isLandscape()) || (this.AHb != getRotation()))) {
        cre();
      }
    }
    AppMethodBeat.o(112658);
  }
  
  public final void r(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(112662);
    if ((this.AGV != null) && (this.pFk))
    {
      this.AGV.setVisibility(0);
      this.AGV.removeAllViews();
      this.AGV.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2130970152, null);
      TextView localTextView = (TextView)localView.findViewById(2131823007);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      this.AGV.addView(localView, -1, -2);
    }
    AppMethodBeat.o(112662);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(139658);
    if (this.AGW != null)
    {
      if (paramView == null)
      {
        this.AGW.setVisibility(8);
        AppMethodBeat.o(139658);
        return;
      }
      this.AGW.setVisibility(0);
      this.AGW.removeAllViews();
      this.AGW.setGravity(17);
      this.AGW.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(139658);
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    AdapterView.OnItemClickListener ahl;
    
    public b() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(112653);
      if (d.y(d.this))
      {
        i = d.b(d.this).size();
        j = d.d(d.this).size();
        AppMethodBeat.o(112653);
        return i + j + 1;
      }
      int i = d.b(d.this).size();
      int j = d.d(d.this).size();
      AppMethodBeat.o(112653);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      RadioButton AHo;
      ImageView AHp;
      LinearLayout AHq;
      TextView gui;
      ImageView iTH;
      TextView ruR;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(112651);
        paramView.setOnClickListener(this);
        this.gui = ((TextView)paramView.findViewById(2131820680));
        this.iTH = ((ImageView)paramView.findViewById(2131820929));
        this.AHq = ((LinearLayout)paramView.findViewById(2131821003));
        if ((d.x(d.this)) || (d.z(d.this)))
        {
          this.ruR = ((TextView)paramView.findViewById(2131821115));
          this.AHo = ((RadioButton)paramView.findViewById(2131820951));
          this.AHp = ((ImageView)paramView.findViewById(2131821148));
        }
        AppMethodBeat.o(112651);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112652);
        if (d.b.this.ahl != null) {
          d.b.this.ahl.onItemClick(null, paramView, getPosition(), getPosition());
        }
        AppMethodBeat.o(112652);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.d
 * JD-Core Version:    0.7.0.1
 */