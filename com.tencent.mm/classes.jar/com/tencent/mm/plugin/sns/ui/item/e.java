package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bc;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends BaseTimeLineItem
{
  private int xwP = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100086);
    Object localObject = parambf.xmu;
    if (paramBaseViewHolder.xRu != null)
    {
      if ((!parambf.xIs) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.Enj <= 0)) {
        break label247;
      }
      paramBaseViewHolder.xRu.setBackgroundResource(2131232446);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.xQQ.No(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      aw localaw = new aw();
      localaw.diQ = ((String)localObject);
      localaw.index = 0;
      localaw.xzo = localArrayList;
      localaw.xvU = this.xvU;
      if (localTagImageView != null) {
        localTagImageView.setTag(localaw);
      }
      localObject = parambf.xIT;
      paramBaseViewHolder.xiM = ((bpj)localObject);
      if (localObject == null) {
        break label465;
      }
      if (!u.aqG().equals(paramTimeLineObject.mAQ)) {
        break;
      }
      paramBaseViewHolder.xQQ.setVisibility(0);
      parambe = parambe.xwD;
      paramBaseViewHolder = paramBaseViewHolder.xQQ;
      parambf = parambf.xmu;
      i = this.mActivity.hashCode();
      bool = this.xvU;
      localObject = bc.eLG();
      ((bc)localObject).tGD = paramTimeLineObject.CreateTime;
      parambe.a(paramBaseViewHolder, paramTimeLineObject, parambf, i, paramInt2, paramInt1, bool, (bc)localObject, true);
      AppMethodBeat.o(100086);
      return;
      label247:
      paramBaseViewHolder.xRu.setBackgroundResource(2131232445);
    }
    if (parambf.xIv)
    {
      paramBaseViewHolder.xQQ.setVisibility(0);
      parambe = parambe.xwD;
      paramBaseViewHolder = paramBaseViewHolder.xQQ;
      parambf = parambf.xmu;
      i = this.mActivity.hashCode();
      bool = this.xvU;
      localObject = bc.eLG();
      ((bc)localObject).tGD = paramTimeLineObject.CreateTime;
      parambe.a(paramBaseViewHolder, paramTimeLineObject, parambf, i, paramInt2, paramInt1, bool, (bc)localObject, false);
      AppMethodBeat.o(100086);
      return;
    }
    if (((bpj)localObject).dDO == 0)
    {
      paramBaseViewHolder.xQQ.setVisibility(0);
      parambe = parambe.xwD;
      paramBaseViewHolder = paramBaseViewHolder.xQQ;
      parambf = parambf.xmu;
      i = this.mActivity.hashCode();
      bool = this.xvU;
      localObject = bc.eLG();
      ((bc)localObject).tGD = paramTimeLineObject.CreateTime;
      parambe.a(paramBaseViewHolder, paramTimeLineObject, parambf, i, paramInt2, paramInt1, bool, (bc)localObject, true);
      AppMethodBeat.o(100086);
      return;
    }
    ad.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((bpj)localObject).dDO);
    AppMethodBeat.o(100086);
    return;
    label465:
    ad.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambf.xmu);
    AppMethodBeat.o(100086);
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100085);
    paramBaseViewHolder.xQI.setImageResource(2131232932);
    paramBaseViewHolder.xQq.setTextColor(paramBaseViewHolder.xQq.getContext().getResources().getColor(2131100800));
    if (paramBaseViewHolder.xQw != null)
    {
      paramBaseViewHolder.xQw.setLayoutResource(2131495550);
      if (!paramBaseViewHolder.xQx) {
        paramBaseViewHolder.xQQ = ((PhotosContent)paramBaseViewHolder.xQw.inflate());
      }
    }
    for (paramBaseViewHolder.xQx = true;; paramBaseViewHolder.xQx = true)
    {
      ad.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.nBH);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.xQQ.findViewById(ay.xBN[0]);
      paramBaseViewHolder.xQQ.a(localTagImageView);
      localTagImageView.setOnClickListener(this.wNd.wMy.xno);
      AppMethodBeat.o(100085);
      return;
      paramBaseViewHolder.xQQ = ((PhotosContent)paramBaseViewHolder.rLd.findViewById(2131300686));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */