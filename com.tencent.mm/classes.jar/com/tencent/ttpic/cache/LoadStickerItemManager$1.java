package com.tencent.ttpic.cache;

import java.util.Comparator;

final class LoadStickerItemManager$1
  implements Comparator<String>
{
  private int getFrameIndex(String paramString)
  {
    return Integer.parseInt(paramString.substring(paramString.lastIndexOf('_') + 1, paramString.lastIndexOf('.')));
  }
  
  private String getImageName(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf('_'));
  }
  
  public final int compare(String paramString1, String paramString2)
  {
    try
    {
      String str1 = getImageName(paramString1);
      String str2 = getImageName(paramString2);
      if (str1.equals(str2)) {
        return getFrameIndex(paramString1) - getFrameIndex(paramString2);
      }
      int i = str1.compareTo(str2);
      return i;
    }
    catch (Exception paramString1) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager.1
 * JD-Core Version:    0.7.0.1
 */