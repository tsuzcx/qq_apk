package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.qqmusic.mediaplayer.util.Logger;

public class DefaultMediaHTTPService
  implements IMediaHTTPService
{
  private static final String TAG = "DefaultMediaHTTPService";
  
  public IMediaHTTPConnection makeHTTPConnection()
  {
    Logger.d("DefaultMediaHTTPService", "makeHTTPConnection");
    return new DefaultMediaHTTPConnection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService
 * JD-Core Version:    0.7.0.1
 */