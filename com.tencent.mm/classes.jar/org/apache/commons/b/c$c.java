package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

class c$c
  implements c.a
{
  private final Map Klf;
  private final d Klg;
  
  c$c()
  {
    AppMethodBeat.i(40704);
    this.Klf = new HashMap();
    this.Klg = new d();
    AppMethodBeat.o(40704);
  }
  
  public final int aRp(String paramString)
  {
    AppMethodBeat.i(40706);
    paramString = this.Klf.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(40706);
      return -1;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(40706);
    return i;
  }
  
  public final void g(String paramString, int paramInt)
  {
    AppMethodBeat.i(40705);
    this.Klf.put(paramString, Integer.valueOf(paramInt));
    this.Klg.d(paramInt, paramString);
    AppMethodBeat.o(40705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.apache.commons.b.c.c
 * JD-Core Version:    0.7.0.1
 */