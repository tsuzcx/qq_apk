package com.tencent.mm.plugin.voip.video.camera.a;

import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends OrientationEventListener
{
  private int KUR;
  private long KUS;
  private a UOh;
  
  public b(a parama)
  {
    super(MMApplicationContext.getContext());
    AppMethodBeat.i(292933);
    this.KUR = -1;
    this.KUS = 0L;
    this.UOh = parama;
    enable();
    AppMethodBeat.o(292933);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(292947);
    if ((paramInt < 0) || (paramInt > 360))
    {
      AppMethodBeat.o(292947);
      return;
    }
    if ((Math.abs(this.KUR - paramInt) >= 30) || (Util.ticksToNow(this.KUS) >= 300L))
    {
      this.KUR = paramInt;
      this.KUS = Util.currentTicks();
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
      if ((paramInt != -1) && (this.UOh != null)) {
        this.UOh.Jd(paramInt);
      }
      AppMethodBeat.o(292947);
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
    AppMethodBeat.i(292938);
    disable();
    this.UOh = null;
    AppMethodBeat.o(292938);
  }
  
  public static abstract interface a
  {
    public abstract void Jd(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.b
 * JD-Core Version:    0.7.0.1
 */