package com.tencent.mm.plugin.voip.video.camera.a;

import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends OrientationEventListener
{
  private int EZf;
  private long EZg;
  private a Oak;
  
  public b(a parama)
  {
    super(MMApplicationContext.getContext());
    AppMethodBeat.i(239594);
    this.EZf = -1;
    this.EZg = 0L;
    this.Oak = parama;
    enable();
    AppMethodBeat.o(239594);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(239598);
    if ((paramInt < 0) || (paramInt > 360))
    {
      AppMethodBeat.o(239598);
      return;
    }
    if ((Math.abs(this.EZf - paramInt) >= 30) || (Util.ticksToNow(this.EZg) >= 300L))
    {
      this.EZf = paramInt;
      this.EZg = Util.currentTicks();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label118;
      }
      if ((paramInt > 30) && (paramInt < 330)) {
        break label213;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if ((paramInt != -1) && (this.Oak != null)) {
        this.Oak.IA(paramInt);
      }
      AppMethodBeat.o(239598);
      return;
      label118:
      if ((paramInt >= 30) && (paramInt <= 150))
      {
        if ((paramInt >= 60) && (paramInt <= 120)) {
          paramInt = 2;
        }
      }
      else if ((paramInt >= 120) && (paramInt <= 240))
      {
        if ((paramInt >= 150) && (paramInt <= 210)) {
          paramInt = 3;
        }
      }
      else if ((paramInt >= 210) && (paramInt <= 330) && (paramInt >= 240) && (paramInt <= 300))
      {
        paramInt = 4;
        continue;
      }
      label213:
      paramInt = -1;
    }
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(239597);
    disable();
    this.Oak = null;
    AppMethodBeat.o(239597);
  }
  
  public static abstract interface a
  {
    public abstract void IA(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.b
 * JD-Core Version:    0.7.0.1
 */