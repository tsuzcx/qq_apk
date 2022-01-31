package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bk;

final class SnsTimeLineUI$c
{
  public boolean axD = true;
  public String pgc = "";
  public long pgd;
  public int pge;
  public int pgf;
  public long pgg;
  public long pgh;
  public int pgi;
  public long pgj;
  public int pgk;
  public long pgl;
  public int scene;
  
  private SnsTimeLineUI$c(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  final void reset()
  {
    this.scene = 0;
    this.pgd = 0L;
    this.pge = -1;
    this.pgf = 0;
    this.pgg = 0L;
    this.pgh = 0L;
    this.pgi = 0;
    this.pgj = 0L;
    this.pgk = 0;
    this.pgl = 0L;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.pgc).append(",").append(this.scene).append(",").append(this.pgd).append(",").append(this.pge).append(",").append(this.pgf).append(",").append(this.pgg).append(",").append(this.pgh).append(",").append(this.pgi).append(",").append(this.pgj).append(",").append(this.pgk).append(",").append(this.pgl);
    return localStringBuilder.toString();
  }
  
  public final void yQ(int paramInt)
  {
    if (!this.axD) {
      return;
    }
    this.pgf = paramInt;
    this.pgg = bk.UY();
  }
  
  public final void yR(int paramInt)
  {
    if (!this.axD) {
      return;
    }
    reset();
    this.scene = 2;
    this.pgh = bk.UY();
    this.pgi = paramInt;
  }
  
  public final void yS(int paramInt)
  {
    if (!this.axD) {
      return;
    }
    reset();
    this.scene = 3;
    this.pgj = bk.UY();
    this.pgl = 0L;
    this.pgk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.c
 * JD-Core Version:    0.7.0.1
 */