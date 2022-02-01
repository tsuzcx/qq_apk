package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.f;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum h
{
  public static final Set<h> NoU;
  public final f NoV;
  public final f NoW;
  public b NoX;
  public b NoY;
  
  static
  {
    AppMethodBeat.i(56687);
    NoM = new h("BOOLEAN", 0, "Boolean");
    NoN = new h("CHAR", 1, "Char");
    NoO = new h("BYTE", 2, "Byte");
    NoP = new h("SHORT", 3, "Short");
    NoQ = new h("INT", 4, "Int");
    NoR = new h("FLOAT", 5, "Float");
    NoS = new h("LONG", 6, "Long");
    NoT = new h("DOUBLE", 7, "Double");
    NoZ = new h[] { NoM, NoN, NoO, NoP, NoQ, NoR, NoS, NoT };
    NoU = Collections.unmodifiableSet(EnumSet.of(NoN, new h[] { NoO, NoP, NoQ, NoR, NoS, NoT }));
    AppMethodBeat.o(56687);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(56684);
    this.NoX = null;
    this.NoY = null;
    this.NoV = f.bei(paramString);
    this.NoW = f.bei(paramString + "Array");
    AppMethodBeat.o(56684);
  }
  
  public final f glQ()
  {
    AppMethodBeat.i(56685);
    f localf = this.NoV;
    if (localf == null) {
      ajW(0);
    }
    AppMethodBeat.o(56685);
    return localf;
  }
  
  public final f glR()
  {
    AppMethodBeat.i(56686);
    f localf = this.NoW;
    if (localf == null) {
      ajW(3);
    }
    AppMethodBeat.o(56686);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */