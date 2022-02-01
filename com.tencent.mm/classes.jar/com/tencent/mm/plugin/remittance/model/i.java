package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  public int Ikc;
  public boolean IlA;
  public String IlB;
  qw Ilw;
  public qx Ilx;
  public d Ily;
  public e Ilz;
  private com.tencent.mm.an.i callback;
  public boolean cancel;
  private com.tencent.mm.an.d kwO;
  
  public i(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, d paramd, e parame)
  {
    AppMethodBeat.i(67843);
    this.IlA = false;
    this.IlB = "";
    this.cancel = false;
    this.Ikc = 0;
    this.IlB = (System.currentTimeMillis() + paramInt1);
    d.a locala = new d.a();
    this.Ikc = paramInt1;
    locala.lBU = new qw();
    locala.lBV = new qx();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.Ilw = ((qw)d.b.b(this.kwO.lBR));
    this.Ilw.amount = paramInt1;
    this.Ilw.channel = paramInt2;
    this.Ilw.Ilb = paramInt3;
    this.Ilw.RZl = paramString1;
    this.Ilw.ImV = paramString2;
    this.Ilw.Ilc = paramString3;
    this.Ilw.ImY = paramString4;
    this.Ilw.llO = paramString5;
    this.Ilw.Ild = paramString6;
    this.Ilw.RZm = paramInt4;
    this.Ily = paramd;
    this.Ilz = parame;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.Ilw.amount) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.Ilw.channel) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.Ilw.Ilb) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.Ilw.RZl }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.Ilw.ImV }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.Ilw.Ilc }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.Ilw.ImY }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.Ilw.llO }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.Ilw.Ild }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.Ilw.RZm) }));
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(67843);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(67844);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(67844);
    return i;
  }
  
  public final int getType()
  {
    return 2677;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67845);
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Ilx = ((qx)d.c.b(((com.tencent.mm.an.d)params).lBS));
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.Ilx.tqa), this.Ilx.tqb, a.a(this.Ilx.Ilf) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.i
 * JD-Core Version:    0.7.0.1
 */