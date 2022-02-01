package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private b rr;
  public LinkedList<String> zVX;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    ad.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new apz();
    ((b.a)localObject).gUV = new aqa();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((b.a)localObject).funcId = getType();
    this.rr = ((b.a)localObject).atI();
    this.rr.setIsUserCmd(true);
    localObject = (apz)this.rr.gUS.gUX;
    ((apz)localObject).Drg = paramLinkedList;
    ((apz)localObject).CPi = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    if (!com.tencent.mm.pluginsdk.wallet.e.eBc()) {
      ((apz)localObject).CUX = com.tencent.mm.pluginsdk.wallet.e.eBd();
    }
    com.tencent.mm.wallet_core.ui.e.aby(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(69898);
    this.callback = paramg;
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
      paramq = (aqa)((b)paramq).gUT.gUX;
      ad.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { paramq.Drh });
      this.zVX = paramq.zVX;
      paramArrayOfByte = this.zVX;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        ad.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FkI, bt.by(paramq.Drh, ""));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FkJ, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      rk localrk = new rk();
      localrk.dwU.dwW = paramArrayOfByte;
      a.ESL.l(localrk);
      break;
      com.tencent.mm.wallet_core.ui.e.aby(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */