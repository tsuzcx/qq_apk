package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements i
{
  public SparseArray<c.c> Nge;
  public boolean Ngf;
  public b Ngg;
  private a Ngh;
  public MTimerHandler Ngi;
  public int index;
  private long start;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.Nge = null;
    this.Ngf = false;
    this.Ngi = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (d.this.Ngf)
        {
          Log.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(d.this.index) });
          d.a(d.this);
          d.c(d.this).a(-1, d.b(d.this), null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.Ngh = parama;
    AppMethodBeat.o(29750);
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.Ngf)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.Nge = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.Ngf = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.fYF.getBytes().length;
      euw localeuw;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localeuw = new euw();
        localeuw.UwE = localc.Ngb;
        localeuw.UwF = localc.fYF;
        localeuw.Taj = new eae().dc(localc.ils);
        if ((localc.type == 1) || (ab.Lj(localc.source))) {
          localeuw.UwG = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localeuw.CPw), localc.id });
        localLinkedList.add(localeuw);
        this.Nge.put(localc.Ngb, localc);
        i += j;
        break;
        localeuw.CPw = 4;
        continue;
        localeuw.CPw = 1;
        continue;
        localeuw.CPw = 2;
        continue;
        localeuw.CPw = 3;
      }
    }
    this.Ngg = new b(localLinkedList);
    bh.aGY().a(this.Ngg, 0);
    this.start = System.currentTimeMillis();
    this.Ngi.startTimer(60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void gsq()
  {
    this.Ngg = null;
    this.Ngf = false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    bh.aGY().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29753);
    if (this.Ngg != paramq)
    {
      Log.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.Ngi.stopTimer();
    Log.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramq).NfW != null) {}
    for (int i = ((b)paramq).NfW.size();; i = 0)
    {
      Log.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      gsq();
      this.Ngh.a(paramInt2, this.Nge, ((b)paramq).NfW);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */