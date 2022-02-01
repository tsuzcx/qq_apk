package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class c
{
  public static final <T> Iterator<T> ao(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129344);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = (Iterator)new b(paramArrayOfT);
    AppMethodBeat.o(129344);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.c
 * JD-Core Version:    0.7.0.1
 */