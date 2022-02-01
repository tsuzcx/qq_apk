package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class p
{
  private static p e = null;
  public boolean a;
  private Context b;
  private File c;
  private boolean d;
  private File f;
  
  private p(Context paramContext)
  {
    AppMethodBeat.i(219371);
    this.b = null;
    this.c = null;
    this.a = false;
    this.d = false;
    this.f = null;
    this.b = paramContext.getApplicationContext();
    b();
    AppMethodBeat.o(219371);
  }
  
  public static p a()
  {
    try
    {
      p localp = e;
      return localp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static p a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(219366);
      if (e == null) {
        e = new p(paramContext);
      }
      paramContext = e;
      AppMethodBeat.o(219366);
      return paramContext;
    }
    finally {}
  }
  
  private File d()
  {
    AppMethodBeat.i(219379);
    try
    {
      if (this.c == null)
      {
        this.c = new File(QbSdk.getTbsFolderDir(this.b), "core_private");
        if (this.c != null)
        {
          boolean bool = this.c.isDirectory();
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(219379);
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
    finally
    {
      for (;;)
      {
        File localFile1;
        Object localObject2 = null;
      }
    }
    AppMethodBeat.o(219379);
    return localFile1;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(219391);
    this.d = paramBoolean;
    c();
    AppMethodBeat.o(219391);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 90
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: getfield 40	com/tencent/smtt/utils/p:f	Ljava/io/File;
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: aload_0
    //   18: invokespecial 92	com/tencent/smtt/utils/p:d	()Ljava/io/File;
    //   21: putfield 40	com/tencent/smtt/utils/p:f	Ljava/io/File;
    //   24: aload_0
    //   25: getfield 40	com/tencent/smtt/utils/p:f	Ljava/io/File;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +11 -> 41
    //   33: ldc 90
    //   35: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new 94	java/io/BufferedInputStream
    //   44: dup
    //   45: new 96	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: getfield 40	com/tencent/smtt/utils/p:f	Ljava/io/File;
    //   53: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 102	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_1
    //   60: new 104	java/util/Properties
    //   63: dup
    //   64: invokespecial 105	java/util/Properties:<init>	()V
    //   67: astore_2
    //   68: aload_2
    //   69: aload_1
    //   70: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_2
    //   74: ldc 110
    //   76: ldc 112
    //   78: invokevirtual 116	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_2
    //   82: ldc 112
    //   84: aload_2
    //   85: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +11 -> 99
    //   91: aload_0
    //   92: aload_2
    //   93: invokestatic 128	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   96: putfield 36	com/tencent/smtt/utils/p:a	Z
    //   99: aload_1
    //   100: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   103: ldc 90
    //   105: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: goto -70 -> 38
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: ldc 90
    //   119: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: goto -84 -> 38
    //   125: astore_1
    //   126: aload_2
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   136: ldc 90
    //   138: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: goto -103 -> 38
    //   144: astore_1
    //   145: ldc 90
    //   147: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -112 -> 38
    //   153: astore_2
    //   154: goto -26 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	p
    //   28	72	1	localObject1	Object
    //   111	4	1	localObject2	Object
    //   116	1	1	localException1	java.lang.Exception
    //   125	1	1	localObject3	Object
    //   127	6	1	localObject4	Object
    //   144	1	1	localException2	java.lang.Exception
    //   8	119	2	localObject5	Object
    //   153	1	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	111	finally
    //   33	38	111	finally
    //   99	103	111	finally
    //   103	108	111	finally
    //   117	122	111	finally
    //   132	136	111	finally
    //   136	141	111	finally
    //   145	150	111	finally
    //   99	103	116	java/lang/Exception
    //   9	24	125	finally
    //   24	29	125	finally
    //   41	60	125	finally
    //   132	136	144	java/lang/Exception
    //   60	99	153	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 92	com/tencent/smtt/utils/p:d	()Ljava/io/File;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +26 -> 37
    //   14: new 134	java/lang/NullPointerException
    //   17: dup
    //   18: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   21: athrow
    //   22: new 134	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: astore_1
    //   31: ldc 132
    //   33: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: new 94	java/io/BufferedInputStream
    //   40: dup
    //   41: new 96	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 102	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: new 104	java/util/Properties
    //   56: dup
    //   57: invokespecial 105	java/util/Properties:<init>	()V
    //   60: astore_3
    //   61: aload_3
    //   62: aload_2
    //   63: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   66: aload_3
    //   67: ldc 110
    //   69: aload_0
    //   70: getfield 36	com/tencent/smtt/utils/p:a	Z
    //   73: invokestatic 139	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   76: invokevirtual 143	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload_3
    //   81: ldc 145
    //   83: aload_0
    //   84: getfield 38	com/tencent/smtt/utils/p:d	Z
    //   87: invokestatic 139	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   90: invokevirtual 143	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   93: pop
    //   94: new 147	java/io/BufferedOutputStream
    //   97: dup
    //   98: new 149	java/io/FileOutputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   109: astore_1
    //   110: aload_3
    //   111: aload_1
    //   112: aconst_null
    //   113: invokevirtual 157	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   120: aload_1
    //   121: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   124: ldc 132
    //   126: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore_1
    //   131: ldc 132
    //   133: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   146: aload_1
    //   147: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   150: ldc 132
    //   152: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: astore_1
    //   157: ldc 132
    //   159: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: astore_1
    //   164: goto -142 -> 22
    //   167: astore_2
    //   168: goto -48 -> 120
    //   171: astore_2
    //   172: goto -26 -> 146
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_1
    //   178: goto -36 -> 142
    //   181: astore_3
    //   182: goto -40 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	p
    //   9	2	1	localFile	File
    //   30	73	1	localException1	java.lang.Exception
    //   109	12	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   130	1	1	localException2	java.lang.Exception
    //   137	1	1	localObject1	Object
    //   139	8	1	localObject2	Object
    //   156	1	1	localException3	java.lang.Exception
    //   163	1	1	localException4	java.lang.Exception
    //   175	1	1	localObject3	Object
    //   177	1	1	localObject4	Object
    //   52	91	2	localBufferedInputStream	java.io.BufferedInputStream
    //   167	1	2	localException5	java.lang.Exception
    //   171	1	2	localException6	java.lang.Exception
    //   60	51	3	localProperties	java.util.Properties
    //   181	1	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   22	30	30	java/lang/Exception
    //   120	124	130	java/lang/Exception
    //   5	10	137	finally
    //   37	53	137	finally
    //   146	150	156	java/lang/Exception
    //   14	22	163	java/lang/Exception
    //   116	120	167	java/lang/Exception
    //   142	146	171	java/lang/Exception
    //   53	110	175	finally
    //   110	116	181	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.p
 * JD-Core Version:    0.7.0.1
 */