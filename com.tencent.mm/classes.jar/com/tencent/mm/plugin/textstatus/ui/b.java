package com.tencent.mm.plugin.textstatus.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.g.e.a;
import com.tencent.mm.plugin.textstatus.k.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isCanPullDown", "", "username", "", "customParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "runCurrentUi", "", "runnable", "Ljava/lang/Runnable;", "isSameThird", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "topicInfo", "plugin-textstatus_release"})
public final class b
{
  public static final boolean a(TextStatusTopicInfo paramTextStatusTopicInfo1, TextStatusTopicInfo paramTextStatusTopicInfo2)
  {
    AppMethodBeat.i(232500);
    p.k(paramTextStatusTopicInfo1, "$this$isSameThird");
    if (paramTextStatusTopicInfo2 == null)
    {
      AppMethodBeat.o(232500);
      return false;
    }
    if ((p.h(paramTextStatusTopicInfo1.sourceId, paramTextStatusTopicInfo2.sourceId) ^ true))
    {
      AppMethodBeat.o(232500);
      return false;
    }
    LinkedList localLinkedList = paramTextStatusTopicInfo2.jumpInfos;
    if ((localLinkedList != null) && (k.B((List)localLinkedList, (List)paramTextStatusTopicInfo1.jumpInfos) == true))
    {
      paramTextStatusTopicInfo2 = paramTextStatusTopicInfo2.sourceJumpInfos;
      if ((paramTextStatusTopicInfo2 != null) && (k.B((List)paramTextStatusTopicInfo2, (List)paramTextStatusTopicInfo1.sourceJumpInfos) == true))
      {
        AppMethodBeat.o(232500);
        return true;
      }
    }
    AppMethodBeat.o(232500);
    return false;
  }
  
  public static final boolean a(String paramString, i parami, a parama)
  {
    AppMethodBeat.i(232502);
    p.k(paramString, "username");
    f localf = f.MOw;
    if (u.agG(f.lD("thumb", paramString)))
    {
      AppMethodBeat.o(232502);
      return true;
    }
    if ((parami != null) && (parami.dDH() == true))
    {
      AppMethodBeat.o(232502);
      return true;
    }
    if ((parama != null) && (!TextUtils.isEmpty((CharSequence)parama.field_MediaThumbUrl)))
    {
      AppMethodBeat.o(232502);
      return true;
    }
    AppMethodBeat.o(232502);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.b
 * JD-Core Version:    0.7.0.1
 */