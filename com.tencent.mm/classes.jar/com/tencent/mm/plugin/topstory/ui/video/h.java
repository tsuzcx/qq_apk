package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class h
  extends RecyclerView.w
  implements a
{
  public dpa BIY;
  public b BLL;
  private boolean BLM;
  protected View.OnClickListener km = new h.1(this);
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.BLL = paramb;
    fC(paramView);
  }
  
  protected final void a(b paramb, Context paramContext, f paramf, int paramInt)
  {
    dpa localdpa = paramb.ets().TN(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.etg(), localdpa, paramInt, 5, "");
    if (localdpa != null)
    {
      if (this.BLL.eti().eul())
      {
        this.BLL.eti().cyX();
        this.BLM = true;
      }
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      locale.LfS = new h.2(this);
      locale.LfT = new h.3(this, paramf, paramContext, localdpa, paramb, paramInt);
      locale.KtV = new h.4(this);
      locale.cPF();
    }
  }
  
  public final void d(dpa paramdpa)
  {
    this.BIY = paramdpa;
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramdpa.title });
    etN();
  }
  
  public boolean etM()
  {
    return false;
  }
  
  public abstract void etN();
  
  public abstract f etO();
  
  public void eta()
  {
    this.BLL.eta();
  }
  
  public void etb()
  {
    this.BLL.etb();
  }
  
  public int etc()
  {
    return lN() - this.BLL.eto().getHeadersCount();
  }
  
  public void fC(View paramView) {}
  
  protected void fD(View paramView)
  {
    if (this.BLL.etl() != etc())
    {
      this.BLL.ete().BNl = 2;
      this.BLL.TE(etc());
      com.tencent.mm.plugin.websearch.api.a.a.md(4);
      this.BLL.ete().j(this.BIY);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLL.etg(), this.BIY, etc(), 2, "");
    }
    do
    {
      return;
      fE(paramView);
    } while (!etM());
    etb();
    this.BLL.etb();
    eta();
    this.BLL.eta();
  }
  
  public void fE(View paramView) {}
  
  public abstract View getWowView();
  
  public void sQ(boolean paramBoolean)
  {
    this.BLL.a(this.BIY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */