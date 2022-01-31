package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void run()
  {
    String str = this.mxJ + "-" + ad.bB(this.mxK);
    for (;;)
    {
      synchronized (a.aYI())
      {
        if (a.aYI().containsKey(str))
        {
          a.a(a.AD(), str, this.mxM);
          a.a(a.bmE(), str, this.mxN);
          a.a(a.bmF(), str, this.mxO);
          int i = ((Integer)a.aYI().get(str)).intValue() - 1;
          if (i > 0)
          {
            a.aYI().put(str, Integer.valueOf(i));
            return;
          }
          a.aYI().remove(str);
        }
      }
      y.d("MicroMsg.Audio.AudioReportService", "leonlaudio not exist audioKey");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.a.2
 * JD-Core Version:    0.7.0.1
 */