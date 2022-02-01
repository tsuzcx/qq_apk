package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
  extends n
  implements k
{
  private String aeskey;
  private g callback;
  private String fileId;
  private String fnC;
  private b rr;
  private int uWB;
  private String uWC;
  private String uWD;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(26524);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.uWB = paramInt;
    this.fnC = paramString3;
    this.uWC = paramString4;
    this.uWD = paramString5;
    paramString2 = new b.a();
    paramString2.hvt = new ctz();
    paramString2.hvu = new cua();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.reqCmdId = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.aAz();
    ac.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.uWC, paramString1, Integer.valueOf(paramInt), paramString3, bs.eWi() });
    AppMethodBeat.o(26524);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(26525);
    this.callback = paramg;
    paramg = new k.b();
    paramg.title = "ChatSync";
    paramg.description = "ChatSync";
    paramg.type = 35;
    paramg.url = this.fileId;
    paramg.fQi = this.aeskey;
    paramg.hhZ = this.aeskey;
    paramg.hhF = this.uWB;
    paramg.hhZ = this.aeskey;
    paramg.cZX = 0;
    paramg.action = "phone";
    paramg.messageAction = this.uWC;
    paramg.extInfo = "supportAfterSleep,supportGetMore";
    paramg.content = this.uWD;
    ctz localctz = (ctz)this.rr.hvr.hvw;
    em localem = new em();
    localem.tlK = this.fnC;
    localem.DRa = paramg.sdkVer;
    localem.ndI = 35;
    localem.tlJ = this.fnC;
    localem.hkR = k.b.a(paramg, null, null, 0, 0);
    localem.CreateTime = ((int)bs.aNx());
    localctz.FFG = localem;
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
    ac.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26526);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.r.e
 * JD-Core Version:    0.7.0.1
 */