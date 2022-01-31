package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.y;

final class MMGridPaper$5$2
  implements Runnable
{
  MMGridPaper$5$2(MMGridPaper.5 param5, int paramInt) {}
  
  public final void run()
  {
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.uVK.uVI.uVi.getChildAt(0);
    int i = this.uVJ + (this.uVK.uVI.uVi.getChildCount() >> 1);
    y.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
    this.uVK.uVI.uVi.removeViewAt(0);
    localMMGridPaperGridView.a(i, this.uVK.uVI.dtu, this.uVK.uVI.mNumColumns, this.uVK.uVI.uVj);
    this.uVK.uVI.uVi.addView(localMMGridPaperGridView);
    i = this.uVK.uVI.uVi.getChildCount();
    this.uVK.uVI.uVi.Go(i >> 1);
    MMGridPaper.a(this.uVK.uVI, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.5.2
 * JD-Core Version:    0.7.0.1
 */