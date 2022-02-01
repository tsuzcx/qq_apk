package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class s
  extends w
{
  private xm Ojf;
  public xn Ojg;
  private h callback;
  private c nao;
  
  public s(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    c.a locala = new c.a();
    locala.otE = new xm();
    locala.otF = new xn();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.Ojf = ((xm)c.b.b(this.nao.otB));
    this.Ojf.YGt = paramString1;
    this.Ojf.Oln = paramString2;
    this.Ojf.amount = paramInt1;
    this.Ojf.Oki = paramString3;
    this.Ojf.Okh = paramString4;
    this.Ojf.channel = paramInt2;
    this.Ojf.OhP = paramInt3;
    this.Ojf.Zge = paramString5;
    this.Ojf.Zgf = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67869);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67869);
    return i;
  }
  
  public final int getType()
  {
    return 2773;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288846);
    Log.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Ojg = ((xn)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ojg.hAV), this.Ojg.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */