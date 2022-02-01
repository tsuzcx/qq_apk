package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
  extends OrientationEventListener
{
  a BMD;
  private int cpv = -1;
  private int orientation = -1;
  private int vZC = -1;
  private long vZD = 0L;
  private long vZE = 0L;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(126096);
    super.enable();
    this.vZE = bu.HQ();
    AppMethodBeat.o(126096);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(126095);
    if (bu.aO(this.vZE) < 2000L)
    {
      ae.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(126095);
      return;
    }
    ae.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((Math.abs(this.vZC - paramInt) >= 60) && (bu.aO(this.vZD) >= 1000L))
    {
      this.vZC = paramInt;
      this.vZD = bu.HQ();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label147;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.BMD != null) {
        this.BMD.nO(this.orientation);
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
    public abstract void nO(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.i
 * JD-Core Version:    0.7.0.1
 */