package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputFooter$5
  implements ChatFooterPanel.a
{
  VoiceInputFooter$5(VoiceInputFooter paramVoiceInputFooter) {}
  
  public final void append(String paramString)
  {
    try
    {
      VoiceInputFooter.e(this.sbe).aex(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.VoiceInputFooter", paramString, "", new Object[0]);
    }
  }
  
  public final void asj()
  {
    VoiceInputFooter.e(this.sbe).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    VoiceInputFooter.e(this.sbe).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
  }
  
  public final void bgv() {}
  
  public final void hp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter.5
 * JD-Core Version:    0.7.0.1
 */