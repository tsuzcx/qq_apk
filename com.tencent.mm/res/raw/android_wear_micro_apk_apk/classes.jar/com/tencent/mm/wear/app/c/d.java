package com.tencent.mm.wear.app.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public final class d
  extends BitmapDrawable
{
  private d(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static void a(Resources paramResources, Bitmap paramBitmap, ImageView paramImageView)
  {
    paramImageView.setImageDrawable(new d(paramResources, paramBitmap));
    paramImageView.invalidate();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((getBitmap() != null) && (!getBitmap().isRecycled()))
    {
      com.tencent.mm.wear.a.c.d.e("MicroMsg.MMImageLoader", "draw canvas", new Object[0]);
      super.draw(paramCanvas);
      return;
    }
    com.tencent.mm.wear.a.c.d.e("MicroMsg.MMImageLoader", "draw canvas null", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.d
 * JD-Core Version:    0.7.0.1
 */