package com.tencent.mm.plugin.sns.ad.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.ad.f.c;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import java.util.LinkedList;

public final class f
{
  public static j a(bh parambh)
  {
    if ((parambh != null) && (parambh.AAQ != null)) {
      return parambh.AAQ.Agi;
    }
    return null;
  }
  
  public static bzh a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(219150);
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.timeLineObject != null) && (paramBaseViewHolder.timeLineObject.HUG != null))
    {
      paramBaseViewHolder = paramBaseViewHolder.timeLineObject.HUG;
      if (!c.isEmpty(paramBaseViewHolder.Gtx))
      {
        paramBaseViewHolder = (bzh)paramBaseViewHolder.Gtx.get(0);
        AppMethodBeat.o(219150);
        return paramBaseViewHolder;
      }
    }
    AppMethodBeat.o(219150);
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
    AppMethodBeat.i(219151);
    paramBaseViewHolder = b(paramBaseViewHolder);
    if (paramBaseViewHolder != null)
    {
      paramBaseViewHolder = paramBaseViewHolder.Id;
      AppMethodBeat.o(219151);
      return paramBaseViewHolder;
    }
    AppMethodBeat.o(219151);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.f
 * JD-Core Version:    0.7.0.1
 */