package com.tencent.mm.plugin.textstatus.third;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getFirstValidInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "", "isBackJumpInfo", "", "", "isFinder", "isForeJumpInfo", "isNeedUpdateExtInfo", "isWeApp", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final boolean a(TextStatusJumpInfo paramTextStatusJumpInfo)
  {
    AppMethodBeat.i(290135);
    s.u(paramTextStatusJumpInfo, "<this>");
    if ((b(paramTextStatusJumpInfo)) || (c(paramTextStatusJumpInfo)))
    {
      AppMethodBeat.o(290135);
      return true;
    }
    AppMethodBeat.o(290135);
    return false;
  }
  
  private static boolean b(TextStatusJumpInfo paramTextStatusJumpInfo)
  {
    AppMethodBeat.i(290141);
    s.u(paramTextStatusJumpInfo, "<this>");
    boolean bool = s.p(paramTextStatusJumpInfo.jumpType, "5");
    AppMethodBeat.o(290141);
    return bool;
  }
  
  private static boolean c(TextStatusJumpInfo paramTextStatusJumpInfo)
  {
    AppMethodBeat.i(290155);
    s.u(paramTextStatusJumpInfo, "<this>");
    boolean bool = s.p(paramTextStatusJumpInfo.jumpType, "7");
    AppMethodBeat.o(290155);
    return bool;
  }
  
  public static final TextStatusJumpInfo lu(List<? extends TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(290171);
    s.u(paramList, "<this>");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramList.next();
      i locali = i.TuX;
      if (i.contains(localTextStatusJumpInfo.jumpType))
      {
        AppMethodBeat.o(290171);
        return localTextStatusJumpInfo;
      }
    }
    AppMethodBeat.o(290171);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.j
 * JD-Core Version:    0.7.0.1
 */