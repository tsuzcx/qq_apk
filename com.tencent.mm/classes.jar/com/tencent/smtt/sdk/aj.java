package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class aj
{
  private static aj a = null;
  private static Context b = null;
  
  static aj a(Context paramContext)
  {
    AppMethodBeat.i(139232);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aj();
      }
      b = paramContext.getApplicationContext();
      paramContext = a;
      AppMethodBeat.o(139232);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(139232);
    }
  }
  
  /* Error */
  private Properties e()
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 46	com/tencent/smtt/sdk/aj:a	()Ljava/io/File;
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
    //   0	133	0	this	aj
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
    AppMethodBeat.i(139235);
    ao.a();
    File localFile = new File(ao.s(b), "tbscoreinstall.txt");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      AppMethodBeat.o(139235);
      return localFile;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(139235);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    AppMethodBeat.i(139239);
    a("dexopt_retry_num", paramInt);
    AppMethodBeat.o(139239);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139233);
    a("copy_core_ver", paramInt1);
    a("copy_status", paramInt2);
    AppMethodBeat.o(139233);
  }
  
  void a(String paramString)
  {
    AppMethodBeat.i(139241);
    a("install_apk_path", paramString);
    AppMethodBeat.o(139241);
  }
  
  void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(139248);
    a(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(139248);
  }
  
  /* Error */
  void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: invokespecial 118	com/tencent/smtt/sdk/aj:e	()Ljava/util/Properties;
    //   12: astore 5
    //   14: aload 4
    //   16: astore_3
    //   17: aload 5
    //   19: ifnull +61 -> 80
    //   22: aload 5
    //   24: aload_1
    //   25: aload_2
    //   26: invokevirtual 122	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   29: pop
    //   30: aload_0
    //   31: invokevirtual 46	com/tencent/smtt/sdk/aj:a	()Ljava/io/File;
    //   34: astore_2
    //   35: aload 4
    //   37: astore_3
    //   38: aload_2
    //   39: ifnull +41 -> 80
    //   42: new 124	java/io/FileOutputStream
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_2
    //   51: aload 5
    //   53: aload_2
    //   54: new 127	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 129
    //   60: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 137
    //   69: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 145	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   78: aload_2
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +62 -> 143
    //   84: aload_3
    //   85: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   88: ldc 116
    //   90: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: astore_1
    //   95: ldc 116
    //   97: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +38 -> 143
    //   108: aload_2
    //   109: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   112: ldc 116
    //   114: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: astore_1
    //   119: ldc 116
    //   121: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   136: ldc 116
    //   138: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: ldc 116
    //   145: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: astore_2
    //   150: goto -14 -> 136
    //   153: astore_1
    //   154: goto -26 -> 128
    //   157: astore_1
    //   158: goto -54 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	aj
    //   0	161	1	paramString1	String
    //   0	161	2	paramString2	String
    //   16	69	3	localObject1	Object
    //   6	30	4	localObject2	Object
    //   12	40	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   84	88	94	java/io/IOException
    //   8	14	101	java/lang/Exception
    //   22	35	101	java/lang/Exception
    //   42	51	101	java/lang/Exception
    //   108	112	118	java/io/IOException
    //   8	14	125	finally
    //   22	35	125	finally
    //   42	51	125	finally
    //   132	136	149	java/io/IOException
    //   51	78	153	finally
    //   51	78	157	java/lang/Exception
  }
  
  int b()
  {
    AppMethodBeat.i(139237);
    int i = c("install_core_ver");
    AppMethodBeat.o(139237);
    return i;
  }
  
  int b(String paramString)
  {
    AppMethodBeat.i(139246);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      int i = Integer.parseInt(localProperties.getProperty(paramString));
      AppMethodBeat.o(139246);
      return i;
    }
    AppMethodBeat.o(139246);
    return -1;
  }
  
  void b(int paramInt)
  {
    AppMethodBeat.i(139240);
    a("unzip_retry_num", paramInt);
    AppMethodBeat.o(139240);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139234);
    a("tpatch_ver", paramInt1);
    a("tpatch_status", paramInt2);
    AppMethodBeat.o(139234);
  }
  
  int c()
  {
    AppMethodBeat.i(139238);
    int i = b("install_status");
    AppMethodBeat.o(139238);
    return i;
  }
  
  int c(String paramString)
  {
    AppMethodBeat.i(139249);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      int i = Integer.parseInt(localProperties.getProperty(paramString));
      AppMethodBeat.o(139249);
      return i;
    }
    AppMethodBeat.o(139249);
    return 0;
  }
  
  void c(int paramInt)
  {
    AppMethodBeat.i(139243);
    a("incrupdate_status", paramInt);
    AppMethodBeat.o(139243);
  }
  
  void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139242);
    a("install_core_ver", paramInt1);
    a("install_status", paramInt2);
    AppMethodBeat.o(139242);
  }
  
  int d()
  {
    AppMethodBeat.i(139244);
    int i = b("incrupdate_status");
    AppMethodBeat.o(139244);
    return i;
  }
  
  String d(String paramString)
  {
    AppMethodBeat.i(139250);
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null))
    {
      paramString = localProperties.getProperty(paramString);
      AppMethodBeat.o(139250);
      return paramString;
    }
    AppMethodBeat.o(139250);
    return null;
  }
  
  void d(int paramInt)
  {
    AppMethodBeat.i(139245);
    a("unlzma_status", paramInt);
    AppMethodBeat.o(139245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.aj
 * JD-Core Version:    0.7.0.1
 */