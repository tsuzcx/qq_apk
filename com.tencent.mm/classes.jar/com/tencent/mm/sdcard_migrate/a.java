package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
{
  int HYC;
  final a HYD;
  final List<b> qfY;
  
  a(b paramb)
  {
    AppMethodBeat.i(176025);
    this.qfY = new ArrayList();
    this.HYC = 0;
    this.HYD = new a();
    this.qfY.add(paramb);
    AppMethodBeat.o(176025);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(176024);
    this.qfY.add(paramb);
    AppMethodBeat.o(176024);
    return this;
  }
  
  public final class a
  {
    public a() {}
    
    public final void fiX()
    {
      AppMethodBeat.i(176023);
      synchronized (a.this.qfY)
      {
        a.b localb = (a.b)a.this.qfY.get(a.this.HYC);
        a locala = a.this;
        locala.HYC += 1;
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