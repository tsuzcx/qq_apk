package com.tencent.mm.timelineedit.a.a;

import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k
  implements cw
{
  private static final k[] adqw;
  private static final bj.d<k> dLG;
  private final int value;
  
  static
  {
    AppMethodBeat.i(232202);
    adqs = new k("PbDefault", 0, 0);
    adqt = new k("PbForbidOutside", 1, 1);
    adqu = new k("PbJumpBack", 2, 2);
    adqv = new k("UNRECOGNIZED", 3, -1);
    adqx = new k[] { adqs, adqt, adqu, adqv };
    dLG = new bj.d() {};
    adqw = values();
    AppMethodBeat.o(232202);
  }
  
  private k(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(232215);
    if (this == adqv)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(232215);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(232215);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.k
 * JD-Core Version:    0.7.0.1
 */