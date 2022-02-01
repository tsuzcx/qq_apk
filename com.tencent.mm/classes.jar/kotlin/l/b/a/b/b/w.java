package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w
{
  public static final a Tht;
  
  static
  {
    AppMethodBeat.i(56860);
    w localw1 = new w("FINAL", 0);
    Tho = localw1;
    w localw2 = new w("SEALED", 1);
    Thp = localw2;
    w localw3 = new w("OPEN", 2);
    Thq = localw3;
    w localw4 = new w("ABSTRACT", 3);
    Thr = localw4;
    Ths = new w[] { localw1, localw2, localw3, localw4 };
    Tht = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private w() {}
  
  public static final class a
  {
    public static w bn(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return w.Thr;
      }
      if (paramBoolean2) {
        return w.Thq;
      }
      return w.Tho;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */