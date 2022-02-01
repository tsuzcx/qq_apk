package com.tencent.tavkit.utils;

import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class TAVBitmapUtils
{
  public static int readImagePreferRotation(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(219982);
    try
    {
      int j = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (j)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      }
      for (;;)
      {
        AppMethodBeat.o(219982);
        return i;
        i = 3;
        continue;
        i = 2;
      }
      return 0;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(219982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVBitmapUtils
 * JD-Core Version:    0.7.0.1
 */