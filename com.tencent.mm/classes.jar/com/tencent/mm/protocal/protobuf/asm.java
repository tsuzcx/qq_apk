package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asm
  extends com.tencent.mm.bw.a
{
  public int GEB;
  public String GJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GEB);
      if (this.GJE != null) {
        paramVarArgs.d(2, this.GJE);
      }
      AppMethodBeat.o(189408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GEB) + 0;
      paramInt = i;
      if (this.GJE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GJE);
      }
      AppMethodBeat.o(189408);
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
      AppMethodBeat.o(189408);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      asm localasm = (asm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189408);
        return -1;
      case 1: 
        localasm.GEB = locala.OmT.zc();
        AppMethodBeat.o(189408);
        return 0;
      }
      localasm.GJE = locala.OmT.readString();
      AppMethodBeat.o(189408);
      return 0;
    }
    AppMethodBeat.o(189408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asm
 * JD-Core Version:    0.7.0.1
 */