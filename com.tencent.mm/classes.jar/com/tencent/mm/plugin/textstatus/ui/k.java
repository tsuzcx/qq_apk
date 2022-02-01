package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isBlur", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "isSame", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "compareJumpInfo", "", "compareJumpInfos", "resetMedia", "", "reverseBlur", "setSendToSquare", "isSwitchOpen", "plugin-textstatus_release"})
public final class k
{
  public static final boolean B(List<? extends TextStatusJumpInfo> paramList1, List<? extends TextStatusJumpInfo> paramList2)
  {
    AppMethodBeat.i(236756);
    p.k(paramList1, "$this$isSame");
    if (paramList2 == null)
    {
      AppMethodBeat.o(236756);
      return false;
    }
    if (paramList1.size() != paramList2.size())
    {
      AppMethodBeat.o(236756);
      return false;
    }
    paramList1 = ((Iterable)paramList1).iterator();
    int i = 0;
    while (paramList1.hasNext())
    {
      Object localObject = paramList1.next();
      if (i < 0) {
        j.iBO();
      }
      if (!a((TextStatusJumpInfo)localObject, (TextStatusJumpInfo)paramList2.get(i)))
      {
        AppMethodBeat.o(236756);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(236756);
    return true;
  }
  
  public static final boolean a(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(236749);
    p.k(paramTextStatusExtInfo, "$this$isBlur");
    if ((paramTextStatusExtInfo.option & 1L) != 0L)
    {
      AppMethodBeat.o(236749);
      return true;
    }
    AppMethodBeat.o(236749);
    return false;
  }
  
  public static final boolean a(TextStatusJumpInfo paramTextStatusJumpInfo1, TextStatusJumpInfo paramTextStatusJumpInfo2)
  {
    AppMethodBeat.i(236760);
    p.k(paramTextStatusJumpInfo1, "$this$isSame");
    if (paramTextStatusJumpInfo2 == null)
    {
      AppMethodBeat.o(236760);
      return false;
    }
    if ((p.h(paramTextStatusJumpInfo1.jumpType, paramTextStatusJumpInfo2.jumpType) ^ true))
    {
      AppMethodBeat.o(236760);
      return false;
    }
    if ((p.h(paramTextStatusJumpInfo1.busiId, paramTextStatusJumpInfo2.busiId) ^ true))
    {
      AppMethodBeat.o(236760);
      return false;
    }
    if ((p.h(paramTextStatusJumpInfo1.busiBuf, paramTextStatusJumpInfo2.busiBuf) ^ true))
    {
      AppMethodBeat.o(236760);
      return false;
    }
    AppMethodBeat.o(236760);
    return true;
  }
  
  public static final void b(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(236752);
    p.k(paramTextStatusExtInfo, "$this$resetMedia");
    paramTextStatusExtInfo.mediaType = 0;
    paramTextStatusExtInfo.mediaUrl = "";
    paramTextStatusExtInfo.mediaThumbUrl = "";
    paramTextStatusExtInfo.mediaAesKey = "";
    paramTextStatusExtInfo.mediaThumbAesKey = "";
    paramTextStatusExtInfo.mediaWidth = 0;
    paramTextStatusExtInfo.mediaHeight = 0;
    AppMethodBeat.o(236752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.k
 * JD-Core Version:    0.7.0.1
 */