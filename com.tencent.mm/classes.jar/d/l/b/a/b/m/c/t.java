package d.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum t
{
  private final String Obd;
  
  static
  {
    AppMethodBeat.i(61244);
    t localt1 = new t("IN", 0, "in");
    OaZ = localt1;
    t localt2 = new t("OUT", 1, "out");
    Oba = localt2;
    t localt3 = new t("INV", 2, "");
    Obb = localt3;
    Obc = new t[] { localt1, localt2, localt3 };
    AppMethodBeat.o(61244);
  }
  
  private t(String paramString)
  {
    this.Obd = paramString;
  }
  
  public final String toString()
  {
    return this.Obd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.c.t
 * JD-Core Version:    0.7.0.1
 */