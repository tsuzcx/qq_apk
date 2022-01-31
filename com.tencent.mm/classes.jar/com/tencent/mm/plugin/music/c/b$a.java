package com.tencent.mm.plugin.music.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
  implements Runnable
{
  int action;
  
  b$a(b paramb, int paramInt)
  {
    this.action = paramInt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(137465);
    if (this.oYH.oYG != null) {
      this.oYH.oYG.Ad(this.action);
    }
    AppMethodBeat.o(137465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b.a
 * JD-Core Version:    0.7.0.1
 */