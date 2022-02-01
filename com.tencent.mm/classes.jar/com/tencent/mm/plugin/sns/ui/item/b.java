package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100067);
    paramBaseViewHolder.RKJ.setPosition(paramInt1);
    Object localObject2 = parambo.Rdg;
    paramInt2 = paramTimeLineObject.ContentObj.Zpr.size();
    dmz localdmz;
    if (paramInt2 > 0)
    {
      localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      switch (paramTimeLineObject.ContentObj.Zpq)
      {
      }
    }
    for (;;)
    {
      parambn.hpB().c(paramBaseViewHolder.RKJ, parambn.QBf.RQl, parambn.QBf.RPU);
      a(parambo, 1);
      AppMethodBeat.o(100067);
      return;
      paramBaseViewHolder.RKJ.setOnClickListener(parambn.QBf.Rea);
      Object localObject1 = new bf();
      ((bf)localObject1).hHB = ((String)localObject2);
      ((bf)localObject1).index = 0;
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramBaseViewHolder.RKJ);
      ((bf)localObject1).RrK = ((List)localObject2);
      ((bf)localObject1).Roa = this.Roa;
      ((bf)localObject1).position = paramInt1;
      paramBaseViewHolder.RKJ.setTag(localObject1);
      paramBaseViewHolder.RKJ.setVisibility(0);
      localObject1 = al.hgy();
      localObject2 = paramBaseViewHolder.RKJ;
      paramInt1 = this.mActivity.hashCode();
      br localbr = br.jbh();
      localbr.time = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(localdmz, (View)localObject2, paramInt1, localbr);
      paramBaseViewHolder.DOt.setVisibility(8);
      paramBaseViewHolder.titleTv.setText(this.mActivity.getString(b.j.sns_photo_collapse_title, new Object[] { Integer.valueOf(paramInt2) }));
      paramBaseViewHolder.titleTv.setVisibility(0);
      continue;
      paramBaseViewHolder.RKJ.setTag(new s(paramTimeLineObject, (String)localObject2));
      paramBaseViewHolder.RKJ.setOnClickListener(parambn.QBf.RQu);
      paramBaseViewHolder.DOt.setImageResource(b.i.sns_collapse_video_play);
      paramBaseViewHolder.DOt.setVisibility(0);
      paramBaseViewHolder.titleTv.setVisibility(8);
      localObject1 = al.hgy();
      localObject2 = paramBaseViewHolder.RKJ;
      paramInt1 = this.mActivity.hashCode();
      localbr = br.jbh();
      localbr.time = paramTimeLineObject.CreateTime;
      ((g)localObject1).b(localdmz, (View)localObject2, paramInt1, localbr);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100066);
    int i = al.hgP();
    if (paramBaseViewHolder.RKG != null) {
      if (!paramBaseViewHolder.RLs)
      {
        paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_media_collapse_item);
        paramBaseViewHolder.RLt = paramBaseViewHolder.RKG.inflate();
      }
    }
    for (paramBaseViewHolder.RLs = true;; paramBaseViewHolder.RLs = true)
    {
      paramBaseViewHolder.RKJ = ((TagImageView)paramBaseViewHolder.RLt.findViewById(b.f.content_preview));
      paramBaseViewHolder.DOt = ((ImageView)paramBaseViewHolder.RLt.findViewById(b.f.state));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.RLt.findViewById(b.f.content_hint));
      View localView = paramBaseViewHolder.RLt;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localView.setLayoutParams(localLayoutParams);
      t.c(paramBaseViewHolder.RKJ, this.mActivity);
      AppMethodBeat.o(100066);
      return;
      paramBaseViewHolder.RLt = paramBaseViewHolder.convertView.findViewById(b.f.content_collapse_rl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.b
 * JD-Core Version:    0.7.0.1
 */