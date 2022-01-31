package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends m
  implements k
{
  private String aeskey;
  private f callback;
  private String dZZ;
  private String fileId;
  private int oSO;
  private String oSP;
  private String oSQ;
  private b rr;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(22900);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.oSO = paramInt;
    this.dZZ = paramString3;
    this.oSP = paramString4;
    this.oSQ = paramString5;
    paramString2 = new b.a();
    paramString2.fsX = new byp();
    paramString2.fsY = new byq();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.reqCmdId = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.ado();
    ab.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.oSP, paramString1, Integer.valueOf(paramInt), paramString3, bo.dtY() });
    AppMethodBeat.o(22900);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(22901);
    this.callback = paramf;
    paramf = new j.b();
    paramf.title = "ChatSync";
    paramf.description = "ChatSync";
    paramf.type = 35;
    paramf.url = this.fileId;
    paramf.ewj = this.aeskey;
    paramf.fgS = this.aeskey;
    paramf.fgw = this.oSO;
    paramf.fgS = this.aeskey;
    paramf.showType = 0;
    paramf.action = "phone";
    paramf.messageAction = this.oSP;
    paramf.extInfo = "supportAfterSleep,supportGetMore";
    paramf.content = this.oSQ;
    byp localbyp = (byp)this.rr.fsV.fta;
    dx localdx = new dx();
    localdx.num = this.dZZ;
    localdx.wpR = paramf.sdkVer;
    localdx.jKs = 35;
    localdx.nul = this.dZZ;
    localdx.ntu = j.b.a(paramf, null, null, 0, 0);
    localdx.CreateTime = ((int)bo.aox());
    localbyp.xKW = localdx;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(22901);
    return i;
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22902);
    ab.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22902);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.q.e
 * JD-Core Version:    0.7.0.1
 */