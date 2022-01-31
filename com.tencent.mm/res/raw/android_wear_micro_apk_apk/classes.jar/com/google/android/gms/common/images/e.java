package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public abstract class e
{
  final f IQ;
  protected int IR;
  
  final void a(Context paramContext, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("null reference");
    }
    new BitmapDrawable(paramContext.getResources(), paramBitmap);
    gT();
  }
  
  final void f(Context paramContext)
  {
    if (this.IR != 0)
    {
      int i = this.IR;
      paramContext.getResources().getDrawable(i);
    }
    gT();
  }
  
  protected abstract void gT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.e
 * JD-Core Version:    0.7.0.1
 */