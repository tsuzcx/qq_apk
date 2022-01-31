package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsUploadSayFooter$4
  implements ChatFooterPanel.a
{
  SnsUploadSayFooter$4(SnsUploadSayFooter paramSnsUploadSayFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(39719);
    SnsUploadSayFooter.c(this.sbF).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    SnsUploadSayFooter.c(this.sbF).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(39719);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(39720);
    try
    {
      SnsUploadSayFooter.c(this.sbF).avk(paramString);
      AppMethodBeat.o(39720);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(39720);
    }
  }
  
  public final void bag() {}
  
  public final void fT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.4
 * JD-Core Version:    0.7.0.1
 */