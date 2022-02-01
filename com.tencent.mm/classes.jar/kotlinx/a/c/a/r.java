package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "beginTc", "", "endTc", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-runtime"})
public enum r
{
  public final byte UaE;
  public final byte UaF;
  public final char UaG;
  public final char UaH;
  
  static
  {
    AppMethodBeat.i(225719);
    r localr1 = new r("OBJ", 0, '{', '}');
    Uaz = localr1;
    r localr2 = new r("LIST", 1, '[', ']');
    UaA = localr2;
    r localr3 = new r("MAP", 2, '{', '}');
    UaB = localr3;
    r localr4 = new r("POLY_OBJ", 3, '[', ']');
    UaC = localr4;
    UaD = new r[] { localr1, localr2, localr3, localr4 };
    AppMethodBeat.o(225719);
  }
  
  private r(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(225720);
    this.UaG = paramChar1;
    this.UaH = paramChar2;
    this.UaE = g.G(this.UaG);
    this.UaF = g.G(this.UaH);
    AppMethodBeat.o(225720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.r
 * JD-Core Version:    0.7.0.1
 */