package d.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V>
{
  private static final d<Object> NGq;
  private final c<V> NGr;
  
  static
  {
    AppMethodBeat.i(61438);
    NGq = new d(c.NGn);
    AppMethodBeat.o(61438);
  }
  
  private d(c<V> paramc)
  {
    this.NGr = paramc;
  }
  
  private d<V> a(c<V> paramc)
  {
    AppMethodBeat.i(61435);
    if (paramc == this.NGr)
    {
      AppMethodBeat.o(61435);
      return this;
    }
    paramc = new d(paramc);
    AppMethodBeat.o(61435);
    return paramc;
  }
  
  public static <V> d<V> gux()
  {
    return NGq;
  }
  
  public final V get(int paramInt)
  {
    AppMethodBeat.i(61436);
    Object localObject = this.NGr.get(paramInt);
    AppMethodBeat.o(61436);
    return localObject;
  }
  
  public final d<V> r(int paramInt, V paramV)
  {
    AppMethodBeat.i(61437);
    paramV = a(this.NGr.e(paramInt, paramV));
    AppMethodBeat.o(61437);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */