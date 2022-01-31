package com.tencent.mm.pluginsdk.model.app;

public final class an
  implements am
{
  public volatile boolean bRf;
  public volatile boolean edU;
  public volatile boolean ggq;
  public volatile boolean ggr;
  an.a rVd;
  
  public an(an.a parama)
  {
    this.rVd = parama;
  }
  
  public final void cW(boolean paramBoolean)
  {
    this.edU = true;
    this.ggq = paramBoolean;
    if ((this.ggr) && (this.rVd != null)) {
      this.rVd.q(this.bRf, paramBoolean);
    }
  }
  
  public final void cX(boolean paramBoolean)
  {
    this.bRf = paramBoolean;
    this.ggr = true;
    if ((this.edU) && (this.rVd != null)) {
      this.rVd.q(paramBoolean, this.ggq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an
 * JD-Core Version:    0.7.0.1
 */