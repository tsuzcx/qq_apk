package d.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$d$b$b
  implements j.a
{
  private static j.b<b> LtK;
  final int value;
  
  static
  {
    AppMethodBeat.i(59200);
    LyK = new b("NONE", 0, 0);
    LyL = new b("INTERNAL_TO_CLASS_ID", 1, 1);
    LyM = new b("DESC_TO_CLASS_ID", 2, 2);
    LyN = new b[] { LyK, LyL, LyM };
    LtK = new j.b() {};
    AppMethodBeat.o(59200);
  }
  
  private a$d$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b aiu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return LyK;
    case 1: 
      return LyL;
    }
    return LyM;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */