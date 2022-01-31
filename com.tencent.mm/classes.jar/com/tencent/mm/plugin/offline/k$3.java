package com.tencent.mm.plugin.offline;

import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.y;

final class k$3
  implements a
{
  k$3(k paramk) {}
  
  public final void a(i.f paramf, i.g paramg, boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      k.bqa().dx(7, 7);
    }
  }
  
  public final void a(u.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k.3
 * JD-Core Version:    0.7.0.1
 */