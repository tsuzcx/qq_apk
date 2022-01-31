package com.tencent.tencentmap.mapsdk.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    boolean bool = true;
    AppMethodBeat.i(101257);
    a locala;
    if (!a.b())
    {
      a.b(true);
      locala = this.a;
      if (a.a(this.a)) {
        break label49;
      }
    }
    for (;;)
    {
      locala.a(bool);
      a.b(false);
      AppMethodBeat.o(101257);
      return;
      label49:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.a.1
 * JD-Core Version:    0.7.0.1
 */