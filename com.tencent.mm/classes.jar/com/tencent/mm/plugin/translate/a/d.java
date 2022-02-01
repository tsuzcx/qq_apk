package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements g
{
  public int index;
  private long start;
  public SparseArray<c.c> yVN;
  public boolean yVO;
  public b yVP;
  a yVQ;
  public av yVR;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.yVN = null;
    this.yVO = false;
    this.yVR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (d.this.yVO)
        {
          ad.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(d.this.index) });
          d.this.dQz();
          d.this.yVQ.a(-1, d.this.yVN, null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.yVQ = parama;
    AppMethodBeat.o(29750);
  }
  
  public final void dQz()
  {
    this.yVP = null;
    this.yVO = false;
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.yVO)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.yVN = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.yVO = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.dBj.getBytes().length;
      des localdes;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localdes = new des();
        localdes.Ewl = localc.yVK;
        localdes.Ewm = localc.dBj;
        localdes.DpV = new SKBuiltinBuffer_t().setBuffer(localc.ePe);
        if ((localc.type == 1) || (w.pF(localc.source))) {
          localdes.Ewn = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        ad.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localdes.Scene), localc.id });
        localLinkedList.add(localdes);
        this.yVN.put(localc.yVK, localc);
        i += j;
        break;
        localdes.Scene = 4;
        continue;
        localdes.Scene = 1;
        continue;
        localdes.Scene = 2;
        continue;
        localdes.Scene = 3;
      }
    }
    this.yVP = new b(localLinkedList);
    az.aeS().a(this.yVP, 0);
    this.start = System.currentTimeMillis();
    this.yVR.av(60000L, 60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    az.aeS().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29753);
    if (this.yVP != paramn)
    {
      ad.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.yVR.stopTimer();
    ad.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramn).yVF != null) {}
    for (int i = ((b)paramn).yVF.size();; i = 0)
    {
      ad.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      dQz();
      this.yVQ.a(paramInt2, this.yVN, ((b)paramn).yVF);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */