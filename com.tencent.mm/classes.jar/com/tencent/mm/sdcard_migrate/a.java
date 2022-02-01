package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
{
  int EPC;
  final a EPD;
  final List<b> oZi;
  
  a(b paramb)
  {
    AppMethodBeat.i(176025);
    this.oZi = new ArrayList();
    this.EPC = 0;
    this.EPD = new a();
    this.oZi.add(paramb);
    AppMethodBeat.o(176025);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(176024);
    this.oZi.add(paramb);
    AppMethodBeat.o(176024);
    return this;
  }
  
  public final class a
  {
    public a() {}
    
    public final void eEb()
    {
      AppMethodBeat.i(176023);
      synchronized (a.this.oZi)
      {
        a.b localb = (a.b)a.this.oZi.get(a.this.EPC);
        a locala = a.this;
        locala.EPC += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a
 * JD-Core Version:    0.7.0.1
 */