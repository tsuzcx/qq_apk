package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class d
  implements c
{
  private a OtM;
  
  public d()
  {
    AppMethodBeat.i(40570);
    this.OtM = new a();
    AppMethodBeat.o(40570);
  }
  
  private static Long gDl()
  {
    AppMethodBeat.i(40573);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(40573);
    return Long.valueOf(l);
  }
  
  public final String gDk()
  {
    AppMethodBeat.i(40572);
    String str = String.valueOf(gDl());
    AppMethodBeat.o(40572);
    return str;
  }
  
  public final String getNonce()
  {
    AppMethodBeat.i(40571);
    long l1 = gDl().longValue();
    long l2 = new Random().nextInt();
    AppMethodBeat.o(40571);
    return String.valueOf(l1 + l2);
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.b.f.d
 * JD-Core Version:    0.7.0.1
 */