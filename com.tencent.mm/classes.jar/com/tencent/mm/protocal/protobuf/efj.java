package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efj
  extends com.tencent.mm.bw.a
{
  public int FRI;
  public long FSD;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.FRI);
      paramVarArgs.aZ(3, this.FSD);
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Ret);
      int i = f.a.a.b.b.a.bz(2, this.FRI);
      int j = f.a.a.b.b.a.p(3, this.FSD);
      AppMethodBeat.o(32561);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efj localefj = (efj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32561);
        return -1;
      case 1: 
        localefj.Ret = locala.OmT.zc();
        AppMethodBeat.o(32561);
        return 0;
      case 2: 
        localefj.FRI = locala.OmT.zc();
        AppMethodBeat.o(32561);
        return 0;
      }
      localefj.FSD = locala.OmT.zd();
      AppMethodBeat.o(32561);
      return 0;
    }
    AppMethodBeat.o(32561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efj
 * JD-Core Version:    0.7.0.1
 */