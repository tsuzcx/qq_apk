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
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100067);
    paramBaseViewHolder.xQz.setPosition(paramInt1);
    Object localObject2 = parambf.xmu;
    paramInt2 = paramTimeLineObject.Etm.DaC.size();
    if (paramInt2 > 0)
    {
      parambf = (bpi)paramTimeLineObject.Etm.DaC.get(0);
      switch (paramTimeLineObject.Etm.DaB)
      {
      }
    }
    for (;;)
    {
      parambe.dCa().c(paramBaseViewHolder.xQz, parambe.wMy.xTK, parambe.wMy.xTt);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.xQz.setOnClickListener(parambe.wMy.xno);
      Object localObject1 = new aw();
      ((aw)localObject1).diQ = ((String)localObject2);
      ((aw)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.xQz);
      ((aw)localObject1).xzo = ((List)localObject2);
      ((aw)localObject1).xvU = this.xvU;
      ((aw)localObject1).position = paramInt1;
      paramBaseViewHolder.xQz.setTag(localObject1);
      paramBaseViewHolder.xQz.setVisibility(0);
      localObject1 = af.dtr();
      localObject2 = paramBaseViewHolder.xQz;
      paramInt1 = this.mActivity.hashCode();
      bc localbc = bc.eLG();
      localbc.tGD = paramTimeLineObject.CreateTime;
      ((f)localObject1).b(parambf, (View)localObject2, paramInt1, localbc);
      paramBaseViewHolder.xkO.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(2131763937, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.xQz.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.xQz.setOnClickListener(parambe.wMy.xTR);
      paramBaseViewHolder.xkO.setImageResource(2131691189);
      paramBaseViewHolder.xkO.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = af.dtr();
      localObject2 = paramBaseViewHolder.xQz;
      paramInt1 = this.mActivity.hashCode();
      localbc = bc.eLG();
      localbc.tGD = paramTimeLineObject.CreateTime;
      ((f)localObject1).b(parambf, (View)localObject2, paramInt1, localbc);
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100066);
    int i = af.dtE();
    if (paramBaseViewHolder.xQw != null) {
      if (!paramBaseViewHolder.xRj)
      {
        paramBaseViewHolder.xQw.setLayoutResource(2131495564);
        paramBaseViewHolder.xRk = paramBaseViewHolder.xQw.inflate();
      }
    }
    for (paramBaseViewHolder.xRj = true;; paramBaseViewHolder.xRj = true)
    {
      paramBaseViewHolder.xQz = ((TagImageView)paramBaseViewHolder.xRk.findViewById(2131298769));
      paramBaseViewHolder.xkO = ((ImageView)paramBaseViewHolder.xRk.findViewById(2131305185));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.xRk.findViewById(2131298756));
      View localView = paramBaseViewHolder.xRk;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      q.b(paramBaseViewHolder.xQz, this.mActivity);
      AppMethodBeat.o(100066);
      return;
      paramBaseViewHolder.xRk = paramBaseViewHolder.rLd.findViewById(2131298751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */