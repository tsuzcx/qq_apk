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
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public ImageView AcL;
  public TextView AeQ;
  public View AeV;
  public View AeW;
  public View AeX;
  public TextView AeY;
  public TextView AeZ;
  public View AfF;
  public View AfG;
  public com.tencent.mm.plugin.topstory.ui.video.f AfY;
  public View AfZ;
  public ImageView Afa;
  public ImageView Afb;
  public View Afc;
  public FrameLayout Afi;
  public ImageView Aga;
  public View Agb;
  public View Agc;
  public View Agd;
  public TextView Age;
  public View Agf;
  public TextView Agg;
  public ImageView Agh;
  private boolean Agi;
  public MMNeat7extView nMV;
  public View nzT;
  public View pzJ;
  public TextView tvx;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.Agi = paramBoolean;
  }
  
  public final boolean edN()
  {
    AppMethodBeat.i(126493);
    if ((this.Agd.getAlpha() != 0.0F) && (this.Agc.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void edO()
  {
    AppMethodBeat.i(126495);
    if (!bs.isNullOrNil(this.zZN.title))
    {
      this.nMV.ar(this.zZN.title);
      this.nMV.setVisibility(0);
      this.nMV.requestLayout();
      this.nMV.setOnClickListener(this.iu);
      this.tvx.setText(this.zZN.source);
      if (bs.isNullOrNil(this.zZN.kRU)) {
        break label965;
      }
      this.Afc.setVisibility(0);
      label93:
      this.AcL.setOnClickListener(this.iu);
      this.tvx.setOnClickListener(this.iu);
      this.Afc.setOnClickListener(this.iu);
      if (bs.isNullOrNil(this.zZN.FRT)) {
        break label977;
      }
      com.tencent.mm.av.o.aFB().a(this.zZN.FRT, this.AcL, com.tencent.mm.plugin.topstory.ui.d.Aae);
      label159:
      if (!this.AcC.edn()) {
        break label990;
      }
      this.pzJ.setVisibility(0);
      this.pzJ.setOnClickListener(this.iu);
      label190:
      if (!this.AcC.edo()) {
        break label1002;
      }
      this.AfF.setTag(this.zZN);
      this.AfF.setOnClickListener(this.iu);
      this.AfF.setVisibility(0);
      this.AfG.setVisibility(0);
      label240:
      this.AfF.setTag(this.zZN);
      this.AfF.setOnClickListener(this.iu);
      this.nzT.setOnClickListener(this.iu);
      this.Agb.setVisibility(0);
      this.Agc.setVisibility(0);
      this.Agd.setVisibility(0);
      if (this.AfY == null)
      {
        this.AfY = new f(this.AcC.cYC(), this.AcC, this);
        this.Afi.removeAllViews();
        localObject = this.Afi;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.AfY;
        ac.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.AcC.getVideoWidth()), Integer.valueOf(this.AcC.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.AcC.getVideoWidth(), this.AcC.getVideoHeight()));
      }
      this.AfY.a(this.zZN, edd());
      if (this.AcC.edm() == edd()) {
        super.edb();
      }
      this.Age.setText(this.zZN.tcG);
      if ((!this.Agi) || (this.zZN.sVE.size() <= 0)) {
        break label1065;
      }
      this.AeV.setVisibility(0);
      Object localObject = (cyv)this.zZN.sVE.get(0);
      this.AeY.setTag(localObject);
      this.AeY.setText(((cyv)localObject).dlQ);
      this.AeY.setVisibility(0);
      this.AeY.setOnClickListener(this.iu);
      this.AeW.setVisibility(0);
      this.Afa.setVisibility(8);
      if (!bs.isNullOrNil(((cyv)localObject).drM))
      {
        com.tencent.mm.av.o.aFB().a(((cyv)localObject).drM, this.Afa, com.tencent.mm.plugin.topstory.ui.d.Aaf);
        this.Afa.setVisibility(0);
      }
      if (this.zZN.sVE.size() <= 1) {
        break label1023;
      }
      localObject = (cyv)this.zZN.sVE.get(1);
      this.AeZ.setTag(localObject);
      this.AeZ.setText(((cyv)localObject).dlQ);
      this.AeZ.setOnClickListener(this.iu);
      this.AeZ.setVisibility(0);
      this.AeX.setVisibility(0);
      this.Afb.setVisibility(8);
      if (!bs.isNullOrNil(((cyv)localObject).drM))
      {
        com.tencent.mm.av.o.aFB().a(((cyv)localObject).drM, this.Afb, com.tencent.mm.plugin.topstory.ui.d.Aaf);
        this.Afb.setVisibility(0);
      }
      label718:
      if (this.zZN.sVE.size() <= 2) {
        break label1044;
      }
      localObject = (cyv)this.zZN.sVE.get(2);
      this.Agg.setTag(localObject);
      this.Agg.setText(((cyv)localObject).dlQ);
      this.Agg.setOnClickListener(this.iu);
      this.Agg.setVisibility(0);
      this.Agf.setVisibility(0);
      this.Agh.setVisibility(8);
      if (!bs.isNullOrNil(((cyv)localObject).drM))
      {
        com.tencent.mm.av.o.aFB().a(((cyv)localObject).drM, this.Agh, com.tencent.mm.plugin.topstory.ui.d.Aaf);
        this.Agh.setVisibility(0);
      }
      label837:
      if (this.AcC.edm() != edd()) {
        eey();
      }
      if ((this.zZN.FRX & 0x80) <= 0) {
        break label1110;
      }
      this.AfZ.setVisibility(0);
      this.AfZ.setOnClickListener(this.iu);
      if (!this.zZN.FSc) {
        break label1077;
      }
      this.Aga.setImageResource(2131691329);
      this.AeQ.setTextColor(this.AeQ.getResources().getColor(2131101051));
    }
    for (;;)
    {
      this.AeQ.setText(com.tencent.mm.plugin.topstory.ui.d.Rk(this.zZN.FSh));
      AppMethodBeat.o(126495);
      return;
      this.nMV.setVisibility(8);
      break;
      label965:
      this.Afc.setVisibility(8);
      break label93;
      label977:
      this.AcL.setImageResource(2131231875);
      break label159;
      label990:
      this.pzJ.setVisibility(8);
      break label190;
      label1002:
      this.AfF.setVisibility(8);
      this.AfG.setVisibility(8);
      break label240;
      label1023:
      this.AeX.setVisibility(8);
      this.AeZ.setVisibility(8);
      break label718;
      label1044:
      this.Agf.setVisibility(8);
      this.Agg.setVisibility(8);
      break label837;
      label1065:
      this.AeV.setVisibility(8);
      break label837;
      label1077:
      this.Aga.setImageResource(2131691330);
      this.AeQ.setTextColor(this.AeQ.getResources().getColor(2131101182));
    }
    label1110:
    this.AfZ.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f edP()
  {
    return this.AfY;
  }
  
  public final void edb()
  {
    AppMethodBeat.i(126492);
    super.edb();
    AppMethodBeat.o(126492);
  }
  
  public final void edc()
  {
    AppMethodBeat.i(126491);
    super.edc();
    this.Agd.animate().cancel();
    this.Agc.animate().cancel();
    this.Agd.setAlpha(0.0F);
    this.Agc.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void eey()
  {
    AppMethodBeat.i(126489);
    ac.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.Agd.animate().cancel();
    this.Agc.animate().cancel();
    this.Agb.animate().cancel();
    this.Agb.setAlpha(0.8F);
    this.Agd.setAlpha(0.8F);
    this.Agc.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final void eez()
  {
    AppMethodBeat.i(126490);
    ac.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.Agd.animate().cancel();
    this.Agc.animate().cancel();
    this.Agb.animate().cancel();
    this.Agb.setAlpha(0.0F);
    this.Agd.setAlpha(0.0F);
    this.Agc.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final void fq(View paramView)
  {
    AppMethodBeat.i(126488);
    super.fq(paramView);
    this.Afi = ((FrameLayout)paramView.findViewById(2131306411));
    this.AcL = ((ImageView)paramView.findViewById(2131305130));
    this.tvx = ((TextView)paramView.findViewById(2131305134));
    this.nMV = ((MMNeat7extView)paramView.findViewById(2131305948));
    this.Afc = paramView.findViewById(2131305129);
    this.pzJ = paramView.findViewById(2131304744);
    this.AfZ = paramView.findViewById(2131307019);
    this.Aga = ((ImageView)paramView.findViewById(2131307018));
    this.AeQ = ((TextView)paramView.findViewById(2131307017));
    this.AfG = paramView.findViewById(2131302464);
    this.AfF = paramView.findViewById(2131302474);
    this.AeV = paramView.findViewById(2131297472);
    this.Age = ((TextView)paramView.findViewById(2131297445));
    this.AeW = paramView.findViewById(2131305612);
    this.AeX = paramView.findViewById(2131305616);
    this.Agf = paramView.findViewById(2131305620);
    this.AeY = ((TextView)paramView.findViewById(2131305613));
    this.AeZ = ((TextView)paramView.findViewById(2131305617));
    this.Agg = ((TextView)paramView.findViewById(2131305621));
    this.Afa = ((ImageView)paramView.findViewById(2131305611));
    this.Afb = ((ImageView)paramView.findViewById(2131305615));
    this.Agh = ((ImageView)paramView.findViewById(2131305619));
    this.Agb = paramView.findViewById(2131297425);
    this.Agc = paramView.findViewById(2131300722);
    this.Agd = paramView.findViewById(2131300204);
    this.nzT = paramView.findViewById(2131300202);
    if (this.Agi)
    {
      this.AeV.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.AeV.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void fr(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((com.tencent.mm.plugin.topstory.a.h.ect()) && (paramView.getId() == this.nMV.getId())) {
      this.AcC.edj().Aek = true;
    }
    super.fr(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void fs(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.nMV.getId())
    {
      if ((this.zZN != null) && (!bs.isNullOrNil(this.zZN.BYT)))
      {
        paramView = this.zZN.BYT;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.br.d.b(this.AcC.cYC(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.AcC.edj().Aei)
        {
          this.AfY.bOb();
          this.AcC.edj().crK();
        }
        this.AcC.edf().j(this.zZN);
        ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.AcC.edh(), this.zZN, edd(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.pzJ.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.lA(8);
        a(this.AcC, this.AcC.cYC(), this.AfY, edd());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.AfF.getId())
      {
        this.AcC.as(this.AfF, edd());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.AeY.getId()) || (paramView.getId() == this.AeZ.getId()))
      {
        this.AcC.ede().AdF = true;
        this.AcC.edj().stopPlay();
        this.AfY.edD();
        paramView = (cyv)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.h.a(this.AcC.edh());
        ((dil)localObject1).qox = UUID.randomUUID().toString();
        ((dil)localObject1).FRv = this.zZN.sVF;
        ((dil)localObject1).FRz = paramView.FIb;
        ((dil)localObject1).FRA = null;
        ((dil)localObject1).FRB = paramView;
        ((dil)localObject1).ftN = this.AcC.Nw();
        ((dil)localObject1).FRC = this.AcC.ede().AdF;
        localObject2 = ((dil)localObject1).BYq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          yh localyh = (yh)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localyh.key)) {
            localyh.ErW = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new yh();
        ((yh)localObject2).key = "show_tag_list";
        ((yh)localObject2).ErW = paramView.id;
        ((dil)localObject1).BYq.add(localObject2);
      }
      z.a(this.AcC.cYC(), (dil)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.lA(28);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.AcC.edh(), this.zZN, edd(), 4, paramView.dlQ + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.AcL.getId()) || (paramView.getId() == this.tvx.getId()) || (paramView.getId() == this.Afc.getId()))
      {
        if ((this.zZN != null) && (!bs.isNullOrNil(this.zZN.kRU)))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.zZN.kRU);
          com.tencent.mm.br.d.b(this.AcC.cYC().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.AcC.edh(), this.zZN, edd(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.AfZ.getId())
      {
        this.AcC.a(this.zZN, paramView);
        if (this.zZN.FSc)
        {
          this.Aga.setImageResource(2131691329);
          this.AeQ.setTextColor(this.AeQ.getResources().getColor(2131101051));
          AppMethodBeat.o(126497);
          return;
        }
        this.Aga.setImageResource(2131691330);
        this.AeQ.setTextColor(this.AeQ.getResources().getColor(2131101182));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
  
  public final View getWowView()
  {
    return this.AfZ;
  }
  
  public final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.sd(paramBoolean);
    eez();
    this.AcC.Ro(edd());
    if (this.AfY.am(paramBoolean, false))
    {
      edc();
      super.edb();
    }
    AppMethodBeat.o(126494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */