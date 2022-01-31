package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class FavRecordDetailUI$2$2$1$1
  implements Runnable
{
  FavRecordDetailUI$2$2$1$1(FavRecordDetailUI.2.2.1 param1, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(24204);
    this.mAo.dismiss();
    ab.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavRecordDetailUI.a(this.pZq.pZp.pZo.pZl)) });
    this.pZq.pZp.pZo.pZl.finish();
    AppMethodBeat.o(24204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2.1.1
 * JD-Core Version:    0.7.0.1
 */