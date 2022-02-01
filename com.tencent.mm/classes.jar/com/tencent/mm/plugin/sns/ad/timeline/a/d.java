package com.tencent.mm.plugin.sns.ad.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.b;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import java.util.LinkedList;

public final class d
{
  public static com.tencent.mm.plugin.sns.ad.d.i a(bh parambh)
  {
    if ((parambh != null) && (parambh.AjE != null)) {
      return parambh.AjE.zPb;
    }
    return null;
  }
  
  public static byn a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(197678);
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.timeLineObject != null) && (paramBaseViewHolder.timeLineObject.HAT != null))
    {
      paramBaseViewHolder = paramBaseViewHolder.timeLineObject.HAT;
      if (!b.isEmpty(paramBaseViewHolder.GaQ))
      {
        paramBaseViewHolder = (byn)paramBaseViewHolder.GaQ.get(0);
        AppMethodBeat.o(197678);
        return paramBaseViewHolder;
      }
    }
    AppMethodBeat.o(197678);
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
    AppMethodBeat.i(197679);
    paramBaseViewHolder = b(paramBaseViewHolder);
    if (paramBaseViewHolder != null)
    {
      paramBaseViewHolder = paramBaseViewHolder.Id;
      AppMethodBeat.o(197679);
      return paramBaseViewHolder;
    }
    AppMethodBeat.o(197679);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */