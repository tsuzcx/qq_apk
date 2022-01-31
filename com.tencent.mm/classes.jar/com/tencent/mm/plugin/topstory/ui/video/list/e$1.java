package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class e$1
  implements Runnable
{
  e$1(e parame, List paramList, boolean paramBoolean) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized (((b)this.pHH.pEp).bNJ())
      {
        List localList = ???.cnS();
        y.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(this.pFy.size()) });
        if (!this.pFz) {
          break label331;
        }
        i = localList.size();
        if (localList.size() <= 0) {
          break label291;
        }
        if (!((byg)localList.get(0)).tOx.equals(((byg)this.pFy.get(0)).tOx))
        {
          this.pFy.remove(0);
          localList.addAll(this.pFy);
          if (this.pHH.pHB)
          {
            this.pHH.agL.notifyChanged();
            ((b)this.pHH.pEp).bNt().b((byg)localList.get(0));
          }
        }
        else
        {
          localList.clear();
        }
      }
      if ((this.pHH.pHG != null) && (localObject != null) && (localObject.get(0) != null))
      {
        this.pHH.pHG.a((byg)localObject.get(0));
        this.pHH.pHG = null;
      }
      this.pHH.aj(this.pHH.pEn.size() + i, this.pFy.size() - i);
      continue;
      label291:
      localObject.addAll(this.pFy);
      this.pHH.aj(this.pHH.pEn.size(), this.pFy.size());
      continue;
      label331:
      int i = localObject.size();
      localObject.addAll(this.pFy);
      this.pHH.aj(i + this.pHH.pEn.size(), this.pFy.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e.1
 * JD-Core Version:    0.7.0.1
 */