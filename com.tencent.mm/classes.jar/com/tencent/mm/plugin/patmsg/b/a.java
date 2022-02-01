package com.tencent.mm.plugin.patmsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.mc;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class a
  extends p
  implements m
{
  public mc MHs;
  private com.tencent.mm.am.h callback;
  private long hZj;
  private long msgId;
  private com.tencent.mm.am.c oDw;
  
  public a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    AppMethodBeat.i(266364);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = Util.getInt(localObject.toString(), 0);; i = 0)
    {
      localObject = new c.a();
      ((c.a)localObject).otE = new esl();
      ((c.a)localObject).otF = new esm();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/revokemsg";
      ((c.a)localObject).funcId = 594;
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      this.msgId = paramLong1;
      this.hZj = paramLong2;
      this.oDw = ((c.a)localObject).bEF();
      localObject = (esl)c.b.b(this.oDw.otB);
      ((esl)localObject).YHk = paramString1;
      ((esl)localObject).abwb = 0;
      ((esl)localObject).abwc = 0;
      ((esl)localObject).abwe = paramLong2;
      ((esl)localObject).CreateTime = ((int)(paramLong3 / 1000L));
      ((esl)localObject).IMh = z.bAM();
      ((esl)localObject).IMg = paramString2;
      ((esl)localObject).abwd = i;
      Log.i("MicroMsg.NetSceneRevokePatMsg", "clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { ((esl)localObject).YHk, Integer.valueOf(((esl)localObject).abwb), Integer.valueOf(((esl)localObject).abwc), Integer.valueOf(((esl)localObject).CreateTime), ((esl)localObject).IMh, ((esl)localObject).IMg, Integer.valueOf(((esl)localObject).abwd) });
      AppMethodBeat.o(266364);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266377);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266377);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266385);
    Log.i("MicroMsg.NetSceneRevokePatMsg", "onGYNetEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ((b)com.tencent.mm.kernel.h.ax(b.class)).aW(this.msgId, this.hZj);
      params = com.tencent.mm.kernel.h.baE().ban().d(290818, Integer.valueOf(0));
      if (params == null) {
        break label207;
      }
    }
    label207:
    for (paramInt1 = Util.getInt(params.toString(), 0);; paramInt1 = 0)
    {
      com.tencent.mm.kernel.h.baE().ban().B(290818, Integer.valueOf(paramInt1 + 1));
      if (this.MHs != null)
      {
        this.MHs.iUn = 2;
        this.MHs.bMH();
        params = com.tencent.mm.util.c.agsX;
        com.tencent.mm.util.c.a(this.MHs);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(266385);
        return;
        if (this.MHs != null)
        {
          this.MHs.iUn = 1;
          this.MHs.bMH();
          params = com.tencent.mm.util.c.agsX;
          com.tencent.mm.util.c.a(this.MHs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.a
 * JD-Core Version:    0.7.0.1
 */