package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cp;
import com.tencent.mm.h.a.cp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class a$1$1
  implements com.tencent.mm.ah.f
{
  a$1$1(a.1 param1, cp.a parama, cp paramcp, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    g.DO().dJT.b(580, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.SubCoreECard", "jsapi check success");
      com.tencent.mm.pluginsdk.wallet.f.Xf(((a)paramm).bUH());
      paramString = (Context)this.qJI.aoB.get();
      if ((paramString != null) && ((paramString instanceof Activity)))
      {
        com.tencent.mm.plugin.wallet_ecard.a.b.a(bk.getInt(this.qJJ.bII.bIN, 0), this.qJJ.bII.token, this.qJJ.bII.bIM, this.qJK, paramString, new a.1.1.1(this));
        return;
      }
      this.qJJ.bIJ.retCode = -1;
      this.qJJ.bII.bFJ.run();
      return;
    }
    y.e("MicroMsg.SubCoreECard", "jsapi check fail");
    this.qJJ.bIJ.retCode = -1;
    this.qJJ.bII.bFJ.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.1.1
 * JD-Core Version:    0.7.0.1
 */