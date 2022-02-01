package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public enum h
{
  public static final Set<h> TeC;
  public final f TeD;
  public final f TeE;
  public b TeF;
  public b TeG;
  
  static
  {
    AppMethodBeat.i(56687);
    Teu = new h("BOOLEAN", 0, "Boolean");
    Tev = new h("CHAR", 1, "Char");
    Tew = new h("BYTE", 2, "Byte");
    Tex = new h("SHORT", 3, "Short");
    Tey = new h("INT", 4, "Int");
    Tez = new h("FLOAT", 5, "Float");
    TeA = new h("LONG", 6, "Long");
    TeB = new h("DOUBLE", 7, "Double");
    TeH = new h[] { Teu, Tev, Tew, Tex, Tey, Tez, TeA, TeB };
    TeC = Collections.unmodifiableSet(EnumSet.of(Tev, new h[] { Tew, Tex, Tey, Tez, TeA, TeB }));
    AppMethodBeat.o(56687);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(56684);
    this.TeF = null;
    this.TeG = null;
    this.TeD = f.btY(paramString);
    this.TeE = f.btY(paramString + "Array");
    AppMethodBeat.o(56684);
  }
  
  public final f hzt()
  {
    AppMethodBeat.i(56685);
    f localf = this.TeD;
    if (localf == null) {
      atM(0);
    }
    AppMethodBeat.o(56685);
    return localf;
  }
  
  public final f hzu()
  {
    AppMethodBeat.i(56686);
    f localf = this.TeE;
    if (localf == null) {
      atM(3);
    }
    AppMethodBeat.o(56686);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */