package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;

public class MarkerOptions
{
  private boolean bFlat;
  private BitmapDescriptor bitmapDesctor;
  private boolean boDragable;
  private boolean boInfoWindowEnable;
  private boolean boVisible;
  private String contentDescription;
  private float fAlpha;
  private float fAngle;
  private float fanchorU;
  private float fanchorV;
  private int iLevel;
  private boolean mClockwise;
  private Collision[] mCollisions;
  private int mIconLooperDuration;
  private boolean mIconLooperEnable;
  private IndoorInfo mIndoorInfo;
  private float mInfowindowAnchorU;
  private float mInfowindowAnchorV;
  private int mInfowindowOffsetX;
  private int mInfowindowOffsetY;
  private boolean mIsFastLoad;
  private boolean mIsViewInfowindow;
  private Object mTag;
  private LatLng mlatlng;
  private String strSnippet;
  private String strtitle;
  private float zIndex;
  
  @Deprecated
  public MarkerOptions()
  {
    AppMethodBeat.i(218008);
    this.strtitle = "";
    this.fAngle = 0.0F;
    this.fAlpha = 1.0F;
    this.zIndex = 0.0F;
    this.boInfoWindowEnable = true;
    this.bFlat = false;
    this.mClockwise = true;
    this.mInfowindowAnchorU = 0.5F;
    this.mInfowindowAnchorV = 1.0F;
    this.mInfowindowOffsetX = 0;
    this.mInfowindowOffsetY = 0;
    this.mIsFastLoad = true;
    this.mIsViewInfowindow = false;
    this.iLevel = 2;
    this.mIconLooperDuration = 500;
    this.mCollisions = new Collision[0];
    this.fanchorU = 0.5F;
    this.fanchorV = 0.5F;
    this.boVisible = true;
    AppMethodBeat.o(218008);
  }
  
  public MarkerOptions(LatLng paramLatLng)
  {
    AppMethodBeat.i(218005);
    this.strtitle = "";
    this.fAngle = 0.0F;
    this.fAlpha = 1.0F;
    this.zIndex = 0.0F;
    this.boInfoWindowEnable = true;
    this.bFlat = false;
    this.mClockwise = true;
    this.mInfowindowAnchorU = 0.5F;
    this.mInfowindowAnchorV = 1.0F;
    this.mInfowindowOffsetX = 0;
    this.mInfowindowOffsetY = 0;
    this.mIsFastLoad = true;
    this.mIsViewInfowindow = false;
    this.iLevel = 2;
    this.mIconLooperDuration = 500;
    this.mCollisions = new Collision[0];
    this.fanchorU = 0.5F;
    this.fanchorV = 0.5F;
    this.boVisible = true;
    this.mlatlng = paramLatLng;
    AppMethodBeat.o(218005);
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
  
  public MarkerOptions collisionBy(MarkerCollisionItem... paramVarArgs)
  {
    this.mCollisions = paramVarArgs;
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
  
  public Collision[] getCollisions()
  {
    return this.mCollisions;
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
  
  public int getIconLooperDuration()
  {
    return this.mIconLooperDuration;
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
  
  public MarkerOptions iconLooper(boolean paramBoolean)
  {
    this.mIconLooperEnable = paramBoolean;
    return this;
  }
  
  public MarkerOptions iconLooper(boolean paramBoolean, int paramInt)
  {
    this.mIconLooperEnable = paramBoolean;
    this.mIconLooperDuration = paramInt;
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
  
  public boolean isIconLooperEnable()
  {
    return this.mIconLooperEnable;
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
    if ((paramInt < 0) || (paramInt > 2)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions
 * JD-Core Version:    0.7.0.1
 */