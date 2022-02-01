package com.tencent.mm.plugin.performance.diagnostic.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.d;

public final class b
{
  static u W(u paramu)
  {
    AppMethodBeat.i(176897);
    if (!paramu.jKQ())
    {
      paramu = new IOException("cannot read file: " + ah.v(paramu.jKT()));
      AppMethodBeat.o(176897);
      throw paramu;
    }
    AppMethodBeat.o(176897);
    return paramu;
  }
  
  /* Error */
  public static void a(u paramu1, u paramu2, com.tencent.mm.vfs.w paramw, String paramString)
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 57	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 59	java/io/BufferedOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokestatic 65	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   17: invokespecial 68	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: invokespecial 69	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore 5
    //   25: new 71	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 74	java/util/ArrayList:<init>	()V
    //   32: astore 6
    //   34: aload_0
    //   35: invokevirtual 77	com/tencent/mm/vfs/u:isDirectory	()Z
    //   38: ifeq +199 -> 237
    //   41: aload_2
    //   42: ifnull +187 -> 229
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 80	com/tencent/mm/vfs/u:a	(Lcom/tencent/mm/vfs/w;)[Lcom/tencent/mm/vfs/u;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +15 -> 67
    //   55: aload 6
    //   57: aload_1
    //   58: invokestatic 86	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   61: invokeinterface 92 2 0
    //   66: pop
    //   67: aload 6
    //   69: invokeinterface 95 1 0
    //   74: ifne +206 -> 280
    //   77: aload 6
    //   79: iconst_0
    //   80: invokeinterface 99 2 0
    //   85: checkcast 15	com/tencent/mm/vfs/u
    //   88: astore 7
    //   90: aload 7
    //   92: invokevirtual 33	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   95: invokestatic 39	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   98: aload_0
    //   99: invokevirtual 33	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   102: invokestatic 39	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   105: invokevirtual 105	java/lang/String:length	()I
    //   108: invokevirtual 109	java/lang/String:substring	(I)Ljava/lang/String;
    //   111: astore 4
    //   113: aload 4
    //   115: astore_1
    //   116: aload 4
    //   118: ldc 111
    //   120: invokevirtual 115	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   123: ifeq +10 -> 133
    //   126: aload 4
    //   128: iconst_1
    //   129: invokevirtual 109	java/lang/String:substring	(I)Ljava/lang/String;
    //   132: astore_1
    //   133: aload_1
    //   134: astore 4
    //   136: aload_1
    //   137: invokevirtual 116	java/lang/String:isEmpty	()Z
    //   140: ifeq +10 -> 150
    //   143: aload 7
    //   145: invokevirtual 119	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   148: astore 4
    //   150: new 121	java/util/zip/ZipEntry
    //   153: dup
    //   154: aload 4
    //   156: invokespecial 122	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   159: astore_1
    //   160: aload_1
    //   161: bipush 8
    //   163: invokevirtual 125	java/util/zip/ZipEntry:setMethod	(I)V
    //   166: aload 5
    //   168: aload_1
    //   169: invokevirtual 129	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   172: aload 7
    //   174: invokevirtual 77	com/tencent/mm/vfs/u:isDirectory	()Z
    //   177: ifeq +80 -> 257
    //   180: aload_2
    //   181: ifnull +68 -> 249
    //   184: aload_0
    //   185: aload_2
    //   186: invokevirtual 80	com/tencent/mm/vfs/u:a	(Lcom/tencent/mm/vfs/w;)[Lcom/tencent/mm/vfs/u;
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +15 -> 206
    //   194: aload 6
    //   196: aload_1
    //   197: invokestatic 86	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   200: invokeinterface 92 2 0
    //   205: pop
    //   206: aload 5
    //   208: invokevirtual 132	java/util/zip/ZipOutputStream:closeEntry	()V
    //   211: goto -144 -> 67
    //   214: astore_0
    //   215: aload 5
    //   217: astore_1
    //   218: aload_1
    //   219: invokestatic 137	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   222: ldc 55
    //   224: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_0
    //   228: athrow
    //   229: aload_0
    //   230: invokevirtual 141	com/tencent/mm/vfs/u:jKX	()[Lcom/tencent/mm/vfs/u;
    //   233: astore_1
    //   234: goto -183 -> 51
    //   237: aload 6
    //   239: aload_0
    //   240: invokeinterface 145 2 0
    //   245: pop
    //   246: goto -179 -> 67
    //   249: aload_0
    //   250: invokevirtual 141	com/tencent/mm/vfs/u:jKX	()[Lcom/tencent/mm/vfs/u;
    //   253: astore_1
    //   254: goto -64 -> 190
    //   257: aload 7
    //   259: aload 5
    //   261: invokestatic 148	com/tencent/mm/plugin/performance/diagnostic/a/b:a	(Lcom/tencent/mm/vfs/u;Ljava/io/OutputStream;)V
    //   264: goto -58 -> 206
    //   267: astore_0
    //   268: aload 5
    //   270: invokevirtual 132	java/util/zip/ZipOutputStream:closeEntry	()V
    //   273: ldc 55
    //   275: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_0
    //   279: athrow
    //   280: aload_3
    //   281: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   284: ifne +9 -> 293
    //   287: aload 5
    //   289: aload_3
    //   290: invokevirtual 156	java/util/zip/ZipOutputStream:setComment	(Ljava/lang/String;)V
    //   293: aload 5
    //   295: invokestatic 137	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   298: ldc 55
    //   300: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_1
    //   307: goto -89 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramu1	u
    //   0	310	1	paramu2	u
    //   0	310	2	paramw	com.tencent.mm.vfs.w
    //   0	310	3	paramString	String
    //   111	44	4	localObject	Object
    //   23	271	5	localZipOutputStream	java.util.zip.ZipOutputStream
    //   32	206	6	localArrayList	java.util.ArrayList
    //   88	170	7	localu	u
    // Exception table:
    //   from	to	target	type
    //   25	41	214	finally
    //   45	51	214	finally
    //   55	67	214	finally
    //   67	113	214	finally
    //   116	133	214	finally
    //   136	150	214	finally
    //   150	166	214	finally
    //   206	211	214	finally
    //   229	234	214	finally
    //   237	246	214	finally
    //   268	280	214	finally
    //   280	293	214	finally
    //   166	180	267	finally
    //   184	190	267	finally
    //   194	206	267	finally
    //   249	254	267	finally
    //   257	264	267	finally
    //   5	25	304	finally
  }
  
