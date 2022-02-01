package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  public static final a NrL;
  
  static
  {
    AppMethodBeat.i(56860);
    w localw1 = new w("FINAL", 0);
    NrG = localw1;
    w localw2 = new w("SEALED", 1);
    NrH = localw2;
    w localw3 = new w("OPEN", 2);
    NrI = localw3;
    w localw4 = new w("ABSTRACT", 3);
    NrJ = localw4;
    NrK = new w[] { localw1, localw2, localw3, localw4 };
    NrL = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private w() {}
  
  public static final class a
  {
    public static w bd(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return w.NrJ;
      }
      if (paramBoolean2) {
        return w.NrI;
      }
      return w.NrG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */