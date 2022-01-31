package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class q$2
  implements com.tencent.mm.plugin.fts.a.l
{
  q$2(q paramq) {}
  
  public final void b(j paramj)
  {
    switch (paramj.aYY)
    {
    }
    do
    {
      do
      {
        return;
      } while ((q.a(this.vMn) == null) || (!q.a(this.vMn).equals(q.a(this.vMn))));
      q.a(this.vMn, paramj.kwi);
      q.a(this.vMn, paramj.kxh);
      if (paramj.kxh.size() > 0) {
        switch (((com.tencent.mm.plugin.fts.a.a.l)paramj.kxh.get(0)).type)
        {
        default: 
          y.i("MicroMsg.MMSearchContactAdapter", "not support search");
        }
      }
      for (;;)
      {
        boolean bool = q.c(this.vMn);
        q.a(this.vMn, paramj.ktu.bVk, bool);
        return;
        q.c(this.vMn, paramj.kxh);
        continue;
        q.d(this.vMn, paramj.kxh);
        continue;
        q.e(this.vMn, paramj.kxh);
        continue;
        if (q.e(this.vMn) != null) {
          q.e(this.vMn).addAll(paramj.kxh);
        } else {
          q.c(this.vMn, paramj.kxh);
        }
      }
    } while (!paramj.ktu.bVk.equals(q.d(this.vMn)));
    q.c(this.vMn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.q.2
 * JD-Core Version:    0.7.0.1
 */