package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
{
  public ViewGroup mContainer;
  private final String mTag;
  public String qbR;
  public p yVM;
  public String zbo;
  public byn zbu;
  public i zbv;
  
  public d(String paramString)
  {
    AppMethodBeat.i(197692);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoPlayBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(197692);
  }
  
  private void a(p paramp, byn parambyn, String paramString1, ViewGroup paramViewGroup, String paramString2, i parami, SnsTimelineVideoView.b paramb, int paramInt)
  {
    AppMethodBeat.i(197694);
    ad.d(this.mTag, "the online is to start");
    c localc;
    if ((paramp != null) && (parambyn != null) && (paramViewGroup != null))
    {
      ad.w(this.mTag, "the sns info is " + paramp + " the media is " + parambyn);
      localc = new c();
      localc.dIQ = parambyn;
      localc.doX = paramString2;
      localc.dzb = q.zw(paramp.field_snsId);
      localc.hZE = paramp.field_createTime;
      if (!j.x(paramViewGroup)) {
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
      if ((paramString2 != null) && (!paramString2.ABa) && (paramString2.AAW != null) && (paramString2.AAW.dIQ != null) && (bt.lQ(paramString1, paramString2.AAX)) && (bt.lQ(paramString2.AAW.dIQ.Id, parambyn.Id))) {
        ad.w(this.mTag, "the time line online video is already added!");
      }
      for (;;)
      {
        paramString2.setUICallback(paramb);
        j.O(paramString2, true);
        paramString2.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        paramString2.setVideoScaleType(i.e.ESP);
        paramString2.setVideoCallback(new a(paramp, paramString2, parami, paramInt));
        com.tencent.mm.plugin.sns.ui.video.d.eeK().a(paramString2, localc, paramString1);
        AppMethodBeat.o(197694);
        return;
        ad.w(this.mTag, "the time line online video is added, it need to be replaced");
        long l = SystemClock.currentThreadTimeMillis();
        j.w(paramViewGroup);
        paramString2 = com.tencent.mm.plugin.sns.ui.video.d.eeK().gn(paramViewGroup.getContext());
        ad.w(this.mTag, "the time line online video is added, getAvailableVideoView, called: take " + (SystemClock.currentThreadTimeMillis() - l));
        if (j.eP(paramString2))
        {
          paramString2.eeI();
          j.eQ(paramString2);
        }
        j.v(paramString2, -1, -1);
        j.a(paramViewGroup, paramString2, -1);
      }
    }
  }
  
  public final void a(int paramInt, SnsTimelineVideoView.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(197693);
    int i = 1;
    if (this.yVM == null)
    {
      ad.e(this.mTag, "OnlinePlayerHelper:the sns info is null");
      i = 0;
    }
    if (this.zbu == null)
    {
      ad.e(this.mTag, "OnlinePlayerHelper:the media object is null");
      i = 0;
    }
    if (this.mContainer == null)
    {
      ad.e(this.mTag, "OnlinePlayerHelper:the container is null");
      i = 0;
    }
    if (TextUtils.isEmpty(this.zbo))
    {
      ad.e(this.mTag, "OnlinePlayerHelper:the time line id is empty");
      i = 0;
    }
    if (TextUtils.isEmpty(this.qbR))
    {
      ad.e(this.mTag, "OnlinePlayerHelper:the sns local id is empty");
      i = 0;
    }
    if (this.zbv == null)
    {
      ad.e(this.mTag, "OnlinePlayerHelper:the snsAdStatistic is null");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        a(this.yVM, this.zbu, this.zbo, this.mContainer, this.qbR, this.zbv, paramb, paramInt);
      }
      AppMethodBeat.o(197693);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.d
 * JD-Core Version:    0.7.0.1
 */