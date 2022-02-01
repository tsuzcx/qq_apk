package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "beginTc", "", "endTc", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public enum q
{
  public final byte ajEW;
  public final byte ajEX;
  public final char ajEY;
  public final char ajEZ;
  
  static
  {
    AppMethodBeat.i(188536);
    q localq1 = new q("OBJ", 0, '{', '}');
    ajER = localq1;
    q localq2 = new q("LIST", 1, '[', ']');
    ajES = localq2;
    q localq3 = new q("MAP", 2, '{', '}');
    ajET = localq3;
    q localq4 = new q("POLY_OBJ", 3, '[', ']');
    ajEU = localq4;
    ajEV = new q[] { localq1, localq2, localq3, localq4 };
    AppMethodBeat.o(188536);
  }
  
  private q(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(188549);
    this.ajEY = paramChar1;
    this.ajEZ = paramChar2;
    this.ajEW = f.L(this.ajEY);
    this.ajEX = f.L(this.ajEZ);
    AppMethodBeat.o(188549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.q
 * JD-Core Version:    0.7.0.1
 */