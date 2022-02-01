package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.3;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long zFS = 0L;
  private int zFT = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean L(InputStream paramInputStream)
  {
    AppMethodBeat.i(96069);
    c localc = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject = localc;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      String str1 = this.zFt.getPath() + this.zFt.dYH();
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      ae.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(o.aZR(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      localOutputStream2 = o.db(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.zFE.value = "";
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
        if (this.zFH == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zFH = bu.DD(this.zFI);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.zFF)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zFF = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zFG = bu.aRi();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!r.azw(ah.getAccPath()))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ae.i("MicroMsg.SnsDownloadAdSight", "read data");
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
              ae.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, k);
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        this.zFM += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.zFM - this.zFT > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localc = ah.dXz();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.zFt.mediaId;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          ah.cXK().post(new c.3(localc, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.zFT = this.zFM;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.zFM, l, this.zFE))
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
        a(this.zFM, 0L, this.zFE);
      }
      ae.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(o.aZR(this.zFt.getPath() + this.zFt.dYH()))));
      AppMethodBeat.o(96069);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject = localOutputStream1;
      ae.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject = localOutputStream1;
      ae.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
          ae.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
        ae.printErrStackTrace("MicroMsg.SnsDownloadAdSight", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final v a(v paramv)
  {
    AppMethodBeat.i(96068);
    this.zFS = 0L;
    if (this.zFS > 0L)
    {
      ae.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.zFS);
      paramv.setRequestProperty("RANGE", "bytes=" + this.zFS + "-");
    }
    AppMethodBeat.o(96068);
    return paramv;
  }
  
  public final String aAM(String paramString)
  {
    return paramString;
  }
  
  public final boolean dYI()
  {
    return false;
  }
  
  public final boolean dYJ()
  {
    AppMethodBeat.i(96070);
    long l = o.aZR(this.zFt.getPath() + this.zFt.dYH());
    ae.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.zFJ);
    if (l < this.zFJ + this.zFS)
    {
      AppMethodBeat.o(96070);
      return false;
    }
    String str = r.j(this.dKe);
    o.bc(this.zFt.getPath(), this.zFt.dYH(), str);
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