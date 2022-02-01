package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  private vs CoM;
  public vt CoN;
  private i callback;
  private d hJu;
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    d.a locala = new d.a();
    locala.iLN = new vs();
    locala.iLO = new vt();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.CoM = ((vs)this.hJu.iLK.iLR);
    this.CoM.KHM = paramString1;
    this.CoM.KHN = paramString2;
    this.CoM.yRL = paramInt1;
    this.CoM.CpD = paramString3;
    this.CoM.CpC = paramString4;
    this.CoM.channel = paramInt2;
    this.CoM.Coi = paramInt3;
    this.CoM.LgK = paramString5;
    this.CoM.LgL = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67869);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67869);
    return i;
  }
  
  public final int getType()
  {
    return 2773;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67870);
    Log.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.CoN = ((vt)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.CoN.dDN), this.CoN.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.p
 * JD-Core Version:    0.7.0.1
 */