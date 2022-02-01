package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auf
  extends com.tencent.mm.bw.a
{
  public String GLc;
  public int GxI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GxI);
      if (this.GLc != null) {
        paramVarArgs.d(2, this.GLc);
      }
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GxI) + 0;
      paramInt = i;
      if (this.GLc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GLc);
      }
      AppMethodBeat.o(155407);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      auf localauf = (auf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155407);
        return -1;
      case 1: 
        localauf.GxI = locala.OmT.zc();
        AppMethodBeat.o(155407);
        return 0;
      }
      localauf.GLc = locala.OmT.readString();
      AppMethodBeat.o(155407);
      return 0;
    }
    AppMethodBeat.o(155407);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auf
 * JD-Core Version:    0.7.0.1
 */