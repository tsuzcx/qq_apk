package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqt
  extends com.tencent.mm.bw.a
{
  public int GHB;
  public int GHC;
  public int GHD;
  public int GHE;
  public int GHF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189389);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GHB);
      paramVarArgs.aS(2, this.GHC);
      paramVarArgs.aS(3, this.GHD);
      paramVarArgs.aS(4, this.GHE);
      paramVarArgs.aS(5, this.GHF);
      AppMethodBeat.o(189389);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GHB);
      int i = f.a.a.b.b.a.bz(2, this.GHC);
      int j = f.a.a.b.b.a.bz(3, this.GHD);
      int k = f.a.a.b.b.a.bz(4, this.GHE);
      int m = f.a.a.b.b.a.bz(5, this.GHF);
      AppMethodBeat.o(189389);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189389);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqt localaqt = (aqt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189389);
        return -1;
      case 1: 
        localaqt.GHB = locala.OmT.zc();
        AppMethodBeat.o(189389);
        return 0;
      case 2: 
        localaqt.GHC = locala.OmT.zc();
        AppMethodBeat.o(189389);
        return 0;
      case 3: 
        localaqt.GHD = locala.OmT.zc();
        AppMethodBeat.o(189389);
        return 0;
      case 4: 
        localaqt.GHE = locala.OmT.zc();
        AppMethodBeat.o(189389);
        return 0;
      }
      localaqt.GHF = locala.OmT.zc();
      AppMethodBeat.o(189389);
      return 0;
    }
    AppMethodBeat.o(189389);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqt
 * JD-Core Version:    0.7.0.1
 */