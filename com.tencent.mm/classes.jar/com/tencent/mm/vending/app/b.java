package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b agtN;
  Map<c, a> agtO;
  final SparseIntArray agtP;
  final Handler agtQ;
  
  static
  {
    AppMethodBeat.i(74893);
    agtN = null;
    agtN = new b();
    AppMethodBeat.o(74893);
  }
  
  public b()
  {
    AppMethodBeat.i(74891);
    this.agtO = new ConcurrentHashMap();
    this.agtP = new SparseIntArray();
    this.agtQ = new Handler(com.tencent.mm.vending.i.b.jJZ().agvC.getLooper())
    {
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(74894);
        a locala = (a)???.obj;
        switch (???.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(74894);
          return;
          locala.onCreate();
          synchronized (locala.agtD)
          {
            locala.agtG = true;
            locala.agtD.notify();
            AppMethodBeat.o(74894);
            return;
          }
          AppMethodBeat.o(74894);
          return;
          AppMethodBeat.o(74894);
          return;
          localObject.onDestroy();
        }
      }
    };
    AppMethodBeat.o(74891);
  }
  
  public static b jJD()
  {
    return agtN;
  }
  
  public final void a(c paramc, a parama)
  {
    AppMethodBeat.i(74892);
    if (!this.agtO.containsKey(paramc))
    {
      this.agtO.put(paramc, parama);
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[] { paramc, Integer.valueOf(paramc.hashCode()), parama, Looper.myLooper() });
      int i = this.agtP.get(paramc.hashCode(), 0);
      if ((i > 0) && (i < 4))
      {
        if (i > 0) {
          this.agtQ.sendMessage(this.agtQ.obtainMessage(1, parama));
        }
        if (i >= 2) {
          this.agtQ.sendMessage(this.agtQ.obtainMessage(2, parama));
        }
        if (i >= 3) {
          this.agtQ.sendMessage(this.agtQ.obtainMessage(3, parama));
        }
        if (i >= 4) {
          this.agtQ.sendMessage(this.agtQ.obtainMessage(4, parama));
        }
      }
      AppMethodBeat.o(74892);
      return;
    }
    com.tencent.mm.vending.f.a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
    AppMethodBeat.o(74892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.app.b
 * JD-Core Version:    0.7.0.1
 */