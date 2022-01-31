package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;
import java.util.Map;

final class e$1
  implements Runnable
{
  e$1(e parame, List paramList, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2030);
    for (;;)
    {
      synchronized (((b)this.tln.thM).cJs())
      {
        List localList = ???.cKb();
        ab.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(this.tiV.size()) });
        if (!this.tiW) {
          break label426;
        }
        i = localList.size();
        if (localList.size() <= 0) {
          break label389;
        }
        if (!((ckx)localList.get(0)).xVa.equals(((ckx)this.tiV.get(0)).xVa))
        {
          this.tiV.remove(0);
          localList.addAll(this.tiV);
          if (this.tln.tld)
          {
            this.tln.ajb.notifyChanged();
            ((b)this.tln.thM).cJd().f((ckx)localList.get(0));
            AppMethodBeat.o(2030);
          }
        }
        else
        {
          localList.clear();
        }
      }
      if ((this.tln.tlm != null) && (localObject1 != null) && (localObject1.get(0) != null))
      {
        localObject2 = (ckx)localObject1.get(0);
        this.tln.tlm.d((ckx)localObject2);
        this.tln.thL.put(localObject2, this.tln.tlm);
        this.tln.tlm = null;
        if (((((ckx)localObject2).xVl & 0x80) > 0) && (g.RL().Ru().getInt(ac.a.yJG, 0) <= 0)) {
          this.tln.thM.getRecyclerView().postDelayed(new e.1.1(this), 1000L);
        }
      }
      Object localObject2 = this.tln;
      ((e)localObject2).ap(((e)localObject2).getHeadersCount() + i, this.tiV.size() - i);
      continue;
      label389:
      localObject1.addAll(this.tiV);
      this.tln.ap(this.tln.getHeadersCount(), this.tiV.size());
      continue;
      label426:
      int i = localObject1.size();
      localObject1.addAll(this.tiV);
      e locale = this.tln;
      locale.ap(i + locale.getHeadersCount(), this.tiV.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e.1
 * JD-Core Version:    0.7.0.1
 */