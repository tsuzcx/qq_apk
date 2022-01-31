package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class d
  implements c
{
  private a CSh;
  
  public d()
  {
    AppMethodBeat.i(77301);
    this.CSh = new a();
    AppMethodBeat.o(77301);
  }
  
  private static Long erN()
  {
    AppMethodBeat.i(77304);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(77304);
    return Long.valueOf(l);
  }
  
  public final String erM()
  {
    AppMethodBeat.i(77303);
    String str = String.valueOf(erN());
    AppMethodBeat.o(77303);
    return str;
  }
  
  public final String getNonce()
  {
    AppMethodBeat.i(77302);
    long l1 = erN().longValue();
    long l2 = new Random().nextInt();
    AppMethodBeat.o(77302);
    return String.valueOf(l1 + l2);
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.b.f.d
 * JD-Core Version:    0.7.0.1
 */