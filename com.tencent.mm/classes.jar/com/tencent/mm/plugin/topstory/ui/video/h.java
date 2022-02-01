package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class h
  extends RecyclerView.v
  implements a
{
  public esy MWs;
  public b MZd;
  private boolean MZe;
  protected View.OnClickListener bwV = new h.1(this);
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.MZd = paramb;
    hd(paramView);
  }
  
  public void Ah(boolean paramBoolean)
  {
    this.MZd.a(this.MWs);
  }
  
  protected final void a(b paramb, Context paramContext, f paramf, int paramInt)
  {
    esy localesy = paramb.gqL().ajJ(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.gqA(), localesy, paramInt, 5, "");
    if (localesy != null)
    {
      if (this.MZd.gqC().ehu())
      {
        this.MZd.gqC().dmi();
        this.MZe = true;
      }
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      locale.ODT = new h.2(this);
      locale.ODU = new h.3(this, paramf, paramContext, localesy, paramb, paramInt);
      locale.XbB = new h.4(this);
      locale.eik();
    }
  }
  
  public final void d(esy paramesy)
  {
    this.MWs = paramesy;
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramesy.title });
    gri();
  }
  
  public abstract View getWowView();
  
  public void gqu()
  {
    this.MZd.gqu();
  }
  
  public void gqv()
  {
    this.MZd.gqv();
  }
  
  public int gqw()
  {
    return md() - this.MZd.gqH().gqR();
  }
  
  public boolean grh()
  {
    return false;
  }
  
  public abstract void gri();
  
  public abstract f grj();
  
  public void hd(View paramView) {}
  
  protected void he(View paramView)
  {
    if (this.MZd.gqE() != gqw())
    {
      this.MZd.gqy().NaF = 2;
      this.MZd.ajA(gqw());
      com.tencent.mm.plugin.websearch.api.a.a.rE(4);
      this.MZd.gqy().k(this.MWs);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MZd.gqA(), this.MWs, gqw(), 2, "");
    }
    do
    {
      return;
      hf(paramView);
    } while (!grh());
    gqv();
    this.MZd.gqv();
    gqu();
    this.MZd.gqu();
  }
  
  public void hf(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */