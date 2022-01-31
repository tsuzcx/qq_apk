package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends OrientationEventListener
{
  private int oGO = -1;
  private int oGP = -1;
  private long oGQ = 0L;
  private long oGR = 0L;
  private int orientation = -1;
  i.a tiZ;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(1731);
    super.enable();
    this.oGR = bo.yB();
    AppMethodBeat.o(1731);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(1730);
    if (bo.av(this.oGR) < 2000L)
    {
      ab.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(1730);
      return;
    }
    ab.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((Math.abs(this.oGO - paramInt) >= 60) && (bo.av(this.oGQ) >= 1000L))
    {
      this.oGO = paramInt;
      this.oGQ = bo.yB();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label150;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.tiZ != null) {
        this.tiZ.zr(this.orientation);
      }
      AppMethodBeat.o(1730);
      return;
      label150:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.i
 * JD-Core Version:    0.7.0.1
 */