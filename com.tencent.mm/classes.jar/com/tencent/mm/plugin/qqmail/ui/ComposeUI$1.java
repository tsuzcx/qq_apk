package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ComposeUI$1
  implements ap.a
{
  ComposeUI$1(ComposeUI paramComposeUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(68167);
    this.pLX.enableOptionMenu(ComposeUI.a(this.pLX, true));
    AppMethodBeat.o(68167);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.1
 * JD-Core Version:    0.7.0.1
 */