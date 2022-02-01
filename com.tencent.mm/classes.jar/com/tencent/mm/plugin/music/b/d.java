package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import java.net.URL;
import java.util.HashMap;

public final class d
  extends com.tencent.mm.audio.mix.g.b
{
  private IMediaHTTPConnection LID;
  private com.tencent.mm.al.b hsd;
  
  public d(IMediaHTTPConnection paramIMediaHTTPConnection, com.tencent.mm.al.b paramb)
  {
    this.LID = paramIMediaHTTPConnection;
    this.hsd = paramb;
  }
  
  public final com.tencent.mm.al.b aGB()
  {
    return this.hsd;
  }
  
  public final String aGC()
  {
    AppMethodBeat.i(270876);
    if (this.LID != null)
    {
      str = this.LID.getMIMEType();
      AppMethodBeat.o(270876);
      return str;
    }
    String str = super.aGC();
    AppMethodBeat.o(270876);
    return str;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(270865);
    if (this.LID != null) {}
    try
    {
      URL localURL = new URL(this.hsd.hsg);
      HashMap localHashMap = new HashMap();
      this.LID.connect(localURL, localHashMap);
      AppMethodBeat.o(270865);
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
    AppMethodBeat.i(270867);
    if (this.LID != null) {
      this.LID.disconnect();
    }
    AppMethodBeat.o(270867);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(270873);
    if (this.LID != null)
    {
      l = this.LID.getSize();
      AppMethodBeat.o(270873);
      return l;
    }
    long l = super.getSize();
    AppMethodBeat.o(270873);
    return l;
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270870);
    if (this.LID != null)
    {
      paramInt1 = this.LID.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(270870);
      return paramInt1;
    }
    paramInt1 = super.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(270870);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.d
 * JD-Core Version:    0.7.0.1
 */