package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
{
  public static byte[] aM(byte[] paramArrayOfByte)
  {
    Object localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
    Canvas localCanvas = new Canvas(paramArrayOfByte);
    localCanvas.drawColor(-1);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
    localObject = new ByteArrayOutputStream();
    paramArrayOfByte.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.e
 * JD-Core Version:    0.7.0.1
 */