package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.av.a;
import com.tencent.mm.av.e;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

final class d$1
  implements Runnable
{
  d$1(String paramString1, String paramString2, long paramLong) {}
  
  public final void run()
  {
    String str = this.vBi;
    Object localObject = str;
    if (s.fn(this.byr))
    {
      localObject = str;
      if (!bk.aM(str, "").startsWith("<"))
      {
        int i = this.vBi.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = this.vBi.substring(i + 1);
        }
      }
    }
    localObject = g.a.gp(bk.ZQ((String)localObject));
    if (localObject != null) {
      switch (((g.a)localObject).type)
      {
      }
    }
    for (;;)
    {
      return;
      localObject = a.Pw();
      if ((localObject != null) && (((e)localObject).eux != null) && (((e)localObject).euv == 0)) {
        try
        {
          long l = bk.getLong(((e)localObject).eux, 0L);
          if (this.vBj == l)
          {
            ai.d(new d.1.1(this));
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.1
 * JD-Core Version:    0.7.0.1
 */