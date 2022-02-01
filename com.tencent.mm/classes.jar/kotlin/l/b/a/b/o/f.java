package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class f
{
  public final String PlL;
  public final int abus;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(61369);
    this.PlL = paramString;
    this.abus = paramInt;
    AppMethodBeat.o(61369);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61372);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!p.h(this.PlL, paramObject.PlL)) || (this.abus != paramObject.abus)) {}
      }
    }
    else
    {
      AppMethodBeat.o(61372);
      return true;
    }
    AppMethodBeat.o(61372);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61371);
    String str = this.PlL;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.abus;
      AppMethodBeat.o(61371);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61370);
    String str = "NumberWithRadix(number=" + this.PlL + ", radix=" + this.abus + ")";
    AppMethodBeat.o(61370);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.o.f
 * JD-Core Version:    0.7.0.1
 */