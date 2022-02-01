package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a$a
{
  final c aiER;
  final int arity;
  
  public c$a$a(c paramc, int paramInt)
  {
    AppMethodBeat.i(191420);
    this.aiER = paramc;
    this.arity = paramInt;
    AppMethodBeat.o(191420);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.aiER != paramObject.aiER) {
        return false;
      }
    } while (this.arity == paramObject.arity);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191430);
    int i = this.aiER.hashCode();
    int j = this.arity;
    AppMethodBeat.o(191430);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191425);
    String str = "KindWithArity(kind=" + this.aiER + ", arity=" + this.arity + ')';
    AppMethodBeat.o(191425);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */