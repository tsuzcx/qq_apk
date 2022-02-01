package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class h
  extends RecyclerView.v
  implements a
{
  public eiw GjH;
  public b Gmr;
  private boolean Gms;
  protected View.OnClickListener ko = new h.1(this);
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.Gmr = paramb;
    fU(paramView);
  }
  
  protected final void a(b paramb, Context paramContext, f paramf, int paramInt)
  {
    eiw localeiw = paramb.fyO().acd(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.fyD(), localeiw, paramInt, 5, "");
    if (localeiw != null)
    {
      if (this.Gmr.fyF().dFG())
      {
        this.Gmr.fyF().cXa();
        this.Gms = true;
      }
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      locale.HLX = new h.2(this);
      locale.HLY = new h.3(this, paramf, paramContext, localeiw, paramb, paramInt);
      locale.PGl = new h.4(this);
      locale.dGm();
    }
  }
  
  public final void d(eiw parameiw)
  {
    this.GjH = parameiw;
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { parameiw.title });
    fzj();
  }
  
  public void fU(View paramView) {}
  
  protected void fV(View paramView)
  {
    if (this.Gmr.fyH() != fyz())
    {
      this.Gmr.fyB().GnS = 2;
      this.Gmr.abU(fyz());
      com.tencent.mm.plugin.websearch.api.a.a.pl(4);
      this.Gmr.fyB().k(this.GjH);
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 2, "");
    }
    do
    {
      return;
      fW(paramView);
    } while (!fzi());
    fyy();
    this.Gmr.fyy();
    fyx();
    this.Gmr.fyx();
  }
  
  public void fW(View paramView) {}
  
  public void fyx()
  {
    this.Gmr.fyx();
  }
  
  public void fyy()
  {
    this.Gmr.fyy();
  }
  
  public int fyz()
  {
    return lR() - this.Gmr.fyK().getHeadersCount();
  }
  
  public boolean fzi()
  {
    return false;
  }
  
  public abstract void fzj();
  
  public abstract f fzk();
  
  public abstract View getWowView();
  
  public void wu(boolean paramBoolean)
  {
    this.Gmr.a(this.GjH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */