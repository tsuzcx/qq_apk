package com.tencent.mm.pluginsdk.model;

public enum a$a
{
  public final int code;
  
  private a$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static a DB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return rTc;
    case 0: 
      return rTc;
    case 1: 
      return rTd;
    case 2: 
      return rTe;
    case 3: 
      return rTf;
    }
    return rTg;
  }
  
  public final String getPackage()
  {
    switch (a.1.rTb[ordinal()])
    {
    default: 
      return "com.tencent.map";
    case 1: 
      return "com.tencent.map";
    case 2: 
      return "com.google.android.apps.maps";
    case 3: 
      return "com.sogou.map.android.maps";
    case 4: 
      return "com.baidu.BaiduMap";
    }
    return "com.autonavi.minimap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.a
 * JD-Core Version:    0.7.0.1
 */