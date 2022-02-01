package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  public static final a LdL;
  
  static
  {
    AppMethodBeat.i(56860);
    w localw1 = new w("FINAL", 0);
    LdG = localw1;
    w localw2 = new w("SEALED", 1);
    LdH = localw2;
    w localw3 = new w("OPEN", 2);
    LdI = localw3;
    w localw4 = new w("ABSTRACT", 3);
    LdJ = localw4;
    LdK = new w[] { localw1, localw2, localw3, localw4 };
    LdL = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private w() {}
  
  public static final class a
  {
    public static w aW(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return w.LdJ;
      }
      if (paramBoolean2) {
        return w.LdI;
      }
      return w.LdG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */