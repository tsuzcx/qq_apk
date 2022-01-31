package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.c.aym;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.cbw;
import com.tencent.mm.protocal.c.cdm;
import com.tencent.mm.protocal.c.cdo;
import com.tencent.mm.protocal.c.cdp;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$2$1
  implements Runnable
{
  n$2$1(n.2 param2, bjq parambjq) {}
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    ??? = this.pGj.tDt.sxL.iterator();
    Object localObject4;
    Object localObject3;
    Object localObject5;
    while (((Iterator)???).hasNext())
    {
      localObject4 = (cdp)((Iterator)???).next();
      localObject3 = new byg();
      if (!bk.bl(((cdp)localObject4).tSk.sPH))
      {
        ((byg)localObject3).tOx = ((cdp)localObject4).tSk.sPH;
        if ((((cdp)localObject4).tSm != null) && (((cdp)localObject4).tSm.tSi == 1)) {
          if ((((cdp)localObject4).tSm.tSj != null) && (!bk.dk(((cdp)localObject4).tSm.tSj.tuw)))
          {
            ((byg)localObject3).tOG.clear();
            localObject4 = ((cdp)localObject4).tSm.tSj.tuw.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (cbw)((Iterator)localObject4).next();
              ((byg)localObject3).tOG.add(((cbw)localObject5).tQW.coM());
              ((byg)localObject3).tOF = ((cbw)localObject5).tQY;
            }
            ((byg)localObject3).videoUrl = g.cO(((byg)localObject3).tOG);
          }
        }
        for (;;)
        {
          localArrayList.add(localObject3);
          break;
          if (!bk.bl(((cdp)localObject4).tSn))
          {
            ((byg)localObject3).tOG.clear();
            n.b((byg)localObject3, ((cdp)localObject4).tSn, "");
            ((byg)localObject3).videoUrl = g.cO(((byg)localObject3).tOG);
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.pGk.pGd)
      {
        localObject3 = this.pGk.pGd.cnS();
        if (!bk.dk((List)localObject3)) {
          break label452;
        }
        return;
        if (i >= ((List)localObject3).size()) {
          break label449;
        }
        localObject4 = (byg)((List)localObject3).get(i);
        localObject5 = localArrayList.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          byg localbyg = (byg)((Iterator)localObject5).next();
          if (!((byg)localObject4).tOx.equals(localbyg.tOx)) {
            continue;
          }
          ((byg)localObject4).tOG = localbyg.tOG;
          ((byg)localObject4).tOF = localbyg.tOF;
          ((byg)localObject4).videoUrl = localbyg.videoUrl;
          y.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((byg)localObject4).title, ((byg)localObject4).videoUrl });
        }
      }
      i += 1;
      continue;
      label449:
      return;
      label452:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.2.1
 * JD-Core Version:    0.7.0.1
 */