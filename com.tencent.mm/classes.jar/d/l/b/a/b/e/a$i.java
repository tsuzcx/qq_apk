package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$i
  implements j.a
{
  private static j.b<i> LtK;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58622);
    LuY = new i("DECLARATION", 0, 0);
    LuZ = new i("FAKE_OVERRIDE", 1, 1);
    Lva = new i("DELEGATION", 2, 2);
    Lvb = new i("SYNTHESIZED", 3, 3);
    Lvc = new i[] { LuY, LuZ, Lva, Lvb };
    LtK = new j.b() {};
    AppMethodBeat.o(58622);
  }
  
  private a$i(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static i ahs(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return LuY;
    case 1: 
      return LuZ;
    case 2: 
      return Lva;
    }
    return Lvb;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.i
 * JD-Core Version:    0.7.0.1
 */