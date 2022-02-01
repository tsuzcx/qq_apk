package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class b
{
  public ViewGroup mContainer;
  public String mTag;
  public TimeLineObject zma;
  public boolean zrW;
  
  public b(String paramString)
  {
    AppMethodBeat.i(219161);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "OnlineVideoChecker";
    }
    this.mTag = str;
    AppMethodBeat.o(219161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.b
 * JD-Core Version:    0.7.0.1
 */