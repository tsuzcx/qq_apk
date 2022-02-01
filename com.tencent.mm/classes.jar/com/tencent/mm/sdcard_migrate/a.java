package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
{
  int GmP;
  final a GmQ;
  final List<b> pCt;
  
  a(b paramb)
  {
    AppMethodBeat.i(176025);
    this.pCt = new ArrayList();
    this.GmP = 0;
    this.GmQ = new a();
    this.pCt.add(paramb);
    AppMethodBeat.o(176025);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(176024);
    this.pCt.add(paramb);
    AppMethodBeat.o(176024);
    return this;
  }
  
  public final class a
  {
    public a() {}
    
    public final void eTv()
    {
      AppMethodBeat.i(176023);
      synchronized (a.this.pCt)
      {
        a.b localb = (a.b)a.this.pCt.get(a.this.GmP);
        a locala = a.this;
        locala.GmP += 1;
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