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
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  boolean Bxl;
  private boolean Bxm;
  boolean Bxw;
  private h Bxx;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final int Tb(int paramInt)
  {
    AppMethodBeat.i(126426);
    int i = getHeadersCount();
    if (bt.hj(((b)this.BtO).epL().Tg(paramInt - i).tSj))
    {
      AppMethodBeat.o(126426);
      return 0;
    }
    AppMethodBeat.o(126426);
    return 1;
  }
  
  public final void o(final List<dod> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126425);
    super.o(paramList, paramBoolean);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126424);
        for (;;)
        {
          synchronized (e.a(e.this).epL())
          {
            List localList = ???.cNm();
            ad.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label498;
            }
            int j = localList.size();
            if (localList.size() > 0)
            {
              if (!((dod)localList.get(0)).tSk.equals(((dod)paramList.get(0)).tSk))
              {
                paramList.remove(0);
                i = 0;
                localList.addAll(paramList);
                if (i != 0)
                {
                  localObject2 = (dod)paramList.get(0);
                  localList.set(0, localObject2);
                  com.tencent.mm.plugin.topstory.ui.video.h localh = e.this.b((dod)localObject2);
                  if (localh != null) {
                    localh.d((dod)localObject2);
                  }
                }
                if (e.b(e.this))
                {
                  e.this.asY.notifyChanged();
                  e.a(e.this).epx().i((dod)localList.get(0));
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
                localObject2 = (dod)localList.get(0);
                e.c(e.this).d((dod)localObject2);
                e.d(e.this).put(((dod)localObject2).tSk, new WeakReference(e.c(e.this)));
                e.e(e.this);
                if (((((dod)localObject2).HCD & 0x80) > 0) && (g.ajC().ajl().getInt(al.a.IDe, 0) <= 0)) {
                  e.g(e.this).getRecyclerView().postDelayed(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(126423);
                      ad.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
                      f.a locala = new f.a(aj.getContext());
                      locala.aXO(e.f(e.this).dhO().getString(2131764516)).yU(true);
                      locala.afp(2131755793).b(new f.c()
                      {
                        public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                      }).b(new DialogInterface.OnDismissListener()
                      {
                        public final void onDismiss(DialogInterface paramAnonymous3DialogInterface)
                        {
                          AppMethodBeat.i(126422);
                          g.ajC().ajl().set(al.a.IDe, Integer.valueOf(1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */