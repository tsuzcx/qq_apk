package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  public static final a Jqs;
  
  static
  {
    AppMethodBeat.i(56860);
    w localw1 = new w("FINAL", 0);
    Jqn = localw1;
    w localw2 = new w("SEALED", 1);
    Jqo = localw2;
    w localw3 = new w("OPEN", 2);
    Jqp = localw3;
    w localw4 = new w("ABSTRACT", 3);
    Jqq = localw4;
    Jqr = new w[] { localw1, localw2, localw3, localw4 };
    Jqs = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private w() {}
  
  public static final class a
  {
    public static w aS(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return w.Jqq;
      }
      if (paramBoolean2) {
        return w.Jqp;
      }
      return w.Jqn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */