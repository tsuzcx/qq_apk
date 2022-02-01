package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.storage.bj;
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
    paramBaseViewHolder.Avf.setPosition(paramInt1);
    Object localObject2 = parambi.zQD;
    paramInt2 = paramTimeLineObject.HAT.GaQ.size();
    if (paramInt2 > 0)
    {
      parambi = (byn)paramTimeLineObject.HAT.GaQ.get(0);
      switch (paramTimeLineObject.HAT.GaP)
      {
      }
    }
    for (;;)
    {
      parambh.ecN().c(paramBaseViewHolder.Avf, parambh.zpd.AyH, parambh.zpd.Ayq);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.Avf.setOnClickListener(parambh.zpd.zRv);
      Object localObject1 = new az();
      ((az)localObject1).drH = ((String)localObject2);
      ((az)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.Avf);
      ((az)localObject1).Ady = ((List)localObject2);
      ((az)localObject1).Aae = this.Aae;
      ((az)localObject1).position = paramInt1;
      paramBaseViewHolder.Avf.setTag(localObject1);
      paramBaseViewHolder.Avf.setVisibility(0);
      localObject1 = ag.dUb();
      localObject2 = paramBaseViewHolder.Avf;
      paramInt1 = this.mActivity.hashCode();
      bj localbj = bj.frn();
      localbj.hbR = paramTimeLineObject.CreateTime;
      ((f)localObject1).b(parambi, (View)localObject2, paramInt1, localbj);
      paramBaseViewHolder.zOS.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(2131763937, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.Avf.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.Avf.setOnClickListener(parambh.zpd.AyQ);
      paramBaseViewHolder.zOS.setImageResource(2131691189);
      paramBaseViewHolder.zOS.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = ag.dUb();
      localObject2 = paramBaseViewHolder.Avf;
      paramInt1 = this.mActivity.hashCode();
      localbj = bj.frn();
      localbj.hbR = paramTimeLineObject.CreateTime;
      ((f)localObject1).b(parambi, (View)localObject2, paramInt1, localbj);
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100066);
    int i = ag.dUp();
    if (paramBaseViewHolder.Avc != null) {
      if (!paramBaseViewHolder.AvP)
      {
        paramBaseViewHolder.Avc.setLayoutResource(2131495564);
        paramBaseViewHolder.AvQ = paramBaseViewHolder.Avc.inflate();
      }
    }
    for (paramBaseViewHolder.AvP = true;; paramBaseViewHolder.AvP = true)
    {
      paramBaseViewHolder.Avf = ((TagImageView)paramBaseViewHolder.AvQ.findViewById(2131298769));
      paramBaseViewHolder.zOS = ((ImageView)paramBaseViewHolder.AvQ.findViewById(2131305185));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.AvQ.findViewById(2131298756));
      View localView = paramBaseViewHolder.AvQ;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      q.b(paramBaseViewHolder.Avf, this.mActivity);
      AppMethodBeat.o(100066);
      return;
      paramBaseViewHolder.AvQ = paramBaseViewHolder.tPw.findViewById(2131298751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */