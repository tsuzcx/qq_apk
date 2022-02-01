package com.tencent.mm.plugin.sns.ui.item;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class k
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(258316);
    paramViewStub = (a)paramBaseViewHolder;
    if ((paramViewStub.LkR != null) && (paramViewStub.LkR.getParent() != null))
    {
      paramViewStub.LkR.setLayoutResource(i.g.sns_finder_media_item);
      if (!paramViewStub.Lmy) {
        paramViewStub.Lmz = paramViewStub.LkR.inflate();
      }
    }
    for (paramViewStub.Lmy = true;; paramViewStub.Lmy = true)
    {
      paramViewStub.KDh = ((ImageView)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_status_icon));
      paramViewStub.LmN = ((ImageIndicatorView)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_image_count_indicator));
      paramViewStub.wPh = ((ImageView)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_thumb));
      paramViewStub.LmM = ((Guideline)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_image_count_indicator_guide_line));
      AppMethodBeat.o(258316);
      return;
      paramViewStub.Lmz = paramViewStub.convertView.findViewById(i.f.sns_finder_media_content_rl);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(258317);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqy != null))
    {
      paramBaseViewHolder = (a)paramBaseViewHolder;
      parambn = paramTimeLineObject.ContentObj.Sqy;
      if (!Util.isNullOrNil(parambn.mediaList))
      {
        parambn = (cww)parambn.mediaList.get(0);
        if (parambn != null)
        {
          paramBaseViewHolder.KDh.setVisibility(0);
          paramBaseViewHolder.LmN.setVisibility(8);
          paramBaseViewHolder.LmM.setGuidelineEnd(0);
          Pair localPair = o.a((int)parambn.width, (int)parambn.height, paramBaseViewHolder.Lmz.getContext(), false);
          paramInt1 = ((Integer)localPair.first).intValue();
          paramInt2 = ((Integer)localPair.second).intValue();
          paramBaseViewHolder.Lmz.getLayoutParams().width = paramInt1;
          paramBaseViewHolder.Lmz.getLayoutParams().height = paramInt2;
          paramBaseViewHolder.Lmz.requestLayout();
          if (TextUtils.isEmpty(parambn.coverUrl)) {
            break label261;
          }
          ((ak)h.ag(ak.class)).loadImage(parambn.coverUrl, paramBaseViewHolder.wPh);
        }
      }
    }
    for (;;)
    {
      paramBaseViewHolder.Lmz.setTag(paramTimeLineObject);
      paramBaseViewHolder.Lmz.setOnClickListener(parambm.KPg.Lff);
      parambm.fXi().c(paramBaseViewHolder.Lmz, parambm.Kdz.Lpl, parambm.Kdz.LoP);
      AppMethodBeat.o(258317);
      return;
      label261:
      ((ak)h.ag(ak.class)).loadImage(parambn.thumbUrl, paramBaseViewHolder.wPh);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    ImageView KDh;
    Guideline LmM;
    ImageIndicatorView LmN;
    boolean Lmy = false;
    View Lmz;
    ImageView wPh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */