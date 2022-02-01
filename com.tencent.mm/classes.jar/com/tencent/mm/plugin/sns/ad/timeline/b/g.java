package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import java.util.LinkedList;

public final class g
{
  public static k a(bk parambk)
  {
    if ((parambk != null) && (parambk.EKl != null)) {
      return parambk.EKl.EoE;
    }
    return null;
  }
  
  public static cnb a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(202235);
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.timeLineObject != null) && (paramBaseViewHolder.timeLineObject.ContentObj != null))
    {
      paramBaseViewHolder = paramBaseViewHolder.timeLineObject.ContentObj;
      if (!c.isEmpty(paramBaseViewHolder.LoV))
      {
        paramBaseViewHolder = (cnb)paramBaseViewHolder.LoV.get(0);
        AppMethodBeat.o(202235);
        return paramBaseViewHolder;
      }
    }
    AppMethodBeat.o(202235);
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
    AppMethodBeat.i(202236);
    paramBaseViewHolder = b(paramBaseViewHolder);
    if (paramBaseViewHolder != null)
    {
      paramBaseViewHolder = paramBaseViewHolder.Id;
      AppMethodBeat.o(202236);
      return paramBaseViewHolder;
    }
    AppMethodBeat.o(202236);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.g
 * JD-Core Version:    0.7.0.1
 */