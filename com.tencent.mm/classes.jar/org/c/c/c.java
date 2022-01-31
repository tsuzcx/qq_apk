package org.c.c;

import java.util.Collections;
import java.util.Map;
import org.c.d.e;
import org.c.d.j;
import org.c.g.d;

public final class c
  implements b
{
  public final String a(org.c.d.c paramc)
  {
    d.l(paramc, "Cannot extract base string from null object");
    if ((paramc.xuw == null) || (paramc.xuw.size() <= 0)) {
      throw new org.c.b.c(paramc);
    }
    String str1 = org.c.g.c.encode(paramc.cUV().name());
    String str2 = org.c.g.c.encode(paramc.cVa());
    e locale = new e();
    locale.a(paramc.cUU());
    locale.a(paramc.cUZ());
    locale.a(new e(paramc.xuw));
    paramc = new e(locale.xux);
    Collections.sort(paramc.xux);
    return String.format("%s&%s&%s", new Object[] { str1, str2, org.c.g.c.encode(paramc.cVb()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.c.c.c
 * JD-Core Version:    0.7.0.1
 */