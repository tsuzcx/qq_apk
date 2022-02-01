package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public final int code;
  
  static
  {
    AppMethodBeat.i(109456);
    Fea = new a("TencentMap", 0, 0);
    Feb = new a("GoogleMap", 1, 1);
    Fec = new a("SogouMap", 2, 2);
    Fed = new a("BaiduMap", 3, 3);
    Fee = new a("AutonaviMap", 4, 4);
    Fef = new a[] { Fea, Feb, Fec, Fed, Fee };
    AppMethodBeat.o(109456);
  }
  
  private c$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static a YQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Fea;
    case 0: 
      return Fea;
    case 1: 
      return Feb;
    case 2: 
      return Fec;
    case 3: 
      return Fed;
    }
    return Fee;
  }
  
  public final String getPackage()
  {
    AppMethodBeat.i(109455);
    switch (c.1.FdZ[ordinal()])
    {
    default: 
      AppMethodBeat.o(109455);
      return "com.tencent.map";
    case 1: 
      AppMethodBeat.o(109455);
      return "com.tencent.map";
    case 2: 
      AppMethodBeat.o(109455);
      return "com.google.android.apps.maps";
    case 3: 
      AppMethodBeat.o(109455);
      return "com.sogou.map.android.maps";
    case 4: 
      AppMethodBeat.o(109455);
      return "com.baidu.BaiduMap";
    }
    AppMethodBeat.o(109455);
    return "com.autonavi.minimap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c.a
 * JD-Core Version:    0.7.0.1
 */