package com.tencent.manager.c;

import android.os.Environment;
import android.util.Log;
import com.tencent.util.e.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class i
{
  private static Map<String, Boolean> a = new HashMap();
  private static boolean b = false;
  
  public static boolean a(String paramString)
  {
    Log.i("XProxy|UtilMisc", "isTestEnv  pluginid = " + paramString);
    String str = paramString;
    if ("2".equals(paramString)) {
      str = "Live";
    }
    if ((!a.containsKey(str)) || (!((Boolean)a.get(str)).booleanValue()))
    {
      a.put(str, Boolean.valueOf(true));
      b = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + str + "/xproxy.test").exists();
      Log.i("XProxy|UtilMisc", "isTestEnv = " + b + " pluginid = " + str);
    }
    return b;
  }
  
  public static int b(String paramString)
  {
    String str = "";
    Object localObject = paramString;
    if ("2".equals(paramString)) {
      localObject = "Live";
    }
    paramString = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + (String)localObject + "/config.txt");
    if (!paramString.exists()) {
      return 0;
    }
    try
    {
      localObject = new FileInputStream(paramString);
      paramString = str;
      if (localObject != null)
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject));
        paramString = str;
        for (;;)
        {
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (str.startsWith("TargetVersion")) {
            paramString = str.substring(str.lastIndexOf("=") + 1);
          }
        }
        ((FileInputStream)localObject).close();
      }
      int i;
      return 0;
    }
    catch (Exception paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        a.b("XProxy|UtilMisc", "getTargetSdkVersion NumberFormatException, e=" + paramString.toString());
      }
      paramString = paramString;
      a.b("XProxy|UtilMisc", "getTargetSdkVersion error, e=" + paramString.toString());
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.i
 * JD-Core Version:    0.7.0.1
 */