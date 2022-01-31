package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckx;

public final class b
{
  public long nae;
  public boolean quM;
  public ckx tfm;
  public boolean tfn;
  
  public b(ckx paramckx)
  {
    AppMethodBeat.i(96381);
    this.tfm = paramckx;
    this.nae = System.currentTimeMillis();
    AppMethodBeat.o(96381);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(96382);
    if (paramObject == null)
    {
      AppMethodBeat.o(96382);
      return false;
    }
    paramObject = (b)paramObject;
    boolean bool = this.tfm.xVa.equals(paramObject.tfm.xVa);
    AppMethodBeat.o(96382);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.b
 * JD-Core Version:    0.7.0.1
 */