package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface BitmapFormatType
    {
      public static final int FORMAT_ASSET = 2;
      public static final int FORMAT_BITMAP = 7;
      public static final int FORMAT_DEFAULT = 5;
      public static final int FORMAT_DEFAULT_F = 6;
      public static final int FORMAT_FILE = 3;
      public static final int FORMAT_FONT_TEXT = 9;
      public static final int FORMAT_NONE = -1;
      public static final int FORMAT_PATH = 4;
      public static final int FORMAT_RESOURCE = 1;
      public static final int FORMAT_URL = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */