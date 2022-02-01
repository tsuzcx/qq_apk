package com.tencent.mm.plugin.voip.video.camera.prev;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.voip.video.camera.a.c;

public class CaptureView
  extends ObservableSurfaceView
{
  public CaptureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(235866);
    init();
    AppMethodBeat.o(235866);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235867);
    init();
    AppMethodBeat.o(235867);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235868);
    init();
    AppMethodBeat.o(235868);
  }
  
  private void init()
  {
    AppMethodBeat.i(235869);
    if (c.fLj()) {
      setNeedSetType(true);
    }
    AppMethodBeat.o(235869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.CaptureView
 * JD-Core Version:    0.7.0.1
 */