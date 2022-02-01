package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
final class aa
{
  public static final String abvU;
  public static final aa abvV;
  
  static
  {
    AppMethodBeat.i(129359);
    abvV = new aa();
    String str = System.getProperty("line.separator");
    if (str == null) {
      p.iCn();
    }
    abvU = str;
    AppMethodBeat.o(129359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.aa
 * JD-Core Version:    0.7.0.1
 */