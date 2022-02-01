package com.tencent.mm.plugin.sns.ui.item;

import android.support.constraint.Guideline;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class c
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(198545);
    Object localObject;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaU != null))
    {
      paramBaseViewHolder = (a)paramBaseViewHolder;
      localObject = paramTimeLineObject.HAT.GaU;
      if (!bt.hj(((arj)localObject).mediaList))
      {
        parambi = (ari)((arj)localObject).mediaList.get(0);
        if (parambi != null)
        {
          if (((arj)localObject).Gpi != 4) {
            break label263;
          }
          paramBaseViewHolder.zQn.setVisibility(0);
          paramBaseViewHolder.AwK.setVisibility(8);
          paramBaseViewHolder.AwJ.setGuidelineEnd(0);
          localObject = h.a((int)parambi.width, (int)parambi.height, paramBaseViewHolder.AwI.getContext(), false);
          paramInt1 = ((Integer)((Pair)localObject).first).intValue();
          paramInt2 = ((Integer)((Pair)localObject).second).intValue();
          paramBaseViewHolder.AwI.getLayoutParams().width = paramInt1;
          paramBaseViewHolder.AwI.getLayoutParams().height = paramInt2;
          paramBaseViewHolder.AwI.requestLayout();
        }
      }
    }
    for (;;)
    {
      ((t)g.ad(t.class)).loadImage(parambi.thumbUrl, paramBaseViewHolder.rAT);
      paramBaseViewHolder.AwI.setTag(paramTimeLineObject);
      paramBaseViewHolder.AwI.setOnClickListener(parambh.AaW.ApY);
      parambh.ecN().c(paramBaseViewHolder.AwI, parambh.zpd.AyM, parambh.zpd.Ayq);
      AppMethodBeat.o(198545);
      return;
      label263:
      paramBaseViewHolder.zQn.setVisibility(8);
      paramBaseViewHolder.AwK.setVisibility(8);
      paramBaseViewHolder.AwK.ABt = ((arj)localObject).dqU;
      paramBaseViewHolder.AwJ.setGuidelineEnd(0);
      localObject = h.a((int)parambi.width, (int)parambi.height, paramBaseViewHolder.AwI.getContext());
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      paramInt2 = ((Integer)((Pair)localObject).second).intValue();
      paramBaseViewHolder.AwI.getLayoutParams().width = paramInt1;
      paramBaseViewHolder.AwI.getLayoutParams().height = paramInt2;
      paramBaseViewHolder.AwI.requestLayout();
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(198544);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.Avc != null) && (paramBaseViewHolder.Avc.getParent() != null))
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131496489);
      if (!locala.AwH) {
        locala.AwI = paramBaseViewHolder.Avc.inflate();
      }
    }
    for (locala.AwH = true;; locala.AwH = true)
    {
      locala.zQn = ((ImageView)locala.AwI.findViewById(2131308429));
      locala.AwK = ((ImageIndicatorView)locala.AwI.findViewById(2131308427));
      locala.rAT = ((ImageView)locala.AwI.findViewById(2131308430));
      locala.AwJ = ((Guideline)locala.AwI.findViewById(2131308428));
      AppMethodBeat.o(198544);
      return;
      locala.AwI = paramBaseViewHolder.tPw.findViewById(2131308426);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean AwH = false;
    View AwI;
    Guideline AwJ;
    ImageIndicatorView AwK;
    ImageView rAT;
    ImageView zQn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */