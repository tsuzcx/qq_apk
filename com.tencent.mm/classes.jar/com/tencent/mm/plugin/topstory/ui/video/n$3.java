package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class n$3
  implements f
{
  n$3(n paramn) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(1760);
    ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if (paramm.equals(this.tjA.tjw))
    {
      g.Rc().b(1943, this.tjA.fur);
      this.tjA.tjw = null;
      paramm = (j)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", new Object[] { paramm.cID().wAa });
        a.kS(2);
        this.tjA.thM.aen(paramString);
        this.tjA.tju = false;
        AppMethodBeat.o(1760);
        return;
      }
      paramString = new n.a(this.tjA, (byte)0);
      n.a.a(paramString, paramm.cID().wAa);
      if (paramm.tfp.offset != 0) {
        break label204;
      }
    }
    for (;;)
    {
      n.a.a(paramString, bool);
      d.post(paramString, "TopStory.DecodeRecommendResultTask");
      AppMethodBeat.o(1760);
      return;
      label204:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.3
 * JD-Core Version:    0.7.0.1
 */