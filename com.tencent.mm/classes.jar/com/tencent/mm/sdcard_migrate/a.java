package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
{
  int UTH;
  final a UTI;
  final List<b> vjj;
  
  a(b paramb)
  {
    AppMethodBeat.i(176025);
    this.vjj = new ArrayList();
    this.UTH = 0;
    this.UTI = new a();
    this.vjj.add(paramb);
    AppMethodBeat.o(176025);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(176024);
    this.vjj.add(paramb);
    AppMethodBeat.o(176024);
    return this;
  }
  
  public final class a
  {
    public a() {}
    
    public final void hsB()
    {
      AppMethodBeat.i(176023);
      synchronized (a.this.vjj)
      {
        a.b localb = (a.b)a.this.vjj.get(a.this.UTH);
        a locala = a.this;
        locala.UTH += 1;
        localb.a(this);
        AppMethodBeat.o(176023);
        return;
      }
    }
  }
  
  public static abstract class b
  {
    public abstract void a(a.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a
 * JD-Core Version:    0.7.0.1
 */