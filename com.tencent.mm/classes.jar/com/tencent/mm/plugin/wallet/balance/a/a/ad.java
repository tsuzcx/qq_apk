package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;

public final class ad
  extends m
  implements k
{
  private f callback;
  private b goo;
  private bja tNA;
  public bjb tNB;
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(45332);
    b.a locala = new b.a();
    locala.fsX = new bja();
    locala.fsY = new bjb();
    locala.funcId = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.tNA = ((bja)this.goo.fsV.fta);
    this.tNA.wvn = paramString1;
    this.tNA.xxz = paramString2;
    this.tNA.tNy = ab.cQT();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(45332);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(45333);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(45333);
    return i;
  }
  
  public final int getType()
  {
    return 2996;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45334);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tNB = ((bjb)((b)paramq).fsW.fta);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tNB.koj), this.tNB.kok });
    if (this.tNB.koj == 0) {
      ab.aeP(this.tNB.tNy);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(45334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.ad
 * JD-Core Version:    0.7.0.1
 */