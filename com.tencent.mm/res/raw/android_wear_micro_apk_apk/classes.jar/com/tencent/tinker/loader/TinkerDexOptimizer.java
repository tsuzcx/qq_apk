package com.tencent.tinker.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class TinkerDexOptimizer
{
  public static boolean a(Collection<File> paramCollection, File paramFile, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
  {
    boolean bool2 = true;
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection, new Comparator() {});
    Collections.reverse(paramCollection);
    paramCollection = paramCollection.iterator();
    do
    {
      bool1 = bool2;
      if (!paramCollection.hasNext()) {
        break;
      }
    } while (new TinkerDexOptimizer.OptimizeWorker((File)paramCollection.next(), paramFile, true, paramString, paramResultCallback).oR());
    boolean bool1 = false;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer
 * JD-Core Version:    0.7.0.1
 */