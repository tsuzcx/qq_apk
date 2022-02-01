package com.tencent.mm.plugin.textstatus.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.util.e;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isCanPullDown", "", "username", "", "customParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "runCurrentUi", "", "runnable", "Ljava/lang/Runnable;", "isSameThird", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "topicInfo", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final boolean a(TextStatusTopicInfo paramTextStatusTopicInfo1, TextStatusTopicInfo paramTextStatusTopicInfo2)
  {
    AppMethodBeat.i(291340);
    s.u(paramTextStatusTopicInfo1, "<this>");
    if (paramTextStatusTopicInfo2 == null)
    {
      AppMethodBeat.o(291340);
      return false;
    }
    if (!s.p(paramTextStatusTopicInfo1.sourceId, paramTextStatusTopicInfo2.sourceId))
    {
      AppMethodBeat.o(291340);
      return false;
    }
    LinkedList localLinkedList = paramTextStatusTopicInfo2.jumpInfos;
    if ((localLinkedList != null) && (com.tencent.mm.plugin.textstatus.d.b.O((List)localLinkedList, (List)paramTextStatusTopicInfo1.jumpInfos) == true))
    {
      i = 1;
      if (i == 0) {
        break label126;
      }
      paramTextStatusTopicInfo2 = paramTextStatusTopicInfo2.sourceJumpInfos;
      if ((paramTextStatusTopicInfo2 == null) || (com.tencent.mm.plugin.textstatus.d.b.O((List)paramTextStatusTopicInfo2, (List)paramTextStatusTopicInfo1.sourceJumpInfos) != true)) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label126;
      }
      AppMethodBeat.o(291340);
      return true;
      i = 0;
      break;
    }
    label126:
    AppMethodBeat.o(291340);
    return false;
  }
  
  public static final boolean a(String paramString, k paramk, com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(291346);
    s.u(paramString, "username");
    e locale = e.TAU;
    if (y.ZC(e.nl("thumb", paramString)))
    {
      AppMethodBeat.o(291346);
      return true;
    }
    if ((paramk != null) && (paramk.etQ() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291346);
      return true;
    }
    if ((paramb != null) && (!TextUtils.isEmpty((CharSequence)paramb.field_MediaThumbUrl)))
    {
      AppMethodBeat.o(291346);
      return true;
    }
    AppMethodBeat.o(291346);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.b
 * JD-Core Version:    0.7.0.1
 */