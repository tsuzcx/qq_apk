package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class ShareScreenImgUI$1
  extends ak
{
  ShareScreenImgUI$1(ShareScreenImgUI paramShareScreenImgUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(34966);
    ShareScreenImgUI.a(this.AxH);
    if (bo.isNullOrNil(this.AxH.filePath))
    {
      ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
      ShareScreenImgUI.b(this.AxH);
      this.AxH.finish();
      AppMethodBeat.o(34966);
      return;
    }
    ShareScreenImgUI.c(this.AxH);
    AppMethodBeat.o(34966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI.1
 * JD-Core Version:    0.7.0.1
 */