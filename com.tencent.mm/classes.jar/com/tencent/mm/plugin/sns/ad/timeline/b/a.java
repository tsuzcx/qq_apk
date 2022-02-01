package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.f;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.d;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.video.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
{
  private boolean zrR = false;
  private String zrS = "";
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(219155);
    if (this.zrR)
    {
      ae.d("SnsAd.AdSightTimeLineItem", "the new video  item is online video");
      if (paramBaseViewHolder == null)
      {
        ae.e("SnsAd.AdSightTimeLineItem", "the holder is null");
        AppMethodBeat.o(219155);
        return;
      }
      bzh localbzh = f.a(paramBaseViewHolder);
      String str1 = f.c(paramBaseViewHolder);
      p localp = ah.dXE().aBr(paramBaseViewHolder.dqc);
      j localj = f.a(this.zGX);
      String str2 = paramBaseViewHolder.dqc;
      if ((localbzh == null) || (str1 == null) || (localp == null))
      {
        ae.e("SnsAd.AdSightTimeLineItem", "the media , timelineId, sns info is null");
        AppMethodBeat.o(219155);
        return;
      }
      b.eil().pause();
      ehP();
      paramBaseViewHolder = (FrameLayout)paramBaseViewHolder.AKJ.AnG.findViewById(2131305105);
      d locald = new d("SnsAd.AdSightTimeLineItem");
      locald.mContainer = paramBaseViewHolder;
      locald.zrY = localbzh;
      locald.zlW = localp;
      locald.qiw = str2;
      locald.zrS = str1;
      locald.zrZ = localj;
      locald.a(1, new a.1(this));
      AppMethodBeat.o(219155);
      return;
    }
    ae.d("SnsAd.AdSightTimeLineItem", "the new video item is running, execute super play!");
    super.a(paramBaseViewHolder, paramInt);
    AppMethodBeat.o(219155);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(219153);
    if (parambi != null) {}
    try
    {
      if (parambi.zlW != null) {
        if ((!com.tencent.mm.plugin.sns.ad.timeline.a.a.a(parambi.zlW.dVj())) || (!com.tencent.mm.plugin.sns.ad.timeline.a.a.dVr())) {
          break label81;
        }
      }
      label40:
      label81:
      for (this.zrR = true;; this.zrR = false)
      {
        if ((paramTimeLineObject != null) && (paramTimeLineObject.Id != null)) {
          this.zrS = paramTimeLineObject.Id;
        }
        super.a(paramBaseViewHolder, paramInt1, parambi, paramTimeLineObject, paramInt2, parambh);
        AppMethodBeat.o(219153);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label40;
    }
  }
  
  public final boolean dVx()
  {
    AppMethodBeat.i(219154);
    if (this.zrR)
    {
      AppMethodBeat.o(219154);
      return false;
    }
    boolean bool = super.dVx();
    AppMethodBeat.o(219154);
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