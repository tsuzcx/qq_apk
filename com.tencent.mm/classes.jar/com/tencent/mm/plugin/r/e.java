package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
  extends n
  implements k
{
  private String aeskey;
  private f callback;
  private String fHO;
  private String fileId;
  private b rr;
  private int wlN;
  private String wlO;
  private String wlP;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(26524);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.wlN = paramInt;
    this.fHO = paramString3;
    this.wlO = paramString4;
    this.wlP = paramString5;
    paramString2 = new b.a();
    paramString2.hQF = new dad();
    paramString2.hQG = new dae();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.hQH = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.aDS();
    ae.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.wlO, paramString1, Integer.valueOf(paramInt), paramString3, bu.fpN() });
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
    paramf.gmb = this.aeskey;
    paramf.hCW = this.aeskey;
    paramf.hCC = this.wlN;
    paramf.hCW = this.aeskey;
    paramf.dmr = 0;
    paramf.action = "phone";
    paramf.messageAction = this.wlO;
    paramf.extInfo = "supportAfterSleep,supportGetMore";
    paramf.content = this.wlP;
    dad localdad = (dad)this.rr.hQD.hQJ;
    eq localeq = new eq();
    localeq.uvG = this.fHO;
    localeq.FOQ = paramf.sdkVer;
    localeq.nJA = 35;
    localeq.uvF = this.fHO;
    localeq.hFS = k.b.a(paramf, null, null, 0, 0);
    localeq.CreateTime = ((int)bu.aRi());
    localdad.HJH = localeq;
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
    ae.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26526);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.r.e
 * JD-Core Version:    0.7.0.1
 */