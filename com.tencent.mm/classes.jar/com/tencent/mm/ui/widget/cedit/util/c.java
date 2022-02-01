package com.tencent.mm.ui.widget.cedit.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static <T extends CharSequence> T m(T paramT, int paramInt)
  {
    AppMethodBeat.i(252134);
    b.checkArgument(true);
    if ((TextUtils.isEmpty(paramT)) || (paramT.length() <= 100000))
    {
      AppMethodBeat.o(252134);
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
    AppMethodBeat.o(252134);
    return paramT;
  }
  
  public static long oO(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.c
 * JD-Core Version:    0.7.0.1
 */