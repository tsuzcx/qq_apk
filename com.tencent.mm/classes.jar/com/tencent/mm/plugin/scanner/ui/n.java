package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.px;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends m
{
  public n(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint, paramDisplayMetrics, paramInt);
  }
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151676);
    ab.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
    paramString1 = ((com.tencent.mm.plugin.scanner.util.m)this.qza).qDq;
    paramArrayOfByte1 = new px();
    paramArrayOfByte1.cGs.cardType = "identity";
    paramArrayOfByte1.cGs.cGt = 1;
    if ((this.qza instanceof com.tencent.mm.plugin.scanner.util.m)) {
      paramArrayOfByte1.cGs.cGv = paramString1;
    }
    a.ymk.a(paramArrayOfByte1, Looper.getMainLooper());
    this.qzg.getContext().finish();
    AppMethodBeat.o(151676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.n
 * JD-Core Version:    0.7.0.1
 */