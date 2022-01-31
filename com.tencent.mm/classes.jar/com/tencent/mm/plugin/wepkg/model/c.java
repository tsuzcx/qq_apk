package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.c.ciu;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static int rPc = 4;
  private static ByteOrder rPd = ByteOrder.BIG_ENDIAN;
  private volatile String dkv = "";
  private File fDw;
  volatile boolean fDy = false;
  private volatile int rPe;
  private volatile int rPf = 0;
  volatile ciu rPg = null;
  private volatile LinkedList<ze> rPh = null;
  private volatile String rPi = "";
  
  public c(File paramFile)
  {
    this.fDw = paramFile;
    if (abY()) {
      bool = true;
    }
    this.fDy = bool;
  }
  
  private boolean a(FileChannel paramFileChannel)
  {
    if (this.rPe <= 0) {}
    for (;;)
    {
      return false;
      try
      {
        paramFileChannel.position(rPc);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(this.rPe);
        localByteBuffer.order(rPd);
        paramFileChannel.read(localByteBuffer);
        paramFileChannel = localByteBuffer.array();
        if ((paramFileChannel != null) && (paramFileChannel.length != 0))
        {
          this.rPg = new ciu();
          this.rPg.aH(paramFileChannel);
          this.rPh = this.rPg.tXa;
          this.rPi = this.rPg.tXb;
          this.dkv = this.rPg.kRN;
          this.rPf = (rPc + this.rPe);
          return true;
        }
      }
      catch (Exception paramFileChannel)
      {
        y.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + paramFileChannel.getMessage());
      }
    }
    return false;
  }
  
  private boolean abY()
  {
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = new RandomAccessFile(this.fDw, "r").getChannel();
      localObject1 = localFileChannel;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        y.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + localException1.getMessage());
      }
      try
      {
        localObject1.position(0L);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(rPc);
        localByteBuffer.order(rPd);
        localObject1.read(localByteBuffer);
        this.rPe = localByteBuffer.getInt(0);
        boolean bool = a(localObject1);
        return bool;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + localException2.getMessage());
        return false;
      }
      finally
      {
        b(localObject1);
      }
    }
    if (localObject1 == null) {
      return false;
    }
  }
  
  private static void b(FileChannel paramFileChannel)
  {
    if (paramFileChannel != null) {}
    try
    {
      paramFileChannel.close();
      return;
    }
    catch (IOException paramFileChannel) {}
  }
  
  public final m fL(String paramString1, String paramString2)
  {
    if ((bk.dk(this.rPh)) || (this.rPf < rPc) || (bk.bl(paramString1)))
    {
      y.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      return null;
    }
    Iterator localIterator = this.rPh.iterator();
    while (localIterator.hasNext())
    {
      ze localze = (ze)localIterator.next();
      if (bk.pm(localze.sYw).equals(paramString1))
      {
        Object localObject = localze.sYy;
        if ((!bk.bl((String)localObject)) && ((((String)localObject).startsWith("video/")) || (((String)localObject).startsWith("audio/")))) {}
        for (int i = 1; i != 0; i = 0)
        {
          y.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          return null;
        }
        if (localze.hQL <= 5242880L) {
          try
          {
            y.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            localObject = new m(localze.sYy, paramString2, new b(this.fDw, this.rPf + localze.sYx, localze.hQL));
            return localObject;
          }
          catch (IOException localIOException)
          {
            y.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localze.sYx), Integer.valueOf(localze.hQL), localze.sYy, localIOException.getMessage() });
          }
        } else {
          y.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localze.hQL), Long.valueOf(5242880L), paramString1, Long.valueOf(localze.sYx), localze.sYy });
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.c
 * JD-Core Version:    0.7.0.1
 */