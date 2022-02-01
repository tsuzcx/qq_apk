package com.tencent.mm.timelineedit.a.a;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n
  implements cl
{
  private static final n[] VMB;
  private static final be.b<n> bRT;
  private final int value;
  
  static
  {
    AppMethodBeat.i(260792);
    VMw = new n("NoneAnimation", 0, 0);
    VMx = new n("AnimationStart", 1, 1);
    VMy = new n("AnimationProgress", 2, 2);
    VMz = new n("AnimationFinish", 3, 3);
    VMA = new n("UNRECOGNIZED", 4, -1);
    VMC = new n[] { VMw, VMx, VMy, VMz, VMA };
    bRT = new be.b() {};
    VMB = values();
    AppMethodBeat.o(260792);
  }
  
  private n(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(260787);
    if (this == VMA)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(260787);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(260787);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.n
 * JD-Core Version:    0.7.0.1
 */