package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum z$b
{
  private final Object bTf;
  
  static
  {
    AppMethodBeat.i(59644);
    TEI = new b("INT", 0, Integer.valueOf(0));
    TEJ = new b("LONG", 1, Long.valueOf(0L));
    TEK = new b("FLOAT", 2, Float.valueOf(0.0F));
    TEL = new b("DOUBLE", 3, Double.valueOf(0.0D));
    TEM = new b("BOOLEAN", 4, Boolean.FALSE);
    TEN = new b("STRING", 5, "");
    TEO = new b("BYTE_STRING", 6, d.TDp);
    TEP = new b("ENUM", 7, null);
    TEQ = new b("MESSAGE", 8, null);
    TER = new b[] { TEI, TEJ, TEK, TEL, TEM, TEN, TEO, TEP, TEQ };
    AppMethodBeat.o(59644);
  }
  
  private z$b(Object paramObject)
  {
    this.bTf = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.h.z.b
 * JD-Core Version:    0.7.0.1
 */