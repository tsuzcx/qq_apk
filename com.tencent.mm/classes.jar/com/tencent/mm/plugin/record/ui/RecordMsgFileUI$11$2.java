package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

final class RecordMsgFileUI$11$2
  implements n.d
{
  RecordMsgFileUI$11$2(RecordMsgFileUI.11 param11) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24264);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24264);
      return;
      if (RecordMsgFileUI.c(this.pZQ.pZN) == 8)
      {
        paramMenuItem = n.c(RecordMsgFileUI.a(this.pZQ.pZN), RecordMsgFileUI.b(this.pZQ.pZN));
        if (!e.cN(paramMenuItem))
        {
          ab.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
          Toast.makeText(this.pZQ.pZN, this.pZQ.pZN.getString(2131299824), 1).show();
          AppMethodBeat.o(24264);
          return;
        }
        if (new File(paramMenuItem).length() > 10485760L)
        {
          ab.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
          Toast.makeText(this.pZQ.pZN, this.pZQ.pZN.getString(2131299825), 1).show();
          AppMethodBeat.o(24264);
          return;
        }
      }
      RecordMsgFileUI.h(this.pZQ.pZN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11.2
 * JD-Core Version:    0.7.0.1
 */