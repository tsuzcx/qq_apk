package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.b.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

public final class ac$b<T>
  implements Comparator
{
  public ac$b(b paramb) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(60755);
    paramT1 = (ad)paramT1;
    b localb = this.ajpQ;
    s.s(paramT1, "it");
    paramT1 = (Comparable)localb.invoke(paramT1).toString();
    paramT2 = (ad)paramT2;
    localb = this.ajpQ;
    s.s(paramT2, "it");
    int i = a.b(paramT1, (Comparable)localb.invoke(paramT2).toString());
    AppMethodBeat.o(60755);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ac.b
 * JD-Core Version:    0.7.0.1
 */