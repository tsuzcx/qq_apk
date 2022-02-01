package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "beginTc", "", "endTc", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-runtime"})
public enum r
{
  public final byte OlH;
  public final byte OlI;
  public final char OlJ;
  public final char OlK;
  
  static
  {
    AppMethodBeat.i(199947);
    r localr1 = new r("OBJ", 0, '{', '}');
    OlC = localr1;
    r localr2 = new r("LIST", 1, '[', ']');
    OlD = localr2;
    r localr3 = new r("MAP", 2, '{', '}');
    OlE = localr3;
    r localr4 = new r("POLY_OBJ", 3, '[', ']');
    OlF = localr4;
    OlG = new r[] { localr1, localr2, localr3, localr4 };
    AppMethodBeat.o(199947);
  }
  
  private r(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(199948);
    this.OlJ = paramChar1;
    this.OlK = paramChar2;
    this.OlH = g.I(this.OlJ);
    this.OlI = g.I(this.OlK);
    AppMethodBeat.o(199948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.r
 * JD-Core Version:    0.7.0.1
 */