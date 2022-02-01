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
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import java.util.LinkedList;

public final class h
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100088);
    String str = parambi.AhK;
    if (!paramTimeLineObject.HUG.Gtx.isEmpty())
    {
      paramBaseViewHolder.AMv.setPosition(paramInt1);
      paramBaseViewHolder.Aza.setVisibility(0);
      parambi = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
      Object localObject1 = ah.dXB();
      Object localObject2 = paramBaseViewHolder.AMv;
      paramInt1 = this.mActivity.hashCode();
      bk localbk = bk.fvn();
      localbk.heF = paramTimeLineObject.CreateTime;
      ((g)localObject1).a(parambi, (View)localObject2, 2131689564, paramInt1, localbk);
      paramBaseViewHolder.AfZ.setPressed(false);
      localObject1 = paramTimeLineObject.Id;
      if (com.tencent.mm.ay.a.aJZ())
      {
        localObject2 = com.tencent.mm.ay.a.aKc();
        if ((localObject2 != null) && (com.tencent.mm.ay.a.e((f)localObject2)) && (((String)localObject1).equals(((f)localObject2).ijZ)))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label347;
          }
          paramBaseViewHolder.AfZ.setImageResource(2131233393);
          label171:
          paramBaseViewHolder.AMv.setTag(new s(paramTimeLineObject, str));
          paramBaseViewHolder.AMv.setOnClickListener(parambh.Asj.AHw);
          paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, str));
          parambh.egu().c(paramBaseViewHolder.Aza, parambh.zGs.AQb, parambh.zGs.APL);
          paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AyK);
          paramTimeLineObject = parambi.Desc;
          if (bu.isNullOrNil(paramTimeLineObject)) {
            break label359;
          }
          paramBaseViewHolder.AMw.setVisibility(0);
          paramBaseViewHolder.AMw.setText(paramTimeLineObject);
        }
      }
      for (;;)
      {
        parambi = parambi.Title;
        if (bu.isNullOrNil(parambi)) {
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
        paramBaseViewHolder.AfZ.setImageResource(2131233395);
        break label171;
        label359:
        paramBaseViewHolder.AMw.setVisibility(4);
      }
      label370:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(100088);
      return;
    }
    paramBaseViewHolder.Aza.setVisibility(8);
    AppMethodBeat.o(100088);
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100087);
    if (paramBaseViewHolder.AMs != null)
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495568);
      paramBaseViewHolder.ANf = ((ViewStub)paramBaseViewHolder.uan.findViewById(2131300969));
      if ((!paramBaseViewHolder.ANg) && (paramBaseViewHolder.ANf != null)) {
        paramBaseViewHolder.ANh = paramBaseViewHolder.ANf.inflate();
      }
    }
    for (paramBaseViewHolder.ANg = true;; paramBaseViewHolder.ANg = true)
    {
      paramBaseViewHolder.Aza = paramBaseViewHolder.ANh;
      paramBaseViewHolder.Aza.findViewById(2131305185).setOnTouchListener(this.zGX.Aib);
      paramBaseViewHolder.AMv = ((TagImageView)paramBaseViewHolder.Aza.findViewById(2131300948));
      paramBaseViewHolder.AfZ = ((ImageView)paramBaseViewHolder.Aza.findViewById(2131305185));
      paramBaseViewHolder.AMw = ((TextView)paramBaseViewHolder.Aza.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.Aza.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100914));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      r.b(paramBaseViewHolder.AMv, this.mActivity);
      AppMethodBeat.o(100087);
      return;
      paramBaseViewHolder.ANh = paramBaseViewHolder.uan.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */