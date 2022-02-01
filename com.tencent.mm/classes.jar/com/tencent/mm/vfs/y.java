package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public final class y
{
  /* Error */
  private static boolean L(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: sipush 13304
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 22	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: sipush 13304
    //   20: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: invokestatic 29	com/tencent/mm/vfs/y:bEo	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 33	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   32: pop
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 5
    //   40: new 35	java/util/zip/ZipOutputStream
    //   43: dup
    //   44: aload_1
    //   45: iconst_0
    //   46: invokestatic 39	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   49: invokespecial 43	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore 4
    //   54: aload_0
    //   55: invokeinterface 49 1 0
    //   60: astore 6
    //   62: aload 6
    //   64: invokeinterface 54 1 0
    //   69: ifeq +301 -> 370
    //   72: aload 6
    //   74: invokeinterface 58 1 0
    //   79: checkcast 18	java/lang/String
    //   82: invokestatic 64	com/tencent/mm/vfs/ah:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   85: astore_0
    //   86: invokestatic 70	com/tencent/mm/vfs/k:kMs	()Lcom/tencent/mm/vfs/k;
    //   89: aload_0
    //   90: aconst_null
    //   91: invokevirtual 74	com/tencent/mm/vfs/k:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/k$f;)Lcom/tencent/mm/vfs/k$f;
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 79	com/tencent/mm/vfs/k$f:boj	()Z
    //   99: ifeq -37 -> 62
    //   102: aload_0
    //   103: getfield 83	com/tencent/mm/vfs/k$f:agxM	Lcom/tencent/mm/vfs/FileSystem$b;
    //   106: aload_0
    //   107: getfield 87	com/tencent/mm/vfs/k$f:path	Ljava/lang/String;
    //   110: invokeinterface 93 2 0
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull -55 -> 62
    //   120: aload_1
    //   121: getfield 99	com/tencent/mm/vfs/j:agxh	Z
    //   124: ifeq +186 -> 310
    //   127: aload_0
    //   128: getfield 87	com/tencent/mm/vfs/k$f:path	Ljava/lang/String;
    //   131: invokevirtual 103	java/lang/String:length	()I
    //   134: istore_3
    //   135: aload_0
    //   136: getfield 87	com/tencent/mm/vfs/k$f:path	Ljava/lang/String;
    //   139: ldc 105
    //   141: invokevirtual 108	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   144: ifeq +161 -> 305
    //   147: iconst_0
    //   148: istore_2
    //   149: aload_0
    //   150: getfield 83	com/tencent/mm/vfs/k$f:agxM	Lcom/tencent/mm/vfs/FileSystem$b;
    //   153: aload_0
    //   154: getfield 87	com/tencent/mm/vfs/k$f:path	Ljava/lang/String;
    //   157: invokestatic 111	com/tencent/mm/vfs/ah:a	(Lcom/tencent/mm/vfs/FileSystem$b;Ljava/lang/String;)Ljava/lang/Iterable;
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull -100 -> 62
    //   165: iload_2
    //   166: iload_3
    //   167: iadd
    //   168: istore_2
    //   169: aload_0
    //   170: invokeinterface 114 1 0
    //   175: astore 7
    //   177: aload 7
    //   179: invokeinterface 54 1 0
    //   184: ifeq -122 -> 62
    //   187: aload 7
    //   189: invokeinterface 58 1 0
    //   194: checkcast 95	com/tencent/mm/vfs/j
    //   197: astore_0
    //   198: aload_0
    //   199: getfield 99	com/tencent/mm/vfs/j:agxh	Z
    //   202: ifne -25 -> 177
    //   205: aload_0
    //   206: getfield 117	com/tencent/mm/vfs/j:acpB	Ljava/lang/String;
    //   209: invokevirtual 103	java/lang/String:length	()I
    //   212: iload_2
    //   213: if_icmpge +119 -> 332
    //   216: aload_0
    //   217: getfield 120	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 123	com/tencent/mm/vfs/j:agxi	Lcom/tencent/mm/vfs/FileSystem$b;
    //   225: aload_0
    //   226: getfield 117	com/tencent/mm/vfs/j:acpB	Ljava/lang/String;
    //   229: invokeinterface 127 2 0
    //   234: astore_0
    //   235: aload 4
    //   237: new 129	java/util/zip/ZipEntry
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 132	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   245: invokevirtual 136	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   248: aload_0
    //   249: aload 5
    //   251: invokevirtual 142	java/io/InputStream:read	([B)I
    //   254: istore_3
    //   255: iload_3
    //   256: iflt +88 -> 344
    //   259: aload 4
    //   261: aload 5
    //   263: iconst_0
    //   264: iload_3
    //   265: invokevirtual 146	java/util/zip/ZipOutputStream:write	([BII)V
    //   268: goto -20 -> 248
    //   271: astore 5
    //   273: aload 4
    //   275: astore_1
    //   276: aload 5
    //   278: astore 4
    //   280: ldc 148
    //   282: aload 4
    //   284: ldc 150
    //   286: invokestatic 156	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   289: aload_0
    //   290: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   293: aload_1
    //   294: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   297: sipush 13304
    //   300: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: iconst_0
    //   304: ireturn
    //   305: iconst_1
    //   306: istore_2
    //   307: goto -158 -> 149
    //   310: aload_0
    //   311: getfield 87	com/tencent/mm/vfs/k$f:path	Ljava/lang/String;
    //   314: bipush 47
    //   316: invokevirtual 164	java/lang/String:lastIndexOf	(I)I
    //   319: istore_2
    //   320: aload_1
    //   321: invokestatic 170	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   324: astore_0
    //   325: iload_2
    //   326: iconst_1
    //   327: iadd
    //   328: istore_2
    //   329: goto -160 -> 169
    //   332: aload_0
    //   333: getfield 117	com/tencent/mm/vfs/j:acpB	Ljava/lang/String;
    //   336: iload_2
    //   337: invokevirtual 174	java/lang/String:substring	(I)Ljava/lang/String;
    //   340: astore_1
    //   341: goto -120 -> 221
    //   344: aload_0
    //   345: invokevirtual 178	java/io/InputStream:close	()V
    //   348: aload 4
    //   350: invokevirtual 181	java/util/zip/ZipOutputStream:closeEntry	()V
    //   353: goto -176 -> 177
    //   356: astore 5
    //   358: aload 4
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_0
    //   363: aload 5
    //   365: astore 4
    //   367: goto -87 -> 280
    //   370: aconst_null
    //   371: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   374: aload 4
    //   376: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   379: sipush 13304
    //   382: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: iconst_1
    //   386: ireturn
    //   387: astore_1
    //   388: aconst_null
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_0
    //   393: aload_0
    //   394: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   397: aload 4
    //   399: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   402: sipush 13304
    //   405: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: aconst_null
    //   412: astore_0
    //   413: goto -20 -> 393
    //   416: astore_1
    //   417: goto -24 -> 393
    //   420: astore 5
    //   422: aload_1
    //   423: astore 4
    //   425: aload 5
    //   427: astore_1
    //   428: goto -35 -> 393
    //   431: astore 4
    //   433: aconst_null
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_0
    //   437: goto -157 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramList	java.util.List<String>
    //   0	440	1	paramString	String
    //   148	189	2	i	int
    //   134	131	3	j	int
    //   52	372	4	localObject1	Object
    //   431	1	4	localIOException1	IOException
    //   38	224	5	arrayOfByte	byte[]
    //   271	6	5	localIOException2	IOException
    //   356	8	5	localIOException3	IOException
    //   420	6	5	localObject2	Object
    //   60	13	6	localIterator1	Iterator
    //   175	13	7	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   235	248	271	java/io/IOException
    //   248	255	271	java/io/IOException
    //   259	268	271	java/io/IOException
    //   344	348	271	java/io/IOException
    //   54	62	356	java/io/IOException
    //   62	116	356	java/io/IOException
    //   120	147	356	java/io/IOException
    //   149	161	356	java/io/IOException
    //   169	177	356	java/io/IOException
    //   177	221	356	java/io/IOException
    //   221	235	356	java/io/IOException
    //   310	325	356	java/io/IOException
    //   332	341	356	java/io/IOException
    //   348	353	356	java/io/IOException
    //   40	54	387	finally
    //   54	62	410	finally
    //   62	116	410	finally
    //   120	147	410	finally
    //   149	161	410	finally
    //   169	177	410	finally
    //   177	221	410	finally
    //   221	235	410	finally
    //   310	325	410	finally
    //   332	341	410	finally
    //   348	353	410	finally
    //   235	248	416	finally
    //   248	255	416	finally
    //   259	268	416	finally
    //   344	348	416	finally
    //   280	289	420	finally
    //   40	54	431	java/io/IOException
  }
  
  public static InputStream Lh(String paramString)
  {
    AppMethodBeat.i(13264);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13264);
      throw paramString;
    }
    paramString = b(ah.parseUri(paramString), null);
    AppMethodBeat.o(13264);
    return paramString;
  }
  
  public static long O(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(238437);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(238437);
      return -1L;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(238437);
      return -1L;
    }
    k.f localf1 = k.kMs().a(ah.parseUri(paramString1), null);
    k.f localf2 = k.kMs().a(ah.parseUri(paramString2), null);
    if ((!localf1.boj()) || (!localf2.boj()))
    {
      AppMethodBeat.o(238437);
      return -1L;
    }
    try
    {
      long l = localf2.agxM.a(localf2.path, localf1.agxM, localf1.path, paramBoolean);
      AppMethodBeat.o(238437);
      return l;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.VFSFileOp", "Failed to copy file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
      AppMethodBeat.o(238437);
    }
    return -1L;
  }
  
  public static boolean ZC(String paramString)
  {
    AppMethodBeat.i(13287);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13287);
      return false;
    }
    paramString = ah.parseUri(paramString);
    paramString = k.kMs().a(paramString, null);
    if (!paramString.boj())
    {
      AppMethodBeat.o(13287);
      return false;
    }
    boolean bool = paramString.agxM.bDU(paramString.path);
    AppMethodBeat.o(13287);
    return bool;
  }
  
  public static ParcelFileDescriptor a(Uri paramUri, k.f paramf, String paramString)
  {
    AppMethodBeat.i(13275);
    paramf = k.kMs().a(paramUri, paramf);
    if (!paramf.boj())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13275);
      throw paramUri;
    }
    paramUri = paramf.agxM.qf(paramf.path, paramString);
    AppMethodBeat.o(13275);
    return paramUri;
  }
  
  static OutputStream a(Uri paramUri, k.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(13271);
    paramf = k.kMs().a(paramUri, paramf);
    if (!paramf.boj())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13271);
      throw paramUri;
    }
    paramUri = paramf.agxM.ev(paramf.path, paramBoolean);
    AppMethodBeat.o(13271);
    return paramUri;
  }
  
  public static RandomAccessFile a(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13273);
    String str = ah.b(paramUri, paramBoolean);
    if (str == null)
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13273);
      throw paramUri;
    }
    if (paramBoolean) {}
    for (paramUri = "rw";; paramUri = "r")
    {
      paramUri = new RandomAccessFile(str, paramUri);
      AppMethodBeat.o(13273);
      return paramUri;
    }
  }
  
  private static boolean a(k.f paramf1, final k.f paramf2, boolean paramBoolean)
  {
    AppMethodBeat.i(13292);
    if ((!paramf1.boj()) || (!paramf2.boj()))
    {
      AppMethodBeat.o(13292);
      return false;
    }
    final HashSet localHashSet = new HashSet();
    int i = paramf1.path.length();
    if (!paramBoolean) {}
    for (Object localObject = null;; localObject = new ah.a()
        {
          public final boolean b(j paramAnonymousj)
          {
            AppMethodBeat.i(238269);
            String str2 = paramAnonymousj.acpB.substring(this.agAd);
            String str1 = str2;
            if (!str2.startsWith("/")) {
              str1 = "/".concat(String.valueOf(str2));
            }
            str1 = paramf2.path + str1;
            try
            {
              bool = paramf2.agxM.a(str1, paramAnonymousj.agxi, paramAnonymousj.acpB);
              if (bool) {
                localHashSet.add(str1);
              }
              if (!bool)
              {
                AppMethodBeat.o(238269);
                return true;
              }
            }
            catch (IOException paramAnonymousj)
            {
              for (;;)
              {
                boolean bool = false;
              }
              AppMethodBeat.o(238269);
            }
            return false;
          }
        })
    {
      paramf1 = ah.a(paramf1.agxM, paramf1.path, false, (ah.a)localObject);
      if (paramf1 != null) {
        break;
      }
      AppMethodBeat.o(13292);
      return false;
    }
    paramf2.agxM.bDX(paramf2.path);
    localHashSet.add(paramf2.path);
    Iterator localIterator = paramf1.iterator();
    j localj;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label422;
      }
      localj = (j)localIterator.next();
      localObject = localj.acpB.substring(i);
      paramf1 = (k.f)localObject;
      if (!((String)localObject).startsWith("/")) {
        paramf1 = "/".concat(String.valueOf(localObject));
      }
      paramf1 = paramf2.path + paramf1;
      if (localj.agxh)
      {
        if (localHashSet.add(paramf1)) {
          paramf2.agxM.bDX(paramf1);
        }
      }
      else
      {
        int j = paramf1.lastIndexOf('/');
        if (j > 0)
        {
          localObject = paramf1.substring(0, j);
          if (localHashSet.add(localObject)) {
            paramf2.agxM.bDX((String)localObject);
          }
        }
        if (paramBoolean) {
          try
          {
            if (!paramf2.agxM.a(paramf1, localj.agxi, localj.acpB))
            {
              paramf2.agxM.a(paramf1, localj.agxi, localj.acpB, false);
              localj.NP(true);
            }
          }
          catch (IOException paramf2)
          {
            localObject = new StringBuilder("Failed to ");
            if (!paramBoolean) {}
          }
        }
      }
    }
    for (paramf1 = "move";; paramf1 = "copy")
    {
      Log.w("MicroMsg.VFSFileOp", paramf2, paramf1 + " files.");
      AppMethodBeat.o(13292);
      return false;
      paramf2.agxM.a(paramf1, localj.agxi, localj.acpB, false);
      break;
    }
    label422:
    AppMethodBeat.o(13292);
    return true;
  }
  
  /* Error */
  public static int aA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 13303
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 301	java/util/zip/ZipInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 302	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: invokespecial 305	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: new 263	java/util/HashSet
    //   23: dup
    //   24: invokespecial 265	java/util/HashSet:<init>	()V
    //   27: astore 4
    //   29: aload_3
    //   30: astore_0
    //   31: sipush 4096
    //   34: newarray byte
    //   36: astore 5
    //   38: aload_3
    //   39: astore_0
    //   40: aload_3
    //   41: invokevirtual 309	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnull +328 -> 376
    //   51: aload_3
    //   52: astore_0
    //   53: aload 7
    //   55: invokevirtual 312	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   58: astore 6
    //   60: aload_3
    //   61: astore_0
    //   62: aload 6
    //   64: ldc_w 314
    //   67: invokevirtual 318	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   70: ifne -32 -> 38
    //   73: aload_3
    //   74: astore_0
    //   75: aload 6
    //   77: ldc_w 320
    //   80: invokevirtual 318	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   83: ifne -45 -> 38
    //   86: aload_3
    //   87: astore_0
    //   88: aload 7
    //   90: invokevirtual 323	java/util/zip/ZipEntry:isDirectory	()Z
    //   93: ifeq +96 -> 189
    //   96: aload_3
    //   97: astore_0
    //   98: aload 6
    //   100: iconst_0
    //   101: aload 6
    //   103: invokevirtual 103	java/lang/String:length	()I
    //   106: iconst_1
    //   107: isub
    //   108: invokevirtual 282	java/lang/String:substring	(II)Ljava/lang/String;
    //   111: astore 6
    //   113: aload_3
    //   114: astore_0
    //   115: aload 4
    //   117: aload 6
    //   119: invokevirtual 275	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   122: ifeq -84 -> 38
    //   125: aload_3
    //   126: astore_0
    //   127: new 325	com/tencent/mm/vfs/u
    //   130: dup
    //   131: new 207	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   138: aload_1
    //   139: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 105
    //   144: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 6
    //   149: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 326	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 329	com/tencent/mm/vfs/u:jKY	()Z
    //   161: pop
    //   162: goto -124 -> 38
    //   165: astore_1
    //   166: aload_3
    //   167: astore_0
    //   168: ldc 148
    //   170: aload_1
    //   171: ldc_w 331
    //   174: invokestatic 156	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   177: aload_3
    //   178: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   181: sipush 13303
    //   184: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iconst_m1
    //   188: ireturn
    //   189: aload_3
    //   190: astore_0
    //   191: new 325	com/tencent/mm/vfs/u
    //   194: dup
    //   195: new 207	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   202: aload_1
    //   203: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 105
    //   208: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 6
    //   213: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 326	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   222: astore 7
    //   224: aload_3
    //   225: astore_0
    //   226: aload 6
    //   228: invokestatic 334	com/tencent/mm/vfs/ah:bEv	(Ljava/lang/String;)Ljava/lang/String;
    //   231: astore 6
    //   233: aload 6
    //   235: ifnull +52 -> 287
    //   238: aload_3
    //   239: astore_0
    //   240: aload 4
    //   242: aload 6
    //   244: invokevirtual 275	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   247: ifeq +40 -> 287
    //   250: aload_3
    //   251: astore_0
    //   252: new 325	com/tencent/mm/vfs/u
    //   255: dup
    //   256: new 207	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   263: aload_1
    //   264: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 105
    //   269: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 6
    //   274: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 326	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   283: invokevirtual 329	com/tencent/mm/vfs/u:jKY	()Z
    //   286: pop
    //   287: aload_3
    //   288: astore_0
    //   289: aload 7
    //   291: invokestatic 338	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   294: astore 6
    //   296: aload_3
    //   297: astore_0
    //   298: aload_3
    //   299: aload 5
    //   301: invokevirtual 339	java/util/zip/ZipInputStream:read	([B)I
    //   304: istore_2
    //   305: iload_2
    //   306: iconst_m1
    //   307: if_icmpeq +42 -> 349
    //   310: aload_3
    //   311: astore_0
    //   312: aload 6
    //   314: aload 5
    //   316: iconst_0
    //   317: iload_2
    //   318: invokevirtual 342	java/io/OutputStream:write	([BII)V
    //   321: goto -25 -> 296
    //   324: astore_1
    //   325: aload_3
    //   326: astore_0
    //   327: ldc 148
    //   329: aload_1
    //   330: ldc_w 331
    //   333: invokestatic 156	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   336: aload_3
    //   337: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   340: sipush 13303
    //   343: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: bipush 254
    //   348: ireturn
    //   349: aload_3
    //   350: astore_0
    //   351: aload 6
    //   353: invokevirtual 343	java/io/OutputStream:close	()V
    //   356: goto -318 -> 38
    //   359: astore_3
    //   360: aload_0
    //   361: astore_1
    //   362: aload_3
    //   363: astore_0
    //   364: aload_1
    //   365: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   368: sipush 13303
    //   371: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload_0
    //   375: athrow
    //   376: aload_3
    //   377: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   380: sipush 13303
    //   383: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: iconst_0
    //   387: ireturn
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: goto -27 -> 364
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -72 -> 325
    //   400: astore_1
    //   401: aconst_null
    //   402: astore_3
    //   403: goto -237 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramString1	String
    //   0	406	1	paramString2	String
    //   304	14	2	i	int
    //   17	333	3	localZipInputStream	java.util.zip.ZipInputStream
    //   359	18	3	localCloseable	java.io.Closeable
    //   396	7	3	localObject1	Object
    //   27	214	4	localHashSet	HashSet
    //   36	279	5	arrayOfByte	byte[]
    //   58	294	6	localObject2	Object
    //   44	246	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	165	java/io/FileNotFoundException
    //   31	38	165	java/io/FileNotFoundException
    //   40	46	165	java/io/FileNotFoundException
    //   53	60	165	java/io/FileNotFoundException
    //   62	73	165	java/io/FileNotFoundException
    //   75	86	165	java/io/FileNotFoundException
    //   88	96	165	java/io/FileNotFoundException
    //   98	113	165	java/io/FileNotFoundException
    //   115	125	165	java/io/FileNotFoundException
    //   127	162	165	java/io/FileNotFoundException
    //   191	224	165	java/io/FileNotFoundException
    //   226	233	165	java/io/FileNotFoundException
    //   240	250	165	java/io/FileNotFoundException
    //   252	287	165	java/io/FileNotFoundException
    //   289	296	165	java/io/FileNotFoundException
    //   298	305	165	java/io/FileNotFoundException
    //   312	321	165	java/io/FileNotFoundException
    //   351	356	165	java/io/FileNotFoundException
    //   20	29	324	java/io/IOException
    //   31	38	324	java/io/IOException
    //   40	46	324	java/io/IOException
    //   53	60	324	java/io/IOException
    //   62	73	324	java/io/IOException
    //   75	86	324	java/io/IOException
    //   88	96	324	java/io/IOException
    //   98	113	324	java/io/IOException
    //   115	125	324	java/io/IOException
    //   127	162	324	java/io/IOException
    //   191	224	324	java/io/IOException
    //   226	233	324	java/io/IOException
    //   240	250	324	java/io/IOException
    //   252	287	324	java/io/IOException
    //   289	296	324	java/io/IOException
    //   298	305	324	java/io/IOException
    //   312	321	324	java/io/IOException
    //   351	356	324	java/io/IOException
    //   20	29	359	finally
    //   31	38	359	finally
    //   40	46	359	finally
    //   53	60	359	finally
    //   62	73	359	finally
    //   75	86	359	finally
    //   88	96	359	finally
    //   98	113	359	finally
    //   115	125	359	finally
    //   127	162	359	finally
    //   168	177	359	finally
    //   191	224	359	finally
    //   226	233	359	finally
    //   240	250	359	finally
    //   252	287	359	finally
    //   289	296	359	finally
    //   298	305	359	finally
    //   312	321	359	finally
    //   327	336	359	finally
    //   351	356	359	finally
    //   6	18	388	finally
    //   6	18	394	java/io/IOException
    //   6	18	400	java/io/FileNotFoundException
  }
  
  public static String alV(String paramString)
  {
    AppMethodBeat.i(13298);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13298);
      return "";
    }
    paramString = new u(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1))
    {
      AppMethodBeat.o(13298);
      return "";
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(13298);
    return paramString;
  }
  
  public static InputStream ao(u paramu)
  {
    AppMethodBeat.i(13265);
    paramu = b(paramu.mUri, paramu.jKM());
    AppMethodBeat.o(13265);
    return paramu;
  }
  
  public static OutputStream ap(u paramu)
  {
    AppMethodBeat.i(13268);
    paramu = a(paramu.mUri, paramu.jKM(), false);
    AppMethodBeat.o(13268);
    return paramu;
  }
  
  public static InputStream b(Uri paramUri, k.f paramf)
  {
    AppMethodBeat.i(13266);
    paramf = k.kMs().a(paramUri, paramf);
    if (!paramf.boj())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13266);
      throw paramUri;
    }
    paramUri = paramf.agxM.Lh(paramf.path);
    AppMethodBeat.o(13266);
    return paramUri;
  }
  
  public static boolean bDX(String paramString)
  {
    AppMethodBeat.i(13285);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13285);
      return false;
    }
    paramString = new u(paramString);
    if ((paramString.jKY()) || (paramString.isDirectory()))
    {
      AppMethodBeat.o(13285);
      return true;
    }
    AppMethodBeat.o(13285);
    return false;
  }
  
  public static long bEl(String paramString)
  {
    AppMethodBeat.i(13278);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = ah.parseUri(paramString);
    paramString = k.kMs().a(paramString, null);
    if (!paramString.boj())
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = paramString.agxM.bDV(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    long l = paramString.size;
    AppMethodBeat.o(13278);
    return l;
  }
  
  public static long bEm(String paramString)
  {
    AppMethodBeat.i(13279);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = ah.parseUri(paramString);
    paramString = k.kMs().a(paramString, null);
    if (!paramString.boj())
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = paramString.agxM.bDV(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    long l = paramString.agxg;
    AppMethodBeat.o(13279);
    return l;
  }
  
  /* Error */
  public static String bEn(String paramString)
  {
    // Byte code:
    //   0: sipush 13281
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 207	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: new 371	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokestatic 302	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 372	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: sipush 512
    //   32: newarray char
    //   34: astore 5
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: aload 5
    //   41: invokevirtual 375	java/io/InputStreamReader:read	([C)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +72 -> 119
    //   50: aload_3
    //   51: astore_2
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 378	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 4
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 148
    //   71: ldc_w 380
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 4
    //   86: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 384	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: astore_2
    //   95: sipush 13281
    //   98: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_3
    //   102: astore_2
    //   103: aload 4
    //   105: athrow
    //   106: astore_0
    //   107: aload_2
    //   108: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   111: sipush 13281
    //   114: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: aload_3
    //   120: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 4
    //   125: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore_0
    //   129: sipush 13281
    //   132: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_2
    //   140: goto -33 -> 107
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_3
    //   147: goto -80 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   44	14	1	i	int
    //   28	112	2	localInputStreamReader1	java.io.InputStreamReader
    //   26	121	3	localInputStreamReader2	java.io.InputStreamReader
    //   13	40	4	localStringBuilder	StringBuilder
    //   65	59	4	localIOException1	IOException
    //   143	1	4	localIOException2	IOException
    //   34	21	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   29	36	65	java/io/IOException
    //   38	45	65	java/io/IOException
    //   52	62	65	java/io/IOException
    //   29	36	106	finally
    //   38	45	106	finally
    //   52	62	106	finally
    //   69	93	106	finally
    //   95	101	106	finally
    //   103	106	106	finally
    //   15	27	137	finally
    //   15	27	143	java/io/IOException
  }
  
  public static String bEo(String paramString)
  {
    AppMethodBeat.i(13284);
    paramString = new u(paramString).jKU().jKO();
    AppMethodBeat.o(13284);
    return paramString;
  }
  
  public static boolean bEp(String paramString)
  {
    AppMethodBeat.i(13297);
    try
    {
      paramString = new u(paramString);
      if ((paramString.jKS()) || (paramString.jKZ()))
      {
        AppMethodBeat.o(13297);
        return true;
      }
      AppMethodBeat.o(13297);
      return false;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(13297);
    }
    return false;
  }
  
  public static String bEq(String paramString)
  {
    AppMethodBeat.i(13299);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13299);
      return "";
    }
    String str = new u(paramString).getName();
    int i = str.lastIndexOf('.');
    if (i < 0)
    {
      AppMethodBeat.o(13299);
      return paramString;
    }
    if (i == 0)
    {
      AppMethodBeat.o(13299);
      return "";
    }
    paramString = str.substring(0, i);
    AppMethodBeat.o(13299);
    return paramString;
  }
  
  public static void bEr(String paramString)
  {
    AppMethodBeat.i(13300);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13300);
      return;
    }
    paramString = ah.parseUri(paramString);
    paramString = k.kMs().a(paramString, null);
    if (!paramString.boj())
    {
      AppMethodBeat.o(13300);
      return;
    }
    if ((paramString.agxM.jKc() & 0x2) == 0)
    {
      AppMethodBeat.o(13300);
      return;
    }
    if (paramString.agxM.ex(paramString.path, true) == null)
    {
      AppMethodBeat.o(13300);
      return;
    }
    try
    {
      paramString.agxM.ev(paramString.path + "/.nomedia", false).close();
      AppMethodBeat.o(13300);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(13300);
    }
  }
  
  /* Error */
  public static byte[] bEs(String paramString)
  {
    // Byte code:
    //   0: sipush 13301
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 13301
    //   13: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 302	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: ldc_w 415
    //   26: invokestatic 421	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_2
    //   30: sipush 2048
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 142	java/io/InputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iflt +26 -> 69
    //   46: aload_2
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 424	java/security/MessageDigest:update	([BII)V
    //   53: goto -17 -> 36
    //   56: astore_2
    //   57: aload_0
    //   58: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   61: sipush 13301
    //   64: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_2
    //   70: invokevirtual 428	java/security/MessageDigest:digest	()[B
    //   73: astore_2
    //   74: aload_0
    //   75: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   78: sipush 13301
    //   81: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_2
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   93: sipush 13301
    //   96: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: athrow
    //   101: astore_2
    //   102: aload_0
    //   103: astore_3
    //   104: aload_2
    //   105: astore_0
    //   106: aload_3
    //   107: astore_2
    //   108: goto -19 -> 89
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -57 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   41	9	1	i	int
    //   29	18	2	localMessageDigest	java.security.MessageDigest
    //   56	14	2	localException	Exception
    //   73	17	2	arrayOfByte	byte[]
    //   101	4	2	localObject1	Object
    //   107	1	2	localObject2	Object
    //   35	72	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   23	36	56	java/lang/Exception
    //   36	42	56	java/lang/Exception
    //   46	53	56	java/lang/Exception
    //   69	74	56	java/lang/Exception
    //   18	23	86	finally
    //   23	36	101	finally
    //   36	42	101	finally
    //   46	53	101	finally
    //   69	74	101	finally
    //   18	23	111	java/lang/Exception
  }
  
  public static boolean bF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(13289);
    boolean bool = qn(paramString1 + paramString2, paramString1 + paramString3);
    AppMethodBeat.o(13289);
    return bool;
  }
  
  /* Error */
  public static byte[] bi(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 13280
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 13280
    //   13: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: iload_2
    //   19: iflt +10 -> 29
    //   22: iload_2
    //   23: ldc_w 437
    //   26: if_icmple +263 -> 289
    //   29: sipush 4096
    //   32: istore_3
    //   33: new 439	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: iload_3
    //   38: invokespecial 441	java/io/ByteArrayOutputStream:<init>	(I)V
    //   41: astore 8
    //   43: aload_0
    //   44: invokestatic 302	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore 7
    //   49: iload_1
    //   50: i2l
    //   51: lstore 4
    //   53: lload 4
    //   55: lconst_0
    //   56: lcmp
    //   57: ifle +22 -> 79
    //   60: aload 7
    //   62: astore 6
    //   64: lload 4
    //   66: aload 7
    //   68: lload 4
    //   70: invokevirtual 445	java/io/InputStream:skip	(J)J
    //   73: lsub
    //   74: lstore 4
    //   76: goto -23 -> 53
    //   79: aload 7
    //   81: astore 6
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore 9
    //   90: iload_2
    //   91: istore_1
    //   92: iload_2
    //   93: ifge +7 -> 100
    //   96: ldc_w 446
    //   99: istore_1
    //   100: aload 7
    //   102: astore 6
    //   104: aload 7
    //   106: aload 9
    //   108: iconst_0
    //   109: iload_1
    //   110: sipush 1024
    //   113: invokestatic 452	java/lang/Math:min	(II)I
    //   116: invokevirtual 455	java/io/InputStream:read	([BII)I
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_m1
    //   122: if_icmpeq +27 -> 149
    //   125: iload_1
    //   126: ifle +23 -> 149
    //   129: aload 7
    //   131: astore 6
    //   133: aload 8
    //   135: aload 9
    //   137: iconst_0
    //   138: iload_2
    //   139: invokevirtual 456	java/io/ByteArrayOutputStream:write	([BII)V
    //   142: iload_1
    //   143: iload_2
    //   144: isub
    //   145: istore_1
    //   146: goto -46 -> 100
    //   149: aload 7
    //   151: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   154: aload 8
    //   156: invokevirtual 459	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   159: astore 6
    //   161: aload 8
    //   163: invokevirtual 460	java/io/ByteArrayOutputStream:close	()V
    //   166: ldc 148
    //   168: ldc_w 462
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_0
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 6
    //   183: arraylength
    //   184: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: invokestatic 470	com/tencent/stubs/logger/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: sipush 13280
    //   194: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload 6
    //   199: areturn
    //   200: astore 8
    //   202: aconst_null
    //   203: astore 7
    //   205: aload 7
    //   207: astore 6
    //   209: ldc 148
    //   211: new 207	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 472
    //   218: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 474
    //   228: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 8
    //   233: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 228	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload 7
    //   247: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   250: sipush 13280
    //   253: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 6
    //   262: aload 6
    //   264: invokestatic 160	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   267: sipush 13280
    //   270: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_0
    //   274: athrow
    //   275: astore 7
    //   277: goto -111 -> 166
    //   280: astore_0
    //   281: goto -19 -> 262
    //   284: astore 8
    //   286: goto -81 -> 205
    //   289: iload_2
    //   290: istore_3
    //   291: goto -258 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramString	String
    //   0	294	1	paramInt1	int
    //   0	294	2	paramInt2	int
    //   32	259	3	i	int
    //   51	24	4	l	long
    //   62	201	6	localObject	Object
    //   47	199	7	localInputStream	InputStream
    //   275	1	7	localIOException1	IOException
    //   41	121	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   200	32	8	localIOException2	IOException
    //   284	1	8	localIOException3	IOException
    //   88	48	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   43	49	200	java/io/IOException
    //   43	49	258	finally
    //   161	166	275	java/io/IOException
    //   64	76	280	finally
    //   83	90	280	finally
    //   104	120	280	finally
    //   133	142	280	finally
    //   209	245	280	finally
    //   64	76	284	java/io/IOException
    //   83	90	284	java/io/IOException
    //   104	120	284	java/io/IOException
    //   133	142	284	java/io/IOException
  }
  
  public static String bub(String paramString)
  {
    AppMethodBeat.i(13302);
    paramString = bEs(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(13302);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuilder.append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(13302);
    return paramString;
  }
  
  public static ReadableByteChannel c(Uri paramUri, k.f paramf)
  {
    AppMethodBeat.i(170165);
    paramf = k.kMs().a(paramUri, paramf);
    if (!paramf.boj())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(170165);
      throw paramUri;
    }
    paramUri = paramf.agxM.bDS(paramf.path);
    AppMethodBeat.o(170165);
    return paramUri;
  }
  
  public static WritableByteChannel d(Uri paramUri, k.f paramf)
  {
    AppMethodBeat.i(238350);
    paramf = k.kMs().a(paramUri, paramf);
    if (!paramf.boj())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(238350);
      throw paramUri;
    }
    paramUri = paramf.agxM.et(paramf.path, false);
    AppMethodBeat.o(238350);
    return paramUri;
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(13288);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13288);
      return false;
    }
    boolean bool = new u(paramString).diJ();
    AppMethodBeat.o(13288);
    return bool;
  }
  
  public static int e(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(13277);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length < paramInt + 0))
    {
      AppMethodBeat.o(13277);
      return -2;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = ev(paramString, true);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, 0, paramInt);
      return 0;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      Log.w("MicroMsg.VFSFileOp", localException, "");
      localObject2 = localObject1;
      Log.w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
      return -1;
    }
    finally
    {
      ah.closeQuietly(localObject2);
      AppMethodBeat.o(13277);
    }
  }
  
  public static OutputStream e(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(170167);
    paramu = a(paramu.mUri, paramu.jKM(), paramBoolean);
    AppMethodBeat.o(170167);
    return paramu;
  }
  
  public static RandomAccessFile eA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13272);
    paramString = a(ah.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13272);
    return paramString;
  }
  
  public static Iterable<j> eB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13291);
    paramString = ah.parseUri(paramString);
    paramString = k.kMs().a(paramString, null);
    if (!paramString.boj())
    {
      AppMethodBeat.o(13291);
      return null;
    }
    if (paramBoolean)
    {
      paramString = ah.a(paramString.agxM, paramString.path);
      AppMethodBeat.o(13291);
      return paramString;
    }
    paramString = paramString.agxM.bDW(paramString.path);
    AppMethodBeat.o(13291);
    return paramString;
  }
  
  public static OutputStream ev(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13269);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13269);
      throw paramString;
    }
    paramString = a(ah.parseUri(paramString), null, paramBoolean);
    AppMethodBeat.o(13269);
    return paramString;
  }
  
  public static boolean ew(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13296);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramString = ah.parseUri(paramString);
    paramString = k.kMs().a(paramString, null);
    if (!paramString.boj())
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramBoolean = paramString.agxM.ew(paramString.path, paramBoolean);
    AppMethodBeat.o(13296);
    return paramBoolean;
  }
  
  public static int f(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(13283);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(13283);
      return -2;
    }
    if (paramArrayOfByte.length < paramInt + 0)
    {
      AppMethodBeat.o(13283);
      return -3;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = ev(paramString, false);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, 0, paramInt);
      return 0;
    }
    catch (IOException paramArrayOfByte)
    {
      localObject2 = localObject1;
      Log.e("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", new Object[] { paramString, paramArrayOfByte.getMessage() });
      return -1;
    }
    finally
    {
      ah.closeQuietly(localObject2);
      AppMethodBeat.o(13283);
    }
  }
  
  public static String n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13276);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13276);
      return null;
    }
    paramString = ah.b(ah.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13276);
    return paramString;
  }
  
  public static ParcelFileDescriptor qk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13274);
    paramString1 = a(ah.parseUri(paramString1), null, paramString2);
    AppMethodBeat.o(13274);
    return paramString1;
  }
  
  public static long ql(String paramString1, String paramString2)
  {
    AppMethodBeat.i(369571);
    long l = O(paramString1, paramString2, false);
    AppMethodBeat.o(369571);
    return l;
  }
  
  public static boolean qm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(369572);
    boolean bool = qn(paramString1, paramString2);
    AppMethodBeat.o(369572);
    return bool;
  }
  
  public static boolean qn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238462);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(238462);
      return false;
    }
    k.f localf1 = k.kMs().a(ah.parseUri(paramString1), null);
    k.f localf2 = k.kMs().a(ah.parseUri(paramString2), null);
    if ((!localf1.boj()) || (!localf2.boj()))
    {
      AppMethodBeat.o(238462);
      return false;
    }
    try
    {
      boolean bool1 = localf2.agxM.a(localf2.path, localf1.agxM, localf1.path);
      boolean bool2 = bool1;
      if (!bool1) {
        if (localf2.agxM.a(localf2.path, localf1.agxM, localf1.path, false) < 0L) {
          break label183;
        }
      }
      label183:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1)
        {
          localf1.agxM.iP(localf1.path);
          bool2 = bool1;
        }
        AppMethodBeat.o(238462);
        return bool2;
      }
      return false;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.VFSFileOp", "Failed to move file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
      AppMethodBeat.o(238462);
    }
  }
  
  public static boolean qo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13293);
    paramString1 = ah.parseUri(paramString1);
    paramString1 = k.kMs().a(paramString1, null);
    paramString2 = ah.parseUri(paramString2);
    boolean bool = a(paramString1, k.kMs().a(paramString2, null), false);
    AppMethodBeat.o(13293);
    return bool;
  }
  
  public static boolean qp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13294);
    Object localObject1 = ah.parseUri(paramString1);
    localObject1 = k.kMs().a((Uri)localObject1, null);
    paramString2 = ah.parseUri(paramString2);
    paramString2 = k.kMs().a(paramString2, null);
    if ((((k.f)localObject1).boj()) && (paramString2.boj()))
    {
      Object localObject3 = ((k.f)localObject1).agxM;
      Object localObject2 = paramString2.agxM;
      if (((((FileSystem.b)localObject3).jKc() & 0xA) == 10) && ((((FileSystem.b)localObject2).jKc() & 0xA) == 10))
      {
        localObject3 = ((FileSystem.b)localObject3).ex(((k.f)localObject1).path, false);
        localObject2 = ((FileSystem.b)localObject2).ex(paramString2.path, true);
        if ((localObject3 != null) && (localObject2 != null) && (new File((String)localObject3).renameTo(new File((String)localObject2))))
        {
          AppMethodBeat.o(13294);
          return true;
        }
      }
    }
    if ((a((k.f)localObject1, paramString2, true)) && (ew(paramString1, false)))
    {
      AppMethodBeat.o(13294);
      return true;
    }
    AppMethodBeat.o(13294);
    return false;
  }
  
  public static boolean qq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(170171);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(170171);
      return false;
    }
    boolean bool = L(Collections.singletonList(paramString1), paramString2);
    AppMethodBeat.o(170171);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.y
 * JD-Core Version:    0.7.0.1
 */