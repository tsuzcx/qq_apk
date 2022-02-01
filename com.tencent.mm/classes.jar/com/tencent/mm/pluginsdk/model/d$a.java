package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  public final int code;
  
  static
  {
    AppMethodBeat.i(109456);
    JUQ = new a("TencentMap", 0, 0);
    JUR = new a("GoogleMap", 1, 1);
    JUS = new a("SogouMap", 2, 2);
    JUT = new a("BaiduMap", 3, 3);
    JUU = new a("AutonaviMap", 4, 4);
    JUV = new a[] { JUQ, JUR, JUS, JUT, JUU };
    AppMethodBeat.o(109456);
  }
  
  private d$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static a ahC(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return JUQ;
    case 0: 
      return JUQ;
    case 1: 
      return JUR;
    case 2: 
      return JUS;
    case 3: 
      return JUT;
    }
    return JUU;
  }
  
  public final String getPackage()
  {
    AppMethodBeat.i(109455);
    switch (d.1.JUP[ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d.a
 * JD-Core Version:    0.7.0.1
 */