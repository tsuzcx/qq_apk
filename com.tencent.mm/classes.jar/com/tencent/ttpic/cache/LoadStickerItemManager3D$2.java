package com.tencent.ttpic.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class LoadStickerItemManager3D$2
  implements Comparator<String>
{
  private int getFrameIndex(String paramString)
  {
    AppMethodBeat.i(81822);
    int i = Integer.parseInt(paramString.substring(paramString.lastIndexOf('_') + 1, paramString.lastIndexOf('.')));
    AppMethodBeat.o(81822);
    return i;
  }
  
  private String getImageName(String paramString)
  {
    AppMethodBeat.i(81821);
    paramString = paramString.substring(0, paramString.lastIndexOf('_'));
    AppMethodBeat.o(81821);
    return paramString;
  }
  
  public final int compare(String paramString1, String paramString2)
  {
    AppMethodBeat.i(81820);
    try
    {
      String str1 = getImageName(paramString1);
      String str2 = getImageName(paramString2);
      if (str1.equals(str2))
      {
        i = getFrameIndex(paramString1);
        int j = getFrameIndex(paramString2);
        AppMethodBeat.o(81820);
        return i - j;
      }
      int i = str1.compareTo(str2);
      AppMethodBeat.o(81820);
      return i;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(81820);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager3D.2
 * JD-Core Version:    0.7.0.1
 */