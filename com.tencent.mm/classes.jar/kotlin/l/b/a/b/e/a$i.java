package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$i
  implements k.a
{
  private static k.b<i> abag;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58622);
    abbu = new i("DECLARATION", 0, 0);
    abbv = new i("FAKE_OVERRIDE", 1, 1);
    abbw = new i("DELEGATION", 2, 2);
    abbx = new i("SYNTHESIZED", 3, 3);
    abby = new i[] { abbu, abbv, abbw, abbx };
    abag = new k.b() {};
    AppMethodBeat.o(58622);
  }
  
  private a$i(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static i aEn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abbu;
    case 1: 
      return abbv;
    case 2: 
      return abbw;
    }
    return abbx;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.i
 * JD-Core Version:    0.7.0.1
 */