package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "beginTc", "", "endTc", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-runtime"})
public enum r
{
  public final byte NOB;
  public final byte NOC;
  public final char NOD;
  public final char NOE;
  
  static
  {
    AppMethodBeat.i(191359);
    r localr1 = new r("OBJ", 0, '{', '}');
    NOw = localr1;
    r localr2 = new r("LIST", 1, '[', ']');
    NOx = localr2;
    r localr3 = new r("MAP", 2, '{', '}');
    NOy = localr3;
    r localr4 = new r("POLY_OBJ", 3, '[', ']');
    NOz = localr4;
    NOA = new r[] { localr1, localr2, localr3, localr4 };
    AppMethodBeat.o(191359);
  }
  
  private r(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(191360);
    this.NOD = paramChar1;
    this.NOE = paramChar2;
    this.NOB = g.I(this.NOD);
    this.NOC = g.I(this.NOE);
    AppMethodBeat.o(191360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.r
 * JD-Core Version:    0.7.0.1
 */