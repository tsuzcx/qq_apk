package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class i
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  protected b AcC;
  private boolean AfA;
  private g AfB;
  boolean Afz;
  
  public i(b paramb)
  {
    super(paramb);
    this.AcC = paramb;
  }
  
  public final int Rr(int paramInt)
  {
    return 0;
  }
  
  public final void n(final List<dio> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126395);
    super.n(paramList, paramBoolean);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126394);
        for (;;)
        {
          synchronized (i.this.AcC.edt())
          {
            Object localObject1 = ???.eed();
            ac.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramList.size()) });
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
                i.this.arg.notifyChanged();
                i.this.AcC.edf().i((dio)paramList.get(0));
                AppMethodBeat.o(126394);
                return;
              }
              if ((i.b(i.this) != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
              {
                localObject1 = (dio)((List)localObject1).get(0);
                i.b(i.this).d((dio)localObject1);
                i.c(i.this).put(((dio)localObject1).sVF, new WeakReference(i.b(i.this)));
                i.d(i.this);
                if (((((dio)localObject1).FRX & 0x80) > 0) && (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GQH, 0) <= 0)) {
                  i.f(i.this).getRecyclerView().postDelayed(new i.1.1(this), 1000L);
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
          locali.cj(locali.getHeadersCount() + i);
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