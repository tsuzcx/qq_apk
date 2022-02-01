package d.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V>
{
  private static final d<Object> Odw;
  private final c<V> Odx;
  
  static
  {
    AppMethodBeat.i(61438);
    Odw = new d(c.Odt);
    AppMethodBeat.o(61438);
  }
  
  private d(c<V> paramc)
  {
    this.Odx = paramc;
  }
  
  private d<V> a(c<V> paramc)
  {
    AppMethodBeat.i(61435);
    if (paramc == this.Odx)
    {
      AppMethodBeat.o(61435);
      return this;
    }
    paramc = new d(paramc);
    AppMethodBeat.o(61435);
    return paramc;
  }
  
  public static <V> d<V> gyZ()
  {
    return Odw;
  }
  
  public final V get(int paramInt)
  {
    AppMethodBeat.i(61436);
    Object localObject = this.Odx.get(paramInt);
    AppMethodBeat.o(61436);
    return localObject;
  }
  
  public final d<V> r(int paramInt, V paramV)
  {
    AppMethodBeat.i(61437);
    paramV = a(this.Odx.f(paramInt, paramV));
    AppMethodBeat.o(61437);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */