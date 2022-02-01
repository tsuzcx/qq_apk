package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends BaseTimeLineItem
{
  private int KPj = 103;
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(199267);
    paramBaseViewHolder.Lld.setImageResource(i.e.lucky_friendactivity_comment_icon);
    paramBaseViewHolder.LkL.setTextColor(paramBaseViewHolder.LkL.getContext().getResources().getColor(i.c.red_text_color));
    if (paramBaseViewHolder.LkR != null)
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_hb_reward_item);
      if (!paramBaseViewHolder.LkS) {
        paramBaseViewHolder.Lll = ((PhotosContent)paramBaseViewHolder.LkR.inflate());
      }
    }
    for (paramBaseViewHolder.LkS = true;; paramBaseViewHolder.LkS = true)
    {
      Log.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.viewType);
      paramViewStub = (TagImageView)paramBaseViewHolder.Lll.findViewById(bg.KUt[0]);
      paramBaseViewHolder.Lll.a(paramViewStub);
      paramViewStub.setOnClickListener(this.Kee.Kdz.KEA);
      AppMethodBeat.o(199267);
      return;
      paramBaseViewHolder.Lll = ((PhotosContent)paramBaseViewHolder.convertView.findViewById(i.f.hb_content_rl));
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100086);
    Object localObject = parambn.KDB;
    if (paramBaseViewHolder.LlP != null)
    {
      if ((!parambn.LbC) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.Umy <= 0)) {
        break label248;
      }
      paramBaseViewHolder.LlP.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_myself);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.Lll.agW(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      be localbe = new be();
      localbe.fCM = ((String)localObject);
      localbe.index = 0;
      localbe.KRL = localArrayList;
      localbe.KOn = this.KOn;
      if (localTagImageView != null) {
        localTagImageView.setTag(localbe);
      }
      localObject = parambn.Lcd;
      paramBaseViewHolder.postInfo = ((cvu)localObject);
      if (localObject == null) {
        break label468;
      }
      if (!z.bcZ().equals(paramTimeLineObject.UserName)) {
        break;
      }
      paramBaseViewHolder.Lll.setVisibility(0);
      parambm = parambm.KOW;
      paramBaseViewHolder = paramBaseViewHolder.Lll;
      parambn = parambn.KDB;
      i = this.mActivity.hashCode();
      bool = this.KOn;
      localObject = bp.hzh();
      ((bp)localObject).time = paramTimeLineObject.CreateTime;
      parambm.a(paramBaseViewHolder, paramTimeLineObject, parambn, i, paramInt2, paramInt1, bool, (bp)localObject, true);
      AppMethodBeat.o(100086);
      return;
      label248:
      paramBaseViewHolder.LlP.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
    }
    if (parambn.LbF)
    {
      paramBaseViewHolder.Lll.setVisibility(0);
      parambm = parambm.KOW;
      paramBaseViewHolder = paramBaseViewHolder.Lll;
      parambn = parambn.KDB;
      i = this.mActivity.hashCode();
      bool = this.KOn;
      localObject = bp.hzh();
      ((bp)localObject).time = paramTimeLineObject.CreateTime;
      parambm.a(paramBaseViewHolder, paramTimeLineObject, parambn, i, paramInt2, paramInt1, bool, (bp)localObject, false);
      AppMethodBeat.o(100086);
      return;
    }
    if (((cvu)localObject).gbp == 0)
    {
      paramBaseViewHolder.Lll.setVisibility(0);
      parambm = parambm.KOW;
      paramBaseViewHolder = paramBaseViewHolder.Lll;
      parambn = parambn.KDB;
      i = this.mActivity.hashCode();
      bool = this.KOn;
      localObject = bp.hzh();
      ((bp)localObject).time = paramTimeLineObject.CreateTime;
      parambm.a(paramBaseViewHolder, paramTimeLineObject, parambn, i, paramInt2, paramInt1, bool, (bp)localObject, true);
      AppMethodBeat.o(100086);
      return;
    }
    Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((cvu)localObject).gbp);
    AppMethodBeat.o(100086);
    return;
    label468:
    Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambn.KDB);
    AppMethodBeat.o(100086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */