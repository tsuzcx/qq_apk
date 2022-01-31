package com.tencent.mm.ui.tools;

import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.b;

final class ShareImgUI$a
  implements Runnable
{
  private Uri mUri;
  private ShareImgUI.c weQ;
  
  public ShareImgUI$a(ShareImgUI paramShareImgUI, Uri paramUri, ShareImgUI.c paramc)
  {
    this.mUri = paramUri;
    this.weQ = paramc;
  }
  
  public final void run()
  {
    this.weH.filePath = ShareImgUI.a(this.weH, this.mUri);
    if ((bk.bl(this.weH.filePath)) || (!new b(this.weH.filePath).exists())) {
      if (ShareImgUI.aem(this.weH.getContentResolver().getType(this.mUri)) != 3) {
        break label110;
      }
    }
    label110:
    for (this.weH.filePath = d.a(this.weH.getContentResolver(), this.mUri);; this.weH.filePath = d.a(this.weH.getContentResolver(), this.mUri, 1))
    {
      if (this.weQ != null) {
        this.weQ.cIP();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.a
 * JD-Core Version:    0.7.0.1
 */