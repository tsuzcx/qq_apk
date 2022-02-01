package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  private boolean AfA;
  boolean AfK;
  private h AfL;
  boolean Afz;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final int Rr(int paramInt)
  {
    AppMethodBeat.i(126426);
    int i = getHeadersCount();
    if (bs.gY(((b)this.Acd).edt().Rw(paramInt - i).sVE))
    {
      AppMethodBeat.o(126426);
      return 0;
    }
    AppMethodBeat.o(126426);
    return 1;
  }
  
  public final void n(final List<dio> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126425);
    super.n(paramList, paramBoolean);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126424);
        for (;;)
        {
          synchronized (e.a(e.this).edt())
          {
            List localList = ???.eed();
            ac.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label498;
            }
            int j = localList.size();
            if (localList.size() > 0)
            {
              if (!((dio)localList.get(0)).sVF.equals(((dio)paramList.get(0)).sVF))
              {
                paramList.remove(0);
                i = 0;
                localList.addAll(paramList);
                if (i != 0)
                {
                  localObject2 = (dio)paramList.get(0);
                  localList.set(0, localObject2);
                  com.tencent.mm.plugin.topstory.ui.video.h localh = e.this.b((dio)localObject2);
                  if (localh != null) {
                    localh.d((dio)localObject2);
                  }
                }
                if (e.b(e.this))
                {
                  e.this.arg.notifyChanged();
                  e.a(e.this).edf().i((dio)localList.get(0));
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
                localObject2 = (dio)localList.get(0);
                e.c(e.this).d((dio)localObject2);
                e.d(e.this).put(((dio)localObject2).sVF, new WeakReference(e.c(e.this)));
                e.e(e.this);
                if (((((dio)localObject2).FRX & 0x80) > 0) && (g.agR().agA().getInt(ah.a.GQH, 0) <= 0)) {
                  e.g(e.this).getRecyclerView().postDelayed(new e.1.1(this), 1000L);
                }
              }
              Object localObject2 = e.this;
              ((e)localObject2).aq(((e)localObject2).getHeadersCount() + j, paramList.size() - j);
            }
          }
          localObject1.addAll(paramList);
          e.this.aq(e.this.getHeadersCount(), paramList.size());
          continue;
          label498:
          int i = localObject1.size();
          localObject1.addAll(paramList);
          e locale = e.this;
          locale.aq(i + locale.getHeadersCount(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */