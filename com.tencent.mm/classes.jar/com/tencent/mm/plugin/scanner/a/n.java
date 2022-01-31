package com.tencent.mm.plugin.scanner.a;

import android.os.Bundle;
import com.tencent.mm.h.a.nw;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends c<nw>
  implements b.a
{
  private boolean isDecoding = false;
  private d nHt = null;
  private q nHu = null;
  
  public n()
  {
    this.udX = nw.class.getName().hashCode();
  }
  
  public final void C(Bundle paramBundle) {}
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.nHu != null) {
      this.nHu.O(paramString, paramInt2, paramInt3);
    }
    this.isDecoding = false;
  }
  
  public final void fB(long paramLong)
  {
    y.i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
    if (this.nHu != null) {
      this.nHu.O("", -2, -1);
    }
    this.isDecoding = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.n
 * JD-Core Version:    0.7.0.1
 */