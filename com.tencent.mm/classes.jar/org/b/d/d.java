package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.b.g.c;

public final class d
  implements Comparable<d>
{
  private final String key;
  private final String value;
  
  public d(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40541);
    if (paramObject == null)
    {
      AppMethodBeat.o(40541);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(40541);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(40541);
      return false;
    }
    paramObject = (d)paramObject;
    if ((paramObject.key.equals(this.key)) && (paramObject.value.equals(this.value)))
    {
      AppMethodBeat.o(40541);
      return true;
    }
    AppMethodBeat.o(40541);
    return false;
  }
  
  public final String fNi()
  {
    AppMethodBeat.i(40540);
    String str = c.encode(this.key).concat("=").concat(c.encode(this.value));
    AppMethodBeat.o(40540);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(40542);
    int i = this.key.hashCode();
    int j = this.value.hashCode();
    AppMethodBeat.o(40542);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.d.d
 * JD-Core Version:    0.7.0.1
 */