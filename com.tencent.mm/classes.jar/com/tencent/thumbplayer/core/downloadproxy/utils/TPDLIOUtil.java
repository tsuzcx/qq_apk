package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TPDLIOUtil
{
  private static final String FILE_NAME = "TPDLIOUtil";
  private static Pattern PATH_PATTERN;
  private static final String PROTOCOL_ASSET = "asset";
  private static final String PROTOCOL_FILE = "file";
  private static final String PROTOCOL_HTTP = "http";
  private static final String PROTOCOL_HTTPS = "https";
  private static Pattern PROTOCOL_PATTERN;
  
  static
  {
    AppMethodBeat.i(228177);
    PROTOCOL_PATTERN = Pattern.compile("^(\\w+):/{2,3}");
    PATH_PATTERN = Pattern.compile("^(\\w+):/{2,3}(.*)");
    AppMethodBeat.o(228177);
  }
  
  public static File compare(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(228142);
    if (paramFile1 == null)
    {
      AppMethodBeat.o(228142);
      return paramFile2;
    }
    if ((paramFile2 == null) || (!paramFile2.exists()))
    {
      AppMethodBeat.o(228142);
      return paramFile1;
    }
    if (!paramFile1.exists())
    {
      AppMethodBeat.o(228142);
      return paramFile2;
    }
    if (paramFile1.lastModified() > paramFile2.lastModified())
    {
      AppMethodBeat.o(228142);
      return paramFile1;
    }
    AppMethodBeat.o(228142);
    return paramFile2;
  }
  
  /* Error */
  public static int copy(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +10 -> 20
    //   13: ldc 73
    //   15: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: invokevirtual 62	java/io/File:exists	()Z
    //   24: ifne +10 -> 34
    //   27: ldc 73
    //   29: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_1
    //   35: invokevirtual 62	java/io/File:exists	()Z
    //   38: ifne +40 -> 78
    //   41: aload_1
    //   42: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnonnull +10 -> 57
    //   50: ldc 73
    //   52: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_3
    //   58: invokevirtual 62	java/io/File:exists	()Z
    //   61: ifne +17 -> 78
    //   64: aload_3
    //   65: invokevirtual 80	java/io/File:mkdirs	()Z
    //   68: ifne +10 -> 78
    //   71: ldc 73
    //   73: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_0
    //   77: ireturn
    //   78: new 82	java/io/FileInputStream
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_3
    //   87: new 87	java/io/FileOutputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: aload_3
    //   97: aload_1
    //   98: invokestatic 91	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   101: istore_2
    //   102: aload_3
    //   103: invokevirtual 94	java/io/FileInputStream:close	()V
    //   106: aload_1
    //   107: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   110: ldc 73
    //   112: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iload_2
    //   116: ireturn
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 94	java/io/FileInputStream:close	()V
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   138: ldc 73
    //   140: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 94	java/io/FileInputStream:close	()V
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   166: ldc 73
    //   168: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: goto -68 -> 106
    //   177: astore_0
    //   178: goto -68 -> 110
    //   181: astore_1
    //   182: goto -52 -> 130
    //   185: astore_0
    //   186: goto -48 -> 138
    //   189: astore_3
    //   190: goto -32 -> 158
    //   193: astore_1
    //   194: goto -28 -> 166
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -50 -> 150
    //   203: astore_0
    //   204: goto -54 -> 150
    //   207: astore_0
    //   208: aconst_null
    //   209: astore_0
    //   210: goto -88 -> 122
    //   213: astore_0
    //   214: aload_1
    //   215: astore_0
    //   216: goto -94 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramFile1	File
    //   0	219	1	paramFile2	File
    //   101	15	2	i	int
    //   45	110	3	localObject	Object
    //   189	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   78	87	117	java/io/FileNotFoundException
    //   78	87	145	finally
    //   102	106	173	java/io/IOException
    //   106	110	177	java/io/IOException
    //   126	130	181	java/io/IOException
    //   134	138	185	java/io/IOException
    //   154	158	189	java/io/IOException
    //   162	166	193	java/io/IOException
    //   87	96	197	finally
    //   96	102	203	finally
    //   87	96	207	java/io/FileNotFoundException
    //   96	102	213	java/io/FileNotFoundException
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    i = 0;
    AppMethodBeat.i(228033);
    if ((paramInputStream == null) || (paramOutputStream == null))
    {
      AppMethodBeat.o(228033);
      return 0;
    }
    byte[] arrayOfByte = new byte[1024];
    try
    {
      for (;;)
      {
        int j = paramInputStream.read(arrayOfByte);
        if (j <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, j);
        i += j;
      }
      return i;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(228033);
    }
  }
  
  public static boolean createFile(File paramFile)
  {
    AppMethodBeat.i(228122);
    if (paramFile == null)
    {
      AppMethodBeat.o(228122);
      return false;
    }
    if (!paramFile.exists())
    {
      if (!createParentDirectories(paramFile))
      {
        AppMethodBeat.o(228122);
        return false;
      }
      try
      {
        boolean bool = paramFile.createNewFile();
        AppMethodBeat.o(228122);
        return bool;
      }
      catch (IOException paramFile)
      {
        AppMethodBeat.o(228122);
        return false;
      }
    }
    AppMethodBeat.o(228122);
    return true;
  }
  
  public static boolean createFile(String paramString)
  {
    AppMethodBeat.i(228131);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(228131);
      return false;
    }
    boolean bool = createFile(new File(paramString));
    AppMethodBeat.o(228131);
    return bool;
  }
  
  public static boolean createParentDirectories(File paramFile)
  {
    AppMethodBeat.i(228108);
    if (paramFile == null)
    {
      AppMethodBeat.o(228108);
      return false;
    }
    paramFile = paramFile.getParentFile();
    if ((paramFile != null) && (!paramFile.exists()))
    {
      boolean bool = paramFile.mkdirs();
      AppMethodBeat.o(228108);
      return bool;
    }
    AppMethodBeat.o(228108);
    return true;
  }
  
  public static boolean createParentDirectories(String paramString)
  {
    AppMethodBeat.i(228115);
    boolean bool = createParentDirectories(new File(paramString));
    AppMethodBeat.o(228115);
    return bool;
  }
  
  public static String getPath(String paramString)
  {
    AppMethodBeat.i(228000);
    if (paramString == null)
    {
      AppMethodBeat.o(228000);
      return null;
    }
    Matcher localMatcher = PATH_PATTERN.matcher(paramString);
    if ((localMatcher.find()) && (localMatcher.group(1).equals("asset")))
    {
      paramString = localMatcher.group(2);
      AppMethodBeat.o(228000);
      return paramString;
    }
    AppMethodBeat.o(228000);
    return paramString;
  }
  
  public static String getProtocol(String paramString)
  {
    AppMethodBeat.i(227971);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(227971);
      return "file";
    }
    paramString = PROTOCOL_PATTERN.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(227971);
      return paramString;
    }
    AppMethodBeat.o(227971);
    return "file";
  }
  
  public static boolean isExternalStorageMounted()
  {
    AppMethodBeat.i(228167);
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    AppMethodBeat.o(228167);
    return bool;
  }
  
  public static boolean isRemoteFile(String paramString)
  {
    AppMethodBeat.i(227955);
    paramString = getProtocol(paramString);
    if ((paramString.equals("https")) || (paramString.equals("http")))
    {
      AppMethodBeat.o(227955);
      return true;
    }
    AppMethodBeat.o(227955);
    return false;
  }
  
  public static InputStream open(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227986);
    String str = getProtocol(paramString);
    if (str.equals("asset"))
    {
      paramString = getPath(paramString);
      try
      {
        paramContext = paramContext.getAssets().open(paramString);
        AppMethodBeat.o(227986);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        AppMethodBeat.o(227986);
        return null;
      }
    }
    if (str.equals("file"))
    {
      paramContext = getPath(paramString);
      try
      {
        paramContext = new FileInputStream(paramContext);
        AppMethodBeat.o(227986);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(227986);
        return null;
      }
    }
    if ((str.equals("http")) || (str.equals("https"))) {
      try
      {
        paramContext = new URL(paramString).openStream();
        AppMethodBeat.o(227986);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(227986);
        return null;
      }
    }
    AppMethodBeat.o(227986);
    return null;
  }
  
  public static InputStream openInputStream(File paramFile)
  {
    AppMethodBeat.i(228101);
    if (paramFile == null)
    {
      AppMethodBeat.o(228101);
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      AppMethodBeat.o(228101);
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      AppMethodBeat.o(228101);
    }
    return null;
  }
  
  public static InputStream openInputStream(String paramString)
  {
    AppMethodBeat.i(228089);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(228089);
      return null;
    }
    paramString = openInputStream(new File(paramString));
    AppMethodBeat.o(228089);
    return paramString;
  }
  
  public static OutputStream openOutputStream(File paramFile)
  {
    AppMethodBeat.i(228074);
    if ((paramFile == null) || (!createFile(paramFile)))
    {
      AppMethodBeat.o(228074);
      return null;
    }
    try
    {
      paramFile = new FileOutputStream(paramFile);
      AppMethodBeat.o(228074);
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      AppMethodBeat.o(228074);
    }
    return null;
  }
  
  public static OutputStream openOutputStream(String paramString)
  {
    AppMethodBeat.i(228063);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(228063);
      return null;
    }
    paramString = openOutputStream(new File(paramString));
    AppMethodBeat.o(228063);
    return paramString;
  }
  
  public static void recursiveDelete(File paramFile)
  {
    AppMethodBeat.i(228157);
    if (paramFile != null) {}
    try
    {
      if (paramFile.exists())
      {
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile == null)
          {
            AppMethodBeat.o(228157);
            return;
          }
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            recursiveDelete(arrayOfFile[i]);
            i += 1;
          }
        }
        TPDLProxyLog.d("TPDLIOUtil", 0, "tpdlnative", "recursiveDelete: delete=".concat(String.valueOf(paramFile.delete())));
      }
      AppMethodBeat.o(228157);
      return;
    }
    catch (Exception paramFile)
    {
      TPDLProxyLog.d("TPDLIOUtil", 0, "tpdlnative", "recursiveDelete failed, error:" + paramFile.toString());
      AppMethodBeat.o(228157);
    }
  }
  
  /* Error */
  public static boolean write(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 253
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_1
    //   10: ifnull +8 -> 18
    //   13: aload_1
    //   14: arraylength
    //   15: ifgt +10 -> 25
    //   18: ldc 253
    //   20: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: invokevirtual 62	java/io/File:exists	()Z
    //   29: ifne +55 -> 84
    //   32: aload_0
    //   33: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnull +18 -> 58
    //   43: aload 5
    //   45: invokevirtual 80	java/io/File:mkdirs	()Z
    //   48: ifne +10 -> 58
    //   51: ldc 253
    //   53: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_0
    //   59: invokevirtual 117	java/io/File:createNewFile	()Z
    //   62: istore 4
    //   64: iload 4
    //   66: ifne +18 -> 84
    //   69: ldc 253
    //   71: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_0
    //   77: ldc 253
    //   79: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iconst_0
    //   83: ireturn
    //   84: new 87	java/io/FileOutputStream
    //   87: dup
    //   88: aload_0
    //   89: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   92: astore_0
    //   93: aload_0
    //   94: aload_1
    //   95: iload_2
    //   96: iload_3
    //   97: invokevirtual 108	java/io/OutputStream:write	([BII)V
    //   100: aload_0
    //   101: invokevirtual 254	java/io/OutputStream:close	()V
    //   104: ldc 253
    //   106: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_0
    //   112: ldc 8
    //   114: iconst_0
    //   115: ldc 220
    //   117: new 240	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 256
    //   124: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 257	java/io/IOException:toString	()Ljava/lang/String;
    //   131: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 260	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   140: goto -36 -> 104
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 254	java/io/OutputStream:close	()V
    //   154: ldc 253
    //   156: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_0
    //   162: ldc 8
    //   164: iconst_0
    //   165: ldc 220
    //   167: new 240	java/lang/StringBuilder
    //   170: dup
    //   171: ldc_w 256
    //   174: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: invokevirtual 257	java/io/IOException:toString	()Ljava/lang/String;
    //   181: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 260	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   190: goto -36 -> 154
    //   193: astore_0
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 254	java/io/OutputStream:close	()V
    //   204: ldc 253
    //   206: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload_0
    //   210: athrow
    //   211: astore_1
    //   212: ldc 8
    //   214: iconst_0
    //   215: ldc 220
    //   217: new 240	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 256
    //   224: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_1
    //   228: invokevirtual 257	java/io/IOException:toString	()Ljava/lang/String;
    //   231: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 260	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   240: goto -36 -> 204
    //   243: astore_1
    //   244: aload_0
    //   245: astore 5
    //   247: aload_1
    //   248: astore_0
    //   249: aload 5
    //   251: astore_1
    //   252: goto -56 -> 196
    //   255: astore_1
    //   256: goto -110 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramFile	File
    //   0	259	1	paramArrayOfByte	byte[]
    //   0	259	2	paramInt1	int
    //   0	259	3	paramInt2	int
    //   62	3	4	bool	boolean
    //   36	214	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   58	64	76	java/io/IOException
    //   100	104	111	java/io/IOException
    //   84	93	143	java/lang/Exception
    //   150	154	161	java/io/IOException
    //   84	93	193	finally
    //   200	204	211	java/io/IOException
    //   93	100	243	finally
    //   93	100	255	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil
 * JD-Core Version:    0.7.0.1
 */