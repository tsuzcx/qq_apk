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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import java.util.LinkedList;

public final class h
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100088);
    String str = parambi.zQD;
    if (!paramTimeLineObject.HAT.GaQ.isEmpty())
    {
      paramBaseViewHolder.Avf.setPosition(paramInt1);
      paramBaseViewHolder.AhO.setVisibility(0);
      parambi = (byn)paramTimeLineObject.HAT.GaQ.get(0);
      Object localObject1 = ag.dUb();
      Object localObject2 = paramBaseViewHolder.Avf;
      paramInt1 = this.mActivity.hashCode();
      bj localbj = bj.frn();
      localbj.hbR = paramTimeLineObject.CreateTime;
      ((com.tencent.mm.plugin.sns.model.f)localObject1).a(parambi, (View)localObject2, 2131689564, paramInt1, localbj);
      paramBaseViewHolder.zOS.setPressed(false);
      localObject1 = paramTimeLineObject.Id;
      if (com.tencent.mm.az.a.aJG())
      {
        localObject2 = com.tencent.mm.az.a.aJJ();
        if ((localObject2 != null) && (com.tencent.mm.az.a.e((com.tencent.mm.az.f)localObject2)) && (((String)localObject1).equals(((com.tencent.mm.az.f)localObject2).ihg)))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label347;
          }
          paramBaseViewHolder.zOS.setImageResource(2131233393);
          label171:
          paramBaseViewHolder.Avf.setTag(new s(paramTimeLineObject, str));
          paramBaseViewHolder.Avf.setOnClickListener(parambh.AaW.Aqi);
          paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, str));
          parambh.ecN().c(paramBaseViewHolder.AhO, parambh.zpd.AyF, parambh.zpd.Ayq);
          paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Ahy);
          paramTimeLineObject = parambi.Desc;
          if (bt.isNullOrNil(paramTimeLineObject)) {
            break label359;
          }
          paramBaseViewHolder.Avg.setVisibility(0);
          paramBaseViewHolder.Avg.setText(paramTimeLineObject);
        }
      }
      for (;;)
      {
        parambi = parambi.Title;
        if (bt.isNullOrNil(parambi)) {
          break label370;
        }
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambi = new SpannableString(parambi);
        paramBaseViewHolder.titleTv.setText(parambi, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(100088);
        return;
        paramInt1 = 0;
        break;
        label347:
        paramBaseViewHolder.zOS.setImageResource(2131233395);
        break label171;
        label359:
        paramBaseViewHolder.Avg.setVisibility(4);
      }
      label370:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(100088);
      return;
    }
    paramBaseViewHolder.AhO.setVisibility(8);
    AppMethodBeat.o(100088);
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100087);
    if (paramBaseViewHolder.Avc != null)
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495568);
      paramBaseViewHolder.AvO = ((ViewStub)paramBaseViewHolder.tPw.findViewById(2131300969));
      if ((!paramBaseViewHolder.AvP) && (paramBaseViewHolder.AvO != null)) {
        paramBaseViewHolder.AvQ = paramBaseViewHolder.AvO.inflate();
      }
    }
    for (paramBaseViewHolder.AvP = true;; paramBaseViewHolder.AvP = true)
    {
      paramBaseViewHolder.AhO = paramBaseViewHolder.AvQ;
      paramBaseViewHolder.AhO.findViewById(2131305185).setOnTouchListener(this.zpI.zQU);
      paramBaseViewHolder.Avf = ((TagImageView)paramBaseViewHolder.AhO.findViewById(2131300948));
      paramBaseViewHolder.zOS = ((ImageView)paramBaseViewHolder.AhO.findViewById(2131305185));
      paramBaseViewHolder.Avg = ((TextView)paramBaseViewHolder.AhO.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.AhO.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100914));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      q.b(paramBaseViewHolder.Avf, this.mActivity);
      AppMethodBeat.o(100087);
      return;
      paramBaseViewHolder.AvQ = paramBaseViewHolder.tPw.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */