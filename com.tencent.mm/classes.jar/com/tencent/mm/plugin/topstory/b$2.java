package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$2
  implements f
{
  b$2(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(65454);
    if (paramm.equals(this.teJ.teF))
    {
      g.Rc().b(this.teJ.teF.getType(), this);
      this.teJ.teF = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
        AppMethodBeat.o(65454);
      }
    }
    else
    {
      AppMethodBeat.o(65454);
      return;
    }
    g.RL().Ru().set(ac.a.yKj, paramString.cID().wAa);
    g.RL().Ru().dww();
    paramString = new qf();
    a.ymk.l(paramString);
    AppMethodBeat.o(65454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b.2
 * JD-Core Version:    0.7.0.1
 */