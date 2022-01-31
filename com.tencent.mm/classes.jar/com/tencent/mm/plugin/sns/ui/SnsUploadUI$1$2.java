package com.tencent.mm.plugin.sns.ui;

import android.view.View;

final class SnsUploadUI$1$2
  implements Runnable
{
  SnsUploadUI$1$2(SnsUploadUI.1 param1) {}
  
  public final void run()
  {
    SnsUploadSayFooter localSnsUploadSayFooter = SnsUploadUI.a(this.pjq.pjp);
    if (!localSnsUploadSayFooter.bJX()) {
      localSnsUploadSayFooter.setVisibility(8);
    }
    SnsUploadUI.a(this.pjq.pjp).postInvalidate();
    SnsUploadUI.c(this.pjq.pjp).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.1.2
 * JD-Core Version:    0.7.0.1
 */