package com.tencent.mm.plugin.scanner.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;

public final class a
  extends n
  implements k
{
  private f callback;
  public String dyV;
  public com.tencent.mm.al.b rr;
  
  public a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(118333);
    this.dyV = paramString;
    b.a locala = new b.a();
    locala.funcId = getType();
    od localod = new od();
    localod.FEU = new com.tencent.mm.bx.b(paramArrayOfByte);
    localod.FEX = paramString;
    localod.FJt = 3;
    localod.dnh = 101;
    localod.FBz = paramInt;
    locala.hNM = localod;
    locala.uri = "/cgi-bin/mmpay-bin/ocrgetbankcardinfo";
    locala.hNN = new oe();
    this.rr = locala.aDC();
    AppMethodBeat.o(118333);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(118335);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(118335);
    return i;
  }
  
  public final int getType()
  {
    return 2693;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118334);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(118334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.b.a
 * JD-Core Version:    0.7.0.1
 */