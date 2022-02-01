package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class f
{
  public final String Azr;
  public final int KbD;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(61369);
    this.Azr = paramString;
    this.KbD = paramInt;
    AppMethodBeat.o(61369);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61372);
    if (this != paramObject)
    {
      if (!(paramObject instanceof f)) {
        break label65;
      }
      paramObject = (f)paramObject;
      if (!k.g(this.Azr, paramObject.Azr)) {
        break label65;
      }
      if (this.KbD != paramObject.KbD) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(61372);
      return true;
    }
    label65:
    AppMethodBeat.o(61372);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61371);
    String str = this.Azr;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.KbD;
      AppMethodBeat.o(61371);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61370);
    String str = "NumberWithRadix(number=" + this.Azr + ", radix=" + this.KbD + ")";
    AppMethodBeat.o(61370);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.o.f
 * JD-Core Version:    0.7.0.1
 */