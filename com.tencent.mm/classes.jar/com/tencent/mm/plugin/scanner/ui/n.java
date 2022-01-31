package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mm.h.a.ov;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
{
  public n(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint, paramDisplayMetrics, paramInt);
  }
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
    paramString = ((k)this.nLv).nPx;
    paramArrayOfByte1 = new ov();
    paramArrayOfByte1.bYr.cardType = "identity";
    paramArrayOfByte1.bYr.bYs = 1;
    if ((this.nLv instanceof k)) {
      paramArrayOfByte1.bYr.bYu = paramString;
    }
    a.udP.a(paramArrayOfByte1, Looper.getMainLooper());
    this.nLB.getContext().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.n
 * JD-Core Version:    0.7.0.1
 */