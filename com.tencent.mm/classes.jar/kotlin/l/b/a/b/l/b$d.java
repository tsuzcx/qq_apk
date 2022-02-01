package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;

final class b$d<K, V>
{
  final a<? extends V> TMV;
  private final K key;
  
  public b$d(K paramK, a<? extends V> parama)
  {
    this.key = paramK;
    this.TMV = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60508);
    if (this == paramObject)
    {
      AppMethodBeat.o(60508);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(60508);
      return false;
    }
    paramObject = (d)paramObject;
    if (!this.key.equals(paramObject.key))
    {
      AppMethodBeat.o(60508);
      return false;
    }
    AppMethodBeat.o(60508);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60509);
    int i = this.key.hashCode();
    AppMethodBeat.o(60509);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.l.b.d
 * JD-Core Version:    0.7.0.1
 */