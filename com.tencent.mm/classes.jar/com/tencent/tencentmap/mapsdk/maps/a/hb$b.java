package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class hb$b
  extends hb
{
  Object d;
  
  hb$b(float paramFloat, Object paramObject)
  {
    AppMethodBeat.i(148036);
    this.a = paramFloat;
    this.d = paramObject;
    boolean bool;
    if (paramObject != null)
    {
      bool = true;
      this.c = bool;
      if (!this.c) {
        break label58;
      }
    }
    label58:
    for (paramObject = paramObject.getClass();; paramObject = Object.class)
    {
      this.b = paramObject;
      AppMethodBeat.o(148036);
      return;
      bool = false;
      break;
    }
  }
  
  public Object a()
  {
    return this.d;
  }
  
  public b e()
  {
    AppMethodBeat.i(148037);
    b localb = new b(b(), this.d);
    localb.a(c());
    AppMethodBeat.o(148037);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hb.b
 * JD-Core Version:    0.7.0.1
 */