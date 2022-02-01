package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
{
  int IsJ;
  final a IsK;
  final List<b> qmD;
  
  a(b paramb)
  {
    AppMethodBeat.i(176025);
    this.qmD = new ArrayList();
    this.IsJ = 0;
    this.IsK = new a();
    this.qmD.add(paramb);
    AppMethodBeat.o(176025);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(176024);
    this.qmD.add(paramb);
    AppMethodBeat.o(176024);
    return this;
  }
  
  public final class a
  {
    public a() {}
    
    public final void fmP()
    {
      AppMethodBeat.i(176023);
      synchronized (a.this.qmD)
      {
        a.b localb = (a.b)a.this.qmD.get(a.this.IsJ);
        a locala = a.this;
        locala.IsJ += 1;
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