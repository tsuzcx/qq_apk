package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

final class m$b
  implements Runnable
{
  List<String> wkA;
  
  private m$b(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(62965);
    Object localObject1 = com.tencent.mm.plugin.music.h.b.O(this.wkz.dsL());
    int j = m.a(this.wkz);
    int i = 0;
    int k = 0;
    while (i < this.wkA.size())
    {
      if (((String)this.wkA.get(i)).equals(localObject1))
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
    localObject1 = m.b(this.wkz);
    for (i = j + 1;; i = 0) {
      try
      {
        while (i < this.wkA.size())
        {
          m.c(this.wkz).add(this.wkA.get(i));
          i += 1;
          continue;
          while (i < j)
          {
            m.c(this.wkz).add(this.wkA.get(i));
            i += 1;
          }
          ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(this.wkz).size()), Integer.valueOf(m.a(this.wkz)) });
          localObject1 = new mf();
          ((mf)localObject1).dzK.action = 5;
          a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
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