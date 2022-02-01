package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class ReadMailUI$8
  implements MTimerHandler.CallBack
{
  ReadMailUI$8(ReadMailUI paramReadMailUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(267002);
    ReadMailUI.C(this.NpI);
    AppMethodBeat.o(267002);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.8
 * JD-Core Version:    0.7.0.1
 */