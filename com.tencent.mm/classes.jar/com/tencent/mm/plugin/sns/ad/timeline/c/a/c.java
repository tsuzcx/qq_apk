package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.j;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  private final String mTag;
  public ViewGroup mXH;
  public String qiw;
  public TimeLineObject zrX;
  public bzh zrY;
  
  public c(String paramString)
  {
    AppMethodBeat.i(219162);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoLayoutBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(219162);
  }
  
  public final void layout()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(219163);
    label331:
    label337:
    for (;;)
    {
      ViewGroup localViewGroup;
      String str2;
      try
      {
        if (this.zrY == null)
        {
          ae.e(this.mTag, "OnlineVideoLayoutBuilder: the media object is null");
          i = 0;
        }
        if (this.zrX == null)
        {
          ae.e(this.mTag, "OnlineVideoLayoutBuilder: the time line object is null");
          i = 0;
        }
        if (this.mXH == null)
        {
          ae.e(this.mTag, "OnlineVideoLayoutBuilder: the video container is null");
          i = 0;
        }
        if (!TextUtils.isEmpty(this.qiw)) {
          break label337;
        }
        ae.e(this.mTag, "OnlineVideoLayoutBuilder: the sns local id is empty");
        i = j;
        if (i == 0) {
          break label331;
        }
        bzh localbzh = this.zrY;
        TimeLineObject localTimeLineObject = this.zrX;
        localViewGroup = this.mXH;
        String str1 = this.qiw;
        str2 = localTimeLineObject.Id;
        boolean bool = d.eir().aCy(str2);
        SnsTimelineVideoView localSnsTimelineVideoView = d.eir().aCB(str2);
        if (j.x(localViewGroup))
        {
          View localView = localViewGroup.getChildAt(0);
          if (((localView instanceof SnsTimelineVideoView)) && (!bu.lX(str2, ((SnsTimelineVideoView)localView).ASs)))
          {
            ae.w(this.mTag, "the obj id is not equal, remove child!!!!");
            j.w(localViewGroup);
          }
        }
        if (localSnsTimelineVideoView == null)
        {
          ae.w(this.mTag, "the item is  null!!!!");
          if ((localSnsTimelineVideoView != null) && (!j.x(localViewGroup)))
          {
            ae.w(this.mTag, "the videoView is not null, the container is empty");
            j.eP(localSnsTimelineVideoView);
            j.u(localSnsTimelineVideoView, -1, -1);
            j.t(localSnsTimelineVideoView, true);
            localSnsTimelineVideoView.setVideoScaleType(i.e.Flk);
            j.a(localViewGroup, localSnsTimelineVideoView, 0);
            AppMethodBeat.o(219163);
          }
        }
        else
        {
          localSnsTimelineVideoView.a(localbzh, str1, localTimeLineObject.CreateTime);
          continue;
        }
        if (!bool) {
          break label331;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(219163);
        return;
      }
      if ((j.x(localViewGroup)) && (!d.eir().aCz(str2)))
      {
        ae.w(this.mTag, "the container is not empty, the state is invalid");
        j.w(localViewGroup);
      }
      AppMethodBeat.o(219163);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.c
 * JD-Core Version:    0.7.0.1
 */