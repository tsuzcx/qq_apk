package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BitmapDescriptor
{
  private BitmapFormator bitmapFormator = null;
  
  public BitmapDescriptor(BitmapFormator paramBitmapFormator)
  {
    this.bitmapFormator = paramBitmapFormator;
  }
  
  public final Bitmap getBitmap(Context paramContext)
  {
    AppMethodBeat.i(173082);
    if (this.bitmapFormator == null)
    {
      AppMethodBeat.o(173082);
      return null;
    }
    paramContext = this.bitmapFormator.getBitmap(paramContext);
    AppMethodBeat.o(173082);
    return paramContext;
  }
  
  public final BitmapFormator getFormater()
  {
    return this.bitmapFormator;
  }
  
  public static abstract interface BitmapFormator
  {
    public abstract Bitmap getBitmap(Context paramContext);
    
    public abstract String getBitmapId();
    
    public abstract int getFormateType();
    
    public abstract void setScale(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */