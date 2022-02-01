package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

public abstract interface TencentMapResource
{
  public abstract BitmapDescriptor createBitmapDescriptor(float paramFloat, int paramInt);
  
  public abstract BitmapDescriptor createBitmapDescriptor(int paramInt);
  
  public abstract BitmapDescriptor createBitmapDescriptor(int paramInt1, int paramInt2);
  
  public abstract BitmapDescriptor createBitmapDescriptor(Bitmap paramBitmap, int paramInt);
  
  public abstract BitmapDescriptor createBitmapDescriptor(String paramString, int paramInt);
  
  public abstract MyLocationStyle getDefaultMyLocationStyle();
  
  public abstract int getScreenPixels();
  
  public abstract Typeface getTypeface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapResource
 * JD-Core Version:    0.7.0.1
 */