package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ShareScreenImgUI$1
  extends ah
{
  ShareScreenImgUI$1(ShareScreenImgUI paramShareScreenImgUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    ShareScreenImgUI.a(this.weR);
    if (bk.bl(this.weR.filePath))
    {
      y.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
      ShareScreenImgUI.b(this.weR);
      this.weR.finish();
      return;
    }
    ShareScreenImgUI.c(this.weR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI.1
 * JD-Core Version:    0.7.0.1
 */