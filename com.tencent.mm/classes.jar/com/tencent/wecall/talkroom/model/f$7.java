package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class f$7
  extends TimerTask
{
  f$7(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(127876);
    if (!this.BBh.BBc)
    {
      f.a(this.BBh, f.n(this.BBh) + 1);
      if (f.o(this.BBh)) {
        f.b(this.BBh, f.p(this.BBh) + 1);
      }
      if ((f.q(this.BBh) == 3) || (f.q(this.BBh) == 2))
      {
        f.c(this.BBh, f.r(this.BBh) + 1);
        this.BBh.BAG.tKv = f.r(this.BBh);
      }
      this.BBh.BAG.BBZ = (f.n(this.BBh) * 1000);
      this.BBh.BAG.tKu = f.n(this.BBh);
    }
    if (this.BBh.BAm != null) {
      f.n(this.BBh);
    }
    AppMethodBeat.o(127876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.7
 * JD-Core Version:    0.7.0.1
 */