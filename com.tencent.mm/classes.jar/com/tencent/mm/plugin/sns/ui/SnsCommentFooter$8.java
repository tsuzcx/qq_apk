package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$8
  implements ChatFooterPanel.a
{
  SnsCommentFooter$8(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void append(String paramString)
  {
    try
    {
      SnsCommentFooter.d(this.oXQ).aex(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsCommentFooter", paramString, "", new Object[0]);
    }
  }
  
  public final void asj()
  {
    if ((SnsCommentFooter.d(this.oXQ) == null) || (SnsCommentFooter.d(this.oXQ).getInputConnection() == null)) {
      return;
    }
    SnsCommentFooter.d(this.oXQ).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    SnsCommentFooter.d(this.oXQ).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
  }
  
  public final void bgv() {}
  
  public final void hp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.8
 * JD-Core Version:    0.7.0.1
 */