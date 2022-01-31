package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.video.ObservableSurfaceView;

public class CaptureView
  extends ObservableSurfaceView
{
  public CaptureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (j.bSC()) {
      setNeedSetType(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.CaptureView
 * JD-Core Version:    0.7.0.1
 */