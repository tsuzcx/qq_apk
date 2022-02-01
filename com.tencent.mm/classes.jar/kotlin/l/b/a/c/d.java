package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V>
{
  private static final d<Object> TSq;
  private final c<V> TSr;
  
  static
  {
    AppMethodBeat.i(61438);
    TSq = new d(c.TSn);
    AppMethodBeat.o(61438);
  }
  
  private d(c<V> paramc)
  {
    this.TSr = paramc;
  }
  
  private d<V> a(c<V> paramc)
  {
    AppMethodBeat.i(61435);
    if (paramc == this.TSr)
    {
      AppMethodBeat.o(61435);
      return this;
    }
    paramc = new d(paramc);
    AppMethodBeat.o(61435);
    return paramc;
  }
  
  public static <V> d<V> hMc()
  {
    return TSq;
  }
  
  public final V get(int paramInt)
  {
    AppMethodBeat.i(61436);
    Object localObject = this.TSr.get(paramInt);
    AppMethodBeat.o(61436);
    return localObject;
  }
  
  public final d<V> w(int paramInt, V paramV)
  {
    AppMethodBeat.i(61437);
    paramV = a(this.TSr.e(paramInt, paramV));
    AppMethodBeat.o(61437);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */