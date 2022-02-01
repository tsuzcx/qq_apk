package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"print", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final String e(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(290374);
    s.u(paramTextStatusExtInfo, "<this>");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("mediaTyoe:").append(paramTextStatusExtInfo.mediaType).append(" mediaUrl:").append(paramTextStatusExtInfo.mediaUrl).append(" turl:").append(paramTextStatusExtInfo.mediaThumbUrl).append(" des:").append(Util.secPrint(paramTextStatusExtInfo.description)).append(" bid:").append(paramTextStatusExtInfo.backgroundId).append(" rid:").append(paramTextStatusExtInfo.referenceTextStatusId).append(" rname:").append(paramTextStatusExtInfo.referenceUsername).append(" did:").append(paramTextStatusExtInfo.duplicateTextStatusId).append(" dname:").append(paramTextStatusExtInfo.duplicateUsername).append(" topicInfo:");
    Object localObject = paramTextStatusExtInfo.topicInfo;
    s.s(localObject, "topicInfo");
    localStringBuilder2 = localStringBuilder2.append(g((TextStatusTopicInfo)localObject)).append(" hasBrandInfo:");
    localObject = (CharSequence)paramTextStatusExtInfo.brand_key_info;
    int i;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      localStringBuilder2.append(bool).append(" option:");
      localStringBuilder1.append(paramTextStatusExtInfo.option);
      paramTextStatusExtInfo = localStringBuilder1.toString();
      AppMethodBeat.o(290374);
      return paramTextStatusExtInfo;
      i = 0;
      break;
    }
  }
  
  private static String g(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(290388);
    s.u(paramTextStatusTopicInfo, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("tid:").append(paramTextStatusTopicInfo.topicId).append(" sid:").append(paramTextStatusTopicInfo.sourceId).append(" said:").append(paramTextStatusTopicInfo.sourceActivityId).append(" sname:").append(paramTextStatusTopicInfo.sourceName).append(" sicon:").append(paramTextStatusTopicInfo.sourceIcon).append(" iconId:").append(paramTextStatusTopicInfo.iconId).append(" vinfo:").append(paramTextStatusTopicInfo.verifyInfo).append(" jumpinfos:");
    Object localObject1 = paramTextStatusTopicInfo.jumpInfos;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = localStringBuilder.append(localObject1).append(" sourceInfos:");
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.sourceJumpInfos;
      if (paramTextStatusTopicInfo != null) {
        break label167;
      }
    }
    label167:
    for (paramTextStatusTopicInfo = localObject2;; paramTextStatusTopicInfo = lx((List)paramTextStatusTopicInfo))
    {
      paramTextStatusTopicInfo = paramTextStatusTopicInfo;
      AppMethodBeat.o(290388);
      return paramTextStatusTopicInfo;
      localObject1 = lx((List)localObject1);
      break;
    }
  }
  
  private static String lx(List<? extends TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(290403);
    s.u(paramList, "<this>");
    StringBuilder localStringBuilder1 = new StringBuilder("size:" + paramList.size() + '-');
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramList.next();
      s.u(localTextStatusJumpInfo, "<this>");
      StringBuilder localStringBuilder2 = new StringBuilder("jType:").append(localTextStatusJumpInfo.jumpType).append(" bid:").append(localTextStatusJumpInfo.busiId).append(" buf:");
      String str = localTextStatusJumpInfo.busiBuf;
      if (str == null) {}
      for (int i = -1;; i = str.length())
      {
        localStringBuilder1.append(i + " kbuf:" + localTextStatusJumpInfo.keyBusiBuf).append(",");
        break;
      }
    }
    paramList = localStringBuilder1.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(290403);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.d
 * JD-Core Version:    0.7.0.1
 */