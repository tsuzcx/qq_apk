package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.eiw;
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
  boolean GpB;
  private h GpC;
  boolean Gpq;
  private boolean Gpr;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final int abY(int paramInt)
  {
    AppMethodBeat.i(126426);
    int i = getHeadersCount();
    if (Util.isNullOrNil(((b)this.GlS).fyO().acd(paramInt - i).xuO))
    {
      AppMethodBeat.o(126426);
      return 0;
    }
    AppMethodBeat.o(126426);
    return 1;
  }
  
  public final void t(final List<eiw> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126425);
    super.t(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126424);
        for (;;)
        {
          synchronized (e.a(e.this).fyO())
          {
            List localList = ???.GW();
            Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label498;
            }
            int j = localList.size();
            if (localList.size() > 0)
            {
              if (!((eiw)localList.get(0)).psI.equals(((eiw)paramList.get(0)).psI))
              {
                paramList.remove(0);
                i = 0;
                localList.addAll(paramList);
                if (i != 0)
                {
                  localObject2 = (eiw)paramList.get(0);
                  localList.set(0, localObject2);
                  com.tencent.mm.plugin.topstory.ui.video.h localh = e.this.b((eiw)localObject2);
                  if (localh != null) {
                    localh.d((eiw)localObject2);
                  }
                }
                if (e.b(e.this))
                {
                  e.this.atj.notifyChanged();
                  e.a(e.this).fyB().j((eiw)localList.get(0));
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
                localObject2 = (eiw)localList.get(0);
                e.c(e.this).d((eiw)localObject2);
                e.d(e.this).put(((eiw)localObject2).psI, new WeakReference(e.c(e.this)));
                e.e(e.this);
                if (((((eiw)localObject2).Nix & 0x80) > 0) && (g.aAh().azQ().getInt(ar.a.Oga, 0) <= 0)) {
                  e.g(e.this).getRecyclerView().postDelayed(new e.1.1(this), 1000L);
                }
              }
              Object localObject2 = e.this;
              ((e)localObject2).as(((e)localObject2).getHeadersCount() + j, paramList.size() - j);
            }
          }
          localObject1.addAll(paramList);
          e.this.as(e.this.getHeadersCount(), paramList.size());
          continue;
          label498:
          int i = localObject1.size();
          localObject1.addAll(paramList);
          e locale = e.this;
          locale.as(i + locale.getHeadersCount(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */