package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class a
  implements Serializable, o
{
  protected final Object aiwE;
  private final Class aiwF;
  private final boolean aiwG;
  private final int arity;
  private final int flags;
  private final String name;
  private final String signature;
  
  public a(Class paramClass, String paramString1, String paramString2)
  {
    this(f.aiwK, paramClass, paramString1, paramString2);
  }
  
  private a(Object paramObject, Class paramClass, String paramString1, String paramString2)
  {
    this.aiwE = paramObject;
    this.aiwF = paramClass;
    this.name = paramString1;
    this.signature = paramString2;
    this.aiwG = false;
    this.arity = 3;
    this.flags = 2;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190979);
    if (this == paramObject)
    {
      AppMethodBeat.o(190979);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(190979);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.aiwG == paramObject.aiwG) && (this.arity == paramObject.arity) && (this.flags == paramObject.flags) && (s.p(this.aiwE, paramObject.aiwE)) && (s.p(this.aiwF, paramObject.aiwF)) && (this.name.equals(paramObject.name)) && (this.signature.equals(paramObject.signature)))
    {
      AppMethodBeat.o(190979);
      return true;
    }
    AppMethodBeat.o(190979);
    return false;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(190984);
    int i;
    int m;
    int n;
    if (this.aiwE != null)
    {
      i = this.aiwE.hashCode();
      if (this.aiwF != null) {
        j = this.aiwF.hashCode();
      }
      m = this.name.hashCode();
      n = this.signature.hashCode();
      if (!this.aiwG) {
        break label124;
      }
    }
    label124:
    for (int k = 1231;; k = 1237)
    {
      int i1 = this.arity;
      int i2 = this.flags;
      AppMethodBeat.o(190984);
      return ((k + (((i * 31 + j) * 31 + m) * 31 + n) * 31) * 31 + i1) * 31 + i2;
      i = 0;
      break;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(190986);
    String str = ai.a(this);
    AppMethodBeat.o(190986);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.g.b.a
 * JD-Core Version:    0.7.0.1
 */