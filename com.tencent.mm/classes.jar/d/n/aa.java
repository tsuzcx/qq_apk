package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
final class aa
{
  public static final String NHr;
  public static final aa NHs;
  
  static
  {
    AppMethodBeat.i(129359);
    NHs = new aa();
    String str = System.getProperty("line.separator");
    if (str == null) {
      p.gfZ();
    }
    NHr = str;
    AppMethodBeat.o(129359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.aa
 * JD-Core Version:    0.7.0.1
 */