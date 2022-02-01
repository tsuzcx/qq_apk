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
    AppMethodBeat.i(220594);
    this.opened = false;
    this.closed = false;
    this.dataSource = paramDataSource;
    this.dataSpec = paramDataSpec;
    this.singleByteArray = new byte[1];
    AppMethodBeat.o(220594);
  }
  
  private void checkOpened()
  {
    AppMethodBeat.i(220600);
    if (!this.opened)
    {
      this.dataSource.open(this.dataSpec);
      this.opened = true;
    }
    AppMethodBeat.o(220600);
  }
  
  public final long bytesRead()
  {
    return this.totalBytesRead;
  }
  
  public final void close()
  {
    AppMethodBeat.i(220599);
    if (!this.closed)
    {
      this.dataSource.close();
      this.closed = true;
    }
    AppMethodBeat.o(220599);
  }
  
  public final void open()
  {
    AppMethodBeat.i(220595);
    checkOpened();
    AppMethodBeat.o(220595);
  }
  
  public final int read()
  {
    AppMethodBeat.i(220596);
    if (read(this.singleByteArray) == -1)
    {
      AppMethodBeat.o(220596);
      return -1;
    }
    int i = this.singleByteArray[0];
    AppMethodBeat.o(220596);
    return i & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220597);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(220597);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220598);
    if (!this.closed) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      paramInt1 = this.dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break;
      }
      AppMethodBeat.o(220598);
      return -1;
    }
    this.totalBytesRead += paramInt1;
    AppMethodBeat.o(220598);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DataSourceInputStream
 * JD-Core Version:    0.7.0.1
 */