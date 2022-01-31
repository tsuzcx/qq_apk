package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

public final class e
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40150);
    String str = paramaw.rGx;
    if (!paramTimeLineObject.xTS.wOa.isEmpty())
    {
      paramBaseViewHolder.sgW.setPosition(paramInt1);
      paramBaseViewHolder.rUS.setVisibility(0);
      paramaw = (bcs)paramTimeLineObject.xTS.wOa.get(0);
      Object localObject1 = ag.cpc();
      Object localObject2 = paramBaseViewHolder.sgW;
      paramInt1 = this.mActivity.hashCode();
      az localaz = az.dxB();
      localaz.oLs = paramTimeLineObject.CreateTime;
      ((g)localObject1).a(paramaw, (View)localObject2, 2131230809, paramInt1, localaz);
      paramBaseViewHolder.rFb.setPressed(false);
      localObject1 = paramTimeLineObject.Id;
      if (com.tencent.mm.aw.a.aiw())
      {
        localObject2 = com.tencent.mm.aw.a.aiz();
        if ((localObject2 != null) && (com.tencent.mm.aw.a.d((com.tencent.mm.aw.e)localObject2)) && (((String)localObject1).equals(((com.tencent.mm.aw.e)localObject2).fKj)))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label347;
          }
          paramBaseViewHolder.rFb.setImageResource(2130839751);
          label171:
          paramBaseViewHolder.sgW.setTag(new q(paramTimeLineObject, str));
          paramBaseViewHolder.sgW.setOnClickListener(paramav.rON.scE);
          paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, str));
          paramav.jVd.c(paramBaseViewHolder.rUS, paramav.rks.sjG, paramav.rks.sjr);
          paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.rUE);
          paramTimeLineObject = paramaw.Desc;
          if (bo.isNullOrNil(paramTimeLineObject)) {
            break label359;
          }
          paramBaseViewHolder.sgX.setVisibility(0);
          paramBaseViewHolder.sgX.setText(paramTimeLineObject);
        }
      }
      for (;;)
      {
        paramaw = paramaw.Title;
        if (bo.isNullOrNil(paramaw)) {
          break label370;
        }
        paramBaseViewHolder.titleTv.setVisibility(0);
        paramaw = new SpannableString(paramaw);
        paramBaseViewHolder.titleTv.setText(paramaw, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(40150);
        return;
        paramInt1 = 0;
        break;
        label347:
        paramBaseViewHolder.rFb.setImageResource(2130839753);
        break label171;
        label359:
        paramBaseViewHolder.sgX.setVisibility(4);
      }
      label370:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(40150);
      return;
    }
    paramBaseViewHolder.rUS.setVisibility(8);
    AppMethodBeat.o(40150);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40149);
    if (paramBaseViewHolder.sgT != null)
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970844);
      paramBaseViewHolder.shC = ((ViewStub)paramBaseViewHolder.ngZ.findViewById(2131827945));
      if ((!paramBaseViewHolder.shD) && (paramBaseViewHolder.shC != null)) {
        paramBaseViewHolder.shE = paramBaseViewHolder.shC.inflate();
      }
    }
    for (paramBaseViewHolder.shD = true;; paramBaseViewHolder.shD = true)
    {
      paramBaseViewHolder.rUS = paramBaseViewHolder.shE;
      paramBaseViewHolder.rUS.findViewById(2131824765).setOnTouchListener(this.rkX.rGO);
      paramBaseViewHolder.sgW = ((TagImageView)paramBaseViewHolder.rUS.findViewById(2131825855));
      paramBaseViewHolder.rFb = ((ImageView)paramBaseViewHolder.rUS.findViewById(2131824765));
      paramBaseViewHolder.sgX = ((TextView)paramBaseViewHolder.rUS.findViewById(2131825858));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.rUS.findViewById(2131825857));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131690489));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      i.b(paramBaseViewHolder.sgW, this.mActivity);
      AppMethodBeat.o(40149);
      return;
      paramBaseViewHolder.shE = paramBaseViewHolder.ngZ.findViewById(2131828028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */