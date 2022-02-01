package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.vfs.q;

final class g$3
  implements Runnable
{
  g$3(g.a parama, int paramInt) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(102669);
    Object localObject = new q(d.bbW());
    if ((!((q)localObject).ifE()) || (!((q)localObject).isDirectory()))
    {
      g.d(this.Hyi);
      AppMethodBeat.o(102669);
      return;
    }
    localObject = ((q)localObject).ifJ();
    if ((localObject == null) || (localObject.length <= 0))
    {
      g.d(this.Hyi);
      AppMethodBeat.o(102669);
      return;
    }
    String str1 = String.format("reader_%d_", new Object[] { Integer.valueOf(this.val$type) });
    String str2 = String.format("ReaderApp_%d", new Object[] { Integer.valueOf(this.val$type) });
    while (i < localObject.length)
    {
      if (localObject[i].getName().startsWith(str1)) {
        localObject[i].cFq();
      }
      if (localObject[i].getName().startsWith(str2)) {
        localObject[i].cFq();
      }
      i += 1;
    }
    g.d(this.Hyi);
    AppMethodBeat.o(102669);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(102670);
    String str = super.toString() + "|deleteAllPic";
    AppMethodBeat.o(102670);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g.3
 * JD-Core Version:    0.7.0.1
 */