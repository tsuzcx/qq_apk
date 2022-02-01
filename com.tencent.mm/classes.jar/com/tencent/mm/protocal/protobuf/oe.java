package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oe
  extends com.tencent.mm.bx.a
{
  public String CLI;
  public String CLJ;
  public String Url;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLI != null) {
        paramVarArgs.d(1, this.CLI);
      }
      if (this.CLJ != null) {
        paramVarArgs.d(2, this.CLJ);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.mBH);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLI == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.CLI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CLJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CLJ);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.mBH);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        oe localoe = (oe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localoe.CLI = locala.KhF.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localoe.CLJ = locala.KhF.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localoe.Url = locala.KhF.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localoe.mBH = locala.KhF.xS();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oe
 * JD-Core Version:    0.7.0.1
 */