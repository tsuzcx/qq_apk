package com.tencent.mm.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.b paramb1, b.c paramc, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(51968);
    this.ymu.a(this.yms, this.ymt);
    if (this.mFP != null)
    {
      this.mFP.post(new b.1.1(this));
      AppMethodBeat.o(51968);
      return;
    }
    this.ymt.onComplete();
    AppMethodBeat.o(51968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b.1
 * JD-Core Version:    0.7.0.1
 */