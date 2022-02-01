package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

final class m$b
  implements Runnable
{
  List<String> wAj;
  
  private m$b(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(62965);
    Object localObject1 = com.tencent.mm.plugin.music.h.b.O(this.wAi.dwa());
    int j = m.a(this.wAi);
    int i = 0;
    int k = 0;
    while (i < this.wAj.size())
    {
      if (((String)this.wAj.get(i)).equals(localObject1))
      {
        j = i;
        k = 1;
      }
      i += 1;
    }
    if (k == 0)
    {
      AppMethodBeat.o(62965);
      return;
    }
    localObject1 = m.b(this.wAi);
    for (i = j + 1;; i = 0) {
      try
      {
        while (i < this.wAj.size())
        {
          m.c(this.wAi).add(this.wAj.get(i));
          i += 1;
          continue;
          while (i < j)
          {
            m.c(this.wAi).add(this.wAj.get(i));
            i += 1;
          }
          ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(this.wAi).size()), Integer.valueOf(m.a(this.wAi)) });
          localObject1 = new mg();
          ((mg)localObject1).dAP.action = 5;
          a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          AppMethodBeat.o(62965);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(62965);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.b
 * JD-Core Version:    0.7.0.1
 */