package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class i$1
  implements Runnable
{
  i$1(i parami, List paramList, boolean paramBoolean) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized (this.pHD.pEP.bNJ())
      {
        List localList = ???.cnS();
        y.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(this.pFy.size()) });
        if (!this.pFz) {
          break label279;
        }
        i = localList.size();
        if (localList.size() > 0)
        {
          localList.clear();
          localList.addAll(this.pFy);
          if (this.pHD.pHB)
          {
            this.pHD.agL.notifyChanged();
            this.pHD.pEP.bNt().b((byg)this.pFy.get(0));
            return;
          }
          if ((this.pHD.pHC != null) && (localList != null) && (localList.get(0) != null))
          {
            this.pHD.pHC.a((byg)localList.get(0));
            this.pHD.pHC = null;
          }
          this.pHD.aj(this.pHD.pEn.size() + i, this.pFy.size() - i);
        }
      }
      localObject.addAll(this.pFy);
      this.pHD.aj(this.pHD.pEn.size(), this.pFy.size());
      continue;
      label279:
      int i = localObject.size();
      localObject.addAll(this.pFy);
      this.pHD.bL(this.pHD.pEn.size() + i);
      this.pHD.aj(i + this.pHD.pEn.size(), this.pFy.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i.1
 * JD-Core Version:    0.7.0.1
 */