package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.e;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public TimeLineObject JLk;
  public cvt JLl;
  private final String mTag;
  public ViewGroup rnd;
  public String veZ;
  
  public c(String paramString)
  {
    AppMethodBeat.i(264759);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoLayoutBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(264759);
  }
  
  public final void fP()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(264760);
    label331:
    label337:
    for (;;)
    {
      ViewGroup localViewGroup;
      String str2;
      try
      {
        if (this.JLl == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the media object is null");
          i = 0;
        }
        if (this.JLk == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the time line object is null");
          i = 0;
        }
        if (this.rnd == null)
        {
          Log.e(this.mTag, "OnlineVideoLayoutBuilder: the video container is null");
          i = 0;
        }
        if (!TextUtils.isEmpty(this.veZ)) {
          break label337;
        }
        Log.e(this.mTag, "OnlineVideoLayoutBuilder: the sns local id is empty");
        i = j;
        if (i == 0) {
          break label331;
        }
        cvt localcvt = this.JLl;
        TimeLineObject localTimeLineObject = this.JLk;
        localViewGroup = this.rnd;
        String str1 = this.veZ;
        str2 = localTimeLineObject.Id;
        boolean bool = e.fZg().bcz(str2);
        SnsTimelineVideoView localSnsTimelineVideoView = e.fZg().bcC(str2);
        if (l.N(localViewGroup))
        {
          View localView = localViewGroup.getChildAt(0);
          if (((localView instanceof SnsTimelineVideoView)) && (!Util.isEqual(str2, ((SnsTimelineVideoView)localView).Lrv)))
          {
            Log.w(this.mTag, "the obj id is not equal, remove child!!!!");
            l.M(localViewGroup);
          }
        }
        if (localSnsTimelineVideoView == null)
        {
          Log.w(this.mTag, "the item is  null!!!!");
          if ((localSnsTimelineVideoView != null) && (!l.N(localViewGroup)))
          {
            Log.w(this.mTag, "the videoView is not null, the container is empty");
            l.gj(localSnsTimelineVideoView);
            l.v(localSnsTimelineVideoView, -1, -1);
            l.w(localSnsTimelineVideoView, true);
            localSnsTimelineVideoView.setVideoScaleType(i.e.RcH);
            l.b(localViewGroup, localSnsTimelineVideoView, 0);
            AppMethodBeat.o(264760);
          }
        }
        else
        {
          localSnsTimelineVideoView.a(localcvt, str1, localTimeLineObject.CreateTime);
          continue;
        }
        if (!bool) {
          break label331;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(264760);
        return;
      }
      if ((l.N(localViewGroup)) && (!e.fZg().bcA(str2)))
      {
        Log.w(this.mTag, "the container is not empty, the state is invalid");
        l.M(localViewGroup);
      }
      AppMethodBeat.o(264760);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.c
 * JD-Core Version:    0.7.0.1
 */