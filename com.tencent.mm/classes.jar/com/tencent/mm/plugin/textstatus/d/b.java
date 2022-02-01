package com.tencent.mm.plugin.textstatus.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getKey", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpElement;", "isSame", "", "compareJumpElement", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "compareJumpInfo", "", "compareJumpElements", "isSameTextStatusJumpElement", "compareJumpInfos", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final boolean O(List<? extends TextStatusJumpInfo> paramList1, List<? extends TextStatusJumpInfo> paramList2)
  {
    AppMethodBeat.i(289747);
    s.u(paramList1, "<this>");
    if (paramList2 == null)
    {
      AppMethodBeat.o(289747);
      return false;
    }
    if (paramList1.size() != paramList2.size())
    {
      AppMethodBeat.o(289747);
      return false;
    }
    paramList1 = ((Iterable)paramList1).iterator();
    int i = 0;
    while (paramList1.hasNext())
    {
      Object localObject = paramList1.next();
      if (i < 0) {
        p.kkW();
      }
      if (!a((TextStatusJumpInfo)localObject, (TextStatusJumpInfo)paramList2.get(i)))
      {
        AppMethodBeat.o(289747);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(289747);
    return true;
  }
  
  public static final boolean a(TextStatusJumpInfo paramTextStatusJumpInfo1, TextStatusJumpInfo paramTextStatusJumpInfo2)
  {
    AppMethodBeat.i(289756);
    s.u(paramTextStatusJumpInfo1, "<this>");
    if (paramTextStatusJumpInfo2 == null)
    {
      AppMethodBeat.o(289756);
      return false;
    }
    if (!s.p(paramTextStatusJumpInfo1.jumpType, paramTextStatusJumpInfo2.jumpType))
    {
      AppMethodBeat.o(289756);
      return false;
    }
    if (!s.p(paramTextStatusJumpInfo1.busiId, paramTextStatusJumpInfo2.busiId))
    {
      AppMethodBeat.o(289756);
      return false;
    }
    if (!s.p(paramTextStatusJumpInfo1.busiBuf, paramTextStatusJumpInfo2.busiBuf))
    {
      AppMethodBeat.o(289756);
      return false;
    }
    String str = paramTextStatusJumpInfo1.keyBusiBuf;
    paramTextStatusJumpInfo1 = str;
    if (str == null) {
      paramTextStatusJumpInfo1 = "";
    }
    str = paramTextStatusJumpInfo2.keyBusiBuf;
    paramTextStatusJumpInfo2 = str;
    if (str == null) {
      paramTextStatusJumpInfo2 = "";
    }
    if (!s.p(paramTextStatusJumpInfo1, paramTextStatusJumpInfo2))
    {
      AppMethodBeat.o(289756);
      return false;
    }
    AppMethodBeat.o(289756);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.b
 * JD-Core Version:    0.7.0.1
 */