package com.tencent.mm.plugin.scanner.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.protobuf.qh;

public final class a
  extends p
  implements m
{
  private h callback;
  public String hQR;
  public c rr;
  
  public a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(118333);
    this.hQR = paramString;
    c.a locala = new c.a();
    locala.funcId = getType();
    qg localqg = new qg();
    localqg.YPG = new b(paramArrayOfByte);
    localqg.YPH = paramString;
    localqg.YVb = 3;
    localqg.source = 101;
    localqg.YLL = paramInt;
    locala.otE = localqg;
    locala.uri = "/cgi-bin/mmpay-bin/ocrgetbankcardinfo";
    locala.otF = new qh();
    this.rr = locala.bEF();
    AppMethodBeat.o(118333);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(118335);
    this.callback = paramh;
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