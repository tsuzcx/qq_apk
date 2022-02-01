package com.tencent.mm.plugin.patmsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class a
  extends n
  implements k
{
  private f callback;
  private long dHH;
  private com.tencent.mm.ak.b hZD;
  private long msgId;
  public ee wVu;
  
  public a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    AppMethodBeat.i(220345);
    Object localObject = g.ajR().ajA().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bu.getInt(localObject.toString(), 0);; i = 0)
    {
      localObject = new b.a();
      ((b.a)localObject).hQF = new cwq();
      ((b.a)localObject).hQG = new cwr();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokemsg";
      ((b.a)localObject).funcId = 594;
      ((b.a)localObject).hQH = 0;
      ((b.a)localObject).respCmdId = 0;
      this.msgId = paramLong1;
      this.dHH = paramLong2;
      this.hZD = ((b.a)localObject).aDS();
      localObject = (cwq)this.hZD.hQD.hQJ;
      ((cwq)localObject).FOR = paramString1;
      ((cwq)localObject).HHv = 0;
      ((cwq)localObject).HHw = 0;
      ((cwq)localObject).HHy = paramLong2;
      ((cwq)localObject).CreateTime = ((int)(paramLong3 / 1000L));
      ((cwq)localObject).uvG = v.aAC();
      ((cwq)localObject).uvF = paramString2;
      ((cwq)localObject).HHx = i;
      ae.i("MicroMsg.NetSceneRevokePatMsg", "clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { ((cwq)localObject).FOR, Integer.valueOf(((cwq)localObject).HHv), Integer.valueOf(((cwq)localObject).HHw), Integer.valueOf(((cwq)localObject).CreateTime), ((cwq)localObject).uvG, ((cwq)localObject).uvF, Integer.valueOf(((cwq)localObject).HHx) });
      AppMethodBeat.o(220345);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(220346);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(220346);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220347);
    ae.i("MicroMsg.NetSceneRevokePatMsg", "onGYNetEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).aa(this.msgId, this.dHH);
      paramq = g.ajR().ajA().get(290818, Integer.valueOf(0));
      if (paramq == null) {
        break label207;
      }
    }
    label207:
    for (paramInt1 = bu.getInt(paramq.toString(), 0);; paramInt1 = 0)
    {
      g.ajR().ajA().set(290818, Integer.valueOf(paramInt1 + 1));
      if (this.wVu != null)
      {
        this.wVu.ejn = 2;
        this.wVu.aLH();
        paramq = com.tencent.mm.util.b.LDa;
        com.tencent.mm.util.b.a(this.wVu);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(220347);
        return;
        if (this.wVu != null)
        {
          this.wVu.ejn = 1;
          this.wVu.aLH();
          paramq = com.tencent.mm.util.b.LDa;
          com.tencent.mm.util.b.a(this.wVu);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.a
 * JD-Core Version:    0.7.0.1
 */