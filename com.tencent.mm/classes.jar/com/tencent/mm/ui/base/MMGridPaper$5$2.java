package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMGridPaper$5$2
  implements Runnable
{
  MMGridPaper$5$2(MMGridPaper.5 param5, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(106621);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.zkd.zkb.zjD.getChildAt(0);
    int i = this.zkc + (this.zkd.zkb.zjD.getChildCount() >> 1);
    ab.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
    this.zkd.zkb.zjD.removeViewAt(0);
    localMMGridPaperGridView.a(i, this.zkd.zkb.mNumRows, this.zkd.zkb.mNumColumns, this.zkd.zkb.zjE);
    this.zkd.zkb.zjD.addView(localMMGridPaperGridView);
    i = this.zkd.zkb.zjD.getChildCount();
    this.zkd.zkb.zjD.OF(i >> 1);
    MMGridPaper.a(this.zkd.zkb, 1);
    AppMethodBeat.o(106621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.5.2
 * JD-Core Version:    0.7.0.1
 */