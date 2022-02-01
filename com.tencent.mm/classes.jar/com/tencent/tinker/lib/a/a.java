package com.tencent.tinker.lib.a;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static void a(ClassLoader paramClassLoader, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()))
    {
      ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath, folder %s is illegal", new Object[] { paramFile });
      return;
    }
    if (((Build.VERSION.SDK_INT == 25) && (Build.VERSION.PREVIEW_SDK_INT != 0)) || (Build.VERSION.SDK_INT > 25)) {}
    label365:
    for (;;)
    {
      try
      {
        Object localObject6 = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
        Object localObject1 = (List)ShareReflectUtil.findField(localObject6, "nativeLibraryDirectories").get(localObject6);
        if (localObject1 != null) {
          break label365;
        }
        localObject1 = new ArrayList(2);
        Object localObject4 = ((List)localObject1).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          if (!paramFile.equals((File)((Iterator)localObject4).next())) {
            continue;
          }
          ((Iterator)localObject4).remove();
        }
        ((List)localObject1).add(0, paramFile);
        Object localObject5 = (List)ShareReflectUtil.findField(localObject6, "systemNativeLibraryDirectories").get(localObject6);
        localObject4 = localObject5;
        if (localObject5 == null) {
          localObject4 = new ArrayList(2);
        }
        localObject5 = new ArrayList(((List)localObject1).size() + ((List)localObject4).size() + 1);
        ((List)localObject5).addAll((Collection)localObject1);
        ((List)localObject5).addAll((Collection)localObject4);
        localObject1 = (Object[])ShareReflectUtil.findMethod(localObject6, "makePathElements", new Class[] { List.class }).invoke(localObject6, new Object[] { localObject5 });
        ShareReflectUtil.findField(localObject6, "nativeLibraryPathElements").set(localObject6, localObject1);
        return;
      }
      finally
      {
        ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), localObject2.getMessage() });
        a.b.d(paramClassLoader, paramFile);
        return;
      }
      if (Build.VERSION.SDK_INT >= 23) {
        try
        {
          a.b.d(paramClassLoader, paramFile);
          return;
        }
        finally
        {
          ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), localObject3.getMessage() });
          a.a.c(paramClassLoader, paramFile);
          return;
        }
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        a.a.c(paramClassLoader, paramFile);
        return;
      }
      a.c.b(paramClassLoader, paramFile);
      return;
    }
  }
  
  public static boolean a(ApplicationLike paramApplicationLike, String paramString)
  {
    Object localObject1 = b.d(paramApplicationLike);
    if (ShareTinkerInternals.isNullOrNil((String)localObject1))
    {
      ShareTinkerLog.e("Tinker.LoadLibrary", "failed to get current patch version.", new Object[0]);
      return false;
    }
    File localFile = SharePatchFileUtil.getPatchDirectory(paramApplicationLike.getApplication());
    if (localFile == null)
    {
      ShareTinkerLog.e("Tinker.LoadLibrary", "failed to get current patch directory.", new Object[0]);
      return false;
    }
    localObject1 = new File(localFile.getAbsolutePath() + "/" + SharePatchFileUtil.getPatchVersionDirectory((String)localObject1));
    paramString = new File(((File)localObject1).getAbsolutePath() + "/lib/lib/" + paramString);
    if (!paramString.exists())
    {
      ShareTinkerLog.e("Tinker.LoadLibrary", "tinker lib path [%s] is not exists.", new Object[] { paramString });
      return false;
    }
    paramApplicationLike = paramApplicationLike.getApplication().getClassLoader();
    if (paramApplicationLike == null)
    {
      ShareTinkerLog.e("Tinker.LoadLibrary", "classloader is null", new Object[0]);
      return false;
    }
    ShareTinkerLog.i("Tinker.LoadLibrary", "before hack classloader:" + paramApplicationLike.toString(), new Object[0]);
    try
    {
      localObject1 = a.class.getDeclaredMethod("a", new Class[] { ClassLoader.class, File.class });
      ((Method)localObject1).setAccessible(true);
      ((Method)localObject1).invoke(null, new Object[] { paramApplicationLike, paramString });
      ShareTinkerLog.i("Tinker.LoadLibrary", "after hack classloader:" + paramApplicationLike.toString(), new Object[0]);
      return true;
    }
    finally
    {
      try
      {
        ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath fail:" + paramString + ", thr: " + localObject2, new Object[0]);
        return false;
      }
      finally
      {
        ShareTinkerLog.i("Tinker.LoadLibrary", "after hack classloader:" + paramApplicationLike.toString(), new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.a.a
 * JD-Core Version:    0.7.0.1
 */