package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ShareImgUI$3
  extends ah
{
  ShareImgUI$3(ShareImgUI paramShareImgUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (bk.bl(this.weH.filePath))
    {
      y.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
      ShareImgUI.d(this.weH);
      this.weH.finish();
      return;
    }
    ShareImgUI.c(this.weH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.3
 * JD-Core Version:    0.7.0.1
 */