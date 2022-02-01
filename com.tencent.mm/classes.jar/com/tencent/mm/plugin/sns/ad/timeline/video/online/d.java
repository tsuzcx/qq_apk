package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.e;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public com.tencent.mm.plugin.sns.ad.f.l JHg;
  public String JJA;
  public cvt JLl;
  public SnsInfo Jws;
  public ViewGroup mContainer;
  private final String mTag;
  public String veZ;
  
  public d(String paramString)
  {
    AppMethodBeat.i(268808);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoPlayBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(268808);
  }
  
  private void a(SnsInfo paramSnsInfo, cvt paramcvt, String paramString1, ViewGroup paramViewGroup, String paramString2, com.tencent.mm.plugin.sns.ad.f.l paraml, SnsTimelineVideoView.b paramb, int paramInt)
  {
    AppMethodBeat.i(268811);
    Log.d(this.mTag, "the online is to start");
    com.tencent.mm.plugin.sns.ui.video.d locald;
    if ((paramSnsInfo != null) && (paramcvt != null) && (paramViewGroup != null))
    {
      Log.w(this.mTag, "the sns info is " + paramSnsInfo + " the media is " + paramcvt);
      locald = new com.tencent.mm.plugin.sns.ui.video.d();
      locald.fVT = paramcvt;
      locald.fAg = paramString2;
      locald.fLp = t.Qu(paramSnsInfo.field_snsId);
      locald.createTime = paramSnsInfo.getCreateTime();
      if (!com.tencent.mm.plugin.sns.ad.i.l.N(paramViewGroup)) {
        break label369;
      }
      paramString2 = paramViewGroup.getChildAt(0);
      if (!(paramString2 instanceof SnsTimelineVideoView)) {
        break label369;
      }
    }
    label369:
    for (paramString2 = (SnsTimelineVideoView)paramString2;; paramString2 = null)
    {
      if ((paramString2 != null) && (!paramString2.Lrx) && (paramString2.Lru != null) && (paramString2.Lru.fVT != null) && (Util.isEqual(paramString1, paramString2.Lrv)) && (Util.isEqual(paramString2.Lru.fVT.Id, paramcvt.Id))) {
        Log.w(this.mTag, "the time line online video is already added!");
      }
      for (;;)
      {
        paramString2.setUICallback(paramb);
        com.tencent.mm.plugin.sns.ad.i.l.w(paramString2, true);
        paramString2.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        paramString2.setVideoScaleType(i.e.RcH);
        paramString2.setVideoCallback(new a(paramSnsInfo, paramString2, paraml, paramInt));
        e.fZg().a(paramString2, locald, paramString1);
        AppMethodBeat.o(268811);
        return;
        Log.w(this.mTag, "the time line online video is added, it need to be replaced");
        long l = SystemClock.currentThreadTimeMillis();
        com.tencent.mm.plugin.sns.ad.i.l.M(paramViewGroup);
        paramString2 = e.fZg().ie(paramViewGroup.getContext());
        Log.w(this.mTag, "the time line online video is added, getAvailableVideoView, called: take " + (SystemClock.currentThreadTimeMillis() - l));
        if (com.tencent.mm.plugin.sns.ad.i.l.gi(paramString2))
        {
          paramString2.fZb();
          com.tencent.mm.plugin.sns.ad.i.l.gj(paramString2);
        }
        com.tencent.mm.plugin.sns.ad.i.l.v(paramString2, -1, -1);
        com.tencent.mm.plugin.sns.ad.i.l.b(paramViewGroup, paramString2, -1);
      }
    }
  }
  
  public final void a(int paramInt, SnsTimelineVideoView.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(268809);
    int i = 1;
    if (this.Jws == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the sns info is null");
      i = 0;
    }
    if (this.JLl == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the media object is null");
      i = 0;
    }
    if (this.mContainer == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the container is null");
      i = 0;
    }
    if (TextUtils.isEmpty(this.JJA))
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the time line id is empty");
      i = 0;
    }
    if (TextUtils.isEmpty(this.veZ))
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the sns local id is empty");
      i = 0;
    }
    if (this.JHg == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the snsAdStatistic is null");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        a(this.Jws, this.JLl, this.JJA, this.mContainer, this.veZ, this.JHg, paramb, paramInt);
      }
      AppMethodBeat.o(268809);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.d
 * JD-Core Version:    0.7.0.1
 */