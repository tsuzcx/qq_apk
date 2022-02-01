package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  
  public final boolean I(InputStream paramInputStream)
  {
    AppMethodBeat.i(96073);
    ac.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", new Object[] { this.xYf.getPath() + this.xYf.dIT() });
    Object localObject2 = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject1 = localObject2;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject1 = localObject2;
      localOutputStream2 = i.cS(this.xYf.getPath() + this.xYf.dIT(), false);
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      this.xYq.value = "";
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
        if (j > this.xYr)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.xYr = j;
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.xYs = bs.aNx();
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (this.xYt == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.xYt = bs.Ap(this.xYu);
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (!q.ata(af.getAccPath()))
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
              ac.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, j);
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        this.xYy += j;
        i = 1;
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (a(this.xYy, l, this.xYq))
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
        a(this.xYy, 0L, this.xYq);
      }
      AppMethodBeat.o(96073);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject1 = localOutputStream1;
      ac.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject1 = localOutputStream1;
      ac.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
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
          ac.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
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
        ac.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final String aup(String paramString)
  {
    return paramString;
  }
  
  public final boolean dIV()
  {
    AppMethodBeat.i(96074);
    String str = q.i(this.dwE);
    i.aT(this.xYf.getPath(), this.xYf.dIT(), str);
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