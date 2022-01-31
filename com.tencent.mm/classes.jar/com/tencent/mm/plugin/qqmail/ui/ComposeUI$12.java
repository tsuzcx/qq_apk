package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;

final class ComposeUI$12
  implements ap.a
{
  ComposeUI$12(ComposeUI paramComposeUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(68184);
    if ((this.pLX.pLA) && (ComposeUI.a(this.pLX, false)) && (ComposeUI.a(this.pLX) == 5))
    {
      ComposeUI.b(this.pLX);
      if (ComposeUI.c(this.pLX) != null) {
        ComposeUI.c(this.pLX).dismiss();
      }
      ComposeUI.a(this.pLX, t.a(this.pLX, this.pLX.getString(2131302124), 2000L));
    }
    AppMethodBeat.o(68184);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.12
 * JD-Core Version:    0.7.0.1
 */