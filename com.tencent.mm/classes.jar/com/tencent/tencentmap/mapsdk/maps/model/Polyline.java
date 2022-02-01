package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import java.util.List;

public abstract interface Polyline
  extends Animationable, Clickable, Levelable, Removable, Tagable<Object>, Visible, IOverlay
{
  @Deprecated
  public static final int DARK_BLUE = 6;
  @Deprecated
  public static final int DASHED = 33;
  @Deprecated
  public static final int GREEN = 4;
  @Deprecated
  public static final int GREY = 0;
  @Deprecated
  public static final int LIGHT_BLUE = 1;
  @Deprecated
  public static final int RED = 2;
  @Deprecated
  public static final int WHITE_BLUE = 19;
  @Deprecated
  public static final int YELLOW = 3;
  
  public abstract void addTurnArrow(int paramInt1, int paramInt2);
  
  public abstract void appendPoint(LatLng... paramVarArgs);
  
  public abstract void appendPoints(List<LatLng> paramList);
  
  public abstract void cleanTurnArrow();
  
  public abstract void eraseTo(int paramInt, LatLng paramLatLng);
  
  public abstract int getColor();
  
  public abstract int[][] getColors();
  
  public abstract List<Integer> getPattern();
  
  public abstract List<LatLng> getPoints();
  
  public abstract PolylineOptions getPolylineOptions();
  
  public abstract PolylineOptions.Text getText();
  
  public abstract Rect getVisibleRect();
  
  public abstract float getWidth();
  
  public abstract boolean isAboveMaskLayer();
  
  public abstract boolean isGradientEnable();
  
  public abstract void pattern(List<Integer> paramList);
  
  public abstract void setAboveMaskLayer(boolean paramBoolean);
  
  public abstract void setArrow(boolean paramBoolean);
  
  public abstract void setColor(int paramInt);
  
  public abstract void setColorTexture(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setColorTexture(String paramString);
  
  public abstract void setColors(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public abstract void setEraseable(boolean paramBoolean);
  
  public abstract void setGradientEnable(boolean paramBoolean);
  
  public abstract void setPoints(List<LatLng> paramList);
  
  public abstract void setPolylineOptions(PolylineOptions paramPolylineOptions);
  
  public abstract void setText(PolylineOptions.Text paramText);
  
  public abstract void setWidth(float paramFloat);
  
  public abstract void startAnimation(Animation paramAnimation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Polyline
 * JD-Core Version:    0.7.0.1
 */