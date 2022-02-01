package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends OrientationEventListener
{
  private int EZf = -1;
  private long EZg = 0L;
  private long EZh = 0L;
  private int FO = -1;
  a MZW;
  private int lastOrientation = -1;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(126096);
    super.enable();
    this.EZh = Util.currentTicks();
    AppMethodBeat.o(126096);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(126095);
    if (Util.ticksToNow(this.EZh) < 2000L)
    {
      Log.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(126095);
      return;
    }
    Log.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((Math.abs(this.EZf - paramInt) >= 60) && (Util.ticksToNow(this.EZg) >= 1000L))
    {
      this.EZf = paramInt;
      this.EZg = Util.currentTicks();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label147;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.FO = 0;
      }
    }
    for (;;)
    {
      if (this.MZW != null) {
        this.MZW.onOrientationChange(this.FO);
      }
      AppMethodBeat.o(126095);
      return;
      label147:
      if ((paramInt >= 30) && (paramInt <= 150))
      {
        if ((paramInt >= 60) && (paramInt <= 120)) {
          this.FO = 90;
        }
      }
      else if ((paramInt >= 120) && (paramInt <= 240))
      {
        if ((paramInt >= 150) && (paramInt <= 210)) {
          this.FO = 180;
        }
      }
      else if ((paramInt >= 210) && (paramInt <= 330) && (paramInt >= 240) && (paramInt <= 300)) {
        this.FO = 270;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onOrientationChange(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.i
 * JD-Core Version:    0.7.0.1
 */