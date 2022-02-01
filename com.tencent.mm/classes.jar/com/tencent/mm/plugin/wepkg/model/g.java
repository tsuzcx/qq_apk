package com.tencent.mm.plugin.wepkg.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.gfd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private static int XFR = 4;
  private static ByteOrder XFS = ByteOrder.BIG_ENDIAN;
  private volatile int XFT;
  private volatile int XFU;
  public volatile gfd XFV;
  private volatile LinkedList<asx> XFW;
  private volatile String XFX;
  private volatile String mDesc;
  private u mFile;
  volatile boolean qDW;
  
  public g(u paramu)
  {
    AppMethodBeat.i(177090);
    this.qDW = false;
    this.XFU = 0;
    this.XFV = null;
    this.XFW = null;
    this.XFX = "";
    this.mDesc = "";
    this.mFile = paramu;
    if (iFr()) {
      bool = true;
    }
    this.qDW = bool;
    AppMethodBeat.o(177090);
  }
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.XFT <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(XFR);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.XFT);
      localByteBuffer.order(XFS);
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
      this.XFV = new gfd();
      this.XFV.parseFrom(paramFileChannel);
      this.XFW = this.XFV.accz;
      this.XFX = this.XFV.accA;
      this.mDesc = this.XFV.IGG;
      this.XFU = (XFR + this.XFT);
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
  
  private static boolean boq(String paramString)
  {
    AppMethodBeat.i(278688);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(278688);
      return false;
    }
    if ((paramString.startsWith("video/")) || (paramString.startsWith("audio/")))
    {
      AppMethodBeat.o(278688);
      return true;
    }
    AppMethodBeat.o(278688);
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
  
  private boolean iFr()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = y.eA(ah.v(this.mFile.mUri), false).getChannel();
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
        ByteBuffer localByteBuffer = ByteBuffer.allocate(XFR);
        localByteBuffer.order(XFS);
        localObject1.read(localByteBuffer);
        this.XFT = localByteBuffer.getInt(0);
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
  
  public final String iFs()
  {
    AppMethodBeat.i(278703);
    if ((Util.isNullOrNil(this.XFW)) || (this.XFU < XFR))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "getAllCode, mFileIndexList is null");
      AppMethodBeat.o(278703);
      return null;
    }
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.XFW.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (asx)localIterator.next();
      if (!boq(((asx)localObject2).ZDa)) {
        try
        {
          localObject2 = d.convertStreamToString(new b(this.mFile, this.XFU + ((asx)localObject2).ZCZ, ((asx)localObject2).vhE));
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
    AppMethodBeat.o(278703);
    return localObject1;
  }
  
  /* Error */
  public final LinkedList<d> iFt()
  {
    // Byte code:
    //   0: ldc_w 259
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 53	com/tencent/mm/plugin/wepkg/model/g:XFW	Ljava/util/LinkedList;
    //   10: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   13: ifne +13 -> 26
    //   16: aload_0
    //   17: getfield 49	com/tencent/mm/plugin/wepkg/model/g:XFU	I
    //   20: getstatic 26	com/tencent/mm/plugin/wepkg/model/g:XFR	I
    //   23: if_icmpge +19 -> 42
    //   26: ldc 117
    //   28: ldc_w 261
    //   31: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: ldc_w 259
    //   37: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aconst_null
    //   41: areturn
    //   42: new 213	java/util/LinkedList
    //   45: dup
    //   46: invokespecial 262	java/util/LinkedList:<init>	()V
    //   49: astore 6
    //   51: aload_0
    //   52: getfield 53	com/tencent/mm/plugin/wepkg/model/g:XFW	Ljava/util/LinkedList;
    //   55: invokevirtual 217	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   58: astore 7
    //   60: aload 7
    //   62: invokeinterface 222 1 0
    //   67: ifeq +337 -> 404
    //   70: aload 7
    //   72: invokeinterface 226 1 0
    //   77: checkcast 228	com/tencent/mm/protocal/protobuf/asx
    //   80: astore_2
    //   81: aload_2
    //   82: getfield 266	com/tencent/mm/protocal/protobuf/asx:ZDc	Lcom/tencent/mm/protocal/protobuf/cbn;
    //   85: ifnull -25 -> 60
    //   88: aload_2
    //   89: getfield 266	com/tencent/mm/protocal/protobuf/asx:ZDc	Lcom/tencent/mm/protocal/protobuf/cbn;
    //   92: getfield 271	com/tencent/mm/protocal/protobuf/cbn:ZCY	Ljava/lang/String;
    //   95: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   98: ifne -38 -> 60
    //   101: new 273	com/tencent/mm/plugin/wepkg/model/d
    //   104: dup
    //   105: invokespecial 274	com/tencent/mm/plugin/wepkg/model/d:<init>	()V
    //   108: astore_3
    //   109: aload_3
    //   110: aload_2
    //   111: getfield 266	com/tencent/mm/protocal/protobuf/asx:ZDc	Lcom/tencent/mm/protocal/protobuf/cbn;
    //   114: getfield 277	com/tencent/mm/protocal/protobuf/cbn:oOI	Ljava/lang/String;
    //   117: putfield 280	com/tencent/mm/plugin/wepkg/model/d:nTQ	Ljava/lang/String;
    //   120: aload_3
    //   121: aload_2
    //   122: getfield 266	com/tencent/mm/protocal/protobuf/asx:ZDc	Lcom/tencent/mm/protocal/protobuf/cbn;
    //   125: getfield 283	com/tencent/mm/protocal/protobuf/cbn:IcT	Ljava/lang/String;
    //   128: putfield 286	com/tencent/mm/plugin/wepkg/model/d:nTR	Ljava/lang/String;
    //   131: aload_3
    //   132: aload_2
    //   133: getfield 266	com/tencent/mm/protocal/protobuf/asx:ZDc	Lcom/tencent/mm/protocal/protobuf/cbn;
    //   136: getfield 289	com/tencent/mm/protocal/protobuf/cbn:aakM	Ljava/lang/String;
    //   139: putfield 292	com/tencent/mm/plugin/wepkg/model/d:XFN	Ljava/lang/String;
    //   142: aload_3
    //   143: aload_2
    //   144: getfield 266	com/tencent/mm/protocal/protobuf/asx:ZDc	Lcom/tencent/mm/protocal/protobuf/cbn;
    //   147: getfield 295	com/tencent/mm/protocal/protobuf/cbn:aakN	Ljava/lang/String;
    //   150: putfield 298	com/tencent/mm/plugin/wepkg/model/d:egJ	Ljava/lang/String;
    //   153: new 235	com/tencent/mm/plugin/wepkg/d/b
    //   156: dup
    //   157: aload_0
    //   158: getfield 61	com/tencent/mm/plugin/wepkg/model/g:mFile	Lcom/tencent/mm/vfs/u;
    //   161: aload_0
    //   162: getfield 49	com/tencent/mm/plugin/wepkg/model/g:XFU	I
    //   165: i2l
    //   166: aload_2
    //   167: getfield 239	com/tencent/mm/protocal/protobuf/asx:ZCZ	J
    //   170: ladd
    //   171: aload_2
    //   172: getfield 242	com/tencent/mm/protocal/protobuf/asx:vhE	I
    //   175: i2l
    //   176: invokespecial 245	com/tencent/mm/plugin/wepkg/d/b:<init>	(Lcom/tencent/mm/vfs/u;JJ)V
    //   179: astore_2
    //   180: aload_3
    //   181: getfield 280	com/tencent/mm/plugin/wepkg/model/d:nTQ	Ljava/lang/String;
    //   184: astore 4
    //   186: new 119	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   193: invokestatic 303	com/tencent/mm/plugin/game/commlib/e/c:fEg	()Ljava/lang/String;
    //   196: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 305
    //   202: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 4
    //   207: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 307
    //   213: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore 4
    //   221: aload 4
    //   223: invokestatic 310	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   226: ifne +9 -> 235
    //   229: aload 4
    //   231: invokestatic 313	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   234: pop
    //   235: new 119	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   242: aload 4
    //   244: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_3
    //   248: getfield 298	com/tencent/mm/plugin/wepkg/model/d:egJ	Ljava/lang/String;
    //   251: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore 8
    //   259: new 169	com/tencent/mm/vfs/u
    //   262: dup
    //   263: aload 8
    //   265: invokespecial 314	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   268: iconst_0
    //   269: invokestatic 317	com/tencent/mm/vfs/y:e	(Lcom/tencent/mm/vfs/u;Z)Ljava/io/OutputStream;
    //   272: astore 5
    //   274: sipush 4096
    //   277: newarray byte
    //   279: astore 9
    //   281: aload_2
    //   282: aload 9
    //   284: invokevirtual 322	java/io/InputStream:read	([B)I
    //   287: istore_1
    //   288: iload_1
    //   289: iconst_m1
    //   290: if_icmpeq +43 -> 333
    //   293: aload 5
    //   295: aload 9
    //   297: iconst_0
    //   298: iload_1
    //   299: invokevirtual 328	java/io/OutputStream:write	([BII)V
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
    //   323: invokestatic 333	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   326: aload_2
    //   327: invokestatic 333	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   330: goto -270 -> 60
    //   333: aload 5
    //   335: invokevirtual 336	java/io/OutputStream:flush	()V
    //   338: ldc_w 338
    //   341: invokestatic 344	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   344: checkcast 338	com/tencent/mm/plugin/lite/api/c
    //   347: aload 8
    //   349: aload 4
    //   351: invokeinterface 347 3 0
    //   356: aload_3
    //   357: aload 4
    //   359: putfield 350	com/tencent/mm/plugin/wepkg/model/d:filePath	Ljava/lang/String;
    //   362: aload 6
    //   364: aload_3
    //   365: invokevirtual 354	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   368: pop
    //   369: aload_2
    //   370: invokestatic 333	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   373: aload 5
    //   375: invokestatic 333	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   378: goto -318 -> 60
    //   381: astore 4
    //   383: aconst_null
    //   384: astore_2
    //   385: aconst_null
    //   386: astore_3
    //   387: aload_3
    //   388: invokestatic 333	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   391: aload_2
    //   392: invokestatic 333	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   395: ldc_w 259
    //   398: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload 4
    //   403: athrow
    //   404: ldc_w 259
    //   407: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: aload 6
    //   412: areturn
    //   413: astore 4
    //   415: aconst_null
    //   416: astore 5
    //   418: aload_2
    //   419: astore_3
    //   420: aload 5
    //   422: astore_2
    //   423: goto -36 -> 387
    //   426: astore 4
    //   428: aload_2
    //   429: astore_3
    //   430: aload 5
    //   432: astore_2
    //   433: goto -46 -> 387
    //   436: astore 4
    //   438: goto -51 -> 387
    //   441: astore 4
    //   443: aconst_null
    //   444: astore_2
    //   445: aconst_null
    //   446: astore_3
    //   447: goto -135 -> 312
    //   450: astore 4
    //   452: aconst_null
    //   453: astore 5
    //   455: aload_2
    //   456: astore_3
    //   457: aload 5
    //   459: astore_2
    //   460: goto -148 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	g
    //   287	12	1	i	int
    //   80	380	2	localObject1	Object
    //   108	349	3	localObject2	Object
    //   184	59	4	str1	String
    //   305	53	4	localException1	Exception
    //   381	21	4	localObject3	Object
    //   413	1	4	localObject4	Object
    //   426	1	4	localObject5	Object
    //   436	1	4	localObject6	Object
    //   441	1	4	localException2	Exception
    //   450	1	4	localException3	Exception
    //   272	186	5	localOutputStream	java.io.OutputStream
    //   49	362	6	localLinkedList	LinkedList
    //   58	13	7	localIterator	Iterator
    //   257	91	8	str2	String
    //   279	17	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   274	281	305	java/lang/Exception
    //   281	288	305	java/lang/Exception
    //   293	302	305	java/lang/Exception
    //   333	369	305	java/lang/Exception
    //   153	180	381	finally
    //   180	235	413	finally
    //   235	274	413	finally
    //   274	281	426	finally
    //   281	288	426	finally
    //   293	302	426	finally
    //   333	369	426	finally
    //   312	322	436	finally
    //   153	180	441	java/lang/Exception
    //   180	235	450	java/lang/Exception
    //   235	274	450	java/lang/Exception
  }
  
  public final WebResourceResponse oL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((Util.isNullOrNil(this.XFW)) || (this.XFU < XFR) || (Util.isNullOrNil(paramString1)))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.XFW.iterator();
    while (localIterator1.hasNext())
    {
      asx localasx = (asx)localIterator1.next();
      if (Util.nullAsNil(localasx.ZCY).equals(paramString1))
      {
        if (boq(localasx.ZDa))
        {
          Log.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localasx.vhE <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            Log.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            WebResourceResponse localWebResourceResponse = new WebResourceResponse(localasx.ZDa, paramString2, new b(this.mFile, this.XFU + localasx.ZCZ, localasx.vhE));
            if (Util.isNullOrNil(localasx.ZDb)) {
              break label338;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localasx.ZDb.iterator();
            while (localIterator2.hasNext())
            {
              asv localasv = (asv)localIterator2.next();
              localHashMap.put(localasv.key, localasv.value);
            }
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localasx.ZCZ), Integer.valueOf(localasx.vhE), localasx.ZDa, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label338:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          Log.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localasx.vhE), Long.valueOf(5242880L), paramString1, Long.valueOf(localasx.ZCZ), localasx.ZDa });
        }
      }
    }
    AppMethodBeat.o(110684);
    return null;
  }
  
  public final String oM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(278708);
    if ((Util.isNullOrNil(this.XFW)) || (this.XFU < XFR))
    {
      Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile, mFileIndexList is null");
      AppMethodBeat.o(278708);
      return null;
    }
    Iterator localIterator = this.XFW.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (asx)localIterator.next();
      if ((Util.nullAsNil(paramString1).equals(((asx)localObject).ZCY)) && (!boq(((asx)localObject).ZDa))) {
        try
        {
          localObject = d.T(new b(this.mFile, this.XFU + ((asx)localObject).ZCZ, ((asx)localObject).vhE));
          if ("utf8".equals(paramString2))
          {
            localObject = new String((byte[])localObject, "UTF-8");
            AppMethodBeat.o(278708);
            return localObject;
          }
          localObject = Base64.encodeToString((byte[])localObject, 2);
          AppMethodBeat.o(278708);
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
    AppMethodBeat.o(278708);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g
 * JD-Core Version:    0.7.0.1
 */