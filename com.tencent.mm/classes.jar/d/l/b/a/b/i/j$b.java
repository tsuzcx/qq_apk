package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.i.b;

public final class j$b
  extends b<T>
{
  public j$b(Object paramObject1, Object paramObject2, j paramj)
  {
    super(paramObject2);
  }
  
  public final boolean b(d.l.k<?> paramk)
  {
    AppMethodBeat.i(59807);
    d.g.b.k.h(paramk, "property");
    if (this.JQy.aFx)
    {
      paramk = (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
      AppMethodBeat.o(59807);
      throw paramk;
    }
    AppMethodBeat.o(59807);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.l.b.a.b.i.j.b
 * JD-Core Version:    0.7.0.1
 */