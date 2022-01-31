package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class ShareImgUI$3
  extends ak
{
  ShareImgUI$3(ShareImgUI paramShareImgUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(34937);
    if (bo.isNullOrNil(this.Axx.filePath))
    {
      ab.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
      ShareImgUI.d(this.Axx);
      this.Axx.finish();
      AppMethodBeat.o(34937);
      return;
    }
    ShareImgUI.c(this.Axx);
    AppMethodBeat.o(34937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.3
 * JD-Core Version:    0.7.0.1
 */