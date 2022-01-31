package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class n$1$1$1
  implements Runnable
{
  n$1$1$1(n.1.1 param1, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(1755);
    for (;;)
    {
      synchronized (this.tjE.tjC.tjA)
      {
        List localList = this.tjE.tjC.tjA.cKb();
        if ((!bo.es(this.tjD)) && (!bo.es(localList)) && ((this.tjE.tjC.tjA.thM.getLayoutManager() instanceof LinearLayoutManager)))
        {
          ckx localckx = (ckx)this.tjD.get(0);
          int i = 0;
          if (i < localList.size())
          {
            if (((ckx)localList.get(i)).xVa.equals(localckx.xVa))
            {
              ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=item exist");
              AppMethodBeat.o(1755);
              return;
            }
            i += 1;
          }
          else
          {
            int j = ((ckx)this.tjD.get(0)).vYf;
            int m = this.tjE.tjC.tjA.thM.cJk();
            int k = this.tjE.tjC.tjA.thM.cJm().getHeadersCount();
            i = ((LinearLayoutManager)this.tjE.tjC.tjA.thM.getLayoutManager()).iv();
            int n = localList.size() - 1;
            if (m == n)
            {
              ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=last pos");
              AppMethodBeat.o(1755);
              return;
            }
            if ((j <= m) || (j > n + 1))
            {
              j = i - k + 1;
              i = j;
              if (j <= 0) {
                i = m + 1;
              }
              j = i;
              if (i > localList.size()) {
                j = localList.size();
              }
              localList.add(j, localckx);
              ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "insert success pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), localckx.xVa, localckx.title });
              this.tjE.tjC.tjA.thM.cJm().bS(j + k);
              AppMethodBeat.o(1755);
            }
          }
        }
        else
        {
          ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=result list or curlist is null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.1.1.1
 * JD-Core Version:    0.7.0.1
 */