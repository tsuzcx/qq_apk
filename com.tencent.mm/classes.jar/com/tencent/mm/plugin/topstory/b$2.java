package com.tencent.mm.plugin.topstory;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.pa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$2
  implements f
{
  b$2(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.equals(this.pCU.pCT))
    {
      g.Dk().b(this.pCU.pCT.getType(), this);
      this.pCU.pCT = null;
    }
    paramString = (com.tencent.mm.plugin.topstory.a.c.a)paramm;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
      return;
    }
    g.DP().Dz().c(ac.a.uzv, paramString.bNh().sEb);
    paramString = new pa();
    com.tencent.mm.sdk.b.a.udP.m(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b.2
 * JD-Core Version:    0.7.0.1
 */