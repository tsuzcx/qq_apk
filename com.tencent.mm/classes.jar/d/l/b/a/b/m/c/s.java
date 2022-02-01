package d.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum s
{
  private final String JZI;
  
  static
  {
    AppMethodBeat.i(61244);
    s locals1 = new s("IN", 0, "in");
    JZE = locals1;
    s locals2 = new s("OUT", 1, "out");
    JZF = locals2;
    s locals3 = new s("INV", 2, "");
    JZG = locals3;
    JZH = new s[] { locals1, locals2, locals3 };
    AppMethodBeat.o(61244);
  }
  
  private s(String paramString)
  {
    this.JZI = paramString;
  }
  
  public final String toString()
  {
    return this.JZI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.c.s
 * JD-Core Version:    0.7.0.1
 */