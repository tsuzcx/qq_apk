package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  public final int code;
  
  static
  {
    AppMethodBeat.i(125812);
    vKa = new a("TencentMap", 0, 0);
    vKb = new a("GoogleMap", 1, 1);
    vKc = new a("SogouMap", 2, 2);
    vKd = new a("BaiduMap", 3, 3);
    vKe = new a("AutonaviMap", 4, 4);
    vKf = new a[] { vKa, vKb, vKc, vKd, vKe };
    AppMethodBeat.o(125812);
  }
  
  private a$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static a Lt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return vKa;
    case 0: 
      return vKa;
    case 1: 
      return vKb;
    case 2: 
      return vKc;
    case 3: 
      return vKd;
    }
    return vKe;
  }
  
  public final String getPackage()
  {
    AppMethodBeat.i(125811);
    switch (a.1.vJZ[ordinal()])
    {
    default: 
      AppMethodBeat.o(125811);
      return "com.tencent.map";
    case 1: 
      AppMethodBeat.o(125811);
      return "com.tencent.map";
    case 2: 
      AppMethodBeat.o(125811);
      return "com.google.android.apps.maps";
    case 3: 
      AppMethodBeat.o(125811);
      return "com.sogou.map.android.maps";
    case 4: 
      AppMethodBeat.o(125811);
      return "com.baidu.BaiduMap";
    }
    AppMethodBeat.o(125811);
    return "com.autonavi.minimap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.a
 * JD-Core Version:    0.7.0.1
 */