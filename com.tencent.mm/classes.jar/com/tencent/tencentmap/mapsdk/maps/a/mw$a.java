package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

class mw$a<U>
  implements Iterator<U>
{
  private mw<U> a;
  
  public mw$a(mw<U> parammw)
  {
    this.a = parammw;
  }
  
  public boolean hasNext()
  {
    AppMethodBeat.i(149352);
    if (!this.a.b())
    {
      AppMethodBeat.o(149352);
      return true;
    }
    AppMethodBeat.o(149352);
    return false;
  }
  
  public U next()
  {
    AppMethodBeat.i(149353);
    Object localObject = this.a.c();
    this.a = this.a.d();
    AppMethodBeat.o(149353);
    return localObject;
  }
  
  public void remove()
  {
    AppMethodBeat.i(149354);
    RuntimeException localRuntimeException = new RuntimeException("not supported");
    AppMethodBeat.o(149354);
    throw localRuntimeException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mw.a
 * JD-Core Version:    0.7.0.1
 */