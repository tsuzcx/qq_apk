package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$i
  implements k.a
{
  private static k.b<i> aiYE;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58622);
    aiZV = new i("DECLARATION", 0, 0);
    aiZW = new i("FAKE_OVERRIDE", 1, 1);
    aiZX = new i("DELEGATION", 2, 2);
    aiZY = new i("SYNTHESIZED", 3, 3);
    aiZZ = new i[] { aiZV, aiZW, aiZX, aiZY };
    aiYE = new k.b() {};
    AppMethodBeat.o(58622);
  }
  
  private a$i(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static i aLe(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return aiZV;
    case 1: 
      return aiZW;
    case 2: 
      return aiZX;
    }
    return aiZY;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.i
 * JD-Core Version:    0.7.0.1
 */