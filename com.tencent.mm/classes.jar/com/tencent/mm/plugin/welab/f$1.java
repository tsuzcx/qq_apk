package com.tencent.mm.plugin.welab;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements w.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    f.BF();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(86400) });
      f.access$100();
      f.hZ(86400);
      f.IV();
      return 0;
    }
    paramString = (aaq)paramb.ecF.ecN;
    f.access$100();
    f.ia(paramString.sSK);
    f.hZ(paramString.tao);
    f.O(paramString.tap);
    f.P(paramString.tan);
    f.IV();
    y.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramString.tao) });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.f.1
 * JD-Core Version:    0.7.0.1
 */