package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public abstract class e
{
  final f KF;
  protected int KG;
  
  final void a(Context paramContext, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("null reference");
    }
    new BitmapDrawable(paramContext.getResources(), paramBitmap);
    hd();
  }
  
  final void g(Context paramContext)
  {
    if (this.KG != 0)
    {
      int i = this.KG;
      paramContext.getResources().getDrawable(i);
    }
    hd();
  }
  
  protected abstract void hd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.e
 * JD-Core Version:    0.7.0.1
 */