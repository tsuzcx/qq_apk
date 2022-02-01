package com.tencent.mm.ui.widget.cedit.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static long mV(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  public static <T extends CharSequence> T p(T paramT, int paramInt)
  {
    AppMethodBeat.i(206425);
    b.checkArgument(true);
    if ((TextUtils.isEmpty(paramT)) || (paramT.length() <= 100000))
    {
      AppMethodBeat.o(206425);
      return paramT;
    }
    int i = paramInt;
    if (Character.isHighSurrogate(paramT.charAt(99999)))
    {
      i = paramInt;
      if (Character.isLowSurrogate(paramT.charAt(100000))) {
        i = 99999;
      }
    }
    paramT = paramT.subSequence(0, i);
    AppMethodBeat.o(206425);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.c
 * JD-Core Version:    0.7.0.1
 */