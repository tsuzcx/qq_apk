package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;

public final class ag
{
  public TimeLineObject Ahs;
  public WeakReference<View> AjX;
  public String dqc;
  
  public ag(TimeLineObject paramTimeLineObject, View paramView, String paramString)
  {
    AppMethodBeat.i(219705);
    this.Ahs = paramTimeLineObject;
    this.AjX = new WeakReference(paramView);
    this.dqc = paramString;
    AppMethodBeat.o(219705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */