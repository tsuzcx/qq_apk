package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class MMGridPaper$5
  implements MMFlipper.b
{
  MMGridPaper$5(MMGridPaper paramMMGridPaper) {}
  
  public final void wS(int paramInt)
  {
    y.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uVI.uVp), Integer.valueOf(this.uVI.uVq), Integer.valueOf(this.uVI.uVr) });
    if ((paramInt <= this.uVI.uVp) && (this.uVI.uVp > 0)) {
      this.uVI.ntK.post(new MMGridPaper.5.1(this, paramInt));
    }
    for (;;)
    {
      this.uVI.uVn = paramInt;
      this.uVI.hxP.setSelectedDot(paramInt);
      return;
      if ((paramInt >= this.uVI.uVq) && (this.uVI.uVq < this.uVI.uVr - 1)) {
        this.uVI.ntK.post(new MMGridPaper.5.2(this, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.5
 * JD-Core Version:    0.7.0.1
 */