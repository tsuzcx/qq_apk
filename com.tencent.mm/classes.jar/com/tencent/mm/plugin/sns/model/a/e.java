package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean V(InputStream paramInputStream)
  {
    AppMethodBeat.i(309477);
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    localObject1 = localObject5;
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localObject2 = localObject4;
      localObject1 = localObject5;
      if (this.QzS.Qsr.vhJ == 6) {}
      for (Object localObject3 = ".mp4";; localObject3 = ".jpg")
      {
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject3 = as.mh(this.QzS.Qsr.Id, (String)localObject3);
        localObject2 = localObject4;
        localObject1 = localObject5;
        Log.i("MicroMsg.SnsDownloadCommonMedia", "download common media. path = %s ", new Object[] { localObject3 });
        localObject2 = localObject4;
        localObject1 = localObject5;
        bool = y.ZC((String)localObject3);
        if (!bool) {
          break;
        }
        AppMethodBeat.o(309477);
        return true;
      }
      localObject2 = localObject4;
      localObject1 = localObject5;
      boolean bool = y.bEp((String)localObject3);
      if (!bool)
      {
        AppMethodBeat.o(309477);
        return false;
      }
      localObject2 = localObject4;
      localObject1 = localObject5;
      localObject3 = y.ev((String)localObject3, false);
      localObject2 = localObject3;
      localObject1 = localObject3;
      this.QAd.value = "";
      for (;;)
      {
        localObject2 = localObject3;
        localObject1 = localObject3;
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (i > this.QAe)
        {
          localObject2 = localObject3;
          localObject1 = localObject3;
          this.QAe = i;
          localObject2 = localObject3;
          localObject1 = localObject3;
          this.QAf = Util.nowSecond();
        }
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (this.QAg == 0L)
        {
          localObject2 = localObject3;
          localObject1 = localObject3;
          this.QAg = Util.milliSecondsToNow(this.QAh);
        }
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (!t.aXA(al.getAccPath()))
        {
          localObject2 = localObject3;
          localObject1 = localObject3;
          ((OutputStream)localObject3).close();
          localObject2 = localObject3;
          localObject1 = localObject3;
          paramInputStream.close();
          if (localObject3 != null) {}
          try
          {
            ((OutputStream)localObject3).close();
            AppMethodBeat.o(309477);
            return false;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.SnsDownloadCommonMedia", paramInputStream, "", new Object[0]);
            }
          }
        }
        localObject2 = localObject3;
        localObject1 = localObject3;
        ((OutputStream)localObject3).write(arrayOfByte, 0, i);
        localObject2 = localObject3;
        localObject1 = localObject3;
        this.QAl = (i + this.QAl);
      }
      try
      {
        localObject1.close();
        AppMethodBeat.o(309477);
        throw paramInputStream;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SnsDownloadCommonMedia", localIOException, "", new Object[0]);
        }
      }
    }
    catch (Exception paramInputStream)
    {
      localObject1 = localObject2;
      Log.printErrStackTrace("MicroMsg.SnsDownloadCommonMedia", paramInputStream, "snscdndownload fail : " + paramInputStream.getMessage(), new Object[0]);
      if (localObject2 != null) {}
      try
      {
        localObject2.close();
        AppMethodBeat.o(309477);
        return false;
        localObject2 = localObject3;
        localObject1 = localObject3;
        ((OutputStream)localObject3).close();
        AppMethodBeat.o(309477);
        return true;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SnsDownloadCommonMedia", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  protected final int getMediaType()
  {
    return this.QzS.Qsr.vhJ;
  }
  
  public final boolean hhI()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.e
 * JD-Core Version:    0.7.0.1
 */