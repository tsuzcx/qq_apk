package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

public class CameraParameter
{
  public static final int NEWCAMER_POSITION = 6;
  public static final int NEWLATLNG = 7;
  public static final int NEWLATLNG_BOUNDS = 9;
  public static final int NEWLATLNG_BOUNDS_DIMENSION = 10;
  public static final int NEWLATLNG_BOUNDS_WITH_MAP_CENTER = 11;
  public static final int NEWLATLNG_ZOOM = 8;
  public static final int SCROLLBY = 2;
  public static final int ZOOMBY = 4;
  public static final int ZOOMBY_POINT = 5;
  public static final int ZOOMIN = 0;
  public static final int ZOOMOUT = 1;
  public static final int ZOOMTO = 3;
  public int cameraUpdate_type = -1;
  public CameraPosition newCameraPosition = null;
  public LatLng newLatLng = null;
  public LatLngBounds newLatLngBounds_bounds = null;
  public LatLngBounds newLatLngBounds_dimension_bounds = null;
  public int newLatLngBounds_dimension_height = 0;
  public int newLatLngBounds_dimension_padding = 0;
  public int newLatLngBounds_dimension_width = 0;
  public int newLatLngBounds_padding = 0;
  public LatLng newLatLngZoom_latlng = null;
  public float newLatLngZoom_zoom = 0.0F;
  public float scrollBy_xPixel = 0.0F;
  public float scrollBy_yPixel = 0.0F;
  public float zoomBy_Point_amount = 0.0F;
  public Point zoomBy_Point_focus = null;
  public float zoomBy_amount = 0.0F;
  public float zoomTo_zoom = 0.0F;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.CameraParameter
 * JD-Core Version:    0.7.0.1
 */