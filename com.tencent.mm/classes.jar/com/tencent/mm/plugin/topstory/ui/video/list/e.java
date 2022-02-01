package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  boolean BOJ;
  private boolean BOK;
  boolean BOU;
  private h BOV;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final int TI(int paramInt)
  {
    AppMethodBeat.i(126426);
    int i = getHeadersCount();
    if (bu.ht(((b)this.BLm).ets().TN(paramInt - i).uda))
    {
      AppMethodBeat.o(126426);
      return 0;
    }
    AppMethodBeat.o(126426);
    return 1;
  }
  
  public final void o(final List<dpa> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126425);
    super.o(paramList, paramBoolean);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126424);
        for (;;)
        {
          synchronized (e.a(e.this).ets())
          {
            List localList = ???.cPU();
            ae.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label498;
            }
            int j = localList.size();
            if (localList.size() > 0)
            {
              if (!((dpa)localList.get(0)).udb.equals(((dpa)paramList.get(0)).udb))
              {
                paramList.remove(0);
                i = 0;
                localList.addAll(paramList);
                if (i != 0)
                {
                  localObject2 = (dpa)paramList.get(0);
                  localList.set(0, localObject2);
                  com.tencent.mm.plugin.topstory.ui.video.h localh = e.this.b((dpa)localObject2);
                  if (localh != null) {
                    localh.d((dpa)localObject2);
                  }
                }
                if (e.b(e.this))
                {
                  e.this.asY.notifyChanged();
                  e.a(e.this).ete().i((dpa)localList.get(0));
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
                localObject2 = (dpa)localList.get(0);
                e.c(e.this).d((dpa)localObject2);
                e.d(e.this).put(((dpa)localObject2).udb, new WeakReference(e.c(e.this)));
                e.e(e.this);
                if (((((dpa)localObject2).HWq & 0x80) > 0) && (g.ajR().ajA().getInt(am.a.IXE, 0) <= 0)) {
                  e.g(e.this).getRecyclerView().postDelayed(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(126423);
                      ae.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
                      f.a locala = new f.a(ak.getContext());
                      locala.aZq(e.f(e.this).dkN().getString(2131764516)).zi(true);
                      locala.afY(2131755793).b(new f.c()
                      {
                        public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                      }).b(new DialogInterface.OnDismissListener()
                      {
                        public final void onDismiss(DialogInterface paramAnonymous3DialogInterface)
                        {
                          AppMethodBeat.i(126422);
                          g.ajR().ajA().set(am.a.IXE, Integer.valueOf(1));
                          AppMethodBeat.o(126422);
                        }
                      }).show();
                      AppMethodBeat.o(126423);
                    }
                  }, 1000L);
                }
              }
              Object localObject2 = e.this;
              ((e)localObject2).ar(((e)localObject2).getHeadersCount() + j, paramList.size() - j);
            }
          }
          localObject1.addAll(paramList);
          e.this.ar(e.this.getHeadersCount(), paramList.size());
          continue;
          label498:
          int i = localObject1.size();
          localObject1.addAll(paramList);
          e locale = e.this;
          locale.ar(i + locale.getHeadersCount(), paramList.size());
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