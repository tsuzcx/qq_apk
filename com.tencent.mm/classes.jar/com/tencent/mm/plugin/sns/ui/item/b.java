package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100067);
    paramBaseViewHolder.zdp.setPosition(paramInt1);
    Object localObject2 = parambf.yzm;
    paramInt2 = paramTimeLineObject.FQo.Etz.size();
    if (paramInt2 > 0)
    {
      parambf = (btz)paramTimeLineObject.FQo.Etz.get(0);
      switch (paramTimeLineObject.FQo.Ety)
      {
      }
    }
    for (;;)
    {
      parambe.dQx().c(paramBaseViewHolder.zdp, parambe.xZe.zgG, parambe.xZe.zgp);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.zdp.setOnClickListener(parambe.xZe.yAf);
      Object localObject1 = new aw();
      ((aw)localObject1).dgl = ((String)localObject2);
      ((aw)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.zdp);
      ((aw)localObject1).yMc = ((List)localObject2);
      ((aw)localObject1).yIK = this.yIK;
      ((aw)localObject1).position = paramInt1;
      paramBaseViewHolder.zdp.setTag(localObject1);
      paramBaseViewHolder.zdp.setVisibility(0);
      localObject1 = af.dHO();
      localObject2 = paramBaseViewHolder.zdp;
      paramInt1 = this.mActivity.hashCode();
      com.tencent.mm.storage.bf localbf = com.tencent.mm.storage.bf.fbk();
      localbf.gIh = paramTimeLineObject.CreateTime;
      ((f)localObject1).b(parambf, (View)localObject2, paramInt1, localbf);
      paramBaseViewHolder.yxG.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(2131763937, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.zdp.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.zdp.setOnClickListener(parambe.xZe.zgN);
      paramBaseViewHolder.yxG.setImageResource(2131691189);
      paramBaseViewHolder.yxG.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = af.dHO();
      localObject2 = paramBaseViewHolder.zdp;
      paramInt1 = this.mActivity.hashCode();
      localbf = com.tencent.mm.storage.bf.fbk();
      localbf.gIh = paramTimeLineObject.CreateTime;
      ((f)localObject1).b(parambf, (View)localObject2, paramInt1, localbf);
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100066);
    int i = af.dIc();
    if (paramBaseViewHolder.zdm != null) {
      if (!paramBaseViewHolder.zdZ)
      {
        paramBaseViewHolder.zdm.setLayoutResource(2131495564);
        paramBaseViewHolder.zea = paramBaseViewHolder.zdm.inflate();
      }
    }
    for (paramBaseViewHolder.zdZ = true;; paramBaseViewHolder.zdZ = true)
    {
      paramBaseViewHolder.zdp = ((TagImageView)paramBaseViewHolder.zea.findViewById(2131298769));
      paramBaseViewHolder.yxG = ((ImageView)paramBaseViewHolder.zea.findViewById(2131305185));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.zea.findViewById(2131298756));
      View localView = paramBaseViewHolder.zea;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      q.b(paramBaseViewHolder.zdp, this.mActivity);
      AppMethodBeat.o(100066);
      return;
      paramBaseViewHolder.zea = paramBaseViewHolder.sSS.findViewById(2131298751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */