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
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public ImageView BLU;
  public View BOP;
  public View BOQ;
  public TextView BOa;
  public View BOf;
  public View BOg;
  public View BOh;
  public TextView BOi;
  public TextView BOj;
  public ImageView BOk;
  public ImageView BOl;
  public View BOm;
  public FrameLayout BOs;
  public com.tencent.mm.plugin.topstory.ui.video.f BPi;
  public View BPj;
  public ImageView BPk;
  public View BPl;
  public View BPm;
  public View BPn;
  public TextView BPo;
  public View BPp;
  public TextView BPq;
  public ImageView BPr;
  private boolean BPs;
  public View ogP;
  public MMNeat7extView ovt;
  public View qjT;
  public TextView uGl;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.BPs = paramBoolean;
  }
  
  public final boolean etM()
  {
    AppMethodBeat.i(126493);
    if ((this.BPn.getAlpha() != 0.0F) && (this.BPm.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void etN()
  {
    AppMethodBeat.i(126495);
    if (!bu.isNullOrNil(this.BIY.title))
    {
      this.ovt.aq(this.BIY.title);
      this.ovt.setVisibility(0);
      this.ovt.requestLayout();
      this.ovt.setOnClickListener(this.km);
      this.uGl.setText(this.BIY.source);
      if (bu.isNullOrNil(this.BIY.dJL)) {
        break label965;
      }
      this.BOm.setVisibility(0);
      label93:
      this.BLU.setOnClickListener(this.km);
      this.uGl.setOnClickListener(this.km);
      this.BOm.setOnClickListener(this.km);
      if (bu.isNullOrNil(this.BIY.HWm)) {
        break label977;
      }
      q.aJb().a(this.BIY.HWm, this.BLU, com.tencent.mm.plugin.topstory.ui.d.BJp);
      label159:
      if (!this.BLL.etm()) {
        break label990;
      }
      this.qjT.setVisibility(0);
      this.qjT.setOnClickListener(this.km);
      label190:
      if (!this.BLL.etn()) {
        break label1002;
      }
      this.BOP.setTag(this.BIY);
      this.BOP.setOnClickListener(this.km);
      this.BOP.setVisibility(0);
      this.BOQ.setVisibility(0);
      label240:
      this.BOP.setTag(this.BIY);
      this.BOP.setOnClickListener(this.km);
      this.ogP.setOnClickListener(this.km);
      this.BPl.setVisibility(0);
      this.BPm.setVisibility(0);
      this.BPn.setVisibility(0);
      if (this.BPi == null)
      {
        this.BPi = new f(this.BLL.dkN(), this.BLL, this);
        this.BOs.removeAllViews();
        localObject = this.BOs;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.BPi;
        ae.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.BLL.getVideoWidth()), Integer.valueOf(this.BLL.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.BLL.getVideoWidth(), this.BLL.getVideoHeight()));
      }
      this.BPi.a(this.BIY, etc());
      if (this.BLL.etl() == etc()) {
        super.eta();
      }
      this.BPo.setText(this.BIY.uly);
      if ((!this.BPs) || (this.BIY.uda.size() <= 0)) {
        break label1065;
      }
      this.BOf.setVisibility(0);
      Object localObject = (dfc)this.BIY.uda.get(0);
      this.BOi.setTag(localObject);
      this.BOi.setText(((dfc)localObject).dyI);
      this.BOi.setVisibility(0);
      this.BOi.setOnClickListener(this.km);
      this.BOg.setVisibility(0);
      this.BOk.setVisibility(8);
      if (!bu.isNullOrNil(((dfc)localObject).dEM))
      {
        q.aJb().a(((dfc)localObject).dEM, this.BOk, com.tencent.mm.plugin.topstory.ui.d.BJq);
        this.BOk.setVisibility(0);
      }
      if (this.BIY.uda.size() <= 1) {
        break label1023;
      }
      localObject = (dfc)this.BIY.uda.get(1);
      this.BOj.setTag(localObject);
      this.BOj.setText(((dfc)localObject).dyI);
      this.BOj.setOnClickListener(this.km);
      this.BOj.setVisibility(0);
      this.BOh.setVisibility(0);
      this.BOl.setVisibility(8);
      if (!bu.isNullOrNil(((dfc)localObject).dEM))
      {
        q.aJb().a(((dfc)localObject).dEM, this.BOl, com.tencent.mm.plugin.topstory.ui.d.BJq);
        this.BOl.setVisibility(0);
      }
      label718:
      if (this.BIY.uda.size() <= 2) {
        break label1044;
      }
      localObject = (dfc)this.BIY.uda.get(2);
      this.BPq.setTag(localObject);
      this.BPq.setText(((dfc)localObject).dyI);
      this.BPq.setOnClickListener(this.km);
      this.BPq.setVisibility(0);
      this.BPp.setVisibility(0);
      this.BPr.setVisibility(8);
      if (!bu.isNullOrNil(((dfc)localObject).dEM))
      {
        q.aJb().a(((dfc)localObject).dEM, this.BPr, com.tencent.mm.plugin.topstory.ui.d.BJq);
        this.BPr.setVisibility(0);
      }
      label837:
      if (this.BLL.etl() != etc()) {
        euw();
      }
      if ((this.BIY.HWq & 0x80) <= 0) {
        break label1110;
      }
      this.BPj.setVisibility(0);
      this.BPj.setOnClickListener(this.km);
      if (!this.BIY.HWv) {
        break label1077;
      }
      this.BPk.setImageResource(2131691329);
      this.BOa.setTextColor(this.BOa.getResources().getColor(2131101051));
    }
    for (;;)
    {
      this.BOa.setText(com.tencent.mm.plugin.topstory.ui.d.TB(this.BIY.HWA));
      AppMethodBeat.o(126495);
      return;
      this.ovt.setVisibility(8);
      break;
      label965:
      this.BOm.setVisibility(8);
      break label93;
      label977:
      this.BLU.setImageResource(2131231875);
      break label159;
      label990:
      this.qjT.setVisibility(8);
      break label190;
      label1002:
      this.BOP.setVisibility(8);
      this.BOQ.setVisibility(8);
      break label240;
      label1023:
      this.BOh.setVisibility(8);
      this.BOj.setVisibility(8);
      break label718;
      label1044:
      this.BPp.setVisibility(8);
      this.BPq.setVisibility(8);
      break label837;
      label1065:
      this.BOf.setVisibility(8);
      break label837;
      label1077:
      this.BPk.setImageResource(2131691330);
      this.BOa.setTextColor(this.BOa.getResources().getColor(2131101182));
    }
    label1110:
    this.BPj.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f etO()
  {
    return this.BPi;
  }
  
  public final void eta()
  {
    AppMethodBeat.i(126492);
    super.eta();
    AppMethodBeat.o(126492);
  }
  
  public final void etb()
  {
    AppMethodBeat.i(126491);
    super.etb();
    this.BPn.animate().cancel();
    this.BPm.animate().cancel();
    this.BPn.setAlpha(0.0F);
    this.BPm.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void euw()
  {
    AppMethodBeat.i(126489);
    ae.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.BPn.animate().cancel();
    this.BPm.animate().cancel();
    this.BPl.animate().cancel();
    this.BPl.setAlpha(0.8F);
    this.BPn.setAlpha(0.8F);
    this.BPm.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final void eux()
  {
    AppMethodBeat.i(126490);
    ae.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.BPn.animate().cancel();
    this.BPm.animate().cancel();
    this.BPl.animate().cancel();
    this.BPl.setAlpha(0.0F);
    this.BPn.setAlpha(0.0F);
    this.BPm.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final void fC(View paramView)
  {
    AppMethodBeat.i(126488);
    super.fC(paramView);
    this.BOs = ((FrameLayout)paramView.findViewById(2131306411));
    this.BLU = ((ImageView)paramView.findViewById(2131305130));
    this.uGl = ((TextView)paramView.findViewById(2131305134));
    this.ovt = ((MMNeat7extView)paramView.findViewById(2131305948));
    this.BOm = paramView.findViewById(2131305129);
    this.qjT = paramView.findViewById(2131304744);
    this.BPj = paramView.findViewById(2131307019);
    this.BPk = ((ImageView)paramView.findViewById(2131307018));
    this.BOa = ((TextView)paramView.findViewById(2131307017));
    this.BOQ = paramView.findViewById(2131302464);
    this.BOP = paramView.findViewById(2131302474);
    this.BOf = paramView.findViewById(2131297472);
    this.BPo = ((TextView)paramView.findViewById(2131297445));
    this.BOg = paramView.findViewById(2131305612);
    this.BOh = paramView.findViewById(2131305616);
    this.BPp = paramView.findViewById(2131305620);
    this.BOi = ((TextView)paramView.findViewById(2131305613));
    this.BOj = ((TextView)paramView.findViewById(2131305617));
    this.BPq = ((TextView)paramView.findViewById(2131305621));
    this.BOk = ((ImageView)paramView.findViewById(2131305611));
    this.BOl = ((ImageView)paramView.findViewById(2131305615));
    this.BPr = ((ImageView)paramView.findViewById(2131305619));
    this.BPl = paramView.findViewById(2131297425);
    this.BPm = paramView.findViewById(2131300722);
    this.BPn = paramView.findViewById(2131300204);
    this.ogP = paramView.findViewById(2131300202);
    if (this.BPs)
    {
      this.BOf.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.BOf.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void fD(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((com.tencent.mm.plugin.topstory.a.h.esr()) && (paramView.getId() == this.ovt.getId())) {
      this.BLL.eti().BNu = true;
    }
    super.fD(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void fE(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.ovt.getId())
    {
      if ((this.BIY != null) && (!bu.isNullOrNil(this.BIY.DTM)))
      {
        paramView = this.BIY.DTM;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.br.d.b(this.BLL.dkN(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.BLL.eti().BNs)
        {
          this.BPi.bTP();
          this.BLL.eti().cyX();
        }
        this.BLL.ete().j(this.BIY);
        ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLL.etg(), this.BIY, etc(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.qjT.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.md(8);
        a(this.BLL, this.BLL.dkN(), this.BPi, etc());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.BOP.getId())
      {
        this.BLL.at(this.BOP, etc());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.BOi.getId()) || (paramView.getId() == this.BOj.getId()))
      {
        this.BLL.etd().BMO = true;
        this.BLL.eti().stopPlay();
        this.BPi.etC();
        paramView = (dfc)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.h.a(this.BLL.etg());
        ((dox)localObject1).rfA = UUID.randomUUID().toString();
        ((dox)localObject1).HVO = this.BIY.udb;
        ((dox)localObject1).HVS = paramView.HMm;
        ((dox)localObject1).HVT = null;
        ((dox)localObject1).HVU = paramView;
        ((dox)localObject1).fOX = this.BLL.Pd();
        ((dox)localObject1).HVV = this.BLL.etd().BMO;
        localObject2 = ((dox)localObject1).DTg.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aaj localaaj = (aaj)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localaaj.key)) {
            localaaj.GrF = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new aaj();
        ((aaj)localObject2).key = "show_tag_list";
        ((aaj)localObject2).GrF = paramView.id;
        ((dox)localObject1).DTg.add(localObject2);
      }
      ad.a(this.BLL.dkN(), (dox)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.md(28);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLL.etg(), this.BIY, etc(), 4, paramView.dyI + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.BLU.getId()) || (paramView.getId() == this.uGl.getId()) || (paramView.getId() == this.BOm.getId()))
      {
        if ((this.BIY != null) && (!bu.isNullOrNil(this.BIY.dJL)))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.BIY.dJL);
          com.tencent.mm.br.d.b(this.BLL.dkN().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLL.etg(), this.BIY, etc(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.BPj.getId())
      {
        this.BLL.a(this.BIY, paramView);
        if (this.BIY.HWv)
        {
          this.BPk.setImageResource(2131691329);
          this.BOa.setTextColor(this.BOa.getResources().getColor(2131101051));
          AppMethodBeat.o(126497);
          return;
        }
        this.BPk.setImageResource(2131691330);
        this.BOa.setTextColor(this.BOa.getResources().getColor(2131101182));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
  
  public final View getWowView()
  {
    return this.BPj;
  }
  
  public final void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.sQ(paramBoolean);
    eux();
    this.BLL.TF(etc());
    if (this.BPi.ap(paramBoolean, false))
    {
      etb();
      super.eta();
    }
    AppMethodBeat.o(126494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */