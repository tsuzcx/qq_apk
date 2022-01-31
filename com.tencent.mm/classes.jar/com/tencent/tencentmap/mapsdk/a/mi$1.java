package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

class mi$1
  implements Runnable
{
  mi$1(mi parammi, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void run()
  {
    if (!mi.a(this.d, this.a)) {}
    Object localObject;
    Bitmap localBitmap;
    do
    {
      return;
      localObject = new om();
      ((om)localObject).a(this.b);
      localObject = new oi(((om)localObject).a(), ((om)localObject).b(), ((om)localObject).c(), 1);
      localBitmap = BitmapFactory.decodeByteArray(this.c, 0, this.c.length);
    } while (localBitmap == null);
    mi.a(this.d).a(li.a(localBitmap, Bitmap.CompressFormat.PNG), (oi)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mi.1
 * JD-Core Version:    0.7.0.1
 */