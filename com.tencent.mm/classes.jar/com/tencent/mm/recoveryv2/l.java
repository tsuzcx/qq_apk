package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public final class l
{
  static int am(long paramLong, int paramInt)
  {
    AppMethodBeat.i(193887);
    if ((paramLong < -2147483648L) || (paramLong > 2147483647L))
    {
      a.a.log(5, "MicroMsg.recovery.utils", paramLong + " cannot be cast to int without changing its value.");
      AppMethodBeat.o(193887);
      return paramInt;
    }
    paramInt = (int)paramLong;
    AppMethodBeat.o(193887);
    return paramInt;
  }
  
  /* Error */
  private static String bJ(Context paramContext)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 64	android/os/Process:myPid	()I
    //   8: istore_1
    //   9: aload_0
    //   10: ldc 66
    //   12: invokevirtual 72	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 74	android/app/ActivityManager
    //   18: invokevirtual 78	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 81	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload 4
    //   30: invokeinterface 87 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 93 1 0
    //   44: ifeq +58 -> 102
    //   47: aload 4
    //   49: invokeinterface 97 1 0
    //   54: checkcast 99	android/app/ActivityManager$RunningAppProcessInfo
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 103	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   64: iload_1
    //   65: if_icmpne -28 -> 37
    //   68: aload_0
    //   69: aload 5
    //   71: getfield 107	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   74: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -40 -> 37
    //   80: aload 5
    //   82: getfield 107	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: ldc 58
    //   88: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: iconst_5
    //   95: ldc 24
    //   97: ldc 115
    //   99: invokestatic 49	com/tencent/mm/recoveryv2/a$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   102: sipush 128
    //   105: newarray byte
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: new 117	java/io/FileInputStream
    //   115: dup
    //   116: new 26	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 119
    //   122: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: iload_1
    //   126: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 127
    //   131: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 128	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   140: astore_0
    //   141: aload_0
    //   142: aload 5
    //   144: invokevirtual 132	java/io/FileInputStream:read	([B)I
    //   147: istore_3
    //   148: iload_3
    //   149: ifle +40 -> 189
    //   152: iconst_0
    //   153: istore_1
    //   154: goto +117 -> 271
    //   157: new 109	java/lang/String
    //   160: dup
    //   161: aload 5
    //   163: iconst_0
    //   164: iload_2
    //   165: invokespecial 135	java/lang/String:<init>	([BII)V
    //   168: astore 4
    //   170: aload_0
    //   171: invokestatic 139	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   174: ldc 58
    //   176: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 4
    //   181: areturn
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: goto +85 -> 271
    //   189: aload_0
    //   190: invokestatic 139	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   193: ldc 58
    //   195: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: ldc 141
    //   200: areturn
    //   201: astore_0
    //   202: aload 4
    //   204: astore_0
    //   205: iconst_5
    //   206: ldc 24
    //   208: ldc 143
    //   210: invokestatic 49	com/tencent/mm/recoveryv2/a$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokestatic 139	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   217: goto -24 -> 193
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 139	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   229: ldc 58
    //   231: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: athrow
    //   236: astore 4
    //   238: aload_0
    //   239: astore 5
    //   241: aload 4
    //   243: astore_0
    //   244: aload 5
    //   246: astore 4
    //   248: goto -24 -> 224
    //   251: astore 4
    //   253: aload_0
    //   254: astore 5
    //   256: aload 4
    //   258: astore_0
    //   259: aload 5
    //   261: astore 4
    //   263: goto -39 -> 224
    //   266: astore 4
    //   268: goto -63 -> 205
    //   271: iload_3
    //   272: istore_2
    //   273: iload_1
    //   274: iload_3
    //   275: if_icmpge -118 -> 157
    //   278: aload 5
    //   280: iload_1
    //   281: baload
    //   282: ifgt -100 -> 182
    //   285: iload_1
    //   286: istore_2
    //   287: goto -130 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramContext	Context
    //   8	278	1	i	int
    //   164	123	2	j	int
    //   147	129	3	k	int
    //   21	204	4	localObject1	Object
    //   236	6	4	localObject2	Object
    //   246	1	4	localObject3	Object
    //   251	6	4	localObject4	Object
    //   261	1	4	localObject5	Object
    //   266	1	4	localException	java.lang.Exception
    //   57	222	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	37	93	java/lang/Exception
    //   37	86	93	java/lang/Exception
    //   112	141	201	java/lang/Exception
    //   112	141	220	finally
    //   141	148	236	finally
    //   157	170	236	finally
    //   205	213	251	finally
    //   141	148	266	java/lang/Exception
    //   157	170	266	java/lang/Exception
  }
  
  static <T> T checkNotNull(T paramT, String paramString)
  {
    AppMethodBeat.i(193883);
    if (paramT == null)
    {
      paramT = new RuntimeException(String.valueOf(paramString));
      AppMethodBeat.o(193883);
      throw paramT;
    }
    AppMethodBeat.o(193883);
    return paramT;
  }
  
  static boolean cv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(193884);
    if ((bJ(paramContext) != null) && (bJ(paramContext).equals(paramContext.getPackageName() + paramString)))
    {
      AppMethodBeat.o(193884);
      return true;
    }
    AppMethodBeat.o(193884);
    return false;
  }
  
  public static File iU(Context paramContext)
  {
    AppMethodBeat.i(193882);
    paramContext = new File(paramContext.getFilesDir().getParentFile(), "MicroMsg/recovery");
    AppMethodBeat.o(193882);
    return paramContext;
  }
  
  static String iV(Context paramContext)
  {
    AppMethodBeat.i(193886);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        AppMethodBeat.o(193886);
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      a.w("MicroMsg.recovery.utils", "get version name fail", paramContext);
      AppMethodBeat.o(193886);
      return null;
      AppMethodBeat.o(193886);
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label35:
      break label35;
    }
  }
  
  static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(193888);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(193888);
      return false;
    }
    if (paramString.startsWith("-"))
    {
      bool = TextUtils.isDigitsOnly(paramString.substring(1));
      AppMethodBeat.o(193888);
      return bool;
    }
    boolean bool = TextUtils.isDigitsOnly(paramString);
    AppMethodBeat.o(193888);
    return bool;
  }
  
  @SuppressLint({"LongLogTag"})
  public static final class b
  {
    public static boolean M(File paramFile)
    {
      AppMethodBeat.i(193877);
      if (paramFile == null)
      {
        AppMethodBeat.o(193877);
        return false;
      }
      if (paramFile.isDirectory())
      {
        bool = N(paramFile);
        AppMethodBeat.o(193877);
        return bool;
      }
      boolean bool = safeDeleteFile(paramFile);
      AppMethodBeat.o(193877);
      return bool;
    }
    
    private static boolean N(File paramFile)
    {
      int i = 0;
      AppMethodBeat.i(193879);
      if ((paramFile == null) || (!paramFile.exists()))
      {
        AppMethodBeat.o(193879);
        return false;
      }
      if (paramFile.isFile()) {
        safeDeleteFile(paramFile);
      }
      for (;;)
      {
        AppMethodBeat.o(193879);
        return true;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int j = arrayOfFile.length;
            while (i < j)
            {
              N(arrayOfFile[i]);
              i += 1;
            }
            safeDeleteFile(paramFile);
          }
        }
      }
    }
    
    static void O(File paramFile)
    {
      AppMethodBeat.i(193880);
      if (paramFile == null)
      {
        paramFile = new IOException("File is null.");
        AppMethodBeat.o(193880);
        throw paramFile;
      }
      if (paramFile.exists()) {
        M(paramFile);
      }
      File localFile = paramFile.getParentFile();
      if (localFile == null)
      {
        paramFile = new IOException("Can not create parent for current file, path = " + paramFile.getAbsolutePath());
        AppMethodBeat.o(193880);
        throw paramFile;
      }
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      if (!paramFile.createNewFile())
      {
        paramFile = new IOException("Create file fail, file already exists.");
        AppMethodBeat.o(193880);
        throw paramFile;
      }
      AppMethodBeat.o(193880);
    }
    
    public static File[] P(File paramFile)
    {
      AppMethodBeat.i(193881);
      try
      {
        paramFile = paramFile.listFiles();
        if (paramFile != null)
        {
          AppMethodBeat.o(193881);
          return paramFile;
        }
        AppMethodBeat.o(193881);
        return new File[0];
      }
      catch (Throwable paramFile)
      {
        AppMethodBeat.o(193881);
      }
      return new File[0];
    }
    
    @SuppressLint({"NewApi"})
    static void closeQuietly(Object paramObject)
    {
      AppMethodBeat.i(193876);
      if (paramObject == null)
      {
        AppMethodBeat.o(193876);
        return;
      }
      if ((paramObject instanceof Closeable)) {
        try
        {
          ((Closeable)paramObject).close();
          AppMethodBeat.o(193876);
          return;
        }
        catch (Throwable paramObject)
        {
          AppMethodBeat.o(193876);
          return;
        }
      }
      if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
        try
        {
          ((AutoCloseable)paramObject).close();
          AppMethodBeat.o(193876);
          return;
        }
        catch (Throwable paramObject) {}
      }
      AppMethodBeat.o(193876);
    }
    
    private static boolean safeDeleteFile(File paramFile)
    {
      AppMethodBeat.i(193878);
      if (paramFile == null)
      {
        AppMethodBeat.o(193878);
        return true;
      }
      if (paramFile.exists())
      {
        boolean bool = paramFile.delete();
        if (!bool)
        {
          new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(paramFile.getPath());
          paramFile.deleteOnExit();
        }
        AppMethodBeat.o(193878);
        return bool;
      }
      AppMethodBeat.o(193878);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.l
 * JD-Core Version:    0.7.0.1
 */