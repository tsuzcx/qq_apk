package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;

final class MPSmileyFooter$4
  implements ChatFooterPanel.a
{
  MPSmileyFooter$4(MPSmileyFooter paramMPSmileyFooter) {}
  
  public final void aWL() {}
  
  public final void aWM()
  {
    AppMethodBeat.i(82247);
    MPSmileyFooter.c(this.Xql).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    MPSmileyFooter.c(this.Xql).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(82247);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(82248);
    try
    {
      MPSmileyFooter.c(this.Xql).bDt(paramString);
      AppMethodBeat.o(82248);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(82248);
    }
  }
  
  public final void fp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter.4
 * JD-Core Version:    0.7.0.1
 */