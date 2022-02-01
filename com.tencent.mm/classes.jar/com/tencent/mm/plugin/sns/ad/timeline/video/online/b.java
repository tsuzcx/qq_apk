package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class b
{
  public TimeLineObject DqS;
  public boolean DzT;
  public ViewGroup mContainer;
  public String mTag;
  
  public b(String paramString)
  {
    AppMethodBeat.i(202321);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoChecker";
    }
    this.mTag = str;
    AppMethodBeat.o(202321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.b
 * JD-Core Version:    0.7.0.1
 */