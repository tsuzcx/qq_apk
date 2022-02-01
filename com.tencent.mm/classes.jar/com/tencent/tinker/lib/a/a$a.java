package com.tencent.tinker.lib.a;

import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

final class a$a
{
  private static void b(ClassLoader paramClassLoader, File paramFile)
  {
    paramClassLoader = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
    Field localField = ShareReflectUtil.findField(paramClassLoader, "nativeLibraryDirectories");
    File[] arrayOfFile = (File[])localField.get(paramClassLoader);
    ArrayList localArrayList = new ArrayList(arrayOfFile.length + 1);
    localArrayList.add(paramFile);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if (!paramFile.equals(localFile)) {
        localArrayList.add(localFile);
      }
      i += 1;
    }
    localField.set(paramClassLoader, localArrayList.toArray(new File[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.lib.a.a.a
 * JD-Core Version:    0.7.0.1
 */