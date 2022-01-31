package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsUploadSayFooter$4
  implements ChatFooterPanel.a
{
  SnsUploadSayFooter$4(SnsUploadSayFooter paramSnsUploadSayFooter) {}
  
  public final void append(String paramString)
  {
    try
    {
      SnsUploadSayFooter.c(this.pjd).aex(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramString, "", new Object[0]);
    }
  }
  
  public final void asj()
  {
    SnsUploadSayFooter.c(this.pjd).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    SnsUploadSayFooter.c(this.pjd).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
  }
  
  public final void bgv() {}
  
  public final void hp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.4
 * JD-Core Version:    0.7.0.1
 */