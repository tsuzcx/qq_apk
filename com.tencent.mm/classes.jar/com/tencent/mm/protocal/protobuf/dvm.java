package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvm
  extends com.tencent.mm.bx.a
{
  public String dlB;
  public int odq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      paramVarArgs.aR(2, this.odq);
      AppMethodBeat.o(187836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.odq);
      AppMethodBeat.o(187836);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(187836);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvm localdvm = (dvm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187836);
          return -1;
        case 1: 
          localdvm.dlB = locala.KhF.readString();
          AppMethodBeat.o(187836);
          return 0;
        }
        localdvm.odq = locala.KhF.xS();
        AppMethodBeat.o(187836);
        return 0;
      }
      AppMethodBeat.o(187836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvm
 * JD-Core Version:    0.7.0.1
 */