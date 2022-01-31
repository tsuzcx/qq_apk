package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;

class ao$a<K, V>
{
  byte[] a;
  private LinkedHashMap<K, V> b;
  private int c;
  
  public ao$a(int paramInt)
  {
    AppMethodBeat.i(149628);
    this.a = new byte[0];
    this.c = paramInt;
    this.b = new ao.a.1(this, (int)Math.ceil(paramInt / 0.75F) + 1, 0.75F, true);
    AppMethodBeat.o(149628);
  }
  
  public V a(K paramK)
  {
    AppMethodBeat.i(149629);
    synchronized (this.a)
    {
      paramK = this.b.get(paramK);
      AppMethodBeat.o(149629);
      return paramK;
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(149631);
    synchronized (this.a)
    {
      this.b.clear();
      AppMethodBeat.o(149631);
      return;
    }
  }
  
  public void a(K paramK, V paramV)
  {
    AppMethodBeat.i(149630);
    synchronized (this.a)
    {
      this.b.put(paramK, paramV);
      AppMethodBeat.o(149630);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ao.a
 * JD-Core Version:    0.7.0.1
 */