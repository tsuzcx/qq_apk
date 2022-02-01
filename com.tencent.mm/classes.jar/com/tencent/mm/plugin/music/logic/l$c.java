package com.tencent.mm.plugin.music.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

final class l$c
  implements Runnable
{
  List<String> LLN;
  
  private l$c(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(62965);
    Object localObject1 = b.Y(this.LLM.gng());
    int j = l.a(this.LLM);
    int i = 0;
    int k = 0;
    while (i < this.LLN.size())
    {
      if (((String)this.LLN.get(i)).equals(localObject1))
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
    localObject1 = l.b(this.LLM);
    for (i = j + 1;; i = 0) {
      try
      {
        while (i < this.LLN.size())
        {
          l.c(this.LLM).add((String)this.LLN.get(i));
          i += 1;
          continue;
          while (i < j)
          {
            l.c(this.LLM).add((String)this.LLN.get(i));
            i += 1;
          }
          Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(l.c(this.LLM).size()), Integer.valueOf(l.a(this.LLM)) });
          localObject1 = new ox();
          ((ox)localObject1).hRN.action = 5;
          ((ox)localObject1).publish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.l.c
 * JD-Core Version:    0.7.0.1
 */