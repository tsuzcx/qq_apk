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
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseTimeLineItem
{
  private int AaZ = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100086);
    Object localObject = parambi.zQD;
    if (paramBaseViewHolder.Awa != null)
    {
      if ((!parambi.AmR) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.HuQ <= 0)) {
        break label247;
      }
      paramBaseViewHolder.Awa.setBackgroundResource(2131232446);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.Avw.Ra(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      az localaz = new az();
      localaz.drH = ((String)localObject);
      localaz.index = 0;
      localaz.Ady = localArrayList;
      localaz.Aae = this.Aae;
      if (localTagImageView != null) {
        localTagImageView.setTag(localaz);
      }
      localObject = parambi.Ant;
      paramBaseViewHolder.zMQ = ((byo)localObject);
      if (localObject == null) {
        break label465;
      }
      if (!u.aAm().equals(paramTimeLineObject.nDo)) {
        break;
      }
      paramBaseViewHolder.Avw.setVisibility(0);
      parambh = parambh.AaN;
      paramBaseViewHolder = paramBaseViewHolder.Avw;
      parambi = parambi.zQD;
      i = this.mActivity.hashCode();
      bool = this.Aae;
      localObject = bj.frn();
      ((bj)localObject).hbR = paramTimeLineObject.CreateTime;
      parambh.a(paramBaseViewHolder, paramTimeLineObject, parambi, i, paramInt2, paramInt1, bool, (bj)localObject, true);
      AppMethodBeat.o(100086);
      return;
      label247:
      paramBaseViewHolder.Awa.setBackgroundResource(2131232445);
    }
    if (parambi.AmU)
    {
      paramBaseViewHolder.Avw.setVisibility(0);
      parambh = parambh.AaN;
      paramBaseViewHolder = paramBaseViewHolder.Avw;
      parambi = parambi.zQD;
      i = this.mActivity.hashCode();
      bool = this.Aae;
      localObject = bj.frn();
      ((bj)localObject).hbR = paramTimeLineObject.CreateTime;
      parambh.a(paramBaseViewHolder, paramTimeLineObject, parambi, i, paramInt2, paramInt1, bool, (bj)localObject, false);
      AppMethodBeat.o(100086);
      return;
    }
    if (((byo)localObject).dNN == 0)
    {
      paramBaseViewHolder.Avw.setVisibility(0);
      parambh = parambh.AaN;
      paramBaseViewHolder = paramBaseViewHolder.Avw;
      parambi = parambi.zQD;
      i = this.mActivity.hashCode();
      bool = this.Aae;
      localObject = bj.frn();
      ((bj)localObject).hbR = paramTimeLineObject.CreateTime;
      parambh.a(paramBaseViewHolder, paramTimeLineObject, parambi, i, paramInt2, paramInt1, bool, (bj)localObject, true);
      AppMethodBeat.o(100086);
      return;
    }
    ad.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((byo)localObject).dNN);
    AppMethodBeat.o(100086);
    return;
    label465:
    ad.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambi.zQD);
    AppMethodBeat.o(100086);
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100085);
    paramBaseViewHolder.Avo.setImageResource(2131232932);
    paramBaseViewHolder.AuW.setTextColor(paramBaseViewHolder.AuW.getContext().getResources().getColor(2131100800));
    if (paramBaseViewHolder.Avc != null)
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495550);
      if (!paramBaseViewHolder.Avd) {
        paramBaseViewHolder.Avw = ((PhotosContent)paramBaseViewHolder.Avc.inflate());
      }
    }
    for (paramBaseViewHolder.Avd = true;; paramBaseViewHolder.Avd = true)
    {
      ad.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.oIb);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.Avw.findViewById(bb.AfX[0]);
      paramBaseViewHolder.Avw.a(localTagImageView);
      localTagImageView.setOnClickListener(this.zpI.zpd.zRv);
      AppMethodBeat.o(100085);
      return;
      paramBaseViewHolder.Avw = ((PhotosContent)paramBaseViewHolder.tPw.findViewById(2131300686));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */