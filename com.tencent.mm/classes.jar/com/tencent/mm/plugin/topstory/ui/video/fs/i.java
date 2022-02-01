package com.tencent.mm.plugin.topstory.ui.video.fs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class i
  extends e
{
  protected b MZd;
  boolean Ncc;
  private boolean Ncd;
  private g Nce;
  
  public i(b paramb)
  {
    super(paramb);
    this.MZd = paramb;
  }
  
  public final int ajE(int paramInt)
  {
    return 0;
  }
  
  public final void u(final List<esy> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126395);
    super.u(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126394);
        for (;;)
        {
          synchronized (i.this.MZd.gqL())
          {
            Object localObject1 = ???.eiH();
            Log.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label374;
            }
            i = ((List)localObject1).size();
            if (((List)localObject1).size() > 0)
            {
              ((List)localObject1).clear();
              ((List)localObject1).addAll(paramList);
              if (i.a(i.this))
              {
                i.this.alc.notifyChanged();
                i.this.MZd.gqy().j((esy)paramList.get(0));
                AppMethodBeat.o(126394);
                return;
              }
              if ((i.b(i.this) != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
              {
                localObject1 = (esy)((List)localObject1).get(0);
                i.b(i.this).d((esy)localObject1);
                i.c(i.this).put(((esy)localObject1).Crh, new WeakReference(i.b(i.this)));
                i.d(i.this);
                if (((((esy)localObject1).Uvd & 0x80) > 0) && (h.aHG().aHp().getInt(ar.a.Vuq, 0) <= 0)) {
                  i.f(i.this).getRecyclerView().postDelayed(new i.1.1(this), 1000L);
                }
              }
              localObject1 = i.this;
              ((i)localObject1).aG(((i)localObject1).gqR() + i, paramList.size() - i);
            }
          }
          localObject2.addAll(paramList);
          i.this.aG(i.this.gqR(), paramList.size());
          continue;
          label374:
          int i = localObject2.size();
          localObject2.addAll(paramList);
          i locali = i.this;
          locali.cL(locali.gqR() + i);
          locali = i.this;
          locali.aG(i + locali.gqR(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i
 * JD-Core Version:    0.7.0.1
 */