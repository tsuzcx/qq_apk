package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import java.net.URL;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.audio.mix.h.b
{
  private IMediaHTTPConnection AgO;
  private com.tencent.mm.ai.b dvk;
  
  public c(IMediaHTTPConnection paramIMediaHTTPConnection, com.tencent.mm.ai.b paramb)
  {
    this.AgO = paramIMediaHTTPConnection;
    this.dvk = paramb;
  }
  
  public final com.tencent.mm.ai.b ZU()
  {
    return this.dvk;
  }
  
  public final String ZV()
  {
    AppMethodBeat.i(198139);
    if (this.AgO != null)
    {
      str = this.AgO.getMIMEType();
      AppMethodBeat.o(198139);
      return str;
    }
    String str = super.ZV();
    AppMethodBeat.o(198139);
    return str;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(198135);
    if (this.AgO != null) {}
    try
    {
      URL localURL = new URL(this.dvk.dvn);
      HashMap localHashMap = new HashMap();
      this.AgO.connect(localURL, localHashMap);
      AppMethodBeat.o(198135);
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
    AppMethodBeat.i(198136);
    if (this.AgO != null) {
      this.AgO.disconnect();
    }
    AppMethodBeat.o(198136);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(198138);
    if (this.AgO != null)
    {
      l = this.AgO.getSize();
      AppMethodBeat.o(198138);
      return l;
    }
    long l = super.getSize();
    AppMethodBeat.o(198138);
    return l;
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198137);
    if (this.AgO != null)
    {
      paramInt1 = this.AgO.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(198137);
      return paramInt1;
    }
    paramInt1 = super.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(198137);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.c
 * JD-Core Version:    0.7.0.1
 */