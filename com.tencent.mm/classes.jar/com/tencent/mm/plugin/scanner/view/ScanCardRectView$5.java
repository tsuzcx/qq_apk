package com.tencent.mm.plugin.scanner.view;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.b.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;

final class ScanCardRectView$5
  implements b.a
{
  ScanCardRectView$5(ScanCardRectView paramScanCardRectView) {}
  
  public final void a(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(118383);
    if (paramLong == ScanCardRectView.a(this.PkB))
    {
      Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(this.PkB)) });
      ScanCardRectView.b(this.PkB);
      if (ScanCardRectView.c(this.PkB) != null) {
        ScanCardRectView.c(this.PkB).aU(paramBundle);
      }
    }
    AppMethodBeat.o(118383);
  }
  
  public final void bc(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(118382);
    if (paramLong1 == ScanCardRectView.a(this.PkB)) {
      this.PkB.ua(paramLong2);
    }
    AppMethodBeat.o(118382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView.5
 * JD-Core Version:    0.7.0.1
 */