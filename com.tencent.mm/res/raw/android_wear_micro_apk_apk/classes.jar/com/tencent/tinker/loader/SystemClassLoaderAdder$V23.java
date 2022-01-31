package com.tencent.tinker.loader;

import android.util.Log;
import com.tencent.tinker.loader.a.h;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

final class SystemClassLoaderAdder$V23
{
  private static Object[] c(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
  {
    try
    {
      Method localMethod1 = h.a(paramObject, "makePathElements", new Class[] { List.class, File.class, List.class });
      return (Object[])localMethod1.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        Log.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makePathElements(List,File,List) failure");
        try
        {
          Method localMethod2 = h.a(paramObject, "makePathElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          Log.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
          try
          {
            Log.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: try use v19 instead");
            paramObject = SystemClassLoaderAdder.V19.b(paramObject, paramArrayList, paramFile, paramArrayList1);
            return paramObject;
          }
          catch (NoSuchMethodException paramObject)
          {
            Log.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(List,File,List) failure");
            throw paramObject;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder.V23
 * JD-Core Version:    0.7.0.1
 */