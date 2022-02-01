package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$i
  implements j.a
{
  private static j.b<i> NHN;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58622);
    NJb = new i("DECLARATION", 0, 0);
    NJc = new i("FAKE_OVERRIDE", 1, 1);
    NJd = new i("DELEGATION", 2, 2);
    NJe = new i("SYNTHESIZED", 3, 3);
    NJf = new i[] { NJb, NJc, NJd, NJe };
    NHN = new j.b() {};
    AppMethodBeat.o(58622);
  }
  
  private a$i(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static i akD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NJb;
    case 1: 
      return NJc;
    case 2: 
      return NJd;
    }
    return NJe;
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