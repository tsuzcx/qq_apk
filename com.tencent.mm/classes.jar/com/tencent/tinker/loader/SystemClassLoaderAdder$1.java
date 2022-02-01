package com.tencent.tinker.loader;

import java.io.File;
import java.util.Comparator;
import java.util.Map;

final class SystemClassLoaderAdder$1
  implements Comparator<File>
{
  SystemClassLoaderAdder$1(Map paramMap) {}
  
  public final int compare(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) && (paramFile2 == null)) {
      return 0;
    }
    if (paramFile1 == null) {
      return -1;
    }
    if (paramFile2 == null) {
      return 1;
    }
    paramFile1 = paramFile1.getName();
    paramFile2 = paramFile2.getName();
    if (paramFile1.equals(paramFile2)) {
      return 0;
    }
    if (paramFile1.startsWith("test.dex")) {
      return 1;
    }
    if (paramFile2.startsWith("test.dex")) {
      return -1;
    }
    boolean bool1 = ((Boolean)this.val$matchesClassNPatternMemo.get(paramFile1)).booleanValue();
    boolean bool2 = ((Boolean)this.val$matchesClassNPatternMemo.get(paramFile2)).booleanValue();
    if ((bool1) && (bool2))
    {
      int i = paramFile1.indexOf('.');
      int j = paramFile2.indexOf('.');
      if (i > 7)
      {
        i = Integer.parseInt(paramFile1.substring(7, i));
        if (j <= 7) {
          break label175;
        }
      }
      label175:
      for (j = Integer.parseInt(paramFile2.substring(7, j));; j = 1)
      {
        if (i != j) {
          break label181;
        }
        return 0;
        i = 1;
        break;
      }
      label181:
      if (i < j) {
        return -1;
      }
      return 1;
    }
    if (bool1) {
      return -1;
    }
    if (bool2) {
      return 1;
    }
    return paramFile1.compareTo(paramFile2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder.1
 * JD-Core Version:    0.7.0.1
 */