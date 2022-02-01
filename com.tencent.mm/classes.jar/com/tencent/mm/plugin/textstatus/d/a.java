package com.tencent.mm.plugin.textstatus.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isBlur", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "isDuplicateBg", "isHideBlur", "isSameElements", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "topicInfo", "resetMedia", "", "reverseBlur", "setDuplicateBg", "isDuplicate", "setSendToSquare", "isSwitchOpen", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(TextStatusExtInfo paramTextStatusExtInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(289742);
    s.u(paramTextStatusExtInfo, "<this>");
    if (paramBoolean)
    {
      paramTextStatusExtInfo.option |= 0x8;
      AppMethodBeat.o(289742);
      return;
    }
    paramTextStatusExtInfo.option &= 0xFFFFFFF7;
    AppMethodBeat.o(289742);
  }
  
  public static final boolean a(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(289748);
    s.u(paramTextStatusExtInfo, "<this>");
    s.u(paramTextStatusExtInfo, "<this>");
    if ((paramTextStatusExtInfo.option & 0x8) != 0L) {}
    for (int i = 1; (i != 0) && (b(paramTextStatusExtInfo)); i = 0)
    {
      AppMethodBeat.o(289748);
      return true;
    }
    AppMethodBeat.o(289748);
    return false;
  }
  
  public static final boolean b(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(289754);
    s.u(paramTextStatusExtInfo, "<this>");
    if ((paramTextStatusExtInfo.option & 1L) != 0L)
    {
      AppMethodBeat.o(289754);
      return true;
    }
    AppMethodBeat.o(289754);
    return false;
  }
  
  public static final void c(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(289760);
    s.u(paramTextStatusExtInfo, "<this>");
    paramTextStatusExtInfo.mediaType = 0;
    paramTextStatusExtInfo.mediaUrl = "";
    paramTextStatusExtInfo.mediaThumbUrl = "";
    paramTextStatusExtInfo.mediaAesKey = "";
    paramTextStatusExtInfo.mediaThumbAesKey = "";
    paramTextStatusExtInfo.mediaWidth = 0;
    paramTextStatusExtInfo.mediaHeight = 0;
    AppMethodBeat.o(289760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.a
 * JD-Core Version:    0.7.0.1
 */