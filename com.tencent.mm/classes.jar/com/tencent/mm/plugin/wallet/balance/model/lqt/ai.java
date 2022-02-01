package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
  extends q
  implements m
{
  private cwv HuU;
  public cww HuV;
  private i callback;
  private d hJu;
  
  public ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68553);
    d.a locala = new d.a();
    locala.iLN = new cwv();
    locala.iLO = new cww();
    locala.funcId = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.HuU = ((cwv)this.hJu.iLK.iLR);
    this.HuU.KPu = paramString1;
    this.HuU.KUp = paramString2;
    this.HuU.HuS = ag.fNb();
    Log.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(68553);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(68554);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(68554);
    return i;
  }
  
  public final int getType()
  {
    return 2996;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(68555);
    Log.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.HuV = ((cww)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.HuV.pTZ), this.HuV.pUa });
    if (this.HuV.pTZ == 0) {
      ag.aUH(this.HuV.HuS);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(68555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ai
 * JD-Core Version:    0.7.0.1
 */