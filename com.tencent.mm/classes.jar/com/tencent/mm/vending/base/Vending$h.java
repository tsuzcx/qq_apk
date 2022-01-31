package com.tencent.mm.vending.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class Vending$h<K, V>
  extends HashMap<K, V>
{
  Vending.f AOf = null;
  
  public final void clear()
  {
    AppMethodBeat.i(126170);
    super.clear();
    if (this.AOf != null) {
      this.AOf.a();
    }
    AppMethodBeat.o(126170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.h
 * JD-Core Version:    0.7.0.1
 */