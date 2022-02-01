package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.storage.as;
import java.util.LinkedList;

public final class b
{
  public static q a(String paramString, i parami, int paramInt)
  {
    AppMethodBeat.i(270566);
    c(parami);
    if (as.bvK(paramString))
    {
      paramString = new com.tencent.mm.openim.b.b(paramString, "");
      AppMethodBeat.o(270566);
      return paramString;
    }
    parami = new LinkedList();
    parami.add(Integer.valueOf(79));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = new com.tencent.mm.pluginsdk.model.t(1, localLinkedList, parami, new LinkedList(), "", "", null, "", null);
    parami = new fam();
    if (paramInt == 182) {}
    for (parami.RKI = 2;; parami.RKI = 1)
    {
      paramString.a(parami);
      AppMethodBeat.o(270566);
      return paramString;
    }
  }
  
  private static void c(i parami)
  {
    AppMethodBeat.i(270567);
    h.aGY().a(30, parami);
    h.aGY().a(667, parami);
    AppMethodBeat.o(270567);
  }
  
  public static void d(i parami)
  {
    AppMethodBeat.i(270568);
    h.aGY().b(30, parami);
    h.aGY().b(667, parami);
    AppMethodBeat.o(270568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */