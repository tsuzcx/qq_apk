package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private static int JNa = 4;
  private static ByteOrder JNb = ByteOrder.BIG_ENDIAN;
  private volatile int JNc;
  private volatile int JNd;
  public volatile eya JNe;
  private volatile LinkedList<aod> JNf;
  private volatile String JNg;
  volatile boolean kKk;
  private volatile String mDesc;
  private o mFile;
  
  public g(o paramo)
  {
    AppMethodBeat.i(177090);
    this.kKk = false;
    this.JNd = 0;
    this.JNe = null;
    this.JNf = null;
    this.JNg = "";
    this.mDesc = "";
    this.mFile = paramo;
    if (bwk()) {
      bool = true;
    }
    this.kKk = bool;
    AppMethodBeat.o(177090);
  }
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.JNc <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(JNa);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.JNc);
      localByteBuffer.order(JNb);
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
      this.JNe = new eya();
      this.JNe.parseFrom(paramFileChannel);
      this.JNf = this.JNe.Nvh;
      this.JNg = this.JNe.Nvi;
      this.mDesc = this.JNe.Desc;
      this.JNd = (JNa + this.JNc);
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
  
  private static boolean bcC(String paramString)
  {
    AppMethodBeat.i(200171);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(200171);
      return false;
    }
    if ((paramString.startsWith("video/")) || (paramString.startsWith("audio/")))
    {
      AppMethodBeat.o(200171);
      return true;
    }
    AppMethodBeat.o(200171);
    return false;
  }
  
  private boolean bwk()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = s.dB(aa.z(this.mFile.mUri), false).getChannel();
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
        ByteBuffer localByteBuffer = ByteBuffer.allocate(JNa);
        localByteBuffer.order(JNb);
        localObject1.read(localByteBuffer);
        this.JNc = localByteBuffer.getInt(0);
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
  
  public final String bcD(String paramString)
  {
    AppMethodBeat.i(200173);
    if ((Util.isNullOrNil(this.JNf)) || (this.JNd < JNa))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile, mFileIndexList is null");
      AppMethodBeat.o(200173);
      return null;
    }
    Iterator localIterator = this.JNf.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (aod)localIterator.next();
      if ((Util.nullAsNil(paramString).equals(((aod)localObject).LzG)) && (!bcC(((aod)localObject).LzI))) {
        try
        {
          localObject = d.convertStreamToString(new b(this.mFile, this.JNd + ((aod)localObject).LzH, ((aod)localObject).oUq));
          AppMethodBeat.o(200173);
          return localObject;
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile: " + localIOException.getMessage());
        }
      }
    }
    AppMethodBeat.o(200173);
    return null;
  }
  
  public final String gkR()
  {
    AppMethodBeat.i(200172);
    if ((Util.isNullOrNil(this.JNf)) || (this.JNd < JNa))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "getAllCode, mFileIndexList is null");
      AppMethodBeat.o(200172);
      return null;
    }
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.JNf.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (aod)localIterator.next();
      if (!bcC(((aod)localObject2).LzI)) {
        try
        {
          localObject2 = d.convertStreamToString(new b(this.mFile, this.JNd + ((aod)localObject2).LzH, ((aod)localObject2).oUq));
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
    AppMethodBeat.o(200172);
    return localObject1;
  }
  
  /* Error */
  public final LinkedList<d> gkS()
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 53	com/tencent/mm/plugin/wepkg/model/g:JNf	Ljava/util/LinkedList;
    //   10: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   13: ifne +13 -> 26
    //   16: aload_0
    //   17: getfield 49	com/tencent/mm/plugin/wepkg/model/g:JNd	I
    //   20: getstatic 26	com/tencent/mm/plugin/wepkg/model/g:JNa	I
    //   23: if_icmpge +19 -> 42
    //   26: ldc 117
    //   28: ldc_w 278
    //   31: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: ldc_w 276
    //   37: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aconst_null
    //   41: areturn
    //   42: new 213	java/util/LinkedList
    //   45: dup
    //   46: invokespecial 279	java/util/LinkedList:<init>	()V
    //   49: astore 6
    //   51: aload_0
    //   52: getfield 53	com/tencent/mm/plugin/wepkg/model/g:JNf	Ljava/util/LinkedList;
    //   55: invokevirtual 217	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   58: astore 7
    //   60: aload 7
    //   62: invokeinterface 222 1 0
    //   67: ifeq +326 -> 393
    //   70: aload 7
    //   72: invokeinterface 226 1 0
    //   77: checkcast 228	com/tencent/mm/protocal/protobuf/aod
    //   80: astore_2
    //   81: aload_2
    //   82: getfield 283	com/tencent/mm/protocal/protobuf/aod:LzK	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   85: ifnull -25 -> 60
    //   88: aload_2
    //   89: getfield 283	com/tencent/mm/protocal/protobuf/aod:LzK	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   92: getfield 286	com/tencent/mm/protocal/protobuf/bgn:LzG	Ljava/lang/String;
    //   95: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   98: ifne -38 -> 60
    //   101: new 288	com/tencent/mm/plugin/wepkg/model/d
    //   104: dup
    //   105: invokespecial 289	com/tencent/mm/plugin/wepkg/model/d:<init>	()V
    //   108: astore_3
    //   109: aload_3
    //   110: aload_2
    //   111: getfield 283	com/tencent/mm/protocal/protobuf/aod:LzK	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   114: getfield 292	com/tencent/mm/protocal/protobuf/bgn:jfi	Ljava/lang/String;
    //   117: putfield 295	com/tencent/mm/plugin/wepkg/model/d:izu	Ljava/lang/String;
    //   120: aload_3
    //   121: aload_2
    //   122: getfield 283	com/tencent/mm/protocal/protobuf/aod:LzK	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   125: getfield 298	com/tencent/mm/protocal/protobuf/bgn:xut	Ljava/lang/String;
    //   128: putfield 301	com/tencent/mm/plugin/wepkg/model/d:izv	Ljava/lang/String;
    //   131: aload_3
    //   132: aload_2
    //   133: getfield 283	com/tencent/mm/protocal/protobuf/aod:LzK	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   136: getfield 304	com/tencent/mm/protocal/protobuf/bgn:LQp	Ljava/lang/String;
    //   139: putfield 307	com/tencent/mm/plugin/wepkg/model/d:JMW	Ljava/lang/String;
    //   142: aload_3
    //   143: aload_2
    //   144: getfield 283	com/tencent/mm/protocal/protobuf/aod:LzK	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   147: getfield 310	com/tencent/mm/protocal/protobuf/bgn:LQq	Ljava/lang/String;
    //   150: putfield 313	com/tencent/mm/plugin/wepkg/model/d:cri	Ljava/lang/String;
    //   153: new 245	com/tencent/mm/plugin/wepkg/d/b
    //   156: dup
    //   157: aload_0
    //   158: getfield 61	com/tencent/mm/plugin/wepkg/model/g:mFile	Lcom/tencent/mm/vfs/o;
    //   161: aload_0
    //   162: getfield 49	com/tencent/mm/plugin/wepkg/model/g:JNd	I
    //   165: i2l
    //   166: aload_2
    //   167: getfield 249	com/tencent/mm/protocal/protobuf/aod:LzH	J
    //   170: ladd
    //   171: aload_2
    //   172: getfield 252	com/tencent/mm/protocal/protobuf/aod:oUq	I
    //   175: i2l
    //   176: invokespecial 255	com/tencent/mm/plugin/wepkg/d/b:<init>	(Lcom/tencent/mm/vfs/o;JJ)V
    //   179: astore_2
    //   180: aload_3
    //   181: getfield 295	com/tencent/mm/plugin/wepkg/model/d:izu	Ljava/lang/String;
    //   184: astore 4
    //   186: new 119	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   193: invokestatic 318	com/tencent/mm/plugin/game/commlib/util/b:dTg	()Ljava/lang/String;
    //   196: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 320
    //   202: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 4
    //   207: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 322
    //   213: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore 4
    //   221: aload 4
    //   223: invokestatic 325	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   226: ifne +9 -> 235
    //   229: aload 4
    //   231: invokestatic 328	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
    //   234: pop
    //   235: new 119	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   242: aload 4
    //   244: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_3
    //   248: getfield 313	com/tencent/mm/plugin/wepkg/model/d:cri	Ljava/lang/String;
    //   251: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore 8
    //   259: new 161	com/tencent/mm/vfs/o
    //   262: dup
    //   263: aload 8
    //   265: invokespecial 329	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   268: iconst_0
    //   269: invokestatic 333	com/tencent/mm/vfs/s:d	(Lcom/tencent/mm/vfs/o;Z)Ljava/io/OutputStream;
    //   272: astore 5
    //   274: sipush 4096
    //   277: newarray byte
    //   279: astore 9
    //   281: aload_2
    //   282: aload 9
    //   284: invokevirtual 338	java/io/InputStream:read	([B)I
    //   287: istore_1
    //   288: iload_1
    //   289: iconst_m1
    //   290: if_icmpeq +43 -> 333
    //   293: aload 5
    //   295: aload 9
    //   297: iconst_0
    //   298: iload_1
    //   299: invokevirtual 344	java/io/OutputStream:write	([BII)V
    //   302: goto -21 -> 281
    //   305: astore 4
    //   307: aload_2
    //   308: astore_3
    //   309: aload 5
    //   311: astore_2
    //   312: ldc 117
    //   314: aload 4
    //   316: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_3
    //   323: invokestatic 349	com/tencent/mm/pluginsdk/j/a/d/a:c	(Ljava/io/Closeable;)V
    //   326: aload_2
    //   327: invokestatic 349	com/tencent/mm/pluginsdk/j/a/d/a:c	(Ljava/io/Closeable;)V
    //   330: goto -270 -> 60
    //   333: aload 5
    //   335: invokevirtual 352	java/io/OutputStream:flush	()V
    //   338: aload 8
    //   340: aload 4
    //   342: invokestatic 357	com/tencent/mm/plugin/lite/b/e:ix	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_3
    //   346: aload 4
    //   348: putfield 360	com/tencent/mm/plugin/wepkg/model/d:filePath	Ljava/lang/String;
    //   351: aload 6
    //   353: aload_3
    //   354: invokevirtual 363	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   357: pop
    //   358: aload_2
    //   359: invokestatic 349	com/tencent/mm/pluginsdk/j/a/d/a:c	(Ljava/io/Closeable;)V
    //   362: aload 5
    //   364: invokestatic 349	com/tencent/mm/pluginsdk/j/a/d/a:c	(Ljava/io/Closeable;)V
    //   367: goto -307 -> 60
    //   370: astore 4
    //   372: aconst_null
    //   373: astore_2
    //   374: aconst_null
    //   375: astore_3
    //   376: aload_3
    //   377: invokestatic 349	com/tencent/mm/pluginsdk/j/a/d/a:c	(Ljava/io/Closeable;)V
    //   380: aload_2
    //   381: invokestatic 349	com/tencent/mm/pluginsdk/j/a/d/a:c	(Ljava/io/Closeable;)V
    //   384: ldc_w 276
    //   387: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: aload 4
    //   392: athrow
    //   393: ldc_w 276
    //   396: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload 6
    //   401: areturn
    //   402: astore 4
    //   404: aconst_null
    //   405: astore 5
    //   407: aload_2
    //   408: astore_3
    //   409: aload 5
    //   411: astore_2
    //   412: goto -36 -> 376
    //   415: astore 4
    //   417: aload_2
    //   418: astore_3
    //   419: aload 5
    //   421: astore_2
    //   422: goto -46 -> 376
    //   425: astore 4
    //   427: goto -51 -> 376
    //   430: astore 4
    //   432: aconst_null
    //   433: astore_2
    //   434: aconst_null
    //   435: astore_3
    //   436: goto -124 -> 312
    //   439: astore 4
    //   441: aconst_null
    //   442: astore 5
    //   444: aload_2
    //   445: astore_3
    //   446: aload 5
    //   448: astore_2
    //   449: goto -137 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	g
    //   287	12	1	i	int
    //   80	369	2	localObject1	Object
    //   108	338	3	localObject2	Object
    //   184	59	4	str1	String
    //   305	42	4	localException1	Exception
    //   370	21	4	localObject3	Object
    //   402	1	4	localObject4	Object
    //   415	1	4	localObject5	Object
    //   425	1	4	localObject6	Object
    //   430	1	4	localException2	Exception
    //   439	1	4	localException3	Exception
    //   272	175	5	localOutputStream	java.io.OutputStream
    //   49	351	6	localLinkedList	LinkedList
    //   58	13	7	localIterator	Iterator
    //   257	82	8	str2	String
    //   279	17	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   274	281	305	java/lang/Exception
    //   281	288	305	java/lang/Exception
    //   293	302	305	java/lang/Exception
    //   333	358	305	java/lang/Exception
    //   153	180	370	finally
    //   180	235	402	finally
    //   235	274	402	finally
    //   274	281	415	finally
    //   281	288	415	finally
    //   293	302	415	finally
    //   333	358	415	finally
    //   312	322	425	finally
    //   153	180	430	java/lang/Exception
    //   180	235	439	java/lang/Exception
    //   235	274	439	java/lang/Exception
  }
  
  public final WebResourceResponse mt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((Util.isNullOrNil(this.JNf)) || (this.JNd < JNa) || (Util.isNullOrNil(paramString1)))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.JNf.iterator();
    while (localIterator1.hasNext())
    {
      aod localaod = (aod)localIterator1.next();
      if (Util.nullAsNil(localaod.LzG).equals(paramString1))
      {
        if (bcC(localaod.LzI))
        {
          Log.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localaod.oUq <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            Log.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            WebResourceResponse localWebResourceResponse = new WebResourceResponse(localaod.LzI, paramString2, new b(this.mFile, this.JNd + localaod.LzH, localaod.oUq));
            if (Util.isNullOrNil(localaod.LzJ)) {
              break label338;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localaod.LzJ.iterator();
            while (localIterator2.hasNext())
            {
              aob localaob = (aob)localIterator2.next();
              localHashMap.put(localaob.key, localaob.value);
            }
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localaod.LzH), Integer.valueOf(localaod.oUq), localaod.LzI, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label338:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          Log.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localaod.oUq), Long.valueOf(5242880L), paramString1, Long.valueOf(localaod.LzH), localaod.LzI });
        }
      }
    }
    AppMethodBeat.o(110684);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g
 * JD-Core Version:    0.7.0.1
 */