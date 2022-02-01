package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.au.a;

final class ComposeUI$1
  implements au.a
{
  ComposeUI$1(ComposeUI paramComposeUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(122892);
    this.vXa.enableOptionMenu(ComposeUI.a(this.vXa, true));
    AppMethodBeat.o(122892);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.1
 * JD-Core Version:    0.7.0.1
 */