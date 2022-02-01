package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long zoD = 0L;
  private int zoE = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean L(InputStream paramInputStream)
  {
    AppMethodBeat.i(96069);
    com.tencent.mm.plugin.sns.model.b localb = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject = localb;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      String str1 = this.zoe.getPath() + this.zoe.dVg();
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      ad.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(i.aYo(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      localOutputStream2 = i.cX(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.zop.value = "";
      int i = 0;
      for (;;)
      {
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        int k = paramInputStream.read(arrayOfByte);
        if (k == -1) {
          break;
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.zos == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zos = bt.Df(this.zot);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.zoq)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zoq = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zor = bt.aQJ();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!q.ayf(ag.getAccPath()))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ad.i("MicroMsg.SnsDownloadAdSight", "read data");
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localOutputStream2.close();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          paramInputStream.close();
          if (localOutputStream2 != null) {}
          try
          {
            localOutputStream2.close();
            AppMethodBeat.o(96069);
            return false;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, k);
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        this.zox += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.zox - this.zoE > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localb = ag.dTZ();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.zoe.mediaId;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ag.cVf().post(new b.3(localb, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zoE = this.zox;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.zox, l, this.zop))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          l = System.currentTimeMillis();
          i = 0;
          j = k;
        }
      }
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      localOutputStream2.close();
      localObject = null;
      localOutputStream1 = null;
      if (i != 0) {
        a(this.zox, 0L, this.zop);
      }
      ad.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(i.aYo(this.zoe.getPath() + this.zoe.dVg()))));
      AppMethodBeat.o(96069);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject = localOutputStream1;
      ad.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject = localOutputStream1;
      ad.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
      if (localOutputStream1 != null) {}
      try
      {
        localOutputStream1.close();
        AppMethodBeat.o(96069);
        return false;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
    try
    {
      ((OutputStream)localObject).close();
      AppMethodBeat.o(96069);
      throw paramInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SnsDownloadAdSight", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final v a(v paramv)
  {
    AppMethodBeat.i(96068);
    this.zoD = 0L;
    if (this.zoD > 0L)
    {
      ad.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.zoD);
      paramv.setRequestProperty("RANGE", "bytes=" + this.zoD + "-");
    }
    AppMethodBeat.o(96068);
    return paramv;
  }
  
  public final String azv(String paramString)
  {
    return paramString;
  }
  
  public final boolean dVh()
  {
    return false;
  }
  
  public final boolean dVi()
  {
    AppMethodBeat.i(96070);
    long l = i.aYo(this.zoe.getPath() + this.zoe.dVg());
    ad.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.zou);
    if (l < this.zou + this.zoD)
    {
      AppMethodBeat.o(96070);
      return false;
    }
    String str = q.j(this.dIQ);
    i.bb(this.zoe.getPath(), this.zoe.dVg(), str);
    AppMethodBeat.o(96070);
    return true;
  }
  
  protected final int getMediaType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.d
 * JD-Core Version:    0.7.0.1
 */