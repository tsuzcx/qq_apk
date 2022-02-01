package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public SnsInfo DqO;
  public cnb DzV;
  public k DzW;
  public String Dzk;
  public ViewGroup mContainer;
  private final String mTag;
  public String rzs;
  
  public d(String paramString)
  {
    AppMethodBeat.i(202324);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoPlayBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(202324);
  }
  
  private void a(SnsInfo paramSnsInfo, cnb paramcnb, String paramString1, ViewGroup paramViewGroup, String paramString2, k paramk, SnsTimelineVideoView.b paramb, int paramInt)
  {
    AppMethodBeat.i(202326);
    Log.d(this.mTag, "the online is to start");
    c localc;
    if ((paramSnsInfo != null) && (paramcnb != null) && (paramViewGroup != null))
    {
      Log.w(this.mTag, "the sns info is " + paramSnsInfo + " the media is " + paramcnb);
      localc = new c();
      localc.ebR = paramcnb;
      localc.dHp = paramString2;
      localc.dRS = r.Jb(paramSnsInfo.field_snsId);
      localc.iXu = paramSnsInfo.getCreateTime();
      if (!m.G(paramViewGroup)) {
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
      if ((paramString2 != null) && (!paramString2.Fdb) && (paramString2.FcY != null) && (paramString2.FcY.ebR != null) && (Util.isEqual(paramString1, paramString2.FcZ)) && (Util.isEqual(paramString2.FcY.ebR.Id, paramcnb.Id))) {
        Log.w(this.mTag, "the time line online video is already added!");
      }
      for (;;)
      {
        paramString2.setUICallback(paramb);
        m.u(paramString2, true);
        paramString2.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        paramString2.setVideoScaleType(i.e.Kcc);
        paramString2.setVideoCallback(new a(paramSnsInfo, paramString2, paramk, paramInt));
        com.tencent.mm.plugin.sns.ui.video.d.fkS().a(paramString2, localc, paramString1);
        AppMethodBeat.o(202326);
        return;
        Log.w(this.mTag, "the time line online video is added, it need to be replaced");
        long l = SystemClock.currentThreadTimeMillis();
        m.F(paramViewGroup);
        paramString2 = com.tencent.mm.plugin.sns.ui.video.d.fkS().hd(paramViewGroup.getContext());
        Log.w(this.mTag, "the time line online video is added, getAvailableVideoView, called: take " + (SystemClock.currentThreadTimeMillis() - l));
        if (m.fb(paramString2))
        {
          paramString2.fkQ();
          m.fc(paramString2);
        }
        m.u(paramString2, -1, -1);
        m.a(paramViewGroup, paramString2, -1);
      }
    }
  }
  
  public final void a(int paramInt, SnsTimelineVideoView.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(202325);
    int i = 1;
    if (this.DqO == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the sns info is null");
      i = 0;
    }
    if (this.DzV == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the media object is null");
      i = 0;
    }
    if (this.mContainer == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the container is null");
      i = 0;
    }
    if (TextUtils.isEmpty(this.Dzk))
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the time line id is empty");
      i = 0;
    }
    if (TextUtils.isEmpty(this.rzs))
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the sns local id is empty");
      i = 0;
    }
    if (this.DzW == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the snsAdStatistic is null");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        a(this.DqO, this.DzV, this.Dzk, this.mContainer, this.rzs, this.DzW, paramb, paramInt);
      }
      AppMethodBeat.o(202325);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.d
 * JD-Core Version:    0.7.0.1
 */