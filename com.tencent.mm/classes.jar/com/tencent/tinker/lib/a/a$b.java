package com.tencent.tinker.lib.a;

import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class a$b
{
  private static void b(ClassLoader paramClassLoader, File paramFile)
  {
    Object localObject2 = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
    paramClassLoader = (List)ShareReflectUtil.findField(localObject2, "nativeLibraryDirectories").get(localObject2);
    if (paramClassLoader == null) {
      paramClassLoader = new ArrayList(2);
    }
    for (;;)
    {
      Object localObject1 = paramClassLoader.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (paramFile.equals((File)((Iterator)localObject1).next())) {
          ((Iterator)localObject1).remove();
        }
      }
      paramClassLoader.add(0, paramFile);
      localObject1 = (List)ShareReflectUtil.findField(localObject2, "systemNativeLibraryDirectories").get(localObject2);
      paramFile = (File)localObject1;
      if (localObject1 == null) {
        paramFile = new ArrayList(2);
      }
      localObject1 = new ArrayList(paramClassLoader.size() + paramFile.size() + 1);
      ((List)localObject1).addAll(paramClassLoader);
      ((List)localObject1).addAll(paramFile);
      paramClassLoader = (Object[])ShareReflectUtil.findMethod(localObject2, "makePathElements", new Class[] { List.class, File.class, List.class }).invoke(localObject2, new Object[] { localObject1, null, new ArrayList() });
      ShareReflectUtil.findField(localObject2, "nativeLibraryPathElements").set(localObject2, paramClassLoader);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.lib.a.a.b
 * JD-Core Version:    0.7.0.1
 */