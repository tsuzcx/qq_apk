package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.f;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum h
{
  public static final Set<h> JnA;
  public final f JnB;
  public final f JnC;
  public b JnD;
  public b JnE;
  
  static
  {
    AppMethodBeat.i(56687);
    Jns = new h("BOOLEAN", 0, "Boolean");
    Jnt = new h("CHAR", 1, "Char");
    Jnu = new h("BYTE", 2, "Byte");
    Jnv = new h("SHORT", 3, "Short");
    Jnw = new h("INT", 4, "Int");
    Jnx = new h("FLOAT", 5, "Float");
    Jny = new h("LONG", 6, "Long");
    Jnz = new h("DOUBLE", 7, "Double");
    JnF = new h[] { Jns, Jnt, Jnu, Jnv, Jnw, Jnx, Jny, Jnz };
    JnA = Collections.unmodifiableSet(EnumSet.of(Jnt, new h[] { Jnu, Jnv, Jnw, Jnx, Jny, Jnz }));
    AppMethodBeat.o(56687);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(56684);
    this.JnD = null;
    this.JnE = null;
    this.JnB = f.aQC(paramString);
    this.JnC = f.aQC(paramString + "Array");
    AppMethodBeat.o(56684);
  }
  
  public final f fxm()
  {
    AppMethodBeat.i(56685);
    f localf = this.JnB;
    if (localf == null) {
      adP(0);
    }
    AppMethodBeat.o(56685);
    return localf;
  }
  
  public final f fxn()
  {
    AppMethodBeat.i(56686);
    f localf = this.JnC;
    if (localf == null) {
      adP(3);
    }
    AppMethodBeat.o(56686);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */