package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

final class l
  implements k.d
{
  static final l agxP;
  private final LinkedHashSet<k.d> agxQ;
  
  static
  {
    AppMethodBeat.i(238283);
    agxP = new l();
    AppMethodBeat.o(238283);
  }
  
  private l()
  {
    AppMethodBeat.i(238278);
    this.agxQ = new LinkedHashSet();
    AppMethodBeat.o(238278);
  }
  
  final void a(k.d paramd)
  {
    try
    {
      AppMethodBeat.i(238288);
      if (paramd != null) {
        this.agxQ.add(paramd);
      }
      AppMethodBeat.o(238288);
      return;
    }
    finally {}
  }
  
  public final void bQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(238301);
    try
    {
      Iterator localIterator = this.agxQ.iterator();
      while (localIterator.hasNext()) {
        ((k.d)localIterator.next()).bQ(paramBoolean1, paramBoolean2);
      }
    }
    finally
    {
      AppMethodBeat.o(238301);
    }
    AppMethodBeat.o(238301);
  }
  
  public final void jKq()
  {
    AppMethodBeat.i(238297);
    try
    {
      Iterator localIterator = this.agxQ.iterator();
      while (localIterator.hasNext()) {
        ((k.d)localIterator.next()).jKq();
      }
    }
    finally
    {
      AppMethodBeat.o(238297);
    }
    AppMethodBeat.o(238297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.l
 * JD-Core Version:    0.7.0.1
 */