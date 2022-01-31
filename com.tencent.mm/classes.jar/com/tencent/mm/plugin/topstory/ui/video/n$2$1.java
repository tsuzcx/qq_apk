package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$2$1
  implements Runnable
{
  n$2$1(n.2 param2, bsl parambsl) {}
  
  public final void run()
  {
    AppMethodBeat.i(1758);
    ArrayList localArrayList = new ArrayList();
    ??? = this.tjG.xFU.wrp.iterator();
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Object localObject6;
    while (((Iterator)???).hasNext())
    {
      localObject4 = (cqx)((Iterator)???).next();
      localObject3 = new ckx();
      if (!bo.isNullOrNil(((cqx)localObject4).xZj.wNY))
      {
        ((ckx)localObject3).xVa = ((cqx)localObject4).xZj.wNY;
        if ((((cqx)localObject4).xZl != null) && (((cqx)localObject4).xZl.xZh == 1)) {
          if ((((cqx)localObject4).xZl.xZi != null) && (!bo.es(((cqx)localObject4).xZl.xZi.xuy)))
          {
            ((ckx)localObject3).xVj.clear();
            localObject4 = ((cqx)localObject4).xZl.xZi.xuy.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (cpc)((Iterator)localObject4).next();
              localObject6 = new ckz();
              ((ckz)localObject6).url = ((cpc)localObject5).xXQ.dqj();
              ((ckz)localObject6).xVo = 0;
              ((ckx)localObject3).xVj.add(localObject6);
              ((ckx)localObject3).xVi = ((cpc)localObject5).xXS;
            }
            localObject4 = g.dQ(((ckx)localObject3).xVj);
            if (localObject4 != null)
            {
              ((ckx)localObject3).videoUrl = ((ckz)localObject4).url;
              ((ckx)localObject3).xVo = ((ckz)localObject4).xVo;
            }
          }
        }
        for (;;)
        {
          localArrayList.add(localObject3);
          break;
          if (!bo.isNullOrNil(((cqx)localObject4).xZm))
          {
            ((ckx)localObject3).xVj.clear();
            n.b((ckx)localObject3, ((cqx)localObject4).xZm, "");
            localObject4 = g.dQ(((ckx)localObject3).xVj);
            if (localObject4 != null)
            {
              ((ckx)localObject3).videoUrl = ((ckz)localObject4).url;
              ((ckx)localObject3).xVo = ((ckz)localObject4).xVo;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.tjH.tjA)
      {
        localObject3 = this.tjH.tjA.cKb();
        if (bo.es((List)localObject3))
        {
          AppMethodBeat.o(1758);
          return;
        }
        i = 0;
        if (i >= ((List)localObject3).size()) {
          break;
        }
        localObject4 = (ckx)((List)localObject3).get(i);
        localObject5 = localArrayList.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ckx)((Iterator)localObject5).next();
          if (!((ckx)localObject4).xVa.equals(((ckx)localObject6).xVa)) {
            continue;
          }
          ((ckx)localObject4).xVj = ((ckx)localObject6).xVj;
          ((ckx)localObject4).xVi = ((ckx)localObject6).xVi;
          ((ckx)localObject4).videoUrl = ((ckx)localObject6).videoUrl;
          ab.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((ckx)localObject4).title, ((ckx)localObject4).videoUrl });
        }
      }
      i += 1;
    }
    AppMethodBeat.o(1758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.2.1
 * JD-Core Version:    0.7.0.1
 */