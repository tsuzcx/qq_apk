package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.network.u;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.3;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long ovl = 0L;
  private int ovm = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean A(InputStream paramInputStream)
  {
    com.tencent.mm.plugin.sns.model.b localb = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject = localb;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      String str1 = this.ouO.getPath() + this.ouO.bEq();
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      long l = e.aeQ(str1);
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      y.i("MicroMsg.SnsDownloadAdSight", "getdatabegin " + l);
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      localOutputStream2 = e.I(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.ouZ.value = "";
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
        if (this.ovc == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.ovc = bk.co(this.ovd);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.ova)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.ova = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.ovb = bk.UX();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!i.Nd(af.FU()))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          y.i("MicroMsg.SnsDownloadAdSight", "read data");
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
            return false;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, k);
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        this.ovi += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.ovi - this.ovm > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localb = af.bDA();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.ouO.bUi;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          af.aXq().post(new b.3(localb, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.ovm = this.ovi;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.ovi, l, this.ouZ))
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
        a(this.ovi, 0L, this.ouZ);
      }
      l = e.aeQ(this.ouO.getPath() + this.ouO.bEq());
      y.i("MicroMsg.SnsDownloadAdSight", "getdataend2  " + l);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject = localOutputStream1;
      y.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject = localOutputStream1;
      y.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
      if (localOutputStream1 != null) {}
      try
      {
        localOutputStream1.close();
        return false;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
      throw paramInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SnsDownloadAdSight", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final String Oc(String paramString)
  {
    return paramString;
  }
  
  public final u b(u paramu)
  {
    this.ovl = 0L;
    if (this.ovl > 0L)
    {
      y.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.ovl);
      paramu.setRequestProperty("RANGE", "bytes=" + this.ovl + "-");
    }
    return paramu;
  }
  
  public final boolean bEr()
  {
    return false;
  }
  
  public final boolean bEs()
  {
    long l = e.aeQ(this.ouO.getPath() + this.ouO.bEq());
    y.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.ovf);
    if (l < this.ovf + this.ovl) {
      return false;
    }
    String str = i.k(this.bZK);
    e.f(this.ouO.getPath(), this.ouO.bEq(), str);
    return true;
  }
  
  protected final int bEt()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.d
 * JD-Core Version:    0.7.0.1
 */