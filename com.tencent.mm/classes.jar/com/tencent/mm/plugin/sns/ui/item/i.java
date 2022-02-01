package com.tencent.mm.plugin.sns.ui.item;

import android.support.constraint.Guideline;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class i
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(203929);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Lpd != null))
    {
      paramBaseViewHolder = (a)paramBaseViewHolder;
      parambl = paramTimeLineObject.ContentObj.Lpd;
      if (!Util.isNullOrNil(parambl.mediaList))
      {
        parambl = (cok)parambl.mediaList.get(0);
        if (parambl != null)
        {
          paramBaseViewHolder.EpU.setVisibility(0);
          paramBaseViewHolder.EYx.setVisibility(8);
          paramBaseViewHolder.EYw.setGuidelineEnd(0);
          Pair localPair = n.a((int)parambl.width, (int)parambl.height, paramBaseViewHolder.EYm.getContext(), false);
          paramInt1 = ((Integer)localPair.first).intValue();
          paramInt2 = ((Integer)localPair.second).intValue();
          paramBaseViewHolder.EYm.getLayoutParams().width = paramInt1;
          paramBaseViewHolder.EYm.getLayoutParams().height = paramInt2;
          paramBaseViewHolder.EYm.requestLayout();
          if (TextUtils.isEmpty(parambl.coverUrl)) {
            break label261;
          }
          ((aj)g.ah(aj.class)).loadImage(parambl.coverUrl, paramBaseViewHolder.tiQ);
        }
      }
    }
    for (;;)
    {
      paramBaseViewHolder.EYm.setTag(paramTimeLineObject);
      paramBaseViewHolder.EYm.setOnClickListener(parambk.EBo.ERd);
      parambk.fiV().c(paramBaseViewHolder.EYm, parambk.DQs.FaN, parambk.DQs.Far);
      AppMethodBeat.o(203929);
      return;
      label261:
      ((aj)g.ah(aj.class)).loadImage(parambl.thumbUrl, paramBaseViewHolder.tiQ);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203928);
    paramBaseViewHolder = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.EWD != null) && (paramBaseViewHolder.EWD.getParent() != null))
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496437);
      if (!paramBaseViewHolder.EYl) {
        paramBaseViewHolder.EYm = paramBaseViewHolder.EWD.inflate();
      }
    }
    for (paramBaseViewHolder.EYl = true;; paramBaseViewHolder.EYl = true)
    {
      paramBaseViewHolder.EpU = ((ImageView)paramBaseViewHolder.EYm.findViewById(2131308126));
      paramBaseViewHolder.EYx = ((ImageIndicatorView)paramBaseViewHolder.EYm.findViewById(2131308124));
      paramBaseViewHolder.tiQ = ((ImageView)paramBaseViewHolder.EYm.findViewById(2131308127));
      paramBaseViewHolder.EYw = ((Guideline)paramBaseViewHolder.EYm.findViewById(2131308125));
      AppMethodBeat.o(203928);
      return;
      paramBaseViewHolder.EYm = paramBaseViewHolder.convertView.findViewById(2131308123);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean EYl = false;
    View EYm;
    Guideline EYw;
    ImageIndicatorView EYx;
    ImageView EpU;
    ImageView tiQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */