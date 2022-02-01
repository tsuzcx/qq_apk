package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ai;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.b.a;

public final class h
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(203927);
    if (paramTimeLineObject.ContentObj.Lpa != null)
    {
      paramBaseViewHolder.EWG.setPosition(paramInt1);
      paramBaseViewHolder.EIs.setVisibility(0);
      cnb localcnb = new cnb();
      localcnb.Url = paramTimeLineObject.ContentObj.Lpa.iAo;
      localcnb.Msz = paramTimeLineObject.ContentObj.Lpa.iAo;
      localcnb.oUv = 2;
      localcnb.MsA = 1;
      localcnb.MsB = new cnd();
      localcnb.Mcw = 1;
      localcnb.MsB.Mto = paramTimeLineObject.ContentObj.Lpa.width;
      localcnb.MsB.Mtp = paramTimeLineObject.ContentObj.Lpa.height;
      localcnb.Id = paramTimeLineObject.Id;
      g localg = aj.faL();
      TagImageView localTagImageView = paramBaseViewHolder.EWG;
      paramInt1 = this.mActivity.hashCode();
      bp localbp = bp.gCU();
      localbp.hXs = paramTimeLineObject.CreateTime;
      localg.b(localcnb, localTagImageView, paramInt1, localbp);
      paramBaseViewHolder.uzC.setPressed(false);
      paramBaseViewHolder.uzC.setImageDrawable(ar.m(paramBaseViewHolder.uzC.getContext(), 2131690929, -1));
      paramBaseViewHolder.EIs.setTag(new ai(paramTimeLineObject, paramBaseViewHolder.EWG, parambl.Eql));
      paramBaseViewHolder.EWH.setVisibility(8);
      parambk.fiV().c(paramBaseViewHolder.EIs, parambk.DQs.FaM, parambk.DQs.Far);
      paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERc);
      parambl = paramTimeLineObject.ContentObj.Lpa.title;
      if (!Util.isNullOrNil(parambl))
      {
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambl = new SpannableString(parambl);
        paramBaseViewHolder.titleTv.setText(parambl, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(203927);
        return;
      }
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(203927);
      return;
    }
    paramBaseViewHolder.EIs.setVisibility(8);
    AppMethodBeat.o(203927);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203926);
    if (paramBaseViewHolder.EWD != null)
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496461);
      paramBaseViewHolder.EXp = ((ViewStub)paramBaseViewHolder.convertView.findViewById(2131302605));
      if ((!paramBaseViewHolder.EXq) && (paramBaseViewHolder.EXp != null)) {
        paramBaseViewHolder.EXr = paramBaseViewHolder.EXp.inflate();
      }
    }
    for (paramBaseViewHolder.EXq = true;; paramBaseViewHolder.EXq = true)
    {
      paramBaseViewHolder.EIs = paramBaseViewHolder.EXr;
      paramBaseViewHolder.EIs.findViewById(2131308376).setOnTouchListener(this.DQX.EqE);
      paramBaseViewHolder.EWG = ((TagImageView)paramBaseViewHolder.EIs.findViewById(2131302578));
      paramBaseViewHolder.uzC = ((ImageView)paramBaseViewHolder.EIs.findViewById(2131308376));
      paramBaseViewHolder.EWH = ((TextView)paramBaseViewHolder.EIs.findViewById(2131307116));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.EIs.findViewById(2131309253));
      paramBaseViewHolder.titleTv.setMaxLines(2);
      r.b(paramBaseViewHolder.EWG, this.mActivity);
      AppMethodBeat.o(203926);
      return;
      paramBaseViewHolder.EXr = paramBaseViewHolder.convertView.findViewById(2131304553);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */