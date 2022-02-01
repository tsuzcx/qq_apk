package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements f
{
  public SparseArray<c.c> BSM;
  public boolean BSN;
  public b BSO;
  a BSP;
  public aw BSQ;
  public int index;
  private long start;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.BSM = null;
    this.BSN = false;
    this.BSQ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (d.this.BSN)
        {
          ae.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(d.this.index) });
          d.this.euW();
          d.this.BSP.a(-1, d.this.BSM, null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.BSP = parama;
    AppMethodBeat.o(29750);
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.BSN)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.BSM = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.BSN = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.dMy.getBytes().length;
      dqv localdqv;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localdqv = new dqv();
        localdqv.HXP = localc.BSJ;
        localdqv.HXQ = localc.dMy;
        localdqv.GNA = new SKBuiltinBuffer_t().setBuffer(localc.fmy);
        if ((localc.type == 1) || (x.wb(localc.source))) {
          localdqv.HXR = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        ae.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localdqv.Scene), localc.id });
        localLinkedList.add(localdqv);
        this.BSM.put(localc.BSJ, localc);
        i += j;
        break;
        localdqv.Scene = 4;
        continue;
        localdqv.Scene = 1;
        continue;
        localdqv.Scene = 2;
        continue;
        localdqv.Scene = 3;
      }
    }
    this.BSO = new b(localLinkedList);
    bc.ajj().a(this.BSO, 0);
    this.start = System.currentTimeMillis();
    this.BSQ.ay(60000L, 60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void euW()
  {
    this.BSO = null;
    this.BSN = false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    bc.ajj().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29753);
    if (this.BSO != paramn)
    {
      ae.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.BSQ.stopTimer();
    ae.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramn).BSE != null) {}
    for (int i = ((b)paramn).BSE.size();; i = 0)
    {
      ae.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      euW();
      this.BSP.a(paramInt2, this.BSM, ((b)paramn).BSE);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */