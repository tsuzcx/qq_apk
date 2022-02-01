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
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class i
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  protected b yOL;
  boolean yRK;
  private boolean yRL;
  private g yRM;
  
  public i(b paramb)
  {
    super(paramb);
    this.yOL = paramb;
  }
  
  public final int Pl(int paramInt)
  {
    return 0;
  }
  
  public final void m(final List<ddb> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126395);
    super.m(paramList, paramBoolean);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126394);
        for (;;)
        {
          synchronized (i.this.yOL.dOT())
          {
            Object localObject1 = ???.dPE();
            ad.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramList.size()) });
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
                i.this.aql.notifyChanged();
                i.this.yOL.dOF().i((ddb)paramList.get(0));
                AppMethodBeat.o(126394);
                return;
              }
              if ((i.b(i.this) != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
              {
                localObject1 = (ddb)((List)localObject1).get(0);
                i.b(i.this).d((ddb)localObject1);
                i.c(i.this).put(((ddb)localObject1).rNP, new WeakReference(i.b(i.this)));
                i.d(i.this);
                if (((((ddb)localObject1).EuW & 0x80) > 0) && (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.FsP, 0) <= 0)) {
                  i.f(i.this).getRecyclerView().postDelayed(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(126393);
                      f.a locala = new f.a(aj.getContext());
                      locala.aMo(i.e(i.this).cKW().getString(2131764516)).wZ(true);
                      locala.aaF(2131766205).b(new f.c()
                      {
                        public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                      }).b(new DialogInterface.OnDismissListener()
                      {
                        public final void onDismiss(DialogInterface paramAnonymous3DialogInterface)
                        {
                          AppMethodBeat.i(126392);
                          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsP, Integer.valueOf(1));
                          com.tencent.mm.kernel.g.afB().afk().eKy();
                          AppMethodBeat.o(126392);
                        }
                      }).show();
                      AppMethodBeat.o(126393);
                    }
                  }, 1000L);
                }
              }
              localObject1 = i.this;
              ((i)localObject1).aq(((i)localObject1).getHeadersCount() + i, paramList.size() - i);
            }
          }
          localObject2.addAll(paramList);
          i.this.aq(i.this.getHeadersCount(), paramList.size());
          continue;
          label374:
          int i = localObject2.size();
          localObject2.addAll(paramList);
          i locali = i.this;
          locali.ck(locali.getHeadersCount() + i);
          locali = i.this;
          locali.aq(i + locali.getHeadersCount(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i
 * JD-Core Version:    0.7.0.1
 */