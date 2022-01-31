package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class SnsUploadSayFooter$5
  implements Runnable
{
  SnsUploadSayFooter$5(SnsUploadSayFooter paramSnsUploadSayFooter) {}
  
  public final void run()
  {
    if ((SnsUploadSayFooter.d(this.pjd)) && (SnsUploadSayFooter.e(this.pjd) != null))
    {
      SnsUploadSayFooter.e(this.pjd).setVisibility(0);
      SnsUploadSayFooter.f(this.pjd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.5
 * JD-Core Version:    0.7.0.1
 */