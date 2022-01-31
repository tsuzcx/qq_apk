package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.ai.m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private b rr;
  public LinkedList<String> ubt;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(46495);
    ab.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ags();
    ((b.a)localObject).fsY = new agt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((b.a)localObject).funcId = getType();
    this.rr = ((b.a)localObject).ado();
    this.rr.setIsUserCmd(true);
    localObject = (ags)this.rr.fsV.fta;
    ((ags)localObject).wZr = paramLinkedList;
    ((ags)localObject).wDH = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (!com.tencent.mm.pluginsdk.wallet.g.dpN()) {
      ((ags)localObject).wIZ = com.tencent.mm.pluginsdk.wallet.g.dpO();
    }
    com.tencent.mm.wallet_core.ui.e.RX(42);
    AppMethodBeat.o(46495);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(46496);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46496);
    return i;
  }
  
  public final int getType()
  {
    return 1650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46497);
    ab.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (agt)((b)paramq).fsW.fta;
      ab.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { paramq.wZs });
      this.ubt = paramq.ubt;
      paramArrayOfByte = this.ubt;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        ab.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCm, bo.bf(paramq.wZs, ""));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCn, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(46497);
      return;
      pt localpt = new pt();
      localpt.cGk.cGm = paramArrayOfByte;
      a.ymk.l(localpt);
      break;
      com.tencent.mm.wallet_core.ui.e.RX(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */