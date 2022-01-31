package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bh;

public class lp
  implements bh
{
  public String a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(149200);
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - 1.0D - paramInt2);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("https://p0.map.gtimg.com/scenic/");
    ((StringBuffer)localObject).append("?z=");
    ((StringBuffer)localObject).append(paramInt3);
    ((StringBuffer)localObject).append("&y=");
    ((StringBuffer)localObject).append(paramInt2);
    ((StringBuffer)localObject).append("&x=");
    ((StringBuffer)localObject).append(paramInt1);
    ((StringBuffer)localObject).append("&styleid=");
    ((StringBuffer)localObject).append(7);
    ((StringBuffer)localObject).append("&version=");
    ((StringBuffer)localObject).append(lm.a());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149200);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lp
 * JD-Core Version:    0.7.0.1
 */