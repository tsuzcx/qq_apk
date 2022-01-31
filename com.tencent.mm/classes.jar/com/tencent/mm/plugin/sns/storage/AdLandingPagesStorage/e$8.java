package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$8
  implements d.a
{
  e$8(f.a parama, String paramString1, String paramString2) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37714);
    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { this.val$url, paramString });
    al.d(new e.8.2(this));
    AppMethodBeat.o(37714);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37713);
    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { this.val$url });
    al.d(new e.8.1(this));
    AppMethodBeat.o(37713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.8
 * JD-Core Version:    0.7.0.1
 */