package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public TimeLineObject DzU;
  public cnb DzV;
  private final String mTag;
  public ViewGroup okL;
  public String rzs;
  
  public c(String paramString)
  {
    AppMethodBeat.i(202322);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoLayoutBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(202322);
  }
  
  public final void layout()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(202323);
    label331:
    label337:
    for (;;)
    {
      ViewGroup localViewGroup;
      String str2;
      try
      {
        if (this.DzV == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the media object is null");
          i = 0;
        }
        if (this.DzU == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the time line object is null");
          i = 0;
        }
        if (this.okL == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the video container is null");
          i = 0;
        }
        if (!TextUtils.isEmpty(this.rzs)) {
          break label337;
        }
        Log.e(this.mTag, "OnlineVideoLayoutBuilder: the sns local id is empty");
        i = j;
        if (i == 0) {
          break label331;
        }
        cnb localcnb = this.DzV;
        TimeLineObject localTimeLineObject = this.DzU;
        localViewGroup = this.okL;
        String str1 = this.rzs;
        str2 = localTimeLineObject.Id;
        boolean bool = d.fkS().aRu(str2);
        SnsTimelineVideoView localSnsTimelineVideoView = d.fkS().aRx(str2);
        if (m.G(localViewGroup))
        {
          View localView = localViewGroup.getChildAt(0);
          if (((localView instanceof SnsTimelineVideoView)) && (!Util.isEqual(str2, ((SnsTimelineVideoView)localView).FcZ)))
          {
            Log.w(this.mTag, "the obj id is not equal, remove child!!!!");
            m.F(localViewGroup);
          }
        }
        if (localSnsTimelineVideoView == null)
        {
          Log.w(this.mTag, "the item is  null!!!!");
          if ((localSnsTimelineVideoView != null) && (!m.G(localViewGroup)))
          {
            Log.w(this.mTag, "the videoView is not null, the container is empty");
            m.fc(localSnsTimelineVideoView);
            m.u(localSnsTimelineVideoView, -1, -1);
            m.u(localSnsTimelineVideoView, true);
            localSnsTimelineVideoView.setVideoScaleType(i.e.Kcc);
            m.a(localViewGroup, localSnsTimelineVideoView, 0);
            AppMethodBeat.o(202323);
          }
        }
        else
        {
          localSnsTimelineVideoView.a(localcnb, str1, localTimeLineObject.CreateTime);
          continue;
        }
        if (!bool) {
          break label331;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202323);
        return;
      }
      if ((m.G(localViewGroup)) && (!d.fkS().aRv(str2)))
      {
        Log.w(this.mTag, "the container is not empty, the state is invalid");
        m.F(localViewGroup);
      }
      AppMethodBeat.o(202323);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.c
 * JD-Core Version:    0.7.0.1
 */