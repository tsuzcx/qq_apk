package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"})
public final class b
{
  public static final <T> Iterator<T> aj(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129344);
    p.k(paramArrayOfT, "array");
    paramArrayOfT = (Iterator)new a(paramArrayOfT);
    AppMethodBeat.o(129344);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.b
 * JD-Core Version:    0.7.0.1
 */