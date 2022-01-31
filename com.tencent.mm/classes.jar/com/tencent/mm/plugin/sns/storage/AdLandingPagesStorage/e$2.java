package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$2
  implements f.a
{
  e$2(f.a parama, String paramString) {}
  
  public final void abi(final String paramString)
  {
    AppMethodBeat.i(37700);
    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { this.val$url });
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37697);
        e.2.this.rBW.abi(paramString);
        AppMethodBeat.o(37697);
      }
    });
    AppMethodBeat.o(37700);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37699);
    ab.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { this.val$url });
    al.d(new e.2.2(this));
    AppMethodBeat.o(37699);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(37698);
    al.d(new e.2.1(this));
    AppMethodBeat.o(37698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.2
 * JD-Core Version:    0.7.0.1
 */