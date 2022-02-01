package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BubbleOptions
{
  private Drawable[] mBackground = null;
  private String mContent;
  private View mContentView;
  private int mDisplayLevel = 0;
  private Marker mMarker;
  private float mMarkerAnchorU = 0.5F;
  private float mMarkerAnchorV = 0.5F;
  private int mMarkerHeight = 0;
  private int mMarkerWidth = 0;
  private boolean mOnTapHidden = false;
  private LatLng mPosition;
  
  public BubbleOptions background(Bitmap[] paramArrayOfBitmap)
  {
    AppMethodBeat.i(173098);
    if (paramArrayOfBitmap != null)
    {
      this.mBackground = new Drawable[4];
      int i = 0;
      int j = paramArrayOfBitmap.length;
      while (i < j)
      {
        this.mBackground[i] = new BitmapDrawable(paramArrayOfBitmap[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(173098);
    return this;
  }
  
  public BubbleOptions background(Drawable[] paramArrayOfDrawable)
  {
    this.mBackground = paramArrayOfDrawable;
    return this;
  }
  
  public BubbleOptions content(String paramString)
  {
    this.mContent = paramString;
    return this;
  }
  
  public BubbleOptions contentView(View paramView)
  {
    this.mContentView = paramView;
    return this;
  }
  
  public BubbleOptions displayLevel(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mDisplayLevel = i;
    return this;
  }
  
  public Drawable[] getBackground()
  {
    return this.mBackground;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public View getContentView()
  {
    return this.mContentView;
  }
  
  public int getDisplayLevel()
  {
    return this.mDisplayLevel;
  }
  
  public Marker getMarker()
  {
    return this.mMarker;
  }
  
  public float getMarkerAnchorU()
  {
    return this.mMarkerAnchorU;
  }
  
  public float getMarkerAnchorV()
  {
    return this.mMarkerAnchorV;
  }
  
  public int getMarkerHeight()
  {
    return this.mMarkerHeight;
  }
  
  public int getMarkerWidth()
  {
    return this.mMarkerWidth;
  }
  
  public boolean getOnTapHidden()
  {
    return this.mOnTapHidden;
  }
  
  public LatLng getPosition()
  {
    return this.mPosition;
  }
  
  public BubbleOptions marker(Marker paramMarker)
  {
    AppMethodBeat.i(173097);
    this.mMarker = paramMarker;
    position(paramMarker.getPosition());
    markerAnchor(paramMarker.getAnchorU(), paramMarker.getAnchorV());
    AppMethodBeat.o(173097);
    return this;
  }
  
  public BubbleOptions markerAnchor(float paramFloat1, float paramFloat2)
  {
    this.mMarkerAnchorU = paramFloat1;
    this.mMarkerAnchorV = paramFloat2;
    return this;
  }
  
  public BubbleOptions markerSize(int paramInt1, int paramInt2)
  {
    this.mMarkerWidth = paramInt1;
    this.mMarkerHeight = paramInt2;
    return this;
  }
  
  public BubbleOptions position(LatLng paramLatLng)
  {
    this.mPosition = paramLatLng;
    return this;
  }
  
  public BubbleOptions setOnTapHidden(boolean paramBoolean)
  {
    this.mOnTapHidden = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BubbleOptions
 * JD-Core Version:    0.7.0.1
 */