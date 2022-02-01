package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.f;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum h
{
  public static final Set<h> MRP;
  public final f MRQ;
  public final f MRR;
  public b MRS;
  public b MRT;
  
  static
  {
    AppMethodBeat.i(56687);
    MRH = new h("BOOLEAN", 0, "Boolean");
    MRI = new h("CHAR", 1, "Char");
    MRJ = new h("BYTE", 2, "Byte");
    MRK = new h("SHORT", 3, "Short");
    MRL = new h("INT", 4, "Int");
    MRM = new h("FLOAT", 5, "Float");
    MRN = new h("LONG", 6, "Long");
    MRO = new h("DOUBLE", 7, "Double");
    MRU = new h[] { MRH, MRI, MRJ, MRK, MRL, MRM, MRN, MRO };
    MRP = Collections.unmodifiableSet(EnumSet.of(MRI, new h[] { MRJ, MRK, MRL, MRM, MRN, MRO }));
    AppMethodBeat.o(56687);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(56684);
    this.MRS = null;
    this.MRT = null;
    this.MRQ = f.bcE(paramString);
    this.MRR = f.bcE(paramString + "Array");
    AppMethodBeat.o(56684);
  }
  
  public final f gho()
  {
    AppMethodBeat.i(56685);
    f localf = this.MRQ;
    if (localf == null) {
      ajm(0);
    }
    AppMethodBeat.o(56685);
    return localf;
  }
  
  public final f ghp()
  {
    AppMethodBeat.i(56686);
    f localf = this.MRR;
    if (localf == null) {
      ajm(3);
    }
    AppMethodBeat.o(56686);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */