package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

class en$b
  implements Iterator<Map.Entry<K, V>>
{
  private en.c<K, V> b;
  
  private en$b(en.c<K, V> paramc)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public Map.Entry<K, V> a()
  {
    AppMethodBeat.i(147604);
    en.c localc = this.b;
    this.b = en.c.g(this.b);
    AppMethodBeat.o(147604);
    return localc;
  }
  
  public boolean hasNext()
  {
    return this.b != null;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(147605);
    this.a.b(this.b.a());
    AppMethodBeat.o(147605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.en.b
 * JD-Core Version:    0.7.0.1
 */