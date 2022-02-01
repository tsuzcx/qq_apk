package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public boolean cancel;
  private b gvE;
  public int wIJ;
  ov wKf;
  public ow wKg;
  public c wKh;
  public d wKi;
  public boolean wKj;
  public String wKk;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    AppMethodBeat.i(67843);
    this.wKj = false;
    this.wKk = "";
    this.cancel = false;
    this.wIJ = 0;
    this.wKk = (System.currentTimeMillis() + paramInt1);
    b.a locala = new b.a();
    this.wIJ = paramInt1;
    locala.hvt = new ov();
    locala.hvu = new ow();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.wKf = ((ov)this.gvE.hvr.hvw);
    this.wKf.uiK = paramInt1;
    this.wKf.channel = paramInt2;
    this.wKf.wJT = paramInt3;
    this.wKf.EeN = paramString1;
    this.wKf.wLr = paramString2;
    this.wKf.wJU = paramString3;
    this.wKf.wLu = paramString4;
    this.wKf.iAz = paramString5;
    this.wKf.wJV = paramString6;
    this.wKf.EeO = paramInt4;
    this.wKh = paramc;
    this.wKi = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.wKf.uiK) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.wKf.channel) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.wKf.wJT) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.wKf.EeN }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.wKf.wLr }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.wKf.wJU }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.wKf.wLu }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.wKf.iAz }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.wKf.wJV }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.wKf.EeO) }));
    ac.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(67843);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(67844);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKg = ((ow)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.wKg.nWx), this.wKg.nWy, a.a(this.wKg.wJX) });
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