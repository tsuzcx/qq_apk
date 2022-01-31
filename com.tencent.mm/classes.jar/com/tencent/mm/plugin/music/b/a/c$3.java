package com.tencent.mm.plugin.music.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;

final class c$3
  implements Runnable
{
  c$3(c paramc, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, String paramString3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public final void run()
  {
    AppMethodBeat.i(104818);
    Object localObject1 = this.oXh + "-" + ag.cE(this.hvi);
    for (;;)
    {
      synchronized (c.bFm())
      {
        if (!c.bFm().containsKey(localObject1)) {
          break label307;
        }
        c.a(c.bUO(), (String)localObject1, this.nlw);
        c.a(c.bUP(), (String)localObject1, this.oXQ);
        c.a(c.bUQ(), (String)localObject1, this.oXR);
        int i = ((Integer)c.bFm().get(localObject1)).intValue() - 1;
        if (i > 0)
        {
          c.bFm().put(localObject1, Integer.valueOf(i));
          if (!this.oXP)
          {
            c.zT(1);
            c.bUR();
            if (c.Nt().containsKey(localObject1))
            {
              i = ((Integer)c.Nt().get(localObject1)).intValue() - 1;
              if (i <= 0) {
                break label335;
              }
              c.Nt().put(localObject1, Integer.valueOf(i));
            }
            if ((!this.oXP) && (!TextUtils.isEmpty(this.oXS)))
            {
              if (!c.bUT().containsKey(this.oXS)) {
                break label346;
              }
              localObject1 = (c.a)c.bUT().get(this.oXS);
              if (localObject1 != null) {
                ((c.a)localObject1).playCount += 1;
              }
              ((c.a)localObject1).oXY = this.oXT;
              ((c.a)localObject1).fileSize = this.oXU;
              ((c.a)localObject1).duration = this.val$duration;
              c.bUT().put(this.oXS, localObject1);
            }
            AppMethodBeat.o(104818);
          }
        }
        else
        {
          c.bFm().remove(localObject1);
        }
      }
      c.bUS();
      continue;
      label307:
      ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio not exist audioKey, audioId:%s, audioSrc:%s", new Object[] { this.oXh, this.hvi });
      continue;
      label335:
      c.Nt().remove(localObject2);
      continue;
      label346:
      c.a locala = new c.a(this.oXO);
      locala.playCount = 1;
      locala.oXY = this.oXT;
      locala.fileSize = this.oXU;
      locala.duration = this.val$duration;
      c.bUT().put(this.oXS, locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.c.3
 * JD-Core Version:    0.7.0.1
 */