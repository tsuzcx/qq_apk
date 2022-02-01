package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface TrafficEvent
{
  public abstract String getDescription();
  
  public abstract int getEndTime();
  
  public abstract String getMessage();
  
  public abstract String getRoadName();
  
  public abstract String getSource();
  
  public abstract int getStartTime();
  
  public abstract String getType();
  
  public abstract int getUpdateTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
 * JD-Core Version:    0.7.0.1
 */