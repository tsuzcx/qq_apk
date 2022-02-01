package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public boolean cancel;
  private b iaa;
  oo vAa;
  public op vAb;
  public c vAc;
  public d vAd;
  public boolean vAe;
  public String vAf;
  public int vyE;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    AppMethodBeat.i(67843);
    this.vAe = false;
    this.vAf = "";
    this.cancel = false;
    this.vyE = 0;
    this.vAf = (System.currentTimeMillis() + paramInt1);
    b.a locala = new b.a();
    this.vyE = paramInt1;
    locala.gUU = new oo();
    locala.gUV = new op();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.vAa = ((oo)this.iaa.gUS.gUX);
    this.vAa.tav = paramInt1;
    this.vAa.channel = paramInt2;
    this.vAa.vzO = paramInt3;
    this.vAa.CMl = paramString1;
    this.vAa.vBm = paramString2;
    this.vAa.vzP = paramString3;
    this.vAa.vBp = paramString4;
    this.vAa.iaw = paramString5;
    this.vAa.vzQ = paramString6;
    this.vAa.CMm = paramInt4;
    this.vAc = paramc;
    this.vAd = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.vAa.tav) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.vAa.channel) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.vAa.vzO) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.vAa.CMl }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.vAa.vBm }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.vAa.vzP }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.vAa.vBp }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.vAa.iaw }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.vAa.vzQ }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.vAa.CMm) }));
    ad.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(67843);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(67844);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(67844);
    return i;
  }
  
  public final int getType()
  {
    return 2677;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67845);
    ad.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vAb = ((op)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.vAb.ntx), this.vAb.nty, a.a(this.vAb.vzS) });
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