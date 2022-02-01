package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PolygonOptions
{
  private static final int COLOR_DEFAULT_POLYGON;
  private boolean boIsVisble;
  private float fStrokeWidth;
  private int iFillColor;
  private int iLevel;
  private int iStrokeColor;
  private int iZindex;
  private final List<LatLng> listPts;
  private boolean mClickable;
  private List<Integer> pattern;
  private BitmapDescriptor texture;
  private int textureSpacing;
  
  static
  {
    AppMethodBeat.i(181085);
    COLOR_DEFAULT_POLYGON = Color.argb(200, 0, 163, 255);
    AppMethodBeat.o(181085);
  }
  
  public PolygonOptions()
  {
    AppMethodBeat.i(173295);
    this.iLevel = OverlayLevel.OverlayLevelAboveLabels;
    this.fStrokeWidth = 1.0F;
    this.iStrokeColor = -16777216;
    this.iFillColor = COLOR_DEFAULT_POLYGON;
    this.iZindex = 0;
    this.boIsVisble = true;
    this.listPts = new ArrayList();
    AppMethodBeat.o(173295);
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
  
  public List<Integer> getPattern()
  {
    return this.pattern;
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
  
  public BitmapDescriptor getTexture()
  {
    return this.texture;
  }
  
  public int getTextureSpacing()
  {
    return this.textureSpacing;
  }
  
  public float getZIndex()
  {
    return this.iZindex;
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public boolean isValid()
  {
    AppMethodBeat.i(193615);
    if ((this.listPts != null) && (this.listPts.size() > 2))
    {
      AppMethodBeat.o(193615);
      return true;
    }
    AppMethodBeat.o(193615);
    return false;
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
  
  public PolygonOptions pattern(List<Integer> paramList)
  {
    this.pattern = paramList;
    this.texture = null;
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
    this.texture = null;
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
  
  public PolygonOptions texture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.texture = paramBitmapDescriptor;
    return this;
  }
  
  public PolygonOptions textureSpacing(int paramInt)
  {
    this.textureSpacing = paramInt;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.boIsVisble = paramBoolean;
    return this;
  }
  
  public PolygonOptions zIndex(int paramInt)
  {
    this.iZindex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */