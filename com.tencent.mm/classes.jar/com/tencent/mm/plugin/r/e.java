package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends n
  implements k
{
  private String aeskey;
  private f callback;
  private String fFK;
  private String fileId;
  private b rr;
  private int vZJ;
  private String vZK;
  private String vZL;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(26524);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.vZJ = paramInt;
    this.fFK = paramString3;
    this.vZK = paramString4;
    this.vZL = paramString5;
    paramString2 = new b.a();
    paramString2.hNM = new czj();
    paramString2.hNN = new czk();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.hNO = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.aDC();
    ad.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.vZK, paramString1, Integer.valueOf(paramInt), paramString3, bt.flS() });
    AppMethodBeat.o(26524);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26525);
    this.callback = paramf;
    paramf = new k.b();
    paramf.title = "ChatSync";
    paramf.description = "ChatSync";
    paramf.type = 35;
    paramf.url = this.fileId;
    paramf.gjI = this.aeskey;
    paramf.hAi = this.aeskey;
    paramf.hzO = this.vZJ;
    paramf.hAi = this.aeskey;
    paramf.dlp = 0;
    paramf.action = "phone";
    paramf.messageAction = this.vZK;
    paramf.extInfo = "supportAfterSleep,supportGetMore";
    paramf.content = this.vZL;
    czj localczj = (czj)this.rr.hNK.hNQ;
    eq localeq = new eq();
    localeq.ukj = this.fFK;
    localeq.Fws = paramf.sdkVer;
    localeq.nEf = 35;
    localeq.uki = this.fFK;
    localeq.hDa = k.b.a(paramf, null, null, 0, 0);
    localeq.CreateTime = ((int)bt.aQJ());
    localczj.Hqf = localeq;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26525);
    return i;
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26526);
    ad.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26526);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.r.e
 * JD-Core Version:    0.7.0.1
 */