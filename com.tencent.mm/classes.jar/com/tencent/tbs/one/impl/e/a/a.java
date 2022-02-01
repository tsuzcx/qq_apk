package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.d;
import com.tencent.tbs.one.impl.a.k.a;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.tbs.one.impl.a.a<e<File>>
{
  Context b;
  String c;
  String[] d;
  String e;
  String f;
  int g;
  File h;
  File i;
  com.tencent.tbs.one.impl.d.a j;
  int k;
  JSONObject l;
  int m;
  String n;
  long o;
  Bundle p;
  d.a q;
  
  public a(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString, d.a parama, File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(190680);
    this.o = -1L;
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramArrayOfString;
    paramContext = parama.d;
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      this.e = paramString2;
      this.f = parama.a;
      this.g = parama.c;
      this.h = paramFile;
      this.p = paramBundle;
      this.q = parama;
      this.i = com.tencent.tbs.one.impl.common.f.a(this.b, this.b, paramString1, parama.a, parama.c);
      AppMethodBeat.o(190680);
      return;
      paramString2 = paramContext;
    }
  }
  
  public final void a()
  {
    AppMethodBeat.i(174057);
    final Context localContext = this.b;
    final String str1 = this.c;
    final String str2 = this.f;
    final int i1 = this.g;
    final File localFile = this.h;
    TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(localContext, str1);
    if (localTBSOneRuntimeExtension != null)
    {
      int i2 = localTBSOneRuntimeExtension.shouldOverrideInstallationJob(str1, str2, i1, null, localFile, new TBSOneCallback()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(174064);
          a.this.k = 0;
          a.this.a(paramAnonymousInt, paramAnonymousString, null);
          AppMethodBeat.o(174064);
        }
        
        public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(174063);
          a.this.a(paramAnonymousInt2);
          AppMethodBeat.o(174063);
        }
      });
      if (i2 != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component installation job by runtime extension", new Object[] { str1, str2 });
        this.k = i2;
        AppMethodBeat.o(174057);
        return;
      }
    }
    if (localFile.exists()) {
      c.a(localFile);
    }
    m.d(new Runnable()
    {
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(174053);
        a locala = a.this;
        String[] arrayOfString;
        int k;
        String str;
        if (locala.d != null)
        {
          arrayOfString = locala.d;
          k = arrayOfString.length;
          i = 0;
          if (i < k)
          {
            str = arrayOfString[i];
            if (com.tencent.tbs.one.impl.e.f.a(localContext, str)) {
              if (!locala.a(str)) {
                break label114;
              }
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label126;
          }
          a.this.a(e.a(e.a.d, a.this.h));
          AppMethodBeat.o(174053);
          return;
          com.tencent.tbs.one.impl.a.f.a("copyFromSharableApplications,verify app %s failed", new Object[] { str });
          label114:
          i += 1;
          break;
        }
        label126:
        locala = a.this;
        if (locala.d != null)
        {
          arrayOfString = locala.d;
          k = arrayOfString.length;
          i = 0;
          if (i < k) {
            if (!locala.b(arrayOfString[i])) {}
          }
        }
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label214;
          }
          a.this.a(e.a(e.a.g, a.this.h));
          AppMethodBeat.o(174053);
          return;
          i += 1;
          break;
        }
        label214:
        locala = a.this;
        boolean bool;
        if (locala.p != null) {
          bool = locala.p.getBoolean("is_ignore_frequency_limitation", false);
        }
        while (!bool)
        {
          long l = com.tencent.tbs.one.impl.e.f.h(localFile);
          if (System.currentTimeMillis() - l < 86400000L)
          {
            a.a(a.this, "Too many component requests, last request time: " + d.a(l));
            AppMethodBeat.o(174053);
            return;
            bool = false;
          }
          else
          {
            com.tencent.tbs.one.impl.e.f.i(localFile);
          }
        }
        h.a("TBSOneAction", 1003, null);
        i = com.tencent.tbs.one.impl.e.f.c(com.tencent.tbs.one.impl.common.f.b(com.tencent.tbs.one.impl.common.f.a(localContext.getDir("tbs", 0), str1), str2));
        a.a(a.this, localContext, str1, str2, i1, a.this.e, i);
        AppMethodBeat.o(174053);
      }
    });
    AppMethodBeat.o(174057);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(174059);
    h.a("TBSOneAction", 1004, null);
    com.tencent.tbs.one.impl.e.f.a(this.h, System.currentTimeMillis());
    super.a(paramInt, paramString, paramThrowable);
    AppMethodBeat.o(174059);
  }
  
  final boolean a(String paramString)
  {
    AppMethodBeat.i(174060);
    Object localObject = this.b;
    String str1 = this.c;
    String str2 = this.f;
    int i1 = this.g;
    File localFile = this.h;
    try
    {
      localObject = com.tencent.tbs.one.impl.common.f.a(com.tencent.tbs.one.impl.common.f.a(((Context)localObject).createPackageContext(paramString, 2).getDir("tbs", 0), str1), str2, i1);
      if ((((File)localObject).exists()) && (com.tencent.tbs.one.impl.e.f.g((File)localObject)))
      {
        c.b((File)localObject, localFile);
        com.tencent.tbs.one.impl.e.f.a(localFile, i1);
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished copy component from %s", new Object[] { str1, str2, paramString });
        AppMethodBeat.o(174060);
        return true;
      }
    }
    catch (Exception localException)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Failed copy component from %s,exception is", new Object[] { str1, str2, paramString, localException.toString() });
      c.a(localFile);
      AppMethodBeat.o(174060);
    }
    return false;
  }
  
  public final void b()
  {
    AppMethodBeat.i(174058);
    super.b();
    if (this.j != null) {
      this.j.b();
    }
    if (this.k != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(this.b, this.c);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.k);
      }
    }
    AppMethodBeat.o(174058);
  }
  
  /* Error */
  final boolean b(String paramString)
  {
    // Byte code:
    //   0: ldc_w 304
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 64	com/tencent/tbs/one/impl/e/a/a:b	Landroid/content/Context;
    //   10: aload_1
    //   11: iconst_2
    //   12: invokevirtual 265	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +225 -> 242
    //   20: aload_0
    //   21: getfield 64	com/tencent/tbs/one/impl/e/a/a:b	Landroid/content/Context;
    //   24: aload_3
    //   25: aload_0
    //   26: getfield 66	com/tencent/tbs/one/impl/e/a/a:c	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 95	com/tencent/tbs/one/impl/e/a/a:q	Lcom/tencent/tbs/one/impl/common/d$a;
    //   33: getfield 83	com/tencent/tbs/one/impl/common/d$a:a	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 95	com/tencent/tbs/one/impl/e/a/a:q	Lcom/tencent/tbs/one/impl/common/d$a;
    //   40: getfield 87	com/tencent/tbs/one/impl/common/d$a:c	I
    //   43: invokestatic 100	com/tencent/tbs/one/impl/common/f:a	(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/io/File;
    //   46: astore_3
    //   47: ldc_w 306
    //   50: iconst_1
    //   51: anewarray 152	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_3
    //   57: aastore
    //   58: invokestatic 157	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_3
    //   62: ifnonnull +11 -> 73
    //   65: ldc_w 304
    //   68: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_0
    //   72: ireturn
    //   73: new 219	java/io/File
    //   76: dup
    //   77: aload_3
    //   78: new 308	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   85: aload_0
    //   86: getfield 95	com/tencent/tbs/one/impl/e/a/a:q	Lcom/tencent/tbs/one/impl/common/d$a;
    //   89: getfield 83	com/tencent/tbs/one/impl/common/d$a:a	Ljava/lang/String;
    //   92: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 315
    //   98: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 319	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 223	java/io/File:exists	()Z
    //   112: ifeq +10 -> 122
    //   115: aload_3
    //   116: invokevirtual 322	java/io/File:isFile	()Z
    //   119: ifne +29 -> 148
    //   122: ldc_w 324
    //   125: iconst_2
    //   126: anewarray 152	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_1
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: aload_3
    //   136: aastore
    //   137: invokestatic 157	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: ldc_w 304
    //   143: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_0
    //   147: ireturn
    //   148: aload_3
    //   149: invokestatic 326	com/tencent/tbs/one/impl/e/f:j	(Ljava/io/File;)Z
    //   152: istore_2
    //   153: iload_2
    //   154: ifne +11 -> 165
    //   157: ldc_w 304
    //   160: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_0
    //   164: ireturn
    //   165: new 328	java/io/FileInputStream
    //   168: dup
    //   169: aload_3
    //   170: invokespecial 331	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   173: astore_3
    //   174: aload_3
    //   175: aload_0
    //   176: getfield 91	com/tencent/tbs/one/impl/e/a/a:h	Ljava/io/File;
    //   179: aconst_null
    //   180: invokestatic 334	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/io/File;Ljava/io/File;)V
    //   183: aload_3
    //   184: invokestatic 337	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   187: aload_0
    //   188: getfield 91	com/tencent/tbs/one/impl/e/a/a:h	Ljava/io/File;
    //   191: aload_0
    //   192: getfield 91	com/tencent/tbs/one/impl/e/a/a:h	Ljava/io/File;
    //   195: invokestatic 339	com/tencent/tbs/one/impl/e/f:a	(Ljava/io/File;Ljava/io/File;)V
    //   198: aload_0
    //   199: getfield 91	com/tencent/tbs/one/impl/e/a/a:h	Ljava/io/File;
    //   202: aload_0
    //   203: getfield 95	com/tencent/tbs/one/impl/e/a/a:q	Lcom/tencent/tbs/one/impl/common/d$a;
    //   206: getfield 87	com/tencent/tbs/one/impl/common/d$a:c	I
    //   209: invokestatic 285	com/tencent/tbs/one/impl/e/f:a	(Ljava/io/File;I)V
    //   212: ldc_w 304
    //   215: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iconst_1
    //   219: ireturn
    //   220: astore_3
    //   221: ldc_w 341
    //   224: iconst_2
    //   225: anewarray 152	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_1
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload_3
    //   235: invokestatic 347	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   238: aastore
    //   239: invokestatic 157	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: ldc_w 304
    //   245: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_1
    //   251: goto -9 -> 242
    //   254: astore_3
    //   255: goto -34 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	a
    //   0	258	1	paramString	String
    //   152	2	2	bool	boolean
    //   15	169	3	localObject	Object
    //   220	15	3	localTBSOneException	TBSOneException
    //   254	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   165	212	220	com/tencent/tbs/one/TBSOneException
    //   6	16	250	android/content/pm/PackageManager$NameNotFoundException
    //   20	61	250	android/content/pm/PackageManager$NameNotFoundException
    //   73	122	250	android/content/pm/PackageManager$NameNotFoundException
    //   122	140	250	android/content/pm/PackageManager$NameNotFoundException
    //   148	153	250	android/content/pm/PackageManager$NameNotFoundException
    //   165	212	250	android/content/pm/PackageManager$NameNotFoundException
    //   221	242	250	android/content/pm/PackageManager$NameNotFoundException
    //   165	212	254	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a
 * JD-Core Version:    0.7.0.1
 */