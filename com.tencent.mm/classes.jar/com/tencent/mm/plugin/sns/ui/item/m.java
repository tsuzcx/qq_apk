package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class m
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(251526);
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
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(i.c.sns_link_color));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      t.b(paramBaseViewHolder.LkU, this.mActivity);
      AppMethodBeat.o(251526);
      return;
      paramBaseViewHolder.LlF = paramBaseViewHolder.convertView.findViewById(i.f.media_content_rl);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100088);
    String str = parambn.KDB;
    if (!paramTimeLineObject.ContentObj.Sqr.isEmpty())
    {
      paramBaseViewHolder.LkU.setPosition(paramInt1);
      paramBaseViewHolder.KWu.setVisibility(0);
      parambn = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      g localg = aj.fOF();
      TagImageView localTagImageView = paramBaseViewHolder.LkU;
      paramInt1 = i.i.app_attach_file_icon_music;
      paramInt2 = this.mActivity.hashCode();
      bp localbp = bp.hzh();
      localbp.time = paramTimeLineObject.CreateTime;
      localg.a(parambn, localTagImageView, paramInt1, paramInt2, localbp);
      paramBaseViewHolder.yVe.setPressed(false);
      if (bm.aXq(paramTimeLineObject.Id))
      {
        paramBaseViewHolder.yVe.setImageResource(i.e.music_pauseicon);
        paramBaseViewHolder.LkU.setTag(new s(paramTimeLineObject, str));
        paramBaseViewHolder.LkU.setOnClickListener(parambm.KPg.Lfs);
        paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, str));
        parambm.fXi().c(paramBaseViewHolder.KWu, parambm.Kdz.Lpe, parambm.Kdz.LoP);
        paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.KWe);
        paramTimeLineObject = parambn.CMB;
        if (Util.isNullOrNil(paramTimeLineObject)) {
          break label322;
        }
        paramBaseViewHolder.LkV.setVisibility(0);
        paramBaseViewHolder.LkV.setText(paramTimeLineObject);
      }
      for (;;)
      {
        parambn = parambn.fwr;
        if (Util.isNullOrNil(parambn)) {
          break label333;
        }
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambn = new SpannableString(parambn);
        paramBaseViewHolder.titleTv.setText(parambn, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(100088);
        return;
        paramBaseViewHolder.yVe.setImageResource(i.e.music_playicon);
        break;
        label322:
        paramBaseViewHolder.LkV.setVisibility(4);
      }
      label333:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(100088);
      return;
    }
    paramBaseViewHolder.KWu.setVisibility(8);
    AppMethodBeat.o(100088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.m
 * JD-Core Version:    0.7.0.1
 */