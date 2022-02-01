package com.tencent.mm.recoveryv2;

import android.app.Application;
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

public final class k$a
{
  static int aL(long paramLong, int paramInt)
  {
    AppMethodBeat.i(238078);
    if ((paramLong < -2147483648L) || (paramLong > 2147483647L))
    {
      k.b.a.log(5, "MicroMsg.recovery.utils", paramLong + " cannot be cast to int without changing its value.");
      AppMethodBeat.o(238078);
      return paramInt;
    }
    paramInt = (int)paramLong;
    AppMethodBeat.o(238078);
    return paramInt;
  }
  
  static <T> T c(T paramT, String paramString)
  {
    AppMethodBeat.i(238052);
    if (paramT == null)
    {
      paramT = new RuntimeException(String.valueOf(paramString));
      AppMethodBeat.o(238052);
      throw paramT;
    }
    AppMethodBeat.o(238052);
    return paramT;
  }
  
  static Application cKQ()
  {
    AppMethodBeat.i(238084);
    if (k.a.a.fgz == null) {
      k.a.a.fgz = k.a.a.getApplication();
    }
    Application localApplication = k.a.a.fgz;
    AppMethodBeat.o(238084);
    return localApplication;
  }
  
  static boolean cQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(238059);
    if ((cv(paramContext) != null) && (cv(paramContext).equals(paramContext.getPackageName() + paramString)))
    {
      AppMethodBeat.o(238059);
      return true;
    }
    AppMethodBeat.o(238059);
    return false;
  }
  
  /* Error */
  private static String cv(Context paramContext)
  {
    // Byte code:
    //   0: ldc 101
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 107	android/os/Process:myPid	()I
    //   8: istore_1
    //   9: aload_0
    //   10: ldc 109
    //   12: invokevirtual 113	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 115	android/app/ActivityManager
    //   18: invokevirtual 119	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 94	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload 4
    //   30: invokeinterface 125 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 131 1 0
    //   44: ifeq +58 -> 102
    //   47: aload 4
    //   49: invokeinterface 135 1 0
    //   54: checkcast 137	android/app/ActivityManager$RunningAppProcessInfo
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 141	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   64: iload_1
    //   65: if_icmpne -28 -> 37
    //   68: aload_0
    //   69: aload 5
    //   71: getfield 145	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   74: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -40 -> 37
    //   80: aload 5
    //   82: getfield 145	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: ldc 101
    //   88: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: iconst_5
    //   95: ldc 27
    //   97: ldc 147
    //   99: invokestatic 52	com/tencent/mm/recoveryv2/k$b$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   102: sipush 128
    //   105: newarray byte
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: new 149	java/io/FileInputStream
    //   115: dup
    //   116: new 29	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 151
    //   122: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: iload_1
    //   126: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 157
    //   131: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   140: astore_0
    //   141: aload_0
    //   142: aload 5
    //   144: invokevirtual 162	java/io/FileInputStream:read	([B)I
    //   147: istore_3
    //   148: iload_3
    //   149: ifle +40 -> 189
    //   152: iconst_0
    //   153: istore_1
    //   154: goto +117 -> 271
    //   157: new 63	java/lang/String
    //   160: dup
    //   161: aload 5
    //   163: iconst_0
    //   164: iload_2
    //   165: invokespecial 165	java/lang/String:<init>	([BII)V
    //   168: astore 4
    //   170: aload_0
    //   171: invokestatic 169	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
    //   174: ldc 101
    //   176: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 4
    //   181: areturn
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: goto +85 -> 271
    //   189: aload_0
    //   190: invokestatic 169	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
    //   193: ldc 101
    //   195: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: ldc 171
    //   200: areturn
    //   201: astore_0
    //   202: aload 4
    //   204: astore_0
    //   205: iconst_5
    //   206: ldc 27
    //   208: ldc 173
    //   210: invokestatic 52	com/tencent/mm/recoveryv2/k$b$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokestatic 169	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
    //   217: goto -24 -> 193
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 169	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
    //   229: ldc 101
    //   231: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(238080);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(238080);
      return false;
    }
    if (paramString.startsWith("-"))
    {
      bool = TextUtils.isDigitsOnly(paramString.substring(1));
      AppMethodBeat.o(238080);
      return bool;
    }
    boolean bool = TextUtils.isDigitsOnly(paramString);
    AppMethodBeat.o(238080);
    return bool;
  }
  
  public static File lX(Context paramContext)
  {
    AppMethodBeat.i(238047);
    paramContext = new File(paramContext.getFilesDir().getParentFile(), "MicroMsg/recovery");
    AppMethodBeat.o(238047);
    return paramContext;
  }
  
  static String lY(Context paramContext)
  {
    AppMethodBeat.i(238075);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        AppMethodBeat.o(238075);
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      k.b.w("MicroMsg.recovery.utils", "get version name fail", paramContext);
      AppMethodBeat.o(238075);
      return null;
      AppMethodBeat.o(238075);
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label35:
      break label35;
    }
  }
  
  public static final class b
  {
    public static boolean I(File paramFile)
    {
      AppMethodBeat.i(238025);
      if (paramFile == null)
      {
        AppMethodBeat.o(238025);
        return false;
      }
      if (paramFile.isDirectory())
      {
        bool = J(paramFile);
        AppMethodBeat.o(238025);
        return bool;
      }
      boolean bool = safeDeleteFile(paramFile);
      AppMethodBeat.o(238025);
      return bool;
    }
    
    private static boolean J(File paramFile)
    {
      int i = 0;
      AppMethodBeat.i(238045);
      if ((paramFile == null) || (!paramFile.exists()))
      {
        AppMethodBeat.o(238045);
        return false;
      }
      if (paramFile.isFile()) {
        safeDeleteFile(paramFile);
      }
      for (;;)
      {
        AppMethodBeat.o(238045);
        return true;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int j = arrayOfFile.length;
            while (i < j)
            {
              J(arrayOfFile[i]);
              i += 1;
            }
            safeDeleteFile(paramFile);
          }
        }
      }
    }
    
    static void K(File paramFile)
    {
      AppMethodBeat.i(238056);
      if (paramFile == null)
      {
        paramFile = new IOException("File is null.");
        AppMethodBeat.o(238056);
        throw paramFile;
      }
      if (paramFile.exists()) {
        I(paramFile);
      }
      File localFile = paramFile.getParentFile();
      if (localFile == null)
      {
        paramFile = new IOException("Can not create parent for current file, path = " + paramFile.getAbsolutePath());
        AppMethodBeat.o(238056);
        throw paramFile;
      }
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      if (!paramFile.createNewFile())
      {
        paramFile = new IOException("Create file fail, file already exists.");
        AppMethodBeat.o(238056);
        throw paramFile;
      }
      AppMethodBeat.o(238056);
    }
    
    public static File[] L(File paramFile)
    {
      AppMethodBeat.i(238066);
      try
      {
        paramFile = paramFile.listFiles();
        if (paramFile != null) {
          return paramFile;
        }
        return new File[0];
      }
      finally
      {
        AppMethodBeat.o(238066);
      }
      return new File[0];
    }
    
    static void closeQuietly(Object paramObject)
    {
      AppMethodBeat.i(238013);
      if (paramObject == null)
      {
        AppMethodBeat.o(238013);
        return;
      }
      if ((paramObject instanceof Closeable)) {
        try
        {
          ((Closeable)paramObject).close();
        }
        finally
        {
          AppMethodBeat.o(238013);
          return;
        }
      }
      if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
        try
        {
          ((AutoCloseable)paramObject).close();
          AppMethodBeat.o(238013);
          return;
        }
        finally {}
      }
      AppMethodBeat.o(238013);
    }
    
    private static boolean safeDeleteFile(File paramFile)
    {
      AppMethodBeat.i(238036);
      if (paramFile == null)
      {
        AppMethodBeat.o(238036);
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
        AppMethodBeat.o(238036);
        return bool;
      }
      AppMethodBeat.o(238036);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.k.a
 * JD-Core Version:    0.7.0.1
 */