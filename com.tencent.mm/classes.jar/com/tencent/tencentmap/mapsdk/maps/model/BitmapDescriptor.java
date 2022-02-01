package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BitmapDescriptor
{
  private final BitmapFormator bitmapFormator;
  
  public BitmapDescriptor(BitmapFormator paramBitmapFormator)
  {
    this.bitmapFormator = paramBitmapFormator;
  }
  
  public final String getBDId()
  {
    AppMethodBeat.i(217996);
    String str = this.bitmapFormator.getBitmapId();
    AppMethodBeat.o(217996);
    return str;
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
  
  public final int getHeight()
  {
    AppMethodBeat.i(218006);
    if (this.bitmapFormator == null)
    {
      AppMethodBeat.o(218006);
      return 0;
    }
    int i = this.bitmapFormator.getHeight();
    AppMethodBeat.o(218006);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(218003);
    if (this.bitmapFormator == null)
    {
      AppMethodBeat.o(218003);
      return 0;
    }
    int i = this.bitmapFormator.getWidth();
    AppMethodBeat.o(218003);
    return i;
  }
  
  public static abstract interface BitmapFormator
  {
    public abstract int activeSize();
    
    public abstract Bitmap getBitmap(Context paramContext);
    
    public abstract String getBitmapId();
    
    public abstract int getFormateType();
    
    public abstract int getHeight();
    
    public abstract int getWidth();
    
    public abstract int nextActiveIndex();
    
    public abstract void recycle();
    
    public abstract void setScale(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */