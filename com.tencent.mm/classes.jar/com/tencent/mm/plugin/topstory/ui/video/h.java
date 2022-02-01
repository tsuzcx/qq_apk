package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class h
  extends RecyclerView.v
  implements a
{
  public foh TIW;
  public b TLM;
  private boolean TLN;
  protected View.OnClickListener dpY = new h.1(this);
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.TLM = paramb;
    ko(paramView);
  }
  
  public void FD(boolean paramBoolean)
  {
    this.TLM.a(this.TIW);
  }
  
  protected final void a(b paramb, Context paramContext, f paramf, int paramInt)
  {
    foh localfoh = paramb.hNK().apc(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.hNz(), localfoh, paramInt, 5, "");
    if (localfoh != null)
    {
      if (this.TLM.hNB().fjy())
      {
        this.TLM.hNB().bck();
        this.TLN = true;
      }
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
      localf.Vtg = new h.2(this);
      localf.GAC = new h.3(this, paramf, paramContext, localfoh, paramb, paramInt);
      localf.aeLi = new h.4(this);
      localf.dDn();
    }
  }
  
  public final void d(foh paramfoh)
  {
    this.TIW = paramfoh;
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramfoh.title });
    hOh();
  }
  
  public abstract View getWowView();
  
  public void hNt()
  {
    this.TLM.hNt();
  }
  
  public void hNu()
  {
    this.TLM.hNu();
  }
  
  public int hNv()
  {
    return KJ() - this.TLM.hNG().hNP();
  }
  
  public boolean hOg()
  {
    return false;
  }
  
  public abstract void hOh();
  
  public abstract f hOi();
  
  public void ko(View paramView) {}
  
  protected void kp(View paramView)
  {
    if (this.TLM.hND() != hNv())
    {
      this.TLM.hNx().TNo = 2;
      this.TLM.aoT(hNv());
      com.tencent.mm.plugin.websearch.api.a.a.rG(4);
      this.TLM.hNx().k(this.TIW);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLM.hNz(), this.TIW, hNv(), 2, "");
    }
    do
    {
      return;
      kq(paramView);
    } while (!hOg());
    hNu();
    this.TLM.hNu();
    hNt();
    this.TLM.hNt();
  }
  
  public void kq(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */