package com.tencent.mm.plugin.sns.ad.timeline.c;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.timeline.b.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.d;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.q;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  extends q
{
  private boolean Dzj = false;
  private String Dzk = "";
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(202254);
    if (this.Dzj)
    {
      Log.d("SnsAd.AdSightTimeLineItem", "the new video  item is online video");
      if (paramBaseViewHolder == null)
      {
        Log.e("SnsAd.AdSightTimeLineItem", "the holder is null");
        AppMethodBeat.o(202254);
        return;
      }
      cnb localcnb = g.a(paramBaseViewHolder);
      String str1 = g.c(paramBaseViewHolder);
      SnsInfo localSnsInfo = aj.faO().aQm(paramBaseViewHolder.dHp);
      k localk = g.a(this.DQX);
      String str2 = paramBaseViewHolder.dHp;
      if ((localcnb == null) || (str1 == null) || (localSnsInfo == null))
      {
        Log.e("SnsAd.AdSightTimeLineItem", "the media , timelineId, sns info is null");
        AppMethodBeat.o(202254);
        return;
      }
      com.tencent.mm.plugin.sns.ui.video.b.fkM().pause();
      eYc();
      paramBaseViewHolder = (FrameLayout)paramBaseViewHolder.EUK.Ewr.findViewById(2131308264);
      d locald = new d("SnsAd.AdSightTimeLineItem");
      locald.mContainer = paramBaseViewHolder;
      locald.DzV = localcnb;
      locald.DqO = localSnsInfo;
      locald.rzs = str2;
      locald.Dzk = str1;
      locald.DzW = localk;
      locald.a(1, new SnsTimelineVideoView.b()
      {
        public final void Zl(String paramAnonymousString)
        {
          AppMethodBeat.i(202251);
          if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(b.a(b.this))))
          {
            Log.w("SnsAd.AdSightTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + b.a(b.this));
            b.b(b.this);
          }
          AppMethodBeat.o(202251);
        }
      });
      AppMethodBeat.o(202254);
      return;
    }
    Log.d("SnsAd.AdSightTimeLineItem", "the new video item is running, execute super play!");
    super.a(paramBaseViewHolder, paramInt);
    AppMethodBeat.o(202254);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(202252);
    if (parambl != null) {}
    try
    {
      if (parambl.DqO != null) {
        if ((!a.a(parambl.DqO.getAdXml())) || (!a.eXT())) {
          break label143;
        }
      }
      label143:
      for (this.Dzj = true;; this.Dzj = false)
      {
        if ((paramTimeLineObject != null) && (paramTimeLineObject.Id != null)) {
          this.Dzk = paramTimeLineObject.Id;
        }
        if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.LoV.size() <= 0)) {
          break;
        }
        cnb localcnb1 = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
        if (parambl.Eoq)
        {
          if (!this.Dzj) {
            break label162;
          }
          com.tencent.mm.plugin.sns.ad.e.b.a(parambl.DqO, localcnb1);
        }
        super.a(paramBaseViewHolder, paramInt1, parambl, paramTimeLineObject, paramInt2, parambk);
        AppMethodBeat.o(202252);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        continue;
        cnb localcnb2 = null;
        continue;
        label162:
        com.tencent.mm.plugin.sns.ad.e.b.a(localcnb2, false);
      }
    }
  }
  
  public final boolean eXX()
  {
    AppMethodBeat.i(202253);
    if (this.Dzj)
    {
      AppMethodBeat.o(202253);
      return false;
    }
    boolean bool = super.eXX();
    AppMethodBeat.o(202253);
    return bool;
  }
  
  public final boolean eXY()
  {
    return this.Dzj;
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.b
 * JD-Core Version:    0.7.0.1
 */