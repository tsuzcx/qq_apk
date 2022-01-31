package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.sdk.platformtools.y;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    y.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
    this.ntQ.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h.2
 * JD-Core Version:    0.7.0.1
 */