package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.fws;
import com.tencent.mm.storage.au;
import java.util.LinkedList;

public final class b
{
  public static p a(String paramString, com.tencent.mm.am.h paramh, int paramInt)
  {
    AppMethodBeat.i(309570);
    c(paramh);
    if (au.bwO(paramString))
    {
      paramString = new com.tencent.mm.openim.model.b(paramString, "");
      AppMethodBeat.o(309570);
      return paramString;
    }
    paramh = new LinkedList();
    paramh.add(Integer.valueOf(79));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = new v(1, localLinkedList, paramh, new LinkedList(), "", "", null, "", null);
    paramh = new fws();
    if (paramInt == 182) {}
    for (paramh.YIc = 2;; paramh.YIc = 1)
    {
      paramString.a(paramh);
      AppMethodBeat.o(309570);
      return paramString;
    }
  }
  
  private static void c(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(309573);
    com.tencent.mm.kernel.h.aZW().a(30, paramh);
    com.tencent.mm.kernel.h.aZW().a(667, paramh);
    AppMethodBeat.o(309573);
  }
  
  public static void d(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(309575);
    com.tencent.mm.kernel.h.aZW().b(30, paramh);
    com.tencent.mm.kernel.h.aZW().b(667, paramh);
    AppMethodBeat.o(309575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */