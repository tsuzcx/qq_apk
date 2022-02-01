package com.tencent.mm.plugin.textstatus.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getFirstValidInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "", "isBackJumpInfo", "", "", "isForeJumpInfo", "plugin-textstatus_release"})
public final class e
{
  public static final TextStatusJumpInfo in(List<? extends TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(235891);
    p.k(paramList, "$this$getFirstValidInfo");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramList.next();
      d locald = d.MIW;
      if (d.contains(localTextStatusJumpInfo.jumpType))
      {
        AppMethodBeat.o(235891);
        return localTextStatusJumpInfo;
      }
    }
    AppMethodBeat.o(235891);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.e
 * JD-Core Version:    0.7.0.1
 */