package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private vu IlO;
  public vv IlP;
  private i callback;
  private d kwO;
  
  public r(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    d.a locala = new d.a();
    locala.lBU = new vu();
    locala.lBV = new vv();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.IlO = ((vu)d.b.b(this.kwO.lBR));
    this.IlO.RJf = paramString1;
    this.IlO.InV = paramString2;
    this.IlO.amount = paramInt1;
    this.IlO.ImS = paramString3;
    this.IlO.ImR = paramString4;
    this.IlO.channel = paramInt2;
    this.IlO.Ilb = paramInt3;
    this.IlO.ShY = paramString5;
    this.IlO.ShZ = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67869);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.IlP = ((vv)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IlP.fwx), this.IlP.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.r
 * JD-Core Version:    0.7.0.1
 */