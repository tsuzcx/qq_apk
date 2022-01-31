package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Intent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.b.c;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeatTextView;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public View igy;
  public View jwo;
  public TextView kEq;
  public TextView kEr;
  public TextView nMe;
  public ImageView pEY;
  public com.tencent.mm.plugin.topstory.ui.video.f pHM;
  public MMNeatTextView pHO;
  public View pHP;
  public View pHQ;
  public View pHR;
  private boolean pHS;
  public View pHb;
  public View pHf;
  public TextView pHg;
  public View pHh;
  public View pHi;
  public ImageView pHj;
  public ImageView pHk;
  public View pHl;
  public FrameLayout pHq;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.pHS = paramBoolean;
  }
  
  public final boolean bNX()
  {
    return (this.pHR.getAlpha() != 0.0F) && (this.pHQ.getAlpha() != 0.0F);
  }
  
  public final void bNY()
  {
    if (!bk.bl(this.pDy.title))
    {
      this.pHO.R(this.pDy.title);
      this.pHO.setVisibility(0);
      this.pHO.requestLayout();
      this.pHO.setOnClickListener(this.nuB);
      this.nMe.setText(this.pDy.aWf);
      if (bk.bl(this.pDy.mSy)) {
        break label696;
      }
      this.pHl.setVisibility(0);
      label88:
      this.pEY.setOnClickListener(this.nuB);
      this.nMe.setOnClickListener(this.nuB);
      this.pHl.setOnClickListener(this.nuB);
      if (bk.bl(this.pDy.tOD)) {
        break label708;
      }
      com.tencent.mm.as.o.ON().a(this.pDy.tOD, this.pEY, com.tencent.mm.plugin.topstory.ui.d.pDJ);
      label154:
      if (!this.pEP.bNC()) {
        break label721;
      }
      this.jwo.setVisibility(0);
      this.jwo.setOnClickListener(this.nuB);
      label185:
      this.pHb.setTag(this.pDy);
      this.pHb.setOnClickListener(this.nuB);
      this.igy.setOnClickListener(this.nuB);
      this.pHP.setVisibility(0);
      this.pHQ.setVisibility(0);
      this.pHR.setVisibility(0);
      if (this.pHM == null)
      {
        this.pHM = new f(this.pEP.bfn(), this.pEP, this);
        this.pHq.removeAllViews();
        localObject = this.pHq;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.pHM;
        y.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.pEP.getVideoWidth()), Integer.valueOf(this.pEP.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.pEP.getVideoWidth(), this.pEP.getVideoHeight()));
      }
      this.pHM.a(this.pDy, bNr());
      if (this.pEP.bNB() == bNr()) {
        bNp();
      }
      this.pHg.setText(this.pDy.oBT);
      if ((!this.pHS) || (this.pDy.sXo.size() <= 0)) {
        break label754;
      }
      this.pHf.setVisibility(0);
      Object localObject = (bse)this.pDy.sXo.get(0);
      this.kEq.setTag(localObject);
      this.kEq.setText(((bse)localObject).bQZ);
      this.kEq.setVisibility(0);
      this.kEq.setOnClickListener(this.nuB);
      this.pHh.setVisibility(0);
      this.pHj.setVisibility(8);
      if (!bk.bl(((bse)localObject).bVO))
      {
        com.tencent.mm.as.o.ON().a(((bse)localObject).bVO, this.pHj, com.tencent.mm.plugin.topstory.ui.d.pDK);
        this.pHj.setVisibility(0);
      }
      if (this.pDy.sXo.size() <= 1) {
        break label733;
      }
      localObject = (bse)this.pDy.sXo.get(1);
      this.kEr.setTag(localObject);
      this.kEr.setText(((bse)localObject).bQZ);
      this.kEr.setOnClickListener(this.nuB);
      this.kEr.setVisibility(0);
      this.pHi.setVisibility(0);
      this.pHk.setVisibility(8);
      if (!bk.bl(((bse)localObject).bVO))
      {
        com.tencent.mm.as.o.ON().a(((bse)localObject).bVO, this.pHk, com.tencent.mm.plugin.topstory.ui.d.pDK);
        this.pHk.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.pEP.bNB() != bNr()) {
        bOC();
      }
      return;
      this.pHO.setVisibility(8);
      break;
      label696:
      this.pHl.setVisibility(8);
      break label88;
      label708:
      this.pEY.setImageResource(b.c.default_avatar);
      break label154;
      label721:
      this.jwo.setVisibility(8);
      break label185;
      label733:
      this.pHi.setVisibility(8);
      this.kEr.setVisibility(8);
      continue;
      label754:
      this.pHf.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f bNZ()
  {
    return this.pHM;
  }
  
  public final void bNp()
  {
    super.bNp();
    this.pHR.animate().cancel();
    this.pHQ.animate().cancel();
    this.pHR.animate().alpha(0.8F).setDuration(200L).setStartDelay(1800L).start();
    this.pHQ.animate().alpha(0.8F).setDuration(200L).setStartDelay(1800L).start();
  }
  
  public final void bNq()
  {
    super.bNq();
    this.pHR.animate().cancel();
    this.pHQ.animate().cancel();
    this.pHR.setAlpha(0.0F);
    this.pHQ.setAlpha(0.0F);
  }
  
  public final void bOC()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.pHR.animate().cancel();
    this.pHQ.animate().cancel();
    this.pHP.animate().cancel();
    this.pHP.setAlpha(0.8F);
    this.pHR.setAlpha(0.8F);
    this.pHQ.setAlpha(0.8F);
  }
  
  public final void bOD()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.pHR.animate().cancel();
    this.pHQ.animate().cancel();
    this.pHP.animate().cancel();
    this.pHP.setAlpha(0.0F);
    this.pHR.setAlpha(0.0F);
    this.pHQ.setAlpha(0.0F);
  }
  
  public final void dm(View paramView)
  {
    super.dm(paramView);
    this.pHq = ((FrameLayout)paramView.findViewById(b.d.video_view_container));
    this.pEY = ((ImageView)paramView.findViewById(b.d.source_iv));
    this.nMe = ((TextView)paramView.findViewById(b.d.source_tv));
    this.pHO = ((MMNeatTextView)paramView.findViewById(b.d.title_tv));
    this.pHl = paramView.findViewById(b.d.source_arrow);
    this.jwo = paramView.findViewById(b.d.share_iv);
    this.pHb = paramView.findViewById(b.d.feedback_iv);
    this.pHf = paramView.findViewById(b.d.bottom_tag_layout);
    this.pHg = ((TextView)paramView.findViewById(b.d.bottom_desc_tv));
    this.pHh = paramView.findViewById(b.d.tag_1_ll);
    this.pHi = paramView.findViewById(b.d.tag_2_ll);
    this.kEq = ((TextView)paramView.findViewById(b.d.tag_1_tv));
    this.kEr = ((TextView)paramView.findViewById(b.d.tag_2_tv));
    this.pHj = ((ImageView)paramView.findViewById(b.d.tag_1_icon));
    this.pHk = ((ImageView)paramView.findViewById(b.d.tag_2_icon));
    this.pHP = paramView.findViewById(b.d.body_mask);
    this.pHQ = paramView.findViewById(b.d.header_mask);
    this.pHR = paramView.findViewById(b.d.footer_mask);
    this.igy = paramView.findViewById(b.d.footer_layout);
    if (this.pHS)
    {
      this.pHf.setVisibility(0);
      return;
    }
    this.pHf.setVisibility(8);
  }
  
  protected final void dn(View paramView)
  {
    if ((com.tencent.mm.plugin.topstory.a.g.bNd()) && (paramView.getId() == this.pHO.getId())) {
      this.pEP.bNx().pGz = true;
    }
    super.dn(paramView);
  }
  
  public final void jdMethod_do(View paramView)
  {
    Object localObject;
    if (paramView.getId() == this.pHO.getId()) {
      if ((this.pDy != null) && (!bk.bl(this.pDy.qUh)))
      {
        paramView = this.pDy.qUh;
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramView);
        com.tencent.mm.br.d.b(this.pEP.bfn(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
        if (this.pEP.bNx().pGx)
        {
          this.pHM.bNV();
          this.pEP.bNx().bFy();
        }
        this.pEP.bNt().c(this.pDy);
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pEP.bNv(), this.pDy, bNr(), 1, "");
      }
    }
    do
    {
      return;
      if (paramView.getId() == this.jwo.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(8);
        a(this.pEP, this.pEP.bfn(), this.pHM, bNr());
        return;
      }
      if (paramView.getId() == this.pHb.getId())
      {
        this.pEP.zy(bNr());
        return;
      }
      if ((paramView.getId() == this.kEq.getId()) || (paramView.getId() == this.kEr.getId()))
      {
        this.pEP.bNs().pFL = true;
        this.pEP.bNx().stopPlay();
        this.pHM.bNO();
        paramView = (bse)paramView.getTag();
        localObject = com.tencent.mm.plugin.topstory.a.g.a(this.pEP.bNv());
        ((byf)localObject).tNY = UUID.randomUUID().toString();
        ((byf)localObject).tOk = this.pDy.tOx;
        ((byf)localObject).tOo = paramView.tIP;
        ((byf)localObject).tOp = null;
        ((byf)localObject).tOq = paramView;
        ((byf)localObject).dnJ = this.pEP.Bj();
        ((byf)localObject).tOr = this.pEP.bNs().pFL;
        aa.a(this.pEP.bfn(), (byf)localObject);
        com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(28);
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pEP.bNv(), this.pDy, bNr(), 4, paramView.bQZ + ":" + paramView.id);
        return;
      }
    } while (((paramView.getId() != this.pEY.getId()) && (paramView.getId() != this.nMe.getId()) && (paramView.getId() != this.pHl.getId())) || (this.pDy == null) || (bk.bl(this.pDy.mSy)));
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.pDy.mSy);
    com.tencent.mm.br.d.b(this.pEP.bfn().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
  }
  
  public final void jJ(boolean paramBoolean)
  {
    super.jJ(paramBoolean);
    bOD();
    this.pEP.zx(bNr());
    if (this.pHM.jI(paramBoolean))
    {
      bNq();
      bNp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */