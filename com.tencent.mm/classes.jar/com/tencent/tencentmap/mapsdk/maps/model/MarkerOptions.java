package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MarkerOptions
{
  private boolean bFlat = false;
  private BitmapDescriptor bitmapDesctor;
  private boolean boDragable;
  private boolean boInfoWindowEnable = true;
  private boolean boVisible = true;
  private String contentDescription;
  private float fAlpha = 1.0F;
  private float fAngle = 0.0F;
  private float fanchorU = 0.5F;
  private float fanchorV = 0.5F;
  private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
  private boolean mClockwise = true;
  private IndoorInfo mIndoorInfo;
  private float mInfowindowAnchorU = 0.5F;
  private float mInfowindowAnchorV = 1.0F;
  private int mInfowindowOffsetX = 0;
  private int mInfowindowOffsetY = 0;
  private boolean mIsFastLoad = true;
  private boolean mIsViewInfowindow = false;
  private Object mTag;
  private LatLng mlatlng;
  private String strSnippet;
  private String strtitle = "";
  private float zIndex = 0.0F;
  
  @Deprecated
  public MarkerOptions() {}
  
  public MarkerOptions(LatLng paramLatLng)
  {
    this.mlatlng = paramLatLng;
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.fAlpha = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.fanchorU = paramFloat1;
    this.fanchorV = paramFloat2;
    return this;
  }
  
  public MarkerOptions clockwise(boolean paramBoolean)
  {
    this.mClockwise = paramBoolean;
    return this;
  }
  
  public MarkerOptions contentDescription(String paramString)
  {
    this.contentDescription = paramString;
    return this;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.boDragable = paramBoolean;
    return this;
  }
  
  public MarkerOptions fastLoad(boolean paramBoolean)
  {
    this.mIsFastLoad = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.bFlat = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.fAlpha;
  }
  
  public float getAnchorU()
  {
    return this.fanchorU;
  }
  
  public float getAnchorV()
  {
    return this.fanchorV;
  }
  
  public String getContentDescription()
  {
    return this.contentDescription;
  }
  
  public BitmapDescriptor getIcon()
  {
    AppMethodBeat.i(173263);
    BitmapDescriptor localBitmapDescriptor = this.bitmapDesctor;
    AppMethodBeat.o(173263);
    return localBitmapDescriptor;
  }
  
  public IndoorInfo getIndoorInfo()
  {
    return this.mIndoorInfo;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.mInfowindowAnchorU;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.mInfowindowAnchorV;
  }
  
  public int getInfoWindowOffsetX()
  {
    return this.mInfowindowOffsetX;
  }
  
  public int getInfowindowOffsetY()
  {
    return this.mInfowindowOffsetY;
  }
  
  public int getLevel()
  {
    return this.iLevel;
  }
  
  public LatLng getPosition()
  {
    return this.mlatlng;
  }
  
  public float getRotation()
  {
    return this.fAngle;
  }
  
  public String getSnippet()
  {
    return this.strSnippet;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public String getTitle()
  {
    return this.strtitle;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.bitmapDesctor = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions indoorInfo(IndoorInfo paramIndoorInfo)
  {
    this.mIndoorInfo = paramIndoorInfo;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.mInfowindowAnchorU = paramFloat1;
    this.mInfowindowAnchorV = paramFloat2;
    return this;
  }
  
  public MarkerOptions infoWindowEnable(boolean paramBoolean)
  {
    this.boInfoWindowEnable = paramBoolean;
    return this;
  }
  
  public MarkerOptions infoWindowOffset(int paramInt1, int paramInt2)
  {
    this.mInfowindowOffsetX = paramInt1;
    this.mInfowindowOffsetY = paramInt2;
    return this;
  }
  
  public boolean isAvoidAnnocation()
  {
    return false;
  }
  
  public boolean isClockwise()
  {
    return this.mClockwise;
  }
  
  public boolean isDraggable()
  {
    return this.boDragable;
  }
  
  public boolean isFastLoad()
  {
    return this.mIsFastLoad;
  }
  
  public boolean isFlat()
  {
    return this.bFlat;
  }
  
  public boolean isInfoWindowEnable()
  {
    return this.boInfoWindowEnable;
  }
  
  public boolean isViewInfowindow()
  {
    return this.mIsViewInfowindow;
  }
  
  public boolean isVisible()
  {
    return this.boVisible;
  }
  
  public MarkerOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.mlatlng = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.fAngle = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.strSnippet = paramString;
    return this;
  }
  
  public MarkerOptions tag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.strtitle = paramString;
    return this;
  }
  
  public MarkerOptions viewInfoWindow(boolean paramBoolean)
  {
    this.mIsViewInfowindow = paramBoolean;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.boVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(173264);
    if (paramParcel == null)
    {
      AppMethodBeat.o(173264);
      return;
    }
    if (this.mlatlng != null) {
      paramParcel.writeString(this.mlatlng.toString());
    }
    AppMethodBeat.o(173264);
  }
  
  public MarkerOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions
 * JD-Core Version:    0.7.0.1
 */