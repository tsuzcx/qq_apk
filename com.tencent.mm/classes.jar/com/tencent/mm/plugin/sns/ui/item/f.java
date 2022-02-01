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
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import java.util.LinkedList;

public final class f
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100088);
    String str = parambf.xmu;
    if (!paramTimeLineObject.Etm.DaC.isEmpty())
    {
      paramBaseViewHolder.xQz.setPosition(paramInt1);
      paramBaseViewHolder.xDE.setVisibility(0);
      parambf = (bpi)paramTimeLineObject.Etm.DaC.get(0);
      Object localObject1 = af.dtr();
      Object localObject2 = paramBaseViewHolder.xQz;
      paramInt1 = this.mActivity.hashCode();
      bc localbc = bc.eLG();
      localbc.tGD = paramTimeLineObject.CreateTime;
      ((com.tencent.mm.plugin.sns.model.f)localObject1).a(parambf, (View)localObject2, 2131689564, paramInt1, localbc);
      paramBaseViewHolder.xkO.setPressed(false);
      localObject1 = paramTimeLineObject.Id;
      if (com.tencent.mm.az.a.azF())
      {
        localObject2 = com.tencent.mm.az.a.azI();
        if ((localObject2 != null) && (com.tencent.mm.az.a.e((com.tencent.mm.az.f)localObject2)) && (((String)localObject1).equals(((com.tencent.mm.az.f)localObject2).hnp)))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label347;
          }
          paramBaseViewHolder.xkO.setImageResource(2131233393);
          label171:
          paramBaseViewHolder.xQz.setTag(new s(paramTimeLineObject, str));
          paramBaseViewHolder.xQz.setOnClickListener(parambe.xwM.xLF);
          paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, str));
          parambe.dCa().c(paramBaseViewHolder.xDE, parambe.wMy.xTI, parambe.wMy.xTt);
          paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xDo);
          paramTimeLineObject = parambf.Desc;
          if (bt.isNullOrNil(paramTimeLineObject)) {
            break label359;
          }
          paramBaseViewHolder.xQA.setVisibility(0);
          paramBaseViewHolder.xQA.setText(paramTimeLineObject);
        }
      }
      for (;;)
      {
        parambf = parambf.Title;
        if (bt.isNullOrNil(parambf)) {
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
        paramBaseViewHolder.xkO.setImageResource(2131233395);
        break label171;
        label359:
        paramBaseViewHolder.xQA.setVisibility(4);
      }
      label370:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(100088);
      return;
    }
    paramBaseViewHolder.xDE.setVisibility(8);
    AppMethodBeat.o(100088);
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100087);
    if (paramBaseViewHolder.xQw != null)
    {
      paramBaseViewHolder.xQw.setLayoutResource(2131495568);
      paramBaseViewHolder.xRi = ((ViewStub)paramBaseViewHolder.rLd.findViewById(2131300969));
      if ((!paramBaseViewHolder.xRj) && (paramBaseViewHolder.xRi != null)) {
        paramBaseViewHolder.xRk = paramBaseViewHolder.xRi.inflate();
      }
    }
    for (paramBaseViewHolder.xRj = true;; paramBaseViewHolder.xRj = true)
    {
      paramBaseViewHolder.xDE = paramBaseViewHolder.xRk;
      paramBaseViewHolder.xDE.findViewById(2131305185).setOnTouchListener(this.wNd.xmL);
      paramBaseViewHolder.xQz = ((TagImageView)paramBaseViewHolder.xDE.findViewById(2131300948));
      paramBaseViewHolder.xkO = ((ImageView)paramBaseViewHolder.xDE.findViewById(2131305185));
      paramBaseViewHolder.xQA = ((TextView)paramBaseViewHolder.xDE.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.xDE.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100914));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      q.b(paramBaseViewHolder.xQz, this.mActivity);
      AppMethodBeat.o(100087);
      return;
      paramBaseViewHolder.xRk = paramBaseViewHolder.rLd.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */