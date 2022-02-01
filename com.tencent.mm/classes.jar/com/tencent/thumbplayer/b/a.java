package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a
{
  public static Bitmap k(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189086);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    localBitmap.copyPixelsFromBuffer(paramArrayOfByte);
    paramArrayOfByte = localBitmap;
    if (paramInt3 != 0)
    {
      paramArrayOfByte = new Matrix();
      paramArrayOfByte.postRotate(paramInt3);
      paramArrayOfByte = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramArrayOfByte, true);
    }
    AppMethodBeat.o(189086);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.b.a
 * JD-Core Version:    0.7.0.1
 */