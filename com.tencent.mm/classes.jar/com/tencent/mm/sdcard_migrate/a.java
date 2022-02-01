package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
{
  final List<b> BI;
  int acoR;
  final a acoS;
  
  a(b paramb)
  {
    AppMethodBeat.i(176025);
    this.BI = new ArrayList();
    this.acoR = 0;
    this.acoS = new a();
    this.BI.add(paramb);
    AppMethodBeat.o(176025);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(176024);
    this.BI.add(paramb);
    AppMethodBeat.o(176024);
    return this;
  }
  
  public final class a
  {
    public a() {}
    
    public final void iSG()
    {
      AppMethodBeat.i(176023);
      synchronized (a.this.BI)
      {
        a.b localb = (a.b)a.this.BI.get(a.this.acoR);
        a locala = a.this;
        locala.acoR += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a
 * JD-Core Version:    0.7.0.1
 */