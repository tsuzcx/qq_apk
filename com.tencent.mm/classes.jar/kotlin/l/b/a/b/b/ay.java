package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;

public abstract interface ay
{
  public abstract Collection<ad> a(ax paramax, Collection<? extends ad> paramCollection, b<? super ax, ? extends Iterable<? extends ad>> paramb, b<? super ad, ah> paramb1);
  
  public static final class a
    implements ay
  {
    public static final a aiHw;
    
    static
    {
      AppMethodBeat.i(56886);
      aiHw = new a();
      AppMethodBeat.o(56886);
    }
    
    public final Collection<ad> a(ax paramax, Collection<? extends ad> paramCollection, b<? super ax, ? extends Iterable<? extends ad>> paramb, b<? super ad, ah> paramb1)
    {
      AppMethodBeat.i(56885);
      s.u(paramax, "currentTypeConstructor");
      s.u(paramCollection, "superTypes");
      s.u(paramb, "neighbors");
      s.u(paramb1, "reportLoop");
      AppMethodBeat.o(56885);
      return paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.b.ay
 * JD-Core Version:    0.7.0.1
 */