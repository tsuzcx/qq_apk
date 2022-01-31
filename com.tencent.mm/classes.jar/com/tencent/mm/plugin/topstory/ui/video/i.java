package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends OrientationEventListener
{
  private int mgp = -1;
  private int mgq = -1;
  private long mgr = 0L;
  private long mgs = 0L;
  private int orientation = -1;
  i.a pFA;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enable()
  {
    super.enable();
    this.mgs = bk.UZ();
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    if (bk.cp(this.mgs) < 2000L) {
      y.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
    }
    for (;;)
    {
      return;
      y.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[] { Integer.valueOf(paramInt) });
      if ((Math.abs(this.mgp - paramInt) >= 60) && (bk.cp(this.mgr) >= 1000L))
      {
        this.mgp = paramInt;
        this.mgr = bk.UZ();
        if ((paramInt <= 60) || (paramInt >= 300)) {
          if ((paramInt <= 30) || (paramInt >= 330)) {
            this.orientation = 0;
          }
        }
        while (this.pFA != null)
        {
          this.pFA.tX(this.orientation);
          return;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.i
 * JD-Core Version:    0.7.0.1
 */