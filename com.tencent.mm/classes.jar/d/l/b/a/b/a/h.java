package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.f;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum h
{
  public static final Set<h> LaU;
  public final f LaV;
  public final f LaW;
  public b LaX;
  public b LaY;
  
  static
  {
    AppMethodBeat.i(56687);
    LaM = new h("BOOLEAN", 0, "Boolean");
    LaN = new h("CHAR", 1, "Char");
    LaO = new h("BYTE", 2, "Byte");
    LaP = new h("SHORT", 3, "Short");
    LaQ = new h("INT", 4, "Int");
    LaR = new h("FLOAT", 5, "Float");
    LaS = new h("LONG", 6, "Long");
    LaT = new h("DOUBLE", 7, "Double");
    LaZ = new h[] { LaM, LaN, LaO, LaP, LaQ, LaR, LaS, LaT };
    LaU = Collections.unmodifiableSet(EnumSet.of(LaN, new h[] { LaO, LaP, LaQ, LaR, LaS, LaT }));
    AppMethodBeat.o(56687);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(56684);
    this.LaX = null;
    this.LaY = null;
    this.LaV = f.aWB(paramString);
    this.LaW = f.aWB(paramString + "Array");
    AppMethodBeat.o(56684);
  }
  
  public final f fPQ()
  {
    AppMethodBeat.i(56685);
    f localf = this.LaV;
    if (localf == null) {
      agL(0);
    }
    AppMethodBeat.o(56685);
    return localf;
  }
  
  public final f fPR()
  {
    AppMethodBeat.i(56686);
    f localf = this.LaW;
    if (localf == null) {
      agL(3);
    }
    AppMethodBeat.o(56686);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */