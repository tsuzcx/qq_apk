package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public enum h
{
  public static final Set<h> aaHw;
  public b aaHA;
  public final f aaHx;
  public final f aaHy;
  public b aaHz;
  
  static
  {
    AppMethodBeat.i(56687);
    aaHo = new h("BOOLEAN", 0, "Boolean");
    aaHp = new h("CHAR", 1, "Char");
    aaHq = new h("BYTE", 2, "Byte");
    aaHr = new h("SHORT", 3, "Short");
    aaHs = new h("INT", 4, "Int");
    aaHt = new h("FLOAT", 5, "Float");
    aaHu = new h("LONG", 6, "Long");
    aaHv = new h("DOUBLE", 7, "Double");
    aaHB = new h[] { aaHo, aaHp, aaHq, aaHr, aaHs, aaHt, aaHu, aaHv };
    aaHw = Collections.unmodifiableSet(EnumSet.of(aaHp, new h[] { aaHq, aaHr, aaHs, aaHt, aaHu, aaHv }));
    AppMethodBeat.o(56687);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(56684);
    this.aaHz = null;
    this.aaHA = null;
    this.aaHx = f.bHb(paramString);
    this.aaHy = f.bHb(paramString + "Array");
    AppMethodBeat.o(56684);
  }
  
  public final f iDF()
  {
    AppMethodBeat.i(56685);
    f localf = this.aaHx;
    if (localf == null) {
      aDG(0);
    }
    AppMethodBeat.o(56685);
    return localf;
  }
  
  public final f iDG()
  {
    AppMethodBeat.i(56686);
    f localf = this.aaHy;
    if (localf == null) {
      aDG(3);
    }
    AppMethodBeat.o(56686);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */