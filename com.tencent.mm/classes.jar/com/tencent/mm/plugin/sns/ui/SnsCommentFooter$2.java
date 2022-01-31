package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class SnsCommentFooter$2
  implements Runnable
{
  SnsCommentFooter$2(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void run()
  {
    if ((SnsCommentFooter.a(this.oXQ)) && (SnsCommentFooter.b(this.oXQ) != null))
    {
      SnsCommentFooter.b(this.oXQ).setVisibility(0);
      SnsCommentFooter.c(this.oXQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.2
 * JD-Core Version:    0.7.0.1
 */