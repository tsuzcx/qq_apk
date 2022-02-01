package a.a.a.a;

import a.a.a.b.h;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b
{
  /* Error */
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 16	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: aload_0
    //   5: invokevirtual 20	android/content/Context:getPackageName	()Ljava/lang/String;
    //   8: sipush 8192
    //   11: invokevirtual 26	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +17 -> 33
    //   19: aload_0
    //   20: getfield 32	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   23: astore 4
    //   25: goto +11 -> 36
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +6 -> 44
    //   41: goto +158 -> 199
    //   44: aload_2
    //   45: astore_0
    //   46: aload_2
    //   47: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   50: invokevirtual 47	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   53: ifne +30 -> 83
    //   56: new 49	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   63: astore_0
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_0
    //   71: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   74: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_0
    //   79: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_0
    //   83: new 38	java/io/File
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 66	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: new 49	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc 68
    //   106: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: invokestatic 71	a/a/a/a/b:b	()Ljava/lang/String;
    //   114: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: ldc 73
    //   121: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_2
    //   126: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 5
    //   131: new 49	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   138: astore_2
    //   139: aload_2
    //   140: ldc 68
    //   142: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_2
    //   147: invokestatic 71	a/a/a/a/b:b	()Ljava/lang/String;
    //   150: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_2
    //   155: ldc 73
    //   157: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: aload_1
    //   163: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: new 75	a/a/a/a/e
    //   175: dup
    //   176: new 38	java/io/File
    //   179: dup
    //   180: aload 4
    //   182: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: aload_1
    //   186: invokespecial 78	a/a/a/a/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   189: astore_2
    //   190: goto +5 -> 195
    //   193: aconst_null
    //   194: astore_2
    //   195: aload_2
    //   196: ifnonnull +8 -> 204
    //   199: aconst_null
    //   200: astore_0
    //   201: goto +254 -> 455
    //   204: aload_2
    //   205: getfield 82	a/a/a/a/e:f	La/a/a/a/d;
    //   208: astore 6
    //   210: aload 6
    //   212: ifnull +229 -> 441
    //   215: aload 6
    //   217: getfield 86	a/a/a/a/d:a	Ljava/lang/String;
    //   220: aload 5
    //   222: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   225: ifeq +216 -> 441
    //   228: aload 6
    //   230: getfield 86	a/a/a/a/d:a	Ljava/lang/String;
    //   233: ldc 92
    //   235: invokevirtual 47	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   238: ifeq +203 -> 441
    //   241: aload 6
    //   243: getfield 86	a/a/a/a/d:a	Ljava/lang/String;
    //   246: astore 4
    //   248: aload 4
    //   250: bipush 47
    //   252: invokevirtual 96	java/lang/String:lastIndexOf	(I)I
    //   255: istore_3
    //   256: aload 4
    //   258: astore_1
    //   259: iload_3
    //   260: iconst_m1
    //   261: if_icmpeq +12 -> 273
    //   264: aload 4
    //   266: iload_3
    //   267: iconst_1
    //   268: iadd
    //   269: invokevirtual 100	java/lang/String:substring	(I)Ljava/lang/String;
    //   272: astore_1
    //   273: new 49	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   280: astore 4
    //   282: aload 4
    //   284: aload_0
    //   285: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 4
    //   291: aload_1
    //   292: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: new 38	java/io/File
    //   299: dup
    //   300: aload 4
    //   302: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   308: astore 5
    //   310: aload 5
    //   312: invokevirtual 103	java/io/File:exists	()Z
    //   315: ifeq +9 -> 324
    //   318: aload 5
    //   320: invokevirtual 106	java/io/File:delete	()Z
    //   323: pop
    //   324: sipush 4096
    //   327: newarray byte
    //   329: astore 4
    //   331: aload_2
    //   332: aload 6
    //   334: invokevirtual 109	a/a/a/a/e:a	(La/a/a/a/d;)Ljava/io/InputStream;
    //   337: astore 6
    //   339: new 111	java/io/FileOutputStream
    //   342: dup
    //   343: aload 5
    //   345: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   348: astore_0
    //   349: aload_0
    //   350: astore_1
    //   351: aload 6
    //   353: aload 4
    //   355: invokevirtual 120	java/io/InputStream:read	([B)I
    //   358: istore_3
    //   359: aload_0
    //   360: astore_1
    //   361: iload_3
    //   362: ifle +44 -> 406
    //   365: aload_0
    //   366: astore_1
    //   367: aload_0
    //   368: aload 4
    //   370: iconst_0
    //   371: iload_3
    //   372: invokevirtual 124	java/io/FileOutputStream:write	([BII)V
    //   375: goto -26 -> 349
    //   378: astore_0
    //   379: goto +48 -> 427
    //   382: astore 4
    //   384: goto +13 -> 397
    //   387: astore_0
    //   388: aconst_null
    //   389: astore_1
    //   390: goto +37 -> 427
    //   393: astore 4
    //   395: aconst_null
    //   396: astore_0
    //   397: aload_0
    //   398: astore_1
    //   399: aload 4
    //   401: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   404: aload_0
    //   405: astore_1
    //   406: aload_1
    //   407: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   410: aload 5
    //   412: astore_0
    //   413: goto +30 -> 443
    //   416: astore_0
    //   417: aload_0
    //   418: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   421: aload 5
    //   423: astore_0
    //   424: goto +19 -> 443
    //   427: aload_1
    //   428: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   431: goto +8 -> 439
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   439: aload_0
    //   440: athrow
    //   441: aconst_null
    //   442: astore_0
    //   443: aload_2
    //   444: invokevirtual 130	a/a/a/a/e:a	()V
    //   447: goto +8 -> 455
    //   450: astore_1
    //   451: aload_1
    //   452: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   455: aload_0
    //   456: invokevirtual 103	java/io/File:exists	()Z
    //   459: ifeq +16 -> 475
    //   462: aload_0
    //   463: invokevirtual 134	java/io/File:length	()J
    //   466: lconst_0
    //   467: lcmp
    //   468: ifgt +5 -> 473
    //   471: aconst_null
    //   472: areturn
    //   473: aload_0
    //   474: areturn
    //   475: aconst_null
    //   476: areturn
    //   477: astore_1
    //   478: goto -285 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	paramContext	Context
    //   0	481	1	paramString1	String
    //   0	481	2	paramString2	String
    //   255	117	3	i	int
    //   23	346	4	localObject1	Object
    //   382	1	4	localException1	Exception
    //   393	7	4	localException2	Exception
    //   129	293	5	localObject2	Object
    //   208	144	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/lang/Exception
    //   19	25	28	java/lang/Exception
    //   351	359	378	finally
    //   367	375	378	finally
    //   399	404	378	finally
    //   351	359	382	java/lang/Exception
    //   367	375	382	java/lang/Exception
    //   331	349	387	finally
    //   331	349	393	java/lang/Exception
    //   406	410	416	java/io/IOException
    //   427	431	434	java/io/IOException
    //   443	447	450	java/io/IOException
    //   172	190	477	java/io/IOException
  }
  
  public static String a()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("armeabi-v7a"))) {
        return "armeabi-v7a";
      }
      if ((str != null) && (str.contains("arm64-v8a"))) {
        return "arm64-v8a";
      }
      if ((str != null) && (str.contains("armeabi"))) {
        return "armeabi";
      }
      return "";
    }
    finally {}
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
      i += 1;
    }
    return new String(arrayOfByte);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInputStream != null)
    {
      if (paramArrayOfByte != null)
      {
        if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= paramArrayOfByte.length))
        {
          int i = paramInt1;
          int j = paramInt2;
          if (paramArrayOfByte.length - paramInt1 < paramInt2) {
            return;
          }
          while (j > 0)
          {
            paramInt1 = paramInputStream.read(paramArrayOfByte, i, j);
            if (paramInt1 >= 0)
            {
              i += paramInt1;
              j -= paramInt1;
            }
            else
            {
              throw new EOFException();
            }
          }
        }
        return;
      }
      throw new NullPointerException("dst == null");
    }
    paramInputStream = new NullPointerException("in == null");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("lib");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".so");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        paramString = paramContext.getFilesDir().getParent();
      }
      catch (Exception paramString)
      {
        Object localObject2;
        boolean bool1;
        continue;
      }
      try
      {
        if ((paramContext instanceof ContextWrapper))
        {
          paramString = ((ContextWrapper)paramContext).getBaseContext();
        }
        else
        {
          paramString = ContextWrapper.class.getDeclaredField("mBase");
          paramString.setAccessible(true);
          paramString = paramString.get(paramContext);
        }
        localObject2 = paramString.getClass();
        localObject2 = ((Class)localObject2).getDeclaredMethod("getDataDirFile", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        paramString = ((File)((Method)localObject2).invoke(paramString, new Object[0])).getAbsolutePath();
      }
      finally
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/.seclib/");
    localObject2 = ((StringBuilder)localObject1).toString();
    try
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append(str);
      localObject1 = new File(paramString.toString());
      if (((File)localObject1).exists())
      {
        paramString = (String)localObject1;
        if (((File)localObject1).length() != 0L) {}
      }
      else
      {
        paramString = a(paramContext, str, (String)localObject2);
      }
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.exists()) {
          if (!h.a(paramString, null))
          {
            paramString.delete();
            bool1 = h.a(a(paramContext, str, (String)localObject2), null);
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      bool1 = bool2;
    }
    if (bool1) {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject2);
        paramContext.append(str);
        System.load(paramContext.toString());
        return true;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return bool1;
  }
  
  public static String b()
  {
    try
    {
      String str = a();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = a(paramContext, paramString);
      localUnsatisfiedLinkError.printStackTrace();
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */