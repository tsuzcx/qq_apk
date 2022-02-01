package com.tencent.mm.timelineedit.a.a;

import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
  implements cw
{
  private static final o[] adqN;
  private static final bj.d<o> dLG;
  private final int value;
  
  static
  {
    AppMethodBeat.i(232131);
    adqI = new o("UnknownType", 0, 0);
    adqJ = new o("Video", 1, 1);
    adqK = new o("Audio", 2, 2);
    adqL = new o("Image", 3, 3);
    adqM = new o("UNRECOGNIZED", 4, -1);
    adqO = new o[] { adqI, adqJ, adqK, adqL, adqM };
    dLG = new bj.d() {};
    adqN = values();
    AppMethodBeat.o(232131);
  }
  
  private o(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static o azz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return adqI;
    case 1: 
      return adqJ;
    case 2: 
      return adqK;
    }
    return adqL;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(232143);
    if (this == adqM)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(232143);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(232143);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.o
 * JD-Core Version:    0.7.0.1
 */