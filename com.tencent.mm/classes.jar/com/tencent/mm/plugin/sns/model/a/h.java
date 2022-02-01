package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  
  public final boolean K(InputStream paramInputStream)
  {
    AppMethodBeat.i(96073);
    Log.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", new Object[] { this.DPt.getPath() + this.DPt.fbV() });
    Object localObject2 = null;
    OutputStream localOutputStream2 = null;
    OutputStream localOutputStream1 = localOutputStream2;
    Object localObject1 = localObject2;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localOutputStream1 = localOutputStream2;
      localObject1 = localObject2;
      localOutputStream2 = s.dw(this.DPt.getPath() + this.DPt.fbV(), false);
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      long l = System.currentTimeMillis();
      localOutputStream1 = localOutputStream2;
      localObject1 = localOutputStream2;
      this.DPE.value = "";
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
        if (j > this.DPF)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.DPF = j;
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.DPG = Util.nowSecond();
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (this.DPH == 0L)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          this.DPH = Util.milliSecondsToNow(this.DPI);
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (!r.aOt(aj.getAccPath()))
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
              Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
            }
          }
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localOutputStream2.write(arrayOfByte, 0, j);
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        this.DPM += j;
        i = 1;
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        if (a(this.DPM, l, this.DPE))
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
        a(this.DPM, 0L, this.DPE);
      }
      AppMethodBeat.o(96073);
      return true;
    }
    catch (Exception paramInputStream)
    {
      localObject1 = localOutputStream1;
      Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      localObject1 = localOutputStream1;
      Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", paramInputStream, "", new Object[0]);
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
        Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final String aPI(String paramString)
  {
    return paramString;
  }
  
  public final boolean fbX()
  {
    AppMethodBeat.i(96074);
    String str = r.j(this.ebR);
    s.bo(this.DPt.getPath(), this.DPt.fbV(), str);
    AppMethodBeat.o(96074);
    return true;
  }
  
  protected final int getMediaType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.h
 * JD-Core Version:    0.7.0.1
 */