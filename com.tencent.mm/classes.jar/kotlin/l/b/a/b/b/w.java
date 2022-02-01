package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  public static final a aaKn;
  
  static
  {
    AppMethodBeat.i(56860);
    w localw1 = new w("FINAL", 0);
    aaKi = localw1;
    w localw2 = new w("SEALED", 1);
    aaKj = localw2;
    w localw3 = new w("OPEN", 2);
    aaKk = localw3;
    w localw4 = new w("ABSTRACT", 3);
    aaKl = localw4;
    aaKm = new w[] { localw1, localw2, localw3, localw4 };
    aaKn = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private w() {}
  
  public static final class a
  {
    public static w bx(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return w.aaKl;
      }
      if (paramBoolean2) {
        return w.aaKk;
      }
      return w.aaKi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */