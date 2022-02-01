package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class b$2
  implements i
{
  b$2(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(88418);
    if (paramq.equals(this.GiT.GiP))
    {
      g.azz().b(this.GiT.GiP.getType(), this);
      this.GiT.GiP = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
        AppMethodBeat.o(88418);
      }
    }
    else
    {
      AppMethodBeat.o(88418);
      return;
    }
    g.aAh().azQ().set(ar.a.OgP, paramString.fxZ().MaZ);
    g.aAh().azQ().gBI();
    paramString = new ts();
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(88418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b.2
 * JD-Core Version:    0.7.0.1
 */