package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public View mXu;
  public MMNeat7extView nkc;
  public View oWy;
  public TextView snE;
  public ImageView yOU;
  public View yRQ;
  public View yRR;
  public TextView yRb;
  public View yRg;
  public View yRh;
  public View yRi;
  public TextView yRj;
  public TextView yRk;
  public ImageView yRl;
  public ImageView yRm;
  public View yRn;
  public FrameLayout yRt;
  public com.tencent.mm.plugin.topstory.ui.video.f ySj;
  public View ySk;
  public ImageView ySl;
  public View ySm;
  public View ySn;
  public View ySo;
  public TextView ySp;
  public View ySq;
  public TextView ySr;
  public ImageView ySs;
  private boolean ySt;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.ySt = paramBoolean;
  }
  
  public final void dOB()
  {
    AppMethodBeat.i(126492);
    super.dOB();
    AppMethodBeat.o(126492);
  }
  
  public final void dOC()
  {
    AppMethodBeat.i(126491);
    super.dOC();
    this.ySo.animate().cancel();
    this.ySn.animate().cancel();
    this.ySo.setAlpha(0.0F);
    this.ySn.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void dPZ()
  {
    AppMethodBeat.i(126489);
    ad.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.ySo.animate().cancel();
    this.ySn.animate().cancel();
    this.ySm.animate().cancel();
    this.ySm.setAlpha(0.8F);
    this.ySo.setAlpha(0.8F);
    this.ySn.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final boolean dPn()
  {
    AppMethodBeat.i(126493);
    if ((this.ySo.getAlpha() != 0.0F) && (this.ySn.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void dPo()
  {
    AppMethodBeat.i(126495);
    if (!bt.isNullOrNil(this.yLU.title))
    {
      this.nkc.aq(this.yLU.title);
      this.nkc.setVisibility(0);
      this.nkc.requestLayout();
      this.nkc.setOnClickListener(this.hs);
      this.snE.setText(this.yLU.source);
      if (bt.isNullOrNil(this.yLU.kqB)) {
        break label965;
      }
      this.yRn.setVisibility(0);
      label93:
      this.yOU.setOnClickListener(this.hs);
      this.snE.setOnClickListener(this.hs);
      this.yRn.setOnClickListener(this.hs);
      if (bt.isNullOrNil(this.yLU.EuS)) {
        break label977;
      }
      com.tencent.mm.aw.o.ayJ().a(this.yLU.EuS, this.yOU, com.tencent.mm.plugin.topstory.ui.d.yMm);
      label159:
      if (!this.yOL.dON()) {
        break label990;
      }
      this.oWy.setVisibility(0);
      this.oWy.setOnClickListener(this.hs);
      label190:
      if (!this.yOL.dOO()) {
        break label1002;
      }
      this.yRQ.setTag(this.yLU);
      this.yRQ.setOnClickListener(this.hs);
      this.yRQ.setVisibility(0);
      this.yRR.setVisibility(0);
      label240:
      this.yRQ.setTag(this.yLU);
      this.yRQ.setOnClickListener(this.hs);
      this.mXu.setOnClickListener(this.hs);
      this.ySm.setVisibility(0);
      this.ySn.setVisibility(0);
      this.ySo.setVisibility(0);
      if (this.ySj == null)
      {
        this.ySj = new f(this.yOL.cKW(), this.yOL, this);
        this.yRt.removeAllViews();
        localObject = this.yRt;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.ySj;
        ad.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.yOL.getVideoWidth()), Integer.valueOf(this.yOL.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.yOL.getVideoWidth(), this.yOL.getVideoHeight()));
      }
      this.ySj.a(this.yLU, dOD());
      if (this.yOL.dOM() == dOD()) {
        super.dOB();
      }
      this.ySp.setText(this.yLU.rUO);
      if ((!this.ySt) || (this.yLU.rNO.size() <= 0)) {
        break label1065;
      }
      this.yRg.setVisibility(0);
      Object localObject = (ctk)this.yLU.rNO.get(0);
      this.yRj.setTag(localObject);
      this.yRj.setText(((ctk)localObject).doh);
      this.yRj.setVisibility(0);
      this.yRj.setOnClickListener(this.hs);
      this.yRh.setVisibility(0);
      this.yRl.setVisibility(8);
      if (!bt.isNullOrNil(((ctk)localObject).dub))
      {
        com.tencent.mm.aw.o.ayJ().a(((ctk)localObject).dub, this.yRl, com.tencent.mm.plugin.topstory.ui.d.yMn);
        this.yRl.setVisibility(0);
      }
      if (this.yLU.rNO.size() <= 1) {
        break label1023;
      }
      localObject = (ctk)this.yLU.rNO.get(1);
      this.yRk.setTag(localObject);
      this.yRk.setText(((ctk)localObject).doh);
      this.yRk.setOnClickListener(this.hs);
      this.yRk.setVisibility(0);
      this.yRi.setVisibility(0);
      this.yRm.setVisibility(8);
      if (!bt.isNullOrNil(((ctk)localObject).dub))
      {
        com.tencent.mm.aw.o.ayJ().a(((ctk)localObject).dub, this.yRm, com.tencent.mm.plugin.topstory.ui.d.yMn);
        this.yRm.setVisibility(0);
      }
      label718:
      if (this.yLU.rNO.size() <= 2) {
        break label1044;
      }
      localObject = (ctk)this.yLU.rNO.get(2);
      this.ySr.setTag(localObject);
      this.ySr.setText(((ctk)localObject).doh);
      this.ySr.setOnClickListener(this.hs);
      this.ySr.setVisibility(0);
      this.ySq.setVisibility(0);
      this.ySs.setVisibility(8);
      if (!bt.isNullOrNil(((ctk)localObject).dub))
      {
        com.tencent.mm.aw.o.ayJ().a(((ctk)localObject).dub, this.ySs, com.tencent.mm.plugin.topstory.ui.d.yMn);
        this.ySs.setVisibility(0);
      }
      label837:
      if (this.yOL.dOM() != dOD()) {
        dPZ();
      }
      if ((this.yLU.EuW & 0x80) <= 0) {
        break label1110;
      }
      this.ySk.setVisibility(0);
      this.ySk.setOnClickListener(this.hs);
      if (!this.yLU.Evb) {
        break label1077;
      }
      this.ySl.setImageResource(2131691329);
      this.yRb.setTextColor(this.yRb.getResources().getColor(2131101051));
    }
    for (;;)
    {
      this.yRb.setText(com.tencent.mm.plugin.topstory.ui.d.Pe(this.yLU.Evg));
      AppMethodBeat.o(126495);
      return;
      this.nkc.setVisibility(8);
      break;
      label965:
      this.yRn.setVisibility(8);
      break label93;
      label977:
      this.yOU.setImageResource(2131231875);
      break label159;
      label990:
      this.oWy.setVisibility(8);
      break label190;
      label1002:
      this.yRQ.setVisibility(8);
      this.yRR.setVisibility(8);
      break label240;
      label1023:
      this.yRi.setVisibility(8);
      this.yRk.setVisibility(8);
      break label718;
      label1044:
      this.ySq.setVisibility(8);
      this.ySr.setVisibility(8);
      break label837;
      label1065:
      this.yRg.setVisibility(8);
      break label837;
      label1077:
      this.ySl.setImageResource(2131691330);
      this.yRb.setTextColor(this.yRb.getResources().getColor(2131101182));
    }
    label1110:
    this.ySk.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f dPp()
  {
    return this.ySj;
  }
  
  public final void dQa()
  {
    AppMethodBeat.i(126490);
    ad.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.ySo.animate().cancel();
    this.ySn.animate().cancel();
    this.ySm.animate().cancel();
    this.ySm.setAlpha(0.0F);
    this.ySo.setAlpha(0.0F);
    this.ySn.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final void fd(View paramView)
  {
    AppMethodBeat.i(126488);
    super.fd(paramView);
    this.yRt = ((FrameLayout)paramView.findViewById(2131306411));
    this.yOU = ((ImageView)paramView.findViewById(2131305130));
    this.snE = ((TextView)paramView.findViewById(2131305134));
    this.nkc = ((MMNeat7extView)paramView.findViewById(2131305948));
    this.yRn = paramView.findViewById(2131305129);
    this.oWy = paramView.findViewById(2131304744);
    this.ySk = paramView.findViewById(2131307019);
    this.ySl = ((ImageView)paramView.findViewById(2131307018));
    this.yRb = ((TextView)paramView.findViewById(2131307017));
    this.yRR = paramView.findViewById(2131302464);
    this.yRQ = paramView.findViewById(2131302474);
    this.yRg = paramView.findViewById(2131297472);
    this.ySp = ((TextView)paramView.findViewById(2131297445));
    this.yRh = paramView.findViewById(2131305612);
    this.yRi = paramView.findViewById(2131305616);
    this.ySq = paramView.findViewById(2131305620);
    this.yRj = ((TextView)paramView.findViewById(2131305613));
    this.yRk = ((TextView)paramView.findViewById(2131305617));
    this.ySr = ((TextView)paramView.findViewById(2131305621));
    this.yRl = ((ImageView)paramView.findViewById(2131305611));
    this.yRm = ((ImageView)paramView.findViewById(2131305615));
    this.ySs = ((ImageView)paramView.findViewById(2131305619));
    this.ySm = paramView.findViewById(2131297425);
    this.ySn = paramView.findViewById(2131300722);
    this.ySo = paramView.findViewById(2131300204);
    this.mXu = paramView.findViewById(2131300202);
    if (this.ySt)
    {
      this.yRg.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.yRg.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void fe(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((com.tencent.mm.plugin.topstory.a.h.dNT()) && (paramView.getId() == this.nkc.getId())) {
      this.yOL.dOJ().yQu = true;
    }
    super.fe(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void ff(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.nkc.getId())
    {
      if ((this.yLU != null) && (!bt.isNullOrNil(this.yLU.AGB)))
      {
        paramView = this.yLU.AGB;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.bs.d.b(this.yOL.cKW(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.yOL.dOJ().yQs)
        {
          this.ySj.bGO();
          this.yOL.dOJ().ckd();
        }
        this.yOL.dOF().j(this.yLU);
        ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.yOL.dOH(), this.yLU, dOD(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.oWy.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.lI(8);
        a(this.yOL, this.yOL.cKW(), this.ySj, dOD());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.yRQ.getId())
      {
        this.yOL.aq(this.yRQ, dOD());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.yRj.getId()) || (paramView.getId() == this.yRk.getId()))
      {
        this.yOL.dOE().yPO = true;
        this.yOL.dOJ().stopPlay();
        this.ySj.dPd();
        paramView = (ctk)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.h.a(this.yOL.dOH());
        ((dcy)localObject1).qwV = UUID.randomUUID().toString();
        ((dcy)localObject1).Euu = this.yLU.rNP;
        ((dcy)localObject1).Euy = paramView.Eld;
        ((dcy)localObject1).Euz = null;
        ((dcy)localObject1).EuA = paramView;
        ((dcy)localObject1).fqj = this.yOL.Ny();
        ((dcy)localObject1).EuB = this.yOL.dOE().yPO;
        localObject2 = ((dcy)localObject1).AFX.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          xp localxp = (xp)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localxp.key)) {
            localxp.CZj = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new xp();
        ((xp)localObject2).key = "show_tag_list";
        ((xp)localObject2).CZj = paramView.id;
        ((dcy)localObject1).AFX.add(localObject2);
      }
      aa.a(this.yOL.cKW(), (dcy)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.lI(28);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.yOL.dOH(), this.yLU, dOD(), 4, paramView.doh + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.yOU.getId()) || (paramView.getId() == this.snE.getId()) || (paramView.getId() == this.yRn.getId()))
      {
        if ((this.yLU != null) && (!bt.isNullOrNil(this.yLU.kqB)))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.yLU.kqB);
          com.tencent.mm.bs.d.b(this.yOL.cKW().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.yOL.dOH(), this.yLU, dOD(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.ySk.getId())
      {
        this.yOL.a(this.yLU, paramView);
        if (this.yLU.Evb)
        {
          this.ySl.setImageResource(2131691329);
          this.yRb.setTextColor(this.yRb.getResources().getColor(2131101051));
          AppMethodBeat.o(126497);
          return;
        }
        this.ySl.setImageResource(2131691330);
        this.yRb.setTextColor(this.yRb.getResources().getColor(2131101182));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
  
  public final View getWowView()
  {
    return this.ySk;
  }
  
  public final void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.rf(paramBoolean);
    dQa();
    this.yOL.Pi(dOD());
    if (this.ySj.aj(paramBoolean, false))
    {
      dOC();
      super.dOB();
    }
    AppMethodBeat.o(126494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */