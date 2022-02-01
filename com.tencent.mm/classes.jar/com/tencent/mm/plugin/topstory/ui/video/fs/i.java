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
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class i
  extends e
{
  protected b TLM;
  boolean TOL;
  private boolean TOM;
  private g TON;
  
  public i(b paramb)
  {
    super(paramb);
    this.TLM = paramb;
  }
  
  public final void I(final List<foh> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126395);
    super.I(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126394);
        for (;;)
        {
          synchronized (i.this.TLM.hNK())
          {
            Object localObject1 = ???.aiJ();
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
                i.this.bZE.notifyChanged();
                i.this.TLM.hNx().j((foh)paramList.get(0));
                AppMethodBeat.o(126394);
                return;
              }
              if ((i.b(i.this) != null) && (localObject1 != null) && (((List)localObject1).get(0) != null))
              {
                localObject1 = (foh)((List)localObject1).get(0);
                i.b(i.this).d((foh)localObject1);
                i.c(i.this).put(((foh)localObject1).Ido, new WeakReference(i.b(i.this)));
                i.d(i.this);
                if (((((foh)localObject1).abOE & 0x80) > 0) && (h.baE().ban().getInt(at.a.acVZ, 0) <= 0)) {
                  i.f(i.this).getRecyclerView().postDelayed(new i.1.1(this), 1000L);
                }
              }
              localObject1 = i.this;
              ((i)localObject1).bA(((i)localObject1).hNP() + i, paramList.size() - i);
            }
          }
          localObject2.addAll(paramList);
          i.this.bA(i.this.hNP(), paramList.size());
          continue;
          label374:
          int i = localObject2.size();
          localObject2.addAll(paramList);
          i locali = i.this;
          locali.fV(locali.hNP() + i);
          locali = i.this;
          locali.bA(i + locali.hNP(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126395);
  }
  
  public final int aoX(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i
 * JD-Core Version:    0.7.0.1
 */