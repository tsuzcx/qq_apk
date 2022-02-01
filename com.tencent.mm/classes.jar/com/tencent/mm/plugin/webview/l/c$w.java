package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"buildMatrix", "", "", "matrix", "", "invoke"})
final class c$w
  extends q
  implements b<List<? extends Integer>, List<? extends String>>
{
  public static final w JEA;
  
  static
  {
    AppMethodBeat.i(82892);
    JEA = new w();
    AppMethodBeat.o(82892);
  }
  
  c$w()
  {
    super(1);
  }
  
  public static List<String> in(List<Integer> paramList)
  {
    AppMethodBeat.i(82891);
    p.h(paramList, "matrix");
    SecureRandom localSecureRandom = new SecureRandom();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte = new byte[((Number)((Iterator)localObject).next()).intValue()];
      localSecureRandom.nextBytes(arrayOfByte);
      paramList.add(e.a(arrayOfByte, (CharSequence)"", (b)a.JEB));
    }
    paramList = (List)paramList;
    AppMethodBeat.o(82891);
    return paramList;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Byte, String>
  {
    public static final a JEB;
    
    static
    {
      AppMethodBeat.i(82889);
      JEB = new a();
      AppMethodBeat.o(82889);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.c.w
 * JD-Core Version:    0.7.0.1
 */