package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btm
  extends com.tencent.mm.bx.a
{
  public String DQW;
  public String DQX;
  public String DQY;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196736);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQW != null) {
        paramVarArgs.d(1, this.DQW);
      }
      if (this.DQX != null) {
        paramVarArgs.d(2, this.DQX);
      }
      if (this.DQY != null) {
        paramVarArgs.d(3, this.DQY);
      }
      paramVarArgs.aR(4, this.action);
      AppMethodBeat.o(196736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQW == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.DQW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DQX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DQX);
      }
      i = paramInt;
      if (this.DQY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQY);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.action);
      AppMethodBeat.o(196736);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(196736);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btm localbtm = (btm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196736);
          return -1;
        case 1: 
          localbtm.DQW = locala.KhF.readString();
          AppMethodBeat.o(196736);
          return 0;
        case 2: 
          localbtm.DQX = locala.KhF.readString();
          AppMethodBeat.o(196736);
          return 0;
        case 3: 
          localbtm.DQY = locala.KhF.readString();
          AppMethodBeat.o(196736);
          return 0;
        }
        localbtm.action = locala.KhF.xS();
        AppMethodBeat.o(196736);
        return 0;
      }
      AppMethodBeat.o(196736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btm
 * JD-Core Version:    0.7.0.1
 */