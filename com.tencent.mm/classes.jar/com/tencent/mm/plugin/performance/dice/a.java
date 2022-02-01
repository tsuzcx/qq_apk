package com.tencent.mm.plugin.performance.dice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class a
  implements Runnable
{
  public static final a MKN;
  private IListener<se> eUA;
  private final Map<String, a> eUz;
  
  static
  {
    AppMethodBeat.i(301074);
    MKN = new a();
    AppMethodBeat.o(301074);
  }
  
  private a()
  {
    AppMethodBeat.i(301050);
    this.eUz = new ConcurrentHashMap();
    AppMethodBeat.o(301050);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(301059);
    try
    {
      Log.i("MicroMsg.DiceCup", "dice [%s]", new Object[] { parama.key() });
      b.e(parama);
      long l1 = b.axG();
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < TimeUnit.MINUTES.toMillis(parama.cycleMinutes()))
      {
        Log.i("MicroMsg.DiceCup", "dice [%s] pass cycle", new Object[] { parama.key() });
        AppMethodBeat.o(301059);
        return;
      }
      b.dI(l2);
      double d = Math.random();
      if ((d <= parama.rate()) && (parama.rate() >= 0.0D)) {
        parama.action(d);
      }
      AppMethodBeat.o(301059);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.DiceCup", parama, "", new Object[0]);
      AppMethodBeat.o(301059);
    }
  }
  
  private void d(a parama)
  {
    try
    {
      AppMethodBeat.i(301067);
      this.eUz.remove(parama.key());
      if ((this.eUz.isEmpty()) && (this.eUA != null))
      {
        this.eUA.dead();
        this.eUA = null;
      }
      AppMethodBeat.o(301067);
      return;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(301080);
      b(parama);
      d(parama);
      AppMethodBeat.o(301080);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void b(a parama)
  {
    try
    {
      AppMethodBeat.i(301084);
      if (this.eUz.containsKey(parama.key()))
      {
        parama = new IllegalArgumentException(parama.key() + " dice already exists");
        AppMethodBeat.o(301084);
        throw parama;
      }
    }
    finally {}
    this.eUz.put(parama.key(), parama);
    c(parama);
    if (this.eUA == null)
    {
      this.eUA = new DiceCup.1(this, f.hfK);
      this.eUA.alive();
    }
    AppMethodBeat.o(301084);
  }
  
  public final void run()
  {
    try
    {
      AppMethodBeat.i(301089);
      Iterator localIterator = this.eUz.entrySet().iterator();
      while (localIterator.hasNext()) {
        c((a)((Map.Entry)localIterator.next()).getValue());
      }
      AppMethodBeat.o(301089);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void action(double paramDouble);
    
    public abstract long cycleMinutes();
    
    public abstract String key();
    
    public abstract double rate();
  }
  
  static final class b
  {
    private static final b MKP;
    private static String eUC;
    private static final MultiProcessMMKV evW;
    
    static
    {
      AppMethodBeat.i(301065);
      evW = MultiProcessMMKV.getMMKV("diagnostic_storage");
      MKP = new b();
      AppMethodBeat.o(301065);
    }
    
    public static long axG()
    {
      AppMethodBeat.i(301054);
      long l = evW.decodeLong(eUC, 0L);
      AppMethodBeat.o(301054);
      return l;
    }
    
    public static void dI(long paramLong)
    {
      AppMethodBeat.i(301060);
      evW.encode(eUC, paramLong);
      AppMethodBeat.o(301060);
    }
    
    public static b e(a.a parama)
    {
      AppMethodBeat.i(301048);
      eUC = MMApplicationContext.getProcessName() + "_" + parama.key();
      parama = MKP;
      AppMethodBeat.o(301048);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.dice.a
 * JD-Core Version:    0.7.0.1
 */