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
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public SnsInfo PJQ;
  public com.tencent.mm.plugin.sns.ad.g.l PYh;
  public String Qbe;
  public dmz QcU;
  public ViewGroup mContainer;
  private final String mTag;
  public String yqW;
  
  public d(String paramString)
  {
    AppMethodBeat.i(310962);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoPlayBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(310962);
  }
  
  private void a(SnsInfo paramSnsInfo, dmz paramdmz, String paramString1, ViewGroup paramViewGroup, String paramString2, com.tencent.mm.plugin.sns.ad.g.l paraml, SnsTimelineVideoView.b paramb, int paramInt)
  {
    AppMethodBeat.i(310979);
    Log.d(this.mTag, "the online is to start");
    com.tencent.mm.plugin.sns.ui.video.d locald;
    if ((paramSnsInfo != null) && (paramdmz != null) && (paramViewGroup != null))
    {
      Log.w(this.mTag, "the sns info is " + paramSnsInfo + " the media is " + paramdmz);
      locald = new com.tencent.mm.plugin.sns.ui.video.d();
      locald.ibT = paramdmz;
      locald.hES = paramString2;
      locald.hQX = t.uA(paramSnsInfo.field_snsId);
      locald.createTime = paramSnsInfo.getCreateTime();
      if (!com.tencent.mm.plugin.sns.ad.j.l.X(paramViewGroup)) {
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
      if ((paramString2 != null) && (!paramString2.RUB) && (paramString2.RUz != null) && (paramString2.RUz.ibT != null) && (Util.isEqual(paramString1, paramString2.Rcp)) && (Util.isEqual(paramString2.RUz.ibT.Id, paramdmz.Id))) {
        Log.w(this.mTag, "the time line online video is already added!");
      }
      for (;;)
      {
        paramString2.setUICallback(paramb);
        com.tencent.mm.plugin.sns.ad.j.l.C(paramString2, true);
        paramString2.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        paramString2.setVideoScaleType(i.e.XYN);
        paramString2.setVideoCallback(new a(paramSnsInfo, paramString2, paraml, paramInt));
        e.hsu().a(paramString2, locald, paramString1);
        AppMethodBeat.o(310979);
        return;
        Log.w(this.mTag, "the time line online video is added, it need to be replaced");
        long l = SystemClock.currentThreadTimeMillis();
        com.tencent.mm.plugin.sns.ad.j.l.W(paramViewGroup);
        paramString2 = e.hsu().jU(paramViewGroup.getContext());
        Log.w(this.mTag, "the time line online video is added, getAvailableVideoView, called: take " + (SystemClock.currentThreadTimeMillis() - l));
        if (com.tencent.mm.plugin.sns.ad.j.l.jl(paramString2))
        {
          paramString2.hsm();
          com.tencent.mm.plugin.sns.ad.j.l.jm(paramString2);
        }
        com.tencent.mm.plugin.sns.ad.j.l.z(paramString2, -1, -1);
        com.tencent.mm.plugin.sns.ad.j.l.b(paramViewGroup, paramString2, -1);
      }
    }
  }
  
  public final void a(int paramInt, SnsTimelineVideoView.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(310985);
    int i = 1;
    if (this.PJQ == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the sns info is null");
      i = 0;
    }
    if (this.QcU == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the media object is null");
      i = 0;
    }
    if (this.mContainer == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the container is null");
      i = 0;
    }
    if (TextUtils.isEmpty(this.Qbe))
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the time line id is empty");
      i = 0;
    }
    if (TextUtils.isEmpty(this.yqW))
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the sns local id is empty");
      i = 0;
    }
    if (this.PYh == null)
    {
      Log.e(this.mTag, "OnlinePlayerHelper:the snsAdStatistic is null");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        a(this.PJQ, this.QcU, this.Qbe, this.mContainer, this.yqW, this.PYh, paramb, paramInt);
      }
      AppMethodBeat.o(310985);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.d
 * JD-Core Version:    0.7.0.1
 */