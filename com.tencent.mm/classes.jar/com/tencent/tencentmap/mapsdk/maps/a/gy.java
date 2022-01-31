package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class gy
  extends hc
{
  private boolean g = true;
  
  public gy(hb.a... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public gy a()
  {
    AppMethodBeat.i(148029);
    Object localObject = this.e;
    int j = this.e.size();
    hb.a[] arrayOfa = new hb.a[j];
    int i = 0;
    while (i < j)
    {
      arrayOfa[i] = ((hb.a)((hb)((ArrayList)localObject).get(i)).d());
      i += 1;
    }
    localObject = new gy(arrayOfa);
    AppMethodBeat.o(148029);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gy
 * JD-Core Version:    0.7.0.1
 */