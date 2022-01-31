package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

class c$c
  implements c.a
{
  private final Map CPo;
  private final d CPp;
  
  c$c()
  {
    AppMethodBeat.i(116928);
    this.CPo = new HashMap();
    this.CPp = new d();
    AppMethodBeat.o(116928);
  }
  
  public final int azI(String paramString)
  {
    AppMethodBeat.i(116930);
    paramString = this.CPo.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116930);
      return -1;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(116930);
    return i;
  }
  
  public final void g(String paramString, int paramInt)
  {
    AppMethodBeat.i(116929);
    this.CPo.put(paramString, Integer.valueOf(paramInt));
    this.CPp.w(paramInt, paramString);
    AppMethodBeat.o(116929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.b.c.c
 * JD-Core Version:    0.7.0.1
 */