package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private yi ORJ;
  private yj ORK;
  private h callback;
  private final c rr;
  
  public p(String paramString, b paramb)
  {
    AppMethodBeat.i(314353);
    c.a locala = new c.a();
    locala.otE = new yi();
    locala.otF = new yj();
    locala.funcId = 4561;
    locala.uri = "/cgi-bin/mmpay-bin/report_qrcode_scan_identify_scene";
    this.rr = locala.bEF();
    this.ORJ = ((yi)c.b.b(this.rr.otB));
    this.ORJ.url = paramString;
    this.ORJ.ZgY = paramb;
    AppMethodBeat.o(314353);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(314360);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(314360);
    return i;
  }
  
  public final int getType()
  {
    return 4561;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(314364);
    Log.i("MicroMsg.NetSceneF2fQrcodeScanIdentify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.ORK = ((yj)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(314364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p
 * JD-Core Version:    0.7.0.1
 */