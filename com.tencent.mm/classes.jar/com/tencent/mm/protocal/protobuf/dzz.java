package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzz
  extends com.tencent.mm.bw.a
{
  public int IfM;
  public int IfN;
  public int IfO;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115903);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      paramVarArgs.aS(2, this.IfM);
      paramVarArgs.aS(3, this.IfN);
      paramVarArgs.aS(4, this.IfO);
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nJA);
      int i = f.a.a.b.b.a.bz(2, this.IfM);
      int j = f.a.a.b.b.a.bz(3, this.IfN);
      int k = f.a.a.b.b.a.bz(4, this.IfO);
      AppMethodBeat.o(115903);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzz localdzz = (dzz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115903);
        return -1;
      case 1: 
        localdzz.nJA = locala.OmT.zc();
        AppMethodBeat.o(115903);
        return 0;
      case 2: 
        localdzz.IfM = locala.OmT.zc();
        AppMethodBeat.o(115903);
        return 0;
      case 3: 
        localdzz.IfN = locala.OmT.zc();
        AppMethodBeat.o(115903);
        return 0;
      }
      localdzz.IfO = locala.OmT.zc();
      AppMethodBeat.o(115903);
      return 0;
    }
    AppMethodBeat.o(115903);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzz
 * JD-Core Version:    0.7.0.1
 */