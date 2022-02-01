package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class f
{
  public final String Dsg;
  public final int NFT;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(61369);
    this.Dsg = paramString;
    this.NFT = paramInt;
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
        if ((!p.i(this.Dsg, paramObject.Dsg)) || (this.NFT != paramObject.NFT)) {}
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
    String str = this.Dsg;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.NFT;
      AppMethodBeat.o(61371);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61370);
    String str = "NumberWithRadix(number=" + this.Dsg + ", radix=" + this.NFT + ")";
    AppMethodBeat.o(61370);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.o.f
 * JD-Core Version:    0.7.0.1
 */