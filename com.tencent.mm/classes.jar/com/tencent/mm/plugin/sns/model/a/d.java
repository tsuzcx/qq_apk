package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.3;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long xYE = 0L;
  private int xYF = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean I(InputStream paramInputStream)
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
      String str1 = this.xYf.getPath() + this.xYf.dIT();
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      ac.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(i.aSp(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localb;
      localOutputStream2 = i.cS(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.xYq.value = "";
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
        if (this.xYt == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.xYt = bs.Ap(this.xYu);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.xYr)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.xYr = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.xYs = bs.aNx();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!q.ata(af.getAccPath()))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ac.i("MicroMsg.SnsDownloadAdSight", "read data");
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
              ac.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, k);
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        this.xYy += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.xYy - this.xYF > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localb = af.dHM();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.xYf.mediaId;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          af.cMM().post(new b.3(localb, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.xYF = this.xYy;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.xYy, l, this.xYq))
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
        a(this.xYy, 0L, this.xYq);
      }
      ac.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(i.aSp(this.xYf.getPath() + this.xYf.dIT()))));
      AppMethodBeat.o(96069);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject = localOutputStream1;
      ac.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject = localOutputStream1;
      ac.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
          ac.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
        ac.printErrStackTrace("MicroMsg.SnsDownloadAdSight", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final v a(v paramv)
  {
    AppMethodBeat.i(96068);
    this.xYE = 0L;
    if (this.xYE > 0L)
    {
      ac.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.xYE);
      paramv.setRequestProperty("RANGE", "bytes=" + this.xYE + "-");
    }
    AppMethodBeat.o(96068);
    return paramv;
  }
  
  public final String aup(String paramString)
  {
    return paramString;
  }
  
  public final boolean dIU()
  {
    return false;
  }
  
  public final boolean dIV()
  {
    AppMethodBeat.i(96070);
    long l = i.aSp(this.xYf.getPath() + this.xYf.dIT());
    ac.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.xYv);
    if (l < this.xYv + this.xYE)
    {
      AppMethodBeat.o(96070);
      return false;
    }
    String str = q.j(this.dwE);
    i.aT(this.xYf.getPath(), this.xYf.dIT(), str);
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