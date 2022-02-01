package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PolygonOptions
{
  private static final int COLOR_DEFAULT_POLYGON;
  private boolean boIsGeoDes;
  private boolean boIsVisble;
  private float fStrokeWidth;
  private int iFillColor;
  private int iLevel;
  private int iStrokeColor;
  private int iZindex;
  private final List<LatLng> listPts;
  private boolean mClickable;
  private int mMaxTextSize;
  private int mMinTextSize;
  private String mText;
  private int mTextColor;
  private int mTextSize;
  private Typeface mTypeface;
  
  static
  {
    AppMethodBeat.i(181085);
    COLOR_DEFAULT_POLYGON = Color.argb(200, 0, 163, 255);
    AppMethodBeat.o(181085);
  }
  
  public PolygonOptions()
  {
    AppMethodBeat.i(173295);
    this.mText = "";
    this.mTextColor = -16777216;
    this.mTypeface = Typeface.DEFAULT;
    this.mMaxTextSize = 2147483647;
    this.mMinTextSize = 1;
    this.mTextSize = -1;
    this.iLevel = OverlayLevel.OverlayLevelAboveLabels;
    this.fStrokeWidth = 1.0F;
    this.iStrokeColor = -16777216;
    this.iFillColor = COLOR_DEFAULT_POLYGON;
    this.iZindex = 0;
    this.boIsVisble = true;
    this.boIsGeoDes = false;
    this.listPts = new ArrayList();
    AppMethodBeat.o(173295);
  }
  
  private PolygonOptions geodesic(boolean paramBoolean)
  {
    this.boIsGeoDes = paramBoolean;
    return this;
  }
  
  private int getTextSize()
  {
    return this.mTextSize;
  }
  
  private boolean isGeodesic()
  {
    return this.boIsGeoDes;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    AppMethodBeat.i(173297);
    if (paramLatLng != null) {
      this.listPts.add(paramLatLng);
    }
    AppMethodBeat.o(173297);
    return this;
  }
  
  public PolygonOptions add(List<LatLng> paramList)
  {
    AppMethodBeat.i(173299);
    if (paramList != null) {
      this.listPts.addAll(paramList);
    }
    AppMethodBeat.o(173299);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    AppMethodBeat.i(173298);
    if (paramVarArgs != null) {
      this.listPts.addAll(Arrays.asList(paramVarArgs));
    }
    AppMethodBeat.o(173298);
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(173300);
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        LatLng localLatLng = (LatLng)paramIterable.next();
        this.listPts.add(localLatLng);
      }
    }
    AppMethodBeat.o(173300);
    return this;
  }
  
  public PolygonOptions clickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
    return this;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.iFillColor = paramInt;
    return this;
  }
  
  public int getFillColor()
  {
    return this.iFillColor;
  }
  
  public int getLevel()
  {
    return this.iLevel;
  }
  
  int getMaxTextSize()
  {
    return this.mMaxTextSize;
  }
  
  int getMinTextSize()
  {
    return this.mMinTextSize;
  }
  
  public List<LatLng> getPoints()
  {
    return this.listPts;
  }
  
  public int getStrokeColor()
  {
    return this.iStrokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this.fStrokeWidth;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  int getTextColor()
  {
    return this.mTextColor;
  }
  
  Typeface getTypeface()
  {
    return this.mTypeface;
  }
  
  public float getZIndex()
  {
    return this.iZindex;
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public boolean isVisible()
  {
    return this.boIsVisble;
  }
  
  public PolygonOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  PolygonOptions maxTextSize(int paramInt)
  {
    this.mMaxTextSize = paramInt;
    return this;
  }
  
  PolygonOptions minTextSize(int paramInt)
  {
    this.mMinTextSize = paramInt;
    return this;
  }
  
  public void setPoints(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(173296);
    this.listPts.clear();
    if (paramIterable == null)
    {
      AppMethodBeat.o(173296);
      return;
    }
    addAll(paramIterable);
    AppMethodBeat.o(173296);
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.iStrokeColor = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.fStrokeWidth = 1.0F;
      return this;
    }
    this.fStrokeWidth = paramFloat;
    return this;
  }
  
  PolygonOptions text(String paramString)
  {
    this.mText = paramString;
    return this;
  }
  
  PolygonOptions textColor(int paramInt)
  {
    this.mTextColor = paramInt;
    return this;
  }
  
  PolygonOptions textSize(int paramInt)
  {
    this.mTextSize = paramInt;
    return this;
  }
  
  PolygonOptions textTypeface(Typeface paramTypeface)
  {
    this.mTypeface = paramTypeface;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.boIsVisble = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(173301);
    if (paramParcel == null)
    {
      AppMethodBeat.o(173301);
      return;
    }
    paramParcel.writeInt(this.iFillColor);
    AppMethodBeat.o(173301);
  }
  
  public PolygonOptions zIndex(int paramInt)
  {
    this.iZindex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */