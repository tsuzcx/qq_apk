package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GeometryConstants
{
  public static final Rect BOUNDARY_WORLD;
  public static final double LATITUDE_SPAN = 180.0D;
  public static final double LONGITUDE_SPAN = 360.0D;
  public static final double MAX_LATITUDE = 90.0D;
  public static final double MAX_LONGITUDE = 1.7976931348623157E+308D;
  public static final double MAX_MERCATOR_LATITUDE = 85.051128779806589D;
  public static final double MAX_WRAP_LONGITUDE = 180.0D;
  public static final double MIN_LATITUDE = -90.0D;
  public static final double MIN_LONGITUDE = -1.797693134862316E+308D;
  public static final double MIN_MERCATOR_LATITUDE = -85.051128779806589D;
  public static final double MIN_WRAP_LONGITUDE = -180.0D;
  public static final int RADIUS_EARTH_METERS = 6378137;
  public static final int WORLD_EAST = 180000000;
  public static final int WORLD_NORTH = 85000000;
  public static final int WORLD_SOUTH = -85000000;
  public static final int WORLD_WEST = -180000000;
  
  static
  {
    AppMethodBeat.i(181060);
    BOUNDARY_WORLD = new Rect(-180000000, -85000000, 180000000, 85000000);
    AppMethodBeat.o(181060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants
 * JD-Core Version:    0.7.0.1
 */