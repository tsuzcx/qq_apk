package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  public int Cnj;
  rd Cou;
  public re Cov;
  public c Cow;
  public d Cox;
  public boolean Coy;
  public String Coz;
  private i callback;
  public boolean cancel;
  private com.tencent.mm.ak.d hJu;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    AppMethodBeat.i(67843);
    this.Coy = false;
    this.Coz = "";
    this.cancel = false;
    this.Cnj = 0;
    this.Coz = (System.currentTimeMillis() + paramInt1);
    d.a locala = new d.a();
    this.Cnj = paramInt1;
    locala.iLN = new rd();
    locala.iLO = new re();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.Cou = ((rd)this.hJu.iLK.iLR);
    this.Cou.yRL = paramInt1;
    this.Cou.channel = paramInt2;
    this.Cou.Coi = paramInt3;
    this.Cou.KYc = paramString1;
    this.Cou.CpG = paramString2;
    this.Cou.Coj = paramString3;
    this.Cou.CpJ = paramString4;
    this.Cou.jTz = paramString5;
    this.Cou.Cok = paramString6;
    this.Cou.KYd = paramInt4;
    this.Cow = paramc;
    this.Cox = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.Cou.yRL) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.Cou.channel) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.Cou.Coi) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.Cou.KYc }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.Cou.CpG }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.Cou.Coj }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.Cou.CpJ }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.Cou.jTz }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.Cou.Cok }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.Cou.KYd) }));
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(67843);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(67844);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
    this.Cov = ((re)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.Cov.pTZ), this.Cov.pUa, a.a(this.Cov.Com) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.g
 * JD-Core Version:    0.7.0.1
 */