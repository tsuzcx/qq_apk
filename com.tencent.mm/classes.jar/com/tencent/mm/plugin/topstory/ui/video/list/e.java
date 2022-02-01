package com.tencent.mm.plugin.topstory.ui.video.list;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  boolean TOL;
  private boolean TOM;
  boolean TOX;
  private h TOY;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final void I(final List<foh> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(126425);
    super.I(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126424);
        for (;;)
        {
          synchronized (e.a(e.this).hNK())
          {
            List localList = ???.aiJ();
            Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()) });
            if (!paramBoolean) {
              break label498;
            }
            int j = localList.size();
            if (localList.size() > 0)
            {
              if (!((foh)localList.get(0)).Ido.equals(((foh)paramList.get(0)).Ido))
              {
                paramList.remove(0);
                i = 0;
                localList.addAll(paramList);
                if (i != 0)
                {
                  localObject2 = (foh)paramList.get(0);
                  localList.set(0, localObject2);
                  com.tencent.mm.plugin.topstory.ui.video.h localh = e.this.b((foh)localObject2);
                  if (localh != null) {
                    localh.d((foh)localObject2);
                  }
                }
                if (e.b(e.this))
                {
                  e.this.bZE.notifyChanged();
                  e.a(e.this).hNx().j((foh)localList.get(0));
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
                localObject2 = (foh)localList.get(0);
                e.c(e.this).d((foh)localObject2);
                e.d(e.this).put(((foh)localObject2).Ido, new WeakReference(e.c(e.this)));
                e.e(e.this);
                if (((((foh)localObject2).abOE & 0x80) > 0) && (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acVZ, 0) <= 0)) {
                  e.g(e.this).getRecyclerView().postDelayed(new e.1.1(this), 1000L);
                }
              }
              Object localObject2 = e.this;
              ((e)localObject2).bA(((e)localObject2).hNP() + j, paramList.size() - j);
            }
          }
          localObject1.addAll(paramList);
          e.this.bA(e.this.hNP(), paramList.size());
          continue;
          label498:
          int i = localObject1.size();
          localObject1.addAll(paramList);
          e locale = e.this;
          locale.bA(i + locale.hNP(), paramList.size());
        }
      }
    });
    AppMethodBeat.o(126425);
  }
  
  public final int aoX(int paramInt)
  {
    AppMethodBeat.i(126426);
    int i = hNP();
    if (Util.isNullOrNil(((b)this.TLn).hNK().apc(paramInt - i).Idn))
    {
      AppMethodBeat.o(126426);
      return 0;
    }
    AppMethodBeat.o(126426);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */