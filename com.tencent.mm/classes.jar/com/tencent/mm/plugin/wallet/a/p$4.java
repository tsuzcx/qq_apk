package com.tencent.mm.plugin.wallet.a;

import android.os.Looper;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

final class p$4
  implements j.a
{
  p$4(p paramp) {}
  
  private void bTN()
  {
    if (((k)g.r(k.class)).aSz())
    {
      bs localbs = new bs();
      localbs.bFJ = new p.4.1(this, localbs);
      a.udP.a(localbs, Looper.getMainLooper());
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = com.tencent.mm.model.c.c.IX().fJ("100428");
      if (paramString.isValid()) {
        break label48;
      }
      y.i("MicroMsg.SubCoreMMWallet", "invalid faceid abtest");
      bTN();
    }
    label48:
    while (bk.getInt((String)paramString.ctr().get("openFaceIdPay"), 0) != 0) {
      return;
    }
    y.i("MicroMsg.SubCoreMMWallet", "close faceid abtest");
    bTN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p.4
 * JD-Core Version:    0.7.0.1
 */