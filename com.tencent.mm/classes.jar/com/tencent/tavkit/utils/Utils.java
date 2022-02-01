package com.tencent.tavkit.utils;

import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class Utils
{
  public static boolean isRectValid(CGRect paramCGRect)
  {
    return (paramCGRect != null) && (paramCGRect.size != null) && (paramCGRect.origin != null) && (paramCGRect.size.width != 0.0F) && (paramCGRect.size.height != 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.utils.Utils
 * JD-Core Version:    0.7.0.1
 */