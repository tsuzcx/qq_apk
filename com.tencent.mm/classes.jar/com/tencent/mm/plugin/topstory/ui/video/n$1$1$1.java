package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.LinearLayoutManager;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class n$1$1$1
  implements Runnable
{
  n$1$1$1(n.1.1 param1, List paramList) {}
  
  public final void run()
  {
    for (;;)
    {
      byg localbyg;
      int i;
      int j;
      int m;
      int k;
      int n;
      synchronized (this.pGh.pGf.pGd)
      {
        List localList = this.pGh.pGf.pGd.cnS();
        if ((bk.dk(this.pGg)) || (bk.dk(localList)) || (!(this.pGh.pGf.pGd.pEp.getLayoutManager() instanceof LinearLayoutManager))) {
          break label389;
        }
        localbyg = (byg)this.pGg.get(0);
        i = 0;
        if (i < localList.size())
        {
          if (!((byg)localList.get(i)).tOx.equals(localbyg.tOx)) {
            break label402;
          }
          y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=item exist");
          return;
        }
        j = ((byg)this.pGg.get(0)).sgk;
        m = this.pGh.pGf.pGd.pEp.bNB();
        k = this.pGh.pGf.pGd.pEp.bND().pEn.size();
        i = ((LinearLayoutManager)this.pGh.pGf.pGd.pEp.getLayoutManager()).ha() - k;
        n = localList.size() - 1;
        if (m == n)
        {
          y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=last pos");
          return;
        }
      }
      if ((j <= m) || (j <= i) || (j > n + 1)) {
        j = i + 1;
      }
      for (;;)
      {
        i = j;
        if (j <= 0) {
          i = m + 1;
        }
        j = i;
        if (i > localObject.size()) {
          j = localObject.size();
        }
        localObject.add(j, localbyg);
        y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "insert success pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), localbyg.tOx, localbyg.title });
        this.pGh.pGf.pGd.pEp.bND().bM(j + k);
        for (;;)
        {
          return;
          label389:
          y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=result list or curlist is null");
        }
      }
      label402:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.1.1.1
 * JD-Core Version:    0.7.0.1
 */