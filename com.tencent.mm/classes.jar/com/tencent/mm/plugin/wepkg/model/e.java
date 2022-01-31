package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.s;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static int vFU = 4;
  private static ByteOrder vFV = ByteOrder.BIG_ENDIAN;
  private File gVL;
  volatile boolean gVO;
  private volatile String mDesc;
  private volatile int vFW;
  private volatile int vFX;
  volatile cwh vFY;
  private volatile LinkedList<adp> vFZ;
  private volatile String vGa;
  
  public e(File paramFile)
  {
    AppMethodBeat.i(63525);
    this.gVO = false;
    this.vFX = 0;
    this.vFY = null;
    this.vFZ = null;
    this.vGa = "";
    this.mDesc = "";
    this.gVL = paramFile;
    if (avP()) {
      bool = true;
    }
    this.gVO = bool;
    AppMethodBeat.o(63525);
  }
  
  private boolean a(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(63528);
    if (this.vFW <= 0)
    {
      AppMethodBeat.o(63528);
      return false;
    }
    try
    {
      paramFileChannel.position(vFU);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.vFW);
      localByteBuffer.order(vFV);
      paramFileChannel.read(localByteBuffer);
      paramFileChannel = localByteBuffer.array();
      if (paramFileChannel != null)
      {
        int i = paramFileChannel.length;
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(63528);
        return false;
      }
      this.vFY = new cwh();
      this.vFY.parseFrom(paramFileChannel);
      this.vFZ = this.vFY.yev;
      this.vGa = this.vFY.yew;
      this.mDesc = this.vFY.Desc;
      this.vFX = (vFU + this.vFW);
      AppMethodBeat.o(63528);
      return true;
    }
    catch (Exception paramFileChannel)
    {
      ab.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + paramFileChannel.getMessage());
      AppMethodBeat.o(63528);
    }
    return false;
  }
  
  private boolean avP()
  {
    AppMethodBeat.i(63527);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = new RandomAccessFile(this.gVL, "r").getChannel();
      localObject1 = localFileChannel;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + localException1.getMessage());
      }
      try
      {
        localObject1.position(0L);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(vFU);
        localByteBuffer.order(vFV);
        localObject1.read(localByteBuffer);
        this.vFW = localByteBuffer.getInt(0);
        boolean bool = a(localObject1);
        return bool;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + localException2.getMessage());
        return false;
      }
      finally
      {
        b(localObject1);
        AppMethodBeat.o(63527);
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(63527);
      return false;
    }
  }
  
  private static void b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(63529);
    if (paramFileChannel != null) {
      try
      {
        paramFileChannel.close();
        AppMethodBeat.o(63529);
        return;
      }
      catch (IOException paramFileChannel) {}
    }
    AppMethodBeat.o(63529);
  }
  
  public final s hO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63526);
    if ((bo.es(this.vFZ)) || (this.vFX < vFU) || (bo.isNullOrNil(paramString1)))
    {
      ab.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(63526);
      return null;
    }
    Iterator localIterator = this.vFZ.iterator();
    while (localIterator.hasNext())
    {
      adp localadp = (adp)localIterator.next();
      if (bo.nullAsNil(localadp.wWA).equals(paramString1))
      {
        Object localObject = localadp.wWC;
        if ((!bo.isNullOrNil((String)localObject)) && ((((String)localObject).startsWith("video/")) || (((String)localObject).startsWith("audio/")))) {}
        for (int i = 1; i != 0; i = 0)
        {
          ab.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(63526);
          return null;
        }
        if (localadp.jKn <= 5242880L) {
          try
          {
            ab.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            localObject = new s(localadp.wWC, paramString2, new b(this.gVL, this.vFX + localadp.wWB, localadp.jKn));
            AppMethodBeat.o(63526);
            return localObject;
          }
          catch (IOException localIOException)
          {
            ab.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localadp.wWB), Integer.valueOf(localadp.jKn), localadp.wWC, localIOException.getMessage() });
          }
        } else {
          ab.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localadp.jKn), Long.valueOf(5242880L), paramString1, Long.valueOf(localadp.wWB), localadp.wWC });
        }
      }
    }
    AppMethodBeat.o(63526);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e
 * JD-Core Version:    0.7.0.1
 */