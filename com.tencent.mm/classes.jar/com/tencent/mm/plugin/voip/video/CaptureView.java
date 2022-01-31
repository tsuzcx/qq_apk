package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.video.ObservableSurfaceView;

public class CaptureView
  extends ObservableSurfaceView
{
  public CaptureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5042);
    init();
    AppMethodBeat.o(5042);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5043);
    init();
    AppMethodBeat.o(5043);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(5044);
    init();
    AppMethodBeat.o(5044);
  }
  
  private void init()
  {
    AppMethodBeat.i(5045);
    if (i.cPP()) {
      setNeedSetType(true);
    }
    AppMethodBeat.o(5045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.CaptureView
 * JD-Core Version:    0.7.0.1
 */