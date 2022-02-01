package io.flutter.view;

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

final class e
{
  private static final String[] SUPPORTED_ABIS;
  private final String JfC;
  private final HashSet<String> JfD;
  private a JfE;
  
  static
  {
    AppMethodBeat.i(9821);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS;; localObject = (String[])((ArrayList)localObject).toArray(new String[0]))
    {
      SUPPORTED_ABIS = (String[])localObject;
      AppMethodBeat.o(9821);
      return;
      localObject = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
      ((ArrayList)localObject).removeAll(Arrays.asList(new String[] { null, "" }));
    }
  }
  
  private static String a(File paramFile, PackageManager paramPackageManager, String paramString)
  {
    AppMethodBeat.i(9817);
    try
    {
      paramPackageManager = paramPackageManager.getPackageInfo(paramString, 0);
      if (paramPackageManager == null)
      {
        AppMethodBeat.o(9817);
        return "res_timestamp-";
      }
    }
    catch (PackageManager.NameNotFoundException paramFile)
    {
      AppMethodBeat.o(9817);
      return "res_timestamp-";
    }
    paramString = new StringBuilder("res_timestamp-");
    if (Build.VERSION.SDK_INT >= 28) {}
    for (long l = paramPackageManager.getLongVersionCode();; l = paramPackageManager.versionCode)
    {
      paramPackageManager = l + "-" + paramPackageManager.lastUpdateTime;
      paramFile = ah(paramFile);
      if (paramFile != null) {
        break;
      }
      AppMethodBeat.o(9817);
      return paramPackageManager;
    }
    if ((paramFile.length != 1) || (!paramPackageManager.equals(paramFile[0])))
    {
      AppMethodBeat.o(9817);
      return paramPackageManager;
    }
    AppMethodBeat.o(9817);
    return null;
  }
  
  private static void a(String paramString, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(9816);
    paramString = new File(paramString);
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashSet.next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    paramHashSet = ah(paramString);
    if (paramHashSet == null)
    {
      AppMethodBeat.o(9816);
      return;
    }
    int j = paramHashSet.length;
    int i = 0;
    while (i < j)
    {
      new File(paramString, paramHashSet[i]).delete();
      i += 1;
    }
    AppMethodBeat.o(9816);
  }
  
  private static String[] ah(File paramFile)
  {
    AppMethodBeat.i(9815);
    paramFile = paramFile.list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(9696);
        boolean bool = paramAnonymousString.startsWith("res_timestamp-");
        AppMethodBeat.o(9696);
        return bool;
      }
    });
    AppMethodBeat.o(9815);
    return paramFile;
  }
  
  final void fvs()
  {
    AppMethodBeat.i(9814);
    if (this.JfE == null)
    {
      AppMethodBeat.o(9814);
      return;
    }
    try
    {
      this.JfE.get();
      AppMethodBeat.o(9814);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      a(this.JfC, this.JfD);
      AppMethodBeat.o(9814);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      break label36;
    }
    catch (CancellationException localCancellationException)
    {
      label36:
      break label36;
    }
  }
  
  static final class a
    extends AsyncTask<Void, Void, Void>
  {
    private final String JfC;
    private final HashSet<String> JfD;
    private final PackageManager bPb;
    private final AssetManager iLt;
    private final String mPackageName;
    
    private Void aHW()
    {
      AppMethodBeat.i(9734);
      File localFile = new File(this.JfC);
      String str = e.b(localFile, this.bPb, this.mPackageName);
      if (str == null)
      {
        AppMethodBeat.o(9734);
        return null;
      }
      e.b(this.JfC, this.JfD);
      if (!ai(localFile))
      {
        AppMethodBeat.o(9734);
        return null;
      }
      if (str != null) {}
      try
      {
        new File(localFile, str).createNewFile();
        label87:
        AppMethodBeat.o(9734);
        return null;
      }
      catch (IOException localIOException)
      {
        break label87;
      }
    }
    
    /* Error */
    private boolean ai(File paramFile)
    {
      // Byte code:
      //   0: sipush 9735
      //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 49	io/flutter/view/e$a:JfD	Ljava/util/HashSet;
      //   10: invokevirtual 74	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   13: astore 4
      //   15: aload 4
      //   17: invokeinterface 79 1 0
      //   22: ifeq +229 -> 251
      //   25: aload 4
      //   27: invokeinterface 83 1 0
      //   32: checkcast 85	java/lang/String
      //   35: astore_3
      //   36: new 30	java/io/File
      //   39: dup
      //   40: aload_1
      //   41: aload_3
      //   42: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   45: astore_2
      //   46: aload_2
      //   47: invokevirtual 88	java/io/File:exists	()Z
      //   50: ifne -35 -> 15
      //   53: aload_2
      //   54: invokevirtual 92	java/io/File:getParentFile	()Ljava/io/File;
      //   57: ifnull +11 -> 68
      //   60: aload_2
      //   61: invokevirtual 92	java/io/File:getParentFile	()Ljava/io/File;
      //   64: invokevirtual 95	java/io/File:mkdirs	()Z
      //   67: pop
      //   68: aload_0
      //   69: getfield 97	io/flutter/view/e$a:iLt	Landroid/content/res/AssetManager;
      //   72: aload_3
      //   73: invokevirtual 103	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   76: astore 5
      //   78: new 105	java/io/FileOutputStream
      //   81: dup
      //   82: aload_2
      //   83: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   86: astore 6
      //   88: aload 5
      //   90: aload 6
      //   92: invokestatic 112	io/flutter/view/e:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
      //   95: aload 6
      //   97: invokevirtual 118	java/io/OutputStream:close	()V
      //   100: aload 5
      //   102: ifnull -87 -> 15
      //   105: aload 5
      //   107: invokevirtual 121	java/io/InputStream:close	()V
      //   110: goto -95 -> 15
      //   113: astore_2
      //   114: goto -99 -> 15
      //   117: astore_3
      //   118: sipush 9735
      //   121: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   124: aload_3
      //   125: athrow
      //   126: astore_2
      //   127: aload_3
      //   128: ifnull +96 -> 224
      //   131: aload 6
      //   133: invokevirtual 118	java/io/OutputStream:close	()V
      //   136: sipush 9735
      //   139: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: aload_2
      //   143: athrow
      //   144: astore_3
      //   145: sipush 9735
      //   148: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: aload_3
      //   152: athrow
      //   153: astore_2
      //   154: aload 5
      //   156: ifnull +12 -> 168
      //   159: aload_3
      //   160: ifnull +83 -> 243
      //   163: aload 5
      //   165: invokevirtual 121	java/io/InputStream:close	()V
      //   168: sipush 9735
      //   171: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   174: aload_2
      //   175: athrow
      //   176: astore_1
      //   177: new 123	java/lang/StringBuilder
      //   180: dup
      //   181: ldc 125
      //   183: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   186: aload_1
      //   187: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
      //   190: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   193: pop
      //   194: aload_0
      //   195: getfield 32	io/flutter/view/e$a:JfC	Ljava/lang/String;
      //   198: aload_0
      //   199: getfield 49	io/flutter/view/e$a:JfD	Ljava/util/HashSet;
      //   202: invokestatic 52	io/flutter/view/e:b	(Ljava/lang/String;Ljava/util/HashSet;)V
      //   205: sipush 9735
      //   208: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: iconst_0
      //   212: ireturn
      //   213: astore 6
      //   215: aload_3
      //   216: aload 6
      //   218: invokevirtual 138	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   221: goto -85 -> 136
      //   224: aload 6
      //   226: invokevirtual 118	java/io/OutputStream:close	()V
      //   229: goto -93 -> 136
      //   232: astore 5
      //   234: aload_3
      //   235: aload 5
      //   237: invokevirtual 138	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   240: goto -72 -> 168
      //   243: aload 5
      //   245: invokevirtual 121	java/io/InputStream:close	()V
      //   248: goto -80 -> 168
      //   251: sipush 9735
      //   254: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   257: iconst_1
      //   258: ireturn
      //   259: astore_2
      //   260: aconst_null
      //   261: astore_3
      //   262: goto -135 -> 127
      //   265: astore_2
      //   266: aconst_null
      //   267: astore_3
      //   268: goto -114 -> 154
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	271	0	this	a
      //   0	271	1	paramFile	File
      //   45	38	2	localFile	File
      //   113	1	2	localFileNotFoundException	java.io.FileNotFoundException
      //   126	17	2	localObject1	Object
      //   153	22	2	localObject2	Object
      //   259	1	2	localObject3	Object
      //   265	1	2	localObject4	Object
      //   35	38	3	str	String
      //   117	11	3	localThrowable1	java.lang.Throwable
      //   144	91	3	localThrowable2	java.lang.Throwable
      //   261	7	3	localObject5	Object
      //   13	13	4	localIterator	Iterator
      //   76	88	5	localInputStream	java.io.InputStream
      //   232	12	5	localThrowable3	java.lang.Throwable
      //   86	46	6	localFileOutputStream	java.io.FileOutputStream
      //   213	12	6	localThrowable4	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   36	68	113	java/io/FileNotFoundException
      //   68	78	113	java/io/FileNotFoundException
      //   105	110	113	java/io/FileNotFoundException
      //   163	168	113	java/io/FileNotFoundException
      //   168	176	113	java/io/FileNotFoundException
      //   234	240	113	java/io/FileNotFoundException
      //   243	248	113	java/io/FileNotFoundException
      //   88	95	117	java/lang/Throwable
      //   118	126	126	finally
      //   78	88	144	java/lang/Throwable
      //   95	100	144	java/lang/Throwable
      //   136	144	144	java/lang/Throwable
      //   215	221	144	java/lang/Throwable
      //   224	229	144	java/lang/Throwable
      //   145	153	153	finally
      //   36	68	176	java/io/IOException
      //   68	78	176	java/io/IOException
      //   105	110	176	java/io/IOException
      //   163	168	176	java/io/IOException
      //   168	176	176	java/io/IOException
      //   234	240	176	java/io/IOException
      //   243	248	176	java/io/IOException
      //   131	136	213	java/lang/Throwable
      //   163	168	232	java/lang/Throwable
      //   88	95	259	finally
      //   78	88	265	finally
      //   95	100	265	finally
      //   131	136	265	finally
      //   136	144	265	finally
      //   215	221	265	finally
      //   224	229	265	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.view.e
 * JD-Core Version:    0.7.0.1
 */