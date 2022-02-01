package com.tencent.mm.plugin.sns.ad.timeline.c;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.s;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  extends s
{
  private String JJA = "";
  private boolean JJz = false;
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(242023);
    if (this.JJz)
    {
      Log.d("SnsAd.AdSightTimeLineItem", "the new video  item is online video");
      if (paramBaseViewHolder == null)
      {
        Log.e("SnsAd.AdSightTimeLineItem", "the holder is null");
        AppMethodBeat.o(242023);
        return;
      }
      cvt localcvt = g.a(paramBaseViewHolder);
      String str1 = g.c(paramBaseViewHolder);
      SnsInfo localSnsInfo = aj.fOI().bbl(paramBaseViewHolder.fAg);
      l locall = g.a(this.Kee);
      String str2 = paramBaseViewHolder.fAg;
      if ((localcvt == null) || (str1 == null) || (localSnsInfo == null))
      {
        Log.e("SnsAd.AdSightTimeLineItem", "the media , timelineId, sns info is null");
        AppMethodBeat.o(242023);
        return;
      }
      com.tencent.mm.plugin.sns.ui.video.b.fYX().pause();
      fLI();
      paramBaseViewHolder = (FrameLayout)paramBaseViewHolder.JKG.KKj.findViewById(i.f.sns_video_container);
      com.tencent.mm.plugin.sns.ad.timeline.video.online.d locald = new com.tencent.mm.plugin.sns.ad.timeline.video.online.d("SnsAd.AdSightTimeLineItem");
      locald.mContainer = paramBaseViewHolder;
      locald.JLl = localcvt;
      locald.Jws = localSnsInfo;
      locald.veZ = str2;
      locald.JJA = str1;
      locald.JHg = locall;
      locald.a(1, new SnsTimelineVideoView.b()
      {
        public final void agY(String paramAnonymousString)
        {
          AppMethodBeat.i(204778);
          if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(b.a(b.this))))
          {
            Log.w("SnsAd.AdSightTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + b.a(b.this));
            b.b(b.this);
          }
          AppMethodBeat.o(204778);
        }
      });
      AppMethodBeat.o(242023);
      return;
    }
    Log.d("SnsAd.AdSightTimeLineItem", "the new video item is running, execute super play!");
    super.a(paramBaseViewHolder, paramInt);
    AppMethodBeat.o(242023);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(242022);
    if (parambn != null) {}
    try
    {
      if (parambn.Jws != null) {
        this.JJz = com.tencent.mm.plugin.sns.ad.timeline.b.b.b(parambn.Jws.getAdXml());
      }
      label30:
      if ((paramTimeLineObject != null) && (paramTimeLineObject.Id != null)) {
        this.JJA = paramTimeLineObject.Id;
      }
      cvt localcvt;
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0))
      {
        localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
        if (parambn.KBz)
        {
          if (!this.JJz) {
            break label139;
          }
          com.tencent.mm.plugin.sns.ad.d.d.a(parambn.Jws, localcvt);
        }
      }
      for (;;)
      {
        super.a(paramBaseViewHolder, paramInt1, parambn, paramTimeLineObject, paramInt2, parambm);
        AppMethodBeat.o(242022);
        return;
        localcvt = null;
        break;
        label139:
        com.tencent.mm.plugin.sns.ad.d.d.a(localcvt, false);
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final boolean fLA()
  {
    return this.JJz;
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.b
 * JD-Core Version:    0.7.0.1
 */