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
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class c
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(220087);
    Object localObject;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.GtB != null))
    {
      paramBaseViewHolder = (a)paramBaseViewHolder;
      localObject = paramTimeLineObject.HUG.GtB;
      if (!bu.ht(((ary)localObject).mediaList))
      {
        parambi = (arx)((ary)localObject).mediaList.get(0);
        if (parambi != null)
        {
          if (((ary)localObject).GIy != 4) {
            break label263;
          }
          paramBaseViewHolder.Ahu.setVisibility(0);
          paramBaseViewHolder.AOc.setVisibility(8);
          paramBaseViewHolder.AOb.setGuidelineEnd(0);
          localObject = h.a((int)parambi.width, (int)parambi.height, paramBaseViewHolder.AOa.getContext(), false);
          paramInt1 = ((Integer)((Pair)localObject).first).intValue();
          paramInt2 = ((Integer)((Pair)localObject).second).intValue();
          paramBaseViewHolder.AOa.getLayoutParams().width = paramInt1;
          paramBaseViewHolder.AOa.getLayoutParams().height = paramInt2;
          paramBaseViewHolder.AOa.requestLayout();
        }
      }
    }
    for (;;)
    {
      ((t)g.ad(t.class)).loadImage(parambi.thumbUrl, paramBaseViewHolder.rJe);
      paramBaseViewHolder.AOa.setTag(paramTimeLineObject);
      paramBaseViewHolder.AOa.setOnClickListener(parambh.Asj.AHm);
      parambh.egu().c(paramBaseViewHolder.AOa, parambh.zGs.AQi, parambh.zGs.APL);
      AppMethodBeat.o(220087);
      return;
      label263:
      paramBaseViewHolder.Ahu.setVisibility(8);
      paramBaseViewHolder.AOc.setVisibility(8);
      paramBaseViewHolder.AOc.ASU = ((ary)localObject).drZ;
      paramBaseViewHolder.AOb.setGuidelineEnd(0);
      localObject = h.a((int)parambi.width, (int)parambi.height, paramBaseViewHolder.AOa.getContext());
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      paramInt2 = ((Integer)((Pair)localObject).second).intValue();
      paramBaseViewHolder.AOa.getLayoutParams().width = paramInt1;
      paramBaseViewHolder.AOa.getLayoutParams().height = paramInt2;
      paramBaseViewHolder.AOa.requestLayout();
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(220086);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.AMs != null) && (paramBaseViewHolder.AMs.getParent() != null))
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131496489);
      if (!locala.ANZ) {
        locala.AOa = paramBaseViewHolder.AMs.inflate();
      }
    }
    for (locala.ANZ = true;; locala.ANZ = true)
    {
      locala.Ahu = ((ImageView)locala.AOa.findViewById(2131308429));
      locala.AOc = ((ImageIndicatorView)locala.AOa.findViewById(2131308427));
      locala.rJe = ((ImageView)locala.AOa.findViewById(2131308430));
      locala.AOb = ((Guideline)locala.AOa.findViewById(2131308428));
      AppMethodBeat.o(220086);
      return;
      locala.AOa = paramBaseViewHolder.uan.findViewById(2131308426);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean ANZ = false;
    View AOa;
    Guideline AOb;
    ImageIndicatorView AOc;
    ImageView Ahu;
    ImageView rJe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */