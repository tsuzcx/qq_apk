package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.3;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long DPS = 0L;
  private int DPT = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean K(InputStream paramInputStream)
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
      String str1 = this.DPt.getPath() + this.DPt.fbV();
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      Log.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(s.boW(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      localOutputStream2 = s.dw(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.DPE.value = "";
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
        if (this.DPH == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.DPH = Util.milliSecondsToNow(this.DPI);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.DPF)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.DPF = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.DPG = Util.nowSecond();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!r.aOt(aj.getAccPath()))
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          Log.i("MicroMsg.SnsDownloadAdSight", "read data");
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
              Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, k);
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        this.DPM += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.DPM - this.DPT > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localc = aj.faJ();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.DPt.mediaId;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          aj.dRd().post(new c.3(localc, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.DPT = this.DPM;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.DPM, l, this.DPE))
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
        a(this.DPM, 0L, this.DPE);
      }
      Log.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(s.boW(this.DPt.getPath() + this.DPt.fbV()))));
      AppMethodBeat.o(96069);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject = localOutputStream1;
      Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject = localOutputStream1;
      Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", paramInputStream, "", new Object[0]);
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
        Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final x a(x paramx)
  {
    AppMethodBeat.i(96068);
    this.DPS = 0L;
    if (this.DPS > 0L)
    {
      Log.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.DPS);
      paramx.setRequestProperty("RANGE", "bytes=" + this.DPS + "-");
    }
    AppMethodBeat.o(96068);
    return paramx;
  }
  
  public final String aPI(String paramString)
  {
    return paramString;
  }
  
  public final boolean fbW()
  {
    return false;
  }
  
  public final boolean fbX()
  {
    AppMethodBeat.i(96070);
    long l = s.boW(this.DPt.getPath() + this.DPt.fbV());
    Log.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.DPJ);
    if (l < this.DPJ + this.DPS)
    {
      AppMethodBeat.o(96070);
      return false;
    }
    String str = r.k(this.ebR);
    s.bo(this.DPt.getPath(), this.DPt.fbV(), str);
    AppMethodBeat.o(96070);
    return true;
  }
  
  protected final int getMediaType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.d
 * JD-Core Version:    0.7.0.1
 */