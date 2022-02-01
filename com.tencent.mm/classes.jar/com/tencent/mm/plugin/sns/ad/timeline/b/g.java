package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import java.util.LinkedList;

public final class g
{
  public static l a(bm parambm)
  {
    if ((parambm != null) && (parambm.KYo != null)) {
      return parambm.KYo.KBN;
    }
    return null;
  }
  
  public static cvt a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(265858);
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.timeLineObject != null) && (paramBaseViewHolder.timeLineObject.ContentObj != null))
    {
      paramBaseViewHolder = paramBaseViewHolder.timeLineObject.ContentObj;
      if (!d.isEmpty(paramBaseViewHolder.Sqr))
      {
        paramBaseViewHolder = (cvt)paramBaseViewHolder.Sqr.get(0);
        AppMethodBeat.o(265858);
        return paramBaseViewHolder;
      }
    }
    AppMethodBeat.o(265858);
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
    AppMethodBeat.i(265859);
    paramBaseViewHolder = b(paramBaseViewHolder);
    if (paramBaseViewHolder != null)
    {
      paramBaseViewHolder = paramBaseViewHolder.Id;
      AppMethodBeat.o(265859);
      return paramBaseViewHolder;
    }
    AppMethodBeat.o(265859);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.g
 * JD-Core Version:    0.7.0.1
 */