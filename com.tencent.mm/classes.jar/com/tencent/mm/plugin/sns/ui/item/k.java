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
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class k
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100088);
    String str = parambo.Rdg;
    if (!paramTimeLineObject.ContentObj.Zpr.isEmpty())
    {
      paramBaseViewHolder.RKJ.setPosition(paramInt1);
      paramBaseViewHolder.Rwr.setVisibility(0);
      dmz localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      g localg = al.hgy();
      TagImageView localTagImageView = paramBaseViewHolder.RKJ;
      paramInt1 = b.i.app_attach_file_icon_music;
      paramInt2 = this.mActivity.hashCode();
      br localbr = br.jbh();
      localbr.time = paramTimeLineObject.CreateTime;
      localg.a(localdmz, localTagImageView, paramInt1, paramInt2, localbr);
      paramBaseViewHolder.DOt.setPressed(false);
      if (bn.aUY(paramTimeLineObject.Id))
      {
        paramBaseViewHolder.DOt.setImageResource(b.e.music_pauseicon);
        paramBaseViewHolder.RKJ.setTag(new s(paramTimeLineObject, str));
        paramBaseViewHolder.RKJ.setOnClickListener(parambn.RoS.RFE);
        paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, str));
        parambn.hpB().c(paramBaseViewHolder.Rwr, parambn.QBf.RQj, parambn.QBf.RPU);
        paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.Rwb);
        paramTimeLineObject = localdmz.IGG;
        if (Util.isNullOrNil(paramTimeLineObject)) {
          break label384;
        }
        paramBaseViewHolder.RKK.setVisibility(0);
        paramBaseViewHolder.RKK.setText(paramTimeLineObject);
        label266:
        paramTimeLineObject = localdmz.hAP;
        if (Util.isNullOrNil(paramTimeLineObject)) {
          break label395;
        }
        paramBaseViewHolder.titleTv.setVisibility(0);
        paramTimeLineObject = new SpannableString(paramTimeLineObject);
        paramBaseViewHolder.titleTv.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
        label312:
        paramBaseViewHolder.desc = (this.mActivity.getString(b.j.sns_link) + localdmz.hAP + "," + localdmz.IGG);
      }
    }
    for (;;)
    {
      a(parambo, 2);
      AppMethodBeat.o(100088);
      return;
      paramBaseViewHolder.DOt.setImageResource(b.e.music_playicon);
      break;
      label384:
      paramBaseViewHolder.RKK.setVisibility(4);
      break label266;
      label395:
      paramBaseViewHolder.titleTv.setVisibility(8);
      break label312;
      paramBaseViewHolder.Rwr.setVisibility(8);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100087);
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
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(b.c.sns_link_color));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      t.c(paramBaseViewHolder.RKJ, this.mActivity);
      AppMethodBeat.o(100087);
      return;
      paramBaseViewHolder.RLt = paramBaseViewHolder.convertView.findViewById(b.f.media_content_rl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */