package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.storage.an;
import java.util.LinkedList;

public final class b
{
  public static n a(String paramString, f paramf, int paramInt)
  {
    AppMethodBeat.i(219331);
    d(paramf);
    if (an.aUq(paramString))
    {
      paramString = new com.tencent.mm.openim.b.b(paramString, "");
      AppMethodBeat.o(219331);
      return paramString;
    }
    paramf = new LinkedList();
    if (paramInt == 182) {
      paramf.add(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(paramString);
      paramString = new o(1, localLinkedList, paramf, new LinkedList(), "", "", null, "", null);
      AppMethodBeat.o(219331);
      return paramString;
      paramf.add(Integer.valueOf(181));
    }
  }
  
  private static void d(f paramf)
  {
    AppMethodBeat.i(219332);
    g.ajj().a(30, paramf);
    g.ajj().a(667, paramf);
    AppMethodBeat.o(219332);
  }
  
  public static void e(f paramf)
  {
    AppMethodBeat.i(219333);
    g.ajj().b(30, paramf);
    g.ajj().b(667, paramf);
    AppMethodBeat.o(219333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */