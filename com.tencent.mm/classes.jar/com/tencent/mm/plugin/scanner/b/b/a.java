package com.tencent.mm.plugin.scanner.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;

public final class a
  extends n
  implements k
{
  private g callback;
  public String dnh;
  public com.tencent.mm.ak.b rr;
  
  public a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(118333);
    this.dnh = paramString;
    b.a locala = new b.a();
    locala.funcId = getType();
    nh localnh = new nh();
    localnh.DZw = new com.tencent.mm.bw.b(paramArrayOfByte);
    localnh.DZz = paramString;
    localnh.Edm = 3;
    localnh.dbL = 101;
    localnh.DWd = paramInt;
    locala.hvt = localnh;
    locala.uri = "/cgi-bin/mmpay-bin/ocrgetbankcardinfo";
    locala.hvu = new ni();
    this.rr = locala.aAz();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.b.a
 * JD-Core Version:    0.7.0.1
 */