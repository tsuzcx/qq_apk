package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bl
{
  private final boolean ajqJ;
  public final boolean ajqK;
  private final int ajqL;
  public final String label;
  
  static
  {
    AppMethodBeat.i(60912);
    ajqM = new bl("INVARIANT", 0, "", true, true, 0);
    ajqN = new bl("IN_VARIANCE", 1, "in", true, false, -1);
    ajqO = new bl("OUT_VARIANCE", 2, "out", false, true, 1);
    ajqP = new bl[] { ajqM, ajqN, ajqO };
    AppMethodBeat.o(60912);
  }
  
  private bl(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.label = paramString;
    this.ajqJ = paramBoolean1;
    this.ajqK = paramBoolean2;
    this.ajqL = paramInt;
  }
  
  public final String toString()
  {
    return this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bl
 * JD-Core Version:    0.7.0.1
 */