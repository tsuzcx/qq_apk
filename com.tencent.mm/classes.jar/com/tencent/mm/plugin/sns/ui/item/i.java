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
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class i
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(308998);
    Object localObject;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpy != null))
    {
      paramBaseViewHolder = (a)paramBaseViewHolder;
      localObject = paramTimeLineObject.ContentObj.Zpy;
      if (!Util.isNullOrNil(((doc)localObject).mediaList))
      {
        localObject = (dob)((doc)localObject).mediaList.get(0);
        if (localObject != null)
        {
          paramBaseViewHolder.RcO.setVisibility(0);
          paramBaseViewHolder.RMC.setVisibility(8);
          paramBaseViewHolder.RMB.setGuidelineEnd(0);
          Pair localPair = o.a((int)((dob)localObject).width, (int)((dob)localObject).height, paramBaseViewHolder.RMo.getContext(), false);
          paramInt1 = ((Integer)localPair.first).intValue();
          paramInt2 = ((Integer)localPair.second).intValue();
          paramBaseViewHolder.RMo.getLayoutParams().width = paramInt1;
          paramBaseViewHolder.RMo.getLayoutParams().height = paramInt2;
          paramBaseViewHolder.RMo.requestLayout();
          if (TextUtils.isEmpty(((dob)localObject).coverUrl)) {
            break label275;
          }
          ((cn)h.az(cn.class)).loadImage(((dob)localObject).coverUrl, paramBaseViewHolder.AlJ);
        }
      }
    }
    for (;;)
    {
      paramBaseViewHolder.RMo.setTag(paramTimeLineObject);
      paramBaseViewHolder.RMo.setOnClickListener(parambn.RoS.RFr);
      parambn.hpB().c(paramBaseViewHolder.RMo, parambn.QBf.RQq, parambn.QBf.RPU);
      a(parambo, 1);
      AppMethodBeat.o(308998);
      return;
      label275:
      ((cn)h.az(cn.class)).loadImage(((dob)localObject).thumbUrl, paramBaseViewHolder.AlJ);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(308992);
    paramBaseViewHolder = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null))
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_finder_media_item);
      if (!paramBaseViewHolder.RMn) {
        paramBaseViewHolder.RMo = paramBaseViewHolder.RKG.inflate();
      }
    }
    for (paramBaseViewHolder.RMn = true;; paramBaseViewHolder.RMn = true)
    {
      paramBaseViewHolder.RcO = ((ImageView)paramBaseViewHolder.RMo.findViewById(b.f.sns_finder_media_status_icon));
      paramBaseViewHolder.RMC = ((ImageIndicatorView)paramBaseViewHolder.RMo.findViewById(b.f.sns_finder_media_image_count_indicator));
      paramBaseViewHolder.AlJ = ((ImageView)paramBaseViewHolder.RMo.findViewById(b.f.sns_finder_media_thumb));
      paramBaseViewHolder.RMB = ((Guideline)paramBaseViewHolder.RMo.findViewById(b.f.sns_finder_media_image_count_indicator_guide_line));
      AppMethodBeat.o(308992);
      return;
      paramBaseViewHolder.RMo = paramBaseViewHolder.convertView.findViewById(b.f.sns_finder_media_content_rl);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    ImageView AlJ;
    Guideline RMB;
    ImageIndicatorView RMC;
    boolean RMn = false;
    View RMo;
    ImageView RcO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */