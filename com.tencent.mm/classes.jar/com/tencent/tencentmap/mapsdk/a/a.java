package com.tencent.tencentmap.mapsdk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
{
  protected static String a = null;
  public static boolean b = false;
  private static String c = null;
  private static String d = null;
  private static Boolean e = null;
  private static int f = 0;
  private static String g = "";
  
  public static String a()
  {
    if (!"".equals(g)) {
      return g;
    }
    try
    {
      if (f == 0) {
        f = Process.myPid();
      }
      g = g + f + "_";
      g += new Date().getTime();
    }
    catch (Exception localException)
    {
      label89:
      break label89;
    }
    return g;
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +11 -> 15
    //   7: ldc 29
    //   9: astore_0
    //   10: ldc 2
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: ldc 29
    //   17: astore_2
    //   18: aload_0
    //   19: invokevirtual 88	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   22: astore 5
    //   24: aload_0
    //   25: ldc 90
    //   27: iconst_0
    //   28: invokevirtual 94	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   31: ldc 96
    //   33: ldc 29
    //   35: invokeinterface 102 3 0
    //   40: astore 4
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: ldc 29
    //   49: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +33 -> 85
    //   55: ldc 104
    //   57: astore_3
    //   58: aload_0
    //   59: ldc 90
    //   61: iconst_0
    //   62: invokevirtual 94	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   65: invokeinterface 108 1 0
    //   70: ldc 96
    //   72: ldc 104
    //   74: invokeinterface 114 3 0
    //   79: invokeinterface 118 1 0
    //   84: pop
    //   85: new 54	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 120
    //   91: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 128	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: ldc 29
    //   111: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifne +301 -> 415
    //   117: aload 5
    //   119: aload_3
    //   120: invokevirtual 134	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   123: astore_3
    //   124: aload_3
    //   125: astore 4
    //   127: new 136	java/util/Properties
    //   130: dup
    //   131: invokespecial 137	java/util/Properties:<init>	()V
    //   134: astore 5
    //   136: aload_3
    //   137: astore 4
    //   139: aload 5
    //   141: aload_3
    //   142: invokevirtual 141	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   145: aload_3
    //   146: astore 4
    //   148: aload 5
    //   150: ldc 143
    //   152: ldc 29
    //   154: invokevirtual 146	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 5
    //   159: aload 5
    //   161: astore_2
    //   162: aload_3
    //   163: astore 4
    //   165: new 54	java/lang/StringBuilder
    //   168: dup
    //   169: ldc 148
    //   171: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_2
    //   175: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 128	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_3
    //   189: astore 4
    //   191: ldc 29
    //   193: aload_2
    //   194: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: istore_1
    //   198: iload_1
    //   199: ifne +34 -> 233
    //   202: aload_2
    //   203: astore_0
    //   204: aload_3
    //   205: ifnull -195 -> 10
    //   208: aload_3
    //   209: invokevirtual 153	java/io/InputStream:close	()V
    //   212: aload_2
    //   213: astore_0
    //   214: goto -204 -> 10
    //   217: astore_0
    //   218: aload_0
    //   219: invokestatic 156	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   222: aload_2
    //   223: astore_0
    //   224: goto -214 -> 10
    //   227: astore_0
    //   228: ldc 2
    //   230: monitorexit
    //   231: aload_0
    //   232: athrow
    //   233: aload_2
    //   234: astore 4
    //   236: aload_3
    //   237: ifnull +172 -> 409
    //   240: aload_3
    //   241: invokevirtual 153	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: invokevirtual 160	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   248: aload_0
    //   249: invokevirtual 163	android/content/Context:getPackageName	()Ljava/lang/String;
    //   252: sipush 128
    //   255: invokevirtual 169	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   258: getfield 175	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   261: ldc 177
    //   263: invokevirtual 183	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   266: astore_3
    //   267: aload_2
    //   268: astore_0
    //   269: aload_3
    //   270: ifnull -260 -> 10
    //   273: aload_3
    //   274: invokevirtual 184	java/lang/Object:toString	()Ljava/lang/String;
    //   277: astore_0
    //   278: goto -268 -> 10
    //   281: astore_3
    //   282: aload_3
    //   283: invokestatic 156	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   286: goto -42 -> 244
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_3
    //   293: astore 4
    //   295: aload_0
    //   296: ldc 90
    //   298: iconst_0
    //   299: invokevirtual 94	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   302: invokeinterface 108 1 0
    //   307: ldc 96
    //   309: ldc 29
    //   311: invokeinterface 114 3 0
    //   316: invokeinterface 118 1 0
    //   321: pop
    //   322: aload_3
    //   323: astore 4
    //   325: ldc 186
    //   327: iconst_0
    //   328: anewarray 4	java/lang/Object
    //   331: invokestatic 188	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: aload_2
    //   335: astore 4
    //   337: aload_3
    //   338: ifnull +71 -> 409
    //   341: aload_3
    //   342: invokevirtual 153	java/io/InputStream:close	()V
    //   345: goto -101 -> 244
    //   348: astore_3
    //   349: aload_3
    //   350: invokestatic 156	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   353: goto -109 -> 244
    //   356: astore_0
    //   357: aconst_null
    //   358: astore_2
    //   359: aload_2
    //   360: ifnull +7 -> 367
    //   363: aload_2
    //   364: invokevirtual 153	java/io/InputStream:close	()V
    //   367: aload_0
    //   368: athrow
    //   369: astore_2
    //   370: aload_2
    //   371: invokestatic 156	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   374: goto -7 -> 367
    //   377: astore_0
    //   378: ldc 190
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokestatic 128	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload_2
    //   388: astore_0
    //   389: goto -379 -> 10
    //   392: astore_0
    //   393: aload 4
    //   395: astore_2
    //   396: goto -37 -> 359
    //   399: astore 4
    //   401: goto -109 -> 292
    //   404: astore 4
    //   406: goto -114 -> 292
    //   409: aload 4
    //   411: astore_2
    //   412: goto -168 -> 244
    //   415: aconst_null
    //   416: astore_3
    //   417: goto -184 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	paramContext	Context
    //   197	2	1	bool	boolean
    //   17	347	2	localObject1	Object
    //   369	19	2	localIOException1	java.io.IOException
    //   395	17	2	localObject2	Object
    //   44	230	3	localObject3	Object
    //   281	2	3	localIOException2	java.io.IOException
    //   289	1	3	localException1	Exception
    //   291	51	3	localObject4	Object
    //   348	2	3	localIOException3	java.io.IOException
    //   416	1	3	localObject5	Object
    //   40	354	4	localObject6	Object
    //   399	1	4	localException2	Exception
    //   404	6	4	localException3	Exception
    //   22	138	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   208	212	217	java/io/IOException
    //   18	24	227	finally
    //   208	212	227	finally
    //   218	222	227	finally
    //   240	244	227	finally
    //   244	267	227	finally
    //   273	278	227	finally
    //   282	286	227	finally
    //   341	345	227	finally
    //   349	353	227	finally
    //   363	367	227	finally
    //   367	369	227	finally
    //   370	374	227	finally
    //   378	387	227	finally
    //   240	244	281	java/io/IOException
    //   24	42	289	java/lang/Exception
    //   45	55	289	java/lang/Exception
    //   58	85	289	java/lang/Exception
    //   85	124	289	java/lang/Exception
    //   341	345	348	java/io/IOException
    //   24	42	356	finally
    //   45	55	356	finally
    //   58	85	356	finally
    //   85	124	356	finally
    //   363	367	369	java/io/IOException
    //   244	267	377	java/lang/Throwable
    //   273	278	377	java/lang/Throwable
    //   127	136	392	finally
    //   139	145	392	finally
    //   148	159	392	finally
    //   165	188	392	finally
    //   191	198	392	finally
    //   295	322	392	finally
    //   325	334	392	finally
    //   127	136	399	java/lang/Exception
    //   139	145	399	java/lang/Exception
    //   148	159	399	java/lang/Exception
    //   165	188	404	java/lang/Exception
    //   191	198	404	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", paramString).commit();
  }
  
  public static void a(String paramString)
  {
    try
    {
      a = paramString;
      c localc = c.m();
      if (localc != null) {
        localc.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    try
    {
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == paramInt)
        {
          boolean bool = localRunningAppProcessInfo.processName.split(":")[0].equals(i(paramContext).split(":")[0]);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", paramString).commit();
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        cy.d("context == null return null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        String str2 = paramContext.getSharedPreferences("DENGTA_META", 4).getString("APPKEY_DENGTA", null);
        bool1 = bool3;
        String str1 = df.d();
        if (str2 != null)
        {
          bool1 = bool3;
          if (str2.equals(str1)) {}
        }
        else
        {
          bool3 = true;
          bool2 = true;
          bool1 = bool3;
          paramContext = paramContext.getSharedPreferences("DENGTA_META", 0).edit();
          bool1 = bool3;
          paramContext.putString("APPKEY_DENGTA", str1);
          bool1 = bool3;
          paramContext.commit();
        }
      }
      catch (Exception paramContext)
      {
        cy.b("updateLocalAPPKEY fail!", new Object[0]);
        cy.a(paramContext);
        bool2 = bool1;
      }
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("pid_stat", paramString).commit();
  }
  
  public static boolean c(Context paramContext)
  {
    if (paramContext == null) {
      cy.d("context == null return null", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        String str2 = paramContext.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
        String str1 = j(paramContext);
        if (str2 != null)
        {
          bool = str2.equals(str1);
          if (bool) {}
        }
        else
        {
          bool = true;
          cy.b("updateLocalAPPKEY fail!", new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = paramContext.getSharedPreferences("DENGTA_META", 0).edit();
          paramContext.putString("APPVER_DENGTA", str1);
          paramContext.commit();
          return true;
        }
        catch (Exception paramContext)
        {
          boolean bool;
          break;
        }
        paramContext = paramContext;
        bool = false;
      }
    }
    cy.a(paramContext);
    return bool;
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  private static boolean d(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramString != null)) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label160:
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label160;
        }
        int j = paramContext.length;
        int i = 0;
        if (i >= j) {
          break label160;
        }
        bool2 = paramString.equals(paramContext[i]);
        if (bool2)
        {
          bool1 = bool3;
          cy.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        i += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        cy.a(paramContext);
        return bool1;
      }
      finally
      {
        cy.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
      }
      return false;
    }
  }
  
  public static String e(Context paramContext)
  {
    if (c == null) {
      c = j(paramContext);
    }
    return c;
  }
  
  private static boolean e(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        cy.b("no running proc", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(localObject[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      cy.a(paramContext);
      cy.d("Failed to judge }[%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static boolean f(Context paramContext)
  {
    try
    {
      cy.b("Read phone state permission check! start ", new Object[0]);
      if (e == null) {
        e = Boolean.valueOf(d(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      boolean bool = e.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean g(Context paramContext)
  {
    return e(paramContext, paramContext.getPackageName());
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      if (f == 0) {
        f = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == f)
        {
          int i = localRunningAppProcessInfo.importance;
          return i;
        }
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String i(Context paramContext)
  {
    if (d != null) {
      return d;
    }
    try
    {
      if (f == 0) {
        f = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == f)
        {
          paramContext = localRunningAppProcessInfo.processName;
          d = paramContext;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      cy.a(paramContext);
    }
    return "";
  }
  
  private static String j(Context paramContext)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = null;
    }
    int i;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        m = paramContext.versionCode;
        if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
          continue;
        }
        paramContext = String.valueOf(m);
      }
      catch (Exception paramContext)
      {
        int m;
        cy.a(paramContext);
        cy.d(paramContext.toString(), new Object[0]);
        paramContext = "";
        continue;
      }
      finally {}
      return paramContext;
      localObject = paramContext.getPackageName();
      continue;
      paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
      localObject = paramContext.toCharArray();
      i = 0;
    }
    int k;
    for (int j = 0;; j = k)
    {
      if (i < localObject.length)
      {
        k = j;
        if (localObject[i] == '.') {
          k = j + 1;
        }
      }
      else
      {
        if (j < 3)
        {
          cy.a("add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
        }
        for (;;)
        {
          cy.a("version: %s", new Object[] { paramContext });
          break;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.a
 * JD-Core Version:    0.7.0.1
 */