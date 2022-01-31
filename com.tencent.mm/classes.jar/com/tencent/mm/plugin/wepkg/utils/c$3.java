package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.mm.plugin.wepkg.model.g;
import java.util.List;

final class c$3
  implements Runnable
{
  c$3(c paramc, List paramList) {}
  
  public final void run()
  {
    int i = 0;
    while ((i < this.rQm.size()) && (i < 5))
    {
      String str = (String)this.rQm.get(i);
      g.cka().bw(str, false);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.3
 * JD-Core Version:    0.7.0.1
 */