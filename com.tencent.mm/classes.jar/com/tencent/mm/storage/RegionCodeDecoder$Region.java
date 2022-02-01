package com.tencent.mm.storage;

public class RegionCodeDecoder$Region
{
  private String code;
  private String countryCode;
  private boolean hasChildren = false;
  private boolean isCity = false;
  private boolean isCountry = false;
  private boolean isProvince = false;
  private String name;
  private Region parent = null;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Region getParent()
  {
    return this.parent;
  }
  
  public boolean hasChildren()
  {
    return this.hasChildren;
  }
  
  public boolean isCity()
  {
    return this.isCity;
  }
  
  public boolean isCountry()
  {
    return this.isCountry;
  }
  
  public boolean isProvince()
  {
    return this.isProvince;
  }
  
  public void setCity(boolean paramBoolean)
  {
    this.isCity = paramBoolean;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCountry(boolean paramBoolean)
  {
    this.isCountry = paramBoolean;
  }
  
  public void setCountryCode(String paramString)
  {
    this.countryCode = paramString;
  }
  
  public void setHasChildren(boolean paramBoolean)
  {
    this.hasChildren = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParent(Region paramRegion)
  {
    this.parent = paramRegion;
  }
  
  public void setProvince(boolean paramBoolean)
  {
    this.isProvince = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.RegionCodeDecoder.Region
 * JD-Core Version:    0.7.0.1
 */