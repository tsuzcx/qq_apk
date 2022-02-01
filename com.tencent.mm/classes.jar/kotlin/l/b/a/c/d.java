package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V>
{
  private static final d<Object> ajtU;
  private final c<V> ajtV;
  
  static
  {
    AppMethodBeat.i(61438);
    ajtU = new d(c.ajtR);
    AppMethodBeat.o(61438);
  }
  
  private d(c<V> paramc)
  {
    this.ajtV = paramc;
  }
  
  private d<V> a(c<V> paramc)
  {
    AppMethodBeat.i(61435);
    if (paramc == this.ajtV)
    {
      AppMethodBeat.o(61435);
      return this;
    }
    paramc = new d(paramc);
    AppMethodBeat.o(61435);
    return paramc;
  }
  
  public static <V> d<V> kBh()
  {
    return ajtU;
  }
  
  public final d<V> W(int paramInt, V paramV)
  {
    AppMethodBeat.i(61437);
    paramV = a(this.ajtV.j(paramInt, paramV));
    AppMethodBeat.o(61437);
    return paramV;
  }
  
  public final V get(int paramInt)
  {
    AppMethodBeat.i(61436);
    Object localObject = this.ajtV.A(paramInt);
    AppMethodBeat.o(61436);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */