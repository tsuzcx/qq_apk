package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

public class TextureMapView
  extends MapView
{
  public TextureMapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramAttributeSet, paramInt, paramTencentMapOptions);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet, TencentMapOptions paramTencentMapOptions)
  {
    this(paramContext, paramAttributeSet, 0, paramTencentMapOptions);
  }
  
  public TextureMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
  }
  
  protected final MapViewType getViewType()
  {
    return MapViewType.TextureView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TextureMapView
 * JD-Core Version:    0.7.0.1
 */