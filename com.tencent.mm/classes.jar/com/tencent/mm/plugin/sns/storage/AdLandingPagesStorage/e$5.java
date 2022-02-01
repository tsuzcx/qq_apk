package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

final class e$5
  implements c.a
{
  e$5(c.a parama, String paramString) {}
  
  public final void QR(final String paramString)
  {
    AppMethodBeat.i(97304);
    ae.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for big file %s", new Object[] { this.val$url });
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97301);
        e.5.this.AcJ.QR(paramString);
        AppMethodBeat.o(97301);
      }
    });
    AppMethodBeat.o(97304);
  }
  
  public final void dp(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(97303);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97300);
        e.5.this.AcJ.dp(paramString, paramInt);
        AppMethodBeat.o(97300);
      }
    });
    AppMethodBeat.o(97303);
  }
  
  public final void yO(final String paramString)
  {
    AppMethodBeat.i(97305);
    ae.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success big file for %s", new Object[] { this.val$url });
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97302);
        e.5.this.AcJ.yO(paramString);
        AppMethodBeat.o(97302);
      }
    });
    AppMethodBeat.o(97305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.5
 * JD-Core Version:    0.7.0.1
 */