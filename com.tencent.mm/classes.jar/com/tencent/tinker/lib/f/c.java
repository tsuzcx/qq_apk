package com.tencent.tinker.lib.f;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;

public final class c
{
  private static c IFl;
  public boolean IFm = true;
  public File IFn = null;
  public File IFo = null;
  private Context context = null;
  public int sua = 20;
  
  private c(Context paramContext)
  {
    this.context = paramContext;
    this.IFn = new File(SharePatchFileUtil.getPatchTempDirectory(paramContext), "patch.retry");
    this.IFo = new File(SharePatchFileUtil.getPatchTempDirectory(paramContext), "temp.apk");
  }
  
  public static c kN(Context paramContext)
  {
    if (IFl == null) {
      IFl = new c(paramContext);
    }
    return IFl;
  }
  
  public final void Y(File paramFile)
  {
    if (paramFile.getAbsolutePath().equals(this.IFo.getAbsolutePath())) {
      return;
    }
    a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.IFo.getAbsolutePath() });
    try
    {
      SharePatchFileUtil.copyFileUsingStream(paramFile, this.IFo);
      return;
    }
    catch (IOException localIOException)
    {
      a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.IFo.getAbsolutePath() });
    }
  }
  
  public final boolean aOi(String paramString)
  {
    if (!this.IFm) {
      a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
    }
    int i;
    do
    {
      a locala;
      do
      {
        return true;
        if (!this.IFn.exists())
        {
          a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
          return true;
        }
        if (paramString == null)
        {
          a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
          return true;
        }
        locala = a.Z(this.IFn);
      } while (!paramString.equals(locala.md5));
      i = Integer.parseInt(locala.IFp);
    } while (i < this.sua);
    a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[] { Integer.valueOf(i) });
    SharePatchFileUtil.safeDeleteFile(this.IFo);
    return false;
  }
  
  public final boolean aOj(String paramString)
  {
    if (!this.IFm) {
      a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
    }
    a locala;
    do
    {
      return true;
      if (!this.IFn.exists())
      {
        a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
        return true;
      }
      if (paramString == null)
      {
        a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
        return true;
      }
      locala = a.Z(this.IFn);
    } while (!paramString.equals(locala.md5));
    a.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
    locala.IFp = "1";
    a.a(this.IFn, locala);
    return true;
  }
  
  public final boolean fpd()
  {
    if (!this.IFm)
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
      return false;
    }
    if (!com.tencent.tinker.lib.e.a.kI(this.context).xZI)
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
      return false;
    }
    if (!this.IFn.exists())
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
      return false;
    }
    if (b.kK(this.context))
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
      return false;
    }
    String str = this.IFo.getAbsolutePath();
    if ((str == null) || (!new File(str).exists()))
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { str });
      return false;
    }
    a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[] { str });
    com.tencent.tinker.lib.e.c.cx(this.context, str);
    return true;
  }
  
  public static final class a
  {
    public String IFp;
    public String md5;
    
    public a(String paramString1, String paramString2)
    {
      this.md5 = paramString1;
      this.IFp = paramString2;
    }
    
    /* Error */
    public static a Z(File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: new 26	java/util/Properties
      //   6: dup
      //   7: invokespecial 27	java/util/Properties:<init>	()V
      //   10: astore_2
      //   11: new 29	java/io/FileInputStream
      //   14: dup
      //   15: aload_0
      //   16: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   19: astore_3
      //   20: aload_3
      //   21: astore_1
      //   22: aload_2
      //   23: aload_3
      //   24: invokevirtual 36	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   27: aload_3
      //   28: astore_1
      //   29: aload_2
      //   30: ldc 37
      //   32: invokevirtual 41	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
      //   35: astore_0
      //   36: aload_3
      //   37: astore_1
      //   38: aload_2
      //   39: ldc 43
      //   41: invokevirtual 41	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
      //   44: astore_2
      //   45: aload_2
      //   46: astore_1
      //   47: aload_3
      //   48: invokestatic 49	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
      //   51: new 2	com/tencent/tinker/lib/f/c$a
      //   54: dup
      //   55: aload_0
      //   56: aload_1
      //   57: invokespecial 51	com/tencent/tinker/lib/f/c$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   60: areturn
      //   61: astore_2
      //   62: aconst_null
      //   63: astore_3
      //   64: aconst_null
      //   65: astore_0
      //   66: aload_3
      //   67: astore_1
      //   68: ldc 53
      //   70: ldc 55
      //   72: aload_2
      //   73: invokestatic 61	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   76: invokevirtual 64	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   79: iconst_0
      //   80: anewarray 4	java/lang/Object
      //   83: invokestatic 70	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   86: aload_3
      //   87: invokestatic 49	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
      //   90: aload 4
      //   92: astore_1
      //   93: goto -42 -> 51
      //   96: astore_0
      //   97: aconst_null
      //   98: astore_1
      //   99: aload_1
      //   100: invokestatic 49	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
      //   103: aload_0
      //   104: athrow
      //   105: astore_0
      //   106: goto -7 -> 99
      //   109: astore_2
      //   110: aconst_null
      //   111: astore_0
      //   112: goto -46 -> 66
      //   115: astore_2
      //   116: goto -50 -> 66
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	paramFile	File
      //   21	79	1	localObject1	Object
      //   10	36	2	localObject2	Object
      //   61	12	2	localIOException1	IOException
      //   109	1	2	localIOException2	IOException
      //   115	1	2	localIOException3	IOException
      //   19	68	3	localFileInputStream	java.io.FileInputStream
      //   1	90	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   11	20	61	java/io/IOException
      //   11	20	96	finally
      //   22	27	105	finally
      //   29	36	105	finally
      //   38	45	105	finally
      //   68	86	105	finally
      //   22	27	109	java/io/IOException
      //   29	36	109	java/io/IOException
      //   38	45	115	java/io/IOException
    }
    
    /* Error */
    public static void a(File paramFile, a parama)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnonnull +4 -> 5
      //   4: return
      //   5: aload_0
      //   6: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
      //   9: astore_2
      //   10: aload_2
      //   11: invokevirtual 83	java/io/File:exists	()Z
      //   14: ifne +8 -> 22
      //   17: aload_2
      //   18: invokevirtual 86	java/io/File:mkdirs	()Z
      //   21: pop
      //   22: new 26	java/util/Properties
      //   25: dup
      //   26: invokespecial 27	java/util/Properties:<init>	()V
      //   29: astore_2
      //   30: aload_2
      //   31: ldc 37
      //   33: aload_1
      //   34: getfield 17	com/tencent/tinker/lib/f/c$a:md5	Ljava/lang/String;
      //   37: invokevirtual 90	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   40: pop
      //   41: aload_2
      //   42: ldc 43
      //   44: aload_1
      //   45: getfield 19	com/tencent/tinker/lib/f/c$a:IFp	Ljava/lang/String;
      //   48: invokevirtual 90	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   51: pop
      //   52: new 92	java/io/FileOutputStream
      //   55: dup
      //   56: aload_0
      //   57: iconst_0
      //   58: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   61: astore_1
      //   62: aload_1
      //   63: astore_0
      //   64: aload_2
      //   65: aload_1
      //   66: aconst_null
      //   67: invokevirtual 99	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   70: aload_1
      //   71: invokestatic 49	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
      //   74: return
      //   75: astore_2
      //   76: aconst_null
      //   77: astore_1
      //   78: aload_1
      //   79: astore_0
      //   80: ldc 53
      //   82: aload_2
      //   83: ldc 101
      //   85: iconst_0
      //   86: anewarray 4	java/lang/Object
      //   89: invokestatic 105	com/tencent/tinker/lib/f/a:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   92: aload_1
      //   93: invokestatic 49	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
      //   96: return
      //   97: astore_1
      //   98: aconst_null
      //   99: astore_0
      //   100: aload_0
      //   101: invokestatic 49	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
      //   104: aload_1
      //   105: athrow
      //   106: astore_1
      //   107: goto -7 -> 100
      //   110: astore_2
      //   111: goto -33 -> 78
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	paramFile	File
      //   0	114	1	parama	a
      //   9	56	2	localObject	Object
      //   75	8	2	localException1	java.lang.Exception
      //   110	1	2	localException2	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   52	62	75	java/lang/Exception
      //   52	62	97	finally
      //   64	70	106	finally
      //   80	92	106	finally
      //   64	70	110	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.f.c
 * JD-Core Version:    0.7.0.1
 */