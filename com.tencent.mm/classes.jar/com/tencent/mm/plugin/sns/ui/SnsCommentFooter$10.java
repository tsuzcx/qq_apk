package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$10
  implements ChatFooterPanel.a
{
  SnsCommentFooter$10(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(98648);
    try
    {
      SnsCommentFooter.b(this.xyx).aMd(paramString);
      AppMethodBeat.o(98648);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.SnsCommentFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(98648);
    }
  }
  
  public final void btF()
  {
    AppMethodBeat.i(98647);
    if (SnsCommentFooter.b(this.xyx) != null)
    {
      if (SnsCommentFooter.b(this.xyx).getInputConnection() == null)
      {
        AppMethodBeat.o(98647);
        return;
      }
      SnsCommentFooter.b(this.xyx).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      SnsCommentFooter.b(this.xyx).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(98647);
  }
  
  public final void cqY() {}
  
  public final void lf(boolean paramBoolean)
  {
    AppMethodBeat.i(98646);
    this.xyx.setToSendTextColor(paramBoolean);
    AppMethodBeat.o(98646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.10
 * JD-Core Version:    0.7.0.1
 */