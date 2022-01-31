package com.tencent.mm.plugin.sns.ui.c;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  private int oWs = 103;
  
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    Object localObject = paramax.oOM;
    if (paramc.pnE != null)
    {
      if ((!paramax.phf) || (paramc.okd.tKm == null) || (paramc.okd.tKm.tKO <= 0)) {
        break label238;
      }
      paramc.pnE.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_myself);
    }
    int i;
    boolean bool;
    for (;;)
    {
      TagImageView localTagImageView = paramc.pmZ.yD(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localTagImageView);
      ao localao = new ao();
      localao.bMB = ((String)localObject);
      localao.index = 0;
      localao.oYz = localArrayList;
      localao.oVB = this.oVB;
      if (localTagImageView != null) {
        localTagImageView.setTag(localao);
      }
      localObject = paramax.phF;
      paramc.oLv = ((awe)localObject);
      if (localObject == null) {
        break label442;
      }
      if (!q.Gj().equals(parambxk.hPY)) {
        break;
      }
      paramc.pmZ.setVisibility(0);
      paramau = paramau.oWh;
      paramc = paramc.pmZ;
      paramax = paramax.oOM;
      i = this.mActivity.hashCode();
      bool = this.oVB;
      localObject = az.cuY();
      ((az)localObject).time = parambxk.mPL;
      paramau.a(paramc, parambxk, paramax, i, paramInt2, paramInt1, bool, (az)localObject, true);
      return;
      label238:
      paramc.pnE.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
    }
    if (paramax.phi)
    {
      paramc.pmZ.setVisibility(0);
      paramau = paramau.oWh;
      paramc = paramc.pmZ;
      paramax = paramax.oOM;
      i = this.mActivity.hashCode();
      bool = this.oVB;
      localObject = az.cuY();
      ((az)localObject).time = parambxk.mPL;
      paramau.a(paramc, parambxk, paramax, i, paramInt2, paramInt1, bool, (az)localObject, false);
      return;
    }
    if (((awe)localObject).cec == 0)
    {
      paramc.pmZ.setVisibility(0);
      paramau = paramau.oWh;
      paramc = paramc.pmZ;
      paramax = paramax.oOM;
      i = this.mActivity.hashCode();
      bool = this.oVB;
      localObject = az.cuY();
      ((az)localObject).time = parambxk.mPL;
      paramau.a(paramc, parambxk, paramax, i, paramInt2, paramInt1, bool, (az)localObject, true);
      return;
    }
    y.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + ((awe)localObject).cec);
    return;
    label442:
    y.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + paramax.oOM);
  }
  
  public final void d(a.c paramc)
  {
    paramc.pmS.setImageResource(i.e.lucky_friendactivity_comment_icon);
    paramc.pmC.setTextColor(-2730427);
    if (paramc.pmI != null)
    {
      paramc.pmI.setLayoutResource(i.g.sns_hb_reward_item);
      if (!paramc.pmJ) {
        paramc.pmZ = ((PhotosContent)paramc.pmI.inflate());
      }
    }
    for (paramc.pmJ = true;; paramc.pmJ = true)
    {
      y.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.ivk);
      TagImageView localTagImageView = (TagImageView)paramc.pmZ.findViewById(aq.paG[0]);
      paramc.pmZ.a(localTagImageView);
      localTagImageView.setOnClickListener(this.owd.ovx.oPK);
      return;
      paramc.pmZ = ((PhotosContent)paramc.kKz.findViewById(i.f.hb_content_rl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.e
 * JD-Core Version:    0.7.0.1
 */