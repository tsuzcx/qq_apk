package d.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e<K, V>
  implements Serializable
{
  public final K aFP;
  public final V value;
  
  public e(K paramK, V paramV)
  {
    this.aFP = paramK;
    this.value = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61439);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(61439);
      return false;
    }
    paramObject = (e)paramObject;
    if (this.aFP == null)
    {
      if (paramObject.aFP != null) {
        break label73;
      }
      if (this.value != null) {
        break label80;
      }
      if (paramObject.value != null) {
        break label73;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(61439);
      return true;
      if (this.aFP.equals(paramObject.aFP)) {
        break;
      }
      label73:
      label80:
      do
      {
        AppMethodBeat.o(61439);
        return false;
      } while (!this.value.equals(paramObject.value));
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(61440);
    int i;
    if (this.aFP == null)
    {
      i = 0;
      if (this.value != null) {
        break label43;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(61440);
      return i ^ j;
      i = this.aFP.hashCode();
      break;
      label43:
      j = this.value.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61441);
    String str = this.aFP + "=" + this.value;
    AppMethodBeat.o(61441);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.c.e
 * JD-Core Version:    0.7.0.1
 */