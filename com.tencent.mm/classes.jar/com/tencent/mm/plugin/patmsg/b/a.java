package com.tencent.mm.plugin.patmsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class a
  extends q
  implements m
{
  public hk ARn;
  private i callback;
  private long dZs;
  private d iUB;
  private long msgId;
  
  public a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    AppMethodBeat.i(206967);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = Util.getInt(localObject.toString(), 0);; i = 0)
    {
      localObject = new d.a();
      ((d.a)localObject).iLN = new dpk();
      ((d.a)localObject).iLO = new dpl();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/revokemsg";
      ((d.a)localObject).funcId = 594;
      ((d.a)localObject).iLP = 0;
      ((d.a)localObject).respCmdId = 0;
      this.msgId = paramLong1;
      this.dZs = paramLong2;
      this.iUB = ((d.a)localObject).aXF();
      localObject = (dpk)this.iUB.iLK.iLR;
      ((dpk)localObject).KIz = paramString1;
      ((dpk)localObject).MSH = 0;
      ((dpk)localObject).MSI = 0;
      ((dpk)localObject).MSK = paramLong2;
      ((dpk)localObject).CreateTime = ((int)(paramLong3 / 1000L));
      ((dpk)localObject).xNH = z.aTY();
      ((dpk)localObject).xNG = paramString2;
      ((dpk)localObject).MSJ = i;
      Log.i("MicroMsg.NetSceneRevokePatMsg", "clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { ((dpk)localObject).KIz, Integer.valueOf(((dpk)localObject).MSH), Integer.valueOf(((dpk)localObject).MSI), Integer.valueOf(((dpk)localObject).CreateTime), ((dpk)localObject).xNH, ((dpk)localObject).xNG, Integer.valueOf(((dpk)localObject).MSJ) });
      AppMethodBeat.o(206967);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(206968);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(206968);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(206969);
    Log.i("MicroMsg.NetSceneRevokePatMsg", "onGYNetEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).ae(this.msgId, this.dZs);
      params = com.tencent.mm.kernel.g.aAh().azQ().get(290818, Integer.valueOf(0));
      if (params == null) {
        break label207;
      }
    }
    label207:
    for (paramInt1 = Util.getInt(params.toString(), 0);; paramInt1 = 0)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(290818, Integer.valueOf(paramInt1 + 1));
      if (this.ARn != null)
      {
        this.ARn.eLW = 2;
        this.ARn.bfK();
        params = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(this.ARn);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(206969);
        return;
        if (this.ARn != null)
        {
          this.ARn.eLW = 1;
          this.ARn.bfK();
          params = com.tencent.mm.util.b.QYu;
          com.tencent.mm.util.b.a(this.ARn);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.a
 * JD-Core Version:    0.7.0.1
 */