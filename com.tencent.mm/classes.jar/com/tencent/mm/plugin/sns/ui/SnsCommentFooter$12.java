package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsCommentFooter$12
  implements ChatFooterPanel.a
{
  SnsCommentFooter$12(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void aDN() {}
  
  public final void aDO()
  {
    AppMethodBeat.i(98647);
    if (SnsCommentFooter.b(this.KQR) != null)
    {
      if (SnsCommentFooter.b(this.KQR).getInputConnection() == null)
      {
        AppMethodBeat.o(98647);
        return;
      }
      SnsCommentFooter.b(this.KQR).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      SnsCommentFooter.b(this.KQR).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(98647);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(98648);
    try
    {
      SnsCommentFooter.b(this.KQR).bBa(paramString);
      AppMethodBeat.o(98648);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SnsCommentFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(98648);
    }
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(98646);
    this.KQR.setToSendTextColor(paramBoolean);
    AppMethodBeat.o(98646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.12
 * JD-Core Version:    0.7.0.1
 */