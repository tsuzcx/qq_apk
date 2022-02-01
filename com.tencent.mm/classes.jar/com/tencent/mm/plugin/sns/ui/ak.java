package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;

public final class ak
{
  public TimeLineObject KCX;
  public WeakReference<View> KGd;
  public String fAg;
  
  public ak(TimeLineObject paramTimeLineObject, View paramView, String paramString)
  {
    AppMethodBeat.i(268032);
    this.KCX = paramTimeLineObject;
    this.KGd = new WeakReference(paramView);
    this.fAg = paramString;
    AppMethodBeat.o(268032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */