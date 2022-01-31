package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bh;
import com.tencent.tencentmap.mapsdk.a.cy;

public class nq
  implements bh
{
  private cy a = cy.a;
  
  protected int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % paramInt2;
    paramInt1 = i;
    if (i * paramInt2 < 0) {
      paramInt1 = i + paramInt2;
    }
    return paramInt1;
  }
  
  public cy a()
  {
    return this.a;
  }
  
  public String a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(149518);
    String str = nn.e();
    if (str == null)
    {
      AppMethodBeat.o(149518);
      return null;
    }
    int[] arrayOfInt = nn.h();
    if (arrayOfInt.length == 0) {}
    for (str = str.replaceFirst("\\{range\\}", "");; str = str.replaceFirst("\\{range\\}", Integer.toString(a(paramInt1 + paramInt2, arrayOfInt.length))))
    {
      str = str.replaceFirst("\\{z\\}", Integer.toString(paramInt3)).replaceFirst("\\{x\\}", Integer.toString(paramInt1)).replaceFirst("\\{y\\}", Integer.toString(paramInt2)).replaceFirst("\\{style\\}", Integer.toString(nn.a())).replaceFirst("\\{scene\\}", Integer.toString(nn.b())).replaceFirst("\\{version\\}", Integer.toString(nn.c())).replaceFirst("\\{ch\\}", this.a.name());
      str = str + "&foreignLanguage=" + this.a.name();
      AppMethodBeat.o(149518);
      return str;
    }
  }
  
  public void a(cy paramcy)
  {
    this.a = paramcy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nq
 * JD-Core Version:    0.7.0.1
 */