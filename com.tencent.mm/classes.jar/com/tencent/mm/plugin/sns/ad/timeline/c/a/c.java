package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public ViewGroup mSy;
  private final String mTag;
  public String qbR;
  public TimeLineObject zbt;
  public byn zbu;
  
  public c(String paramString)
  {
    AppMethodBeat.i(197690);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoLayoutBuilder";
    }
    this.mTag = str;
    AppMethodBeat.o(197690);
  }
  
  public final void layout()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(197691);
    label331:
    label337:
    for (;;)
    {
      ViewGroup localViewGroup;
      String str2;
      try
      {
        if (this.zbu == null)
        {
          ad.e(this.mTag, "OnlineVideoLayoutBuilder: the media object is null");
          i = 0;
        }
        if (this.zbt == null)
        {
          ad.e(this.mTag, "OnlineVideoLayoutBuilder: the time line object is null");
          i = 0;
        }
        if (this.mSy == null)
        {
          ad.e(this.mTag, "OnlineVideoLayoutBuilder: the video container is null");
          i = 0;
        }
        if (!TextUtils.isEmpty(this.qbR)) {
          break label337;
        }
        ad.e(this.mTag, "OnlineVideoLayoutBuilder: the sns local id is empty");
        i = j;
        if (i == 0) {
          break label331;
        }
        byn localbyn = this.zbu;
        TimeLineObject localTimeLineObject = this.zbt;
        localViewGroup = this.mSy;
        String str1 = this.qbR;
        str2 = localTimeLineObject.Id;
        boolean bool = d.eeK().aBh(str2);
        SnsTimelineVideoView localSnsTimelineVideoView = d.eeK().aBk(str2);
        if (j.x(localViewGroup))
        {
          View localView = localViewGroup.getChildAt(0);
          if (((localView instanceof SnsTimelineVideoView)) && (!bt.lQ(str2, ((SnsTimelineVideoView)localView).AAX)))
          {
            ad.w(this.mTag, "the obj id is not equal, remove child!!!!");
            j.w(localViewGroup);
          }
        }
        if (localSnsTimelineVideoView == null)
        {
          ad.w(this.mTag, "the item is  null!!!!");
          if ((localSnsTimelineVideoView != null) && (!j.x(localViewGroup)))
          {
            ad.w(this.mTag, "the videoView is not null, the container is empty");
            j.eQ(localSnsTimelineVideoView);
            j.v(localSnsTimelineVideoView, -1, -1);
            j.O(localSnsTimelineVideoView, true);
            localSnsTimelineVideoView.setVideoScaleType(i.e.ESP);
            j.a(localViewGroup, localSnsTimelineVideoView, 0);
            AppMethodBeat.o(197691);
          }
        }
        else
        {
          localSnsTimelineVideoView.a(localbyn, str1, localTimeLineObject.CreateTime);
          continue;
        }
        if (!bool) {
          break label331;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(197691);
        return;
      }
      if ((j.x(localViewGroup)) && (!d.eeK().aBi(str2)))
      {
        ad.w(this.mTag, "the container is not empty, the state is invalid");
        j.w(localViewGroup);
      }
      AppMethodBeat.o(197691);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.c
 * JD-Core Version:    0.7.0.1
 */