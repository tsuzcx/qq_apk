package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Point;
import java.util.List;

public final class CamerParameter
{
  public static int NEWCAMER_POSITION;
  public static int NEWLATLNG;
  public static int NEWLATLNG_BOUNDS;
  public static int NEWLATLNG_BOUNDS_DIMENSION;
  public static int NEWLATLNG_BOUNDS_RECT;
  public static int NEWLATLNG_ZOOM;
  public static int NEW_ELEMENTS_BOUNDS_RECT = 13;
  public static int ROTATETO;
  public static int SCROLLBY;
  public static int ZOOMBY;
  public static int ZOOMBY_POINT;
  public static int ZOOMIN = 0;
  public static int ZOOMOUT = 1;
  public static int ZOOMTO;
  public List<IOverlay> elements;
  public int iCamerType = -1;
  public CameraPosition newCameraPosition_cameraPosition = null;
  public int newLatLngBoundsRects_padBom = 0;
  public int newLatLngBoundsRects_padLeft = 0;
  public int newLatLngBoundsRects_padRight = 0;
  public int newLatLngBoundsRects_padTop = 0;
  public LatLngBounds newLatLngBounds_bounds = null;
  public LatLngBounds newLatLngBounds_dimension_bounds = null;
  public int newLatLngBounds_dimension_height = 0;
  public int newLatLngBounds_dimension_padding = 0;
  public int newLatLngBounds_dimension_width = 0;
  public int newLatLngBounds_padding = 0;
  public LatLng newLatLngZoom_latLng = null;
  public float newLatLngZoom_zoom = 0.0F;
  public LatLng newLatLng_latLng = null;
  public float rotateto_rotate = 0.0F;
  public float rotateto_skew = 0.0F;
  public float scrollBy_xPixel = 0.0F;
  public float scrollBy_yPixel = 0.0F;
  public float zoomBy_Point_amount = 0.0F;
  public Point zoomBy_Point_focus = null;
  public float zoomBy_amount = 0.0F;
  public float zoomTo_zoom = 0.0F;
  
  static
  {
    SCROLLBY = 2;
    ZOOMTO = 3;
    ZOOMBY = 4;
    ZOOMBY_POINT = 5;
    NEWCAMER_POSITION = 6;
    NEWLATLNG = 7;
    NEWLATLNG_ZOOM = 8;
    NEWLATLNG_BOUNDS = 9;
    NEWLATLNG_BOUNDS_DIMENSION = 10;
    NEWLATLNG_BOUNDS_RECT = 11;
    ROTATETO = 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CamerParameter
 * JD-Core Version:    0.7.0.1
 */