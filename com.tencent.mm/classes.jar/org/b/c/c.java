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
    AppMethodBeat.i(77241);
    d.s(paramc, "Cannot extract base string from null object");
    if ((paramc.CRI == null) || (paramc.CRI.size() <= 0))
    {
      paramc = new org.b.b.c(paramc);
      AppMethodBeat.o(77241);
      throw paramc;
    }
    String str1 = org.b.g.c.encode(paramc.erA().name());
    String str2 = org.b.g.c.encode(paramc.erF());
    e locale = new e();
    locale.a(paramc.erz());
    locale.a(paramc.erE());
    locale.a(new e(paramc.CRI));
    paramc = new e(locale.CRJ);
    Collections.sort(paramc.CRJ);
    paramc = String.format("%s&%s&%s", new Object[] { str1, str2, org.b.g.c.encode(paramc.erH()) });
    AppMethodBeat.o(77241);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.c.c
 * JD-Core Version:    0.7.0.1
 */