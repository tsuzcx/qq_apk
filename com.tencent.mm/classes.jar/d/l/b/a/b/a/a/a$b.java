package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

final class a$b
{
  final b.c MSE;
  final int arity;
  
  public a$b(b.c paramc, int paramInt)
  {
    AppMethodBeat.i(56707);
    this.MSE = paramc;
    this.arity = paramInt;
    AppMethodBeat.o(56707);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56710);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.MSE, paramObject.MSE)) || (this.arity != paramObject.arity)) {}
      }
    }
    else
    {
      AppMethodBeat.o(56710);
      return true;
    }
    AppMethodBeat.o(56710);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56709);
    b.c localc = this.MSE;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      int j = this.arity;
      AppMethodBeat.o(56709);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56708);
    String str = "KindWithArity(kind=" + this.MSE + ", arity=" + this.arity + ")";
    AppMethodBeat.o(56708);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */