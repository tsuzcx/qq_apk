package com.tencent.manager.c;

import com.tencent.util.e.a;
import java.io.File;

public class h
{
  public static void a(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      boolean bool = paramFile.delete();
      a.a("NowPluginManager", "deleteDir res = " + bool);
      return;
    }
    int i = 0;
    label46:
    if (i < arrayOfFile.length)
    {
      if ((arrayOfFile[i] == null) || (!arrayOfFile[i].isFile())) {
        break label81;
      }
      arrayOfFile[i].delete();
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      label81:
      if ((arrayOfFile[i] != null) && (arrayOfFile[i].isDirectory())) {
        a(arrayOfFile[i]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.h
 * JD-Core Version:    0.7.0.1
 */