package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class a$1$1
  implements f
{
  a$1$1(a.1 param1, cs.a parama, cs paramcs, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48038);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(580, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.SubCoreECard", "jsapi check success");
      com.tencent.mm.pluginsdk.wallet.g.ana(((d)paramm).cSW());
      paramString = (Context)this.uyA.aqU.get();
      if ((paramString != null) && ((paramString instanceof Activity)))
      {
        a.a(this.uyD.uyz, new a.a(this.uyD.uyz, this.uyB));
        com.tencent.mm.plugin.wallet_ecard.a.b.a(bo.getInt(this.uyB.cqd.cqi, 0), this.uyB.cqd.token, this.uyB.cqd.cqh, this.uyC, paramString, a.a(this.uyD.uyz));
        AppMethodBeat.o(48038);
        return;
      }
      this.uyB.cqe.retCode = -1;
      this.uyB.cqd.callback.run();
      AppMethodBeat.o(48038);
      return;
    }
    ab.e("MicroMsg.SubCoreECard", "jsapi check fail");
    this.uyB.cqe.retCode = -1;
    this.uyB.cqd.callback.run();
    AppMethodBeat.o(48038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.1.1
 * JD-Core Version:    0.7.0.1
 */