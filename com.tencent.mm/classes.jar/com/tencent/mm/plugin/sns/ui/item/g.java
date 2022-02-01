package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ag;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.b.a;

public final class g
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(220091);
    if (paramTimeLineObject.HUG.GtD != null)
    {
      paramBaseViewHolder.AMv.setPosition(paramInt1);
      paramBaseViewHolder.Aza.setVisibility(0);
      bzh localbzh = new bzh();
      localbzh.Url = paramTimeLineObject.HUG.GtD.hGe;
      localbzh.Hmj = paramTimeLineObject.HUG.GtD.hGe;
      localbzh.nJA = 2;
      localbzh.Hmk = 1;
      localbzh.Hmm = new bzj();
      localbzh.GXH = 1;
      localbzh.Hmm.Hna = paramTimeLineObject.HUG.GtD.width;
      localbzh.Hmm.Hnb = paramTimeLineObject.HUG.GtD.height;
      localbzh.Id = paramTimeLineObject.Id;
      com.tencent.mm.plugin.sns.model.g localg = ah.dXB();
      TagImageView localTagImageView = paramBaseViewHolder.AMv;
      paramInt1 = this.mActivity.hashCode();
      bk localbk = bk.fvn();
      localbk.heF = paramTimeLineObject.CreateTime;
      localg.b(localbzh, localTagImageView, paramInt1, localbk);
      paramBaseViewHolder.AfZ.setPressed(false);
      paramBaseViewHolder.AfZ.setImageDrawable(ao.k(paramBaseViewHolder.AfZ.getContext(), 2131690672, -1));
      paramBaseViewHolder.Aza.setTag(new ag(paramTimeLineObject, paramBaseViewHolder.AMv, parambi.AhK));
      paramBaseViewHolder.AMw.setVisibility(8);
      parambh.egu().c(paramBaseViewHolder.Aza, parambh.zGs.AQh, parambh.zGs.APL);
      paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHl);
      parambi = paramTimeLineObject.HUG.GtD.title;
      if (!bu.isNullOrNil(parambi))
      {
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambi = new SpannableString(parambi);
        paramBaseViewHolder.titleTv.setText(parambi, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(220091);
        return;
      }
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(220091);
      return;
    }
    paramBaseViewHolder.Aza.setVisibility(8);
    AppMethodBeat.o(220091);
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(220090);
    if (paramBaseViewHolder.AMs != null)
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495568);
      paramBaseViewHolder.ANf = ((ViewStub)paramBaseViewHolder.uan.findViewById(2131300969));
      if ((!paramBaseViewHolder.ANg) && (paramBaseViewHolder.ANf != null)) {
        paramBaseViewHolder.ANh = paramBaseViewHolder.ANf.inflate();
      }
    }
    for (paramBaseViewHolder.ANg = true;; paramBaseViewHolder.ANg = true)
    {
      paramBaseViewHolder.Aza = paramBaseViewHolder.ANh;
      paramBaseViewHolder.Aza.findViewById(2131305185).setOnTouchListener(this.zGX.Aib);
      paramBaseViewHolder.AMv = ((TagImageView)paramBaseViewHolder.Aza.findViewById(2131300948));
      paramBaseViewHolder.AfZ = ((ImageView)paramBaseViewHolder.Aza.findViewById(2131305185));
      paramBaseViewHolder.AMw = ((TextView)paramBaseViewHolder.Aza.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.Aza.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setMaxLines(2);
      r.b(paramBaseViewHolder.AMv, this.mActivity);
      AppMethodBeat.o(220090);
      return;
      paramBaseViewHolder.ANh = paramBaseViewHolder.uan.findViewById(2131302207);
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