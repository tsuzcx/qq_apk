package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends OrientationEventListener
{
  a Bvf;
  private int gNO = -1;
  private int orientation = -1;
  private long vNA = 0L;
  private long vNB = 0L;
  private int vNz = -1;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(126096);
    super.enable();
    this.vNB = bt.HI();
    AppMethodBeat.o(126096);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(126095);
    if (bt.aO(this.vNB) < 2000L)
    {
      ad.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(126095);
      return;
    }
    ad.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((Math.abs(this.vNz - paramInt) >= 60) && (bt.aO(this.vNA) >= 1000L))
    {
      this.vNz = paramInt;
      this.vNA = bt.HI();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label147;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.Bvf != null) {
        this.Bvf.nL(this.orientation);
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
    public abstract void nL(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.i
 * JD-Core Version:    0.7.0.1
 */