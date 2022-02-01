package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements i
{
  public SparseArray<c.c> Gts;
  public boolean Gtt;
  public b Gtu;
  a Gtv;
  public MTimerHandler Gtw;
  public int index;
  private long start;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.Gts = null;
    this.Gtt = false;
    this.Gtw = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (d.this.Gtt)
        {
          Log.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(d.this.index) });
          d.this.fAp();
          d.this.Gtv.a(-1, d.this.Gts, null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.Gtv = parama;
    AppMethodBeat.o(29750);
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.Gtt)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.Gts = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.Gtt = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.eeq.getBytes().length;
      ekr localekr;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localekr = new ekr();
        localekr.NjV = localc.Gtp;
        localekr.NjW = localc.eeq;
        localekr.LRE = new SKBuiltinBuffer_t().setBuffer(localc.fRc);
        if ((localc.type == 1) || (ab.Eq(localc.source))) {
          localekr.NjX = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localekr.Scene), localc.id });
        localLinkedList.add(localekr);
        this.Gts.put(localc.Gtp, localc);
        i += j;
        break;
        localekr.Scene = 4;
        continue;
        localekr.Scene = 1;
        continue;
        localekr.Scene = 2;
        continue;
        localekr.Scene = 3;
      }
    }
    this.Gtu = new b(localLinkedList);
    bg.azz().a(this.Gtu, 0);
    this.start = System.currentTimeMillis();
    this.Gtw.startTimer(60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void fAp()
  {
    this.Gtu = null;
    this.Gtt = false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    bg.azz().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29753);
    if (this.Gtu != paramq)
    {
      Log.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.Gtw.stopTimer();
    Log.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramq).Gtk != null) {}
    for (int i = ((b)paramq).Gtk.size();; i = 0)
    {
      Log.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      fAp();
      this.Gtv.a(paramInt2, this.Gts, ((b)paramq).Gtk);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */