package com.tencent.mm.plugin.sns.ui.item.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class b
{
  public static int af(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309066);
    if (paramSnsInfo.isBreakFrameAd())
    {
      AppMethodBeat.o(309066);
      return 32;
    }
    if (paramSnsInfo.isTwistAd())
    {
      AppMethodBeat.o(309066);
      return 28;
    }
    if (paramSnsInfo.isGestureAd())
    {
      AppMethodBeat.o(309066);
      return 29;
    }
    if (paramSnsInfo.isLongPressGestureAd())
    {
      AppMethodBeat.o(309066);
      return 30;
    }
    if (paramSnsInfo.isShakeAd())
    {
      AppMethodBeat.o(309066);
      return 31;
    }
    AppMethodBeat.o(309066);
    return 27;
  }
  
  public static boolean amu(int paramInt)
  {
    return (paramInt == 27) || (paramInt == 28) || (paramInt == 29) || (paramInt == 30) || (paramInt == 31) || (paramInt == 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.b
 * JD-Core Version:    0.7.0.1
 */