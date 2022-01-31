package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami, List paramList, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2008);
    for (;;)
    {
      synchronized (this.tlf.tim.cJs())
      {
        Object localObject1 = ???.cKb();
        ab.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(this.tiV.size()) });
        if (!this.tiW) {
          break label367;
        }
        i = ((List)localObject1).size();
        if (((List)localObject1).size() > 0)
        {
          ((List)localObject1).clear();
          ((List)localObject1).addAll(this.tiV);
          if (this.tlf.tld)
          {
            this.tlf.ajb.notifyChanged();
            this.tlf.tim.cJd().f((ckx)this.tiV.get(0));
            AppMethodBeat.o(2008);
            return;
          }
          if ((this.tlf.tle != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
          {
            localObject1 = (ckx)((List)localObject1).get(0);
            this.tlf.tle.d((ckx)localObject1);
            this.tlf.thL.put(localObject1, this.tlf.tle);
            this.tlf.tle = null;
            if (((((ckx)localObject1).xVl & 0x80) > 0) && (com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yJG, 0) <= 0)) {
              this.tlf.thM.getRecyclerView().postDelayed(new i.1.1(this), 1000L);
            }
          }
          localObject1 = this.tlf;
          ((i)localObject1).ap(((i)localObject1).getHeadersCount() + i, this.tiV.size() - i);
        }
      }
      localObject2.addAll(this.tiV);
      this.tlf.ap(this.tlf.getHeadersCount(), this.tiV.size());
      continue;
      label367:
      int i = localObject2.size();
      localObject2.addAll(this.tiV);
      i locali = this.tlf;
      locali.bR(locali.getHeadersCount() + i);
      locali = this.tlf;
      locali.ap(i + locali.getHeadersCount(), this.tiV.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i.1
 * JD-Core Version:    0.7.0.1
 */