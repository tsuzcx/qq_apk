package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private String aeskey;
  private i callback;
  private String fileId;
  private String gna;
  private d rr;
  private int zGp;
  private String zGq;
  private String zGr;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(26524);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.zGp = paramInt;
    this.gna = paramString3;
    this.zGq = paramString4;
    this.zGr = paramString5;
    paramString2 = new d.a();
    paramString2.iLN = new dth();
    paramString2.iLO = new dti();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.iLP = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.aXF();
    Log.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.zGq, paramString1, Integer.valueOf(paramInt), paramString3, Util.getStack() });
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
    parami.ixb = this.aeskey;
    parami.iwI = this.zGp;
    parami.ixb = this.aeskey;
    parami.dDG = 0;
    parami.action = "phone";
    parami.messageAction = this.zGq;
    parami.extInfo = "supportAfterSleep,supportGetMore";
    parami.content = this.zGr;
    dth localdth = (dth)this.rr.iLK.iLR;
    fd localfd = new fd();
    localfd.xNH = this.gna;
    localfd.KIy = parami.sdkVer;
    localfd.oUv = 35;
    localfd.xNG = this.gna;
    localfd.iAc = k.b.a(parami, null, null, 0, 0);
    localfd.CreateTime = ((int)Util.nowSecond());
    localdth.MVu = localfd;
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
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.q.e
 * JD-Core Version:    0.7.0.1
 */