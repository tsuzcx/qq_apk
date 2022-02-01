package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azm
  extends com.tencent.mm.bx.a
{
  public int FMu;
  public long Guq;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      paramVarArgs.aS(2, this.FMu);
      paramVarArgs.aY(3, this.Guq);
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nEf);
      int i = f.a.a.b.b.a.bz(2, this.FMu);
      int j = f.a.a.b.b.a.p(3, this.Guq);
      AppMethodBeat.o(117868);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      azm localazm = (azm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117868);
        return -1;
      case 1: 
        localazm.nEf = locala.NPN.zc();
        AppMethodBeat.o(117868);
        return 0;
      case 2: 
        localazm.FMu = locala.NPN.zc();
        AppMethodBeat.o(117868);
        return 0;
      }
      localazm.Guq = locala.NPN.zd();
      AppMethodBeat.o(117868);
      return 0;
    }
    AppMethodBeat.o(117868);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azm
 * JD-Core Version:    0.7.0.1
 */