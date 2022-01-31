package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  private a AOj;
  public d AOk;
  private int c;
  public _Callback d;
  private int e;
  
  public b(_Callback param_Callback, a parama)
  {
    AppMethodBeat.i(126108);
    this.c = -1;
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.e = param_Callback.hashCode();
    this.d = param_Callback;
    this.AOj = parama;
    AppMethodBeat.o(126108);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(126110);
    Assert.assertNotNull(this.AOj);
    this.AOj.b(this);
    AppMethodBeat.o(126110);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(126109);
    if ((paramObject != null) && (paramObject.hashCode() == this.e))
    {
      AppMethodBeat.o(126109);
      return true;
    }
    AppMethodBeat.o(126109);
    return false;
  }
  
  public final int hashCode()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.b
 * JD-Core Version:    0.7.0.1
 */