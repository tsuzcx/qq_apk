package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100067);
    paramBaseViewHolder.EWG.setPosition(paramInt1);
    Object localObject2 = parambl.Eql;
    paramInt2 = paramTimeLineObject.ContentObj.LoV.size();
    if (paramInt2 > 0)
    {
      parambl = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
      switch (paramTimeLineObject.ContentObj.LoU)
      {
      }
    }
    for (;;)
    {
      parambk.fiV().c(paramBaseViewHolder.EWG, parambk.DQs.FaI, parambk.DQs.Far);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.EWG.setOnClickListener(parambk.DQs.Erh);
      Object localObject1 = new bc();
      ((bc)localObject1).dJX = ((String)localObject2);
      ((bc)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.EWG);
      ((bc)localObject1).EDW = ((List)localObject2);
      ((bc)localObject1).EAv = this.EAv;
      ((bc)localObject1).position = paramInt1;
      paramBaseViewHolder.EWG.setTag(localObject1);
      paramBaseViewHolder.EWG.setVisibility(0);
      localObject1 = aj.faL();
      localObject2 = paramBaseViewHolder.EWG;
      paramInt1 = this.mActivity.hashCode();
      bp localbp = bp.gCU();
      localbp.hXs = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(parambl, (View)localObject2, paramInt1, localbp);
      paramBaseViewHolder.uzC.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(2131766164, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.EWG.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.EWG.setOnClickListener(parambk.DQs.FaR);
      paramBaseViewHolder.uzC.setImageResource(2131691511);
      paramBaseViewHolder.uzC.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = aj.faL();
      localObject2 = paramBaseViewHolder.EWG;
      paramInt1 = this.mActivity.hashCode();
      localbp = bp.gCU();
      localbp.hXs = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(parambl, (View)localObject2, paramInt1, localbp);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100066);
    int i = aj.fbb();
    if (paramBaseViewHolder.EWD != null) {
      if (!paramBaseViewHolder.EXq)
      {
        paramBaseViewHolder.EWD.setLayoutResource(2131496456);
        paramBaseViewHolder.EXr = paramBaseViewHolder.EWD.inflate();
      }
    }
    for (paramBaseViewHolder.EXq = true;; paramBaseViewHolder.EXq = true)
    {
      paramBaseViewHolder.EWG = ((TagImageView)paramBaseViewHolder.EXr.findViewById(2131299213));
      paramBaseViewHolder.uzC = ((ImageView)paramBaseViewHolder.EXr.findViewById(2131308376));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.EXr.findViewById(2131299199));
      View localView = paramBaseViewHolder.EXr;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      r.b(paramBaseViewHolder.EWG, this.mActivity);
      AppMethodBeat.o(100066);
      return;
      paramBaseViewHolder.EXr = paramBaseViewHolder.convertView.findViewById(2131299194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */