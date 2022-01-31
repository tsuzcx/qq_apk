package com.tencent.shadow.core.manager.installplugin;

import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class ODexBloc
{
  private static ConcurrentHashMap<String, Object> sLocks = new ConcurrentHashMap();
  
  public static File oDexPlugin(File paramFile1, File paramFile2, File paramFile3)
  {
    String str = paramFile1.getAbsolutePath();
    Object localObject2 = sLocks.get(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Object();
      sLocks.put(str, localObject1);
    }
    try
    {
      if (paramFile3.exists()) {
        return paramFile2;
      }
      if ((paramFile2.exists()) && (paramFile2.isFile())) {
        throw new InstallPluginException("oDexDir=" + paramFile2.getAbsolutePath() + "已存在，但它是个文件，不敢贸然删除");
      }
    }
    finally {}
    paramFile2.mkdirs();
    new DexClassLoader(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath(), null, ODexBloc.class.getClassLoader());
    try
    {
      paramFile3.createNewFile();
      return paramFile2;
    }
    catch (IOException paramFile1)
    {
      throw new InstallPluginException("oDexPlugin完毕 创建tag文件失败：" + paramFile3.getAbsolutePath(), paramFile1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.ODexBloc
 * JD-Core Version:    0.7.0.1
 */