package com.tencent.mm.plugin.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.ewy;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends p
  implements m
{
  private int LhB;
  private String LhC;
  private String LhD;
  private String aeskey;
  private h callback;
  private String fileId;
  private String hRv;
  private String ltf;
  private c rr;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(261802);
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.LhB = paramInt;
    this.ltf = paramString3;
    this.LhC = paramString4;
    this.LhD = paramString5;
    this.hRv = paramString6;
    paramString2 = new c.a();
    paramString2.otE = new ewx();
    paramString2.otF = new ewy();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.funcId = 222;
    paramString2.otG = 107;
    paramString2.respCmdId = 1000000107;
    this.rr = paramString2.bEF();
    Log.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.LhC, paramString1, Integer.valueOf(paramInt), paramString3, Util.getStack() });
    AppMethodBeat.o(261802);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26525);
    this.callback = paramh;
    paramh = new k.b();
    paramh.title = "ChatSync";
    paramh.description = "ChatSync";
    paramh.type = 35;
    paramh.url = this.fileId;
    paramh.aesKey = this.aeskey;
    paramh.nRv = this.aeskey;
    paramh.nRd = this.LhB;
    paramh.nRv = this.aeskey;
    paramh.hAN = 0;
    paramh.action = "phone";
    paramh.messageAction = this.LhC;
    paramh.extInfo = "supportAfterSleep,supportGetMore";
    paramh.content = this.LhD;
    paramh.hRv = this.hRv;
    ewx localewx = (ewx)c.b.b(this.rr.otB);
    fu localfu = new fu();
    localfu.IMh = this.ltf;
    localfu.YHj = paramh.sdkVer;
    localfu.vhJ = 35;
    localfu.IMg = this.ltf;
    localfu.nUB = k.b.a(paramh, null, null, 0, 0);
    localfu.CreateTime = ((int)Util.nowSecond());
    localewx.abyY = localfu;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.z.e
 * JD-Core Version:    0.7.0.1
 */