package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.h.a.hk;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;

final class ap$4
  extends c<hk>
{
  ap$4(ap paramap)
  {
    this.udX = hk.class.getName().hashCode();
  }
  
  private static boolean a(hk paramhk)
  {
    for (;;)
    {
      try
      {
        e locale = g.AA();
        if (locale != null) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        int i = 0;
        continue;
      }
      paramhk.bPp.bIY = i;
      return false;
      i = bk.getInt(g.AA().getValue("AndroidUseUnicodeEmoji"), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap.4
 * JD-Core Version:    0.7.0.1
 */