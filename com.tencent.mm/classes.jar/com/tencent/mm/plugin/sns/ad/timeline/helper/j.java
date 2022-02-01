package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import java.util.LinkedList;

public final class j
{
  public static l a(bn parambn)
  {
    if ((parambn != null) && (parambn.Ryp != null)) {
      return parambn.Ryp.Rbv;
    }
    return null;
  }
  
  public static dmz a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(311156);
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.timeLineObject != null) && (paramBaseViewHolder.timeLineObject.ContentObj != null))
    {
      paramBaseViewHolder = paramBaseViewHolder.timeLineObject.ContentObj;
      if (!d.isEmpty(paramBaseViewHolder.Zpr))
      {
        paramBaseViewHolder = (dmz)paramBaseViewHolder.Zpr.get(0);
        AppMethodBeat.o(311156);
        return paramBaseViewHolder;
      }
    }
    AppMethodBeat.o(311156);
    return null;
  }
  
  public static TimeLineObject b(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if (paramBaseViewHolder != null) {
      return paramBaseViewHolder.timeLineObject;
    }
    return null;
  }
  
  public static String c(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(311180);
    paramBaseViewHolder = b(paramBaseViewHolder);
    if (paramBaseViewHolder != null)
    {
      paramBaseViewHolder = paramBaseViewHolder.Id;
      AppMethodBeat.o(311180);
      return paramBaseViewHolder;
    }
    AppMethodBeat.o(311180);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.j
 * JD-Core Version:    0.7.0.1
 */