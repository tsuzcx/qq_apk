package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import java.net.URL;
import java.util.HashMap;

public final class d
  extends com.tencent.mm.audio.mix.g.b
{
  private IMediaHTTPConnection FNH;
  private com.tencent.mm.al.b fnS;
  
  public d(IMediaHTTPConnection paramIMediaHTTPConnection, com.tencent.mm.al.b paramb)
  {
    this.FNH = paramIMediaHTTPConnection;
    this.fnS = paramb;
  }
  
  public final com.tencent.mm.al.b aeD()
  {
    return this.fnS;
  }
  
  public final String aeE()
  {
    AppMethodBeat.i(257476);
    if (this.FNH != null)
    {
      str = this.FNH.getMIMEType();
      AppMethodBeat.o(257476);
      return str;
    }
    String str = super.aeE();
    AppMethodBeat.o(257476);
    return str;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(257472);
    if (this.FNH != null) {}
    try
    {
      URL localURL = new URL(this.fnS.fnV);
      HashMap localHashMap = new HashMap();
      this.FNH.connect(localURL, localHashMap);
      AppMethodBeat.o(257472);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.AudioHttpDownloadSource", localException, "connect", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(257473);
    if (this.FNH != null) {
      this.FNH.disconnect();
    }
    AppMethodBeat.o(257473);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(257475);
    if (this.FNH != null)
    {
      l = this.FNH.getSize();
      AppMethodBeat.o(257475);
      return l;
    }
    long l = super.getSize();
    AppMethodBeat.o(257475);
    return l;
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257474);
    if (this.FNH != null)
    {
      paramInt1 = this.FNH.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(257474);
      return paramInt1;
    }
    paramInt1 = super.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(257474);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.d
 * JD-Core Version:    0.7.0.1
 */