package com.tencent.util;

import android.os.Environment;
import java.io.File;

public class a
{
  public static boolean a()
  {
    return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/now/h5testEnv").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.a
 * JD-Core Version:    0.7.0.1
 */