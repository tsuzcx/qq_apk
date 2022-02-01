package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

class ResourceExtractor
{
  private static final String[] SUPPORTED_ABIS;
  private static final String TAG = "ResourceExtractor";
  private static final String TIMESTAMP_PREFIX = "res_timestamp-";
  private final AssetManager mAssetManager;
  private final String mDataDirPath;
  private ExtractTask mExtractTask;
  private final PackageManager mPackageManager;
  private final String mPackageName;
  private final HashSet<String> mResources;
  
  static
  {
    AppMethodBeat.i(190172);
    SUPPORTED_ABIS = getSupportedAbis();
    AppMethodBeat.o(190172);
  }
  
  ResourceExtractor(String paramString1, String paramString2, PackageManager paramPackageManager, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(190082);
    this.mDataDirPath = paramString1;
    this.mPackageName = paramString2;
    this.mPackageManager = paramPackageManager;
    this.mAssetManager = paramAssetManager;
    this.mResources = new HashSet();
    AppMethodBeat.o(190082);
  }
  
  private static String checkTimestamp(File paramFile, PackageManager paramPackageManager, String paramString)
  {
    AppMethodBeat.i(190108);
    try
    {
      paramPackageManager = paramPackageManager.getPackageInfo(paramString, 0);
      if (paramPackageManager == null)
      {
        AppMethodBeat.o(190108);
        return "res_timestamp-";
      }
    }
    catch (PackageManager.NameNotFoundException paramFile)
    {
      AppMethodBeat.o(190108);
      return "res_timestamp-";
    }
    paramPackageManager = "res_timestamp-" + getVersionCode(paramPackageManager) + "-" + paramPackageManager.lastUpdateTime;
    paramFile = getExistingTimestamps(paramFile);
    if (paramFile == null)
    {
      AppMethodBeat.o(190108);
      return paramPackageManager;
    }
    if ((paramFile.length != 1) || (!paramPackageManager.equals(paramFile[0])))
    {
      AppMethodBeat.o(190108);
      return paramPackageManager;
    }
    AppMethodBeat.o(190108);
    return null;
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(190121);
    byte[] arrayOfByte = new byte[16384];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(190121);
  }
  
  private static void deleteFiles(String paramString, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(190100);
    paramString = new File(paramString);
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashSet.next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    paramHashSet = getExistingTimestamps(paramString);
    if (paramHashSet == null)
    {
      AppMethodBeat.o(190100);
      return;
    }
    int j = paramHashSet.length;
    int i = 0;
    while (i < j)
    {
      new File(paramString, paramHashSet[i]).delete();
      i += 1;
    }
    AppMethodBeat.o(190100);
  }
  
