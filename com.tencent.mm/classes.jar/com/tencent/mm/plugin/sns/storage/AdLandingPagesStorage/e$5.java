package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$5
  implements c.a
{
  e$5(c.a parama, String paramString) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(37707);
    ab.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for big file %s", new Object[] { this.val$url });
    al.d(new e.5.2(this, paramString));
    AppMethodBeat.o(37707);
  }
  
  public final void dq(String paramString, int paramInt)
  {
    AppMethodBeat.i(37706);
    al.d(new e.5.1(this, paramString, paramInt));
    AppMethodBeat.o(37706);
  }
  
  public final void mP(String paramString)
  {
    AppMethodBeat.i(37708);
    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success big file for %s", new Object[] { this.val$url });
    al.d(new e.5.3(this, paramString));
    AppMethodBeat.o(37708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.5
 * JD-Core Version:    0.7.0.1
 */