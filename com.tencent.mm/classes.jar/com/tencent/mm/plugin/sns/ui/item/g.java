package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends BaseTimeLineItem
{
  private int RoV = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100086);
    Object localObject1 = parambo.Rdg;
    Object localObject2;
    int i;
    boolean bool;
    if (paramBaseViewHolder.RLD != null)
    {
      if ((parambo.RBF) && (paramBaseViewHolder.snsobj.SnsRedEnvelops != null) && (paramBaseViewHolder.snsobj.SnsRedEnvelops.abEF > 0)) {
        paramBaseViewHolder.RLD.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_myself);
      }
    }
    else
    {
      localObject2 = paramBaseViewHolder.RKZ.alP(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      bf localbf = new bf();
      localbf.hHB = ((String)localObject1);
      localbf.index = 0;
      localbf.RrK = localArrayList;
      localbf.Roa = this.Roa;
      if (localObject2 != null) {
        ((TagImageView)localObject2).setTag(localbf);
      }
      localObject1 = parambo.RCh;
      paramBaseViewHolder.postInfo = ((dna)localObject1);
      if (localObject1 == null) {
        break label469;
      }
      if (!z.bAM().equals(paramTimeLineObject.UserName)) {
        break label268;
      }
      paramBaseViewHolder.RKZ.setVisibility(0);
      parambn = parambn.RoJ;
      paramBaseViewHolder = paramBaseViewHolder.RKZ;
      localObject1 = parambo.Rdg;
      i = this.mActivity.hashCode();
      bool = this.Roa;
      localObject2 = br.jbh();
      ((br)localObject2).time = paramTimeLineObject.CreateTime;
      parambn.a(paramBaseViewHolder, paramTimeLineObject, (String)localObject1, i, paramInt2, paramInt1, bool, (br)localObject2, true);
    }
    for (;;)
    {
      a(parambo, 1);
      AppMethodBeat.o(100086);
      return;
      paramBaseViewHolder.RLD.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_arror);
      break;
      label268:
      if (parambo.RBI)
      {
        paramBaseViewHolder.RKZ.setVisibility(0);
        parambn = parambn.RoJ;
        paramBaseViewHolder = paramBaseViewHolder.RKZ;
        localObject1 = parambo.Rdg;
        i = this.mActivity.hashCode();
        bool = this.Roa;
        localObject2 = br.jbh();
        ((br)localObject2).time = paramTimeLineObject.CreateTime;
        parambn.a(paramBaseViewHolder, paramTimeLineObject, (String)localObject1, i, paramInt2, paramInt1, bool, (br)localObject2, false);
      }
      else if (((dna)localObject1).ihz == 0)
      {
        paramBaseViewHolder.RKZ.setVisibility(0);
        parambn = parambn.RoJ;
        paramBaseViewHolder = paramBaseViewHolder.RKZ;
        localObject1 = parambo.Rdg;
        i = this.mActivity.hashCode();
        bool = this.Roa;
        localObject2 = br.jbh();
        ((br)localObject2).time = paramTimeLineObject.CreateTime;
        parambn.a(paramBaseViewHolder, paramTimeLineObject, (String)localObject1, i, paramInt2, paramInt1, bool, (br)localObject2, true);
      }
      else
      {
        Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((dna)localObject1).ihz);
        continue;
        label469:
        Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambo.Rdg);
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100085);
    paramBaseViewHolder.RKS.setImageResource(b.e.lucky_friendactivity_comment_icon);
    paramBaseViewHolder.RKA.setTextColor(paramBaseViewHolder.RKA.getContext().getResources().getColor(b.c.red_text_color));
    if (paramBaseViewHolder.RKG != null)
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_hb_reward_item);
      if (!paramBaseViewHolder.RKH) {
        paramBaseViewHolder.RKZ = ((PhotosContent)paramBaseViewHolder.RKG.inflate());
      }
    }
    for (paramBaseViewHolder.RKH = true;; paramBaseViewHolder.RKH = true)
    {
      Log.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.viewType);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.RKZ.findViewById(bh.Rur[0]);
      paramBaseViewHolder.RKZ.a(localTagImageView);
      localTagImageView.setOnClickListener(this.QBJ.QBf.Rea);
      AppMethodBeat.o(100085);
      return;
      paramBaseViewHolder.RKZ = ((PhotosContent)paramBaseViewHolder.convertView.findViewById(b.f.hb_content_rl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */