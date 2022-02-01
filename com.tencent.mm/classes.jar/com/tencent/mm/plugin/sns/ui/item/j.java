package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.b.a;

public final class j
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(221262);
    if (paramBaseViewHolder.LkR != null)
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_media_sub_item2);
      paramBaseViewHolder.LlD = ((ViewStub)paramBaseViewHolder.convertView.findViewById(i.f.images_keeper_li));
      if ((!paramBaseViewHolder.LlE) && (paramBaseViewHolder.LlD != null)) {
        paramBaseViewHolder.LlF = paramBaseViewHolder.LlD.inflate();
      }
    }
    for (paramBaseViewHolder.LlE = true;; paramBaseViewHolder.LlE = true)
    {
      paramBaseViewHolder.KWu = paramBaseViewHolder.LlF;
      paramBaseViewHolder.KWu.findViewById(i.f.state).setOnTouchListener(this.Kee.KDW);
      paramBaseViewHolder.LkU = ((TagImageView)paramBaseViewHolder.KWu.findViewById(i.f.image_left));
      paramBaseViewHolder.yVe = ((ImageView)paramBaseViewHolder.KWu.findViewById(i.f.state));
      paramBaseViewHolder.LkV = ((TextView)paramBaseViewHolder.KWu.findViewById(i.f.righttext));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.KWu.findViewById(i.f.titletext));
      paramBaseViewHolder.titleTv.setMaxLines(2);
      t.b(paramBaseViewHolder.LkU, this.mActivity);
      AppMethodBeat.o(221262);
      return;
      paramBaseViewHolder.LlF = paramBaseViewHolder.convertView.findViewById(i.f.media_content_rl);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(221291);
    if (paramTimeLineObject.ContentObj.Sqw != null)
    {
      paramBaseViewHolder.LkU.setPosition(paramInt1);
      paramBaseViewHolder.KWu.setVisibility(0);
      cvt localcvt = new cvt();
      localcvt.Url = paramTimeLineObject.ContentObj.Sqw.lpK;
      localcvt.TDF = paramTimeLineObject.ContentObj.Sqw.lpK;
      localcvt.rWu = 2;
      localcvt.TDG = 1;
      localcvt.TDH = new cvv();
      localcvt.TlV = 1;
      localcvt.TDH.TEu = paramTimeLineObject.ContentObj.Sqw.width;
      localcvt.TDH.TEv = paramTimeLineObject.ContentObj.Sqw.height;
      localcvt.Id = paramTimeLineObject.Id;
      g localg = aj.fOF();
      TagImageView localTagImageView = paramBaseViewHolder.LkU;
      paramInt1 = this.mActivity.hashCode();
      bp localbp = bp.hzh();
      localbp.time = paramTimeLineObject.CreateTime;
      localg.b(localcvt, localTagImageView, paramInt1, localbp);
      paramBaseViewHolder.yVe.setPressed(false);
      paramBaseViewHolder.yVe.setImageDrawable(au.o(paramBaseViewHolder.yVe.getContext(), i.i.icons_outlined_video_call, -1));
      paramBaseViewHolder.KWu.setTag(new ak(paramTimeLineObject, paramBaseViewHolder.LkU, parambn.KDB));
      paramBaseViewHolder.LkV.setVisibility(8);
      parambm.fXi().c(paramBaseViewHolder.KWu, parambm.Kdz.Lpk, parambm.Kdz.LoP);
      paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfe);
      parambn = paramTimeLineObject.ContentObj.Sqw.title;
      if (!Util.isNullOrNil(parambn))
      {
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambn = new SpannableString(parambn);
        paramBaseViewHolder.titleTv.setText(parambn, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(221291);
        return;
      }
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(221291);
      return;
    }
    paramBaseViewHolder.KWu.setVisibility(8);
    AppMethodBeat.o(221291);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j
 * JD-Core Version:    0.7.0.1
 */