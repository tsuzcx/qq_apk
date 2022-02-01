package com.tencent.mm.timelineedit.a.a;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum p
  implements cl
{
  private static final p[] VMO;
  private static final be.b<p> bRT;
  private final int value;
  
  static
  {
    AppMethodBeat.i(260817);
    VMK = new p("Custom", 0, 0);
    VML = new p("CenterCrop", 1, 1);
    VMM = new p("CenterInside", 2, 2);
    VMN = new p("UNRECOGNIZED", 3, -1);
    VMP = new p[] { VMK, VML, VMM, VMN };
    bRT = new be.b() {};
    VMO = values();
    AppMethodBeat.o(260817);
  }
  
  private p(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static p atk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return VMK;
    case 1: 
      return VML;
    }
    return VMM;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(260816);
    if (this == VMN)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(260816);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(260816);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.p
 * JD-Core Version:    0.7.0.1
 */