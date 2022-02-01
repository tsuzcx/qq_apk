package com.tencent.mm.timelineedit.a.a;

import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n
  implements cw
{
  private static final n[] adqG;
  private static final bj.d<n> dLG;
  private final int value;
  
  static
  {
    AppMethodBeat.i(232191);
    adqB = new n("NoneAnimation", 0, 0);
    adqC = new n("AnimationStart", 1, 1);
    adqD = new n("AnimationProgress", 2, 2);
    adqE = new n("AnimationFinish", 3, 3);
    adqF = new n("UNRECOGNIZED", 4, -1);
    adqH = new n[] { adqB, adqC, adqD, adqE, adqF };
    dLG = new bj.d() {};
    adqG = values();
    AppMethodBeat.o(232191);
  }
  
  private n(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(232197);
    if (this == adqF)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(232197);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(232197);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.n
 * JD-Core Version:    0.7.0.1
 */