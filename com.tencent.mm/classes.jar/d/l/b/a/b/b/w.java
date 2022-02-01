package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  public static final a MUG;
  
  static
  {
    AppMethodBeat.i(56860);
    w localw1 = new w("FINAL", 0);
    MUB = localw1;
    w localw2 = new w("SEALED", 1);
    MUC = localw2;
    w localw3 = new w("OPEN", 2);
    MUD = localw3;
    w localw4 = new w("ABSTRACT", 3);
    MUE = localw4;
    MUF = new w[] { localw1, localw2, localw3, localw4 };
    MUG = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private w() {}
  
  public static final class a
  {
    public static w be(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return w.MUE;
      }
      if (paramBoolean2) {
        return w.MUD;
      }
      return w.MUB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */