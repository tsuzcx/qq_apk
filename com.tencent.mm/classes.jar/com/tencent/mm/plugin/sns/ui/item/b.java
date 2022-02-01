package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100067);
    paramBaseViewHolder.AMv.setPosition(paramInt1);
    Object localObject2 = parambi.AhK;
    paramInt2 = paramTimeLineObject.HUG.Gtx.size();
    if (paramInt2 > 0)
    {
      parambi = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
      switch (paramTimeLineObject.HUG.Gtw)
      {
      }
    }
    for (;;)
    {
      parambh.egu().c(paramBaseViewHolder.AMv, parambh.zGs.AQd, parambh.zGs.APL);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.AMv.setOnClickListener(parambh.zGs.AiC);
      Object localObject1 = new az();
      ((az)localObject1).dsN = ((String)localObject2);
      ((az)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.AMv);
      ((az)localObject1).AuK = ((List)localObject2);
      ((az)localObject1).Arr = this.Arr;
      ((az)localObject1).position = paramInt1;
      paramBaseViewHolder.AMv.setTag(localObject1);
      paramBaseViewHolder.AMv.setVisibility(0);
      localObject1 = ah.dXB();
      localObject2 = paramBaseViewHolder.AMv;
      paramInt1 = this.mActivity.hashCode();
      bk localbk = bk.fvn();
      localbk.heF = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(parambi, (View)localObject2, paramInt1, localbk);
      paramBaseViewHolder.AfZ.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(2131763937, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.AMv.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.AMv.setOnClickListener(parambh.zGs.AQm);
      paramBaseViewHolder.AfZ.setImageResource(2131691189);
      paramBaseViewHolder.AfZ.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = ah.dXB();
      localObject2 = paramBaseViewHolder.AMv;
      paramInt1 = this.mActivity.hashCode();
      localbk = bk.fvn();
      localbk.heF = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(parambi, (View)localObject2, paramInt1, localbk);
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100066);
    int i = ah.dXP();
    if (paramBaseViewHolder.AMs != null) {
      if (!paramBaseViewHolder.ANg)
      {
        paramBaseViewHolder.AMs.setLayoutResource(2131495564);
        paramBaseViewHolder.ANh = paramBaseViewHolder.AMs.inflate();
      }
    }
    for (paramBaseViewHolder.ANg = true;; paramBaseViewHolder.ANg = true)
    {
      paramBaseViewHolder.AMv = ((TagImageView)paramBaseViewHolder.ANh.findViewById(2131298769));
      paramBaseViewHolder.AfZ = ((ImageView)paramBaseViewHolder.ANh.findViewById(2131305185));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.ANh.findViewById(2131298756));
      View localView = paramBaseViewHolder.ANh;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      r.b(paramBaseViewHolder.AMv, this.mActivity);
      AppMethodBeat.o(100066);
      return;
      paramBaseViewHolder.ANh = paramBaseViewHolder.uan.findViewById(2131298751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */