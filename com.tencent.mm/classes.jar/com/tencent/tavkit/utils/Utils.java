package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class Utils
{
  public static boolean isRectValid(CGRect paramCGRect)
  {
    AppMethodBeat.i(213250);
    if ((paramCGRect != null) && (isSizeValid(paramCGRect.size)))
    {
      AppMethodBeat.o(213250);
      return true;
    }
    AppMethodBeat.o(213250);
    return false;
  }
  
  public static boolean isSizeValid(CGSize paramCGSize)
  {
    return (paramCGSize != null) && (paramCGSize.width != 0.0F) && (paramCGSize.height != 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.utils.Utils
 * JD-Core Version:    0.7.0.1
 */