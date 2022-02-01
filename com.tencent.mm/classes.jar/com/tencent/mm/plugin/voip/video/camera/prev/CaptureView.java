package com.tencent.mm.plugin.voip.video.camera.prev;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.voip.video.camera.a.d;

public class CaptureView
  extends ObservableSurfaceView
{
  public CaptureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(292906);
    init();
    AppMethodBeat.o(292906);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(292908);
    init();
    AppMethodBeat.o(292908);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(292912);
    init();
    AppMethodBeat.o(292912);
  }
  
  private void init()
  {
    AppMethodBeat.i(292917);
    if (d.icD()) {
      setNeedSetType(true);
    }
    AppMethodBeat.o(292917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.CaptureView
 * JD-Core Version:    0.7.0.1
 */