package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends n
  implements k
{
  private String aeskey;
  private g callback;
  private String fileId;
  private String fki;
  private b rr;
  private int tNY;
  private String tNZ;
  private String tOa;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(26524);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.tNY = paramInt;
    this.fki = paramString3;
    this.tNZ = paramString4;
    this.tOa = paramString5;
    paramString2 = new b.a();
    paramString2.gUU = new cos();
    paramString2.gUV = new cot();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.reqCmdId = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.atI();
    ad.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.tNZ, paramString1, Integer.valueOf(paramInt), paramString3, bt.eGN() });
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
    paramg.fMw = this.aeskey;
    paramg.gHy = this.aeskey;
    paramg.gHe = this.tNY;
    paramg.gHy = this.aeskey;
    paramg.dcz = 0;
    paramg.action = "phone";
    paramg.messageAction = this.tNZ;
    paramg.extInfo = "supportAfterSleep,supportGetMore";
    paramg.content = this.tOa;
    cos localcos = (cos)this.rr.gUS.gUX;
    ek localek = new ek();
    localek.sdQ = this.fki;
    localek.CyE = paramg.sdkVer;
    localek.mBH = 35;
    localek.sdP = this.fki;
    localek.gKr = k.b.a(paramg, null, null, 0, 0);
    localek.CreateTime = ((int)bt.aGK());
    localcos.EiI = localek;
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.r.e
 * JD-Core Version:    0.7.0.1
 */