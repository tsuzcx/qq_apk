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
    AppMethodBeat.i(76544);
    if (this.mediaHTTPConnection != null) {
      this.mediaHTTPConnection.disconnect();
    }
    AppMethodBeat.o(76544);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(76543);
    AudioFormat.AudioType localAudioType = FormatDetector.getAudioFormat(this, false);
    AppMethodBeat.o(76543);
    return localAudioType;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(76542);
    long l = this.mediaHTTPConnection.getSize();
    AppMethodBeat.o(76542);
    return l;
  }
  
  public void open()
  {
    AppMethodBeat.i(76540);
    this.mediaHTTPConnection = this.service.makeHTTPConnection();
    this.mediaHTTPConnection.connect(new URL(this.uri.toString()), this.headers);
    AppMethodBeat.o(76540);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76541);
    int i = 0;
    int j;
    do
    {
      j = paramInt1 + i;
      int k = this.mediaHTTPConnection.readAt(i + paramLong, paramArrayOfByte, j, paramInt2 - j);
      if (k < 0)
      {
        AppMethodBeat.o(76541);
        return k;
      }
      j = i;
      if (k == 0) {
        break;
      }
      j = i + k;
      i = j;
    } while (j < paramInt2);
    AppMethodBeat.o(76541);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */