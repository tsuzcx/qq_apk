package com.tencent.tinker.loader.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k
{
  private static final boolean apZ = ao(System.getProperty("java.vm.version"));
  private static final boolean aqa = pd();
  private static Boolean aqb = null;
  private static String aqc = null;
  private static String aqd = null;
  private static String processName = null;
  
  public static boolean D(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  private static String Q(Context paramContext)
  {
    if (aqc != null) {
      return aqc;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("TINKER_ID");
      if (paramContext != null) {}
      for (aqc = String.valueOf(paramContext);; aqc = null) {
        return aqc;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      Log.e("Tinker.TinkerInternals", "getManifestTinkerID exception:" + paramContext.getMessage());
    }
  }
  
  public static int R(Context paramContext)
  {
    String str = "tinker_own_config_".concat(String.valueOf(V(paramContext)));
    int i = paramContext.getSharedPreferences(str, 0).getInt("safe_mode_count_1.9.13.1", 0);
    Log.w("Tinker.TinkerInternals", "getSafeModeCount: preferName:" + str + " count:" + i);
    return i;
  }
  
  public static boolean S(Context paramContext)
  {
    String str = null;
    Object localObject = paramContext.getApplicationInfo();
    if (localObject != null) {
      str = ((ApplicationInfo)localObject).processName;
    }
    localObject = str;
    if (D(str)) {
      localObject = paramContext.getPackageName();
    }
    str = V(paramContext);
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramContext = "";
    }
    return ((String)localObject).equals(paramContext);
  }
  
  public static boolean T(Context paramContext)
  {
    if (aqb != null) {
      return aqb.booleanValue();
    }
    paramContext = Boolean.valueOf(V(paramContext).endsWith(":patch"));
    aqb = paramContext;
    return paramContext.booleanValue();
  }
  
  public static void U(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if ((localRunningAppProcessInfo.uid == Process.myUid()) && (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))) {
            Process.killProcess(localRunningAppProcessInfo.pid);
          }
        }
      }
    }
  }
  
  public static String V(Context paramContext)
  {
    if (processName != null) {
      return processName;
    }
    paramContext = W(paramContext);
    processName = paramContext;
    return paramContext;
  }
  
  /* Error */
  private static String W(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 228	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +6 -> 15
    //   12: ldc 157
    //   14: areturn
    //   15: aload_0
    //   16: ldc 179
    //   18: invokevirtual 182	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 184	android/app/ActivityManager
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +86 -> 112
    //   29: aload_0
    //   30: invokevirtual 188	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +77 -> 112
    //   38: aload_0
    //   39: invokeinterface 194 1 0
    //   44: astore 4
    //   46: aload 4
    //   48: invokeinterface 199 1 0
    //   53: ifeq +243 -> 296
    //   56: aload 4
    //   58: invokeinterface 203 1 0
    //   63: checkcast 205	android/app/ActivityManager$RunningAppProcessInfo
    //   66: astore_0
    //   67: aload_0
    //   68: getfield 218	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   71: iload_1
    //   72: if_icmpne -26 -> 46
    //   75: aload_0
    //   76: ifnull +36 -> 112
    //   79: aload_0
    //   80: getfield 215	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   83: astore_0
    //   84: aload_0
    //   85: areturn
    //   86: astore_0
    //   87: ldc 91
    //   89: new 93	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 230
    //   95: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 115	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   111: pop
    //   112: sipush 128
    //   115: newarray byte
    //   117: astore 5
    //   119: new 232	java/io/FileInputStream
    //   122: dup
    //   123: new 93	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 234
    //   129: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: iload_1
    //   133: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 236
    //   138: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 237	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   147: astore 4
    //   149: aload 4
    //   151: astore_0
    //   152: aload 4
    //   154: aload 5
    //   156: invokevirtual 241	java/io/FileInputStream:read	([B)I
    //   159: istore_3
    //   160: iload_3
    //   161: ifle +43 -> 204
    //   164: iconst_0
    //   165: istore_1
    //   166: goto +135 -> 301
    //   169: aload 4
    //   171: astore_0
    //   172: new 47	java/lang/String
    //   175: dup
    //   176: aload 5
    //   178: iconst_0
    //   179: iload_2
    //   180: invokespecial 244	java/lang/String:<init>	([BII)V
    //   183: astore 5
    //   185: aload 4
    //   187: invokevirtual 247	java/io/FileInputStream:close	()V
    //   190: aload 5
    //   192: areturn
    //   193: astore_0
    //   194: aload 5
    //   196: areturn
    //   197: iload_1
    //   198: iconst_1
    //   199: iadd
    //   200: istore_1
    //   201: goto +100 -> 301
    //   204: aload 4
    //   206: invokevirtual 247	java/io/FileInputStream:close	()V
    //   209: ldc 157
    //   211: areturn
    //   212: astore 5
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 4
    //   219: astore_0
    //   220: ldc 91
    //   222: new 93	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 230
    //   228: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload 5
    //   233: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 115	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   245: pop
    //   246: aload 4
    //   248: ifnull -39 -> 209
    //   251: aload 4
    //   253: invokevirtual 247	java/io/FileInputStream:close	()V
    //   256: goto -47 -> 209
    //   259: astore_0
    //   260: goto -51 -> 209
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_0
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 247	java/io/FileInputStream:close	()V
    //   275: aload 4
    //   277: athrow
    //   278: astore_0
    //   279: goto -70 -> 209
    //   282: astore_0
    //   283: goto -8 -> 275
    //   286: astore 4
    //   288: goto -21 -> 267
    //   291: astore 5
    //   293: goto -76 -> 217
    //   296: aconst_null
    //   297: astore_0
    //   298: goto -223 -> 75
    //   301: iload_3
    //   302: istore_2
    //   303: iload_1
    //   304: iload_3
    //   305: if_icmpge -136 -> 169
    //   308: aload 5
    //   310: iload_1
    //   311: baload
    //   312: sipush 255
    //   315: iand
    //   316: sipush 128
    //   319: if_icmpgt +10 -> 329
    //   322: aload 5
    //   324: iload_1
    //   325: baload
    //   326: ifgt -129 -> 197
    //   329: iload_1
    //   330: istore_2
    //   331: goto -162 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   3	327	1	i	int
    //   179	152	2	j	int
    //   159	147	3	k	int
    //   44	208	4	localObject1	Object
    //   263	13	4	localObject2	Object
    //   286	1	4	localObject3	Object
    //   117	78	5	localObject4	Object
    //   212	20	5	localException1	Exception
    //   291	32	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   29	34	86	java/lang/Exception
    //   38	46	86	java/lang/Exception
    //   46	75	86	java/lang/Exception
    //   79	84	86	java/lang/Exception
    //   185	190	193	java/lang/Exception
    //   119	149	212	java/lang/Exception
    //   251	256	259	java/lang/Exception
    //   119	149	263	finally
    //   204	209	278	java/lang/Exception
    //   271	275	282	java/lang/Exception
    //   152	160	286	finally
    //   172	185	286	finally
    //   220	246	286	finally
    //   152	160	291	java/lang/Exception
    //   172	185	291	java/lang/Exception
  }
  
  public static int a(Context paramContext, int paramInt, File paramFile, j paramj)
  {
    int i;
    int j;
    if (!paramj.p(paramFile))
    {
      i = -1;
      j = i;
      if (i == 0)
      {
        if (paramInt != 7) {
          break label170;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        paramContext = paramj.oY();
        if ((!cA(paramInt)) && (paramContext.containsKey("assets/dex_meta.txt")))
        {
          j = -9;
          return j;
          paramContext = Q(paramContext);
          if (paramContext == null)
          {
            i = -5;
            break;
          }
          paramFile = paramj.oZ();
          if (paramFile == null)
          {
            i = -2;
            break;
          }
          paramFile = (String)paramFile.get("TINKER_ID");
          if (paramFile == null)
          {
            i = -6;
            break;
          }
          if (!paramContext.equals(paramFile))
          {
            Log.e("Tinker.TinkerInternals", "tinkerId is not equal, base is " + paramContext + ", but patch is " + paramFile);
            i = -7;
            break;
          }
          i = 0;
          break;
          label170:
          i = 0;
          continue;
        }
        if ((!cB(paramInt)) && (paramContext.containsKey("assets/so_meta.txt"))) {
          return -9;
        }
        if ((!cC(paramInt)) && (paramContext.containsKey("assets/res_meta.txt"))) {
          return -9;
        }
      }
    }
    return 0;
  }
  
  public static c a(c paramc, int paramInt)
  {
    if (paramc.apv.startsWith("test.dex"))
    {
      if (paramInt != 1) {}
      for (String str = "classes" + paramInt + ".dex";; str = "classes.dex") {
        return new c(str, paramc.adU, paramc.apw, paramc.apx, paramc.apA, paramc.apy, paramc.apz, paramc.apB);
      }
    }
    return null;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    try
    {
      for (;;)
      {
        Throwable localThrowable = paramThrowable.getCause();
        if (localThrowable == null) {
          break;
        }
        paramThrowable = localThrowable;
      }
      paramThrowable.printStackTrace(localPrintStream);
      paramThrowable = ap(localByteArrayOutputStream.toString());
      return paramThrowable;
    }
    finally
    {
      f.aa(localPrintStream);
    }
  }
  
  public static boolean an(String paramString)
  {
    String str = Build.FINGERPRINT;
    if ((paramString == null) || (paramString.equals("")) || (str == null) || (str.equals("")))
    {
      Log.d("Tinker.TinkerInternals", "fingerprint empty:" + paramString + ",current:" + str);
      return false;
    }
    if (paramString.equals(str))
    {
      Log.d("Tinker.TinkerInternals", "same fingerprint:".concat(String.valueOf(str)));
      return false;
    }
    Log.d("Tinker.TinkerInternals", "system OTA,fingerprint not equal:" + paramString + "," + str);
    return true;
  }
  
  private static boolean ao(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!paramString.matches()) {}
    }
    try
    {
      int i = Integer.parseInt(paramString.group(1));
      int j = Integer.parseInt(paramString.group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j <= 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  private static String ap(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    label66:
    for (;;)
    {
      return paramString;
      char[] arrayOfChar = paramString.toCharArray();
      if (arrayOfChar == null) {
        return null;
      }
      int i = 0;
      if (i < arrayOfChar.length) {
        if (arrayOfChar[i] > '') {
          arrayOfChar[i] = '\000';
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label66;
        }
        return new String(arrayOfChar, 0, i);
        i += 1;
        break;
      }
    }
  }
  
  public static boolean cA(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean cB(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean cC(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean cD(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void j(Context paramContext, int paramInt)
  {
    String str = "tinker_own_config_".concat(String.valueOf(V(paramContext)));
    paramContext.getSharedPreferences(str, 0).edit().putInt("safe_mode_count_1.9.13.1", paramInt).commit();
    Log.w("Tinker.TinkerInternals", "setSafeModeCount: preferName:" + str + " count:" + paramInt);
  }
  
  public static String l(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.equals("changing"))
    {
      if (S(paramContext)) {
        str = "odex";
      }
    }
    else {
      return str;
    }
    return "interpet";
  }
  
  public static boolean pa()
  {
    return (apZ) || (Build.VERSION.SDK_INT >= 21);
  }
  
  public static boolean pb()
  {
    return Build.VERSION.SDK_INT > 25;
  }
  
  public static String pc()
  {
    if (aqd != null) {
      return aqd;
    }
    aqd = (String)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
    Log.d("Tinker.TinkerInternals", "getCurrentInstructionSet:" + aqd);
    return aqd;
  }
  
  private static boolean pd()
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      String str = (String)((Method)localObject).invoke(null, new Object[] { "dalvik.vm.usejit" });
      localObject = (String)((Method)localObject).invoke(null, new Object[] { "dalvik.vm.usejitprofiles" });
      if ((!D(str)) && (D((String)localObject)))
      {
        boolean bool = str.equals("true");
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("Tinker.TinkerInternals", "isVmJitInternal ex:".concat(String.valueOf(localThrowable)));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.k
 * JD-Core Version:    0.7.0.1
 */