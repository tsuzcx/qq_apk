package com.tencent.mm.plugin.patmsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class a
  extends n
  implements k
{
  private f callback;
  private long dGB;
  private com.tencent.mm.al.b hWL;
  private long msgId;
  public ec wFJ;
  
  public a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    AppMethodBeat.i(215711);
    Object localObject = g.ajC().ajl().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bt.getInt(localObject.toString(), 0);; i = 0)
    {
      localObject = new b.a();
      ((b.a)localObject).hNM = new cvw();
      ((b.a)localObject).hNN = new cvx();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokemsg";
      ((b.a)localObject).funcId = 594;
      ((b.a)localObject).hNO = 0;
      ((b.a)localObject).respCmdId = 0;
      this.msgId = paramLong1;
      this.dGB = paramLong2;
      this.hWL = ((b.a)localObject).aDC();
      localObject = (cvw)this.hWL.hNK.hNQ;
      ((cvw)localObject).Fwt = paramString1;
      ((cvw)localObject).HnV = 0;
      ((cvw)localObject).HnW = 0;
      ((cvw)localObject).HnY = paramLong2;
      ((cvw)localObject).CreateTime = ((int)(paramLong3 / 1000L));
      ((cvw)localObject).ukj = u.aAm();
      ((cvw)localObject).uki = paramString2;
      ((cvw)localObject).HnX = i;
      ad.i("MicroMsg.NetSceneRevokePatMsg", "clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { ((cvw)localObject).Fwt, Integer.valueOf(((cvw)localObject).HnV), Integer.valueOf(((cvw)localObject).HnW), Integer.valueOf(((cvw)localObject).CreateTime), ((cvw)localObject).ukj, ((cvw)localObject).uki, Integer.valueOf(((cvw)localObject).HnX) });
      AppMethodBeat.o(215711);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(215712);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215712);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215713);
    ad.i("MicroMsg.NetSceneRevokePatMsg", "onGYNetEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).ab(this.msgId, this.dGB);
      paramq = g.ajC().ajl().get(290818, Integer.valueOf(0));
      if (paramq == null) {
        break label207;
      }
    }
    label207:
    for (paramInt1 = bt.getInt(paramq.toString(), 0);; paramInt1 = 0)
    {
      g.ajC().ajl().set(290818, Integer.valueOf(paramInt1 + 1));
      if (this.wFJ != null)
      {
        this.wFJ.ehD = 2;
        this.wFJ.aLk();
        paramq = com.tencent.mm.util.b.Lgy;
        com.tencent.mm.util.b.a(this.wFJ);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(215713);
        return;
        if (this.wFJ != null)
        {
          this.wFJ.ehD = 1;
          this.wFJ.aLk();
          paramq = com.tencent.mm.util.b.Lgy;
          com.tencent.mm.util.b.a(this.wFJ);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.a
 * JD-Core Version:    0.7.0.1
 */