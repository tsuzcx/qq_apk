package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.3;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends b
{
  private long QAr = 0L;
  private int QAs = 0;
  
  public d(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean V(InputStream paramInputStream)
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
      String str1 = this.QzS.getPath() + this.QzS.hhG();
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      Log.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(com.tencent.mm.vfs.y.bEl(str1))));
      localOutputStream1 = localOutputStream2;
      localObject = localc;
      localOutputStream2 = com.tencent.mm.vfs.y.ev(str1, true);
      int j = 1;
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject = localOutputStream2;
      this.QAd.value = "";
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
        if (this.QAg == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.QAg = Util.milliSecondsToNow(this.QAh);
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (k > this.QAe)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.QAe = k;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.QAf = Util.nowSecond();
        }
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (!t.aXA(al.getAccPath()))
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
        this.QAl += k;
        k = j;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (this.QAl - this.QAs > 409600 * j)
        {
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          localc = al.hgw();
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          String str2 = this.QzS.mediaId;
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          al.fAG().post(new c.3(localc, str2, str1));
          localOutputStream1 = localOutputStream2;
          localObject = localOutputStream2;
          this.QAs = this.QAl;
          k = j + 1;
        }
        i = 1;
        j = k;
        localOutputStream1 = localOutputStream2;
        localObject = localOutputStream2;
        if (a(this.QAl, l, this.QAd))
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
        a(this.QAl, 0L, this.QAd);
      }
      Log.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(com.tencent.mm.vfs.y.bEl(this.QzS.getPath() + this.QzS.hhG()))));
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
  
  public final com.tencent.mm.network.y a(com.tencent.mm.network.y paramy)
  {
    AppMethodBeat.i(96068);
    this.QAr = 0L;
    if (this.QAr > 0L)
    {
      Log.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.QAr);
      paramy.setRequestProperty("RANGE", "bytes=" + this.QAr + "-");
    }
    AppMethodBeat.o(96068);
    return paramy;
  }
  
  public final String aYY(String paramString)
  {
    return paramString;
  }
  
  protected final int getMediaType()
  {
    return 4;
  }
  
  public final boolean hhH()
  {
    return false;
  }
  
  public final boolean hhI()
  {
    AppMethodBeat.i(96070);
    long l = com.tencent.mm.vfs.y.bEl(this.QzS.getPath() + this.QzS.hhG());
    Log.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + l + " " + this.QAi);
    if (l < this.QAi + this.QAr)
    {
      AppMethodBeat.o(96070);
      return false;
    }
    String str = t.j(this.ibT);
    com.tencent.mm.vfs.y.bF(this.QzS.getPath(), this.QzS.hhG(), str);
    AppMethodBeat.o(96070);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.d
 * JD-Core Version:    0.7.0.1
 */