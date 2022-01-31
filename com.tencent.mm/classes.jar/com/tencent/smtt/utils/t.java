package com.tencent.smtt.utils;

import android.content.Context;
import java.io.File;

public class t
{
  private static t e = null;
  public boolean a = false;
  private Context b = null;
  private File c = null;
  private boolean d = false;
  private File f = null;
  
  private t(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    b();
  }
  
  public static t a()
  {
    try
    {
      t localt = e;
      return localt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static t a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new t(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private File d()
  {
    try
    {
      if (this.c == null)
      {
        this.c = new File(this.b.getDir("tbs", 0), "core_private");
        if (this.c == null) {
          break label87;
        }
        if (!this.c.isDirectory()) {
          return null;
        }
      }
      File localFile2 = new File(this.c, "debug.conf");
      localFile1 = localFile2;
      if (!localFile2.exists())
      {
        localFile2.createNewFile();
        localFile1 = localFile2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        File localFile1;
        Object localObject = null;
      }
    }
    return localFile1;
    label87:
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    c();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 33	com/tencent/smtt/utils/t:f	Ljava/io/File;
    //   8: ifnonnull +11 -> 19
    //   11: aload_0
    //   12: aload_0
    //   13: invokespecial 80	com/tencent/smtt/utils/t:d	()Ljava/io/File;
    //   16: putfield 33	com/tencent/smtt/utils/t:f	Ljava/io/File;
    //   19: aload_0
    //   20: getfield 33	com/tencent/smtt/utils/t:f	Ljava/io/File;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnonnull +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: new 82	java/io/BufferedInputStream
    //   34: dup
    //   35: new 84	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: getfield 33	com/tencent/smtt/utils/t:f	Ljava/io/File;
    //   43: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 90	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_1
    //   50: new 92	java/util/Properties
    //   53: dup
    //   54: invokespecial 93	java/util/Properties:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: aload_1
    //   60: invokevirtual 96	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   63: aload_2
    //   64: ldc 98
    //   66: ldc 100
    //   68: invokevirtual 104	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_2
    //   72: ldc 100
    //   74: aload_2
    //   75: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifne +11 -> 89
    //   81: aload_0
    //   82: aload_2
    //   83: invokestatic 116	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   86: putfield 29	com/tencent/smtt/utils/t:a	Z
    //   89: aload_1
    //   90: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   93: goto -65 -> 28
    //   96: astore_1
    //   97: goto -69 -> 28
    //   100: astore_1
    //   101: aload_2
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull -76 -> 28
    //   107: aload_1
    //   108: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   111: goto -83 -> 28
    //   114: astore_1
    //   115: goto -87 -> 28
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: astore_2
    //   137: goto -8 -> 129
    //   140: astore_2
    //   141: aload_1
    //   142: astore_3
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: astore_2
    //   147: goto -26 -> 121
    //   150: astore_2
    //   151: goto -48 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	t
    //   23	67	1	localObject1	Object
    //   96	1	1	localException1	java.lang.Exception
    //   100	1	1	localThrowable1	Throwable
    //   102	6	1	localObject2	Object
    //   114	1	1	localException2	java.lang.Exception
    //   118	12	1	localObject3	Object
    //   131	11	1	localObject4	Object
    //   144	1	1	localObject5	Object
    //   3	123	2	localObject6	Object
    //   136	1	2	localException3	java.lang.Exception
    //   140	4	2	localObject7	Object
    //   146	1	2	localObject8	Object
    //   150	1	2	localThrowable2	Throwable
    //   142	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   89	93	96	java/lang/Exception
    //   4	19	100	java/lang/Throwable
    //   19	24	100	java/lang/Throwable
    //   31	50	100	java/lang/Throwable
    //   107	111	114	java/lang/Exception
    //   4	19	118	finally
    //   19	24	118	finally
    //   31	50	118	finally
    //   89	93	131	finally
    //   107	111	131	finally
    //   125	129	131	finally
    //   129	131	131	finally
    //   125	129	136	java/lang/Exception
    //   50	89	140	finally
    //   50	89	150	java/lang/Throwable
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 80	com/tencent/smtt/utils/t:d	()Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +19 -> 25
    //   9: new 121	java/lang/NullPointerException
    //   12: dup
    //   13: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   16: athrow
    //   17: new 121	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: new 82	java/io/BufferedInputStream
    //   28: dup
    //   29: new 84	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 90	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_2
    //   41: new 92	java/util/Properties
    //   44: dup
    //   45: invokespecial 93	java/util/Properties:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 96	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: ldc 98
    //   57: aload_0
    //   58: getfield 29	com/tencent/smtt/utils/t:a	Z
    //   61: invokestatic 126	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   64: invokevirtual 130	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   67: pop
    //   68: aload_3
    //   69: ldc 132
    //   71: aload_0
    //   72: getfield 31	com/tencent/smtt/utils/t:d	Z
    //   75: invokestatic 126	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   78: invokevirtual 130	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   81: pop
    //   82: new 134	java/io/BufferedOutputStream
    //   85: dup
    //   86: new 136	java/io/FileOutputStream
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 137	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 140	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   97: astore_1
    //   98: aload_3
    //   99: aload_1
    //   100: aconst_null
    //   101: invokevirtual 144	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   104: aload_2
    //   105: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   108: aload_1
    //   109: invokevirtual 145	java/io/BufferedOutputStream:close	()V
    //   112: return
    //   113: astore_1
    //   114: return
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   124: aload_1
    //   125: invokevirtual 145	java/io/BufferedOutputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: return
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   140: aload_2
    //   141: invokevirtual 145	java/io/BufferedOutputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: goto -130 -> 17
    //   150: astore_1
    //   151: return
    //   152: astore_2
    //   153: goto -45 -> 108
    //   156: astore_2
    //   157: goto -33 -> 124
    //   160: astore_3
    //   161: goto -21 -> 140
    //   164: astore_2
    //   165: goto -21 -> 144
    //   168: astore_1
    //   169: aconst_null
    //   170: astore 4
    //   172: aload_2
    //   173: astore_3
    //   174: aload 4
    //   176: astore_2
    //   177: goto -41 -> 136
    //   180: astore 4
    //   182: aload_1
    //   183: astore 5
    //   185: aload_2
    //   186: astore_3
    //   187: aload 4
    //   189: astore_1
    //   190: aload 5
    //   192: astore_2
    //   193: goto -57 -> 136
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -79 -> 120
    //   202: astore_3
    //   203: goto -83 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	t
    //   4	105	1	localObject1	Object
    //   113	1	1	localException1	java.lang.Exception
    //   115	1	1	localThrowable1	Throwable
    //   117	8	1	localObject2	Object
    //   129	1	1	localException2	java.lang.Exception
    //   131	14	1	localObject3	Object
    //   146	1	1	localException3	java.lang.Exception
    //   150	1	1	localException4	java.lang.Exception
    //   168	15	1	localObject4	Object
    //   189	1	1	localObject5	Object
    //   196	1	1	localThrowable2	Throwable
    //   198	1	1	localObject6	Object
    //   40	101	2	localBufferedInputStream	java.io.BufferedInputStream
    //   152	1	2	localException5	java.lang.Exception
    //   156	1	2	localException6	java.lang.Exception
    //   164	9	2	localException7	java.lang.Exception
    //   176	17	2	localObject7	Object
    //   48	89	3	localProperties	java.util.Properties
    //   160	1	3	localException8	java.lang.Exception
    //   173	14	3	localObject8	Object
    //   202	1	3	localThrowable3	Throwable
    //   170	5	4	localObject9	Object
    //   180	8	4	localObject10	Object
    //   183	8	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   108	112	113	java/lang/Exception
    //   0	5	115	java/lang/Throwable
    //   25	41	115	java/lang/Throwable
    //   124	128	129	java/lang/Exception
    //   0	5	131	finally
    //   25	41	131	finally
    //   9	17	146	java/lang/Exception
    //   17	25	150	java/lang/Exception
    //   104	108	152	java/lang/Exception
    //   120	124	156	java/lang/Exception
    //   136	140	160	java/lang/Exception
    //   140	144	164	java/lang/Exception
    //   41	98	168	finally
    //   98	104	180	finally
    //   41	98	196	java/lang/Throwable
    //   98	104	202	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.t
 * JD-Core Version:    0.7.0.1
 */