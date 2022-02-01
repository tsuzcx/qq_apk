package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/MultiInputStream;", "Ljava/io/InputStream;", "first", "second", "(Ljava/io/InputStream;Ljava/io/InputStream;)V", "available", "", "close", "", "mark", "readlimit", "markSupported", "", "read", "b", "", "off", "len", "reset", "skip", "", "n", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends InputStream
{
  public static final a YtK;
  private InputStream YtL;
  private InputStream YtM;
  
  static
  {
    AppMethodBeat.i(245527);
    YtK = new a((byte)0);
    AppMethodBeat.o(245527);
  }
  
  public l(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    AppMethodBeat.i(245521);
    this.YtL = paramInputStream1;
    this.YtM = paramInputStream2;
    AppMethodBeat.o(245521);
  }
  
  public final int available()
  {
    AppMethodBeat.i(245543);
    int i = this.YtL.available();
    int j = this.YtM.available();
    AppMethodBeat.o(245543);
    return i + j;
  }
  
  public final void close()
  {
    AppMethodBeat.i(245547);
    this.YtL.close();
    this.YtM.close();
    AppMethodBeat.o(245547);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(245550);
      this.YtL.mark(paramInt);
      this.YtM.mark(paramInt - this.YtL.available());
      AppMethodBeat.o(245550);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    return false;
  }
  
  public final int read()
  {
    AppMethodBeat.i(245530);
    int i = this.YtL.read();
    if (i != -1)
    {
      AppMethodBeat.o(245530);
      return i;
    }
    i = this.YtM.read();
    AppMethodBeat.o(245530);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(245533);
    if (paramArrayOfByte != null)
    {
      int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
      AppMethodBeat.o(245533);
      return i;
    }
    AppMethodBeat.o(245533);
    return 0;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(245536);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(245536);
      return 0;
    }
    int j = this.YtL.read(paramArrayOfByte, paramInt1, paramInt2);
    if (j == -1) {}
    for (;;)
    {
      if (i < paramInt2)
      {
        paramInt1 = this.YtM.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (paramInt1 == -1)
        {
          AppMethodBeat.o(245536);
          return -1;
        }
        AppMethodBeat.o(245536);
        return i + paramInt1;
      }
      AppMethodBeat.o(245536);
      return i;
      i = j;
    }
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(245551);
      this.YtL.reset();
      this.YtM.reset();
      AppMethodBeat.o(245551);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(245540);
    long l = this.YtL.skip(paramLong);
    if (l < paramLong)
    {
      paramLong = this.YtM.skip(paramLong - l);
      AppMethodBeat.o(245540);
      return l + paramLong;
    }
    AppMethodBeat.o(245540);
    return l;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/MultiInputStream$Companion;", "", "()V", "TAG", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */