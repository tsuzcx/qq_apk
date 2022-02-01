package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cys
  extends com.tencent.mm.bw.a
{
  public int HIO;
  public int Timestamp;
  public int gvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HIO);
      paramVarArgs.aS(2, this.Timestamp);
      paramVarArgs.aS(3, this.gvx);
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HIO);
      int i = f.a.a.b.b.a.bz(2, this.Timestamp);
      int j = f.a.a.b.b.a.bz(3, this.gvx);
      AppMethodBeat.o(117906);
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
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cys localcys = (cys)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117906);
        return -1;
      case 1: 
        localcys.HIO = locala.OmT.zc();
        AppMethodBeat.o(117906);
        return 0;
      case 2: 
        localcys.Timestamp = locala.OmT.zc();
        AppMethodBeat.o(117906);
        return 0;
      }
      localcys.gvx = locala.OmT.zc();
      AppMethodBeat.o(117906);
      return 0;
    }
    AppMethodBeat.o(117906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cys
 * JD-Core Version:    0.7.0.1
 */