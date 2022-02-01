package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.List;

public abstract interface MarkerGroup
{
  public abstract void addMarker(Marker paramMarker);
  
  public abstract void addMarkerById(String paramString);
  
  public abstract void addMarkerList(List<Marker> paramList);
  
  public abstract void clear();
  
  public abstract boolean containMarker(Marker paramMarker);
  
  public abstract boolean containMarkerById(String paramString);
  
  public abstract Marker findMarkerById(String paramString);
  
  public abstract String getId();
  
  public abstract List<String> getMarkerIdList();
  
  public abstract List<Marker> getMarkerList();
  
  public abstract boolean removeMarker(Marker paramMarker);
  
  public abstract boolean removeMarkerById(String paramString);
  
  public abstract void setMarkerGroupOnTapMapBubblesHidden(boolean paramBoolean);
  
  public abstract void setMarkerGroupOnTapMapInfoWindowHidden(boolean paramBoolean);
  
  public abstract boolean setMarkerOnTapMapBubblesHidden(Marker paramMarker, boolean paramBoolean);
  
  public abstract boolean setOnTapMapBubblesHiddenById(String paramString, boolean paramBoolean);
  
  public abstract boolean updateMarkerOptionById(String paramString, MarkerOptions paramMarkerOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerGroup
 * JD-Core Version:    0.7.0.1
 */