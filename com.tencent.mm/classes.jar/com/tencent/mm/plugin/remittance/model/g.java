package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  public boolean cancel;
  private b gPp;
  public int xWq;
  qa xXM;
  public qb xXN;
  public c xXO;
  public d xXP;
  public boolean xXQ;
  public String xXR;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    AppMethodBeat.i(67843);
    this.xXQ = false;
    this.xXR = "";
    this.cancel = false;
    this.xWq = 0;
    this.xXR = (System.currentTimeMillis() + paramInt1);
    b.a locala = new b.a();
    this.xWq = paramInt1;
    locala.hNM = new qa();
    locala.hNN = new qb();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.xXM = ((qa)this.gPp.hNK.hNQ);
    this.xXM.vls = paramInt1;
    this.xXM.channel = paramInt2;
    this.xXM.xXA = paramInt3;
    this.xXM.FLm = paramString1;
    this.xXM.xYY = paramString2;
    this.xXM.xXB = paramString3;
    this.xXM.xZb = paramString4;
    this.xXM.iTJ = paramString5;
    this.xXM.xXC = paramString6;
    this.xXM.FLn = paramInt4;
    this.xXO = paramc;
    this.xXP = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.xXM.vls) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.xXM.channel) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.xXM.xXA) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.xXM.FLm }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.xXM.xYY }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.xXM.xXB }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.xXM.xZb }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.xXM.iTJ }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.xXM.xXC }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.xXM.FLn) }));
    ad.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(67843);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67844);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.xXN = ((qb)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.xXN.ozR), this.xXN.ozS, a.a(this.xXN.xXE) });
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