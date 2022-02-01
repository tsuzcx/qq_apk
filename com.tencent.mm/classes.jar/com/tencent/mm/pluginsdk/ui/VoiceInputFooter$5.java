package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputFooter$5
  implements ChatFooterPanel.a
{
  VoiceInputFooter$5(VoiceInputFooter paramVoiceInputFooter) {}
  
  public final void aWL() {}
  
  public final void aWM()
  {
    AppMethodBeat.i(31259);
    VoiceInputFooter.e(this.Yaj).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    VoiceInputFooter.e(this.Yaj).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(31259);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(31260);
    try
    {
      VoiceInputFooter.e(this.Yaj).bDt(paramString);
      AppMethodBeat.o(31260);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.VoiceInputFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(31260);
    }
  }
  
  public final void fp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter.5
 * JD-Core Version:    0.7.0.1
 */