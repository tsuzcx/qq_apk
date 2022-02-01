package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class b
{
  public ViewGroup mContainer;
  public String mTag;
  public TimeLineObject yVQ;
  public boolean zbs;
  
  public b(String paramString)
  {
    AppMethodBeat.i(197689);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoChecker";
    }
    this.mTag = str;
    AppMethodBeat.o(197689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.b
 * JD-Core Version:    0.7.0.1
 */