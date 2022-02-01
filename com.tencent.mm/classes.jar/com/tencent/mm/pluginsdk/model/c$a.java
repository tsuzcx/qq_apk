package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public final int code;
  
  static
  {
    AppMethodBeat.i(109456);
    ELC = new a("TencentMap", 0, 0);
    ELD = new a("GoogleMap", 1, 1);
    ELE = new a("SogouMap", 2, 2);
    ELF = new a("BaiduMap", 3, 3);
    ELG = new a("AutonaviMap", 4, 4);
    ELH = new a[] { ELC, ELD, ELE, ELF, ELG };
    AppMethodBeat.o(109456);
  }
  
  private c$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static a Yk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ELC;
    case 0: 
      return ELC;
    case 1: 
      return ELD;
    case 2: 
      return ELE;
    case 3: 
      return ELF;
    }
    return ELG;
  }
  
  public final String getPackage()
  {
    AppMethodBeat.i(109455);
    switch (c.1.ELB[ordinal()])
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c.a
 * JD-Core Version:    0.7.0.1
 */