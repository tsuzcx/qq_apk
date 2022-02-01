package com.tencent.mm.plugin.sns.ui.item;

import android.support.constraint.Guideline;
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
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class d
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(203919);
    Object localObject;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.dME != null))
    {
      paramBaseViewHolder = (a)paramBaseViewHolder;
      localObject = paramTimeLineObject.ContentObj.dME;
      if (!Util.isNullOrNil(((bcj)localObject).mediaList))
      {
        parambl = (bch)((bcj)localObject).mediaList.get(0);
        if (parambl != null)
        {
          if (((bcj)localObject).vXJ != 4) {
            break label263;
          }
          paramBaseViewHolder.EpU.setVisibility(0);
          paramBaseViewHolder.EYx.setVisibility(8);
          paramBaseViewHolder.EYw.setGuidelineEnd(0);
          localObject = n.a((int)parambl.width, (int)parambl.height, paramBaseViewHolder.EYm.getContext(), false);
          paramInt1 = ((Integer)((Pair)localObject).first).intValue();
          paramInt2 = ((Integer)((Pair)localObject).second).intValue();
          paramBaseViewHolder.EYm.getLayoutParams().width = paramInt1;
          paramBaseViewHolder.EYm.getLayoutParams().height = paramInt2;
          paramBaseViewHolder.EYm.requestLayout();
        }
      }
    }
    for (;;)
    {
      ((aj)g.ah(aj.class)).loadImage(parambl.thumbUrl, paramBaseViewHolder.tiQ);
      paramBaseViewHolder.EYm.setTag(paramTimeLineObject);
      paramBaseViewHolder.EYm.setOnClickListener(parambk.EBo.ERd);
      parambk.fiV().c(paramBaseViewHolder.EYm, parambk.DQs.FaN, parambk.DQs.Far);
      AppMethodBeat.o(203919);
      return;
      label263:
      paramBaseViewHolder.EpU.setVisibility(8);
      paramBaseViewHolder.EYx.setVisibility(8);
      paramBaseViewHolder.EYx.FdA = ((bcj)localObject).dJl;
      paramBaseViewHolder.EYw.setGuidelineEnd(0);
      localObject = n.a((int)parambl.width, (int)parambl.height, paramBaseViewHolder.EYm.getContext());
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      paramInt2 = ((Integer)((Pair)localObject).second).intValue();
      paramBaseViewHolder.EYm.getLayoutParams().width = paramInt1;
      paramBaseViewHolder.EYm.getLayoutParams().height = paramInt2;
      paramBaseViewHolder.EYm.requestLayout();
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203918);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.EWD != null) && (paramBaseViewHolder.EWD.getParent() != null))
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496437);
      if (!locala.EYl) {
        locala.EYm = paramBaseViewHolder.EWD.inflate();
      }
    }
    for (locala.EYl = true;; locala.EYl = true)
    {
      locala.EpU = ((ImageView)locala.EYm.findViewById(2131308126));
      locala.EYx = ((ImageIndicatorView)locala.EYm.findViewById(2131308124));
      locala.tiQ = ((ImageView)locala.EYm.findViewById(2131308127));
      locala.EYw = ((Guideline)locala.EYm.findViewById(2131308125));
      AppMethodBeat.o(203918);
      return;
      locala.EYm = paramBaseViewHolder.convertView.findViewById(2131308123);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */