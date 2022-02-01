package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.b.a;

public final class g
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(198549);
    if (paramTimeLineObject.HAT.GaW != null)
    {
      paramBaseViewHolder.Avf.setPosition(paramInt1);
      paramBaseViewHolder.AhO.setVisibility(0);
      byn localbyn = new byn();
      localbyn.Url = paramTimeLineObject.HAT.GaW.hDm;
      localbyn.GSI = paramTimeLineObject.HAT.GaW.hDm;
      localbyn.nEf = 2;
      localbyn.GSJ = 1;
      localbyn.GSL = new byp();
      localbyn.GEe = 1;
      localbyn.GSL.GTz = paramTimeLineObject.HAT.GaW.width;
      localbyn.GSL.GTA = paramTimeLineObject.HAT.GaW.height;
      localbyn.Id = paramTimeLineObject.Id;
      f localf = com.tencent.mm.plugin.sns.model.ag.dUb();
      TagImageView localTagImageView = paramBaseViewHolder.Avf;
      paramInt1 = this.mActivity.hashCode();
      bj localbj = bj.frn();
      localbj.hbR = paramTimeLineObject.CreateTime;
      localf.b(localbyn, localTagImageView, paramInt1, localbj);
      paramBaseViewHolder.zOS.setPressed(false);
      paramBaseViewHolder.zOS.setImageDrawable(ao.k(paramBaseViewHolder.zOS.getContext(), 2131690672, -1));
      paramBaseViewHolder.AhO.setTag(new com.tencent.mm.plugin.sns.ui.ag(paramTimeLineObject, paramBaseViewHolder.Avf, parambi.zQD));
      paramBaseViewHolder.Avg.setVisibility(8);
      parambh.ecN().c(paramBaseViewHolder.AhO, parambh.zpd.AyL, parambh.zpd.Ayq);
      paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.ApX);
      parambi = paramTimeLineObject.HAT.GaW.title;
      if (!bt.isNullOrNil(parambi))
      {
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambi = new SpannableString(parambi);
        paramBaseViewHolder.titleTv.setText(parambi, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(198549);
        return;
      }
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(198549);
      return;
    }
    paramBaseViewHolder.AhO.setVisibility(8);
    AppMethodBeat.o(198549);
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(198548);
    if (paramBaseViewHolder.Avc != null)
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495568);
      paramBaseViewHolder.AvO = ((ViewStub)paramBaseViewHolder.tPw.findViewById(2131300969));
      if ((!paramBaseViewHolder.AvP) && (paramBaseViewHolder.AvO != null)) {
        paramBaseViewHolder.AvQ = paramBaseViewHolder.AvO.inflate();
      }
    }
    for (paramBaseViewHolder.AvP = true;; paramBaseViewHolder.AvP = true)
    {
      paramBaseViewHolder.AhO = paramBaseViewHolder.AvQ;
      paramBaseViewHolder.AhO.findViewById(2131305185).setOnTouchListener(this.zpI.zQU);
      paramBaseViewHolder.Avf = ((TagImageView)paramBaseViewHolder.AhO.findViewById(2131300948));
      paramBaseViewHolder.zOS = ((ImageView)paramBaseViewHolder.AhO.findViewById(2131305185));
      paramBaseViewHolder.Avg = ((TextView)paramBaseViewHolder.AhO.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.AhO.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setMaxLines(2);
      q.b(paramBaseViewHolder.Avf, this.mActivity);
      AppMethodBeat.o(198548);
      return;
      paramBaseViewHolder.AvQ = paramBaseViewHolder.tPw.findViewById(2131302207);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */