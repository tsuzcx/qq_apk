package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class n$3
  implements f
{
  n$3(n paramn) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if (paramm.equals(this.pGd.pFZ))
    {
      g.Dk().b(1943, this.pGd.eeo);
      this.pGd.pFZ = null;
      paramm = (c)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramm.bNh().sEb });
        a.jdMethod_if(2);
        this.pGd.pEp.PL(paramString);
        this.pGd.pFX = false;
      }
    }
    else
    {
      return;
    }
    paramString = new n.a(this.pGd, (byte)0);
    n.a.a(paramString, paramm.bNh().sEb);
    if (paramm.pDB.offset == 0) {}
    for (;;)
    {
      n.a.a(paramString, bool);
      e.post(paramString, "TopStory.DecodeRecommendResultTask");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.3
 * JD-Core Version:    0.7.0.1
 */