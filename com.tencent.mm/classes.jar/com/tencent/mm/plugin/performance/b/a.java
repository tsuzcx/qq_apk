package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
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
  public static final a GNv;
  private final Map<String, a> GNw;
  private IListener<qq> GNx;
  
  static
  {
    AppMethodBeat.i(201481);
    GNv = new a();
    AppMethodBeat.o(201481);
  }
  
  private a()
  {
    AppMethodBeat.i(201465);
    this.GNw = new ConcurrentHashMap();
    AppMethodBeat.o(201465);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(201475);
    Log.i("MicroMsg.DiceCup", "dice [%s]", new Object[] { parama.key() });
    b.e(parama);
    long l1 = b.fnX();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < TimeUnit.MINUTES.toMillis(parama.cycleMinutes()))
    {
      Log.i("MicroMsg.DiceCup", "dice [%s] pass cycle", new Object[] { parama.key() });
      AppMethodBeat.o(201475);
      return;
    }
    b.Pc(l2);
    double d = Math.random();
    if ((d <= parama.rate()) && (parama.rate() >= 0.0D)) {
      parama.action(d);
    }
    AppMethodBeat.o(201475);
  }
  
  private void d(a parama)
  {
    try
    {
      AppMethodBeat.i(201477);
      this.GNw.remove(parama.key());
      if ((this.GNw.isEmpty()) && (this.GNx != null))
      {
        this.GNx.dead();
        this.GNx = null;
      }
      AppMethodBeat.o(201477);
      return;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(201466);
      b(parama);
      d(parama);
      AppMethodBeat.o(201466);
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
      AppMethodBeat.i(201471);
      if (this.GNw.containsKey(parama.key()))
      {
        parama = new IllegalArgumentException(parama.key() + " dice already exists");
        AppMethodBeat.o(201471);
        throw parama;
      }
    }
    finally {}
    this.GNw.put(parama.key(), parama);
    c(parama);
    if (this.GNx == null)
    {
      this.GNx = new IListener() {};
      this.GNx.alive();
    }
    AppMethodBeat.o(201471);
  }
  
  public final void run()
  {
    try
    {
      AppMethodBeat.i(201480);
      Iterator localIterator = this.GNw.entrySet().iterator();
      while (localIterator.hasNext()) {
        c((a)((Map.Entry)localIterator.next()).getValue());
      }
      AppMethodBeat.o(201480);
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
    private static final b GNA;
    private static String GNz;
    private static final MultiProcessMMKV fbr;
    
    static
    {
      AppMethodBeat.i(200750);
      fbr = MultiProcessMMKV.getMMKV("diagnostic_storage");
      GNA = new b();
      AppMethodBeat.o(200750);
    }
    
    public static void Pc(long paramLong)
    {
      AppMethodBeat.i(200747);
      fbr.encode(GNz, paramLong);
      AppMethodBeat.o(200747);
    }
    
    public static b e(a.a parama)
    {
      AppMethodBeat.i(200745);
      GNz = MMApplicationContext.getProcessName() + "_" + parama.key();
      parama = GNA;
      AppMethodBeat.o(200745);
      return parama;
    }
    
    public static long fnX()
    {
      AppMethodBeat.i(200746);
      long l = fbr.decodeLong(GNz, 0L);
      AppMethodBeat.o(200746);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */