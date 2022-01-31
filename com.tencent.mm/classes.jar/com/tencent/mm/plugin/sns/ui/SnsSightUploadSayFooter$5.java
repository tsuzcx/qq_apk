package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsSightUploadSayFooter$5
  implements ChatFooterPanel.a
{
  SnsSightUploadSayFooter$5(SnsSightUploadSayFooter paramSnsSightUploadSayFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(39289);
    SnsSightUploadSayFooter.b(this.rWa).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    SnsSightUploadSayFooter.b(this.rWa).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(39289);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(39290);
    try
    {
      SnsSightUploadSayFooter.b(this.rWa).avk(paramString);
      AppMethodBeat.o(39290);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(39290);
    }
  }
  
  public final void bag() {}
  
  public final void fT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.5
 * JD-Core Version:    0.7.0.1
 */