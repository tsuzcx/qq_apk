package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r$a
{
  public int h;
  public int w;
  public int x;
  public int y;
  
  public final String toString()
  {
    AppMethodBeat.i(116444);
    String str = String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w) });
    AppMethodBeat.o(116444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r.a
 * JD-Core Version:    0.7.0.1
 */