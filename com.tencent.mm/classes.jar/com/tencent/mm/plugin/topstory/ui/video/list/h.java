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
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public View jWo;
  public MMNeat7extView kgH;
  public View lFN;
  public TextView naO;
  public TextView naP;
  public TextView naQ;
  public TextView qzL;
  public ImageView tiu;
  public View tkB;
  public View tkC;
  public View tkD;
  public ImageView tkE;
  public ImageView tkF;
  public View tkG;
  public FrameLayout tkL;
  public TextView tkw;
  public View tlA;
  public View tlB;
  public TextView tlC;
  public View tlD;
  public ImageView tlE;
  private boolean tlF;
  public View tli;
  public com.tencent.mm.plugin.topstory.ui.video.f tlw;
  public View tlx;
  public ImageView tly;
  public View tlz;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.tlF = paramBoolean;
  }
  
  public final void cIZ()
  {
    AppMethodBeat.i(2091);
    super.cIZ();
    AppMethodBeat.o(2091);
  }
  
  public final boolean cJK()
  {
    AppMethodBeat.i(2092);
    if ((this.tlB.getAlpha() != 0.0F) && (this.tlA.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(2092);
      return true;
    }
    AppMethodBeat.o(2092);
    return false;
  }
  
  public final void cJL()
  {
    AppMethodBeat.i(2094);
    if (!bo.isNullOrNil(this.tfm.title))
    {
      this.kgH.af(this.tfm.title);
      this.kgH.setVisibility(0);
      this.kgH.requestLayout();
      this.kgH.setOnClickListener(this.qaq);
      this.qzL.setText(this.tfm.source);
      if (bo.isNullOrNil(this.tfm.puE)) {
        break label921;
      }
      this.tkG.setVisibility(0);
      label94:
      this.tiu.setOnClickListener(this.qaq);
      this.qzL.setOnClickListener(this.qaq);
      this.tkG.setOnClickListener(this.qaq);
      if (bo.isNullOrNil(this.tfm.xVg)) {
        break label933;
      }
      com.tencent.mm.at.o.ahG().a(this.tfm.xVg, this.tiu, com.tencent.mm.plugin.topstory.ui.d.tfD);
      label160:
      if (!this.tim.cJl()) {
        break label946;
      }
      this.lFN.setVisibility(0);
      this.lFN.setOnClickListener(this.qaq);
      label191:
      this.tli.setTag(this.tfm);
      this.tli.setOnClickListener(this.qaq);
      if (bo.es(this.tfm.xVk)) {
        break label958;
      }
      this.tli.setVisibility(0);
      label234:
      this.jWo.setOnClickListener(this.qaq);
      this.tlz.setVisibility(0);
      this.tlA.setVisibility(0);
      this.tlB.setVisibility(0);
      if (this.tlw == null)
      {
        this.tlw = new f(this.tim.bMN(), this.tim, this);
        this.tkL.removeAllViews();
        localObject = this.tkL;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.tlw;
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.tim.getVideoWidth()), Integer.valueOf(this.tim.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.tim.getVideoWidth(), this.tim.getVideoHeight()));
      }
      this.tlw.a(this.tfm, cJb());
      if (this.tim.cJk() == cJb()) {
        super.cIZ();
      }
      this.tlC.setText(this.tfm.rrm);
      if ((!this.tlF) || (this.tfm.wVo.size() <= 0)) {
        break label1012;
      }
      this.tkB.setVisibility(0);
      Object localObject = (ccp)this.tfm.wVo.get(0);
      this.naO.setTag(localObject);
      this.naO.setText(((ccp)localObject).cyA);
      this.naO.setVisibility(0);
      this.naO.setOnClickListener(this.qaq);
      this.tkC.setVisibility(0);
      this.tkE.setVisibility(8);
      if (!bo.isNullOrNil(((ccp)localObject).cDz))
      {
        com.tencent.mm.at.o.ahG().a(((ccp)localObject).cDz, this.tkE, com.tencent.mm.plugin.topstory.ui.d.tfE);
        this.tkE.setVisibility(0);
      }
      if (this.tfm.wVo.size() <= 1) {
        break label970;
      }
      localObject = (ccp)this.tfm.wVo.get(1);
      this.naP.setTag(localObject);
      this.naP.setText(((ccp)localObject).cyA);
      this.naP.setOnClickListener(this.qaq);
      this.naP.setVisibility(0);
      this.tkD.setVisibility(0);
      this.tkF.setVisibility(8);
      if (!bo.isNullOrNil(((ccp)localObject).cDz))
      {
        com.tencent.mm.at.o.ahG().a(((ccp)localObject).cDz, this.tkF, com.tencent.mm.plugin.topstory.ui.d.tfE);
        this.tkF.setVisibility(0);
      }
      label690:
      if (this.tfm.wVo.size() <= 2) {
        break label991;
      }
      localObject = (ccp)this.tfm.wVo.get(2);
      this.naQ.setTag(localObject);
      this.naQ.setText(((ccp)localObject).cyA);
      this.naQ.setOnClickListener(this.qaq);
      this.naQ.setVisibility(0);
      this.tlD.setVisibility(0);
      this.tlE.setVisibility(8);
      if (!bo.isNullOrNil(((ccp)localObject).cDz))
      {
        com.tencent.mm.at.o.ahG().a(((ccp)localObject).cDz, this.tlE, com.tencent.mm.plugin.topstory.ui.d.tfE);
        this.tlE.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.tim.cJk() != cJb()) {
        cKt();
      }
      if ((this.tfm.xVl & 0x80) <= 0) {
        break label1061;
      }
      this.tlx.setVisibility(0);
      this.tlx.setOnClickListener(this.qaq);
      if (!this.tfm.xVp) {
        break label1024;
      }
      this.tly.setImageResource(2131232125);
      this.tkw.setTextColor(this.tkw.getResources().getColor(2131690603));
      AppMethodBeat.o(2094);
      return;
      this.kgH.setVisibility(8);
      break;
      label921:
      this.tkG.setVisibility(8);
      break label94;
      label933:
      this.tiu.setImageResource(2130838493);
      break label160;
      label946:
      this.lFN.setVisibility(8);
      break label191;
      label958:
      this.tli.setVisibility(8);
      break label234;
      label970:
      this.tkD.setVisibility(8);
      this.naP.setVisibility(8);
      break label690;
      label991:
      this.tlD.setVisibility(8);
      this.naQ.setVisibility(8);
      continue;
      label1012:
      this.tkB.setVisibility(8);
    }
    label1024:
    this.tly.setImageResource(2131232126);
    this.tkw.setTextColor(this.tkw.getResources().getColor(2131690709));
    AppMethodBeat.o(2094);
    return;
    label1061:
    this.tlx.setVisibility(8);
    AppMethodBeat.o(2094);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f cJM()
  {
    return this.tlw;
  }
  
  public final void cJa()
  {
    AppMethodBeat.i(2090);
    super.cJa();
    this.tlB.animate().cancel();
    this.tlA.animate().cancel();
    this.tlB.setAlpha(0.0F);
    this.tlA.setAlpha(0.0F);
    AppMethodBeat.o(2090);
  }
  
  public final void cKt()
  {
    AppMethodBeat.i(2088);
    ab.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.tlB.animate().cancel();
    this.tlA.animate().cancel();
    this.tlz.animate().cancel();
    this.tlz.setAlpha(0.8F);
    this.tlB.setAlpha(0.8F);
    this.tlA.setAlpha(0.8F);
    AppMethodBeat.o(2088);
  }
  
  public final void cKu()
  {
    AppMethodBeat.i(2089);
    ab.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.tlB.animate().cancel();
    this.tlA.animate().cancel();
    this.tlz.animate().cancel();
    this.tlz.setAlpha(0.0F);
    this.tlB.setAlpha(0.0F);
    this.tlA.setAlpha(0.0F);
    AppMethodBeat.o(2089);
  }
  
  public final void ep(View paramView)
  {
    AppMethodBeat.i(2087);
    super.ep(paramView);
    this.tkL = ((FrameLayout)paramView.findViewById(2131828187));
    this.tiu = ((ImageView)paramView.findViewById(2131828540));
    this.qzL = ((TextView)paramView.findViewById(2131821550));
    this.kgH = ((MMNeat7extView)paramView.findViewById(2131821212));
    this.tkG = paramView.findViewById(2131828541);
    this.lFN = paramView.findViewById(2131828545);
    this.tlx = paramView.findViewById(2131828542);
    this.tly = ((ImageView)paramView.findViewById(2131828543));
    this.tkw = ((TextView)paramView.findViewById(2131828544));
    this.tli = paramView.findViewById(2131828546);
    this.tkB = paramView.findViewById(2131828550);
    this.tlC = ((TextView)paramView.findViewById(2131828597));
    this.tkC = paramView.findViewById(2131828551);
    this.tkD = paramView.findViewById(2131828554);
    this.tlD = paramView.findViewById(2131828600);
    this.naO = ((TextView)paramView.findViewById(2131828553));
    this.naP = ((TextView)paramView.findViewById(2131828556));
    this.naQ = ((TextView)paramView.findViewById(2131828602));
    this.tkE = ((ImageView)paramView.findViewById(2131828552));
    this.tkF = ((ImageView)paramView.findViewById(2131828555));
    this.tlE = ((ImageView)paramView.findViewById(2131828601));
    this.tlz = paramView.findViewById(2131828599);
    this.tlA = paramView.findViewById(2131828598);
    this.tlB = paramView.findViewById(2131828603);
    this.jWo = paramView.findViewById(2131824363);
    if (this.tlF)
    {
      this.tkB.setVisibility(0);
      AppMethodBeat.o(2087);
      return;
    }
    this.tkB.setVisibility(8);
    AppMethodBeat.o(2087);
  }
  
  public final void eq(View paramView)
  {
    AppMethodBeat.i(2095);
    if ((com.tencent.mm.plugin.topstory.a.g.cIw()) && (paramView.getId() == this.kgH.getId())) {
      this.tim.cJh().tjU = true;
    }
    super.eq(paramView);
    AppMethodBeat.o(2095);
  }
  
  public final void er(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(2096);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.kgH.getId())
    {
      if ((this.tfm != null) && (!bo.isNullOrNil(this.tfm.uJr)))
      {
        paramView = this.tfm.uJr;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.bq.d.b(this.tim.bMN(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.tim.cJh().tjS)
        {
          this.tlw.cJI();
          this.tim.cJh().crn();
        }
        this.tim.cJd().g(this.tfm);
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tim.cJf(), this.tfm, cJb(), 1, "");
        AppMethodBeat.o(2096);
      }
    }
    else
    {
      if (paramView.getId() == this.lFN.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.kS(8);
        a(this.tim, this.tim.bMN(), this.tlw, cJb());
        AppMethodBeat.o(2096);
        return;
      }
      if (paramView.getId() == this.tli.getId())
      {
        this.tim.ah(this.tli, cJb());
        AppMethodBeat.o(2096);
        return;
      }
      if ((paramView.getId() == this.naO.getId()) || (paramView.getId() == this.naP.getId()))
      {
        this.tim.cJc().tjk = true;
        this.tim.cJh().stopPlay();
        this.tlw.cJC();
        paramView = (ccp)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.g.a(this.tim.cJf());
        ((ckw)localObject1).xUt = UUID.randomUUID().toString();
        ((ckw)localObject1).xUK = this.tfm.xVa;
        ((ckw)localObject1).xUO = paramView.xNd;
        ((ckw)localObject1).xUP = null;
        ((ckw)localObject1).xUQ = paramView;
        ((ckw)localObject1).efg = this.tim.DP();
        ((ckw)localObject1).xUR = this.tim.cJc().tjk;
        localObject2 = ((ckw)localObject1).uIO.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          up localup = (up)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localup.key)) {
            localup.wMN = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new up();
        ((up)localObject2).key = "show_tag_list";
        ((up)localObject2).wMN = paramView.id;
        ((ckw)localObject1).uIO.add(localObject2);
      }
      aa.a(this.tim.bMN(), (ckw)localObject1);
      com.tencent.mm.plugin.websearch.api.a.a.kS(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tim.cJf(), this.tfm, cJb(), 4, paramView.cyA + ":" + paramView.id);
      AppMethodBeat.o(2096);
      return;
      if ((paramView.getId() == this.tiu.getId()) || (paramView.getId() == this.qzL.getId()) || (paramView.getId() == this.tkG.getId()))
      {
        if ((this.tfm != null) && (!bo.isNullOrNil(this.tfm.puE)))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.tfm.puE);
          com.tencent.mm.bq.d.b(this.tim.bMN().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tim.cJf(), this.tfm, cJb(), 3, "");
          AppMethodBeat.o(2096);
        }
      }
      else if (paramView.getId() == this.tlx.getId())
      {
        this.tim.a(this.tfm);
        if (this.tfm.xVp)
        {
          this.tly.setImageResource(2131232125);
          this.tkw.setTextColor(this.tkw.getResources().getColor(2131690603));
          AppMethodBeat.o(2096);
          return;
        }
        this.tly.setImageResource(2131232126);
        this.tkw.setTextColor(this.tkw.getResources().getColor(2131690709));
      }
      AppMethodBeat.o(2096);
      return;
      i = 0;
    }
  }
  
  public final View getWowView()
  {
    return this.tlx;
  }
  
  public final void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(2093);
    super.mA(paramBoolean);
    cKu();
    this.tim.GA(cJb());
    if (this.tlw.Q(paramBoolean, false))
    {
      cJa();
      super.cIZ();
    }
    AppMethodBeat.o(2093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */