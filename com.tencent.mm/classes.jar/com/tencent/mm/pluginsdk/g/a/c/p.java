package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class p
{
  public static void clK()
  {
    if (g.DN().Dc())
    {
      g.DN();
      if (!a.CW()) {
        break label20;
      }
    }
    label20:
    long l;
    do
    {
      do
      {
        return;
      } while (getNetworkType() == 0);
      l = bk.UX();
    } while (bk.a((Long)g.DP().Dz().get(ac.a.uqS, null), 0L) >= l);
    g.DP().Dz().c(ac.a.uqS, Long.valueOf(7200L + l));
    y.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
    q.a.clL().DS().O(new p.1());
  }
  
  static int getNetworkType()
  {
    switch ()
    {
    default: 
      return 2;
    case 0: 
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.p
 * JD-Core Version:    0.7.0.1
 */