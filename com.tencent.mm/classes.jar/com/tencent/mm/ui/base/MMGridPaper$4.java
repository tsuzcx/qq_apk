package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.y;

final class MMGridPaper$4
  implements MMFlipper.a
{
  MMGridPaper$4(MMGridPaper paramMMGridPaper) {}
  
  public final void dH(int paramInt1, int paramInt2)
  {
    y.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.uVI.uVk), Integer.valueOf(paramInt2), Integer.valueOf(this.uVI.uVl), Boolean.valueOf(this.uVI.uVz), Boolean.valueOf(this.uVI.uVy) });
    if (((Math.abs(this.uVI.uVl - paramInt2) < 50) && (Math.abs(this.uVI.uVk - paramInt1) < 50)) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      y.d("MicroMsg.MMGridPaper", "match width height limit, return");
      return;
    }
    if ((this.uVI.uVz) && (this.uVI.uVk > paramInt1) && (!this.uVI.uVy))
    {
      y.d("MicroMsg.MMGridPaper", "match ori limit, return");
      return;
    }
    y.v("MicroMsg.MMGridPaper", "onMeasure: match");
    y.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(this.uVI.uVE) });
    this.uVI.uVy = false;
    if (!this.uVI.uVE)
    {
      this.uVI.uVl = paramInt2;
      this.uVI.uVk = paramInt1;
    }
    this.uVI.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.4
 * JD-Core Version:    0.7.0.1
 */