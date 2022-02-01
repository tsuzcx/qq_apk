package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;

public final class CameraUpdate
{
  private final CamerParameter camerPara;
  
  CameraUpdate(CamerParameter paramCamerParameter)
  {
    this.camerPara = paramCamerParameter;
  }
  
  public final CamerParameter getParams()
  {
    return this.camerPara;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.CameraUpdate
 * JD-Core Version:    0.7.0.1
 */