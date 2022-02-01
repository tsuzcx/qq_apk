package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class DataSourceInputStream
  extends InputStream
{
  private boolean closed;
  private final DataSource dataSource;
  private final DataSpec dataSpec;
  private boolean opened;
  private final byte[] singleByteArray;
  private long totalBytesRead;
  
  public DataSourceInputStream(DataSource paramDataSource, DataSpec paramDataSpec)
  {
    AppMethodBeat.i(193812);
    this.opened = false;
    this.closed = false;
    this.dataSource = paramDataSource;
    this.dataSpec = paramDataSpec;
    this.singleByteArray = new byte[1];
    AppMethodBeat.o(193812);
  }
  
  private void checkOpened()
  {
    AppMethodBeat.i(193818);
    if (!this.opened)
    {
      this.dataSource.open(this.dataSpec);
      this.opened = true;
    }
    AppMethodBeat.o(193818);
  }
  
  public final long bytesRead()
  {
    return this.totalBytesRead;
  }
  
  public final void close()
  {
    AppMethodBeat.i(193817);
    if (!this.closed)
    {
      this.dataSource.close();
      this.closed = true;
    }
    AppMethodBeat.o(193817);
  }
  
  public final void open()
  {
    AppMethodBeat.i(193813);
    checkOpened();
    AppMethodBeat.o(193813);
  }
  
  public final int read()
  {
    AppMethodBeat.i(193814);
    if (read(this.singleByteArray) == -1)
    {
      AppMethodBeat.o(193814);
      return -1;
    }
    int i = this.singleByteArray[0];
    AppMethodBeat.o(193814);
    return i & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193815);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(193815);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193816);
    if (!this.closed) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      paramInt1 = this.dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break;
      }
      AppMethodBeat.o(193816);
      return -1;
    }
    this.totalBytesRead += paramInt1;
    AppMethodBeat.o(193816);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DataSourceInputStream
 * JD-Core Version:    0.7.0.1
 */