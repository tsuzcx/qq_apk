package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class m$b
  implements Runnable
{
  List<String> oZp;
  
  private m$b(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(104839);
    Object localObject1 = com.tencent.mm.plugin.music.h.b.K(this.oZo.bVs());
    int j = m.a(this.oZo);
    int i = 0;
    int k = 0;
    while (i < this.oZp.size())
    {
      if (((String)this.oZp.get(i)).equals(localObject1))
      {
        j = i;
        k = 1;
      }
      i += 1;
    }
    if (k == 0)
    {
      AppMethodBeat.o(104839);
      return;
    }
    localObject1 = m.b(this.oZo);
    for (i = j + 1;; i = 0) {
      try
      {
        while (i < this.oZp.size())
        {
          m.c(this.oZo).add(this.oZp.get(i));
          i += 1;
          continue;
          while (i < j)
          {
            m.c(this.oZo).add(this.oZp.get(i));
            i += 1;
          }
          ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(this.oZo).size()), Integer.valueOf(m.a(this.oZo)) });
          localObject1 = new ki();
          ((ki)localObject1).cAc.action = 5;
          a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
          AppMethodBeat.o(104839);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(104839);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.b
 * JD-Core Version:    0.7.0.1
 */