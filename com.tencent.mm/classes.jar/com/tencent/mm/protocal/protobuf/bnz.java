package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnz
  extends com.tencent.mm.bw.a
{
  public long HaO;
  public int HaP;
  public long HaQ;
  public int HaR;
  public long HaS;
  public int HaT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HaO);
      paramVarArgs.aS(2, this.HaP);
      paramVarArgs.aZ(3, this.HaQ);
      paramVarArgs.aS(4, this.HaR);
      paramVarArgs.aZ(5, this.HaS);
      paramVarArgs.aS(6, this.HaT);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HaO);
      int i = f.a.a.b.b.a.bz(2, this.HaP);
      int j = f.a.a.b.b.a.p(3, this.HaQ);
      int k = f.a.a.b.b.a.bz(4, this.HaR);
      int m = f.a.a.b.b.a.p(5, this.HaS);
      int n = f.a.a.b.b.a.bz(6, this.HaT);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnz localbnz = (bnz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localbnz.HaO = locala.OmT.zd();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localbnz.HaP = locala.OmT.zc();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localbnz.HaQ = locala.OmT.zd();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localbnz.HaR = locala.OmT.zc();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localbnz.HaS = locala.OmT.zd();
        AppMethodBeat.o(115845);
        return 0;
      }
      localbnz.HaT = locala.OmT.zc();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnz
 * JD-Core Version:    0.7.0.1
 */