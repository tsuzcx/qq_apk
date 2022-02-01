package com.tencent.mm.plugin.translate.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Queue;

public final class f
  implements h
{
  public SparseArray<e.c> TTc;
  public boolean TTd;
  public b TTe;
  private a TTf;
  public MTimerHandler TTg;
  public int index;
  private long start;
  
  public f(int paramInt, a parama)
  {
    AppMethodBeat.i(29750);
    this.TTc = null;
    this.TTd = false;
    this.TTg = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29749);
        if (f.this.TTd)
        {
          Log.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(f.this.index) });
          f.a(f.this);
          f.c(f.this).a(-1, f.b(f.this), null);
        }
        AppMethodBeat.o(29749);
        return false;
      }
    }, false);
    this.index = paramInt;
    this.TTf = parama;
    AppMethodBeat.o(29750);
  }
  
  public final boolean g(Queue<e.c> paramQueue)
  {
    AppMethodBeat.i(29751);
    if (this.TTd)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.TTc = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(29751);
      return false;
    }
    this.TTd = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      e.c localc = (e.c)paramQueue.peek();
      int j = localc.ieH.getBytes().length;
      fqj localfqj;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localfqj = new fqj();
        localfqj.abQm = localc.TSZ;
        localfqj.abQn = localc.ieH;
        localfqj.aanh = new gol().df(localc.kLr);
        if ((localc.type == 1) || (au.bwE(localc.source))) {
          localfqj.abQo = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localfqj.IJG), localc.id });
        localLinkedList.add(localfqj);
        this.TTc.put(localc.TSZ, localc);
        i += j;
        break;
        localfqj.IJG = 4;
        continue;
        localfqj.IJG = 1;
        continue;
        localfqj.IJG = 2;
        continue;
        localfqj.IJG = 3;
      }
    }
    this.TTe = new b(localLinkedList);
    bh.aZW().a(this.TTe, 0);
    this.start = System.currentTimeMillis();
    this.TTg.startTimer(60000L);
    AppMethodBeat.o(29751);
    return true;
  }
  
  public final void hPy()
  {
    this.TTe = null;
    this.TTd = false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(29752);
    bh.aZW().a(631, this);
    AppMethodBeat.o(29752);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29753);
    if (this.TTe != paramp)
    {
      Log.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(29753);
      return;
    }
    this.TTg.stopTimer();
    Log.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramp).TSJ != null) {}
    for (int i = ((b)paramp).TSJ.size();; i = 0)
    {
      Log.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      hPy();
      this.TTf.a(paramInt2, this.TTc, ((b)paramp).TSJ);
      AppMethodBeat.o(29753);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.b.f
 * JD-Core Version:    0.7.0.1
 */