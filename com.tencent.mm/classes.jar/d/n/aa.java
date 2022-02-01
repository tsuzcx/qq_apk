package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
final class aa
{
  public static final String Kdb;
  public static final aa Kdc;
  
  static
  {
    AppMethodBeat.i(129359);
    Kdc = new aa();
    String str = System.getProperty("line.separator");
    if (str == null) {
      k.fvU();
    }
    Kdb = str;
    AppMethodBeat.o(129359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.aa
 * JD-Core Version:    0.7.0.1
 */