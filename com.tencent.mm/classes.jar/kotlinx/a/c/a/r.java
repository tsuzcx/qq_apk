package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "beginTc", "", "endTc", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-runtime"})
public enum r
{
  public final byte abDS;
  public final byte abDT;
  public final char abDU;
  public final char abDV;
  
  static
  {
    AppMethodBeat.i(256315);
    r localr1 = new r("OBJ", 0, '{', '}');
    abDN = localr1;
    r localr2 = new r("LIST", 1, '[', ']');
    abDO = localr2;
    r localr3 = new r("MAP", 2, '{', '}');
    abDP = localr3;
    r localr4 = new r("POLY_OBJ", 3, '[', ']');
    abDQ = localr4;
    abDR = new r[] { localr1, localr2, localr3, localr4 };
    AppMethodBeat.o(256315);
  }
  
  private r(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(256317);
    this.abDU = paramChar1;
    this.abDV = paramChar2;
    this.abDS = g.R(this.abDU);
    this.abDT = g.R(this.abDV);
    AppMethodBeat.o(256317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.r
 * JD-Core Version:    0.7.0.1
 */