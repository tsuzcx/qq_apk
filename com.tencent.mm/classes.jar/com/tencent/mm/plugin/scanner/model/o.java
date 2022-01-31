package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends c<ox>
  implements b.a
{
  private boolean isDecoding;
  private e quS;
  private r quT;
  
  public o()
  {
    AppMethodBeat.i(80873);
    this.quS = null;
    this.isDecoding = false;
    this.quT = null;
    this.__eventId = ox.class.getName().hashCode();
    AppMethodBeat.o(80873);
  }
  
  public final void T(Bundle paramBundle) {}
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151657);
    ab.i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.quT != null) {
      this.quT.ac(paramString1, paramInt2, paramInt3);
    }
    this.isDecoding = false;
    AppMethodBeat.o(151657);
  }
  
  public final void le(long paramLong)
  {
    AppMethodBeat.i(80875);
    ab.i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
    if (this.quT != null) {
      this.quT.ac("", -2, -1);
    }
    this.isDecoding = false;
    AppMethodBeat.o(80875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.o
 * JD-Core Version:    0.7.0.1
 */