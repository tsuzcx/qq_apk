package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DefaultHttpDataSourceFactory
  extends HttpDataSource.BaseFactory
{
  private final boolean allowCrossProtocolRedirects;
  private final int connectTimeoutMillis;
  private final TransferListener listener;
  private final int readTimeoutMillis;
  private final String userAgent;
  
  public DefaultHttpDataSourceFactory(String paramString)
  {
    this(paramString, null);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramString, null, paramInt1, paramInt2, paramBoolean);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, TransferListener paramTransferListener)
  {
    this(paramString, paramTransferListener, 8000, 8000, false);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, TransferListener paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(193847);
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.listener = paramTransferListener;
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    AppMethodBeat.o(193847);
  }
  
  protected final DefaultHttpDataSource createDataSourceInternal(int paramInt, HttpDataSource.RequestProperties paramRequestProperties)
  {
    AppMethodBeat.i(193849);
    paramRequestProperties = new DefaultHttpDataSource(this.userAgent, null, paramInt, paramInt, this.allowCrossProtocolRedirects, paramRequestProperties);
    if (this.listener != null) {
      paramRequestProperties.addTransferListener(this.listener);
    }
    AppMethodBeat.o(193849);
    return paramRequestProperties;
  }
  
  protected final DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties paramRequestProperties)
  {
    AppMethodBeat.i(193848);
    paramRequestProperties = new DefaultHttpDataSource(this.userAgent, null, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, paramRequestProperties);
    if (this.listener != null) {
      paramRequestProperties.addTransferListener(this.listener);
    }
    AppMethodBeat.o(193848);
    return paramRequestProperties;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */