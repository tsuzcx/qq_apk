package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class v$b$1
  implements Runnable
{
  v$b$1(v.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(67993);
    if (v.b.a(this.pJM) != null) {
      v.b.a(this.pJM).cancel();
    }
    AppMethodBeat.o(67993);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(67994);
    String str = super.toString() + "|onCancelled";
    AppMethodBeat.o(67994);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.b.1
 * JD-Core Version:    0.7.0.1
 */