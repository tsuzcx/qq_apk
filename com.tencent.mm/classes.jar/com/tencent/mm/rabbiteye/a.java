package com.tencent.mm.rabbiteye;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.detective.AnrDetective;
import com.tencent.mm.rabbiteye.detective.LagDetective;

public final class a
{
  private static b NAM;
  
  static
  {
    AppMethodBeat.i(186288);
    System.loadLibrary("rabbiteye");
    AppMethodBeat.o(186288);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(186287);
    if (parama.a)
    {
      AnrDetective.a(NAM, parama);
      AnrDetective.a();
      AnrDetective.nativeInitAnr(AnrDetective.NAP.c);
    }
    if (parama.d) {
      LagDetective.b(NAM, parama).start();
    }
    AppMethodBeat.o(186287);
  }
  
  public static void a(b paramb)
  {
    NAM = paramb;
  }
  
  public static final class a
  {
    public boolean a;
    public boolean b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public long j;
    
    public a()
    {
      AppMethodBeat.i(186286);
      this.a = false;
      this.b = false;
      this.c = "";
      this.d = false;
      this.e = false;
      this.f = false;
      this.g = false;
      this.h = 2000L;
      this.i = 2000L;
      this.j = 2000L;
      AppMethodBeat.o(186286);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean, String paramString3);
    
    public abstract void gf(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.a
 * JD-Core Version:    0.7.0.1
 */