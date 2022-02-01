package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends BaseTimeLineItem
{
  private int EBr = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100086);
    Object localObject = parambl.Eql;
    if (paramBaseViewHolder.EXB != null)
    {
      if ((!parambl.ENG) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.Nae <= 0)) {
        break label247;
      }
      paramBaseViewHolder.EXB.setBackgroundResource(2131232828);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.EWX.ZD(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      bc localbc = new bc();
      localbc.dJX = ((String)localObject);
      localbc.index = 0;
      localbc.EDW = localArrayList;
      localbc.EAv = this.EAv;
      if (localTagImageView != null) {
        localTagImageView.setTag(localbc);
      }
      localObject = parambl.EOh;
      paramBaseViewHolder.postInfo = ((cnc)localObject);
      if (localObject == null) {
        break label465;
      }
      if (!z.aTY().equals(paramTimeLineObject.UserName)) {
        break;
      }
      paramBaseViewHolder.EWX.setVisibility(0);
      parambk = parambk.EBe;
      paramBaseViewHolder = paramBaseViewHolder.EWX;
      parambl = parambl.Eql;
      i = this.mActivity.hashCode();
      bool = this.EAv;
      localObject = bp.gCU();
      ((bp)localObject).hXs = paramTimeLineObject.CreateTime;
      parambk.a(paramBaseViewHolder, paramTimeLineObject, parambl, i, paramInt2, paramInt1, bool, (bp)localObject, true);
      AppMethodBeat.o(100086);
      return;
      label247:
      paramBaseViewHolder.EXB.setBackgroundResource(2131232827);
    }
    if (parambl.ENJ)
    {
      paramBaseViewHolder.EWX.setVisibility(0);
      parambk = parambk.EBe;
      paramBaseViewHolder = paramBaseViewHolder.EWX;
      parambl = parambl.Eql;
      i = this.mActivity.hashCode();
      bool = this.EAv;
      localObject = bp.gCU();
      ((bp)localObject).hXs = paramTimeLineObject.CreateTime;
      parambk.a(paramBaseViewHolder, paramTimeLineObject, parambl, i, paramInt2, paramInt1, bool, (bp)localObject, false);
      AppMethodBeat.o(100086);
      return;
    }
    if (((cnc)localObject).egZ == 0)
    {
      paramBaseViewHolder.EWX.setVisibility(0);
      parambk = parambk.EBe;
      paramBaseViewHolder = paramBaseViewHolder.EWX;
      parambl = parambl.Eql;
      i = this.mActivity.hashCode();
      bool = this.EAv;
      localObject = bp.gCU();
      ((bp)localObject).hXs = paramTimeLineObject.CreateTime;
      parambk.a(paramBaseViewHolder, paramTimeLineObject, parambl, i, paramInt2, paramInt1, bool, (bp)localObject, true);
      AppMethodBeat.o(100086);
      return;
    }
    Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((cnc)localObject).egZ);
    AppMethodBeat.o(100086);
    return;
    label465:
    Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + parambl.Eql);
    AppMethodBeat.o(100086);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100085);
    paramBaseViewHolder.EWP.setImageResource(2131233582);
    paramBaseViewHolder.EWx.setTextColor(paramBaseViewHolder.EWx.getContext().getResources().getColor(2131100996));
    if (paramBaseViewHolder.EWD != null)
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496442);
      if (!paramBaseViewHolder.EWE) {
        paramBaseViewHolder.EWX = ((PhotosContent)paramBaseViewHolder.EWD.inflate());
      }
    }
    for (paramBaseViewHolder.EWE = true;; paramBaseViewHolder.EWE = true)
    {
      Log.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.qcr);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.EWX.findViewById(be.EGz[0]);
      paramBaseViewHolder.EWX.a(localTagImageView);
      localTagImageView.setOnClickListener(this.DQX.DQs.Erh);
      AppMethodBeat.o(100085);
      return;
      paramBaseViewHolder.EWX = ((PhotosContent)paramBaseViewHolder.convertView.findViewById(2131302255));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */