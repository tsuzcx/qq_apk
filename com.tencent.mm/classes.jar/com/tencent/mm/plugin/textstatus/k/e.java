package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"print", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "", "plugin-textstatus_release"})
public final class e
{
  public static final String c(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(232172);
    p.k(paramTextStatusExtInfo, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder("mediaTyoe:").append(paramTextStatusExtInfo.mediaType).append(" mediaUrl:").append(paramTextStatusExtInfo.mediaUrl).append(" turl:").append(paramTextStatusExtInfo.mediaThumbUrl).append(" des:").append(Util.secPrint(paramTextStatusExtInfo.description)).append(' ').append("bid:").append(paramTextStatusExtInfo.backgroundId).append(" rid:").append(paramTextStatusExtInfo.referenceTextStatusId).append(" rname:").append(paramTextStatusExtInfo.referenceUsername).append(" topicInfo:");
    paramTextStatusExtInfo = paramTextStatusExtInfo.topicInfo;
    p.j(paramTextStatusExtInfo, "topicInfo");
    paramTextStatusExtInfo = e(paramTextStatusExtInfo);
    AppMethodBeat.o(232172);
    return paramTextStatusExtInfo;
  }
  
  private static String e(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(232175);
    p.k(paramTextStatusTopicInfo, "$this$print");
    Object localObject3 = new StringBuilder("tid:").append(paramTextStatusTopicInfo.topicId).append(" sid:").append(paramTextStatusTopicInfo.sourceId).append(" said:").append(paramTextStatusTopicInfo.sourceActivityId).append(" sname:").append(paramTextStatusTopicInfo.sourceName).append(" sicon:").append(paramTextStatusTopicInfo.sourceIcon).append(" iconId:").append(paramTextStatusTopicInfo.iconId).append(" vinfo:").append(paramTextStatusTopicInfo.verifyInfo).append(" jumpinfos:");
    Object localObject1 = paramTextStatusTopicInfo.jumpInfos;
    if (localObject1 != null) {}
    for (localObject1 = ir((List)localObject1);; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append(" sourceInfos:");
      localObject3 = paramTextStatusTopicInfo.sourceJumpInfos;
      paramTextStatusTopicInfo = localObject2;
      if (localObject3 != null) {
        paramTextStatusTopicInfo = ir((List)localObject3);
      }
      paramTextStatusTopicInfo = paramTextStatusTopicInfo;
      AppMethodBeat.o(232175);
      return paramTextStatusTopicInfo;
    }
  }
  
  private static String ir(List<? extends TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(232177);
    p.k(paramList, "$this$print");
    StringBuilder localStringBuilder1 = new StringBuilder("size:" + paramList.size() + '-');
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramList.next();
      p.k(localTextStatusJumpInfo, "$this$print");
      StringBuilder localStringBuilder2 = new StringBuilder("jType:").append(localTextStatusJumpInfo.jumpType).append(" bid:").append(localTextStatusJumpInfo.busiId).append(" buf:");
      String str = localTextStatusJumpInfo.busiBuf;
      if (str != null) {}
      for (int i = str.length();; i = -1)
      {
        localStringBuilder1.append(i + " kbuf:" + localTextStatusJumpInfo.keyBusiBuf).append(",");
        break;
      }
    }
    paramList = localStringBuilder1.toString();
    p.j(paramList, "sb.toString()");
    AppMethodBeat.o(232177);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.e
 * JD-Core Version:    0.7.0.1
 */