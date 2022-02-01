package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
{
  public ViewGroup mContainer;
  private final String mTag;
  public String qiw;
  public p zlW;
  public String zrS;
  public bzh zrY;
  public com.tencent.mm.plugin.sns.ad.e.j zrZ;
  
  public d(String paramString)
  {
    AppMethodBeat.i(219164);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoPlayBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(219164);
  }
  
  private void a(p paramp, bzh parambzh, String paramString1, ViewGroup paramViewGroup, String paramString2, com.tencent.mm.plugin.sns.ad.e.j paramj, SnsTimelineVideoView.b paramb, int paramInt)
  {
    AppMethodBeat.i(219166);
    ae.d(this.mTag, "the online is to start");
    c localc;
    if ((paramp != null) && (parambzh != null) && (paramViewGroup != null))
    {
      ae.w(this.mTag, "the sns info is " + paramp + " the media is " + parambzh);
      localc = new c();
      localc.dKe = parambzh;
      localc.dqc = paramString2;
      localc.dAg = r.zV(paramp.field_snsId);
      localc.icw = paramp.field_createTime;
      if (!com.tencent.mm.plugin.sns.ad.f.j.x(paramViewGroup)) {
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
      if ((paramString2 != null) && (!paramString2.ASv) && (paramString2.ASr != null) && (paramString2.ASr.dKe != null) && (bu.lX(paramString1, paramString2.ASs)) && (bu.lX(paramString2.ASr.dKe.Id, parambzh.Id))) {
        ae.w(this.mTag, "the time line online video is already added!");
      }
      for (;;)
      {
        paramString2.setUICallback(paramb);
        com.tencent.mm.plugin.sns.ad.f.j.t(paramString2, true);
        paramString2.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        paramString2.setVideoScaleType(i.e.Flk);
        paramString2.setVideoCallback(new a(paramp, paramString2, paramj, paramInt));
        com.tencent.mm.plugin.sns.ui.video.d.eir().a(paramString2, localc, paramString1);
        AppMethodBeat.o(219166);
        return;
        ae.w(this.mTag, "the time line online video is added, it need to be replaced");
        long l = SystemClock.currentThreadTimeMillis();
        com.tencent.mm.plugin.sns.ad.f.j.w(paramViewGroup);
        paramString2 = com.tencent.mm.plugin.sns.ui.video.d.eir().gs(paramViewGroup.getContext());
        ae.w(this.mTag, "the time line online video is added, getAvailableVideoView, called: take " + (SystemClock.currentThreadTimeMillis() - l));
        if (com.tencent.mm.plugin.sns.ad.f.j.eO(paramString2))
        {
          paramString2.eip();
          com.tencent.mm.plugin.sns.ad.f.j.eP(paramString2);
        }
        com.tencent.mm.plugin.sns.ad.f.j.u(paramString2, -1, -1);
        com.tencent.mm.plugin.sns.ad.f.j.a(paramViewGroup, paramString2, -1);
      }
    }
  }
  
  public final void a(int paramInt, SnsTimelineVideoView.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(219165);
    int i = 1;
    if (this.zlW == null)
    {
      ae.e(this.mTag, "OnlinePlayerHelper:the sns info is null");
      i = 0;
    }
    if (this.zrY == null)
    {
      ae.e(this.mTag, "OnlinePlayerHelper:the media object is null");
      i = 0;
    }
    if (this.mContainer == null)
    {
      ae.e(this.mTag, "OnlinePlayerHelper:the container is null");
      i = 0;
    }
    if (TextUtils.isEmpty(this.zrS))
    {
      ae.e(this.mTag, "OnlinePlayerHelper:the time line id is empty");
      i = 0;
    }
    if (TextUtils.isEmpty(this.qiw))
    {
      ae.e(this.mTag, "OnlinePlayerHelper:the sns local id is empty");
      i = 0;
    }
    if (this.zrZ == null)
    {
      ae.e(this.mTag, "OnlinePlayerHelper:the snsAdStatistic is null");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        a(this.zlW, this.zrY, this.zrS, this.mContainer, this.qiw, this.zrZ, paramb, paramInt);
      }
      AppMethodBeat.o(219165);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.d
 * JD-Core Version:    0.7.0.1
 */