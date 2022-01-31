package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.protocal.c.btm;
import java.util.LinkedList;

final class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  public final void run()
  {
    if ((System.currentTimeMillis() - i.b(this.olO) >= 60000L) || (i.a(this.olO).sve.size() > 1000))
    {
      if ((i.a(this.olO) != null) && (i.a(this.olO).sve.size() > 0)) {
        i.d(this.olO);
      }
      i.a(this.olO, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i.3
 * JD-Core Version:    0.7.0.1
 */