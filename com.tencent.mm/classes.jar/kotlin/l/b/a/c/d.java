package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V>
{
  private static final d<Object> abuP;
  private final c<V> abuQ;
  
  static
  {
    AppMethodBeat.i(61438);
    abuP = new d(c.abuM);
    AppMethodBeat.o(61438);
  }
  
  private d(c<V> paramc)
  {
    this.abuQ = paramc;
  }
  
  private d<V> a(c<V> paramc)
  {
    AppMethodBeat.i(61435);
    if (paramc == this.abuQ)
    {
      AppMethodBeat.o(61435);
      return this;
    }
    paramc = new d(paramc);
    AppMethodBeat.o(61435);
    return paramc;
  }
  
  public static <V> d<V> iQt()
  {
    return abuP;
  }
  
  public final d<V> B(int paramInt, V paramV)
  {
    AppMethodBeat.i(61437);
    paramV = a(this.abuQ.g(paramInt, paramV));
    AppMethodBeat.o(61437);
    return paramV;
  }
  
  public final V get(int paramInt)
  {
    AppMethodBeat.i(61436);
    Object localObject = this.abuQ.aX(paramInt);
    AppMethodBeat.o(61436);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */