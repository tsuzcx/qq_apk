package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class Util
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(228301);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(228301);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(228301);
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(228290);
    byte[] arrayOfByte = new byte[4096];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(228290);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Util
 * JD-Core Version:    0.7.0.1
 */