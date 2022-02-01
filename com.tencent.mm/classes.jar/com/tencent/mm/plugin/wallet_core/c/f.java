package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public LinkedList<String> Bor;
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    ac.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new atd();
    ((b.a)localObject).hvu = new ate();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((b.a)localObject).funcId = getType();
    this.rr = ((b.a)localObject).aAz();
    this.rr.setIsUserCmd(true);
    localObject = (atd)this.rr.hvr.hvw;
    ((atd)localObject).EMi = paramLinkedList;
    ((atd)localObject).EhT = com.tencent.mm.plugin.wallet_core.model.k.ero();
    if (!com.tencent.mm.pluginsdk.wallet.e.eQw()) {
      ((atd)localObject).EnH = com.tencent.mm.pluginsdk.wallet.e.eQx();
    }
    com.tencent.mm.wallet_core.ui.e.adR(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ate)((b)paramq).hvs.hvw;
      ac.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { paramq.EMj });
      this.Bor = paramq.Bor;
      paramArrayOfByte = this.Bor;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        ac.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIx, bs.bG(paramq.EMj, ""));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIy, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      rt localrt = new rt();
      localrt.duH.duJ = paramArrayOfByte;
      a.GpY.l(localrt);
      break;
      com.tencent.mm.wallet_core.ui.e.adR(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */