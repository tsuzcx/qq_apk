package io.flutter.embedding.engine.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

final class c
{
  private static final String[] SUPPORTED_ABIS;
  private final String KMA;
  private final HashSet<String> KMB;
  private a KMC;
  
  static
  {
    AppMethodBeat.i(192840);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS;; localObject = (String[])((ArrayList)localObject).toArray(new String[0]))
    {
      SUPPORTED_ABIS = (String[])localObject;
      AppMethodBeat.o(192840);
      return;
      localObject = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
      ((ArrayList)localObject).removeAll(Arrays.asList(new String[] { null, "" }));
    }
  }
  
  private static String a(File paramFile, PackageManager paramPackageManager, String paramString)
  {
    AppMethodBeat.i(192836);
    try
    {
      paramPackageManager = paramPackageManager.getPackageInfo(paramString, 0);
      if (paramPackageManager == null)
      {
        AppMethodBeat.o(192836);
        return "res_timestamp-";
      }
    }
    catch (PackageManager.NameNotFoundException paramFile)
    {
      AppMethodBeat.o(192836);
      return "res_timestamp-";
    }
    paramString = new StringBuilder("res_timestamp-");
    if (Build.VERSION.SDK_INT >= 28) {}
    for (long l = paramPackageManager.getLongVersionCode();; l = paramPackageManager.versionCode)
    {
      paramPackageManager = l + "-" + paramPackageManager.lastUpdateTime;
      paramFile = al(paramFile);
      if (paramFile != null) {
        break;
      }
      AppMethodBeat.o(192836);
      return paramPackageManager;
    }
    if ((paramFile.length != 1) || (!paramPackageManager.equals(paramFile[0])))
    {
      AppMethodBeat.o(192836);
      return paramPackageManager;
    }
    AppMethodBeat.o(192836);
    return null;
  }
  
  private static void a(String paramString, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(192835);
    paramString = new File(paramString);
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashSet.next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    paramHashSet = al(paramString);
    if (paramHashSet == null)
    {
      AppMethodBeat.o(192835);
      return;
    }
    int j = paramHashSet.length;
    int i = 0;
    while (i < j)
    {
      new File(paramString, paramHashSet[i]).delete();
      i += 1;
    }
    AppMethodBeat.o(192835);
  }
  
  private static String[] al(File paramFile)
  {
    AppMethodBeat.i(192834);
    paramFile = paramFile.list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(192844);
        boolean bool = paramAnonymousString.startsWith("res_timestamp-");
        AppMethodBeat.o(192844);
        return bool;
      }
    });
    AppMethodBeat.o(192834);
    return paramFile;
  }
  
  final void fNt()
  {
    AppMethodBeat.i(192833);
    if (this.KMC == null)
    {
      AppMethodBeat.o(192833);
      return;
    }
    try
    {
      this.KMC.get();
      AppMethodBeat.o(192833);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      a(this.KMA, this.KMB);
      AppMethodBeat.o(192833);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      break label33;
    }
    catch (CancellationException localCancellationException)
    {
      label33:
      break label33;
    }
  }
  
  static final class a
    extends AsyncTask<Void, Void, Void>
  {
    private final String KMA;
    private final HashSet<String> KMB;
    private final PackageManager bMJ;
    private final AssetManager jlA;
    private final String mPackageName;
    
    private Void aON()
    {
      AppMethodBeat.i(192841);
      File localFile = new File(this.KMA);
      String str = c.b(localFile, this.bMJ, this.mPackageName);
      if (str == null)
      {
        AppMethodBeat.o(192841);
        return null;
      }
      c.b(this.KMA, this.KMB);
      if (!am(localFile))
      {
        AppMethodBeat.o(192841);
        return null;
      }
      if (str != null) {}
      try
      {
        new File(localFile, str).createNewFile();
        label84:
        AppMethodBeat.o(192841);
        return null;
      }
      catch (IOException localIOException)
      {
        break label84;
      }
    }
    
    /* Error */
    private boolean am(File paramFile)
    {
      // Byte code:
      //   0: ldc 70
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 50	io/flutter/embedding/engine/a/c$a:KMB	Ljava/util/HashSet;
      //   9: invokevirtual 76	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   12: astore 4
      //   14: aload 4
      //   16: invokeinterface 81 1 0
      //   21: ifeq +224 -> 245
      //   24: aload 4
      //   26: invokeinterface 85 1 0
      //   31: checkcast 87	java/lang/String
      //   34: astore_3
      //   35: new 31	java/io/File
      //   38: dup
      //   39: aload_1
      //   40: aload_3
      //   41: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   44: astore_2
      //   45: aload_2
      //   46: invokevirtual 90	java/io/File:exists	()Z
      //   49: ifne -35 -> 14
      //   52: aload_2
      //   53: invokevirtual 94	java/io/File:getParentFile	()Ljava/io/File;
      //   56: ifnull +11 -> 67
      //   59: aload_2
      //   60: invokevirtual 94	java/io/File:getParentFile	()Ljava/io/File;
      //   63: invokevirtual 97	java/io/File:mkdirs	()Z
      //   66: pop
      //   67: aload_0
      //   68: getfield 99	io/flutter/embedding/engine/a/c$a:jlA	Landroid/content/res/AssetManager;
      //   71: aload_3
      //   72: invokevirtual 105	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   75: astore 5
      //   77: new 107	java/io/FileOutputStream
      //   80: dup
      //   81: aload_2
      //   82: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   85: astore 6
      //   87: aload 5
      //   89: aload 6
      //   91: invokestatic 114	io/flutter/embedding/engine/a/c:e	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
      //   94: aload 6
      //   96: invokevirtual 120	java/io/OutputStream:close	()V
      //   99: aload 5
      //   101: ifnull -87 -> 14
      //   104: aload 5
      //   106: invokevirtual 123	java/io/InputStream:close	()V
      //   109: goto -95 -> 14
      //   112: astore_2
      //   113: goto -99 -> 14
      //   116: astore_3
      //   117: ldc 70
      //   119: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_3
      //   123: athrow
      //   124: astore_2
      //   125: aload_3
      //   126: ifnull +92 -> 218
      //   129: aload 6
      //   131: invokevirtual 120	java/io/OutputStream:close	()V
      //   134: ldc 70
      //   136: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: aload_2
      //   140: athrow
      //   141: astore_3
      //   142: ldc 70
      //   144: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   147: aload_3
      //   148: athrow
      //   149: astore_2
      //   150: aload 5
      //   152: ifnull +12 -> 164
      //   155: aload_3
      //   156: ifnull +81 -> 237
      //   159: aload 5
      //   161: invokevirtual 123	java/io/InputStream:close	()V
      //   164: ldc 70
      //   166: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: aload_2
      //   170: athrow
      //   171: astore_1
      //   172: new 125	java/lang/StringBuilder
      //   175: dup
      //   176: ldc 127
      //   178: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   181: aload_1
      //   182: invokevirtual 132	java/io/IOException:getMessage	()Ljava/lang/String;
      //   185: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   188: pop
      //   189: aload_0
      //   190: getfield 33	io/flutter/embedding/engine/a/c$a:KMA	Ljava/lang/String;
      //   193: aload_0
      //   194: getfield 50	io/flutter/embedding/engine/a/c$a:KMB	Ljava/util/HashSet;
      //   197: invokestatic 53	io/flutter/embedding/engine/a/c:b	(Ljava/lang/String;Ljava/util/HashSet;)V
      //   200: ldc 70
      //   202: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   205: iconst_0
      //   206: ireturn
      //   207: astore 6
      //   209: aload_3
      //   210: aload 6
      //   212: invokevirtual 140	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   215: goto -81 -> 134
      //   218: aload 6
      //   220: invokevirtual 120	java/io/OutputStream:close	()V
      //   223: goto -89 -> 134
      //   226: astore 5
      //   228: aload_3
      //   229: aload 5
      //   231: invokevirtual 140	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   234: goto -70 -> 164
      //   237: aload 5
      //   239: invokevirtual 123	java/io/InputStream:close	()V
      //   242: goto -78 -> 164
      //   245: ldc 70
      //   247: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   250: iconst_1
      //   251: ireturn
      //   252: astore_2
      //   253: aconst_null
      //   254: astore_3
      //   255: goto -130 -> 125
      //   258: astore_2
      //   259: aconst_null
      //   260: astore_3
      //   261: goto -111 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	264	0	this	a
      //   0	264	1	paramFile	File
      //   44	38	2	localFile	File
      //   112	1	2	localFileNotFoundException	java.io.FileNotFoundException
      //   124	16	2	localObject1	Object
      //   149	21	2	localObject2	Object
      //   252	1	2	localObject3	Object
      //   258	1	2	localObject4	Object
      //   34	38	3	str	String
      //   116	10	3	localThrowable1	java.lang.Throwable
      //   141	88	3	localThrowable2	java.lang.Throwable
      //   254	7	3	localObject5	Object
      //   12	13	4	localIterator	Iterator
      //   75	85	5	localInputStream	java.io.InputStream
      //   226	12	5	localThrowable3	java.lang.Throwable
      //   85	45	6	localFileOutputStream	java.io.FileOutputStream
      //   207	12	6	localThrowable4	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   35	67	112	java/io/FileNotFoundException
      //   67	77	112	java/io/FileNotFoundException
      //   104	109	112	java/io/FileNotFoundException
      //   159	164	112	java/io/FileNotFoundException
      //   164	171	112	java/io/FileNotFoundException
      //   228	234	112	java/io/FileNotFoundException
      //   237	242	112	java/io/FileNotFoundException
      //   87	94	116	java/lang/Throwable
      //   117	124	124	finally
      //   77	87	141	java/lang/Throwable
      //   94	99	141	java/lang/Throwable
      //   134	141	141	java/lang/Throwable
      //   209	215	141	java/lang/Throwable
      //   218	223	141	java/lang/Throwable
      //   142	149	149	finally
      //   35	67	171	java/io/IOException
      //   67	77	171	java/io/IOException
      //   104	109	171	java/io/IOException
      //   159	164	171	java/io/IOException
      //   164	171	171	java/io/IOException
      //   228	234	171	java/io/IOException
      //   237	242	171	java/io/IOException
      //   129	134	207	java/lang/Throwable
      //   159	164	226	java/lang/Throwable
      //   87	94	252	finally
      //   77	87	258	finally
      //   94	99	258	finally
      //   129	134	258	finally
      //   134	141	258	finally
      //   209	215	258	finally
      //   218	223	258	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.c
 * JD-Core Version:    0.7.0.1
 */