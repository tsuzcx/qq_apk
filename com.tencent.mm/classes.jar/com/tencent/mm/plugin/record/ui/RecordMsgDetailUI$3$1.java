package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class RecordMsgDetailUI$3$1
  implements n.c
{
  RecordMsgDetailUI$3$1(RecordMsgDetailUI.3 param3) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(24236);
    paraml.e(0, this.pZI.pZH.getString(2131299826));
    if (this.pZI.pZH.getIntent().getIntExtra("from_scene", 0) == 0) {
      paraml.e(2, this.pZI.pZH.getString(2131302102));
    }
    AppMethodBeat.o(24236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3.1
 * JD-Core Version:    0.7.0.1
 */