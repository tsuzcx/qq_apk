package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends OrientationEventListener
{
  a Gnj;
  private int lastOrientation = -1;
  private int orientation = -1;
  private int ztE = -1;
  private long ztF = 0L;
  private long ztG = 0L;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(126096);
    super.enable();
    this.ztG = Util.currentTicks();
    AppMethodBeat.o(126096);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(126095);
    if (Util.ticksToNow(this.ztG) < 2000L)
    {
      Log.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(126095);
      return;
    }
    Log.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((Math.abs(this.ztE - paramInt) >= 60) && (Util.ticksToNow(this.ztF) >= 1000L))
    {
      this.ztE = paramInt;
      this.ztF = Util.currentTicks();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label147;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.Gnj != null) {
        this.Gnj.onOrientationChange(this.orientation);
      }
      AppMethodBeat.o(126095);
      return;
      label147:
      if ((paramInt >= 30) && (paramInt <= 150))
      {
        if ((paramInt >= 60) && (paramInt <= 120)) {
          this.orientation = 90;
        }
      }
      else if ((paramInt >= 120) && (paramInt <= 240))
      {
        if ((paramInt >= 150) && (paramInt <= 210)) {
          this.orientation = 180;
        }
      }
      else if ((paramInt >= 210) && (paramInt <= 330) && (paramInt >= 240) && (paramInt <= 300)) {
        this.orientation = 270;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onOrientationChange(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.i
 * JD-Core Version:    0.7.0.1
 */