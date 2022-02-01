package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public LinkedList<String> COG;
  private com.tencent.mm.al.f callback;
  private b rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    ad.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new axb();
    ((b.a)localObject).hNN = new axc();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((b.a)localObject).funcId = getType();
    this.rr = ((b.a)localObject).aDC();
    this.rr.setIsUserCmd(true);
    localObject = (axb)this.rr.hNK.hNQ;
    ((axb)localObject).Gvm = paramLinkedList;
    ((axb)localObject).FPa = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    if (!com.tencent.mm.pluginsdk.wallet.e.ffA()) {
      ((axb)localObject).FUQ = com.tencent.mm.pluginsdk.wallet.e.ffB();
    }
    com.tencent.mm.wallet_core.ui.e.agr(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(69898);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69898);
    return i;
  }
  
  public final int getType()
  {
    return 1650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69899);
    ad.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (axc)((b)paramq).hNL.hNQ;
      ad.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { paramq.Gvn });
      this.COG = paramq.COG;
      paramArrayOfByte = this.COG;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        ad.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        g.ajD();
        g.ajC().ajl().set(al.a.IuP, bt.bI(paramq.Gvn, ""));
        g.ajD();
        g.ajC().ajl().set(al.a.IuQ, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      sf localsf = new sf();
      localsf.dGI.dGK = paramArrayOfByte;
      a.IbL.l(localsf);
      break;
      com.tencent.mm.wallet_core.ui.e.agr(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */