package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  private static int EXi = 4;
  private static ByteOrder EXj = ByteOrder.BIG_ENDIAN;
  private volatile int EXk;
  private volatile int EXl;
  volatile eds EXm;
  private volatile LinkedList<alo> EXn;
  private volatile String EXo;
  private k ggb;
  volatile boolean jIo;
  private volatile String mDesc;
  
  public f(k paramk)
  {
    AppMethodBeat.i(177090);
    this.jIo = false;
    this.EXl = 0;
    this.EXm = null;
    this.EXn = null;
    this.EXo = "";
    this.mDesc = "";
    this.ggb = paramk;
    if (baW()) {
      bool = true;
    }
    this.jIo = bool;
    AppMethodBeat.o(177090);
  }
  
  private static boolean aMj(String paramString)
  {
    AppMethodBeat.i(209398);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209398);
      return false;
    }
    if ((paramString.startsWith("video/")) || (paramString.startsWith("audio/")))
    {
      AppMethodBeat.o(209398);
      return true;
    }
    AppMethodBeat.o(209398);
    return false;
  }
  
  private boolean b(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(110686);
    if (this.EXk <= 0)
    {
      AppMethodBeat.o(110686);
      return false;
    }
    try
    {
      paramFileChannel.position(EXi);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.EXk);
      localByteBuffer.order(EXj);
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
      this.EXm = new eds();
      this.EXm.parseFrom(paramFileChannel);
      this.EXn = this.EXm.IiD;
      this.EXo = this.EXm.IiE;
      this.mDesc = this.EXm.Desc;
      this.EXl = (EXi + this.EXk);
      AppMethodBeat.o(110686);
      return true;
    }
    catch (Exception paramFileChannel)
    {
      ae.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + paramFileChannel.getMessage());
      AppMethodBeat.o(110686);
    }
    return false;
  }
  
  private boolean baW()
  {
    AppMethodBeat.i(110685);
    localObject1 = null;
    try
    {
      FileChannel localFileChannel = o.dg(w.B(this.ggb.mUri), false).getChannel();
      localObject1 = localFileChannel;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ae.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + localException1.getMessage());
      }
      try
      {
        localObject1.position(0L);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(EXi);
        localByteBuffer.order(EXj);
        localObject1.read(localByteBuffer);
        this.EXk = localByteBuffer.getInt(0);
        boolean bool = b(localObject1);
        return bool;
      }
      catch (Exception localException2)
      {
        ae.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + localException2.getMessage());
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
  
  public final String fbM()
  {
    AppMethodBeat.i(209399);
    if ((bu.ht(this.EXn)) || (this.EXl < EXi))
    {
      ae.e("MicroMsg.Wepkg.WePkgReader", "getAllCode, mFileIndexList is null");
      AppMethodBeat.o(209399);
      return null;
    }
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.EXn.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (alo)localIterator.next();
      if (!aMj(((alo)localObject2).GDG)) {
        try
        {
          localObject2 = d.convertStreamToString(new b(this.ggb, this.EXl + ((alo)localObject2).GDF, ((alo)localObject2).nJv));
          if (localObject2 != null)
          {
            ((StringBuilder)localObject1).append("\n");
            ((StringBuilder)localObject1).append((String)localObject2);
          }
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.Wepkg.WePkgReader", "getAllCode: " + localIOException.getMessage());
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(209399);
    return localObject1;
  }
  
  public final WebResourceResponse lu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110684);
    if ((bu.ht(this.EXn)) || (this.EXl < EXi) || (bu.isNullOrNil(paramString1)))
    {
      ae.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
      AppMethodBeat.o(110684);
      return null;
    }
    Iterator localIterator1 = this.EXn.iterator();
    while (localIterator1.hasNext())
    {
      alo localalo = (alo)localIterator1.next();
      if (bu.nullAsNil(localalo.GDE).equals(paramString1))
      {
        if (aMj(localalo.GDG))
        {
          ae.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[] { paramString1 });
          AppMethodBeat.o(110684);
          return null;
        }
        if (localalo.nJv <= 5242880L)
        {
          HashMap localHashMap;
          try
          {
            ae.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[] { paramString1 });
            WebResourceResponse localWebResourceResponse = new WebResourceResponse(localalo.GDG, paramString2, new b(this.ggb, this.EXl + localalo.GDF, localalo.nJv));
            if (bu.ht(localalo.GDH)) {
              break label338;
            }
            localHashMap = new HashMap();
            Iterator localIterator2 = localalo.GDH.iterator();
            while (localIterator2.hasNext())
            {
              alm localalm = (alm)localIterator2.next();
              localHashMap.put(localalm.key, localalm.value);
            }
          }
          catch (IOException localIOException)
          {
            ae.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[] { paramString1, Long.valueOf(localalo.GDF), Integer.valueOf(localalo.nJv), localalo.GDG, localIOException.getMessage() });
          }
          localIOException.mResponseHeaders = localHashMap;
          label338:
          AppMethodBeat.o(110684);
          return localIOException;
        }
        else
        {
          ae.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[] { Integer.valueOf(localalo.nJv), Long.valueOf(5242880L), paramString1, Long.valueOf(localalo.GDF), localalo.GDG });
        }
      }
    }
    AppMethodBeat.o(110684);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f
 * JD-Core Version:    0.7.0.1
 */