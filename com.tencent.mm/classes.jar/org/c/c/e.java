package org.c.c;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
  implements d
{
  public final String a(org.c.d.c paramc)
  {
    org.c.g.d.l(paramc, "Cannot extract a header from a null object");
    if ((paramc.xuw == null) || (paramc.xuw.size() <= 0)) {
      throw new org.c.b.c(paramc);
    }
    paramc = paramc.xuw;
    StringBuffer localStringBuffer = new StringBuffer(paramc.size() * 20);
    localStringBuffer.append("OAuth ");
    Iterator localIterator = paramc.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuffer.toString();
      }
      String str = (String)localIterator.next();
      if (localStringBuffer.length() > 6) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(String.format("%s=\"%s\"", new Object[] { str, org.c.g.c.encode((String)paramc.get(str)) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.c.c.e
 * JD-Core Version:    0.7.0.1
 */