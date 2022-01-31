package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
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
  
  public final boolean A(InputStream paramInputStream)
  {
    AppMethodBeat.i(36752);
    ab.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", new Object[] { this.rjH.getPath() + this.rjH.cpP() });
    Object localObject2 = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject1 = localObject2;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject1 = localObject2;
      localOutputStream2 = e.M(this.rjH.getPath() + this.rjH.cpP(), false);
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      this.rjS.value = "";
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
        if (j > this.rjT)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.rjT = j;
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.rjU = bo.aox();
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (this.rjV == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.rjV = bo.hl(this.rjW);
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (!i.ZK(ag.getAccPath()))
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
            AppMethodBeat.o(36752);
            return false;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, j);
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        this.rka += j;
        i = 1;
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (a(this.rka, l, this.rjS))
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
        a(this.rka, 0L, this.rjS);
      }
      AppMethodBeat.o(36752);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject1 = localOutputStream1;
      ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject1 = localOutputStream1;
      ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
      if (localOutputStream1 != null) {}
      try
      {
        localOutputStream1.close();
        AppMethodBeat.o(36752);
        return false;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
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
      AppMethodBeat.o(36752);
      throw paramInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final String aaW(String paramString)
  {
    return paramString;
  }
  
  public final boolean cpR()
  {
    AppMethodBeat.i(36753);
    String str = i.j(this.cIc);
    e.h(this.rjH.getPath(), this.rjH.cpP(), str);
    AppMethodBeat.o(36753);
    return true;
  }
  
  protected final int cpS()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.h
 * JD-Core Version:    0.7.0.1
 */