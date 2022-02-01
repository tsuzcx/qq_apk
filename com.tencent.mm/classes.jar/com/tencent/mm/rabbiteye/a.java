package com.tencent.mm.rabbiteye;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.detective.AnrDetective;
import com.tencent.mm.rabbiteye.detective.LagDetective;

public final class a
{
  private static b UOo;
  private static a UOp;
  
  static
  {
    AppMethodBeat.i(231730);
    System.loadLibrary("rabbiteye");
    AppMethodBeat.o(231730);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(231726);
    UOp = parama;
    if (parama.a)
    {
      AnrDetective.a(UOo, parama);
      AnrDetective.a();
      AnrDetective.nativeInitAnr(AnrDetective.UOs.d, AnrDetective.UOs.e);
    }
    if (parama.f) {
      LagDetective.b(UOo, parama).start();
    }
    AppMethodBeat.o(231726);
  }
  
  public static void a(b paramb)
  {
    UOo = paramb;
  }
  
  public static void hpL()
  {
    AppMethodBeat.i(231729);
    AnrDetective.hpL();
    AppMethodBeat.o(231729);
  }
  
  public static final class a
  {
    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    
    public a()
    {
      AppMethodBeat.i(231721);
      this.a = false;
      this.b = false;
      this.c = false;
      this.d = "";
      this.e = "";
      this.f = false;
      this.g = false;
      this.h = false;
      this.i = false;
      this.j = 2000L;
      this.k = 2000L;
      this.l = 2000L;
      AppMethodBeat.o(231721);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean, String paramString3);
    
    public abstract void gP(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.a
 * JD-Core Version:    0.7.0.1
 */