package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.Map;

public class HttpDataSource
  implements IDataSource
{
  private final Map<String, String> headers;
  private IMediaHTTPConnection mediaHTTPConnection;
  private final IMediaHTTPService service;
  private final Uri uri;
  
  public HttpDataSource(Uri paramUri, Map<String, String> paramMap, IMediaHTTPService paramIMediaHTTPService)
  {
    this.uri = paramUri;
    this.headers = paramMap;
    this.service = paramIMediaHTTPService;
  }
  
  public void close()
  {
    AppMethodBeat.i(104553);
    if (this.mediaHTTPConnection != null) {
      this.mediaHTTPConnection.disconnect();
    }
    AppMethodBeat.o(104553);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(104552);
    AudioFormat.AudioType localAudioType = FormatDetector.getAudioFormat(this, false);
    AppMethodBeat.o(104552);
    return localAudioType;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(104551);
    long l = this.mediaHTTPConnection.getSize();
    AppMethodBeat.o(104551);
    return l;
  }
  
  public void open()
  {
    AppMethodBeat.i(104549);
    this.mediaHTTPConnection = this.service.makeHTTPConnection();
    this.mediaHTTPConnection.connect(new URL(this.uri.toString()), this.headers);
    AppMethodBeat.o(104549);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104550);
    int i = 0;
    int j;
    do
    {
      j = paramInt1 + i;
      int k = this.mediaHTTPConnection.readAt(i + paramLong, paramArrayOfByte, j, paramInt2 - j);
      if (k < 0)
      {
        AppMethodBeat.o(104550);
        return k;
      }
      j = i;
      if (k == 0) {
        break;
      }
      j = i + k;
      i = j;
    } while (j < paramInt2);
    AppMethodBeat.o(104550);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */