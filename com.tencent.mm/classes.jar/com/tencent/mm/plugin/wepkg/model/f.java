package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
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

public final class f
{
  private static int EEM = 4;
  private static ByteOrder EEN = ByteOrder.BIG_ENDIAN;
  private volatile int EEO;
  private volatile int EEP;
  volatile ecb EEQ;
  private volatile LinkedList<ale> EER;
  private volatile String EES;
  private e gdT;
  volatile boolean jFp;
  private volatile String mDesc;
  
  public f(e parame)
  {
    AppMethodBeat.i(177090);
    this.jFp = false;
    this.EEP = 0;
    this.EEQ = null;
    this.EER = null;
    this.EES = "";
    this.mDesc = "";
    this.gdT = parame;
    if (bax()) {
      bool = true;
    }
    this.jFp = bool;
    AppMethodBeat.o(177090);
  }
  
  private static boolean aKN(String paramString)
  {
    AppMethodBeat.i(214470);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(214470);
      return false;
    }
    if ((paramString.startsWith("video/")) || (paramString.startsWith("audio/")))
    {
      AppMethodBeat.o(214470);
      return true;
    }
    AppMethodBeat.o(214470);
    return false;
  }
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.EEO <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(EEM);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.EEO);
      localByteBuffer.order(EEN);
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
      this.EEQ = new ecb();
      this.EEQ.parseFrom(paramFileChannel);
      this.EER = this.EEQ.HOw;
      this.EES = this.EEQ.HOx;
      this.mDesc = this.EEQ.Desc;
      this.EEP = (EEM + this.EEO);
      AppMethodBeat.o(110686);
      return true;
    }
    catch (Exception paramFileChannel)
    {
      ad.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + paramFileChannel.getMessage());
      AppMethodBeat.o(110686);
    }
    return false;
  }
  
  private boolean bax()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = i.dd(q.B(this.gdT.mUri), false).getChannel();
      localObject1 = localFileChannel;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ad.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + localException1.getMessage());
      }
      try
      {
        localObject1.position(0L);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(EEM);
        localByteBuffer.order(EEN);
        localObject1.read(localByteBuffer);
        this.EEO = localByteBuffer.getInt(0);
        boolean bool = b(localObject1);
        return bool;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + localException2.getMessage());
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
  
  public final String eYa()
  {
    AppMethodBeat.i(214471);
    if ((bt.hj(this.EER)) || (this.EEP < EEM))
    {
      ad.e("MicroMsg.Wepkg.WePkgReader", "getAllCode, mFileIndexList is null");
      AppMethodBeat.o(214471);
      return null;
    }
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.EER.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ale)localIterator.next();
      if (!aKN(((ale)localObject2).GkW)) {
        try
        {
          localObject2 = d.convertStreamToString(new b(this.gdT, this.EEP + ((ale)localObject2).GkV, ((ale)localObject2).nEa));
          if (localObject2 != null)
          {
            ((StringBuilder)localObject1).append("\n");
            ((StringBuilder)localObject1).append((String)localObject2);
          }
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.Wepkg.WePkgReader", "getAllCode: " + localIOException.getMessage());
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(214471);
    return localObject1;
  }
  
  public final WebResourceResponse ln(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((bt.hj(this.EER)) || (this.EEP < EEM) || (bt.isNullOrNil(paramString1)))
    {
      ad.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.EER.iterator();
    while (localIterator1.hasNext())
    {
      ale localale = (ale)localIterator1.next();
      if (bt.nullAsNil(localale.GkU).equals(paramString1))
      {
        if (aKN(localale.GkW))
        {
          ad.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localale.nEa <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            ad.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            WebResourceResponse localWebResourceResponse = new WebResourceResponse(localale.GkW, paramString2, new b(this.gdT, this.EEP + localale.GkV, localale.nEa));
            if (bt.hj(localale.GkX)) {
              break label338;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localale.GkX.iterator();
            while (localIterator2.hasNext())
            {
              alc localalc = (alc)localIterator2.next();
              localHashMap.put(localalc.key, localalc.value);
            }
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localale.GkV), Integer.valueOf(localale.nEa), localale.GkW, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label338:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          ad.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localale.nEa), Long.valueOf(5242880L), paramString1, Long.valueOf(localale.GkV), localale.GkW });
        }
      }
    }
    AppMethodBeat.o(110684);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f
 * JD-Core Version:    0.7.0.1
 */