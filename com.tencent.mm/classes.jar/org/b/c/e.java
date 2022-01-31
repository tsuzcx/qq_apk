package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
  implements d
{
  public final String a(org.b.d.c paramc)
  {
    AppMethodBeat.i(77237);
    org.b.g.d.s(paramc, "Cannot extract a header from a null object");
    if ((paramc.CRI == null) || (paramc.CRI.size() <= 0))
    {
      paramc = new org.b.b.c(paramc);
      AppMethodBeat.o(77237);
      throw paramc;
    }
    paramc = paramc.CRI;
    StringBuffer localStringBuffer = new StringBuffer(paramc.size() * 20);
    localStringBuffer.append("OAuth ");
    Iterator localIterator = paramc.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        paramc = localStringBuffer.toString();
        AppMethodBeat.o(77237);
        return paramc;
      }
      String str = (String)localIterator.next();
      if (localStringBuffer.length() > 6) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(String.format("%s=\"%s\"", new Object[] { str, org.b.g.c.encode((String)paramc.get(str)) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.b.c.e
 * JD-Core Version:    0.7.0.1
 */