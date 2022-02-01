package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.b.a;

public final class h
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(309041);
    if (paramTimeLineObject.ContentObj.Zpw != null)
    {
      paramBaseViewHolder.RKJ.setPosition(paramInt1);
      paramBaseViewHolder.Rwr.setVisibility(0);
      dmz localdmz = new dmz();
      localdmz.Url = paramTimeLineObject.ContentObj.Zpw.nUM;
      localdmz.aaTl = paramTimeLineObject.ContentObj.Zpw.nUM;
      localdmz.vhJ = 2;
      localdmz.aaTm = 1;
      localdmz.aaTn = new dnb();
      localdmz.aazR = 1;
      localdmz.aaTn.aaUb = paramTimeLineObject.ContentObj.Zpw.width;
      localdmz.aaTn.aaUc = paramTimeLineObject.ContentObj.Zpw.height;
      localdmz.Id = paramTimeLineObject.Id;
      g localg = com.tencent.mm.plugin.sns.model.al.hgy();
      TagImageView localTagImageView = paramBaseViewHolder.RKJ;
      paramInt1 = this.mActivity.hashCode();
      br localbr = br.jbh();
      localbr.time = paramTimeLineObject.CreateTime;
      localg.b(localdmz, localTagImageView, paramInt1, localbr);
      paramBaseViewHolder.DOt.setPressed(false);
      paramBaseViewHolder.DOt.setImageDrawable(bb.m(paramBaseViewHolder.DOt.getContext(), b.i.icons_outlined_video_call, -1));
      paramBaseViewHolder.Rwr.setTag(new com.tencent.mm.plugin.sns.ui.al(paramTimeLineObject, paramBaseViewHolder.RKJ, parambo.Rdg));
      paramBaseViewHolder.RKK.setVisibility(8);
      parambn.hpB().c(paramBaseViewHolder.Rwr, parambn.QBf.RQp, parambn.QBf.RPU);
      paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFq);
      paramTimeLineObject = paramTimeLineObject.ContentObj.Zpw.title;
      if (!Util.isNullOrNil(paramTimeLineObject))
      {
        paramBaseViewHolder.titleTv.setVisibility(0);
        paramTimeLineObject = new SpannableString(paramTimeLineObject);
        paramBaseViewHolder.titleTv.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
      }
    }
    for (;;)
    {
      a(parambo, 1);
      AppMethodBeat.o(309041);
      return;
      paramBaseViewHolder.titleTv.setVisibility(8);
      continue;
      paramBaseViewHolder.Rwr.setVisibility(8);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(309026);
    if (paramBaseViewHolder.RKG != null)
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_media_sub_item2);
      paramBaseViewHolder.RLr = ((ViewStub)paramBaseViewHolder.convertView.findViewById(b.f.images_keeper_li));
      if ((!paramBaseViewHolder.RLs) && (paramBaseViewHolder.RLr != null)) {
        paramBaseViewHolder.RLt = paramBaseViewHolder.RLr.inflate();
      }
    }
    for (paramBaseViewHolder.RLs = true;; paramBaseViewHolder.RLs = true)
    {
      paramBaseViewHolder.Rwr = paramBaseViewHolder.RLt;
      paramBaseViewHolder.Rwr.findViewById(b.f.state).setOnTouchListener(this.QBJ.Rdy);
      paramBaseViewHolder.RKJ = ((TagImageView)paramBaseViewHolder.Rwr.findViewById(b.f.image_left));
      paramBaseViewHolder.DOt = ((ImageView)paramBaseViewHolder.Rwr.findViewById(b.f.state));
      paramBaseViewHolder.RKK = ((TextView)paramBaseViewHolder.Rwr.findViewById(b.f.righttext));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.Rwr.findViewById(b.f.titletext));
      paramBaseViewHolder.titleTv.setMaxLines(2);
      t.c(paramBaseViewHolder.RKJ, this.mActivity);
      AppMethodBeat.o(309026);
      return;
      paramBaseViewHolder.RLt = paramBaseViewHolder.convertView.findViewById(b.f.media_content_rl);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */