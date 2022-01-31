package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseTimeLineItem
{
  private int rOQ = 103;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40148);
    Object localObject = paramaw.rGx;
    if (paramBaseViewHolder.shP != null)
    {
      if ((!paramaw.rZM) || (paramBaseViewHolder.snsobj.SnsRedEnvelops == null) || (paramBaseViewHolder.snsobj.SnsRedEnvelops.xPd <= 0)) {
        break label247;
      }
      paramBaseViewHolder.shP.setBackgroundResource(2130838909);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramBaseViewHolder.shk.EJ(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      ao localao = new ao();
      localao.ctV = ((String)localObject);
      localao.index = 0;
      localao.rQS = localArrayList;
      localao.rNW = this.rNW;
      if (localTagImageView != null) {
        localTagImageView.setTag(localao);
      }
      localObject = paramaw.sam;
      paramBaseViewHolder.rDg = ((bct)localObject);
      if (localObject == null) {
        break label465;
      }
      if (!r.Zn().equals(paramTimeLineObject.jJA)) {
        break;
      }
      paramBaseViewHolder.shk.setVisibility(0);
      paramav = paramav.rOF;
      paramBaseViewHolder = paramBaseViewHolder.shk;
      paramaw = paramaw.rGx;
      i = this.mActivity.hashCode();
      bool = this.rNW;
      localObject = az.dxB();
      ((az)localObject).oLs = paramTimeLineObject.CreateTime;
      paramav.a(paramBaseViewHolder, paramTimeLineObject, paramaw, i, paramInt2, paramInt1, bool, (az)localObject, true);
      AppMethodBeat.o(40148);
      return;
      label247:
      paramBaseViewHolder.shP.setBackgroundResource(2130838908);
    }
    if (paramaw.rZP)
    {
      paramBaseViewHolder.shk.setVisibility(0);
      paramav = paramav.rOF;
      paramBaseViewHolder = paramBaseViewHolder.shk;
      paramaw = paramaw.rGx;
      i = this.mActivity.hashCode();
      bool = this.rNW;
      localObject = az.dxB();
      ((az)localObject).oLs = paramTimeLineObject.CreateTime;
      paramav.a(paramBaseViewHolder, paramTimeLineObject, paramaw, i, paramInt2, paramInt1, bool, (az)localObject, false);
      AppMethodBeat.o(40148);
      return;
    }
    if (((bct)localObject).cMQ == 0)
    {
      paramBaseViewHolder.shk.setVisibility(0);
      paramav = paramav.rOF;
      paramBaseViewHolder = paramBaseViewHolder.shk;
      paramaw = paramaw.rGx;
      i = this.mActivity.hashCode();
      bool = this.rNW;
      localObject = az.dxB();
      ((az)localObject).oLs = paramTimeLineObject.CreateTime;
      paramav.a(paramBaseViewHolder, paramTimeLineObject, paramaw, i, paramInt2, paramInt1, bool, (az)localObject, true);
      AppMethodBeat.o(40148);
      return;
    }
    ab.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((bct)localObject).cMQ);
    AppMethodBeat.o(40148);
    return;
    label465:
    ab.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + paramaw.rGx);
    AppMethodBeat.o(40148);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40147);
    paramBaseViewHolder.shd.setImageResource(2130839331);
    paramBaseViewHolder.sgN.setTextColor(-2730427);
    if (paramBaseViewHolder.sgT != null)
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970827);
      if (!paramBaseViewHolder.sgU) {
        paramBaseViewHolder.shk = ((PhotosContent)paramBaseViewHolder.sgT.inflate());
      }
    }
    for (paramBaseViewHolder.sgU = true;; paramBaseViewHolder.sgU = true)
    {
      ab.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.kwo);
      TagImageView localTagImageView = (TagImageView)paramBaseViewHolder.shk.findViewById(aq.rTk[0]);
      paramBaseViewHolder.shk.a(localTagImageView);
      localTagImageView.setOnClickListener(this.rkX.rks.rHw);
      AppMethodBeat.o(40147);
      return;
      paramBaseViewHolder.shk = ((PhotosContent)paramBaseViewHolder.ngZ.findViewById(2131827993));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */