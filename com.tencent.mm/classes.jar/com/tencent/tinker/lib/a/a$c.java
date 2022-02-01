package com.tencent.tinker.lib.a;

import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class a$c
{
  static void b(ClassLoader paramClassLoader, File paramFile)
  {
    paramFile = paramFile.getPath();
    Field localField = ShareReflectUtil.findField(paramClassLoader, "libPath");
    Object localObject1 = ((String)localField.get(paramClassLoader)).split(":");
    Object localObject2 = new StringBuilder(paramFile);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = localObject1[i];
      if ((localObject3 != null) && (!paramFile.equals(localObject3))) {
        ((StringBuilder)localObject2).append(':').append(localObject3);
      }
      i += 1;
    }
    localField.set(paramClassLoader, ((StringBuilder)localObject2).toString());
    localField = ShareReflectUtil.findField(paramClassLoader, "libraryPathElements");
    localObject1 = (List)localField.get(paramClassLoader);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (paramFile.equals((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    ((List)localObject1).add(0, paramFile);
    localField.set(paramClassLoader, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.lib.a.a.c
 * JD-Core Version:    0.7.0.1
 */