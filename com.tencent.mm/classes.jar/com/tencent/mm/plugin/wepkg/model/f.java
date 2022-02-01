package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.dqk;
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
  private static int BIE = 4;
  private static ByteOrder BIF = ByteOrder.BIG_ENDIAN;
  private volatile int BIG;
  private volatile int BIH;
  volatile dqk BII;
  private volatile LinkedList<ahp> BIJ;
  private volatile String BIK;
  private e fGL;
  volatile boolean iLs;
  private volatile String mDesc;
  
  public f(e parame)
  {
    AppMethodBeat.i(177090);
    this.iLs = false;
    this.BIH = 0;
    this.BII = null;
    this.BIJ = null;
    this.BIK = "";
    this.mDesc = "";
    this.fGL = parame;
    if (aQh()) {
      bool = true;
    }
    this.iLs = bool;
    AppMethodBeat.o(177090);
  }
  
  private boolean aQh()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = i.cS(q.B(this.fGL.mUri), false).getChannel();
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
        ByteBuffer localByteBuffer = ByteBuffer.allocate(BIE);
        localByteBuffer.order(BIF);
        localObject1.read(localByteBuffer);
        this.BIG = localByteBuffer.getInt(0);
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
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.BIG <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(BIE);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.BIG);
      localByteBuffer.order(BIF);
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
      this.BII = new dqk();
      this.BII.parseFrom(paramFileChannel);
      this.BIJ = this.BII.EGe;
      this.BIK = this.BII.EGf;
      this.mDesc = this.BII.Desc;
      this.BIH = (BIE + this.BIG);
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
  
  public final WebResourceResponse ku(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((bt.gL(this.BIJ)) || (this.BIH < BIE) || (bt.isNullOrNil(paramString1)))
    {
      ad.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.BIJ.iterator();
    while (localIterator1.hasNext())
    {
      ahp localahp = (ahp)localIterator1.next();
      if (bt.nullAsNil(localahp.Dke).equals(paramString1))
      {
        Object localObject = localahp.Dkg;
        if ((!bt.isNullOrNil((String)localObject)) && ((((String)localObject).startsWith("video/")) || (((String)localObject).startsWith("audio/")))) {}
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localahp.mBC <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            ad.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            localObject = new WebResourceResponse(localahp.Dkg, paramString2, new b(this.fGL, this.BIH + localahp.Dkf, localahp.mBC));
            if (bt.gL(localahp.Dkh)) {
              break label370;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localahp.Dkh.iterator();
            while (localIterator2.hasNext())
            {
              ahn localahn = (ahn)localIterator2.next();
              localHashMap.put(localahn.key, localahn.value);
            }
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localahp.Dkf), Integer.valueOf(localahp.mBC), localahp.Dkg, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label370:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          ad.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localahp.mBC), Long.valueOf(5242880L), paramString1, Long.valueOf(localahp.Dkf), localahp.Dkg });
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