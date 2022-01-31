package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class DefaultMediaHTTPService
  implements IMediaHTTPService
{
  private static final String TAG = "DefaultMediaHTTPService";
  
  public IMediaHTTPConnection makeHTTPConnection()
  {
    AppMethodBeat.i(104799);
    Logger.d("DefaultMediaHTTPService", "makeHTTPConnection");
    DefaultMediaHTTPConnection localDefaultMediaHTTPConnection = new DefaultMediaHTTPConnection();
    AppMethodBeat.o(104799);
    return localDefaultMediaHTTPConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService
 * JD-Core Version:    0.7.0.1
 */