package com.tencent.mm.plugin.textstatus.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.third.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getBackJumpType", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final String b(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(290281);
    s.u(paramTextStatusTopicInfo, "<this>");
    paramTextStatusTopicInfo = paramTextStatusTopicInfo.jumpInfos;
    s.s(paramTextStatusTopicInfo, "jumpInfos");
    paramTextStatusTopicInfo = j.lu((List)paramTextStatusTopicInfo);
    if (paramTextStatusTopicInfo == null)
    {
      AppMethodBeat.o(290281);
      return null;
    }
    paramTextStatusTopicInfo = paramTextStatusTopicInfo.jumpType;
    AppMethodBeat.o(290281);
    return paramTextStatusTopicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.c
 * JD-Core Version:    0.7.0.1
 */