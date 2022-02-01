package com.tencent.mm.plugin.scanner.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.nb;

public final class a
  extends n
  implements k
{
  private g callback;
  public String dpw;
  public com.tencent.mm.al.b rr;
  
  public a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(118333);
    this.dpw = paramString;
    b.a locala = new b.a();
    locala.funcId = getType();
    na localna = new na();
    localna.CGV = new com.tencent.mm.bx.b(paramArrayOfByte);
    localna.CGY = paramString;
    localna.CKK = 3;
    localna.dep = 101;
    localna.CDE = paramInt;
    locala.gUU = localna;
    locala.uri = "/cgi-bin/mmpay-bin/ocrgetbankcardinfo";
    locala.gUV = new nb();
    this.rr = locala.atI();
    AppMethodBeat.o(118333);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(118335);
    this.callback = paramg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.b.a
 * JD-Core Version:    0.7.0.1
 */