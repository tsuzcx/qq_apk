package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

class c$c
  implements c.a
{
  private final Map ajVA;
  private final d ajVB;
  
  c$c()
  {
    AppMethodBeat.i(40704);
    this.ajVA = new HashMap();
    this.ajVB = new d();
    AppMethodBeat.o(40704);
  }
  
  public final int bLb(String paramString)
  {
    AppMethodBeat.i(40706);
    paramString = this.ajVA.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(40706);
      return -1;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(40706);
    return i;
  }
  
  public final void u(String paramString, int paramInt)
  {
    AppMethodBeat.i(40705);
    this.ajVA.put(paramString, Integer.valueOf(paramInt));
    this.ajVB.z(paramInt, paramString);
    AppMethodBeat.o(40705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.c.c.c
 * JD-Core Version:    0.7.0.1
 */