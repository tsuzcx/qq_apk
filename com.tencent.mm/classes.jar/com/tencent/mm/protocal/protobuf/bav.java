package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bav
  extends com.tencent.mm.bw.a
{
  public int LKt;
  public float LKu;
  public int LKv;
  public int LKw;
  public float LKx;
  public int LKy;
  public int uUm;
  public int uUn;
  public int uUr;
  public int uUs;
  public int uUu;
  public int uUy;
  public int uUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uUm);
      paramVarArgs.aM(2, this.uUn);
      paramVarArgs.aM(3, this.LKt);
      paramVarArgs.E(4, this.LKu);
      paramVarArgs.aM(5, this.LKv);
      paramVarArgs.aM(6, this.LKw);
      paramVarArgs.aM(7, this.uUr);
      paramVarArgs.aM(8, this.uUs);
      paramVarArgs.E(9, this.LKx);
      paramVarArgs.aM(10, this.uUu);
      paramVarArgs.aM(11, this.LKy);
      paramVarArgs.aM(12, this.uUy);
      paramVarArgs.aM(13, this.uUz);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.uUm);
      int i = g.a.a.b.b.a.bu(2, this.uUn);
      int j = g.a.a.b.b.a.bu(3, this.LKt);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.bu(5, this.LKv);
      int n = g.a.a.b.b.a.bu(6, this.LKw);
      int i1 = g.a.a.b.b.a.bu(7, this.uUr);
      int i2 = g.a.a.b.b.a.bu(8, this.uUs);
      int i3 = g.a.a.b.b.a.fS(9);
      int i4 = g.a.a.b.b.a.bu(10, this.uUu);
      int i5 = g.a.a.b.b.a.bu(11, this.LKy);
      int i6 = g.a.a.b.b.a.bu(12, this.uUy);
      int i7 = g.a.a.b.b.a.bu(13, this.uUz);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + (k + 4) + m + n + i1 + i2 + (i3 + 4) + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bav localbav = (bav)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localbav.uUm = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localbav.uUn = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localbav.LKt = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localbav.LKu = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localbav.LKv = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 6: 
        localbav.LKw = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 7: 
        localbav.uUr = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 8: 
        localbav.uUs = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 9: 
        localbav.LKx = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(184205);
        return 0;
      case 10: 
        localbav.uUu = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 11: 
        localbav.LKy = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      case 12: 
        localbav.uUy = locala.UbS.zi();
        AppMethodBeat.o(184205);
        return 0;
      }
      localbav.uUz = locala.UbS.zi();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bav
 * JD-Core Version:    0.7.0.1
 */