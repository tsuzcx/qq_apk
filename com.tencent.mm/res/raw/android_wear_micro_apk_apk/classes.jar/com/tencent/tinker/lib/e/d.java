package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.loader.a.f;
import java.io.File;
import java.io.IOException;

public final class d
{
  private static d akl;
  private boolean akm = true;
  private File akn = null;
  private File ako = null;
  private int akp = 5;
  private Context context = null;
  
  private d(Context paramContext)
  {
    this.context = paramContext;
    this.akn = new File(f.N(paramContext), "patch.retry");
    this.ako = new File(f.N(paramContext), "temp.apk");
  }
  
  public static d H(Context paramContext)
  {
    if (akl == null) {
      akl = new d(paramContext);
    }
    return akl;
  }
  
  private void e(File paramFile)
  {
    if (paramFile.getAbsolutePath().equals(this.ako.getAbsolutePath())) {
      return;
    }
    a.b("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.ako.getAbsolutePath() });
    try
    {
      f.b(paramFile, this.ako);
      return;
    }
    catch (IOException localIOException)
    {
      a.a("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.ako.getAbsolutePath() });
    }
  }
  
  /* Error */
  public final void g(android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/tinker/lib/e/d:akm	Z
    //   4: ifne +15 -> 19
    //   7: ldc 68
    //   9: ldc 90
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 76	com/tencent/tinker/lib/e/a:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: return
    //   19: aload_1
    //   20: ifnonnull +15 -> 35
    //   23: ldc 68
    //   25: ldc 92
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 84	com/tencent/tinker/lib/e/a:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: return
    //   35: aload_1
    //   36: invokestatic 98	com/tencent/tinker/lib/service/TinkerPatchService:h	(Landroid/content/Intent;)Ljava/lang/String;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnonnull +15 -> 56
    //   44: ldc 68
    //   46: ldc 100
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokestatic 76	com/tencent/tinker/lib/e/a:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: return
    //   56: new 32	java/io/File
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: invokestatic 107	com/tencent/tinker/loader/a/f:n	(Ljava/io/File;)Ljava/lang/String;
    //   69: astore 4
    //   71: aload 4
    //   73: ifnonnull +15 -> 88
    //   76: ldc 68
    //   78: ldc 109
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 76	com/tencent/tinker/lib/e/a:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: return
    //   88: aload_0
    //   89: getfield 24	com/tencent/tinker/lib/e/d:akn	Ljava/io/File;
    //   92: invokevirtual 113	java/io/File:exists	()Z
    //   95: ifeq +185 -> 280
    //   98: aload_0
    //   99: getfield 24	com/tencent/tinker/lib/e/d:akn	Ljava/io/File;
    //   102: invokestatic 119	com/tencent/tinker/lib/e/e:f	(Ljava/io/File;)Lcom/tencent/tinker/lib/e/e;
    //   105: astore_1
    //   106: aload_1
    //   107: getfield 123	com/tencent/tinker/lib/e/e:afE	Ljava/lang/String;
    //   110: ifnull +22 -> 132
    //   113: aload_1
    //   114: getfield 126	com/tencent/tinker/lib/e/e:akq	Ljava/lang/String;
    //   117: ifnull +15 -> 132
    //   120: aload 4
    //   122: aload_1
    //   123: getfield 123	com/tencent/tinker/lib/e/e:afE	Ljava/lang/String;
    //   126: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifne +102 -> 231
    //   132: aload_0
    //   133: aload_3
    //   134: invokespecial 128	com/tencent/tinker/lib/e/d:e	(Ljava/io/File;)V
    //   137: aload_1
    //   138: aload 4
    //   140: putfield 123	com/tencent/tinker/lib/e/e:afE	Ljava/lang/String;
    //   143: aload_1
    //   144: ldc 130
    //   146: putfield 126	com/tencent/tinker/lib/e/e:akq	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 24	com/tencent/tinker/lib/e/d:akn	Ljava/io/File;
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 134	java/io/File:getParentFile	()Ljava/io/File;
    //   158: astore 4
    //   160: aload 4
    //   162: invokevirtual 113	java/io/File:exists	()Z
    //   165: ifne +9 -> 174
    //   168: aload 4
    //   170: invokevirtual 137	java/io/File:mkdirs	()Z
    //   173: pop
    //   174: new 139	java/util/Properties
    //   177: dup
    //   178: invokespecial 140	java/util/Properties:<init>	()V
    //   181: astore 4
    //   183: aload 4
    //   185: ldc 142
    //   187: aload_1
    //   188: getfield 123	com/tencent/tinker/lib/e/e:afE	Ljava/lang/String;
    //   191: invokevirtual 146	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: aload 4
    //   197: ldc 148
    //   199: aload_1
    //   200: getfield 126	com/tencent/tinker/lib/e/e:akq	Ljava/lang/String;
    //   203: invokevirtual 146	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: new 150	java/io/FileOutputStream
    //   210: dup
    //   211: aload_3
    //   212: iconst_0
    //   213: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   216: astore_3
    //   217: aload_3
    //   218: astore_1
    //   219: aload 4
    //   221: aload_3
    //   222: aconst_null
    //   223: invokevirtual 157	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   226: aload_3
    //   227: invokestatic 163	com/tencent/tinker/a/a/a:R	(Ljava/lang/Object;)V
    //   230: return
    //   231: aload_1
    //   232: getfield 126	com/tencent/tinker/lib/e/e:akq	Ljava/lang/String;
    //   235: invokestatic 169	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   238: istore_2
    //   239: iload_2
    //   240: aload_0
    //   241: getfield 30	com/tencent/tinker/lib/e/d:akp	I
    //   244: if_icmplt +23 -> 267
    //   247: aload_0
    //   248: getfield 26	com/tencent/tinker/lib/e/d:ako	Ljava/io/File;
    //   251: invokestatic 173	com/tencent/tinker/loader/a/f:l	(Ljava/io/File;)Z
    //   254: pop
    //   255: ldc 68
    //   257: ldc 175
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 76	com/tencent/tinker/lib/e/a:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: return
    //   267: aload_1
    //   268: iload_2
    //   269: iconst_1
    //   270: iadd
    //   271: invokestatic 179	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   274: putfield 126	com/tencent/tinker/lib/e/e:akq	Ljava/lang/String;
    //   277: goto -128 -> 149
    //   280: aload_0
    //   281: aload_3
    //   282: invokespecial 128	com/tencent/tinker/lib/e/d:e	(Ljava/io/File;)V
    //   285: new 115	com/tencent/tinker/lib/e/e
    //   288: dup
    //   289: aload 4
    //   291: ldc 130
    //   293: invokespecial 182	com/tencent/tinker/lib/e/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: astore_1
    //   297: goto -148 -> 149
    //   300: astore 4
    //   302: aconst_null
    //   303: astore_3
    //   304: aload_3
    //   305: astore_1
    //   306: ldc 68
    //   308: aload 4
    //   310: ldc 184
    //   312: iconst_0
    //   313: anewarray 4	java/lang/Object
    //   316: invokestatic 187	com/tencent/tinker/lib/e/a:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   319: aload_3
    //   320: invokestatic 163	com/tencent/tinker/a/a/a:R	(Ljava/lang/Object;)V
    //   323: return
    //   324: astore_3
    //   325: aconst_null
    //   326: astore_1
    //   327: aload_1
    //   328: invokestatic 163	com/tencent/tinker/a/a/a:R	(Ljava/lang/Object;)V
    //   331: aload_3
    //   332: athrow
    //   333: astore_3
    //   334: goto -7 -> 327
    //   337: astore 4
    //   339: goto -35 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	d
    //   0	342	1	paramIntent	android.content.Intent
    //   238	33	2	i	int
    //   64	256	3	localObject1	Object
    //   324	8	3	localObject2	Object
    //   333	1	3	localObject3	Object
    //   69	221	4	localObject4	Object
    //   300	9	4	localException1	java.lang.Exception
    //   337	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   207	217	300	java/lang/Exception
    //   207	217	324	finally
    //   219	226	333	finally
    //   306	319	333	finally
    //   219	226	337	java/lang/Exception
  }
  
  public final void od()
  {
    if (!this.akm) {
      a.b("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
    }
    while (!this.ako.exists()) {
      return;
    }
    f.l(this.ako);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.d
 * JD-Core Version:    0.7.0.1
 */