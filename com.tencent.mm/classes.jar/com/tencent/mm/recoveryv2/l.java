package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
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
import java.lang.reflect.Method;

public final class l
{
  static int aj(long paramLong, int paramInt)
  {
    AppMethodBeat.i(207091);
    if ((paramLong < -2147483648L) || (paramLong > 2147483647L))
    {
      a.a.log(5, "MicroMsg.recovery.utils", paramLong + " cannot be cast to int without changing its value.");
      AppMethodBeat.o(207091);
      return paramInt;
    }
    paramInt = (int)paramLong;
    AppMethodBeat.o(207091);
    return paramInt;
  }
  
  static boolean ca(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207088);
    if ((hW(paramContext) != null) && (hW(paramContext).equals(paramContext.getPackageName() + paramString)))
    {
      AppMethodBeat.o(207088);
      return true;
    }
    AppMethodBeat.o(207088);
    return false;
  }
  
  static <T> T checkNotNull(T paramT, String paramString)
  {
    AppMethodBeat.i(207087);
    if (paramT == null)
    {
      paramT = new RuntimeException(String.valueOf(paramString));
      AppMethodBeat.o(207087);
      throw paramT;
    }
    AppMethodBeat.o(207087);
    return paramT;
  }
  
  public static File hV(Context paramContext)
  {
    AppMethodBeat.i(207086);
    paramContext = new File(paramContext.getFilesDir().getParentFile(), "MicroMsg/recovery");
    AppMethodBeat.o(207086);
    return paramContext;
  }
  
  /* Error */
  private static String hW(Context paramContext)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 112	android/os/Process:myPid	()I
    //   8: istore_1
    //   9: aload_0
    //   10: ldc 114
    //   12: invokevirtual 118	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 120	android/app/ActivityManager
    //   18: invokevirtual 124	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 66	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload 4
    //   30: invokeinterface 130 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 136 1 0
    //   44: ifeq +58 -> 102
    //   47: aload 4
    //   49: invokeinterface 140 1 0
    //   54: checkcast 142	android/app/ActivityManager$RunningAppProcessInfo
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 146	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   64: iload_1
    //   65: if_icmpne -28 -> 37
    //   68: aload_0
    //   69: aload 5
    //   71: getfield 150	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   74: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -40 -> 37
    //   80: aload 5
    //   82: getfield 150	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: ldc 106
    //   88: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: iconst_5
    //   95: ldc 25
    //   97: ldc 152
    //   99: invokestatic 50	com/tencent/mm/recoveryv2/a$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   102: sipush 128
    //   105: newarray byte
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: new 154	java/io/FileInputStream
    //   115: dup
    //   116: new 27	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 156
    //   122: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: iload_1
    //   126: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 162
    //   131: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   140: astore_0
    //   141: aload_0
    //   142: aload 5
    //   144: invokevirtual 167	java/io/FileInputStream:read	([B)I
    //   147: istore_3
    //   148: iload_3
    //   149: ifle +40 -> 189
    //   152: iconst_0
    //   153: istore_1
    //   154: goto +117 -> 271
    //   157: new 68	java/lang/String
    //   160: dup
    //   161: aload 5
    //   163: iconst_0
    //   164: iload_2
    //   165: invokespecial 170	java/lang/String:<init>	([BII)V
    //   168: astore 4
    //   170: aload_0
    //   171: invokestatic 174	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   174: ldc 106
    //   176: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 4
    //   181: areturn
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: goto +85 -> 271
    //   189: aload_0
    //   190: invokestatic 174	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   193: ldc 106
    //   195: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: ldc 176
    //   200: areturn
    //   201: astore_0
    //   202: aload 4
    //   204: astore_0
    //   205: iconst_5
    //   206: ldc 25
    //   208: ldc 178
    //   210: invokestatic 50	com/tencent/mm/recoveryv2/a$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokestatic 174	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   217: goto -24 -> 193
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 174	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   229: ldc 106
    //   231: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   266	1	4	localException	Exception
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
  
  static String hX(Context paramContext)
  {
    AppMethodBeat.i(207090);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        AppMethodBeat.o(207090);
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      a.w("MicroMsg.recovery.utils", "get version name fail", paramContext);
      AppMethodBeat.o(207090);
      return null;
      AppMethodBeat.o(207090);
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
    AppMethodBeat.i(207092);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(207092);
      return false;
    }
    if (paramString.startsWith("-"))
    {
      bool = TextUtils.isDigitsOnly(paramString.substring(1));
      AppMethodBeat.o(207092);
      return bool;
    }
    boolean bool = TextUtils.isDigitsOnly(paramString);
    AppMethodBeat.o(207092);
    return bool;
  }
  
  static final class a
  {
    private static Application HUP;
    
    public static Application fhx()
    {
      AppMethodBeat.i(207078);
      if (HUP == null) {
        HUP = getApplication();
      }
      Application localApplication = HUP;
      AppMethodBeat.o(207078);
      return localApplication;
    }
    
    private static Application getApplication()
    {
      AppMethodBeat.i(207079);
      try
      {
        Object localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
        AppMethodBeat.o(207079);
        return localObject1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            Object localObject2 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            localObject2 = (Application)((Method)localObject2).invoke(null, new Object[0]);
          }
          catch (Exception localException2)
          {
            Object localObject3 = null;
          }
        }
      }
    }
  }
  
  @SuppressLint({"LongLogTag"})
  public static final class b
  {
    public static boolean L(File paramFile)
    {
      AppMethodBeat.i(207081);
      if (paramFile == null)
      {
        AppMethodBeat.o(207081);
        return false;
      }
      if (paramFile.isDirectory())
      {
        bool = M(paramFile);
        AppMethodBeat.o(207081);
        return bool;
      }
      boolean bool = safeDeleteFile(paramFile);
      AppMethodBeat.o(207081);
      return bool;
    }
    
    private static boolean M(File paramFile)
    {
      int i = 0;
      AppMethodBeat.i(207083);
      if ((paramFile == null) || (!paramFile.exists()))
      {
        AppMethodBeat.o(207083);
        return false;
      }
      if (paramFile.isFile()) {
        safeDeleteFile(paramFile);
      }
      for (;;)
      {
        AppMethodBeat.o(207083);
        return true;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int j = arrayOfFile.length;
            while (i < j)
            {
              M(arrayOfFile[i]);
              i += 1;
            }
            safeDeleteFile(paramFile);
          }
        }
      }
    }
    
    static void N(File paramFile)
    {
      AppMethodBeat.i(207084);
      if (paramFile == null)
      {
        paramFile = new IOException("File is null.");
        AppMethodBeat.o(207084);
        throw paramFile;
      }
      if (paramFile.exists()) {
        L(paramFile);
      }
      File localFile = paramFile.getParentFile();
      if (localFile == null)
      {
        paramFile = new IOException("Can not create parent for current file, path = " + paramFile.getAbsolutePath());
        AppMethodBeat.o(207084);
        throw paramFile;
      }
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      if (!paramFile.createNewFile())
      {
        paramFile = new IOException("Create file fail, file already exists.");
        AppMethodBeat.o(207084);
        throw paramFile;
      }
      AppMethodBeat.o(207084);
    }
    
    public static File[] O(File paramFile)
    {
      AppMethodBeat.i(207085);
      try
      {
        paramFile = paramFile.listFiles();
        AppMethodBeat.o(207085);
        return paramFile;
      }
      catch (Throwable paramFile)
      {
        AppMethodBeat.o(207085);
      }
      return new File[0];
    }
    
    @SuppressLint({"NewApi"})
    static void closeQuietly(Object paramObject)
    {
      AppMethodBeat.i(207080);
      if (paramObject == null)
      {
        AppMethodBeat.o(207080);
        return;
      }
      if ((paramObject instanceof Closeable)) {
        try
        {
          ((Closeable)paramObject).close();
          AppMethodBeat.o(207080);
          return;
        }
        catch (Throwable paramObject)
        {
          AppMethodBeat.o(207080);
          return;
        }
      }
      if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
        try
        {
          ((AutoCloseable)paramObject).close();
          AppMethodBeat.o(207080);
          return;
        }
        catch (Throwable paramObject) {}
      }
      AppMethodBeat.o(207080);
    }
    
    private static boolean safeDeleteFile(File paramFile)
    {
      AppMethodBeat.i(207082);
      if (paramFile == null)
      {
        AppMethodBeat.o(207082);
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
        AppMethodBeat.o(207082);
        return bool;
      }
      AppMethodBeat.o(207082);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.l
 * JD-Core Version:    0.7.0.1
 */