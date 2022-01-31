package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.xweb.WebView.c;

final class X5WebFactory$b$1
  implements QbSdk.PreInitCallback
{
  private boolean BIm = false;
  private boolean BIn = false;
  
  X5WebFactory$b$1(WebView.c paramc) {}
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(84866);
    this.BIm = true;
    if ((this.BIm) && (this.BIn) && (this.BIo != null))
    {
      this.BIo.onCoreInitFinished();
      X5WebFactory.b.Pt();
    }
    AppMethodBeat.o(84866);
  }
  
  public final void onViewInitFinished(boolean paramBoolean)
  {
    AppMethodBeat.i(84867);
    this.BIn = true;
    if ((this.BIm) && (this.BIn) && (this.BIo != null))
    {
      this.BIo.onCoreInitFinished();
      X5WebFactory.b.Pt();
    }
    AppMethodBeat.o(84867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory.b.1
 * JD-Core Version:    0.7.0.1
 */