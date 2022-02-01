package com.tencent.mm.plugin.patmsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.jq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.util.c;

public final class a
  extends q
  implements m
{
  public jq GKy;
  private i callback;
  private long fTl;
  private d lKU;
  private long msgId;
  
  public a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    AppMethodBeat.i(186613);
    Object localObject = h.aHG().aHp().b(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = Util.getInt(localObject.toString(), 0);; i = 0)
    {
      localObject = new d.a();
      ((d.a)localObject).lBU = new dzg();
      ((d.a)localObject).lBV = new dzh();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/revokemsg";
      ((d.a)localObject).funcId = 594;
      ((d.a)localObject).lBW = 0;
      ((d.a)localObject).respCmdId = 0;
      this.msgId = paramLong1;
      this.fTl = paramLong2;
      this.lKU = ((d.a)localObject).bgN();
      localObject = (dzg)d.b.b(this.lKU.lBR);
      ((dzg)localObject).RJQ = paramString1;
      ((dzg)localObject).UeO = 0;
      ((dzg)localObject).UeP = 0;
      ((dzg)localObject).UeR = paramLong2;
      ((dzg)localObject).CreateTime = ((int)(paramLong3 / 1000L));
      ((dzg)localObject).CRR = z.bcZ();
      ((dzg)localObject).CRQ = paramString2;
      ((dzg)localObject).UeQ = i;
      Log.i("MicroMsg.NetSceneRevokePatMsg", "clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { ((dzg)localObject).RJQ, Integer.valueOf(((dzg)localObject).UeO), Integer.valueOf(((dzg)localObject).UeP), Integer.valueOf(((dzg)localObject).CreateTime), ((dzg)localObject).CRR, ((dzg)localObject).CRQ, Integer.valueOf(((dzg)localObject).UeQ) });
      AppMethodBeat.o(186613);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(186614);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(186614);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186615);
    Log.i("MicroMsg.NetSceneRevokePatMsg", "onGYNetEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ((b)h.ae(b.class)).am(this.msgId, this.fTl);
      params = h.aHG().aHp().b(290818, Integer.valueOf(0));
      if (params == null) {
        break label207;
      }
    }
    label207:
    for (paramInt1 = Util.getInt(params.toString(), 0);; paramInt1 = 0)
    {
      h.aHG().aHp().i(290818, Integer.valueOf(paramInt1 + 1));
      if (this.GKy != null)
      {
        this.GKy.gLL = 2;
        this.GKy.bpa();
        params = c.Yyz;
        c.a(this.GKy);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(186615);
        return;
        if (this.GKy != null)
        {
          this.GKy.gLL = 1;
          this.GKy.bpa();
          params = c.Yyz;
          c.a(this.GKy);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.a
 * JD-Core Version:    0.7.0.1
 */