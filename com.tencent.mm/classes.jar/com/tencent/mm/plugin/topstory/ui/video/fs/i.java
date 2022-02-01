package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class i
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  protected b BLL;
  boolean BOJ;
  private boolean BOK;
  private g BOL;
  
  public i(b paramb)
  {
    super(paramb);
    this.BLL = paramb;
  }
  
  public final int TI(int paramInt)
  {
    return 0;
  }
  
  public final void o(final List<dpa> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126395);
    super.o(paramList, paramBoolean);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126394);
        for (;;)
        {
          synchronized (i.this.BLL.ets())
          {
            Object localObject1 = ???.cPU();
            ae.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramList.size()) });
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
                i.this.asY.notifyChanged();
                i.this.BLL.ete().i((dpa)paramList.get(0));
                AppMethodBeat.o(126394);
                return;
              }
              if ((i.b(i.this) != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
              {
                localObject1 = (dpa)((List)localObject1).get(0);
                i.b(i.this).d((dpa)localObject1);
                i.c(i.this).put(((dpa)localObject1).udb, new WeakReference(i.b(i.this)));
                i.d(i.this);
                if (((((dpa)localObject1).HWq & 0x80) > 0) && (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IXE, 0) <= 0)) {
                  i.f(i.this).getRecyclerView().postDelayed(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(126393);
                      f.a locala = new f.a(ak.getContext());
                      locala.aZq(i.e(i.this).dkN().getString(2131764516)).zi(true);
                      locala.afY(2131766205).b(new f.c()
                      {
                        public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                      }).b(new DialogInterface.OnDismissListener()
                      {
                        public final void onDismiss(DialogInterface paramAnonymous3DialogInterface)
                        {
                          AppMethodBeat.i(126392);
                          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXE, Integer.valueOf(1));
                          com.tencent.mm.kernel.g.ajR().ajA().fuc();
                          AppMethodBeat.o(126392);
                        }
                      }).show();
                      AppMethodBeat.o(126393);
                    }
                  }, 1000L);
                }
              }
              localObject1 = i.this;
              ((i)localObject1).ar(((i)localObject1).getHeadersCount() + i, paramList.size() - i);
            }
          }
          localObject2.addAll(paramList);
          i.this.ar(i.this.getHeadersCount(), paramList.size());
          continue;
          label374:
          int i = localObject2.size();
          localObject2.addAll(paramList);
          i locali = i.this;
          locali.cj(locali.getHeadersCount() + i);
          locali = i.this;
          locali.ar(i + locali.getHeadersCount(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i
 * JD-Core Version:    0.7.0.1
 */