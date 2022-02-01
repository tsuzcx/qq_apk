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
    AppMethodBeat.i(241216);
    init();
    AppMethodBeat.o(241216);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(241221);
    init();
    AppMethodBeat.o(241221);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(241225);
    init();
    AppMethodBeat.o(241225);
  }
  
  private void init()
  {
    AppMethodBeat.i(241228);
    if (d.gDJ()) {
      setNeedSetType(true);
    }
    AppMethodBeat.o(241228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.CaptureView
 * JD-Core Version:    0.7.0.1
 */