  private static String[] getExistingTimestamps(File paramFile)
  {
    AppMethodBeat.i(190093);
    paramFile = paramFile.list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(190065);
        boolean bool = paramAnonymousString.startsWith("res_timestamp-");
        AppMethodBeat.o(190065);
        return bool;
      }
    });
    AppMethodBeat.o(190093);
    return paramFile;
  }
  
  private static String[] getSupportedAbis()
  {
    AppMethodBeat.i(190131);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = Build.SUPPORTED_ABIS;
      AppMethodBeat.o(190131);
      return localObject;
    }
    Object localObject = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
    ((ArrayList)localObject).removeAll(Arrays.asList(new String[] { null, "" }));
    localObject = (String[])((ArrayList)localObject).toArray(new String[0]);
    AppMethodBeat.o(190131);
    return localObject;
  }
  
  static long getVersionCode(PackageInfo paramPackageInfo)
  {
    AppMethodBeat.i(190076);
    if (Build.VERSION.SDK_INT >= 28)
    {
      l = paramPackageInfo.getLongVersionCode();
      AppMethodBeat.o(190076);
      return l;
    }
    long l = paramPackageInfo.versionCode;
    AppMethodBeat.o(190076);
    return l;
  }
  
  ResourceExtractor addResource(String paramString)
  {
    AppMethodBeat.i(190180);
    this.mResources.add(paramString);
    AppMethodBeat.o(190180);
    return this;
  }
  
  ResourceExtractor addResources(Collection<String> paramCollection)
  {
    AppMethodBeat.i(190188);
    this.mResources.addAll(paramCollection);
    AppMethodBeat.o(190188);
    return this;
  }
  
  ResourceExtractor start()
  {
    AppMethodBeat.i(190197);
    this.mExtractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
    this.mExtractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    AppMethodBeat.o(190197);
    return this;
  }
  
  void waitForCompletion()
  {
    AppMethodBeat.i(190209);
    if (this.mExtractTask == null)
    {
      AppMethodBeat.o(190209);
      return;
    }
    try
    {
      this.mExtractTask.get();
      AppMethodBeat.o(190209);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      deleteFiles(this.mDataDirPath, this.mResources);
      AppMethodBeat.o(190209);
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
  
  static class ExtractTask
    extends AsyncTask<Void, Void, Void>
  {
    private final AssetManager mAssetManager;
    private final String mDataDirPath;
    private final PackageManager mPackageManager;
    private final String mPackageName;
    private final HashSet<String> mResources;
    
    ExtractTask(String paramString1, HashSet<String> paramHashSet, String paramString2, PackageManager paramPackageManager, AssetManager paramAssetManager)
    {
      this.mDataDirPath = paramString1;
      this.mResources = paramHashSet;
      this.mAssetManager = paramAssetManager;
      this.mPackageName = paramString2;
      this.mPackageManager = paramPackageManager;
    }
    
    /* Error */
    private boolean extractAPK(File paramFile)
    {
      // Byte code:
      //   0: ldc 43
      //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 27	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
      //   9: invokevirtual 55	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   12: astore_2
      //   13: aload_2
      //   14: invokeinterface 61 1 0
      //   19: ifeq +238 -> 257
      //   22: aload_2
      //   23: invokeinterface 65 1 0
      //   28: checkcast 67	java/lang/String
      //   31: astore_3
      //   32: new 69	java/io/File
      //   35: dup
      //   36: aload_1
      //   37: aload_3
      //   38: invokespecial 72	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   41: astore 4
      //   43: aload 4
      //   45: invokevirtual 75	java/io/File:exists	()Z
      //   48: ifne -35 -> 13
      //   51: aload 4
      //   53: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
      //   56: ifnull +12 -> 68
      //   59: aload 4
      //   61: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
      //   64: invokevirtual 82	java/io/File:mkdirs	()Z
      //   67: pop
      //   68: aload_0
      //   69: getfield 29	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mAssetManager	Landroid/content/res/AssetManager;
      //   72: aload_3
      //   73: invokevirtual 88	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   76: astore_3
      //   77: new 90	java/io/FileOutputStream
      //   80: dup
      //   81: aload 4
      //   83: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   86: astore 6
      //   88: aload_3
      //   89: aload 6
      //   91: invokestatic 97	io/flutter/embedding/engine/loader/ResourceExtractor:access$200	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
      //   94: aload 6
      //   96: invokevirtual 102	java/io/OutputStream:close	()V
      //   99: aload_3
      //   100: ifnull -87 -> 13
      //   103: aload_3
      //   104: invokevirtual 105	java/io/InputStream:close	()V
      //   107: goto -94 -> 13
      //   110: astore_3
      //   111: goto -98 -> 13
      //   114: astore 4
      //   116: ldc 43
      //   118: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: aload 4
      //   123: athrow
      //   124: astore 5
      //   126: aload 4
      //   128: ifnull +104 -> 232
      //   131: aload 6
      //   133: invokevirtual 102	java/io/OutputStream:close	()V
      //   136: ldc 43
      //   138: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   141: aload 5
      //   143: athrow
      //   144: astore 4
      //   146: ldc 43
      //   148: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: aload 4
      //   153: athrow
      //   154: astore 5
      //   156: aload_3
      //   157: ifnull +12 -> 169
      //   160: aload 4
      //   162: ifnull +88 -> 250
      //   165: aload_3
      //   166: invokevirtual 105	java/io/InputStream:close	()V
      //   169: ldc 43
      //   171: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   174: aload 5
      //   176: athrow
      //   177: astore_1
      //   178: ldc 110
      //   180: new 112	java/lang/StringBuilder
      //   183: dup
      //   184: ldc 114
      //   186: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   189: aload_1
      //   190: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
      //   193: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   196: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   199: invokestatic 134	io/flutter/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   202: aload_0
      //   203: getfield 25	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mDataDirPath	Ljava/lang/String;
      //   206: aload_0
      //   207: getfield 27	io/flutter/embedding/engine/loader/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
      //   210: invokestatic 138	io/flutter/embedding/engine/loader/ResourceExtractor:access$100	(Ljava/lang/String;Ljava/util/HashSet;)V
      //   213: ldc 43
      //   215: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   218: iconst_0
      //   219: ireturn
      //   220: astore 6
      //   222: aload 4
      //   224: aload 6
      //   226: invokevirtual 144	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   229: goto -93 -> 136
      //   232: aload 6
      //   234: invokevirtual 102	java/io/OutputStream:close	()V
      //   237: goto -101 -> 136
      //   240: astore_3
      //   241: aload 4
      //   243: aload_3
      //   244: invokevirtual 144	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   247: goto -78 -> 169
      //   250: aload_3
      //   251: invokevirtual 105	java/io/InputStream:close	()V
      //   254: goto -85 -> 169
      //   257: ldc 43
      //   259: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   262: iconst_1
      //   263: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	264	0	this	ExtractTask
      //   0	264	1	paramFile	File
      //   12	11	2	localIterator	Iterator
      //   31	73	3	localObject1	Object
      //   110	56	3	localFileNotFoundException	java.io.FileNotFoundException
      //   240	11	3	localThrowable1	java.lang.Throwable
      //   41	41	4	localFile	File
      //   114	13	4	localObject2	Object
      //   144	98	4	localObject3	Object
      //   124	18	5	localObject4	Object
      //   154	21	5	localObject5	Object
      //   86	46	6	localFileOutputStream	java.io.FileOutputStream
      //   220	13	6	localThrowable2	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   32	68	110	java/io/FileNotFoundException
      //   68	77	110	java/io/FileNotFoundException
      //   103	107	110	java/io/FileNotFoundException
      //   169	177	110	java/io/FileNotFoundException
      //   241	247	110	java/io/FileNotFoundException
      //   250	254	110	java/io/FileNotFoundException
      //   88	94	114	finally
      //   116	124	124	finally
      //   77	88	144	finally
      //   94	99	144	finally
      //   136	144	144	finally
      //   222	229	144	finally
      //   232	237	144	finally
      //   146	154	154	finally
      //   32	68	177	java/io/IOException
      //   68	77	177	java/io/IOException
      //   103	107	177	java/io/IOException
      //   169	177	177	java/io/IOException
      //   241	247	177	java/io/IOException
      //   250	254	177	java/io/IOException
      //   131	136	220	finally
      //   165	169	240	finally
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      AppMethodBeat.i(190070);
      paramVarArgs = new File(this.mDataDirPath);
      String str = ResourceExtractor.access$000(paramVarArgs, this.mPackageManager, this.mPackageName);
      if (str == null)
      {
        AppMethodBeat.o(190070);
        return null;
      }
      ResourceExtractor.access$100(this.mDataDirPath, this.mResources);
      if (!extractAPK(paramVarArgs))
      {
        AppMethodBeat.o(190070);
        return null;
      }
      if (str != null) {}
      try
      {
        new File(paramVarArgs, str).createNewFile();
        AppMethodBeat.o(190070);
        return null;
      }
      catch (IOException paramVarArgs)
      {
        for (;;)
        {
          Log.w("ResourceExtractor", "Failed to write resource timestamp");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ResourceExtractor
 * JD-Core Version:    0.7.0.1
 */