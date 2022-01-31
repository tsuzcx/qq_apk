package com.tencent.ttpic.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class LoadStickerItemManager$1
  implements Comparator<String>
{
  private int getFrameIndex(String paramString)
  {
    AppMethodBeat.i(81810);
    int i = Integer.parseInt(paramString.substring(paramString.lastIndexOf('_') + 1, paramString.lastIndexOf('.')));
    AppMethodBeat.o(81810);
    return i;
  }
  
  private String getImageName(String paramString)
  {
    AppMethodBeat.i(81809);
    paramString = paramString.substring(0, paramString.lastIndexOf('_'));
    AppMethodBeat.o(81809);
    return paramString;
  }
  
  public final int compare(String paramString1, String paramString2)
  {
    AppMethodBeat.i(81808);
    try
    {
      String str1 = getImageName(paramString1);
      String str2 = getImageName(paramString2);
      if (str1.equals(str2))
      {
        i = getFrameIndex(paramString1);
        int j = getFrameIndex(paramString2);
        AppMethodBeat.o(81808);
        return i - j;
      }
      int i = str1.compareTo(str2);
      AppMethodBeat.o(81808);
      return i;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(81808);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager.1
 * JD-Core Version:    0.7.0.1
 */