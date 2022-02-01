package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
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
  public static final a AUa;
  private final Map<String, a> AUb;
  private IListener<ps> AUc;
  
  static
  {
    AppMethodBeat.i(201100);
    AUa = new a();
    AppMethodBeat.o(201100);
  }
  
  private a()
  {
    AppMethodBeat.i(201094);
    this.AUb = new ConcurrentHashMap();
    AppMethodBeat.o(201094);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(201097);
    Log.i("MicroMsg.DiceCup", "dice [%s]", new Object[] { parama.Lb() });
    b.e(parama);
    long l1 = b.eCn();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < TimeUnit.MINUTES.toMillis(parama.eCl()))
    {
      Log.i("MicroMsg.DiceCup", "dice [%s] pass cycle", new Object[] { parama.Lb() });
      AppMethodBeat.o(201097);
      return;
    }
    b.HI(l2);
    if ((Math.random() <= parama.eCk()) && (parama.eCk() >= 0.0D)) {
      parama.eCj();
    }
    AppMethodBeat.o(201097);
  }
  
  private void d(a parama)
  {
    try
    {
      AppMethodBeat.i(201098);
      this.AUb.remove(parama.Lb());
      if ((this.AUb.isEmpty()) && (this.AUc != null))
      {
        this.AUc.dead();
        this.AUc = null;
      }
      AppMethodBeat.o(201098);
      return;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(201095);
      b(parama);
      d(parama);
      AppMethodBeat.o(201095);
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
      AppMethodBeat.i(201096);
      if (this.AUb.containsKey(parama.Lb()))
      {
        parama = new IllegalArgumentException(parama.Lb() + " dice already exists");
        AppMethodBeat.o(201096);
        throw parama;
      }
    }
    finally {}
    this.AUb.put(parama.Lb(), parama);
    c(parama);
    if (this.AUc == null)
    {
      this.AUc = new IListener() {};
      this.AUc.alive();
    }
    AppMethodBeat.o(201096);
  }
  
  public final void run()
  {
    try
    {
      AppMethodBeat.i(201099);
      Iterator localIterator = this.AUb.entrySet().iterator();
      while (localIterator.hasNext()) {
        c((a)((Map.Entry)localIterator.next()).getValue());
      }
      AppMethodBeat.o(201099);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract String Lb();
    
    public abstract void eCj();
    
    public abstract double eCk();
    
    public abstract long eCl();
  }
  
  static final class b
  {
    private static String AUe;
    private static final b AUf;
    private static final MultiProcessMMKV djK;
    
    static
    {
      AppMethodBeat.i(201093);
      djK = MultiProcessMMKV.getMMKV("diagnostic_storage");
      AUf = new b();
      AppMethodBeat.o(201093);
    }
    
    public static void HI(long paramLong)
    {
      AppMethodBeat.i(201092);
      djK.encode(AUe, paramLong);
      AppMethodBeat.o(201092);
    }
    
    public static b e(a.a parama)
    {
      AppMethodBeat.i(201090);
      AUe = MMApplicationContext.getProcessName() + "_" + parama.Lb();
      parama = AUf;
      AppMethodBeat.o(201090);
      return parama;
    }
    
    public static long eCn()
    {
      AppMethodBeat.i(201091);
      long l = djK.decodeLong(AUe, 0L);
      AppMethodBeat.o(201091);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */