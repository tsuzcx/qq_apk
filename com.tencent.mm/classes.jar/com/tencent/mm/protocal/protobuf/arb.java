package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arb
  extends com.tencent.mm.bw.a
{
  public int GHQ;
  public float GHR;
  public int GHS;
  public int GHT;
  public float GHU;
  public int suc;
  public int sud;
  public int suh;
  public int sui;
  public int suk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.suc);
      paramVarArgs.aS(2, this.sud);
      paramVarArgs.aS(3, this.GHQ);
      paramVarArgs.y(4, this.GHR);
      paramVarArgs.aS(5, this.GHS);
      paramVarArgs.aS(6, this.GHT);
      paramVarArgs.aS(7, this.suh);
      paramVarArgs.aS(8, this.sui);
      paramVarArgs.y(9, this.GHU);
      paramVarArgs.aS(10, this.suk);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.suc);
      int i = f.a.a.b.b.a.bz(2, this.sud);
      int j = f.a.a.b.b.a.bz(3, this.GHQ);
      int k = f.a.a.b.b.a.amE(4);
      int m = f.a.a.b.b.a.bz(5, this.GHS);
      int n = f.a.a.b.b.a.bz(6, this.GHT);
      int i1 = f.a.a.b.b.a.bz(7, this.suh);
      int i2 = f.a.a.b.b.a.bz(8, this.sui);
      int i3 = f.a.a.b.b.a.amE(9);
      int i4 = f.a.a.b.b.a.bz(10, this.suk);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      arb localarb = (arb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localarb.suc = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localarb.sud = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localarb.GHQ = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localarb.GHR = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localarb.GHS = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 6: 
        localarb.GHT = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 7: 
        localarb.suh = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 8: 
        localarb.sui = locala.OmT.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 9: 
        localarb.GHU = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(184205);
        return 0;
      }
      localarb.suk = locala.OmT.zc();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arb
 * JD-Core Version:    0.7.0.1
 */