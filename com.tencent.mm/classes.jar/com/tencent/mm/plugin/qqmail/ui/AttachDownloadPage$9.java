package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.Map;

final class AttachDownloadPage$9
  extends v.a
{
  AttachDownloadPage$9(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final void onComplete() {}
  
  public final void onError(int paramInt, String paramString)
  {
    AttachDownloadPage.a(this.nfL, 4);
    if (AttachDownloadPage.m(this.nfL) < 5)
    {
      AttachDownloadPage.n(this.nfL);
      AttachDownloadPage.f(this.nfL);
      return;
    }
    AttachDownloadPage.d(this.nfL);
  }
  
  public final void onProgress(int paramInt)
  {
    y.d("MicroMsg.AttachDownloadPage", "download progress : " + paramInt);
    AttachDownloadPage.j(this.nfL);
    AttachDownloadPage.a(this.nfL, 1);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    e.f(AttachDownloadPage.k(this.nfL), AttachDownloadPage.l(this.nfL) + ".temp", AttachDownloadPage.l(this.nfL));
    AttachDownloadPage.a(this.nfL, 3);
    Toast.makeText(this.nfL, this.nfL.getString(b.j.download_success) + " : " + AttachDownloadPage.a(this.nfL), 5000).show();
    AttachDownloadPage.d(this.nfL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.9
 * JD-Core Version:    0.7.0.1
 */