package com.tencent.mm.timelineedit.a.a;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
  implements cl
{
  private static final o[] VMI;
  private static final be.b<o> bRT;
  private final int value;
  
  static
  {
    AppMethodBeat.i(260804);
    VMD = new o("UnknownType", 0, 0);
    VME = new o("Video", 1, 1);
    VMF = new o("Audio", 2, 2);
    VMG = new o("Image", 3, 3);
    VMH = new o("UNRECOGNIZED", 4, -1);
    VMJ = new o[] { VMD, VME, VMF, VMG, VMH };
    bRT = new be.b() {};
    VMI = values();
    AppMethodBeat.o(260804);
  }
  
  private o(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static o atj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return VMD;
    case 1: 
      return VME;
    case 2: 
      return VMF;
    }
    return VMG;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(260800);
    if (this == VMH)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(260800);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(260800);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.o
 * JD-Core Version:    0.7.0.1
 */