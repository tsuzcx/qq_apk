package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.3;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long KcZ = 0L;
  private int Kda = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean H(InputStream paramInputStream)
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
      String str1 = this.KcA.getPath() + this.KcA.fPO();
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      Log.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(u.bBQ(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      localOutputStream2 = u.dI(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.KcL.value = "";
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
        if (this.KcO == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.KcO = Util.milliSecondsToNow(this.KcP);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.KcM)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.KcM = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.KcN = Util.nowSecond();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!t.aZp(aj.getAccPath()))
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
        this.KcT += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.KcT - this.Kda > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localc = aj.fOD();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.KcA.mediaId;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          aj.etE().post(new c.3(localc, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.Kda = this.KcT;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.KcT, l, this.KcL))
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
        a(this.KcT, 0L, this.KcL);
      }
      Log.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(u.bBQ(this.KcA.getPath() + this.KcA.fPO()))));
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
    this.KcZ = 0L;
    if (this.KcZ > 0L)
    {
      Log.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.KcZ);
      paramx.bP("RANGE", "bytes=" + this.KcZ + "-");
    }
    AppMethodBeat.o(96068);
    return paramx;
  }
  
  public final String baE(String paramString)
  {
    return paramString;
  }
  
  public final boolean fPP()
  {
    return false;
  }
  
  public final boolean fPQ()
  {
    AppMethodBeat.i(96070);
    long l = u.bBQ(this.KcA.getPath() + this.KcA.fPO());
    Log.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.KcQ);
    if (l < this.KcQ + this.KcZ)
    {
      AppMethodBeat.o(96070);
      return false;
    }
    String str = t.j(this.fVT);
    u.bj(this.KcA.getPath(), this.KcA.fPO(), str);
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