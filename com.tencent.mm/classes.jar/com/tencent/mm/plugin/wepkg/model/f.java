package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static int DaN = 4;
  private static ByteOrder DaO = ByteOrder.BIG_ENDIAN;
  private volatile int DaP;
  private volatile int DaQ;
  volatile dwb DaR;
  private volatile LinkedList<aio> DaS;
  private volatile String DaT;
  private e fKs;
  volatile boolean jlz;
  private volatile String mDesc;
  
  public f(e parame)
  {
    AppMethodBeat.i(177090);
    this.jlz = false;
    this.DaQ = 0;
    this.DaR = null;
    this.DaS = null;
    this.DaT = "";
    this.mDesc = "";
    this.fKs = parame;
    if (aWZ()) {
      bool = true;
    }
    this.jlz = bool;
    AppMethodBeat.o(177090);
  }
  
  private boolean aWZ()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = i.cY(q.B(this.fKs.mUri), false).getChannel();
      localObject1 = localFileChannel;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ac.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + localException1.getMessage());
      }
      try
      {
        localObject1.position(0L);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(DaN);
        localByteBuffer.order(DaO);
        localObject1.read(localByteBuffer);
        this.DaP = localByteBuffer.getInt(0);
        boolean bool = b(localObject1);
        return bool;
      }
      catch (Exception localException2)
      {
        ac.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + localException2.getMessage());
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
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.DaP <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(DaN);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.DaP);
      localByteBuffer.order(DaO);
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
      this.DaR = new dwb();
      this.DaR.parseFrom(paramFileChannel);
      this.DaS = this.DaR.Gdq;
      this.DaT = this.DaR.Gdr;
      this.mDesc = this.DaR.Desc;
      this.DaQ = (DaN + this.DaP);
      AppMethodBeat.o(110686);
      return true;
    }
    catch (Exception paramFileChannel)
    {
      ac.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + paramFileChannel.getMessage());
      AppMethodBeat.o(110686);
    }
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
  
  public final WebResourceResponse kQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((bs.gY(this.DaS)) || (this.DaQ < DaN) || (bs.isNullOrNil(paramString1)))
    {
      ac.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.DaS.iterator();
    while (localIterator1.hasNext())
    {
      aio localaio = (aio)localIterator1.next();
      if (bs.nullAsNil(localaio.EDk).equals(paramString1))
      {
        Object localObject = localaio.EDm;
        if ((!bs.isNullOrNil((String)localObject)) && ((((String)localObject).startsWith("video/")) || (((String)localObject).startsWith("audio/")))) {}
        for (int i = 1; i != 0; i = 0)
        {
          ac.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localaio.ndD <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            ac.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            localObject = new WebResourceResponse(localaio.EDm, paramString2, new b(this.fKs, this.DaQ + localaio.EDl, localaio.ndD));
            if (bs.gY(localaio.EDn)) {
              break label370;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localaio.EDn.iterator();
            while (localIterator2.hasNext())
            {
              aim localaim = (aim)localIterator2.next();
              localHashMap.put(localaim.key, localaim.value);
            }
          }
          catch (IOException localIOException)
          {
            ac.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localaio.EDl), Integer.valueOf(localaio.ndD), localaio.EDm, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label370:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          ac.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localaio.ndD), Long.valueOf(5242880L), paramString1, Long.valueOf(localaio.EDl), localaio.EDm });
        }
      }
    }
    AppMethodBeat.o(110684);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f
 * JD-Core Version:    0.7.0.1
 */