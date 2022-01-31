package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class MMGridPaper$5
  implements MMFlipper.b
{
  MMGridPaper$5(MMGridPaper paramMMGridPaper) {}
  
  public final void CK(int paramInt)
  {
    AppMethodBeat.i(106622);
    ab.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zkb.zjK), Integer.valueOf(this.zkb.zjL), Integer.valueOf(this.zkb.zjM) });
    if ((paramInt <= this.zkb.zjK) && (this.zkb.zjK > 0)) {
      this.zkb.mHV.post(new MMGridPaper.5.1(this, paramInt));
    }
    for (;;)
    {
      this.zkb.zjI = paramInt;
      this.zkb.jpZ.setSelectedDot(paramInt);
      AppMethodBeat.o(106622);
      return;
      if ((paramInt >= this.zkb.zjL) && (this.zkb.zjL < this.zkb.zjM - 1)) {
        this.zkb.mHV.post(new MMGridPaper.5.2(this, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.5
 * JD-Core Version:    0.7.0.1
 */