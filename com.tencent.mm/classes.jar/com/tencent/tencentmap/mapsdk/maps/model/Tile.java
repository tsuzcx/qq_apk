package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class Tile
{
  public static Tile EMPTY_TILE;
  public final byte[] mData;
  public final int mHeight;
  public final int mWidth;
  
  static
  {
    AppMethodBeat.i(181089);
    EMPTY_TILE = new Tile(-1, -1, getNoTileData());
    AppMethodBeat.o(181089);
  }
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mData = paramArrayOfByte;
  }
  
  private static byte[] getNoTileData()
  {
    AppMethodBeat.i(181088);
    Object localObject = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
    new Canvas((Bitmap)localObject).drawARGB(0, 255, 255, 255);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    localObject = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(181088);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Tile
 * JD-Core Version:    0.7.0.1
 */