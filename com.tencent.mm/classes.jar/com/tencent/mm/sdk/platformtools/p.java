package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  @TargetApi(11)
  public static void cn(View paramView)
  {
    AppMethodBeat.i(52001);
    if (paramView.getLayerType() == 1)
    {
      AppMethodBeat.o(52001);
      return;
    }
    paramView.setLayerType(1, null);
    AppMethodBeat.o(52001);
  }
  
  @TargetApi(11)
  public static void x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52002);
    if ((paramInt1 >= 2048) || (paramInt2 >= 2048)) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      if (paramView.getLayerType() != paramInt1) {
        paramView.setLayerType(paramInt1, null);
      }
      AppMethodBeat.o(52002);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.p
 * JD-Core Version:    0.7.0.1
 */