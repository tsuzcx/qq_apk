package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
{
  private boolean zbn = false;
  private String zbo = "";
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(197683);
    if (this.zbn)
    {
      ad.d("SnsAd.AdSightTimeLineItem", "the new video  item is online video");
      if (paramBaseViewHolder == null)
      {
        ad.e("SnsAd.AdSightTimeLineItem", "the holder is null");
        AppMethodBeat.o(197683);
        return;
      }
      byn localbyn = com.tencent.mm.plugin.sns.ad.timeline.a.d.a(paramBaseViewHolder);
      String str1 = com.tencent.mm.plugin.sns.ad.timeline.a.d.c(paramBaseViewHolder);
      p localp = ag.dUe().aAa(paramBaseViewHolder.doX);
      i locali = com.tencent.mm.plugin.sns.ad.timeline.a.d.a(this.zpI);
      String str2 = paramBaseViewHolder.doX;
      if ((localbyn == null) || (str1 == null) || (localp == null))
      {
        ad.e("SnsAd.AdSightTimeLineItem", "the media , timelineId, sns info is null");
        AppMethodBeat.o(197683);
        return;
      }
      b.eeD().pause();
      eeG();
      paramBaseViewHolder = (FrameLayout)paramBaseViewHolder.Atv.zWx.findViewById(2131305105);
      com.tencent.mm.plugin.sns.ad.timeline.c.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d("SnsAd.AdSightTimeLineItem");
      locald.mContainer = paramBaseViewHolder;
      locald.zbu = localbyn;
      locald.yVM = localp;
      locald.qbR = str2;
      locald.zbo = str1;
      locald.zbv = locali;
      locald.a(1, new SnsTimelineVideoView.b()
      {
        public final void Pj(String paramAnonymousString)
        {
          AppMethodBeat.i(197680);
          if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(a.a(a.this))))
          {
            ad.w("SnsAd.AdSightTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + a.a(a.this));
            a.b(a.this);
          }
          AppMethodBeat.o(197680);
        }
      });
      AppMethodBeat.o(197683);
      return;
    }
    ad.d("SnsAd.AdSightTimeLineItem", "the new video item is running, execute super play!");
    super.a(paramBaseViewHolder, paramInt);
    AppMethodBeat.o(197683);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(197681);
    if (parambi != null) {}
    try
    {
      if (parambi.yVM != null) {
        if ((!com.tencent.mm.plugin.sns.ad.timeline.a.a.a(parambi.yVM.dRL())) || (!com.tencent.mm.plugin.sns.ad.timeline.a.a.dRT())) {
          break label81;
        }
      }
      label40:
      label81:
      for (this.zbn = true;; this.zbn = false)
      {
        if ((paramTimeLineObject != null) && (paramTimeLineObject.Id != null)) {
          this.zbo = paramTimeLineObject.Id;
        }
        super.a(paramBaseViewHolder, paramInt1, parambi, paramTimeLineObject, paramInt2, parambh);
        AppMethodBeat.o(197681);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label40;
    }
  }
  
  public final boolean dRZ()
  {
    AppMethodBeat.i(197682);
    if (this.zbn)
    {
      AppMethodBeat.o(197682);
      return false;
    }
    boolean bool = super.dRZ();
    AppMethodBeat.o(197682);
    return bool;
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a
 * JD-Core Version:    0.7.0.1
 */