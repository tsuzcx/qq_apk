package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

final class i
  implements h.d
{
  static final i YCR;
  private final LinkedHashSet<h.d> YCS;
  
  static
  {
    AppMethodBeat.i(195218);
    YCR = new i();
    AppMethodBeat.o(195218);
  }
  
  private i()
  {
    AppMethodBeat.i(195208);
    this.YCS = new LinkedHashSet();
    AppMethodBeat.o(195208);
  }
  
  final void b(h.d paramd)
  {
    try
    {
      AppMethodBeat.i(195210);
      if (paramd != null) {
        this.YCS.add(paramd);
      }
      AppMethodBeat.o(195210);
      return;
    }
    finally {}
  }
  
  public final void br(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195216);
    try
    {
      Iterator localIterator = this.YCS.iterator();
      while (localIterator.hasNext()) {
        ((h.d)localIterator.next()).br(paramBoolean1, paramBoolean2);
      }
    }
    finally
    {
      AppMethodBeat.o(195216);
    }
    AppMethodBeat.o(195216);
  }
  
  public final void ife()
  {
    AppMethodBeat.i(195213);
    try
    {
      Iterator localIterator = this.YCS.iterator();
      while (localIterator.hasNext()) {
        ((h.d)localIterator.next()).ife();
      }
    }
    finally
    {
      AppMethodBeat.o(195213);
    }
    AppMethodBeat.o(195213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.i
 * JD-Core Version:    0.7.0.1
 */