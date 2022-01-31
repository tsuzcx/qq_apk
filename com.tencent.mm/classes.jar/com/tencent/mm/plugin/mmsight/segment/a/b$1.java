package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements c
{
  b$1(b paramb) {}
  
  public final void Es()
  {
    AppMethodBeat.i(3709);
    if (this.oNa.fqY) {
      this.oNa.oMS.zi(this.oNa.oMU);
    }
    AppMethodBeat.o(3709);
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(3712);
    this.oNa.oMT = paramInt3;
    if (this.oNa.oMX != null) {
      this.oNa.oMX.Z(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(3712);
  }
  
  public final void boW()
  {
    AppMethodBeat.i(3711);
    ab.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { this.oNa.oMZ });
    if (this.oNa.oMZ != null)
    {
      this.oNa.oMZ.bX(this.oNa.oMS);
      AppMethodBeat.o(3711);
      return;
    }
    if (this.oNa.isStart) {
      this.oNa.oMS.start();
    }
    AppMethodBeat.o(3711);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(3708);
    if (this.oNa.oMY != null) {
      this.oNa.oMY.bW(this.oNa.oMS);
    }
    if (this.oNa.isStart) {
      this.oNa.oMS.start();
    }
    this.oNa.Pz = true;
    AppMethodBeat.o(3708);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3710);
    if (this.oNa.oMW != null) {
      this.oNa.oMW.eH(paramInt1, paramInt2);
    }
    AppMethodBeat.o(3710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b.1
 * JD-Core Version:    0.7.0.1
 */