package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public LinkedList<String> Dgl;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    ae.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axr();
    ((b.a)localObject).hQG = new axs();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((b.a)localObject).funcId = getType();
    this.rr = ((b.a)localObject).aDS();
    this.rr.setIsUserCmd(true);
    localObject = (axr)this.rr.hQD.hQJ;
    ((axr)localObject).GOL = paramLinkedList;
    ((axr)localObject).Ghz = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    if (!com.tencent.mm.pluginsdk.wallet.e.fjq()) {
      ((axr)localObject).Gnp = com.tencent.mm.pluginsdk.wallet.e.fjr();
    }
    com.tencent.mm.wallet_core.ui.f.aha(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (axs)((b)paramq).hQE.hQJ;
      ae.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { paramq.GOM });
      this.Dgl = paramq.Dgl;
      paramArrayOfByte = this.Dgl;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        ae.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        g.ajS();
        g.ajR().ajA().set(am.a.IPn, bu.bI(paramq.GOM, ""));
        g.ajS();
        g.ajR().ajA().set(am.a.IPo, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      sg localsg = new sg();
      localsg.dHO.dHQ = paramArrayOfByte;
      a.IvT.l(localsg);
      break;
      com.tencent.mm.wallet_core.ui.f.aha(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */