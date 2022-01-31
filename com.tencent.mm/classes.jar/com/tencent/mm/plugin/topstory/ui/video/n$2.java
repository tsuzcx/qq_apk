package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class n$2
  implements f
{
  n$2(n paramn, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1759);
    if (((paramm instanceof e)) && (paramm.equals(this.tjF)))
    {
      g.Rc().b(this.tjF.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(1759);
        return;
      }
      d.post(new n.2.1(this, (bsl)((e)paramm).rr.fsW.fta), "requestVideoUrlResultParse");
    }
    AppMethodBeat.o(1759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.2
 * JD-Core Version:    0.7.0.1
 */