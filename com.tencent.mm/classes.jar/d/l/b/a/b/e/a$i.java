package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$i
  implements j.a
{
  private static j.b<i> JGr;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58622);
    JHF = new i("DECLARATION", 0, 0);
    JHG = new i("FAKE_OVERRIDE", 1, 1);
    JHH = new i("DELEGATION", 2, 2);
    JHI = new i("SYNTHESIZED", 3, 3);
    JHJ = new i[] { JHF, JHG, JHH, JHI };
    JGr = new j.b() {};
    AppMethodBeat.o(58622);
  }
  
  private a$i(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static i aew(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return JHF;
    case 1: 
      return JHG;
    case 2: 
      return JHH;
    }
    return JHI;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.i
 * JD-Core Version:    0.7.0.1
 */