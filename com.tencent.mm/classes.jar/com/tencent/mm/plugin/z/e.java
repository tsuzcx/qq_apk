package com.tencent.mm.plugin.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private String FlA;
  private String FlB;
  private int Flz;
  private String aeskey;
  private i callback;
  private String fileId;
  private String iRj;
  private d rr;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(26524);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.Flz = paramInt;
    this.iRj = paramString3;
    this.FlA = paramString4;
    this.FlB = paramString5;
    paramString2 = new d.a();
    paramString2.lBU = new edg();
    paramString2.lBV = new edh();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.lBW = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.bgN();
    Log.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.FlA, paramString1, Integer.valueOf(paramInt), paramString3, Util.getStack() });
    AppMethodBeat.o(26524);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26525);
    this.callback = parami;
    parami = new k.b();
    parami.title = "ChatSync";
    parami.description = "ChatSync";
    parami.type = 35;
    parami.url = this.fileId;
    parami.aesKey = this.aeskey;
    parami.lmq = this.aeskey;
    parami.llX = this.Flz;
    parami.lmq = this.aeskey;
    parami.fwp = 0;
    parami.action = "phone";
    parami.messageAction = this.FlA;
    parami.extInfo = "supportAfterSleep,supportGetMore";
    parami.content = this.FlB;
    edg localedg = (edg)d.b.b(this.rr.lBR);
    fa localfa = new fa();
    localfa.CRR = this.iRj;
    localfa.RJP = parami.sdkVer;
    localfa.rWu = 35;
    localfa.CRQ = this.iRj;
    localfa.lpy = k.b.a(parami, null, null, 0, 0);
    localfa.CreateTime = ((int)Util.nowSecond());
    localedg.UhI = localfa;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26525);
    return i;
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26526);
    Log.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26526);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.z.e
 * JD-Core Version:    0.7.0.1
 */