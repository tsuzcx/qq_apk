package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;

public final class k
{
  public static void a(b paramb)
  {
    AppMethodBeat.i(202364);
    if (paramb == null)
    {
      AppMethodBeat.o(202364);
      return;
    }
    j.b(paramb.eYp(), paramb.eYq(), 0, 0, paramb.eYo());
    AppMethodBeat.o(202364);
  }
  
  public static abstract class a
    implements k.b
  {
    public final String eYo()
    {
      return "";
    }
  }
  
  public static abstract interface b
  {
    public abstract String eYo();
    
    public abstract String eYp();
    
    public abstract String eYq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.k
 * JD-Core Version:    0.7.0.1
 */