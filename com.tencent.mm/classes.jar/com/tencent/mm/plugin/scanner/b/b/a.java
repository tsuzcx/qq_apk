package com.tencent.mm.plugin.scanner.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.protocal.protobuf.oy;

public final class a
  extends q
  implements m
{
  private i callback;
  public String fLj;
  public d rr;
  
  public a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(118333);
    this.fLj = paramString;
    d.a locala = new d.a();
    locala.funcId = getType();
    ox localox = new ox();
    localox.RSg = new b(paramArrayOfByte);
    localox.RSh = paramString;
    localox.RXj = 3;
    localox.source = 101;
    localox.ROx = paramInt;
    locala.lBU = localox;
    locala.uri = "/cgi-bin/mmpay-bin/ocrgetbankcardinfo";
    locala.lBV = new oy();
    this.rr = locala.bgN();
    AppMethodBeat.o(118333);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118335);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(118335);
    return i;
  }
  
  public final int getType()
  {
    return 2693;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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