package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.d;

public abstract class h
  extends RecyclerView.v
  implements a
{
  public View.OnClickListener nuB = new h.1(this);
  public byg pDy;
  public b pEP;
  private boolean pEQ;
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.pEP = paramb;
    dm(paramView);
  }
  
  public final void a(b paramb, Context paramContext, f paramf, int paramInt)
  {
    byg localbyg = paramb.bNJ().Es(paramInt);
    if (localbyg != null)
    {
      if (this.pEP.bNx().bOu())
      {
        this.pEP.bNx().bFy();
        this.pEQ = true;
      }
      d locald = new d(paramContext, 1, false);
      locald.phH = new h.2(this);
      locald.phI = new h.3(this, paramf, paramContext, localbyg, paramb);
      locald.wmU = new h.4(this);
      locald.cfU();
    }
  }
  
  public final void a(byg parambyg)
  {
    this.pDy = parambyg;
    y.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { parambyg.title });
    bNY();
  }
  
  public boolean bNX()
  {
    return false;
  }
  
  public abstract void bNY();
  
  public abstract f bNZ();
  
  public void bNp()
  {
    this.pEP.bNp();
  }
  
  public void bNq()
  {
    this.pEP.bNq();
  }
  
  public int bNr()
  {
    return id() - this.pEP.bND().pEn.size();
  }
  
  public void dm(View paramView) {}
  
  public void dn(View paramView)
  {
    if (this.pEP.bNB() != bNr())
    {
      this.pEP.bNt().pGp = 2;
      this.pEP.zw(bNr());
      com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(4);
      this.pEP.bNt().c(this.pDy);
      ((com.tencent.mm.plugin.topstory.a.b)g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pEP.bNv(), this.pDy, bNr(), 2, "");
      return;
    }
    if (bNX())
    {
      bNq();
      this.pEP.bNq();
      bNp();
      this.pEP.bNp();
      return;
    }
    jdMethod_do(paramView);
  }
  
  public void jdMethod_do(View paramView) {}
  
  public void jJ(boolean paramBoolean)
  {
    this.pEP.bNH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */