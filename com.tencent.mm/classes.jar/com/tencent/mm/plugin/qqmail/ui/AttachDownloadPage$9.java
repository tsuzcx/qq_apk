package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.Map;

final class AttachDownloadPage$9
  extends v.a
{
  AttachDownloadPage$9(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final void onComplete() {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(68141);
    AttachDownloadPage.a(this.pLa, 4);
    if (AttachDownloadPage.m(this.pLa) < 5)
    {
      AttachDownloadPage.n(this.pLa);
      AttachDownloadPage.f(this.pLa);
      AppMethodBeat.o(68141);
      return;
    }
    AttachDownloadPage.d(this.pLa);
    AppMethodBeat.o(68141);
  }
  
  public final void onProgress(int paramInt)
  {
    AppMethodBeat.i(68139);
    ab.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramInt)));
    AttachDownloadPage.j(this.pLa);
    AttachDownloadPage.a(this.pLa, 1);
    AppMethodBeat.o(68139);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(68140);
    e.h(AttachDownloadPage.k(this.pLa), AttachDownloadPage.l(this.pLa) + ".temp", AttachDownloadPage.l(this.pLa));
    AttachDownloadPage.a(this.pLa, 3);
    Toast.makeText(this.pLa, this.pLa.getString(2131299017) + " : " + AttachDownloadPage.a(this.pLa), 5000).show();
    AttachDownloadPage.d(this.pLa);
    AppMethodBeat.o(68140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.9
 * JD-Core Version:    0.7.0.1
 */