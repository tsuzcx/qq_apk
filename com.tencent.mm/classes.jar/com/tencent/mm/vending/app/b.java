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
  private static b Yzp;
  Map<c, a> Yzq;
  final SparseIntArray Yzr;
  final Handler Yzs;
  
  static
  {
    AppMethodBeat.i(74893);
    Yzp = null;
    Yzp = new b();
    AppMethodBeat.o(74893);
  }
  
  public b()
  {
    AppMethodBeat.i(74891);
    this.Yzq = new ConcurrentHashMap();
    this.Yzr = new SparseIntArray();
    this.Yzs = new Handler(com.tencent.mm.vending.i.b.ieS().YBf.getLooper())
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
          synchronized (locala.Yzf)
          {
            locala.Yzi = true;
            locala.Yzf.notify();
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
  
  public static b iew()
  {
    return Yzp;
  }
  
  public final void a(c paramc, a parama)
  {
    AppMethodBeat.i(74892);
    if (!this.Yzq.containsKey(paramc))
    {
      this.Yzq.put(paramc, parama);
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[] { paramc, Integer.valueOf(paramc.hashCode()), parama, Looper.myLooper() });
      int i = this.Yzr.get(paramc.hashCode(), 0);
      if ((i > 0) && (i < 4))
      {
        if (i > 0) {
          this.Yzs.sendMessage(this.Yzs.obtainMessage(1, parama));
        }
        if (i >= 2) {
          this.Yzs.sendMessage(this.Yzs.obtainMessage(2, parama));
        }
        if (i >= 3) {
          this.Yzs.sendMessage(this.Yzs.obtainMessage(3, parama));
        }
        if (i >= 4) {
          this.Yzs.sendMessage(this.Yzs.obtainMessage(4, parama));
        }
      }
      AppMethodBeat.o(74892);
      return;
    }
    com.tencent.mm.vending.f.a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
    AppMethodBeat.o(74892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.app.b
 * JD-Core Version:    0.7.0.1
 */