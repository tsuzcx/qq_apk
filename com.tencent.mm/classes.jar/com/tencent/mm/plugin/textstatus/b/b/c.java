package com.tencent.mm.plugin.textstatus.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getBackJumpType", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "plugin-textstatus_release"})
public final class c
{
  public static final String a(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(232972);
    p.k(paramTextStatusTopicInfo, "$this$getBackJumpType");
    paramTextStatusTopicInfo = paramTextStatusTopicInfo.jumpInfos;
    p.j(paramTextStatusTopicInfo, "jumpInfos");
    paramTextStatusTopicInfo = e.in((List)paramTextStatusTopicInfo);
    if (paramTextStatusTopicInfo != null)
    {
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.jumpType;
      AppMethodBeat.o(232972);
      return paramTextStatusTopicInfo;
    }
    AppMethodBeat.o(232972);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.c
 * JD-Core Version:    0.7.0.1
 */