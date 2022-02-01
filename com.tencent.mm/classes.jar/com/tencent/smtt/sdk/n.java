package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class n
{
  private static n a = null;
  private static Context b = null;
  
  private n()
  {
    AppMethodBeat.i(54048);
    AppMethodBeat.o(54048);
  }
  
  static n a(Context paramContext)
  {
    AppMethodBeat.i(194888);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new n();
      }
      b = paramContext.getApplicationContext();
      paramContext = a;
      AppMethodBeat.o(194888);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(194888);
    }
  }
  
  /* Error */
  private Properties e()
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 47	com/tencent/smtt/sdk/n:a	()Ljava/io/File;
    //   9: astore_1
    //   10: new 49	java/util/Properties
    //   13: dup
    //   14: invokespecial 50	java/util/Properties:<init>	()V
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +109 -> 128
    //   22: new 52	java/io/BufferedInputStream
    //   25: dup
    //   26: new 54	java/io/FileInputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 60	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_1
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 63	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   43: aload_1
    //   44: ifnull +7 -> 51
    //   47: aload_1
    //   48: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   51: ldc 44
    //   53: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_2
    //   57: areturn
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   71: ldc 44
    //   73: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   89: ldc 44
    //   91: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: goto -46 -> 51
    //   100: astore_1
    //   101: goto -30 -> 71
    //   104: astore_2
    //   105: goto -16 -> 89
    //   108: astore_2
    //   109: aload_1
    //   110: astore_3
    //   111: aload_2
    //   112: astore_1
    //   113: aload_3
    //   114: astore_2
    //   115: goto -34 -> 81
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -58 -> 63
    //   124: astore_3
    //   125: goto -62 -> 63
    //   128: aconst_null
    //   129: astore_1
    //   130: goto -87 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	n
    //   9	39	1	localObject1	Object
    //   58	1	1	localException1	Exception
    //   62	6	1	localObject2	Object
    //   78	17	1	localObject3	Object
    //   96	1	1	localIOException1	IOException
    //   100	10	1	localIOException2	IOException
    //   112	1	1	localObject4	Object
    //   118	1	1	localException2	Exception
    //   120	10	1	localObject5	Object
    //   17	69	2	localProperties	Properties
    //   104	1	2	localIOException3	IOException
    //   108	4	2	localObject6	Object
    //   114	1	2	localObject7	Object
    //   110	4	3	localIOException4	IOException
    //   124	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   5	18	58	java/lang/Exception
    //   5	18	78	finally
    //   22	38	78	finally
    //   47	51	96	java/io/IOException
    //   67	71	100	java/io/IOException
    //   85	89	104	java/io/IOException
    //   38	43	108	finally
    //   22	38	118	java/lang/Exception
    //   38	43	124	java/lang/Exception
  }
  
  File a()
  {
    AppMethodBeat.i(194896);
    q.a();
    File localFile = new File(q.t(b), "tbscoreinstall.txt");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      AppMethodBeat.o(194896);
      return localFile;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(194896);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    AppMethodBeat.i(194915);
    a("dexopt_retry_num", paramInt);
    AppMethodBeat.o(194915);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194890);
    a("copy_core_ver", paramInt1);
    a("copy_status", paramInt2);
    AppMethodBeat.o(194890);
  }
  
  void a(String paramString)
  {
    AppMethodBeat.i(194918);
    a("install_apk_path", paramString);
    AppMethodBeat.o(194918);
  }
  
  void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(194939);
    a(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(194939);
  }
  
  /* Error */
  void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 119
    //   7: new 121	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 123
    //   13: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 131
    //   22: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 140	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aconst_null
    //   36: astore 4
    //   38: aload_0
    //   39: invokespecial 142	com/tencent/smtt/sdk/n:e	()Ljava/util/Properties;
    //   42: astore 5
    //   44: aload 4
    //   46: astore_3
    //   47: aload 5
    //   49: ifnull +61 -> 110
    //   52: aload 5
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 146	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   59: pop
    //   60: aload_0
    //   61: invokevirtual 47	com/tencent/smtt/sdk/n:a	()Ljava/io/File;
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload_2
    //   69: ifnull +41 -> 110
    //   72: new 148	java/io/FileOutputStream
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_2
    //   81: aload 5
    //   83: aload_2
    //   84: new 121	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 151
    //   90: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_1
    //   94: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 153
    //   99: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokevirtual 157	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   108: aload_2
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +62 -> 173
    //   114: aload_3
    //   115: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   118: ldc 117
    //   120: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: astore_1
    //   125: ldc 117
    //   127: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: return
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +38 -> 173
    //   138: aload_2
    //   139: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   142: ldc 117
    //   144: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: return
    //   148: astore_1
    //   149: ldc 117
    //   151: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: return
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   166: ldc 117
    //   168: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_1
    //   172: athrow
    //   173: ldc 117
    //   175: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: return
    //   179: astore_2
    //   180: goto -14 -> 166
    //   183: astore_1
    //   184: goto -26 -> 158
    //   187: astore_1
    //   188: goto -54 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	n
    //   0	191	1	paramString1	String
    //   0	191	2	paramString2	String
    //   46	69	3	localObject1	Object
    //   36	30	4	localObject2	Object
    //   42	40	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   114	118	124	java/io/IOException
    //   38	44	131	java/lang/Exception
    //   52	65	131	java/lang/Exception
    //   72	81	131	java/lang/Exception
    //   138	142	148	java/io/IOException
    //   38	44	155	finally
    //   52	65	155	finally
    //   72	81	155	finally
    //   162	166	179	java/io/IOException
    //   81	108	183	finally
    //   81	108	187	java/lang/Exception
  }
  
  int b()
  {
    AppMethodBeat.i(194910);
    int i = c("install_core_ver");
    AppMethodBeat.o(194910);
    return i;
  }
  
  int b(String paramString)
  {
    AppMethodBeat.i(194929);
    try
    {
      Properties localProperties = e();
      if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
      {
        int i = Integer.parseInt(localProperties.getProperty(paramString));
        AppMethodBeat.o(194929);
        return i;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(194929);
    }
    return -1;
  }
  
  void b(int paramInt)
  {
    AppMethodBeat.i(194917);
    a("unzip_retry_num", paramInt);
    AppMethodBeat.o(194917);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194891);
    a("tpatch_ver", paramInt1);
    a("tpatch_status", paramInt2);
    AppMethodBeat.o(194891);
  }
  
  int c()
  {
    AppMethodBeat.i(194913);
    int i = b("install_status");
    AppMethodBeat.o(194913);
    return i;
  }
  
  int c(String paramString)
  {
    AppMethodBeat.i(194942);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      int i = Integer.parseInt(localProperties.getProperty(paramString));
      AppMethodBeat.o(194942);
      return i;
    }
    AppMethodBeat.o(194942);
    return 0;
  }
  
  void c(int paramInt)
  {
    AppMethodBeat.i(194920);
    a("incrupdate_status", paramInt);
    AppMethodBeat.o(194920);
  }
  
  void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194919);
    a("install_core_ver", paramInt1);
    a("install_status", paramInt2);
    AppMethodBeat.o(194919);
  }
  
  int d()
  {
    AppMethodBeat.i(194922);
    int i = b("incrupdate_status");
    AppMethodBeat.o(194922);
    return i;
  }
  
  String d(String paramString)
  {
    AppMethodBeat.i(194946);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      paramString = localProperties.getProperty(paramString);
      AppMethodBeat.o(194946);
      return paramString;
    }
    AppMethodBeat.o(194946);
    return null;
  }
  
  void d(int paramInt)
  {
    AppMethodBeat.i(194924);
    a("unlzma_status", paramInt);
    AppMethodBeat.o(194924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.n
 * JD-Core Version:    0.7.0.1
 */