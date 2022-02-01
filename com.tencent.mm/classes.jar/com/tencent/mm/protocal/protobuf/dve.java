package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dve
  extends com.tencent.mm.bw.a
{
  public int Adu;
  public int IaQ;
  public long IaR;
  public long IaS;
  public long rfl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IaQ);
      paramVarArgs.aS(2, this.Adu);
      paramVarArgs.aZ(3, this.rfl);
      paramVarArgs.aZ(4, this.IaR);
      paramVarArgs.aZ(5, this.IaS);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.IaQ);
      int i = f.a.a.b.b.a.bz(2, this.Adu);
      int j = f.a.a.b.b.a.p(3, this.rfl);
      int k = f.a.a.b.b.a.p(4, this.IaR);
      int m = f.a.a.b.b.a.p(5, this.IaS);
      AppMethodBeat.o(169092);
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
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dve localdve = (dve)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localdve.IaQ = locala.OmT.zc();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localdve.Adu = locala.OmT.zc();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localdve.rfl = locala.OmT.zd();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localdve.IaR = locala.OmT.zd();
        AppMethodBeat.o(169092);
        return 0;
      }
      localdve.IaS = locala.OmT.zd();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dve
 * JD-Core Version:    0.7.0.1
 */