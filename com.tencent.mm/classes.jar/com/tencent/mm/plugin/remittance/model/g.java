package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends n
  implements k
{
  private f callback;
  public boolean cancel;
  private b gRX;
  public int ymj;
  qc ynE;
  public qd ynF;
  public c ynG;
  public d ynH;
  public boolean ynI;
  public String ynJ;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    AppMethodBeat.i(67843);
    this.ynI = false;
    this.ynJ = "";
    this.cancel = false;
    this.ymj = 0;
    this.ynJ = (System.currentTimeMillis() + paramInt1);
    b.a locala = new b.a();
    this.ymj = paramInt1;
    locala.hQF = new qc();
    locala.hQG = new qd();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.ynE = ((qc)this.gRX.hQD.hQJ);
    this.ynE.vxx = paramInt1;
    this.ynE.channel = paramInt2;
    this.ynE.yns = paramInt3;
    this.ynE.GdL = paramString1;
    this.ynE.yoQ = paramString2;
    this.ynE.ynt = paramString3;
    this.ynE.yoT = paramString4;
    this.ynE.iWC = paramString5;
    this.ynE.ynu = paramString6;
    this.ynE.GdM = paramInt4;
    this.ynG = paramc;
    this.ynH = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.ynE.vxx) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.ynE.channel) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.ynE.yns) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.ynE.GdL }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.ynE.yoQ }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.ynE.ynt }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.ynE.yoT }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.ynE.iWC }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.ynE.ynu }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.ynE.GdM) }));
    ae.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(67843);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67844);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynF = ((qd)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.ynF.oGt), this.ynF.oGu, a.a(this.ynF.ynw) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.g
 * JD-Core Version:    0.7.0.1
 */