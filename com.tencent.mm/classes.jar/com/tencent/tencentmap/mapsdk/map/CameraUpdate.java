package com.tencent.tencentmap.mapsdk.map;

public class CameraUpdate
{
  private final CameraParameter camerPara;
  
  CameraUpdate(CameraParameter paramCameraParameter)
  {
    this.camerPara = paramCameraParameter;
  }
  
  public CameraParameter getParams()
  {
    return this.camerPara;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.CameraUpdate
 * JD-Core Version:    0.7.0.1
 */