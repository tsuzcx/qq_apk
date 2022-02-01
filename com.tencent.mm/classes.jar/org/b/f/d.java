package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class d
  implements c
{
  private a MbF;
  
  public d()
  {
    AppMethodBeat.i(40570);
    this.MbF = new a();
    AppMethodBeat.o(40570);
  }
  
  private static Long ggf()
  {
    AppMethodBeat.i(40573);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(40573);
    return Long.valueOf(l);
  }
  
  public final String getNonce()
  {
    AppMethodBeat.i(40571);
    long l1 = ggf().longValue();
    long l2 = new Random().nextInt();
    AppMethodBeat.o(40571);
    return String.valueOf(l1 + l2);
  }
  
  public final String gge()
  {
    AppMethodBeat.i(40572);
    String str = String.valueOf(ggf());
    AppMethodBeat.o(40572);
    return str;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.f.d
 * JD-Core Version:    0.7.0.1
 */