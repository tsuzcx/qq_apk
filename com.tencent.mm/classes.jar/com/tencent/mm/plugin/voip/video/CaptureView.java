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
    AppMethodBeat.i(115565);
    init();
    AppMethodBeat.o(115565);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115566);
    init();
    AppMethodBeat.o(115566);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115567);
    init();
    AppMethodBeat.o(115567);
  }
  
  private void init()
  {
    AppMethodBeat.i(115568);
    if (j.eEq()) {
      setNeedSetType(true);
    }
    AppMethodBeat.o(115568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.CaptureView
 * JD-Core Version:    0.7.0.1
 */