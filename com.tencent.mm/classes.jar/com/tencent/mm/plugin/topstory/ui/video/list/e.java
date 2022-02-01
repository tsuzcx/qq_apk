package com.tencent.mm.plugin.topstory.ui.video.list;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  boolean Ncc;
  private boolean Ncd;
  boolean Ncn;
  private h Nco;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final int ajE(int paramInt)
  {
    AppMethodBeat.i(126426);
    int i = gqR();
    if (Util.isNullOrNil(((b)this.MYE).gqL().ajJ(paramInt - i).Crg))
    {
      AppMethodBeat.o(126426);
      return 0;
    }
    AppMethodBeat.o(126426);
    return 1;
  }
  
  public final void u(final List<esy> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126425);
    super.u(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126424);
        for (;;)
        {
          synchronized (e.a(e.this).gqL())
          {
            List localList = ???.eiH();
            Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label498;
            }
            int j = localList.size();
            if (localList.size() > 0)
            {
              if (!((esy)localList.get(0)).Crh.equals(((esy)paramList.get(0)).Crh))
              {
                paramList.remove(0);
                i = 0;
                localList.addAll(paramList);
                if (i != 0)
                {
                  localObject2 = (esy)paramList.get(0);
                  localList.set(0, localObject2);
                  com.tencent.mm.plugin.topstory.ui.video.h localh = e.this.b((esy)localObject2);
                  if (localh != null) {
                    localh.d((esy)localObject2);
                  }
                }
                if (e.b(e.this))
                {
                  e.this.alc.notifyChanged();
                  e.a(e.this).gqy().j((esy)localList.get(0));
                  AppMethodBeat.o(126424);
                }
              }
              else
              {
                localList.clear();
                i = 1;
                continue;
              }
              if ((e.c(e.this) != null) && (localList != null) && (localList.get(0) != null))
              {
                localObject2 = (esy)localList.get(0);
                e.c(e.this).d((esy)localObject2);
                e.d(e.this).put(((esy)localObject2).Crh, new WeakReference(e.c(e.this)));
                e.e(e.this);
                if (((((esy)localObject2).Uvd & 0x80) > 0) && (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vuq, 0) <= 0)) {
                  e.g(e.this).getRecyclerView().postDelayed(new e.1.1(this), 1000L);
                }
              }
              Object localObject2 = e.this;
              ((e)localObject2).aG(((e)localObject2).gqR() + j, paramList.size() - j);
            }
          }
          localObject1.addAll(paramList);
          e.this.aG(e.this.gqR(), paramList.size());
          continue;
          label498:
          int i = localObject1.size();
          localObject1.addAll(paramList);
          e locale = e.this;
          locale.aG(i + locale.gqR(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */