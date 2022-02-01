package com.tencent.tencentmap.mapsdk.maps.model;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.PARAMETER})
public @interface OverlayLevel
{
  public static final int OverlayLevelAboveBuildings = 1;
  public static final int OverlayLevelAboveLabels = 2;
  public static final int OverlayLevelAboveRoads = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel
 * JD-Core Version:    0.7.0.1
 */