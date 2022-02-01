package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class i
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  protected b Gmr;
  boolean Gpq;
  private boolean Gpr;
  private g Gps;
  
  public i(b paramb)
  {
    super(paramb);
    this.Gmr = paramb;
  }
  
  public final int abY(int paramInt)
  {
    return 0;
  }
  
  public final void t(final List<eiw> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126395);
    super.t(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126394);
        for (;;)
        {
          synchronized (i.this.Gmr.fyO())
          {
            Object localObject1 = ???.GW();
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
                i.this.atj.notifyChanged();
                i.this.Gmr.fyB().j((eiw)paramList.get(0));
                AppMethodBeat.o(126394);
                return;
              }
              if ((i.b(i.this) != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
              {
                localObject1 = (eiw)((List)localObject1).get(0);
                i.b(i.this).d((eiw)localObject1);
                i.c(i.this).put(((eiw)localObject1).psI, new WeakReference(i.b(i.this)));
                i.d(i.this);
                if (((((eiw)localObject1).Nix & 0x80) > 0) && (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Oga, 0) <= 0)) {
                  i.f(i.this).getRecyclerView().postDelayed(new i.1.1(this), 1000L);
                }
              }
              localObject1 = i.this;
              ((i)localObject1).as(((i)localObject1).getHeadersCount() + i, paramList.size() - i);
            }
          }
          localObject2.addAll(paramList);
          i.this.as(i.this.getHeadersCount(), paramList.size());
          continue;
          label374:
          int i = localObject2.size();
          localObject2.addAll(paramList);
          i locali = i.this;
          locali.ci(locali.getHeadersCount() + i);
          locali = i.this;
          locali.as(i + locali.getHeadersCount(), paramList.size());
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