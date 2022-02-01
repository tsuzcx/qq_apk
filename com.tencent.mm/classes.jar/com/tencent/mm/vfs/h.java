package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

final class h
  implements g.d
{
  static final h Rco;
  private final LinkedHashSet<g.d> Rcp;
  
  static
  {
    AppMethodBeat.i(197233);
    Rco = new h();
    AppMethodBeat.o(197233);
  }
  
  private h()
  {
    AppMethodBeat.i(197229);
    this.Rcp = new LinkedHashSet();
    AppMethodBeat.o(197229);
  }
  
  final void a(g.d paramd)
  {
    try
    {
      AppMethodBeat.i(197230);
      if (paramd != null) {
        this.Rcp.add(paramd);
      }
      AppMethodBeat.o(197230);
      return;
    }
    finally {}
  }
  
  public final void bh(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197232);
    try
    {
      Iterator localIterator = this.Rcp.iterator();
      while (localIterator.hasNext()) {
        ((g.d)localIterator.next()).bh(paramBoolean1, paramBoolean2);
      }
    }
    finally
    {
      AppMethodBeat.o(197232);
    }
    AppMethodBeat.o(197232);
  }
  
  public final void hdV()
  {
    AppMethodBeat.i(197231);
    try
    {
      Iterator localIterator = this.Rcp.iterator();
      while (localIterator.hasNext()) {
        ((g.d)localIterator.next()).hdV();
      }
    }
    finally
    {
      AppMethodBeat.o(197231);
    }
    AppMethodBeat.o(197231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */