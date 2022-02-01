package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;
import org.b.d.e;
import org.b.d.j;
import org.b.g.d;

public final class c
  implements b
{
  public final String a(org.b.d.c paramc)
  {
    AppMethodBeat.i(40510);
    d.x(paramc, "Cannot extract base string from null object");
    if ((paramc.ajYy == null) || (paramc.ajYy.size() <= 0))
    {
      paramc = new org.b.b.c(paramc);
      AppMethodBeat.o(40510);
      throw paramc;
    }
    String str1 = org.b.g.c.cg(paramc.kJJ().name());
    String str2 = org.b.g.c.cg(paramc.kJO());
    e locale = new e();
    locale.a(paramc.kJI());
    locale.a(paramc.kJN());
    locale.a(new e(paramc.ajYy));
    paramc = new e(locale.ajYz);
    Collections.sort(paramc.ajYz);
    paramc = String.format("%s&%s&%s", new Object[] { str1, str2, org.b.g.c.cg(paramc.kJQ()) });
    AppMethodBeat.o(40510);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.b.c.c
 * JD-Core Version:    0.7.0.1
 */