package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.y;

final class MMGridPaper$5$1
  implements Runnable
{
  MMGridPaper$5$1(MMGridPaper.5 param5, int paramInt) {}
  
  public final void run()
  {
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.uVK.uVI.uVi.getChildAt(this.uVK.uVI.uVi.getChildCount() - 1);
    int i = this.uVJ - (this.uVK.uVI.uVi.getChildCount() >> 1);
    y.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(this.uVK.uVI.uVi.getChildCount() - 1), Integer.valueOf(i) });
    this.uVK.uVI.uVi.removeViewAt(this.uVK.uVI.uVi.getChildCount() - 1);
    localMMGridPaperGridView.a(i, this.uVK.uVI.dtu, this.uVK.uVI.mNumColumns, this.uVK.uVI.uVj);
    this.uVK.uVI.uVi.addView(localMMGridPaperGridView, 0);
    i = this.uVK.uVI.uVi.getChildCount();
    this.uVK.uVI.uVi.Go(i >> 1);
    MMGridPaper.a(this.uVK.uVI, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.5.1
 * JD-Core Version:    0.7.0.1
 */