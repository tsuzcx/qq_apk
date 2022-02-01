package com.tencent.mm.plugin.wepkg.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.fiq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebResourceResponse;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
{
  private static int QMt = 4;
  private static ByteOrder QMu = ByteOrder.BIG_ENDIAN;
  private volatile int QMv;
  private volatile int QMw;
  public volatile fiq QMx;
  private volatile LinkedList<ape> QMy;
  private volatile String QMz;
  private volatile String mDesc;
  private q mFile;
  volatile boolean nEb;
  
  public g(q paramq)
  {
    AppMethodBeat.i(177090);
    this.nEb = false;
    this.QMw = 0;
    this.QMx = null;
    this.QMy = null;
    this.QMz = "";
    this.mDesc = "";
    this.mFile = paramq;
    if (heJ()) {
      bool = true;
    }
    this.nEb = bool;
    AppMethodBeat.o(177090);
  }
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.QMv <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(QMt);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.QMv);
      localByteBuffer.order(QMu);
      paramFileChannel.read(localByteBuffer);
      paramFileChannel = localByteBuffer.array();
      if (paramFileChannel != null)
      {
        int i = paramFileChannel.length;
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(110686);
        return false;
      }
      this.QMx = new fiq();
      this.QMx.parseFrom(paramFileChannel);
      this.QMy = this.QMx.UIq;
      this.QMz = this.QMx.UIr;
      this.mDesc = this.QMx.CMB;
      this.QMw = (QMt + this.QMv);
      AppMethodBeat.o(110686);
      return true;
    }
    catch (Exception paramFileChannel)
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + paramFileChannel.getMessage());
      AppMethodBeat.o(110686);
    }
    return false;
  }
  
  private static boolean boC(String paramString)
  {
    AppMethodBeat.i(194137);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194137);
      return false;
    }
    if ((paramString.startsWith("video/")) || (paramString.startsWith("audio/")))
    {
      AppMethodBeat.o(194137);
      return true;
    }
    AppMethodBeat.o(194137);
    return false;
  }
  
  private static void c(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110687);
    if (paramFileChannel != null) {
      try
      {
        paramFileChannel.close();
        AppMethodBeat.o(110687);
        return;
      }
      catch (IOException paramFileChannel) {}
    }
    AppMethodBeat.o(110687);
  }
  
  private boolean heJ()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = u.dO(this.mFile.getPath(), false).getChannel();
      localObject1 = localFileChannel;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + localException1.getMessage());
      }
      try
      {
        localObject1.position(0L);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(QMt);
        localByteBuffer.order(QMu);
        localObject1.read(localByteBuffer);
        this.QMv = localByteBuffer.getInt(0);
        boolean bool = b(localObject1);
        return bool;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + localException2.getMessage());
        return false;
      }
      finally
      {
        c(localObject1);
        AppMethodBeat.o(110685);
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(110685);
      return false;
    }
  }
  
  public final String heK()
  {
    AppMethodBeat.i(194138);
    if ((Util.isNullOrNil(this.QMy)) || (this.QMw < QMt))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "getAllCode, mFileIndexList is null");
      AppMethodBeat.o(194138);
      return null;
    }
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.QMy.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ape)localIterator.next();
      if (!boC(((ape)localObject2).SCi)) {
        try
        {
          localObject2 = d.convertStreamToString(new b(this.mFile, this.QMw + ((ape)localObject2).SCh, ((ape)localObject2).rWo));
          if (localObject2 != null)
          {
            ((StringBuilder)localObject1).append("\n");
            ((StringBuilder)localObject1).append((String)localObject2);
          }
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.Wepkg.WePkgReader", "getAllCode: " + localIOException.getMessage());
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(194138);
    return localObject1;
  }
  
  /* Error */
  public final LinkedList<d> heL()
  {
    // Byte code:
    //   0: ldc 252
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 53	com/tencent/mm/plugin/wepkg/model/g:QMy	Ljava/util/LinkedList;
    //   9: invokestatic 201	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   12: ifne +13 -> 25
    //   15: aload_0
    //   16: getfield 49	com/tencent/mm/plugin/wepkg/model/g:QMw	I
    //   19: getstatic 26	com/tencent/mm/plugin/wepkg/model/g:QMt	I
    //   22: if_icmpge +17 -> 39
    //   25: ldc 117
    //   27: ldc 254
    //   29: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc 252
    //   34: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: new 206	java/util/LinkedList
    //   42: dup
    //   43: invokespecial 255	java/util/LinkedList:<init>	()V
    //   46: astore 6
    //   48: aload_0
    //   49: getfield 53	com/tencent/mm/plugin/wepkg/model/g:QMy	Ljava/util/LinkedList;
    //   52: invokevirtual 210	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   55: astore 7
    //   57: aload 7
    //   59: invokeinterface 215 1 0
    //   64: ifeq +325 -> 389
    //   67: aload 7
    //   69: invokeinterface 219 1 0
    //   74: checkcast 221	com/tencent/mm/protocal/protobuf/ape
    //   77: astore_2
    //   78: aload_2
    //   79: getfield 259	com/tencent/mm/protocal/protobuf/ape:SCk	Lcom/tencent/mm/protocal/protobuf/bnq;
    //   82: ifnull -25 -> 57
    //   85: aload_2
    //   86: getfield 259	com/tencent/mm/protocal/protobuf/ape:SCk	Lcom/tencent/mm/protocal/protobuf/bnq;
    //   89: getfield 264	com/tencent/mm/protocal/protobuf/bnq:SCg	Ljava/lang/String;
    //   92: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   95: ifne -38 -> 57
    //   98: new 266	com/tencent/mm/plugin/wepkg/model/d
    //   101: dup
    //   102: invokespecial 267	com/tencent/mm/plugin/wepkg/model/d:<init>	()V
    //   105: astore_3
    //   106: aload_3
    //   107: aload_2
    //   108: getfield 259	com/tencent/mm/protocal/protobuf/ape:SCk	Lcom/tencent/mm/protocal/protobuf/bnq;
    //   111: getfield 270	com/tencent/mm/protocal/protobuf/bnq:lVG	Ljava/lang/String;
    //   114: putfield 273	com/tencent/mm/plugin/wepkg/model/d:loN	Ljava/lang/String;
    //   117: aload_3
    //   118: aload_2
    //   119: getfield 259	com/tencent/mm/protocal/protobuf/ape:SCk	Lcom/tencent/mm/protocal/protobuf/bnq;
    //   122: getfield 276	com/tencent/mm/protocal/protobuf/bnq:CqK	Ljava/lang/String;
    //   125: putfield 279	com/tencent/mm/plugin/wepkg/model/d:loO	Ljava/lang/String;
    //   128: aload_3
    //   129: aload_2
    //   130: getfield 259	com/tencent/mm/protocal/protobuf/ape:SCk	Lcom/tencent/mm/protocal/protobuf/bnq;
    //   133: getfield 282	com/tencent/mm/protocal/protobuf/bnq:SYK	Ljava/lang/String;
    //   136: putfield 285	com/tencent/mm/plugin/wepkg/model/d:QMp	Ljava/lang/String;
    //   139: aload_3
    //   140: aload_2
    //   141: getfield 259	com/tencent/mm/protocal/protobuf/ape:SCk	Lcom/tencent/mm/protocal/protobuf/bnq;
    //   144: getfield 288	com/tencent/mm/protocal/protobuf/bnq:SYL	Ljava/lang/String;
    //   147: putfield 291	com/tencent/mm/plugin/wepkg/model/d:coY	Ljava/lang/String;
    //   150: new 228	com/tencent/mm/plugin/wepkg/d/b
    //   153: dup
    //   154: aload_0
    //   155: getfield 61	com/tencent/mm/plugin/wepkg/model/g:mFile	Lcom/tencent/mm/vfs/q;
    //   158: aload_0
    //   159: getfield 49	com/tencent/mm/plugin/wepkg/model/g:QMw	I
    //   162: i2l
    //   163: aload_2
    //   164: getfield 232	com/tencent/mm/protocal/protobuf/ape:SCh	J
    //   167: ladd
    //   168: aload_2
    //   169: getfield 235	com/tencent/mm/protocal/protobuf/ape:rWo	I
    //   172: i2l
    //   173: invokespecial 238	com/tencent/mm/plugin/wepkg/d/b:<init>	(Lcom/tencent/mm/vfs/q;JJ)V
    //   176: astore_2
    //   177: aload_3
    //   178: getfield 273	com/tencent/mm/plugin/wepkg/model/d:loN	Ljava/lang/String;
    //   181: astore 4
    //   183: new 119	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   190: invokestatic 296	com/tencent/mm/plugin/game/commlib/e/c:ewp	()Ljava/lang/String;
    //   193: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 298
    //   199: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 300
    //   210: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 4
    //   218: aload 4
    //   220: invokestatic 303	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   223: ifne +9 -> 232
    //   226: aload 4
    //   228: invokestatic 306	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   231: pop
    //   232: new 119	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   239: aload 4
    //   241: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_3
    //   245: getfield 291	com/tencent/mm/plugin/wepkg/model/d:coY	Ljava/lang/String;
    //   248: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 8
    //   256: new 169	com/tencent/mm/vfs/q
    //   259: dup
    //   260: aload 8
    //   262: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   265: iconst_0
    //   266: invokestatic 310	com/tencent/mm/vfs/u:e	(Lcom/tencent/mm/vfs/q;Z)Ljava/io/OutputStream;
    //   269: astore 5
    //   271: sipush 4096
    //   274: newarray byte
    //   276: astore 9
    //   278: aload_2
    //   279: aload 9
    //   281: invokevirtual 315	java/io/InputStream:read	([B)I
    //   284: istore_1
    //   285: iload_1
    //   286: iconst_m1
    //   287: if_icmpeq +43 -> 330
    //   290: aload 5
    //   292: aload 9
    //   294: iconst_0
    //   295: iload_1
    //   296: invokevirtual 321	java/io/OutputStream:write	([BII)V
    //   299: goto -21 -> 278
    //   302: astore 4
    //   304: aload_2
    //   305: astore_3
    //   306: aload 5
    //   308: astore_2
    //   309: ldc 117
    //   311: aload 4
    //   313: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_3
    //   320: invokestatic 326	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   323: aload_2
    //   324: invokestatic 326	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   327: goto -270 -> 57
    //   330: aload 5
    //   332: invokevirtual 329	java/io/OutputStream:flush	()V
    //   335: aload 8
    //   337: aload 4
    //   339: invokestatic 334	com/tencent/mm/plugin/lite/b/e:iJ	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_3
    //   343: aload 4
    //   345: putfield 337	com/tencent/mm/plugin/wepkg/model/d:filePath	Ljava/lang/String;
    //   348: aload 6
    //   350: aload_3
    //   351: invokevirtual 341	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   354: pop
    //   355: aload_2
    //   356: invokestatic 326	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   359: aload 5
    //   361: invokestatic 326	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   364: goto -307 -> 57
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_2
    //   371: aconst_null
    //   372: astore_3
    //   373: aload_3
    //   374: invokestatic 326	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   377: aload_2
    //   378: invokestatic 326	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   381: ldc 252
    //   383: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aload 4
    //   388: athrow
    //   389: ldc 252
    //   391: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload 6
    //   396: areturn
    //   397: astore 4
    //   399: aconst_null
    //   400: astore 5
    //   402: aload_2
    //   403: astore_3
    //   404: aload 5
    //   406: astore_2
    //   407: goto -34 -> 373
    //   410: astore 4
    //   412: aload_2
    //   413: astore_3
    //   414: aload 5
    //   416: astore_2
    //   417: goto -44 -> 373
    //   420: astore 4
    //   422: goto -49 -> 373
    //   425: astore 4
    //   427: aconst_null
    //   428: astore_2
    //   429: aconst_null
    //   430: astore_3
    //   431: goto -122 -> 309
    //   434: astore 4
    //   436: aconst_null
    //   437: astore 5
    //   439: aload_2
    //   440: astore_3
    //   441: aload 5
    //   443: astore_2
    //   444: goto -135 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	g
    //   284	12	1	i	int
    //   77	367	2	localObject1	Object
    //   105	336	3	localObject2	Object
    //   181	59	4	str1	String
    //   302	42	4	localException1	Exception
    //   367	20	4	localObject3	Object
    //   397	1	4	localObject4	Object
    //   410	1	4	localObject5	Object
    //   420	1	4	localObject6	Object
    //   425	1	4	localException2	Exception
    //   434	1	4	localException3	Exception
    //   269	173	5	localOutputStream	java.io.OutputStream
    //   46	349	6	localLinkedList	LinkedList
    //   55	13	7	localIterator	Iterator
    //   254	82	8	str2	String
    //   276	17	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   271	278	302	java/lang/Exception
    //   278	285	302	java/lang/Exception
    //   290	299	302	java/lang/Exception
    //   330	355	302	java/lang/Exception
    //   150	177	367	finally
    //   177	232	397	finally
    //   232	271	397	finally
    //   271	278	410	finally
    //   278	285	410	finally
    //   290	299	410	finally
    //   330	355	410	finally
    //   309	319	420	finally
    //   150	177	425	java/lang/Exception
    //   177	232	434	java/lang/Exception
    //   232	271	434	java/lang/Exception
  }
  
  public final WebResourceResponse mV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((Util.isNullOrNil(this.QMy)) || (this.QMw < QMt) || (Util.isNullOrNil(paramString1)))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.QMy.iterator();
    while (localIterator1.hasNext())
    {
      ape localape = (ape)localIterator1.next();
      if (Util.nullAsNil(localape.SCg).equals(paramString1))
      {
        if (boC(localape.SCi))
        {
          Log.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localape.rWo <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            Log.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            WebResourceResponse localWebResourceResponse = new WebResourceResponse(localape.SCi, paramString2, new b(this.mFile, this.QMw + localape.SCh, localape.rWo));
            if (Util.isNullOrNil(localape.SCj)) {
              break label337;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localape.SCj.iterator();
            while (localIterator2.hasNext())
            {
              apc localapc = (apc)localIterator2.next();
              localHashMap.put(localapc.key, localapc.value);
            }
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localape.SCh), Integer.valueOf(localape.rWo), localape.SCi, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label337:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          Log.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localape.rWo), Long.valueOf(5242880L), paramString1, Long.valueOf(localape.SCh), localape.SCi });
        }
      }
    }
    AppMethodBeat.o(110684);
    return null;
  }
  
  public final String mW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194142);
    if ((Util.isNullOrNil(this.QMy)) || (this.QMw < QMt))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile, mFileIndexList is null");
      AppMethodBeat.o(194142);
      return null;
    }
    Iterator localIterator = this.QMy.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ape)localIterator.next();
      if ((Util.nullAsNil(paramString1).equals(((ape)localObject).SCg)) && (!boC(((ape)localObject).SCi))) {
        try
        {
          localObject = d.F(new b(this.mFile, this.QMw + ((ape)localObject).SCh, ((ape)localObject).rWo));
          if ("utf8".equals(paramString2))
          {
            localObject = new String((byte[])localObject, "UTF-8");
            AppMethodBeat.o(194142);
            return localObject;
          }
          localObject = Base64.encodeToString((byte[])localObject, 2);
          AppMethodBeat.o(194142);
          return localObject;
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile: " + localIOException.getMessage());
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile: " + localOutOfMemoryError.getMessage());
        }
      }
    }
    AppMethodBeat.o(194142);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g
 * JD-Core Version:    0.7.0.1
 */