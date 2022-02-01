package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejc
  extends com.tencent.mm.bx.a
{
  public int OcH;
  public int Oet;
  public int Oeu;
  public int Oev;
  public int Oew;
  public int Oex;
  public int Oey;
  public int pullType;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221256);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      paramVarArgs.aS(2, this.Oet);
      paramVarArgs.aS(3, this.pullType);
      paramVarArgs.aS(4, this.OcH);
      paramVarArgs.aS(5, this.Oeu);
      paramVarArgs.aS(6, this.Oev);
      paramVarArgs.aS(7, this.Oew);
      paramVarArgs.aS(8, this.Oex);
      paramVarArgs.aS(9, this.Oey);
      AppMethodBeat.o(221256);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.scene);
      int i = f.a.a.b.b.a.bz(2, this.Oet);
      int j = f.a.a.b.b.a.bz(3, this.pullType);
      int k = f.a.a.b.b.a.bz(4, this.OcH);
      int m = f.a.a.b.b.a.bz(5, this.Oeu);
      int n = f.a.a.b.b.a.bz(6, this.Oev);
      int i1 = f.a.a.b.b.a.bz(7, this.Oew);
      int i2 = f.a.a.b.b.a.bz(8, this.Oex);
      int i3 = f.a.a.b.b.a.bz(9, this.Oey);
      AppMethodBeat.o(221256);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(221256);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ejc localejc = (ejc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(221256);
        return -1;
      case 1: 
        localejc.scene = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 2: 
        localejc.Oet = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 3: 
        localejc.pullType = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 4: 
        localejc.OcH = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 5: 
        localejc.Oeu = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 6: 
        localejc.Oev = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 7: 
        localejc.Oew = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      case 8: 
        localejc.Oex = locala.NPN.zc();
        AppMethodBeat.o(221256);
        return 0;
      }
      localejc.Oey = locala.NPN.zc();
      AppMethodBeat.o(221256);
      return 0;
    }
    AppMethodBeat.o(221256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejc
 * JD-Core Version:    0.7.0.1
 */