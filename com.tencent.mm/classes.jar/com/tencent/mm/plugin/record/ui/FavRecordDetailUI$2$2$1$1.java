package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class FavRecordDetailUI$2$2$1$1
  implements Runnable
{
  FavRecordDetailUI$2$2$1$1(FavRecordDetailUI.2.2.1 param1, p paramp) {}
  
  public final void run()
  {
    this.kfC.dismiss();
    y.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavRecordDetailUI.a(this.ntI.ntH.ntG.ntD)) });
    this.ntI.ntH.ntG.ntD.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2.1.1
 * JD-Core Version:    0.7.0.1
 */