  public static void a(u paramu1, u paramu2, String paramString)
  {
    AppMethodBeat.i(300961);
    a(paramu1, paramu2, null, paramString);
    AppMethodBeat.o(300961);
  }
  
  private static void a(u paramu, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(176898);
    byte[] arrayOfByte = new byte[4096];
    try
    {
      localBufferedInputStream = new BufferedInputStream(y.ao(paramu));
      try
      {
        for (;;)
        {
          int i = localBufferedInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        paramOutputStream.flush();
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedInputStream localBufferedInputStream = null;
      }
    }
    d.ai(localBufferedInputStream);
    AppMethodBeat.o(176898);
    throw paramu;
    paramOutputStream.flush();
    d.ai(localBufferedInputStream);
    AppMethodBeat.o(176898);
  }
  
  static String aRs(String paramString)
  {
    AppMethodBeat.i(124914);
    if (TextUtils.equals(paramString, "armeabi"))
    {
      AppMethodBeat.o(124914);
      return "arm";
    }
    if (TextUtils.equals(paramString, "armeabi-v7a"))
    {
      AppMethodBeat.o(124914);
      return "arm";
    }
    if (TextUtils.equals(paramString, "arm64-v8a"))
    {
      AppMethodBeat.o(124914);
      return "arm64";
    }
    if (TextUtils.equals(paramString, "mips"))
    {
      AppMethodBeat.o(124914);
      return "mips";
    }
    if (TextUtils.equals(paramString, "mips64"))
    {
      AppMethodBeat.o(124914);
      return "mips64";
    }
    if (TextUtils.equals(paramString, "x86"))
    {
      AppMethodBeat.o(124914);
      return "x86";
    }
    if (TextUtils.equals(paramString, "x86_64"))
    {
      AppMethodBeat.o(124914);
      return "x86_64";
    }
    paramString = new IllegalArgumentException("unknown abi: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(124914);
    throw paramString;
  }
  
  static int aRt(String paramString)
  {
    AppMethodBeat.i(124917);
    Object localObject1 = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if (TextUtils.equals(((ActivityManager.RunningAppProcessInfo)localObject4).processName, paramString))
          {
            i = ((ActivityManager.RunningAppProcessInfo)localObject4).pid;
            AppMethodBeat.o(124917);
            return i;
          }
        }
      }
    }
    u[] arrayOfu = new u("/proc").jKX();
    int j = arrayOfu.length;
    int i = 0;
    u localu;
    if (i < j)
    {
      localu = arrayOfu[i];
      if ((TextUtils.isDigitsOnly(localu.getName())) && (localu.jKQ()))
      {
        localObject4 = new u(localu, "cmdline");
        if (((u)localObject4).jKQ()) {
          localObject1 = null;
        }
      }
    }
    try
    {
      localObject4 = new BufferedReader(new ab((u)localObject4));
    }
    finally
    {
      for (;;)
      {
        try
        {
          boolean bool = paramString.equals(((BufferedReader)localObject4).readLine().trim());
          if (bool) {
            try
            {
              i = Integer.parseInt(localu.getName().trim(), 10);
            }
            finally
            {
              d.b((Reader)localObject4);
              AppMethodBeat.o(124917);
              return 0;
            }
          }
          d.b((Reader)localObject4);
          i += 1;
          break;
        }
        finally
        {
          Object localObject3 = localObject5;
          continue;
        }
        localObject5 = finally;
        d.b((Reader)localObject1);
      }
      AppMethodBeat.o(124917);
      return 0;
    }
  }
  
  public static void f(u paramu1, u paramu2)
  {
    AppMethodBeat.i(300959);
    a(paramu1, paramu2, null, null);
    AppMethodBeat.o(300959);
  }
  
  public static u gyA()
  {
    AppMethodBeat.i(300942);
    Object localObject1 = new u(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
    String[] arrayOfString = Build.SUPPORTED_ABIS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      localObject2 = "oat/" + aRs((String)localObject2) + "/base.vdex";
      localObject2 = new u(((u)localObject1).jKP(), (String)localObject2);
      if (((u)localObject2).jKQ())
      {
        AppMethodBeat.o(300942);
        return localObject2;
      }
      i += 1;
    }
    localObject1 = new IOException("cannot find readable base vdex path.");
    AppMethodBeat.o(300942);
    throw ((Throwable)localObject1);
  }
  
  public static u gyB()
  {
    AppMethodBeat.i(300947);
    u localu = new u(MMApplicationContext.getContext().getExternalCacheDir(), com.tencent.mm.plugin.performance.a.b.aRr("¢´½¾¤¨£¤"));
    AppMethodBeat.o(300947);
    return localu;
  }
  
  public static u gyy()
  {
    AppMethodBeat.i(300927);
    u localu = W(new u(MMApplicationContext.getContext().getApplicationInfo().sourceDir));
    AppMethodBeat.o(300927);
    return localu;
  }
  
  public static u gyz()
  {
    AppMethodBeat.i(300938);
    Object localObject1 = new u(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
    String[] arrayOfString = Build.SUPPORTED_ABIS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      localObject2 = "oat/" + aRs((String)localObject2) + "/base.odex";
      localObject2 = new u(((u)localObject1).jKP(), (String)localObject2);
      if (((u)localObject2).jKQ())
      {
        AppMethodBeat.o(300938);
        return localObject2;
      }
      i += 1;
    }
    localObject1 = new IOException("cannot find readable base odex path.");
    AppMethodBeat.o(300938);
    throw ((Throwable)localObject1);
  }
  
  public static u kS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(300954);
    paramString1 = new u(gyB(), paramString1 + paramString2);
    paramString1.jKP().jKY();
    if (!paramString1.jKZ())
    {
      paramString1 = new IOException("cannot createNewFile:" + ah.v(paramString1.jKT()));
      AppMethodBeat.o(300954);
      throw paramString1;
    }
    AppMethodBeat.o(300954);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.b
 * JD-Core Version:    0.7.0.1
 */