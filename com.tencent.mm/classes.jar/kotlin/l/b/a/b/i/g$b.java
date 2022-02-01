package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.i.b;
import kotlin.l.o;

public final class g$b
  extends b<T>
{
  public g$b(Object paramObject1, Object paramObject2, g paramg)
  {
    super(paramObject2);
  }
  
  public final boolean b(o<?> paramo)
  {
    AppMethodBeat.i(59807);
    s.u(paramo, "property");
    if (this.ajik.GrX)
    {
      paramo = new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
      AppMethodBeat.o(59807);
      throw paramo;
    }
    AppMethodBeat.o(59807);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.i.g.b
 * JD-Core Version:    0.7.0.1
 */