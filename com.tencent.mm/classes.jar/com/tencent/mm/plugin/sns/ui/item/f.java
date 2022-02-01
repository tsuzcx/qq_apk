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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class f
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100088);
    String str = parambf.yzm;
    if (!paramTimeLineObject.FQo.Etz.isEmpty())
    {
      paramBaseViewHolder.zdp.setPosition(paramInt1);
      paramBaseViewHolder.yQs.setVisibility(0);
      parambf = (btz)paramTimeLineObject.FQo.Etz.get(0);
      Object localObject1 = af.dHO();
      Object localObject2 = paramBaseViewHolder.zdp;
      paramInt1 = this.mActivity.hashCode();
      com.tencent.mm.storage.bf localbf = com.tencent.mm.storage.bf.fbk();
      localbf.gIh = paramTimeLineObject.CreateTime;
      ((com.tencent.mm.plugin.sns.model.f)localObject1).a(parambf, (View)localObject2, 2131689564, paramInt1, localbf);
      paramBaseViewHolder.yxG.setPressed(false);
      localObject1 = paramTimeLineObject.Id;
      if (com.tencent.mm.ay.a.aGv())
      {
        localObject2 = com.tencent.mm.ay.a.aGy();
        if ((localObject2 != null) && (com.tencent.mm.ay.a.e((com.tencent.mm.ay.f)localObject2)) && (((String)localObject1).equals(((com.tencent.mm.ay.f)localObject2).hNS)))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label347;
          }
          paramBaseViewHolder.yxG.setImageResource(2131233393);
          label171:
          paramBaseViewHolder.zdp.setTag(new s(paramTimeLineObject, str));
          paramBaseViewHolder.zdp.setOnClickListener(parambe.yJC.yYu);
          paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, str));
          parambe.dQx().c(paramBaseViewHolder.yQs, parambe.xZe.zgE, parambe.xZe.zgp);
          paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yQc);
          paramTimeLineObject = parambf.Desc;
          if (bs.isNullOrNil(paramTimeLineObject)) {
            break label359;
          }
          paramBaseViewHolder.zdq.setVisibility(0);
          paramBaseViewHolder.zdq.setText(paramTimeLineObject);
        }
      }
      for (;;)
      {
        parambf = parambf.Title;
        if (bs.isNullOrNil(parambf)) {
          break label370;
        }
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambf = new SpannableString(parambf);
        paramBaseViewHolder.titleTv.setText(parambf, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(100088);
        return;
        paramInt1 = 0;
        break;
        label347:
        paramBaseViewHolder.yxG.setImageResource(2131233395);
        break label171;
        label359:
        paramBaseViewHolder.zdq.setVisibility(4);
      }
      label370:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(100088);
      return;
    }
    paramBaseViewHolder.yQs.setVisibility(8);
    AppMethodBeat.o(100088);
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100087);
    if (paramBaseViewHolder.zdm != null)
    {
      paramBaseViewHolder.zdm.setLayoutResource(2131495568);
      paramBaseViewHolder.zdY = ((ViewStub)paramBaseViewHolder.sSS.findViewById(2131300969));
      if ((!paramBaseViewHolder.zdZ) && (paramBaseViewHolder.zdY != null)) {
        paramBaseViewHolder.zea = paramBaseViewHolder.zdY.inflate();
      }
    }
    for (paramBaseViewHolder.zdZ = true;; paramBaseViewHolder.zdZ = true)
    {
      paramBaseViewHolder.yQs = paramBaseViewHolder.zea;
      paramBaseViewHolder.yQs.findViewById(2131305185).setOnTouchListener(this.xZJ.yzD);
      paramBaseViewHolder.zdp = ((TagImageView)paramBaseViewHolder.yQs.findViewById(2131300948));
      paramBaseViewHolder.yxG = ((ImageView)paramBaseViewHolder.yQs.findViewById(2131305185));
      paramBaseViewHolder.zdq = ((TextView)paramBaseViewHolder.yQs.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.yQs.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100914));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      q.b(paramBaseViewHolder.zdp, this.mActivity);
      AppMethodBeat.o(100087);
      return;
      paramBaseViewHolder.zea = paramBaseViewHolder.sSS.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */