package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.storage.as;
import java.util.LinkedList;

public final class b
{
  public static q a(String paramString, i parami, int paramInt)
  {
    AppMethodBeat.i(202715);
    d(parami);
    if (as.bjp(paramString))
    {
      paramString = new com.tencent.mm.openim.b.b(paramString, "");
      AppMethodBeat.o(202715);
      return paramString;
    }
    parami = new LinkedList();
    parami.add(Integer.valueOf(79));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = new p(1, localLinkedList, parami, new LinkedList(), "", "", null, "", null);
    parami = new eqb();
    if (paramInt == 182) {}
    for (parami.KJS = 2;; parami.KJS = 1)
    {
      paramString.a(parami);
      AppMethodBeat.o(202715);
      return paramString;
    }
  }
  
  private static void d(i parami)
  {
    AppMethodBeat.i(202716);
    g.azz().a(30, parami);
    g.azz().a(667, parami);
    AppMethodBeat.o(202716);
  }
  
  public static void e(i parami)
  {
    AppMethodBeat.i(202717);
    g.azz().b(30, parami);
    g.azz().b(667, parami);
    AppMethodBeat.o(202717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */