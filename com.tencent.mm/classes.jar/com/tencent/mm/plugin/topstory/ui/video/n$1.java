package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class n$1
  implements f
{
  public n$1(n paramn, j paramj) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1757);
    if (paramm == this.tjz)
    {
      g.Rc().b(1943, this);
      paramString = (j)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s, response json: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.cID().wAa });
        AppMethodBeat.o(1757);
        return;
      }
      d.post(new n.1.1(this, paramString), "TopStory.requestRelVideo");
    }
    AppMethodBeat.o(1757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.1
 * JD-Core Version:    0.7.0.1
 */