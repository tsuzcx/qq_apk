package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.3;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long rkg = 0L;
  private int rkh = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean A(InputStream paramInputStream)
  {
    AppMethodBeat.i(36748);
    com.tencent.mm.plugin.sns.model.b localb = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject = localb;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      String str1 = this.rjH.getPath() + this.rjH.cpP();
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      ab.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(e.avI(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      localOutputStream2 = e.M(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.rjS.value = "";
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
        if (this.rjV == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.rjV = bo.hl(this.rjW);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.rjT)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.rjT = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.rjU = bo.aox();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!i.ZK(ag.getAccPath()))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ab.i("MicroMsg.SnsDownloadAdSight", "read data");
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
            AppMethodBeat.o(36748);
            return false;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, k);
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        this.rka += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.rka - this.rkh > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localb = ag.cpa();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.rjH.cBO;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ag.bEf().post(new b.3(localb, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.rkh = this.rka;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.rka, l, this.rjS))
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
        a(this.rka, 0L, this.rjS);
      }
      ab.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(e.avI(this.rjH.getPath() + this.rjH.cpP()))));
      AppMethodBeat.o(36748);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject = localOutputStream1;
      ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject = localOutputStream1;
      ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
      if (localOutputStream1 != null) {}
      try
      {
        localOutputStream1.close();
        AppMethodBeat.o(36748);
        return false;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
      AppMethodBeat.o(36748);
      throw paramInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final String aaW(String paramString)
  {
    return paramString;
  }
  
  public final v b(v paramv)
  {
    AppMethodBeat.i(36747);
    this.rkg = 0L;
    if (this.rkg > 0L)
    {
      ab.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.rkg);
      paramv.setRequestProperty("RANGE", "bytes=" + this.rkg + "-");
    }
    AppMethodBeat.o(36747);
    return paramv;
  }
  
  public final boolean cpQ()
  {
    return false;
  }
  
  public final boolean cpR()
  {
    AppMethodBeat.i(36749);
    long l = e.avI(this.rjH.getPath() + this.rjH.cpP());
    ab.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.rjX);
    if (l < this.rjX + this.rkg)
    {
      AppMethodBeat.o(36749);
      return false;
    }
    String str = i.k(this.cIc);
    e.h(this.rjH.getPath(), this.rjH.cpP(), str);
    AppMethodBeat.o(36749);
    return true;
  }
  
  protected final int cpS()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.d
 * JD-Core Version:    0.7.0.1
 */