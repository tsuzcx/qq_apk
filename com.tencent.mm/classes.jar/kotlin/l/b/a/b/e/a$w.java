package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$w
  implements k.a
{
  private static k.b<w> abag;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    abdj = new w("INTERNAL", 0, 0);
    abdk = new w("PRIVATE", 1, 1);
    abdl = new w("PROTECTED", 2, 2);
    abdm = new w("PUBLIC", 3, 3);
    abdn = new w("PRIVATE_TO_THIS", 4, 4);
    abdo = new w("LOCAL", 5, 5);
    abdp = new w[] { abdj, abdk, abdl, abdm, abdn, abdo };
    abag = new k.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static w aFd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abdj;
    case 1: 
      return abdk;
    case 2: 
      return abdl;
    case 3: 
      return abdm;
    case 4: 
      return abdn;
    }
    return abdo;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.w
 * JD-Core Version:    0.7.0.1
 */