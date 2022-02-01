package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"})
public final class b
{
  public static final <T> Iterator<T> ad(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129344);
    p.h(paramArrayOfT, "array");
    paramArrayOfT = (Iterator)new a(paramArrayOfT);
    AppMethodBeat.o(129344);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.b
 * JD-Core Version:    0.7.0.1
 */