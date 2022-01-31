package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;

final class AttachDownloadPage$3
  implements View.OnClickListener
{
  AttachDownloadPage$3(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final void onClick(View paramView)
  {
    AttachDownloadPage.a(this.nfL, 2);
    ac.btF().cancel(AttachDownloadPage.b(this.nfL));
    AttachDownloadPage.c(this.nfL);
    AttachDownloadPage.d(this.nfL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.3
 * JD-Core Version:    0.7.0.1
 */