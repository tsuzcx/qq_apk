package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(269007);
    int i = aj.fOV();
    if (paramBaseViewHolder.LkR != null) {
      if (!paramBaseViewHolder.LlE)
      {
        paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_media_collapse_item);
        paramBaseViewHolder.LlF = paramBaseViewHolder.LkR.inflate();
      }
    }
    for (paramBaseViewHolder.LlE = true;; paramBaseViewHolder.LlE = true)
    {
      paramBaseViewHolder.LkU = ((TagImageView)paramBaseViewHolder.LlF.findViewById(i.f.content_preview));
      paramBaseViewHolder.yVe = ((ImageView)paramBaseViewHolder.LlF.findViewById(i.f.state));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.LlF.findViewById(i.f.content_hint));
      paramViewStub = paramBaseViewHolder.LlF;
      ViewGroup.LayoutParams localLayoutParams = paramViewStub.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      paramViewStub.setLayoutParams(localLayoutParams);
      t.b(paramBaseViewHolder.LkU, this.mActivity);
      AppMethodBeat.o(269007);
      return;
      paramBaseViewHolder.LlF = paramBaseViewHolder.convertView.findViewById(i.f.content_collapse_rl);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100067);
    paramBaseViewHolder.LkU.setPosition(paramInt1);
    Object localObject2 = parambn.KDB;
    paramInt2 = paramTimeLineObject.ContentObj.Sqr.size();
    if (paramInt2 > 0)
    {
      parambn = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      switch (paramTimeLineObject.ContentObj.Sqq)
      {
      }
    }
    for (;;)
    {
      parambm.fXi().c(paramBaseViewHolder.LkU, parambm.Kdz.Lpg, parambm.Kdz.LoP);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.LkU.setOnClickListener(parambm.Kdz.KEA);
      Object localObject1 = new be();
      ((be)localObject1).fCM = ((String)localObject2);
      ((be)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.LkU);
      ((be)localObject1).KRL = ((List)localObject2);
      ((be)localObject1).KOn = this.KOn;
      ((be)localObject1).position = paramInt1;
      paramBaseViewHolder.LkU.setTag(localObject1);
      paramBaseViewHolder.LkU.setVisibility(0);
      localObject1 = aj.fOF();
      localObject2 = paramBaseViewHolder.LkU;
      paramInt1 = this.mActivity.hashCode();
      bp localbp = bp.hzh();
      localbp.time = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(parambn, (View)localObject2, paramInt1, localbp);
      paramBaseViewHolder.yVe.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(i.j.sns_photo_collapse_title, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.LkU.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.LkU.setOnClickListener(parambm.Kdz.Lpp);
      paramBaseViewHolder.yVe.setImageResource(i.i.sns_collapse_video_play);
      paramBaseViewHolder.yVe.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = aj.fOF();
      localObject2 = paramBaseViewHolder.LkU;
      paramInt1 = this.mActivity.hashCode();
      localbp = bp.hzh();
      localbp.time = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(parambn, (View)localObject2, paramInt1, localbp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */