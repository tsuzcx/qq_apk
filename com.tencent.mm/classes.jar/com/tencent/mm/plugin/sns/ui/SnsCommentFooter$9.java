package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$9
  implements ChatFooterPanel.a
{
  SnsCommentFooter$9(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(38887);
    if (SnsCommentFooter.b(this.rQk) != null)
    {
      if (SnsCommentFooter.b(this.rQk).getInputConnection() == null)
      {
        AppMethodBeat.o(38887);
        return;
      }
      SnsCommentFooter.b(this.rQk).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      SnsCommentFooter.b(this.rQk).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(38887);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(38888);
    try
    {
      SnsCommentFooter.b(this.rQk).avk(paramString);
      AppMethodBeat.o(38888);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsCommentFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(38888);
    }
  }
  
  public final void bag() {}
  
  public final void fT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.9
 * JD-Core Version:    0.7.0.1
 */