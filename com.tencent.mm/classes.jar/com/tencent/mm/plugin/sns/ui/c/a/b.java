package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private Context context;
  private com.tencent.mm.ui.widget.c.a jVd;
  com.tencent.mm.plugin.sns.a.b.g rOU;
  public TextView sfH;
  public TextView sfI;
  public View sfJ;
  public Button sfK;
  public Button sfL;
  public View sfM;
  public MaskImageView sfN;
  public SnsCardAdTagListView sfO;
  public View sfP;
  public View sfQ;
  public View sfR;
  
  public b(TimeLineObject paramTimeLineObject, n paramn, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.g paramg)
  {
    this.timeLineObject = paramTimeLineObject;
    this.rMD = paramn;
    this.rOV = paramb;
    this.rOU = paramg;
  }
  
  private void F(n paramn)
  {
    int j = 0;
    AppMethodBeat.i(40093);
    if ((paramn == null) || (!paramn.cqp()))
    {
      AppMethodBeat.o(40093);
      return;
    }
    int k = Color.parseColor("#cdcdcd");
    int m = Color.parseColor("#ffffff");
    if ((this.sfK == null) || (this.sfL == null))
    {
      AppMethodBeat.o(40093);
      return;
    }
    this.sfK.setOnClickListener(this.rOV.sjV);
    this.sfL.setOnClickListener(this.rOV.sjW);
    int n;
    int i;
    if (paramn.csb().cqs())
    {
      n = v.gG(paramn.csb().rqS.rrk, paramn.csP());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.sfL.setBackgroundColor(m);
          this.sfL.setTextColor(k);
          this.sfL.setText(paramn.csb().rqS.Eb(1));
          this.sfK.setBackgroundResource(2130840379);
          this.sfK.setTextColor(-16777216);
          this.sfK.setText(paramn.csb().rqS.Ea(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.sfK.setTextColor(-16777216);
        this.sfK.setBackgroundResource(2130840379);
        this.sfL.setTextColor(-16777216);
        this.sfL.setBackgroundResource(2130840379);
        this.sfK.setText(paramn.csb().cql());
        this.sfL.setText(paramn.csb().cqm());
      }
      AppMethodBeat.o(40093);
      return;
      i = j;
      if (n == 2)
      {
        this.sfK.setBackgroundColor(m);
        this.sfK.setTextColor(k);
        this.sfK.setText(paramn.csb().rqS.Eb(0));
        this.sfL.setBackgroundResource(2130840379);
        this.sfL.setTextColor(-16777216);
        this.sfL.setText(paramn.csb().rqS.Ea(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final void g(View paramView1, View paramView2)
  {
    AppMethodBeat.i(40091);
    this.contentView = paramView1;
    this.rOw = paramView2;
    this.context = paramView1.getContext();
    this.sfQ = paramView1.findViewById(2131827828);
    this.sfR = paramView1.findViewById(2131827831);
    this.sfJ = paramView1.findViewById(2131827835);
    this.sfJ.setVisibility(8);
    this.sfM = paramView1.findViewById(2131827838);
    this.sfM.setVisibility(8);
    this.sfN = ((MaskImageView)paramView1.findViewById(2131827829));
    this.sfK = ((Button)paramView1.findViewById(2131827836));
    this.sfL = ((Button)paramView1.findViewById(2131827837));
    paramView2 = this.rMD.csd();
    if ((paramView2 != null) && (paramView2.cqi()) && (!this.rMD.csT())) {
      this.sfM.setVisibility(0);
    }
    this.sfI = ((TextView)paramView1.findViewById(2131827833));
    this.sfI.setClickable(false);
    this.sfI.setLongClickable(false);
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int i = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight());
    int j = com.tencent.mm.cb.a.ao(this.context, 2131428700);
    int k = com.tencent.mm.cb.a.ao(this.context, 2131427861);
    int m = this.context.getResources().getDimensionPixelSize(2131427808);
    int n = this.context.getResources().getDimensionPixelSize(2131427808);
    int i1 = this.context.getResources().getDimensionPixelSize(2131427854);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131427792);
    paramView2.bottomMargin = 0;
    paramView2.width = (i - j - k - m - n - i1);
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(2130840375));
    this.sfH = ((TextView)paramView1.findViewById(2131827832));
    this.sfH.setClickable(false);
    this.sfH.setLongClickable(false);
    if (!bo.isNullOrNil(this.rMD.csb().rqC))
    {
      this.sfH.setText(this.rMD.csb().rqC + " ");
      j.k(this.sfH, 2);
      this.sfH.setVisibility(0);
      if (!bo.isNullOrNil(this.rMD.csb().rqD)) {
        break label1328;
      }
      paramView2 = this.timeLineObject.xTP;
      label490:
      if (bo.isNullOrNil(paramView2)) {
        break label1342;
      }
      this.sfI.setText(paramView2 + " ");
      j.k(this.sfI, 2);
      this.sfI.setVisibility(0);
      label541:
      this.jVd = new com.tencent.mm.ui.widget.c.a(this.context);
      this.jVd.c(paramView1, this.rOV.sjJ, this.rOV.sjr);
      if ((!this.rMD.csb().cqr()) && (!this.rMD.csb().cqs())) {
        break label1354;
      }
      this.sfJ.setVisibility(0);
      F(this.rMD);
    }
    for (;;)
    {
      this.sfG = new aj();
      this.sfG.rLE = paramView1.findViewById(2131827830);
      this.sfG.rLD = this.sfG.rLE;
      this.sfG.rLE.setOnClickListener(this.rOV.sjO);
      this.sfG.qVe = ((com.tencent.mm.plugin.sight.decode.a.a)this.sfG.rLE.findViewById(2131820629));
      this.sfG.rwJ = ((ImageView)this.sfG.rLE.findViewById(2131820996));
      this.sfG.rLF = ((MMPinProgressBtn)this.sfG.rLE.findViewById(2131821404));
      this.sfG.rLG = ((TextView)this.sfG.rLE.findViewById(2131827795));
      this.sfG.rwK = ((TextView)this.sfG.rLE.findViewById(2131827796));
      paramView2 = (RelativeLayout.LayoutParams)this.sfN.getLayoutParams();
      paramView2.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      this.sfN.setLayoutParams(paramView2);
      paramView2 = (RelativeLayout.LayoutParams)this.sfG.rLD.getLayoutParams();
      paramView2.leftMargin = com.tencent.mm.cb.a.ao(this.context, 2131427792);
      paramView2.rightMargin = com.tencent.mm.cb.a.ao(this.context, 2131427792);
      paramView2.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.bottomMargin = com.tencent.mm.cb.a.ao(this.context, 2131427792);
      this.sfG.rLD.setLayoutParams(paramView2);
      this.sfP = paramView1.findViewById(2131828110);
      paramView2 = (RelativeLayout.LayoutParams)this.sfP.getLayoutParams();
      paramView2.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      this.sfP.setLayoutParams(paramView2);
      this.sfO = ((SnsCardAdTagListView)this.contentView.findViewById(2131827834));
      this.sfO.setActivityContext((Activity)this.context);
      this.sfO.removeAllViews();
      if (this.rMD.csb().rqG.size() > 0)
      {
        this.sfO.setVisibility(0);
        this.sfO.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.context, 6));
        this.sfO.dx(this.rMD.csb().rqG);
      }
      if (!bo.isNullOrNil(this.rMD.csb().rqE))
      {
        this.sfP.setVisibility(0);
        this.sfP.findViewById(2131828112).setVisibility(0);
        ((TextView)this.sfP.findViewById(2131828112)).setText(this.rMD.csb().rqE);
      }
      if (!bo.isNullOrNil(this.rMD.csb().rqF)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.rMD.csb().rqF, new b.3(this));
      }
      this.jVd.c(paramView1, this.rOV.sjJ, this.rOV.sjr);
      this.sfN.setVisibility(8);
      this.sfN.setScaleType(QImageView.a.AED);
      this.sfG.rLD.setVisibility(8);
      ((SightPlayImageView)this.sfG.qVe).qTZ = true;
      ((SightPlayImageView)this.sfG.qVe).setScaleType(QImageView.a.AED);
      paramView1.setBackgroundResource(2130840375);
      paramView1.setOnClickListener(this.rOV.sjX);
      AppMethodBeat.o(40091);
      return;
      this.sfH.setVisibility(8);
      break;
      label1328:
      paramView2 = this.rMD.csb().rqD;
      break label490;
      label1342:
      this.sfI.setVisibility(8);
      break label541;
      label1354:
      this.sfJ.setVisibility(8);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(40092);
    this.rMD = com.tencent.mm.plugin.sns.storage.h.abu(this.rMD.getSnsId());
    ab.i("MicroMsg.CardAdDetailItemView", "refreshView");
    F(this.rMD);
    this.sfG.rwK.setVisibility(8);
    Object localObject2 = ag.cpc();
    if ((this.timeLineObject.xTS != null) && (this.timeLineObject.xTS.wOa.size() > 0)) {}
    int i;
    int j;
    for (Object localObject1 = (bcs)this.timeLineObject.xTS.wOa.get(0);; localObject1 = null)
    {
      i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject1 == null) {
        break label1494;
      }
      i = i - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427854) - this.context.getResources().getDimensionPixelSize(2131427792) - this.context.getResources().getDimensionPixelSize(2131427792);
      j = (int)(i * ((bcs)localObject1).xrV.xsI / ((bcs)localObject1).xrV.xsH);
      if (this.timeLineObject.xTS.wNZ != 1) {
        break;
      }
      localObject2 = this.sfN.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      this.sfN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ag.cpc().b((bcs)localObject1, this.sfN, -1, this.context.hashCode(), az.yNT);
      this.sfN.setVisibility(0);
      this.sfN.setTag(this);
      this.contentView.setTag(this);
      this.sfK.setTag(this);
      this.sfL.setTag(this);
      this.sfN.setOnClickListener(this.rOV.rHw);
      this.jVd.c(this.sfN, this.rOV.sjJ, this.rOV.sjr);
      AppMethodBeat.o(40092);
      return;
    }
    if ((this.timeLineObject.xTS.wNZ == 5) || (this.timeLineObject.xTS.wNZ == 15))
    {
      this.sfG.rLD.setVisibility(0);
      this.jVd.c(this.sfG.rLE, this.rOV.sjJ, this.rOV.sjr);
      Object localObject3 = this.sfG.rLD.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = i;
      ((ViewGroup.LayoutParams)localObject3).height = j;
      this.sfG.rLD.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.sfG.qVe.ft(i, j);
      this.sfG.qVe.setOnCompletionListener(new b.e()
      {
        public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(40088);
          if ((paramAnonymousInt != -1) && (b.this.rOU != null)) {
            b.this.rOU.v(b.this.rMD.field_snsId, false);
          }
          AppMethodBeat.o(40088);
        }
      });
      if ((this.rOU != null) && (!this.rOU.lj(this.rMD.field_snsId))) {
        this.sfG.qVe.setOnDecodeDurationListener(new b.2(this));
      }
      long l = System.nanoTime();
      boolean bool = com.tencent.mm.plugin.sns.model.g.t((bcs)localObject1);
      ab.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
      localObject3 = this.sfG;
      this.sfG.crk = this.rMD.csH();
      if (!bool) {
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).w((bcs)localObject1))
        {
          ((aj)localObject3).rwJ.setVisibility(8);
          ((aj)localObject3).rLF.setVisibility(0);
          ((aj)localObject3).rLF.dOF();
          this.sfG.rLD.setVisibility(0);
          ((aj)localObject3).qVe.setTagObject(localObject3);
          ((aj)localObject3).rLE.setTag(this);
          this.contentView.setTag(this);
          this.sfK.setTag(this);
          this.sfL.setTag(this);
          ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.rMD, (bcs)localObject1, ((aj)localObject3).qVe, this.context.hashCode(), 0, az.yNT, true, true);
          if (this.rOU != null)
          {
            localObject2 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id);
            localObject1 = i.j((bcs)localObject1);
            if (!e.cN((String)localObject2 + (String)localObject1)) {
              break label1399;
            }
            this.rOU.w(this.rMD.field_snsId, true);
            label830:
            if (ag.cpc().b(this.rMD, null) != 5) {
              break label1417;
            }
          }
        }
      }
      label1417:
      for (bool = true;; bool = false)
      {
        this.rOU.c(this.rMD.field_snsId, bool, false);
        AppMethodBeat.o(40092);
        return;
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) == 5)
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject2).A((bcs)localObject1);
          ((aj)localObject3).rwJ.setVisibility(8);
          ((aj)localObject3).rLF.setVisibility(0);
          ((aj)localObject3).rLF.dOF();
          break;
        }
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((bcs)localObject1))
        {
          ((aj)localObject3).rLF.setVisibility(8);
          ((aj)localObject3).rwJ.setImageResource(2130840321);
          ((aj)localObject3).rwJ.setVisibility(0);
          break;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
        ((aj)localObject3).rwJ.setVisibility(0);
        ((aj)localObject3).rLF.setVisibility(8);
        ((aj)localObject3).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
        ((aj)localObject3).rwJ.setContentDescription(this.context.getResources().getString(2131302100));
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) != 4) {
          break;
        }
        ((aj)localObject3).rwK.setVisibility(0);
        break;
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).u((bcs)localObject1))
        {
          ((aj)localObject3).rwJ.setVisibility(0);
          ((aj)localObject3).rLF.setVisibility(8);
          ((aj)localObject3).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
          ((aj)localObject3).rwJ.setContentDescription(this.context.getResources().getString(2131302100));
        }
        for (;;)
        {
          if (!((aj)localObject3).qVe.cmy()) {
            break label1397;
          }
          ab.d("MicroMsg.CardAdDetailItemView", "play video error " + ((bcs)localObject1).Id + " " + ((bcs)localObject1).Url + " " + ((bcs)localObject1).xrS);
          ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
          ((aj)localObject3).rwJ.setVisibility(0);
          ((aj)localObject3).rLF.setVisibility(8);
          ((aj)localObject3).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
          ((aj)localObject3).rwJ.setContentDescription(this.context.getResources().getString(2131302100));
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).v((bcs)localObject1))
          {
            ((aj)localObject3).rwJ.setVisibility(8);
            ((aj)localObject3).rLF.setVisibility(8);
          }
          else if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) <= 5)
          {
            ((aj)localObject3).rwJ.setVisibility(8);
            ((aj)localObject3).rLF.setVisibility(8);
          }
          else
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
            ((aj)localObject3).rwJ.setVisibility(0);
            ((aj)localObject3).rLF.setVisibility(8);
            ((aj)localObject3).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
            ((aj)localObject3).rwJ.setContentDescription(this.context.getResources().getString(2131302100));
          }
        }
        label1397:
        break;
        label1399:
        this.rOU.w(this.rMD.field_snsId, false);
        break label830;
      }
    }
    ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.sfG.qVe, this.context.hashCode());
    this.sfG.rLG.setVisibility(8);
    this.sfG.qVe.setOnSightCompletionAction(null);
    this.sfG.qVe.setOnCompletionListener(null);
    this.sfG.qVe.setOnDecodeDurationListener(null);
    label1494:
    AppMethodBeat.o(40092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */