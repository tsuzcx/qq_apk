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
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends BaseTimeLineItem
{
  private int yJF = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100086);
    Object localObject = parambf.yzm;
    if (paramBaseViewHolder.zek != null)
    {
      if ((!parambf.yVi) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.FKi <= 0)) {
        break label247;
      }
      paramBaseViewHolder.zek.setBackgroundResource(2131232446);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.zdG.Pr(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      aw localaw = new aw();
      localaw.dgl = ((String)localObject);
      localaw.index = 0;
      localaw.yMc = localArrayList;
      localaw.yIK = this.yIK;
      if (localTagImageView != null) {
        localTagImageView.setTag(localaw);
      }
      localObject = parambf.yVJ;
      paramBaseViewHolder.yvD = ((bua)localObject);
      if (localObject == null) {
        break label465;
      }
      if (!u.axw().equals(paramTimeLineObject.ncR)) {
        break;
      }
      paramBaseViewHolder.zdG.setVisibility(0);
      parambe = parambe.yJt;
      paramBaseViewHolder = paramBaseViewHolder.zdG;
      parambf = parambf.yzm;
      i = this.mActivity.hashCode();
      bool = this.yIK;
      localObject = com.tencent.mm.storage.bf.fbk();
      ((com.tencent.mm.storage.bf)localObject).gIh = paramTimeLineObject.CreateTime;
      parambe.a(paramBaseViewHolder, paramTimeLineObject, parambf, i, paramInt2, paramInt1, bool, (com.tencent.mm.storage.bf)localObject, true);
      AppMethodBeat.o(100086);
      return;
      label247:
      paramBaseViewHolder.zek.setBackgroundResource(2131232445);
    }
    if (parambf.yVl)
    {
      paramBaseViewHolder.zdG.setVisibility(0);
      parambe = parambe.yJt;
      paramBaseViewHolder = paramBaseViewHolder.zdG;
      parambf = parambf.yzm;
      i = this.mActivity.hashCode();
      bool = this.yIK;
      localObject = com.tencent.mm.storage.bf.fbk();
      ((com.tencent.mm.storage.bf)localObject).gIh = paramTimeLineObject.CreateTime;
      parambe.a(paramBaseViewHolder, paramTimeLineObject, parambf, i, paramInt2, paramInt1, bool, (com.tencent.mm.storage.bf)localObject, false);
      AppMethodBeat.o(100086);
      return;
    }
    if (((bua)localObject).dBA == 0)
    {
      paramBaseViewHolder.zdG.setVisibility(0);
      parambe = parambe.yJt;
      paramBaseViewHolder = paramBaseViewHolder.zdG;
      parambf = parambf.yzm;
      i = this.mActivity.hashCode();
      bool = this.yIK;
      localObject = com.tencent.mm.storage.bf.fbk();
      ((com.tencent.mm.storage.bf)localObject).gIh = paramTimeLineObject.CreateTime;
      parambe.a(paramBaseViewHolder, paramTimeLineObject, parambf, i, paramInt2, paramInt1, bool, (com.tencent.mm.storage.bf)localObject, true);
      AppMethodBeat.o(100086);
      return;
    }
    ac.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((bua)localObject).dBA);
    AppMethodBeat.o(100086);
    return;
    label465:
    ac.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambf.yzm);
    AppMethodBeat.o(100086);
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100085);
    paramBaseViewHolder.zdy.setImageResource(2131232932);
    paramBaseViewHolder.zdg.setTextColor(paramBaseViewHolder.zdg.getContext().getResources().getColor(2131100800));
    if (paramBaseViewHolder.zdm != null)
    {
      paramBaseViewHolder.zdm.setLayoutResource(2131495550);
      if (!paramBaseViewHolder.zdn) {
        paramBaseViewHolder.zdG = ((PhotosContent)paramBaseViewHolder.zdm.inflate());
      }
    }
    for (paramBaseViewHolder.zdn = true;; paramBaseViewHolder.zdn = true)
    {
      ac.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.oeH);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.zdG.findViewById(ay.yOB[0]);
      paramBaseViewHolder.zdG.a(localTagImageView);
      localTagImageView.setOnClickListener(this.xZJ.xZe.yAf);
      AppMethodBeat.o(100085);
      return;
      paramBaseViewHolder.zdG = ((PhotosContent)paramBaseViewHolder.sSS.findViewById(2131300686));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */