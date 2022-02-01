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
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
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
  public ImageView Buw;
  public TextView BwC;
  public View BwH;
  public View BwI;
  public View BwJ;
  public TextView BwK;
  public TextView BwL;
  public ImageView BwM;
  public ImageView BwN;
  public View BwO;
  public FrameLayout BwU;
  public com.tencent.mm.plugin.topstory.ui.video.f BxK;
  public View BxL;
  public ImageView BxM;
  public View BxN;
  public View BxO;
  public View BxP;
  public TextView BxQ;
  public View BxR;
  public TextView BxS;
  public ImageView BxT;
  private boolean BxU;
  public View Bxr;
  public View Bxs;
  public View oaY;
  public MMNeat7extView opB;
  public View qdo;
  public TextView uuM;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.BxU = paramBoolean;
  }
  
  public final void ept()
  {
    AppMethodBeat.i(126492);
    super.ept();
    AppMethodBeat.o(126492);
  }
  
  public final void epu()
  {
    AppMethodBeat.i(126491);
    super.epu();
    this.BxP.animate().cancel();
    this.BxO.animate().cancel();
    this.BxP.setAlpha(0.0F);
    this.BxO.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void eqP()
  {
    AppMethodBeat.i(126489);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.BxP.animate().cancel();
    this.BxO.animate().cancel();
    this.BxN.animate().cancel();
    this.BxN.setAlpha(0.8F);
    this.BxP.setAlpha(0.8F);
    this.BxO.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final void eqQ()
  {
    AppMethodBeat.i(126490);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.BxP.animate().cancel();
    this.BxO.animate().cancel();
    this.BxN.animate().cancel();
    this.BxN.setAlpha(0.0F);
    this.BxP.setAlpha(0.0F);
    this.BxO.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final boolean eqf()
  {
    AppMethodBeat.i(126493);
    if ((this.BxP.getAlpha() != 0.0F) && (this.BxO.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void eqg()
  {
    AppMethodBeat.i(126495);
    if (!bt.isNullOrNil(this.Brz.title))
    {
      this.opB.ar(this.Brz.title);
      this.opB.setVisibility(0);
      this.opB.requestLayout();
      this.opB.setOnClickListener(this.km);
      this.uuM.setText(this.Brz.source);
      if (bt.isNullOrNil(this.Brz.lox)) {
        break label965;
      }
      this.BwO.setVisibility(0);
      label93:
      this.Buw.setOnClickListener(this.km);
      this.uuM.setOnClickListener(this.km);
      this.BwO.setOnClickListener(this.km);
      if (bt.isNullOrNil(this.Brz.HCz)) {
        break label977;
      }
      q.aIJ().a(this.Brz.HCz, this.Buw, com.tencent.mm.plugin.topstory.ui.d.BrQ);
      label159:
      if (!this.Bun.epF()) {
        break label990;
      }
      this.qdo.setVisibility(0);
      this.qdo.setOnClickListener(this.km);
      label190:
      if (!this.Bun.epG()) {
        break label1002;
      }
      this.Bxr.setTag(this.Brz);
      this.Bxr.setOnClickListener(this.km);
      this.Bxr.setVisibility(0);
      this.Bxs.setVisibility(0);
      label240:
      this.Bxr.setTag(this.Brz);
      this.Bxr.setOnClickListener(this.km);
      this.oaY.setOnClickListener(this.km);
      this.BxN.setVisibility(0);
      this.BxO.setVisibility(0);
      this.BxP.setVisibility(0);
      if (this.BxK == null)
      {
        this.BxK = new f(this.Bun.dhO(), this.Bun, this);
        this.BwU.removeAllViews();
        localObject = this.BwU;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.BxK;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.Bun.getVideoWidth()), Integer.valueOf(this.Bun.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.Bun.getVideoWidth(), this.Bun.getVideoHeight()));
      }
      this.BxK.a(this.Brz, epv());
      if (this.Bun.epE() == epv()) {
        super.ept();
      }
      this.BxQ.setText(this.Brz.uaw);
      if ((!this.BxU) || (this.Brz.tSj.size() <= 0)) {
        break label1065;
      }
      this.BwH.setVisibility(0);
      Object localObject = (dei)this.Brz.tSj.get(0);
      this.BwK.setTag(localObject);
      this.BwK.setText(((dei)localObject).dxD);
      this.BwK.setVisibility(0);
      this.BwK.setOnClickListener(this.km);
      this.BwI.setVisibility(0);
      this.BwM.setVisibility(8);
      if (!bt.isNullOrNil(((dei)localObject).dDH))
      {
        q.aIJ().a(((dei)localObject).dDH, this.BwM, com.tencent.mm.plugin.topstory.ui.d.BrR);
        this.BwM.setVisibility(0);
      }
      if (this.Brz.tSj.size() <= 1) {
        break label1023;
      }
      localObject = (dei)this.Brz.tSj.get(1);
      this.BwL.setTag(localObject);
      this.BwL.setText(((dei)localObject).dxD);
      this.BwL.setOnClickListener(this.km);
      this.BwL.setVisibility(0);
      this.BwJ.setVisibility(0);
      this.BwN.setVisibility(8);
      if (!bt.isNullOrNil(((dei)localObject).dDH))
      {
        q.aIJ().a(((dei)localObject).dDH, this.BwN, com.tencent.mm.plugin.topstory.ui.d.BrR);
        this.BwN.setVisibility(0);
      }
      label718:
      if (this.Brz.tSj.size() <= 2) {
        break label1044;
      }
      localObject = (dei)this.Brz.tSj.get(2);
      this.BxS.setTag(localObject);
      this.BxS.setText(((dei)localObject).dxD);
      this.BxS.setOnClickListener(this.km);
      this.BxS.setVisibility(0);
      this.BxR.setVisibility(0);
      this.BxT.setVisibility(8);
      if (!bt.isNullOrNil(((dei)localObject).dDH))
      {
        q.aIJ().a(((dei)localObject).dDH, this.BxT, com.tencent.mm.plugin.topstory.ui.d.BrR);
        this.BxT.setVisibility(0);
      }
      label837:
      if (this.Bun.epE() != epv()) {
        eqP();
      }
      if ((this.Brz.HCD & 0x80) <= 0) {
        break label1110;
      }
      this.BxL.setVisibility(0);
      this.BxL.setOnClickListener(this.km);
      if (!this.Brz.HCI) {
        break label1077;
      }
      this.BxM.setImageResource(2131691329);
      this.BwC.setTextColor(this.BwC.getResources().getColor(2131101051));
    }
    for (;;)
    {
      this.BwC.setText(com.tencent.mm.plugin.topstory.ui.d.SU(this.Brz.HCN));
      AppMethodBeat.o(126495);
      return;
      this.opB.setVisibility(8);
      break;
      label965:
      this.BwO.setVisibility(8);
      break label93;
      label977:
      this.Buw.setImageResource(2131231875);
      break label159;
      label990:
      this.qdo.setVisibility(8);
      break label190;
      label1002:
      this.Bxr.setVisibility(8);
      this.Bxs.setVisibility(8);
      break label240;
      label1023:
      this.BwJ.setVisibility(8);
      this.BwL.setVisibility(8);
      break label718;
      label1044:
      this.BxR.setVisibility(8);
      this.BxS.setVisibility(8);
      break label837;
      label1065:
      this.BwH.setVisibility(8);
      break label837;
      label1077:
      this.BxM.setImageResource(2131691330);
      this.BwC.setTextColor(this.BwC.getResources().getColor(2131101182));
    }
    label1110:
    this.BxL.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f eqh()
  {
    return this.BxK;
  }
  
  public final void fD(View paramView)
  {
    AppMethodBeat.i(126488);
    super.fD(paramView);
    this.BwU = ((FrameLayout)paramView.findViewById(2131306411));
    this.Buw = ((ImageView)paramView.findViewById(2131305130));
    this.uuM = ((TextView)paramView.findViewById(2131305134));
    this.opB = ((MMNeat7extView)paramView.findViewById(2131305948));
    this.BwO = paramView.findViewById(2131305129);
    this.qdo = paramView.findViewById(2131304744);
    this.BxL = paramView.findViewById(2131307019);
    this.BxM = ((ImageView)paramView.findViewById(2131307018));
    this.BwC = ((TextView)paramView.findViewById(2131307017));
    this.Bxs = paramView.findViewById(2131302464);
    this.Bxr = paramView.findViewById(2131302474);
    this.BwH = paramView.findViewById(2131297472);
    this.BxQ = ((TextView)paramView.findViewById(2131297445));
    this.BwI = paramView.findViewById(2131305612);
    this.BwJ = paramView.findViewById(2131305616);
    this.BxR = paramView.findViewById(2131305620);
    this.BwK = ((TextView)paramView.findViewById(2131305613));
    this.BwL = ((TextView)paramView.findViewById(2131305617));
    this.BxS = ((TextView)paramView.findViewById(2131305621));
    this.BwM = ((ImageView)paramView.findViewById(2131305611));
    this.BwN = ((ImageView)paramView.findViewById(2131305615));
    this.BxT = ((ImageView)paramView.findViewById(2131305619));
    this.BxN = paramView.findViewById(2131297425);
    this.BxO = paramView.findViewById(2131300722);
    this.BxP = paramView.findViewById(2131300204);
    this.oaY = paramView.findViewById(2131300202);
    if (this.BxU)
    {
      this.BwH.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.BwH.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void fE(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((com.tencent.mm.plugin.topstory.a.h.eoK()) && (paramView.getId() == this.opB.getId())) {
      this.Bun.epB().BvW = true;
    }
    super.fE(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void fF(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.opB.getId())
    {
      if ((this.Brz != null) && (!bt.isNullOrNil(this.Brz.DBP)))
      {
        paramView = this.Brz.DBP;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.bs.d.b(this.Bun.dhO(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.Bun.epB().BvU)
        {
          this.BxK.bSC();
          this.Bun.epB().cxw();
        }
        this.Bun.epx().j(this.Brz);
        ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Bun.epz(), this.Brz, epv(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.qdo.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.ma(8);
        a(this.Bun, this.Bun.dhO(), this.BxK, epv());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.Bxr.getId())
      {
        this.Bun.at(this.Bxr, epv());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.BwK.getId()) || (paramView.getId() == this.BwL.getId()))
      {
        this.Bun.epw().Bvq = true;
        this.Bun.epB().stopPlay();
        this.BxK.epV();
        paramView = (dei)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.h.a(this.Bun.epz());
        ((doa)localObject1).qXu = UUID.randomUUID().toString();
        ((doa)localObject1).HCb = this.Brz.tSk;
        ((doa)localObject1).HCf = paramView.HsJ;
        ((doa)localObject1).HCg = null;
        ((doa)localObject1).HCh = paramView;
        ((doa)localObject1).fMP = this.Bun.Pf();
        ((doa)localObject1).HCi = this.Bun.epw().Bvq;
        localObject2 = ((doa)localObject1).DBj.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aag localaag = (aag)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localaag.key)) {
            localaag.FZf = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new aag();
        ((aag)localObject2).key = "show_tag_list";
        ((aag)localObject2).FZf = paramView.id;
        ((doa)localObject1).DBj.add(localObject2);
      }
      com.tencent.mm.plugin.websearch.api.ad.a(this.Bun.dhO(), (doa)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.ma(28);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Bun.epz(), this.Brz, epv(), 4, paramView.dxD + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.Buw.getId()) || (paramView.getId() == this.uuM.getId()) || (paramView.getId() == this.BwO.getId()))
      {
        if ((this.Brz != null) && (!bt.isNullOrNil(this.Brz.lox)))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.Brz.lox);
          com.tencent.mm.bs.d.b(this.Bun.dhO().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Bun.epz(), this.Brz, epv(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.BxL.getId())
      {
        this.Bun.a(this.Brz, paramView);
        if (this.Brz.HCI)
        {
          this.BxM.setImageResource(2131691329);
          this.BwC.setTextColor(this.BwC.getResources().getColor(2131101051));
          AppMethodBeat.o(126497);
          return;
        }
        this.BxM.setImageResource(2131691330);
        this.BwC.setTextColor(this.BwC.getResources().getColor(2131101182));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
  
  public final View getWowView()
  {
    return this.BxL;
  }
  
  public final void sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.sJ(paramBoolean);
    eqQ();
    this.Bun.SY(epv());
    if (this.BxK.aq(paramBoolean, false))
    {
      epu();
      super.ept();
    }
    AppMethodBeat.o(126494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */