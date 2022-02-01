package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  private final String ajrG;
  
  static
  {
    AppMethodBeat.i(61244);
    ajrH = new w("IN", 0, "in");
    ajrI = new w("OUT", 1, "out");
    ajrJ = new w("INV", 2, "");
    ajrK = new w[] { ajrH, ajrI, ajrJ };
    AppMethodBeat.o(61244);
  }
  
  private w(String paramString)
  {
    this.ajrG = paramString;
  }
  
  public final String toString()
  {
    return this.ajrG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.c.w
 * JD-Core Version:    0.7.0.1
 */