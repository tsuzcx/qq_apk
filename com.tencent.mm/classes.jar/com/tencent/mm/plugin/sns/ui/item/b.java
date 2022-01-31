package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40134);
    paramBaseViewHolder.sgW.setPosition(paramInt1);
    Object localObject2 = paramaw.rGx;
    paramInt2 = paramTimeLineObject.xTS.wOa.size();
    if (paramInt2 > 0)
    {
      paramaw = (bcs)paramTimeLineObject.xTS.wOa.get(0);
      switch (paramTimeLineObject.xTS.wNZ)
      {
      }
    }
    for (;;)
    {
      paramav.jVd.c(paramBaseViewHolder.sgW, paramav.rks.sjI, paramav.rks.sjr);
      AppMethodBeat.o(40134);
      return;
      paramBaseViewHolder.sgW.setOnClickListener(paramav.rks.rHw);
      Object localObject1 = new ao();
      ((ao)localObject1).ctV = ((String)localObject2);
      ((ao)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.sgW);
      ((ao)localObject1).rQS = ((List)localObject2);
      ((ao)localObject1).rNW = this.rNW;
      ((ao)localObject1).position = paramInt1;
      paramBaseViewHolder.sgW.setTag(localObject1);
      paramBaseViewHolder.sgW.setVisibility(0);
      localObject1 = ag.cpc();
      localObject2 = paramBaseViewHolder.sgW;
      paramInt1 = this.mActivity.hashCode();
      az localaz = az.dxB();
      localaz.oLs = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(paramaw, (View)localObject2, paramInt1, localaz);
      paramBaseViewHolder.rFb.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(2131303923, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.sgW.setTag(new q(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.sgW.setOnClickListener(paramav.rks.sjP);
      paramBaseViewHolder.rFb.setImageResource(2131232003);
      paramBaseViewHolder.rFb.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = ag.cpc();
      localObject2 = paramBaseViewHolder.sgW;
      paramInt1 = this.mActivity.hashCode();
      localaz = az.dxB();
      localaz.oLs = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(paramaw, (View)localObject2, paramInt1, localaz);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40133);
    int i = ag.cpn();
    if (paramBaseViewHolder.sgT != null) {
      if (!paramBaseViewHolder.shD)
      {
        paramBaseViewHolder.sgT.setLayoutResource(2130970840);
        paramBaseViewHolder.shE = paramBaseViewHolder.sgT.inflate();
      }
    }
    for (paramBaseViewHolder.shD = true;; paramBaseViewHolder.shD = true)
    {
      paramBaseViewHolder.sgW = ((TagImageView)paramBaseViewHolder.shE.findViewById(2131828022));
      paramBaseViewHolder.rFb = ((ImageView)paramBaseViewHolder.shE.findViewById(2131824765));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.shE.findViewById(2131828024));
      View localView = paramBaseViewHolder.shE;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      i.b(paramBaseViewHolder.sgW, this.mActivity);
      AppMethodBeat.o(40133);
      return;
      paramBaseViewHolder.shE = paramBaseViewHolder.ngZ.findViewById(2131828021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */