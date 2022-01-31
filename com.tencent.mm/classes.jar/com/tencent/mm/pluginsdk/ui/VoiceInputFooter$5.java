package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputFooter$5
  implements ChatFooterPanel.a
{
  VoiceInputFooter$5(VoiceInputFooter paramVoiceInputFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(27557);
    VoiceInputFooter.e(this.vSl).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    VoiceInputFooter.e(this.vSl).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(27557);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(27558);
    try
    {
      VoiceInputFooter.e(this.vSl).avk(paramString);
      AppMethodBeat.o(27558);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.VoiceInputFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(27558);
    }
  }
  
  public final void bag() {}
  
  public final void fT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter.5
 * JD-Core Version:    0.7.0.1
 */