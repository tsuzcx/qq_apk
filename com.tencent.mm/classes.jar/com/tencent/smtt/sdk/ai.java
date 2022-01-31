package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class ai
{
  private static ai a = null;
  private static Context b = null;
  
  static ai a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ai();
      }
      b = paramContext.getApplicationContext();
      return a;
    }
    finally {}
  }
  
  /* Error */
  private Properties e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 35	com/tencent/smtt/sdk/ai:a	()Ljava/io/File;
    //   4: astore_1
    //   5: new 37	java/util/Properties
    //   8: dup
    //   9: invokespecial 38	java/util/Properties:<init>	()V
    //   12: astore_2
    //   13: aload_1
    //   14: ifnull +94 -> 108
    //   17: new 40	java/io/BufferedInputStream
    //   20: dup
    //   21: new 42	java/io/FileInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 48	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual 51	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   46: aload_2
    //   47: areturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +7 -> 61
    //   57: aload_1
    //   58: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   61: aload_2
    //   62: areturn
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull +7 -> 74
    //   70: aload_2
    //   71: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: goto -31 -> 46
    //   80: astore_1
    //   81: goto -20 -> 61
    //   84: astore_2
    //   85: goto -11 -> 74
    //   88: astore_2
    //   89: aload_1
    //   90: astore_3
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: astore_2
    //   95: goto -29 -> 66
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_1
    //   101: goto -48 -> 53
    //   104: astore_3
    //   105: goto -52 -> 53
    //   108: aconst_null
    //   109: astore_1
    //   110: goto -72 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ai
    //   4	39	1	localObject1	Object
    //   48	1	1	localException1	java.lang.Exception
    //   52	6	1	localObject2	Object
    //   63	12	1	localObject3	Object
    //   76	1	1	localIOException1	IOException
    //   80	10	1	localIOException2	IOException
    //   92	1	1	localObject4	Object
    //   98	1	1	localException2	java.lang.Exception
    //   100	10	1	localObject5	Object
    //   12	59	2	localProperties	Properties
    //   84	1	2	localIOException3	IOException
    //   88	4	2	localObject6	Object
    //   94	1	2	localObject7	Object
    //   90	4	3	localIOException4	IOException
    //   104	1	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	13	48	java/lang/Exception
    //   0	13	63	finally
    //   17	33	63	finally
    //   42	46	76	java/io/IOException
    //   57	61	80	java/io/IOException
    //   70	74	84	java/io/IOException
    //   33	38	88	finally
    //   17	33	98	java/lang/Exception
    //   33	38	104	java/lang/Exception
  }
  
  File a()
  {
    an.a();
    File localFile = new File(an.t(b), "tbscoreinstall.txt");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  void a(int paramInt)
  {
    a("dexopt_retry_num", paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a("copy_core_ver", paramInt1);
    a("copy_status", paramInt2);
  }
  
  void a(String paramString)
  {
    a("install_apk_path", paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    a(paramString, String.valueOf(paramInt));
  }
  
  /* Error */
  void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 102	com/tencent/smtt/sdk/ai:e	()Ljava/util/Properties;
    //   7: astore 5
    //   9: aload 4
    //   11: astore_3
    //   12: aload 5
    //   14: ifnull +61 -> 75
    //   17: aload 5
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 106	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 35	com/tencent/smtt/sdk/ai:a	()Ljava/io/File;
    //   29: astore_2
    //   30: aload 4
    //   32: astore_3
    //   33: aload_2
    //   34: ifnull +41 -> 75
    //   37: new 108	java/io/FileOutputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_2
    //   46: aload 5
    //   48: aload_2
    //   49: new 111	java/lang/StringBuilder
    //   52: dup
    //   53: ldc 113
    //   55: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 121
    //   64: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 129	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   73: aload_2
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   83: return
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull -5 -> 83
    //   91: aload_2
    //   92: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   95: return
    //   96: astore_1
    //   97: return
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: return
    //   113: astore_2
    //   114: goto -5 -> 109
    //   117: astore_1
    //   118: goto -17 -> 101
    //   121: astore_1
    //   122: goto -35 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ai
    //   0	125	1	paramString1	String
    //   0	125	2	paramString2	String
    //   11	69	3	localObject1	Object
    //   1	30	4	localObject2	Object
    //   7	40	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   3	9	84	java/lang/Exception
    //   17	30	84	java/lang/Exception
    //   37	46	84	java/lang/Exception
    //   91	95	96	java/io/IOException
    //   3	9	98	finally
    //   17	30	98	finally
    //   37	46	98	finally
    //   79	83	111	java/io/IOException
    //   105	109	113	java/io/IOException
    //   46	73	117	finally
    //   46	73	121	java/lang/Exception
  }
  
  int b()
  {
    return c("install_core_ver");
  }
  
  int b(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return -1;
  }
  
  void b(int paramInt)
  {
    a("unzip_retry_num", paramInt);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    a("install_core_ver", paramInt1);
    a("install_status", paramInt2);
  }
  
  int c()
  {
    return b("install_status");
  }
  
  int c(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return 0;
  }
  
  void c(int paramInt)
  {
    a("incrupdate_status", paramInt);
  }
  
  int d()
  {
    return b("incrupdate_status");
  }
  
  String d(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return localProperties.getProperty(paramString);
    }
    return null;
  }
  
  void d(int paramInt)
  {
    a("unlzma_status", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.ai
 * JD-Core Version:    0.7.0.1
 */