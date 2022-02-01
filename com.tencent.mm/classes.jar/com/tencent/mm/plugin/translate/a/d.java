package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements g
{
  public SparseArray<c.c> AjC;
  public boolean AjD;
  public b AjE;
  a AjF;
  public au AjG;
  public int index;
  private long start;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.AjC = null;
    this.AjD = false;
    this.AjG = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (d.this.AjD)
        {
          ac.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(d.this.index) });
          d.this.eeY();
          d.this.AjF.a(-1, d.this.AjC, null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.AjF = parama;
    AppMethodBeat.o(29750);
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.AjD)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.AjC = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.AjD = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.dyX.getBytes().length;
      dkh localdkh;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localdkh = new dkh();
        localdkh.FTo = localc.Ajz;
        localdkh.FTp = localc.dyX;
        localdkh.EKY = new SKBuiltinBuffer_t().setBuffer(localc.eSm);
        if ((localc.type == 1) || (w.sQ(localc.source))) {
          localdkh.FTq = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        ac.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localdkh.Scene), localc.id });
        localLinkedList.add(localdkh);
        this.AjC.put(localc.Ajz, localc);
        i += j;
        break;
        localdkh.Scene = 4;
        continue;
        localdkh.Scene = 1;
        continue;
        localdkh.Scene = 2;
        continue;
        localdkh.Scene = 3;
      }
    }
    this.AjE = new b(localLinkedList);
    az.agi().a(this.AjE, 0);
    this.start = System.currentTimeMillis();
    this.AjG.au(60000L, 60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void eeY()
  {
    this.AjE = null;
    this.AjD = false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    az.agi().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29753);
    if (this.AjE != paramn)
    {
      ac.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.AjG.stopTimer();
    ac.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramn).Aju != null) {}
    for (int i = ((b)paramn).Aju.size();; i = 0)
    {
      ac.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      eeY();
      this.AjF.a(paramInt2, this.AjC, ((b)paramn).Aju);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */