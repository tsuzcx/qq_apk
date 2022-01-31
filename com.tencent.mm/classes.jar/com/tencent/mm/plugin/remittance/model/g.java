package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends m
  implements k
{
  private f callback;
  private b goo;
  ml qiZ;
  public mm qja;
  public c qjb;
  public d qjc;
  public boolean qjd;
  public String qje;
  public boolean qjf;
  public int qjg;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    AppMethodBeat.i(44732);
    this.qjd = false;
    this.qje = "";
    this.qjf = false;
    this.qjg = 0;
    this.qje = (System.currentTimeMillis() + paramInt1);
    b.a locala = new b.a();
    this.qjg = paramInt1;
    locala.fsX = new ml();
    locala.fsY = new mm();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.qiZ = ((ml)this.goo.fsV.fta);
    this.qiZ.okH = paramInt1;
    this.qiZ.cCy = paramInt2;
    this.qiZ.qiP = paramInt3;
    this.qiZ.wAX = paramString1;
    this.qiZ.qkk = paramString2;
    this.qiZ.qiQ = paramString3;
    this.qiZ.qkn = paramString4;
    this.qiZ.wpt = paramString5;
    this.qiZ.qiR = paramString6;
    this.qiZ.wAY = paramInt4;
    this.qjb = paramc;
    this.qjc = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.qiZ.okH) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.qiZ.cCy) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.qiZ.qiP) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.qiZ.wAX }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.qiZ.qkk }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.qiZ.qiQ }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.qiZ.qkn }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.qiZ.wpt }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.qiZ.qiR }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.qiZ.wAY) }));
    ab.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(44732);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44733);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(44733);
    return i;
  }
  
  public final int getType()
  {
    return 2677;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44734);
    ab.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qja = ((mm)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.qja.koj), this.qja.kok, a.a(this.qja.qiT) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(44734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.g
 * JD-Core Version:    0.7.0.1
 */