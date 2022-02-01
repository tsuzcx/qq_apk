package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amt
  extends com.tencent.mm.bw.a
{
  public int EFP;
  public int EFQ;
  public int EFR;
  public int EFS;
  public int EFT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195102);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EFP);
      paramVarArgs.aR(2, this.EFQ);
      paramVarArgs.aR(3, this.EFR);
      paramVarArgs.aR(4, this.EFS);
      paramVarArgs.aR(5, this.EFT);
      AppMethodBeat.o(195102);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EFP);
      int i = f.a.a.b.b.a.bx(2, this.EFQ);
      int j = f.a.a.b.b.a.bx(3, this.EFR);
      int k = f.a.a.b.b.a.bx(4, this.EFS);
      int m = f.a.a.b.b.a.bx(5, this.EFT);
      AppMethodBeat.o(195102);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195102);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amt localamt = (amt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195102);
        return -1;
      case 1: 
        localamt.EFP = locala.LVo.xF();
        AppMethodBeat.o(195102);
        return 0;
      case 2: 
        localamt.EFQ = locala.LVo.xF();
        AppMethodBeat.o(195102);
        return 0;
      case 3: 
        localamt.EFR = locala.LVo.xF();
        AppMethodBeat.o(195102);
        return 0;
      case 4: 
        localamt.EFS = locala.LVo.xF();
        AppMethodBeat.o(195102);
        return 0;
      }
      localamt.EFT = locala.LVo.xF();
      AppMethodBeat.o(195102);
      return 0;
    }
    AppMethodBeat.o(195102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amt
 * JD-Core Version:    0.7.0.1
 */