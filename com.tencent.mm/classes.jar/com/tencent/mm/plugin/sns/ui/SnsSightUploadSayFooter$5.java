package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsSightUploadSayFooter$5
  implements ChatFooterPanel.a
{
  SnsSightUploadSayFooter$5(SnsSightUploadSayFooter paramSnsSightUploadSayFooter) {}
  
  public final void append(String paramString)
  {
    try
    {
      SnsSightUploadSayFooter.b(this.pds).aex(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", paramString, "", new Object[0]);
    }
  }
  
  public final void asj()
  {
    SnsSightUploadSayFooter.b(this.pds).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    SnsSightUploadSayFooter.b(this.pds).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
  }
  
  public final void bgv() {}
  
  public final void hp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.5
 * JD-Core Version:    0.7.0.1
 */