package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

public abstract class h
  extends RecyclerView.v
  implements a
{
  protected View.OnClickListener qaq = new h.1(this);
  public ckx tfm;
  public b tim;
  private boolean tin;
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.tim = paramb;
    ep(paramView);
  }
  
  protected final void a(b paramb, Context paramContext, f paramf, int paramInt)
  {
    ckx localckx = paramb.cJs().GI(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.cJf(), localckx, paramInt, 5, "");
    if (localckx != null)
    {
      if (this.tim.cJh().cKj())
      {
        this.tim.cJh().crn();
        this.tin = true;
      }
      d locald = new d(paramContext, 1, false);
      locald.sao = new h.2(this);
      locald.sap = new h.3(this, paramf, paramContext, localckx, paramb, paramInt);
      locald.AGQ = new h.4(this);
      locald.crd();
    }
  }
  
  public void cIZ()
  {
    this.tim.cIZ();
  }
  
  public boolean cJK()
  {
    return false;
  }
  
  public abstract void cJL();
  
  public abstract f cJM();
  
  public void cJa()
  {
    this.tim.cJa();
  }
  
  public int cJb()
  {
    return jN() - this.tim.cJm().getHeadersCount();
  }
  
  public final void d(ckx paramckx)
  {
    this.tfm = paramckx;
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramckx.title });
    cJL();
  }
  
  public void ep(View paramView) {}
  
  protected void eq(View paramView)
  {
    if (this.tim.cJk() != cJb())
    {
      this.tim.cJd().tjK = 2;
      this.tim.Gz(cJb());
      com.tencent.mm.plugin.websearch.api.a.a.kS(4);
      this.tim.cJd().g(this.tfm);
      ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tim.cJf(), this.tfm, cJb(), 2, "");
    }
    do
    {
      return;
      er(paramView);
    } while (!cJK());
    cJa();
    this.tim.cJa();
    cIZ();
    this.tim.cIZ();
  }
  
  public void er(View paramView) {}
  
  public abstract View getWowView();
  
  public void mA(boolean paramBoolean)
  {
    this.tim.cJq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */