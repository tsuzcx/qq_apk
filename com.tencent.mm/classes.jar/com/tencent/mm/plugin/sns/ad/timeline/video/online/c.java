package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.e;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public TimeLineObject QcT;
  public dmz QcU;
  private final String mTag;
  public ViewGroup uwW;
  public String yqW;
  
  public c(String paramString)
  {
    AppMethodBeat.i(310960);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoLayoutBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(310960);
  }
  
  public final void CY()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(310972);
    label331:
    label337:
    for (;;)
    {
      ViewGroup localViewGroup;
      String str2;
      try
      {
        if (this.QcU == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the media object is null");
          i = 0;
        }
        if (this.QcT == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the time line object is null");
          i = 0;
        }
        if (this.uwW == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the video container is null");
          i = 0;
        }
        if (!TextUtils.isEmpty(this.yqW)) {
          break label337;
        }
        Log.e(this.mTag, "OnlineVideoLayoutBuilder: the sns local id is empty");
        i = j;
        if (i == 0) {
          break label331;
        }
        dmz localdmz = this.QcU;
        TimeLineObject localTimeLineObject = this.QcT;
        localViewGroup = this.uwW;
        String str1 = this.yqW;
        str2 = localTimeLineObject.Id;
        boolean bool = e.hsu().bbn(str2);
        SnsTimelineVideoView localSnsTimelineVideoView = e.hsu().bbq(str2);
        if (l.X(localViewGroup))
        {
          View localView = localViewGroup.getChildAt(0);
          if (((localView instanceof SnsTimelineVideoView)) && (!Util.isEqual(str2, ((SnsTimelineVideoView)localView).Rcp)))
          {
            Log.w(this.mTag, "the obj id is not equal, remove child!!!!");
            l.W(localViewGroup);
          }
        }
        if (localSnsTimelineVideoView == null)
        {
          Log.w(this.mTag, "the item is  null!!!!");
          if ((localSnsTimelineVideoView != null) && (!l.X(localViewGroup)))
          {
            Log.w(this.mTag, "the videoView is not null, the container is empty");
            l.jm(localSnsTimelineVideoView);
            l.z(localSnsTimelineVideoView, -1, -1);
            l.C(localSnsTimelineVideoView, true);
            localSnsTimelineVideoView.setVideoScaleType(i.e.XYN);
            l.b(localViewGroup, localSnsTimelineVideoView, 0);
            AppMethodBeat.o(310972);
          }
        }
        else
        {
          localSnsTimelineVideoView.a(localdmz, str1, localTimeLineObject.CreateTime);
          continue;
        }
        if (!bool) {
          break label331;
        }
      }
      finally
      {
        AppMethodBeat.o(310972);
        return;
      }
      if ((l.X(localViewGroup)) && (!e.hsu().bbo(str2)))
      {
        Log.w(this.mTag, "the container is not empty, the state is invalid");
        l.W(localViewGroup);
      }
      AppMethodBeat.o(310972);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.c
 * JD-Core Version:    0.7.0.1
 */