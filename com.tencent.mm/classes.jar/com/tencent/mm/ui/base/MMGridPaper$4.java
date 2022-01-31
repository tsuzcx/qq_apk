package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMGridPaper$4
  implements MMFlipper.a
{
  MMGridPaper$4(MMGridPaper paramMMGridPaper) {}
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106619);
    ab.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.zkb.zjF), Integer.valueOf(paramInt2), Integer.valueOf(this.zkb.zjG), Boolean.valueOf(this.zkb.zjU), Boolean.valueOf(this.zkb.zjT) });
    if (((Math.abs(this.zkb.zjG - paramInt2) < 50) && (Math.abs(this.zkb.zjF - paramInt1) < 50)) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      ab.d("MicroMsg.MMGridPaper", "match width height limit, return");
      AppMethodBeat.o(106619);
      return;
    }
    if ((this.zkb.zjU) && (this.zkb.zjF > paramInt1) && (!this.zkb.zjT))
    {
      ab.d("MicroMsg.MMGridPaper", "match ori limit, return");
      AppMethodBeat.o(106619);
      return;
    }
    ab.v("MicroMsg.MMGridPaper", "onMeasure: match");
    ab.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(this.zkb.zjX) });
    this.zkb.zjT = false;
    if (!this.zkb.zjX)
    {
      this.zkb.zjG = paramInt2;
      this.zkb.zjF = paramInt1;
    }
    this.zkb.refresh();
    AppMethodBeat.o(106619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.4
 * JD-Core Version:    0.7.0.1
 */