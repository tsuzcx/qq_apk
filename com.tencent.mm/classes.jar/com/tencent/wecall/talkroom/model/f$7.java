package com.tencent.wecall.talkroom.model;

import java.util.TimerTask;

final class f$7
  extends TimerTask
{
  f$7(f paramf) {}
  
  public final void run()
  {
    if (!this.xeA.xev)
    {
      f.a(this.xeA, f.n(this.xeA) + 1);
      if (f.o(this.xeA)) {
        f.b(this.xeA, f.p(this.xeA) + 1);
      }
      if ((f.q(this.xeA) == 3) || (f.q(this.xeA) == 2))
      {
        f.c(this.xeA, f.r(this.xeA) + 1);
        this.xeA.xdZ.qdI = f.r(this.xeA);
      }
      this.xeA.xdZ.xfs = (f.n(this.xeA) * 1000);
      this.xeA.xdZ.qdH = f.n(this.xeA);
    }
    if (this.xeA.xdE != null)
    {
      f.f localf = this.xeA.xdE;
      boolean bool = this.xeA.xev;
      f.n(this.xeA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.7
 * JD-Core Version:    0.7.0.1
 */