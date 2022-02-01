package com.tencent.mm.timelineedit.a.a;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k
  implements cl
{
  private static final k[] VMr;
  private static final be.b<k> bRT;
  private final int value;
  
  static
  {
    AppMethodBeat.i(260647);
    VMn = new k("PbDefault", 0, 0);
    VMo = new k("PbForbidOutside", 1, 1);
    VMp = new k("PbJumpBack", 2, 2);
    VMq = new k("UNRECOGNIZED", 3, -1);
    VMs = new k[] { VMn, VMo, VMp, VMq };
    bRT = new be.b() {};
    VMr = values();
    AppMethodBeat.o(260647);
  }
  
  private k(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(260645);
    if (this == VMq)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(260645);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(260645);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.k
 * JD-Core Version:    0.7.0.1
 */