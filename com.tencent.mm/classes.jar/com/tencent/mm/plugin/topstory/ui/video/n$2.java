package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class n$2
  implements f
{
  n$2(n paramn, com.tencent.mm.plugin.topstory.a.c.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((paramm instanceof com.tencent.mm.plugin.topstory.a.c.b)) && (paramm.equals(this.pGi)))
    {
      g.Dk().b(this.pGi.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        y.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    else
    {
      return;
    }
    e.post(new n.2.1(this, (bjq)((com.tencent.mm.plugin.topstory.a.c.b)paramm).dmK.ecF.ecN), "requestVideoUrlResultParse");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.2
 * JD-Core Version:    0.7.0.1
 */