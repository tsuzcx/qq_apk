package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import com.google.android.gms.c;

public final class zzak
  extends Button
{
  public zzak(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public zzak(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }
  
  private static int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException(33 + "Unknown color scheme: " + paramInt1);
    case 1: 
      paramInt2 = paramInt3;
    case 0: 
      return paramInt2;
    }
    return paramInt4;
  }
  
  public final void a(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = paramResources.getDisplayMetrics().density;
    setMinHeight((int)(f * 48.0F + 0.5F));
    setMinWidth((int)(f * 48.0F + 0.5F));
    int i = c.HH;
    int j = c.HI;
    j = d(paramInt2, i, j, j);
    i = c.HD;
    int k = c.HE;
    i = d(paramInt2, i, k, k);
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException(32 + "Unknown button size: " + paramInt1);
    case 2: 
      i = j;
    }
    Drawable localDrawable = a.a(paramResources.getDrawable(i));
    Object localObject = paramResources.getColorStateList(com.google.android.gms.b.HF);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localDrawable.setTintList((ColorStateList)localObject);
      label188:
      localObject = PorterDuff.Mode.SRC_ATOP;
      if (Build.VERSION.SDK_INT < 21) {
        break label328;
      }
      localDrawable.setTintMode((PorterDuff.Mode)localObject);
    }
    for (;;)
    {
      setBackgroundDrawable(localDrawable);
      i = com.google.android.gms.b.HD;
      j = com.google.android.gms.b.HE;
      setTextColor((ColorStateList)d.D(paramResources.getColorStateList(d(paramInt2, i, j, j))));
      switch (paramInt1)
      {
      default: 
        throw new IllegalStateException(32 + "Unknown button size: " + paramInt1);
        if (!(localDrawable instanceof android.support.v4.a.a.b)) {
          break label188;
        }
        ((android.support.v4.a.a.b)localDrawable).setTintList((ColorStateList)localObject);
        break label188;
        label328:
        if ((localDrawable instanceof android.support.v4.a.a.b)) {
          ((android.support.v4.a.a.b)localDrawable).setTintMode((PorterDuff.Mode)localObject);
        }
        break;
      }
    }
    setText(paramResources.getString(com.google.android.gms.d.HY));
    for (;;)
    {
      setTransformationMethod(null);
      return;
      setText(paramResources.getString(com.google.android.gms.d.HZ));
      continue;
      setText(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzak
 * JD-Core Version:    0.7.0.1
 */