package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMGridPaper$5$1
  implements Runnable
{
  MMGridPaper$5$1(MMGridPaper.5 param5, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(106620);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.zkd.zkb.zjD.getChildAt(this.zkd.zkb.zjD.getChildCount() - 1);
    int i = this.zkc - (this.zkd.zkb.zjD.getChildCount() >> 1);
    ab.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(this.zkd.zkb.zjD.getChildCount() - 1), Integer.valueOf(i) });
    this.zkd.zkb.zjD.removeViewAt(this.zkd.zkb.zjD.getChildCount() - 1);
    localMMGridPaperGridView.a(i, this.zkd.zkb.mNumRows, this.zkd.zkb.mNumColumns, this.zkd.zkb.zjE);
    this.zkd.zkb.zjD.addView(localMMGridPaperGridView, 0);
    i = this.zkd.zkb.zjD.getChildCount();
    this.zkd.zkb.zjD.OF(i >> 1);
    MMGridPaper.a(this.zkd.zkb, -1);
    AppMethodBeat.o(106620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.5.1
 * JD-Core Version:    0.7.0.1
 */