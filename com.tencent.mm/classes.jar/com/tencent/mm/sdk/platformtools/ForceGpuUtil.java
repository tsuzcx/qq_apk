package com.tencent.mm.sdk.platformtools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ForceGpuUtil
{
  private static final String TAG = "MicroMsg.ForceGpuUtil";
  public static boolean canGetTextureSize;
  
  static
  {
    AppMethodBeat.i(185116);
    canGetTextureSize = true;
    canGetTextureSize = true;
    setMaxTextureGet(true);
    AppMethodBeat.o(185116);
  }
  
  public static boolean canUseHardwareAcceleration(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157544);
    boolean bool = Help30Impl.getInstance().canUseHardwareAcceleration(paramInt1, paramInt2);
    AppMethodBeat.o(157544);
    return bool;
  }
  
  public static void decideLayerType(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157543);
    if (paramView == null)
    {
      AppMethodBeat.o(157543);
      return;
    }
    Help30Impl.getInstance().decideLayerType(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(157543);
  }
  
  public static int getMaxTextureSize()
  {
    AppMethodBeat.i(230294);
    int i = Help30Impl.getInstance().getMaxTextureSize();
    AppMethodBeat.o(230294);
    return i;
  }
  
  public static void setLayerType(View paramView) {}
  
  public static void setMaxTextureGet(boolean paramBoolean)
  {
    AppMethodBeat.i(157545);
    Log.i("MicroMsg.ForceGpuUtil", "setMaxTextureGet: %s, canGetTextureSize %s.", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(canGetTextureSize) });
    if ((paramBoolean) && (canGetTextureSize)) {
      Help30Impl.getInstance().updateTextureMaxSize();
    }
    AppMethodBeat.o(157545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ForceGpuUtil
 * JD-Core Version:    0.7.0.1
 */