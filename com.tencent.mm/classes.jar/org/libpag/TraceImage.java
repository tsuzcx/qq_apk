package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class TraceImage
{
  public static void Trace(String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187474);
    paramString = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramString.copyPixelsFromBuffer(paramByteBuffer);
    new StringBuilder("Image(width = ").append(paramString.getWidth()).append(", height = ").append(paramString.getHeight()).append(")");
    AppMethodBeat.o(187474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.libpag.TraceImage
 * JD-Core Version:    0.7.0.1
 */