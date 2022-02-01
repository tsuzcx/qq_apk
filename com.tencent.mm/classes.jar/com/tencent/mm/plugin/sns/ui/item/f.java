package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
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
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bk;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseTimeLineItem
{
  private int Asm = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100086);
    Object localObject = parambi.AhK;
    if (paramBaseViewHolder.ANr != null)
    {
      if ((!parambi.AEf) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.HOt <= 0)) {
        break label247;
      }
      paramBaseViewHolder.ANr.setBackgroundResource(2131232446);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.AMM.RH(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      az localaz = new az();
      localaz.dsN = ((String)localObject);
      localaz.index = 0;
      localaz.AuK = localArrayList;
      localaz.Arr = this.Arr;
      if (localTagImageView != null) {
        localTagImageView.setTag(localaz);
      }
      localObject = parambi.AEG;
      paramBaseViewHolder.AdX = ((bzi)localObject);
      if (localObject == null) {
        break label465;
      }
      if (!v.aAC().equals(paramTimeLineObject.nIJ)) {
        break;
      }
      paramBaseViewHolder.AMM.setVisibility(0);
      parambh = parambh.Asa;
      paramBaseViewHolder = paramBaseViewHolder.AMM;
      parambi = parambi.AhK;
      i = this.mActivity.hashCode();
      bool = this.Arr;
      localObject = bk.fvn();
      ((bk)localObject).heF = paramTimeLineObject.CreateTime;
      parambh.a(paramBaseViewHolder, paramTimeLineObject, parambi, i, paramInt2, paramInt1, bool, (bk)localObject, true);
      AppMethodBeat.o(100086);
      return;
      label247:
      paramBaseViewHolder.ANr.setBackgroundResource(2131232445);
    }
    if (parambi.AEi)
    {
      paramBaseViewHolder.AMM.setVisibility(0);
      parambh = parambh.Asa;
      paramBaseViewHolder = paramBaseViewHolder.AMM;
      parambi = parambi.AhK;
      i = this.mActivity.hashCode();
      bool = this.Arr;
      localObject = bk.fvn();
      ((bk)localObject).heF = paramTimeLineObject.CreateTime;
      parambh.a(paramBaseViewHolder, paramTimeLineObject, parambi, i, paramInt2, paramInt1, bool, (bk)localObject, false);
      AppMethodBeat.o(100086);
      return;
    }
    if (((bzi)localObject).dPd == 0)
    {
      paramBaseViewHolder.AMM.setVisibility(0);
      parambh = parambh.Asa;
      paramBaseViewHolder = paramBaseViewHolder.AMM;
      parambi = parambi.AhK;
      i = this.mActivity.hashCode();
      bool = this.Arr;
      localObject = bk.fvn();
      ((bk)localObject).heF = paramTimeLineObject.CreateTime;
      parambh.a(paramBaseViewHolder, paramTimeLineObject, parambi, i, paramInt2, paramInt1, bool, (bk)localObject, true);
      AppMethodBeat.o(100086);
      return;
    }
    ae.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((bzi)localObject).dPd);
    AppMethodBeat.o(100086);
    return;
    label465:
    ae.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambi.AhK);
    AppMethodBeat.o(100086);
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100085);
    paramBaseViewHolder.AME.setImageResource(2131232932);
    paramBaseViewHolder.AMm.setTextColor(paramBaseViewHolder.AMm.getContext().getResources().getColor(2131100800));
    if (paramBaseViewHolder.AMs != null)
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495550);
      if (!paramBaseViewHolder.AMt) {
        paramBaseViewHolder.AMM = ((PhotosContent)paramBaseViewHolder.AMs.inflate());
      }
    }
    for (paramBaseViewHolder.AMt = true;; paramBaseViewHolder.AMt = true)
    {
      ae.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.oOD);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.AMM.findViewById(bb.Axj[0]);
      paramBaseViewHolder.AMM.a(localTagImageView);
      localTagImageView.setOnClickListener(this.zGX.zGs.AiC);
      AppMethodBeat.o(100085);
      return;
      paramBaseViewHolder.AMM = ((PhotosContent)paramBaseViewHolder.uan.findViewById(2131300686));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */