package com.tencent.tencentmap.mapsdk.maps.model;

public class SubPoi
  extends MapPoi
{
  private String id;
  private String parentId;
  
  public String getId()
  {
    return this.id;
  }
  
  public String getParentId()
  {
    return this.parentId;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setParentId(String paramString)
  {
    this.parentId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.SubPoi
 * JD-Core Version:    0.7.0.1
 */