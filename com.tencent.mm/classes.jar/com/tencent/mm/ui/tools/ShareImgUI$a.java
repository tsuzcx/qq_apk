package com.tencent.mm.ui.tools;

import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;

final class ShareImgUI$a
  implements Runnable
{
  private ShareImgUI.c AxG;
  private Uri mUri;
  
  public ShareImgUI$a(ShareImgUI paramShareImgUI, Uri paramUri, ShareImgUI.c paramc)
  {
    this.mUri = paramUri;
    this.AxG = paramc;
  }
  
  public final void run()
  {
    AppMethodBeat.i(34943);
    this.Axx.filePath = ShareImgUI.a(this.Axx, this.mUri);
    if ((bo.isNullOrNil(this.Axx.filePath)) || (!new b(this.Axx.filePath).exists())) {
      if (ShareImgUI.auU(this.Axx.getContentResolver().getType(this.mUri)) != 3) {
        break label120;
      }
    }
    label120:
    for (this.Axx.filePath = e.a(this.Axx.getContentResolver(), this.mUri);; this.Axx.filePath = e.a(this.Axx.getContentResolver(), this.mUri, 1))
    {
      if (this.AxG != null) {
        this.AxG.dND();
      }
      AppMethodBeat.o(34943);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.a
 * JD-Core Version:    0.7.0.1
 */