package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class h
  extends b
{
  public h(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean J(InputStream paramInputStream)
  {
    AppMethodBeat.i(96073);
    ad.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", new Object[] { this.wLz.getPath() + this.wLz.dut() });
    Object localObject2 = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject1 = localObject2;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject1 = localObject2;
      localOutputStream2 = i.cM(this.wLz.getPath() + this.wLz.dut(), false);
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      this.wLK.value = "";
      int i = 0;
      for (;;)
      {
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        int j = paramInputStream.read(arrayOfByte);
        if (j == -1) {
          break;
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (j > this.wLL)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.wLL = j;
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.wLM = bt.aGK();
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (this.wLN == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.wLN = bt.vM(this.wLO);
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (!q.anO(af.getAccPath()))
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          localOutputStream2.close();
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          paramInputStream.close();
          if (localOutputStream2 != null) {}
          try
          {
            localOutputStream2.close();
            AppMethodBeat.o(96073);
            return false;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, j);
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        this.wLS += j;
        i = 1;
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (a(this.wLS, l, this.wLK))
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          l = System.currentTimeMillis();
          i = 0;
        }
      }
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      localOutputStream2.close();
      localObject1 = null;
      localOutputStream1 = null;
      if (i != 0) {
        a(this.wLS, 0L, this.wLK);
      }
      AppMethodBeat.o(96073);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject1 = localOutputStream1;
      ad.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject1 = localOutputStream1;
      ad.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
      if (localOutputStream1 != null) {}
      try
      {
        localOutputStream1.close();
        AppMethodBeat.o(96073);
        return false;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
    try
    {
      ((OutputStream)localObject1).close();
      AppMethodBeat.o(96073);
      throw paramInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final String apd(String paramString)
  {
    return paramString;
  }
  
  public final boolean duv()
  {
    AppMethodBeat.i(96074);
    String str = q.i(this.dyS);
    i.aQ(this.wLz.getPath(), this.wLz.dut(), str);
    AppMethodBeat.o(96074);
    return true;
  }
  
  protected final int getMediaType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.h
 * JD-Core Version:    0.7.0.1
 */