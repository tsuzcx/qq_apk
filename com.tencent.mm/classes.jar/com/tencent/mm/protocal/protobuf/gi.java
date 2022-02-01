package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gi
  extends com.tencent.mm.bw.a
{
  public int FQT;
  public int FQU;
  public int FQV;
  public int FQW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FQT);
      paramVarArgs.aS(2, this.FQU);
      paramVarArgs.aS(3, this.FQV);
      paramVarArgs.aS(4, this.FQW);
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FQT);
      int i = f.a.a.b.b.a.bz(2, this.FQU);
      int j = f.a.a.b.b.a.bz(3, this.FQV);
      int k = f.a.a.b.b.a.bz(4, this.FQW);
      AppMethodBeat.o(32126);
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
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      gi localgi = (gi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32126);
        return -1;
      case 1: 
        localgi.FQT = locala.OmT.zc();
        AppMethodBeat.o(32126);
        return 0;
      case 2: 
        localgi.FQU = locala.OmT.zc();
        AppMethodBeat.o(32126);
        return 0;
      case 3: 
        localgi.FQV = locala.OmT.zc();
        AppMethodBeat.o(32126);
        return 0;
      }
      localgi.FQW = locala.OmT.zc();
      AppMethodBeat.o(32126);
      return 0;
    }
    AppMethodBeat.o(32126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gi
 * JD-Core Version:    0.7.0.1
 */