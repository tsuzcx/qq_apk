package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class ak
  extends w
{
  private dym Vbn;
  public dyn Vbo;
  private h callback;
  private c nao;
  
  public ak(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68553);
    c.a locala = new c.a();
    locala.otE = new dym();
    locala.otF = new dyn();
    locala.funcId = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.Vbn = ((dym)c.b.b(this.nao.otB));
    this.Vbn.YNI = paramString1;
    this.Vbn.DVu = paramString2;
    this.Vbn.Vbl = ai.ieD();
    Log.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(68553);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(68554);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(68554);
    return i;
  }
  
  public final int getType()
  {
    return 2996;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(316151);
    Log.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.Vbo = ((dyn)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Vbo.wuz), this.Vbo.wuA });
    if (this.Vbo.wuz == 0) {
      ai.bfU(this.Vbo.Vbl);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(316151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ak
 * JD-Core Version:    0.7.0.1
 */