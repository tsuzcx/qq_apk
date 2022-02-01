package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements f
{
  public SparseArray<c.c> BBo;
  public boolean BBp;
  public b BBq;
  a BBr;
  public av BBs;
  public int index;
  private long start;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.BBo = null;
    this.BBp = false;
    this.BBs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (d.this.BBp)
        {
          ad.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(d.this.index) });
          d.this.erp();
          d.this.BBr.a(-1, d.this.BBo, null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.BBr = parama;
    AppMethodBeat.o(29750);
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.BBp)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.BBo = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.BBp = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.dLj.getBytes().length;
      dpy localdpy;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localdpy = new dpy();
        localdpy.HEc = localc.BBl;
        localdpy.HEd = localc.dLj;
        localdpy.Gub = new SKBuiltinBuffer_t().setBuffer(localc.fkB);
        if ((localc.type == 1) || (w.vF(localc.source))) {
          localdpy.HEe = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        ad.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localdpy.Scene), localc.id });
        localLinkedList.add(localdpy);
        this.BBo.put(localc.BBl, localc);
        i += j;
        break;
        localdpy.Scene = 4;
        continue;
        localdpy.Scene = 1;
        continue;
        localdpy.Scene = 2;
        continue;
        localdpy.Scene = 3;
      }
    }
    this.BBq = new b(localLinkedList);
    ba.aiU().a(this.BBq, 0);
    this.start = System.currentTimeMillis();
    this.BBs.az(60000L, 60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void erp()
  {
    this.BBq = null;
    this.BBp = false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    ba.aiU().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29753);
    if (this.BBq != paramn)
    {
      ad.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.BBs.stopTimer();
    ad.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramn).BBg != null) {}
    for (int i = ((b)paramn).BBg.size();; i = 0)
    {
      ad.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      erp();
      this.BBr.a(paramInt2, this.BBo, ((b)paramn).BBg);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */