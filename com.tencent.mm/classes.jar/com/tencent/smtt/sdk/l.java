package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class l
{
  private static l a = null;
  private static Context b = null;
  
  static l a(Context paramContext)
  {
    AppMethodBeat.i(54095);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new l();
      }
      b = paramContext.getApplicationContext();
      paramContext = a;
      AppMethodBeat.o(54095);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(54095);
    }
  }
  
  /* Error */
  private Properties e()
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 46	com/tencent/smtt/sdk/l:a	()Ljava/io/File;
    //   9: astore_1
    //   10: new 48	java/util/Properties
    //   13: dup
    //   14: invokespecial 49	java/util/Properties:<init>	()V
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +109 -> 128
    //   22: new 51	java/io/BufferedInputStream
    //   25: dup
    //   26: new 53	java/io/FileInputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_1
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 62	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   43: aload_1
    //   44: ifnull +7 -> 51
    //   47: aload_1
    //   48: invokevirtual 65	java/io/BufferedInputStream:close	()V
    //   51: ldc 43
    //   53: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   68: invokevirtual 65	java/io/BufferedInputStream:close	()V
    //   71: ldc 43
    //   73: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 65	java/io/BufferedInputStream:close	()V
    //   89: ldc 43
    //   91: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	133	0	this	l
    //   9	39	1	localObject1	Object
    //   58	1	1	localException1	java.lang.Exception
    //   62	6	1	localObject2	Object
    //   78	17	1	localObject3	Object
    //   96	1	1	localIOException1	IOException
    //   100	10	1	localIOException2	IOException
    //   112	1	1	localObject4	Object
    //   118	1	1	localException2	java.lang.Exception
    //   120	10	1	localObject5	Object
    //   17	69	2	localProperties	Properties
    //   104	1	2	localIOException3	IOException
    //   108	4	2	localObject6	Object
    //   114	1	2	localObject7	Object
    //   110	4	3	localIOException4	IOException
    //   124	1	3	localException3	java.lang.Exception
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
    AppMethodBeat.i(54098);
    o.a();
    File localFile = new File(o.s(b), "tbscoreinstall.txt");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      AppMethodBeat.o(54098);
      return localFile;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(54098);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    AppMethodBeat.i(54102);
    a("dexopt_retry_num", paramInt);
    AppMethodBeat.o(54102);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54096);
    a("copy_core_ver", paramInt1);
    a("copy_status", paramInt2);
    AppMethodBeat.o(54096);
  }
  
  void a(String paramString)
  {
    AppMethodBeat.i(54104);
    a("install_apk_path", paramString);
    AppMethodBeat.o(54104);
  }
  
  void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(54111);
    a(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(54111);
  }
  
  /* Error */
  void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 118
    //   7: new 120	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 122
    //   13: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 130
    //   22: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 139	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aconst_null
    //   36: astore 4
    //   38: aload_0
    //   39: invokespecial 141	com/tencent/smtt/sdk/l:e	()Ljava/util/Properties;
    //   42: astore 5
    //   44: aload 4
    //   46: astore_3
    //   47: aload 5
    //   49: ifnull +61 -> 110
    //   52: aload 5
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 145	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   59: pop
    //   60: aload_0
    //   61: invokevirtual 46	com/tencent/smtt/sdk/l:a	()Ljava/io/File;
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload_2
    //   69: ifnull +41 -> 110
    //   72: new 147	java/io/FileOutputStream
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_2
    //   81: aload 5
    //   83: aload_2
    //   84: new 120	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 150
    //   90: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_1
    //   94: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 152
    //   99: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokevirtual 156	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   108: aload_2
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +62 -> 173
    //   114: aload_3
    //   115: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   118: ldc 116
    //   120: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: astore_1
    //   125: ldc 116
    //   127: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: return
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +38 -> 173
    //   138: aload_2
    //   139: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   142: ldc 116
    //   144: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: return
    //   148: astore_1
    //   149: ldc 116
    //   151: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: return
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   166: ldc 116
    //   168: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_1
    //   172: athrow
    //   173: ldc 116
    //   175: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: return
    //   179: astore_2
    //   180: goto -14 -> 166
    //   183: astore_1
    //   184: goto -26 -> 158
    //   187: astore_1
    //   188: goto -54 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	l
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
    AppMethodBeat.i(54100);
    int i = c("install_core_ver");
    AppMethodBeat.o(54100);
    return i;
  }
  
  int b(String paramString)
  {
    AppMethodBeat.i(54109);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      int i = Integer.parseInt(localProperties.getProperty(paramString));
      AppMethodBeat.o(54109);
      return i;
    }
    AppMethodBeat.o(54109);
    return -1;
  }
  
  void b(int paramInt)
  {
    AppMethodBeat.i(54103);
    a("unzip_retry_num", paramInt);
    AppMethodBeat.o(54103);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54097);
    a("tpatch_ver", paramInt1);
    a("tpatch_status", paramInt2);
    AppMethodBeat.o(54097);
  }
  
  int c()
  {
    AppMethodBeat.i(54101);
    int i = b("install_status");
    AppMethodBeat.o(54101);
    return i;
  }
  
  int c(String paramString)
  {
    AppMethodBeat.i(54112);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      int i = Integer.parseInt(localProperties.getProperty(paramString));
      AppMethodBeat.o(54112);
      return i;
    }
    AppMethodBeat.o(54112);
    return 0;
  }
  
  void c(int paramInt)
  {
    AppMethodBeat.i(54106);
    a("incrupdate_status", paramInt);
    AppMethodBeat.o(54106);
  }
  
  void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54105);
    a("install_core_ver", paramInt1);
    a("install_status", paramInt2);
    AppMethodBeat.o(54105);
  }
  
  int d()
  {
    AppMethodBeat.i(54107);
    int i = b("incrupdate_status");
    AppMethodBeat.o(54107);
    return i;
  }
  
  String d(String paramString)
  {
    AppMethodBeat.i(54113);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      paramString = localProperties.getProperty(paramString);
      AppMethodBeat.o(54113);
      return paramString;
    }
    AppMethodBeat.o(54113);
    return null;
  }
  
  void d(int paramInt)
  {
    AppMethodBeat.i(54108);
    a("unlzma_status", paramInt);
    AppMethodBeat.o(54108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */