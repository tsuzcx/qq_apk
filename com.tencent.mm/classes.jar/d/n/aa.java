package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
final class aa
{
  public static final String LQw;
  public static final aa LQx;
  
  static
  {
    AppMethodBeat.i(129359);
    LQx = new aa();
    String str = System.getProperty("line.separator");
    if (str == null) {
      k.fOy();
    }
    LQw = str;
    AppMethodBeat.o(129359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.aa
 * JD-Core Version:    0.7.0.1
 */