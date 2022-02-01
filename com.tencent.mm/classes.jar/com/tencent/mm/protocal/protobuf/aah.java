package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aah
  extends com.tencent.mm.bx.a
{
  public int FGO;
  public int FZg;
  public int nDG;
  public int ugm;
  public int xbr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xbr);
      paramVarArgs.aS(2, this.ugm);
      paramVarArgs.aS(3, this.FZg);
      paramVarArgs.aS(4, this.nDG);
      paramVarArgs.aS(5, this.FGO);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.xbr);
      int i = f.a.a.b.b.a.bz(2, this.ugm);
      int j = f.a.a.b.b.a.bz(3, this.FZg);
      int k = f.a.a.b.b.a.bz(4, this.nDG);
      int m = f.a.a.b.b.a.bz(5, this.FGO);
      AppMethodBeat.o(124478);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aah localaah = (aah)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localaah.xbr = locala.NPN.zc();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localaah.ugm = locala.NPN.zc();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localaah.FZg = locala.NPN.zc();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localaah.nDG = locala.NPN.zc();
        AppMethodBeat.o(124478);
        return 0;
      }
      localaah.FGO = locala.NPN.zc();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aah
 * JD-Core Version:    0.7.0.1
 */